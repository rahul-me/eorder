package com.bms.mdm.packages;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bms.constants.Constants;
import com.bms.neetai.users.UserActionForm;

public class PackagesMasterAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		System.out.println("Before processing of Master Action");
		System.out.println("Have You come here???");
		PackagesActionForm packagesActionForm = (PackagesActionForm) form;
		PackagesDBHelper pkgDBHelper = new PackagesDBHelper();
		
		HttpSession httpSession=request.getSession(true);
		UserActionForm userActionForm=(UserActionForm)httpSession.getAttribute(Constants.USER_BEAN);
		int compid=(int) httpSession.getAttribute(Constants.COMPANY_ID);
		

		if (request.getParameter("packageMasterId").equals("0")) {
			Date date=new Date();
			SimpleDateFormat simpleDateFormat=new SimpleDateFormat(Constants.DATE_FORMAT);
			String toDayDate = simpleDateFormat.format(date);
			System.out.println(toDayDate+" Hello");
			packagesActionForm.setCreatedDate(toDayDate);
			packagesActionForm.setCreatedDTTM(simpleDateFormat.format(date));
			packagesActionForm.setCreatedBy(userActionForm.getUserMasterId());
			pkgDBHelper.addPkg(packagesActionForm);			
		} else {
			int pkgId = Integer.parseInt(request.getParameter("packageMasterId"));
			packagesActionForm.setPackageMasterId(pkgId);			
			pkgDBHelper.updatePkgProperty(packagesActionForm);
			
			
			
			
		}

		System.out.println("After processing of Master Action");
		return mapping.findForward("success");

	}
}
