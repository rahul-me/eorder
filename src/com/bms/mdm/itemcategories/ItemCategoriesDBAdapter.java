package com.bms.mdm.itemcategories;

import java.sql.ResultSet;

import org.apache.log4j.Logger;

import com.bms.db.ContentValues;
import com.bms.db.RestoserverDBAdapter;
import com.bms.mdm.itemcategories.ItemCategoryActionForm;


/**
 * ItemCategoriesDBAdapter manages the ItemCategories table in the database. Responsible for 
 * all CRUD operations on the ItemCategories table.
 * @author Deepam Parmar
 *
 */



public class ItemCategoriesDBAdapter extends RestoserverDBAdapter{

	private final String TAG = "com.bms.mdm.itemcategories.ItemCategoriesDBAdapter";
	
	private final Logger log = Logger.getLogger(TAG);
	
	public static final String MDM_ITEM_CATEGORIES_TABLE_NAME="mdm_itemcategory";

	public static final String COLUMN_ITEM_CATEGORIES_MASTER_ID="itemCategoryMasterId";
	public static final String COLUMN_ITEM_CATEGORIES_NAME="name";
	public static final String COLUMN_ITEM_CATEGORIES_DISCRIPTION="description";
	public static final String COLUMN_ITEM_CATEGORIES_SUPER_CATEGORY_ID="superCategoryId";
	public static final String COLUMN_ITEM_CATEGORIES_CRATED_BY="createdBy";
	public static final String COLUMN_ITEM_CATEGORIES_CREATED_DTTM="createdDTTM";
	public static final String COLUMN_ITEM_CATEGORIES_MODIFIED_BY="modifiedBy";
	public static final String COLUMN_ITEM_CATEGORIES_MODIFIED_DTTM="modifiedDTTM";
	public static final String COLUMN_ITEM_CATEGORIES_COMPANY_MASTER_ID="companyMasterId";
	public static final String COLUMN_ITEM_CATEGORIES_IS_ACTIVE="isActive";
	

	public ItemCategoriesDBAdapter() {
		 super();
	}

	 /**
		 * Insert ItemCategories will insert data in to ItemCategories table 
         *
		 * @param itemCategoriesBean 
		 * @return cVAlue object if succes 
		 */

		public int insertItemCategories(ItemCategoryActionForm itemCategoriesBean)
		
		{	
			ContentValues cValues = new ContentValues();
			cValues.put(COLUMN_ITEM_CATEGORIES_MASTER_ID,itemCategoriesBean.getItemCategoryMasterId());
			cValues.put(COLUMN_ITEM_CATEGORIES_NAME, itemCategoriesBean.getName());
			cValues.put(COLUMN_ITEM_CATEGORIES_DISCRIPTION, itemCategoriesBean.getDescription());
			cValues.put(COLUMN_ITEM_CATEGORIES_SUPER_CATEGORY_ID, itemCategoriesBean.getSuperCategoryId());
			cValues.put(COLUMN_ITEM_CATEGORIES_CRATED_BY, itemCategoriesBean.getCreatedBy());
			cValues.put(COLUMN_ITEM_CATEGORIES_CREATED_DTTM, itemCategoriesBean.getCreatedDTTM());
			cValues.put(COLUMN_ITEM_CATEGORIES_MODIFIED_BY, itemCategoriesBean.getModifiedBy());
			cValues.put(COLUMN_ITEM_CATEGORIES_MODIFIED_DTTM, itemCategoriesBean.getModifiedDTTM());
			cValues.put(COLUMN_ITEM_CATEGORIES_COMPANY_MASTER_ID, itemCategoriesBean.getCompanyMasterId());
			cValues.put(COLUMN_ITEM_CATEGORIES_MODIFIED_BY, itemCategoriesBean.getModifiedBy());
			cValues.put(COLUMN_ITEM_CATEGORIES_IS_ACTIVE, itemCategoriesBean.getIsActive());
			
			return (int)insert(MDM_ITEM_CATEGORIES_TABLE_NAME, null, cValues);
			
		}
	 
		/**
		 * get All Method will return all record of ItemCategories table
		 * 
		 * 
		 */
		
		public ResultSet getAll()
		{
			return query(MDM_ITEM_CATEGORIES_TABLE_NAME, null, null, null, null, null, null);		
		}
		
		public ResultSet getAllSuperCategory()
		{
			return query(MDM_ITEM_CATEGORIES_TABLE_NAME, null, COLUMN_ITEM_CATEGORIES_SUPER_CATEGORY_ID+ "= 0", null, null, null, null);		
		}
		
		
		public ResultSet getByItemCategoryId(int itemCateId)
		{
			return query(MDM_ITEM_CATEGORIES_TABLE_NAME, null, COLUMN_ITEM_CATEGORIES_MASTER_ID+ "=" + itemCateId, null, null, null, null);
		}
		
		/**
		 * getByCategoryCodeAndSuperCatId  will return single record of ItemCategories table
		 * 
		 * @param SuperCatId and CategoryCode
		 * @return resultset
		 * 
		 */
	
		public ResultSet getSuperCategoryName(int itemCategoryCode)
		{
			String str[]={COLUMN_ITEM_CATEGORIES_NAME};
			return query(MDM_ITEM_CATEGORIES_TABLE_NAME, str, COLUMN_ITEM_CATEGORIES_MASTER_ID+ "=" + itemCategoryCode, null, null, null, null);
		}
		
		public ResultSet getAllByFilter(String Filter) {
			return query(MDM_ITEM_CATEGORIES_TABLE_NAME, null, Filter, null, null, null,
					null);
		}
		/**
		 * DeactivateItemCategory will unset particular ItemCategories of ItemCategories table
		 * 
		 * @param itemCateId
		 * @return true/false
		 * 
		 */
		public boolean deactiavteItemCategories(long itemCateId) {

			return delete(MDM_ITEM_CATEGORIES_TABLE_NAME, COLUMN_ITEM_CATEGORIES_MASTER_ID+ "=" + itemCateId, null) > 0;
		}
	
		/**
		 *update will update ItemCategories of ItemCategories table
		 * 
		 * @param itemCategoriesBean
		 * @return resultset
		 * 
		 */
		public int update(ItemCategoryActionForm itemCategoriesBean ){

			int result = 0;
			ContentValues cv=new ContentValues();
			cv.put(COLUMN_ITEM_CATEGORIES_NAME, itemCategoriesBean.getName());
			cv.put(COLUMN_ITEM_CATEGORIES_DISCRIPTION, itemCategoriesBean.getDescription());
			cv.put(COLUMN_ITEM_CATEGORIES_SUPER_CATEGORY_ID, itemCategoriesBean.getSuperCategoryId());
			cv.put(COLUMN_ITEM_CATEGORIES_CRATED_BY, itemCategoriesBean.getCreatedBy());
			cv.put(COLUMN_ITEM_CATEGORIES_CREATED_DTTM, itemCategoriesBean.getCreatedDTTM());
			cv.put(COLUMN_ITEM_CATEGORIES_MODIFIED_BY, itemCategoriesBean.getModifiedBy());
			cv.put(COLUMN_ITEM_CATEGORIES_MODIFIED_DTTM, itemCategoriesBean.getModifiedDTTM());
			cv.put(COLUMN_ITEM_CATEGORIES_COMPANY_MASTER_ID, itemCategoriesBean.getCompanyMasterId());
			cv.put(COLUMN_ITEM_CATEGORIES_IS_ACTIVE, itemCategoriesBean.getIsActive());
		
			
			result = update(MDM_ITEM_CATEGORIES_TABLE_NAME, cv, COLUMN_ITEM_CATEGORIES_MASTER_ID + "='" + itemCategoriesBean.getItemCategoryMasterId() +"'", null);
			return result;
		}
		
		/**
		 * get All Active Method will return all record of Active Item table
		 * 
		 * 
		 */
		
		public ResultSet getAllActiveItemCategories()
		{
			return query(MDM_ITEM_CATEGORIES_TABLE_NAME, null, COLUMN_ITEM_CATEGORIES_IS_ACTIVE+ "= 1", null, null, null,null);		
		}
		
		public ResultSet getitemCategoriesByCompanyId(int companyid)
		{
			ResultSet resultSet=query(MDM_ITEM_CATEGORIES_TABLE_NAME,null,COLUMN_ITEM_CATEGORIES_COMPANY_MASTER_ID+ "=" + "'" + companyid +"'", null, null, null, null);
			return resultSet;
		}
		public ResultSet getAlldistinctCompany()
		{
			return query(true,MDM_ITEM_CATEGORIES_TABLE_NAME,new String[]{COLUMN_ITEM_CATEGORIES_COMPANY_MASTER_ID}, null, null, null, null, null, null);		
		}
		

		
		
		
}
