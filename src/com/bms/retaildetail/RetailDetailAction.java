package com.bms.retaildetail;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bms.constants.Constants;

public class RetailDetailAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		RetailDetailActionForm retailDetailBean = (RetailDetailActionForm)form;
		RetailDetailDBHelper retailDetailHelper = new RetailDetailDBHelper();
		HttpSession httpSession = request.getSession(true);
		int userid = (int)httpSession.getAttribute(Constants.USER_ID);
		boolean res = false;
		if(retailDetailHelper.findDataIsAvailableOrNotForRetailid(userid) == true){
			retailDetailBean.setRetailid(userid);
			retailDetailHelper.updateRetailDetail(retailDetailBean);
			res = true;
		}else{
			retailDetailBean.setRetailid(userid);
			retailDetailHelper.insertRetailDetail(retailDetailBean);
			res = true;
		}
		
		if(res==false){
			return mapping.findForward("error");
		}
		else{
			return mapping.findForward("success");
		}
	}
}
