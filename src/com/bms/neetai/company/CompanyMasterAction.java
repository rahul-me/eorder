package com.bms.neetai.company;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bms.constants.Constants;
import com.bms.context.ServerAppContext;
import com.bms.neetai.userroles.UserRoleActionForm;
import com.bms.neetai.userroles.UserRoleDBHelper;
import com.bms.neetai.users.UserActionForm;
import com.bms.struts.SCMAction;



public class CompanyMasterAction extends SCMAction {
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		CompanyActionForm companyActionForm=(CompanyActionForm)form;
		CompanyDBHelper companyDBHelper=new  CompanyDBHelper(); 
		 
		
		HttpSession httpSession=request.getSession(true);
		UserActionForm userActionForm=(UserActionForm)httpSession.getAttribute(Constants.USER_BEAN);
		companyActionForm.setCreatedBy(userActionForm.getUserMasterId());
	 
		  SimpleDateFormat simpleDateFormat=new SimpleDateFormat(Constants.DATE_FORMAT);
		 companyActionForm.setCreatedDTTM(simpleDateFormat.format(new Date()));
		
         	
		 int companyid=Integer.parseInt(request.getParameter("companyMasterId"));         	
         	if(companyid>0)
         	{   		
         		companyDBHelper.updateCompany(companyActionForm);
         		ServerAppContext serverAppContext  = (ServerAppContext)request.getServletContext().getAttribute(Constants.STRUTS_APPLICATION_CONTEXT);
         		ArrayList<CompanyActionForm>companyList=companyDBHelper.getAllCompany();
         		serverAppContext.setCompanyList(companyList);
         		
         		ArrayList<CompanyActionForm>companyActiveList=companyDBHelper.fetchAllActiveCompanyRecords();
         		serverAppContext.setCompanyListByActiveCompany(companyActiveList);
         		
         		HashMap<Integer,CompanyActionForm >companybymasterid=new HashMap<Integer,CompanyActionForm>();
         		companybymasterid=serverAppContext.getCompanyByCompanyMasterId();
         		companybymasterid.put(companyActionForm.getCompanyMasterId(),companyActionForm);
         		serverAppContext.setCompanyByCompanyMasterId(companybymasterid);
         		return mapping.findForward(Constants.STRUTS_MAPPING_SUCCESS);
         	}
         	else
    {
        int status=companyDBHelper.addCompany(companyActionForm);
        if(status>0){
        	
        	UserRoleDBHelper roleHelper = new UserRoleDBHelper();
        	
			ArrayList<CompanyActionForm>companyList=companyDBHelper.getAllCompany();
			ServerAppContext serverAppContext  = (ServerAppContext)request.getServletContext().getAttribute(Constants.STRUTS_APPLICATION_CONTEXT);
     		serverAppContext.setCompanyList(companyList);
     		
     		HashMap<Integer,ArrayList<UserRoleActionForm>> userRolesByCompanyIdhm = serverAppContext.getUserRollByCompanyMasterId();
     		userRolesByCompanyIdhm.put(status, roleHelper.getUserRollByCompanyId(status));
     		ArrayList<CompanyActionForm>companyActiveList=companyDBHelper.fetchAllActiveCompanyRecords();
     		serverAppContext.setCompanyListByActiveCompany(companyActiveList);
     		
     		companyActionForm.setCompanyMasterId(status);
     		HashMap<Integer,CompanyActionForm >companybymasterid=new HashMap<Integer,CompanyActionForm>();
     		companybymasterid=serverAppContext.getCompanyByCompanyMasterId();
     		companybymasterid.put(status,companyActionForm);
     		serverAppContext.setCompanyByCompanyMasterId(companybymasterid);
     		
        }
        return mapping.findForward(Constants.STRUTS_MAPPING_SUCCESS);
     		
		 
    }	 
				
	}
  
}
