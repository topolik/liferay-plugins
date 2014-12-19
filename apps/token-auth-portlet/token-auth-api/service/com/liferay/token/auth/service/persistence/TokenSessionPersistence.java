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

import com.liferay.token.auth.model.TokenSession;

/**
 * The persistence interface for the token session service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TokenSessionPersistenceImpl
 * @see TokenSessionUtil
 * @generated
 */
@ProviderType
public interface TokenSessionPersistence extends BasePersistence<TokenSession> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TokenSessionUtil} to access the token session persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the token sessions where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching token sessions
	*/
	public java.util.List<com.liferay.token.auth.model.TokenSession> findByCompanyId(
		long companyId);

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
	public java.util.List<com.liferay.token.auth.model.TokenSession> findByCompanyId(
		long companyId, int start, int end);

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
	public java.util.List<com.liferay.token.auth.model.TokenSession> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenSession> orderByComparator);

	/**
	* Returns the first token session in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching token session
	* @throws com.liferay.token.auth.NoSuchTokenSessionException if a matching token session could not be found
	*/
	public com.liferay.token.auth.model.TokenSession findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenSession> orderByComparator)
		throws com.liferay.token.auth.exception.NoSuchTokenSessionException;

	/**
	* Returns the first token session in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching token session, or <code>null</code> if a matching token session could not be found
	*/
	public com.liferay.token.auth.model.TokenSession fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenSession> orderByComparator);

	/**
	* Returns the last token session in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching token session
	* @throws com.liferay.token.auth.NoSuchTokenSessionException if a matching token session could not be found
	*/
	public com.liferay.token.auth.model.TokenSession findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenSession> orderByComparator)
		throws com.liferay.token.auth.exception.NoSuchTokenSessionException;

	/**
	* Returns the last token session in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching token session, or <code>null</code> if a matching token session could not be found
	*/
	public com.liferay.token.auth.model.TokenSession fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenSession> orderByComparator);

	/**
	* Returns the token sessions before and after the current token session in the ordered set where companyId = &#63;.
	*
	* @param sessionId the primary key of the current token session
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next token session
	* @throws com.liferay.token.auth.NoSuchTokenSessionException if a token session with the primary key could not be found
	*/
	public com.liferay.token.auth.model.TokenSession[] findByCompanyId_PrevAndNext(
		long sessionId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenSession> orderByComparator)
		throws com.liferay.token.auth.exception.NoSuchTokenSessionException;

	/**
	* Returns all the token sessions that the user has permission to view where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching token sessions that the user has permission to view
	*/
	public java.util.List<com.liferay.token.auth.model.TokenSession> filterFindByCompanyId(
		long companyId);

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
	public java.util.List<com.liferay.token.auth.model.TokenSession> filterFindByCompanyId(
		long companyId, int start, int end);

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
	public java.util.List<com.liferay.token.auth.model.TokenSession> filterFindByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenSession> orderByComparator);

	/**
	* Returns the token sessions before and after the current token session in the ordered set of token sessions that the user has permission to view where companyId = &#63;.
	*
	* @param sessionId the primary key of the current token session
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next token session
	* @throws com.liferay.token.auth.NoSuchTokenSessionException if a token session with the primary key could not be found
	*/
	public com.liferay.token.auth.model.TokenSession[] filterFindByCompanyId_PrevAndNext(
		long sessionId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenSession> orderByComparator)
		throws com.liferay.token.auth.exception.NoSuchTokenSessionException;

	/**
	* Removes all the token sessions where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	*/
	public void removeByCompanyId(long companyId);

	/**
	* Returns the number of token sessions where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching token sessions
	*/
	public int countByCompanyId(long companyId);

	/**
	* Returns the number of token sessions that the user has permission to view where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching token sessions that the user has permission to view
	*/
	public int filterCountByCompanyId(long companyId);

	/**
	* Returns all the token sessions where clientId = &#63;.
	*
	* @param clientId the client ID
	* @return the matching token sessions
	*/
	public java.util.List<com.liferay.token.auth.model.TokenSession> findByClientId(
		long clientId);

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
	public java.util.List<com.liferay.token.auth.model.TokenSession> findByClientId(
		long clientId, int start, int end);

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
	public java.util.List<com.liferay.token.auth.model.TokenSession> findByClientId(
		long clientId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenSession> orderByComparator);

	/**
	* Returns the first token session in the ordered set where clientId = &#63;.
	*
	* @param clientId the client ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching token session
	* @throws com.liferay.token.auth.NoSuchTokenSessionException if a matching token session could not be found
	*/
	public com.liferay.token.auth.model.TokenSession findByClientId_First(
		long clientId,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenSession> orderByComparator)
		throws com.liferay.token.auth.exception.NoSuchTokenSessionException;

	/**
	* Returns the first token session in the ordered set where clientId = &#63;.
	*
	* @param clientId the client ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching token session, or <code>null</code> if a matching token session could not be found
	*/
	public com.liferay.token.auth.model.TokenSession fetchByClientId_First(
		long clientId,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenSession> orderByComparator);

	/**
	* Returns the last token session in the ordered set where clientId = &#63;.
	*
	* @param clientId the client ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching token session
	* @throws com.liferay.token.auth.NoSuchTokenSessionException if a matching token session could not be found
	*/
	public com.liferay.token.auth.model.TokenSession findByClientId_Last(
		long clientId,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenSession> orderByComparator)
		throws com.liferay.token.auth.exception.NoSuchTokenSessionException;

	/**
	* Returns the last token session in the ordered set where clientId = &#63;.
	*
	* @param clientId the client ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching token session, or <code>null</code> if a matching token session could not be found
	*/
	public com.liferay.token.auth.model.TokenSession fetchByClientId_Last(
		long clientId,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenSession> orderByComparator);

	/**
	* Returns the token sessions before and after the current token session in the ordered set where clientId = &#63;.
	*
	* @param sessionId the primary key of the current token session
	* @param clientId the client ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next token session
	* @throws com.liferay.token.auth.NoSuchTokenSessionException if a token session with the primary key could not be found
	*/
	public com.liferay.token.auth.model.TokenSession[] findByClientId_PrevAndNext(
		long sessionId, long clientId,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenSession> orderByComparator)
		throws com.liferay.token.auth.exception.NoSuchTokenSessionException;

	/**
	* Returns all the token sessions that the user has permission to view where clientId = &#63;.
	*
	* @param clientId the client ID
	* @return the matching token sessions that the user has permission to view
	*/
	public java.util.List<com.liferay.token.auth.model.TokenSession> filterFindByClientId(
		long clientId);

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
	public java.util.List<com.liferay.token.auth.model.TokenSession> filterFindByClientId(
		long clientId, int start, int end);

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
	public java.util.List<com.liferay.token.auth.model.TokenSession> filterFindByClientId(
		long clientId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenSession> orderByComparator);

	/**
	* Returns the token sessions before and after the current token session in the ordered set of token sessions that the user has permission to view where clientId = &#63;.
	*
	* @param sessionId the primary key of the current token session
	* @param clientId the client ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next token session
	* @throws com.liferay.token.auth.NoSuchTokenSessionException if a token session with the primary key could not be found
	*/
	public com.liferay.token.auth.model.TokenSession[] filterFindByClientId_PrevAndNext(
		long sessionId, long clientId,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenSession> orderByComparator)
		throws com.liferay.token.auth.exception.NoSuchTokenSessionException;

	/**
	* Removes all the token sessions where clientId = &#63; from the database.
	*
	* @param clientId the client ID
	*/
	public void removeByClientId(long clientId);

	/**
	* Returns the number of token sessions where clientId = &#63;.
	*
	* @param clientId the client ID
	* @return the number of matching token sessions
	*/
	public int countByClientId(long clientId);

	/**
	* Returns the number of token sessions that the user has permission to view where clientId = &#63;.
	*
	* @param clientId the client ID
	* @return the number of matching token sessions that the user has permission to view
	*/
	public int filterCountByClientId(long clientId);

	/**
	* Caches the token session in the entity cache if it is enabled.
	*
	* @param tokenSession the token session
	*/
	public void cacheResult(
		com.liferay.token.auth.model.TokenSession tokenSession);

	/**
	* Caches the token sessions in the entity cache if it is enabled.
	*
	* @param tokenSessions the token sessions
	*/
	public void cacheResult(
		java.util.List<com.liferay.token.auth.model.TokenSession> tokenSessions);

	/**
	* Creates a new token session with the primary key. Does not add the token session to the database.
	*
	* @param sessionId the primary key for the new token session
	* @return the new token session
	*/
	public com.liferay.token.auth.model.TokenSession create(long sessionId);

	/**
	* Removes the token session with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param sessionId the primary key of the token session
	* @return the token session that was removed
	* @throws com.liferay.token.auth.NoSuchTokenSessionException if a token session with the primary key could not be found
	*/
	public com.liferay.token.auth.model.TokenSession remove(long sessionId)
		throws com.liferay.token.auth.exception.NoSuchTokenSessionException;

	public com.liferay.token.auth.model.TokenSession updateImpl(
		com.liferay.token.auth.model.TokenSession tokenSession);

	/**
	* Returns the token session with the primary key or throws a {@link com.liferay.token.auth.NoSuchTokenSessionException} if it could not be found.
	*
	* @param sessionId the primary key of the token session
	* @return the token session
	* @throws com.liferay.token.auth.NoSuchTokenSessionException if a token session with the primary key could not be found
	*/
	public com.liferay.token.auth.model.TokenSession findByPrimaryKey(
		long sessionId)
		throws com.liferay.token.auth.exception.NoSuchTokenSessionException;

	/**
	* Returns the token session with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param sessionId the primary key of the token session
	* @return the token session, or <code>null</code> if a token session with the primary key could not be found
	*/
	public com.liferay.token.auth.model.TokenSession fetchByPrimaryKey(
		long sessionId);

	@Override
	public java.util.Map<java.io.Serializable, com.liferay.token.auth.model.TokenSession> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the token sessions.
	*
	* @return the token sessions
	*/
	public java.util.List<com.liferay.token.auth.model.TokenSession> findAll();

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
	public java.util.List<com.liferay.token.auth.model.TokenSession> findAll(
		int start, int end);

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
	public java.util.List<com.liferay.token.auth.model.TokenSession> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenSession> orderByComparator);

	/**
	* Removes all the token sessions from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of token sessions.
	*
	* @return the number of token sessions
	*/
	public int countAll();
}