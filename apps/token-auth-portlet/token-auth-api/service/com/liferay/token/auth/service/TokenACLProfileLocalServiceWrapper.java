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

package com.liferay.token.auth.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TokenACLProfileLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TokenACLProfileLocalService
 * @generated
 */
@ProviderType
public class TokenACLProfileLocalServiceWrapper
	implements TokenACLProfileLocalService,
		ServiceWrapper<TokenACLProfileLocalService> {
	public TokenACLProfileLocalServiceWrapper(
		TokenACLProfileLocalService tokenACLProfileLocalService) {
		_tokenACLProfileLocalService = tokenACLProfileLocalService;
	}

	/**
	* Adds the token a c l profile to the database. Also notifies the appropriate model listeners.
	*
	* @param tokenACLProfile the token a c l profile
	* @return the token a c l profile that was added
	*/
	@Override
	public com.liferay.token.auth.model.TokenACLProfile addTokenACLProfile(
		com.liferay.token.auth.model.TokenACLProfile tokenACLProfile) {
		return _tokenACLProfileLocalService.addTokenACLProfile(tokenACLProfile);
	}

	/**
	* Creates a new token a c l profile with the primary key. Does not add the token a c l profile to the database.
	*
	* @param aclProfileId the primary key for the new token a c l profile
	* @return the new token a c l profile
	*/
	@Override
	public com.liferay.token.auth.model.TokenACLProfile createTokenACLProfile(
		long aclProfileId) {
		return _tokenACLProfileLocalService.createTokenACLProfile(aclProfileId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.model.PersistedModel deletePersistedModel(
		com.liferay.portal.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _tokenACLProfileLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the token a c l profile with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param aclProfileId the primary key of the token a c l profile
	* @return the token a c l profile that was removed
	* @throws PortalException if a token a c l profile with the primary key could not be found
	*/
	@Override
	public com.liferay.token.auth.model.TokenACLProfile deleteTokenACLProfile(
		long aclProfileId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _tokenACLProfileLocalService.deleteTokenACLProfile(aclProfileId);
	}

	/**
	* Deletes the token a c l profile from the database. Also notifies the appropriate model listeners.
	*
	* @param tokenACLProfile the token a c l profile
	* @return the token a c l profile that was removed
	*/
	@Override
	public com.liferay.token.auth.model.TokenACLProfile deleteTokenACLProfile(
		com.liferay.token.auth.model.TokenACLProfile tokenACLProfile) {
		return _tokenACLProfileLocalService.deleteTokenACLProfile(tokenACLProfile);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _tokenACLProfileLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _tokenACLProfileLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.token.auth.model.impl.TokenACLProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _tokenACLProfileLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.token.auth.model.impl.TokenACLProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _tokenACLProfileLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _tokenACLProfileLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _tokenACLProfileLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.token.auth.model.TokenACLProfile fetchTokenACLProfile(
		long aclProfileId) {
		return _tokenACLProfileLocalService.fetchTokenACLProfile(aclProfileId);
	}

	@Override
	public java.util.List<com.liferay.token.auth.model.TokenACLProfile> findByNames(
		long companyId, java.lang.String[] names) {
		return _tokenACLProfileLocalService.findByNames(companyId, names);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _tokenACLProfileLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _tokenACLProfileLocalService.getBeanIdentifier();
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _tokenACLProfileLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the token a c l profile with the primary key.
	*
	* @param aclProfileId the primary key of the token a c l profile
	* @return the token a c l profile
	* @throws PortalException if a token a c l profile with the primary key could not be found
	*/
	@Override
	public com.liferay.token.auth.model.TokenACLProfile getTokenACLProfile(
		long aclProfileId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _tokenACLProfileLocalService.getTokenACLProfile(aclProfileId);
	}

	/**
	* Returns a range of all the token a c l profiles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.token.auth.model.impl.TokenACLProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of token a c l profiles
	* @param end the upper bound of the range of token a c l profiles (not inclusive)
	* @return the range of token a c l profiles
	*/
	@Override
	public java.util.List<com.liferay.token.auth.model.TokenACLProfile> getTokenACLProfiles(
		int start, int end) {
		return _tokenACLProfileLocalService.getTokenACLProfiles(start, end);
	}

	/**
	* Returns the number of token a c l profiles.
	*
	* @return the number of token a c l profiles
	*/
	@Override
	public int getTokenACLProfilesCount() {
		return _tokenACLProfileLocalService.getTokenACLProfilesCount();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_tokenACLProfileLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	* Updates the token a c l profile in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tokenACLProfile the token a c l profile
	* @return the token a c l profile that was updated
	*/
	@Override
	public com.liferay.token.auth.model.TokenACLProfile updateTokenACLProfile(
		com.liferay.token.auth.model.TokenACLProfile tokenACLProfile) {
		return _tokenACLProfileLocalService.updateTokenACLProfile(tokenACLProfile);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	@Deprecated
	public TokenACLProfileLocalService getWrappedTokenACLProfileLocalService() {
		return _tokenACLProfileLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	@Deprecated
	public void setWrappedTokenACLProfileLocalService(
		TokenACLProfileLocalService tokenACLProfileLocalService) {
		_tokenACLProfileLocalService = tokenACLProfileLocalService;
	}

	@Override
	public TokenACLProfileLocalService getWrappedService() {
		return _tokenACLProfileLocalService;
	}

	@Override
	public void setWrappedService(
		TokenACLProfileLocalService tokenACLProfileLocalService) {
		_tokenACLProfileLocalService = tokenACLProfileLocalService;
	}

	private TokenACLProfileLocalService _tokenACLProfileLocalService;
}