package com.bms.mapping.itemcustomerpricemapping;

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
import com.bms.mdm.area.AreaActionForm;
import com.bms.mdm.area.AreaDBHelper;
import com.bms.mdm.item.ItemActionForm;
import com.bms.neetai.users.UserActionForm;
import com.bms.neetai.users.UserDBHelper;
import com.bms.order.ordermaster.OrderMasterActionForm;
import com.bms.order.ordermaster.OrderMasterDBHelper;
import com.bms.struts.SCMAction;

public class ItemCustomerPriceMappingViewAction extends SCMAction{

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		System.out.println("Item-Supplier Mapping");
		
		HttpSession session=request.getSession(true);
		//UserActionForm userActionForm=new UserActionForm();
		//userActionForm=(UserActionForm) session.getAttribute(Constants.USER_BEAN);
		ServerAppContext serverAppContext  = (ServerAppContext)request.getServletContext().getAttribute(Constants.STRUTS_APPLICATION_CONTEXT);
		int compid=(int)session.getAttribute(Constants.COMPANY_ID);
		
		ItemCustomerPriceMappingActionForm itemCustomerActionForm=(ItemCustomerPriceMappingActionForm)form;
		//ItemSupplierMapDBHelper itemSupplierMapDBHelper=new ItemSupplierMapDBHelper();
		//UserSiteMappingDBHelper userSiteMappingDBHelper=new UserSiteMappingDBHelper();
		
		//ArrayList<UserSiteMappingActionForm> userSiteMap=new ArrayList<UserSiteMappingActionForm>();
		
		//ItemDBHelper itemDBHelper=new ItemDBHelper();
		try
		{
		
			ArrayList<ItemActionForm> itemList=serverAppContext.getItemByCompanyId().get(compid);		
			ArrayList<UserActionForm>userList=serverAppContext.getUserByCompanyId().get(compid);
			if(itemList!=null || userList!=null)
			{		
			
			itemCustomerActionForm.setItemList(itemList);
			itemCustomerActionForm.setUserList(userList);
			}
			
			//ArrayList<ItemActionForm> itemList=itemDBHelper.fetchAllActiveItemRecords();
		
		//Iterator<UserSiteMappingActionForm> userSiteIterator=userSiteList.iterator();
		/*StringBuffer ItemLabel=new StringBuffer();
		for(int i= 0; i<itemList.size(); i++)
		{
			ItemLabel.delete(0, ItemLabel.length());
			ItemLabel.append(itemList.get(i).getItemName());
			
			ItemLabel.append("/");
			System.out.println(itemList.get(i).getItemName());
			System.out.println(itemList.get(i).getItemId());
			SitesDBHelper sitesDBHelper=new SitesDBHelper();
			SitesActionForm sitesActionForm=sitesDBHelper.getSiteBySiteId(itemList.get(i).getSupplierId());
			System.out.println(sitesActionForm.getSiteName());
			ItemLabel.append(sitesActionForm.getSiteName());
			
			String str=ItemLabel.toString();
			itemList.get(i).setItemLabel(str);
			System.out.println("ItemId is"+itemList.get(i).getItemId() +"Item Name is" +itemList.get(i).getItemName());
		}*/
		//itemSupplierActionForm.setItemList(itemList);
		
		/*SupplierDBHelper supplierDBHelper=new SupplierDBHelper();
		ArrayList<SupplierActionForm> supplierList=supplierDBHelper.fetchAllRecords();
		itemCustomerActionForm.setUserList(supplierList);*/
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		BeanUtils.copyProperties(form,itemCustomerActionForm);
		
		return mapping.findForward("success");
		
	}
}
