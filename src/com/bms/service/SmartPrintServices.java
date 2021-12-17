package com.bms.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

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
import com.bms.mdm.item.ItemActionForm;
import com.bms.mdm.item.ItemDBHelper;
import com.bms.neetai.company.CompanyActionForm;
import com.bms.neetai.company.CompanyDBHelper;
import com.bms.neetai.users.UserActionForm;
import com.bms.neetai.users.UserDBHelper;
import com.bms.neetai.users.UserMasterAction;
import com.bms.order.orderdetail.OrderDetailActionForm;
import com.bms.order.orderdetail.OrderDetailDBHelper;
import com.bms.order.ordermaster.OrderMasterActionForm;
import com.bms.order.ordermaster.OrderMasterDBHelper;
import com.bms.utility.printutils.PrintUtility;
import com.bms.utility.printutils.PrintUtilityBean;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
@Path("/SmartPrintServices")

public class SmartPrintServices {
	
	
	
	

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
	HttpSession session;



	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String respondAsReady() {
		return "Print service is ready!";
	}

	
	/*
	 * 
	 * Below Function is Print for Booking (Hotel Booking/Car Booking)
	 */
	
	@POST
	@Path("/orderingPrintservice")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JSONObject orderingPrintservice(String data) throws JSONException, NumberFormatException, ParseException{
		
		    PrintUtilityBean printUtilityBean=null;
			OrderDetailDBHelper orderDetailDBHelper= new OrderDetailDBHelper();
			JSONObject jsonObject = null;
			JSONArray jsonArray = null;
			String orderMaster="";
			long master=0;
			try
			{
				jsonObject = new JSONObject(data);
				System.out.println("Data is "+data);
				//String orderMasterId = jsonObject.getString("orderNumber");
				orderMaster =  (String) jsonObject.get("orderNumber");
				
				String printerType=jsonObject.getString("printerType");
				System.out.println("Order Number is "+orderMaster);
				jsonArray = new JSONArray();
					if(jsonObject !=null)
					{
						
						master = (long) Long.parseLong(orderMaster);
						OrderMasterDBHelper orderMasterDBHelper= new OrderMasterDBHelper();
						OrderMasterActionForm orderMasterActionForm=orderMasterDBHelper.getOrderByOrderNumber(master);
						UserDBHelper userDBHelper= new UserDBHelper();
						UserActionForm userActionForm=userDBHelper.getSingleUserByUserId(orderMasterActionForm.getUserMasterId());
						ItemDBHelper itemDBHelper= new ItemDBHelper();

						CompanyDBHelper companyDBHelper= new CompanyDBHelper();
						CompanyActionForm companyActionForm=companyDBHelper.getCompanybyCompanyMasterId(orderMasterActionForm.getCompanyMasterId());
						//jsonObject = new JSONObject();
						jsonArray = new JSONArray();
							
							jsonObject = new JSONObject();
								
								if(companyActionForm.getName()!=null && !companyActionForm.getName().equalsIgnoreCase("") && !companyActionForm.getName().equalsIgnoreCase(null))
								{
									jsonObject.put("companyName", companyActionForm.getName());
								}
								else{
									jsonObject.put("companyName", "");
								}
								
								if(companyActionForm.getName()!=null && !companyActionForm.getName().equalsIgnoreCase("") && !companyActionForm.getName().equalsIgnoreCase(null))
								{
									jsonObject.put("companyAddress", companyActionForm.getAddress());
								}
								else{
									jsonObject.put("companyAddress", "");
								}
								
								
							 	if(userActionForm.getUserName()!=null && !userActionForm.getUserName().equalsIgnoreCase("") && !userActionForm.getUserName().equalsIgnoreCase(null))
								{
									jsonObject.put("custName", userActionForm.getFirstName());
								}
								else{
									jsonObject.put("custName", "");
								}
								
								if(userActionForm.getAddress()!=null && !userActionForm.getAddress().equalsIgnoreCase("") && !userActionForm.getAddress().equalsIgnoreCase(null))
								{
									jsonObject.put("custAddress", userActionForm.getAddress());
								}else
								{
									jsonObject.put("custAddress", "");
								}
								
								if(userActionForm.getCity()!=null && !userActionForm.getCity().equalsIgnoreCase("") && !userActionForm.getCity().equalsIgnoreCase(null))
								{
									jsonObject.put("custCity", userActionForm.getCity());
								}else
								{
									jsonObject.put("custCity", "");
								}
								
								if(userActionForm.getState()!=null && !userActionForm.getState().equalsIgnoreCase("") && !userActionForm.getState().equalsIgnoreCase(null))
								{
									jsonObject.put("custState", userActionForm.getState());
								}else
								{
									jsonObject.put("custState", "");
								}
								
								if(userActionForm.getPhoneNumber1()!=null && !userActionForm.getPhoneNumber1().equalsIgnoreCase("") && !userActionForm.getPhoneNumber1().equalsIgnoreCase(null))
								{
									jsonObject.put("custContact", userActionForm.getPhoneNumber1());
								}
								else{
									jsonObject.put("custContact", "");
								}
							
										if(userActionForm!=null)
											{
												if(orderMasterActionForm!=null)
												{
													if(orderMasterActionForm.getOrderNumber()!=null && !orderMasterActionForm.getOrderNumber().equalsIgnoreCase("") && !orderMasterActionForm.getOrderNumber().equalsIgnoreCase(null))
													{
													jsonObject.put("orderNo", orderMasterActionForm.getOrderNumber());
													}else{
													jsonObject.put("orderNo", "");
													}
													if(orderMasterActionForm.getCreatedDate()!=null && !orderMasterActionForm.getCreatedDate().equalsIgnoreCase("") && !orderMasterActionForm.getCreatedDate().equalsIgnoreCase(null))
													{
														String dateString= orderMasterActionForm.getCreatedDate();
														String result  = dateString.split(" ")[0];
														/*String input = orderMasterActionForm.getCreatedDate();
														String output = input.substring(0, 11);*/
													jsonObject.put("orderDate", result);
													}else{
													jsonObject.put("orderDate", "");
													}
												}
											}
							jsonArray.put(jsonObject);
							ArrayList<OrderDetailActionForm> orderList=orderDetailDBHelper.getOrderDetailsListByOrderMasterId(orderMasterActionForm.getOrderMasterId());
							if(orderList!=null)
								{				
									Iterator<OrderDetailActionForm> orderItr=orderList.iterator();
									while(orderItr.hasNext())
									{
										JSONObject json1=new JSONObject();
										OrderDetailActionForm ordedet=orderItr.next();
										//OrderDetailActionForm orderDetailActionFormforItem = orderDetailDBHelper.getOrderByorderMasterId(orderMasterActionForm.getOrderMasterId());
										ItemActionForm itemActionForm =itemDBHelper.getItemById(ordedet.getItemMasterId());
										//JSONObject json2=new JSONObject();
										if(ordedet!=null && itemActionForm!=null)
											json1.put("itemName", itemActionForm.getName());
											json1.put("itemRate", ordedet.getRate());
											json1.put("itemQty", ordedet.getQuantity());
											json1.put("itemAmt", ordedet.getAmount());
										jsonArray.put(json1);
									}
									
								 }else{
									 jsonArray = new JSONArray();
								 }
							jsonObject.put("totalBill", orderMasterActionForm.getTotal());
							jsonObject.put("lblCustDetails","CUSTOMER DETAILS");
							jsonObject.put("lblOrderDetails","ORDER DETAILS");
							//jsonObject.put(printerType, jsonObject);
						}
				printUtilityBean=PrintUtilityBean.getPrintUtilityBeanInstance();	
				printUtilityBean.setPrinterName("Thermal");
				printUtilityBean.setPrinterType(printerType);
				printUtilityBean.setPrintingModule("ORDER");
				printUtilityBean.setPrintProfile(Constants.BMS_ORDER_MODULE);//Set 1 means We have Set here Booking Print Services
			}
			catch (Exception e) {
				System.out.println(e);
			}
			PrintUtility printUtility=new PrintUtility();
			String data3=printUtility.print(printUtilityBean, jsonArray);
			jsonObject.put("printData", data3);
			System.out.println("Final Printed data is: "+data3);
			return (jsonObject);
		}
	


}	

	
	
	

