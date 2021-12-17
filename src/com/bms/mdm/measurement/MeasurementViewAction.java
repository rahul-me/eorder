package com.bms.mdm.measurement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bms.constants.Constants;
import com.bms.context.ServerAppContext;
import com.bms.struts.SCMAction;

public class MeasurementViewAction extends SCMAction{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		MeasurementActionForm measurementActionForm=(MeasurementActionForm)form;
		ServerAppContext serverAppContext  = (ServerAppContext)request.getServletContext().getAttribute(Constants.STRUTS_APPLICATION_CONTEXT);
		
	 try{   
		    if(request.getParameter("measurementId")!=null)
		    {
	        int measurementId=Integer.parseInt(request.getParameter("measurementId"));
	        System.out.println("helloworld"+measurementId);   
	        measurementActionForm=serverAppContext.getMeasurementByMeasurementMasterId().get(measurementId);
	        BeanUtils.copyProperties(form,measurementActionForm);
	        }
	        
	     }
	     catch(Exception e)
			{
				e.printStackTrace();
			}
			return mapping.findForward("success");
			
	}

}
