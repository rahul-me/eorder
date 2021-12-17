package com.bms.mdm.filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bms.constants.Constants;
import com.bms.context.ServerAppContext;
import com.bms.mdm.item.ItemActionForm;
import com.bms.mdm.orderstage.OrderStageActionForm;
import com.bms.mdm.orderstage.OrderStageDBHelper;
import com.bms.neetai.userroles.UserRoleActionForm;
import com.bms.neetai.users.UserActionForm;
import com.bms.neetai.users.UserDBHelper;
import com.bms.order.ordermaster.OrderMasterActionForm;
import com.bms.order.ordermaster.OrderMasterDBHelper;
import com.bms.struts.SCMAction;

public class FilterAction extends SCMAction{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		FilterActionForm filterActionForm= (FilterActionForm)form;
		System.out.println("40 :"+filterActionForm.getUserRoleList());
		
		HttpSession session=request.getSession(true);
		UserActionForm userActionForm=new UserActionForm();
		UserRoleActionForm userRoleActionForm=new UserRoleActionForm();
		userActionForm=(UserActionForm) session.getAttribute(Constants.USER_BEAN);
		ServerAppContext serverAppContext  = (ServerAppContext)request.getServletContext().getAttribute(Constants.STRUTS_APPLICATION_CONTEXT);
		int compid=(int)session.getAttribute(Constants.COMPANY_ID);
		//ArrayList <Integer> siteId=(ArrayList<Integer>)session.getAttribute(Constants.USER_SITE_ID);
	//	int userId=userActionForm.getUserMasterId();
		//ArrayList<OrderMasterActionForm> orderMasterActionFormsList=OrderMasterDBHelper.fetchAll();
		/*OrderMasterActionForm.setOrderMasterList(orderMasterActionFormsList);*/
		ArrayList<ItemActionForm> itemList=serverAppContext.getItemByCompanyId().get(compid);		
		ArrayList<UserActionForm>userList=serverAppContext.getUserByCompanyId().get(compid);
		ArrayList<UserRoleActionForm> userRoles=serverAppContext.getUserRollByCompanyMasterId().get(compid);		
		System.out.println("hello");
		if(itemList!=null || userList!=null)
		{		
		
				
		OrderMasterDBHelper orderMasterDBHelper=new OrderMasterDBHelper();
		ArrayList<OrderMasterActionForm> orderMasterActionFormsList=orderMasterDBHelper.getOrderByCompanyId(compid);
		filterActionForm.setOrderMasterList(orderMasterActionFormsList);
		filterActionForm.setItemList(itemList);
		filterActionForm.setUserList(userList);
		filterActionForm.setUserRoleList(userRoles);
		filterActionForm.setOrderMasterList(orderMasterActionFormsList);
		
		OrderStageDBHelper orderStageDBHelper=new OrderStageDBHelper();
		ArrayList<OrderStageActionForm> orderStageActionFormsList=orderStageDBHelper.getOrderStageByCompanyId(compid);
		filterActionForm.setOrderStageList(orderStageActionFormsList);
		}
		
		if(session.getAttribute("itemId")!=null)
			if(!session.getAttribute("itemId").toString().equalsIgnoreCase("") && !session.getAttribute("itemId").toString().equalsIgnoreCase("null")&&!session.getAttribute("itemId").toString().equalsIgnoreCase("undefined"))
			{
				String commaSeparated=session.getAttribute("itemId").toString();
				String [] items = commaSeparated.split(",");
				List<String> container = Arrays.asList(items);
				int[] a= new int[container.size()];
				for(int i=0;i<container.size();i++)
				{
					a[i]=Integer.parseInt(container.get(i));
				}
				filterActionForm.setItemIds(a);
			}
		if(session.getAttribute("fromDate")!=null)
			if(!session.getAttribute("fromDate").toString().equalsIgnoreCase("") && !session.getAttribute("fromDate").toString().equalsIgnoreCase("null"))
			{
				System.out.println("Date"+session.getAttribute("fromDate"));
				String fdate=(String)session.getAttribute("fromDate");
				System.out.println("My FormDate is "+fdate);				
				//String methdate=getRequiredDate(fdate,1,5);
				//System.out.println("88 Hello My Current Date is "+methdate);
				filterActionForm.setFromDate(session.getAttribute("fromDate").toString());
			}
		if(session.getAttribute("toDate")!=null)
			if(!session.getAttribute("toDate").toString().equalsIgnoreCase("null") && !session.getAttribute("toDate").toString().equalsIgnoreCase(""))
			{
				System.out.println("to Date"+session.getAttribute("toDate"));
				filterActionForm.setToDate(session.getAttribute("toDate").toString());
			}
		
		
		if(session.getAttribute("userId")!=null)
			if(!session.getAttribute("userId").toString().equalsIgnoreCase("") && !session.getAttribute("userId").toString().equalsIgnoreCase("null"))
			{
				String commaSeparated=session.getAttribute("userId").toString();
				String [] items = commaSeparated.split(",");
				List<String> container = Arrays.asList(items);
				int[] a= new int[container.size()];
				for(int i=0;i<container.size();i++)
				{
					//a[i]=Integer.parseInt(container.get(i));
				}
				filterActionForm.setUserId(a);
			}
		if(session.getAttribute("userRole")!=null)
			if(!session.getAttribute("userRole").toString().equalsIgnoreCase("") && !session.getAttribute("userRole").toString().equalsIgnoreCase("null"))
			{
				String commaSeparated=session.getAttribute("userRole").toString();
				String [] items = commaSeparated.split(",");
				List<String> container = Arrays.asList(items);
				int[] a= new int[container.size()];
				for(int i=0;i<container.size();i++)
				{
					//a[i]=Integer.parseInt(container.get(i));
				}
				filterActionForm.setUserRole(a);
			}
		
		
		
		
	 if(request.getParameter("orderList")!=null){
			//System.out.println(request.getParameter("status"));
		 			
			if(request.getParameter("insert")!=null){
				ActionErrors actionErrors=new ActionErrors();
				actionErrors.add("mehul",new ActionMessage("errors.purchase.insert.successful"));
				saveErrors(request, actionErrors);
				filterActionForm.setAlertMsg(request.getParameter("insert"));
			}else if(request.getParameter("update")!=null)
			{
				ActionErrors actionErrors=new ActionErrors();
				actionErrors.add("mehul",new ActionMessage("errors.purchase.update.successful"));
				saveErrors(request, actionErrors);
				filterActionForm.setAlertMsg(request.getParameter("update"));
			}else if(request.getParameter("delete")!=null)
			{
				ActionErrors actionErrors=new ActionErrors();
				actionErrors.add("mehul",new ActionMessage("errors.purchase.delete.successful"));
				saveErrors(request, actionErrors);
				filterActionForm.setAlertMsg(request.getParameter("delete"));
			}
			else if(request.getParameter("error")!=null)
			{
				ActionErrors actionErrors=new ActionErrors();
				actionErrors.add("mehul",new ActionMessage("errors.purchase.error"));
				saveErrors(request, actionErrors);
			}
			BeanUtils.copyProperties(form, filterActionForm);
			
			return mapping.findForward("orderList");
		}
	 	else if(request.getParameter("orderManagementList")!=null){
			return mapping.findForward("orderManagementList");
		}
		else if(request.getParameter("customerEntryList")!=null){
			return mapping.findForward("customerEntryList");
		}
		else if(request.getParameter("mmList")!=null){
			return mapping.findForward("areaList");
		}
		else if(request.getParameter("ItemListForward")!=null){
			return mapping.findForward("ItemListForward");
		}
		
		else if(request.getParameter("itemCategoryList")!=null){
			return mapping.findForward("itemCategoryList");
		}
	 
		else if(request.getParameter("companyList")!=null){
			return mapping.findForward("companyList");
		}
		else if(request.getParameter("OrderStageList")!=null){
			return mapping.findForward("OrderStageList");
		}
		else if(request.getParameter("ItemPriceList")!=null){
			return mapping.findForward("ItemPriceList");
		}
		else if(request.getParameter("listCustomer")!=null){
			return mapping.findForward("listCustomer");
		}
	 
		else if(request.getParameter("listSupplier")!=null){
			
			if(request.getParameter("update")!=null){
				ActionErrors actionErrors=new ActionErrors();
				actionErrors.add("mehul",new ActionMessage("errors.purchase.update.successful"));
				saveErrors(request, actionErrors);
				filterActionForm.setAlertMsg(request.getParameter("update"));
				
			}
			else if(request.getParameter("insert")!=null){
					ActionErrors actionErrors=new ActionErrors();
					actionErrors.add("mehul",new ActionMessage("errors.purchase.insert.successful"));
					saveErrors(request, actionErrors);
					filterActionForm.setAlertMsg(request.getParameter("insert"));
			}else if(request.getParameter("delete")!=null){
				ActionErrors actionErrors=new ActionErrors();
				actionErrors.add("mehul",new ActionMessage("errors.purchase.delete.successful"));
				saveErrors(request, actionErrors);
				filterActionForm.setAlertMsg(request.getParameter("delete"));
			}else if(request.getParameter("error")!=null)
			{
				if(request.getParameter("error").equals("Error")){
					ActionErrors actionErrors=new ActionErrors();
					actionErrors.add("mehul",new ActionMessage("errors.purchase.insert.error"));
					saveErrors(request, actionErrors);
				}
			}	
			BeanUtils.copyProperties(form, filterActionForm);
			return mapping.findForward("listSupplier");
		}
		
		else if(request.getParameter("listMeasurement")!=null){
			if(request.getParameter("insert")!=null){
	        	
				ActionErrors actionErrors=new ActionErrors();
				actionErrors.add("mehul",new ActionMessage("errors.purchase.insert.successful"));
				saveErrors(request, actionErrors);
				filterActionForm.setAlertMsg(request.getParameter("insert"));
		    }
		 else if(request.getParameter("update")!=null)
		 {
			 	ActionErrors actionErrors=new ActionErrors();
				actionErrors.add("mehul",new ActionMessage("errors.purchase.update.successful"));
				saveErrors(request, actionErrors);
				filterActionForm.setAlertMsg(request.getParameter("update"));
		 }else if(request.getParameter("delete")!=null)
		 {
			 	ActionErrors actionErrors=new ActionErrors();
				actionErrors.add("mehul",new ActionMessage("errors.purchase.delete.successful"));
				saveErrors(request, actionErrors);
				filterActionForm.setAlertMsg(request.getParameter("delete"));
		 }
		 else if(request.getParameter("error")!=null)
		 {
			 	ActionErrors actionErrors=new ActionErrors();
				actionErrors.add("mehul",new ActionMessage("errors.purchase.insert.error"));
				saveErrors(request, actionErrors);
				
		 }
		BeanUtils.copyProperties(form, filterActionForm);
			return mapping.findForward("listMeasurement");
		}
		
		else if(request.getParameter("listUsers")!=null){
			if(request.getParameter("update")!=null){
				
				ActionErrors actionErrors=new ActionErrors();
				actionErrors.add("mehul",new ActionMessage("errors.user.update.successful"));
				saveErrors(request, actionErrors);
				filterActionForm.setAlertMsg(request.getParameter("update"));
				
			}
			else if(request.getParameter("insert")!=null){
				
					ActionErrors actionErrors=new ActionErrors();
					actionErrors.add("mehul",new ActionMessage("errors.user.insert.successful"));
					saveErrors(request, actionErrors);
					filterActionForm.setAlertMsg(request.getParameter("insert"));
			}else if(request.getParameter("error")!=null)
			{
				if(request.getParameter("error").equals("Error")){
					ActionErrors actionErrors=new ActionErrors();
					actionErrors.add("mehul",new ActionMessage("errors.user.insert.error"));
					saveErrors(request, actionErrors);
				}
			}
			BeanUtils.copyProperties(form, filterActionForm);
			return mapping.findForward("listUsers");
		}
		
		else if(request.getParameter("listUserRole")!=null){
			if(request.getParameter("update")!=null){
				ActionErrors actionErrors=new ActionErrors();
				actionErrors.add("mehul",new ActionMessage("errors.user.update.successful"));
				saveErrors(request, actionErrors);
				filterActionForm.setAlertMsg(request.getParameter("update"));
			}
			else if(request.getParameter("insert")!=null){
					ActionErrors actionErrors=new ActionErrors();
					actionErrors.add("mehul",new ActionMessage("errors.user.insert.successful"));
					saveErrors(request, actionErrors);
					filterActionForm.setAlertMsg(request.getParameter("insert"));
			}else if(request.getParameter("error")!=null)
			{
				if(request.getParameter("error").equals("Error")){
					ActionErrors actionErrors=new ActionErrors();
					actionErrors.add("mehul",new ActionMessage("errors.user.insert.error"));
					saveErrors(request, actionErrors);
				}
			}
			BeanUtils.copyProperties(form, filterActionForm);
			return mapping.findForward("listUserRole");
		}else if(request.getParameter("fillRate")!=null){
			return mapping.findForward("fillRate");
		}else if(request.getParameter("fillRateByItem")!=null){
			return mapping.findForward("fillRateByItem");
		}
	 
		if(request.getParameter("update")!=null){
			ActionErrors actionErrors=new ActionErrors();
			actionErrors.add("mehul",new ActionMessage("errors.purchase.update.successful"));
			saveErrors(request, actionErrors);
			filterActionForm.setAlertMsg(request.getParameter("update"));
		}
		else if(request.getParameter("insert")!=null){
				ActionErrors actionErrors=new ActionErrors();
				actionErrors.add("mehul",new ActionMessage("errors.purchase.insert.successful"));
				saveErrors(request, actionErrors);
				filterActionForm.setAlertMsg(request.getParameter("insert"));
			
		}else if(request.getParameter("delete")!=null){
			ActionErrors actionErrors=new ActionErrors();
			actionErrors.add("mehul",new ActionMessage("errors.purchase.delete.successful"));
			saveErrors(request, actionErrors);
			filterActionForm.setAlertMsg(request.getParameter("delete"));
		
		}
		else if(request.getParameter("error")!=null)
		{
				ActionErrors actionErrors=new ActionErrors();
				actionErrors.add("mehul",new ActionMessage("errors.purchase.insert.error"));
				saveErrors(request, actionErrors);
			
		}
		BeanUtils.copyProperties(form, filterActionForm);
		return mapping.findForward("successList");
	
	}
	
	/*
	public String getRequiredDate(String date, int operation, int days)
	{
		StringTokenizer st=new StringTokenizer(date,"-");
		int count=0;
		int dy=0,dm=0,dd=0;
		while(st.hasMoreTokens())
		{
			try
			{
			count++;
			if(count==1)
			{
				dy=Integer.parseInt(st.nextToken());
			}
			if(count==2)
			{
				dm=Integer.parseInt(st.nextToken());
			}
			if(count==3)
			{
				dd=Integer.parseInt(st.nextToken());
			}
			}
			catch(Exception e)
			{
				System.out.println("Exception occured "+e);
			}
		}
		System.out.println("My Date has been received in method");
		
		
		if(operation==Constants.DATE_ADD)
		{
			addDate(dy,dm,dd, days);
		}
		
		
		return dy+"-"+dm+"-"+dd;
		
			
	}
	
	String addDate(int year, int month, int day , int daysToManipulate)
	{
		
		return "hello";
	}
	String subtractDate(int year, int month, int day , int daysToManipulate)
	{
		int yearToSend=30,monthToSend=30,daysToSend=30;		
		if(day <= daysToManipulate)
		{
			monthToSend=month-1;
			daysToSend=day-daysToManipulate;
		}
		else
		{
			
		}
		return "hello";
	}
	*/
	
}
