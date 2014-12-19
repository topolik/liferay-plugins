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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for TokenSession. This utility wraps
 * {@link com.liferay.token.auth.service.impl.TokenSessionLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see TokenSessionLocalService
 * @see com.liferay.token.auth.service.base.TokenSessionLocalServiceBaseImpl
 * @see com.liferay.token.auth.service.impl.TokenSessionLocalServiceImpl
 * @generated
 */
@ProviderType
public class TokenSessionLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.token.auth.service.impl.TokenSessionLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the token session to the database. Also notifies the appropriate model listeners.
	*
	* @param tokenSession the token session
	* @return the token session that was added
	*/
	public static com.liferay.token.auth.model.TokenSession addTokenSession(
		com.liferay.token.auth.model.TokenSession tokenSession) {
		return getService().addTokenSession(tokenSession);
	}

	public static void audit(long sessionId)
		throws com.liferay.portal.kernel.exception.PortalException {
		getService().audit(sessionId);
	}

	/**
	* Creates a new token session with the primary key. Does not add the token session to the database.
	*
	* @param sessionId the primary key for the new token session
	* @return the new token session
	*/
	public static com.liferay.token.auth.model.TokenSession createTokenSession(
		long sessionId) {
		return getService().createTokenSession(sessionId);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.model.PersistedModel deletePersistedModel(
		com.liferay.portal.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the token session with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param sessionId the primary key of the token session
	* @return the token session that was removed
	* @throws PortalException if a token session with the primary key could not be found
	*/
	public static com.liferay.token.auth.model.TokenSession deleteTokenSession(
		long sessionId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteTokenSession(sessionId);
	}

	/**
	* Deletes the token session from the database. Also notifies the appropriate model listeners.
	*
	* @param tokenSession the token session
	* @return the token session that was removed
	*/
	public static com.liferay.token.auth.model.TokenSession deleteTokenSession(
		com.liferay.token.auth.model.TokenSession tokenSession) {
		return getService().deleteTokenSession(tokenSession);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.token.auth.model.TokenSession fetchTokenSession(
		long sessionId) {
		return getService().fetchTokenSession(sessionId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the token session with the primary key.
	*
	* @param sessionId the primary key of the token session
	* @return the token session
	* @throws PortalException if a token session with the primary key could not be found
	*/
	public static com.liferay.token.auth.model.TokenSession getTokenSession(
		long sessionId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getTokenSession(sessionId);
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
	public static java.util.List<com.liferay.token.auth.model.TokenSession> getTokenSessions(
		int start, int end) {
		return getService().getTokenSessions(start, end);
	}

	/**
	* Returns the number of token sessions.
	*
	* @return the number of token sessions
	*/
	public static int getTokenSessionsCount() {
		return getService().getTokenSessionsCount();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	/**
	* Updates the token session in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tokenSession the token session
	* @return the token session that was updated
	*/
	public static com.liferay.token.auth.model.TokenSession updateTokenSession(
		com.liferay.token.auth.model.TokenSession tokenSession) {
		return getService().updateTokenSession(tokenSession);
	}

	public static TokenSessionLocalService getService() {
		return _serviceTracker.getService();
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	@Deprecated
	public void setService(TokenSessionLocalService service) {
	}

	private static ServiceTracker<TokenSessionLocalService, TokenSessionLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TokenSessionLocalServiceUtil.class);

		_serviceTracker = new ServiceTracker<TokenSessionLocalService, TokenSessionLocalService>(bundle.getBundleContext(),
				TokenSessionLocalService.class, null);

		_serviceTracker.open();
	}
}