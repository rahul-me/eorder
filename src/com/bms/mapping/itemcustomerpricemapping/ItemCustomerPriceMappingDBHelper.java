package com.bms.mapping.itemcustomerpricemapping;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.log4j.Logger;



/**
 * ItemSupplierMapDBHelper manages the ItemCustomerPriceMapDBAdapter Responsible for 
 * all business operations on the ItemCustomerPriceMapping table.
 * @author Jemis Dhameliya
 *
 */

public class ItemCustomerPriceMappingDBHelper {

	
	private static final String TAG= "com.bms.mapping.itemcustomerpricemapping.ItemCustomerPriceMappingDBHelper";
	private Logger logger = Logger.getLogger(TAG);
	private ItemCustomerPriceMappingDBAdapter itemCustomerDBAdapter;
	public ItemCustomerPriceMappingDBHelper() {
		itemCustomerDBAdapter=new ItemCustomerPriceMappingDBAdapter();
	}
	
	
	public ArrayList<ItemCustomerPriceMappingActionForm> fetchAllRecords(){
		itemCustomerDBAdapter.open();
		System.out.println("itemsupp");
		ResultSet cursor=itemCustomerDBAdapter.getAll();
		ArrayList<ItemCustomerPriceMappingActionForm> itemCustomerBeanList = new ArrayList<ItemCustomerPriceMappingActionForm>();;
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				while(cursor.next()){
					itemCustomerBeanList.add(fetchDataFromResultSet(cursor));
				}
				cursor.close();
			}
			catch (Exception e) {
				//System.out.println(e);
				logger.error(e);
			}
			
		}
		itemCustomerDBAdapter.close();
		return itemCustomerBeanList; 
	}
	
	
	
	public ItemCustomerPriceMappingActionForm getItemCustomerPriceMappingById(int itemCustomerMapId){
		itemCustomerDBAdapter.open();
		ResultSet cursor=itemCustomerDBAdapter.getByItemCustomerPriceMappingId(itemCustomerMapId);
		ItemCustomerPriceMappingActionForm itemCustomerMapBean = null;
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				if(cursor.next()){
					itemCustomerMapBean = fetchDataFromResultSet(cursor);
				}
				cursor.close();
			}
			catch (Exception e) {
				logger.error(e);
			}
		}
		itemCustomerDBAdapter.close();
		return itemCustomerMapBean;
	}
	
	
	
	public int addItemCustomerPriceMapping(ItemCustomerPriceMappingActionForm itemCustomerMapBean)
	{   
		itemCustomerDBAdapter.open();
		int status = itemCustomerDBAdapter.insertItemSupplier(itemCustomerMapBean);
		itemCustomerDBAdapter.close();
		
		return status;
	}
	
	public int updatePrice(ArrayList<ItemCustomerPriceMappingActionForm> itemCustomerActionFormsList)
	{   
		int status=0;
		
		itemCustomerDBAdapter.open();
		Iterator<ItemCustomerPriceMappingActionForm> iterator=itemCustomerActionFormsList.iterator();
		while(iterator.hasNext()){
			ItemCustomerPriceMappingActionForm itemCustomerActionForm=iterator.next();
			//ResultSet resultSet=null;
			try {
				
				ResultSet cursor=itemCustomerDBAdapter.checkRecordExists(itemCustomerActionForm);
				//System.out.println(resultSet.isFirst());
				if(cursor.next())
				{
					if(cursor.getInt(ItemCustomerPriceMappingDBAdapter.COLUMN_ITEM_CUSTOMER_MAPPING_ITEM_PRICE)!=itemCustomerActionForm.getItemPrice())
					{	
						status=itemCustomerDBAdapter.updatePrice(itemCustomerActionForm);
					}
				}else
				{
					status=itemCustomerDBAdapter.insertItemSupplier(itemCustomerActionForm);
				}
				
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
		itemCustomerDBAdapter.close();
		
		return status;
	}
	
	
	public boolean deleteItemSupplierById(int itemCustomerMapId)
	{
         itemCustomerDBAdapter.open();
		boolean status = itemCustomerDBAdapter.deactiavteItemCustomerPriceMapping(itemCustomerMapId);
		itemCustomerDBAdapter.close();
		return status;
	}
	
	
	
	
	public int updateItemCustomerPriceMapping(ItemCustomerPriceMappingActionForm itemCustomerMapBean){
		itemCustomerDBAdapter.open();
		int result = itemCustomerDBAdapter.updatePrice(itemCustomerMapBean);
		if(result<=0){
			
		}
		itemCustomerDBAdapter.close();
		return result;
	}
	
	
	private ItemCustomerPriceMappingActionForm fetchDataFromResultSet(ResultSet cursor){ 
		ItemCustomerPriceMappingActionForm itemCustomerMapBean=new ItemCustomerPriceMappingActionForm();
		try
		{
		
			itemCustomerMapBean.setId(cursor.getInt(ItemCustomerPriceMappingDBAdapter.COLUMN_ITEM_CUSTOMER_MAPPING_ID));
			itemCustomerMapBean.setItemId(cursor.getInt(ItemCustomerPriceMappingDBAdapter.COLUMN_ITEM_CUSTOMER_MAPPING_ITEM_ID));
			itemCustomerMapBean.setCustomerId(cursor.getInt(ItemCustomerPriceMappingDBAdapter.COLUMN_ITEM_CUSTOMER_MAPPING_CUSTOMER_ID));
			itemCustomerMapBean.setCompanyId(cursor.getInt(ItemCustomerPriceMappingDBAdapter.COLUMN_ITEM_CUSTOMER_MAPPING_COMPANY_ID));
			itemCustomerMapBean.setItemPrice(cursor.getFloat(ItemCustomerPriceMappingDBAdapter.COLUMN_ITEM_CUSTOMER_MAPPING_ITEM_PRICE));
			
			itemCustomerMapBean.setCreatedBy(cursor.getInt(ItemCustomerPriceMappingDBAdapter.COLUMN_ITEM_CUSTOMER_MAPPING_CREATEDBY));
			itemCustomerMapBean.setModifiedBy(cursor.getInt(ItemCustomerPriceMappingDBAdapter.COLUMN_ITEM_CUSTOMER_MAPPING_MODIFIEDBY));
			itemCustomerMapBean.setCreatedDTTM(cursor.getString(ItemCustomerPriceMappingDBAdapter.COLUMN_ITEM_CUSTOMER_MAPPING_CREATEDDTTM));
			itemCustomerMapBean.setModifiedDTTM(cursor.getString(ItemCustomerPriceMappingDBAdapter.COLUMN_ITEM_CUSTOMER_MAPPING_MODIFIEDDTTM));
			itemCustomerMapBean.setItemStatus(cursor.getInt(ItemCustomerPriceMappingDBAdapter.COLUMN_ITEM_CUSTOMER_MAPPING_ITEM_STATUS));			
		}
		catch(Exception e)
		{
			logger.error(e);
		}
		return itemCustomerMapBean;
	}
	

	
	
	public ArrayList<ItemCustomerPriceMappingActionForm> getItemCustomerPriceMappingBySupplierId(int itemCustomerMapId){
		itemCustomerDBAdapter.open();
		ResultSet cursor=itemCustomerDBAdapter.getItemCustomerPriceMappingBySupplierId(itemCustomerMapId);
		ArrayList<ItemCustomerPriceMappingActionForm> itemCustomerBeanList = new ArrayList<ItemCustomerPriceMappingActionForm>();
		ItemCustomerPriceMappingActionForm itemCustomerMapBean = null;
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				while(cursor.next()){
					itemCustomerBeanList.add(fetchDataFromResultSet(cursor));
				}
				cursor.close();
			}
			catch (Exception e) {
				//System.out.println(e);
				logger.error(e);
			}
			
		}
		itemCustomerDBAdapter.close();
		return itemCustomerBeanList;
	}

	public ArrayList<ItemCustomerPriceMappingActionForm> getItemCustomerPriceMappingBySupplierIdAndSiteIdAndStatus(int itemCustomerMapId){
		itemCustomerDBAdapter.open();
		ResultSet cursor=itemCustomerDBAdapter.getItemCustomerPriceMappingBySupplierId(itemCustomerMapId);
		ArrayList<ItemCustomerPriceMappingActionForm> itemCustomerBeanList = new ArrayList<ItemCustomerPriceMappingActionForm>();
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				while(cursor.next()){
					itemCustomerBeanList.add(fetchDataFromResultSet(cursor));
				}
				cursor.close();
			}
			catch (Exception e) {
				logger.error(e);
			}
		}
		itemCustomerDBAdapter.close();
		return itemCustomerBeanList;
	}
	
	public ArrayList<ItemCustomerPriceMappingActionForm> getItemCustomerPriceMappingBySupplierIdAndItemId(int supplierId, int itemId){
		itemCustomerDBAdapter.open();
		System.out.println("itemsupp");
		ResultSet cursor=itemCustomerDBAdapter.getItemCustomerPriceMappingBySupplierIdAndItemId(supplierId, itemId);
		ArrayList<ItemCustomerPriceMappingActionForm> itemCustomerBeanList = new ArrayList<ItemCustomerPriceMappingActionForm>();;
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				while(cursor.next()){
					itemCustomerBeanList.add(fetchDataFromResultSet(cursor));
				}
				cursor.close();
			}
			catch (Exception e) {
				//System.out.println(e);
				logger.error(e);
			}
			
		}
		itemCustomerDBAdapter.close();
		return itemCustomerBeanList; 
	}
	
	public ArrayList<ItemCustomerPriceMappingActionForm> getItemCustomerPriceMappingByCustomerIdAndCompanyId(int customerId, int companyId){
		itemCustomerDBAdapter.open();
		System.out.println("itemsupp");
		ResultSet cursor=itemCustomerDBAdapter.getItemCustomerPriceMappingByCustomerIdAndCompanyId(customerId, companyId);
		ArrayList<ItemCustomerPriceMappingActionForm> itemCustomerBeanList = new ArrayList<ItemCustomerPriceMappingActionForm>();;
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				while(cursor.next()){
					itemCustomerBeanList.add(fetchDataFromResultSet(cursor));
				}
				cursor.close();
			}
			catch (Exception e) {
				//System.out.println(e);
				logger.error(e);
			}
			
		}
		itemCustomerDBAdapter.close();
		return itemCustomerBeanList; 
	}
	
	public ArrayList<ItemCustomerPriceMappingActionForm> getItemCustomerPriceMappingBySiteId(int itemCustomerMapSiteId){
		itemCustomerDBAdapter.open();
		ResultSet cursor=itemCustomerDBAdapter.getItemCustomerPriceMappingBySiteId(itemCustomerMapSiteId);
		ArrayList<ItemCustomerPriceMappingActionForm> itemCustomerBeanList = new ArrayList<ItemCustomerPriceMappingActionForm>();
		ItemCustomerPriceMappingActionForm itemCustomerMapBean = null;
		
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				while(cursor.next()){
					itemCustomerBeanList.add(fetchDataFromResultSet(cursor));
				}
				cursor.close();
			}
			catch (Exception e) {
				//System.out.println(e);
				logger.error(e);
			}
			
		}
		itemCustomerDBAdapter.close();
		return itemCustomerBeanList;
	}

	
	public ArrayList<ItemCustomerPriceMappingActionForm> getItemCustomerPriceMappingByGenericItems(int itemId){
		itemCustomerDBAdapter.open();
		ResultSet cursor=itemCustomerDBAdapter.getItemCustomerPriceMappingByGenericItem(itemId);
		ArrayList<ItemCustomerPriceMappingActionForm> itemCustomerBeanList = new ArrayList<ItemCustomerPriceMappingActionForm>();
		ItemCustomerPriceMappingActionForm itemCustomerMapBean = null;
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				while(cursor.next()){
					itemCustomerBeanList.add(fetchDataFromResultSet(cursor));
				}
				cursor.close();
			}
			catch (Exception e) {
				//System.out.println(e);
				logger.error(e);
			}
			
		}
		itemCustomerDBAdapter.close();
		return itemCustomerBeanList;
	}


	public ItemCustomerPriceMappingActionForm getItemCustomerPriceMappingByItemId(int itemId){
		itemCustomerDBAdapter.open();
		ResultSet cursor=itemCustomerDBAdapter.getByItemCustomerPriceMappingItemId(itemId);
		ItemCustomerPriceMappingActionForm itemCustomerMapBean = null;
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				if(cursor.next()){
					itemCustomerMapBean = fetchDataFromResultSet(cursor);
				}
				cursor.close();
			}
			catch (Exception e) {
				logger.error(e);
			}
		}
		itemCustomerDBAdapter.close();
		return itemCustomerMapBean;
	}
	
	
	
	/*public ArrayList<SupplierActionForm> getSupplierBySiteId(int siteId){
	
		itemCustomerDBAdapter.open();
		ResultSet cursor=itemCustomerDBAdapter.getItemCustomerPriceMappingBySiteId(siteId);
		ArrayList<SupplierActionForm> ItemCustomerPriceMappingBeanList = new ArrayList<SupplierActionForm>();
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				while(cursor.next()){
					
					SupplierActionForm supplierActionForm= new SupplierDBHelper().getSupplierBySupplierId(cursor.getInt(3));
					ItemCustomerPriceMappingBeanList.add(supplierActionForm);
				}
				cursor.close();
			}
			catch (Exception e) {
				//System.out.println(e);
				logger.error(e);
			}
			
		}
		itemCustomerDBAdapter.close();
		return ItemCustomerPriceMappingBeanList; 
	}*/
	
/*	public HSSFWorkbook create(ArrayList<ItemCustomerPriceMappingActionForm> itemCustomerExport) throws Exception
   	{
   		 ItemDBHelper itemDBHelper =new ItemDBHelper();
   		 ItemActionForm itemBean=new ItemActionForm();
   		HSSFWorkbook wb = new HSSFWorkbook();
         HSSFSheet sheet = wb.createSheet("Items Data");
         *//**
          * Setting the width of the first three columns.
          *//*
         sheet.setColumnWidth(0, 3500);
         sheet.setColumnWidth(1, 7500);
         sheet.setColumnWidth(2, 7500);
         sheet.setColumnWidth(3, 3500);
         *//**
          * Style for the header cells.
          *//*
         HSSFCellStyle headerCellStyle = wb.createCellStyle();
         HSSFFont boldFont = wb.createFont();
         boldFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
         headerCellStyle.setFont(boldFont);
         HSSFRow row = sheet.createRow(0);
         HSSFCell cell = row.createCell(0);
         cell = row.createCell(0);
         cell.setCellStyle(headerCellStyle);
         cell.setCellValue(new HSSFRichTextString("Item no"));
         cell = row.createCell(1);
         cell.setCellStyle(headerCellStyle);
         cell.setCellValue(new HSSFRichTextString("Item Name"));
         cell = row.createCell(2);
         cell.setCellStyle(headerCellStyle);
         cell.setCellValue(new HSSFRichTextString("Price"));
         cell = row.createCell(3);
         cell.setCellStyle(headerCellStyle);
         cell.setCellValue(new HSSFRichTextString("SKU"));
         for(int rows=1; rows<=(itemCustomerExport.size()); rows++)
          {
        	 ItemCustomerPriceMappingActionForm itemCustomerActionForm= (ItemCustomerPriceMappingActionForm) itemCustomerExport.get(rows-1);
        	 itemBean=itemDBHelper.getItemById(itemCustomerActionForm.getItemId());
        	 row = sheet.createRow(rows);
        	 cell=row.createCell(0);
        	 HSSFRichTextString stockTakeNo = new HSSFRichTextString(String.valueOf((itemCustomerActionForm.getItemId())));
             cell.setCellValue(stockTakeNo);
             cell = row.createCell(1);
             HSSFRichTextString itemName = new HSSFRichTextString(itemBean.getItemName());
        	 cell.setCellValue(itemName);
        	 cell = row.createCell(2);
             HSSFRichTextString price = new HSSFRichTextString(String.valueOf(itemCustomerActionForm.getItemPrice()));
             cell.setCellValue(price);
             cell = row.createCell(3);
             HSSFRichTextString sku = new HSSFRichTextString(itemBean.getSKU());
        	 cell.setCellValue(sku);
          }
    	return wb;
   	}
	*/
	
	/*
	 * 
	 * Below Function is for Get Item Price For Order Entry Using Parameter Like SupplierId,ItemId and AreaId(SiteID)
	 */
	public ItemCustomerPriceMappingActionForm getItemCustomerPriceMappingByCustomerIdAndCompanyIdAndItemId(int customerId, int companyId,int itemId){
		itemCustomerDBAdapter.open();
		System.out.println("itemsupp");
		ResultSet cursor=itemCustomerDBAdapter.getItemCustomerPriceMappingByCustomerIdAndCompanyIdAndItemId(customerId, companyId,itemId);
		ItemCustomerPriceMappingActionForm itemCustomerBean = new ItemCustomerPriceMappingActionForm();
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				if(cursor.next()){
					itemCustomerBean = fetchDataFromResultSet(cursor);
				}
				cursor.close();
			}
			catch (Exception e) {
				//System.out.println(e);
				logger.error(e);
			}
			
		}
		itemCustomerDBAdapter.close();
		return itemCustomerBean; 
	}
	
	
	//End Code.
}
