package com.bms.mdm.supercategory;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;

import com.bms.mdm.supercategory.SuperCategoryDBAdapter;
import com.bms.mdm.supercategory.SuperCategoryActionForm;

/**
 * SuperCategoryDBHelper manages the SuperCategoryDBAdapter Responsible for 
 * all business operations on the mdm_supercategory table.
 * @author Jemis Dhameliya
 *
 */
public class SuperCategoryDBHelper {
	private static final String TAG= "com.bms.mdm.supercategory.SuperCategoryDBHelper";
	private Logger logger = Logger.getLogger(TAG);
	private SuperCategoryDBAdapter superCateDBAdapter;
	public SuperCategoryDBHelper() {
		superCateDBAdapter=new SuperCategoryDBAdapter();
	}
	
	public ArrayList<SuperCategoryActionForm> fetchAllRecords(){
		superCateDBAdapter.open();
		ResultSet cursor=superCateDBAdapter.getAll();
		ArrayList<SuperCategoryActionForm> superCateBeanList = new ArrayList<SuperCategoryActionForm>();;
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				while(cursor.next()){
					superCateBeanList.add(fetchDataFromResultSet(cursor));
				}
				cursor.close();
			}
			catch (Exception e) {
				//System.out.println(e);
				logger.error(e);
			}
			
		}
		superCateDBAdapter.close();
		return superCateBeanList; 
	}
	
	
	
	public SuperCategoryActionForm getSuperCategoryById(int superCateId){
		superCateDBAdapter.open();
		ResultSet cursor=superCateDBAdapter.getBySuperCategoryId(superCateId);
		SuperCategoryActionForm superCateBean = null;
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				if(cursor.next()){
					superCateBean = fetchDataFromResultSet(cursor);
				}
				cursor.close();
			}
			catch (Exception e) {
				logger.error(e);
			}
		}
		superCateDBAdapter.close();
		return superCateBean;
	}
	
	
	public int addSuperCategory(SuperCategoryActionForm superCateBean)
	{   
		superCateDBAdapter.open();
		int status = superCateDBAdapter.insertSuperCategories(superCateBean);
		superCateDBAdapter.close();
		
		return status;
	}
	
	
	public boolean deleteSuperCategoryById(int superCateId)
	{
         superCateDBAdapter.open();
		boolean status = superCateDBAdapter.deactiavteSuperCategories(superCateId);
		superCateDBAdapter.close();
		return status;
	}
	
	
	
	
	public int updateSuperCategory(SuperCategoryActionForm superCateBean){
		superCateDBAdapter.open();
		int result = superCateDBAdapter.update(superCateBean);
		superCateDBAdapter.close();
		return result;
	}
	
	
	private SuperCategoryActionForm fetchDataFromResultSet(ResultSet cursor){ 
		SuperCategoryActionForm superCateBean=new SuperCategoryActionForm();
		try
		{
			superCateBean.setSuperCategoryId(cursor.getInt(SuperCategoryDBAdapter.COLUMN_SUPER_CATEGORIES_ID));
			superCateBean.setProductMasterId(cursor.getInt(SuperCategoryDBAdapter.COLUMN_PRODUCT_MASTER_ID));
			superCateBean.setSuperCategoryCode(cursor.getString(SuperCategoryDBAdapter.COLUMN_SUPER_CATEGORIES_CODE));
			superCateBean.setSupercategoryDesc(cursor.getString(SuperCategoryDBAdapter.COLUMN_SUPER_CATEGORIES_DESCRIPTION));
						
		}
		catch(Exception e)
		{
			logger.error(e);
		}
		return superCateBean;
	}
	
	public SuperCategoryActionForm getSuperCategoryByCode(String superCateCode){
		superCateDBAdapter.open();
		ResultSet cursor=superCateDBAdapter.getSuperCategoryCode(superCateCode);
		SuperCategoryActionForm superCateBean = null;
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				if(cursor.next()){
					superCateBean = fetchDataFromResultSet(cursor);
				}
				cursor.close();
			}
			catch (Exception e) {
				logger.error(e);
			}
		}
		superCateDBAdapter.close();
		return superCateBean;
	}
	
	/*public ArrayList<SuperCategoryActionForm> fetchAllRecordsByFilter(HashMap<String , String > filterMap) {
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
		superCateDBAdapter.open();
		ResultSet cursor = superCateDBAdapter.getAllByFilter(whereClause);
		ArrayList<SuperCategoryActionForm> itemCategoryActionBeanList = new ArrayList<SuperCategoryActionForm>();
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
		superCateDBAdapter.close();
		return itemCategoryActionBeanList;
	}*/
	
}
