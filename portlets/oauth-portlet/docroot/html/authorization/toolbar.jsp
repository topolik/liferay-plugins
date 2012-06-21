<%@page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@page import="com.liferay.portal.security.permission.PermissionChecker"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>

<%@ include file="/html/init.jsp" %>

<%
String toolbarItem = ParamUtil.getString(request, OAuthConstants.TOOLBAR_ITEM, "view-all");
int myAppsCount = ParamUtil.getInteger(request, "myAppsCount", 0);
%>

<div class="lfr-portlet-toolbar">
	<portlet:renderURL var="viewAppsURL">
		<portlet:param name="jspPage" value="/html/authorization/view.jsp" />
	</portlet:renderURL>

	<span class="lfr-toolbar-button view-button <%= toolbarItem.equals("view-all") ? "current" : "" %>">
		<a href="<%= viewAppsURL %>"><liferay-ui:message key='<%= adminUser ? "view-all":"my-authorizations" %>' /></a>
	</span>
<c:if test="<%= myAppsCount > 0 %>">
	<portlet:renderURL var="myApplicationsURL">
		<portlet:param name="jspPage" value="/html/authorization/view.jsp"/>
		<portlet:param name="referer" value="<%= currentURL %>"/>
		<portlet:param name="toolbarItem" value="view-my-apps"/>
	</portlet:renderURL>
	
	<span class="lfr-toolbar-button view-button <%= toolbarItem.equals("view-my-apps") ? "current" : "" %>">
		<a href="<%= myApplicationsURL %>"><liferay-ui:message key="my-applications" /></a>
	</span>
</c:if>
<c:if test='<%= permissionChecker.hasPermission(layout.getGroupId(), "com.liferay.portlet.oauth", layout.getGroupId(), ActionKeys.ADD_ENTRY) %>'>
	<portlet:renderURL var="addApplicationURL">
		<portlet:param name="jspPage" value="/html/admin/edit.jsp"/>
		<portlet:param name="referer" value="<%= currentURL %>"/>
	</portlet:renderURL>
	
	<span class="lfr-toolbar-button add-button <%= toolbarItem.equals("add") ? "current" : "" %>">
		<a href="<%= addApplicationURL %>"><liferay-ui:message key="add" /></a>
	</span>
</c:if>
</div>