package com.bms.mdm.measurement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.bms.constants.Constants;
import com.bms.db.ContentValues;
import com.bms.db.RestoserverDBAdapter;


/**
 * MeasurementDBAdapter manages the Measurement table in the database. Responsible for 
 * all CRUD operations on the Measurement table.
 * @author Deepam Parmar
 *
 */

public class MeasurementDBAdapter extends RestoserverDBAdapter {

private final String TAG = "com.bms.mdm.measurement.MeasurementDBAdapter";
	
	private final Logger log = Logger.getLogger(TAG);
	
	public static final String MDM_MEASUREMENT_TABLE_NAME="mdm_measurement";
	
	public static final String COLUMN_MEASUREMENT_MASTER_ID="measurementMasterId";
	public static final String COLUMN_MEASUREMENT_UNIT="unit";
	public static final String COLUMN_MEASUREMENT_NAME="name";
	public static final String COLUMN_MEASUREMENT_SYMBOL="symbol";
	public static final String COLUMN_MEASUREMENT_CREATED_BY="createdBy";
	public static final String COLUMN_MEASUREMENT_CREATED_DTTM="createdDTTM";
	public static final String COLUMN_MEASUREMENT_MODIFIED_BY="modifiedBy";
	public static final String COLUMN_MEASUREMENT_MODIFIED_DTTM="modifiedDTTM";
	public static final String COLUMN_MEASUREMENT_MODIFIED_IS_ACTIVE="isActive";
	public static final String COLUMN_MEASUREMENT_COMPANY_MASTER_ID="companyMasterId";
	
	
	
	public MeasurementDBAdapter()
	{
		super();
	}
	
	
	public int insertMeasurement(MeasurementActionForm measurementActionForm)
	{
		ContentValues cValues=new ContentValues();
		
		
		cValues.put(COLUMN_MEASUREMENT_UNIT, measurementActionForm.getUnit());
		cValues.put(COLUMN_MEASUREMENT_NAME,measurementActionForm.getName());
		cValues.put(COLUMN_MEASUREMENT_SYMBOL,measurementActionForm.getSymbol());
		cValues.put(COLUMN_MEASUREMENT_CREATED_BY,measurementActionForm.getCreatedBy());
		cValues.put(COLUMN_MEASUREMENT_CREATED_DTTM,measurementActionForm.getCreatedDTTM());
		cValues.put(COLUMN_MEASUREMENT_MODIFIED_BY,measurementActionForm.getModifiedBy());
		cValues.put(COLUMN_MEASUREMENT_MODIFIED_DTTM,measurementActionForm.getModifiedDTTM());
		cValues.put(COLUMN_MEASUREMENT_MODIFIED_IS_ACTIVE,measurementActionForm.getIsActive());
		cValues.put(COLUMN_MEASUREMENT_COMPANY_MASTER_ID,measurementActionForm.getCompanyMasterId());
		
		
		return (int)insert(MDM_MEASUREMENT_TABLE_NAME, null, cValues); 
	}
	
	/**
	 * get All Method will return all record of Measurement table
	 * 
	 * 
	 */
	
	public ResultSet getAll()
	{
		return query(MDM_MEASUREMENT_TABLE_NAME, null, null, null, null, null, null);
	}
	
	/**
	 * getByMeasurementId  will return single record of Measurement table
	 * 
	 * @param transactionId
	 * @return resultset
	 * 
	 */
	
	public ResultSet getByMeasurementId(int measurementId)
	{
		return query(MDM_MEASUREMENT_TABLE_NAME, null, COLUMN_MEASUREMENT_MASTER_ID+ "=" + measurementId, null, null, null, null);
	}
	
	
	/**
	 * DeactivateMeasurementEntry  will unset particular Measurement of MeasurementEntry table
	 * 
	 * @param transactionId
	 * @return true/false
	 * 
	 */
		

	public boolean deactiavteMeasurementEntry(long measurementId) {

		return delete(MDM_MEASUREMENT_TABLE_NAME, COLUMN_MEASUREMENT_MASTER_ID+ "=" + measurementId, null) > 0;
	}
	
	/**
	 *update will update MeasurementEntry of Measurement table
	 * 
	 * @param TransactionEntryBean
	 * @return resultset
	 * 
	 */
		
	public int update(MeasurementActionForm measurementActionForm ){

		int result = 0;
		ContentValues cValues=new ContentValues();
		
		//cValues.put(COLUMN_MEASUREMENT_MASTER_ID, measurementActionForm.getMeasurementId());
		
		cValues.put(COLUMN_MEASUREMENT_UNIT, measurementActionForm.getUnit());
		cValues.put(COLUMN_MEASUREMENT_NAME, measurementActionForm.getName());
		cValues.put(COLUMN_MEASUREMENT_SYMBOL, measurementActionForm.getSymbol());
		cValues.put(COLUMN_MEASUREMENT_CREATED_BY, measurementActionForm.getCreatedBy());
		cValues.put(COLUMN_MEASUREMENT_CREATED_DTTM, measurementActionForm.getCreatedDTTM());
		cValues.put(COLUMN_MEASUREMENT_MODIFIED_BY, measurementActionForm.getModifiedBy());
		cValues.put(COLUMN_MEASUREMENT_MODIFIED_DTTM, measurementActionForm.getModifiedDTTM());
		cValues.put(COLUMN_MEASUREMENT_MODIFIED_IS_ACTIVE, measurementActionForm.getIsActive());
		cValues.put(COLUMN_MEASUREMENT_COMPANY_MASTER_ID, measurementActionForm.getCompanyMasterId());
	
		result = update(MDM_MEASUREMENT_TABLE_NAME, cValues, COLUMN_MEASUREMENT_MASTER_ID + "='" + measurementActionForm.getMeasurementMasterId() +"'", null);
		return result;
	}
	
	
	public ResultSet getAllActiveMeasurement()
	{
		return query(MDM_MEASUREMENT_TABLE_NAME, null, COLUMN_MEASUREMENT_MODIFIED_IS_ACTIVE+"= 1", null, null, null,null);		
	}
	
	
	
	
	public ResultSet getmeasurementByCompanyId(int companyid)
	{
		ResultSet resultSet=query(MDM_MEASUREMENT_TABLE_NAME,null,COLUMN_MEASUREMENT_COMPANY_MASTER_ID+ "=" + "'" + companyid +"'", null, null, null, null);
		return resultSet;
	}
	public ResultSet getAlldistinctCompany()
	{
		return query(true,MDM_MEASUREMENT_TABLE_NAME,new String[]{COLUMN_MEASUREMENT_COMPANY_MASTER_ID}, null, null, null, null, null, null);		
	}
	
	public ResultSet findTrueIfTableHasDataForSpecificCompanyOWFalse(int companyid) throws SQLException{
			String sql = "select * from "+Constants.DBNAME+"."+MDM_MEASUREMENT_TABLE_NAME+" where "+COLUMN_MEASUREMENT_COMPANY_MASTER_ID+"="+companyid;
			Statement stmt = connection.createStatement();
			return stmt.executeQuery(sql);
	}
	
	public ResultSet getActiveMeasuresSpecificForCompany(int companyid) throws SQLException{
		String sql = "select * from "+Constants.DBNAME+"."+MDM_MEASUREMENT_TABLE_NAME+" where "+COLUMN_MEASUREMENT_COMPANY_MASTER_ID+"="+companyid+" and "+COLUMN_MEASUREMENT_MODIFIED_IS_ACTIVE+"="+Constants.ACTIVE;
		Statement stmt = connection.createStatement();
		return stmt.executeQuery(sql);
	}
	
}
