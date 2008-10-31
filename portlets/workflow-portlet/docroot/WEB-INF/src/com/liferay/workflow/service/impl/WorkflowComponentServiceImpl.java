/**
 * Copyright (c) 2000-2008 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.liferay.workflow.service.impl;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.jbi.WorkflowComponent;
import com.liferay.portal.kernel.jbi.WorkflowComponentException;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.User;
import com.liferay.saw.service.SAWWorkflowLocalServiceUtil;
import com.liferay.util.portlet.PortletProps;
import com.liferay.workflow.jbi.WorkflowURL;
import com.liferay.workflow.jbi.WorkflowXMLUtil;
import com.liferay.workflow.model.WorkflowTask;
import com.liferay.workflow.service.base.WorkflowComponentServiceBaseImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="WorkflowComponentServiceImpl.java.html"><b><i>View Source</i></b>
 * </a>
 * 
 * @author Brian Wing Shun Chan
 * @author Ganesh Ram
 * @author Vihang Pathak
 */
public class WorkflowComponentServiceImpl extends
		WorkflowComponentServiceBaseImpl implements WorkflowComponent {

	public List getCurrentTasks(long instanceId, long tokenId)
		throws WorkflowComponentException {

		try {
			String xml = getCurrentTasksXml(instanceId, tokenId);

			return WorkflowXMLUtil.parseList(xml, "tasks");
		} catch (Exception e) {
			throw new WorkflowComponentException(e);
		}
	}

	public String getCurrentTasksXml(long instanceId, long tokenId)
		throws WorkflowComponentException {

		if (!_useSAW) {
			try {
				WorkflowURL url = getWorkflowURL();

				url.setParameter(Constants.CMD, "getCurrentTasksXml");
				url.setParameter("instanceId", instanceId);
				url.setParameter("tokenId", tokenId);

				return url.getContent();
			} catch (Exception e) {
				throw new WorkflowComponentException(e);
			}
		} else {
			String userId = _getLoggedInUserId();
			return SAWWorkflowLocalServiceUtil.getCurrentTasksXml(
					instanceId,tokenId, userId);
		}
	}

	public String deploy(String xml) throws WorkflowComponentException {
		if (!_useSAW) {
			try {
				WorkflowURL url = getWorkflowURL();

				xml = StringUtil.replace(xml,
						new String[] { "\n", "\r", "\t" }, new String[] { "",
								"", "" });

				url.setParameter(Constants.CMD, "deploy");
				url.setParameter("xml", xml);

				String content = url.getContent();

				return WorkflowXMLUtil.parseString(content, "definitionId");
			} catch (Exception e) {
				throw new WorkflowComponentException(e);
			}
		} else {
			if (xml == null) {
				xml = "";
			}
			return SAWWorkflowLocalServiceUtil.deploy(xml);
		}
	}

	public Object getDefinition(long definitionId)
		throws WorkflowComponentException {

		try {
			String xml = getDefinitionXml(definitionId);
			return WorkflowXMLUtil.parseDefinition(xml);
			
		} catch (Exception e) {
			throw new WorkflowComponentException(e);
		}
	}

	public List getDefinitions(
			long definitionId, String name, int start,int end) 
		throws WorkflowComponentException {

		try {
			String xml = getDefinitionsXml(definitionId, name, start, end);
			return WorkflowXMLUtil.parseList(xml, "definitions");
			
		} catch (Exception e) {
			throw new WorkflowComponentException(e);
		}
	}

	public String getDefinitionsXml(
			long definitionId, String name, int start,int end) 
		throws WorkflowComponentException {

		if (!_useSAW) {
			try {
				WorkflowURL url = getWorkflowURL();

				url.setParameter(Constants.CMD, "getDefinitionsXml");
				url.setParameter("definitionId", definitionId);
				url.setParameter("name", name);
				url.setParameter("start", start);
				url.setParameter("end", end);

				return url.getContent();
			} catch (Exception e) {
				throw new WorkflowComponentException(e);
			}
		} else {
			String userId = _getLoggedInUserId();
			return SAWWorkflowLocalServiceUtil.getDefinitionsXml(
					definitionId,name, userId, start, end);
		}
	}

	public int getDefinitionsCount(long definitionId, String name)
		throws WorkflowComponentException {

		try {
			String xml = getDefinitionsCountXml(definitionId, name);
			return WorkflowXMLUtil.parseInt(xml, "count");
			
		} catch (Exception e) {
			throw new WorkflowComponentException(e);
		}
	}

	public String getDefinitionsCountXml(long definitionId, String name)
		throws WorkflowComponentException {

		if (!_useSAW) {
			try {
				WorkflowURL url = getWorkflowURL();

				url.setParameter(Constants.CMD, "getDefinitionsCountXml");
				url.setParameter("definitionId", definitionId);
				url.setParameter("name", name);

				return url.getContent();
			} catch (Exception e) {
				throw new WorkflowComponentException(e);
			}
		} else {
			String userId = _getLoggedInUserId();
			return SAWWorkflowLocalServiceUtil.getDefinitionsCountXml(
					definitionId, name, userId);
		}
	}

	public String getDefinitionXml(long definitionId)
		throws WorkflowComponentException {

		if (!_useSAW) {
			try {
				WorkflowURL url = getWorkflowURL();

				url.setParameter(Constants.CMD, "getDefinitionXml");
				url.setParameter("definitionId", definitionId);

				return url.getContent();
			} catch (Exception e) {
				throw new WorkflowComponentException(e);
			}
		} else {

			return SAWWorkflowLocalServiceUtil.getDefinitionXml(definitionId);
		}
	}

	public List getInstances(
			long definitionId, long instanceId,
			String definitionName, String definitionVersion,
			String startDateGT, String startDateLT, String endDateGT,
			String endDateLT, boolean hideEndedTasks,
			boolean retrieveUserInstances, boolean andOperator, int start,
			int end) 
		throws WorkflowComponentException {

		try {
			String xml = getInstancesXml(
					definitionId, instanceId,
					definitionName, definitionVersion, startDateGT,
					startDateLT, endDateGT, endDateLT, hideEndedTasks,
					retrieveUserInstances, andOperator, start, end);

			return WorkflowXMLUtil.parseList(xml, "instances");
		} catch (Exception e) {
			throw new WorkflowComponentException(e);
		}
	}

	public int getInstancesCount(
			long definitionId, long instanceId,
			String definitionName, String definitionVersion,
			String startDateGT, String startDateLT, String endDateGT,
			String endDateLT, boolean hideEndedTasks,
			boolean retrieveUserInstances, boolean andOperator)
		throws WorkflowComponentException {

		try {
			String xml = getInstancesCountXml(
					definitionId, instanceId,
					definitionName, definitionVersion, startDateGT,
					startDateLT, endDateGT, endDateLT, hideEndedTasks,
					retrieveUserInstances, andOperator);

			return WorkflowXMLUtil.parseInt(xml, "count");
		} catch (Exception e) {
			throw new WorkflowComponentException(e);
		}
	}

	public String getInstancesCountXml(
			long definitionId, long instanceId,
			String definitionName, String definitionVersion,
			String startDateGT, String startDateLT, String endDateGT,
			String endDateLT, boolean hideEndedTasks,
			boolean retrieveUserInstances, boolean andOperator)
		throws WorkflowComponentException {

		if (!_useSAW) {
			try {
				WorkflowURL url = getWorkflowURL();

				url.setParameter(Constants.CMD, "getInstancesCountXml");
				url.setParameter("definitionId", definitionId);
				url.setParameter("instanceId", instanceId);
				url.setParameter("definitionName", definitionName);
				url.setParameter("definitionVersion", definitionVersion);
				url.setParameter("startDateGT", startDateGT);
				url.setParameter("startDateLT", startDateLT);
				url.setParameter("endDateGT", endDateGT);
				url.setParameter("endDateLT", endDateLT);
				url.setParameter("hideEndedTasks", hideEndedTasks);
				url
						.setParameter("retrieveUserInstances",
								retrieveUserInstances);
				url.setParameter("andOperator", andOperator);

				return url.getContent();
			} catch (Exception e) {
				throw new WorkflowComponentException(e);
			}
		} else {

			String userId = _getLoggedInUserId();
			if (definitionName == null) {
				definitionName = "";
			}
			if (definitionVersion == null) {
				definitionVersion = "";
			}
			if (endDateLT == null) {
				endDateLT = "";
			}
			if (startDateGT == null) {
				startDateGT = "";
			}
			if (startDateLT == null) {
				startDateLT = "";
			}
			if (endDateGT == null) {
				endDateGT = "";
			}
			if (userId == null) {
				userId = "";
			}

			return SAWWorkflowLocalServiceUtil.getInstancesCountXml(
					definitionId, instanceId, definitionName,
					definitionVersion, startDateGT, startDateLT, endDateGT,
					endDateLT, userId, hideEndedTasks, retrieveUserInstances,
					andOperator);
		}
	}

	public String getInstancesXml(long definitionId, long instanceId,
			String definitionName, String definitionVersion,
			String startDateGT, String startDateLT, String endDateGT,
			String endDateLT, boolean hideEndedTasks,
			boolean retrieveUserInstances, boolean andOperator, 
			int start,int end) 
		throws WorkflowComponentException {

		if (!_useSAW) {
			try {
				WorkflowURL url = getWorkflowURL();

				url.setParameter(Constants.CMD, "getInstancesXml");
				url.setParameter("definitionId", definitionId);
				url.setParameter("instanceId", instanceId);
				url.setParameter("definitionName", definitionName);
				url.setParameter("definitionVersion", definitionVersion);
				url.setParameter("startDateGT", startDateGT);
				url.setParameter("startDateLT", startDateLT);
				url.setParameter("endDateGT", endDateGT);
				url.setParameter("endDateLT", endDateLT);
				url.setParameter("hideEndedTasks", hideEndedTasks);
				url
						.setParameter("retrieveUserInstances",
								retrieveUserInstances);
				url.setParameter("andOperator", andOperator);
				url.setParameter("start", start);
				url.setParameter("end", end);

				return url.getContent();
			} catch (Exception e) {
				throw new WorkflowComponentException(e);
			}
		} else {
			String userId = _getLoggedInUserId();
			if (definitionName == null) {
				definitionName = "";
			}
			if (definitionVersion == null) {
				definitionVersion = "";
			}
			if (endDateLT == null) {
				endDateLT = "";
			}
			if (startDateGT == null) {
				startDateGT = "";
			}
			if (startDateLT == null) {
				startDateLT = "";
			}
			if (endDateGT == null) {
				endDateGT = "";
			}
			if (userId == null) {
				userId = "";
			}
			return SAWWorkflowLocalServiceUtil.getInstancesXml(
					definitionId,instanceId, definitionName, definitionVersion, 
					startDateGT,startDateLT, endDateGT, endDateLT, 
					userId, hideEndedTasks,
					retrieveUserInstances, andOperator, start, end);
		}
	}

	public WorkflowTask getTask(long taskId) 
		throws WorkflowComponentException {
		try {
			String xml = getTaskXml(taskId);
			return WorkflowXMLUtil.parseTask(xml);
			
		} catch (Exception e) {
			throw new WorkflowComponentException(e);
		}
	}

	public String getTaskXml(long taskId) throws WorkflowComponentException {
		if (!_useSAW) {
			try {
				WorkflowURL url = getWorkflowURL();

				url.setParameter(Constants.CMD, "getTaskXml");
				url.setParameter("taskId", taskId);

				return url.getContent();
			} catch (Exception e) {
				throw new WorkflowComponentException(e);
			}
		} else {
			String userId = _getLoggedInUserId();

			return SAWWorkflowLocalServiceUtil.getTaskXml(taskId, userId);
		}
	}

	public List getTaskFormElements(long taskId)
		throws WorkflowComponentException {

		try {
			String xml = getTaskFormElementsXml(taskId);

			return WorkflowXMLUtil.parseList(xml, "taskFormElements");
		} catch (Exception e) {
			throw new WorkflowComponentException(e);
		}
	}

	public String getTaskFormElementsXml(long taskId)
		throws WorkflowComponentException {

		if (!_useSAW) {
			try {
				WorkflowURL url = getWorkflowURL();

				url.setParameter(Constants.CMD, "getTaskFormElementsXml");
				url.setParameter("taskId", taskId);

				return url.getContent();
			} catch (Exception e) {
				throw new WorkflowComponentException(e);
			}
		} else {
			return SAWWorkflowLocalServiceUtil.getTaskFormElementsXml(taskId);
		}
	}

	public List getTaskTransitions(long taskId)
		throws WorkflowComponentException {

		try {
			String xml = getTaskTransitionsXml(taskId);

			return WorkflowXMLUtil.parseList(xml, "taskTransitions");
		} catch (Exception e) {
			throw new WorkflowComponentException(e);
		}
	}

	public String getTaskTransitionsXml(long taskId)
		throws WorkflowComponentException {

		if (!_useSAW) {
			try {
				WorkflowURL url = getWorkflowURL();

				url.setParameter(Constants.CMD, "getTaskTransitionsXml");
				url.setParameter("taskId", taskId);

				return url.getContent();
			} catch (Exception e) {
				throw new WorkflowComponentException(e);
			}
		} else {
			return SAWWorkflowLocalServiceUtil.getTaskTransitionsXml(taskId);
		}
	}

	public List getUserTasks(
			long instanceId, String taskName,
			String definitionName, String assignedTo, String createDateGT,
			String createDateLT, String startDateGT, String startDateLT,
			String endDateGT, String endDateLT, boolean hideEndedTasks,
			boolean andOperator, int start, int end)
		throws WorkflowComponentException {

		try {
			String xml = getUserTasksXml(
					instanceId, taskName, definitionName,
					assignedTo, createDateGT, createDateLT, startDateGT,
					startDateLT, endDateGT, endDateLT, hideEndedTasks,
					andOperator, start, end);

			return WorkflowXMLUtil.parseList(xml, "tasks");
		} catch (Exception e) {
			throw new WorkflowComponentException(e);
		}
	}

	public int getUserTasksCount(
			long instanceId, String taskName,
			String definitionName, String assignedTo, String createDateGT,
			String createDateLT, String startDateGT, String startDateLT,
			String endDateGT, String endDateLT, boolean hideEndedTasks,
			boolean andOperator) 
		throws WorkflowComponentException {

		try {
			String xml = getUserTasksCountXml(
					instanceId, taskName,definitionName, assignedTo, 
					createDateGT, createDateLT,startDateGT, startDateLT, 
					endDateGT, endDateLT,hideEndedTasks, andOperator);

			return WorkflowXMLUtil.parseInt(xml, "count");
		} catch (Exception e) {
			throw new WorkflowComponentException(e);
		}
	}

	public String getUserTasksCountXml(
			long instanceId, String taskName,
			String definitionName, String assignedTo, String createDateGT,
			String createDateLT, String startDateGT, String startDateLT,
			String endDateGT, String endDateLT, boolean hideEndedTasks,
			boolean andOperator) 
		throws WorkflowComponentException {

		if (!_useSAW) {
			try {
				WorkflowURL url = getWorkflowURL();

				url.setParameter(Constants.CMD, "getUserTasksCountXml");
				url.setParameter("instanceId", instanceId);
				url.setParameter("taskName", taskName);
				url.setParameter("definitionName", definitionName);
				url.setParameter("assignedTo", assignedTo);
				url.setParameter("createDateGT", createDateGT);
				url.setParameter("createDateLT", createDateLT);
				url.setParameter("startDateGT", startDateGT);
				url.setParameter("startDateLT", startDateLT);
				url.setParameter("endDateGT", endDateGT);
				url.setParameter("endDateLT", endDateLT);
				url.setParameter("hideEndedTasks", hideEndedTasks);
				url.setParameter("andOperator", andOperator);

				return url.getContent();
			} catch (Exception e) {
				throw new WorkflowComponentException(e);
			}
		} else {

			String userId = _getLoggedInUserId();
			if (definitionName == null) {
				definitionName = "";
			}
			if (assignedTo == null) {
				assignedTo = "";
			}
			if (endDateLT == null) {
				endDateLT = "";
			}
			if (startDateGT == null) {
				startDateGT = "";
			}
			if (startDateLT == null) {
				startDateLT = "";
			}
			if (endDateGT == null) {
				endDateGT = "";
			}
			if (userId == null) {
				userId = "";
			}
			if (createDateLT == null) {
				createDateLT = "";
			}
			if (createDateGT == null) {
				createDateGT = "";
			}
			return SAWWorkflowLocalServiceUtil.getUserTasksCountXml(
					instanceId,taskName, definitionName, assignedTo, 
					userId, createDateGT,createDateLT, 
					startDateGT, startDateLT, 
					endDateGT,endDateLT, 
					hideEndedTasks, andOperator);
		}
	}

	public String getUserTasksXml(
			long instanceId, String taskName,
			String definitionName, String assignedTo, String createDateGT,
			String createDateLT, String startDateGT, String startDateLT,
			String endDateGT, String endDateLT, boolean hideEndedTasks,
			boolean andOperator, int start, int end)
		throws WorkflowComponentException {

		if (!_useSAW) {
			try {
				WorkflowURL url = getWorkflowURL();

				url.setParameter(Constants.CMD, "getUserTasksXml");
				url.setParameter("instanceId", instanceId);
				url.setParameter("taskName", taskName);
				url.setParameter("definitionName", definitionName);
				url.setParameter("assignedTo", assignedTo);
				url.setParameter("createDateGT", createDateGT);
				url.setParameter("createDateLT", createDateLT);
				url.setParameter("startDateGT", startDateGT);
				url.setParameter("startDateLT", startDateLT);
				url.setParameter("endDateGT", endDateGT);
				url.setParameter("endDateLT", endDateLT);
				url.setParameter("hideEndedTasks", hideEndedTasks);
				url.setParameter("andOperator", andOperator);
				url.setParameter("start", start);
				url.setParameter("end", end);

				return url.getContent();
			} catch (Exception e) {
				throw new WorkflowComponentException(e);
			}
		} else {
			String userId = _getLoggedInUserId();
			if (definitionName == null) {
				definitionName = "";
			}
			if (assignedTo == null) {
				assignedTo = "";
			}
			if (endDateLT == null) {
				endDateLT = "";
			}
			if (startDateGT == null) {
				startDateGT = "";
			}
			if (startDateLT == null) {
				startDateLT = "";
			}
			if (endDateGT == null) {
				endDateGT = "";
			}
			if (userId == null) {
				userId = "";
			}
			if (createDateLT == null) {
				createDateLT = "";
			}
			if (createDateGT == null) {
				createDateGT = "";
			}
			return SAWWorkflowLocalServiceUtil.getUserTasksXml(
					instanceId,taskName, definitionName, assignedTo, 
					createDateGT,createDateLT, startDateGT, startDateLT, 
					endDateGT,endDateLT, userId, hideEndedTasks, andOperator, 
					start, end);
		}
	}

	public void signalInstance(long instanceId)
		throws WorkflowComponentException {

		if (!_useSAW) {
			try {
				WorkflowURL url = getWorkflowURL();

				url.setParameter(Constants.CMD, "signalInstance");
				url.setParameter("instanceId", instanceId);

				url.getContent();
			} catch (Exception e) {
				throw new WorkflowComponentException(e);
			}
		} else {
			SAWWorkflowLocalServiceUtil.signalInstance(instanceId);
		}
	}

	public void signalToken(long instanceId, long tokenId)
		throws WorkflowComponentException {

		if (!_useSAW) {
			try {
				WorkflowURL url = getWorkflowURL();

				url.setParameter(Constants.CMD, "signalToken");
				url.setParameter("instanceId", instanceId);
				url.setParameter("tokenId", tokenId);

				url.getContent();
			} catch (Exception e) {
				throw new WorkflowComponentException(e);
			}
		} else {
			SAWWorkflowLocalServiceUtil.signalToken(instanceId, tokenId);
		}
	}

	public String startWorkflow(long definitionId)
		throws WorkflowComponentException {

		if (!_useSAW) {
			try {
				WorkflowURL url = getWorkflowURL();

				url.setParameter(Constants.CMD, "startWorkflow");
				url.setParameter("definitionId", definitionId);

				return url.getContent();
			} catch (Exception e) {
				throw new WorkflowComponentException(e);
			}
		} else {
			String userId = _getLoggedInUserId();
			return SAWWorkflowLocalServiceUtil.startWorkflow(
					definitionId,userId);
		}
	}

	public Map updateTask(long taskId, String transition, Map parameterMap)
		throws WorkflowComponentException {

		try {
			String xml = updateTaskXml(taskId, transition, parameterMap);

			return WorkflowXMLUtil.parseErrors(xml);
		} catch (Exception e) {
			throw new WorkflowComponentException(e);
		}
	}

	public String updateTaskXml(
			long taskId, String transition, Map parameterMap)
		throws WorkflowComponentException {

		if (!_useSAW) {
			try {
				WorkflowURL url = getWorkflowURL();

				url.setParameter(Constants.CMD, "updateTaskXml");
				url.setParameter("taskId", taskId);
				url.setParameter("transition", transition);
				url.addParameterMap(parameterMap);

				return url.getContent();
			} catch (Exception e) {
				throw new WorkflowComponentException(e);
			}
		} else {
			String userId = _getLoggedInUserId();
			if (transition == null) {
				transition = "";
			}
			if (parameterMap == null) {
				parameterMap = new HashMap();
			}
			return SAWWorkflowLocalServiceUtil.updateTaskXml(
					taskId,transition, userId, parameterMap);
		}
	}

	protected WorkflowURL getWorkflowURL() {
		WorkflowURL url = null;

		try {
			url = new WorkflowURL(getUser());
		} catch (Exception e) {
			url = new WorkflowURL();
		}

		return url;
	}

	private String _getLoggedInUserId() throws WorkflowComponentException {
		User user = null;
		String userId = null;
		try {
			user = getUser();
		} catch (PortalException e1) {
			// Even if the user has not logged in, he should be able to see the 
			// list of definitions, instances, and tasks.
			user = null;
		} catch (SystemException e1) {
			throw new WorkflowComponentException(e1);
		}
		
		if(user != null){
			userId = String.valueOf(user.getUserId());;
		}
		else{
			userId = "%";
		}
		return userId;
	}

	private static final String _workflow = PortletProps.get("use.saw");
	private boolean _useSAW = _workflow.equals("true");

}