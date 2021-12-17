package com.bms.mdm.area;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bms.struts.SCMAction;

public class AreaViewAction extends SCMAction{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		AreaActionForm areaActionForm=(AreaActionForm)form;
		AreaDBHelper areaDBHelper=new AreaDBHelper();
		//ServerAppContext serverAppContext  = (ServerAppContext)request.getServletContext().getAttribute(Constants.STRUTS_APPLICATION_CONTEXT);
       if(request.getParameter("areaMasterId")!=null){
    	   
    	   areaActionForm=areaDBHelper.getAreaByAreaId(Integer.parseInt(request.getParameter("areaMasterId")));
    	   BeanUtils.copyProperties(form,areaActionForm);
       }
        //userRoleActionForm=null;
      
        
        
        return mapping.findForward("success");
	}
}
