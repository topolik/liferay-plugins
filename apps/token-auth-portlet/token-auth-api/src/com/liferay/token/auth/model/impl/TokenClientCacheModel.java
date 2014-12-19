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

import com.liferay.token.auth.model.TokenClient;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TokenClient in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see TokenClient
 * @generated
 */
@ProviderType
public class TokenClientCacheModel implements CacheModel<TokenClient>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{clientId=");
		sb.append(clientId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", clientKey=");
		sb.append(clientKey);
		sb.append(", clientSecrets=");
		sb.append(clientSecrets);
		sb.append(", revoked=");
		sb.append(revoked);
		sb.append(", aclProfiles=");
		sb.append(aclProfiles);
		sb.append(", tokenVerifierId=");
		sb.append(tokenVerifierId);
		sb.append(", callbackURI=");
		sb.append(callbackURI);
		sb.append(", websiteURL=");
		sb.append(websiteURL);
		sb.append(", additionalInfo=");
		sb.append(additionalInfo);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TokenClient toEntityModel() {
		TokenClientImpl tokenClientImpl = new TokenClientImpl();

		tokenClientImpl.setClientId(clientId);
		tokenClientImpl.setCompanyId(companyId);
		tokenClientImpl.setUserId(userId);

		if (userName == null) {
			tokenClientImpl.setUserName(StringPool.BLANK);
		}
		else {
			tokenClientImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			tokenClientImpl.setCreateDate(null);
		}
		else {
			tokenClientImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			tokenClientImpl.setModifiedDate(null);
		}
		else {
			tokenClientImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			tokenClientImpl.setName(StringPool.BLANK);
		}
		else {
			tokenClientImpl.setName(name);
		}

		if (description == null) {
			tokenClientImpl.setDescription(StringPool.BLANK);
		}
		else {
			tokenClientImpl.setDescription(description);
		}

		if (clientKey == null) {
			tokenClientImpl.setClientKey(StringPool.BLANK);
		}
		else {
			tokenClientImpl.setClientKey(clientKey);
		}

		if (clientSecrets == null) {
			tokenClientImpl.setClientSecrets(StringPool.BLANK);
		}
		else {
			tokenClientImpl.setClientSecrets(clientSecrets);
		}

		tokenClientImpl.setRevoked(revoked);

		if (aclProfiles == null) {
			tokenClientImpl.setAclProfiles(StringPool.BLANK);
		}
		else {
			tokenClientImpl.setAclProfiles(aclProfiles);
		}

		if (tokenVerifierId == null) {
			tokenClientImpl.setTokenVerifierId(StringPool.BLANK);
		}
		else {
			tokenClientImpl.setTokenVerifierId(tokenVerifierId);
		}

		if (callbackURI == null) {
			tokenClientImpl.setCallbackURI(StringPool.BLANK);
		}
		else {
			tokenClientImpl.setCallbackURI(callbackURI);
		}

		if (websiteURL == null) {
			tokenClientImpl.setWebsiteURL(StringPool.BLANK);
		}
		else {
			tokenClientImpl.setWebsiteURL(websiteURL);
		}

		if (additionalInfo == null) {
			tokenClientImpl.setAdditionalInfo(StringPool.BLANK);
		}
		else {
			tokenClientImpl.setAdditionalInfo(additionalInfo);
		}

		tokenClientImpl.resetOriginalValues();

		return tokenClientImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		clientId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
		clientKey = objectInput.readUTF();
		clientSecrets = objectInput.readUTF();
		revoked = objectInput.readBoolean();
		aclProfiles = objectInput.readUTF();
		tokenVerifierId = objectInput.readUTF();
		callbackURI = objectInput.readUTF();
		websiteURL = objectInput.readUTF();
		additionalInfo = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(clientId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (clientKey == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(clientKey);
		}

		if (clientSecrets == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(clientSecrets);
		}

		objectOutput.writeBoolean(revoked);

		if (aclProfiles == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(aclProfiles);
		}

		if (tokenVerifierId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tokenVerifierId);
		}

		if (callbackURI == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(callbackURI);
		}

		if (websiteURL == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(websiteURL);
		}

		if (additionalInfo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(additionalInfo);
		}
	}

	public long clientId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String description;
	public String clientKey;
	public String clientSecrets;
	public boolean revoked;
	public String aclProfiles;
	public String tokenVerifierId;
	public String callbackURI;
	public String websiteURL;
	public String additionalInfo;
}