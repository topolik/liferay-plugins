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

package com.liferay.token.auth.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBFactoryUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.ClassNamePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.util.PortalUtil;

import com.liferay.token.auth.model.TokenACLProfile;
import com.liferay.token.auth.service.TokenACLProfileService;
import com.liferay.token.auth.service.persistence.TokenACLProfilePersistence;
import com.liferay.token.auth.service.persistence.TokenClientPersistence;
import com.liferay.token.auth.service.persistence.TokenSessionPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the token a c l profile remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.token.auth.service.impl.TokenACLProfileServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.token.auth.service.impl.TokenACLProfileServiceImpl
 * @see com.liferay.token.auth.service.TokenACLProfileServiceUtil
 * @generated
 */
public abstract class TokenACLProfileServiceBaseImpl extends BaseServiceImpl
	implements TokenACLProfileService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.token.auth.service.TokenACLProfileServiceUtil} to access the token a c l profile remote service.
	 */

	/**
	 * Returns the token a c l profile local service.
	 *
	 * @return the token a c l profile local service
	 */
	public com.liferay.token.auth.service.TokenACLProfileLocalService getTokenACLProfileLocalService() {
		return tokenACLProfileLocalService;
	}

	/**
	 * Sets the token a c l profile local service.
	 *
	 * @param tokenACLProfileLocalService the token a c l profile local service
	 */
	public void setTokenACLProfileLocalService(
		com.liferay.token.auth.service.TokenACLProfileLocalService tokenACLProfileLocalService) {
		this.tokenACLProfileLocalService = tokenACLProfileLocalService;
	}

	/**
	 * Returns the token a c l profile remote service.
	 *
	 * @return the token a c l profile remote service
	 */
	public com.liferay.token.auth.service.TokenACLProfileService getTokenACLProfileService() {
		return tokenACLProfileService;
	}

	/**
	 * Sets the token a c l profile remote service.
	 *
	 * @param tokenACLProfileService the token a c l profile remote service
	 */
	public void setTokenACLProfileService(
		com.liferay.token.auth.service.TokenACLProfileService tokenACLProfileService) {
		this.tokenACLProfileService = tokenACLProfileService;
	}

	/**
	 * Returns the token a c l profile persistence.
	 *
	 * @return the token a c l profile persistence
	 */
	public TokenACLProfilePersistence getTokenACLProfilePersistence() {
		return tokenACLProfilePersistence;
	}

	/**
	 * Sets the token a c l profile persistence.
	 *
	 * @param tokenACLProfilePersistence the token a c l profile persistence
	 */
	public void setTokenACLProfilePersistence(
		TokenACLProfilePersistence tokenACLProfilePersistence) {
		this.tokenACLProfilePersistence = tokenACLProfilePersistence;
	}

	/**
	 * Returns the token client local service.
	 *
	 * @return the token client local service
	 */
	public com.liferay.token.auth.service.TokenClientLocalService getTokenClientLocalService() {
		return tokenClientLocalService;
	}

	/**
	 * Sets the token client local service.
	 *
	 * @param tokenClientLocalService the token client local service
	 */
	public void setTokenClientLocalService(
		com.liferay.token.auth.service.TokenClientLocalService tokenClientLocalService) {
		this.tokenClientLocalService = tokenClientLocalService;
	}

	/**
	 * Returns the token client remote service.
	 *
	 * @return the token client remote service
	 */
	public com.liferay.token.auth.service.TokenClientService getTokenClientService() {
		return tokenClientService;
	}

	/**
	 * Sets the token client remote service.
	 *
	 * @param tokenClientService the token client remote service
	 */
	public void setTokenClientService(
		com.liferay.token.auth.service.TokenClientService tokenClientService) {
		this.tokenClientService = tokenClientService;
	}

	/**
	 * Returns the token client persistence.
	 *
	 * @return the token client persistence
	 */
	public TokenClientPersistence getTokenClientPersistence() {
		return tokenClientPersistence;
	}

	/**
	 * Sets the token client persistence.
	 *
	 * @param tokenClientPersistence the token client persistence
	 */
	public void setTokenClientPersistence(
		TokenClientPersistence tokenClientPersistence) {
		this.tokenClientPersistence = tokenClientPersistence;
	}

	/**
	 * Returns the token session local service.
	 *
	 * @return the token session local service
	 */
	public com.liferay.token.auth.service.TokenSessionLocalService getTokenSessionLocalService() {
		return tokenSessionLocalService;
	}

	/**
	 * Sets the token session local service.
	 *
	 * @param tokenSessionLocalService the token session local service
	 */
	public void setTokenSessionLocalService(
		com.liferay.token.auth.service.TokenSessionLocalService tokenSessionLocalService) {
		this.tokenSessionLocalService = tokenSessionLocalService;
	}

	/**
	 * Returns the token session remote service.
	 *
	 * @return the token session remote service
	 */
	public com.liferay.token.auth.service.TokenSessionService getTokenSessionService() {
		return tokenSessionService;
	}

	/**
	 * Sets the token session remote service.
	 *
	 * @param tokenSessionService the token session remote service
	 */
	public void setTokenSessionService(
		com.liferay.token.auth.service.TokenSessionService tokenSessionService) {
		this.tokenSessionService = tokenSessionService;
	}

	/**
	 * Returns the token session persistence.
	 *
	 * @return the token session persistence
	 */
	public TokenSessionPersistence getTokenSessionPersistence() {
		return tokenSessionPersistence;
	}

	/**
	 * Sets the token session persistence.
	 *
	 * @param tokenSessionPersistence the token session persistence
	 */
	public void setTokenSessionPersistence(
		TokenSessionPersistence tokenSessionPersistence) {
		this.tokenSessionPersistence = tokenSessionPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.service.ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name remote service.
	 *
	 * @return the class name remote service
	 */
	public com.liferay.portal.service.ClassNameService getClassNameService() {
		return classNameService;
	}

	/**
	 * Sets the class name remote service.
	 *
	 * @param classNameService the class name remote service
	 */
	public void setClassNameService(
		com.liferay.portal.service.ClassNameService classNameService) {
		this.classNameService = classNameService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
	}

	public void destroy() {
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	protected Class<?> getModelClass() {
		return TokenACLProfile.class;
	}

	protected String getModelClassName() {
		return TokenACLProfile.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = tokenACLProfilePersistence.getDataSource();

			DB db = DBFactoryUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.liferay.token.auth.service.TokenACLProfileLocalService.class)
	protected com.liferay.token.auth.service.TokenACLProfileLocalService tokenACLProfileLocalService;
	@BeanReference(type = com.liferay.token.auth.service.TokenACLProfileService.class)
	protected com.liferay.token.auth.service.TokenACLProfileService tokenACLProfileService;
	@BeanReference(type = TokenACLProfilePersistence.class)
	protected TokenACLProfilePersistence tokenACLProfilePersistence;
	@BeanReference(type = com.liferay.token.auth.service.TokenClientLocalService.class)
	protected com.liferay.token.auth.service.TokenClientLocalService tokenClientLocalService;
	@BeanReference(type = com.liferay.token.auth.service.TokenClientService.class)
	protected com.liferay.token.auth.service.TokenClientService tokenClientService;
	@BeanReference(type = TokenClientPersistence.class)
	protected TokenClientPersistence tokenClientPersistence;
	@BeanReference(type = com.liferay.token.auth.service.TokenSessionLocalService.class)
	protected com.liferay.token.auth.service.TokenSessionLocalService tokenSessionLocalService;
	@BeanReference(type = com.liferay.token.auth.service.TokenSessionService.class)
	protected com.liferay.token.auth.service.TokenSessionService tokenSessionService;
	@BeanReference(type = TokenSessionPersistence.class)
	protected TokenSessionPersistence tokenSessionPersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ClassNameLocalService.class)
	protected com.liferay.portal.service.ClassNameLocalService classNameLocalService;
	@BeanReference(type = com.liferay.portal.service.ClassNameService.class)
	protected com.liferay.portal.service.ClassNameService classNameService;
	@BeanReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
}