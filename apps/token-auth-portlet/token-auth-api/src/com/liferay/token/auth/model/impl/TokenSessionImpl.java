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
import com.liferay.portal.kernel.util.StringBundler;

/**
 * The extended model implementation for the TokenSession service. Represents a row in the &quot;TokenAuth_TokenSession&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.token.auth.model.TokenSession} interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
@ProviderType
public class TokenSessionImpl extends TokenSessionBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a token session model instance should use the {@link com.liferay.token.auth.model.TokenSession} interface instead.
	 */
	public TokenSessionImpl() {
	}

	@Override
	public String toString() {
		String token = "*****";
		String secretToken = getToken();
		if ((secretToken != null) && secretToken.length() > 16) {
			token =
				secretToken.substring(0, 4) + token +
					secretToken.substring(secretToken.length() - 4);
		}

		String result = super.toString();

		result = result.replace(secretToken, token);

		return result;
	}
}