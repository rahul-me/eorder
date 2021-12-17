package com.bms.order.ordermaster;

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
import com.bms.mdm.item.ItemActionForm;
import com.bms.mdm.item.ItemDBHelper;
import com.bms.neetai.users.UserActionForm;
import com.bms.neetai.users.UserDBHelper;
import com.bms.struts.SCMAction;



public class OrderMasterViewAction extends SCMAction{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		
		HttpSession session=request.getSession(true);
		int companyid=(int)session.getAttribute(Constants.COMPANY_ID);
		int roleId=(int)session.getAttribute(Constants.USER_ROLE);
		
		//ServerAppContext serverAppContext  = (ServerAppContext)request.getServletContext().getAttribute(Constants.STRUTS_APPLICATION_CONTEXT);
		HttpSession httpSession=request.getSession(true);
		UserActionForm userActionForm=(UserActionForm)httpSession.getAttribute(Constants.USER_BEAN);
		UserDBHelper userDBHelper=new UserDBHelper();
		ItemDBHelper itemHelper = new ItemDBHelper();
		OrderMasterActionForm OrderMasterActionForm=(OrderMasterActionForm)form;
		//ArrayList<ItemActionForm> itemList=((ServerAppContext)request.getServletContext().getAttribute(Constants.STRUTS_APPLICATION_CONTEXT)).getItemByCompanyId().get(companyid);		
		ArrayList<ItemActionForm> itemList= itemHelper.getActiveItemsForSpecificCompany(companyid);
		/*ConfigDBHelper configDBHelper=new ConfigDBHelper();
		int value=configDBHelper.fetchConfigByProperty("itemPriceOn");*/
		
		//ArrayList<UserActionForm> userList=userDBHelper.userByCompanyId(companyid);
		ArrayList<UserActionForm> userList=userDBHelper.getActiveUsersForSpecificCompany(companyid);
		
		
		
		if(request.getParameter("orderMasterId")!=null)
		{
			OrderMasterDBHelper  OrderMasterDBHelper=new OrderMasterDBHelper();
			int orderMasterId=Integer.parseInt(request.getParameter("orderMasterId"));
			System.out.println("parthgandhi"+orderMasterId);
			
			OrderMasterActionForm=OrderMasterDBHelper.getOrderByMasterId(orderMasterId);
			//String a=OrderMasterActionForm.getOrderNumber();
			OrderMasterActionForm.setCustomerMasterId(OrderMasterActionForm.getUserMasterId());
			ArrayList<OrderMasterActionForm> orderMasterActionFormsList=OrderMasterDBHelper.fetchAll();			
			OrderMasterActionForm.setOrderMasterList(orderMasterActionFormsList);
			OrderMasterActionForm.setItemList(itemList);
			OrderMasterActionForm.setUserList(userList);
			
			//OrderMasterActionForm.setItemPrice(value);
			
			BeanUtils.copyProperties(form,OrderMasterActionForm);
			return mapping.findForward("success");
			
		}
		else
		{
			//OrderMasterActionForm.setItemPrice(value);
			
			OrderMasterActionForm.setItemList(itemList);
			OrderMasterActionForm.setUserList(userList);
			if(roleId!=2)
			{
				OrderMasterActionForm.setUserMasterId(userActionForm.getUserMasterId());
			}
		}
		BeanUtils.copyProperties(form,OrderMasterActionForm);
		return mapping.findForward("success");
	}
	

}
