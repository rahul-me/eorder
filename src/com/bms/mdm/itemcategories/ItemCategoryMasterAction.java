package com.bms.mdm.itemcategories;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionRedirect;

import com.bms.constants.Constants;
import com.bms.context.ServerAppContext;
import com.bms.mdm.item.ItemActionForm;
import com.bms.neetai.users.UserActionForm;
import com.bms.struts.SCMAction;

public class ItemCategoryMasterAction extends SCMAction{

	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		HttpSession httpSession=request.getSession(true);
		UserActionForm userActionForm=(UserActionForm)httpSession.getAttribute(Constants.USER_BEAN);
		int compid=(int)httpSession.getAttribute(Constants.COMPANY_ID);
		
		ItemCategoriesDBHelper itemCategoriesDBHelper=new ItemCategoriesDBHelper();
		ItemCategoryActionForm itemCategoryActionForm=(ItemCategoryActionForm)form;
		ServerAppContext serverAppContext  = (ServerAppContext)request.getServletContext().getAttribute(Constants.STRUTS_APPLICATION_CONTEXT);
	    itemCategoryActionForm.setCreatedBy(userActionForm.getUserMasterId());
		
		 SimpleDateFormat simpleDateFormat=new SimpleDateFormat(Constants.DATE_FORMAT);
		 itemCategoryActionForm.setCreatedDTTM(simpleDateFormat.format(new Date()));
		 if(request.getParameter("itemCategoryMasterId")!=null)
		 {
			 int itemcatid=Integer.parseInt(request.getParameter("itemCategoryMasterId"));
			 if(itemcatid>0){
				 itemCategoryActionForm.setCompanyMasterId(compid);				 
				 int id=itemCategoriesDBHelper.updateItemCategoryEntry(itemCategoryActionForm);
					
				 
		      		ArrayList<ItemCategoryActionForm>itemCategoryFormList=itemCategoriesDBHelper.fetchAllRecords();
		    		serverAppContext.setItemCategoryList(itemCategoryFormList);
		    		
		    		ArrayList<ItemCategoryActionForm>itemCategoryActiveFormList=itemCategoriesDBHelper.fetchAllActiveItemCategoriesRecords();
		    		serverAppContext.setItemCategoryListByActiveitemCategory(itemCategoryActiveFormList);
		    		
		    		HashMap<Integer, ItemCategoryActionForm>itemCategorybyid=new HashMap<Integer,ItemCategoryActionForm>();    		
		    		itemCategorybyid=serverAppContext.getItemCategoryByItemCategoryMasterId();
		    		itemCategorybyid.put(itemCategoryActionForm.getItemCategoryMasterId(),itemCategoryActionForm);
		    		serverAppContext.setItemCategoryByItemCategoryMasterId(itemCategorybyid);
		    		
		    			 
				 	ArrayList<ItemCategoryActionForm>itemCategoryByCompanyList=itemCategoriesDBHelper.getItemCategoryByCompanyId(compid);
					HashMap<Integer,ArrayList<ItemCategoryActionForm>>itemCategoryByCompanyId=new HashMap<Integer,ArrayList<ItemCategoryActionForm>>();
					itemCategoryByCompanyId=serverAppContext.getItemCategoryByCompanyId();
					itemCategoryByCompanyId.put(compid, itemCategoryByCompanyList);
					serverAppContext.setItemCategoryByCompanyId(itemCategoryByCompanyId);
					
				 
				 return mapping.findForward(Constants.STRUTS_MAPPING_SUCCESS);
			 }
			 else
			 {
				 itemCategoryActionForm.setCompanyMasterId(compid);
				 int id=itemCategoriesDBHelper.addItemCategory(itemCategoryActionForm);
				 
				 	ArrayList<ItemCategoryActionForm>itemCategoryFormList=serverAppContext.getItemCategoryList();
				 	if(itemCategoryFormList!=null){
					itemCategoryFormList.add(itemCategoryActionForm);
		    		serverAppContext.setItemCategoryList(itemCategoryFormList);
				 	}
		    		ArrayList<ItemCategoryActionForm>itemCategoryActiveFormList=serverAppContext.getItemCategoryListByActiveitemCategory();
		    		if(itemCategoryActiveFormList!=null){
		    		itemCategoryActiveFormList.add(itemCategoryActionForm);
		    		serverAppContext.setItemCategoryListByActiveitemCategory(itemCategoryActiveFormList);
		    		}
		    		itemCategoryActionForm.setItemCategoryMasterId(id);
		    		
		    		HashMap<Integer, ItemCategoryActionForm>itemCategorybyid=new HashMap<Integer,ItemCategoryActionForm>();
		    		itemCategorybyid=serverAppContext.getItemCategoryByItemCategoryMasterId();
		    		itemCategorybyid.put(id,itemCategoryActionForm);
		    		serverAppContext.setItemCategoryByItemCategoryMasterId(itemCategorybyid);
		    		
				 
					 HashMap<Integer, ArrayList<ItemCategoryActionForm>>itemCategoryByCompanyId=new HashMap<Integer,ArrayList<ItemCategoryActionForm>>();
					 itemCategoryByCompanyId=serverAppContext.getItemCategoryByCompanyId();
					 ArrayList<ItemCategoryActionForm>itemCategoryByCompanyList=itemCategoryByCompanyId.get(compid);
					 if(itemCategoryByCompanyList!=null){
					 itemCategoryByCompanyList.add(itemCategoryActionForm);
					 itemCategoryByCompanyId.put(compid, itemCategoryByCompanyList);
					 serverAppContext.setItemCategoryByCompanyId(itemCategoryByCompanyId);
					 }
				 return mapping.findForward(Constants.STRUTS_MAPPING_SUCCESS);
			 }
			 
		 }
		 
		 
        
        return mapping.findForward(Constants.STRUTS_MAPPING_SUCCESS);
        
		}
}
