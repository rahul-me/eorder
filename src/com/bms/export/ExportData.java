package com.bms.export;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import com.bms.mdm.orderstage.OrderStageDBHelper;
import com.bms.neetai.users.UserDBHelper;
import com.bms.order.ordermaster.OrderMasterActionForm;
import com.bms.order.ordermaster.OrderMasterDBHelper;

public class ExportData extends Action {
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	{
		String data=request.getParameter("orderIdsForDataDisplay");
		System.out.println(data);
		String data1[]=request.getParameterValues("orderIdsForDataDisplay");
		System.out.println(data1);
		String data2=request.getParameter("str");
		System.out.println(data2);
		String data3[]=request.getParameterValues("str");
		System.out.println(data3);
		
		try
		{
			JSONArray jsonArray=null;
			JSONObject jsonObject=new JSONObject(request.getParameter("str"));
			jsonArray=jsonObject.getJSONArray("orderIdsForDataDisplay");
			System.out.println(jsonArray.length());
		}
		catch(Exception e)
		{
			System.out.println(e);
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
						System.out.println(e);
					}
					
					try
					{
						response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
						response.setHeader("Content-Disposition", "attachment; filename=ordersheet.xlsx");
						ServletOutputStream outputstream=response.getOutputStream();
						workb.write(outputstream);
						outputstream.close();
					}
					catch(Exception e)
					{
						System.out.println(e);
					}
		//-------------------------------------------------------------------------------------
		
		return null;
	}

}
