package com.bms.mdm.users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bms.constants.Constants;
import com.bms.context.ServerAppContext;
import com.bms.neetai.company.CompanyActionForm;
import com.bms.neetai.company.CompanyDBHelper;
import com.bms.neetai.userroles.UserRoleActionForm;
import com.bms.neetai.users.UserActionForm;
import com.bms.neetai.users.UserDBHelper;
import com.bms.struts.SCMAction;


public class LoginAction extends SCMAction {

	private static final  String TAG = "com.scm.mdm.users.LoginAction" ;
	private static final Logger logger = Logger.getLogger(TAG);




	public ActionForward execute(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		 ServerAppContext serverAppContext  = (ServerAppContext)request.getServletContext().getAttribute(Constants.STRUTS_APPLICATION_CONTEXT);

		UserActionForm userBean =(UserActionForm)form;
		
		CompanyDBHelper companyHelper = new CompanyDBHelper(); 
		UserDBHelper uDbHelper = new UserDBHelper();
		userBean = uDbHelper.validateUser(userBean);
		
		if (companyHelper.getCompanybyCompanyMasterId(userBean.getCompanyMasterId()).getIsActive() == Constants.ACTIVE) {

			if (userBean.getUserMasterId() != 0) {
				HttpSession session = request.getSession(true);
				session.setAttribute(Constants.IS_LOGGED_IN, Constants.IS_LOGGED_IN);
				session.setAttribute(Constants.USER_BEAN, userBean);
				session.setAttribute(Constants.SESSION_INFO_USERNAME, userBean.getFirstName());
				session.setAttribute(Constants.SESSION_INFO_USERLASTNAME, userBean.getLastName());
				session.setAttribute(Constants.SESSION_INFO_USER_ID, userBean.getUserMasterId());

				// update the last login date of the user

				// UserRoleActionForm
				// userRoleActionForm=serverAppContext.getUserRollByUserRollMasterId().get(userBean.getUserMasterId());
				if (userBean != null) {
					session.setAttribute(Constants.SESSION_INFO_USER_ROLE, userBean.getUserRolesMasterId());
					session.setAttribute(Constants.USER_ROLE, userBean.getUserRolesMasterId());
					session.setAttribute(Constants.USER_ID, userBean.getUserMasterId());
					session.setAttribute(Constants.COMPANY_ID, userBean.getCompanyMasterId());
					CompanyActionForm companyActionForm = serverAppContext.getCompanyByCompanyMasterId().get(userBean.getCompanyMasterId());
					session.setAttribute(Constants.COMPANY_ID, companyActionForm.getCompanyMasterId());
					session.setAttribute(Constants.COMPANY_NAME, companyActionForm.getName());
					System.out.println("Name " + userBean.getUserRoleName());
					if (userBean.getUserRolesMasterId() == 1) {
						return mapping.findForward("success");
					} else if (userBean.getUserRolesMasterId() == 2) {
						return mapping.findForward("success1");
					} else {
						return mapping.findForward("success2");
					}
				}
			}
		}
		// return action errors
		return mapping.findForward("error");
	}
}
