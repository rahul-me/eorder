package com.bms.service;


/**
 * NeetaiAndroidServices manages the Android Applications. 
 * all business operations Perform From/By Android Apps.
 * @author parth gandhi
 */

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.bms.constants.Constants;
import com.bms.context.ServerAppContext;
import com.bms.mdm.item.ItemActionForm;
import com.bms.mdm.item.ItemDBHelper;
import com.bms.mdm.measurement.MeasurementActionForm;
import com.bms.mdm.orderstage.OrderStageActionForm;
import com.bms.neetai.company.CompanyActionForm;
import com.bms.neetai.company.CompanyDBHelper;
import com.bms.neetai.users.UserActionForm;
import com.bms.neetai.users.UserDBHelper;
import com.bms.order.ordermaster.OrderMasterActionForm;
import com.bms.order.ordermaster.OrderMasterDBAdapter;
import com.bms.order.ordermaster.OrderMasterDBHelper;

@Path("/NeetaiAndroidServices")

public class NeetaiAndroidServices {

	@Context
	UriInfo uriInfo;

	@Context
	//Request request;
	//Response response;
	HttpServletRequest request;
	HttpServletResponse response;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String respondAsReady() {
		return "Neetai android web service is ready!";
	}

	@GET
	@Path("/getCompanyListByFilter")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JSONObject getCompanyListByFilter(String data) throws JSONException
	{
		ServerAppContext serverAppContext  = (ServerAppContext)request.getServletContext().getAttribute(Constants.STRUTS_APPLICATION_CONTEXT);
		
	
		JSONObject jsonObject = null;
		JSONArray jsonArray = null;
		JSONObject returnJsonObject= null;
		CompanyDBHelper companyDBHelper=new CompanyDBHelper();
		
		try
		{
			jsonObject = new JSONObject();
			if(jsonObject !=null)
			{
				
				ArrayList<CompanyActionForm>companylist=companyDBHelper.getAllCompany();
				
				
				if(companylist!=null)
				{
					jsonArray = new JSONArray();
					for(int i=0; i<companylist.size(); i++)
					{		
					jsonObject = new JSONObject();
					jsonObject.put("companyid",companylist.get(i).getCompanyMasterId());
					jsonObject.put("companyname",companylist.get(i).getName());
					jsonObject.put("contactpersonnumber",companylist.get(i).getContactPersonNumber());
					jsonObject.put("Email",companylist.get(i).getContactEmail());
					jsonObject.put("edit","<a onclick=editorder("+companylist.get(i).getCompanyMasterId()+"); title='Edit Orderstage'><code class='glyphicon glyphicon-edit'></code></a> <a onclick=deleteOrder("+companylist.get(i).getCompanyMasterId()+"); title='Delete OrderStage'><code class='glyphicon glyphicon-remove'></code></a>");
					jsonObject.put("createdBy",serverAppContext.getUserByUserMasterId().get(companylist.get(i).getCreatedBy()).getUserName());
					jsonObject.put("createdDTTM",companylist.get(i).getCreatedDTTM());

					if(companylist.get(i).getIsActive()==0)
					{
						jsonObject.put("status", "Not Active");
					}
					else
					{
						jsonObject.put("status", "Active");
					}
					jsonArray.put(jsonObject);
					
					}
					
				}
				else
				{
					jsonArray = new JSONArray();
				}
				
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		returnJsonObject = new JSONObject();
		returnJsonObject.put("aaData", jsonArray);
		System.out.println("Now Time is"+returnJsonObject.toString());
		return returnJsonObject;
		
	}


	
	@GET
	@Path("/getUserVerified")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JSONObject getUserVerified(@QueryParam("username") String username,@QueryParam("password") String password) throws JSONException {
		//System.out.println("call By Android get User Verified"+jsonObjectVal);
		System.out.println("gg"+request.getParameter("login"));
		UserDBHelper userDBHelper=new UserDBHelper();
		UserActionForm userBean =new UserActionForm();
		JSONObject jsonObject = null;
		try {
			userBean.setUserName(username);
			userBean.setPassword(password);
			userBean = userDBHelper.validateUser(userBean);
			
		    
			jsonObject = new JSONObject();
			jsonObject.put("userid", userBean.getUserMasterId());
			jsonObject.put("username", userBean.getUserName());
			jsonObject.put("userRollId",userBean.getUserRolesMasterId());
			jsonObject.put("userRolename",userBean.getUserRoleName());
							
						
				
		} catch (Exception e) {
			System.out.println(e);
		}
		return jsonObject;
		
	}	
	
	@GET		
	@Path("/getItemListByUserId")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JSONObject getItemListByUserId(@QueryParam("userId") String userId) throws JSONException{
		
		
		ServerAppContext serverAppContext  = (ServerAppContext)request.getServletContext().getAttribute(Constants.STRUTS_APPLICATION_CONTEXT);
		System.out.println("In Master Data Mgmt Services- getItemListByUserId");		
		String userMasterId=userId;				
		JSONArray jsonArray = null;
		JSONObject returnJsonObject= null;
		JSONObject jsonObject= null;
		UserDBHelper userDBHelper=new UserDBHelper();
		UserActionForm userActionForm=userDBHelper.getSingleUserByUserId(Integer.parseInt(userMasterId));
		if(userActionForm!=null)
		{
		ItemDBHelper itemDBHelper=new ItemDBHelper();				
		try
		{
			jsonObject = new JSONObject();
			ArrayList<ItemActionForm> itemActionForms=itemDBHelper.getItemByCompanyId(userActionForm.getCompanyMasterId());
			if(itemActionForms != null)
			{
				jsonArray = new JSONArray();
				for(int i= 0; i<itemActionForms.size(); i++)
				{
					jsonObject = new JSONObject();
					jsonObject.put("itemMasterId", itemActionForms.get(i).getItemMasterId());
					jsonObject.put("name", itemActionForms.get(i).getName());						
					jsonObject.put("createdBy",serverAppContext.getUserByUserMasterId().get(itemActionForms.get(i).getCreatedBy()).getUserName());
					jsonObject.put("itemPrice", itemActionForms.get(i).getItemPrice());						
					jsonObject.put("createdDTTM", itemActionForms.get(i).getCreatedDTTM());					
					jsonArray.put(jsonObject);
											
				}
			}
		
			else
			{
				jsonArray = new JSONArray();
			}
			
		}
		
		catch (Exception e) {
			System.out.println("In Master Data Mgmt Service getItemListByFilter"+e);
		}
		
		returnJsonObject = new JSONObject();
		returnJsonObject.put("aaData", jsonArray);
		System.out.println("Now Time is"+returnJsonObject.toString());
		}
		else{
			returnJsonObject = new JSONObject();
			returnJsonObject.put("No", "No Data Found for this user");
		}
		return returnJsonObject;		
	}
	

	@GET		
	@Path("/getCustomerByUserId")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JSONObject getCustomerByUserId(@QueryParam("userId") String userId) throws JSONException{		
		System.out.println("In Master Data Mgmt Services- getItemListByUserId");
		System.out.println("parameter"+userId);
		String userMasterId=userId;
		
		JSONArray jsonArray = null;
		JSONObject returnJsonObject= null;
		JSONObject jsonObject= null;
		
		UserDBHelper userDBHelper=new UserDBHelper();
		UserActionForm userActionForm=userDBHelper.getSingleUserByUserId(Integer.parseInt(userMasterId));
		if(userActionForm!=null){		
		try
		{
			jsonObject = new JSONObject();
			ArrayList<UserActionForm> userActionForms=userDBHelper.userByCompanyId(userActionForm.getCompanyMasterId());
			if(userActionForms != null)
			{
				jsonArray = new JSONArray();
				for(int i= 0; i<userActionForms.size(); i++)
				{
					if(userActionForms.get(i).getUserRolesMasterId()==Constants.USERROLL_MASTERID){
					
					jsonObject = new JSONObject();
					jsonObject.put("UserId", userActionForms.get(i).getUserMasterId());
					jsonObject.put("UserName", userActionForms.get(i).getUserName());
					jsonObject.put("FirstName",userActionForms.get(i).getFirstName());
					jsonObject.put("PhoneNo",userActionForms.get(i).getPhoneNumber1());					
					String userRole=userActionForms.get(i).getUserRoleName();																	
					jsonObject.put("UserRole",userRole);
					jsonArray.put(jsonObject);
					
				}
			}
			}
			
			else
			{
				jsonArray = new JSONArray();
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}		
		returnJsonObject = new JSONObject();
		returnJsonObject.put("aaData", jsonArray);
		System.out.println("Now Time is"+returnJsonObject.toString());
		}	
		else{
			returnJsonObject = new JSONObject();
			returnJsonObject.put("No", "No Data Found for this user");
		}
		return returnJsonObject;	
	}
	
	
	
	
	@GET		
	@Path("/getOrderStage")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JSONObject getOrderStage(@QueryParam("userId") String userId) throws JSONException{		
		System.out.println("In Master Data Mgmt Services- getOrderStage");		
		String userMasterId=userId;
		ServerAppContext serverAppContext  = (ServerAppContext)request.getServletContext().getAttribute(Constants.STRUTS_APPLICATION_CONTEXT);
		JSONArray jsonArray = null;
		JSONObject returnJsonObject= null;
		JSONObject jsonObject= null;				
		UserActionForm userActionForm=serverAppContext.getUserByUserMasterId().get(Integer.parseInt(userMasterId));		
		if(userActionForm!=null){		
		try
		{
			jsonObject = new JSONObject();
			ArrayList<OrderStageActionForm> Orderstagelist=serverAppContext.getOrderStageByCompanyMasterId().get(userActionForm.getCompanyMasterId());
			if(Orderstagelist != null)
			{
				jsonArray = new JSONArray();
				for(int i= 0; i<Orderstagelist.size(); i++)
				{
					
					
					jsonObject = new JSONObject();
					jsonObject.put("orderstagemasterid", Orderstagelist.get(i).getOrderStageMasterId());
					jsonObject.put("orderstagename",Orderstagelist.get(i).getName());
					jsonObject.put("description", Orderstagelist.get(i).getDescription());
					jsonArray.put(jsonObject);
					
				
			}
			}
			
			else
			{
				jsonArray = new JSONArray();
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}		
		returnJsonObject = new JSONObject();
		returnJsonObject.put("aaData", jsonArray);
		System.out.println("Now Time is"+returnJsonObject.toString());
		}	
		else{
			returnJsonObject = new JSONObject();
			returnJsonObject.put("No", "No Data Found for this user");
		}
		return returnJsonObject;	
	}
	
	
	@GET
	@Path("/getTodayOrder")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JSONObject getTodayOrder(@QueryParam("userId") String userId,@QueryParam("date") String date) throws JSONException{
		
		System.out.println("in get Item getTodayOrder By Filter");
		ServerAppContext serverAppContext  = (ServerAppContext)request.getServletContext().getAttribute(Constants.STRUTS_APPLICATION_CONTEXT);
		System.out.println("userid"+userId);
		System.out.println("todaydate"+date);
		String userMasterId=userId;
		String Date=date;
		UserDBHelper userDBHelper=new UserDBHelper();
		UserActionForm userActionForm=serverAppContext.getUserByUserMasterId().get(Integer.parseInt(userMasterId));
		int compid=userActionForm.getCompanyMasterId();
		JSONArray jsonArray = null;
		JSONObject jsonObject= null;
		JSONObject returnJsonObject= null;
		OrderMasterDBHelper OrderMasterDBHelper=new OrderMasterDBHelper();		
		
		try
		{		
			
			ArrayList<OrderMasterActionForm> orderMasterActionFormsList = OrderMasterDBHelper.getByUserMasterIdAndOrderDate(Date);
			if(orderMasterActionFormsList != null)
			{
				jsonArray = new JSONArray();								
				for(int i=0; i<orderMasterActionFormsList.size(); i++)
				{
					if(orderMasterActionFormsList.get(i).isActive==1)
					{
					
					 jsonObject = new JSONObject();
					 jsonObject.put("orderMasterId", orderMasterActionFormsList.get(i).getOrderMasterId());
					 jsonObject.put("CreatedDate", orderMasterActionFormsList.get(i).getCreatedDate());
					 jsonObject.put("ordernumber", orderMasterActionFormsList.get(i).getOrderNumber());
					 jsonObject.put("orderAmount", orderMasterActionFormsList.get(i).getTotal());
					 jsonObject.put("state", orderMasterActionFormsList.get(i).getState());
					 jsonObject.put("remark", orderMasterActionFormsList.get(i).getRemark());
					 int userBean=serverAppContext.getUserByUserMasterId().get((orderMasterActionFormsList.get(i).getUserMasterId())).getUserRolesMasterId();
					 if(userBean==Constants.USERROLL_MASTERID){
						 jsonObject.put("customerName",serverAppContext.getUserByUserMasterId().get((orderMasterActionFormsList.get(i).getUserMasterId())).getFirstName());
					 }					 
					 if(orderMasterActionFormsList.get(i).getModifiedBy()!=0){
					 jsonObject.put("UpdatedBy", userDBHelper.getSingleUserByUserId(orderMasterActionFormsList.get(i).getModifiedBy()).getFirstName());}
					 else{jsonObject.put("UpdatedBy","Not Updated");}
					 if(orderMasterActionFormsList.get(i).getModifiedDTTM()!=null){
					 jsonObject.put("UpdatedDTTM", orderMasterActionFormsList.get(i).getModifiedDTTM());}else{jsonObject.put("UpdatedDTTM","Not Updated");}
					 jsonObject.put("createdBy", serverAppContext.getUserByUserMasterId().get((orderMasterActionFormsList.get(i).getCreatedBy())).getFirstName());						
					 
					jsonArray.put(jsonObject);
				}
				}
				
			}
			else
			{
				jsonArray = new JSONArray();
			}
			}
		catch (Exception e) {
			System.out.println(e);
		}
		returnJsonObject = new JSONObject();
		returnJsonObject.put("aaData", jsonArray);
		return returnJsonObject;
		}
	
	

	
	
	
	
	
	
	
		
	@GET
	@Path("/getOrderList")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JSONObject getOrderList(@QueryParam("userId") String userId) throws JSONException{
	
		System.out.println("in get Item order List By Filter");
		ServerAppContext serverAppContext  = (ServerAppContext)request.getServletContext().getAttribute(Constants.STRUTS_APPLICATION_CONTEXT);	
		String userMasterId=userId;
		UserDBHelper userDBHelper=new UserDBHelper();
		UserActionForm userActionForm=serverAppContext.getUserByUserMasterId().get(Integer.parseInt(userMasterId));
		int compid=userActionForm.getCompanyMasterId();
		JSONArray jsonArray = null;
		JSONObject jsonObject= null;
		JSONObject returnJsonObject= null;
		OrderMasterDBHelper OrderMasterDBHelper=new OrderMasterDBHelper();		
		
		try
		{		
			
			ArrayList<OrderMasterActionForm> orderMasterActionFormsList = OrderMasterDBHelper.getOrderByCompanyId(compid);
			HashMap<Integer, ArrayList<OrderStageActionForm>>orderstageBycompanyId=serverAppContext.getOrderStageByCompanyMasterId();
			ArrayList<OrderStageActionForm>orderstageList=orderstageBycompanyId.get(compid);
			if(orderstageList!=null){
				
			if(orderMasterActionFormsList != null)
			{
				jsonArray = new JSONArray();								
				for(int i=0; i<orderMasterActionFormsList.size(); i++)
				{
					if(orderMasterActionFormsList.get(i).isActive==1)
					{
					
					 jsonObject = new JSONObject();
					 jsonObject.put("orderMasterId", orderMasterActionFormsList.get(i).getOrderMasterId());
					 jsonObject.put("CreatedDate", orderMasterActionFormsList.get(i).getCreatedDate());
					 jsonObject.put("ordernumber", orderMasterActionFormsList.get(i).getOrderNumber());
					 jsonObject.put("orderAmount", orderMasterActionFormsList.get(i).getTotal());
					 jsonObject.put("state", orderMasterActionFormsList.get(i).getState());
					 jsonObject.put("remark", orderMasterActionFormsList.get(i).getRemark());
					 int userBean=serverAppContext.getUserByUserMasterId().get((orderMasterActionFormsList.get(i).getUserMasterId())).getUserRolesMasterId();
					 if(userBean==Constants.USERROLL_MASTERID){
						 jsonObject.put("customerName",serverAppContext.getUserByUserMasterId().get((orderMasterActionFormsList.get(i).getUserMasterId())).getFirstName());
					 }					 
					 if(orderMasterActionFormsList.get(i).getModifiedBy()!=0){
					 jsonObject.put("UpdatedBy", userDBHelper.getSingleUserByUserId(orderMasterActionFormsList.get(i).getModifiedBy()).getFirstName());}
					 else{jsonObject.put("UpdatedBy","Not Updated");}
					 if(orderMasterActionFormsList.get(i).getModifiedDTTM()!=null){
					 jsonObject.put("UpdatedDTTM", orderMasterActionFormsList.get(i).getModifiedDTTM());}else{jsonObject.put("UpdatedDTTM","Not Updated");}
					 jsonObject.put("createdBy", serverAppContext.getUserByUserMasterId().get((orderMasterActionFormsList.get(i).getCreatedBy())).getFirstName());						
					 for(int p=0;p<orderstageList.size();p++){
								jsonObject.put("orderstage",orderstageList.get(p).getName());
								}						
					jsonArray.put(jsonObject);
				}
				}
				
			}
			}
			
			else
			{
				jsonArray = new JSONArray();
			}

		}
		catch (Exception e) {
			System.out.println(e);
		}
		returnJsonObject = new JSONObject();
		returnJsonObject.put("aaData", jsonArray);
		return returnJsonObject;
	}
	
	
	@GET		
	@Path("/getMeasurementByCompanyMasterId")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JSONObject getMeasurementByCompanyMasterId(@QueryParam("userId") String userId) throws JSONException{		
		System.out.println("In Master Data Mgmt Services- getMeasurementByCompanyMasterId");		
		String userMasterId=userId;
		ServerAppContext serverAppContext  = (ServerAppContext)request.getServletContext().getAttribute(Constants.STRUTS_APPLICATION_CONTEXT);
		JSONArray jsonArray = null;
		JSONObject returnJsonObject= null;
		JSONObject jsonObject= null;
		
		
		
		UserActionForm userActionForm=serverAppContext.getUserByUserMasterId().get(Integer.parseInt(userMasterId));
		if(userActionForm!=null){		
		try
		{
			jsonObject = new JSONObject();
			ArrayList<MeasurementActionForm> MeasurementList=serverAppContext.getMeasurementByCompanyMasterId().get(userActionForm.getCompanyMasterId());
			if(MeasurementList != null)
			{
				jsonArray = new JSONArray();
				for(int i= 0; i<MeasurementList.size(); i++)
				{
					
					
					jsonObject = new JSONObject();
					jsonObject.put("measurementId", MeasurementList.get(i).getMeasurementMasterId());
					jsonObject.put("measurementname",MeasurementList.get(i).getName());
					jsonObject.put("measurementunit",MeasurementList.get(i).getUnit());
					jsonObject.put("symbol",MeasurementList.get(i).getSymbol());
					jsonArray.put(jsonObject);
					
				
			}
			}
			
			else
			{
				jsonArray = new JSONArray();
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}		
		returnJsonObject = new JSONObject();
		returnJsonObject.put("aaData", jsonArray);
		System.out.println("Now Time is"+returnJsonObject.toString());
		}	
		else{
			returnJsonObject = new JSONObject();
			returnJsonObject.put("No", "No Data Found for this user");
		}
		return returnJsonObject;	
	}
	
	
	
	
	
	@GET
	@Path("/InsertOrder")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject InsertOrder(@QueryParam("data")  String data) throws Exception {	
		JSONObject jObject  = new JSONObject(data);
		System.out.println("hello"+data);		
		System.out.println("In Master Data Mgmt Services- InsertOrder");	 
		
		JSONObject returnJsonObject= null;
		OrderMasterActionForm orderMasterActionForm=new OrderMasterActionForm();
		OrderMasterDBHelper orderMasterDBHelper=new OrderMasterDBHelper();
		int createdBy,Pack,itemQuntity,itemAmount,itemid,itemPrice;
		String colorcode,addedDateTime;		
		try
		{
			
			if(jObject !=null)
			{
				JSONObject User = jObject.getJSONObject("User");
				int uid=User.getInt("userId");
				String remark=User.getString("remark");	
				String date=User.getString("OrderDateTime");
				JSONArray jsonMainArr = jObject.getJSONArray("items");
				for (int i = 0; i < jsonMainArr.length(); i++) {  // **line 2**
				JSONObject childJSONObject = jsonMainArr.getJSONObject(i);
				String name = childJSONObject.getString("itemname");				
				createdBy     = childJSONObject.getInt("createdBy");
				 colorcode=childJSONObject.getString("ColorCode");	
				 System.out.println("hello"+colorcode);
				 Pack=childJSONObject.getInt("Pack");
				 itemQuntity=childJSONObject.getInt("itemQuntity");
				 itemAmount=childJSONObject.getInt("itemAmount");
				 itemid=childJSONObject.getInt("itemid");
				 itemPrice=childJSONObject.getInt("itemPrice");
				 addedDateTime=childJSONObject.getString("addedDateTime");
				
						
				// jsonMainArr.put(childJSONObject);
				orderMasterActionForm.setItemPrice(itemPrice);
				orderMasterActionForm.setItemMasterId(itemid);
				orderMasterActionForm.setUserMasterId(uid);
				orderMasterActionForm.setTotal(itemAmount);
				orderMasterActionForm.setCreatedDate(addedDateTime);
				orderMasterActionForm.setCreatedDTTM(date);
				orderMasterActionForm.setRemark(remark);
				orderMasterActionForm.setCreatedBy(createdBy);
				orderMasterActionForm.setIsActive(1);
				orderMasterActionForm.setCompanyMasterId(2);
				int orderMasterId=orderMasterDBHelper.addOrderMaster(orderMasterActionForm);
				if(orderMasterId>0){
					System.out.println("insert sucessfully");
				}
				
			}			

			}													
		}
		catch (Exception e) {
			System.out.println(e);
		}
		JSONArray jsonMainArr=new JSONArray();
		jsonMainArr.put("insert sucessfully");
		returnJsonObject = new JSONObject();
		returnJsonObject.put("data", jsonMainArr);
		System.out.println("Now Time is"+returnJsonObject.toString());
		return returnJsonObject;
		}
	
	@GET
	@Path("/getOrderSearch")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getOrderSearch(@QueryParam("data") String data) throws Exception {	
		System.out.println("In Master Data Mgmt Services- getOrderSearch");
		System.out.println("hellosearch"+data);
		ServerAppContext serverAppContext  = (ServerAppContext)request.getServletContext().getAttribute(Constants.STRUTS_APPLICATION_CONTEXT);
		OrderMasterDBHelper orderMasterDBHelper=new OrderMasterDBHelper();
		String todate,fromdate;
		String state=null;
		JSONObject jsonObject=new JSONObject(data);
		JSONArray jsonArray=jsonObject.getJSONArray("SelectedStage");
		JSONObject job=jsonObject.getJSONObject("SelectedDate");
		System.out.println("hhhhhh"+job);
		String a=",",b="";
		for(int i=0;i<jsonArray.length();i++){
		JSONObject childJSONObject = jsonArray.getJSONObject(i);		
		state=childJSONObject.getString("StageId");
		if(i==jsonArray.length()-1){
			a="";
		}
		b=b+state+a;		
		}
		HashMap<String, String>filterorder=new HashMap<String,String>();
		for(int i=0;i<job.length();i++){
			fromdate=job.getString("FromDate");
			todate=job.getString("Todate");	 
		if(todate!=null && fromdate!=null){
		filterorder.put(OrderMasterDBAdapter.KEY_ORDER_MASTER_CREATED_DATE, ""+OrderMasterDBAdapter.KEY_ORDER_MASTER_CREATED_DATE+" between '"+fromdate+"' AND '"+todate+"'");
		}
		}
		if(b!=null){
			filterorder.put(OrderMasterDBAdapter.KEY_ORDER_MASTER_STATE,""+b+"");
			}
		
		try
		{
			
			ArrayList<OrderMasterActionForm> orderMasterActionFormsList = orderMasterDBHelper.fetchAllOrderMasterByFilter(filterorder);			
			if(orderMasterActionFormsList != null)
			{
				jsonArray = new JSONArray();								
				for(int i=0; i<orderMasterActionFormsList.size(); i++)
				{
					if(orderMasterActionFormsList.get(i).isActive==1)
					{
					
					 jsonObject = new JSONObject();
					 jsonObject.put("orderMasterId", orderMasterActionFormsList.get(i).getOrderMasterId());
					 jsonObject.put("CreatedDate", orderMasterActionFormsList.get(i).getCreatedDate());
					 jsonObject.put("ordernumber", orderMasterActionFormsList.get(i).getOrderNumber());
					 jsonObject.put("orderAmount", orderMasterActionFormsList.get(i).getTotal());
					 jsonObject.put("state", orderMasterActionFormsList.get(i).getState());
					 jsonObject.put("remark", orderMasterActionFormsList.get(i).getRemark());
					 int userBean=serverAppContext.getUserByUserMasterId().get((orderMasterActionFormsList.get(i).getUserMasterId())).getUserRolesMasterId();
					 if(userBean==Constants.USERROLL_MASTERID){
						 jsonObject.put("customerName",serverAppContext.getUserByUserMasterId().get((orderMasterActionFormsList.get(i).getUserMasterId())).getFirstName());
					 }					 
					 if(orderMasterActionFormsList.get(i).getModifiedBy()!=0){
					 jsonObject.put("UpdatedBy", serverAppContext.getUserByUserMasterId().get(orderMasterActionFormsList.get(i).getModifiedBy()).getFirstName());}
					 else{jsonObject.put("UpdatedBy","Not Updated");}
					 if(orderMasterActionFormsList.get(i).getModifiedDTTM()!=null){
					 jsonObject.put("UpdatedDTTM", orderMasterActionFormsList.get(i).getModifiedDTTM());}else{jsonObject.put("UpdatedDTTM","Not Updated");}
					 jsonObject.put("createdBy", serverAppContext.getUserByUserMasterId().get((orderMasterActionFormsList.get(i).getCreatedBy())).getFirstName());
					 jsonObject.put("orderstage", serverAppContext.getOrderStageByOrderStageMasterId().get((orderMasterActionFormsList.get(i).getState())).getName());	
					 jsonArray.put(jsonObject);
				}
				}
				
			}
			else
			{
				jsonArray = new JSONArray();
			}
			}
			
		
			catch (Exception e) {
				System.out.println(e);
			}
		
			JSONObject returnJsonObject = new JSONObject();
			returnJsonObject.put("aaData", jsonArray);
			return returnJsonObject;	
	}
	
	
	
	@GET
	@Path("/getPendingOrder")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JSONObject getPendingOrder(@QueryParam("data") String data) throws JSONException{
		System.out.println("In Master Data Mgmt Services- getPendingOrder");
		System.out.println("getPendingOrder"+data);
		ServerAppContext serverAppContext  = (ServerAppContext)request.getServletContext().getAttribute(Constants.STRUTS_APPLICATION_CONTEXT);
		OrderMasterDBHelper orderMasterDBHelper=new OrderMasterDBHelper();
	  
		String state=null;
		JSONObject jsonObject=new JSONObject(data);
		JSONArray jsonArray=jsonObject.getJSONArray("SelectedStage");
		
		HashMap<String, String>filterorder=new HashMap<String,String>();
		String s1="",a=",";
		for(int i=0;i<jsonArray.length();i++){
		JSONObject childJSONObject = jsonArray.getJSONObject(i);		
		state=childJSONObject.getString("StageId");
		
		if(i==jsonArray.length()-1){
			a="";
		}
		s1=s1+state+a;
		}
		
		if(s1!=null){
			filterorder.put(OrderMasterDBAdapter.KEY_ORDER_MASTER_STATE,""+s1+"");
			}
		
		try
		{
			
			
			
			ArrayList<OrderMasterActionForm> orderMasterActionFormsList = orderMasterDBHelper.fetchAllOrderMasterByFilter(filterorder);			
			if(orderMasterActionFormsList != null)
			{
				jsonArray = new JSONArray();								
				for(int i=0; i<orderMasterActionFormsList.size(); i++)
				{
					if(orderMasterActionFormsList.get(i).isActive==1)
					{
					
					 jsonObject = new JSONObject();
					 jsonObject.put("orderMasterId", orderMasterActionFormsList.get(i).getOrderMasterId());
					 jsonObject.put("CreatedDate", orderMasterActionFormsList.get(i).getCreatedDate());
					 jsonObject.put("ordernumber", orderMasterActionFormsList.get(i).getOrderNumber());
					 jsonObject.put("orderAmount", orderMasterActionFormsList.get(i).getTotal());
					 jsonObject.put("state", orderMasterActionFormsList.get(i).getState());
					 jsonObject.put("remark", orderMasterActionFormsList.get(i).getRemark());
					 int userBean=serverAppContext.getUserByUserMasterId().get((orderMasterActionFormsList.get(i).getUserMasterId())).getUserRolesMasterId();
					 if(userBean==Constants.USERROLL_MASTERID){
						 jsonObject.put("customerName",serverAppContext.getUserByUserMasterId().get((orderMasterActionFormsList.get(i).getUserMasterId())).getFirstName());
					 }					 
					 if(orderMasterActionFormsList.get(i).getModifiedBy()!=0){
					 jsonObject.put("UpdatedBy", serverAppContext.getUserByUserMasterId().get(orderMasterActionFormsList.get(i).getModifiedBy()).getFirstName());}
					 else{jsonObject.put("UpdatedBy","Not Updated");}
					 if(orderMasterActionFormsList.get(i).getModifiedDTTM()!=null){
					 jsonObject.put("UpdatedDTTM", orderMasterActionFormsList.get(i).getModifiedDTTM());}else{jsonObject.put("UpdatedDTTM","Not Updated");}
					 jsonObject.put("createdBy", serverAppContext.getUserByUserMasterId().get((orderMasterActionFormsList.get(i).getCreatedBy())).getFirstName());						 
					 jsonObject.put("orderstage", serverAppContext.getOrderStageByOrderStageMasterId().get((orderMasterActionFormsList.get(i).getState())).getName());
						
					jsonArray.put(jsonObject);
				}
				}
				
			}
			else
			{
				jsonArray = new JSONArray();
			}
			}
			
		
			catch (Exception e) {
				System.out.println(e);
			}
		
			JSONObject returnJsonObject = new JSONObject();
			returnJsonObject.put("aaData", jsonArray);
			return returnJsonObject;			
	}	
}
	
		
		

	
	
	

