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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.token.auth.service.http.TokenACLProfileServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.token.auth.service.http.TokenACLProfileServiceSoap
 * @generated
 */
@ProviderType
public class TokenACLProfileSoap implements Serializable {
	public static TokenACLProfileSoap toSoapModel(TokenACLProfile model) {
		TokenACLProfileSoap soapModel = new TokenACLProfileSoap();

		soapModel.setAclProfileId(model.getAclProfileId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setAcl(model.getAcl());
		soapModel.setParentProfileId(model.getParentProfileId());
		soapModel.setEffectiveACL(model.getEffectiveACL());
		soapModel.setSystem(model.getSystem());

		return soapModel;
	}

	public static TokenACLProfileSoap[] toSoapModels(TokenACLProfile[] models) {
		TokenACLProfileSoap[] soapModels = new TokenACLProfileSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TokenACLProfileSoap[][] toSoapModels(
		TokenACLProfile[][] models) {
		TokenACLProfileSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TokenACLProfileSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TokenACLProfileSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TokenACLProfileSoap[] toSoapModels(
		List<TokenACLProfile> models) {
		List<TokenACLProfileSoap> soapModels = new ArrayList<TokenACLProfileSoap>(models.size());

		for (TokenACLProfile model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TokenACLProfileSoap[soapModels.size()]);
	}

	public TokenACLProfileSoap() {
	}

	public long getPrimaryKey() {
		return _aclProfileId;
	}

	public void setPrimaryKey(long pk) {
		setAclProfileId(pk);
	}

	public long getAclProfileId() {
		return _aclProfileId;
	}

	public void setAclProfileId(long aclProfileId) {
		_aclProfileId = aclProfileId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getAcl() {
		return _acl;
	}

	public void setAcl(String acl) {
		_acl = acl;
	}

	public long getParentProfileId() {
		return _parentProfileId;
	}

	public void setParentProfileId(long parentProfileId) {
		_parentProfileId = parentProfileId;
	}

	public String getEffectiveACL() {
		return _effectiveACL;
	}

	public void setEffectiveACL(String effectiveACL) {
		_effectiveACL = effectiveACL;
	}

	public boolean getSystem() {
		return _system;
	}

	public boolean isSystem() {
		return _system;
	}

	public void setSystem(boolean system) {
		_system = system;
	}

	private long _aclProfileId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _description;
	private String _acl;
	private long _parentProfileId;
	private String _effectiveACL;
	private boolean _system;
}