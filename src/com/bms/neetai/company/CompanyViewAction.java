package com.bms.neetai.company;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bms.constants.Constants;
import com.bms.context.ServerAppContext;
import com.bms.struts.SCMAction;


public class CompanyViewAction extends SCMAction {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
     
        
        CompanyActionForm companyActionForm=(CompanyActionForm)form;
    	ServerAppContext serverAppContext  = (ServerAppContext)request.getServletContext().getAttribute(Constants.STRUTS_APPLICATION_CONTEXT);        
     try{   
    	 
    	 if(request.getParameter("CompanyId")!=null)
    	 {
        int companyid=Integer.parseInt(request.getParameter("CompanyId"));     
        companyActionForm=serverAppContext.getCompanyByCompanyMasterId().get(companyid);
        BeanUtils.copyProperties(form,companyActionForm);
        return mapping.findForward("success");
        }
     }
     catch(Exception e)
		{
			e.printStackTrace();
		}
     	companyActionForm.setIsActive(1);
		return mapping.findForward("success");
		
	
		}
		
	}
	


