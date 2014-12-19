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
 * The extended model interface for the TokenSession service. Represents a row in the &quot;TokenAuth_TokenSession&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see TokenSessionModel
 * @see com.liferay.token.auth.model.impl.TokenSessionImpl
 * @see com.liferay.token.auth.model.impl.TokenSessionModelImpl
 * @generated
 */
@ProviderType
public interface TokenSession extends TokenSessionModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.token.auth.model.impl.TokenSessionImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<TokenSession, Long> SESSION_ID_ACCESSOR = new Accessor<TokenSession, Long>() {
			@Override
			public Long get(TokenSession tokenSession) {
				return tokenSession.getSessionId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<TokenSession> getTypeClass() {
				return TokenSession.class;
			}
		};
}