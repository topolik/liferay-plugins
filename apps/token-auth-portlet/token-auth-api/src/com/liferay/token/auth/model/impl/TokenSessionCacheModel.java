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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.liferay.token.auth.model.TokenSession;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TokenSession in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see TokenSession
 * @generated
 */
@ProviderType
public class TokenSessionCacheModel implements CacheModel<TokenSession>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{sessionId=");
		sb.append(sessionId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", clientId=");
		sb.append(clientId);
		sb.append(", token=");
		sb.append(token);
		sb.append(", remoteInfo=");
		sb.append(remoteInfo);
		sb.append(", lastUsedDate=");
		sb.append(lastUsedDate);
		sb.append(", additionalInfo=");
		sb.append(additionalInfo);
		sb.append(", expiryDate=");
		sb.append(expiryDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TokenSession toEntityModel() {
		TokenSessionImpl tokenSessionImpl = new TokenSessionImpl();

		tokenSessionImpl.setSessionId(sessionId);
		tokenSessionImpl.setCompanyId(companyId);
		tokenSessionImpl.setUserId(userId);

		if (userName == null) {
			tokenSessionImpl.setUserName(StringPool.BLANK);
		}
		else {
			tokenSessionImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			tokenSessionImpl.setCreateDate(null);
		}
		else {
			tokenSessionImpl.setCreateDate(new Date(createDate));
		}

		tokenSessionImpl.setClientId(clientId);

		if (token == null) {
			tokenSessionImpl.setToken(StringPool.BLANK);
		}
		else {
			tokenSessionImpl.setToken(token);
		}

		if (remoteInfo == null) {
			tokenSessionImpl.setRemoteInfo(StringPool.BLANK);
		}
		else {
			tokenSessionImpl.setRemoteInfo(remoteInfo);
		}

		if (lastUsedDate == Long.MIN_VALUE) {
			tokenSessionImpl.setLastUsedDate(null);
		}
		else {
			tokenSessionImpl.setLastUsedDate(new Date(lastUsedDate));
		}

		if (additionalInfo == null) {
			tokenSessionImpl.setAdditionalInfo(StringPool.BLANK);
		}
		else {
			tokenSessionImpl.setAdditionalInfo(additionalInfo);
		}

		if (expiryDate == Long.MIN_VALUE) {
			tokenSessionImpl.setExpiryDate(null);
		}
		else {
			tokenSessionImpl.setExpiryDate(new Date(expiryDate));
		}

		tokenSessionImpl.resetOriginalValues();

		return tokenSessionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		sessionId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		clientId = objectInput.readLong();
		token = objectInput.readUTF();
		remoteInfo = objectInput.readUTF();
		lastUsedDate = objectInput.readLong();
		additionalInfo = objectInput.readUTF();
		expiryDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(sessionId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(clientId);

		if (token == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(token);
		}

		if (remoteInfo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(remoteInfo);
		}

		objectOutput.writeLong(lastUsedDate);

		if (additionalInfo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(additionalInfo);
		}

		objectOutput.writeLong(expiryDate);
	}

	public long sessionId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long clientId;
	public String token;
	public String remoteInfo;
	public long lastUsedDate;
	public String additionalInfo;
	public long expiryDate;
}