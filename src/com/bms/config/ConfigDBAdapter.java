package com.bms.config;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bms.constants.Constants;
import com.bms.db.ContentValues;
import com.bms.db.RestoserverDBAdapter;
import com.mysql.jdbc.PreparedStatement;

public class ConfigDBAdapter extends RestoserverDBAdapter{
	


	private static final String TAG = "com.scm.config.ConfigDBAdapter"; 
	
	public ConfigDBAdapter() {
		super();
	}

	/**
	 * Create a new property using the details provided. If the property is
	 * successfully created return 1, otherwise return
	 * a -1 to indicate failure.
	 * 
	 * @param property the name of the property
	 * @param value the value of the property
	 * @return 1 for success or -1 if failed
	 */
	
	public int createConfig(ConfigActionForm config) {
		ContentValues initialValues = new ContentValues();

		initialValues.put(KEY_PROPERTY, config.getProperty());
		initialValues.put(KEY_VALUE, config.getValue());
		initialValues.put(KEY_PROPERTY_TYPE, config.getPropertyType());
		initialValues.put(KEY_COMPANY_ID, config.getCompanyId());

		/*Log.d(TAG, "property : " + config.getProperty());
		Log.d(TAG, "value : "+ config.getValue());
		Log.d(TAG, "propertyType : " + config.getPropertyType());*/

		return (int) insert(CONFIG_TABLE_NAME, null, initialValues);
	}

	public int updateIsActive(String TableName,int isActive,String MasterIdName,int masterId,int modifiedBy,String modifiedDTTM)

	{
		int result = 0;
		String query="UPDATE orderingdb."+ TableName +" SET isActive="+isActive+",modifiedBY="+modifiedBy+", modifiedDTTM='"+modifiedDTTM+"' WHERE "+ MasterIdName +"="+masterId+"";
		System.out.println("Q" +query);		
		PreparedStatement ps;
		//ResultSet resultSet=null;
		try {
			ps = (PreparedStatement) connection.prepareStatement(query);
			ps.executeUpdate(query);			
			/*if (resultSet.next()){
			    result =resultSet.getInt(1);
			}
*/
		}catch (Exception e) {
			e.printStackTrace();
		}
		//DBConnectionPool.getInstance().free(connection);
		return result;	
	}
	/**
	 * Delete the property with the given propname
	 * 
	 * @param property to delete
	 * @return true if deleted, false otherwise
	 */
	public boolean deleteConfig(String property) {

		return delete(CONFIG_TABLE_NAME, KEY_PROPERTY+ "='" + property + "'", null) > 0;
	}



	/**
	 * Return a ResultSet over the list of all properties in the table
	 * 
	 * @return ResultSet over all properties
	 */
	public ResultSet fetchAllConfig() {

		return query(CONFIG_TABLE_NAME, new String[] {KEY_PROPERTY, KEY_VALUE ,KEY_PROPERTY_TYPE}, null, null, null, null, null);

	}


	/**
	 * Return a ResultSet positioned at the property  that matches the given property
	 * 
	 * @param property to retrieve
	 * @return ResultSet positioned to matching property, if found
	 * @throws SQLException if property could not be found/retrieved
	 */
	public ResultSet fetchConfigByProperty(String property){

		ResultSet mResultSet =

				query(true, CONFIG_TABLE_NAME, new String[] {KEY_VALUE}, KEY_PROPERTY + "='" + property +"'", null,
						null, null, null, null);
		
		return mResultSet;

	}
	
	public ResultSet fetchConfigByCompanyId(int compId)
	{
		ResultSet rs=query(true, CONFIG_TABLE_NAME, new String[] {KEY_VALUE,KEY_PROPERTY,KEY_PROPERTY_TYPE,KEY_COMPANY_ID}, KEY_COMPANY_ID + "='" + compId +"'", null,
				null, null, null, null);
		return rs;
	}

	
	/**
	 * Return a ResultSet positioned at the property  that matches the given propertyType
	 * 
	 * @param propertyType to retrieve
	 * @return ResultSet positioned to matching property, if found
	 * @throws SQLException if property could not be found/retrieved
	 */
	public ResultSet fetchConfigByPropertyType(String propertyType){

		ResultSet mResultSet =

				query(true, CONFIG_TABLE_NAME, new String[] {KEY_PROPERTY, KEY_VALUE , KEY_PROPERTY_TYPE,KEY_COMPANY_ID}, KEY_PROPERTY_TYPE + "='" + propertyType +"'", null,
						null, null, null, null);
		/*if (mResultSet != null) {
			mResultSet.moveToFirst();
		}*/
		return mResultSet;

	}

	/**
	 * Update the property using the value provided. 
	 * If the property is not present in the DB, then it is created and the value is stored.
	 * @param configBean to update
	 */
	public boolean updateConfig(ConfigActionForm config) {
		ContentValues args = new ContentValues();
		if(config.getCompanyId()!=0)
		args.put(KEY_COMPANY_ID,config.getCompanyId());	
		args.put(KEY_PROPERTY, config.getProperty());
		if(config.getValue()!=null){
		args.put(KEY_VALUE, config.getValue());}
		if(config.getPropertyType()!=null){
		args.put(KEY_PROPERTY_TYPE, config.getPropertyType());}
		//int numberofRowsaffected = update(CONFIG_TABLE_NAME, args, KEY_PROPERTY + "='" + config.getProperty() +"'", null);
		int numberofRowsaffected = update(CONFIG_TABLE_NAME, args, KEY_PROPERTY + "='" + config.getProperty() +"' AND "+KEY_COMPANY_ID +"='"+config.getCompanyId()+"'"  , null);
		
		if(  numberofRowsaffected == 0) // no row was found so we need to create one 
		{
			if(config.getValue()==null){
				args.put(KEY_VALUE, Constants.lAST_SYNC_TIME_DEFAULT);}
			else if(config.getPropertyType()==null){
				args.put(KEY_PROPERTY_TYPE, Constants.ORDER_SINK_TIME_10_MIN);}
			
			insert(CONFIG_TABLE_NAME, null, args);
			return true;
		}
		else if(  numberofRowsaffected  != 1)  // more than/less than 1 row was found so we are in trouble :P   ( this already takes care of 0 by the else if)
		{
			return false;
		}

		return true;  // all is well  .. only 1 row was updated
	}

	public boolean insertMailConfiguration(ConfigActionForm configbean){

		ContentValues args = new ContentValues();
		long result;
		args.put(KEY_PROPERTY, configbean.getProperty());
		args.put(KEY_VALUE, configbean.getValue());
		args.put(KEY_PROPERTY_TYPE, configbean.getPropertyType());
		result= insert(CONFIG_TABLE_NAME, null, args);

		if(result>0){
			//Log.d(TAG, "Inserted");
			return true;		
		}
		else
			return false;
	}

	public boolean deleteAllMailReports(String propertyType) {
		//Log.d(TAG, "Deleting mail Reports");
		return delete(CONFIG_TABLE_NAME, KEY_PROPERTY_TYPE+ "='" + propertyType + "'", null) > 0;
	}


	public ResultSet populate(ConfigActionForm configBean){
		 ResultSet ResultSet = query(CONFIG_TABLE_NAME,null,KEY_PROPERTY+ "=" + "'" +configBean.getProperty() +"'", null, null, null, null);
		 return ResultSet;
	}
	
	
	
	
	
	
	
	public boolean updateTrainingFile(String trainingModeProp,int modeValue,String modeFile) {
		ContentValues args = new ContentValues();

		args.put(KEY_PROPERTY, trainingModeProp);
		args.put(KEY_VALUE, modeValue);
		args.put(KEY_PROPERTY_TYPE, modeFile);
		int numberofRowsaffected = update(CONFIG_TABLE_NAME, args, KEY_PROPERTY +"='"+trainingModeProp+"'", null);
		
		if(  numberofRowsaffected == 0) // no row was found so we need to create one 
		{
			insert(CONFIG_TABLE_NAME, null, args);
			return true;
		}
		else if(  numberofRowsaffected  != 1)  // more than/less than 1 row was found so we are in trouble :P   ( this already takes care of 0 by the else if)
		{
			return false;
		}

		return true;  // all is well  .. only 1 row was updated
	}
	
	
	
	
	
	
	public ResultSet fetchTrainingByProperty(String property)
	{

		ResultSet mResultSet =

				query(true, CONFIG_TABLE_NAME, new String[] {KEY_PROPERTY, KEY_VALUE , KEY_PROPERTY_TYPE}, KEY_PROPERTY + "='" + property +"'", null,
						null, null, null, null);
		/*if (mResultSet != null) {
			mResultSet.moveToFirst();
		}*/
		return mResultSet;

	}
		public boolean insertBackupConfiguration(String prop,int value,String filename)
	{
		ContentValues args = new ContentValues();
		long dbresult;
		args.put(KEY_PROPERTY, prop);
		args.put(KEY_VALUE, value);
		args.put(KEY_PROPERTY_TYPE, filename);	
		//dbresult= insert(CONFIG_TABLE_NAME, null, args);
		int numberofRowsaffected = update(CONFIG_TABLE_NAME, args, KEY_PROPERTY + "='" + prop +"'", null);
		/*if(dbresult>0){
			//Log.d(TAG, "Inserted");
			return true;		
		}
		else
			return false;*/
		if(  numberofRowsaffected == 0) // no row was found so we need to create one 
		{
			insert(CONFIG_TABLE_NAME, null, args);
			return true;
		}
		else if(  numberofRowsaffected  != 1)  // more than/less than 1 row was found so we are in trouble :P   ( this already takes care of 0 by the else if)
		{
			return false;
		}

		return true;  // all is well 
		
	}
	
	public ResultSet fetchBachupConfiguration(String property){

		ResultSet mResultSet =
				query(true, CONFIG_TABLE_NAME, new String[] {KEY_PROPERTY, KEY_VALUE , KEY_PROPERTY_TYPE}, KEY_PROPERTY + "='" + property +"'", null,
						null, null, null, null);
		return mResultSet;

	}
	
	
	public int disableTrainingMode(int trainingModeValue,String enableTrainingFile) {
		ContentValues initialValues = new ContentValues();

		initialValues.put(KEY_PROPERTY, "Training Session");
		initialValues.put(KEY_VALUE, trainingModeValue);
		initialValues.put(KEY_PROPERTY_TYPE, enableTrainingFile);

		/*Log.d(TAG, "property : " + config.getProperty());
		Log.d(TAG, "value : "+ config.getValue());
		Log.d(TAG, "propertyType : " + config.getPropertyType());*/

		return (int) insert(CONFIG_TABLE_NAME, null, initialValues);
	}
	
	public ResultSet getAllByFilter(String Filter) {
		return query(CONFIG_TABLE_NAME, null, Filter, null, null, null,null);
	}
	
	
	public ResultSet getDetailsSpecificForCompanyAndProperty(int companyid, String property) throws SQLException{
		String sql = "select * from "+Constants.DBNAME+"."+CONFIG_TABLE_NAME+" where "+KEY_COMPANY_ID+"="+companyid+" and "+KEY_PROPERTY+"='"+Constants.SETTING_CONFIG_ITEMUNITCOST_EDITABILITY+"'";
		Statement stmt = connection.createStatement();
		return stmt.executeQuery(sql);
	}


}
