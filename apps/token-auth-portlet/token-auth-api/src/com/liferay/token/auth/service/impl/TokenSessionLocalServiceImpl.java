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

package com.liferay.token.auth.service.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.security.ac.AccessControlUtil;
import com.liferay.portal.security.auth.AccessControlContext;
import com.liferay.token.auth.model.TokenSession;
import com.liferay.token.auth.service.base.TokenSessionLocalServiceBaseImpl;
import org.apache.ecs.html.S;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * The implementation of the token session local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.token.auth.service.TokenSessionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.token.auth.service.base.TokenSessionLocalServiceBaseImpl
 * @see com.liferay.token.auth.service.TokenSessionLocalServiceUtil
 */
@ProviderType
public class TokenSessionLocalServiceImpl
	extends TokenSessionLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.token.auth.service.TokenSessionLocalServiceUtil} to access the token session local service.
	 */
	public void audit(long sessionId) throws PortalException {
		TokenSession tokenSession =
			tokenSessionLocalService.getTokenSession(sessionId);

		tokenSession.setLastUsedDate(new Date());

		AccessControlContext accessControlContext =
			AccessControlUtil.getAccessControlContext();

		HttpServletRequest request = accessControlContext.getRequest();

		StringBundler remoteInfo = new StringBundler(3);
		remoteInfo.append(request.getRemoteAddr());
		remoteInfo.append(StringPool.COMMA);
		remoteInfo.append(request.getRemoteHost());

		tokenSession.setRemoteInfo(remoteInfo.toString());

		tokenSessionLocalService.updateTokenSession(tokenSession);
	}
}