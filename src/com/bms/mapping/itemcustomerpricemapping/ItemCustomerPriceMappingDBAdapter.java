package com.bms.mapping.itemcustomerpricemapping;

import java.sql.ResultSet;

import org.apache.log4j.Logger;

import com.bms.db.ContentValues;
import com.bms.db.RestoserverDBAdapter;



/**
 * ItemCustomerPriceMapDBAdapter manages the ItemCustomerPriceMapping table in the database. Responsible for 
 * all CRUD operations on the ItemCustomerPriceMapping table.
 * @author Mehul Markana
 *
 */


public class ItemCustomerPriceMappingDBAdapter  extends RestoserverDBAdapter{

	private final String TAG = "com.bms.mapping.itemcustomerpricemapping.ItemCustomerPriceMappingDBAdapter";
	
	private final Logger log = Logger.getLogger(TAG);
	
	public static final String ITEM_CUSTOMER_MAPPING_TABLE_NAME="mapping_Itemcustomerpricemapping";

	public static final String[] DISTINCTCOLUMN={"SupplierId"};
	public static final String COLUMN_ITEM_CUSTOMER_MAPPING_ID="Id";
	public static final String COLUMN_ITEM_CUSTOMER_MAPPING_ITEM_ID="ItemId";
	public static final String COLUMN_ITEM_CUSTOMER_MAPPING_CUSTOMER_ID="customerId";
	public static final String COLUMN_ITEM_CUSTOMER_MAPPING_COMPANY_ID="companyId";
	public static final String COLUMN_ITEM_CUSTOMER_MAPPING_ITEM_PRICE="ItemPrice";
	
	public static final String COLUMN_ITEM_CUSTOMER_MAPPING_CREATEDBY="createdBy";
	public static final String COLUMN_ITEM_CUSTOMER_MAPPING_MODIFIEDBY="modifiedBy";
	public static final String COLUMN_ITEM_CUSTOMER_MAPPING_CREATEDDTTM="createdDTTM";
	public static final String COLUMN_ITEM_CUSTOMER_MAPPING_MODIFIEDDTTM="modifiedDTTM";
	
	public static final String COLUMN_ITEM_CUSTOMER_MAPPING_ITEM_STATUS="itemStatus";
	
	 public ItemCustomerPriceMappingDBAdapter() {
		 super();
	}
	
	 /**
		 * Insert ItemSupplier will insert data in to ItemCustomerPriceMapping table 
         *
		 * @param itemSupplierMapBean 
		 * @return cVAlue object if succes 
		 */
	 	
		public int insertItemSupplier(ItemCustomerPriceMappingActionForm itemSupplierMapBean)
		
		{	
			ContentValues cValues = new ContentValues();
			cValues.put(COLUMN_ITEM_CUSTOMER_MAPPING_ID, itemSupplierMapBean.getId());
			cValues.put(COLUMN_ITEM_CUSTOMER_MAPPING_ITEM_ID, itemSupplierMapBean.getItemId());
			cValues.put(COLUMN_ITEM_CUSTOMER_MAPPING_CUSTOMER_ID, itemSupplierMapBean.getCustomerId());
			cValues.put(COLUMN_ITEM_CUSTOMER_MAPPING_COMPANY_ID, itemSupplierMapBean.getCompanyId());
			cValues.put(COLUMN_ITEM_CUSTOMER_MAPPING_ITEM_PRICE, itemSupplierMapBean.getItemPrice());
			
			cValues.put(COLUMN_ITEM_CUSTOMER_MAPPING_CREATEDBY, itemSupplierMapBean.getCreatedBy());
			cValues.put(COLUMN_ITEM_CUSTOMER_MAPPING_MODIFIEDBY, itemSupplierMapBean.getModifiedBy());
			cValues.put(COLUMN_ITEM_CUSTOMER_MAPPING_CREATEDDTTM, itemSupplierMapBean.getCreatedDTTM());
			cValues.put(COLUMN_ITEM_CUSTOMER_MAPPING_MODIFIEDDTTM, itemSupplierMapBean.getModifiedDTTM());
			cValues.put(COLUMN_ITEM_CUSTOMER_MAPPING_ITEM_STATUS, itemSupplierMapBean.getItemStatus());
			return (int)insert(ITEM_CUSTOMER_MAPPING_TABLE_NAME, null, cValues);
			
		}
		

	 
		/**
		 * get All Method will return all record of ItemCustomerPriceMapping table
		 * 
		 * 
		 */
		
		public ResultSet getAll()
		{
			return query(ITEM_CUSTOMER_MAPPING_TABLE_NAME, null , null, null, null, null, null);		
		}
		
		
		/**
		 * getByItemSupplierMapId  will return single record of ItemCustomerPriceMapping table
		 * 
		 * @param itemSupplierMapId
		 * @return resultset
		 * 
		 */
		
		public ResultSet getByItemCustomerPriceMappingId(int itemSupplierMapId)
		{
			return query(ITEM_CUSTOMER_MAPPING_TABLE_NAME,null, COLUMN_ITEM_CUSTOMER_MAPPING_ID+ "=" + itemSupplierMapId, null, null, null, null);
		}
		
	
		/**
		 * Deactivate ItemCustomerPriceMapping  will unset particular ItemCustomerPriceMapping of ItemCustomerPriceMapping table
		 * 
		 * @param itemSupplierMapId
		 * @return true/false
		 * 
		 */
			
	
		public boolean deactiavteItemCustomerPriceMapping(long itemSupplierMapId) {

			return delete(ITEM_CUSTOMER_MAPPING_TABLE_NAME, COLUMN_ITEM_CUSTOMER_MAPPING_ID+ "=" + itemSupplierMapId, null) > 0;
		}

		/**
		 * getByItemId  will return single record of ItemCustomerPriceMapping table
		 * 
		 * @param itemId
		 * @return resultset
		 * 
		 */
		
		public ResultSet getByItemCustomerPriceMappingItemId(int itemId)
		{
			return query(ITEM_CUSTOMER_MAPPING_TABLE_NAME, null, COLUMN_ITEM_CUSTOMER_MAPPING_ITEM_ID+ "=" + itemId, null, null, null, null);
		}
		
		/**
		 *update will update ItemCustomerPriceMapping of ItemCustomerPriceMapping table
		 * 
		 * @param itemSupplierMapBean
		 * @return resultset
		 * 
		 */
		public ResultSet checkRecordExists(ItemCustomerPriceMappingActionForm itemSupplierActionForm) {
			System.out.println("Query");
			
			return query(ITEM_CUSTOMER_MAPPING_TABLE_NAME, null, COLUMN_ITEM_CUSTOMER_MAPPING_CUSTOMER_ID + "=" + itemSupplierActionForm.getCustomerId() +" and " +COLUMN_ITEM_CUSTOMER_MAPPING_COMPANY_ID + "=" + itemSupplierActionForm.getCompanyId() +" and " +COLUMN_ITEM_CUSTOMER_MAPPING_ITEM_ID + "=" + itemSupplierActionForm.getItemId() +"", null,null,null,null);
		}
		
		
		public int updatePrice(ItemCustomerPriceMappingActionForm itemSupplierMapBean)
		
		{	
			int result = 0;
			ContentValues cValues=new ContentValues();
			
			cValues.put(COLUMN_ITEM_CUSTOMER_MAPPING_ITEM_PRICE, itemSupplierMapBean.getItemPrice());
			cValues.put(COLUMN_ITEM_CUSTOMER_MAPPING_MODIFIEDDTTM, itemSupplierMapBean.getModifiedDTTM());
			cValues.put(COLUMN_ITEM_CUSTOMER_MAPPING_MODIFIEDBY, itemSupplierMapBean.getModifiedBy());
			
		
			result = update(ITEM_CUSTOMER_MAPPING_TABLE_NAME, cValues, COLUMN_ITEM_CUSTOMER_MAPPING_CUSTOMER_ID + "=" + itemSupplierMapBean.getCustomerId() +" and " +COLUMN_ITEM_CUSTOMER_MAPPING_COMPANY_ID + "=" + itemSupplierMapBean.getCompanyId() +" and " +COLUMN_ITEM_CUSTOMER_MAPPING_ITEM_ID + "=" + itemSupplierMapBean.getItemId() +"", null);
			return result;
			
		}
		
			
		
		public int update(ItemCustomerPriceMappingActionForm itemSupplierMapBean ){

			int result = 0;
			ContentValues cValues=new ContentValues();
			cValues.put(COLUMN_ITEM_CUSTOMER_MAPPING_ITEM_ID, itemSupplierMapBean.getItemId());
			cValues.put(COLUMN_ITEM_CUSTOMER_MAPPING_CUSTOMER_ID, itemSupplierMapBean.getCustomerId());
			cValues.put(COLUMN_ITEM_CUSTOMER_MAPPING_COMPANY_ID, itemSupplierMapBean.getCompanyId());
			cValues.put(COLUMN_ITEM_CUSTOMER_MAPPING_ITEM_PRICE, itemSupplierMapBean.getItemPrice());
			cValues.put(COLUMN_ITEM_CUSTOMER_MAPPING_CREATEDBY, itemSupplierMapBean.getCreatedBy());
			cValues.put(COLUMN_ITEM_CUSTOMER_MAPPING_MODIFIEDBY, itemSupplierMapBean.getModifiedBy());
			cValues.put(COLUMN_ITEM_CUSTOMER_MAPPING_CREATEDDTTM, itemSupplierMapBean.getCreatedDTTM());
			cValues.put(COLUMN_ITEM_CUSTOMER_MAPPING_MODIFIEDDTTM, itemSupplierMapBean.getModifiedDTTM());
			cValues.put(COLUMN_ITEM_CUSTOMER_MAPPING_ITEM_STATUS, itemSupplierMapBean.getItemStatus());
		
			result = update(ITEM_CUSTOMER_MAPPING_TABLE_NAME, cValues, COLUMN_ITEM_CUSTOMER_MAPPING_ID + "='" + itemSupplierMapBean.getId() +"'", null);
			return result;
		}
		
		
		/**
		 * getItemCustomerPriceMappingBySupplierId  will return records of ItemCustomerPriceMapping table
		 * 
		 * @param supplierId
		 * @return resultset
		 * 
		 */
		
/*		select * from scmserverdb.mdm_ItemCustomerPriceMapping where ( supplierid = 1007 and sitetype = 3 )  or ( supplierid = 1007 and siteid = 103 and sitetype = 1 )
		and ( supplierid = 1007 and sitetype = 2 and siteid = 201 );*/
		public ResultSet getItemCustomerPriceMappingBySupplierId(int supplierId)
		{
			return query(ITEM_CUSTOMER_MAPPING_TABLE_NAME, null,COLUMN_ITEM_CUSTOMER_MAPPING_CUSTOMER_ID+ "=" + supplierId, null, null, null, null);
		}


		
		/**
		 * getItemCustomerPriceMappingBySupplierId  will return records of ItemCustomerPriceMapping table
		 * 
		 * @param supplierId
		 * @return resultset
		 * 
		 */
		
		public ResultSet getItemCustomerPriceMappingBySupplierIdAndItemId(int supplierId, int itemId)
		{
			return query(ITEM_CUSTOMER_MAPPING_TABLE_NAME, null, COLUMN_ITEM_CUSTOMER_MAPPING_CUSTOMER_ID+ "=" + supplierId + " AND " + COLUMN_ITEM_CUSTOMER_MAPPING_ITEM_ID + "=" + itemId, null, null, null, null);
		}
		
		public ResultSet getItemCustomerPriceMappingByCustomerIdAndCompanyId(int customerId, int companyId)
		{
			return query(ITEM_CUSTOMER_MAPPING_TABLE_NAME, null, COLUMN_ITEM_CUSTOMER_MAPPING_CUSTOMER_ID+ "=" + customerId + " AND " + COLUMN_ITEM_CUSTOMER_MAPPING_COMPANY_ID + "=" + companyId, null, null, null, null);
		}
		
		/**
		 * getItemCustomerPriceMappingBySupplierIdAndSiteId  will return records of ItemCustomerPriceMapping table
		 * 
		 * @param supplierId
		 * @param siteId
		 * @return resultset
		 * 
		 */
		
		
		public ResultSet getItemCustomerPriceMappingBySupplierIdAndStatus(int supplierId, int siteId)
		{
			return query(ITEM_CUSTOMER_MAPPING_TABLE_NAME, null, COLUMN_ITEM_CUSTOMER_MAPPING_CUSTOMER_ID+ "=" + supplierId + " AND " + COLUMN_ITEM_CUSTOMER_MAPPING_ITEM_STATUS + "=" +1, null, null, null, null);
		}
		/**
		 * getItemCustomerPriceMappingBySupplierIdAndSiteIdAndItemId  will return records of ItemCustomerPriceMapping table
		 * 
		 * @param supplierId
		 * @param siteId
		 * @param itemId
		 * @return resultset
		 * 
		 */
		
		
		
		public ResultSet getItemCustomerPriceMappingBySiteId(int supplierId)
		{
			return query(ITEM_CUSTOMER_MAPPING_TABLE_NAME, null, COLUMN_ITEM_CUSTOMER_MAPPING_CUSTOMER_ID+ "=" + supplierId , null, null, null, null);
		}
		
		/**
		 * getItemCustomerPriceMappingBySiteId  will return records of ItemCustomerPriceMapping table
		 * 
		 * @param siteId
		 * @return resultset
		 * 
		 */
		public ResultSet getDistinctItemCustomerPriceMappingBySupplierId(int supplierId)
		{
			return query(true,ITEM_CUSTOMER_MAPPING_TABLE_NAME,DISTINCTCOLUMN, COLUMN_ITEM_CUSTOMER_MAPPING_CUSTOMER_ID+ "=" + supplierId , null, null, null, null, null);
		}
		
		/**
		 * getItemCustomerPriceMappingBySiteId  will return records of ItemCustomerPriceMapping table
		 * 
		 * @param siteId
		 * @return resultset
		 * 
		 */
		
		public ResultSet getItemCustomerPriceMappingByGenericItem(int itemId)
		{
			return query(ITEM_CUSTOMER_MAPPING_TABLE_NAME, null, COLUMN_ITEM_CUSTOMER_MAPPING_ITEM_ID+ "=" + itemId, null, null, null, null);
		}
        
		/*
         * get ItemPrice From ItemCustomerPriceMapping Table 
         *  @param siteId,supplierId,itemId
         */
		public ResultSet getItemCustomerPriceMappingByCustomerIdAndCompanyIdAndItemId(int customerId, int companyId,int itemId)
		{
			return query(ITEM_CUSTOMER_MAPPING_TABLE_NAME, null, COLUMN_ITEM_CUSTOMER_MAPPING_CUSTOMER_ID+ "=" + customerId + " AND " + COLUMN_ITEM_CUSTOMER_MAPPING_COMPANY_ID + "=" + companyId + " AND "+COLUMN_ITEM_CUSTOMER_MAPPING_ITEM_ID + "=" +itemId, null, null, null, null);
		}
}
