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

import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.token.auth.model.TokenClient;
import com.liferay.token.auth.service.base.TokenClientServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the token client remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.token.auth.service.TokenClientService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.token.auth.service.base.TokenClientServiceBaseImpl
 * @see com.liferay.token.auth.service.TokenClientServiceUtil
 */
@ProviderType
public class TokenClientServiceImpl extends TokenClientServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.token.auth.service.TokenClientServiceUtil} to access the token client remote service.
	 */

	public long getClientsCount() throws PrincipalException {
		long companyId = getPermissionChecker().getCompanyId();

		return tokenClientPersistence.filterCountByCompanyId(companyId);
	}

	public List<TokenClient> getClients(int start, int end)
		throws PrincipalException {

		long companyId = getPermissionChecker().getCompanyId();

		return tokenClientPersistence.filterFindByCompanyId(
			companyId, start, end);
	}

	@Override
	public boolean isValid(long tokenClientId){
		TokenClient tokenClient =
			tokenClientLocalService.fetchTokenClient(tokenClientId);

		if (tokenClient == null) {
			return false;
		}

		if (tokenClient.isRevoked()) {
			return false;
		}

		return true;
	}
}