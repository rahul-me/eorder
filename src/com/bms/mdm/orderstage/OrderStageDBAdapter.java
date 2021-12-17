package com.bms.mdm.orderstage;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.bms.constants.Constants;
import com.bms.db.ContentValues;
import com.bms.db.RestoserverDBAdapter;
import com.mysql.jdbc.PreparedStatement;

public class OrderStageDBAdapter extends RestoserverDBAdapter{

	
private final String TAG = "com.bms.mdm.orderstage.OrderStageDBAdapter";
	
	private final Logger log = Logger.getLogger(TAG);
	
	public static final String MDM_ORDER_STAGE_TABLE_NAME="mdm_orderstage";

	public static final String COLUMN_ORDER_STAGE_MASTER_ID="orderStageMasterId";
	public static final String COLUMN_ORDER_STAGE_NAME="name";
	public static final String COLUMN_ORDER_STAGE_DESCRIPTION="description";
	public static final String COLUMN_ORDER_STAGE_CREATED_BY="createdBy";
	public static final String COLUMN_ORDER_STAGE_MODIFIED_BY="modifiedBy";
	public static final String COLUMN_ORDER_STAGE_CREATED_DTTM="createdDTTM";
	public static final String COLUMN_ORDER_STAGE_MODIFIED_DTTM="modifiedDTTM";
	public static final String COLUMN_ORDER_STAGE_IS_ACTIVE="isActive";
	public static final String COLUMN_ORDER_STAGE_COMPANY_MASTER_ID="companyMasterId";
	
	
	
	
	public OrderStageDBAdapter()
	{
		super();
	}
	
	
	public int insertOrderStage(OrderStageActionForm orderstageActionForm)
	{
		ContentValues cValues=new ContentValues();
		
		
		cValues.put(COLUMN_ORDER_STAGE_MASTER_ID, orderstageActionForm.getOrderStageMasterId());
		cValues.put(COLUMN_ORDER_STAGE_NAME, orderstageActionForm.getName());
		cValues.put(COLUMN_ORDER_STAGE_DESCRIPTION, orderstageActionForm.getDescription());
		cValues.put(COLUMN_ORDER_STAGE_CREATED_BY, orderstageActionForm.getCreatedBy());
		cValues.put(COLUMN_ORDER_STAGE_MODIFIED_BY, orderstageActionForm.getModifiedBy());
		cValues.put(COLUMN_ORDER_STAGE_CREATED_DTTM, orderstageActionForm.getCreatedDTTM());
		cValues.put(COLUMN_ORDER_STAGE_MODIFIED_DTTM, orderstageActionForm.getModifiedDTTM());
		cValues.put(COLUMN_ORDER_STAGE_IS_ACTIVE, orderstageActionForm.getIsActive());
		cValues.put(COLUMN_ORDER_STAGE_COMPANY_MASTER_ID, orderstageActionForm.getCompanyMasterId());
		
		
		return (int)insert(MDM_ORDER_STAGE_TABLE_NAME, null, cValues); 
	}
	
	/**
	 * get All Method will return all record of Measurement table
	 * 
	 * 
	 */
	
	public ResultSet getAll()
	{
		return query(MDM_ORDER_STAGE_TABLE_NAME, null, null, null, null, null, null);
	}
	
	/**
	 * getByMeasurementId  will return single record of Measurement table
	 * 
	 * @param transactionId
	 * @return resultset
	 * 
	 */
	
	public ResultSet getByOrderStageMasterId(int orderstageId)
	{
		return query(MDM_ORDER_STAGE_TABLE_NAME, null, COLUMN_ORDER_STAGE_MASTER_ID+ "=" + orderstageId, null, null, null, null);
	}
	
	
	/**
	 * DeactivateMeasurementEntry  will unset particular Measurement of MeasurementEntry table
	 * 
	 * @param transactionId
	 * @return true/false
	 * 
	 */
		

	public boolean deactiavteOrderStageEntry(long orderstageId) {

		return delete(MDM_ORDER_STAGE_TABLE_NAME, COLUMN_ORDER_STAGE_MASTER_ID+ "=" + orderstageId, null) > 0;
	}
	
	/**
	 *update will update MeasurementEntry of Measurement table
	 * 
	 * @param TransactionEntryBean
	 * @return resultset
	 * 
	 */
		
	public int update(OrderStageActionForm orderstageActionForm ){

		int result = 0;
		ContentValues cValues=new ContentValues();
		
		//cValues.put(COLUMN_ORDER_STAGE_MASTER_ID, orderstageActionForm.getOrderStageMasterId());
		
		
		
		cValues.put(COLUMN_ORDER_STAGE_NAME, orderstageActionForm.getName());
		cValues.put(COLUMN_ORDER_STAGE_DESCRIPTION, orderstageActionForm.getDescription());
		cValues.put(COLUMN_ORDER_STAGE_CREATED_BY, orderstageActionForm.getCreatedBy());
		cValues.put(COLUMN_ORDER_STAGE_MODIFIED_BY, orderstageActionForm.getModifiedBy());
		cValues.put(COLUMN_ORDER_STAGE_CREATED_DTTM, orderstageActionForm.getCreatedDTTM());
		cValues.put(COLUMN_ORDER_STAGE_MODIFIED_DTTM, orderstageActionForm.getModifiedDTTM());
		cValues.put(COLUMN_ORDER_STAGE_IS_ACTIVE, orderstageActionForm.getIsActive());
		cValues.put(COLUMN_ORDER_STAGE_COMPANY_MASTER_ID, orderstageActionForm.getCompanyMasterId());
		
		
		result = update(MDM_ORDER_STAGE_TABLE_NAME, cValues, COLUMN_ORDER_STAGE_MASTER_ID + "='" + orderstageActionForm.getOrderStageMasterId() +"'", null);
		return result;
	}
	
	public ResultSet getAllActiveOrderStage()
	{
		return query(MDM_ORDER_STAGE_TABLE_NAME, null, COLUMN_ORDER_STAGE_IS_ACTIVE+"= 1", null, null, null,null);		
	}

	public ResultSet getorderStageByCompanyId(int companyid)
	{
		ResultSet resultSet=query(MDM_ORDER_STAGE_TABLE_NAME,null,COLUMN_ORDER_STAGE_COMPANY_MASTER_ID+ "=" + "'" + companyid +"'", null, null, null, null);
		return resultSet;
	}
	public ResultSet getAlldistinctCompany()
	{
		return query(true,MDM_ORDER_STAGE_TABLE_NAME,new String[]{COLUMN_ORDER_STAGE_COMPANY_MASTER_ID}, null, null, null, null, null, null);		
	}
	
	public ResultSet getActiveStagesForSpecificCompany(int companyid) throws SQLException{
		String sql ="select * from "+Constants.DBNAME+"."+MDM_ORDER_STAGE_TABLE_NAME+" where "+COLUMN_ORDER_STAGE_COMPANY_MASTER_ID+"="+companyid+" and "+COLUMN_ORDER_STAGE_IS_ACTIVE+"="+Constants.ACTIVE;
		Statement stmt = connection.createStatement();
		return stmt.executeQuery(sql);
	}
		
	
	
	
}
