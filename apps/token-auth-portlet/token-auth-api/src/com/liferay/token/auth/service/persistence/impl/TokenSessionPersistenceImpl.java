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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.token.auth.exception.NoSuchTokenSessionException;
import com.liferay.token.auth.model.TokenSession;
import com.liferay.token.auth.model.impl.TokenSessionImpl;
import com.liferay.token.auth.model.impl.TokenSessionModelImpl;
import com.liferay.token.auth.service.persistence.TokenSessionPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the token session service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TokenSessionPersistence
 * @see TokenSessionUtil
 * @generated
 */
@ProviderType
public class TokenSessionPersistenceImpl extends BasePersistenceImpl<TokenSession>
	implements TokenSessionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TokenSessionUtil} to access the token session persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TokenSessionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TokenSessionModelImpl.ENTITY_CACHE_ENABLED,
			TokenSessionModelImpl.FINDER_CACHE_ENABLED, TokenSessionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TokenSessionModelImpl.ENTITY_CACHE_ENABLED,
			TokenSessionModelImpl.FINDER_CACHE_ENABLED, TokenSessionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TokenSessionModelImpl.ENTITY_CACHE_ENABLED,
			TokenSessionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(TokenSessionModelImpl.ENTITY_CACHE_ENABLED,
			TokenSessionModelImpl.FINDER_CACHE_ENABLED, TokenSessionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(TokenSessionModelImpl.ENTITY_CACHE_ENABLED,
			TokenSessionModelImpl.FINDER_CACHE_ENABLED, TokenSessionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
			new String[] { Long.class.getName() },
			TokenSessionModelImpl.COMPANYID_COLUMN_BITMASK |
			TokenSessionModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(TokenSessionModelImpl.ENTITY_CACHE_ENABLED,
			TokenSessionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the token sessions where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching token sessions
	 */
	@Override
	public List<TokenSession> findByCompanyId(long companyId) {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<TokenSession> findByCompanyId(long companyId, int start, int end) {
		return findByCompanyId(companyId, start, end, null);
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
	@Override
	public List<TokenSession> findByCompanyId(long companyId, int start,
		int end, OrderByComparator<TokenSession> orderByComparator) {
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

		List<TokenSession> list = (List<TokenSession>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TokenSession tokenSession : list) {
				if ((companyId != tokenSession.getCompanyId())) {
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

			query.append(_SQL_SELECT_TOKENSESSION_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TokenSessionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<TokenSession>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TokenSession>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first token session in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching token session
	 * @throws com.liferay.token.auth.NoSuchTokenSessionException if a matching token session could not be found
	 */
	@Override
	public TokenSession findByCompanyId_First(long companyId,
		OrderByComparator<TokenSession> orderByComparator)
		throws NoSuchTokenSessionException {
		TokenSession tokenSession = fetchByCompanyId_First(companyId,
				orderByComparator);

		if (tokenSession != null) {
			return tokenSession;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTokenSessionException(msg.toString());
	}

	/**
	 * Returns the first token session in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching token session, or <code>null</code> if a matching token session could not be found
	 */
	@Override
	public TokenSession fetchByCompanyId_First(long companyId,
		OrderByComparator<TokenSession> orderByComparator) {
		List<TokenSession> list = findByCompanyId(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last token session in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching token session
	 * @throws com.liferay.token.auth.NoSuchTokenSessionException if a matching token session could not be found
	 */
	@Override
	public TokenSession findByCompanyId_Last(long companyId,
		OrderByComparator<TokenSession> orderByComparator)
		throws NoSuchTokenSessionException {
		TokenSession tokenSession = fetchByCompanyId_Last(companyId,
				orderByComparator);

		if (tokenSession != null) {
			return tokenSession;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTokenSessionException(msg.toString());
	}

	/**
	 * Returns the last token session in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching token session, or <code>null</code> if a matching token session could not be found
	 */
	@Override
	public TokenSession fetchByCompanyId_Last(long companyId,
		OrderByComparator<TokenSession> orderByComparator) {
		int count = countByCompanyId(companyId);

		if (count == 0) {
			return null;
		}

		List<TokenSession> list = findByCompanyId(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TokenSession[] findByCompanyId_PrevAndNext(long sessionId,
		long companyId, OrderByComparator<TokenSession> orderByComparator)
		throws NoSuchTokenSessionException {
		TokenSession tokenSession = findByPrimaryKey(sessionId);

		Session session = null;

		try {
			session = openSession();

			TokenSession[] array = new TokenSessionImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, tokenSession,
					companyId, orderByComparator, true);

			array[1] = tokenSession;

			array[2] = getByCompanyId_PrevAndNext(session, tokenSession,
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

	protected TokenSession getByCompanyId_PrevAndNext(Session session,
		TokenSession tokenSession, long companyId,
		OrderByComparator<TokenSession> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TOKENSESSION_WHERE);

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
			query.append(TokenSessionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tokenSession);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TokenSession> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the token sessions that the user has permission to view where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching token sessions that the user has permission to view
	 */
	@Override
	public List<TokenSession> filterFindByCompanyId(long companyId) {
		return filterFindByCompanyId(companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<TokenSession> filterFindByCompanyId(long companyId, int start,
		int end) {
		return filterFindByCompanyId(companyId, start, end, null);
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
	@Override
	public List<TokenSession> filterFindByCompanyId(long companyId, int start,
		int end, OrderByComparator<TokenSession> orderByComparator) {
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
			query.append(_FILTER_SQL_SELECT_TOKENSESSION_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TOKENSESSION_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TOKENSESSION_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(TokenSessionModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TokenSessionModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TokenSession.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, TokenSessionImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, TokenSessionImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			return (List<TokenSession>)QueryUtil.list(q, getDialect(), start,
				end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
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
	@Override
	public TokenSession[] filterFindByCompanyId_PrevAndNext(long sessionId,
		long companyId, OrderByComparator<TokenSession> orderByComparator)
		throws NoSuchTokenSessionException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByCompanyId_PrevAndNext(sessionId, companyId,
				orderByComparator);
		}

		TokenSession tokenSession = findByPrimaryKey(sessionId);

		Session session = null;

		try {
			session = openSession();

			TokenSession[] array = new TokenSessionImpl[3];

			array[0] = filterGetByCompanyId_PrevAndNext(session, tokenSession,
					companyId, orderByComparator, true);

			array[1] = tokenSession;

			array[2] = filterGetByCompanyId_PrevAndNext(session, tokenSession,
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

	protected TokenSession filterGetByCompanyId_PrevAndNext(Session session,
		TokenSession tokenSession, long companyId,
		OrderByComparator<TokenSession> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TOKENSESSION_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TOKENSESSION_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TOKENSESSION_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(TokenSessionModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TokenSessionModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TokenSession.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		SQLQuery q = session.createSynchronizedSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, TokenSessionImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, TokenSessionImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tokenSession);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TokenSession> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the token sessions where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	@Override
	public void removeByCompanyId(long companyId) {
		for (TokenSession tokenSession : findByCompanyId(companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(tokenSession);
		}
	}

	/**
	 * Returns the number of token sessions where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching token sessions
	 */
	@Override
	public int countByCompanyId(long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANYID;

		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TOKENSESSION_WHERE);

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
	 * Returns the number of token sessions that the user has permission to view where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching token sessions that the user has permission to view
	 */
	@Override
	public int filterCountByCompanyId(long companyId) {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return countByCompanyId(companyId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_TOKENSESSION_WHERE);

		query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TokenSession.class.getName(),
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

	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "tokenSession.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CLIENTID = new FinderPath(TokenSessionModelImpl.ENTITY_CACHE_ENABLED,
			TokenSessionModelImpl.FINDER_CACHE_ENABLED, TokenSessionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByClientId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLIENTID =
		new FinderPath(TokenSessionModelImpl.ENTITY_CACHE_ENABLED,
			TokenSessionModelImpl.FINDER_CACHE_ENABLED, TokenSessionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByClientId",
			new String[] { Long.class.getName() },
			TokenSessionModelImpl.CLIENTID_COLUMN_BITMASK |
			TokenSessionModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CLIENTID = new FinderPath(TokenSessionModelImpl.ENTITY_CACHE_ENABLED,
			TokenSessionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByClientId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the token sessions where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @return the matching token sessions
	 */
	@Override
	public List<TokenSession> findByClientId(long clientId) {
		return findByClientId(clientId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<TokenSession> findByClientId(long clientId, int start, int end) {
		return findByClientId(clientId, start, end, null);
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
	@Override
	public List<TokenSession> findByClientId(long clientId, int start, int end,
		OrderByComparator<TokenSession> orderByComparator) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLIENTID;
			finderArgs = new Object[] { clientId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CLIENTID;
			finderArgs = new Object[] { clientId, start, end, orderByComparator };
		}

		List<TokenSession> list = (List<TokenSession>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TokenSession tokenSession : list) {
				if ((clientId != tokenSession.getClientId())) {
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

			query.append(_SQL_SELECT_TOKENSESSION_WHERE);

			query.append(_FINDER_COLUMN_CLIENTID_CLIENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TokenSessionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(clientId);

				if (!pagination) {
					list = (List<TokenSession>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TokenSession>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first token session in the ordered set where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching token session
	 * @throws com.liferay.token.auth.NoSuchTokenSessionException if a matching token session could not be found
	 */
	@Override
	public TokenSession findByClientId_First(long clientId,
		OrderByComparator<TokenSession> orderByComparator)
		throws NoSuchTokenSessionException {
		TokenSession tokenSession = fetchByClientId_First(clientId,
				orderByComparator);

		if (tokenSession != null) {
			return tokenSession;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("clientId=");
		msg.append(clientId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTokenSessionException(msg.toString());
	}

	/**
	 * Returns the first token session in the ordered set where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching token session, or <code>null</code> if a matching token session could not be found
	 */
	@Override
	public TokenSession fetchByClientId_First(long clientId,
		OrderByComparator<TokenSession> orderByComparator) {
		List<TokenSession> list = findByClientId(clientId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last token session in the ordered set where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching token session
	 * @throws com.liferay.token.auth.NoSuchTokenSessionException if a matching token session could not be found
	 */
	@Override
	public TokenSession findByClientId_Last(long clientId,
		OrderByComparator<TokenSession> orderByComparator)
		throws NoSuchTokenSessionException {
		TokenSession tokenSession = fetchByClientId_Last(clientId,
				orderByComparator);

		if (tokenSession != null) {
			return tokenSession;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("clientId=");
		msg.append(clientId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTokenSessionException(msg.toString());
	}

	/**
	 * Returns the last token session in the ordered set where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching token session, or <code>null</code> if a matching token session could not be found
	 */
	@Override
	public TokenSession fetchByClientId_Last(long clientId,
		OrderByComparator<TokenSession> orderByComparator) {
		int count = countByClientId(clientId);

		if (count == 0) {
			return null;
		}

		List<TokenSession> list = findByClientId(clientId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TokenSession[] findByClientId_PrevAndNext(long sessionId,
		long clientId, OrderByComparator<TokenSession> orderByComparator)
		throws NoSuchTokenSessionException {
		TokenSession tokenSession = findByPrimaryKey(sessionId);

		Session session = null;

		try {
			session = openSession();

			TokenSession[] array = new TokenSessionImpl[3];

			array[0] = getByClientId_PrevAndNext(session, tokenSession,
					clientId, orderByComparator, true);

			array[1] = tokenSession;

			array[2] = getByClientId_PrevAndNext(session, tokenSession,
					clientId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TokenSession getByClientId_PrevAndNext(Session session,
		TokenSession tokenSession, long clientId,
		OrderByComparator<TokenSession> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TOKENSESSION_WHERE);

		query.append(_FINDER_COLUMN_CLIENTID_CLIENTID_2);

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
			query.append(TokenSessionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(clientId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tokenSession);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TokenSession> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the token sessions that the user has permission to view where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @return the matching token sessions that the user has permission to view
	 */
	@Override
	public List<TokenSession> filterFindByClientId(long clientId) {
		return filterFindByClientId(clientId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<TokenSession> filterFindByClientId(long clientId, int start,
		int end) {
		return filterFindByClientId(clientId, start, end, null);
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
	@Override
	public List<TokenSession> filterFindByClientId(long clientId, int start,
		int end, OrderByComparator<TokenSession> orderByComparator) {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByClientId(clientId, start, end, orderByComparator);
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
			query.append(_FILTER_SQL_SELECT_TOKENSESSION_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TOKENSESSION_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_CLIENTID_CLIENTID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TOKENSESSION_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(TokenSessionModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TokenSessionModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TokenSession.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				q.addEntity(_FILTER_ENTITY_ALIAS, TokenSessionImpl.class);
			}
			else {
				q.addEntity(_FILTER_ENTITY_TABLE, TokenSessionImpl.class);
			}

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(clientId);

			return (List<TokenSession>)QueryUtil.list(q, getDialect(), start,
				end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
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
	@Override
	public TokenSession[] filterFindByClientId_PrevAndNext(long sessionId,
		long clientId, OrderByComparator<TokenSession> orderByComparator)
		throws NoSuchTokenSessionException {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return findByClientId_PrevAndNext(sessionId, clientId,
				orderByComparator);
		}

		TokenSession tokenSession = findByPrimaryKey(sessionId);

		Session session = null;

		try {
			session = openSession();

			TokenSession[] array = new TokenSessionImpl[3];

			array[0] = filterGetByClientId_PrevAndNext(session, tokenSession,
					clientId, orderByComparator, true);

			array[1] = tokenSession;

			array[2] = filterGetByClientId_PrevAndNext(session, tokenSession,
					clientId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TokenSession filterGetByClientId_PrevAndNext(Session session,
		TokenSession tokenSession, long clientId,
		OrderByComparator<TokenSession> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		if (getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TOKENSESSION_WHERE);
		}
		else {
			query.append(_FILTER_SQL_SELECT_TOKENSESSION_NO_INLINE_DISTINCT_WHERE_1);
		}

		query.append(_FINDER_COLUMN_CLIENTID_CLIENTID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			query.append(_FILTER_SQL_SELECT_TOKENSESSION_NO_INLINE_DISTINCT_WHERE_2);
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
				query.append(TokenSessionModelImpl.ORDER_BY_JPQL);
			}
			else {
				query.append(TokenSessionModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TokenSession.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		SQLQuery q = session.createSynchronizedSQLQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			q.addEntity(_FILTER_ENTITY_ALIAS, TokenSessionImpl.class);
		}
		else {
			q.addEntity(_FILTER_ENTITY_TABLE, TokenSessionImpl.class);
		}

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(clientId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tokenSession);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TokenSession> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the token sessions where clientId = &#63; from the database.
	 *
	 * @param clientId the client ID
	 */
	@Override
	public void removeByClientId(long clientId) {
		for (TokenSession tokenSession : findByClientId(clientId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(tokenSession);
		}
	}

	/**
	 * Returns the number of token sessions where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @return the number of matching token sessions
	 */
	@Override
	public int countByClientId(long clientId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CLIENTID;

		Object[] finderArgs = new Object[] { clientId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TOKENSESSION_WHERE);

			query.append(_FINDER_COLUMN_CLIENTID_CLIENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(clientId);

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
	 * Returns the number of token sessions that the user has permission to view where clientId = &#63;.
	 *
	 * @param clientId the client ID
	 * @return the number of matching token sessions that the user has permission to view
	 */
	@Override
	public int filterCountByClientId(long clientId) {
		if (!InlineSQLHelperUtil.isEnabled()) {
			return countByClientId(clientId);
		}

		StringBundler query = new StringBundler(2);

		query.append(_FILTER_SQL_COUNT_TOKENSESSION_WHERE);

		query.append(_FINDER_COLUMN_CLIENTID_CLIENTID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(query.toString(),
				TokenSession.class.getName(),
				_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN);

		Session session = null;

		try {
			session = openSession();

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME,
				com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(clientId);

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

	private static final String _FINDER_COLUMN_CLIENTID_CLIENTID_2 = "tokenSession.clientId = ?";

	public TokenSessionPersistenceImpl() {
		setModelClass(TokenSession.class);
	}

	/**
	 * Caches the token session in the entity cache if it is enabled.
	 *
	 * @param tokenSession the token session
	 */
	@Override
	public void cacheResult(TokenSession tokenSession) {
		EntityCacheUtil.putResult(TokenSessionModelImpl.ENTITY_CACHE_ENABLED,
			TokenSessionImpl.class, tokenSession.getPrimaryKey(), tokenSession);

		tokenSession.resetOriginalValues();
	}

	/**
	 * Caches the token sessions in the entity cache if it is enabled.
	 *
	 * @param tokenSessions the token sessions
	 */
	@Override
	public void cacheResult(List<TokenSession> tokenSessions) {
		for (TokenSession tokenSession : tokenSessions) {
			if (EntityCacheUtil.getResult(
						TokenSessionModelImpl.ENTITY_CACHE_ENABLED,
						TokenSessionImpl.class, tokenSession.getPrimaryKey()) == null) {
				cacheResult(tokenSession);
			}
			else {
				tokenSession.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all token sessions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TokenSessionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TokenSessionImpl.class);

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the token session.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TokenSession tokenSession) {
		EntityCacheUtil.removeResult(TokenSessionModelImpl.ENTITY_CACHE_ENABLED,
			TokenSessionImpl.class, tokenSession.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TokenSession> tokenSessions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TokenSession tokenSession : tokenSessions) {
			EntityCacheUtil.removeResult(TokenSessionModelImpl.ENTITY_CACHE_ENABLED,
				TokenSessionImpl.class, tokenSession.getPrimaryKey());
		}
	}

	/**
	 * Creates a new token session with the primary key. Does not add the token session to the database.
	 *
	 * @param sessionId the primary key for the new token session
	 * @return the new token session
	 */
	@Override
	public TokenSession create(long sessionId) {
		TokenSession tokenSession = new TokenSessionImpl();

		tokenSession.setNew(true);
		tokenSession.setPrimaryKey(sessionId);

		return tokenSession;
	}

	/**
	 * Removes the token session with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sessionId the primary key of the token session
	 * @return the token session that was removed
	 * @throws com.liferay.token.auth.NoSuchTokenSessionException if a token session with the primary key could not be found
	 */
	@Override
	public TokenSession remove(long sessionId)
		throws NoSuchTokenSessionException {
		return remove((Serializable)sessionId);
	}

	/**
	 * Removes the token session with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the token session
	 * @return the token session that was removed
	 * @throws com.liferay.token.auth.NoSuchTokenSessionException if a token session with the primary key could not be found
	 */
	@Override
	public TokenSession remove(Serializable primaryKey)
		throws NoSuchTokenSessionException {
		Session session = null;

		try {
			session = openSession();

			TokenSession tokenSession = (TokenSession)session.get(TokenSessionImpl.class,
					primaryKey);

			if (tokenSession == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTokenSessionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(tokenSession);
		}
		catch (NoSuchTokenSessionException nsee) {
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
	protected TokenSession removeImpl(TokenSession tokenSession) {
		tokenSession = toUnwrappedModel(tokenSession);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(tokenSession)) {
				tokenSession = (TokenSession)session.get(TokenSessionImpl.class,
						tokenSession.getPrimaryKeyObj());
			}

			if (tokenSession != null) {
				session.delete(tokenSession);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (tokenSession != null) {
			clearCache(tokenSession);
		}

		return tokenSession;
	}

	@Override
	public TokenSession updateImpl(
		com.liferay.token.auth.model.TokenSession tokenSession) {
		tokenSession = toUnwrappedModel(tokenSession);

		boolean isNew = tokenSession.isNew();

		TokenSessionModelImpl tokenSessionModelImpl = (TokenSessionModelImpl)tokenSession;

		Session session = null;

		try {
			session = openSession();

			if (tokenSession.isNew()) {
				session.save(tokenSession);

				tokenSession.setNew(false);
			}
			else {
				session.merge(tokenSession);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TokenSessionModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((tokenSessionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						tokenSessionModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);

				args = new Object[] { tokenSessionModelImpl.getCompanyId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);
			}

			if ((tokenSessionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLIENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						tokenSessionModelImpl.getOriginalClientId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CLIENTID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLIENTID,
					args);

				args = new Object[] { tokenSessionModelImpl.getClientId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CLIENTID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLIENTID,
					args);
			}
		}

		EntityCacheUtil.putResult(TokenSessionModelImpl.ENTITY_CACHE_ENABLED,
			TokenSessionImpl.class, tokenSession.getPrimaryKey(), tokenSession,
			false);

		tokenSession.resetOriginalValues();

		return tokenSession;
	}

	protected TokenSession toUnwrappedModel(TokenSession tokenSession) {
		if (tokenSession instanceof TokenSessionImpl) {
			return tokenSession;
		}

		TokenSessionImpl tokenSessionImpl = new TokenSessionImpl();

		tokenSessionImpl.setNew(tokenSession.isNew());
		tokenSessionImpl.setPrimaryKey(tokenSession.getPrimaryKey());

		tokenSessionImpl.setSessionId(tokenSession.getSessionId());
		tokenSessionImpl.setCompanyId(tokenSession.getCompanyId());
		tokenSessionImpl.setUserId(tokenSession.getUserId());
		tokenSessionImpl.setUserName(tokenSession.getUserName());
		tokenSessionImpl.setCreateDate(tokenSession.getCreateDate());
		tokenSessionImpl.setClientId(tokenSession.getClientId());
		tokenSessionImpl.setToken(tokenSession.getToken());
		tokenSessionImpl.setRemoteInfo(tokenSession.getRemoteInfo());
		tokenSessionImpl.setLastUsedDate(tokenSession.getLastUsedDate());
		tokenSessionImpl.setAdditionalInfo(tokenSession.getAdditionalInfo());
		tokenSessionImpl.setExpiryDate(tokenSession.getExpiryDate());

		return tokenSessionImpl;
	}

	/**
	 * Returns the token session with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the token session
	 * @return the token session
	 * @throws com.liferay.token.auth.NoSuchTokenSessionException if a token session with the primary key could not be found
	 */
	@Override
	public TokenSession findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTokenSessionException {
		TokenSession tokenSession = fetchByPrimaryKey(primaryKey);

		if (tokenSession == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTokenSessionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return tokenSession;
	}

	/**
	 * Returns the token session with the primary key or throws a {@link com.liferay.token.auth.NoSuchTokenSessionException} if it could not be found.
	 *
	 * @param sessionId the primary key of the token session
	 * @return the token session
	 * @throws com.liferay.token.auth.NoSuchTokenSessionException if a token session with the primary key could not be found
	 */
	@Override
	public TokenSession findByPrimaryKey(long sessionId)
		throws NoSuchTokenSessionException {
		return findByPrimaryKey((Serializable)sessionId);
	}

	/**
	 * Returns the token session with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the token session
	 * @return the token session, or <code>null</code> if a token session with the primary key could not be found
	 */
	@Override
	public TokenSession fetchByPrimaryKey(Serializable primaryKey) {
		TokenSession tokenSession = (TokenSession)EntityCacheUtil.getResult(TokenSessionModelImpl.ENTITY_CACHE_ENABLED,
				TokenSessionImpl.class, primaryKey);

		if (tokenSession == _nullTokenSession) {
			return null;
		}

		if (tokenSession == null) {
			Session session = null;

			try {
				session = openSession();

				tokenSession = (TokenSession)session.get(TokenSessionImpl.class,
						primaryKey);

				if (tokenSession != null) {
					cacheResult(tokenSession);
				}
				else {
					EntityCacheUtil.putResult(TokenSessionModelImpl.ENTITY_CACHE_ENABLED,
						TokenSessionImpl.class, primaryKey, _nullTokenSession);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(TokenSessionModelImpl.ENTITY_CACHE_ENABLED,
					TokenSessionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return tokenSession;
	}

	/**
	 * Returns the token session with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sessionId the primary key of the token session
	 * @return the token session, or <code>null</code> if a token session with the primary key could not be found
	 */
	@Override
	public TokenSession fetchByPrimaryKey(long sessionId) {
		return fetchByPrimaryKey((Serializable)sessionId);
	}

	@Override
	public Map<Serializable, TokenSession> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, TokenSession> map = new HashMap<Serializable, TokenSession>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			TokenSession tokenSession = fetchByPrimaryKey(primaryKey);

			if (tokenSession != null) {
				map.put(primaryKey, tokenSession);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			TokenSession tokenSession = (TokenSession)EntityCacheUtil.getResult(TokenSessionModelImpl.ENTITY_CACHE_ENABLED,
					TokenSessionImpl.class, primaryKey);

			if (tokenSession == null) {
				if (uncachedPrimaryKeys == null) {
					uncachedPrimaryKeys = new HashSet<Serializable>();
				}

				uncachedPrimaryKeys.add(primaryKey);
			}
			else {
				map.put(primaryKey, tokenSession);
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_TOKENSESSION_WHERE_PKS_IN);

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

			for (TokenSession tokenSession : (List<TokenSession>)q.list()) {
				map.put(tokenSession.getPrimaryKeyObj(), tokenSession);

				cacheResult(tokenSession);

				uncachedPrimaryKeys.remove(tokenSession.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				EntityCacheUtil.putResult(TokenSessionModelImpl.ENTITY_CACHE_ENABLED,
					TokenSessionImpl.class, primaryKey, _nullTokenSession);
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
	 * Returns all the token sessions.
	 *
	 * @return the token sessions
	 */
	@Override
	public List<TokenSession> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<TokenSession> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<TokenSession> findAll(int start, int end,
		OrderByComparator<TokenSession> orderByComparator) {
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

		List<TokenSession> list = (List<TokenSession>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TOKENSESSION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TOKENSESSION;

				if (pagination) {
					sql = sql.concat(TokenSessionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TokenSession>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TokenSession>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the token sessions from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TokenSession tokenSession : findAll()) {
			remove(tokenSession);
		}
	}

	/**
	 * Returns the number of token sessions.
	 *
	 * @return the number of token sessions
	 */
	@Override
	public int countAll() {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TOKENSESSION);

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
	 * Initializes the token session persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		EntityCacheUtil.removeCache(TokenSessionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_TOKENSESSION = "SELECT tokenSession FROM TokenSession tokenSession";
	private static final String _SQL_SELECT_TOKENSESSION_WHERE_PKS_IN = "SELECT tokenSession FROM TokenSession tokenSession WHERE sessionId IN (";
	private static final String _SQL_SELECT_TOKENSESSION_WHERE = "SELECT tokenSession FROM TokenSession tokenSession WHERE ";
	private static final String _SQL_COUNT_TOKENSESSION = "SELECT COUNT(tokenSession) FROM TokenSession tokenSession";
	private static final String _SQL_COUNT_TOKENSESSION_WHERE = "SELECT COUNT(tokenSession) FROM TokenSession tokenSession WHERE ";
	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN = "tokenSession.sessionId";
	private static final String _FILTER_SQL_SELECT_TOKENSESSION_WHERE = "SELECT DISTINCT {tokenSession.*} FROM TokenAuth_TokenSession tokenSession WHERE ";
	private static final String _FILTER_SQL_SELECT_TOKENSESSION_NO_INLINE_DISTINCT_WHERE_1 =
		"SELECT {TokenAuth_TokenSession.*} FROM (SELECT DISTINCT tokenSession.sessionId FROM TokenAuth_TokenSession tokenSession WHERE ";
	private static final String _FILTER_SQL_SELECT_TOKENSESSION_NO_INLINE_DISTINCT_WHERE_2 =
		") TEMP_TABLE INNER JOIN TokenAuth_TokenSession ON TEMP_TABLE.sessionId = TokenAuth_TokenSession.sessionId";
	private static final String _FILTER_SQL_COUNT_TOKENSESSION_WHERE = "SELECT COUNT(DISTINCT tokenSession.sessionId) AS COUNT_VALUE FROM TokenAuth_TokenSession tokenSession WHERE ";
	private static final String _FILTER_ENTITY_ALIAS = "tokenSession";
	private static final String _FILTER_ENTITY_TABLE = "TokenAuth_TokenSession";
	private static final String _ORDER_BY_ENTITY_ALIAS = "tokenSession.";
	private static final String _ORDER_BY_ENTITY_TABLE = "TokenAuth_TokenSession.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TokenSession exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TokenSession exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = com.liferay.portal.util.PropsValues.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE;
	private static final Log _log = LogFactoryUtil.getLog(TokenSessionPersistenceImpl.class);
	private static final TokenSession _nullTokenSession = new TokenSessionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TokenSession> toCacheModel() {
				return _nullTokenSessionCacheModel;
			}
		};

	private static final CacheModel<TokenSession> _nullTokenSessionCacheModel = new CacheModel<TokenSession>() {
			@Override
			public TokenSession toEntityModel() {
				return _nullTokenSession;
			}
		};
}