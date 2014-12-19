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

import com.liferay.token.auth.model.TokenClient;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the token client service. This utility wraps {@link TokenClientPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TokenClientPersistence
 * @see TokenClientPersistenceImpl
 * @generated
 */
@ProviderType
public class TokenClientUtil {
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
	public static void clearCache(TokenClient tokenClient) {
		getPersistence().clearCache(tokenClient);
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
	public static List<TokenClient> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TokenClient> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TokenClient> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TokenClient> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static TokenClient update(TokenClient tokenClient) {
		return getPersistence().update(tokenClient);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static TokenClient update(TokenClient tokenClient,
		ServiceContext serviceContext) {
		return getPersistence().update(tokenClient, serviceContext);
	}

	/**
	* Returns all the token clients where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching token clients
	*/
	public static java.util.List<com.liferay.token.auth.model.TokenClient> findByCompanyId(
		long companyId) {
		return getPersistence().findByCompanyId(companyId);
	}

	/**
	* Returns a range of all the token clients where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.token.auth.model.impl.TokenClientModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of token clients
	* @param end the upper bound of the range of token clients (not inclusive)
	* @return the range of matching token clients
	*/
	public static java.util.List<com.liferay.token.auth.model.TokenClient> findByCompanyId(
		long companyId, int start, int end) {
		return getPersistence().findByCompanyId(companyId, start, end);
	}

	/**
	* Returns an ordered range of all the token clients where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.token.auth.model.impl.TokenClientModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of token clients
	* @param end the upper bound of the range of token clients (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching token clients
	*/
	public static java.util.List<com.liferay.token.auth.model.TokenClient> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenClient> orderByComparator) {
		return getPersistence()
				   .findByCompanyId(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first token client in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching token client
	* @throws com.liferay.token.auth.NoSuchTokenClientException if a matching token client could not be found
	*/
	public static com.liferay.token.auth.model.TokenClient findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenClient> orderByComparator)
		throws com.liferay.token.auth.exception.NoSuchTokenClientException {
		return getPersistence()
				   .findByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the first token client in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching token client, or <code>null</code> if a matching token client could not be found
	*/
	public static com.liferay.token.auth.model.TokenClient fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenClient> orderByComparator) {
		return getPersistence()
				   .fetchByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the last token client in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching token client
	* @throws com.liferay.token.auth.NoSuchTokenClientException if a matching token client could not be found
	*/
	public static com.liferay.token.auth.model.TokenClient findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenClient> orderByComparator)
		throws com.liferay.token.auth.exception.NoSuchTokenClientException {
		return getPersistence()
				   .findByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last token client in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching token client, or <code>null</code> if a matching token client could not be found
	*/
	public static com.liferay.token.auth.model.TokenClient fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenClient> orderByComparator) {
		return getPersistence()
				   .fetchByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the token clients before and after the current token client in the ordered set where companyId = &#63;.
	*
	* @param clientId the primary key of the current token client
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next token client
	* @throws com.liferay.token.auth.NoSuchTokenClientException if a token client with the primary key could not be found
	*/
	public static com.liferay.token.auth.model.TokenClient[] findByCompanyId_PrevAndNext(
		long clientId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenClient> orderByComparator)
		throws com.liferay.token.auth.exception.NoSuchTokenClientException {
		return getPersistence()
				   .findByCompanyId_PrevAndNext(clientId, companyId,
			orderByComparator);
	}

	/**
	* Returns all the token clients that the user has permission to view where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching token clients that the user has permission to view
	*/
	public static java.util.List<com.liferay.token.auth.model.TokenClient> filterFindByCompanyId(
		long companyId) {
		return getPersistence().filterFindByCompanyId(companyId);
	}

	/**
	* Returns a range of all the token clients that the user has permission to view where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.token.auth.model.impl.TokenClientModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of token clients
	* @param end the upper bound of the range of token clients (not inclusive)
	* @return the range of matching token clients that the user has permission to view
	*/
	public static java.util.List<com.liferay.token.auth.model.TokenClient> filterFindByCompanyId(
		long companyId, int start, int end) {
		return getPersistence().filterFindByCompanyId(companyId, start, end);
	}

	/**
	* Returns an ordered range of all the token clients that the user has permissions to view where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.token.auth.model.impl.TokenClientModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of token clients
	* @param end the upper bound of the range of token clients (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching token clients that the user has permission to view
	*/
	public static java.util.List<com.liferay.token.auth.model.TokenClient> filterFindByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenClient> orderByComparator) {
		return getPersistence()
				   .filterFindByCompanyId(companyId, start, end,
			orderByComparator);
	}

	/**
	* Returns the token clients before and after the current token client in the ordered set of token clients that the user has permission to view where companyId = &#63;.
	*
	* @param clientId the primary key of the current token client
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next token client
	* @throws com.liferay.token.auth.NoSuchTokenClientException if a token client with the primary key could not be found
	*/
	public static com.liferay.token.auth.model.TokenClient[] filterFindByCompanyId_PrevAndNext(
		long clientId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenClient> orderByComparator)
		throws com.liferay.token.auth.exception.NoSuchTokenClientException {
		return getPersistence()
				   .filterFindByCompanyId_PrevAndNext(clientId, companyId,
			orderByComparator);
	}

	/**
	* Removes all the token clients where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	*/
	public static void removeByCompanyId(long companyId) {
		getPersistence().removeByCompanyId(companyId);
	}

	/**
	* Returns the number of token clients where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching token clients
	*/
	public static int countByCompanyId(long companyId) {
		return getPersistence().countByCompanyId(companyId);
	}

	/**
	* Returns the number of token clients that the user has permission to view where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching token clients that the user has permission to view
	*/
	public static int filterCountByCompanyId(long companyId) {
		return getPersistence().filterCountByCompanyId(companyId);
	}

	/**
	* Returns the token client where clientKey = &#63; or throws a {@link com.liferay.token.auth.NoSuchTokenClientException} if it could not be found.
	*
	* @param clientKey the client key
	* @return the matching token client
	* @throws com.liferay.token.auth.NoSuchTokenClientException if a matching token client could not be found
	*/
	public static com.liferay.token.auth.model.TokenClient findByClientKey(
		java.lang.String clientKey)
		throws com.liferay.token.auth.exception.NoSuchTokenClientException {
		return getPersistence().findByClientKey(clientKey);
	}

	/**
	* Returns the token client where clientKey = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param clientKey the client key
	* @return the matching token client, or <code>null</code> if a matching token client could not be found
	*/
	public static com.liferay.token.auth.model.TokenClient fetchByClientKey(
		java.lang.String clientKey) {
		return getPersistence().fetchByClientKey(clientKey);
	}

	/**
	* Returns the token client where clientKey = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param clientKey the client key
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching token client, or <code>null</code> if a matching token client could not be found
	*/
	public static com.liferay.token.auth.model.TokenClient fetchByClientKey(
		java.lang.String clientKey, boolean retrieveFromCache) {
		return getPersistence().fetchByClientKey(clientKey, retrieveFromCache);
	}

	/**
	* Removes the token client where clientKey = &#63; from the database.
	*
	* @param clientKey the client key
	* @return the token client that was removed
	*/
	public static com.liferay.token.auth.model.TokenClient removeByClientKey(
		java.lang.String clientKey)
		throws com.liferay.token.auth.exception.NoSuchTokenClientException {
		return getPersistence().removeByClientKey(clientKey);
	}

	/**
	* Returns the number of token clients where clientKey = &#63;.
	*
	* @param clientKey the client key
	* @return the number of matching token clients
	*/
	public static int countByClientKey(java.lang.String clientKey) {
		return getPersistence().countByClientKey(clientKey);
	}

	/**
	* Returns all the token clients where name = &#63;.
	*
	* @param name the name
	* @return the matching token clients
	*/
	public static java.util.List<com.liferay.token.auth.model.TokenClient> findByName(
		java.lang.String name) {
		return getPersistence().findByName(name);
	}

	/**
	* Returns a range of all the token clients where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.token.auth.model.impl.TokenClientModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of token clients
	* @param end the upper bound of the range of token clients (not inclusive)
	* @return the range of matching token clients
	*/
	public static java.util.List<com.liferay.token.auth.model.TokenClient> findByName(
		java.lang.String name, int start, int end) {
		return getPersistence().findByName(name, start, end);
	}

	/**
	* Returns an ordered range of all the token clients where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.token.auth.model.impl.TokenClientModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of token clients
	* @param end the upper bound of the range of token clients (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching token clients
	*/
	public static java.util.List<com.liferay.token.auth.model.TokenClient> findByName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenClient> orderByComparator) {
		return getPersistence().findByName(name, start, end, orderByComparator);
	}

	/**
	* Returns the first token client in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching token client
	* @throws com.liferay.token.auth.NoSuchTokenClientException if a matching token client could not be found
	*/
	public static com.liferay.token.auth.model.TokenClient findByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenClient> orderByComparator)
		throws com.liferay.token.auth.exception.NoSuchTokenClientException {
		return getPersistence().findByName_First(name, orderByComparator);
	}

	/**
	* Returns the first token client in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching token client, or <code>null</code> if a matching token client could not be found
	*/
	public static com.liferay.token.auth.model.TokenClient fetchByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenClient> orderByComparator) {
		return getPersistence().fetchByName_First(name, orderByComparator);
	}

	/**
	* Returns the last token client in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching token client
	* @throws com.liferay.token.auth.NoSuchTokenClientException if a matching token client could not be found
	*/
	public static com.liferay.token.auth.model.TokenClient findByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenClient> orderByComparator)
		throws com.liferay.token.auth.exception.NoSuchTokenClientException {
		return getPersistence().findByName_Last(name, orderByComparator);
	}

	/**
	* Returns the last token client in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching token client, or <code>null</code> if a matching token client could not be found
	*/
	public static com.liferay.token.auth.model.TokenClient fetchByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenClient> orderByComparator) {
		return getPersistence().fetchByName_Last(name, orderByComparator);
	}

	/**
	* Returns the token clients before and after the current token client in the ordered set where name = &#63;.
	*
	* @param clientId the primary key of the current token client
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next token client
	* @throws com.liferay.token.auth.NoSuchTokenClientException if a token client with the primary key could not be found
	*/
	public static com.liferay.token.auth.model.TokenClient[] findByName_PrevAndNext(
		long clientId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenClient> orderByComparator)
		throws com.liferay.token.auth.exception.NoSuchTokenClientException {
		return getPersistence()
				   .findByName_PrevAndNext(clientId, name, orderByComparator);
	}

	/**
	* Returns all the token clients that the user has permission to view where name = &#63;.
	*
	* @param name the name
	* @return the matching token clients that the user has permission to view
	*/
	public static java.util.List<com.liferay.token.auth.model.TokenClient> filterFindByName(
		java.lang.String name) {
		return getPersistence().filterFindByName(name);
	}

	/**
	* Returns a range of all the token clients that the user has permission to view where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.token.auth.model.impl.TokenClientModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of token clients
	* @param end the upper bound of the range of token clients (not inclusive)
	* @return the range of matching token clients that the user has permission to view
	*/
	public static java.util.List<com.liferay.token.auth.model.TokenClient> filterFindByName(
		java.lang.String name, int start, int end) {
		return getPersistence().filterFindByName(name, start, end);
	}

	/**
	* Returns an ordered range of all the token clients that the user has permissions to view where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.token.auth.model.impl.TokenClientModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of token clients
	* @param end the upper bound of the range of token clients (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching token clients that the user has permission to view
	*/
	public static java.util.List<com.liferay.token.auth.model.TokenClient> filterFindByName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenClient> orderByComparator) {
		return getPersistence()
				   .filterFindByName(name, start, end, orderByComparator);
	}

	/**
	* Returns the token clients before and after the current token client in the ordered set of token clients that the user has permission to view where name = &#63;.
	*
	* @param clientId the primary key of the current token client
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next token client
	* @throws com.liferay.token.auth.NoSuchTokenClientException if a token client with the primary key could not be found
	*/
	public static com.liferay.token.auth.model.TokenClient[] filterFindByName_PrevAndNext(
		long clientId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenClient> orderByComparator)
		throws com.liferay.token.auth.exception.NoSuchTokenClientException {
		return getPersistence()
				   .filterFindByName_PrevAndNext(clientId, name,
			orderByComparator);
	}

	/**
	* Removes all the token clients where name = &#63; from the database.
	*
	* @param name the name
	*/
	public static void removeByName(java.lang.String name) {
		getPersistence().removeByName(name);
	}

	/**
	* Returns the number of token clients where name = &#63;.
	*
	* @param name the name
	* @return the number of matching token clients
	*/
	public static int countByName(java.lang.String name) {
		return getPersistence().countByName(name);
	}

	/**
	* Returns the number of token clients that the user has permission to view where name = &#63;.
	*
	* @param name the name
	* @return the number of matching token clients that the user has permission to view
	*/
	public static int filterCountByName(java.lang.String name) {
		return getPersistence().filterCountByName(name);
	}

	/**
	* Caches the token client in the entity cache if it is enabled.
	*
	* @param tokenClient the token client
	*/
	public static void cacheResult(
		com.liferay.token.auth.model.TokenClient tokenClient) {
		getPersistence().cacheResult(tokenClient);
	}

	/**
	* Caches the token clients in the entity cache if it is enabled.
	*
	* @param tokenClients the token clients
	*/
	public static void cacheResult(
		java.util.List<com.liferay.token.auth.model.TokenClient> tokenClients) {
		getPersistence().cacheResult(tokenClients);
	}

	/**
	* Creates a new token client with the primary key. Does not add the token client to the database.
	*
	* @param clientId the primary key for the new token client
	* @return the new token client
	*/
	public static com.liferay.token.auth.model.TokenClient create(long clientId) {
		return getPersistence().create(clientId);
	}

	/**
	* Removes the token client with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param clientId the primary key of the token client
	* @return the token client that was removed
	* @throws com.liferay.token.auth.NoSuchTokenClientException if a token client with the primary key could not be found
	*/
	public static com.liferay.token.auth.model.TokenClient remove(long clientId)
		throws com.liferay.token.auth.exception.NoSuchTokenClientException {
		return getPersistence().remove(clientId);
	}

	public static com.liferay.token.auth.model.TokenClient updateImpl(
		com.liferay.token.auth.model.TokenClient tokenClient) {
		return getPersistence().updateImpl(tokenClient);
	}

	/**
	* Returns the token client with the primary key or throws a {@link com.liferay.token.auth.NoSuchTokenClientException} if it could not be found.
	*
	* @param clientId the primary key of the token client
	* @return the token client
	* @throws com.liferay.token.auth.NoSuchTokenClientException if a token client with the primary key could not be found
	*/
	public static com.liferay.token.auth.model.TokenClient findByPrimaryKey(
		long clientId)
		throws com.liferay.token.auth.exception.NoSuchTokenClientException {
		return getPersistence().findByPrimaryKey(clientId);
	}

	/**
	* Returns the token client with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param clientId the primary key of the token client
	* @return the token client, or <code>null</code> if a token client with the primary key could not be found
	*/
	public static com.liferay.token.auth.model.TokenClient fetchByPrimaryKey(
		long clientId) {
		return getPersistence().fetchByPrimaryKey(clientId);
	}

	public static java.util.Map<java.io.Serializable, com.liferay.token.auth.model.TokenClient> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the token clients.
	*
	* @return the token clients
	*/
	public static java.util.List<com.liferay.token.auth.model.TokenClient> findAll() {
		return getPersistence().findAll();
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
	public static java.util.List<com.liferay.token.auth.model.TokenClient> findAll(
		int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the token clients.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.token.auth.model.impl.TokenClientModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of token clients
	* @param end the upper bound of the range of token clients (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of token clients
	*/
	public static java.util.List<com.liferay.token.auth.model.TokenClient> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenClient> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the token clients from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of token clients.
	*
	* @return the number of token clients
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TokenClientPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	@Deprecated
	public void setPersistence(TokenClientPersistence persistence) {
	}

	private static ServiceTracker<TokenClientPersistence, TokenClientPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TokenClientUtil.class);

		_serviceTracker = new ServiceTracker<TokenClientPersistence, TokenClientPersistence>(bundle.getBundleContext(),
				TokenClientPersistence.class, null);

		_serviceTracker.open();
	}
}