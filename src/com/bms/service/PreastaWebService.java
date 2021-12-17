
package com.bms.service;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import javax.ws.rs.core.UriInfo;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.bms.config.ConfigActionForm;
import com.bms.config.ConfigDBHelper;
import com.bms.constants.Constants;
import com.bms.context.ServerAppContext;
import com.bms.mail.MailSMS;
import com.bms.mapping.itemcustomerpricemapping.ItemCustomerPriceMappingActionForm;
import com.bms.mapping.itemcustomerpricemapping.ItemCustomerPriceMappingDBHelper;
import com.bms.mdm.item.ItemActionForm;
import com.bms.mdm.item.ItemDBAdapter;
import com.bms.mdm.item.ItemDBHelper;
import com.bms.mdm.itemcategories.ItemCategoriesDBAdapter;
import com.bms.mdm.measurement.MeasurementActionForm;
import com.bms.mdm.measurement.MeasurementDBAdapter;
import com.bms.mdm.orderstage.OrderStageActionForm;
import com.bms.mdm.orderstage.OrderStageDBAdapter;
import com.bms.mdm.orderstage.OrderStageDBHelper;
import com.bms.neetai.company.CompanyDBAdapter;
import com.bms.neetai.userroles.UserRoleActionForm;
import com.bms.neetai.userroles.UserRoleDBAdapter;
import com.bms.neetai.userroles.UserRoleDBHelper;
import com.bms.neetai.users.UserActionForm;
import com.bms.neetai.users.UserDBAdapter;
import com.bms.neetai.users.UserDBHelper;
import com.bms.order.orderdetail.OrderDetailActionForm;
import com.bms.order.orderdetail.OrderDetailDBHelper;
import com.bms.order.ordermaster.OrderMasterActionForm;
import com.bms.order.ordermaster.OrderMasterDBAdapter;
import com.bms.order.ordermaster.OrderMasterDBHelper;
import com.bms.output.FileStreamingOutput;
import com.bms.retail.RetailActionForm;
import com.bms.retail.RetailDBHelper;
import com.bms.sale.saledetail.SaleDetailActionForm;
import com.bms.sale.saledetail.SaleDetailDBHelper;
import com.bms.sale.salemaster.SaleMasterActionForm;
import com.bms.sale.salemaster.SaleMasterDBHelper;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@Path("/preastaWebService")
public class PreastaWebService {

	// private TakeAwayBean takeAwayBean = new TakeAwayBean();

	// The @Context annotation allows us to have certain contextual objects
	// injected into this class.
	// UriInfo object allows us to get URI information (no kidding).
	@Context
	UriInfo uriInfo;

	// Another "injected" object. This allows us to use the information that's
	// part of any incoming request.
	// We could, for example, get header information, or the requestor's
	// address.
	// Request request;
	// Response response;
	@Context
	HttpServletRequest request;
	HttpServletResponse response;

	// This function return site of login user

	public int UserRoleofLoginUser() {
		UserActionForm userActionForm = new UserActionForm();
		HttpSession session = request.getSession(true);
		userActionForm = (UserActionForm) session.getAttribute(Constants.USER_BEAN);
		return userActionForm.getUserRolesMasterId();
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String respondAsReady() {
		return "Smart web service is ready!";
	}

	@POST
	@Path("/getItemStock")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JSONObject getItemStock() {
		try {
			JSONObject jsonObject = null;
			JSONArray jsonArray = new JSONArray();
			ItemDBHelper itemDBHelper = new ItemDBHelper();
			HttpSession httpsession = request.getSession(true);
			int comid = (int) httpsession.getAttribute(Constants.COMPANY_ID);
			ArrayList<ItemActionForm> itemListal = itemDBHelper.getItemByCompanyId(comid);

			for (int i = 0; i < itemListal.size(); i++) {
				jsonObject = new JSONObject();
				jsonObject.put("itemId", itemListal.get(i).getItemMasterId());
				jsonObject.put("stock", itemListal.get(i).getStockQuantity());
				jsonArray.put(jsonObject);
			}
			JSONObject returnJsonObject = new JSONObject();
			returnJsonObject.put("data", jsonArray);
			return returnJsonObject;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@POST
	@Path("/updateStock")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JSONObject updateStock(String data) throws JSONException {
		JSONObject jsonObject = new JSONObject(data);
		try {

			int itemMasterId = jsonObject.getInt("itemMasterId");
			float updateValue = Float.parseFloat(jsonObject.getString("updateValue"));

			ItemDBHelper itemDBHelper = new ItemDBHelper();
			ItemActionForm itemBean = itemDBHelper.getItemById(itemMasterId);
			float availableStock = itemBean.getStockQuantity();
			float updatedStock = availableStock + (float) updateValue;
			itemBean.setStockQuantity(updatedStock);
			itemDBHelper.updateItemEntry(itemBean);
			jsonObject.put("result", "done");
			return jsonObject;
		} catch (Exception e) {
			jsonObject.put("result", "done");
			System.out.println(e);
			return jsonObject;
		}

	}

	@POST
	@Path("/checkForUniqueUserName")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JSONObject checkForUniqueUserName(String data) throws JSONException {
		JSONObject jsonObject = new JSONObject(data);
		try {
			boolean flag = false;
			String uname = String.valueOf(jsonObject.get("userName"));
			UserDBHelper userDBHelper = new UserDBHelper();
			ArrayList<UserActionForm> userList = userDBHelper.getAllUsers();
			for (int i = 0; i < userList.size(); i++) {
				if (uname.equalsIgnoreCase(userList.get(i).getUserName())) {
					flag = true;
					break;
				}
			}

			if (flag) {
				jsonObject.put("result", "contains");
			} else {
				jsonObject.put("result", "notcontains");
			}
			return jsonObject;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@POST
	@Path("/makeUpdateDispatchValues")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JSONObject makeUpdateDispatchValues(String data) throws JSONException {
		JSONObject jsonObject = new JSONObject(data);
		try {
			JSONArray jsonArrayOrderIds = jsonObject.getJSONArray("orderDetailIds");
			JSONArray jsonArrayDispatchQuantityValues = jsonObject.getJSONArray("dispatchQuantityValues");
			JSONArray jsonArrayEditableRates = jsonObject.getJSONArray("editableRates");
			System.out.println(
					jsonArrayOrderIds + " : " + jsonArrayDispatchQuantityValues + " : " + jsonArrayEditableRates);

			RetailDBHelper retailHelper = new RetailDBHelper();
			UserRoleDBHelper roleHelper = new UserRoleDBHelper();
			UserDBHelper userDBHelper = new UserDBHelper();
			OrderMasterDBHelper orderMasterDBHelper = new OrderMasterDBHelper();
			OrderDetailDBHelper orderDetailDBHelpe = new OrderDetailDBHelper();
			int orderMasterId = orderDetailDBHelpe.getOrderByorderDetailDBAdapterId(jsonArrayOrderIds.getInt(0))
					.getOrderMasterId();

			Float totalDispatchedQuantity = 0f;
			try {
				for (int i = 0; i < jsonArrayDispatchQuantityValues.length(); i++) {
					if (!jsonArrayDispatchQuantityValues.get(i).equals("")) {
						totalDispatchedQuantity += Float.parseFloat(jsonArrayDispatchQuantityValues.getString(i));
					}
				}
				System.out.println(totalDispatchedQuantity);
			} catch (Exception e) {
				System.out.println(e);
			}

			boolean flagODSuccessOp = false, flagODException = false, flagOMSuccessOp = false;
			for (int i = 0; i < jsonArrayOrderIds.length(); i++) {
				int orderDetailId = jsonArrayOrderIds.getInt(i);
				float currentDispatchedQty = 0f, updatedDispatchedQty = 0f;

				OrderDetailDBHelper orderDetailDBHelper = new OrderDetailDBHelper();
				OrderDetailActionForm orderDetailForm = new OrderDetailActionForm();

				if (!jsonArrayDispatchQuantityValues.get(i).equals("")) {
					int uid = orderMasterDBHelper.getOrderByMasterId(orderMasterId).getUserMasterId();
					int uroleid = userDBHelper.getSingleUserByUserId(uid).getUserRolesMasterId();
					if (roleHelper.getUserRoleByRoleId(uroleid).getName()
							.equalsIgnoreCase(Constants.ROLE_NAME_FOR_RETAILER)) {
						int itemid = orderDetailDBHelpe.getOrderByorderDetailDBAdapterId(orderDetailId)
								.getItemMasterId();
						RetailActionForm retailBean = retailHelper.getRetailDetailsByRetailerAndItem(uid, itemid);
						retailBean.setDeliveredquantity(retailBean.getDeliveredquantity()
								+ Float.parseFloat(jsonArrayDispatchQuantityValues.getString(i)));
						retailHelper.updateRetailDetails(retailBean);
					}

					System.out.println("Here I come");
					orderDetailForm = orderDetailDBHelper.getOrderByorderDetailDBAdapterId(orderDetailId);

					currentDispatchedQty = orderDetailForm.getDispatchedQuantity();
					updatedDispatchedQty = currentDispatchedQty
							+ Float.parseFloat(jsonArrayDispatchQuantityValues.getString(i));
					orderDetailForm.setDispatchedQuantity(updatedDispatchedQty);
					// orderDetailDBHelper.updateorderDetailDBAdapter(orderDetailForm);
					try {
						orderDetailDBHelper.updateorderDetailDBAdapter(orderDetailForm);
						flagODSuccessOp = true;
					} catch (Exception e) {
						flagODException = true;
						System.out.println(e);
					}
				} else {

					System.out.println("here ;)");
				}
			}

			if (flagODSuccessOp) {
				jsonObject.put("result", "done");
			} else {
				jsonObject.put("result", "error");
			}

			/*
			 * int currentOrderMasterDisQty, updatedOrderMasterDisQty;
			 * currentOrderMasterDisQty =
			 * orderMasterDBHelper.getOrderByMasterId(orderMasterId).
			 * getDispatchedQuantity(); updatedOrderMasterDisQty =
			 * currentOrderMasterDisQty + totalDispatchedQuantity;
			 * orderMasterActionForm =
			 * orderMasterDBHelper.getOrderByMasterId(orderMasterId);
			 * orderMasterActionForm.setDispatchedQuantity(
			 * updatedOrderMasterDisQty); if(flagODSuccessOp==true &&
			 * flagODException==false) {
			 * orderMasterDBHelper.updateOrder(orderMasterActionForm);
			 * flagOMSuccessOp=true; jsonObject.put("result", "done"); } else {
			 * jsonObject.put("result", "error"); }
			 */

			return jsonObject;

		} catch (Exception e) {
			System.out.println(e);
			jsonObject.put("result", "error");
			return null;
		}

	}

	@POST
	@Path("/getItemById")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JSONObject getItemById(String data) throws JSONException {
		ItemDBHelper itemDBHelper = new ItemDBHelper();
		JSONObject jsonObject = new JSONObject(data);
		ItemActionForm itemById = itemDBHelper.getItemById(jsonObject.getInt("itemId"));
		float itemPrice = itemById.getItemPrice();
		jsonObject.put("itemPrice", (double) itemPrice);
		return jsonObject;
	}

	@POST
	@Path("/makeExcel")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void makeExcel(String data) throws ServletException {
		try {

			System.out.println("Hello I am Here in Make Excel");

			System.out.println(request.getContentType());

			// Code For @XLSX excel
			XSSFWorkbook workb = new XSSFWorkbook();
			XSSFSheet worksheet = workb.createSheet("ordersheet1");

			worksheet.setColumnWidth(0, 6000);
			worksheet.setColumnWidth(1, 6000);
			worksheet.setColumnWidth(2, 6000);
			worksheet.setColumnWidth(3, 6000);
			worksheet.setColumnWidth(4, 6000);

			XSSFFont wfont = workb.createFont();
			wfont.setFontName("Times New Roman");

			XSSFCellStyle wstyle = workb.createCellStyle();
			wstyle.setFont(wfont);

			XSSFRow wrow = worksheet.createRow(0);

			XSSFCell wcell = wrow.createCell(0);
			wcell.setCellStyle(wstyle);
			wcell.setCellValue("Order Number");

			wcell = wrow.createCell(1);
			wcell.setCellStyle(wstyle);
			wcell.setCellValue("Order Creation Date");

			wcell = wrow.createCell(2);
			wcell.setCellStyle(wstyle);
			wcell.setCellValue("Order Amount");

			wcell = wrow.createCell(3);
			wcell.setCellStyle(wstyle);
			wcell.setCellValue("Customer Name");

			wcell = wrow.createCell(4);
			wcell.setCellStyle(wstyle);
			wcell.setCellValue("Status");

			try {
				JSONArray jsonArray = null;
				JSONObject jsonObject = new JSONObject(data);
				jsonArray = jsonObject.getJSONArray("orderIdsForDataDisplay");

				XSSFRow wrowData = null;
				XSSFCell wcellData = null;

				OrderMasterDBHelper orderMasterDBHelper = new OrderMasterDBHelper();
				OrderMasterActionForm orderById = new OrderMasterActionForm();

				UserDBHelper userDBHelper = new UserDBHelper();

				OrderStageDBHelper orderStageDBHelper = new OrderStageDBHelper();

				for (int i = 0; i < jsonArray.length(); i++) {
					int id = jsonArray.getInt(i);
					System.out.println(id);

					orderById = orderMasterDBHelper.getOrderByMasterId(id);

					wrowData = worksheet.createRow(i + 1);
					wcellData = wrowData.createCell(0);
					wcellData.setCellStyle(wstyle);
					wcellData.setCellValue(orderById.getOrderNumber());

					wcellData = wrowData.createCell(1);
					wcellData.setCellStyle(wstyle);
					wcellData.setCellValue(orderById.getCreatedDate());

					wcellData = wrowData.createCell(2);
					wcellData.setCellStyle(wstyle);
					wcellData.setCellValue(orderById.getTotal());

					wcellData = wrowData.createCell(3);
					wcellData.setCellStyle(wstyle);
					wcellData.setCellValue(
							(userDBHelper.getSingleUserByUserId(orderById.getUserMasterId())).getFirstName());

					wcellData = wrowData.createCell(4);
					wcellData.setCellStyle(wstyle);
					wcellData.setCellValue((orderStageDBHelper.getOrderStageById(orderById.getState())).getName());

				}
				System.out.println("reached");
			} catch (Exception e) {
				System.out.println(e);
			}

			try {
				// response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
				response.setHeader("Content-Disposition", "attachment; filename=ordersheet.xlsx");
				workb.write(response.getOutputStream());
			} catch (Exception e) {
				System.out.println(e);
			}

			// Code For @XLS excel sheet
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet("ordersheet");

			sheet.setColumnWidth(0, 8000);
			sheet.setColumnWidth(1, 8000);
			sheet.setColumnWidth(2, 8000);
			sheet.setColumnWidth(3, 8000);
			sheet.setColumnWidth(4, 8000);

			HSSFRow row = sheet.createRow(0);

			HSSFFont font = workbook.createFont();
			font.setFontName("Times New Roman");

			CellStyle style = workbook.createCellStyle();
			style.setFont(font);

			HSSFCell cell = row.createCell(0);
			cell.setCellValue("Order Number");
			cell.setCellStyle(style);

			cell = row.createCell(1);
			cell.setCellValue("Order Creation Date");
			cell.setCellStyle(style);

			cell = row.createCell(2);
			cell.setCellValue("Order Amount");
			cell.setCellStyle(style);

			cell = row.createCell(3);
			cell.setCellValue("Customer Name");
			cell.setCellStyle(style);

			cell = row.createCell(4);
			cell.setCellValue("Status");
			cell.setCellStyle(style);

			try {
				JSONArray jsonArray = null;
				JSONObject jsonObject = new JSONObject(data);
				jsonArray = jsonObject.getJSONArray("orderIdsForDataDisplay");

				HSSFRow rowData = null;
				HSSFCell cellData = null;

				OrderMasterDBHelper orderMasterDBHelper = new OrderMasterDBHelper();
				OrderMasterActionForm orderById = new OrderMasterActionForm();

				UserDBHelper userDBHelper = new UserDBHelper();

				OrderStageDBHelper orderStageDBHelper = new OrderStageDBHelper();

				for (int i = 0; i < jsonArray.length(); i++) {
					int id = jsonArray.getInt(i);
					System.out.println(id);

					orderById = orderMasterDBHelper.getOrderByMasterId(id);

					rowData = sheet.createRow(i + 1);
					cellData = rowData.createCell(0);
					cellData.setCellStyle(style);
					cellData.setCellValue(orderById.getOrderNumber());

					cellData = rowData.createCell(1);
					cellData.setCellStyle(style);
					cellData.setCellValue(orderById.getCreatedDate());

					cellData = rowData.createCell(2);
					cellData.setCellStyle(style);
					cellData.setCellValue(orderById.getTotal());

					cellData = rowData.createCell(3);
					cellData.setCellStyle(style);
					cellData.setCellValue(
							(userDBHelper.getSingleUserByUserId(orderById.getUserMasterId())).getFirstName());

					cellData = rowData.createCell(4);
					cellData.setCellStyle(style);
					cellData.setCellValue((orderStageDBHelper.getOrderStageById(orderById.getState())).getName());

				}
				System.out.println("reached");
			} catch (Exception e) {
				System.out.println(e);
			}

			try {

				response.setHeader("Content-Disposition", "attachment; filename=ORDERLIST2.xls");

				ServletOutputStream out = response.getOutputStream();

				workbook.write(out);
				out.close();
				System.out.println("File has been successfully written");
			} catch (Exception e) {
				System.out.println(e);
			}

		} catch (Exception e) {

		}
	}

	@GET
	@Path("/makeExcelNew")	
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public Response makeExcelNew(String dataa) throws ServletException {
		
		//final String data = dataa; 
		
		StreamingOutput outPut = new StreamingOutput() {
			
			@Override
			public void write(OutputStream out) throws IOException, WebApplicationException {
				try
				{
					JSONArray jsonArray=null;
					JSONObject jsonObject=new JSONObject(request.getParameter("str"));
					jsonArray=jsonObject.getJSONArray("orderIdsForDataDisplay");
					System.out.println(jsonArray.length());
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				//-------------------------------------------------------------------------------------
				// Code For @XLSX excel 
							XSSFWorkbook workb=new XSSFWorkbook();
							XSSFSheet worksheet=workb.createSheet("ordersheet1");
							
							worksheet.setColumnWidth(0, 6000);
							worksheet.setColumnWidth(1, 6000);
							worksheet.setColumnWidth(2, 6000);
							worksheet.setColumnWidth(3, 6000);
							worksheet.setColumnWidth(4, 6000);
							
							XSSFFont wfont=workb.createFont();
							wfont.setFontName("Times New Roman");
							
							XSSFCellStyle wstyle=workb.createCellStyle();
							wstyle.setFont(wfont);
							
							XSSFRow wrow=worksheet.createRow(0);
							
							XSSFCell wcell=wrow.createCell(0);
							wcell.setCellStyle(wstyle);
							wcell.setCellValue("Order Number");
							
							wcell=wrow.createCell(1);
							wcell.setCellStyle(wstyle);
							wcell.setCellValue("Order Creation Date");
							
							wcell=wrow.createCell(2);
							wcell.setCellStyle(wstyle);
							wcell.setCellValue("Order Amount");
							
							wcell=wrow.createCell(3);
							wcell.setCellStyle(wstyle);
							wcell.setCellValue("Customer Name");
							
							wcell=wrow.createCell(4);
							wcell.setCellStyle(wstyle);
							wcell.setCellValue("Status");
							
							try
							{
								JSONArray jsonArray=null;
								JSONObject jsonObject=new JSONObject(request.getParameter("str"));
								jsonArray=jsonObject.getJSONArray("orderIdsForDataDisplay");
								
								XSSFRow wrowData=null;
								XSSFCell wcellData=null;
								
								OrderMasterDBHelper orderMasterDBHelper=new OrderMasterDBHelper();
								OrderMasterActionForm orderById=new OrderMasterActionForm();
								
								UserDBHelper userDBHelper=new UserDBHelper();
								
								OrderStageDBHelper orderStageDBHelper=new OrderStageDBHelper();
								
								for(int i=0;i<jsonArray.length();i++)
								{
									int id=jsonArray.getInt(i);
									System.out.println(id);
									
									orderById=orderMasterDBHelper.getOrderByMasterId(id);
									
									wrowData=worksheet.createRow(i+1);
									wcellData=wrowData.createCell(0);
									wcellData.setCellStyle(wstyle);									
									wcellData.setCellValue(orderById.getOrderNumber());
									
									wcellData=wrowData.createCell(1);
									wcellData.setCellStyle(wstyle);									
									wcellData.setCellValue(orderById.getCreatedDate());
									
									wcellData=wrowData.createCell(2);
									wcellData.setCellStyle(wstyle);									
									wcellData.setCellValue(orderById.getTotal());
									
									wcellData=wrowData.createCell(3);
									wcellData.setCellStyle(wstyle);									
									wcellData.setCellValue((userDBHelper.getSingleUserByUserId(orderById.getUserMasterId())).getFirstName());
									
									wcellData=wrowData.createCell(4);
									wcellData.setCellStyle(wstyle);									
									wcellData.setCellValue((orderStageDBHelper.getOrderStageById(orderById.getState())).getName());
									
									
								}
								System.out.println("reached");
							}
							catch(Exception e)
							{
								e.printStackTrace();
							}
							
							try
							{
								workb.write(out);
								out.flush();							
								/*response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
								response.setHeader("Content-Disposition", "attachment; filename=ordersheet.xlsx");
								ServletOutputStream outputstream=response.getOutputStream();
								workb.write(outputstream);
								outputstream.close();*/
							}
							catch(Exception e)
							{
								e.printStackTrace();
							}				
			}
		};
		
		
		
		
		//-------------------------------------------------------------------------------------
		
		return Response.ok(outPut,MediaType.APPLICATION_OCTET_STREAM).header("Content-disposition", "attachment; filename=ordersheet.xlsx").build();
	}
	
	@POST
	@Path("/makeExcelNewS")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public Response makeExcelNewS(String dataa) throws ServletException {
		
		StreamingOutput fileStream =  new StreamingOutput() 
        {
            @Override
            public void write(java.io.OutputStream output) throws IOException, WebApplicationException 
            {
                try
                {
                    java.nio.file.Path path = Paths.get("E:/Rahul/SmallSize/Books/Technical/Maths/NCERT-Class-11-Mathematics.pdf");
                    byte[] data = Files.readAllBytes(path);
                    output.write(data);
                    output.flush();
                } 
                catch (Exception e) 
                {
                    e.printStackTrace();
                }
            }
        };
        return Response
                .ok(fileStream, MediaType.APPLICATION_OCTET_STREAM)
                .header("content-disposition","attachment; filename = myfile.pdf")
                .build();
    
	}

	@GET
	@Path("/getOrderListByFilter")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JSONObject getOrderListByFilter(String data) throws JSONException {

		System.out.println("here");
		System.out.println("here_new");
		ServerAppContext serverAppContext = (ServerAppContext) request.getServletContext()
				.getAttribute(Constants.STRUTS_APPLICATION_CONTEXT);
		HttpSession httpsession = request.getSession(true);
		int comid = (int) httpsession.getAttribute(Constants.COMPANY_ID);
		int userId = (int) httpsession.getAttribute(Constants.USER_ID);
		int userRole = (int) httpsession.getAttribute(Constants.USER_ROLE);

		System.out.println("in get Item order List By Filter");

		HashMap<String, String> filterValuesForGR = new HashMap<String, String>();

		// UserActionForm userActionForm=new UserActionForm();
		filterValuesForGR.put(CompanyDBAdapter.KEY_COMPANYMASTERID, Integer.toString(comid));

		if (request.getParameter("orderStageId") != null) {
			if (!request.getParameter("orderStageId").equalsIgnoreCase("null")) {
				filterValuesForGR.put(OrderMasterDBAdapter.KEY_ORDER_MASTER_STATE,
						request.getParameter("orderStageId"));
			}
		}

		if (request.getParameter("isActive") != null) {
			if (!request.getParameter("isActive").equalsIgnoreCase("null")) {
				filterValuesForGR.put(OrderMasterDBAdapter.KEY_ORDER_MASTER_IS_ACTIVE,
						request.getParameter("isActive"));
			}
		}

		if (request.getParameter("orderMasterId") != null) {
			if (!request.getParameter("orderMasterId").equalsIgnoreCase("null")) {
				filterValuesForGR.put(OrderMasterDBAdapter.KEY_ORDER_MASTER_MASTER_ID,
						request.getParameter("orderMasterId"));
			}
		}

		if (request.getParameter("state") != null) {
			if (!request.getParameter("state").equalsIgnoreCase("null")) {
				filterValuesForGR.put(OrderMasterDBAdapter.KEY_ORDER_MASTER_STATE, request.getParameter("state"));
			}
		}

		// if user not admin then only can see order generated by him only
		if (userRole != 2) {
			filterValuesForGR.put(OrderMasterDBAdapter.KEY_ORDER_MASTER_USERMASTERID, Integer.toString(userId));
		}

		if (request.getParameter("fromDate") != null && request.getParameter("toDate") != null) {
			if (!request.getParameter("fromDate").equalsIgnoreCase("")
					&& !request.getParameter("toDate").equalsIgnoreCase("")) {
				filterValuesForGR.put(OrderMasterDBAdapter.KEY_ORDER_MASTER_CREATED_DATE,
						"" + OrderMasterDBAdapter.KEY_ORDER_MASTER_CREATED_DATE + " between '"
								+ request.getParameter("fromDate") + "' AND '" + request.getParameter("toDate") + "'");
			}
		}
		// set session for automatic dropdown list fill

		HttpSession session = request.getSession();
		if (request.getParameter("orderStageId") != null) {
			session.setAttribute("orderStageId", request.getParameter("orderStageId"));
		}
		if (request.getParameter("orderMasterId") != null) {
			session.setAttribute("orderMasterId", request.getParameter("orderMasterId"));
		}
		if (request.getParameter("customerMasterId") != null) {
			session.setAttribute("customerMasterId", request.getParameter("customerMasterId"));
		}

		if (request.getParameter("fromDate") != null) {
			session.setAttribute("fromDate", request.getParameter("fromDate"));
		}
		if (request.getParameter("toDate") != null) {
			session.setAttribute("toDate", request.getParameter("toDate"));
		}

		JSONArray jsonArray = null;
		JSONObject jsonObject = null;
		JSONObject returnJsonObject = null;
		OrderMasterDBHelper OrderMasterDBHelper = new OrderMasterDBHelper();
		UserDBHelper userDBHelper = new UserDBHelper();
		OrderStageDBHelper orderstageDBHelper = new OrderStageDBHelper();

		try {
			ArrayList<OrderMasterActionForm> orderMasterActionFormsList = OrderMasterDBHelper
					.fetchAllOrderMasterByFilter(filterValuesForGR);
			HashMap<Integer, ArrayList<OrderStageActionForm>> orderstageByCompanyid = serverAppContext
					.getOrderStageByCompanyMasterId();
			// ArrayList<OrderStageActionForm>orderstageList=orderstageByCompanyid.get(comid);
			ArrayList<OrderStageActionForm> orderstageList = orderstageDBHelper
					.getActiveStagesForSpecificCompany(comid);
			DecimalFormat df = new DecimalFormat("0.00");
			if (orderMasterActionFormsList != null) {
				jsonArray = new JSONArray();
				for (int i = 0; i < orderMasterActionFormsList.size(); i++) {
					if (orderMasterActionFormsList.get(i).isActive == 1) {

						jsonObject = new JSONObject();
						double deliveryStatusPer, quaToDis, disQua;
						quaToDis = orderMasterActionFormsList.get(i).getOrderQuantity();
						disQua = orderMasterActionFormsList.get(i).getDispatchedQuantity();
						deliveryStatusPer = (disQua / quaToDis) * 100;
						jsonObject.put("orderMasterId", orderMasterActionFormsList.get(i).getOrderMasterId());
						jsonObject.put("CreatedDate", orderMasterActionFormsList.get(i).getCreatedDate());
						jsonObject.put("createdDTTM", orderMasterActionFormsList.get(i).getCreatedDTTM());
						jsonObject.put("orderType", orderMasterActionFormsList.get(i).getOrderNumber());
						jsonObject.put("orderAmount", orderMasterActionFormsList.get(i).getTotal());
						jsonObject.put("quantityToDispatch", orderMasterActionFormsList.get(i).getOrderQuantity());
						jsonObject.put("dispatchedQuantity", orderMasterActionFormsList.get(i).getDispatchedQuantity());
						jsonObject.put("deliveryStatus", df.format(deliveryStatusPer) + "%");
						jsonObject.put("customerName", serverAppContext.getUserByUserMasterId()
								.get((orderMasterActionFormsList.get(i).getUserMasterId())).getUserName());
						// jsonObject.put("LastStatus",orderMasterActionFormsList.get(i).getState());
						jsonObject.put("LastStatus", orderstageDBHelper
								.getOrderStageById(orderMasterActionFormsList.get(i).getState()).getName());

						OrderStageDBHelper orderStageDBHelper = new OrderStageDBHelper();
						if (orderMasterActionFormsList.get(i).getState() != 0)
							jsonObject.put("orderStage", orderStageDBHelper
									.getOrderStageById(orderMasterActionFormsList.get(i).getState()).getName());
						else
							jsonObject.put("orderStage", "submit");
						if (orderMasterActionFormsList.get(i).getModifiedBy() != 0) {
							jsonObject.put("UpdatedBy",
									userDBHelper
											.getSingleUserByUserId(orderMasterActionFormsList.get(i).getModifiedBy())
											.getFirstName());
						} else {
							jsonObject.put("UpdatedBy", "Not Updated");
						}
						if (orderMasterActionFormsList.get(i).getModifiedDTTM() != null) {
							jsonObject.put("UpdatedDTTM", orderMasterActionFormsList.get(i).getModifiedDTTM());
						} else {
							jsonObject.put("UpdatedDTTM", "Not Updated");
						}
						jsonObject.put("createdBy", serverAppContext.getUserByUserMasterId()
								.get((orderMasterActionFormsList.get(i).getCreatedBy())).getFirstName());
						jsonObject.put("view",
								"<a onclick=getorder(" + orderMasterActionFormsList.get(i).getOrderMasterId() + ","
										+ orderMasterActionFormsList.get(i).getUserMasterId()
										+ "); title='View Order'><code class='glyphicon glyphicon-edit'></code></a>");
						jsonObject.put("edit", "<a onclick=editorder("
								+ orderMasterActionFormsList.get(i).getOrderMasterId()
								+ "); title='edit Order'><code class='glyphicon glyphicon-edit'></code></a> <a onclick=deleteOrder("
								+ orderMasterActionFormsList.get(i).getOrderMasterId()
								+ "); title='Delete order'><code class='glyphicon glyphicon-remove'></code></a>");
						jsonObject.put("pushforexport",
								"<input type='checkbox' id='pushforexport"
										+ orderMasterActionFormsList.get(i).getOrderMasterId()
										+ "' name='pushforexport' value='"
										+ orderMasterActionFormsList.get(i).getOrderMasterId() + "'>");
						if (orderstageList != null) {
							String a, b, c, d, e, m, k = "", z = "";
							for (int j = 0; j < orderstageList.size(); j++) {
								a = "<option value=";
								b = Integer.toString(orderstageList.get(j).getOrderStageMasterId());
								if (orderstageList.get(j).getOrderStageMasterId() == orderMasterActionFormsList.get(i)
										.getState()) {
									z = " selected";
								}
								c = ">";
								d = (orderstageList.get(j).getName());
								e = "</option>";
								m = a + b + z + c + d + e;
								k = k + m;
								z = "";
							}
							jsonObject.put("status",
									"<select id='stateId" + 1
											+ "'class='form-control input-xmedium ' onchange='changeState("
											+ orderMasterActionFormsList.get(i).getOrderMasterId() + ",this.value)'><'"
											+ k + "'></select>");
						}
						jsonArray.put(jsonObject);
					}
				}
			} else {
				jsonArray = new JSONArray();
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		returnJsonObject = new JSONObject();
		returnJsonObject.put("aaData", jsonArray);
		return returnJsonObject;
	}

	@POST
	@Path("/getItemPriceAndMeasurementUnit")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JSONObject getItemPriceAndMeasurementUnit(String data) {
		ServerAppContext serverAppContext = (ServerAppContext) request.getServletContext()
				.getAttribute(Constants.STRUTS_APPLICATION_CONTEXT);
		HttpSession httpsession = request.getSession(true);
		int companyId = (int) httpsession.getAttribute(Constants.COMPANY_ID);

		ItemCustomerPriceMappingDBHelper itemCustomerPriceMappingDBHelper = new ItemCustomerPriceMappingDBHelper();
		JSONObject jsonObject = null;
		try {
			jsonObject = new JSONObject(data);
			if (jsonObject != null) {

				int itemId = jsonObject.getInt("itemId");
				int customerId = jsonObject.getInt("customerId");

				ItemDBHelper itemDBHelper = new ItemDBHelper();
				ItemActionForm itemActionForm = serverAppContext.getItemByItemMasterId().get(itemId);
				MeasurementActionForm measurementActionForm = serverAppContext.getMeasurementByMeasurementMasterId()
						.get(itemActionForm.getMeasurementMasterId());
				HashMap<Integer, MeasurementActionForm> map = serverAppContext.getMeasurementByMeasurementMasterId();
				jsonObject = new JSONObject();
				jsonObject.put("measurementId", measurementActionForm.getMeasurementMasterId());
				jsonObject.put("measurementName", measurementActionForm.getSymbol());
				jsonObject.put("availableStock", itemDBHelper.getItemById(itemId).getStockQuantity());
				// if item price exists in item customer mapping table
				ItemCustomerPriceMappingActionForm itemCustomerPriceMappingActionForm = itemCustomerPriceMappingDBHelper
						.getItemCustomerPriceMappingByCustomerIdAndCompanyIdAndItemId(customerId, companyId, itemId);
				if (itemCustomerPriceMappingActionForm.getItemPrice() != 0) {
					jsonObject.put("itemPrice", itemCustomerPriceMappingActionForm.getItemPrice());
				} else {
					if (itemActionForm != null)
						jsonObject.put("itemPrice", itemActionForm.getItemPrice());
				}

			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return jsonObject;
	}

	@POST
	@Path("/getOrderMasterByOrderNumber")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JSONObject getOrderMasterByOrderNumber(String data) {
		// ServerAppContext serverAppContext =
		// (ServerAppContext)request.getServletContext().getAttribute(Constants.STRUTS_APPLICATION_CONTEXT);

		// PurchaseOrderDetDBHelper purchaseOrderDetDBHelper = new
		// PurchaseOrderDetDBHelper();
		OrderMasterDBHelper orderMasterDBHelper = new OrderMasterDBHelper();
		// CustomerDBHelper customerDBHelper=new CustomerDBHelper();
		JSONObject jsonObject = null;
		try {
			jsonObject = new JSONObject(data);
			if (jsonObject != null) {

				// OperationEntryBean operationEntryBean = new
				// OperationEntryBean();
				long orderMasterId = Long.parseLong(jsonObject.getString("orderNumber"));
				OrderMasterActionForm orderMasterActionForm = orderMasterDBHelper.getOrderByOrderNumber(orderMasterId);
				// ItemDBHelper itemDBHelper = new ItemDBHelper();
				// MeasurementDBHelper measurementDBHelper = new
				// MeasurementDBHelper();

				if (orderMasterActionForm != null) {
					jsonObject = new JSONObject();
					jsonObject.put("orderMasterId", orderMasterActionForm.getOrderMasterId());
					jsonObject.put("orderNumber", orderMasterActionForm.getOrderNumber());
					jsonObject.put("state", orderMasterActionForm.getState());
					jsonObject.put("total", orderMasterActionForm.getTotal());
					jsonObject.put("remark", orderMasterActionForm.getRemark());
					jsonObject.put("createdDate", orderMasterActionForm.getCreatedDate());
					jsonObject.put("createdDTTM", orderMasterActionForm.getCreatedDTTM());
					jsonObject.put("createdBy", orderMasterActionForm.getCreatedBy());
				}

			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return jsonObject;
	}

	@POST
	@Path("/getCustomerDetails")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JSONObject getCustomerDetails(String data) {

		JSONObject jsonObject = null;
		try {
			System.out.println("cus id" + request.getParameter("customerId"));
			int orderMasterId = Integer.parseInt(request.getParameter("orderNumber"));
			System.out.println(orderMasterId);
			jsonObject = new JSONObject();

			UserDBHelper userDBHelper = new UserDBHelper();
			OrderMasterDBHelper orderMasterDBHelper = new OrderMasterDBHelper();
			UserActionForm userActionForm = userDBHelper
					.getSingleUserByUserId(Integer.parseInt(request.getParameter("customerId")));

			jsonObject.put("ordernumber", orderMasterDBHelper.getOrderByMasterId(orderMasterId).getOrderNumber());
			jsonObject.put("firstName", userActionForm.getFirstName());
			jsonObject.put("lastname", userActionForm.getLastName());
			jsonObject.put("fathername", userActionForm.getFirstName());
			jsonObject.put("contactNumber", userActionForm.getPhoneNumber1());
			jsonObject.put("address", userActionForm.getAddress());
			// jsonObject.put("village",customerActionForm.getVillage());
			jsonObject.put("landmark", userActionForm.getPincode());
			// jsonObject.put("taluka",customerActionForm.getTaluka());
			// jsonObject.put("distric", customerActionForm.getDistrict());
			jsonObject.put("email", userActionForm.getEmail());
			jsonObject.put("pin", userActionForm.getPincode());

		} catch (Exception e) {
			System.out.println(e);
		}
		return jsonObject;
	}

	@POST
	@Path("/getOrderDetailsByOrderMasterId")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JSONArray getOrderDetailsByOrderMasterId(String data) {
		ServerAppContext serverAppContext = (ServerAppContext) request.getServletContext()
				.getAttribute(Constants.STRUTS_APPLICATION_CONTEXT);

		HttpSession httpSession = request.getSession(true);
		int companyid = (int) httpSession.getAttribute(Constants.COMPANY_ID);

		// PurchaseOrderDetDBHelper purchaseOrderDetDBHelper = new
		// PurchaseOrderDetDBHelper();
		OrderDetailDBHelper orderDetailDBHelper = new OrderDetailDBHelper();
		OrderMasterDBHelper orderMasterDBHelper = new OrderMasterDBHelper();
		JSONObject jsonObject = null;
		JSONArray jsonArray = null;

		boolean unitCostEditableFlag = false;

		try {
			jsonObject = new JSONObject(data);
			if (jsonObject != null) {

				int orderMasterId = jsonObject.getInt("orderNumber");
				ArrayList<OrderDetailActionForm> orderDetailActionFormsList = orderDetailDBHelper
						.fetchAllorderDetailByOrderMasterId(orderMasterId);

				if (orderDetailActionFormsList != null) {

					// code for taking checking configuration
					ConfigDBHelper configHelper = new ConfigDBHelper();
					ConfigActionForm configBean = configHelper.getDetailsSpecificForCompanyAndProperty(companyid,
							Constants.SETTING_CONFIG_ITEMUNITCOST_EDITABILITY);
					if (configBean != null) {
						if (configBean.getValue().equals(Constants.SETTING_CONFIG_ITEMUNITCOST_EDITABILITY_VALUE_ON)) {
							unitCostEditableFlag = true;
						} else if (configBean.getValue()
								.equals(Constants.SETTING_CONFIG_ITEMUNITCOST_EDITABILITY_VALUE_OFF)) {
							unitCostEditableFlag = false;
						} else {
							unitCostEditableFlag = false;
						}
					}

					jsonArray = new JSONArray();
					for (int i = 0; i < orderDetailActionFormsList.size(); i++) {

						ItemActionForm itemBean = serverAppContext.getItemByItemMasterId()
								.get(orderDetailActionFormsList.get(i).getItemMasterId());
						MeasurementActionForm measurementBean = serverAppContext.getMeasurementByMeasurementMasterId()
								.get(itemBean.getMeasurementMasterId());
						ItemDBHelper itemDBHelper = new ItemDBHelper();
						int itemMasterId = orderDetailActionFormsList.get(i).getItemMasterId();
						float availableStock = itemDBHelper.getItemById(itemMasterId).getStockQuantity();
						if (itemBean != null) {

							jsonObject = new JSONObject();

							if (unitCostEditableFlag) {
								jsonObject.put("unitCostEditable", "yes");
							} else {
								jsonObject.put("unitCostEditable", "no");
							}

							jsonObject.put("availableStock", availableStock);
							jsonObject.put("orderId", orderDetailActionFormsList.get(i).getOrderDetailId());
							jsonObject.put("orderNumber",
									orderMasterDBHelper
											.getOrderByMasterId(orderDetailActionFormsList.get(i).getOrderMasterId())
											.getOrderNumber());
							jsonObject.put("itemMasterId", orderDetailActionFormsList.get(i).getItemMasterId());
							jsonObject.putOpt("itemName", itemDBHelper
									.getItemById(orderDetailActionFormsList.get(i).getItemMasterId()).getName());
							if (measurementBean != null) {
								jsonObject.put("itemMeasurementId", measurementBean.getMeasurementMasterId());
								jsonObject.put("itemMeasurementName", measurementBean.getName());
							}
							jsonObject.put("description", orderDetailActionFormsList.get(i).getDescription());
							jsonObject.put("quantity", orderDetailActionFormsList.get(i).getQuantity());
							jsonObject.put("rate", orderDetailActionFormsList.get(i).getRate());
							jsonObject.put("amount", orderDetailActionFormsList.get(i).getAmount());
							jsonObject.put("orderDetailId", orderDetailActionFormsList.get(i).getOrderDetailId());
							jsonObject.put("dispatchedQuantity",
									orderDetailActionFormsList.get(i).getDispatchedQuantity());
							jsonObject.put("dispatchere", "0");
							/*
							 * jsonObject.put("itemRate",
							 * purchaseDetailBeanList.get(i).getPurchaseRate());
							 * jsonObject.put("itemAmount",
							 * purchaseDetailBeanList.get(i).getPurchaseAmount()
							 * ); jsonObject.put("itemServiced",
							 * purchaseDetailBeanList.get(i).getQuantityServiced
							 * ());
							 */ jsonArray.put(jsonObject);
						}
					}
				} else {
					jsonArray = new JSONArray();
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(jsonArray.toString());
		return jsonArray;
	}

	@POST
	@Path("/updateOrderStatus")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JSONObject updateOrderStatus(String data) {
		int updateResult = 0;
		System.out.println("This is for updateOrderStatus");
		JSONObject jsonObject = null;
		JSONObject returnJsonObject = new JSONObject();
		try {

			HttpSession session = request.getSession(true);
			UserActionForm userActionForm = new UserActionForm();
			userActionForm = (UserActionForm) session.getAttribute(Constants.USER_BEAN);
			int userId = userActionForm.getUserMasterId();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constants.DATE_FORMAT);
			jsonObject = new JSONObject();
			OrderMasterDBHelper orderMasterDBHelper = new OrderMasterDBHelper();
			OrderMasterActionForm orderMasterrBean = new OrderMasterActionForm();

			jsonObject = new JSONObject(data);
			Iterator key = jsonObject.keys();

			while (key.hasNext()) {
				String k = key.next().toString();
				System.out.println("Key : " + k + ", value : " + jsonObject.getString(k));

				// int
				// oldState=orderMasterDBHelper.getOrderByMasterId(Integer.parseInt(k)).getState();
				orderMasterrBean.setOrderMasterId(Integer.parseInt(k));
				orderMasterrBean.setState(Integer.parseInt(jsonObject.getString(k)));
				// orderMasterrBean.setState(oldState);
				orderMasterrBean.setModifiedBy(userId);
				orderMasterrBean.setModifiedDTTM(simpleDateFormat.format(new Date()));
				/*
				 * if(request.getParameter("remark")!=null){
				 * orderMasterrBean.setRemark(request.getParameter("remark")); }
				 */
				boolean updateStatusFlag = false;
				int stageId = orderMasterrBean.getState();
				OrderStageDBHelper orderStageDBHelper = new OrderStageDBHelper();
				String orderStageName = orderStageDBHelper.getOrderStageById(stageId).getName();
				if (orderStageName.equalsIgnoreCase(Constants.STATUS_DELIVERED)) {
					System.out.println("here");
					OrderMasterActionForm orderMasterBean = new OrderMasterActionForm();
					orderMasterBean = orderMasterDBHelper.getOrderByMasterId(Integer.parseInt(k));
					if (orderMasterBean.getOrderQuantity() == orderMasterBean.getDispatchedQuantity()) {
						updateResult = orderMasterDBHelper.updateOrderStatus(orderMasterrBean);
						updateStatusFlag = true;
						try {
							MailSMS gateWay = new MailSMS();
							gateWay.sendMail(Integer.parseInt(k));
						} catch (Exception e) {
							System.out.println(e);
						}
						returnJsonObject.put("result", "validaction");
					} else {
						updateStatusFlag = true;
						returnJsonObject.put("result", "invalidaction");
					}

				}
				if (updateStatusFlag == false) {
					updateResult = orderMasterDBHelper.updateOrderStatus(orderMasterrBean);
					try {
						MailSMS gateWay = new MailSMS();
						gateWay.sendMail(Integer.parseInt(k));
					} catch (Exception e) {
						System.out.println(e);
					}
					returnJsonObject.put("result", "done");
				}

				System.out.println(updateResult);

			}

			/*
			 * for (int i = 0; i < getArray.length(); i++) { JSONObject objects
			 * = getArray.getJSONObject(i); Iterator key = objects.keys(); while
			 * (key.hasNext()) { String k = key.next().toString();
			 * System.out.println("Key : " + k + ", value : " +
			 * objects.getString(k)); } //
			 * System.out.println(objects.toString());
			 * System.out.println("-----------");
			 * 
			 * }
			 */

		} catch (Exception e) {
			System.out.println(e);
		}

		return returnJsonObject;
	}

	@POST
	@Path("/updateitemPrice")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JSONObject updateitemPrice(String data) {
		ServerAppContext serverAppContext = (ServerAppContext) request.getServletContext()
				.getAttribute(Constants.STRUTS_APPLICATION_CONTEXT);
		JSONObject jsonObject = null;
		try {

			HttpSession session = request.getSession(true);
			int compid = (int) session.getAttribute(Constants.COMPANY_ID);

			HashMap<Integer, ArrayList<ItemActionForm>> itemByCompanyId = new HashMap<Integer, ArrayList<ItemActionForm>>();
			itemByCompanyId = serverAppContext.getItemByCompanyId();
			ArrayList<ItemActionForm> itemList = new ArrayList<>();
			ItemDBHelper itemDBHelper = new ItemDBHelper();

			jsonObject = new JSONObject(data);
			Iterator key = jsonObject.keys();

			while (key.hasNext()) {
				String k = key.next().toString();
				System.out.println("Key : " + k + ", value : " + jsonObject.getString(k));
				ItemActionForm itemActionForm2 = new ItemActionForm();
				itemActionForm2.setItemMasterId(Integer.parseInt(k));
				itemActionForm2.setItemPrice(Integer.parseInt(jsonObject.getString(k)));
				itemList.add(itemActionForm2);

			}

			itemDBHelper.updateItemPrice(itemList);

			for (int i = 0; i < itemList.size(); i++) {
				ItemActionForm itemActionFormNew = itemList.get(i);
				itemActionFormNew = itemDBHelper.getItemById(itemActionFormNew.getItemMasterId());
				serverAppContext.getItemByItemMasterId().put(itemActionFormNew.getItemMasterId(), itemActionFormNew);
				// serverAppContext.setItemByItemMasterId(itemActionFormNew.getItemMasterId(),itemActionFormNew);
			}

			ArrayList<ItemActionForm> itemByCompanyList = new ArrayList<>();

			itemByCompanyList = itemDBHelper.getItemByCompanyId(compid);

			itemByCompanyId.put(compid, itemByCompanyList);
			serverAppContext.setItemByCompanyId(itemByCompanyId);

		}
		// Iterator key = jsonObject.keys();

		/*
		 * orderMasterrBean.setOrderMasterId(Integer.parseInt(k));
		 * orderMasterrBean.setState(Integer.parseInt(jsonObject.getString(k)));
		 * orderMasterrBean.setState(oldState);
		 * orderMasterrBean.setModifiedBy(userId);
		 * orderMasterrBean.setModifiedDTTM(simpleDateFormat.format(new
		 * Date()));
		 * 
		 * 
		 * 
		 * } ArrayList<ItemActionForm>itemList=itemDBHelper.fetchAllRecords();
		 * serverAppContext.setItemList(itemList);
		 * 
		 * ArrayList<ItemActionForm>itemActivelist=itemDBHelper.
		 * fetchAllActiveItemRecords();
		 * serverAppContext.setItemListByActiveItem(itemActivelist);
		 * 
		 * HashMap<Integer,ItemActionForm >itembyitemid=new
		 * HashMap<Integer,ItemActionForm>();
		 * itembyitemid=serverAppContext.getItemByItemMasterId();
		 * itembyitemid.put(itemActionForm.getItemMasterId(),itemActionForm);
		 * serverAppContext.setItemByItemMasterId(itembyitemid);
		 * 
		 * ArrayList<ItemActionForm>itemByCompanyList=itemDBHelper.
		 * getItemByCompanyId(compid);
		 * HashMap<Integer,ArrayList<ItemActionForm>>itemByCompanyId=new
		 * HashMap<Integer,ArrayList<ItemActionForm>>();
		 * itemByCompanyId=serverAppContext.getItemByCompanyId();
		 * itemByCompanyId.put(compid, itemByCompanyList);
		 * serverAppContext.setItemByCompanyId(itemByCompanyId);
		 * 
		 */

		catch (Exception e) {
			System.out.println(e);
		}
		return jsonObject;
	}

	@POST
	@Path("/getLastOrderByCustomerMasterId")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JSONObject getLastOrderByCustomerMasterId(String data) {

		JSONObject jsonObject = null;
		try {
			// System.out.println("cus
			// id"+request.getParameter("customerMasId"));
			jsonObject = new JSONObject(data);
			int customerMasterId = jsonObject.getInt("customerMasId");
			jsonObject = new JSONObject();
			// System.out.println("customer id"+customerMasterId);

			OrderMasterDBHelper orderMasterDBHelper = new OrderMasterDBHelper();
			OrderMasterActionForm orderMasterActionForm = new OrderMasterActionForm();

			/*
			 * orderMasterActionForm=orderMasterDBHelper.getcustomerMasterId);
			 */

			jsonObject.put("orderMasterId", orderMasterActionForm.getOrderMasterId());
			jsonObject.put("orderNumber", orderMasterActionForm.getOrderNumber());

		} catch (Exception e) {
			System.out.println(e);
		}
		return jsonObject;
	}

	@POST
	@Path("/inActiveRecord")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JSONObject inActiveRecord(String data) {

		JSONObject jsonObject = null;
		try {

			HttpSession session = request.getSession(true);
			UserActionForm userActionForm = new UserActionForm();
			userActionForm = (UserActionForm) session.getAttribute(Constants.USER_BEAN);
			int userId = userActionForm.getUserMasterId();
			int masterId = 0;
			String TableName = "";
			String MasterIdName = "";
			String ModifiedDTTM = "";
			int isActive = 0;
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constants.DATE_FORMAT);
			ModifiedDTTM = simpleDateFormat.format(new Date());

			jsonObject = new JSONObject(data);

			if (!jsonObject.isNull("OrderStageMasterId")) {
				int OrderStageMasterId = jsonObject.getInt("OrderStageMasterId");
				masterId = OrderStageMasterId;
				TableName = OrderStageDBAdapter.MDM_ORDER_STAGE_TABLE_NAME;
				MasterIdName = OrderStageDBAdapter.COLUMN_ORDER_STAGE_MASTER_ID;
				isActive = 0;
			}

			if (!jsonObject.isNull("CompanyId")) {
				int CompanyId = jsonObject.getInt("CompanyId");
				masterId = CompanyId;
				TableName = CompanyDBAdapter.COMPANY_TABLE_NAME;
				MasterIdName = CompanyDBAdapter.KEY_COMPANYMASTERID;
				isActive = 0;
			}
			if (!jsonObject.isNull("itemId")) {
				int itemId = jsonObject.getInt("itemId");
				masterId = itemId;
				TableName = ItemDBAdapter.MDM_ITEM_TABLE_NAME;
				MasterIdName = ItemDBAdapter.COLUMN_ITEM_MASTER_ID;
				isActive = 0;
			}

			if (!jsonObject.isNull("measurementId")) {
				int measurementId = jsonObject.getInt("measurementId");
				masterId = measurementId;
				TableName = MeasurementDBAdapter.MDM_MEASUREMENT_TABLE_NAME;
				MasterIdName = MeasurementDBAdapter.COLUMN_MEASUREMENT_MASTER_ID;
				isActive = 0;
			}
			if (!jsonObject.isNull("userid")) {
				int userid = jsonObject.getInt("userid");
				masterId = userid;
				TableName = UserDBAdapter.USER_TABLE_NAME;
				MasterIdName = UserDBAdapter.KEY_USERMASTERID;
				isActive = 0;
			}

			if (!jsonObject.isNull("UserRolesMasterId")) {
				int UserRolesMasterId = jsonObject.getInt("UserRolesMasterId");
				masterId = UserRolesMasterId;
				TableName = UserRoleDBAdapter.KEY_USERROLE_TABLE_NAME;
				MasterIdName = UserRoleDBAdapter.KEY_USERROLE_USERROLEMASTERID;
				isActive = 0;
			}

			if (!jsonObject.isNull("ItemCategoryMasterId")) {
				int ItemCategoryMasterId = jsonObject.getInt("ItemCategoryMasterId");
				masterId = ItemCategoryMasterId;
				TableName = ItemCategoriesDBAdapter.MDM_ITEM_CATEGORIES_TABLE_NAME;
				MasterIdName = ItemCategoriesDBAdapter.COLUMN_ITEM_CATEGORIES_MASTER_ID;
				isActive = 0;
			}
			if (!jsonObject.isNull("ordermasId")) {
				int OrderMasterId = jsonObject.getInt("ordermasId");
				masterId = OrderMasterId;
				TableName = OrderMasterDBAdapter.KEY_ORDER_MASTER_TABLE_NAME;
				MasterIdName = OrderMasterDBAdapter.KEY_ORDER_MASTER_MASTER_ID;
				isActive = 0;
			}

			ConfigDBHelper configDBHelper = new ConfigDBHelper();
			int result = configDBHelper.updateIsActive(TableName, isActive, MasterIdName, masterId, userId,
					ModifiedDTTM);
			jsonObject = new JSONObject();
			jsonObject.put("Status", true);

		} catch (Exception e) {
			System.out.println(e);
		}
		return jsonObject;
	}

	@POST
	@Path("/getUserRollByCompanyId")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JSONArray getUserRollByCompanyId(String data) {

		JSONObject jsonObject = null;
		JSONArray jsonArray = null;

		UserRoleDBHelper userRoleDBHelper = new UserRoleDBHelper();
		try {
			jsonObject = new JSONObject(data);
			if (jsonObject != null) {
				int compid = jsonObject.getInt("companyId");
				ArrayList<UserRoleActionForm> userRoleActionFormList = userRoleDBHelper.getUserRollByCompanyId(compid);

				jsonArray = new JSONArray();
				if (userRoleActionFormList != null) {

					for (int i = 0; i < userRoleActionFormList.size(); i++) {
						jsonObject = new JSONObject();
						jsonObject.put("userrole", userRoleActionFormList.get(i).getName());
						jsonObject.put("userrollid", userRoleActionFormList.get(i).getUserRolesMasterId());
						jsonArray.put(jsonObject);

					}

				}

				else {
					jsonArray = new JSONArray();
				}

			}
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(jsonArray.toString());
		return jsonArray;
	}

	@POST
	@Path("/getTodayOrder")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JSONObject getTodayOrder(String data) {
		JSONObject jsonObject = null;
		HttpSession session = request.getSession(true);
		int compId = (int) session.getAttribute(Constants.COMPANY_ID);
		int userRoleId = (int) session.getAttribute(Constants.USER_ROLE);
		int userId = (int) session.getAttribute(Constants.USER_ID);
		// JSONArray jsonArray = null;
		try {
			jsonObject = new JSONObject(data);
			if (jsonObject != null) {
				OrderMasterDBHelper orderMasterDBHelper = new OrderMasterDBHelper();
				String todayDate = jsonObject.getString("tDate");
				System.out.println(todayDate);

				SimpleDateFormat simplleDateFormat1 = new SimpleDateFormat("yyyy-mm-dd");
				Date date1 = simplleDateFormat1.parse(todayDate);
				simplleDateFormat1.format(date1);
				int totalOrder = orderMasterDBHelper.fetchOrder(todayDate, compId, userRoleId, userId);
				int totalamt = orderMasterDBHelper.fetchTotalAmount(todayDate, compId, userRoleId, userId);
				int totalitem = orderMasterDBHelper.fetchTotalItem(todayDate, compId, userRoleId, userId);

				jsonObject = new JSONObject();
				if (totalamt != 0 && totalOrder != 0) {

					jsonObject.put("TodayOrder", totalOrder);
					jsonObject.put("totalAmount", totalamt);
					jsonObject.put("totalItem", totalitem);
				}
				// jsonArray.put(jsonObject);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		// System.out.println(jsonArray.toString());
		return jsonObject;
	}

	@POST
	@Path("/getItemDetails")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JSONObject getItemDetails(String data) {
		HttpSession httpSession = request.getSession(true);
		int retailid = (int) httpSession.getAttribute(Constants.SESSION_INFO_USER_ID);
		JSONObject jsonObject = null;
		int itemid = 0;
		try {
			jsonObject = new JSONObject(data);
		} catch (JSONException je) {
			System.out.println(je);
		}

		try {
			if (jsonObject != null) {
				itemid = jsonObject.getInt("item");
				RetailDBHelper retailHelper = new RetailDBHelper();
				HashMap<Integer, RetailActionForm> retailOnItemHM = retailHelper.getHashMapOfItemsForRetailer(retailid);
				if (retailOnItemHM != null) {
					RetailActionForm retailBean = retailOnItemHM.get(itemid);
					jsonObject.put("availablequantity",
							retailBean.getDeliveredquantity() - retailBean.getSalequantity());
					jsonObject.put("rate", retailBean.getItemPrice());
				}
			}
		} catch (JSONException je) {
			System.out.println(je);
		}

		return jsonObject;
	}

	@POST
	@Path("/getOrderReport")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JSONObject getOrderReport() {
		return new JSONObject();

	}

	@GET
	@Path("/getOrderReportList")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JSONObject getOrderReportList() throws JSONException, SQLException {
		String data = request.getParameter("data");
		JSONObject jsonObject = new JSONObject(data);
		String month = jsonObject.getString("month");
		String year = jsonObject.getString("year");

		HttpSession httpSession = request.getSession(true);
		int companyid = (int) httpSession.getAttribute(Constants.COMPANY_ID);
		int userid = (int) httpSession.getAttribute(Constants.USER_ID);
		boolean adminflag = true;

		UserDBHelper userHelper = new UserDBHelper();
		if (userHelper.getSingleUserByUserId(userid).getUserRolesMasterId() != Constants.ROLE_ADMIN) {
			adminflag = false;
		}

		ItemDBHelper itemHelper = new ItemDBHelper();
		OrderMasterDBHelper orderMasterHelper = new OrderMasterDBHelper();
		OrderDetailDBHelper orderDetailHelper = new OrderDetailDBHelper();
		ArrayList<OrderMasterActionForm> orderMasterList = orderMasterHelper
				.getOrderMasterDataForGivenMonthAndYear(month, year, companyid, userid, adminflag);

		JSONArray jsonArray = new JSONArray();
		int rowcount = 0;
		if (orderMasterList.size() > 0) {
			for (int i = 0; i < orderMasterList.size(); i++) {
				int orderMasterId = orderMasterList.get(i).getOrderMasterId();
				ArrayList<OrderDetailActionForm> orderDetaillist = orderDetailHelper
						.getOrderDetailsListByOrderMasterId(orderMasterId);

				for (int j = 0; j < orderDetaillist.size(); j++) {
					JSONObject jsonData = new JSONObject();
					jsonData.put("serial", ++rowcount);

					String item = itemHelper.getItemById(orderDetailHelper
							.getOrderByorderDetailDBAdapterId(orderDetaillist.get(j).getOrderDetailId())
							.getItemMasterId()).getName();
					jsonData.put("item", item);

					String ordernumber = orderMasterList.get(i).getOrderNumber();
					jsonData.put("ordernumber", ordernumber);

					String orderdate = orderMasterList.get(i).getCreatedDate();
					jsonData.put("orderdate", orderdate);

					float orderquantity = orderDetaillist.get(j).getQuantity();
					jsonData.put("orderedquantity", orderquantity);

					float deliveredquantity = orderDetaillist.get(j).getDispatchedQuantity();
					jsonData.put("deliveredquantity", deliveredquantity);

					int status = orderMasterList.get(i).getIsActive();
					if (status == Constants.ACTIVE) {
						jsonData.put("status", "ACTIVE");
					} else {
						jsonData.put("status", "INACTIVE");
					}

					jsonArray.put(jsonData);
				}

			}
		}

		JSONObject objForReturn = new JSONObject();
		objForReturn.put("aaData", jsonArray);
		return objForReturn;
	}

	@POST
	@Path("/getOrderDetailsForMonthlyReport")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JSONObject getOrderDetailsForMonthlyReport(String data) throws JSONException, SQLException {
		JSONObject jsonObject = new JSONObject(data);
		int month = jsonObject.getInt("month");
		int year = jsonObject.getInt("year");

		String fromdate = LocalDate.of(year, month, 1).toString();
		String todate = LocalDate.of(year, month, 31).toString();

		OrderMasterDBHelper orderMasterHelper = new OrderMasterDBHelper();
		UserDBHelper userHelper = new UserDBHelper();
		UserRoleDBHelper userRoleHelper = new UserRoleDBHelper();

		HttpSession httpSession = request.getSession(true);
		int companyid = (int) httpSession.getAttribute(Constants.COMPANY_ID);
		int userid = (int) httpSession.getAttribute(Constants.USER_ID);
		boolean adminflag = true;

		if (userHelper.getSingleUserByUserId(userid).getUserRolesMasterId() != Constants.ROLE_ADMIN) {
			adminflag = false;
		}

		ArrayList<OrderMasterActionForm> orderMasterList = orderMasterHelper.getTotalOrderForSpecificPeriod(fromdate,
				todate, companyid, userid, adminflag);
		float totalquantity = 0.0f;
		float totalamount = 0.0f;
		int orders = orderMasterList.size();
		for (int i = 0; i < orderMasterList.size(); i++) {
			totalquantity += orderMasterList.get(i).getOrderQuantity();
			totalamount += orderMasterList.get(i).getTotal();
		}

		int totalitem = orderMasterHelper.getTotalItemsInOrderOfSpecificPeriod(fromdate, todate);

		JSONObject jsonData = new JSONObject();
		jsonData.put("totalorder", orderMasterList.size());
		jsonData.put("totalquantity", totalquantity);
		jsonData.put("totalamount", totalamount);
		jsonData.put("totaliteminorder", totalitem);

		return jsonData;
	}

	@GET
	@Path("/getSaleDetails")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JSONObject getSaleDetails() throws SQLException, JSONException {
		SimpleDateFormat formator = new SimpleDateFormat(Constants.DATE_FORMAT_DATE);
		String date = formator.format(new Date());
		String todate = date;
		String fromdate = date;

		SaleMasterDBHelper saleMasterHelper = new SaleMasterDBHelper();
		SaleDetailDBHelper saleDetailHelper = new SaleDetailDBHelper();
		ItemDBHelper itemHelper = new ItemDBHelper();

		ArrayList<SaleMasterActionForm> saleMasterList = saleMasterHelper.getDetailsForSpecificPeriod(fromdate, todate);
		JSONArray jsonArray = new JSONArray();
		int count = 0;
		if (saleMasterList.size() > 0) {
			for (int i = 0; i < saleMasterList.size(); i++) {
				int saleMasterId = saleMasterList.get(i).getSalemasterid();
				ArrayList<SaleDetailActionForm> saleDetailList = saleDetailHelper
						.getDetailsBySaleMasterId(saleMasterId);
				for (int j = 0; j < saleDetailList.size(); j++) {
					int saleDetailId = saleDetailList.get(j).getSaledetailid();

					JSONObject jsonData = new JSONObject();
					jsonData.put("serial", ++count);
					jsonData.put("detailid", saleDetailId);

					String item = itemHelper
							.getItemById(saleDetailHelper.getDetailsByDetailId(saleDetailId).getItemid()).getName();
					jsonData.put("item", item);

					float quantity = saleDetailList.get(j).getQuantity();
					jsonData.put("quantity", quantity);

					float rate = saleDetailList.get(j).getRate();
					jsonData.put("rate", rate);

					float amount = saleDetailList.get(j).getAmount();
					jsonData.put("amount", amount);

					String saledate = saleMasterList.get(i).getCreatedDate();
					jsonData.put("saledate", saledate);

					String consumername = saleMasterList.get(i).getConsumername();
					jsonData.put("consumername", consumername);

					String consumeraddress = saleMasterList.get(i).getConsumeraddress();
					jsonData.put("consumeraddress", consumeraddress);

					jsonData.put("edit", "<a onclick=editSale(" + saleMasterId
							+ "); title='Edit Sale'><code class='glyphicon glyphicon-edit'></code></a>");

					jsonArray.put(jsonData);
				}
			}
		}

		JSONObject retobj = new JSONObject();
		retobj.put("aaData", jsonArray);
		return retobj;

	}

	@POST
	@Path("/getSaleDetailsSpecificForSaleId")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JSONArray getSaleDetailsSpecificForSaleId() throws SQLException, JSONException {
		HttpSession httpSession = request.getSession(true);
		int saleid = (int) httpSession.getAttribute("saleid");
		int userid = (int) httpSession.getAttribute(Constants.USER_ID);

		SaleMasterDBHelper saleMasterHelper = new SaleMasterDBHelper();
		SaleDetailDBHelper saleDetailHelper = new SaleDetailDBHelper();
		RetailDBHelper retailHelper = new RetailDBHelper();

		SaleMasterActionForm saleMasterBean = saleMasterHelper.getDetailsBySaleMasterId(saleid);
		ArrayList<SaleDetailActionForm> saleDetailList = saleDetailHelper.getDetailsBySaleMasterId(saleid);
		JSONArray jsonArray = new JSONArray();
		for (int i = 0; i < saleDetailList.size(); i++) {
			JSONObject jsonData = new JSONObject();
			jsonData.put("itemid", saleDetailList.get(i).getItemid());

			RetailActionForm retailbean = retailHelper.getRetailDetailsByRetailerAndItem(userid,
					saleDetailList.get(i).getItemid());
			float availablequantity = retailbean.getDeliveredquantity() - retailbean.getSalequantity();
			jsonData.put("availablequantity", availablequantity);

			float quantity = saleDetailList.get(i).getQuantity();
			jsonData.put("quantity", quantity);

			float rate = saleDetailList.get(i).getRate();
			jsonData.put("rate", rate);

			float amount = saleDetailList.get(i).getAmount();
			jsonData.put("amount", amount);

			jsonData.put("saleDetailIdU", saleDetailList.get(i).getSaledetailid());
			jsonData.put("consumername", saleMasterBean.getConsumername());
			jsonData.put("consumeraddress", saleMasterBean.getConsumeraddress());

			jsonArray.put(jsonData);
		}
		return jsonArray;
	}
	
	private class StreamingOutputImpl implements StreamingOutput {

		@Override
		public void write(OutputStream out) throws IOException, WebApplicationException {
			
		}
		
	}
}