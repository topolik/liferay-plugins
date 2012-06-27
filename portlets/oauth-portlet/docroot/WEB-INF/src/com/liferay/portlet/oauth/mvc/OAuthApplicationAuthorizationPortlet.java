package com.liferay.portlet.oauth.mvc;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.oauth.service.OAuthApplications_UsersLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portlet.oauth.OAuthConstants;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
public class OAuthApplicationAuthorizationPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		super.render(request, response);
	}

	public void deleteOAuthAppUsr(ActionRequest actionRequest,
			ActionResponse actionResponse)
		throws IOException, PortletException {
		long applicationId = ParamUtil.getLong(actionRequest, OAuthConstants.WEB_APP_ID, 0L);
		
		try {
			if (applicationId > 0) {
				ServiceContext serviceContext =
						ServiceContextFactory.getInstance(actionRequest);
				
				OAuthApplications_UsersLocalServiceUtil
					.deleteOAuthApplications_Users(
						applicationId, serviceContext.getUserId(), serviceContext);
			}
			else {
				SessionErrors.add(
						actionRequest, "cant-complete-operation-without-id");
			}
		}
		catch (Exception e) {
			if (e instanceof SystemException) {
				SessionErrors.add(actionRequest, e.getClass().getName(), e);
			}
			else {
				throw new PortletException(e.fillInStackTrace());
			}
		}
		
	}

	@Override
	public void processAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		super.processAction(actionRequest, actionResponse);
	}
}