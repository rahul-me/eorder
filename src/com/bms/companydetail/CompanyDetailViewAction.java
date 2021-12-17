package com.bms.companydetail;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.lang.reflect.InvocationTargetException;

import com.bms.constants.Constants;
import com.bms.neetai.company.CompanyActionForm;
import com.bms.neetai.company.CompanyDBHelper;

public class CompanyDetailViewAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		CompanyActionForm companyBean = null;
		CompanyDBHelper companyHelper = new CompanyDBHelper();
		int companyId = 0;
		try {
			HttpSession httpSession = request.getSession(true);
			companyId = (int) httpSession.getAttribute(Constants.COMPANY_ID);
			companyBean = companyHelper.getCompanybyCompanyMasterId(companyId);
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			if (companyBean != null) {
				BeanUtils.copyProperties(form, companyBean);
			}
		} catch (InvocationTargetException ite) {
			System.out.println(ite);
		} catch (IllegalAccessException iae) {
			System.out.println(iae);
		}
		return mapping.findForward("success");
	}

}
