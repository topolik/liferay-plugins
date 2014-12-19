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

package com.liferay.token.auth.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TokenClientService}.
 *
 * @author Brian Wing Shun Chan
 * @see TokenClientService
 * @generated
 */
@ProviderType
public class TokenClientServiceWrapper implements TokenClientService,
	ServiceWrapper<TokenClientService> {
	public TokenClientServiceWrapper(TokenClientService tokenClientService) {
		_tokenClientService = tokenClientService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _tokenClientService.getBeanIdentifier();
	}

	@Override
	public java.util.List<com.liferay.token.auth.model.TokenClient> getClients(
		int start, int end)
		throws com.liferay.portal.security.auth.PrincipalException {
		return _tokenClientService.getClients(start, end);
	}

	@Override
	public long getClientsCount()
		throws com.liferay.portal.security.auth.PrincipalException {
		return _tokenClientService.getClientsCount();
	}

	@Override
	public boolean isValid(long tokenClientId) {
		return _tokenClientService.isValid(tokenClientId);
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_tokenClientService.setBeanIdentifier(beanIdentifier);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	@Deprecated
	public TokenClientService getWrappedTokenClientService() {
		return _tokenClientService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	@Deprecated
	public void setWrappedTokenClientService(
		TokenClientService tokenClientService) {
		_tokenClientService = tokenClientService;
	}

	@Override
	public TokenClientService getWrappedService() {
		return _tokenClientService;
	}

	@Override
	public void setWrappedService(TokenClientService tokenClientService) {
		_tokenClientService = tokenClientService;
	}

	private TokenClientService _tokenClientService;
}