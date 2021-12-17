package com.bms.neetai.users;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bms.constants.Constants;
import com.bms.context.ServerAppContext;
import com.bms.neetai.company.CompanyActionForm;
import com.bms.neetai.company.CompanyDBHelper;
import com.bms.neetai.userroles.UserRoleActionForm;
import com.bms.neetai.userroles.UserRoleDBHelper;
import com.bms.struts.SCMAction;

public class UserViewAction extends SCMAction{

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		
		ServerAppContext serverAppContext  = (ServerAppContext)request.getServletContext().getAttribute(Constants.STRUTS_APPLICATION_CONTEXT);
		UserActionForm userActionForm=(UserActionForm)form;
		
		HttpSession httpSession=request.getSession(true);
		UserActionForm userActionForm2=(UserActionForm)httpSession.getAttribute(Constants.USER_BEAN);
		
		UserRoleDBHelper userRoleDBHelper = new UserRoleDBHelper();
		CompanyDBHelper companyHelper = new CompanyDBHelper(); 
		
		//ArrayList<UserRoleActionForm> roleList=serverAppContext.getUserRollByCompanyMasterId().get(userActionForm2.getCompanyMasterId());
		//ArrayList<UserRoleActionForm> roleList = userRoleDBHelper.getUserRollByCompanyId(userActionForm2.getCompanyMasterId());
		ArrayList<UserRoleActionForm> roleList = userRoleDBHelper.getActiveRolesForSpecificCompany(userActionForm2.getCompanyMasterId());
		//ArrayList<CompanyActionForm> companyList=serverAppContext.getCompanyListByActiveCompany();
		ArrayList<CompanyActionForm> companyList= companyHelper.fetchAllActiveCompanyRecords();			        
			if(request.getParameter("customerMasterId")!=null){
				int custid=Integer.parseInt(request.getParameter("customerMasterId"));
	        	UserActionForm  userBean = serverAppContext.getUserByUserMasterId().get(custid);
	        	userBean.setUserMasterId(custid);
	      		
	        	if(userBean.getIsActive()==Constants.USER_STATUS_ACTIVE)
	      			userBean.setIsActive(Constants.USER_STATUS_IN_ACTIVE);
	      		else
	      			userBean.setIsActive(Constants.USER_STATUS_ACTIVE);
	      			
				BeanUtils.copyProperties(form,userBean);
				return mapping.findForward("success1");
			}
	        if(request.getParameter("userMasterId")!=null)
	        {
	        	int userid=Integer.parseInt(request.getParameter("userMasterId"));
	        	UserActionForm  userBean = serverAppContext.getUserByUserMasterId().get(userid);
	        	if((userActionForm2.getUserRoleName()).equalsIgnoreCase("superadmin")){
	        		userBean.setCompanyList(companyList);
	        	}
	        	userBean.setRoleList(roleList);
	        	userBean.setUserMasterId(userid);
	        	if(userBean.getIsActive()==Constants.USER_STATUS_ACTIVE)
	      			userBean.setIsActive(Constants.USER_STATUS_IN_ACTIVE);
	      		else
	      			userBean.setIsActive(Constants.USER_STATUS_ACTIVE);
	        	BeanUtils.copyProperties(form,userBean);
	        	return mapping.findForward("success");
	        }
	        else 
	        {
	        	if((userActionForm2.getUserRoleName()).equalsIgnoreCase("superadmin")){
	        		userActionForm.setCompanyList(companyList);
	        	}
	        	userActionForm.setRoleList(roleList);
	        }
	        if(request.getParameter("hello")!=null){				
				return mapping.findForward("success1");
			}
	        else if(request.getParameter("hello1")!=null){
	        	return mapping.findForward("success");	
	        }
	       /* if((request.getParameter("customerMasterId"))==null){
	        	return mapping.findForward("success1");
	        }
	        else if((request.getParameter("userMasterId"))==null){
	        	 return mapping.findForward("success");
	        }
	        */
	      return mapping.findForward("success");
			
			
					
			}		
}
