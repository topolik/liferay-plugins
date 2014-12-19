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

package com.liferay.token.auth.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link TokenSession}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TokenSession
 * @generated
 */
@ProviderType
public class TokenSessionWrapper implements TokenSession,
	ModelWrapper<TokenSession> {
	public TokenSessionWrapper(TokenSession tokenSession) {
		_tokenSession = tokenSession;
	}

	@Override
	public Class<?> getModelClass() {
		return TokenSession.class;
	}

	@Override
	public String getModelClassName() {
		return TokenSession.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("sessionId", getSessionId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("clientId", getClientId());
		attributes.put("token", getToken());
		attributes.put("remoteInfo", getRemoteInfo());
		attributes.put("lastUsedDate", getLastUsedDate());
		attributes.put("additionalInfo", getAdditionalInfo());
		attributes.put("expiryDate", getExpiryDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long sessionId = (Long)attributes.get("sessionId");

		if (sessionId != null) {
			setSessionId(sessionId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long clientId = (Long)attributes.get("clientId");

		if (clientId != null) {
			setClientId(clientId);
		}

		String token = (String)attributes.get("token");

		if (token != null) {
			setToken(token);
		}

		String remoteInfo = (String)attributes.get("remoteInfo");

		if (remoteInfo != null) {
			setRemoteInfo(remoteInfo);
		}

		Date lastUsedDate = (Date)attributes.get("lastUsedDate");

		if (lastUsedDate != null) {
			setLastUsedDate(lastUsedDate);
		}

		String additionalInfo = (String)attributes.get("additionalInfo");

		if (additionalInfo != null) {
			setAdditionalInfo(additionalInfo);
		}

		Date expiryDate = (Date)attributes.get("expiryDate");

		if (expiryDate != null) {
			setExpiryDate(expiryDate);
		}
	}

	@Override
	public java.lang.Object clone() {
		return new TokenSessionWrapper((TokenSession)_tokenSession.clone());
	}

	@Override
	public int compareTo(com.liferay.token.auth.model.TokenSession tokenSession) {
		return _tokenSession.compareTo(tokenSession);
	}

	/**
	* Returns the additional info of this token session.
	*
	* @return the additional info of this token session
	*/
	@Override
	public java.lang.String getAdditionalInfo() {
		return _tokenSession.getAdditionalInfo();
	}

	/**
	* Returns the client ID of this token session.
	*
	* @return the client ID of this token session
	*/
	@Override
	public long getClientId() {
		return _tokenSession.getClientId();
	}

	/**
	* Returns the company ID of this token session.
	*
	* @return the company ID of this token session
	*/
	@Override
	public long getCompanyId() {
		return _tokenSession.getCompanyId();
	}

	/**
	* Returns the create date of this token session.
	*
	* @return the create date of this token session
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _tokenSession.getCreateDate();
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _tokenSession.getExpandoBridge();
	}

	/**
	* Returns the expiry date of this token session.
	*
	* @return the expiry date of this token session
	*/
	@Override
	public java.util.Date getExpiryDate() {
		return _tokenSession.getExpiryDate();
	}

	/**
	* Returns the last used date of this token session.
	*
	* @return the last used date of this token session
	*/
	@Override
	public java.util.Date getLastUsedDate() {
		return _tokenSession.getLastUsedDate();
	}

	/**
	* Returns the primary key of this token session.
	*
	* @return the primary key of this token session
	*/
	@Override
	public long getPrimaryKey() {
		return _tokenSession.getPrimaryKey();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _tokenSession.getPrimaryKeyObj();
	}

	/**
	* Returns the remote info of this token session.
	*
	* @return the remote info of this token session
	*/
	@Override
	public java.lang.String getRemoteInfo() {
		return _tokenSession.getRemoteInfo();
	}

	/**
	* Returns the session ID of this token session.
	*
	* @return the session ID of this token session
	*/
	@Override
	public long getSessionId() {
		return _tokenSession.getSessionId();
	}

	/**
	* Returns the token of this token session.
	*
	* @return the token of this token session
	*/
	@Override
	public java.lang.String getToken() {
		return _tokenSession.getToken();
	}

	/**
	* Returns the user ID of this token session.
	*
	* @return the user ID of this token session
	*/
	@Override
	public long getUserId() {
		return _tokenSession.getUserId();
	}

	/**
	* Returns the user name of this token session.
	*
	* @return the user name of this token session
	*/
	@Override
	public java.lang.String getUserName() {
		return _tokenSession.getUserName();
	}

	/**
	* Returns the user uuid of this token session.
	*
	* @return the user uuid of this token session
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _tokenSession.getUserUuid();
	}

	@Override
	public int hashCode() {
		return _tokenSession.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _tokenSession.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _tokenSession.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _tokenSession.isNew();
	}

	@Override
	public void persist() {
		_tokenSession.persist();
	}

	/**
	* Sets the additional info of this token session.
	*
	* @param additionalInfo the additional info of this token session
	*/
	@Override
	public void setAdditionalInfo(java.lang.String additionalInfo) {
		_tokenSession.setAdditionalInfo(additionalInfo);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_tokenSession.setCachedModel(cachedModel);
	}

	/**
	* Sets the client ID of this token session.
	*
	* @param clientId the client ID of this token session
	*/
	@Override
	public void setClientId(long clientId) {
		_tokenSession.setClientId(clientId);
	}

	/**
	* Sets the company ID of this token session.
	*
	* @param companyId the company ID of this token session
	*/
	@Override
	public void setCompanyId(long companyId) {
		_tokenSession.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this token session.
	*
	* @param createDate the create date of this token session
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_tokenSession.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_tokenSession.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_tokenSession.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_tokenSession.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the expiry date of this token session.
	*
	* @param expiryDate the expiry date of this token session
	*/
	@Override
	public void setExpiryDate(java.util.Date expiryDate) {
		_tokenSession.setExpiryDate(expiryDate);
	}

	/**
	* Sets the last used date of this token session.
	*
	* @param lastUsedDate the last used date of this token session
	*/
	@Override
	public void setLastUsedDate(java.util.Date lastUsedDate) {
		_tokenSession.setLastUsedDate(lastUsedDate);
	}

	@Override
	public void setNew(boolean n) {
		_tokenSession.setNew(n);
	}

	/**
	* Sets the primary key of this token session.
	*
	* @param primaryKey the primary key of this token session
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_tokenSession.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_tokenSession.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the remote info of this token session.
	*
	* @param remoteInfo the remote info of this token session
	*/
	@Override
	public void setRemoteInfo(java.lang.String remoteInfo) {
		_tokenSession.setRemoteInfo(remoteInfo);
	}

	/**
	* Sets the session ID of this token session.
	*
	* @param sessionId the session ID of this token session
	*/
	@Override
	public void setSessionId(long sessionId) {
		_tokenSession.setSessionId(sessionId);
	}

	/**
	* Sets the token of this token session.
	*
	* @param token the token of this token session
	*/
	@Override
	public void setToken(java.lang.String token) {
		_tokenSession.setToken(token);
	}

	/**
	* Sets the user ID of this token session.
	*
	* @param userId the user ID of this token session
	*/
	@Override
	public void setUserId(long userId) {
		_tokenSession.setUserId(userId);
	}

	/**
	* Sets the user name of this token session.
	*
	* @param userName the user name of this token session
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_tokenSession.setUserName(userName);
	}

	/**
	* Sets the user uuid of this token session.
	*
	* @param userUuid the user uuid of this token session
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_tokenSession.setUserUuid(userUuid);
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.token.auth.model.TokenSession> toCacheModel() {
		return _tokenSession.toCacheModel();
	}

	@Override
	public com.liferay.token.auth.model.TokenSession toEscapedModel() {
		return new TokenSessionWrapper(_tokenSession.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _tokenSession.toString();
	}

	@Override
	public com.liferay.token.auth.model.TokenSession toUnescapedModel() {
		return new TokenSessionWrapper(_tokenSession.toUnescapedModel());
	}

	@Override
	public java.lang.String toXmlString() {
		return _tokenSession.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TokenSessionWrapper)) {
			return false;
		}

		TokenSessionWrapper tokenSessionWrapper = (TokenSessionWrapper)obj;

		if (Validator.equals(_tokenSession, tokenSessionWrapper._tokenSession)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	@Deprecated
	public TokenSession getWrappedTokenSession() {
		return _tokenSession;
	}

	@Override
	public TokenSession getWrappedModel() {
		return _tokenSession;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _tokenSession.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _tokenSession.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_tokenSession.resetOriginalValues();
	}

	private final TokenSession _tokenSession;
}