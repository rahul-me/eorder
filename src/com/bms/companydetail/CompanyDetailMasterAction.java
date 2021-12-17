package com.bms.companydetail;

import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.action.ActionForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bms.constants.Constants;
import com.bms.neetai.company.CompanyActionForm;
import com.bms.neetai.company.CompanyDBHelper;

public class CompanyDetailMasterAction extends DispatchAction {
	
	public static CompanyDBHelper companyHelper;
	
	public CompanyDetailMasterAction(){
		companyHelper = new CompanyDBHelper();
	}
	public ActionForward Submit(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		CompanyActionForm companyBean = (CompanyActionForm)form;
		int companyid = 0;
		try{
		HttpSession httpSession = request.getSession(true);
		companyid = (int)httpSession.getAttribute(Constants.COMPANY_ID);
		}catch(Exception e){
			System.out.println(e);
		}
		if(companyid!=0){
		CompanyActionForm companyBeanOfSpecificId = companyHelper.getCompanybyCompanyMasterId(companyid);
		companyBeanOfSpecificId.setCstidno(companyBean.getCstidno());
		companyBeanOfSpecificId.setVatidno(companyBean.getVatidno());
		companyBeanOfSpecificId.setSaletax(companyBean.getSaletax());
		companyHelper.updateCompany(companyBeanOfSpecificId);
		}
		return mapping.findForward("success");
	}	
}
