package com.bms.mdm.supercategory;

import java.sql.ResultSet;

import org.apache.log4j.Logger;

import com.bms.db.ContentValues;
import com.bms.db.RestoserverDBAdapter;
import com.bms.mdm.supercategory.SuperCategoryActionForm;


/**
 * SuperCategoriesDBAdapter manages the SuperCategories table in the database. Responsible for 
 * all CRUD operations on the mdm_supercategory table.
 * @author Jemis Dhameliya
 *
 */
public class SuperCategoryDBAdapter extends RestoserverDBAdapter{
	private final String TAG = "com.bms.mdm.supercategory.SuperCategoryDBAdapter";
	
	private final Logger log = Logger.getLogger(TAG);
	
	public static final String SUPER_CATEGORIES_TABLE_NAME="mdm_supercategory";

	public static final String COLUMN_SUPER_CATEGORIES_ID="supercategoryId";
	public static final String COLUMN_PRODUCT_MASTER_ID="productMasterId";
	public static final String COLUMN_SUPER_CATEGORIES_CODE="superCategoryCode";
	public static final String COLUMN_SUPER_CATEGORIES_DESCRIPTION="superCategoryDesc";
	
		public SuperCategoryDBAdapter() {
		 super();
	}

	
	
	 /**
		 * Insert SuperCategories will insert data in to SuperCategories table 
         *
		 * @param superCategoryBean 
		 * @return cVAlue object if success 
		 */
        
		public int insertSuperCategories(SuperCategoryActionForm superCategoryBean)
		
		{	
			ContentValues cValues = new ContentValues();
		//	cValues.put(COLUMN_ITEM_CATEGORIES_ID, superCategoryBean.getItemCategoryId());
			cValues.put(COLUMN_PRODUCT_MASTER_ID, superCategoryBean.getProductMasterId());
			cValues.put(COLUMN_SUPER_CATEGORIES_CODE, superCategoryBean.getSuperCategoryCode());
			cValues.put(COLUMN_SUPER_CATEGORIES_DESCRIPTION, superCategoryBean.getSupercategoryDesc());
			
			return (int)insert(SUPER_CATEGORIES_TABLE_NAME, null, cValues);
			
		}
	 
		/**
		 * get All Method will return all record of mdm_SuperCategories table
		 * 
		 * 
		 */
		
		public ResultSet getAll()
		{
			return query(SUPER_CATEGORIES_TABLE_NAME, null, null, null, null, null, null);		
		}
		
		
		/**
		 * getBySuperCategoryId  will return single record of mdm_SuperCategories table
		 * 
		 * @param superCateId
		 * @return resultset
		 * 
		 */
		
		public ResultSet getBySuperCategoryId(int superCateId)
		{
			return query(SUPER_CATEGORIES_TABLE_NAME, null, COLUMN_SUPER_CATEGORIES_ID+ "=" + superCateId, null, null, null, null);
		}
		
	
		public ResultSet getSuperCategoryCode(String superCategoryCode)
		{
			
			return query(SUPER_CATEGORIES_TABLE_NAME, null, COLUMN_SUPER_CATEGORIES_CODE+ "='"+superCategoryCode+"'", null, null, null, null);
		}
		
		public ResultSet getAllByFilter(String Filter) {
			return query(SUPER_CATEGORIES_TABLE_NAME, null, Filter, null, null, null,
					null);
		}
		
		/**
		 * DeactivateSuperCategory will unset particular SuperCategories of mdm_supercategory table
		 * 
		 * @param superCateId
		 * @return true/false
		 * 
		 */
			
	
		public boolean deactiavteSuperCategories(long superCateId) {

			return delete(SUPER_CATEGORIES_TABLE_NAME, COLUMN_SUPER_CATEGORIES_ID+ "=" + superCateId, null) > 0;
		}

		
		/**
		 *update will update SuperCategories of SuperCategories table
		 * 
		 * @param superCategoryBean
		 * @return resultset
		 * 
		 */
			
		
		public int update(SuperCategoryActionForm superCategoryBean ){

			int result = 0;
			ContentValues cv=new ContentValues();
			cv.put(COLUMN_PRODUCT_MASTER_ID, superCategoryBean.getProductMasterId());
			cv.put(COLUMN_SUPER_CATEGORIES_CODE, superCategoryBean.getSuperCategoryCode());
			cv.put(COLUMN_SUPER_CATEGORIES_DESCRIPTION, superCategoryBean.getSupercategoryDesc());
			
			result = update(SUPER_CATEGORIES_TABLE_NAME, cv, COLUMN_SUPER_CATEGORIES_ID + "='" + superCategoryBean.getSuperCategoryId() +"'", null);
			return result;
		}
		
}
