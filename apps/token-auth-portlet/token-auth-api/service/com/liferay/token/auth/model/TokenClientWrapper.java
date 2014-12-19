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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link TokenClient}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TokenClient
 * @generated
 */
@ProviderType
public class TokenClientWrapper implements TokenClient,
	ModelWrapper<TokenClient> {
	public TokenClientWrapper(TokenClient tokenClient) {
		_tokenClient = tokenClient;
	}

	@Override
	public Class<?> getModelClass() {
		return TokenClient.class;
	}

	@Override
	public String getModelClassName() {
		return TokenClient.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("clientId", getClientId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("clientKey", getClientKey());
		attributes.put("clientSecrets", getClientSecrets());
		attributes.put("revoked", getRevoked());
		attributes.put("aclProfiles", getAclProfiles());
		attributes.put("tokenVerifierId", getTokenVerifierId());
		attributes.put("callbackURI", getCallbackURI());
		attributes.put("websiteURL", getWebsiteURL());
		attributes.put("additionalInfo", getAdditionalInfo());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long clientId = (Long)attributes.get("clientId");

		if (clientId != null) {
			setClientId(clientId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String clientKey = (String)attributes.get("clientKey");

		if (clientKey != null) {
			setClientKey(clientKey);
		}

		String clientSecrets = (String)attributes.get("clientSecrets");

		if (clientSecrets != null) {
			setClientSecrets(clientSecrets);
		}

		Boolean revoked = (Boolean)attributes.get("revoked");

		if (revoked != null) {
			setRevoked(revoked);
		}

		String aclProfiles = (String)attributes.get("aclProfiles");

		if (aclProfiles != null) {
			setAclProfiles(aclProfiles);
		}

		String tokenVerifierId = (String)attributes.get("tokenVerifierId");

		if (tokenVerifierId != null) {
			setTokenVerifierId(tokenVerifierId);
		}

		String callbackURI = (String)attributes.get("callbackURI");

		if (callbackURI != null) {
			setCallbackURI(callbackURI);
		}

		String websiteURL = (String)attributes.get("websiteURL");

		if (websiteURL != null) {
			setWebsiteURL(websiteURL);
		}

		String additionalInfo = (String)attributes.get("additionalInfo");

		if (additionalInfo != null) {
			setAdditionalInfo(additionalInfo);
		}
	}

	@Override
	public java.lang.Object clone() {
		return new TokenClientWrapper((TokenClient)_tokenClient.clone());
	}

	@Override
	public int compareTo(com.liferay.token.auth.model.TokenClient tokenClient) {
		return _tokenClient.compareTo(tokenClient);
	}

	/**
	* Returns the acl profiles of this token client.
	*
	* @return the acl profiles of this token client
	*/
	@Override
	public java.lang.String getAclProfiles() {
		return _tokenClient.getAclProfiles();
	}

	/**
	* Returns the additional info of this token client.
	*
	* @return the additional info of this token client
	*/
	@Override
	public java.lang.String getAdditionalInfo() {
		return _tokenClient.getAdditionalInfo();
	}

	/**
	* Returns the callback u r i of this token client.
	*
	* @return the callback u r i of this token client
	*/
	@Override
	public java.lang.String getCallbackURI() {
		return _tokenClient.getCallbackURI();
	}

	/**
	* Returns the client ID of this token client.
	*
	* @return the client ID of this token client
	*/
	@Override
	public long getClientId() {
		return _tokenClient.getClientId();
	}

	/**
	* Returns the client key of this token client.
	*
	* @return the client key of this token client
	*/
	@Override
	public java.lang.String getClientKey() {
		return _tokenClient.getClientKey();
	}

	/**
	* Returns the client secrets of this token client.
	*
	* @return the client secrets of this token client
	*/
	@Override
	public java.lang.String getClientSecrets() {
		return _tokenClient.getClientSecrets();
	}

	/**
	* Returns the company ID of this token client.
	*
	* @return the company ID of this token client
	*/
	@Override
	public long getCompanyId() {
		return _tokenClient.getCompanyId();
	}

	/**
	* Returns the create date of this token client.
	*
	* @return the create date of this token client
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _tokenClient.getCreateDate();
	}

	/**
	* Returns the description of this token client.
	*
	* @return the description of this token client
	*/
	@Override
	public java.lang.String getDescription() {
		return _tokenClient.getDescription();
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _tokenClient.getExpandoBridge();
	}

	/**
	* Returns the modified date of this token client.
	*
	* @return the modified date of this token client
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _tokenClient.getModifiedDate();
	}

	/**
	* Returns the name of this token client.
	*
	* @return the name of this token client
	*/
	@Override
	public java.lang.String getName() {
		return _tokenClient.getName();
	}

	/**
	* Returns the primary key of this token client.
	*
	* @return the primary key of this token client
	*/
	@Override
	public long getPrimaryKey() {
		return _tokenClient.getPrimaryKey();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _tokenClient.getPrimaryKeyObj();
	}

	/**
	* Returns the revoked of this token client.
	*
	* @return the revoked of this token client
	*/
	@Override
	public boolean getRevoked() {
		return _tokenClient.getRevoked();
	}

	/**
	* Returns the token verifier ID of this token client.
	*
	* @return the token verifier ID of this token client
	*/
	@Override
	public java.lang.String getTokenVerifierId() {
		return _tokenClient.getTokenVerifierId();
	}

	/**
	* Returns the user ID of this token client.
	*
	* @return the user ID of this token client
	*/
	@Override
	public long getUserId() {
		return _tokenClient.getUserId();
	}

	/**
	* Returns the user name of this token client.
	*
	* @return the user name of this token client
	*/
	@Override
	public java.lang.String getUserName() {
		return _tokenClient.getUserName();
	}

	/**
	* Returns the user uuid of this token client.
	*
	* @return the user uuid of this token client
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _tokenClient.getUserUuid();
	}

	/**
	* Returns the website u r l of this token client.
	*
	* @return the website u r l of this token client
	*/
	@Override
	public java.lang.String getWebsiteURL() {
		return _tokenClient.getWebsiteURL();
	}

	@Override
	public int hashCode() {
		return _tokenClient.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _tokenClient.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _tokenClient.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _tokenClient.isNew();
	}

	/**
	* Returns <code>true</code> if this token client is revoked.
	*
	* @return <code>true</code> if this token client is revoked; <code>false</code> otherwise
	*/
	@Override
	public boolean isRevoked() {
		return _tokenClient.isRevoked();
	}

	@Override
	public void persist() {
		_tokenClient.persist();
	}

	/**
	* Sets the acl profiles of this token client.
	*
	* @param aclProfiles the acl profiles of this token client
	*/
	@Override
	public void setAclProfiles(java.lang.String aclProfiles) {
		_tokenClient.setAclProfiles(aclProfiles);
	}

	/**
	* Sets the additional info of this token client.
	*
	* @param additionalInfo the additional info of this token client
	*/
	@Override
	public void setAdditionalInfo(java.lang.String additionalInfo) {
		_tokenClient.setAdditionalInfo(additionalInfo);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_tokenClient.setCachedModel(cachedModel);
	}

	/**
	* Sets the callback u r i of this token client.
	*
	* @param callbackURI the callback u r i of this token client
	*/
	@Override
	public void setCallbackURI(java.lang.String callbackURI) {
		_tokenClient.setCallbackURI(callbackURI);
	}

	/**
	* Sets the client ID of this token client.
	*
	* @param clientId the client ID of this token client
	*/
	@Override
	public void setClientId(long clientId) {
		_tokenClient.setClientId(clientId);
	}

	/**
	* Sets the client key of this token client.
	*
	* @param clientKey the client key of this token client
	*/
	@Override
	public void setClientKey(java.lang.String clientKey) {
		_tokenClient.setClientKey(clientKey);
	}

	/**
	* Sets the client secrets of this token client.
	*
	* @param clientSecrets the client secrets of this token client
	*/
	@Override
	public void setClientSecrets(java.lang.String clientSecrets) {
		_tokenClient.setClientSecrets(clientSecrets);
	}

	/**
	* Sets the company ID of this token client.
	*
	* @param companyId the company ID of this token client
	*/
	@Override
	public void setCompanyId(long companyId) {
		_tokenClient.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this token client.
	*
	* @param createDate the create date of this token client
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_tokenClient.setCreateDate(createDate);
	}

	/**
	* Sets the description of this token client.
	*
	* @param description the description of this token client
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_tokenClient.setDescription(description);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_tokenClient.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_tokenClient.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_tokenClient.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the modified date of this token client.
	*
	* @param modifiedDate the modified date of this token client
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_tokenClient.setModifiedDate(modifiedDate);
	}

	/**
	* Sets the name of this token client.
	*
	* @param name the name of this token client
	*/
	@Override
	public void setName(java.lang.String name) {
		_tokenClient.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_tokenClient.setNew(n);
	}

	/**
	* Sets the primary key of this token client.
	*
	* @param primaryKey the primary key of this token client
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_tokenClient.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_tokenClient.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets whether this token client is revoked.
	*
	* @param revoked the revoked of this token client
	*/
	@Override
	public void setRevoked(boolean revoked) {
		_tokenClient.setRevoked(revoked);
	}

	/**
	* Sets the token verifier ID of this token client.
	*
	* @param tokenVerifierId the token verifier ID of this token client
	*/
	@Override
	public void setTokenVerifierId(java.lang.String tokenVerifierId) {
		_tokenClient.setTokenVerifierId(tokenVerifierId);
	}

	/**
	* Sets the user ID of this token client.
	*
	* @param userId the user ID of this token client
	*/
	@Override
	public void setUserId(long userId) {
		_tokenClient.setUserId(userId);
	}

	/**
	* Sets the user name of this token client.
	*
	* @param userName the user name of this token client
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_tokenClient.setUserName(userName);
	}

	/**
	* Sets the user uuid of this token client.
	*
	* @param userUuid the user uuid of this token client
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_tokenClient.setUserUuid(userUuid);
	}

	/**
	* Sets the website u r l of this token client.
	*
	* @param websiteURL the website u r l of this token client
	*/
	@Override
	public void setWebsiteURL(java.lang.String websiteURL) {
		_tokenClient.setWebsiteURL(websiteURL);
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.token.auth.model.TokenClient> toCacheModel() {
		return _tokenClient.toCacheModel();
	}

	@Override
	public com.liferay.token.auth.model.TokenClient toEscapedModel() {
		return new TokenClientWrapper(_tokenClient.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _tokenClient.toString();
	}

	@Override
	public com.liferay.token.auth.model.TokenClient toUnescapedModel() {
		return new TokenClientWrapper(_tokenClient.toUnescapedModel());
	}

	@Override
	public java.lang.String toXmlString() {
		return _tokenClient.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TokenClientWrapper)) {
			return false;
		}

		TokenClientWrapper tokenClientWrapper = (TokenClientWrapper)obj;

		if (Validator.equals(_tokenClient, tokenClientWrapper._tokenClient)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	@Deprecated
	public TokenClient getWrappedTokenClient() {
		return _tokenClient;
	}

	@Override
	public TokenClient getWrappedModel() {
		return _tokenClient;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _tokenClient.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _tokenClient.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_tokenClient.resetOriginalValues();
	}

	private final TokenClient _tokenClient;
}