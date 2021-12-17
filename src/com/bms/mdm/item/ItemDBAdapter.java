package com.bms.mdm.item;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.bms.constants.Constants;
import com.bms.db.ContentValues;
import com.bms.db.RestoserverDBAdapter;
import com.bms.mdm.item.ItemActionForm;



/**
 * ItemDBAdapter manages the Item table in the database. Responsible for 
 * all CRUD operations on the Item table.
 * @author Deepam Parmar
 *
 */

public class ItemDBAdapter extends RestoserverDBAdapter{

	private final String TAG = "com.bms.mdm.item.ItemDBAdapter";
	
	private final Logger log = Logger.getLogger(TAG);
	
	public static final String MDM_ITEM_TABLE_NAME="mdm_item";

	public static final String COLUMN_ITEM_MASTER_ID="itemMasterId";
	public static final String COLUMN_ITEM_NAME="name";
	public static final String COLUMN_ITEM_SKU="SKU";
	public static final String COLUMN_ITEM_LIFE="life";
	public static final String COLUMN_ITEM_STATE="state";
	public static final String COLUMN_ITEM_IS_CRITICAL="isCritical";
	public static final String COLUMN_ITEM_MIN_ORDER_QUANTITY="minOrderQuantity";
	public static final String COLUMN_ITEM_PRICE="itemPrice";
	public static final String COLUMN_ITEM_RETURN_ALLOWED="returnAllowed";
	public static final String COLUMN_ITEM_DESCRIPTION="description";
	public static final String COLUMN_ITEM_IS_ACTIVE="isActive";
	public static final String COLUMN_ITEM_CREATED_BY="createdBy";
	public static final String COLUMN_ITEM_CREATED_DTTM="createdDTTM";
	public static final String COLUMN_ITEM_MODIFIED_BY="modifiedBy";
	public static final String COLUMN_ITEM_MODIFIED_DTTM="modifiedDTTM";
	public static final String COLUMN_ITEM_PHOTO="photo";
	public static final String COLUMN_ITEM_ITEM_TYPE="itemType";
	public static final String COLUMN_ITEM_BRAND="brand";
	public static final String COLUMN_ITEM_MODEL_NUMBER="modelNo";
	public static final String COLUMN_ITEM_TAX1="tax1";
	public static final String COLUMN_ITEM_TAX2="tax2";
	public static final String COLUMN_ITEM_TAX3="tax3";
	public static final String COLUMN_ITEM_CATEGORY_MASTER_ID="itemCategoryMasterId";
	public static final String COLUMN_ITEM_MEASUREMENT_MASTER_ID="measurementMasterId";
	public static final String COLUMN_ITEM_COMPANY_MASTER_ID="companyMasterId";
	public static final String COLUMN_ITEM_STOCK_QUANTITY="stockQuantity";

	private static final String COLUMN_ITEM_CATEGORY_ID = null;
	private static final String COLUMN_ITEM_ACTIVE = null;
	
	
	public ItemDBAdapter() {
		 super();
	}

	
	
	/**
	 * Insert Item will insert data in to Item table
     *
	 * @param itemBean 
	 * @return cVAlue object if success 
	 */
 
	public int insertItem(ItemActionForm itemBean)
	
	{	
		ContentValues cValues = new ContentValues();
		cValues.put(COLUMN_ITEM_MASTER_ID, itemBean.getItemMasterId());
		cValues.put(COLUMN_ITEM_NAME, itemBean.getName());
		cValues.put(COLUMN_ITEM_SKU, itemBean.getSKU());
		cValues.put(COLUMN_ITEM_LIFE, itemBean.getLife());
		cValues.put(COLUMN_ITEM_STATE, itemBean.getState());
		cValues.put(COLUMN_ITEM_IS_CRITICAL, itemBean.getIsCritical());
		cValues.put(COLUMN_ITEM_MIN_ORDER_QUANTITY, itemBean.getMinOrderQuantity());
		cValues.put(COLUMN_ITEM_PRICE, itemBean.getItemPrice());
		cValues.put(COLUMN_ITEM_RETURN_ALLOWED, itemBean.getReturnAllowed());
		cValues.put(COLUMN_ITEM_DESCRIPTION, itemBean.getDescription());
		cValues.put(COLUMN_ITEM_IS_ACTIVE, itemBean.getIsActive());
		cValues.put(COLUMN_ITEM_CREATED_BY, itemBean.getCreatedBy());
		cValues.put(COLUMN_ITEM_CREATED_DTTM, itemBean.getCreatedDTTM());
		cValues.put(COLUMN_ITEM_MODIFIED_BY, itemBean.getModifiedBy());
		cValues.put(COLUMN_ITEM_MODIFIED_DTTM, itemBean.getModifiedDTTM());
		cValues.put(COLUMN_ITEM_PHOTO, itemBean.getPhoto());
		cValues.put(COLUMN_ITEM_ITEM_TYPE, itemBean.getItemType());
		cValues.put(COLUMN_ITEM_BRAND, itemBean.getBrand());
		cValues.put(COLUMN_ITEM_MODEL_NUMBER, itemBean.getModelNo());
		cValues.put(COLUMN_ITEM_TAX1, itemBean.getTax1());
		cValues.put(COLUMN_ITEM_TAX2, itemBean.getTax2());
		cValues.put(COLUMN_ITEM_TAX3, itemBean.getTax3());
		cValues.put(COLUMN_ITEM_CATEGORY_MASTER_ID, itemBean.getItemCategoryMasterId());
		cValues.put(COLUMN_ITEM_MEASUREMENT_MASTER_ID, itemBean.getMeasurementMasterId());
		cValues.put(COLUMN_ITEM_COMPANY_MASTER_ID, itemBean.getCompanyMasterId());
		cValues.put(COLUMN_ITEM_STOCK_QUANTITY, itemBean.getStockQuantity());
				
		return (int)insert(MDM_ITEM_TABLE_NAME, null, cValues);
		
	}
 
	/**
	 * get All Method will return all record of Item table
	 * 
	 * 
	 */
	
	public ResultSet getAll()
	{
		return query(MDM_ITEM_TABLE_NAME, null, null, null, null, null, null);		
	}
	
	public ResultSet getAllItemByItemCategoryId(int itemId)
	{
		return query(MDM_ITEM_TABLE_NAME, null, COLUMN_ITEM_CATEGORY_ID+ "=" + itemId, null, null, null, null);		
	}
	/**
	 * getByItemId  will return single record of Item table
	 * 
	 * @param itemId
	 * @return resultset
	 * 
	 */
	
	public ResultSet getByItemId(int itemId)
	{
		return query(MDM_ITEM_TABLE_NAME, null, COLUMN_ITEM_MASTER_ID+ "=" + itemId, null, null, null, null);
	}
	
	
	
	/**
	 * getAllByFilter will return records by filter
	 * 
	 * @param filter(createdDate,siteId,itemId,itemCategoryId list)
	 * 
	 */
	public ResultSet getAllByFilter(String Filter) {
		return query(MDM_ITEM_TABLE_NAME, null, Filter, null, null, null,null);
	}
	/**
	 * DeactivateItem  will unset particular Item of Item table
	 * 
	 * @param itemId
	 * @return true/false
	 * 
	 */
		

	public boolean deactiavteItem(long itemId) {

		return delete(MDM_ITEM_TABLE_NAME, COLUMN_ITEM_MASTER_ID+ "=" + itemId, null) > 0;
	}

	
	/**
	 *update will update Item of Item table
	 * 
	 * @param itemBean
	 * @return resultset
	 * 
	 */
		
	
	public int update(ItemActionForm itemBean ){

		int result = 0;
		ContentValues cv=new ContentValues();
		cv.put(COLUMN_ITEM_NAME, itemBean.getName());
		cv.put(COLUMN_ITEM_SKU, itemBean.getSKU());
		cv.put(COLUMN_ITEM_LIFE, itemBean.getLife());
		cv.put(COLUMN_ITEM_STATE, itemBean.getState());
		cv.put(COLUMN_ITEM_IS_CRITICAL, itemBean.getIsCritical());
		cv.put(COLUMN_ITEM_MIN_ORDER_QUANTITY, itemBean.getMinOrderQuantity());
		cv.put(COLUMN_ITEM_PRICE, itemBean.getItemPrice());
		cv.put(COLUMN_ITEM_RETURN_ALLOWED, itemBean.getReturnAllowed());
		cv.put(COLUMN_ITEM_DESCRIPTION, itemBean.getDescription());
		cv.put(COLUMN_ITEM_IS_ACTIVE, itemBean.getIsActive());
		cv.put(COLUMN_ITEM_CREATED_BY, itemBean.getCreatedBy());
		cv.put(COLUMN_ITEM_CREATED_DTTM, itemBean.getCreatedDTTM());
		cv.put(COLUMN_ITEM_MODIFIED_BY, itemBean.getModifiedBy());
		cv.put(COLUMN_ITEM_MODIFIED_DTTM, itemBean.getModifiedDTTM());
		cv.put(COLUMN_ITEM_PHOTO, itemBean.getPhoto());
		cv.put(COLUMN_ITEM_ITEM_TYPE, itemBean.getItemType());
		cv.put(COLUMN_ITEM_BRAND, itemBean.getBrand());
		cv.put(COLUMN_ITEM_MODEL_NUMBER, itemBean.getModelNo());
		cv.put(COLUMN_ITEM_TAX1, itemBean.getTax1());
		cv.put(COLUMN_ITEM_TAX2, itemBean.getTax2());
		cv.put(COLUMN_ITEM_TAX3, itemBean.getTax3());
		cv.put(COLUMN_ITEM_CATEGORY_MASTER_ID, itemBean.getItemCategoryMasterId());
		cv.put(COLUMN_ITEM_MEASUREMENT_MASTER_ID, itemBean.getMeasurementMasterId());
		cv.put(COLUMN_ITEM_COMPANY_MASTER_ID, itemBean.getCompanyMasterId());
		cv.put(COLUMN_ITEM_STOCK_QUANTITY, itemBean.getStockQuantity());
		
		
		
	
		result = update(MDM_ITEM_TABLE_NAME, cv, COLUMN_ITEM_MASTER_ID + "=" + itemBean.getItemMasterId(), null);
		return result;
	}
	
	public int updateItemType(ItemActionForm itemBean ){

		int result = 0;
		ContentValues cv=new ContentValues();
		cv.put(COLUMN_ITEM_ITEM_TYPE, itemBean.getItemType());
		
		result = update(MDM_ITEM_TABLE_NAME, cv, COLUMN_ITEM_MASTER_ID + "='" + itemBean.getItemMasterId() +"'", null);
		return result;
	}
	
	public int updateItemPrice(ArrayList<ItemActionForm> itemActionFormsList ){

		int result = 0;
		ContentValues cv=new ContentValues();
		for(int i=0;i<itemActionFormsList.size();i++)
		{
			System.out.println("dbadad"+itemActionFormsList.get(i).getItemPrice());
		cv.put(COLUMN_ITEM_PRICE, itemActionFormsList.get(i).getItemPrice());
		result = update(MDM_ITEM_TABLE_NAME, cv, COLUMN_ITEM_MASTER_ID + "=" + itemActionFormsList.get(i).getItemMasterId(), null);
		}
		return result;
	}
	
	
	public ResultSet getAllSortedItemsByName()
	{
		return query(MDM_ITEM_TABLE_NAME, null, null, null, null, null,COLUMN_ITEM_NAME);		
	}
	
	
	public ResultSet getItemIdByName(String itemName){
		try{
		PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM mdm_item where SKU= + '" + itemName +"'");
		ResultSet resultSet;
		resultSet=preparedStatement.executeQuery();
		return resultSet;
		}
		catch(SQLException e)
		{
			//ResultSet resultSet=null;
			//logger.error(e);
			return null;
		}
		 
	 }
	
	
	
	public ResultSet getitemByCompanyId(int companyid)
	{
		ResultSet resultSet=query(MDM_ITEM_TABLE_NAME,null,COLUMN_ITEM_COMPANY_MASTER_ID+ "=" + "'" + companyid +"'", null, null, null, null);
		return resultSet;
	}
	
	public ResultSet fetchAllRecordsByItemAndItemCategory()
	{
		
		return query(MDM_ITEM_TABLE_NAME, new String[]{COLUMN_ITEM_MASTER_ID,COLUMN_ITEM_NAME,"CONCAT(name, ' ', itemCategoryMasterId) as ItemAndItemCategory"}, COLUMN_ITEM_IS_ACTIVE
				+ "= 1", null, null, null, null);		
	}	
	public ResultSet getAllActiveItem()
	{
		return query(MDM_ITEM_TABLE_NAME, null, COLUMN_ITEM_IS_ACTIVE+"= 1", null, null, null, null);		
	}

	public ResultSet getAlldistinctCompany()
	{
		return query(true,MDM_ITEM_TABLE_NAME,new String[]{COLUMN_ITEM_COMPANY_MASTER_ID}, null, null, null, null, null, null);		
	}
	
	public ResultSet getActiveItemsForSpecificCompany(int companyid){
		return query(MDM_ITEM_TABLE_NAME,null,COLUMN_ITEM_COMPANY_MASTER_ID+"="+companyid+" AND "+COLUMN_ITEM_IS_ACTIVE+"="+Constants.ACTIVE, null, null, null, null);
	}
}
