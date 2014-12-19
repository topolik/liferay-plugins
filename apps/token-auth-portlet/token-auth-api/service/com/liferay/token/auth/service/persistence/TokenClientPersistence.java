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

import com.liferay.portal.service.persistence.BasePersistence;

import com.liferay.token.auth.model.TokenClient;

/**
 * The persistence interface for the token client service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TokenClientPersistenceImpl
 * @see TokenClientUtil
 * @generated
 */
@ProviderType
public interface TokenClientPersistence extends BasePersistence<TokenClient> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TokenClientUtil} to access the token client persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the token clients where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching token clients
	*/
	public java.util.List<com.liferay.token.auth.model.TokenClient> findByCompanyId(
		long companyId);

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
	public java.util.List<com.liferay.token.auth.model.TokenClient> findByCompanyId(
		long companyId, int start, int end);

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
	public java.util.List<com.liferay.token.auth.model.TokenClient> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenClient> orderByComparator);

	/**
	* Returns the first token client in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching token client
	* @throws com.liferay.token.auth.NoSuchTokenClientException if a matching token client could not be found
	*/
	public com.liferay.token.auth.model.TokenClient findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenClient> orderByComparator)
		throws com.liferay.token.auth.exception.NoSuchTokenClientException;

	/**
	* Returns the first token client in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching token client, or <code>null</code> if a matching token client could not be found
	*/
	public com.liferay.token.auth.model.TokenClient fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenClient> orderByComparator);

	/**
	* Returns the last token client in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching token client
	* @throws com.liferay.token.auth.NoSuchTokenClientException if a matching token client could not be found
	*/
	public com.liferay.token.auth.model.TokenClient findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenClient> orderByComparator)
		throws com.liferay.token.auth.exception.NoSuchTokenClientException;

	/**
	* Returns the last token client in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching token client, or <code>null</code> if a matching token client could not be found
	*/
	public com.liferay.token.auth.model.TokenClient fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenClient> orderByComparator);

	/**
	* Returns the token clients before and after the current token client in the ordered set where companyId = &#63;.
	*
	* @param clientId the primary key of the current token client
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next token client
	* @throws com.liferay.token.auth.NoSuchTokenClientException if a token client with the primary key could not be found
	*/
	public com.liferay.token.auth.model.TokenClient[] findByCompanyId_PrevAndNext(
		long clientId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenClient> orderByComparator)
		throws com.liferay.token.auth.exception.NoSuchTokenClientException;

	/**
	* Returns all the token clients that the user has permission to view where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching token clients that the user has permission to view
	*/
	public java.util.List<com.liferay.token.auth.model.TokenClient> filterFindByCompanyId(
		long companyId);

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
	public java.util.List<com.liferay.token.auth.model.TokenClient> filterFindByCompanyId(
		long companyId, int start, int end);

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
	public java.util.List<com.liferay.token.auth.model.TokenClient> filterFindByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenClient> orderByComparator);

	/**
	* Returns the token clients before and after the current token client in the ordered set of token clients that the user has permission to view where companyId = &#63;.
	*
	* @param clientId the primary key of the current token client
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next token client
	* @throws com.liferay.token.auth.NoSuchTokenClientException if a token client with the primary key could not be found
	*/
	public com.liferay.token.auth.model.TokenClient[] filterFindByCompanyId_PrevAndNext(
		long clientId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenClient> orderByComparator)
		throws com.liferay.token.auth.exception.NoSuchTokenClientException;

	/**
	* Removes all the token clients where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	*/
	public void removeByCompanyId(long companyId);

	/**
	* Returns the number of token clients where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching token clients
	*/
	public int countByCompanyId(long companyId);

	/**
	* Returns the number of token clients that the user has permission to view where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching token clients that the user has permission to view
	*/
	public int filterCountByCompanyId(long companyId);

	/**
	* Returns the token client where clientKey = &#63; or throws a {@link com.liferay.token.auth.NoSuchTokenClientException} if it could not be found.
	*
	* @param clientKey the client key
	* @return the matching token client
	* @throws com.liferay.token.auth.NoSuchTokenClientException if a matching token client could not be found
	*/
	public com.liferay.token.auth.model.TokenClient findByClientKey(
		java.lang.String clientKey)
		throws com.liferay.token.auth.exception.NoSuchTokenClientException;

	/**
	* Returns the token client where clientKey = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param clientKey the client key
	* @return the matching token client, or <code>null</code> if a matching token client could not be found
	*/
	public com.liferay.token.auth.model.TokenClient fetchByClientKey(
		java.lang.String clientKey);

	/**
	* Returns the token client where clientKey = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param clientKey the client key
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching token client, or <code>null</code> if a matching token client could not be found
	*/
	public com.liferay.token.auth.model.TokenClient fetchByClientKey(
		java.lang.String clientKey, boolean retrieveFromCache);

	/**
	* Removes the token client where clientKey = &#63; from the database.
	*
	* @param clientKey the client key
	* @return the token client that was removed
	*/
	public com.liferay.token.auth.model.TokenClient removeByClientKey(
		java.lang.String clientKey)
		throws com.liferay.token.auth.exception.NoSuchTokenClientException;

	/**
	* Returns the number of token clients where clientKey = &#63;.
	*
	* @param clientKey the client key
	* @return the number of matching token clients
	*/
	public int countByClientKey(java.lang.String clientKey);

	/**
	* Returns all the token clients where name = &#63;.
	*
	* @param name the name
	* @return the matching token clients
	*/
	public java.util.List<com.liferay.token.auth.model.TokenClient> findByName(
		java.lang.String name);

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
	public java.util.List<com.liferay.token.auth.model.TokenClient> findByName(
		java.lang.String name, int start, int end);

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
	public java.util.List<com.liferay.token.auth.model.TokenClient> findByName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenClient> orderByComparator);

	/**
	* Returns the first token client in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching token client
	* @throws com.liferay.token.auth.NoSuchTokenClientException if a matching token client could not be found
	*/
	public com.liferay.token.auth.model.TokenClient findByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenClient> orderByComparator)
		throws com.liferay.token.auth.exception.NoSuchTokenClientException;

	/**
	* Returns the first token client in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching token client, or <code>null</code> if a matching token client could not be found
	*/
	public com.liferay.token.auth.model.TokenClient fetchByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenClient> orderByComparator);

	/**
	* Returns the last token client in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching token client
	* @throws com.liferay.token.auth.NoSuchTokenClientException if a matching token client could not be found
	*/
	public com.liferay.token.auth.model.TokenClient findByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenClient> orderByComparator)
		throws com.liferay.token.auth.exception.NoSuchTokenClientException;

	/**
	* Returns the last token client in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching token client, or <code>null</code> if a matching token client could not be found
	*/
	public com.liferay.token.auth.model.TokenClient fetchByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenClient> orderByComparator);

	/**
	* Returns the token clients before and after the current token client in the ordered set where name = &#63;.
	*
	* @param clientId the primary key of the current token client
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next token client
	* @throws com.liferay.token.auth.NoSuchTokenClientException if a token client with the primary key could not be found
	*/
	public com.liferay.token.auth.model.TokenClient[] findByName_PrevAndNext(
		long clientId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenClient> orderByComparator)
		throws com.liferay.token.auth.exception.NoSuchTokenClientException;

	/**
	* Returns all the token clients that the user has permission to view where name = &#63;.
	*
	* @param name the name
	* @return the matching token clients that the user has permission to view
	*/
	public java.util.List<com.liferay.token.auth.model.TokenClient> filterFindByName(
		java.lang.String name);

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
	public java.util.List<com.liferay.token.auth.model.TokenClient> filterFindByName(
		java.lang.String name, int start, int end);

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
	public java.util.List<com.liferay.token.auth.model.TokenClient> filterFindByName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenClient> orderByComparator);

	/**
	* Returns the token clients before and after the current token client in the ordered set of token clients that the user has permission to view where name = &#63;.
	*
	* @param clientId the primary key of the current token client
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next token client
	* @throws com.liferay.token.auth.NoSuchTokenClientException if a token client with the primary key could not be found
	*/
	public com.liferay.token.auth.model.TokenClient[] filterFindByName_PrevAndNext(
		long clientId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenClient> orderByComparator)
		throws com.liferay.token.auth.exception.NoSuchTokenClientException;

	/**
	* Removes all the token clients where name = &#63; from the database.
	*
	* @param name the name
	*/
	public void removeByName(java.lang.String name);

	/**
	* Returns the number of token clients where name = &#63;.
	*
	* @param name the name
	* @return the number of matching token clients
	*/
	public int countByName(java.lang.String name);

	/**
	* Returns the number of token clients that the user has permission to view where name = &#63;.
	*
	* @param name the name
	* @return the number of matching token clients that the user has permission to view
	*/
	public int filterCountByName(java.lang.String name);

	/**
	* Caches the token client in the entity cache if it is enabled.
	*
	* @param tokenClient the token client
	*/
	public void cacheResult(
		com.liferay.token.auth.model.TokenClient tokenClient);

	/**
	* Caches the token clients in the entity cache if it is enabled.
	*
	* @param tokenClients the token clients
	*/
	public void cacheResult(
		java.util.List<com.liferay.token.auth.model.TokenClient> tokenClients);

	/**
	* Creates a new token client with the primary key. Does not add the token client to the database.
	*
	* @param clientId the primary key for the new token client
	* @return the new token client
	*/
	public com.liferay.token.auth.model.TokenClient create(long clientId);

	/**
	* Removes the token client with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param clientId the primary key of the token client
	* @return the token client that was removed
	* @throws com.liferay.token.auth.NoSuchTokenClientException if a token client with the primary key could not be found
	*/
	public com.liferay.token.auth.model.TokenClient remove(long clientId)
		throws com.liferay.token.auth.exception.NoSuchTokenClientException;

	public com.liferay.token.auth.model.TokenClient updateImpl(
		com.liferay.token.auth.model.TokenClient tokenClient);

	/**
	* Returns the token client with the primary key or throws a {@link com.liferay.token.auth.NoSuchTokenClientException} if it could not be found.
	*
	* @param clientId the primary key of the token client
	* @return the token client
	* @throws com.liferay.token.auth.NoSuchTokenClientException if a token client with the primary key could not be found
	*/
	public com.liferay.token.auth.model.TokenClient findByPrimaryKey(
		long clientId)
		throws com.liferay.token.auth.exception.NoSuchTokenClientException;

	/**
	* Returns the token client with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param clientId the primary key of the token client
	* @return the token client, or <code>null</code> if a token client with the primary key could not be found
	*/
	public com.liferay.token.auth.model.TokenClient fetchByPrimaryKey(
		long clientId);

	@Override
	public java.util.Map<java.io.Serializable, com.liferay.token.auth.model.TokenClient> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the token clients.
	*
	* @return the token clients
	*/
	public java.util.List<com.liferay.token.auth.model.TokenClient> findAll();

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
	public java.util.List<com.liferay.token.auth.model.TokenClient> findAll(
		int start, int end);

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
	public java.util.List<com.liferay.token.auth.model.TokenClient> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenClient> orderByComparator);

	/**
	* Removes all the token clients from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of token clients.
	*
	* @return the number of token clients
	*/
	public int countAll();
}