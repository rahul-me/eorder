package com.bms.neetai.users;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bms.constants.Constants;
import com.bms.db.ContentValues;

/**
 * 
 * @author Mehul Markana
 *This class is responsible to create the table for different users.
 * The name of the table is userTable in database Restaurant.
 */

public class UserDBAdapter extends com.bms.db.RestoserverDBAdapter{
	private static final String TAG = "com.bms.neetai.users.UserDBAdapter";
	
	public static final String USER_TABLE_NAME="neetai_users";
	    
	
	public static final String KEY_USERMASTERID = "userMasterId";
	public static final String KEY_USERNAME = "userName";
	public static final String KEY_PASSWORD = "password";
	public static final String KEY_FIRSTNAME = "firstName";
	public static final String KEY_LASTNAME = "lastName";
	public static final String KEY_PHONENUMBER1 = "phoneNumber1";
	public static final String KEY_ADDRESS = "address";
	public static final String KEY_USERROLE = "userRoleName";
	public static final String KEY_ISACTIVE = "isActive";
	public static final String KEY_CREATEDDTTM = "createdDTTM";
	public static final String KEY_MODIFIEDDTTM = "modifiedDTTM";
	public static final String KEY_CREATEDBY = "createdBy";
	public static final String KEY_MODIFIEDBY = "modifiedBy";
	public static final String KEY_EMAIL = "email";
	public static final String KEY_PHONENUMBER2 = "phoneNumber2";
	public static final String KEY_USERROLEMASTERID = "userRoleMasterId";
	public static final String KEY_COMPANYMASTERID = "companyMasterId";
	public static final String KEY_USERCODE = "userCode";
	public static final String KEY_CITY = "city";
	public static final String KEY_STATE = "state";
	public static final String KEY_COUNTRY = "country";
	public static final String KEY_PINCODE = "pincode";
	


	
	public UserDBAdapter() {
		super();
	}


	 public int insert(UserActionForm userbean) throws SQLException{
		 ContentValues cv=new ContentValues();
		 
		 
			
		 long result;
		 cv.put(KEY_USERMASTERID,userbean.getUserMasterId());
		 cv.put(KEY_PASSWORD, userbean.getPassword());
		 cv.put(KEY_FIRSTNAME, userbean.getFirstName());
		 cv.put(KEY_LASTNAME, userbean.getLastName());
		 cv.put(KEY_PHONENUMBER1,userbean.getPhoneNumber1());
		 cv.put(KEY_ADDRESS,userbean.getAddress());
		 cv.put(KEY_USERROLE,userbean.getUserRoleName());
		 cv.put(KEY_CREATIONDTTM,userbean.getCreatedDTTM());
		 cv.put(KEY_LASTLOGINDTTM,userbean.getModifiedDTTM());
		 cv.put(KEY_CREATEDBY,userbean.getCreatedBy());
		 cv.put(KEY_MODIFIEDBY,userbean.getModifiedBy());
		 cv.put(KEY_EMAIL,userbean.getEmail());
		// cv.put(KEY_PHONENUMBER2,userbean.getPhoneNumber2());
		 cv.put(KEY_ISACTIVE,userbean.getIsActive());
		 cv.put(KEY_USERROLEMASTERID,userbean.getUserRolesMasterId());
		 cv.put(KEY_COMPANYID,userbean.getCompanyMasterId());
		 cv.put(KEY_USERNAME,userbean.getUserName());
		 cv.put(KEY_USERCODE, userbean.getUserCode());
		 cv.put(KEY_STATE, userbean.getState());
		 cv.put(KEY_CITY, userbean.getCity());
		 cv.put(KEY_COUNTRY, userbean.getCountry());
		 cv.put(KEY_PINCODE, userbean.getPincode());
		 //cv.put(KEY_SITE_ID,userbean.getSiteId());
		 result= insert(USER_TABLE_NAME, null, cv);
		 return (int) result;
	 }

	 public ResultSet getAll(){
		 ResultSet ResultSet = query(USER_TABLE_NAME,null,null, null, null, null, null);
		 return ResultSet;
	 }

	 /**
	  * 
	  * @param userbean
	  * This method is used to get the user data based on its UID
	  * @return
	  */
	 public ResultSet getUserDataByUserId(int id){
		 ResultSet ResultSet = query(USER_TABLE_NAME,null,KEY_USERMASTERID+ "=" + "'" + id +"'", null, null, null, null);
		 return ResultSet;
	 }

	 public ResultSet getUserName(String username){
		 ResultSet ResultSet = query(USER_TABLE_NAME,null,KEY_USERNAME+ "=" + "'" + username + "'", null, null, null, null);
		 return ResultSet;
	 }
	
	 public ResultSet getByRole(String role){
		 ResultSet cursor = query(USER_TABLE_NAME,null,KEY_ROLE+ "=" + "'" + role +"'", null, null, null, null);
		 return cursor;
	 }

	/**
		 * getAllByFilter will return records by filter
		 * 
		 * @param filter(createdDate,SiteId list)
		 * 
		 */
		public ResultSet getAllByFilter(String Filter) {
			return query(USER_TABLE_NAME, null, Filter, null, null, null,
					null);
		}
	 /**
	  * 
	  * @param userbean
	  * THe method below is used to update the details of the the user
	  * @return
	  */
	 public boolean updateUserData(UserActionForm userbean){
		 ContentValues cv = new ContentValues();
		 cv.put(KEY_USERMASTERID,userbean.getUserMasterId());
		 cv.put(KEY_PASSWORD, userbean.getPassword());
		 cv.put(KEY_FIRSTNAME, userbean.getFirstName());
		 cv.put(KEY_LASTNAME, userbean.getLastName());
		 cv.put(KEY_PHONENUMBER1,userbean.getPhoneNumber1());
		 cv.put(KEY_ADDRESS,userbean.getAddress());
		 cv.put(KEY_USERROLE,userbean.getUserRoleName());
		 cv.put(KEY_CREATIONDTTM,userbean.getCreatedDTTM());
		 cv.put(KEY_LASTLOGINDTTM,userbean.getModifiedDTTM());
		 cv.put(KEY_CREATEDBY,userbean.getCreatedBy());
		 cv.put(KEY_MODIFIEDBY,userbean.getModifiedBy());
		 cv.put(KEY_EMAIL,userbean.getEmail());
		 cv.put(KEY_PHONENUMBER2,userbean.getPhoneNumber2());
		 cv.put(KEY_ISACTIVE,userbean.getIsActive());
		 cv.put(KEY_USERROLEMASTERID,userbean.getUserRolesMasterId());
		 cv.put(KEY_COMPANYID,userbean.getCompanyMasterId());
		 cv.put(KEY_USERNAME,userbean.getUserName());
		 cv.put(KEY_USERCODE, userbean.getUserCode());
		 cv.put(KEY_STATE, userbean.getState());
		 cv.put(KEY_CITY, userbean.getCity());
		 cv.put(KEY_COUNTRY, userbean.getCountry());
		 cv.put(KEY_PINCODE, userbean.getPincode());
		//cv.put(KEY_SITE_ID,userbean.getSiteId());
		 return update(USER_TABLE_NAME,cv, KEY_UID + "=" + "'" + userbean.getUserMasterId() + "'", null) > 0;
	 }

	 public boolean deleteUser(int userId){
		 return delete(USER_TABLE_NAME, KEY_UID + "="  + userId  , null) > 0;
	 }

	 public ResultSet validateUser(UserActionForm userBean){
		 ResultSet resultSet = query(USER_TABLE_NAME,null,"binary " + KEY_USERNAME + "=" + "'" + userBean.getUserName() + "' AND binary "+KEY_PASSWORD + " = '" + userBean.getPassword()+"' AND "+KEY_ISACTIVE+"="+Constants.ACTIVE, null, null, null, null);
		 //ResultSet ResultSet = rawQuery("select * from "+USER_TABLE_NAME+" where userName=? AND password=? ", new String[]{userBean.getUserName(),userBean.getPassword()});
		 return resultSet;
		
	 }
	 public ResultSet getAllActiveUser()
		{
			return query(USER_TABLE_NAME, null, KEY_ISACTIVE+"= 1", null, null, null,null);		
		}
	public ResultSet getUserByCompanyId(int companyid)
	{
		ResultSet resultSet = query(USER_TABLE_NAME,null,KEY_COMPANYMASTERID+ "=" + "'" + companyid +"'", null, null, null, null);
		 return resultSet;
		
	}
	

	public ResultSet getUserByCompanyIdAndRollId(int companyid,int userRollId)
	{
		ResultSet resultSet = query(USER_TABLE_NAME,null,KEY_COMPANYMASTERID+ "=" + "'" + companyid +"' AND "+KEY_USERROLEMASTERID+ "=" + "'" + userRollId +"'", null, null, null, null);
		 return resultSet;
		
	}
	
	
	public ResultSet getAlldistinctCompany()
		{
			return query(true,USER_TABLE_NAME,new String[]{KEY_COMPANYMASTERID}, null, null, null, null, null, null);		
		}
	 
	public ResultSet getActiveUsersForSpecificCompany(int companyid) throws SQLException{
		String sql ="select * from "+Constants.DBNAME+"."+USER_TABLE_NAME+" where "+KEY_COMPANYMASTERID+"="+companyid+" and "+KEY_ISACTIVE+"="+Constants.ACTIVE;
		Statement stmt = connection.createStatement();
		return stmt.executeQuery(sql);
	}
	 
}
