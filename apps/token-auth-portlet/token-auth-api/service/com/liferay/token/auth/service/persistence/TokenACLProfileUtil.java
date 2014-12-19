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

import com.liferay.token.auth.model.TokenACLProfile;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the token a c l profile service. This utility wraps {@link TokenACLProfilePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TokenACLProfilePersistence
 * @see TokenACLProfilePersistenceImpl
 * @generated
 */
@ProviderType
public class TokenACLProfileUtil {
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
	public static void clearCache(TokenACLProfile tokenACLProfile) {
		getPersistence().clearCache(tokenACLProfile);
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
	public static List<TokenACLProfile> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TokenACLProfile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TokenACLProfile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TokenACLProfile> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static TokenACLProfile update(TokenACLProfile tokenACLProfile) {
		return getPersistence().update(tokenACLProfile);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static TokenACLProfile update(TokenACLProfile tokenACLProfile,
		ServiceContext serviceContext) {
		return getPersistence().update(tokenACLProfile, serviceContext);
	}

	/**
	* Returns all the token a c l profiles where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching token a c l profiles
	*/
	public static java.util.List<com.liferay.token.auth.model.TokenACLProfile> findByCompanyId(
		long companyId) {
		return getPersistence().findByCompanyId(companyId);
	}

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
	public static java.util.List<com.liferay.token.auth.model.TokenACLProfile> findByCompanyId(
		long companyId, int start, int end) {
		return getPersistence().findByCompanyId(companyId, start, end);
	}

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
	public static java.util.List<com.liferay.token.auth.model.TokenACLProfile> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenACLProfile> orderByComparator) {
		return getPersistence()
				   .findByCompanyId(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first token a c l profile in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching token a c l profile
	* @throws com.liferay.token.auth.NoSuchTokenACLProfileException if a matching token a c l profile could not be found
	*/
	public static com.liferay.token.auth.model.TokenACLProfile findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenACLProfile> orderByComparator)
		throws com.liferay.token.auth.exception.NoSuchTokenACLProfileException {
		return getPersistence()
				   .findByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the first token a c l profile in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching token a c l profile, or <code>null</code> if a matching token a c l profile could not be found
	*/
	public static com.liferay.token.auth.model.TokenACLProfile fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenACLProfile> orderByComparator) {
		return getPersistence()
				   .fetchByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the last token a c l profile in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching token a c l profile
	* @throws com.liferay.token.auth.NoSuchTokenACLProfileException if a matching token a c l profile could not be found
	*/
	public static com.liferay.token.auth.model.TokenACLProfile findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenACLProfile> orderByComparator)
		throws com.liferay.token.auth.exception.NoSuchTokenACLProfileException {
		return getPersistence()
				   .findByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last token a c l profile in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching token a c l profile, or <code>null</code> if a matching token a c l profile could not be found
	*/
	public static com.liferay.token.auth.model.TokenACLProfile fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenACLProfile> orderByComparator) {
		return getPersistence()
				   .fetchByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the token a c l profiles before and after the current token a c l profile in the ordered set where companyId = &#63;.
	*
	* @param aclProfileId the primary key of the current token a c l profile
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next token a c l profile
	* @throws com.liferay.token.auth.NoSuchTokenACLProfileException if a token a c l profile with the primary key could not be found
	*/
	public static com.liferay.token.auth.model.TokenACLProfile[] findByCompanyId_PrevAndNext(
		long aclProfileId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenACLProfile> orderByComparator)
		throws com.liferay.token.auth.exception.NoSuchTokenACLProfileException {
		return getPersistence()
				   .findByCompanyId_PrevAndNext(aclProfileId, companyId,
			orderByComparator);
	}

	/**
	* Removes all the token a c l profiles where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	*/
	public static void removeByCompanyId(long companyId) {
		getPersistence().removeByCompanyId(companyId);
	}

	/**
	* Returns the number of token a c l profiles where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching token a c l profiles
	*/
	public static int countByCompanyId(long companyId) {
		return getPersistence().countByCompanyId(companyId);
	}

	/**
	* Returns all the token a c l profiles where companyId = &#63; and name = &#63;.
	*
	* @param companyId the company ID
	* @param name the name
	* @return the matching token a c l profiles
	*/
	public static java.util.List<com.liferay.token.auth.model.TokenACLProfile> findByC_N(
		long companyId, java.lang.String name) {
		return getPersistence().findByC_N(companyId, name);
	}

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
	public static java.util.List<com.liferay.token.auth.model.TokenACLProfile> findByC_N(
		long companyId, java.lang.String name, int start, int end) {
		return getPersistence().findByC_N(companyId, name, start, end);
	}

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
	public static java.util.List<com.liferay.token.auth.model.TokenACLProfile> findByC_N(
		long companyId, java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenACLProfile> orderByComparator) {
		return getPersistence()
				   .findByC_N(companyId, name, start, end, orderByComparator);
	}

	/**
	* Returns the first token a c l profile in the ordered set where companyId = &#63; and name = &#63;.
	*
	* @param companyId the company ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching token a c l profile
	* @throws com.liferay.token.auth.NoSuchTokenACLProfileException if a matching token a c l profile could not be found
	*/
	public static com.liferay.token.auth.model.TokenACLProfile findByC_N_First(
		long companyId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenACLProfile> orderByComparator)
		throws com.liferay.token.auth.exception.NoSuchTokenACLProfileException {
		return getPersistence()
				   .findByC_N_First(companyId, name, orderByComparator);
	}

	/**
	* Returns the first token a c l profile in the ordered set where companyId = &#63; and name = &#63;.
	*
	* @param companyId the company ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching token a c l profile, or <code>null</code> if a matching token a c l profile could not be found
	*/
	public static com.liferay.token.auth.model.TokenACLProfile fetchByC_N_First(
		long companyId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenACLProfile> orderByComparator) {
		return getPersistence()
				   .fetchByC_N_First(companyId, name, orderByComparator);
	}

	/**
	* Returns the last token a c l profile in the ordered set where companyId = &#63; and name = &#63;.
	*
	* @param companyId the company ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching token a c l profile
	* @throws com.liferay.token.auth.NoSuchTokenACLProfileException if a matching token a c l profile could not be found
	*/
	public static com.liferay.token.auth.model.TokenACLProfile findByC_N_Last(
		long companyId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenACLProfile> orderByComparator)
		throws com.liferay.token.auth.exception.NoSuchTokenACLProfileException {
		return getPersistence()
				   .findByC_N_Last(companyId, name, orderByComparator);
	}

	/**
	* Returns the last token a c l profile in the ordered set where companyId = &#63; and name = &#63;.
	*
	* @param companyId the company ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching token a c l profile, or <code>null</code> if a matching token a c l profile could not be found
	*/
	public static com.liferay.token.auth.model.TokenACLProfile fetchByC_N_Last(
		long companyId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenACLProfile> orderByComparator) {
		return getPersistence()
				   .fetchByC_N_Last(companyId, name, orderByComparator);
	}

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
	public static com.liferay.token.auth.model.TokenACLProfile[] findByC_N_PrevAndNext(
		long aclProfileId, long companyId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenACLProfile> orderByComparator)
		throws com.liferay.token.auth.exception.NoSuchTokenACLProfileException {
		return getPersistence()
				   .findByC_N_PrevAndNext(aclProfileId, companyId, name,
			orderByComparator);
	}

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
	public static java.util.List<com.liferay.token.auth.model.TokenACLProfile> findByC_N(
		long companyId, java.lang.String[] names) {
		return getPersistence().findByC_N(companyId, names);
	}

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
	public static java.util.List<com.liferay.token.auth.model.TokenACLProfile> findByC_N(
		long companyId, java.lang.String[] names, int start, int end) {
		return getPersistence().findByC_N(companyId, names, start, end);
	}

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
	public static java.util.List<com.liferay.token.auth.model.TokenACLProfile> findByC_N(
		long companyId, java.lang.String[] names, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenACLProfile> orderByComparator) {
		return getPersistence()
				   .findByC_N(companyId, names, start, end, orderByComparator);
	}

	/**
	* Removes all the token a c l profiles where companyId = &#63; and name = &#63; from the database.
	*
	* @param companyId the company ID
	* @param name the name
	*/
	public static void removeByC_N(long companyId, java.lang.String name) {
		getPersistence().removeByC_N(companyId, name);
	}

	/**
	* Returns the number of token a c l profiles where companyId = &#63; and name = &#63;.
	*
	* @param companyId the company ID
	* @param name the name
	* @return the number of matching token a c l profiles
	*/
	public static int countByC_N(long companyId, java.lang.String name) {
		return getPersistence().countByC_N(companyId, name);
	}

	/**
	* Returns the number of token a c l profiles where companyId = &#63; and name = any &#63;.
	*
	* @param companyId the company ID
	* @param names the names
	* @return the number of matching token a c l profiles
	*/
	public static int countByC_N(long companyId, java.lang.String[] names) {
		return getPersistence().countByC_N(companyId, names);
	}

	/**
	* Caches the token a c l profile in the entity cache if it is enabled.
	*
	* @param tokenACLProfile the token a c l profile
	*/
	public static void cacheResult(
		com.liferay.token.auth.model.TokenACLProfile tokenACLProfile) {
		getPersistence().cacheResult(tokenACLProfile);
	}

	/**
	* Caches the token a c l profiles in the entity cache if it is enabled.
	*
	* @param tokenACLProfiles the token a c l profiles
	*/
	public static void cacheResult(
		java.util.List<com.liferay.token.auth.model.TokenACLProfile> tokenACLProfiles) {
		getPersistence().cacheResult(tokenACLProfiles);
	}

	/**
	* Creates a new token a c l profile with the primary key. Does not add the token a c l profile to the database.
	*
	* @param aclProfileId the primary key for the new token a c l profile
	* @return the new token a c l profile
	*/
	public static com.liferay.token.auth.model.TokenACLProfile create(
		long aclProfileId) {
		return getPersistence().create(aclProfileId);
	}

	/**
	* Removes the token a c l profile with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param aclProfileId the primary key of the token a c l profile
	* @return the token a c l profile that was removed
	* @throws com.liferay.token.auth.NoSuchTokenACLProfileException if a token a c l profile with the primary key could not be found
	*/
	public static com.liferay.token.auth.model.TokenACLProfile remove(
		long aclProfileId)
		throws com.liferay.token.auth.exception.NoSuchTokenACLProfileException {
		return getPersistence().remove(aclProfileId);
	}

	public static com.liferay.token.auth.model.TokenACLProfile updateImpl(
		com.liferay.token.auth.model.TokenACLProfile tokenACLProfile) {
		return getPersistence().updateImpl(tokenACLProfile);
	}

	/**
	* Returns the token a c l profile with the primary key or throws a {@link com.liferay.token.auth.NoSuchTokenACLProfileException} if it could not be found.
	*
	* @param aclProfileId the primary key of the token a c l profile
	* @return the token a c l profile
	* @throws com.liferay.token.auth.NoSuchTokenACLProfileException if a token a c l profile with the primary key could not be found
	*/
	public static com.liferay.token.auth.model.TokenACLProfile findByPrimaryKey(
		long aclProfileId)
		throws com.liferay.token.auth.exception.NoSuchTokenACLProfileException {
		return getPersistence().findByPrimaryKey(aclProfileId);
	}

	/**
	* Returns the token a c l profile with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param aclProfileId the primary key of the token a c l profile
	* @return the token a c l profile, or <code>null</code> if a token a c l profile with the primary key could not be found
	*/
	public static com.liferay.token.auth.model.TokenACLProfile fetchByPrimaryKey(
		long aclProfileId) {
		return getPersistence().fetchByPrimaryKey(aclProfileId);
	}

	public static java.util.Map<java.io.Serializable, com.liferay.token.auth.model.TokenACLProfile> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the token a c l profiles.
	*
	* @return the token a c l profiles
	*/
	public static java.util.List<com.liferay.token.auth.model.TokenACLProfile> findAll() {
		return getPersistence().findAll();
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
	public static java.util.List<com.liferay.token.auth.model.TokenACLProfile> findAll(
		int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.liferay.token.auth.model.TokenACLProfile> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.token.auth.model.TokenACLProfile> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the token a c l profiles from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of token a c l profiles.
	*
	* @return the number of token a c l profiles
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TokenACLProfilePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	@Deprecated
	public void setPersistence(TokenACLProfilePersistence persistence) {
	}

	private static ServiceTracker<TokenACLProfilePersistence, TokenACLProfilePersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TokenACLProfileUtil.class);

		_serviceTracker = new ServiceTracker<TokenACLProfilePersistence, TokenACLProfilePersistence>(bundle.getBundleContext(),
				TokenACLProfilePersistence.class, null);

		_serviceTracker.open();
	}
}