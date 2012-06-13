<%@page import="com.liferay.portal.oauth.service.OAuthApplications_UsersLocalServiceUtil"%>
<%@page import="com.liferay.portal.oauth.model.OAuthApplications_Users"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.oauth.model.OAuthApplication"%>
<%@page import="com.liferay.portal.oauth.service.OAuthApplicationLocalServiceUtil"%>
<%@page import="com.liferay.portlet.oauth.OAuthConstants"%>
<%@page import="com.liferay.portlet.oauth.search.OAuthApplicationSearchTerms"%>
<%@page import="com.liferay.portlet.oauth.search.OAuthApplicationDisplayTerms"%>
<%@page import="com.liferay.portlet.oauth.search.OAuthApplicationUserSearch"%>

<%@page import="java.util.List"%>

<%@ include file="/html/init.jsp" %>

<c:if test="<%= SessionMessages.contains(request, OAuthConstants.WEB_APP_REQ_PROCESSED) %>">
	<liferay-ui:success key="<%= OAuthConstants.WEB_APP_REQ_PROCESSED %>" message="your-request-completed-successfully"></liferay-ui:success>
</c:if>

<portlet:actionURL var="searchActionURL">
</portlet:actionURL>

<aui:form action="<%= searchActionURL %>" name="fm">

<liferay-util:include page="/html/admin/toolbar.jsp" servletContext="<%= application %>">
		<liferay-util:param name="toolbarItem" value="view-all" />
</liferay-util:include>

<liferay-ui:search-container
	searchContainer="<%= new OAuthApplicationUserSearch(renderRequest, currentURLObj) %>"
	delta="5">
	
	<liferay-ui:search-form
				page="/html/authorization/search.jsp"
				servletContext="<%= application %>"
			/>
	
	<%
		String name = ((OAuthApplicationSearchTerms)searchContainer.getSearchTerms()).getName();
		
		List<OAuthApplications_Users> oAuthApps = null;
		int oAuthAppsCnt = 0;
		
		if (adminUser) {
			oAuthApps = OAuthApplications_UsersLocalServiceUtil.getOAuthApplications_Userses(searchContainer.getStart(), searchContainer.getEnd());
			oAuthAppsCnt = OAuthApplications_UsersLocalServiceUtil.getOAuthApplications_UsersesCount();
		} else {
			oAuthApps = OAuthApplications_UsersLocalServiceUtil.getOAuthApplications_Userses(searchContainer.getStart(), searchContainer.getEnd());
			oAuthAppsCnt = OAuthApplications_UsersLocalServiceUtil.getOAuthApplications_UsersesCount();
		}
	%>
	
	<liferay-ui:search-container-results
	results="<%= oAuthApps %>"
	total="<%= oAuthAppsCnt %>"
	 />

	<liferay-ui:search-container-row
		className="com.liferay.portal.oauth.model.OAuthApplications_Users"
		keyProperty="oaauid"
		modelVar="app">
		<liferay-ui:search-container-column-text
					name="oaauid"
					value="<%= Long.toString(app.getOaauid()) %>"
					orderable="<%= true %>"
				/>
		<liferay-ui:search-container-column-text
					name="applicationId"
					value="<%= Long.toString(app.getApplicationId()) %>"
					orderable="<%= true %>"
				/>
		<liferay-ui:search-container-column-text
					name="accessToken"
					orderable="<%= false %>"
				/>
		<liferay-ui:search-container-column-text
					name="authorized"
					value="<%= Boolean.toString(app.getAuthorized()) %>"
					orderable="<%= false %>"
				/>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />

</liferay-ui:search-container>
</aui:form>

