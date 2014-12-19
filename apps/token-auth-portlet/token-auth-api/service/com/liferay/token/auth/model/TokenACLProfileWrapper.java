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
 * This class is a wrapper for {@link TokenACLProfile}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TokenACLProfile
 * @generated
 */
@ProviderType
public class TokenACLProfileWrapper implements TokenACLProfile,
	ModelWrapper<TokenACLProfile> {
	public TokenACLProfileWrapper(TokenACLProfile tokenACLProfile) {
		_tokenACLProfile = tokenACLProfile;
	}

	@Override
	public Class<?> getModelClass() {
		return TokenACLProfile.class;
	}

	@Override
	public String getModelClassName() {
		return TokenACLProfile.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("aclProfileId", getAclProfileId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("acl", getAcl());
		attributes.put("parentProfileId", getParentProfileId());
		attributes.put("effectiveACL", getEffectiveACL());
		attributes.put("system", getSystem());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long aclProfileId = (Long)attributes.get("aclProfileId");

		if (aclProfileId != null) {
			setAclProfileId(aclProfileId);
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

		String acl = (String)attributes.get("acl");

		if (acl != null) {
			setAcl(acl);
		}

		Long parentProfileId = (Long)attributes.get("parentProfileId");

		if (parentProfileId != null) {
			setParentProfileId(parentProfileId);
		}

		String effectiveACL = (String)attributes.get("effectiveACL");

		if (effectiveACL != null) {
			setEffectiveACL(effectiveACL);
		}

		Boolean system = (Boolean)attributes.get("system");

		if (system != null) {
			setSystem(system);
		}
	}

	@Override
	public java.lang.Object clone() {
		return new TokenACLProfileWrapper((TokenACLProfile)_tokenACLProfile.clone());
	}

	@Override
	public int compareTo(
		com.liferay.token.auth.model.TokenACLProfile tokenACLProfile) {
		return _tokenACLProfile.compareTo(tokenACLProfile);
	}

	/**
	* Returns the acl of this token a c l profile.
	*
	* @return the acl of this token a c l profile
	*/
	@Override
	public java.lang.String getAcl() {
		return _tokenACLProfile.getAcl();
	}

	/**
	* Returns the acl profile ID of this token a c l profile.
	*
	* @return the acl profile ID of this token a c l profile
	*/
	@Override
	public long getAclProfileId() {
		return _tokenACLProfile.getAclProfileId();
	}

	/**
	* Returns the company ID of this token a c l profile.
	*
	* @return the company ID of this token a c l profile
	*/
	@Override
	public long getCompanyId() {
		return _tokenACLProfile.getCompanyId();
	}

	/**
	* Returns the create date of this token a c l profile.
	*
	* @return the create date of this token a c l profile
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _tokenACLProfile.getCreateDate();
	}

	/**
	* Returns the description of this token a c l profile.
	*
	* @return the description of this token a c l profile
	*/
	@Override
	public java.lang.String getDescription() {
		return _tokenACLProfile.getDescription();
	}

	/**
	* Returns the effective a c l of this token a c l profile.
	*
	* @return the effective a c l of this token a c l profile
	*/
	@Override
	public java.lang.String getEffectiveACL() {
		return _tokenACLProfile.getEffectiveACL();
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _tokenACLProfile.getExpandoBridge();
	}

	/**
	* Returns the modified date of this token a c l profile.
	*
	* @return the modified date of this token a c l profile
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _tokenACLProfile.getModifiedDate();
	}

	/**
	* Returns the name of this token a c l profile.
	*
	* @return the name of this token a c l profile
	*/
	@Override
	public java.lang.String getName() {
		return _tokenACLProfile.getName();
	}

	/**
	* Returns the parent profile ID of this token a c l profile.
	*
	* @return the parent profile ID of this token a c l profile
	*/
	@Override
	public long getParentProfileId() {
		return _tokenACLProfile.getParentProfileId();
	}

	/**
	* Returns the primary key of this token a c l profile.
	*
	* @return the primary key of this token a c l profile
	*/
	@Override
	public long getPrimaryKey() {
		return _tokenACLProfile.getPrimaryKey();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _tokenACLProfile.getPrimaryKeyObj();
	}

	/**
	* Returns the system of this token a c l profile.
	*
	* @return the system of this token a c l profile
	*/
	@Override
	public boolean getSystem() {
		return _tokenACLProfile.getSystem();
	}

	/**
	* Returns the user ID of this token a c l profile.
	*
	* @return the user ID of this token a c l profile
	*/
	@Override
	public long getUserId() {
		return _tokenACLProfile.getUserId();
	}

	/**
	* Returns the user name of this token a c l profile.
	*
	* @return the user name of this token a c l profile
	*/
	@Override
	public java.lang.String getUserName() {
		return _tokenACLProfile.getUserName();
	}

	/**
	* Returns the user uuid of this token a c l profile.
	*
	* @return the user uuid of this token a c l profile
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _tokenACLProfile.getUserUuid();
	}

	@Override
	public int hashCode() {
		return _tokenACLProfile.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _tokenACLProfile.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _tokenACLProfile.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _tokenACLProfile.isNew();
	}

	/**
	* Returns <code>true</code> if this token a c l profile is system.
	*
	* @return <code>true</code> if this token a c l profile is system; <code>false</code> otherwise
	*/
	@Override
	public boolean isSystem() {
		return _tokenACLProfile.isSystem();
	}

	@Override
	public void persist() {
		_tokenACLProfile.persist();
	}

	/**
	* Sets the acl of this token a c l profile.
	*
	* @param acl the acl of this token a c l profile
	*/
	@Override
	public void setAcl(java.lang.String acl) {
		_tokenACLProfile.setAcl(acl);
	}

	/**
	* Sets the acl profile ID of this token a c l profile.
	*
	* @param aclProfileId the acl profile ID of this token a c l profile
	*/
	@Override
	public void setAclProfileId(long aclProfileId) {
		_tokenACLProfile.setAclProfileId(aclProfileId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_tokenACLProfile.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this token a c l profile.
	*
	* @param companyId the company ID of this token a c l profile
	*/
	@Override
	public void setCompanyId(long companyId) {
		_tokenACLProfile.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this token a c l profile.
	*
	* @param createDate the create date of this token a c l profile
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_tokenACLProfile.setCreateDate(createDate);
	}

	/**
	* Sets the description of this token a c l profile.
	*
	* @param description the description of this token a c l profile
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_tokenACLProfile.setDescription(description);
	}

	/**
	* Sets the effective a c l of this token a c l profile.
	*
	* @param effectiveACL the effective a c l of this token a c l profile
	*/
	@Override
	public void setEffectiveACL(java.lang.String effectiveACL) {
		_tokenACLProfile.setEffectiveACL(effectiveACL);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_tokenACLProfile.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_tokenACLProfile.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_tokenACLProfile.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the modified date of this token a c l profile.
	*
	* @param modifiedDate the modified date of this token a c l profile
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_tokenACLProfile.setModifiedDate(modifiedDate);
	}

	/**
	* Sets the name of this token a c l profile.
	*
	* @param name the name of this token a c l profile
	*/
	@Override
	public void setName(java.lang.String name) {
		_tokenACLProfile.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_tokenACLProfile.setNew(n);
	}

	/**
	* Sets the parent profile ID of this token a c l profile.
	*
	* @param parentProfileId the parent profile ID of this token a c l profile
	*/
	@Override
	public void setParentProfileId(long parentProfileId) {
		_tokenACLProfile.setParentProfileId(parentProfileId);
	}

	/**
	* Sets the primary key of this token a c l profile.
	*
	* @param primaryKey the primary key of this token a c l profile
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_tokenACLProfile.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_tokenACLProfile.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets whether this token a c l profile is system.
	*
	* @param system the system of this token a c l profile
	*/
	@Override
	public void setSystem(boolean system) {
		_tokenACLProfile.setSystem(system);
	}

	/**
	* Sets the user ID of this token a c l profile.
	*
	* @param userId the user ID of this token a c l profile
	*/
	@Override
	public void setUserId(long userId) {
		_tokenACLProfile.setUserId(userId);
	}

	/**
	* Sets the user name of this token a c l profile.
	*
	* @param userName the user name of this token a c l profile
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_tokenACLProfile.setUserName(userName);
	}

	/**
	* Sets the user uuid of this token a c l profile.
	*
	* @param userUuid the user uuid of this token a c l profile
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_tokenACLProfile.setUserUuid(userUuid);
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.token.auth.model.TokenACLProfile> toCacheModel() {
		return _tokenACLProfile.toCacheModel();
	}

	@Override
	public com.liferay.token.auth.model.TokenACLProfile toEscapedModel() {
		return new TokenACLProfileWrapper(_tokenACLProfile.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _tokenACLProfile.toString();
	}

	@Override
	public com.liferay.token.auth.model.TokenACLProfile toUnescapedModel() {
		return new TokenACLProfileWrapper(_tokenACLProfile.toUnescapedModel());
	}

	@Override
	public java.lang.String toXmlString() {
		return _tokenACLProfile.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TokenACLProfileWrapper)) {
			return false;
		}

		TokenACLProfileWrapper tokenACLProfileWrapper = (TokenACLProfileWrapper)obj;

		if (Validator.equals(_tokenACLProfile,
					tokenACLProfileWrapper._tokenACLProfile)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	@Deprecated
	public TokenACLProfile getWrappedTokenACLProfile() {
		return _tokenACLProfile;
	}

	@Override
	public TokenACLProfile getWrappedModel() {
		return _tokenACLProfile;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _tokenACLProfile.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _tokenACLProfile.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_tokenACLProfile.resetOriginalValues();
	}

	private final TokenACLProfile _tokenACLProfile;
}