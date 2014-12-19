/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.token.auth.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.security.auth.AccessControlContext;
import com.liferay.portal.security.auth.AuthException;
import com.liferay.portal.security.auth.AuthVerifier;
import com.liferay.portal.security.auth.AuthVerifierResult;
import com.liferay.registry.Registry;
import com.liferay.registry.RegistryUtil;
import com.liferay.registry.ServiceTracker;
import com.liferay.token.auth.model.TokenACLProfile;
import com.liferay.token.auth.model.TokenClient;
import com.liferay.token.auth.model.TokenSession;
import com.liferay.token.auth.service.TokenACLProfileLocalService;
import com.liferay.token.auth.service.TokenClientLocalService;
import com.liferay.token.auth.service.TokenSessionLocalService;
import com.liferay.token.auth.verifier.TokenVerificationException;
import com.liferay.token.auth.verifier.TokenVerifier;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author Tomas Polesovsky
 */
@Component(
	immediate = true,
	property = {
		"hosts.allowed=",
		"urls.includes=/api/*,/documents/*,/xmlrpc/*",
		"urls.excludes=/api/liferay/do"
	},
	service = AuthVerifier.class
)
public class TokenAuthVerifier implements AuthVerifier {

	public TokenAuthVerifier() {
		Registry registry = RegistryUtil.getRegistry();

		_tokenVerifierServiceTracker = registry.trackServices(
			TokenVerifier.class);

		_tokenVerifierServiceTracker.open();
	}

	@Override
	public String getAuthType() {
		return AUTH_TYPE;
	}

	@Override
	public AuthVerifierResult verify(
			AccessControlContext accessControlContext, Properties properties)
		throws AuthException {

		AuthVerifierResult authVerifierResult = new AuthVerifierResult();

		try {
			TokenAuthParseResult tokenAuthParseResult = parseTokenSession(
				accessControlContext);

			if (tokenAuthParseResult == null) {
				return authVerifierResult;
			}

			TokenClient tokenClient = tokenAuthParseResult.getTokenClient();
			TokenSession tokenSession = tokenAuthParseResult.getTokenSession();

			long companyId = tokenClient.getCompanyId();
			String aclProfiles = tokenClient.getAclProfiles();
			String[] aclProfilesNames = StringUtil.split(aclProfiles);
			List <TokenACLProfile> tokenACLProfiles =
				_tokenACLProfileLocalService.findByNames(
					companyId, aclProfilesNames);

			_tokenSessionLocalService.audit(tokenSession.getSessionId());

			Map<String, Object> settings = authVerifierResult.getSettings();
			settings.put(ACL_PROFILES, tokenACLProfiles);
			settings.put(SESSION, tokenSession);
			settings.put(SESSION, tokenSession);

			authVerifierResult.setPassword("");
			authVerifierResult.setState(AuthVerifierResult.State.SUCCESS);
			authVerifierResult.setUserId(tokenSession.getUserId());

		}
		catch (TokenVerificationException e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e);
			}

			authVerifierResult.setState(
				AuthVerifierResult.State.INVALID_CREDENTIALS);
		}
		catch (Exception e) {
			throw new AuthException(e);
		}

		return authVerifierResult;
	}

	protected TokenAuthParseResult parseTokenSession(
			AccessControlContext accessControlContext)
		throws TokenVerificationException, PortalException {

		HttpServletRequest request = accessControlContext.getRequest();
		HttpServletResponse response = accessControlContext.getResponse();

		TokenVerifier[] tokenVerifiers =
			_tokenVerifierServiceTracker.getServices(new TokenVerifier[0]);

		for (TokenVerifier tokenVerifier : tokenVerifiers) {
			TokenSession tokenSession = tokenVerifier.parse(request, response);
			if (tokenSession == null) {
				continue;
			}

			TokenClient tokenClient = _tokenClientLocalService.getTokenClient(
				tokenSession.getClientId());

			boolean valid = isValid(
				tokenVerifier, tokenClient, tokenSession, accessControlContext);

			if (!valid) {
				continue;
			}

			return new TokenAuthParseResult(tokenClient, tokenSession);
		}

		return null;
	}


	protected boolean isValid(
			TokenVerifier tokenVerifier, TokenClient tokenClient,
			TokenSession tokenSession,
			AccessControlContext accessControlContext)
		throws PortalException {

		String tokenVerifierId = tokenVerifier.getTokenVerifierId();
		String clientTokenVerifierId = tokenClient.getTokenVerifierId();

		if (!tokenVerifierId.equals(clientTokenVerifierId)) {
			return false;
		}

		if (tokenClient.isRevoked()) {
			throwValidationException(
				"The application has been revoked!", tokenClient, tokenSession,
				accessControlContext);
		}

		Date now = new Date();

		if(now.after(tokenSession.getExpiryDate())) {
			throwValidationException(
				"The token has expired!", tokenClient, tokenSession,
				accessControlContext);
		}

		return true;
	}

	protected void throwValidationException(
			String message, TokenClient tokenClient, TokenSession tokenSession,
			AccessControlContext accessControlContext)
		throws AuthException {

		if (_log.isWarnEnabled()) {
			HttpServletRequest request = accessControlContext.getRequest();
			String remoteAddr = request.getRemoteAddr();
			String remoteHost = request.getRemoteHost();

			_log.warn(
				message +
					"Remote IP: " + remoteAddr +
					", Remote Host: " + remoteHost +
					", TokenSession: " + tokenSession +
					", TokenClient: " + tokenClient);
		}

		throw new AuthException(message);
	}

	@Reference(unbind = "-")
	protected void setTokenACLProfileLocalService(
		TokenACLProfileLocalService tokenACLProfileLocalService) {

		_tokenACLProfileLocalService = tokenACLProfileLocalService;
	}

	@Reference(unbind = "-")
	protected void setTokenClientLocalService(
		TokenClientLocalService tokenClientLocalService) {

		_tokenClientLocalService = tokenClientLocalService;
	}

	@Reference(unbind = "-")
	protected void setTokenSessionLocalService(
		TokenSessionLocalService tokenSessionLocalService) {

		_tokenSessionLocalService = tokenSessionLocalService;
	}

	public static final String AUTH_TYPE = "AUTH_TOKEN";

	public static final String ACL_PROFILES = "AUTH_TOKEN_ACL_PROFILES";

	public static final String CLIENT = "AUTH_TOKEN_CLIENT";

	public static final String SESSION = "AUTH_TOKEN_SESSION";

	private ServiceTracker<?, TokenVerifier>
		_tokenVerifierServiceTracker;

	private TokenClientLocalService _tokenClientLocalService;
	private TokenSessionLocalService _tokenSessionLocalService;
	private TokenACLProfileLocalService _tokenACLProfileLocalService;

	private static Log _log = LogFactoryUtil.getLog(
		TokenAuthVerifier.class);

	private class TokenAuthParseResult {
		private TokenClient _tokenClient;
		private TokenSession _tokenSession;

		private TokenAuthParseResult(
			TokenClient tokenClient, TokenSession tokenSession) {

			this._tokenClient = tokenClient;
			this._tokenSession = tokenSession;
		}

		public TokenClient getTokenClient() {
			return _tokenClient;
		}

		public void setTokenClient(TokenClient tokenClient) {
			this._tokenClient = tokenClient;
		}

		public TokenSession getTokenSession() {
			return _tokenSession;
		}

		public void setTokenSession(TokenSession tokenSession) {
			this._tokenSession = tokenSession;
		}
	}
}

