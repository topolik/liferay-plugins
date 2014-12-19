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
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.token.auth.exception.NoSuchTokenClientException;
import com.liferay.token.auth.model.TokenClient;
import com.liferay.token.auth.model.impl.TokenClientImpl;
import com.liferay.token.auth.model.impl.TokenClientModelImpl;
import com.liferay.token.auth.service.persistence.TokenClientPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the token client service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TokenClientPersistence
 * @see TokenClientUtil
 * @generated
 */
@ProviderType
public class TokenClientPersistenceImpl extends BasePersistenceImpl<TokenClient>
	implements TokenClientPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TokenClientUtil} to access the token client persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TokenClientImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TokenClientModelImpl.ENTITY_CACHE_ENABLED,
			TokenClientModelImpl.FINDER_CACHE_ENABLED, TokenClientImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TokenClientModelImpl.ENTITY_CACHE_ENABLED,
			TokenClientModelImpl.FINDER_CACHE_ENABLED, TokenClientImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TokenClientModelImpl.ENTITY_CACHE_ENABLED,
			TokenClientModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(TokenClientModelImpl.ENTITY_CACHE_ENABLED,
			TokenClientModelImpl.FINDER_CACHE_ENABLED, TokenClientImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(TokenClientModelImpl.ENTITY_CACHE_ENABLED,
			TokenClientModelImpl.FINDER_CACHE_ENABLED, TokenClientImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
			new String[] { Long.class.getName() },
			TokenClientModelImpl.COMPANYID_COLUMN_BITMASK |
			TokenClientModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(TokenClientModelImpl.ENTITY_CACHE_ENABLED,
			TokenClientModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the token clients where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching token clients
	 */
	@Override
	public List<TokenClient> findByCompanyId(long companyId) {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<TokenClient> findByCompanyId(long companyId, int start, int end) {
		return findByCompanyId(companyId, start, end, null);
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
	@Override
	public List<TokenClient> findByCompanyId(long companyId, int start,
		int end, OrderByComparator<TokenClient> orderByComparator) {
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

		List<TokenClient> list = (List<TokenClient>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TokenClient tokenClient : list) {
				if ((companyId != tokenClient.getCompanyId())) {
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

			query.append(_SQL_SELECT_TOKENCLIENT_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TokenClientModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<TokenClient>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TokenClient>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first token client in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching token client
	 * @throws com.liferay.token.auth.NoSuchTokenClientException if a matching token client could not be found
	 */
	@Override
	public TokenClient findByCompanyId_First(long companyId,
		OrderByComparator<TokenClient> orderByComparator)
		throws NoSuchTokenClientException {
		TokenClient tokenClient = fetchByCompanyId_First(companyId,
				orderByComparator);

		if (tokenClient != null) {
			return tokenClient;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTokenClientException(msg.toString());
	}

	/**
	 * Returns the first token client in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching token client, or <code>null</code> if a matching token client could not be found
	 */
	@Override
	public TokenClient fetchByCompanyId_First(long companyId,
		OrderByComparator<TokenClient> orderByComparator) {
		List<TokenClient> list = findByCompanyId(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last token client in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching token client
	 * @throws com.liferay.token.auth.NoSuchTokenClientException if a matching token client could not be found
	 */
	@Override
	public TokenClient findByCompanyId_Last(long companyId,
		OrderByComparator<TokenClient> orderByComparator)
		throws NoSuchTokenClientException {
		TokenClient tokenClient = fetchByCompanyId_Last(companyId,
				orderByComparator);

		if (tokenClient != null) {
			return tokenClient;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTokenClientException(msg.toString());
	}

	/**
	 * Returns the last token client in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching token client, or <code>null</code> if a matching token client could not be found
	 */
	@Override
	public TokenClient fetchByCompanyId_Last(long companyId,
		OrderByComparator<TokenClient> orderByComparator) {
		int count = countByCompanyId(companyId);

		if (count == 0) {
			return null;
		}

		List<TokenClient> list = findByCompanyId(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TokenClient[] findByCompanyId_PrevAndNext(long clientId,
		long companyId, OrderByComparator<TokenClient> orderByComparator)
		throws NoSuchTokenClientException {
		TokenClient tokenClient = findByPrimaryKey(clientId);

		Session session = null;

		try {
			session = openSession();

			TokenClient[] array = new TokenClientImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, tokenClient,
					companyId, orderByComparator, true);

			array[1] = tokenClient;

			array[2] = getByCompanyId_PrevAndNext(session, tokenClient,
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

	protected TokenClient getByCompanyId_PrevAndNext(Session session,
		TokenClient tokenClient, long companyId,
		OrderByComparator<TokenClient> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TOKENCLIENT_WHERE);

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
			query.append(TokenClientModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tokenClient);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TokenClient> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the token clients that the user has permission to view where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching token clients that the user has permission to view
	 */
	@Override
	public List<TokenClient> filterFindByCompanyId(long companyId) {
		return filterFindByCompanyId(companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<TokenClient> filterFindByCompanyId(long companyId, int start,
		int end) {
		return filterFindByCompanyId(companyId, start, end, null);
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
	@Override
	public List<TokenClient> filterFindByCompanyId(long companyId, int start,
		int end, OrderByComparator<TokenClient> orderByComparator) {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByCompanyId(companyId, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(3 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TOKENCLIENT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TOKENCLIENT_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TOKENCLIENT_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator, true);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(TokenClientModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TokenClientModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TokenClient.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, TokenClientImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, TokenClientImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			return (List<TokenClient>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
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
	@Override
	public TokenClient[] filterFindByCompanyId_PrevAndNext(long clientId,
		long companyId, OrderByComparator<TokenClient> orderByComparator)
		throws NoSuchTokenClientException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByCompanyId_PrevAndNext(clientId, companyId,
				orderByComparator);
		}

		TokenClient tokenClient = findByPrimaryKey(clientId);

		Session session = null;

		try {
			session = openSession();

			TokenClient[] array = new TokenClientImpl[3];

			array[0] = filterGetByCompanyId_PrevAndNext(session, tokenClient,
					companyId, orderByComparator, true);

			array[1] = tokenClient;

			array[2] = filterGetByCompanyId_PrevAndNext(session, tokenClient,
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

	protected TokenClient filterGetByCompanyId_PrevAndNext(Session session,
		TokenClient tokenClient, long companyId,
		OrderByComparator<TokenClient> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TOKENCLIENT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TOKENCLIENT_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TOKENCLIENT_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
			if (getDB().isSupportsInlineDistinct()) {
				query.append(TokenClientModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TokenClientModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TokenClient.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		SQLQuery q = session.createSynchronizedSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, TokenClientImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, TokenClientImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tokenClient);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TokenClient> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the token clients where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	@Override
	public void removeByCompanyId(long companyId) {
		for (TokenClient tokenClient : findByCompanyId(companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(tokenClient);
		}
	}

	/**
	 * Returns the number of token clients where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching token clients
	 */
	@Override
	public int countByCompanyId(long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANYID;

		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TOKENCLIENT_WHERE);

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

	/**
	 * Returns the number of token clients that the user has permission to view where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching token clients that the user has permission to view
	 */
	@Override
	public int filterCountByCompanyId(long companyId) {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return countByCompanyId(companyId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_TOKENCLIENT_WHERE);

		query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TokenClient.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "tokenClient.companyId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_CLIENTKEY = new FinderPath(TokenClientModelImpl.ENTITY_CACHE_ENABLED,
			TokenClientModelImpl.FINDER_CACHE_ENABLED, TokenClientImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByClientKey",
			new String[] { String.class.getName() },
			TokenClientModelImpl.CLIENTKEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CLIENTKEY = new FinderPath(TokenClientModelImpl.ENTITY_CACHE_ENABLED,
			TokenClientModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByClientKey",
			new String[] { String.class.getName() });

	/**
	 * Returns the token client where clientKey = &#63; or throws a {@link com.liferay.token.auth.NoSuchTokenClientException} if it could not be found.
	 *
	 * @param clientKey the client key
	 * @return the matching token client
	 * @throws com.liferay.token.auth.NoSuchTokenClientException if a matching token client could not be found
	 */
	@Override
	public TokenClient findByClientKey(String clientKey)
		throws NoSuchTokenClientException {
		TokenClient tokenClient = fetchByClientKey(clientKey);

		if (tokenClient == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("clientKey=");
			msg.append(clientKey);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchTokenClientException(msg.toString());
		}

		return tokenClient;
	}

	/**
	 * Returns the token client where clientKey = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param clientKey the client key
	 * @return the matching token client, or <code>null</code> if a matching token client could not be found
	 */
	@Override
	public TokenClient fetchByClientKey(String clientKey) {
		return fetchByClientKey(clientKey, true);
	}

	/**
	 * Returns the token client where clientKey = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param clientKey the client key
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching token client, or <code>null</code> if a matching token client could not be found
	 */
	@Override
	public TokenClient fetchByClientKey(String clientKey,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { clientKey };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CLIENTKEY,
					finderArgs, this);
		}

		if (result instanceof TokenClient) {
			TokenClient tokenClient = (TokenClient)result;

			if (!Validator.equals(clientKey, tokenClient.getClientKey())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_TOKENCLIENT_WHERE);

			boolean bindClientKey = false;

			if (clientKey == null) {
				query.append(_FINDER_COLUMN_CLIENTKEY_CLIENTKEY_1);
			}
			else if (clientKey.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CLIENTKEY_CLIENTKEY_3);
			}
			else {
				bindClientKey = true;

				query.append(_FINDER_COLUMN_CLIENTKEY_CLIENTKEY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindClientKey) {
					qPos.add(clientKey);
				}

				List<TokenClient> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CLIENTKEY,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"TokenClientPersistenceImpl.fetchByClientKey(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					TokenClient tokenClient = list.get(0);

					result = tokenClient;

					cacheResult(tokenClient);

					if ((tokenClient.getClientKey() == null) ||
							!tokenClient.getClientKey().equals(clientKey)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CLIENTKEY,
							finderArgs, tokenClient);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CLIENTKEY,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (TokenClient)result;
		}
	}

	/**
	 * Removes the token client where clientKey = &#63; from the database.
	 *
	 * @param clientKey the client key
	 * @return the token client that was removed
	 */
	@Override
	public TokenClient removeByClientKey(String clientKey)
		throws NoSuchTokenClientException {
		TokenClient tokenClient = findByClientKey(clientKey);

		return remove(tokenClient);
	}

	/**
	 * Returns the number of token clients where clientKey = &#63;.
	 *
	 * @param clientKey the client key
	 * @return the number of matching token clients
	 */
	@Override
	public int countByClientKey(String clientKey) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CLIENTKEY;

		Object[] finderArgs = new Object[] { clientKey };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TOKENCLIENT_WHERE);

			boolean bindClientKey = false;

			if (clientKey == null) {
				query.append(_FINDER_COLUMN_CLIENTKEY_CLIENTKEY_1);
			}
			else if (clientKey.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CLIENTKEY_CLIENTKEY_3);
			}
			else {
				bindClientKey = true;

				query.append(_FINDER_COLUMN_CLIENTKEY_CLIENTKEY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindClientKey) {
					qPos.add(clientKey);
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

	private static final String _FINDER_COLUMN_CLIENTKEY_CLIENTKEY_1 = "tokenClient.clientKey IS NULL";
	private static final String _FINDER_COLUMN_CLIENTKEY_CLIENTKEY_2 = "tokenClient.clientKey = ?";
	private static final String _FINDER_COLUMN_CLIENTKEY_CLIENTKEY_3 = "(tokenClient.clientKey IS NULL OR tokenClient.clientKey = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME = new FinderPath(TokenClientModelImpl.ENTITY_CACHE_ENABLED,
			TokenClientModelImpl.FINDER_CACHE_ENABLED, TokenClientImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME = new FinderPath(TokenClientModelImpl.ENTITY_CACHE_ENABLED,
			TokenClientModelImpl.FINDER_CACHE_ENABLED, TokenClientImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByName",
			new String[] { String.class.getName() },
			TokenClientModelImpl.NAME_COLUMN_BITMASK |
			TokenClientModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(TokenClientModelImpl.ENTITY_CACHE_ENABLED,
			TokenClientModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the token clients where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching token clients
	 */
	@Override
	public List<TokenClient> findByName(String name) {
		return findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<TokenClient> findByName(String name, int start, int end) {
		return findByName(name, start, end, null);
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
	@Override
	public List<TokenClient> findByName(String name, int start, int end,
		OrderByComparator<TokenClient> orderByComparator) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME;
			finderArgs = new Object[] { name };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME;
			finderArgs = new Object[] { name, start, end, orderByComparator };
		}

		List<TokenClient> list = (List<TokenClient>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TokenClient tokenClient : list) {
				if (!Validator.equals(name, tokenClient.getName())) {
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

			query.append(_SQL_SELECT_TOKENCLIENT_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TokenClientModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(StringUtil.toLowerCase(name));
				}

				if (!pagination) {
					list = (List<TokenClient>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TokenClient>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first token client in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching token client
	 * @throws com.liferay.token.auth.NoSuchTokenClientException if a matching token client could not be found
	 */
	@Override
	public TokenClient findByName_First(String name,
		OrderByComparator<TokenClient> orderByComparator)
		throws NoSuchTokenClientException {
		TokenClient tokenClient = fetchByName_First(name, orderByComparator);

		if (tokenClient != null) {
			return tokenClient;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTokenClientException(msg.toString());
	}

	/**
	 * Returns the first token client in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching token client, or <code>null</code> if a matching token client could not be found
	 */
	@Override
	public TokenClient fetchByName_First(String name,
		OrderByComparator<TokenClient> orderByComparator) {
		List<TokenClient> list = findByName(name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last token client in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching token client
	 * @throws com.liferay.token.auth.NoSuchTokenClientException if a matching token client could not be found
	 */
	@Override
	public TokenClient findByName_Last(String name,
		OrderByComparator<TokenClient> orderByComparator)
		throws NoSuchTokenClientException {
		TokenClient tokenClient = fetchByName_Last(name, orderByComparator);

		if (tokenClient != null) {
			return tokenClient;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTokenClientException(msg.toString());
	}

	/**
	 * Returns the last token client in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching token client, or <code>null</code> if a matching token client could not be found
	 */
	@Override
	public TokenClient fetchByName_Last(String name,
		OrderByComparator<TokenClient> orderByComparator) {
		int count = countByName(name);

		if (count == 0) {
			return null;
		}

		List<TokenClient> list = findByName(name, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TokenClient[] findByName_PrevAndNext(long clientId, String name,
		OrderByComparator<TokenClient> orderByComparator)
		throws NoSuchTokenClientException {
		TokenClient tokenClient = findByPrimaryKey(clientId);

		Session session = null;

		try {
			session = openSession();

			TokenClient[] array = new TokenClientImpl[3];

			array[0] = getByName_PrevAndNext(session, tokenClient, name,
					orderByComparator, true);

			array[1] = tokenClient;

			array[2] = getByName_PrevAndNext(session, tokenClient, name,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TokenClient getByName_PrevAndNext(Session session,
		TokenClient tokenClient, String name,
		OrderByComparator<TokenClient> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TOKENCLIENT_WHERE);

		boolean bindName = false;

		if (name == null) {
			query.append(_FINDER_COLUMN_NAME_NAME_1);
		}
		else if (name.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_NAME_NAME_3);
		}
		else {
			bindName = true;

			query.append(_FINDER_COLUMN_NAME_NAME_2);
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
			query.append(TokenClientModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindName) {
			qPos.add(StringUtil.toLowerCase(name));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tokenClient);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TokenClient> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the token clients that the user has permission to view where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching token clients that the user has permission to view
	 */
	@Override
	public List<TokenClient> filterFindByName(String name) {
		return filterFindByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<TokenClient> filterFindByName(String name, int start, int end) {
		return filterFindByName(name, start, end, null);
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
	@Override
	public List<TokenClient> filterFindByName(String name, int start, int end,
		OrderByComparator<TokenClient> orderByComparator) {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByName(name, start, end, orderByComparator);
		}

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(3 +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TOKENCLIENT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TOKENCLIENT_NO_INLINE_DISTINCT_WHERE_1);
		}

		boolean bindName = false;

		if (name == null) {
			query.append(_FINDER_COLUMN_NAME_NAME_1);
		}
		else if (name.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_NAME_NAME_3);
		}
		else {
			bindName = true;

			query.append(_FINDER_COLUMN_NAME_NAME_2);
		}

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TOKENCLIENT_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator, true);
			}
			else {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_TABLE,
					orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				query.append(TokenClientModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TokenClientModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TokenClient.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, TokenClientImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, TokenClientImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			if (bindName) {
				qPos.add(StringUtil.toLowerCase(name));
			}

			return (List<TokenClient>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
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
	@Override
	public TokenClient[] filterFindByName_PrevAndNext(long clientId,
		String name, OrderByComparator<TokenClient> orderByComparator)
		throws NoSuchTokenClientException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByName_PrevAndNext(clientId, name, orderByComparator);
		}

		TokenClient tokenClient = findByPrimaryKey(clientId);

		Session session = null;

		try {
			session = openSession();

			TokenClient[] array = new TokenClientImpl[3];

			array[0] = filterGetByName_PrevAndNext(session, tokenClient, name,
					orderByComparator, true);

			array[1] = tokenClient;

			array[2] = filterGetByName_PrevAndNext(session, tokenClient, name,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TokenClient filterGetByName_PrevAndNext(Session session,
		TokenClient tokenClient, String name,
		OrderByComparator<TokenClient> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TOKENCLIENT_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TOKENCLIENT_NO_INLINE_DISTINCT_WHERE_1);
		}

		boolean bindName = false;

		if (name == null) {
			query.append(_FINDER_COLUMN_NAME_NAME_1);
		}
		else if (name.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_NAME_NAME_3);
		}
		else {
			bindName = true;

			query.append(_FINDER_COLUMN_NAME_NAME_2);
		}

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TOKENCLIENT_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
				if (getDB().isSupportsInlineDistinct()) {
					query.append(_ORDER_BY_ENTITY_ALIAS);
				}
				else {
					query.append(_ORDER_BY_ENTITY_TABLE);
				}

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
			if (getDB().isSupportsInlineDistinct()) {
				query.append(TokenClientModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TokenClientModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TokenClient.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		SQLQuery q = session.createSynchronizedSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, TokenClientImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, TokenClientImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindName) {
			qPos.add(StringUtil.toLowerCase(name));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tokenClient);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TokenClient> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the token clients where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	@Override
	public void removeByName(String name) {
		for (TokenClient tokenClient : findByName(name, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(tokenClient);
		}
	}

	/**
	 * Returns the number of token clients where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching token clients
	 */
	@Override
	public int countByName(String name) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NAME;

		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TOKENCLIENT_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(StringUtil.toLowerCase(name));
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
	 * Returns the number of token clients that the user has permission to view where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching token clients that the user has permission to view
	 */
	@Override
	public int filterCountByName(String name) {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return countByName(name);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_TOKENCLIENT_WHERE);

		boolean bindName = false;

		if (name == null) {
			query.append(_FINDER_COLUMN_NAME_NAME_1);
		}
		else if (name.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_NAME_NAME_3);
		}
		else {
			bindName = true;

			query.append(_FINDER_COLUMN_NAME_NAME_2);
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TokenClient.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			if (bindName) {
				qPos.add(StringUtil.toLowerCase(name));
			}

			Long count = (Long)q.uniqueResult();

			return count.intValue();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_NAME_NAME_1 = "tokenClient.name IS NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "lower(tokenClient.name) = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(tokenClient.name IS NULL OR tokenClient.name = '')";

	public TokenClientPersistenceImpl() {
		setModelClass(TokenClient.class);
	}

	/**
	 * Caches the token client in the entity cache if it is enabled.
	 *
	 * @param tokenClient the token client
	 */
	@Override
	public void cacheResult(TokenClient tokenClient) {
		EntityCacheUtil.putResult(TokenClientModelImpl.ENTITY_CACHE_ENABLED,
			TokenClientImpl.class, tokenClient.getPrimaryKey(), tokenClient);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CLIENTKEY,
			new Object[] { tokenClient.getClientKey() }, tokenClient);

		tokenClient.resetOriginalValues();
	}

	/**
	 * Caches the token clients in the entity cache if it is enabled.
	 *
	 * @param tokenClients the token clients
	 */
	@Override
	public void cacheResult(List<TokenClient> tokenClients) {
		for (TokenClient tokenClient : tokenClients) {
			if (EntityCacheUtil.getResult(
						TokenClientModelImpl.ENTITY_CACHE_ENABLED,
						TokenClientImpl.class, tokenClient.getPrimaryKey()) == null) {
				cacheResult(tokenClient);
			}
			else {
				tokenClient.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all token clients.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TokenClientImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TokenClientImpl.class);

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the token client.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TokenClient tokenClient) {
		EntityCacheUtil.removeResult(TokenClientModelImpl.ENTITY_CACHE_ENABLED,
			TokenClientImpl.class, tokenClient.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(tokenClient);
	}

	@Override
	public void clearCache(List<TokenClient> tokenClients) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TokenClient tokenClient : tokenClients) {
			EntityCacheUtil.removeResult(TokenClientModelImpl.ENTITY_CACHE_ENABLED,
				TokenClientImpl.class, tokenClient.getPrimaryKey());

			clearUniqueFindersCache(tokenClient);
		}
	}

	protected void cacheUniqueFindersCache(TokenClient tokenClient) {
		if (tokenClient.isNew()) {
			Object[] args = new Object[] { tokenClient.getClientKey() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CLIENTKEY, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CLIENTKEY, args,
				tokenClient);
		}
		else {
			TokenClientModelImpl tokenClientModelImpl = (TokenClientModelImpl)tokenClient;

			if ((tokenClientModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CLIENTKEY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { tokenClient.getClientKey() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CLIENTKEY, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CLIENTKEY, args,
					tokenClient);
			}
		}
	}

	protected void clearUniqueFindersCache(TokenClient tokenClient) {
		TokenClientModelImpl tokenClientModelImpl = (TokenClientModelImpl)tokenClient;

		Object[] args = new Object[] { tokenClient.getClientKey() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CLIENTKEY, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CLIENTKEY, args);

		if ((tokenClientModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CLIENTKEY.getColumnBitmask()) != 0) {
			args = new Object[] { tokenClientModelImpl.getOriginalClientKey() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CLIENTKEY, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CLIENTKEY, args);
		}
	}

	/**
	 * Creates a new token client with the primary key. Does not add the token client to the database.
	 *
	 * @param clientId the primary key for the new token client
	 * @return the new token client
	 */
	@Override
	public TokenClient create(long clientId) {
		TokenClient tokenClient = new TokenClientImpl();

		tokenClient.setNew(true);
		tokenClient.setPrimaryKey(clientId);

		return tokenClient;
	}

	/**
	 * Removes the token client with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param clientId the primary key of the token client
	 * @return the token client that was removed
	 * @throws com.liferay.token.auth.NoSuchTokenClientException if a token client with the primary key could not be found
	 */
	@Override
	public TokenClient remove(long clientId) throws NoSuchTokenClientException {
		return remove((Serializable)clientId);
	}

	/**
	 * Removes the token client with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the token client
	 * @return the token client that was removed
	 * @throws com.liferay.token.auth.NoSuchTokenClientException if a token client with the primary key could not be found
	 */
	@Override
	public TokenClient remove(Serializable primaryKey)
		throws NoSuchTokenClientException {
		Session session = null;

		try {
			session = openSession();

			TokenClient tokenClient = (TokenClient)session.get(TokenClientImpl.class,
					primaryKey);

			if (tokenClient == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTokenClientException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(tokenClient);
		}
		catch (NoSuchTokenClientException nsee) {
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
	protected TokenClient removeImpl(TokenClient tokenClient) {
		tokenClient = toUnwrappedModel(tokenClient);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(tokenClient)) {
				tokenClient = (TokenClient)session.get(TokenClientImpl.class,
						tokenClient.getPrimaryKeyObj());
			}

			if (tokenClient != null) {
				session.delete(tokenClient);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (tokenClient != null) {
			clearCache(tokenClient);
		}

		return tokenClient;
	}

	@Override
	public TokenClient updateImpl(
		com.liferay.token.auth.model.TokenClient tokenClient) {
		tokenClient = toUnwrappedModel(tokenClient);

		boolean isNew = tokenClient.isNew();

		TokenClientModelImpl tokenClientModelImpl = (TokenClientModelImpl)tokenClient;

		Session session = null;

		try {
			session = openSession();

			if (tokenClient.isNew()) {
				session.save(tokenClient);

				tokenClient.setNew(false);
			}
			else {
				session.merge(tokenClient);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TokenClientModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((tokenClientModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						tokenClientModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);

				args = new Object[] { tokenClientModelImpl.getCompanyId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);
			}

			if ((tokenClientModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						tokenClientModelImpl.getOriginalName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);

				args = new Object[] { tokenClientModelImpl.getName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);
			}
		}

		EntityCacheUtil.putResult(TokenClientModelImpl.ENTITY_CACHE_ENABLED,
			TokenClientImpl.class, tokenClient.getPrimaryKey(), tokenClient,
			false);

		clearUniqueFindersCache(tokenClient);
		cacheUniqueFindersCache(tokenClient);

		tokenClient.resetOriginalValues();

		return tokenClient;
	}

	protected TokenClient toUnwrappedModel(TokenClient tokenClient) {
		if (tokenClient instanceof TokenClientImpl) {
			return tokenClient;
		}

		TokenClientImpl tokenClientImpl = new TokenClientImpl();

		tokenClientImpl.setNew(tokenClient.isNew());
		tokenClientImpl.setPrimaryKey(tokenClient.getPrimaryKey());

		tokenClientImpl.setClientId(tokenClient.getClientId());
		tokenClientImpl.setCompanyId(tokenClient.getCompanyId());
		tokenClientImpl.setUserId(tokenClient.getUserId());
		tokenClientImpl.setUserName(tokenClient.getUserName());
		tokenClientImpl.setCreateDate(tokenClient.getCreateDate());
		tokenClientImpl.setModifiedDate(tokenClient.getModifiedDate());
		tokenClientImpl.setName(tokenClient.getName());
		tokenClientImpl.setDescription(tokenClient.getDescription());
		tokenClientImpl.setClientKey(tokenClient.getClientKey());
		tokenClientImpl.setClientSecrets(tokenClient.getClientSecrets());
		tokenClientImpl.setRevoked(tokenClient.isRevoked());
		tokenClientImpl.setAclProfiles(tokenClient.getAclProfiles());
		tokenClientImpl.setTokenVerifierId(tokenClient.getTokenVerifierId());
		tokenClientImpl.setCallbackURI(tokenClient.getCallbackURI());
		tokenClientImpl.setWebsiteURL(tokenClient.getWebsiteURL());
		tokenClientImpl.setAdditionalInfo(tokenClient.getAdditionalInfo());

		return tokenClientImpl;
	}

	/**
	 * Returns the token client with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the token client
	 * @return the token client
	 * @throws com.liferay.token.auth.NoSuchTokenClientException if a token client with the primary key could not be found
	 */
	@Override
	public TokenClient findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTokenClientException {
		TokenClient tokenClient = fetchByPrimaryKey(primaryKey);

		if (tokenClient == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTokenClientException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return tokenClient;
	}

	/**
	 * Returns the token client with the primary key or throws a {@link com.liferay.token.auth.NoSuchTokenClientException} if it could not be found.
	 *
	 * @param clientId the primary key of the token client
	 * @return the token client
	 * @throws com.liferay.token.auth.NoSuchTokenClientException if a token client with the primary key could not be found
	 */
	@Override
	public TokenClient findByPrimaryKey(long clientId)
		throws NoSuchTokenClientException {
		return findByPrimaryKey((Serializable)clientId);
	}

	/**
	 * Returns the token client with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the token client
	 * @return the token client, or <code>null</code> if a token client with the primary key could not be found
	 */
	@Override
	public TokenClient fetchByPrimaryKey(Serializable primaryKey) {
		TokenClient tokenClient = (TokenClient)EntityCacheUtil.getResult(TokenClientModelImpl.ENTITY_CACHE_ENABLED,
				TokenClientImpl.class, primaryKey);

		if (tokenClient == _nullTokenClient) {
			return null;
		}

		if (tokenClient == null) {
			Session session = null;

			try {
				session = openSession();

				tokenClient = (TokenClient)session.get(TokenClientImpl.class,
						primaryKey);

				if (tokenClient != null) {
					cacheResult(tokenClient);
				}
				else {
					EntityCacheUtil.putResult(TokenClientModelImpl.ENTITY_CACHE_ENABLED,
						TokenClientImpl.class, primaryKey, _nullTokenClient);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(TokenClientModelImpl.ENTITY_CACHE_ENABLED,
					TokenClientImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return tokenClient;
	}

	/**
	 * Returns the token client with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param clientId the primary key of the token client
	 * @return the token client, or <code>null</code> if a token client with the primary key could not be found
	 */
	@Override
	public TokenClient fetchByPrimaryKey(long clientId) {
		return fetchByPrimaryKey((Serializable)clientId);
	}

	@Override
	public Map<Serializable, TokenClient> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, TokenClient> map = new HashMap<Serializable, TokenClient>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			TokenClient tokenClient = fetchByPrimaryKey(primaryKey);

			if (tokenClient != null) {
				map.put(primaryKey, tokenClient);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			TokenClient tokenClient = (TokenClient)EntityCacheUtil.getResult(TokenClientModelImpl.ENTITY_CACHE_ENABLED,
					TokenClientImpl.class, primaryKey);

			if (tokenClient == null) {
				if (uncachedPrimaryKeys == null) {
					uncachedPrimaryKeys = new HashSet<Serializable>();
				}

				uncachedPrimaryKeys.add(primaryKey);
			}
			else {
				map.put(primaryKey, tokenClient);
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_TOKENCLIENT_WHERE_PKS_IN);

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

			for (TokenClient tokenClient : (List<TokenClient>)q.list()) {
				map.put(tokenClient.getPrimaryKeyObj(), tokenClient);

				cacheResult(tokenClient);

				uncachedPrimaryKeys.remove(tokenClient.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				EntityCacheUtil.putResult(TokenClientModelImpl.ENTITY_CACHE_ENABLED,
					TokenClientImpl.class, primaryKey, _nullTokenClient);
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
	 * Returns all the token clients.
	 *
	 * @return the token clients
	 */
	@Override
	public List<TokenClient> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<TokenClient> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<TokenClient> findAll(int start, int end,
		OrderByComparator<TokenClient> orderByComparator) {
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

		List<TokenClient> list = (List<TokenClient>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TOKENCLIENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TOKENCLIENT;

				if (pagination) {
					sql = sql.concat(TokenClientModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TokenClient>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TokenClient>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the token clients from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TokenClient tokenClient : findAll()) {
			remove(tokenClient);
		}
	}

	/**
	 * Returns the number of token clients.
	 *
	 * @return the number of token clients
	 */
	@Override
	public int countAll() {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TOKENCLIENT);

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
	 * Initializes the token client persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		EntityCacheUtil.removeCache(TokenClientImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_TOKENCLIENT = "SELECT tokenClient FROM TokenClient tokenClient";
	private static final String _SQL_SELECT_TOKENCLIENT_WHERE_PKS_IN = "SELECT tokenClient FROM TokenClient tokenClient WHERE clientId IN (";
	private static final String _SQL_SELECT_TOKENCLIENT_WHERE = "SELECT tokenClient FROM TokenClient tokenClient WHERE ";
	private static final String _SQL_COUNT_TOKENCLIENT = "SELECT COUNT(tokenClient) FROM TokenClient tokenClient";
	private static final String _SQL_COUNT_TOKENCLIENT_WHERE = "SELECT COUNT(tokenClient) FROM TokenClient tokenClient WHERE ";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "tokenClient.clientId";
	private static final String _FILTER_SQL_SELECT_TOKENCLIENT_WHERE = "SELECT DISTINCT {tokenClient.*} FROM TokenAuth_TokenClient tokenClient WHERE ";
	private static final String _FILTER_SQL_SELECT_TOKENCLIENT_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {TokenAuth_TokenClient.*} FROM (SELECT DISTINCT tokenClient.clientId FROM TokenAuth_TokenClient tokenClient WHERE ";
	private static final String _FILTER_SQL_SELECT_TOKENCLIENT_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN TokenAuth_TokenClient ON TEMP_TABLE.clientId = TokenAuth_TokenClient.clientId";
	private static final String _FILTER_SQL_COUNT_TOKENCLIENT_WHERE = "SELECT COUNT(DISTINCT tokenClient.clientId) AS COUNT_VALUE FROM TokenAuth_TokenClient tokenClient WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "tokenClient";
	private static final String _FILTER_ENTITY_TABLE = "TokenAuth_TokenClient";
	private static final String _ORDER_BY_ENTITY_ALIAS = "tokenClient.";
	private static final String _ORDER_BY_ENTITY_TABLE = "TokenAuth_TokenClient.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TokenClient exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TokenClient exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = com.liferay.portal.util.PropsValues.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE;
	private static final Log _log = LogFactoryUtil.getLog(TokenClientPersistenceImpl.class);
	private static final TokenClient _nullTokenClient = new TokenClientImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TokenClient> toCacheModel() {
				return _nullTokenClientCacheModel;
			}
		};

	private static final CacheModel<TokenClient> _nullTokenClientCacheModel = new CacheModel<TokenClient>() {
			@Override
			public TokenClient toEntityModel() {
				return _nullTokenClient;
			}
		};
}