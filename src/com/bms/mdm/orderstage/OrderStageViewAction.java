package com.bms.mdm.orderstage;

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
import com.bms.mdm.item.ItemDBHelper;
import com.bms.mdm.measurement.MeasurementActionForm;
import com.bms.mdm.measurement.MeasurementDBHelper;
import com.bms.neetai.company.CompanyActionForm;
import com.bms.neetai.company.CompanyDBHelper;
import com.bms.neetai.users.UserActionForm;
import com.bms.struts.SCMAction;



public class OrderStageViewAction extends SCMAction {
    
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("parthgandhi");
		OrderStageActionForm orderStageActionForm=(OrderStageActionForm)form;
		OrderStageDBHelper orderStageDBHelper=new OrderStageDBHelper();
		ServerAppContext serverAppContext  = (ServerAppContext)request.getServletContext().getAttribute(Constants.STRUTS_APPLICATION_CONTEXT);		
		 try{   
			   if(request.getParameter("OrderStageMasterId")!=null)
			   {
		        int OrderStageMasterId=Integer.parseInt(request.getParameter("OrderStageMasterId"));
		        System.out.println("hello world"+OrderStageMasterId);
		        orderStageActionForm=serverAppContext.getOrderStageByOrderStageMasterId().get(OrderStageMasterId);
		        orderStageActionForm=orderStageDBHelper.getOrderStageById(OrderStageMasterId);
		        BeanUtils.copyProperties(form,orderStageActionForm);
		        }
		     }
		     catch(Exception e)
				{
					e.printStackTrace();
				}
				return mapping.findForward("success");
				
			
				}
		
		        
}      
		        
		      
				
			
				
	



