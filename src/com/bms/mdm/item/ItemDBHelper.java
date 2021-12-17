package com.bms.mdm.item;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;


import com.bms.neetai.users.UserActionForm;
import com.bms.neetai.users.UserDBAdapter;




/**
 * ItemDBHelper manages the ItemDBAdapter Responsible for 
 * all business operations on the Item table.
 * @author Dipam Parmar
 *
 */

public class ItemDBHelper {

	private static final String TAG= "com.bms.mdm.item.ItemDBHelper";
	private Logger logger = Logger.getLogger(TAG);
	private ItemDBAdapter itemDBAdapter;
	public ItemDBHelper() {
		itemDBAdapter=new ItemDBAdapter();
	}
	
	
	public ArrayList<ItemActionForm> fetchAllRecords(){
		itemDBAdapter.open();
		ResultSet cursor=itemDBAdapter.getAll();
		ArrayList<ItemActionForm> itemBeanList = new ArrayList<ItemActionForm>();
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				while(cursor.next()){
					itemBeanList.add(fetchDataFromResultSet(cursor));
				}
				cursor.close();
			}
			catch (Exception e) {
				//System.out.println(e);
				logger.error(e);
			}
			
		}
		itemDBAdapter.close();
		return itemBeanList; 
	}
	
	
	
	public ArrayList<ItemActionForm> fetchAllRecordsByConcatNameAndNumber(){
		itemDBAdapter.open();
		ResultSet cursor=itemDBAdapter.fetchAllRecordsByItemAndItemCategory();
		ArrayList<ItemActionForm> itemanditemcatFormList = new ArrayList<ItemActionForm>();
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				while(cursor.next()){
					itemanditemcatFormList.add(fetchDataFromResultSet(cursor));
				}
				cursor.close();
			}
			catch (Exception e) {
				//System.out.println(e);
				logger.error(e);
			}
			
		}
		itemDBAdapter.close();
		return itemanditemcatFormList; 
	}
	
	public ArrayList<ItemActionForm>getItemByCompanyId(int companyid){
		itemDBAdapter.open();
		ResultSet cursor=itemDBAdapter.getitemByCompanyId(companyid);
		ArrayList<ItemActionForm>itemBean=new ArrayList<ItemActionForm>();
		if(cursor!=null){
			try{
				cursor.beforeFirst();
				while(cursor.next()){
					itemBean.add(fetchDataFromResultSet(cursor));
				}
				cursor.close();
			}
			catch(Exception e){
				logger.error(e);
			}
				}
		itemDBAdapter.close();
		return itemBean;
			}
		
	
		
		
	
	public ArrayList<ItemActionForm> getItemByItemCategoryId(int itemCategoryId){
		itemDBAdapter.open();
		ResultSet cursor=itemDBAdapter.getAllItemByItemCategoryId(itemCategoryId);
		ArrayList<ItemActionForm> itemBeanList = new ArrayList<ItemActionForm>();
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				while(cursor.next()){
					itemBeanList.add(fetchDataFromResultSet(cursor));
				}
				cursor.close();
			}
			catch (Exception e) {
				//System.out.println(e);
				logger.error(e);
			}
			
		}
		itemDBAdapter.close();
		return itemBeanList; 
	}
	

	
	public ItemActionForm getItemById(int itemId){
		itemDBAdapter.open();
		ResultSet cursor=itemDBAdapter.getByItemId(itemId);
		ItemActionForm itemBean = null;
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				if(cursor.next()){
					itemBean = fetchDataFromResultSet(cursor);
				}
				cursor.close();
			}
			catch (Exception e) {
				logger.error(e);
			}
		}
		itemDBAdapter.close();
		return itemBean;
	}
	
	public ItemActionForm getItemIdBySKU(String Name)
	{   
		itemDBAdapter.open();
		ResultSet cursor=itemDBAdapter.getItemIdByName(Name);
		ItemActionForm itemBean = null;
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				if(cursor.next()){
					itemBean = fetchDataFromResultSet(cursor);
				}
				cursor.close();
			}
			catch (Exception e) {
				logger.error(e);
				return null;
			}
		}
		itemDBAdapter.close();
		return itemBean;
		
	}
	
	
	public int addItem(ItemActionForm itemBean)
	{   
		itemDBAdapter.open();
		int status = itemDBAdapter.insertItem(itemBean);
		itemDBAdapter.close();
		
		return status;
	}
	
	
	public boolean deleteAccountEntryById(int itemId)
	{
         itemDBAdapter.open();
		boolean status = itemDBAdapter.deactiavteItem(itemId);
		itemDBAdapter.close();
		return status;
	}
	
	
	
	
	public int updateItemEntry(ItemActionForm itemBean){
		itemDBAdapter.open();
		int result = itemDBAdapter.update(itemBean);
		itemDBAdapter.close();
		return result;
	}
	
	public int updateItemType(ItemActionForm itemBean){
		itemDBAdapter.open();
		int result = itemDBAdapter.updateItemType(itemBean);
		itemDBAdapter.close();
		return result;
	}
	
	public int updateItemPrice(ArrayList<ItemActionForm> itemActionFormsList){
		itemDBAdapter.open();
		int result = itemDBAdapter.updateItemPrice(itemActionFormsList);
		itemDBAdapter.close();
		return result;
	}
	
	
	private ItemActionForm fetchDataFromResultSet(ResultSet cursor){ 
		ItemActionForm itemBean=new ItemActionForm();
		try
		{
			itemBean.setItemMasterId(cursor.getInt(ItemDBAdapter.COLUMN_ITEM_MASTER_ID));
			itemBean.setName(cursor.getString(ItemDBAdapter.COLUMN_ITEM_NAME));
			itemBean.setSKU(cursor.getString(ItemDBAdapter.COLUMN_ITEM_SKU));
			itemBean.setLife(cursor.getFloat(ItemDBAdapter.COLUMN_ITEM_LIFE));
			itemBean.setState(cursor.getInt(ItemDBAdapter.COLUMN_ITEM_STATE));
			itemBean.setIsCritical(cursor.getInt(ItemDBAdapter.COLUMN_ITEM_IS_CRITICAL));
			itemBean.setMinOrderQuantity(cursor.getFloat(ItemDBAdapter.COLUMN_ITEM_MIN_ORDER_QUANTITY));
			itemBean.setItemPrice(cursor.getFloat(ItemDBAdapter.COLUMN_ITEM_PRICE));
			itemBean.setReturnAllowed(cursor.getString(ItemDBAdapter.COLUMN_ITEM_RETURN_ALLOWED));
			itemBean.setDescription(cursor.getString(ItemDBAdapter.COLUMN_ITEM_DESCRIPTION));
			itemBean.setIsActive(cursor.getInt(ItemDBAdapter.COLUMN_ITEM_IS_ACTIVE));
			itemBean.setCreatedBy(cursor.getInt(ItemDBAdapter.COLUMN_ITEM_CREATED_BY));
			itemBean.setCreatedDTTM(cursor.getString(ItemDBAdapter.COLUMN_ITEM_CREATED_DTTM));
			itemBean.setModifiedBy(cursor.getString(ItemDBAdapter.COLUMN_ITEM_MODIFIED_BY));
			itemBean.setModifiedDTTM(cursor.getString(ItemDBAdapter.COLUMN_ITEM_MODIFIED_DTTM));
			itemBean.setPhoto(cursor.getString(ItemDBAdapter.COLUMN_ITEM_PHOTO));
			itemBean.setItemType(cursor.getString(ItemDBAdapter.COLUMN_ITEM_ITEM_TYPE));
			itemBean.setBrand(cursor.getString(ItemDBAdapter.COLUMN_ITEM_BRAND));
			itemBean.setModelNo(cursor.getString(ItemDBAdapter.COLUMN_ITEM_MODEL_NUMBER));
			itemBean.setTax1(cursor.getInt(ItemDBAdapter.COLUMN_ITEM_TAX1));
			itemBean.setTax2(cursor.getInt(ItemDBAdapter.COLUMN_ITEM_TAX2));
			itemBean.setTax3(cursor.getInt(ItemDBAdapter.COLUMN_ITEM_TAX3));
			itemBean.setItemCategoryMasterId(cursor.getString(ItemDBAdapter.COLUMN_ITEM_CATEGORY_MASTER_ID));
			itemBean.setMeasurementMasterId(cursor.getInt(ItemDBAdapter.COLUMN_ITEM_MEASUREMENT_MASTER_ID));
			itemBean.setCompanyMasterId(cursor.getInt(ItemDBAdapter.COLUMN_ITEM_COMPANY_MASTER_ID));
			itemBean.setStockQuantity(cursor.getFloat(ItemDBAdapter.COLUMN_ITEM_STOCK_QUANTITY));
					
		//	itemBean.setSiteId(cursor.getInt(ItemDBAdapter.COLUMN_ITEM_SITEID));
		//	itemBean.setSiteCode(cursor.getInt(ItemDBAdapter.COLUMN_ITEM_SITECODE));
			
			
		}
		catch(Exception e)
		{
			logger.error(e);
		}
		return itemBean;
	}
	
	private ItemActionForm getCompanyFromResultSet(ResultSet userResultSet) throws SQLException{
		ItemActionForm itembean=new ItemActionForm();
		itembean.setCompanyMasterId(userResultSet.getInt(UserDBAdapter.KEY_COMPANYMASTERID));
		return itembean;
	
	}
	
	
	/*private ItemActionForm fetchDataFromResultSetitemcat(ResultSet cursor){ 
		ItemActionForm itemBean=new ItemActionForm();
		try
		{
			itemBean.setItemMasterId(cursor.getInt(ItemDBAdapter.COLUMN_ITEM_MASTER_ID));
	
		}
	*/
	//sorting of items by item name
	public ArrayList<ItemActionForm> getAllRecordsSortedbyName(){
		itemDBAdapter.open();
		ResultSet cursor=itemDBAdapter.getAllSortedItemsByName();
		ArrayList<ItemActionForm> itemBeanList = new ArrayList<ItemActionForm>();;
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				while(cursor.next()){
					itemBeanList.add(fetchDataFromResultSet(cursor));
				}
				cursor.close();
			}
			catch (Exception e) {
				//System.out.println(e);
				logger.error(e);
			}
			
		}
		itemDBAdapter.close();
		return itemBeanList; 
	}


	
	public ArrayList<ItemActionForm> fetchAllRecordsByFilter(HashMap<String , String > filterMap) {
		Set<String> keySet = filterMap.keySet();
		Iterator<String > keySetIterator= keySet.iterator();
		String whereClause="";
		while(keySetIterator.hasNext())
		{
			String tempKey = keySetIterator.next();
			if(!tempKey.equalsIgnoreCase("createdDate")){
					whereClause += " " + tempKey + " in("+  filterMap.get(tempKey)   + ") "; 
					System.out.println("mm1" +filterMap.get(tempKey));
					if (keySetIterator.hasNext()) {
						whereClause += " AND ";
					}
				}
			else
			{
				whereClause +=filterMap.get(tempKey); 
				if (keySetIterator.hasNext()) {
					whereClause += " AND ";
				}
			}
		}
		System.out.println("Query "+whereClause);
		itemDBAdapter.open();
		ResultSet cursor = itemDBAdapter.getAllByFilter(whereClause);
		ArrayList<ItemActionForm> itemActionForms = new ArrayList<ItemActionForm>();
		if (cursor != null) {
			try {
				cursor.beforeFirst();
				while (cursor.next()) {
					itemActionForms.add(fetchDataFromResultSet(cursor));
				}
				cursor.close();
			} catch (Exception e) {
				logger.error(e);
			}
		}
		itemDBAdapter.close();
		return itemActionForms;
	}
	/*
	 * Fetch All Active Item Records.
	 */
	
	public ArrayList<ItemActionForm> getAlldistinctCompany(){
		itemDBAdapter.open();
		ResultSet cursor=itemDBAdapter.getAlldistinctCompany();
		ArrayList<ItemActionForm> disticcompanyidList = new ArrayList<ItemActionForm>();;
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				while(cursor.next()){
					disticcompanyidList.add(getCompanyFromResultSet(cursor));
				}
				cursor.close();
			}
			catch (Exception e) {
				//System.out.println(e);
				logger.error(e);
			}
			
		}
		itemDBAdapter.close();
		return disticcompanyidList; 
	}
	public ArrayList<ItemActionForm> fetchAllActiveItemRecords(){
		itemDBAdapter.open();
		ResultSet cursor=itemDBAdapter.getAllActiveItem();
		ArrayList<ItemActionForm> itemBeanList = new ArrayList<ItemActionForm>();
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				while(cursor.next()){
					itemBeanList.add(fetchDataFromResultSet(cursor));
				}
				cursor.close();
			}
			catch (Exception e) {
				//System.out.println(e);
				logger.error(e);
			}
			
		}
		itemDBAdapter.close();
		return itemBeanList; 
	}
	
	public ArrayList<ItemActionForm> getActiveItemsForSpecificCompany(int companyid) throws SQLException{
		itemDBAdapter.open();
		ArrayList<ItemActionForm> list = new ArrayList<ItemActionForm>();
		if(itemDBAdapter.getActiveItemsForSpecificCompany(companyid).next()){
			ResultSet rs = itemDBAdapter.getActiveItemsForSpecificCompany(companyid);
			while(rs.next()){
				list.add(fetchDataFromResultSet(rs));
			}
		}
		itemDBAdapter.close();
		return list;
	}
}