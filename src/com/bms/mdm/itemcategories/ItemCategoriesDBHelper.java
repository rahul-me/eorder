package com.bms.mdm.itemcategories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;

import com.bms.mdm.item.ItemActionForm;




/**
 * ItemCategoriesDBHelper manages the ItemCategoriesDBAdapter Responsible for 
 * all business operations on the ItemCategories table.
 * @author Deepam Parmar
 *
 */

public class ItemCategoriesDBHelper {

	
	private static final String TAG= "com.bms.mdm.itemcategories.ItemCategoriesDBHelper";
	private Logger logger = Logger.getLogger(TAG);
	private ItemCategoriesDBAdapter itemCateDBAdapter;
	public ItemCategoriesDBHelper() {
		itemCateDBAdapter=new ItemCategoriesDBAdapter();
	}
		
	public ArrayList<ItemCategoryActionForm> fetchAllRecords(){
		itemCateDBAdapter.open();
		ResultSet cursor=itemCateDBAdapter.getAll();
		ArrayList<ItemCategoryActionForm> itemCateBeanList = new ArrayList<ItemCategoryActionForm>();;
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				while(cursor.next()){
					itemCateBeanList.add(fetchDataFromResultSet(cursor));
				}
				cursor.close();
			}
			catch (Exception e) {
				//System.out.println(e);
				logger.error(e);
			}
			
		}
		itemCateDBAdapter.close();
		return itemCateBeanList; 
	}
	
	public ArrayList<ItemCategoryActionForm> getAllSuperCategory(){
		itemCateDBAdapter.open();
		ResultSet cursor=itemCateDBAdapter.getAllSuperCategory();
		ArrayList<ItemCategoryActionForm> itemCateBeanList = new ArrayList<ItemCategoryActionForm>();;
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				while(cursor.next()){
					itemCateBeanList.add(fetchDataFromResultSet(cursor));
				}
				cursor.close();
			}
			catch (Exception e) {
				//System.out.println(e);
				logger.error(e);
			}
			
		}
		itemCateDBAdapter.close();
		return itemCateBeanList; 
	}
	
	
	
	public ItemCategoryActionForm getItemCategoryById(int itemCateId){
		itemCateDBAdapter.open();
		ResultSet cursor=itemCateDBAdapter.getByItemCategoryId(itemCateId);
		ItemCategoryActionForm itemCateBean = null;
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				if(cursor.next()){
					itemCateBean = fetchDataFromResultSet(cursor);
				}
				cursor.close();
			}
			catch (Exception e) {
				logger.error(e);
			}
		}
		itemCateDBAdapter.close();
		return itemCateBean;
	}
	
	
	public int addItemCategory(ItemCategoryActionForm itemCateBean)
	{   
		itemCateDBAdapter.open();
		int status = itemCateDBAdapter.insertItemCategories(itemCateBean);
		itemCateDBAdapter.close();
		
		return status;
	}
	
	
	public boolean deleteItemCategoryById(int itemCateId)
	{
         itemCateDBAdapter.open();
		boolean status = itemCateDBAdapter.deactiavteItemCategories(itemCateId);
		itemCateDBAdapter.close();
		return status;
	}
	
	
	
	
	public int updateItemCategoryEntry(ItemCategoryActionForm itemCateBean){
		itemCateDBAdapter.open();
		int result = itemCateDBAdapter.update(itemCateBean);
		itemCateDBAdapter.close();
		return result;
	}
	
	public ArrayList<ItemCategoryActionForm> fetchAllActiveItemCategoriesRecords(){
		itemCateDBAdapter.open();
		ResultSet cursor=itemCateDBAdapter.getAllActiveItemCategories();
		ArrayList<ItemCategoryActionForm> itemcatBeanList = new ArrayList<ItemCategoryActionForm>();
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				while(cursor.next()){
					itemcatBeanList.add(fetchDataFromResultSet(cursor));
				}
				cursor.close();
			}
			catch (Exception e) {
				//System.out.println(e);
				logger.error(e);
			}
			
		}
		itemCateDBAdapter.close();
		return itemcatBeanList; 
	}
	
	
	private ItemCategoryActionForm fetchDataFromResultSet(ResultSet cursor){ 
		ItemCategoryActionForm itemCateBean=new ItemCategoryActionForm();
		try
		{
			itemCateBean.setItemCategoryMasterId(cursor.getInt(ItemCategoriesDBAdapter.COLUMN_ITEM_CATEGORIES_MASTER_ID));
			itemCateBean.setName(cursor.getString(ItemCategoriesDBAdapter.COLUMN_ITEM_CATEGORIES_NAME));
			itemCateBean.setDescription(cursor.getString(ItemCategoriesDBAdapter.COLUMN_ITEM_CATEGORIES_DISCRIPTION));
			itemCateBean.setSuperCategoryId(cursor.getInt(ItemCategoriesDBAdapter.COLUMN_ITEM_CATEGORIES_SUPER_CATEGORY_ID));
			itemCateBean.setCreatedBy(cursor.getInt(ItemCategoriesDBAdapter.COLUMN_ITEM_CATEGORIES_CRATED_BY));
			itemCateBean.setCreatedDTTM(cursor.getString(ItemCategoriesDBAdapter.COLUMN_ITEM_CATEGORIES_CREATED_DTTM));
			itemCateBean.setModifiedBy(cursor.getInt(ItemCategoriesDBAdapter.COLUMN_ITEM_CATEGORIES_MODIFIED_BY));
			itemCateBean.setModifiedDTTM(cursor.getString(ItemCategoriesDBAdapter.COLUMN_ITEM_CATEGORIES_MODIFIED_DTTM));
			itemCateBean.setCompanyMasterId(cursor.getInt(ItemCategoriesDBAdapter.COLUMN_ITEM_CATEGORIES_COMPANY_MASTER_ID));
			itemCateBean.setIsActive(cursor.getInt(ItemCategoriesDBAdapter.COLUMN_ITEM_CATEGORIES_IS_ACTIVE));
					
		}
		catch(Exception e)
		{
			logger.error(e);
		}
		return itemCateBean;
	}
	
	public String getSuperCategoryName(int itemCateId){
		itemCateDBAdapter.open();
		ResultSet cursor=itemCateDBAdapter.getSuperCategoryName(itemCateId);
		String superCatName="";
		try
		{
			cursor.beforeFirst();
			if(cursor.next())
			{
				superCatName=cursor.getString(1);
				System.out.println("............................"+superCatName);
			}
			cursor.close();
		}
		catch (Exception e) {
			logger.error(e);
		}
		itemCateDBAdapter.close();
		return superCatName;
	}
	public ArrayList<ItemCategoryActionForm> fetchAllRecordsByFilter(HashMap<String , String > filterMap) {
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
				whereClause += " STR_TO_DATE(" + tempKey + ",'%d/%m/%Y') between "+  filterMap.get(tempKey)   + " ";
			}
		}
		System.out.println("Query "+whereClause);
		itemCateDBAdapter.open();
		ResultSet cursor = itemCateDBAdapter.getAllByFilter(whereClause);
		ArrayList<ItemCategoryActionForm> itemCategoryActionBeanList = new ArrayList<ItemCategoryActionForm>();
		if (cursor != null) {
			try {
				cursor.beforeFirst();
				while (cursor.next()) {
					itemCategoryActionBeanList.add(fetchDataFromResultSet(cursor));
				}
				cursor.close();
			} catch (Exception e) {
				logger.error(e);
			}
		}
		itemCateDBAdapter.close();
		return itemCategoryActionBeanList;
	}
	public ArrayList<ItemCategoryActionForm>getItemCategoryByCompanyId(int companyid){
		itemCateDBAdapter.open();
		ResultSet cursor=itemCateDBAdapter.getitemCategoriesByCompanyId(companyid);
		ArrayList<ItemCategoryActionForm>itemBean=new ArrayList<ItemCategoryActionForm>();
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
		itemCateDBAdapter.close();
		return itemBean;
			}
	private ItemCategoryActionForm getCompanyFromResultSet(ResultSet userResultSet) throws SQLException{
		ItemCategoryActionForm itemCategbean=new ItemCategoryActionForm();
		itemCategbean.setCompanyMasterId(userResultSet.getInt(ItemCategoriesDBAdapter.COLUMN_ITEM_CATEGORIES_COMPANY_MASTER_ID));
		return itemCategbean;
	}
	public ArrayList<ItemCategoryActionForm> getAlldistinctCompany(){
		itemCateDBAdapter.open();
		ResultSet cursor=itemCateDBAdapter.getAlldistinctCompany();
		ArrayList<ItemCategoryActionForm> itemcategorydisticcompanyFormList = new ArrayList<ItemCategoryActionForm>();;
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				while(cursor.next()){
					itemcategorydisticcompanyFormList.add(getCompanyFromResultSet(cursor));
				}
				cursor.close();
			}
			catch (Exception e) {
				//System.out.println(e);
				logger.error(e);
			}
			
		}
		itemCateDBAdapter.close();
		return itemcategorydisticcompanyFormList; 
	}
	
}
