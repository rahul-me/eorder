package com.bms.mdm.settings;

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
import com.bms.neetai.userroles.UserRoleActionForm;
import com.bms.neetai.userroles.UserRoleDBHelper;
import com.bms.neetai.users.UserActionForm;
import com.bms.struts.SCMAction;

public class AccessControlViewAction extends SCMAction {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		UserRoleDBHelper roleHelper = new UserRoleDBHelper();
		// TODO Auto-generated method stub
		HttpSession session=request.getSession(true);
		int companyid=(int)session.getAttribute(Constants.COMPANY_ID);
		ArrayList<UserRoleActionForm> userrollList= ((ServerAppContext) request.getServletContext().getAttribute(Constants.STRUTS_APPLICATION_CONTEXT)).getUserRollByCompanyMasterId().get(companyid);
		//ArrayList<UserRoleActionForm> userrollList = roleHelper.getUserRollByCompanyId(companyid);
	
		
		AccessControlBean accessControlBean=new AccessControlBean();
		accessControlBean.setRoleList(userrollList);
		
		
		BeanUtils.copyProperties(form,accessControlBean);
		
		return mapping.findForward(Constants.STRUTS_MAPPING_SUCCESS);
	}
}
