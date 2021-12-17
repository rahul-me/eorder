package com.bms.order.ordermaster;

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
import com.bms.mdm.item.ItemActionForm;
import com.bms.mdm.item.ItemDBHelper;
import com.bms.mdm.itemcategories.ItemCategoryActionForm;
import com.bms.mdm.measurement.MeasurementActionForm;
import com.bms.struts.SCMAction;

public class OrderExport extends SCMAction{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
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
			         sheet.setColumnWidth(0, 3000);
			         sheet.setColumnWidth(1, 6500);
			         sheet.setColumnWidth(2, 7500);
			         sheet.setColumnWidth(3, 7500);
			         sheet.setColumnWidth(4, 4500);
			         sheet.setColumnWidth(5, 3000);
			         sheet.setColumnWidth(6, 3500);
			        
			     

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
			         cell.setCellValue(new HSSFRichTextString("Site-ID"));
			        
			         cell = row.createCell(1);
			         cell.setCellStyle(headerCellStyle);
			         cell.setCellValue(new HSSFRichTextString("Category"));
			         cell = row.createCell(2);
			         cell.setCellStyle(headerCellStyle);
			         cell.setCellValue(new HSSFRichTextString("SKU *"));
			         
			         cell = row.createCell(3);
			         cell.setCellStyle(headerCellStyle);
			         cell.setCellValue(new HSSFRichTextString("Item Description"));
			       
			         cell = row.createCell(4);
			         cell.setCellStyle(headerCellStyle);
			         cell.setCellValue(new HSSFRichTextString("Unit"));
			         cell = row.createCell(5);
			         cell.setCellStyle(headerCellStyle);
			         cell.setCellValue(new HSSFRichTextString("Item price"));
			         cell = row.createCell(6);
			         cell.setCellStyle(headerCellStyle);
			         cell.setCellValue(new HSSFRichTextString("Stock-Take-Qty *"));
			         
			         System.out.println("size"+itemArrayList.size());
			         for(int rows=1; rows<=itemArrayList.size(); rows++)
			          {
			        	 itemBean=itemArrayList.get(rows-1);
			        	 measurementActionForm=serverAppContext.getMeasurementByMeasurementMasterId().get(itemBean.getItemMasterId());
			        	 itemCategoryActionForm=serverAppContext.getItemCategoryByItemCategoryMasterId().get(itemBean.getItemCategoryMasterId());
			        	 
			        	row = sheet.createRow(rows);
			            cell=row.createCell(0);
			          
			             cell = row.createCell(1);
			             HSSFRichTextString catName = new HSSFRichTextString((itemCategoryActionForm.getName()));
			             cell.setCellValue(catName);
			             cell = row.createCell(2);
			             HSSFRichTextString itemSKU = new HSSFRichTextString(itemBean.getSKU());
			             cell.setCellValue(itemSKU);
			             cell = row.createCell(3);
			             HSSFRichTextString itemDescription = new HSSFRichTextString(itemBean.getName());
			             cell.setCellValue(itemDescription);
			             cell=row.createCell(4);
			             HSSFRichTextString itemMes = new HSSFRichTextString(measurementActionForm.getUnit());
			             cell.setCellValue(itemMes);
			             cell = row.createCell(5);
			             HSSFRichTextString itemPrice = new HSSFRichTextString(String.valueOf(itemBean.getItemPrice()));
			             cell.setCellValue(itemPrice);
			             cell = row.createCell(6);
			            
			          }
			        
			       System.out.println("responce"+response.getStatus());
			         response.setHeader("Content-Disposition", "attachment; filename=StockTakeList.xls");
			         ServletOutputStream out = response.getOutputStream();
				        wb.write(out);
				        out.flush();
				        out.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		// TODO Auto-generated method stub
		return null;
	}
	
}
