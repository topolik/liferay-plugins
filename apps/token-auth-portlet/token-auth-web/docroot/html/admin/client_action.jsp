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

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

TokenClient tokenClient = (TokenClient)row.getObject();
String clientId = String.valueOf(tokenClient.getClientId());
%>

<liferay-ui:icon-menu>
	<liferay-portlet:renderURL var="viewURL">
		<portlet:param name="mvcPath" value="/admin/view_client.jsp" />
		<portlet:param name="redirect" value="<%= currentURL %>" />
		<portlet:param name="clientId" value="<%= clientId %>" />
	</liferay-portlet:renderURL>

	<liferay-ui:icon
		image="view"
		method="get"
		url="<%= viewURL %>"
	/>

	<c:if test="<%= TokenClientPermission.contains(permissionChecker, tokenClient, ActionKeys.UPDATE) %>">
		<liferay-portlet:renderURL var="editURL">
			<portlet:param name="mvcPath" value="/admin/edit_client.jsp" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="clientId" value="<%= clientId %>" />
		</liferay-portlet:renderURL>

		<liferay-ui:icon
			image="edit"
			method="get"
			url="<%= editURL %>"
		/>
	</c:if>

	<c:if test="<%= TokenClientPermission.contains(permissionChecker, tokenClient, ActionKeys.DELETE) %>">
		<liferay-portlet:actionURL name="deleteClient" var="deleteURL">
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="clientId" value="<%= clientId %>" />
		</liferay-portlet:actionURL>

		<liferay-ui:icon-delete
			url="<%= deleteURL %>"
		/>
	</c:if>
</liferay-ui:icon-menu>