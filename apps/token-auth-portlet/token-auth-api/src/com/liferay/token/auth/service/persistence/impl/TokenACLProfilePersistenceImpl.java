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

package com.liferay.token.auth.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.token.auth.exception.NoSuchTokenACLProfileException;
import com.liferay.token.auth.model.TokenACLProfile;
import com.liferay.token.auth.model.impl.TokenACLProfileImpl;
import com.liferay.token.auth.model.impl.TokenACLProfileModelImpl;
import com.liferay.token.auth.service.persistence.TokenACLProfilePersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the token a c l profile service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TokenACLProfilePersistence
 * @see TokenACLProfileUtil
 * @generated
 */
@ProviderType
public class TokenACLProfilePersistenceImpl extends BasePersistenceImpl<TokenACLProfile>
	implements TokenACLProfilePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TokenACLProfileUtil} to access the token a c l profile persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TokenACLProfileImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TokenACLProfileModelImpl.ENTITY_CACHE_ENABLED,
			TokenACLProfileModelImpl.FINDER_CACHE_ENABLED,
			TokenACLProfileImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TokenACLProfileModelImpl.ENTITY_CACHE_ENABLED,
			TokenACLProfileModelImpl.FINDER_CACHE_ENABLED,
			TokenACLProfileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TokenACLProfileModelImpl.ENTITY_CACHE_ENABLED,
			TokenACLProfileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(TokenACLProfileModelImpl.ENTITY_CACHE_ENABLED,
			TokenACLProfileModelImpl.FINDER_CACHE_ENABLED,
			TokenACLProfileImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(TokenACLProfileModelImpl.ENTITY_CACHE_ENABLED,
			TokenACLProfileModelImpl.FINDER_CACHE_ENABLED,
			TokenACLProfileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
			new String[] { Long.class.getName() },
			TokenACLProfileModelImpl.COMPANYID_COLUMN_BITMASK |
			TokenACLProfileModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(TokenACLProfileModelImpl.ENTITY_CACHE_ENABLED,
			TokenACLProfileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the token a c l profiles where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching token a c l profiles
	 */
	@Override
	public List<TokenACLProfile> findByCompanyId(long companyId) {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<TokenACLProfile> findByCompanyId(long companyId, int start,
		int end) {
		return findByCompanyId(companyId, start, end, null);
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
	@Override
	public List<TokenACLProfile> findByCompanyId(long companyId, int start,
		int end, OrderByComparator<TokenACLProfile> orderByComparator) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId, start, end, orderByComparator };
		}

		List<TokenACLProfile> list = (List<TokenACLProfile>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TokenACLProfile tokenACLProfile : list) {
				if ((companyId != tokenACLProfile.getCompanyId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_TOKENACLPROFILE_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TokenACLProfileModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<TokenACLProfile>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TokenACLProfile>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first token a c l profile in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching token a c l profile
	 * @throws com.liferay.token.auth.NoSuchTokenACLProfileException if a matching token a c l profile could not be found
	 */
	@Override
	public TokenACLProfile findByCompanyId_First(long companyId,
		OrderByComparator<TokenACLProfile> orderByComparator)
		throws NoSuchTokenACLProfileException {
		TokenACLProfile tokenACLProfile = fetchByCompanyId_First(companyId,
				orderByComparator);

		if (tokenACLProfile != null) {
			return tokenACLProfile;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTokenACLProfileException(msg.toString());
	}

	/**
	 * Returns the first token a c l profile in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching token a c l profile, or <code>null</code> if a matching token a c l profile could not be found
	 */
	@Override
	public TokenACLProfile fetchByCompanyId_First(long companyId,
		OrderByComparator<TokenACLProfile> orderByComparator) {
		List<TokenACLProfile> list = findByCompanyId(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last token a c l profile in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching token a c l profile
	 * @throws com.liferay.token.auth.NoSuchTokenACLProfileException if a matching token a c l profile could not be found
	 */
	@Override
	public TokenACLProfile findByCompanyId_Last(long companyId,
		OrderByComparator<TokenACLProfile> orderByComparator)
		throws NoSuchTokenACLProfileException {
		TokenACLProfile tokenACLProfile = fetchByCompanyId_Last(companyId,
				orderByComparator);

		if (tokenACLProfile != null) {
			return tokenACLProfile;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTokenACLProfileException(msg.toString());
	}

	/**
	 * Returns the last token a c l profile in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching token a c l profile, or <code>null</code> if a matching token a c l profile could not be found
	 */
	@Override
	public TokenACLProfile fetchByCompanyId_Last(long companyId,
		OrderByComparator<TokenACLProfile> orderByComparator) {
		int count = countByCompanyId(companyId);

		if (count == 0) {
			return null;
		}

		List<TokenACLProfile> list = findByCompanyId(companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TokenACLProfile[] findByCompanyId_PrevAndNext(long aclProfileId,
		long companyId, OrderByComparator<TokenACLProfile> orderByComparator)
		throws NoSuchTokenACLProfileException {
		TokenACLProfile tokenACLProfile = findByPrimaryKey(aclProfileId);

		Session session = null;

		try {
			session = openSession();

			TokenACLProfile[] array = new TokenACLProfileImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, tokenACLProfile,
					companyId, orderByComparator, true);

			array[1] = tokenACLProfile;

			array[2] = getByCompanyId_PrevAndNext(session, tokenACLProfile,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TokenACLProfile getByCompanyId_PrevAndNext(Session session,
		TokenACLProfile tokenACLProfile, long companyId,
		OrderByComparator<TokenACLProfile> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TOKENACLPROFILE_WHERE);

		query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TokenACLProfileModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tokenACLProfile);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TokenACLProfile> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the token a c l profiles where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	@Override
	public void removeByCompanyId(long companyId) {
		for (TokenACLProfile tokenACLProfile : findByCompanyId(companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(tokenACLProfile);
		}
	}

	/**
	 * Returns the number of token a c l profiles where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching token a c l profiles
	 */
	@Override
	public int countByCompanyId(long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANYID;

		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TOKENACLPROFILE_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "tokenACLProfile.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_N = new FinderPath(TokenACLProfileModelImpl.ENTITY_CACHE_ENABLED,
			TokenACLProfileModelImpl.FINDER_CACHE_ENABLED,
			TokenACLProfileImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByC_N",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_N = new FinderPath(TokenACLProfileModelImpl.ENTITY_CACHE_ENABLED,
			TokenACLProfileModelImpl.FINDER_CACHE_ENABLED,
			TokenACLProfileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_N",
			new String[] { Long.class.getName(), String.class.getName() },
			TokenACLProfileModelImpl.COMPANYID_COLUMN_BITMASK |
			TokenACLProfileModelImpl.NAME_COLUMN_BITMASK |
			TokenACLProfileModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_N = new FinderPath(TokenACLProfileModelImpl.ENTITY_CACHE_ENABLED,
			TokenACLProfileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_N",
			new String[] { Long.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_N = new FinderPath(TokenACLProfileModelImpl.ENTITY_CACHE_ENABLED,
			TokenACLProfileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByC_N",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the token a c l profiles where companyId = &#63; and name = &#63;.
	 *
	 * @param companyId the company ID
	 * @param name the name
	 * @return the matching token a c l profiles
	 */
	@Override
	public List<TokenACLProfile> findByC_N(long companyId, String name) {
		return findByC_N(companyId, name, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<TokenACLProfile> findByC_N(long companyId, String name,
		int start, int end) {
		return findByC_N(companyId, name, start, end, null);
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
	@Override
	public List<TokenACLProfile> findByC_N(long companyId, String name,
		int start, int end, OrderByComparator<TokenACLProfile> orderByComparator) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_N;
			finderArgs = new Object[] { companyId, name };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_N;
			finderArgs = new Object[] {
					companyId, name,
					
					start, end, orderByComparator
				};
		}

		List<TokenACLProfile> list = (List<TokenACLProfile>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TokenACLProfile tokenACLProfile : list) {
				if ((companyId != tokenACLProfile.getCompanyId()) ||
						!Validator.equals(name, tokenACLProfile.getName())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_TOKENACLPROFILE_WHERE);

			query.append(_FINDER_COLUMN_C_N_COMPANYID_2);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_C_N_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_N_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_C_N_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TokenACLProfileModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (bindName) {
					qPos.add(name);
				}

				if (!pagination) {
					list = (List<TokenACLProfile>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TokenACLProfile>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public TokenACLProfile findByC_N_First(long companyId, String name,
		OrderByComparator<TokenACLProfile> orderByComparator)
		throws NoSuchTokenACLProfileException {
		TokenACLProfile tokenACLProfile = fetchByC_N_First(companyId, name,
				orderByComparator);

		if (tokenACLProfile != null) {
			return tokenACLProfile;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTokenACLProfileException(msg.toString());
	}

	/**
	 * Returns the first token a c l profile in the ordered set where companyId = &#63; and name = &#63;.
	 *
	 * @param companyId the company ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching token a c l profile, or <code>null</code> if a matching token a c l profile could not be found
	 */
	@Override
	public TokenACLProfile fetchByC_N_First(long companyId, String name,
		OrderByComparator<TokenACLProfile> orderByComparator) {
		List<TokenACLProfile> list = findByC_N(companyId, name, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TokenACLProfile findByC_N_Last(long companyId, String name,
		OrderByComparator<TokenACLProfile> orderByComparator)
		throws NoSuchTokenACLProfileException {
		TokenACLProfile tokenACLProfile = fetchByC_N_Last(companyId, name,
				orderByComparator);

		if (tokenACLProfile != null) {
			return tokenACLProfile;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTokenACLProfileException(msg.toString());
	}

	/**
	 * Returns the last token a c l profile in the ordered set where companyId = &#63; and name = &#63;.
	 *
	 * @param companyId the company ID
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching token a c l profile, or <code>null</code> if a matching token a c l profile could not be found
	 */
	@Override
	public TokenACLProfile fetchByC_N_Last(long companyId, String name,
		OrderByComparator<TokenACLProfile> orderByComparator) {
		int count = countByC_N(companyId, name);

		if (count == 0) {
			return null;
		}

		List<TokenACLProfile> list = findByC_N(companyId, name, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TokenACLProfile[] findByC_N_PrevAndNext(long aclProfileId,
		long companyId, String name,
		OrderByComparator<TokenACLProfile> orderByComparator)
		throws NoSuchTokenACLProfileException {
		TokenACLProfile tokenACLProfile = findByPrimaryKey(aclProfileId);

		Session session = null;

		try {
			session = openSession();

			TokenACLProfile[] array = new TokenACLProfileImpl[3];

			array[0] = getByC_N_PrevAndNext(session, tokenACLProfile,
					companyId, name, orderByComparator, true);

			array[1] = tokenACLProfile;

			array[2] = getByC_N_PrevAndNext(session, tokenACLProfile,
					companyId, name, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TokenACLProfile getByC_N_PrevAndNext(Session session,
		TokenACLProfile tokenACLProfile, long companyId, String name,
		OrderByComparator<TokenACLProfile> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TOKENACLPROFILE_WHERE);

		query.append(_FINDER_COLUMN_C_N_COMPANYID_2);

		boolean bindName = false;

		if (name == null) {
			query.append(_FINDER_COLUMN_C_N_NAME_1);
		}
		else if (name.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_C_N_NAME_3);
		}
		else {
			bindName = true;

			query.append(_FINDER_COLUMN_C_N_NAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TokenACLProfileModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (bindName) {
			qPos.add(name);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tokenACLProfile);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TokenACLProfile> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
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
	@Override
	public List<TokenACLProfile> findByC_N(long companyId, String[] names) {
		return findByC_N(companyId, names, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<TokenACLProfile> findByC_N(long companyId, String[] names,
		int start, int end) {
		return findByC_N(companyId, names, start, end, null);
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
	@Override
	public List<TokenACLProfile> findByC_N(long companyId, String[] names,
		int start, int end, OrderByComparator<TokenACLProfile> orderByComparator) {
		if (names == null) {
			names = new String[0];
		}
		else {
			names = ArrayUtil.distinct(names, NULL_SAFE_STRING_COMPARATOR);
		}

		if (names.length == 1) {
			return findByC_N(companyId, names[0], start, end, orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderArgs = new Object[] { companyId, StringUtil.merge(names) };
		}
		else {
			finderArgs = new Object[] {
					companyId, StringUtil.merge(names),
					
					start, end, orderByComparator
				};
		}

		List<TokenACLProfile> list = (List<TokenACLProfile>)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_C_N,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TokenACLProfile tokenACLProfile : list) {
				if ((companyId != tokenACLProfile.getCompanyId()) ||
						!ArrayUtil.contains(names, tokenACLProfile.getName())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_TOKENACLPROFILE_WHERE);

			query.append(_FINDER_COLUMN_C_N_COMPANYID_2);

			if (names.length > 0) {
				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < names.length; i++) {
					String name = names[i];

					if (name == null) {
						query.append(_FINDER_COLUMN_C_N_NAME_1);
					}
					else if (name.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_C_N_NAME_3);
					}
					else {
						query.append(_FINDER_COLUMN_C_N_NAME_2);
					}

					if ((i + 1) < names.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);
			}

			query.setStringAt(removeConjunction(query.stringAt(query.index() -
						1)), query.index() - 1);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TokenACLProfileModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				for (String name : names) {
					if ((name != null) && !name.isEmpty()) {
						qPos.add(name);
					}
				}

				if (!pagination) {
					list = (List<TokenACLProfile>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TokenACLProfile>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_C_N,
					finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_C_N,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the token a c l profiles where companyId = &#63; and name = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param name the name
	 */
	@Override
	public void removeByC_N(long companyId, String name) {
		for (TokenACLProfile tokenACLProfile : findByC_N(companyId, name,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(tokenACLProfile);
		}
	}

	/**
	 * Returns the number of token a c l profiles where companyId = &#63; and name = &#63;.
	 *
	 * @param companyId the company ID
	 * @param name the name
	 * @return the number of matching token a c l profiles
	 */
	@Override
	public int countByC_N(long companyId, String name) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_N;

		Object[] finderArgs = new Object[] { companyId, name };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TOKENACLPROFILE_WHERE);

			query.append(_FINDER_COLUMN_C_N_COMPANYID_2);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_C_N_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_N_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_C_N_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (bindName) {
					qPos.add(name);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of token a c l profiles where companyId = &#63; and name = any &#63;.
	 *
	 * @param companyId the company ID
	 * @param names the names
	 * @return the number of matching token a c l profiles
	 */
	@Override
	public int countByC_N(long companyId, String[] names) {
		if (names == null) {
			names = new String[0];
		}
		else {
			names = ArrayUtil.distinct(names, NULL_SAFE_STRING_COMPARATOR);
		}

		Object[] finderArgs = new Object[] { companyId, StringUtil.merge(names) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_N,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_TOKENACLPROFILE_WHERE);

			query.append(_FINDER_COLUMN_C_N_COMPANYID_2);

			if (names.length > 0) {
				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < names.length; i++) {
					String name = names[i];

					if (name == null) {
						query.append(_FINDER_COLUMN_C_N_NAME_1);
					}
					else if (name.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_C_N_NAME_3);
					}
					else {
						query.append(_FINDER_COLUMN_C_N_NAME_2);
					}

					if ((i + 1) < names.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);
			}

			query.setStringAt(removeConjunction(query.stringAt(query.index() -
						1)), query.index() - 1);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				for (String name : names) {
					if ((name != null) && !name.isEmpty()) {
						qPos.add(name);
					}
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_N,
					finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_N,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_C_N_COMPANYID_2 = "tokenACLProfile.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_N_NAME_1 = "tokenACLProfile.name IS NULL";
	private static final String _FINDER_COLUMN_C_N_NAME_2 = "tokenACLProfile.name = ?";
	private static final String _FINDER_COLUMN_C_N_NAME_3 = "(tokenACLProfile.name IS NULL OR tokenACLProfile.name = '')";

	public TokenACLProfilePersistenceImpl() {
		setModelClass(TokenACLProfile.class);
	}

	/**
	 * Caches the token a c l profile in the entity cache if it is enabled.
	 *
	 * @param tokenACLProfile the token a c l profile
	 */
	@Override
	public void cacheResult(TokenACLProfile tokenACLProfile) {
		EntityCacheUtil.putResult(TokenACLProfileModelImpl.ENTITY_CACHE_ENABLED,
			TokenACLProfileImpl.class, tokenACLProfile.getPrimaryKey(),
			tokenACLProfile);

		tokenACLProfile.resetOriginalValues();
	}

	/**
	 * Caches the token a c l profiles in the entity cache if it is enabled.
	 *
	 * @param tokenACLProfiles the token a c l profiles
	 */
	@Override
	public void cacheResult(List<TokenACLProfile> tokenACLProfiles) {
		for (TokenACLProfile tokenACLProfile : tokenACLProfiles) {
			if (EntityCacheUtil.getResult(
						TokenACLProfileModelImpl.ENTITY_CACHE_ENABLED,
						TokenACLProfileImpl.class,
						tokenACLProfile.getPrimaryKey()) == null) {
				cacheResult(tokenACLProfile);
			}
			else {
				tokenACLProfile.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all token a c l profiles.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TokenACLProfileImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TokenACLProfileImpl.class);

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the token a c l profile.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TokenACLProfile tokenACLProfile) {
		EntityCacheUtil.removeResult(TokenACLProfileModelImpl.ENTITY_CACHE_ENABLED,
			TokenACLProfileImpl.class, tokenACLProfile.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TokenACLProfile> tokenACLProfiles) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TokenACLProfile tokenACLProfile : tokenACLProfiles) {
			EntityCacheUtil.removeResult(TokenACLProfileModelImpl.ENTITY_CACHE_ENABLED,
				TokenACLProfileImpl.class, tokenACLProfile.getPrimaryKey());
		}
	}

	/**
	 * Creates a new token a c l profile with the primary key. Does not add the token a c l profile to the database.
	 *
	 * @param aclProfileId the primary key for the new token a c l profile
	 * @return the new token a c l profile
	 */
	@Override
	public TokenACLProfile create(long aclProfileId) {
		TokenACLProfile tokenACLProfile = new TokenACLProfileImpl();

		tokenACLProfile.setNew(true);
		tokenACLProfile.setPrimaryKey(aclProfileId);

		return tokenACLProfile;
	}

	/**
	 * Removes the token a c l profile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param aclProfileId the primary key of the token a c l profile
	 * @return the token a c l profile that was removed
	 * @throws com.liferay.token.auth.NoSuchTokenACLProfileException if a token a c l profile with the primary key could not be found
	 */
	@Override
	public TokenACLProfile remove(long aclProfileId)
		throws NoSuchTokenACLProfileException {
		return remove((Serializable)aclProfileId);
	}

	/**
	 * Removes the token a c l profile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the token a c l profile
	 * @return the token a c l profile that was removed
	 * @throws com.liferay.token.auth.NoSuchTokenACLProfileException if a token a c l profile with the primary key could not be found
	 */
	@Override
	public TokenACLProfile remove(Serializable primaryKey)
		throws NoSuchTokenACLProfileException {
		Session session = null;

		try {
			session = openSession();

			TokenACLProfile tokenACLProfile = (TokenACLProfile)session.get(TokenACLProfileImpl.class,
					primaryKey);

			if (tokenACLProfile == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTokenACLProfileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(tokenACLProfile);
		}
		catch (NoSuchTokenACLProfileException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected TokenACLProfile removeImpl(TokenACLProfile tokenACLProfile) {
		tokenACLProfile = toUnwrappedModel(tokenACLProfile);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(tokenACLProfile)) {
				tokenACLProfile = (TokenACLProfile)session.get(TokenACLProfileImpl.class,
						tokenACLProfile.getPrimaryKeyObj());
			}

			if (tokenACLProfile != null) {
				session.delete(tokenACLProfile);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (tokenACLProfile != null) {
			clearCache(tokenACLProfile);
		}

		return tokenACLProfile;
	}

	@Override
	public TokenACLProfile updateImpl(
		com.liferay.token.auth.model.TokenACLProfile tokenACLProfile) {
		tokenACLProfile = toUnwrappedModel(tokenACLProfile);

		boolean isNew = tokenACLProfile.isNew();

		TokenACLProfileModelImpl tokenACLProfileModelImpl = (TokenACLProfileModelImpl)tokenACLProfile;

		Session session = null;

		try {
			session = openSession();

			if (tokenACLProfile.isNew()) {
				session.save(tokenACLProfile);

				tokenACLProfile.setNew(false);
			}
			else {
				session.merge(tokenACLProfile);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TokenACLProfileModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((tokenACLProfileModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						tokenACLProfileModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);

				args = new Object[] { tokenACLProfileModelImpl.getCompanyId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);
			}

			if ((tokenACLProfileModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_N.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						tokenACLProfileModelImpl.getOriginalCompanyId(),
						tokenACLProfileModelImpl.getOriginalName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_N, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_N,
					args);

				args = new Object[] {
						tokenACLProfileModelImpl.getCompanyId(),
						tokenACLProfileModelImpl.getName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_N, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_N,
					args);
			}
		}

		EntityCacheUtil.putResult(TokenACLProfileModelImpl.ENTITY_CACHE_ENABLED,
			TokenACLProfileImpl.class, tokenACLProfile.getPrimaryKey(),
			tokenACLProfile, false);

		tokenACLProfile.resetOriginalValues();

		return tokenACLProfile;
	}

	protected TokenACLProfile toUnwrappedModel(TokenACLProfile tokenACLProfile) {
		if (tokenACLProfile instanceof TokenACLProfileImpl) {
			return tokenACLProfile;
		}

		TokenACLProfileImpl tokenACLProfileImpl = new TokenACLProfileImpl();

		tokenACLProfileImpl.setNew(tokenACLProfile.isNew());
		tokenACLProfileImpl.setPrimaryKey(tokenACLProfile.getPrimaryKey());

		tokenACLProfileImpl.setAclProfileId(tokenACLProfile.getAclProfileId());
		tokenACLProfileImpl.setCompanyId(tokenACLProfile.getCompanyId());
		tokenACLProfileImpl.setUserId(tokenACLProfile.getUserId());
		tokenACLProfileImpl.setUserName(tokenACLProfile.getUserName());
		tokenACLProfileImpl.setCreateDate(tokenACLProfile.getCreateDate());
		tokenACLProfileImpl.setModifiedDate(tokenACLProfile.getModifiedDate());
		tokenACLProfileImpl.setName(tokenACLProfile.getName());
		tokenACLProfileImpl.setDescription(tokenACLProfile.getDescription());
		tokenACLProfileImpl.setAcl(tokenACLProfile.getAcl());
		tokenACLProfileImpl.setParentProfileId(tokenACLProfile.getParentProfileId());
		tokenACLProfileImpl.setEffectiveACL(tokenACLProfile.getEffectiveACL());
		tokenACLProfileImpl.setSystem(tokenACLProfile.isSystem());

		return tokenACLProfileImpl;
	}

	/**
	 * Returns the token a c l profile with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the token a c l profile
	 * @return the token a c l profile
	 * @throws com.liferay.token.auth.NoSuchTokenACLProfileException if a token a c l profile with the primary key could not be found
	 */
	@Override
	public TokenACLProfile findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTokenACLProfileException {
		TokenACLProfile tokenACLProfile = fetchByPrimaryKey(primaryKey);

		if (tokenACLProfile == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTokenACLProfileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return tokenACLProfile;
	}

	/**
	 * Returns the token a c l profile with the primary key or throws a {@link com.liferay.token.auth.NoSuchTokenACLProfileException} if it could not be found.
	 *
	 * @param aclProfileId the primary key of the token a c l profile
	 * @return the token a c l profile
	 * @throws com.liferay.token.auth.NoSuchTokenACLProfileException if a token a c l profile with the primary key could not be found
	 */
	@Override
	public TokenACLProfile findByPrimaryKey(long aclProfileId)
		throws NoSuchTokenACLProfileException {
		return findByPrimaryKey((Serializable)aclProfileId);
	}

	/**
	 * Returns the token a c l profile with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the token a c l profile
	 * @return the token a c l profile, or <code>null</code> if a token a c l profile with the primary key could not be found
	 */
	@Override
	public TokenACLProfile fetchByPrimaryKey(Serializable primaryKey) {
		TokenACLProfile tokenACLProfile = (TokenACLProfile)EntityCacheUtil.getResult(TokenACLProfileModelImpl.ENTITY_CACHE_ENABLED,
				TokenACLProfileImpl.class, primaryKey);

		if (tokenACLProfile == _nullTokenACLProfile) {
			return null;
		}

		if (tokenACLProfile == null) {
			Session session = null;

			try {
				session = openSession();

				tokenACLProfile = (TokenACLProfile)session.get(TokenACLProfileImpl.class,
						primaryKey);

				if (tokenACLProfile != null) {
					cacheResult(tokenACLProfile);
				}
				else {
					EntityCacheUtil.putResult(TokenACLProfileModelImpl.ENTITY_CACHE_ENABLED,
						TokenACLProfileImpl.class, primaryKey,
						_nullTokenACLProfile);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(TokenACLProfileModelImpl.ENTITY_CACHE_ENABLED,
					TokenACLProfileImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return tokenACLProfile;
	}

	/**
	 * Returns the token a c l profile with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param aclProfileId the primary key of the token a c l profile
	 * @return the token a c l profile, or <code>null</code> if a token a c l profile with the primary key could not be found
	 */
	@Override
	public TokenACLProfile fetchByPrimaryKey(long aclProfileId) {
		return fetchByPrimaryKey((Serializable)aclProfileId);
	}

	@Override
	public Map<Serializable, TokenACLProfile> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, TokenACLProfile> map = new HashMap<Serializable, TokenACLProfile>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			TokenACLProfile tokenACLProfile = fetchByPrimaryKey(primaryKey);

			if (tokenACLProfile != null) {
				map.put(primaryKey, tokenACLProfile);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			TokenACLProfile tokenACLProfile = (TokenACLProfile)EntityCacheUtil.getResult(TokenACLProfileModelImpl.ENTITY_CACHE_ENABLED,
					TokenACLProfileImpl.class, primaryKey);

			if (tokenACLProfile == null) {
				if (uncachedPrimaryKeys == null) {
					uncachedPrimaryKeys = new HashSet<Serializable>();
				}

				uncachedPrimaryKeys.add(primaryKey);
			}
			else {
				map.put(primaryKey, tokenACLProfile);
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_TOKENACLPROFILE_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (TokenACLProfile tokenACLProfile : (List<TokenACLProfile>)q.list()) {
				map.put(tokenACLProfile.getPrimaryKeyObj(), tokenACLProfile);

				cacheResult(tokenACLProfile);

				uncachedPrimaryKeys.remove(tokenACLProfile.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				EntityCacheUtil.putResult(TokenACLProfileModelImpl.ENTITY_CACHE_ENABLED,
					TokenACLProfileImpl.class, primaryKey, _nullTokenACLProfile);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the token a c l profiles.
	 *
	 * @return the token a c l profiles
	 */
	@Override
	public List<TokenACLProfile> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<TokenACLProfile> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<TokenACLProfile> findAll(int start, int end,
		OrderByComparator<TokenACLProfile> orderByComparator) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<TokenACLProfile> list = (List<TokenACLProfile>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TOKENACLPROFILE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TOKENACLPROFILE;

				if (pagination) {
					sql = sql.concat(TokenACLProfileModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TokenACLProfile>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TokenACLProfile>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the token a c l profiles from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TokenACLProfile tokenACLProfile : findAll()) {
			remove(tokenACLProfile);
		}
	}

	/**
	 * Returns the number of token a c l profiles.
	 *
	 * @return the number of token a c l profiles
	 */
	@Override
	public int countAll() {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TOKENACLPROFILE);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the token a c l profile persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		EntityCacheUtil.removeCache(TokenACLProfileImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_TOKENACLPROFILE = "SELECT tokenACLProfile FROM TokenACLProfile tokenACLProfile";
	private static final String _SQL_SELECT_TOKENACLPROFILE_WHERE_PKS_IN = "SELECT tokenACLProfile FROM TokenACLProfile tokenACLProfile WHERE aclProfileId IN (";
	private static final String _SQL_SELECT_TOKENACLPROFILE_WHERE = "SELECT tokenACLProfile FROM TokenACLProfile tokenACLProfile WHERE ";
	private static final String _SQL_COUNT_TOKENACLPROFILE = "SELECT COUNT(tokenACLProfile) FROM TokenACLProfile tokenACLProfile";
	private static final String _SQL_COUNT_TOKENACLPROFILE_WHERE = "SELECT COUNT(tokenACLProfile) FROM TokenACLProfile tokenACLProfile WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "tokenACLProfile.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TokenACLProfile exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TokenACLProfile exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = com.liferay.portal.util.PropsValues.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE;
	private static final Log _log = LogFactoryUtil.getLog(TokenACLProfilePersistenceImpl.class);
	private static final TokenACLProfile _nullTokenACLProfile = new TokenACLProfileImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TokenACLProfile> toCacheModel() {
				return _nullTokenACLProfileCacheModel;
			}
		};

	private static final CacheModel<TokenACLProfile> _nullTokenACLProfileCacheModel =
		new CacheModel<TokenACLProfile>() {
			@Override
			public TokenACLProfile toEntityModel() {
				return _nullTokenACLProfile;
			}
		};
}