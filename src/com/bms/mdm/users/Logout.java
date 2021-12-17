package com.bms.mdm.users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bms.struts.SCMAction;

public class Logout extends SCMAction {
	@Override
	public ActionForward execute(ActionMapping arg0, ActionForm arg1,
			HttpServletRequest arg2, HttpServletResponse arg3) throws Exception {
		arg2.getSession().invalidate();
		// TODO Auto-generated method stub
		 return arg0.findForward("success");
	}


}
