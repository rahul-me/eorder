package com.bms.mapping.itemcustomerpricemapping;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bms.constants.Constants;
import com.bms.context.ServerAppContext;
import com.bms.neetai.users.UserActionForm;
import com.bms.struts.SCMAction;

public class ItemCustomerPriceMappingMasterAction extends SCMAction{

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		
			ItemCustomerPriceMappingActionForm itemCustomerActionForm=(ItemCustomerPriceMappingActionForm)form;
			ItemCustomerPriceMappingDBHelper itemSupplierMapDBHelper=new ItemCustomerPriceMappingDBHelper();
			ArrayList<ItemCustomerPriceMappingActionForm> itemCustomerActionFormsList=new ArrayList<>();
			
			HttpSession httpSession=request.getSession(true);
			UserActionForm userActionForm=(UserActionForm)httpSession.getAttribute(Constants.USER_BEAN);
			
			//ServerAppContext serverAppContext  = (ServerAppContext)request.getServletContext().getAttribute(Constants.STRUTS_APPLICATION_CONTEXT);
			
			SimpleDateFormat simpleDateFormat=new SimpleDateFormat(Constants.DATE_FORMAT);
			
			int companyId=(int)httpSession.getAttribute(Constants.COMPANY_ID);
			int customerId=itemCustomerActionForm.getUserMasterId();
			String itemId[]=request.getParameterValues("itemMasterId");
			String Price[]=request.getParameterValues("prices");
			
			for(int i=0;i<itemId.length;i++){
				
				ItemCustomerPriceMappingActionForm itemCustomerActionFormNew=new ItemCustomerPriceMappingActionForm();
				itemCustomerActionFormNew.setCompanyId(companyId);
				itemCustomerActionFormNew.setCustomerId(customerId);
				itemCustomerActionFormNew.setItemId(Integer.parseInt(itemId[i]));
				itemCustomerActionFormNew.setItemPrice(Float.parseFloat(Price[i]));
				itemCustomerActionFormNew.setItemStatus(1);
				itemCustomerActionFormNew.setCreatedDTTM(simpleDateFormat.format(new Date()));
				itemCustomerActionFormNew.setModifiedDTTM(simpleDateFormat.format(new Date()));
				itemCustomerActionFormNew.setCreatedBy(userActionForm.getUserMasterId());
				itemCustomerActionFormNew.setModifiedBy(userActionForm.getUserMasterId());
				
				itemCustomerActionFormsList.add(itemCustomerActionFormNew);
				
			}
			itemSupplierMapDBHelper.updatePrice(itemCustomerActionFormsList);
			
			return mapping.findForward(Constants.STRUTS_MAPPING_SUCCESS);
	}
}
