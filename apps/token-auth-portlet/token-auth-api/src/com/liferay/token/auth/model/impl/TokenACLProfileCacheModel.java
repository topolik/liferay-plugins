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

import com.liferay.token.auth.model.TokenACLProfile;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TokenACLProfile in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see TokenACLProfile
 * @generated
 */
@ProviderType
public class TokenACLProfileCacheModel implements CacheModel<TokenACLProfile>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{aclProfileId=");
		sb.append(aclProfileId);
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
		sb.append(", acl=");
		sb.append(acl);
		sb.append(", parentProfileId=");
		sb.append(parentProfileId);
		sb.append(", effectiveACL=");
		sb.append(effectiveACL);
		sb.append(", system=");
		sb.append(system);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TokenACLProfile toEntityModel() {
		TokenACLProfileImpl tokenACLProfileImpl = new TokenACLProfileImpl();

		tokenACLProfileImpl.setAclProfileId(aclProfileId);
		tokenACLProfileImpl.setCompanyId(companyId);
		tokenACLProfileImpl.setUserId(userId);

		if (userName == null) {
			tokenACLProfileImpl.setUserName(StringPool.BLANK);
		}
		else {
			tokenACLProfileImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			tokenACLProfileImpl.setCreateDate(null);
		}
		else {
			tokenACLProfileImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			tokenACLProfileImpl.setModifiedDate(null);
		}
		else {
			tokenACLProfileImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			tokenACLProfileImpl.setName(StringPool.BLANK);
		}
		else {
			tokenACLProfileImpl.setName(name);
		}

		if (description == null) {
			tokenACLProfileImpl.setDescription(StringPool.BLANK);
		}
		else {
			tokenACLProfileImpl.setDescription(description);
		}

		if (acl == null) {
			tokenACLProfileImpl.setAcl(StringPool.BLANK);
		}
		else {
			tokenACLProfileImpl.setAcl(acl);
		}

		tokenACLProfileImpl.setParentProfileId(parentProfileId);

		if (effectiveACL == null) {
			tokenACLProfileImpl.setEffectiveACL(StringPool.BLANK);
		}
		else {
			tokenACLProfileImpl.setEffectiveACL(effectiveACL);
		}

		tokenACLProfileImpl.setSystem(system);

		tokenACLProfileImpl.resetOriginalValues();

		return tokenACLProfileImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		aclProfileId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
		acl = objectInput.readUTF();
		parentProfileId = objectInput.readLong();
		effectiveACL = objectInput.readUTF();
		system = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(aclProfileId);
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

		if (acl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(acl);
		}

		objectOutput.writeLong(parentProfileId);

		if (effectiveACL == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(effectiveACL);
		}

		objectOutput.writeBoolean(system);
	}

	public long aclProfileId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String description;
	public String acl;
	public long parentProfileId;
	public String effectiveACL;
	public boolean system;
}