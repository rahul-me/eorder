package com.bms.mdm.measurement;

import java.sql.ResultSet;

import org.apache.log4j.Logger;

import com.bms.db.ContentValues;
import com.bms.db.RestoserverDBAdapter;

public class MeasurementConversionDBAdapter extends RestoserverDBAdapter {
	
	
	private final String TAG = "com.scm.mdm.MeasurementConversionDBAdapter";
	
	private final Logger log = Logger.getLogger(TAG);
	
	public static final String MDM_MEASUREMENTCONVERSION_TABLE_NAME="mdm_measurementconversion";

	public static final String COLUMN_MEASUREMENTCONVERSION_ID="id";
	public static final String COLUMN_FIRST_MEASUREMENT_ID="firstMeasurementId";
	public static final String COLUMN_SECOND_MEASUREMENT_ID="secondMeasurementId";
	public static final String COLUMN_MEASUREMENTCONVERSION_CONVERSION_VALUE="conversionValue";
	public static final String COLUMN_MEASUREMENTCONVERSION_CREATED_BY="createdBy";
	public static final String COLUMN_MEASUREMENTCONVERSION_CREATED_DTTM="createdDTTM";
	public static final String COLUMN_MEASUREMENTCONVERSION_MODIFIED_BY="modifiedBy";
	public static final String COLUMN_MEASUREMENTCONVERSION_MODIFIED_DTTM="modifiedDTTM";
	

	public MeasurementConversionDBAdapter() {
		 super();
	}

	
	
	 /**
		 * Insert ItemCategories will insert data in to ItemCategories table 
         *
		 * @param itemCategoriesBean 
		 * @return cVAlue object if succes 
		 */
        
		public int insertMeasurementConversion(MeasurementConversionBean measurementConversionBean)
		
		{	
		
			ContentValues cValues = new ContentValues();
			cValues.put(COLUMN_MEASUREMENTCONVERSION_ID, measurementConversionBean.getId());
			cValues.put(COLUMN_FIRST_MEASUREMENT_ID, measurementConversionBean.getFirstMeasurementId());
			cValues.put(COLUMN_SECOND_MEASUREMENT_ID, measurementConversionBean.getSecondMeasurementId());
			cValues.put(COLUMN_MEASUREMENTCONVERSION_CONVERSION_VALUE, measurementConversionBean.getConversionValue());
			cValues.put(COLUMN_MEASUREMENTCONVERSION_CREATED_BY, measurementConversionBean.getCreatedBy());
			cValues.put(COLUMN_MEASUREMENTCONVERSION_CREATED_DTTM, measurementConversionBean.getCreatedDTTM());
			cValues.put(COLUMN_MEASUREMENTCONVERSION_MODIFIED_BY, measurementConversionBean.getModifiedBy());
			cValues.put(COLUMN_MEASUREMENTCONVERSION_MODIFIED_DTTM, measurementConversionBean.getModifiedDTTM());
		
			
			return (int)insert(MDM_MEASUREMENTCONVERSION_TABLE_NAME, null, cValues);
			
		}
	 
		/**
		 * get All Method will return all record of ItemCategories table
		 * 
		 * 
		 */
		
		public ResultSet getAll()
		{
			return query(MDM_MEASUREMENTCONVERSION_TABLE_NAME, null, null, null, null, null, null);		
		}
		
		
		/**
		 * getByItemCategoryId  will return single record of ItemCategories table
		 * 
		 * @param itemCateId
		 * @return resultset
		 * 
		 */
		
		public ResultSet getByMeasurementConversionId(int itemCateId)
		{
			return query(MDM_MEASUREMENTCONVERSION_TABLE_NAME, null, COLUMN_MEASUREMENTCONVERSION_ID+ "=" + itemCateId, null, null, null, null);
		}
			
		public ResultSet getAllByFilter(String Filter) {
			return query(MDM_MEASUREMENTCONVERSION_TABLE_NAME, null, Filter, null, null, null,
					null);
		}
		/**
		 * DeactivateItemCategory will unset particular ItemCategories of ItemCategories table
		 * 
		 * @param itemCateId
		 * @return true/false
		 * 
		 */
			
	
		public boolean deactiavteMeasurementConversion(long itemCateId) {

			return delete(MDM_MEASUREMENTCONVERSION_TABLE_NAME, COLUMN_MEASUREMENTCONVERSION_ID+ "=" + itemCateId, null) > 0;
		}

		
		/**
		 *update will update ItemCategories of ItemCategories table
		 * 
		 * @param itemCategoriesBean
		 * @return resultset
		 * 
		 */
			
		
		public int update(MeasurementConversionBean measurementConversionBean ){

			int result = 0;
			ContentValues cValues=new ContentValues();
			cValues.put(COLUMN_FIRST_MEASUREMENT_ID, measurementConversionBean.getFirstMeasurementId());
			cValues.put(COLUMN_SECOND_MEASUREMENT_ID, measurementConversionBean.getSecondMeasurementId());
			cValues.put(COLUMN_MEASUREMENTCONVERSION_CONVERSION_VALUE, measurementConversionBean.getConversionValue());
			cValues.put(COLUMN_MEASUREMENTCONVERSION_CREATED_BY, measurementConversionBean.getCreatedBy());
			cValues.put(COLUMN_MEASUREMENTCONVERSION_CREATED_DTTM, measurementConversionBean.getCreatedDTTM());
			cValues.put(COLUMN_MEASUREMENTCONVERSION_MODIFIED_BY, measurementConversionBean.getModifiedBy());
			cValues.put(COLUMN_MEASUREMENTCONVERSION_MODIFIED_DTTM, measurementConversionBean.getModifiedDTTM());
		
		
			result = update(MDM_MEASUREMENTCONVERSION_TABLE_NAME, cValues, COLUMN_MEASUREMENTCONVERSION_ID + "='" + measurementConversionBean.getId() +"'", null);
			return result;
		}

}
