package com.bms.mdm.item;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bms.constants.Constants;
import com.bms.context.ServerAppContext;
import com.bms.mdm.itemcategories.ItemCategoryActionForm;
import com.bms.mdm.measurement.MeasurementActionForm;
import com.bms.mdm.measurement.MeasurementDBHelper;
import com.bms.neetai.users.UserActionForm;
import com.bms.struts.SCMAction;

public class ItemViewAction extends SCMAction{

	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		ItemActionForm itemActionForm=(ItemActionForm)form;
		ItemDBHelper itemDBHelper = new ItemDBHelper();
		ServerAppContext serverAppContext  = (ServerAppContext)request.getServletContext().getAttribute(Constants.STRUTS_APPLICATION_CONTEXT);
		//ItemDBHelper itemDBHelper=new ItemDBHelper();
		
		//UserActionForm actionForm=(UserActionForm)session.getAttribute(Constants.USER_BEAN);
		HttpSession session=request.getSession(true);
		int compid=(int) session.getAttribute(Constants.COMPANY_ID);
		itemActionForm.setIsActive(1);
		//int userId=actionForm.getUserMasterId();
		try
		{
			if(request.getParameter("itemId")!=null)
			{					
			int itemId=Integer.parseInt(request.getParameter("itemId"));			
			//itemActionForm=serverAppContext.getItemByItemMasterId().get(itemId);
			itemActionForm=itemDBHelper.getItemById(itemId);
			
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		ArrayList<ItemCategoryActionForm> itemCategoryList=serverAppContext.getItemCategoryByCompanyId().get(compid);		
		//ArrayList<MeasurementActionForm> measurementList=serverAppContext.getMeasurementByCompanyMasterId().get(compid);
		ArrayList<UserActionForm> userList=serverAppContext.getUserByCompanyId().get(compid);
		ArrayList<MeasurementActionForm> measurementList= new ArrayList<MeasurementActionForm>(); 
		
		MeasurementDBHelper measuresHelper = new MeasurementDBHelper();
		if(measuresHelper.findTrueIfTableContainsMinOneRow()){
			if(measuresHelper.findTrueIfTableHasDataForSpecificCompanyOWFalse(compid)){
				measurementList = measuresHelper.getActiveMeasuresSpecificForCompany(compid);
			}
		}
		
		if(itemCategoryList!=null && measurementList!=null)				
		itemActionForm.setItemCategoryList(itemCategoryList);			
		itemActionForm.setMeasurementList(measurementList);
		itemActionForm.setUserList(userList);
		
	
		BeanUtils.copyProperties(form,itemActionForm);		
		return mapping.findForward("success");
	}
}
