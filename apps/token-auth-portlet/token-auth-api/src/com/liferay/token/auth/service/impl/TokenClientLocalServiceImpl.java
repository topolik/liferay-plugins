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

import com.liferay.token.auth.service.base.TokenClientLocalServiceBaseImpl;

/**
 * The implementation of the token client local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.token.auth.service.TokenClientLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.token.auth.service.base.TokenClientLocalServiceBaseImpl
 * @see com.liferay.token.auth.service.TokenClientLocalServiceUtil
 */
@ProviderType
public class TokenClientLocalServiceImpl extends TokenClientLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.token.auth.service.TokenClientLocalServiceUtil} to access the token client local service.
	 */
}