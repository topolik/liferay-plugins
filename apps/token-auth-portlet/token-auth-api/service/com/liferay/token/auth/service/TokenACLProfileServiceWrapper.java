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
 * Provides a wrapper for {@link TokenACLProfileService}.
 *
 * @author Brian Wing Shun Chan
 * @see TokenACLProfileService
 * @generated
 */
@ProviderType
public class TokenACLProfileServiceWrapper implements TokenACLProfileService,
	ServiceWrapper<TokenACLProfileService> {
	public TokenACLProfileServiceWrapper(
		TokenACLProfileService tokenACLProfileService) {
		_tokenACLProfileService = tokenACLProfileService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _tokenACLProfileService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_tokenACLProfileService.setBeanIdentifier(beanIdentifier);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	@Deprecated
	public TokenACLProfileService getWrappedTokenACLProfileService() {
		return _tokenACLProfileService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	@Deprecated
	public void setWrappedTokenACLProfileService(
		TokenACLProfileService tokenACLProfileService) {
		_tokenACLProfileService = tokenACLProfileService;
	}

	@Override
	public TokenACLProfileService getWrappedService() {
		return _tokenACLProfileService;
	}

	@Override
	public void setWrappedService(TokenACLProfileService tokenACLProfileService) {
		_tokenACLProfileService = tokenACLProfileService;
	}

	private TokenACLProfileService _tokenACLProfileService;
}