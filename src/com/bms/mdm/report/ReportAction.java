package com.bms.mdm.report;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bms.constants.Constants;
import com.bms.mdm.item.ItemActionForm;
import com.bms.mdm.item.ItemDBHelper;
import com.bms.mdm.itemcategories.ItemCategoriesDBHelper;
import com.bms.mdm.itemcategories.ItemCategoryActionForm;
import com.bms.neetai.users.UserActionForm;
import com.bms.struts.SCMAction;

public class ReportAction extends SCMAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ReportActionForm reportActionForm=(ReportActionForm)form;
		
		/*SitesDBHelper sitesDBHelper=new SitesDBHelper();
		ArrayList<SitesActionForm> siteList=sitesDBHelper.fetchAllRecords();
		*/
		HttpSession session=request.getSession(true);
		UserActionForm userActionForm=new UserActionForm();
		userActionForm=(UserActionForm) session.getAttribute(Constants.USER_BEAN);
		
		int userId=userActionForm.getUserMasterId();
	  
		String report=request.getParameter("report");
		
		ItemDBHelper itemDBHelper=new ItemDBHelper();
		ArrayList<ItemActionForm> itemList=itemDBHelper.fetchAllRecords();
		
		ItemCategoriesDBHelper itemCategoriesDBHelper=new ItemCategoriesDBHelper();
		ArrayList<ItemCategoryActionForm> itemCategoryList=itemCategoriesDBHelper.fetchAllRecords();
		
		try
		{
		reportActionForm.setItemList(itemList);
		reportActionForm.setItemCategoryList(itemCategoryList);
		}catch(Exception e){
			
		}
		
		// TODO Auto-generated method stub
		return mapping.findForward(report);
	}

}
