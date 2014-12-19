<%@ page import="com.liferay.token.auth.service.TokenClientServiceUtil" %>
<%@ page import="com.liferay.token.auth.service.TokenSessionServiceUtil" %>
<%--
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
--%>

<%@ include file="init.jsp" %>

<portlet:renderURL var="portletURL" />

<aui:form name="fm">

	<liferay-ui:search-container
		iteratorURL="<%= portletURL %>"
		total="<%= TokenClientServiceUtil.getClientsCount() %>"
		>
		<liferay-ui:search-container-results
			results="<%= TokenClientServiceUtil.getClients(searchContainer.getStart(), searchContainer.getEnd()) %>"
			/>

		<liferay-ui:search-container-row
			className="com.liferay.token.auth.model.TokenClient"
			modelVar="tokenClient"
			>
			<% com.liferay.token.auth.model.TokenClient tokenClient = null; %>

			<liferay-portlet:renderURL var="rowHREF">
				<portlet:param name="mvcPath" value="/admin/view_client.jsp" />
				<portlet:param name="redirect" value="<%= currentURL %>" />
				<portlet:param name="clientId" value="<%= tokenClient.getClientId() %>" />
			</liferay-portlet:renderURL>


			<liferay-ui:search-container-column-text
				href="<%= rowHREF %>"
				orderable="<%= true %>"
				property="name"
			/>

			<liferay-ui:search-container-column-text
				href="<%= rowHREF %>"
				name="website-url"
				property="websiteURL"
			/>

			<liferay-ui:search-container-column-text
				href="<%= rowHREF %>"
				property="aCLProfiles"
			/>

			<liferay-ui:search-container-column-text
				href="<%= rowHREF %>"
				name="number-of-sessions"
				value="<%= String.valueOf(TokenSessionServiceUtil.getSessionsCount(tokenClient.getClientId())) %>"
			/>

			<liferay-ui:search-container-column-jsp
				align="right"
				path="/admin/client_action.jsp"
			/>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</aui:form>