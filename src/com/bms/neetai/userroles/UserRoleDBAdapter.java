package com.bms.neetai.userroles;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.bms.constants.Constants;
import com.bms.db.ContentValues;
import com.bms.db.RestoserverDBAdapter;
import com.bms.neetai.userroles.UserRoleActionForm;


/**
 * UserRoleDBAdapter manages the usreroletable in the database. Responsible for all
 * CRUD operations on the userrole table.
 * 
 * @author parth gandhi
 * 
 */

public class UserRoleDBAdapter extends RestoserverDBAdapter {
	private final String TAG = "com.bms.neetai.userroles.UserRoleDBAdapter";

	private final Logger log = Logger.getLogger(TAG);
	public static final String KEY_USERROLE_TABLE_NAME = "neetai_userroles";

	public static final String KEY_USERROLE_USERROLEMASTERID = "userRolesMasterId";
	public static final String KEY_USER_USERROLE_NAME = "name";
	public static final String KEY_USERROLE_USERROLE_DESCRIPTION = "description";
	public static final String KEY_USERROLE_USERROLE_CREATEDDTTM = "createdDTTM";
	public static final String KEY_USERROLE_USERROLE_MODIFIEDDTTM = "modifiedDTTM";
	public static final String KEY_USERROLE_CREATEDBY = "createdBY";
	public static final String KEY_USERROLE_MODIFIEDBY = "modifiedBY";
	public static final String KEY_USERROLE_ISACTIVE = "isActive";
	public static final String KEY_USERROLE_COMPANYMASTERID = "companyMasterId";


	
	public UserRoleDBAdapter() {
		super();
	}

	/**
	 * insertUserRole will insert data in to UserRole table
	 * 
	 * 
	 * 
	 * @param userRoleBean
	 * @return cVAlue object if succes
	 */

	public int insertUserRole(UserRoleActionForm userRoleBean)

	{
		ContentValues cValues = new ContentValues();
		cValues.put(KEY_USERROLE_USERROLEMASTERID, userRoleBean.getUserRolesMasterId());
		cValues.put(KEY_USER_USERROLE_NAME, userRoleBean.getName());
		cValues.put(KEY_USERROLE_USERROLE_DESCRIPTION, userRoleBean.getDescription());
		cValues.put(KEY_USERROLE_USERROLE_CREATEDDTTM,userRoleBean.getCreatedDTTM());
		cValues.put(KEY_USERROLE_CREATEDBY, userRoleBean.getCreatedBY());
		cValues.put(KEY_USERROLE_MODIFIEDBY, userRoleBean.getModifiedBY());
		cValues.put(KEY_USERROLE_USERROLE_MODIFIEDDTTM,userRoleBean.getModifiedDTTM());
		cValues.put(KEY_USERROLE_ISACTIVE, userRoleBean.getIsActive());
		cValues.put(KEY_USERROLE_CREATEDBY, userRoleBean.getCreatedBY());
		cValues.put(KEY_USERROLE_COMPANYMASTERID,userRoleBean.getCompanyMasterId());

		
		return (int) insert(KEY_USERROLE_TABLE_NAME, null, cValues);

	}

	/**
	 * get all will return all record of UserRole table
	 * 
	 * 
	 * 
	 * 
	 */

	public ResultSet getAll() {
		return query(KEY_USERROLE_TABLE_NAME,null,null, null,null, null, null);
	}

	/**
	 * getByUserRoleId will return single record of UserRole table
	 * 
	 * @param UserRoleid
	 * @return resultset
	 * 
	 */

	public ResultSet getByUserRoleId(int UserRoleId) {
		return query(KEY_USERROLE_TABLE_NAME,null,
				KEY_USERROLE_USERROLEMASTERID + "=" + UserRoleId, null, null, null, null);
	}
	
	public ResultSet getUserRollByCompanyId(int CompanyId){
		return query(KEY_USERROLE_TABLE_NAME,null,
				KEY_USERROLE_COMPANYMASTERID +"="+CompanyId,null,null,null,null);
	}
	
	

	/**
	 * deactivateUserRole will unset particular UserRole of UserRole table
	 * 
	 * @param UserRoleid
	 * @return true/false
	 * 
	 */

	public boolean deactiavteUserRole(long UserRoleId) {

		return delete(KEY_USERROLE_TABLE_NAME, KEY_USERROLE_USERROLEMASTERID + "=" + UserRoleId,
				null) > 0;
	}

	/**
	 * update will update UserRole of UserRole table
	 * 
	 * @param userRoleBean
	 * @return resultset
	 * 
	 */

	public int update(UserRoleActionForm userRoleBean) {

		int result = 0;
		ContentValues cValues = new ContentValues();
//		cValues.put(KEY_USERROLE_USERROLEMASTERID, userRoleBean.getUserRolesMasterId());
		cValues.put(KEY_USER_USERROLE_NAME, userRoleBean.getName());
		cValues.put(KEY_USERROLE_USERROLE_DESCRIPTION, userRoleBean.getDescription());
		cValues.put(KEY_USERROLE_USERROLE_CREATEDDTTM,userRoleBean.getCreatedDTTM());
		cValues.put(KEY_USERROLE_CREATEDBY, userRoleBean.getCreatedBY());
		cValues.put(KEY_USERROLE_MODIFIEDBY, userRoleBean.getModifiedBY());
		cValues.put(KEY_USERROLE_USERROLE_MODIFIEDDTTM,userRoleBean.getModifiedDTTM());
		cValues.put(KEY_USERROLE_ISACTIVE, userRoleBean.getIsActive());
		cValues.put(KEY_USERROLE_CREATEDBY, userRoleBean.getCreatedBY());
		cValues.put(KEY_USERROLE_COMPANYMASTERID,userRoleBean.getCompanyMasterId());
	result = update(KEY_USERROLE_TABLE_NAME, cValues, KEY_USERROLE_USERROLEMASTERID + "='"
				+ userRoleBean.getUserRolesMasterId() + "'", null);
		return result;
	}
	
	
	
	public ResultSet getAllActiveUserRoll()
	{
		return query(KEY_USERROLE_TABLE_NAME, null, KEY_USERROLE_ISACTIVE+"= 1", null, null, null,null);		
	}
	public ResultSet getAlldistinctCompany()
	{
		return query(true,KEY_USERROLE_TABLE_NAME,new String[]{KEY_USERROLE_COMPANYMASTERID}, null, null, null, null, null, null);		
	}
	
	// Addition of new method 19-2-2016 - @DISILVA
	public ResultSet getUserRoleByRoleId(int roleid){
		return query(KEY_USERROLE_TABLE_NAME, null, KEY_USERROLE_USERROLEMASTERID+"="+roleid, null, null, null, null);
	}

	public ResultSet getActiveRolesForSpecificCompany(int companyid) throws SQLException{
		String sql = "select * from "+Constants.DBNAME+"."+KEY_USERROLE_TABLE_NAME+" where "+KEY_USERROLE_COMPANYMASTERID+"="+companyid+" and "+KEY_USERROLE_ISACTIVE+"="+Constants.ACTIVE;
		Statement stmt = connection.createStatement();
		return stmt.executeQuery(sql);
	}
}