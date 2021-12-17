package com.bms.retaildetail;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bms.constants.Constants;

public class RetailDetailViewAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,HttpServletResponse response) throws Exception {
		HttpSession httpSession = request.getSession(true);
		int userid = (int)httpSession.getAttribute(Constants.USER_ID);
		RetailDetailDBHelper retailDetailHelper = new RetailDetailDBHelper();
		if(retailDetailHelper.findTableIsEmptyORNot() == false){
			if(retailDetailHelper.findDataIsAvailableOrNotForRetailid(userid)== true){
				RetailDetailActionForm retailDetailBean = retailDetailHelper.getRetailDetailByRetailId(userid);
				BeanUtils.copyProperties(form, retailDetailBean);
			}
		}
		return mapping.findForward("success");
	}
}
