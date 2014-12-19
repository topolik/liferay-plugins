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
 * Provides a wrapper for {@link TokenSessionService}.
 *
 * @author Brian Wing Shun Chan
 * @see TokenSessionService
 * @generated
 */
@ProviderType
public class TokenSessionServiceWrapper implements TokenSessionService,
	ServiceWrapper<TokenSessionService> {
	public TokenSessionServiceWrapper(TokenSessionService tokenSessionService) {
		_tokenSessionService = tokenSessionService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _tokenSessionService.getBeanIdentifier();
	}

	@Override
	public long getSessionsCount(long clientId) {
		return _tokenSessionService.getSessionsCount(clientId);
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_tokenSessionService.setBeanIdentifier(beanIdentifier);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	@Deprecated
	public TokenSessionService getWrappedTokenSessionService() {
		return _tokenSessionService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	@Deprecated
	public void setWrappedTokenSessionService(
		TokenSessionService tokenSessionService) {
		_tokenSessionService = tokenSessionService;
	}

	@Override
	public TokenSessionService getWrappedService() {
		return _tokenSessionService;
	}

	@Override
	public void setWrappedService(TokenSessionService tokenSessionService) {
		_tokenSessionService = tokenSessionService;
	}

	private TokenSessionService _tokenSessionService;
}