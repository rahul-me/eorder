package com.bms.mdm.item;

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

import com.bms.constants.Constants;
import com.bms.context.ServerAppContext;
import com.bms.neetai.users.UserActionForm;
import com.bms.struts.SCMAction;


public class ItemMasterAction extends SCMAction{

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
         	
		   
		  ItemActionForm itemActionForm=(ItemActionForm)form;		  
		  ItemDBHelper itemDBHelper=new  ItemDBHelper(); 
		  ServerAppContext serverAppContext  = (ServerAppContext)request.getServletContext().getAttribute(Constants.STRUTS_APPLICATION_CONTEXT);
			
			HttpSession httpSession=request.getSession(true);
			UserActionForm userActionForm=(UserActionForm)httpSession.getAttribute(Constants.USER_BEAN);
			int compid=(int) httpSession.getAttribute(Constants.COMPANY_ID);
			itemActionForm.setCreatedBy(userActionForm.getUserMasterId());
			
		  
		  SimpleDateFormat simpleDateFormat=new SimpleDateFormat(Constants.DATE_FORMAT);
		  itemActionForm.setCreatedDTTM(simpleDateFormat.format(new Date()));		  
		  int itemid=Integer.parseInt(request.getParameter("itemMasterId"));
		  if(itemid>0)
		  {
			  	
			  	itemActionForm.setCompanyMasterId(compid);
			  	itemActionForm.setIsActive(Integer.parseInt(request.getParameter("active")));			  	
			    itemDBHelper.updateItemEntry(itemActionForm);
			    
				ArrayList<ItemActionForm>itemList=itemDBHelper.fetchAllRecords();				
				serverAppContext.setItemList(itemList);				
				
				ArrayList<ItemActionForm>itemActivelist=itemDBHelper.fetchAllActiveItemRecords();				
				serverAppContext.setItemListByActiveItem(itemActivelist);
								
				HashMap<Integer,ItemActionForm >itembyitemid=new HashMap<Integer,ItemActionForm>();
				itembyitemid=serverAppContext.getItemByItemMasterId();
				itembyitemid.put(itemActionForm.getItemMasterId(),itemActionForm);
				serverAppContext.setItemByItemMasterId(itembyitemid);
				
				ArrayList<ItemActionForm>itemByCompanyList=itemDBHelper.getItemByCompanyId(compid);
				HashMap<Integer,ArrayList<ItemActionForm>>itemByCompanyId=new HashMap<Integer,ArrayList<ItemActionForm>>();
				itemByCompanyId=serverAppContext.getItemByCompanyId();
				itemByCompanyId.put(compid, itemByCompanyList);
				serverAppContext.setItemByCompanyId(itemByCompanyId);
				return mapping.findForward(Constants.STRUTS_MAPPING_SUCCESS);
		  }
		  else
		  {
			  
			  	itemActionForm.setCompanyMasterId(compid);
			  	System.out.println("hello : "+request.getParameter("active"));
			  	itemActionForm.setIsActive(Integer.parseInt(request.getParameter("active")));			  	
			  	
			  	int status=itemDBHelper.addItem(itemActionForm);
			  	if(status>0);
				
				ArrayList<ItemActionForm>itemList=serverAppContext.getItemList();
				if(itemList!=null){
				itemList.add(itemActionForm);
				serverAppContext.setItemList(itemList);
				}
				ArrayList<ItemActionForm>itemActivelist=serverAppContext.getItemListByActiveItem();
				itemActivelist.add(itemActionForm);
				serverAppContext.setItemListByActiveItem(itemActivelist);
				
				itemActionForm.setItemMasterId(status);				
				HashMap<Integer,ItemActionForm >itembyitemid=new HashMap<Integer,ItemActionForm>();
				itembyitemid=serverAppContext.getItemByItemMasterId();
				itembyitemid.put(status,itemActionForm);
				serverAppContext.setItemByItemMasterId(itembyitemid);
				
				HashMap<Integer,ArrayList<ItemActionForm>>itemByCompanyId=new HashMap<Integer,ArrayList<ItemActionForm>>();		
				
				ArrayList<ItemActionForm> itemListByCompany=itemDBHelper.getAlldistinctCompany();
				if(itemListByCompany!=null)
				{
					for(int i=0;i<itemListByCompany.size();i++)
					{
						ArrayList<ItemActionForm> itemListByCompanyId= itemDBHelper.getItemByCompanyId(itemListByCompany.get(i).getCompanyMasterId());
						if(itemListByCompanyId!=null)
						{
							int id=itemListByCompanyId.get(0).getCompanyMasterId();
							itemByCompanyId.put(id, itemListByCompanyId);
						}
					}
				}
				serverAppContext.setItemByCompanyId(itemByCompanyId);
				
				
				/*itemByCompanyId=serverAppContext.getItemByCompanyId();
				ArrayList<ItemActionForm>itemByCompanyList=new ArrayList<>();
				
				if(itemByCompanyId.size()>1){
					itemByCompanyList=itemByCompanyId.get(compid);
				}

				itemByCompanyList.add(itemActionForm);
				itemByCompanyId.put(compid, itemByCompanyList);
				serverAppContext.setItemByCompanyId(itemByCompanyId);*/
				
				
				return mapping.findForward(Constants.STRUTS_MAPPING_SUCCESS);
		  
		  }		  
		
			}
	
		
	  
}
