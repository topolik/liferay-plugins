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

import com.liferay.portal.kernel.util.Accessor;
import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the TokenACLProfile service. Represents a row in the &quot;TokenAuth_TokenACLProfile&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see TokenACLProfileModel
 * @see com.liferay.token.auth.model.impl.TokenACLProfileImpl
 * @see com.liferay.token.auth.model.impl.TokenACLProfileModelImpl
 * @generated
 */
@ProviderType
public interface TokenACLProfile extends TokenACLProfileModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.token.auth.model.impl.TokenACLProfileImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<TokenACLProfile, Long> ACL_PROFILE_ID_ACCESSOR = new Accessor<TokenACLProfile, Long>() {
			@Override
			public Long get(TokenACLProfile tokenACLProfile) {
				return tokenACLProfile.getAclProfileId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<TokenACLProfile> getTypeClass() {
				return TokenACLProfile.class;
			}
		};
}