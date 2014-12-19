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

package com.liferay.token.auth.model.impl;

import aQute.bnd.annotation.ProviderType;

/**
 * The extended model implementation for the TokenClient service. Represents a row in the &quot;TokenAuth_TokenClient&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.token.auth.model.TokenClient} interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
@ProviderType
public class TokenClientImpl extends TokenClientBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a token client model instance should use the {@link com.liferay.token.auth.model.TokenClient} interface instead.
	 */
	public TokenClientImpl() {
	}

	@Override
	public String toString() {
		return super.toString().replace(getClientSecrets(), _FIVE_STARS);
	}

	private final String _FIVE_STARS = "*****";
}