package com.bms.struts;


import java.util.HashMap;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import org.apache.struts.taglib.logic.ConditionalTagBase;

import com.bms.constants.Constants;
import com.bms.context.ServerAppContext;

public class PraestaRoleCheckTag extends ConditionalTagBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8462996385853408911L;
	private String rolePermitted;
	private String componentName; 
	

	@Override
	protected boolean condition() throws JspException {
		// TODO Auto-generated method stub
		HttpSession request=(HttpSession)pageContext.getSession();
		
		/*if(request.getAttribute(Constants.SESSION_INFO_USER_ROLE)!=null){
			
			if(rolePermitted.contains(String.valueOf(request.getAttribute(Constants.SESSION_INFO_USER_ROLE)))){
				return true;
			}
		}
		return false;
	}	
*/		

		HashMap<Integer, String> accessMap = ((ServerAppContext)request.getServletContext().getAttribute(Constants.STRUTS_APPLICATION_CONTEXT)).getAccessRoles();
		
		if(accessMap!=null)
		{
			if(accessMap.containsKey(request.getAttribute(Constants.USER_ROLE)))
			{
				if(accessMap.get(request.getAttribute(Constants.USER_ROLE)).contains(componentName))
					return true;
			}
		}
		
		return false;
		
	}

	/**
	 * @return the componentName
	 */
	public String getComponentName() {
		return componentName;
	}

	/**
	 * @param componentName the componentName to set
	 */
	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}

	/**
	 * @return the rolePermitted
	 */
	public String getRolePermitted() {
		return rolePermitted;
	}

	/**
	 * @param rolePermitted the rolePermitted to set
	 */
	public void setRolePermitted(String rolePermitted) {
		this.rolePermitted = rolePermitted;
	}

}
