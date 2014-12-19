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

package com.liferay.token.auth.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

import com.liferay.token.auth.model.TokenSession;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the token session service. This utility wraps {@link TokenSessionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TokenSessionPersistence
 * @see TokenSessionPersistenceImpl
 * @generated
 */
@ProviderType
public class TokenSessionUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(TokenSession tokenSession) {
		getPersistence().clearCache(tokenSession);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TokenSession> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TokenSession> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TokenSession> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TokenSession> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static TokenSession update(TokenSession tokenSession) {
		return getPersistence().update(tokenSession);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static TokenSession update(TokenSession tokenSession,
		ServiceContext serviceContext) {
		return getPersistence().update(tokenSession, serviceContext);
	}

	/**
	* Returns all the token sessions where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching token sessions
	*/
	public static java.util.List<com.liferay.token.auth.model.TokenSession> findByCompanyId(
		long companyId) {
		return getPersistence().findByCompanyId(companyId);
	}

	/**
	* Returns a range of all the token sessions where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.token.auth.model.impl.TokenSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of token sessions
	* @param end the upper bound of the range of token sessions (not inclusive)
	* @return the range of matching token sessions
	*/
	public static java.util.List<com.liferay.token.auth.model.TokenSession> findByCompanyId(
		long companyId, int start, int end) {
		return getPersistence().findByCompanyId(companyId, start, end);
	}

	/**
	* Returns an ordered range of all the token sessions where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.token.auth.model.impl.TokenSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of token sessions
	* @param end the upper bound of the range of token sessions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching token sessions
	*/
	public static java.util.List<com.liferay.token.auth.model.TokenSession> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenSession> orderByComparator) {
		return getPersistence()
				   .findByCompanyId(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first token session in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching token session
	* @throws com.liferay.token.auth.NoSuchTokenSessionException if a matching token session could not be found
	*/
	public static com.liferay.token.auth.model.TokenSession findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenSession> orderByComparator)
		throws com.liferay.token.auth.exception.NoSuchTokenSessionException {
		return getPersistence()
				   .findByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the first token session in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching token session, or <code>null</code> if a matching token session could not be found
	*/
	public static com.liferay.token.auth.model.TokenSession fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenSession> orderByComparator) {
		return getPersistence()
				   .fetchByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the last token session in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching token session
	* @throws com.liferay.token.auth.NoSuchTokenSessionException if a matching token session could not be found
	*/
	public static com.liferay.token.auth.model.TokenSession findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenSession> orderByComparator)
		throws com.liferay.token.auth.exception.NoSuchTokenSessionException {
		return getPersistence()
				   .findByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last token session in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching token session, or <code>null</code> if a matching token session could not be found
	*/
	public static com.liferay.token.auth.model.TokenSession fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenSession> orderByComparator) {
		return getPersistence()
				   .fetchByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the token sessions before and after the current token session in the ordered set where companyId = &#63;.
	*
	* @param sessionId the primary key of the current token session
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next token session
	* @throws com.liferay.token.auth.NoSuchTokenSessionException if a token session with the primary key could not be found
	*/
	public static com.liferay.token.auth.model.TokenSession[] findByCompanyId_PrevAndNext(
		long sessionId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenSession> orderByComparator)
		throws com.liferay.token.auth.exception.NoSuchTokenSessionException {
		return getPersistence()
				   .findByCompanyId_PrevAndNext(sessionId, companyId,
			orderByComparator);
	}

	/**
	* Returns all the token sessions that the user has permission to view where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching token sessions that the user has permission to view
	*/
	public static java.util.List<com.liferay.token.auth.model.TokenSession> filterFindByCompanyId(
		long companyId) {
		return getPersistence().filterFindByCompanyId(companyId);
	}

	/**
	* Returns a range of all the token sessions that the user has permission to view where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.token.auth.model.impl.TokenSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of token sessions
	* @param end the upper bound of the range of token sessions (not inclusive)
	* @return the range of matching token sessions that the user has permission to view
	*/
	public static java.util.List<com.liferay.token.auth.model.TokenSession> filterFindByCompanyId(
		long companyId, int start, int end) {
		return getPersistence().filterFindByCompanyId(companyId, start, end);
	}

	/**
	* Returns an ordered range of all the token sessions that the user has permissions to view where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.token.auth.model.impl.TokenSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of token sessions
	* @param end the upper bound of the range of token sessions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching token sessions that the user has permission to view
	*/
	public static java.util.List<com.liferay.token.auth.model.TokenSession> filterFindByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenSession> orderByComparator) {
		return getPersistence()
				   .filterFindByCompanyId(companyId, start, end,
			orderByComparator);
	}

	/**
	* Returns the token sessions before and after the current token session in the ordered set of token sessions that the user has permission to view where companyId = &#63;.
	*
	* @param sessionId the primary key of the current token session
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next token session
	* @throws com.liferay.token.auth.NoSuchTokenSessionException if a token session with the primary key could not be found
	*/
	public static com.liferay.token.auth.model.TokenSession[] filterFindByCompanyId_PrevAndNext(
		long sessionId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenSession> orderByComparator)
		throws com.liferay.token.auth.exception.NoSuchTokenSessionException {
		return getPersistence()
				   .filterFindByCompanyId_PrevAndNext(sessionId, companyId,
			orderByComparator);
	}

	/**
	* Removes all the token sessions where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	*/
	public static void removeByCompanyId(long companyId) {
		getPersistence().removeByCompanyId(companyId);
	}

	/**
	* Returns the number of token sessions where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching token sessions
	*/
	public static int countByCompanyId(long companyId) {
		return getPersistence().countByCompanyId(companyId);
	}

	/**
	* Returns the number of token sessions that the user has permission to view where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching token sessions that the user has permission to view
	*/
	public static int filterCountByCompanyId(long companyId) {
		return getPersistence().filterCountByCompanyId(companyId);
	}

	/**
	* Returns all the token sessions where clientId = &#63;.
	*
	* @param clientId the client ID
	* @return the matching token sessions
	*/
	public static java.util.List<com.liferay.token.auth.model.TokenSession> findByClientId(
		long clientId) {
		return getPersistence().findByClientId(clientId);
	}

	/**
	* Returns a range of all the token sessions where clientId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.token.auth.model.impl.TokenSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param clientId the client ID
	* @param start the lower bound of the range of token sessions
	* @param end the upper bound of the range of token sessions (not inclusive)
	* @return the range of matching token sessions
	*/
	public static java.util.List<com.liferay.token.auth.model.TokenSession> findByClientId(
		long clientId, int start, int end) {
		return getPersistence().findByClientId(clientId, start, end);
	}

	/**
	* Returns an ordered range of all the token sessions where clientId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.token.auth.model.impl.TokenSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param clientId the client ID
	* @param start the lower bound of the range of token sessions
	* @param end the upper bound of the range of token sessions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching token sessions
	*/
	public static java.util.List<com.liferay.token.auth.model.TokenSession> findByClientId(
		long clientId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenSession> orderByComparator) {
		return getPersistence()
				   .findByClientId(clientId, start, end, orderByComparator);
	}

	/**
	* Returns the first token session in the ordered set where clientId = &#63;.
	*
	* @param clientId the client ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching token session
	* @throws com.liferay.token.auth.NoSuchTokenSessionException if a matching token session could not be found
	*/
	public static com.liferay.token.auth.model.TokenSession findByClientId_First(
		long clientId,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenSession> orderByComparator)
		throws com.liferay.token.auth.exception.NoSuchTokenSessionException {
		return getPersistence().findByClientId_First(clientId, orderByComparator);
	}

	/**
	* Returns the first token session in the ordered set where clientId = &#63;.
	*
	* @param clientId the client ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching token session, or <code>null</code> if a matching token session could not be found
	*/
	public static com.liferay.token.auth.model.TokenSession fetchByClientId_First(
		long clientId,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenSession> orderByComparator) {
		return getPersistence()
				   .fetchByClientId_First(clientId, orderByComparator);
	}

	/**
	* Returns the last token session in the ordered set where clientId = &#63;.
	*
	* @param clientId the client ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching token session
	* @throws com.liferay.token.auth.NoSuchTokenSessionException if a matching token session could not be found
	*/
	public static com.liferay.token.auth.model.TokenSession findByClientId_Last(
		long clientId,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenSession> orderByComparator)
		throws com.liferay.token.auth.exception.NoSuchTokenSessionException {
		return getPersistence().findByClientId_Last(clientId, orderByComparator);
	}

	/**
	* Returns the last token session in the ordered set where clientId = &#63;.
	*
	* @param clientId the client ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching token session, or <code>null</code> if a matching token session could not be found
	*/
	public static com.liferay.token.auth.model.TokenSession fetchByClientId_Last(
		long clientId,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenSession> orderByComparator) {
		return getPersistence().fetchByClientId_Last(clientId, orderByComparator);
	}

	/**
	* Returns the token sessions before and after the current token session in the ordered set where clientId = &#63;.
	*
	* @param sessionId the primary key of the current token session
	* @param clientId the client ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next token session
	* @throws com.liferay.token.auth.NoSuchTokenSessionException if a token session with the primary key could not be found
	*/
	public static com.liferay.token.auth.model.TokenSession[] findByClientId_PrevAndNext(
		long sessionId, long clientId,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenSession> orderByComparator)
		throws com.liferay.token.auth.exception.NoSuchTokenSessionException {
		return getPersistence()
				   .findByClientId_PrevAndNext(sessionId, clientId,
			orderByComparator);
	}

	/**
	* Returns all the token sessions that the user has permission to view where clientId = &#63;.
	*
	* @param clientId the client ID
	* @return the matching token sessions that the user has permission to view
	*/
	public static java.util.List<com.liferay.token.auth.model.TokenSession> filterFindByClientId(
		long clientId) {
		return getPersistence().filterFindByClientId(clientId);
	}

	/**
	* Returns a range of all the token sessions that the user has permission to view where clientId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.token.auth.model.impl.TokenSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param clientId the client ID
	* @param start the lower bound of the range of token sessions
	* @param end the upper bound of the range of token sessions (not inclusive)
	* @return the range of matching token sessions that the user has permission to view
	*/
	public static java.util.List<com.liferay.token.auth.model.TokenSession> filterFindByClientId(
		long clientId, int start, int end) {
		return getPersistence().filterFindByClientId(clientId, start, end);
	}

	/**
	* Returns an ordered range of all the token sessions that the user has permissions to view where clientId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.token.auth.model.impl.TokenSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param clientId the client ID
	* @param start the lower bound of the range of token sessions
	* @param end the upper bound of the range of token sessions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching token sessions that the user has permission to view
	*/
	public static java.util.List<com.liferay.token.auth.model.TokenSession> filterFindByClientId(
		long clientId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenSession> orderByComparator) {
		return getPersistence()
				   .filterFindByClientId(clientId, start, end, orderByComparator);
	}

	/**
	* Returns the token sessions before and after the current token session in the ordered set of token sessions that the user has permission to view where clientId = &#63;.
	*
	* @param sessionId the primary key of the current token session
	* @param clientId the client ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next token session
	* @throws com.liferay.token.auth.NoSuchTokenSessionException if a token session with the primary key could not be found
	*/
	public static com.liferay.token.auth.model.TokenSession[] filterFindByClientId_PrevAndNext(
		long sessionId, long clientId,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenSession> orderByComparator)
		throws com.liferay.token.auth.exception.NoSuchTokenSessionException {
		return getPersistence()
				   .filterFindByClientId_PrevAndNext(sessionId, clientId,
			orderByComparator);
	}

	/**
	* Removes all the token sessions where clientId = &#63; from the database.
	*
	* @param clientId the client ID
	*/
	public static void removeByClientId(long clientId) {
		getPersistence().removeByClientId(clientId);
	}

	/**
	* Returns the number of token sessions where clientId = &#63;.
	*
	* @param clientId the client ID
	* @return the number of matching token sessions
	*/
	public static int countByClientId(long clientId) {
		return getPersistence().countByClientId(clientId);
	}

	/**
	* Returns the number of token sessions that the user has permission to view where clientId = &#63;.
	*
	* @param clientId the client ID
	* @return the number of matching token sessions that the user has permission to view
	*/
	public static int filterCountByClientId(long clientId) {
		return getPersistence().filterCountByClientId(clientId);
	}

	/**
	* Caches the token session in the entity cache if it is enabled.
	*
	* @param tokenSession the token session
	*/
	public static void cacheResult(
		com.liferay.token.auth.model.TokenSession tokenSession) {
		getPersistence().cacheResult(tokenSession);
	}

	/**
	* Caches the token sessions in the entity cache if it is enabled.
	*
	* @param tokenSessions the token sessions
	*/
	public static void cacheResult(
		java.util.List<com.liferay.token.auth.model.TokenSession> tokenSessions) {
		getPersistence().cacheResult(tokenSessions);
	}

	/**
	* Creates a new token session with the primary key. Does not add the token session to the database.
	*
	* @param sessionId the primary key for the new token session
	* @return the new token session
	*/
	public static com.liferay.token.auth.model.TokenSession create(
		long sessionId) {
		return getPersistence().create(sessionId);
	}

	/**
	* Removes the token session with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param sessionId the primary key of the token session
	* @return the token session that was removed
	* @throws com.liferay.token.auth.NoSuchTokenSessionException if a token session with the primary key could not be found
	*/
	public static com.liferay.token.auth.model.TokenSession remove(
		long sessionId)
		throws com.liferay.token.auth.exception.NoSuchTokenSessionException {
		return getPersistence().remove(sessionId);
	}

	public static com.liferay.token.auth.model.TokenSession updateImpl(
		com.liferay.token.auth.model.TokenSession tokenSession) {
		return getPersistence().updateImpl(tokenSession);
	}

	/**
	* Returns the token session with the primary key or throws a {@link com.liferay.token.auth.NoSuchTokenSessionException} if it could not be found.
	*
	* @param sessionId the primary key of the token session
	* @return the token session
	* @throws com.liferay.token.auth.NoSuchTokenSessionException if a token session with the primary key could not be found
	*/
	public static com.liferay.token.auth.model.TokenSession findByPrimaryKey(
		long sessionId)
		throws com.liferay.token.auth.exception.NoSuchTokenSessionException {
		return getPersistence().findByPrimaryKey(sessionId);
	}

	/**
	* Returns the token session with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param sessionId the primary key of the token session
	* @return the token session, or <code>null</code> if a token session with the primary key could not be found
	*/
	public static com.liferay.token.auth.model.TokenSession fetchByPrimaryKey(
		long sessionId) {
		return getPersistence().fetchByPrimaryKey(sessionId);
	}

	public static java.util.Map<java.io.Serializable, com.liferay.token.auth.model.TokenSession> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the token sessions.
	*
	* @return the token sessions
	*/
	public static java.util.List<com.liferay.token.auth.model.TokenSession> findAll() {
		return getPersistence().findAll();
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
	public static java.util.List<com.liferay.token.auth.model.TokenSession> findAll(
		int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the token sessions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.token.auth.model.impl.TokenSessionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of token sessions
	* @param end the upper bound of the range of token sessions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of token sessions
	*/
	public static java.util.List<com.liferay.token.auth.model.TokenSession> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenSession> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the token sessions from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of token sessions.
	*
	* @return the number of token sessions
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TokenSessionPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	@Deprecated
	public void setPersistence(TokenSessionPersistence persistence) {
	}

	private static ServiceTracker<TokenSessionPersistence, TokenSessionPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TokenSessionUtil.class);

		_serviceTracker = new ServiceTracker<TokenSessionPersistence, TokenSessionPersistence>(bundle.getBundleContext(),
				TokenSessionPersistence.class, null);

		_serviceTracker.open();
	}
}