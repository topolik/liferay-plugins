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
 * This class is used by SOAP remote services, specifically {@link com.liferay.token.auth.service.http.TokenSessionServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.token.auth.service.http.TokenSessionServiceSoap
 * @generated
 */
@ProviderType
public class TokenSessionSoap implements Serializable {
	public static TokenSessionSoap toSoapModel(TokenSession model) {
		TokenSessionSoap soapModel = new TokenSessionSoap();

		soapModel.setSessionId(model.getSessionId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setClientId(model.getClientId());
		soapModel.setToken(model.getToken());
		soapModel.setRemoteInfo(model.getRemoteInfo());
		soapModel.setLastUsedDate(model.getLastUsedDate());
		soapModel.setAdditionalInfo(model.getAdditionalInfo());
		soapModel.setExpiryDate(model.getExpiryDate());

		return soapModel;
	}

	public static TokenSessionSoap[] toSoapModels(TokenSession[] models) {
		TokenSessionSoap[] soapModels = new TokenSessionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TokenSessionSoap[][] toSoapModels(TokenSession[][] models) {
		TokenSessionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TokenSessionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TokenSessionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TokenSessionSoap[] toSoapModels(List<TokenSession> models) {
		List<TokenSessionSoap> soapModels = new ArrayList<TokenSessionSoap>(models.size());

		for (TokenSession model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TokenSessionSoap[soapModels.size()]);
	}

	public TokenSessionSoap() {
	}

	public long getPrimaryKey() {
		return _sessionId;
	}

	public void setPrimaryKey(long pk) {
		setSessionId(pk);
	}

	public long getSessionId() {
		return _sessionId;
	}

	public void setSessionId(long sessionId) {
		_sessionId = sessionId;
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

	public long getClientId() {
		return _clientId;
	}

	public void setClientId(long clientId) {
		_clientId = clientId;
	}

	public String getToken() {
		return _token;
	}

	public void setToken(String token) {
		_token = token;
	}

	public String getRemoteInfo() {
		return _remoteInfo;
	}

	public void setRemoteInfo(String remoteInfo) {
		_remoteInfo = remoteInfo;
	}

	public Date getLastUsedDate() {
		return _lastUsedDate;
	}

	public void setLastUsedDate(Date lastUsedDate) {
		_lastUsedDate = lastUsedDate;
	}

	public String getAdditionalInfo() {
		return _additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		_additionalInfo = additionalInfo;
	}

	public Date getExpiryDate() {
		return _expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		_expiryDate = expiryDate;
	}

	private long _sessionId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private long _clientId;
	private String _token;
	private String _remoteInfo;
	private Date _lastUsedDate;
	private String _additionalInfo;
	private Date _expiryDate;
}