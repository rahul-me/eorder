package com.bms.neetai.users;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;

/**
 * 
 * @author Mehul Markana
 *Helper class for different operations on the user is created
 *
 */

public class UserDBHelper {
	
	private final String TAG = "com.bms.neetai.users.UesrDBHelper";
	private UserDBAdapter userDBAdapter ;
	private final Logger logger = Logger.getLogger(TAG);
	
	public UserDBHelper() {
		userDBAdapter = new UserDBAdapter();
	}

	public int addUser(UserActionForm userbean)
	{	
		int result = 0;
		
		try {
			userDBAdapter.open();
			result=userDBAdapter.insert(userbean);
			userDBAdapter.close();
		} catch (Exception e) {
			//System.out.println(e);
			logger.error(e);
		}
		return result;
	}
	
	public Boolean updateUser(UserActionForm userbean)
	{	
		Boolean result;
		userDBAdapter.open();
		result = userDBAdapter.updateUserData(userbean);
		userDBAdapter.close();
		return result;
	}
	
	public Boolean deleteUserById(int userId){
		Boolean result;
		userDBAdapter.open();
		result=userDBAdapter.deleteUser(userId);
		userDBAdapter.close();
		return result;
	}
	/**
	 * 
	 * Convert the data in ResultSet into array list
	 * @return
	 */
	public ArrayList <UserActionForm> getAllUsers()
	{   
		userDBAdapter.open();
		ResultSet userResultSet = userDBAdapter.getAll();
		ArrayList <UserActionForm> userbeanlist = new ArrayList <UserActionForm> ();
		if(userResultSet != null ) {
			try 
			{
				userResultSet.beforeFirst();
				while (userResultSet.next()){
					userbeanlist.add(getUserFromResultSet(userResultSet));	
				}
				userResultSet.close();
			} catch (Exception e) {
				//System.out.println(e);
				logger.error(e);
			}
			
		}
//		userResultSet.close();
		userDBAdapter.close();
		return userbeanlist;
	}
	
	
	
		public ArrayList<UserActionForm> fetchAllDistinctCompany(){
		userDBAdapter.open();
		ResultSet cursor=userDBAdapter.getAlldistinctCompany();
		ArrayList<UserActionForm> disticcompanyFormList = new ArrayList<UserActionForm>();
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				while(cursor.next()){
					disticcompanyFormList.add(getUserFromResultSet1(cursor));
				}
				cursor.close();
			}
			catch (Exception e) {
				//System.out.println(e);
				logger.error(e);
			}
			
		}
		userDBAdapter.close();
		return disticcompanyFormList; 
	}

	public UserActionForm getSingleUserByUserId(int id){
		userDBAdapter.open();
		ResultSet userResultSet = userDBAdapter.getUserDataByUserId(id);
		UserActionForm userBean=new UserActionForm();
		if(userResultSet != null ) {
		try {
			userResultSet.beforeFirst();
			while(userResultSet.next())
				userBean=getUserFromResultSet(userResultSet);
			userResultSet.close();
		}catch (Exception e) {
			//System.out.println(e);
			logger.error(e);
		}
		
		}
		userDBAdapter.close();
		return userBean;
	}

	private UserActionForm getUserFromResultSet(ResultSet userResultSet) throws SQLException{
		UserActionForm userbean = new UserActionForm();
		
			
	
		
		userbean.setUserMasterId(userResultSet.getInt(UserDBAdapter.KEY_USERMASTERID));
		userbean.setUserName(userResultSet.getString(UserDBAdapter.KEY_USERNAME));
		userbean.setFirstName(userResultSet.getString(UserDBAdapter.KEY_FIRSTNAME));
		userbean.setLastName(userResultSet.getString(UserDBAdapter.KEY_LASTNAME));
		userbean.setPassword(userResultSet.getString(UserDBAdapter.KEY_PASSWORD));
		userbean.setAddress(userResultSet.getString(UserDBAdapter.KEY_ADDRESS));
		userbean.setPhoneNumber1(userResultSet.getString(UserDBAdapter.KEY_PHONENUMBER1));
		userbean.setUserRoleName(userResultSet.getString(UserDBAdapter.KEY_USERROLE));
		userbean.setModifiedDTTM(userResultSet.getString(UserDBAdapter.KEY_MODIFIEDDTTM));
		userbean.setCreatedDTTM(userResultSet.getString(UserDBAdapter.KEY_CREATEDDTTM));		
		userbean.setCreatedBy(userResultSet.getInt(UserDBAdapter.KEY_CREATEDBY));
		userbean.setModifiedBy(userResultSet.getInt(UserDBAdapter.KEY_MODIFIEDBY));
		userbean.setEmail(userResultSet.getString(UserDBAdapter.KEY_EMAIL));
		userbean.setPhoneNumber2(userResultSet.getString(UserDBAdapter.KEY_PHONENUMBER2));
		userbean.setIsActive(userResultSet.getInt(UserDBAdapter.KEY_ISACTIVE));
		userbean.setUserRolesMasterId(userResultSet.getInt(UserDBAdapter.KEY_USERROLEMASTERID));
		userbean.setCompanyMasterId(userResultSet.getInt(UserDBAdapter.KEY_COMPANYMASTERID));
		userbean.setCity(userResultSet.getString(UserDBAdapter.KEY_CITY));
		userbean.setCountry(userResultSet.getString(UserDBAdapter.KEY_COUNTRY));
		userbean.setState(userResultSet.getString(UserDBAdapter.KEY_STATE));
		userbean.setPincode(userResultSet.getInt(UserDBAdapter.KEY_PINCODE));
		
		//userbean.setSiteId(userResultSet.getInt(UserDBAdapter.KEY_SITE_ID));
		return userbean;
	}
	
	
	private UserActionForm getUserFromResultSet1(ResultSet userResultSet) throws SQLException{
		UserActionForm userbean=new UserActionForm();
		userbean.setCompanyMasterId(userResultSet.getInt(UserDBAdapter.KEY_COMPANYMASTERID));
		return userbean;
	
	}
	
	public String getUerByRole(String role){
		userDBAdapter.open();
		String sendString="";
		ResultSet userCursor =userDBAdapter.getByRole(role);
		UserActionForm userBean=new UserActionForm();
		StringBuffer buf=new StringBuffer();
		try{
		if(userCursor != null ) {
		userCursor.beforeFirst();
		while (userCursor.next()){
			userBean=getUserFromResultSet(userCursor);
			//sendString += userBean.getUid()+","+userBean.getFirstName()+","+userBean.getLastName()+"|";
			buf.append(userBean.getUserMasterId()).append(",").append(userBean.getFirstName()).append(",").append(userBean.getLastName()).append("|");
		}
		sendString=buf.toString();
		}
		userCursor.close();
		}catch (Exception e) {
			//System.out.println(e);
			logger.error(e);
		}
		userDBAdapter.close();
		return sendString;
	}
	public UserActionForm validateUser(UserActionForm userBean){
		
		userDBAdapter.open();
		ResultSet userResultSet = userDBAdapter.validateUser(userBean);
		if(userResultSet != null ) {
			try 
			{
				userResultSet.beforeFirst();
				if(userResultSet.next()){
					userBean = getUserFromResultSet(userResultSet);
					userBean.setUserMasterId(userResultSet.getInt(UserDBAdapter.KEY_UID));
					userBean.setUserRoleName(userResultSet.getString(UserDBAdapter.KEY_ROLE));
					userResultSet.next();
				}
				userResultSet.close();
			} catch (Exception e) {
				//System.out.println(e);
				logger.error(e);
			}
		}
		
		userDBAdapter.close();
		return userBean;
	}
	
	public UserActionForm validateClientUser(String clientString)
	{
		String[] clientData = clientString.split("\\|");
		//logger.error("started validation");
		UserActionForm userBean = new UserActionForm();
		userBean.setUserName(clientData[1]);
		userBean.setPassword(clientData[2]);
		//logger.error("started validation - parameters are " + userBean.getUserName() +  " password = " + userBean.getPassword());
		userDBAdapter.open();
		ResultSet userResultSet = userDBAdapter.validateUser(userBean);
		if(userResultSet != null ) {
			try 
			{
				userResultSet.beforeFirst();
				if(userResultSet.next()){
					userBean = getUserFromResultSet(userResultSet);
				}
				userResultSet.close();
			}catch (Exception e) {
				//System.out.println(e);
				logger.error(e);
			}
		}
		
		userDBAdapter.close();

		return userBean;
	}
	public ArrayList<UserActionForm> getAllUsersByFilter(HashMap<String , String > filterMap) {
		Set<String> keySet = filterMap.keySet();
		Iterator<String > keySetIterator= keySet.iterator();
		String whereClause="";
		while(keySetIterator.hasNext())
		{
			String tempKey = keySetIterator.next();
			if(!tempKey.equalsIgnoreCase("creationDTTM")){
					whereClause += " " + tempKey + " in("+  filterMap.get(tempKey)   + ") "; 
					System.out.println("mm1" +filterMap.get(tempKey));
					if (keySetIterator.hasNext()) {
						whereClause += " AND ";
					}
				}
			else
			{
				whereClause += " STR_TO_DATE(" + tempKey + ",'%d/%m/%Y') between "+  filterMap.get(tempKey)   + " ";
			}
		}
		System.out.println("Query "+whereClause);
		userDBAdapter.open();
		ResultSet cursor = userDBAdapter.getAllByFilter(whereClause);
		ArrayList<UserActionForm> userActionForms = new ArrayList<UserActionForm>();
		if (cursor != null) {
			try {
				cursor.beforeFirst();
				while (cursor.next()) {
					userActionForms.add(getUserFromResultSet(cursor));
				}
				cursor.close();
			} catch (Exception e) {
				logger.error(e);
			}
		}
		userDBAdapter.close();
		return userActionForms;
	}
	public ArrayList<UserActionForm> fetchAllActiveUser(){
		userDBAdapter.open();
		ResultSet cursor=userDBAdapter.getAllActiveUser();
		ArrayList<UserActionForm> itemcatBeanList = new ArrayList<UserActionForm>();
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				while(cursor.next()){
					itemcatBeanList.add(getUserFromResultSet(cursor));
				}
				cursor.close();
			}
			catch (Exception e) {
				//System.out.println(e);
				logger.error(e);
			}
			
		}
		userDBAdapter.close();
		return itemcatBeanList; 
	}

	public ArrayList<UserActionForm> userByCompanyId(int companyid){
		System.out.println("pj");
			userDBAdapter.open();
			ResultSet cursor=userDBAdapter.getUserByCompanyId(companyid);
			ArrayList<UserActionForm> userBean=new ArrayList<UserActionForm>();
			if(cursor!=null){
				try
				{
					cursor.beforeFirst();
					while(cursor.next()){
						userBean.add(getUserFromResultSet(cursor));
					}
					cursor.close();
				}
				catch(Exception e)
				{
					logger.error(e);
				}
			}
				userDBAdapter.close();
				return userBean;
				
			}
	public ArrayList<UserActionForm>getUserByCompanyIdAndRollId(int companyid,int userRollId){
		System.out.println("alpesh");
		userDBAdapter.open();
		ResultSet cursor=userDBAdapter.getUserByCompanyIdAndRollId(companyid,userRollId);
		ArrayList<UserActionForm> userBean=new ArrayList<UserActionForm>();
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				while(cursor.next()){
					userBean.add(getUserFromResultSet(cursor));
				}
				cursor.close();
			}
			catch(Exception e)
			{
				logger.error(e);
			}
		}
			userDBAdapter.close();
			return userBean;
			
		}
	
	public ArrayList<UserActionForm> getActiveUsersForSpecificCompany(int companyid) throws SQLException{
		userDBAdapter.open();
		ArrayList<UserActionForm> list = new ArrayList<UserActionForm>();
		if(userDBAdapter.getActiveUsersForSpecificCompany(companyid).next()){
			ResultSet rs = userDBAdapter.getActiveUsersForSpecificCompany(companyid);
			while(rs.next()){
				list.add(getUserFromResultSet(rs));
			}
		}
		userDBAdapter.close();
		return list;
	}
}

