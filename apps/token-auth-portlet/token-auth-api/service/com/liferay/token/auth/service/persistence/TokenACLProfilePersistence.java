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

import com.liferay.token.auth.model.TokenACLProfile;

/**
 * The persistence interface for the token a c l profile service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TokenACLProfilePersistenceImpl
 * @see TokenACLProfileUtil
 * @generated
 */
@ProviderType
public interface TokenACLProfilePersistence extends BasePersistence<TokenACLProfile> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TokenACLProfileUtil} to access the token a c l profile persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the token a c l profiles where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching token a c l profiles
	*/
	public java.util.List<com.liferay.token.auth.model.TokenACLProfile> findByCompanyId(
		long companyId);

	/**
	* Returns a range of all the token a c l profiles where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.token.auth.model.impl.TokenACLProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of token a c l profiles
	* @param end the upper bound of the range of token a c l profiles (not inclusive)
	* @return the range of matching token a c l profiles
	*/
	public java.util.List<com.liferay.token.auth.model.TokenACLProfile> findByCompanyId(
		long companyId, int start, int end);

	/**
	* Returns an ordered range of all the token a c l profiles where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.token.auth.model.impl.TokenACLProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of token a c l profiles
	* @param end the upper bound of the range of token a c l profiles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching token a c l profiles
	*/
	public java.util.List<com.liferay.token.auth.model.TokenACLProfile> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenACLProfile> orderByComparator);

	/**
	* Returns the first token a c l profile in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching token a c l profile
	* @throws com.liferay.token.auth.NoSuchTokenACLProfileException if a matching token a c l profile could not be found
	*/
	public com.liferay.token.auth.model.TokenACLProfile findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenACLProfile> orderByComparator)
		throws com.liferay.token.auth.exception.NoSuchTokenACLProfileException;

	/**
	* Returns the first token a c l profile in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching token a c l profile, or <code>null</code> if a matching token a c l profile could not be found
	*/
	public com.liferay.token.auth.model.TokenACLProfile fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenACLProfile> orderByComparator);

	/**
	* Returns the last token a c l profile in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching token a c l profile
	* @throws com.liferay.token.auth.NoSuchTokenACLProfileException if a matching token a c l profile could not be found
	*/
	public com.liferay.token.auth.model.TokenACLProfile findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenACLProfile> orderByComparator)
		throws com.liferay.token.auth.exception.NoSuchTokenACLProfileException;

	/**
	* Returns the last token a c l profile in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching token a c l profile, or <code>null</code> if a matching token a c l profile could not be found
	*/
	public com.liferay.token.auth.model.TokenACLProfile fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenACLProfile> orderByComparator);

	/**
	* Returns the token a c l profiles before and after the current token a c l profile in the ordered set where companyId = &#63;.
	*
	* @param aclProfileId the primary key of the current token a c l profile
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next token a c l profile
	* @throws com.liferay.token.auth.NoSuchTokenACLProfileException if a token a c l profile with the primary key could not be found
	*/
	public com.liferay.token.auth.model.TokenACLProfile[] findByCompanyId_PrevAndNext(
		long aclProfileId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenACLProfile> orderByComparator)
		throws com.liferay.token.auth.exception.NoSuchTokenACLProfileException;

	/**
	* Removes all the token a c l profiles where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	*/
	public void removeByCompanyId(long companyId);

	/**
	* Returns the number of token a c l profiles where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching token a c l profiles
	*/
	public int countByCompanyId(long companyId);

	/**
	* Returns all the token a c l profiles where companyId = &#63; and name = &#63;.
	*
	* @param companyId the company ID
	* @param name the name
	* @return the matching token a c l profiles
	*/
	public java.util.List<com.liferay.token.auth.model.TokenACLProfile> findByC_N(
		long companyId, java.lang.String name);

	/**
	* Returns a range of all the token a c l profiles where companyId = &#63; and name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.token.auth.model.impl.TokenACLProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param name the name
	* @param start the lower bound of the range of token a c l profiles
	* @param end the upper bound of the range of token a c l profiles (not inclusive)
	* @return the range of matching token a c l profiles
	*/
	public java.util.List<com.liferay.token.auth.model.TokenACLProfile> findByC_N(
		long companyId, java.lang.String name, int start, int end);

	/**
	* Returns an ordered range of all the token a c l profiles where companyId = &#63; and name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.token.auth.model.impl.TokenACLProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param name the name
	* @param start the lower bound of the range of token a c l profiles
	* @param end the upper bound of the range of token a c l profiles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching token a c l profiles
	*/
	public java.util.List<com.liferay.token.auth.model.TokenACLProfile> findByC_N(
		long companyId, java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenACLProfile> orderByComparator);

	/**
	* Returns the first token a c l profile in the ordered set where companyId = &#63; and name = &#63;.
	*
	* @param companyId the company ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching token a c l profile
	* @throws com.liferay.token.auth.NoSuchTokenACLProfileException if a matching token a c l profile could not be found
	*/
	public com.liferay.token.auth.model.TokenACLProfile findByC_N_First(
		long companyId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenACLProfile> orderByComparator)
		throws com.liferay.token.auth.exception.NoSuchTokenACLProfileException;

	/**
	* Returns the first token a c l profile in the ordered set where companyId = &#63; and name = &#63;.
	*
	* @param companyId the company ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching token a c l profile, or <code>null</code> if a matching token a c l profile could not be found
	*/
	public com.liferay.token.auth.model.TokenACLProfile fetchByC_N_First(
		long companyId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenACLProfile> orderByComparator);

	/**
	* Returns the last token a c l profile in the ordered set where companyId = &#63; and name = &#63;.
	*
	* @param companyId the company ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching token a c l profile
	* @throws com.liferay.token.auth.NoSuchTokenACLProfileException if a matching token a c l profile could not be found
	*/
	public com.liferay.token.auth.model.TokenACLProfile findByC_N_Last(
		long companyId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenACLProfile> orderByComparator)
		throws com.liferay.token.auth.exception.NoSuchTokenACLProfileException;

	/**
	* Returns the last token a c l profile in the ordered set where companyId = &#63; and name = &#63;.
	*
	* @param companyId the company ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching token a c l profile, or <code>null</code> if a matching token a c l profile could not be found
	*/
	public com.liferay.token.auth.model.TokenACLProfile fetchByC_N_Last(
		long companyId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenACLProfile> orderByComparator);

	/**
	* Returns the token a c l profiles before and after the current token a c l profile in the ordered set where companyId = &#63; and name = &#63;.
	*
	* @param aclProfileId the primary key of the current token a c l profile
	* @param companyId the company ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next token a c l profile
	* @throws com.liferay.token.auth.NoSuchTokenACLProfileException if a token a c l profile with the primary key could not be found
	*/
	public com.liferay.token.auth.model.TokenACLProfile[] findByC_N_PrevAndNext(
		long aclProfileId, long companyId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenACLProfile> orderByComparator)
		throws com.liferay.token.auth.exception.NoSuchTokenACLProfileException;

	/**
	* Returns all the token a c l profiles where companyId = &#63; and name = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.token.auth.model.impl.TokenACLProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param names the names
	* @return the matching token a c l profiles
	*/
	public java.util.List<com.liferay.token.auth.model.TokenACLProfile> findByC_N(
		long companyId, java.lang.String[] names);

	/**
	* Returns a range of all the token a c l profiles where companyId = &#63; and name = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.token.auth.model.impl.TokenACLProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param names the names
	* @param start the lower bound of the range of token a c l profiles
	* @param end the upper bound of the range of token a c l profiles (not inclusive)
	* @return the range of matching token a c l profiles
	*/
	public java.util.List<com.liferay.token.auth.model.TokenACLProfile> findByC_N(
		long companyId, java.lang.String[] names, int start, int end);

	/**
	* Returns an ordered range of all the token a c l profiles where companyId = &#63; and name = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.token.auth.model.impl.TokenACLProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param names the names
	* @param start the lower bound of the range of token a c l profiles
	* @param end the upper bound of the range of token a c l profiles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching token a c l profiles
	*/
	public java.util.List<com.liferay.token.auth.model.TokenACLProfile> findByC_N(
		long companyId, java.lang.String[] names, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenACLProfile> orderByComparator);

	/**
	* Removes all the token a c l profiles where companyId = &#63; and name = &#63; from the database.
	*
	* @param companyId the company ID
	* @param name the name
	*/
	public void removeByC_N(long companyId, java.lang.String name);

	/**
	* Returns the number of token a c l profiles where companyId = &#63; and name = &#63;.
	*
	* @param companyId the company ID
	* @param name the name
	* @return the number of matching token a c l profiles
	*/
	public int countByC_N(long companyId, java.lang.String name);

	/**
	* Returns the number of token a c l profiles where companyId = &#63; and name = any &#63;.
	*
	* @param companyId the company ID
	* @param names the names
	* @return the number of matching token a c l profiles
	*/
	public int countByC_N(long companyId, java.lang.String[] names);

	/**
	* Caches the token a c l profile in the entity cache if it is enabled.
	*
	* @param tokenACLProfile the token a c l profile
	*/
	public void cacheResult(
		com.liferay.token.auth.model.TokenACLProfile tokenACLProfile);

	/**
	* Caches the token a c l profiles in the entity cache if it is enabled.
	*
	* @param tokenACLProfiles the token a c l profiles
	*/
	public void cacheResult(
		java.util.List<com.liferay.token.auth.model.TokenACLProfile> tokenACLProfiles);

	/**
	* Creates a new token a c l profile with the primary key. Does not add the token a c l profile to the database.
	*
	* @param aclProfileId the primary key for the new token a c l profile
	* @return the new token a c l profile
	*/
	public com.liferay.token.auth.model.TokenACLProfile create(
		long aclProfileId);

	/**
	* Removes the token a c l profile with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param aclProfileId the primary key of the token a c l profile
	* @return the token a c l profile that was removed
	* @throws com.liferay.token.auth.NoSuchTokenACLProfileException if a token a c l profile with the primary key could not be found
	*/
	public com.liferay.token.auth.model.TokenACLProfile remove(
		long aclProfileId)
		throws com.liferay.token.auth.exception.NoSuchTokenACLProfileException;

	public com.liferay.token.auth.model.TokenACLProfile updateImpl(
		com.liferay.token.auth.model.TokenACLProfile tokenACLProfile);

	/**
	* Returns the token a c l profile with the primary key or throws a {@link com.liferay.token.auth.NoSuchTokenACLProfileException} if it could not be found.
	*
	* @param aclProfileId the primary key of the token a c l profile
	* @return the token a c l profile
	* @throws com.liferay.token.auth.NoSuchTokenACLProfileException if a token a c l profile with the primary key could not be found
	*/
	public com.liferay.token.auth.model.TokenACLProfile findByPrimaryKey(
		long aclProfileId)
		throws com.liferay.token.auth.exception.NoSuchTokenACLProfileException;

	/**
	* Returns the token a c l profile with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param aclProfileId the primary key of the token a c l profile
	* @return the token a c l profile, or <code>null</code> if a token a c l profile with the primary key could not be found
	*/
	public com.liferay.token.auth.model.TokenACLProfile fetchByPrimaryKey(
		long aclProfileId);

	@Override
	public java.util.Map<java.io.Serializable, com.liferay.token.auth.model.TokenACLProfile> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the token a c l profiles.
	*
	* @return the token a c l profiles
	*/
	public java.util.List<com.liferay.token.auth.model.TokenACLProfile> findAll();

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
	public java.util.List<com.liferay.token.auth.model.TokenACLProfile> findAll(
		int start, int end);

	/**
	* Returns an ordered range of all the token a c l profiles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.token.auth.model.impl.TokenACLProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of token a c l profiles
	* @param end the upper bound of the range of token a c l profiles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of token a c l profiles
	*/
	public java.util.List<com.liferay.token.auth.model.TokenACLProfile> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenACLProfile> orderByComparator);

	/**
	* Removes all the token a c l profiles from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of token a c l profiles.
	*
	* @return the number of token a c l profiles
	*/
	public int countAll();
}