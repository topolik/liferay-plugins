<%--
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

<%@ page import="com.liferay.client.soap.portal.model.OrganizationSoap" %>
<%@ page import="com.liferay.client.soap.portal.service.http.OrganizationServiceSoap" %>
<%@ page import="com.liferay.client.soap.portal.service.http.OrganizationServiceSoapServiceLocator" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portal.model.CompanyConstants" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>

<%@ page import="java.net.URL" %>

<%@ page import="javax.xml.rpc.Stub" %>

You belong to the following organizations:

<br /><br />

<%
String remoteUser = request.getRemoteUser();

long userId = GetterUtil.getLong(remoteUser);

OrganizationServiceSoapServiceLocator locator = new OrganizationServiceSoapServiceLocator();

OrganizationServiceSoap soap = locator.getPortal_OrganizationService(new URL("http://localhost:8080/api/axis/Portal_OrganizationService"));

_setCredentials(request, (Stub) soap);

OrganizationSoap[] organizations = soap.getUserOrganizations(userId);

for (int i = 0; i < organizations.length; i++) {
	OrganizationSoap organization = organizations[i];
%>

	<%= organization.getName() %><br />

<%
}
%>

<%!
private void _setCredentials(HttpServletRequest request, Stub stub) throws Exception {
	String authType = PortalUtil.getCompany(request).getAuthType();

	String remoteUser = request.getRemoteUser();

	if(authType.equals(CompanyConstants.AUTH_TYPE_EA)){
		remoteUser = PortalUtil.getUser(request).getEmailAddress();
	}
	else if(authType.equals(CompanyConstants.AUTH_TYPE_SN)){
		remoteUser = PortalUtil.getUser(request).getScreenName();
	}

	stub._setProperty(Stub.USERNAME_PROPERTY, remoteUser);
	stub._setProperty(Stub.PASSWORD_PROPERTY, "test");
}
%>