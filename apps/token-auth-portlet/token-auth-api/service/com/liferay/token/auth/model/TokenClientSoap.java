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
 * This class is used by SOAP remote services, specifically {@link com.liferay.token.auth.service.http.TokenClientServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.token.auth.service.http.TokenClientServiceSoap
 * @generated
 */
@ProviderType
public class TokenClientSoap implements Serializable {
	public static TokenClientSoap toSoapModel(TokenClient model) {
		TokenClientSoap soapModel = new TokenClientSoap();

		soapModel.setClientId(model.getClientId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setClientKey(model.getClientKey());
		soapModel.setClientSecrets(model.getClientSecrets());
		soapModel.setRevoked(model.getRevoked());
		soapModel.setAclProfiles(model.getAclProfiles());
		soapModel.setTokenVerifierId(model.getTokenVerifierId());
		soapModel.setCallbackURI(model.getCallbackURI());
		soapModel.setWebsiteURL(model.getWebsiteURL());
		soapModel.setAdditionalInfo(model.getAdditionalInfo());

		return soapModel;
	}

	public static TokenClientSoap[] toSoapModels(TokenClient[] models) {
		TokenClientSoap[] soapModels = new TokenClientSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TokenClientSoap[][] toSoapModels(TokenClient[][] models) {
		TokenClientSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TokenClientSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TokenClientSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TokenClientSoap[] toSoapModels(List<TokenClient> models) {
		List<TokenClientSoap> soapModels = new ArrayList<TokenClientSoap>(models.size());

		for (TokenClient model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TokenClientSoap[soapModels.size()]);
	}

	public TokenClientSoap() {
	}

	public long getPrimaryKey() {
		return _clientId;
	}

	public void setPrimaryKey(long pk) {
		setClientId(pk);
	}

	public long getClientId() {
		return _clientId;
	}

	public void setClientId(long clientId) {
		_clientId = clientId;
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

	public String getClientKey() {
		return _clientKey;
	}

	public void setClientKey(String clientKey) {
		_clientKey = clientKey;
	}

	public String getClientSecrets() {
		return _clientSecrets;
	}

	public void setClientSecrets(String clientSecrets) {
		_clientSecrets = clientSecrets;
	}

	public boolean getRevoked() {
		return _revoked;
	}

	public boolean isRevoked() {
		return _revoked;
	}

	public void setRevoked(boolean revoked) {
		_revoked = revoked;
	}

	public String getAclProfiles() {
		return _aclProfiles;
	}

	public void setAclProfiles(String aclProfiles) {
		_aclProfiles = aclProfiles;
	}

	public String getTokenVerifierId() {
		return _tokenVerifierId;
	}

	public void setTokenVerifierId(String tokenVerifierId) {
		_tokenVerifierId = tokenVerifierId;
	}

	public String getCallbackURI() {
		return _callbackURI;
	}

	public void setCallbackURI(String callbackURI) {
		_callbackURI = callbackURI;
	}

	public String getWebsiteURL() {
		return _websiteURL;
	}

	public void setWebsiteURL(String websiteURL) {
		_websiteURL = websiteURL;
	}

	public String getAdditionalInfo() {
		return _additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		_additionalInfo = additionalInfo;
	}

	private long _clientId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _description;
	private String _clientKey;
	private String _clientSecrets;
	private boolean _revoked;
	private String _aclProfiles;
	private String _tokenVerifierId;
	private String _callbackURI;
	private String _websiteURL;
	private String _additionalInfo;
}