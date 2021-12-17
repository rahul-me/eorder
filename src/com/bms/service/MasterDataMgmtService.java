package com.bms.service;


import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.bms.constants.Constants;
import com.bms.context.ServerAppContext;
import com.bms.mapping.itemcustomerpricemapping.ItemCustomerPriceMappingActionForm;
import com.bms.mapping.itemcustomerpricemapping.ItemCustomerPriceMappingDBHelper;
import com.bms.mdm.authorizationmatrix.AuthorisedMatrixActionForm;
import com.bms.mdm.authorizationmatrix.AuthorisedMatrixDBHelper;
import com.bms.mdm.item.ItemActionForm;
import com.bms.mdm.item.ItemDBAdapter;
import com.bms.mdm.item.ItemDBHelper;
import com.bms.mdm.itemcategories.ItemCategoriesDBAdapter;
import com.bms.mdm.itemcategories.ItemCategoriesDBHelper;
import com.bms.mdm.itemcategories.ItemCategoryActionForm;
import com.bms.mdm.measurement.MeasurementActionForm;
import com.bms.mdm.measurement.MeasurementDBHelper;
import com.bms.mdm.orderstage.OrderStageActionForm;
import com.bms.mdm.orderstage.OrderStageDBHelper;
import com.bms.mdm.packages.PackagesActionForm;
import com.bms.mdm.packages.PackagesDBHelper;
import com.bms.neetai.company.CompanyActionForm;
import com.bms.neetai.company.CompanyDBAdapter;
import com.bms.neetai.company.CompanyDBHelper;
import com.bms.neetai.userroles.UserRoleActionForm;
import com.bms.neetai.userroles.UserRoleDBHelper;
import com.bms.neetai.users.UserActionForm;
import com.bms.neetai.users.UserDBAdapter;
import com.bms.neetai.users.UserDBHelper;


@Path("/masterDataMgmtService")

public class MasterDataMgmtService {
	
	

	// The @Context annotation allows us to have certain contextual objects
		// injected into this class.
		// UriInfo object allows us to get URI information (no kidding).
		@Context
		UriInfo uriInfo;

		// Another "injected" object. This allows us to use the information that's
		// part of any incoming request.
		// We could, for example, get header information, or the requestor's address.
		@Context
		//Request request;
		//Response response;
		
		HttpServletRequest request;
		HttpServletResponse response;
		
		
				
		/*@POST
		@Path("/itemExport")
		@Consumes(MediaType.APPLICATION_JSON)
		public Response itemExport(String data){		
			ServerAppContext serverAppContext  = (ServerAppContext)request.getServletContext().getAttribute(Constants.STRUTS_APPLICATION_CONTEXT);
			ArrayList<ItemActionForm> itemArrayList=new ArrayList<ItemActionForm>();
			itemArrayList=serverAppContext.getItemListByActiveItem();
			ItemActionForm itemBean=new ItemActionForm();
			MeasurementActionForm measurementActionForm=new MeasurementActionForm();
			ItemCategoryActionForm itemCategoryActionForm=new ItemCategoryActionForm();
			
			JSONObject jsonObject = null;
			try
			{
				jsonObject = new JSONObject(data);
				if(jsonObject !=null)
				{
					 	HSSFWorkbook wb =new HSSFWorkbook();
					 	 HSSFSheet sheet = wb.createSheet("Item Data");

					      
				         *//**
				          * Setting the width of the first three columns.
				          *//*
				         sheet.setColumnWidth(0, 7500);
				         sheet.setColumnWidth(1, 3500);
				         sheet.setColumnWidth(2, 5000);
				         sheet.setColumnWidth(3, 4500);
				         sheet.setColumnWidth(4, 4500);
				         sheet.setColumnWidth(5, 4500);
				         sheet.setColumnWidth(6, 4500);
				         sheet.setColumnWidth(7, 4500);
				     

				         *//**
				          * Style for the header cells.
				          *//*
				         HSSFCellStyle headerCellStyle = wb.createCellStyle();
				         HSSFFont boldFont = wb.createFont();
				         boldFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
				         headerCellStyle.setFont(boldFont);
				         HSSFRow row = sheet.createRow(0);
				         
				         HSSFCell cell = row.createCell(0);
				         cell.setCellStyle(headerCellStyle);
				         cell.setCellValue(new HSSFRichTextString("Item Id"));
				        
				         cell = row.createCell(1);
				         cell.setCellStyle(headerCellStyle);
				         cell.setCellValue(new HSSFRichTextString("SKU"));
				         cell = row.createCell(2);
				         cell.setCellStyle(headerCellStyle);
				         cell.setCellValue(new HSSFRichTextString("Measurment"));
				       
				         cell = row.createCell(3);
				         cell.setCellStyle(headerCellStyle);
				         cell.setCellValue(new HSSFRichTextString("Category"));
				         cell = row.createCell(4);
				         cell.setCellStyle(headerCellStyle);
				         cell.setCellValue(new HSSFRichTextString("State"));
				         cell = row.createCell(5);
				         cell.setCellStyle(headerCellStyle);
				         cell.setCellValue(new HSSFRichTextString("Type"));
				         
				         cell = row.createCell(6);
				         cell.setCellStyle(headerCellStyle);
				         cell.setCellValue(new HSSFRichTextString("Item price"));
				      
				         cell = row.createCell(7);
				         cell.setCellStyle(headerCellStyle);
				         cell.setCellValue(new HSSFRichTextString("New Item Price"));
				      
				         System.out.println("size"+itemArrayList.size());
				         for(int rows=0; rows<(itemArrayList.size()); rows++)
				          {
				        	 itemBean=serverAppContext.getItemByItemMasterId().get(itemArrayList.get(rows).getItemMasterId());
				        	 measurementActionForm=serverAppContext.getMeasurementByMeasurementMasterId().get(itemArrayList.get(rows).getMeasurementMasterId());
				        	 itemCategoryActionForm=serverAppContext.getItemCategoryByItemCategoryMasterId().get(itemArrayList.get(rows).getItemCategoryMasterId());
				        	 
				        	row = sheet.createRow(rows);
				            cell=row.createCell(0);
				            System.out.println("id"+itemBean.getItemMasterId());
				            HSSFRichTextString sku = new HSSFRichTextString(String.valueOf(itemBean.getItemMasterId()));
				            cell.setCellValue(sku);
				            
				             cell = row.createCell(1);
				             HSSFRichTextString stockTakeNo = new HSSFRichTextString((itemBean.getSKU()));
				             cell.setCellValue(stockTakeNo);
				             cell = row.createCell(2);
				             HSSFRichTextString itemDescription = new HSSFRichTextString(measurementActionForm.getName());
				             cell.setCellValue(itemDescription);
				             cell=row.createCell(3);
				             HSSFRichTextString itemMes = new HSSFRichTextString(itemCategoryActionForm.getName());
				             cell.setCellValue(itemMes);
				             cell = row.createCell(4);
				             HSSFRichTextString itemCat = new HSSFRichTextString(String.valueOf(itemBean.getIsCritical()));
				             cell.setCellValue(itemCat);
				             cell = row.createCell(5);
				             HSSFRichTextString itemPrice = new HSSFRichTextString(String.valueOf((itemBean.getItemType())));
				             cell.setCellValue(itemPrice);
				             cell = row.createCell(6);
				             HSSFRichTextString balenceQuantity = new HSSFRichTextString(String.valueOf(itemBean.getItemPrice()));
				             cell.setCellValue(balenceQuantity);
				           
				             cell=row.createCell(7);
				             cell.setCellValue(0);
				          }
				        
				       System.out.println("responce"+response.getStatus());
				         response.setHeader("Content-Disposition", "attachment; filename=itemList.xls");
				         ServletOutputStream out = response.getOutputStream();
					        wb.write(out);
					        out.flush();
					        out.close();
					        jsonObject.put("Message", "success");
				}
			}
			catch (Exception e) {
				System.out.println(e);
			}
			return null;
		}
		
	 
*/
		
		
		
		@GET
		@Path("/getItemCategoryListByFilter")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public JSONObject getItemCategoryListByFilter(String data) throws JSONException{
			//String logInSiteId=logInSiteId();
			
			System.out.println("In Master Data Mgmt Services- getItemCategoryListByFilter");
			
			HashMap<String , String > filterValuesForItem = new HashMap<String, String>();
			
			//set session for automatic dropdown list fill
			HttpSession session=request.getSession(true);
			
			if(request.getParameter("orderStatus")!=null)
			{
				if(!request.getParameter("orderStatus").equalsIgnoreCase(""))
				{
					filterValuesForItem.put(ItemCategoriesDBAdapter.COLUMN_ITEM_CATEGORIES_IS_ACTIVE, request.getParameter("orderStatus"));
				}
			}
			int compid=(int)session.getAttribute(Constants.COMPANY_ID);
			if(request.getParameter("orderStatus")!=null){
				session.setAttribute("orderStatus", request.getParameter("orderStatus"));
			}
			if(request.getParameter("siteId")!=null){
			session.setAttribute("siteId", request.getParameter("siteId"));}
			if(request.getParameter("itemCategoryId")!=null){
				session.setAttribute("itemCategoryId", request.getParameter("suppId"));}
			if(request.getParameter("companyId")!=null){
				session.setAttribute("companyId", request.getParameter("companyId"));}
			
			
			
			
			ItemCategoriesDBHelper categoriesDBHelper=new ItemCategoriesDBHelper();
			JSONArray jsonArray = null;
			JSONObject jsonObject= null;
			JSONObject returnJsonObject= null;
			
			
			try
			{
			
			
			ArrayList<ItemCategoryActionForm> itemCategoryActionForms=categoriesDBHelper.getItemCategoryByCompanyId(compid);
				if(itemCategoryActionForms != null)
				{
					jsonArray = new JSONArray();
					for(int i= 0; i<itemCategoryActionForms.size(); i++)
					{
						jsonObject = new JSONObject();
						jsonObject.put("CategoryId", itemCategoryActionForms.get(i).getItemCategoryMasterId());
						jsonObject.put("CategoryName", itemCategoryActionForms.get(i).getName());
						jsonObject.put("SuperCategoryName", itemCategoryActionForms.get(i).getName());
						jsonObject.put("CreatedOn", itemCategoryActionForms.get(i).getCreatedDTTM());					
						jsonObject.put("edit","<a onclick=editorder("+itemCategoryActionForms.get(i).getItemCategoryMasterId()+"); title='Edit itemCategories'><code class='glyphicon glyphicon-edit'></code></a> <a onclick=deleteOrder("+itemCategoryActionForms.get(i).getItemCategoryMasterId()+"); title='Delete itemCategories'><code class='glyphicon glyphicon-remove'></code></a>");
						if(itemCategoryActionForms.get(i).getIsActive()==0)
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
			catch (Exception e) {
				System.out.println(e);
			}
			returnJsonObject = new JSONObject();
			returnJsonObject.put("aaData", jsonArray);
			return returnJsonObject;
		}
		
		@GET
		@Path("/getMeasurementListByFilter")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public JSONObject getMeasurementListByFilter(String data) throws JSONException{
			
			System.out.println("In Master Data Mgmt Services- getMeasurementListByFilter");
			HashMap<String , String > filterValuesForItemCat = new HashMap<String, String>();
			
			if(request.getParameter("siteId")!=null){
				if(!request.getParameter("siteId").equalsIgnoreCase("null")){
					}
				
				}
			if(request.getParameter("itemCategoryId")!=null){
				if(!request.getParameter("itemCategoryId").equalsIgnoreCase("null")){
					filterValuesForItemCat.put(ItemCategoriesDBAdapter.COLUMN_ITEM_CATEGORIES_MASTER_ID, request.getParameter("itemCategoryId"));
				}
			}
			if(request.getParameter("companyId")!=null){
				if(!request.getParameter("companyId").equalsIgnoreCase("null")){
					filterValuesForItemCat.put(ItemCategoriesDBAdapter.COLUMN_ITEM_CATEGORIES_COMPANY_MASTER_ID, request.getParameter("CompanyMasterId"));
				}
			}
			
			//set session for automatic dropdown list fill
			HttpSession session=request.getSession();
			int compid=(int)session.getAttribute(Constants.COMPANY_ID);
			if(request.getParameter("siteId")!=null){
			session.setAttribute("siteId", request.getParameter("siteId"));}
			if(request.getParameter("itemCategoryId")!=null){
				session.setAttribute("itemCategoryId", request.getParameter("suppId"));}
			if(request.getParameter("companyId")!=null){
				session.setAttribute("companyId", request.getParameter("companyId"));}
					
			JSONArray jsonArray = null;
			JSONObject jsonObject= null;
			JSONObject returnJsonObject= null;
			MeasurementDBHelper measurementDBHelper=new MeasurementDBHelper();
			try
			{
			ArrayList<MeasurementActionForm> measurementActionFormsList= measurementDBHelper.getMeasurementByCompanyId(compid);
				if(measurementActionFormsList != null)
				{
					jsonArray = new JSONArray();
					for(int i= 0; i<measurementActionFormsList.size(); i++)
					{
						jsonObject = new JSONObject();
						jsonObject.put("id", measurementActionFormsList.get(i).getMeasurementMasterId());
						jsonObject.put("unit", measurementActionFormsList.get(i).getUnit());
						jsonObject.put("name", measurementActionFormsList.get(i).getName());
						jsonObject.put("symbol", measurementActionFormsList.get(i).getSymbol());
						jsonObject.put("CreatedDate", measurementActionFormsList.get(i).getCreatedDTTM());
						jsonObject.put("edit","<a onclick=editorder("+measurementActionFormsList.get(i).getMeasurementMasterId()+"); title='Edit measurement'><code class='glyphicon glyphicon-edit'></code></a> <a onclick=deleteOrder("+measurementActionFormsList.get(i).getMeasurementMasterId()+"); title='Delete measurement'><code class='glyphicon glyphicon-remove'></code></a>");
						if(measurementActionFormsList.get(i).getIsActive()==0)
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
			catch (Exception e) {
				System.out.println(e);
			}
			returnJsonObject = new JSONObject();
			returnJsonObject.put("aaData", jsonArray);
			return returnJsonObject;
		}
		
		@GET
		@Path("/getUserRoleListByFilter")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public JSONObject getUserRoleListByFilter(String data) throws JSONException{
			//String logInSiteId=logInSiteId();
			
			System.out.println("In Master Data Mgmt Services- getMeasurementListByFilter");
			HashMap<String , String > filterValuesForItemCat = new HashMap<String, String>();
			
			if(request.getParameter("siteId")!=null){
				if(!request.getParameter("siteId").equalsIgnoreCase("null")){
					filterValuesForItemCat.put(ItemCategoriesDBAdapter.COLUMN_ITEM_CATEGORIES_MASTER_ID, request.getParameter("siteId"));}
				
				}
			if(request.getParameter("itemCategoryId")!=null){
				if(!request.getParameter("itemCategoryId").equalsIgnoreCase("null")){
					filterValuesForItemCat.put(ItemCategoriesDBAdapter.COLUMN_ITEM_CATEGORIES_MASTER_ID, request.getParameter("itemCategoryId"));
				}
			}
			if(request.getParameter("companyId")!=null){
				if(!request.getParameter("companyId").equalsIgnoreCase("null")){
					filterValuesForItemCat.put(ItemCategoriesDBAdapter.COLUMN_ITEM_CATEGORIES_COMPANY_MASTER_ID, request.getParameter("companyId"));
				}
			}
			
			//set session for automatic dropdown list fill
			HttpSession session=request.getSession();
			int compid=(int)session.getAttribute(Constants.COMPANY_ID);
			if(request.getParameter("siteId")!=null){
			session.setAttribute("siteId", request.getParameter("siteId"));}
			if(request.getParameter("itemCategoryId")!=null){
				session.setAttribute("itemCategoryId", request.getParameter("suppId"));}
			if(request.getParameter("companyId")!=null){
				session.setAttribute("companyId", request.getParameter("companyId"));}
			
			
			JSONArray jsonArray = null;
			JSONObject jsonObject= null;
			JSONObject returnJsonObject= null;
			UserRoleDBHelper userRoleDBHelper=new UserRoleDBHelper();
			UserDBHelper userDBHelper = new UserDBHelper();
			try
			{
			ArrayList<UserRoleActionForm> userRoleActionFormsList= userRoleDBHelper.getUserRollByCompanyId(compid);
				if(userRoleActionFormsList != null)
				{
					jsonArray = new JSONArray();
					for(int i= 0; i<userRoleActionFormsList.size(); i++)
					{
						jsonObject = new JSONObject();
						jsonObject.put("id", userRoleActionFormsList.get(i).getUserRolesMasterId());					
						jsonObject.put("userRolename", userRoleActionFormsList.get(i).getName());
						//jsonObject.put("CreatedBy", serverAppContext.getUserByUserMasterId().get(userRoleActionFormsList.get(i).getCreatedBY()).getUserName());
						if(userRoleActionFormsList.get(i).getCreatedBY() == -1){
							jsonObject.put("CreatedBy", "DEFAULT");
						}else{
							jsonObject.put("CreatedBy", userDBHelper.getSingleUserByUserId(userRoleActionFormsList.get(i).getCreatedBY()).getUserName());
						}
						jsonObject.put("edit","<a onclick=editorder("+userRoleActionFormsList.get(i).getUserRolesMasterId()+"); title='Edit userrole'><code class='glyphicon glyphicon-edit'></code></a> <a onclick=deleteOrder("+userRoleActionFormsList.get(i).getUserRolesMasterId()+"); title='Delete userrole'><code class='glyphicon glyphicon-remove'></code></a>");
						if(userRoleActionFormsList.get(i).getIsActive()==0)
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
			catch (Exception e) {
				System.out.println(e);
			}
			returnJsonObject = new JSONObject();
			returnJsonObject.put("aaData", jsonArray);
			return returnJsonObject;
		}
		
	
		
		@GET		
		@Path("/getItemListByFilter")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public JSONObject getItemListByFilter(String data) throws JSONException{
			HttpSession httpsession=request.getSession(true);
			int comid=(int)httpsession.getAttribute(Constants.COMPANY_ID);
			ServerAppContext serverAppContext  = (ServerAppContext)request.getServletContext().getAttribute(Constants.STRUTS_APPLICATION_CONTEXT);
			System.out.println("In Master Data Mgmt Services- getItemListByFilter");
			
			HashMap<String , String > filterValuesForItem = new HashMap<String, String>();
			
			/*if(request.getParameter("itemId")!=null){
				if(!request.getParameter("itemId").equalsIgnoreCase("null")){*/
					filterValuesForItem.put(CompanyDBAdapter.KEY_COMPANYMASTERID,Integer.toString(comid));
			
			if(request.getParameter("fromDate")!=null && request.getParameter("toDate")!=null){
			if(!request.getParameter("fromDate").equalsIgnoreCase("") && !request.getParameter("toDate").equalsIgnoreCase("")){
				filterValuesForItem.put(ItemDBAdapter.COLUMN_ITEM_CREATED_DTTM, "STR_TO_DATE('"+request.getParameter("fromDate")+"', '%d/%m/%Y') AND STR_TO_DATE('"+request.getParameter("toDate")+"', '%d/%m/%Y')");}}
			
			if(request.getParameter("orderStatus")!=null)
			{
				if(!request.getParameter("orderStatus").equalsIgnoreCase(""))
				{
					String res=request.getParameter("orderStatus");
					if(!(res.equals("null")))
					{
						System.out.println("Hello Rahul");
						filterValuesForItem.put(ItemDBAdapter.COLUMN_ITEM_IS_ACTIVE, request.getParameter("orderStatus"));
					}
					
					
				}
			}
			
			ItemDBHelper itemDBHelper=new ItemDBHelper();
			
			if(request.getParameter("itemId")==null);
			
			
			JSONArray jsonArray = null;
			JSONObject jsonObject= null;
			JSONObject returnJsonObject= null;
			try
			{
				
				ArrayList<ItemActionForm> itemActionForms=itemDBHelper.fetchAllRecordsByFilter(filterValuesForItem);
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
						jsonObject.put("availableQ", "<label id='stock"+itemActionForms.get(i).getItemMasterId()+"'>"+itemActionForms.get(i).getStockQuantity()+"</label>");
						jsonObject.put("addStock", "<div class='input-inline input-medium'><div class='input-group bootstrap-touchspin'><input id='addStock"+itemActionForms.get(i).getItemMasterId()+"' name='addStock' type='text' class='form-control' style='display: block;'><span class='input-group-addon bootstrap-touchspin-prefix'><a onclick=updateStock("+itemActionForms.get(i).getItemMasterId()+")><code class='glyphicon glyphicon-edit'></code></a></span><span class='input-group-addon bootstrap-touchspin-postfix' style='display: none;'></span></div></div>");
						jsonObject.put("createdDTTM", itemActionForms.get(i).getCreatedDTTM());
						jsonObject.put("edit","<a onclick=editorder("+itemActionForms.get(i).getItemMasterId()+"); title='Edit item'><code class='glyphicon glyphicon-edit'></code></a> <a onclick=deleteOrder("+itemActionForms.get(i).getItemMasterId()+"); title='Delete item'><code class='glyphicon glyphicon-remove'></code></a>");
						jsonObject.put("itemPricetext"," <input type='text' styleClass='form-control' styleId='"+i+"' value='"+itemActionForms.get(i).getItemPrice()+"'onchange='changeState("+itemActionForms.get(i).getItemMasterId()+",this.value)' />");
						//jsonObject.put("status","<select id='stateId"+i+"' name='"+orderMasterActionFormsList.get(i).getOrderMasterId()+"' class='form-control input-xmedium select2me statusVal' disabled onchange='changeState("+orderMasterActionFormsList.get(i).getOrderMasterId()+",this.value)'><option value='1' selected>Submitted</option><option value='2'>Processed</option><option value='6'>Cancelled</option></select>");
						if(itemActionForms.get(i).getIsActive()==0)
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
			catch (Exception e) {
				System.out.println("In Master Data Mgmt Service getItemListByFilter"+e);
			}
			returnJsonObject = new JSONObject();
			returnJsonObject.put("aaData", jsonArray);
			return returnJsonObject;
		}
		
		@GET		
		@Path("/getUsersListByFilter")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public JSONObject getUsersListByFilter(String data) throws JSONException{
			//String logInSiteId=logInSiteId();
			//ServerAppContext serverAppContext  = (ServerAppContext)request.getServletContext().getAttribute(Constants.STRUTS_APPLICATION_CONTEXT);
			System.out.println("In Master Data Mgmt Services- getUsersListByFilter");
			HttpSession session=request.getSession();
			int compid=(int)session.getAttribute(Constants.COMPANY_ID);
			HashMap<String , String > filterValuesForUser = new HashMap<String, String>();
			
			/*if(request.getParameter("userId")!=null){
				if(!request.getParameter("userId").equalsIgnoreCase("null")){*/
					filterValuesForUser.put(CompanyDBAdapter.KEY_COMPANYMASTERID, Integer.toString(compid));
					
			System.out.println(request.getParameter("userId"));		
			if(request.getParameter("userId")!=null)
			{
				if(!request.getParameter("userId").equalsIgnoreCase("null"))
					filterValuesForUser.put(UserDBAdapter.KEY_USERMASTERID, request.getParameter("userId"));
			}
			System.out.println(request.getParameter("userRole"));
			if(request.getParameter("userRole")!=null){
				if(!request.getParameter("userRole").equalsIgnoreCase("null")){
					filterValuesForUser.put(UserDBAdapter.KEY_USERROLEMASTERID, "'"+request.getParameter("userRole")+"'");
				}
			}
			if(request.getParameter("companyId")!=null){
				if(!request.getParameter("companyId").equalsIgnoreCase("null")){
					filterValuesForUser.put(UserDBAdapter.KEY_COMPANYID, request.getParameter("companyId"));
				}
			}
			
			//set session for automatic dropdown list fill
			
			
			if(request.getParameter("userId")!=null){
				session.setAttribute("userId", request.getParameter("userId"));}
			if(request.getParameter("userRole")!=null){
				session.setAttribute("userRole", request.getParameter("userRole"));}
			if(request.getParameter("companyId")!=null){
				session.setAttribute("companyId", request.getParameter("companyId"));}
		
			
			
			
			UserDBHelper userDBHelper=new UserDBHelper();
			if(request.getParameter("userId")==null && request.getParameter("userRole")==null);
			if(this.equals("rahul"));
			JSONArray jsonArray = null;
			JSONObject jsonObject= null;
			JSONObject returnJsonObject= null;
			try
			{
				ArrayList<UserActionForm> userActionForms=userDBHelper.getAllUsersByFilter(filterValuesForUser);
				if(userActionForms != null)
				{
					jsonArray = new JSONArray();
					for(int i= 0; i<userActionForms.size(); i++)
					{
						//if(userActionForms.get(i).getUserRolesMasterId()!=3){
						
						jsonObject = new JSONObject();
						jsonObject.put("UserId", userActionForms.get(i).getUserMasterId());
						jsonObject.put("UserName", userActionForms.get(i).getUserName());
						jsonObject.put("FirstName",userActionForms.get(i).getFirstName());
						if(userActionForms.get(i).getPhoneNumber1().equalsIgnoreCase("") || userActionForms.get(i).getPhoneNumber1()==null){
							jsonObject.put("PhoneNo", "-");
						}else{
							jsonObject.put("PhoneNo",userActionForms.get(i).getPhoneNumber1());
						}
											
						jsonObject.put("edit","<a onclick=editorder("+userActionForms.get(i).getUserMasterId()+"); title='Edit users'><code class='glyphicon glyphicon-edit'></code></a> <a onclick=deleteOrder("+userActionForms.get(i).getUserMasterId()+"); title='Delete users'><code class='glyphicon glyphicon-remove'></code></a>");
						if(userActionForms.get(i).getIsActive()==0)
						{
							jsonObject.put("status", "Not Active");
						}
						else
						{
							jsonObject.put("status", "Active");
						}
						String userRole=userActionForms.get(i).getUserRoleName();																	
						jsonObject.put("UserRole",userRole);
						
						
						//int companyid=1;
						//Right Now we Company Id=1 latter on we will change.
						/*companyid=userActionForms.get(i).getCompanyMasterId();
						CompanyDBHelper companyDBHelper=new CompanyDBHelper();
						CompanyActionForm companyActionForm=companyDBHelper.getSingleUserByUserId(companyid);
						jsonObject.put("CompanyName",companyActionForm.getName());*/
					//	jsonObject.put("CreatedOn",userActionForms.get(i).getCreationDate());
						jsonArray.put(jsonObject);
					//}
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
			System.out.println("fgfggf"+returnJsonObject);
			return returnJsonObject;
			
		}
		
		
		@GET		
		@Path("/getCustomerListByFilter")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public JSONObject getCustomerListByFilter(String data) throws JSONException{
			//String logInSiteId=logInSiteId();
			//ServerAppContext serverAppContext  = (ServerAppContext)request.getServletContext().getAttribute(Constants.STRUTS_APPLICATION_CONTEXT);
			System.out.println("In Master Data Mgmt Services- getCustomerListByFilter");
			HttpSession session=request.getSession();
			int compid=(int)session.getAttribute(Constants.COMPANY_ID);
			HashMap<String , String > filterValuesForUser = new HashMap<String, String>();			
			filterValuesForUser.put(CompanyDBAdapter.KEY_COMPANYMASTERID, Integer.toString(compid));			
			if(request.getParameter("companyId")!=null){
				if(!request.getParameter("companyId").equalsIgnoreCase("null")){
					filterValuesForUser.put(UserDBAdapter.KEY_COMPANYID, request.getParameter("companyId"));
				}
			}
			
			UserDBHelper userDBHelper=new UserDBHelper();
			UserActionForm userBean=new UserActionForm();
			JSONArray jsonArray = null;
			JSONObject jsonObject= null;
			JSONObject returnJsonObject= null;
			try
			{
				ArrayList<UserActionForm> userActionForms=userDBHelper.getAllUsersByFilter(filterValuesForUser);
				if(userActionForms != null)
				{
					jsonArray = new JSONArray();
					for(int i= 0; i<userActionForms.size(); i++)
					{
						if(userActionForms.get(i).getUserRolesMasterId()==3){
						
						jsonObject = new JSONObject();
						jsonObject.put("custId", userActionForms.get(i).getUserMasterId());
						jsonObject.put("custName", userActionForms.get(i).getUserName());
						jsonObject.put("PhoneNo",userActionForms.get(i).getPhoneNumber1());
						jsonObject.put("Email", userActionForms.get(i).getEmail());
					
						userBean=userDBHelper.getSingleUserByUserId(userActionForms.get(i).getCreatedBy());
						if(userBean!=null)
						jsonObject.put("createdBy", userBean.getFirstName() +"   "+userBean.getLastName());
						
						jsonObject.put("edit","<a onclick=editorder("+userActionForms.get(i).getUserMasterId()+"); title='Edit users'><code class='glyphicon glyphicon-edit'></code></a> <a onclick=deleteOrder("+userActionForms.get(i).getUserMasterId()+"); title='Delete users'><code class='glyphicon glyphicon-remove'></code></a>");
						if(userActionForms.get(i).getIsActive()==Constants.USER_STATUS_IN_ACTIVE)
						{
							jsonObject.put("status", "In Active");
						}
						else
						{
							jsonObject.put("status", "Active");
						}
						
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
			System.out.println("fgfggf"+returnJsonObject);
			return returnJsonObject;
			
		}
		
		
		@POST
		@Path("/getAccessContols")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public JSONArray getAccessContols(String data) throws JSONException
		{
			System.out.println("In Master Data Mgmt Services- getAccessContols");
			AuthorisedMatrixDBHelper authorisedMatrixDBHelper=new AuthorisedMatrixDBHelper();
			JSONArray jsonArray = null;
			JSONObject jsonObject= new JSONObject(data);
			ArrayList<AuthorisedMatrixActionForm> authArrayList=null;
			try
			{
				if(jsonObject.has("roleId"))
					authArrayList=authorisedMatrixDBHelper.fetchAllRecordsByRoleId(jsonObject.getInt("roleId"));	
			jsonArray = new JSONArray();
			if(authArrayList != null)
			{
				jsonArray = new JSONArray();
				for(int i= 0; i<authArrayList.size(); i++)
				{
					if(authArrayList.get(i).getMappingStatus()==1)
					{
					jsonObject = new JSONObject();
					jsonObject.put("moduleName", authArrayList.get(i).getModulekey());
					jsonArray.put(jsonObject);
					}
				}
			}
			else
			{
				jsonArray = new JSONArray();
			}
			}
			catch(Exception e)
			{
				System.out.println("In Master Data Mgmt Service getAccessContols"+e);
			}
			return jsonArray;
		}
		
		
		@GET
		@Path("/getItemCustomerPriceMappingListByFilter")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public JSONArray getItemCustomerPriceMappingListByFilter(String data) throws JSONException,NullPointerException
		{
			//ServerAppContext serverAppContext  = (ServerAppContext)request.getServletContext().getAttribute(Constants.STRUTS_APPLICATION_CONTEXT);
			HttpSession httpSession=request.getSession(true);
			
			int companyId=(int)httpSession.getAttribute(Constants.COMPANY_ID);
			
			System.out.println("In Master Data Mgmt Services- getItemSupplierMappingListByFilter");
			//ItemSupplierMapDBHelper itemSupplierMapDBHelper=new ItemSupplierMapDBHelper();
			ItemCustomerPriceMappingDBHelper itemCustomerPriceMappingDBHelper=new ItemCustomerPriceMappingDBHelper();
			//StringBuffer itemLabel=new StringBuffer();
			JSONArray jsonArray = null;
			JSONObject jsonObject= null;
			try
			{
					if(request.getParameter("userMasterId")!=null)
					{
						ArrayList<ItemCustomerPriceMappingActionForm> itemCustomerPriceMappingActionForms=itemCustomerPriceMappingDBHelper.getItemCustomerPriceMappingByCustomerIdAndCompanyId(Integer.parseInt(request.getParameter("userMasterId")),companyId);
						jsonArray = new JSONArray();
						if(itemCustomerPriceMappingActionForms != null)
						{
							jsonArray = new JSONArray();
							for(int i= 0; i<itemCustomerPriceMappingActionForms.size(); i++)
							{
									jsonObject = new JSONObject();
									//itemLabel.delete(0, itemLabel.length());
									int itemId=itemCustomerPriceMappingActionForms.get(i).getItemId();
									jsonObject.put("itemId",itemId);
									jsonObject.put("price", itemCustomerPriceMappingActionForms.get(i).getItemPrice());
									jsonArray.put(jsonObject);
									//System.out.println(itemSupplierActionForms.get(i).getItemId());
								}
							}
					}
					else
					{
						jsonArray = new JSONArray();
					}
			}
			catch(Exception e)
			{
				System.out.println("In Master Data Mgmt Service getItemSupplierMappingListByFilter"+e);
			}
			/*returnJsonObject = new JSONObject();
			returnJsonObject.put("aaData", jsonArray);
			return returnJsonObject;
			*/return jsonArray;
		}
		
						
		@GET
		@Path("/getCompanyListByFilter")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public JSONObject getCompanyListByFilter(String data) throws JSONException
		{
			JSONObject jsonObject = null;
			JSONArray jsonArray = null;
			JSONObject returnJsonObject= null;
			CompanyDBHelper companyDBHelper=new CompanyDBHelper();
			UserDBHelper userDBHelper = new UserDBHelper();
			
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
						//jsonObject.put("createdBy",serverAppContext.getUserByUserMasterId().get(companylist.get(i).getCreatedBy()).getUserName());
						jsonObject.put("createdBy",userDBHelper.getSingleUserByUserId(companylist.get(i).getCreatedBy()).getFirstName()+" "+userDBHelper.getSingleUserByUserId(companylist.get(i).getCreatedBy()).getLastName());
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
			@Path("/getOrderStageListByFilter")
			@Produces(MediaType.APPLICATION_JSON)
			@Consumes(MediaType.APPLICATION_JSON)
			public JSONObject getOrderStageListByFilterr(String data) throws JSONException
			{
				ServerAppContext serverAppContext  = (ServerAppContext)request.getServletContext().getAttribute(Constants.STRUTS_APPLICATION_CONTEXT);
				HttpSession session=request.getSession();
				int compid=(int)session.getAttribute(Constants.COMPANY_ID);
			
				JSONObject jsonObject = null;
				JSONArray jsonArray = null;
				JSONObject returnJsonObject= null;
				OrderStageDBHelper orderStageDBHelper=new OrderStageDBHelper();
				
				try
				{
					jsonObject = new JSONObject();
					if(jsonObject !=null)
					{
						
						
						ArrayList<OrderStageActionForm>orderstageList=orderStageDBHelper.getOrderStageByCompanyId(compid);
						if(orderstageList!=null)
						{
							jsonArray = new JSONArray();
							for(int i=0; i<orderstageList.size(); i++)
							{		
								
							jsonObject = new JSONObject();
							jsonObject.put("orderstageid",orderstageList.get(i).getOrderStageMasterId());
							jsonObject.put("name",orderstageList.get(i).getName());
							jsonObject.put("createdBy",serverAppContext.getUserByUserMasterId().get(orderstageList.get(i).getCreatedBy()).getUserName());
							jsonObject.put("CreatedOn",orderstageList.get(i).getCreatedDTTM());
							jsonObject.put("status",orderstageList.get(i).getIsActive());
							jsonObject.put("edit","<a onclick=editorder("+orderstageList.get(i).getOrderStageMasterId()+"); title='Edit Orderstage'><code class='glyphicon glyphicon-edit'></code></a> <a onclick=deleteOrder("+orderstageList.get(i).getOrderStageMasterId()+"); title='Delete OrderStage'><code class='glyphicon glyphicon-remove'></code></a>");
						
							if(orderstageList.get(i).getIsActive()==0)
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
			
			// Method for displaying list of packages
			
			@GET
			@Path("/getAllPkg")
			@Produces(MediaType.APPLICATION_JSON)
			@Consumes(MediaType.APPLICATION_JSON)
			public JSONObject getAllPkg() throws JSONException
			{
				System.out.println("Proccesing in getAllPkg");
				PackagesDBHelper pkgDBHelper=new PackagesDBHelper();
				JSONArray jsonArray = null;
				JSONObject jsonObject= null;
				JSONObject returnJsonObject= null;
				
				
				try
				{
					ArrayList<PackagesActionForm> pkgFormData = pkgDBHelper.getAllActivePkg();
					UserDBHelper userDBHelper=new UserDBHelper();
					UserActionForm userActionForm;
					
					
					if(pkgFormData!=null)
					{
						jsonArray=new JSONArray();
						for(int i=0; i<pkgFormData.size();i++)
						{
							jsonObject=new JSONObject();
							jsonObject.put("pkgid", pkgFormData.get(i).getPackageMasterId());
							jsonObject.put("pkgname", pkgFormData.get(i).getPackageName());
							jsonObject.put("pkgdesc", pkgFormData.get(i).getPackageDescription());
							int createdById=pkgFormData.get(i).getCreatedBy();
							userActionForm=userDBHelper.getSingleUserByUserId(createdById);
							String name=userActionForm.getFirstName();
							//jsonObject.put("pkgcreatedby", pkgFormData.get(i).getCreatedBy());
							jsonObject.put("pkgcreatedby", name);
							jsonObject.put("pkgactivestatus", pkgFormData.get(i).getPackageStatus());
							jsonObject.put("pkgcharge", pkgFormData.get(i).getPackageCharge());
							jsonObject.put("editoption", "<a onclick=editpkg("+pkgFormData.get(i).getPackageMasterId()+"); title='edit package'><code class='glyphicon glyphicon-edit'></code></a><a onclick=deletePkg("+pkgFormData.get(i).getPackageMasterId()+"); title='Delete Packaage'><code class='glyphicon glyphicon-remove'></code></a>");
							
							if(pkgFormData.get(i).getPackageStatus()==0)
							{
								jsonObject.put("pkgactivestatus", "InActive");							
							}
							else
							{
								jsonObject.put("pkgactivestatus", "Active");
							}
							jsonArray.put(jsonObject);
						}
					}
					
				}
				catch(Exception e)
				{
					
				}
				
				returnJsonObject=new JSONObject();
				returnJsonObject.put("aaData",jsonArray );
				return returnJsonObject;
				//return new JSONObject();
			}
				
			

}

