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
 * Provides a wrapper for {@link TokenClientLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TokenClientLocalService
 * @generated
 */
@ProviderType
public class TokenClientLocalServiceWrapper implements TokenClientLocalService,
	ServiceWrapper<TokenClientLocalService> {
	public TokenClientLocalServiceWrapper(
		TokenClientLocalService tokenClientLocalService) {
		_tokenClientLocalService = tokenClientLocalService;
	}

	/**
	* Adds the token client to the database. Also notifies the appropriate model listeners.
	*
	* @param tokenClient the token client
	* @return the token client that was added
	*/
	@Override
	public com.liferay.token.auth.model.TokenClient addTokenClient(
		com.liferay.token.auth.model.TokenClient tokenClient) {
		return _tokenClientLocalService.addTokenClient(tokenClient);
	}

	/**
	* Creates a new token client with the primary key. Does not add the token client to the database.
	*
	* @param clientId the primary key for the new token client
	* @return the new token client
	*/
	@Override
	public com.liferay.token.auth.model.TokenClient createTokenClient(
		long clientId) {
		return _tokenClientLocalService.createTokenClient(clientId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.model.PersistedModel deletePersistedModel(
		com.liferay.portal.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _tokenClientLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the token client with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param clientId the primary key of the token client
	* @return the token client that was removed
	* @throws PortalException if a token client with the primary key could not be found
	*/
	@Override
	public com.liferay.token.auth.model.TokenClient deleteTokenClient(
		long clientId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _tokenClientLocalService.deleteTokenClient(clientId);
	}

	/**
	* Deletes the token client from the database. Also notifies the appropriate model listeners.
	*
	* @param tokenClient the token client
	* @return the token client that was removed
	*/
	@Override
	public com.liferay.token.auth.model.TokenClient deleteTokenClient(
		com.liferay.token.auth.model.TokenClient tokenClient) {
		return _tokenClientLocalService.deleteTokenClient(tokenClient);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _tokenClientLocalService.dynamicQuery();
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
		return _tokenClientLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.token.auth.model.impl.TokenClientModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _tokenClientLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.token.auth.model.impl.TokenClientModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _tokenClientLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _tokenClientLocalService.dynamicQueryCount(dynamicQuery);
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
		return _tokenClientLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.token.auth.model.TokenClient fetchTokenClient(
		long clientId) {
		return _tokenClientLocalService.fetchTokenClient(clientId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _tokenClientLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _tokenClientLocalService.getBeanIdentifier();
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _tokenClientLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the token client with the primary key.
	*
	* @param clientId the primary key of the token client
	* @return the token client
	* @throws PortalException if a token client with the primary key could not be found
	*/
	@Override
	public com.liferay.token.auth.model.TokenClient getTokenClient(
		long clientId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _tokenClientLocalService.getTokenClient(clientId);
	}

	/**
	* Returns a range of all the token clients.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.token.auth.model.impl.TokenClientModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of token clients
	* @param end the upper bound of the range of token clients (not inclusive)
	* @return the range of token clients
	*/
	@Override
	public java.util.List<com.liferay.token.auth.model.TokenClient> getTokenClients(
		int start, int end) {
		return _tokenClientLocalService.getTokenClients(start, end);
	}

	/**
	* Returns the number of token clients.
	*
	* @return the number of token clients
	*/
	@Override
	public int getTokenClientsCount() {
		return _tokenClientLocalService.getTokenClientsCount();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_tokenClientLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	* Updates the token client in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tokenClient the token client
	* @return the token client that was updated
	*/
	@Override
	public com.liferay.token.auth.model.TokenClient updateTokenClient(
		com.liferay.token.auth.model.TokenClient tokenClient) {
		return _tokenClientLocalService.updateTokenClient(tokenClient);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	@Deprecated
	public TokenClientLocalService getWrappedTokenClientLocalService() {
		return _tokenClientLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	@Deprecated
	public void setWrappedTokenClientLocalService(
		TokenClientLocalService tokenClientLocalService) {
		_tokenClientLocalService = tokenClientLocalService;
	}

	@Override
	public TokenClientLocalService getWrappedService() {
		return _tokenClientLocalService;
	}

	@Override
	public void setWrappedService(
		TokenClientLocalService tokenClientLocalService) {
		_tokenClientLocalService = tokenClientLocalService;
	}

	private TokenClientLocalService _tokenClientLocalService;
}