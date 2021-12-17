package com.bms.neetai.userroles;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bms.constants.Constants;
import com.bms.context.ServerAppContext;
import com.bms.neetai.company.CompanyActionForm;
import com.bms.struts.SCMAction;

public class UserRoleViewAction extends SCMAction{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		UserRoleActionForm userRoleActionForm=(UserRoleActionForm)form;
		ServerAppContext serverAppContext  = (ServerAppContext)request.getServletContext().getAttribute(Constants.STRUTS_APPLICATION_CONTEXT);		
		ArrayList<CompanyActionForm> companyList=serverAppContext.getCompanyList();
        if(request.getParameter("UserRolesMasterId")!=null)
        {
        	int userrollid=Integer.parseInt(request.getParameter("UserRolesMasterId"));
        	userRoleActionForm=serverAppContext.getUserRollByUserRollMasterId().get(userrollid);
        }
        userRoleActionForm.setCompanyList(companyList);
        
        BeanUtils.copyProperties(form,userRoleActionForm);
        return mapping.findForward("success");
	}
}
