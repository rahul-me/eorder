package com.bms.mdm.item;

import java.util.ArrayList;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bms.constants.Constants;
import com.bms.context.ServerAppContext;
import com.bms.mdm.itemcategories.ItemCategoryActionForm;
import com.bms.mdm.measurement.MeasurementActionForm;
import com.bms.struts.SCMAction;

public class ItemExport extends SCMAction{

	
	
	@Override
	public ActionForward execute(ActionMapping arg0, ActionForm arg1,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ServerAppContext serverAppContext  = (ServerAppContext)request.getServletContext().getAttribute(Constants.STRUTS_APPLICATION_CONTEXT);
		ArrayList<ItemActionForm> itemArrayList=new ArrayList<ItemActionForm>();
		ItemDBHelper itemDBHelper=new ItemDBHelper();
		itemArrayList=itemDBHelper.fetchAllActiveItemRecords();
		ItemActionForm itemBean=new ItemActionForm();
		MeasurementActionForm measurementActionForm=new MeasurementActionForm();
		ItemCategoryActionForm itemCategoryActionForm=new ItemCategoryActionForm();
		
		try
		{
				 	HSSFWorkbook wb =new HSSFWorkbook();
				 	 HSSFSheet sheet = wb.createSheet("Item Data");

				      
			         /**
			          * Setting the width of the first three columns.
			          */
			         sheet.setColumnWidth(0, 3500);
			         sheet.setColumnWidth(1, 5500);
			         sheet.setColumnWidth(2, 7500);
			         sheet.setColumnWidth(3, 8000);
			         sheet.setColumnWidth(4, 4500);
			         sheet.setColumnWidth(5, 3500);
			         sheet.setColumnWidth(6, 3500);
			         sheet.setColumnWidth(7, 4500);
			         sheet.setColumnWidth(8, 4500);
			     

			         /**
			          * Style for the header cells.
			          */
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
			         cell.setCellValue(new HSSFRichTextString("Category"));
			         
			         cell = row.createCell(2);
			         cell.setCellStyle(headerCellStyle);
			         cell.setCellValue(new HSSFRichTextString("SKU"));
			         cell = row.createCell(3);
			         cell.setCellStyle(headerCellStyle);
			         cell.setCellValue(new HSSFRichTextString("Item Description"));
			         
			         cell = row.createCell(4);
			         cell.setCellStyle(headerCellStyle);
			         cell.setCellValue(new HSSFRichTextString("Measurment"));
			       
			     
			         cell = row.createCell(5);
			         cell.setCellStyle(headerCellStyle);
			         cell.setCellValue(new HSSFRichTextString("Critical"));
			         cell = row.createCell(6);
			         cell.setCellStyle(headerCellStyle);
			         cell.setCellValue(new HSSFRichTextString("Type"));
			         
			         cell = row.createCell(7);
			         cell.setCellStyle(headerCellStyle);
			         cell.setCellValue(new HSSFRichTextString("Item price"));
			      
			         cell = row.createCell(8);
			         cell.setCellStyle(headerCellStyle);
			         cell.setCellValue(new HSSFRichTextString("New Item Price"));
			      
			         System.out.println("size"+itemArrayList.size());
			         for(int rows=1; rows<=itemArrayList.size(); rows++)
			         /* {
			        	 itemBean=itemArrayList.get(rows-1);
			        	 measurementActionForm=serverAppContext.getMeasurmentBeanById().get(itemBean.getItemMasterId());
			        	 itemCategoryActionForm=serverAppContext.getItemcategoryBeanByitemCatCode().get(itemBean.getItemCategoryMasterId());
			        	 
			        	row = sheet.createRow(rows);
			            cell=row.createCell(0);
			            HSSFRichTextString sku = new HSSFRichTextString(String.valueOf(itemBean.getItemId()));
			            cell.setCellValue(sku);
			            
			            cell=row.createCell(1);
			             HSSFRichTextString itemMes = new HSSFRichTextString(itemCategoryActionForm.getItemCategoryName());
			             cell.setCellValue(itemMes);
			             cell = row.createCell(2);
			             HSSFRichTextString stockTakeNo = new HSSFRichTextString((itemBean.getSKU()));
			             cell.setCellValue(stockTakeNo);
			             cell = row.createCell(3);
			             HSSFRichTextString itemName = new HSSFRichTextString(itemBean.getItemName());
			             cell.setCellValue(itemName);
			             
			             cell = row.createCell(4);
			             HSSFRichTextString itemDescription = new HSSFRichTextString(measurementActionForm.getMeasurmentUnit());
			             cell.setCellValue(itemDescription);
			      
			             cell = row.createCell(5);
			             HSSFRichTextString itemCat = new HSSFRichTextString(String.valueOf(itemBean.getIsCritical()));
			             cell.setCellValue(itemCat);
			             cell = row.createCell(6);
			             HSSFRichTextString itemPrice = new HSSFRichTextString(String.valueOf((itemBean.getItemType())));
			             cell.setCellValue(itemPrice);
			             cell = row.createCell(7);
			             HSSFRichTextString balenceQuantity = new HSSFRichTextString(String.valueOf(itemBean.getItemPrice()));
			             cell.setCellValue(balenceQuantity);
			             cell=row.createCell(8);
			          }*/
			        
			       System.out.println("responce"+response.getStatus());
			         response.setHeader("Content-Disposition", "attachment; filename=itemList.xls");
			         ServletOutputStream out = response.getOutputStream();
				        wb.write(out);
				        out.flush();
				        out.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		// TODO Auto-generated method stub
		
		
		return super.execute(arg0, arg1, request, response);
	}
	
}
