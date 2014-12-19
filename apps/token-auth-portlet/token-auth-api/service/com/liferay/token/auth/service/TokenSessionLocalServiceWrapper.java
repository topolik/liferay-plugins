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
 * Provides a wrapper for {@link TokenSessionLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TokenSessionLocalService
 * @generated
 */
@ProviderType
public class TokenSessionLocalServiceWrapper implements TokenSessionLocalService,
	ServiceWrapper<TokenSessionLocalService> {
	public TokenSessionLocalServiceWrapper(
		TokenSessionLocalService tokenSessionLocalService) {
		_tokenSessionLocalService = tokenSessionLocalService;
	}

	/**
	* Adds the token session to the database. Also notifies the appropriate model listeners.
	*
	* @param tokenSession the token session
	* @return the token session that was added
	*/
	@Override
	public com.liferay.token.auth.model.TokenSession addTokenSession(
		com.liferay.token.auth.model.TokenSession tokenSession) {
		return _tokenSessionLocalService.addTokenSession(tokenSession);
	}

	@Override
	public void audit(long sessionId)
		throws com.liferay.portal.kernel.exception.PortalException {
		_tokenSessionLocalService.audit(sessionId);
	}

	/**
	* Creates a new token session with the primary key. Does not add the token session to the database.
	*
	* @param sessionId the primary key for the new token session
	* @return the new token session
	*/
	@Override
	public com.liferay.token.auth.model.TokenSession createTokenSession(
		long sessionId) {
		return _tokenSessionLocalService.createTokenSession(sessionId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.model.PersistedModel deletePersistedModel(
		com.liferay.portal.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _tokenSessionLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the token session with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param sessionId the primary key of the token session
	* @return the token session that was removed
	* @throws PortalException if a token session with the primary key could not be found
	*/
	@Override
	public com.liferay.token.auth.model.TokenSession deleteTokenSession(
		long sessionId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _tokenSessionLocalService.deleteTokenSession(sessionId);
	}

	/**
	* Deletes the token session from the database. Also notifies the appropriate model listeners.
	*
	* @param tokenSession the token session
	* @return the token session that was removed
	*/
	@Override
	public com.liferay.token.auth.model.TokenSession deleteTokenSession(
		com.liferay.token.auth.model.TokenSession tokenSession) {
		return _tokenSessionLocalService.deleteTokenSession(tokenSession);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _tokenSessionLocalService.dynamicQuery();
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
		return _tokenSessionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.token.auth.model.impl.TokenSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _tokenSessionLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.token.auth.model.impl.TokenSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _tokenSessionLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _tokenSessionLocalService.dynamicQueryCount(dynamicQuery);
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
		return _tokenSessionLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.token.auth.model.TokenSession fetchTokenSession(
		long sessionId) {
		return _tokenSessionLocalService.fetchTokenSession(sessionId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _tokenSessionLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _tokenSessionLocalService.getBeanIdentifier();
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _tokenSessionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the token session with the primary key.
	*
	* @param sessionId the primary key of the token session
	* @return the token session
	* @throws PortalException if a token session with the primary key could not be found
	*/
	@Override
	public com.liferay.token.auth.model.TokenSession getTokenSession(
		long sessionId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _tokenSessionLocalService.getTokenSession(sessionId);
	}

	/**
	* Returns a range of all the token sessions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.token.auth.model.impl.TokenSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of token sessions
	* @param end the upper bound of the range of token sessions (not inclusive)
	* @return the range of token sessions
	*/
	@Override
	public java.util.List<com.liferay.token.auth.model.TokenSession> getTokenSessions(
		int start, int end) {
		return _tokenSessionLocalService.getTokenSessions(start, end);
	}

	/**
	* Returns the number of token sessions.
	*
	* @return the number of token sessions
	*/
	@Override
	public int getTokenSessionsCount() {
		return _tokenSessionLocalService.getTokenSessionsCount();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_tokenSessionLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	* Updates the token session in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tokenSession the token session
	* @return the token session that was updated
	*/
	@Override
	public com.liferay.token.auth.model.TokenSession updateTokenSession(
		com.liferay.token.auth.model.TokenSession tokenSession) {
		return _tokenSessionLocalService.updateTokenSession(tokenSession);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	@Deprecated
	public TokenSessionLocalService getWrappedTokenSessionLocalService() {
		return _tokenSessionLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	@Deprecated
	public void setWrappedTokenSessionLocalService(
		TokenSessionLocalService tokenSessionLocalService) {
		_tokenSessionLocalService = tokenSessionLocalService;
	}

	@Override
	public TokenSessionLocalService getWrappedService() {
		return _tokenSessionLocalService;
	}

	@Override
	public void setWrappedService(
		TokenSessionLocalService tokenSessionLocalService) {
		_tokenSessionLocalService = tokenSessionLocalService;
	}

	private TokenSessionLocalService _tokenSessionLocalService;
}