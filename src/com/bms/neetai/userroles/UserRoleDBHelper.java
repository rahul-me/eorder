package com.bms.neetai.userroles;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.bms.neetai.userroles.UserRoleActionForm;
import com.bms.neetai.userroles.UserRoleDBAdapter;
import com.bms.neetai.users.UserActionForm;
import com.bms.neetai.users.UserDBAdapter;


/**
 * UserRoleDBHelper manages the usreroletable in the database. Responsible for all
 * bussiness operations on the userrole table.
 * 
 * @author parth gandhi
 * 
 */

public class UserRoleDBHelper {

	private static final String TAG = "com.bms.neetai.userroles.UserRoleDBAdapter";
	private Logger logger = Logger.getLogger(TAG);
	private UserRoleDBAdapter userRoleDBAdapter  ;

	public UserRoleDBHelper() {
		userRoleDBAdapter = new UserRoleDBAdapter();
	}

	public ArrayList<UserRoleActionForm> fetchAllRecords() {
		userRoleDBAdapter.open();
		ResultSet cursor = userRoleDBAdapter.getAll();
		ArrayList<UserRoleActionForm> userRoleBeanList = new ArrayList<UserRoleActionForm>();
		
		if (cursor != null) {
			try {
				cursor.beforeFirst();
				while (cursor.next()) {
					userRoleBeanList.add(fetchDataFromResultSet(cursor));
				}
				cursor.close();
			} catch (Exception e) {
				// System.out.println(e);
				logger.error(e);
			}

		}
		userRoleDBAdapter.close();
		return userRoleBeanList;
	}

	public UserRoleActionForm getUserByUserId(int UserRoleId) {
		userRoleDBAdapter.open();
		ResultSet cursor = userRoleDBAdapter.getByUserRoleId(UserRoleId);
		UserRoleActionForm userRoleBean = null;
		if (cursor != null) {
			try {
				cursor.beforeFirst();
				if (cursor.next()) {
					userRoleBean = fetchDataFromResultSet(cursor);
				}
				cursor.close();
			} catch (Exception e) {
				logger.error(e);
			}
		}
		userRoleDBAdapter.close();
		return userRoleBean;
	} 
		
	
	
	public ArrayList<UserRoleActionForm> getUserRollByCompanyId(int CompanyId) {
		userRoleDBAdapter.open();
		ResultSet cursor = userRoleDBAdapter.getUserRollByCompanyId(CompanyId);
		ArrayList<UserRoleActionForm> userRoleBeanList = new ArrayList<UserRoleActionForm>();
		
		if (cursor != null) {
			try {
				cursor.beforeFirst();
				while (cursor.next()) {
					userRoleBeanList.add(fetchDataFromResultSet(cursor));
				}
				cursor.close();
			} catch (Exception e) {
				// System.out.println(e);
				logger.error(e);
			}

		}
		userRoleDBAdapter.close();
		return userRoleBeanList;
	}
	
	public int addUser(UserRoleActionForm userRoleBean) {
		userRoleDBAdapter.open();
		int status = userRoleDBAdapter.insertUserRole(userRoleBean);
		userRoleDBAdapter.close();

		return status;
	}

	public boolean deleteUserRole(int userRoleId) {
		userRoleDBAdapter.open();
		boolean status = userRoleDBAdapter.deactiavteUserRole(userRoleId);
		userRoleDBAdapter.close();
		return status;
	}

	public int updateUserRole(UserRoleActionForm userRoleBean) {
		userRoleDBAdapter.open();
		int result = userRoleDBAdapter.update(userRoleBean);
		userRoleDBAdapter.close();
		return result;
	}

	private UserRoleActionForm fetchDataFromResultSet(ResultSet cursor) {
		UserRoleActionForm userRoleBean = new UserRoleActionForm();
		try {

			userRoleBean.setUserRolesMasterId(cursor.getInt(UserRoleDBAdapter.KEY_USERROLE_USERROLEMASTERID));
			userRoleBean.setName(cursor.getString(UserRoleDBAdapter.KEY_USER_USERROLE_NAME));
			userRoleBean.setDescription(cursor.getString(UserRoleDBAdapter.KEY_USERROLE_USERROLE_DESCRIPTION));
			userRoleBean.setCreatedDTTM(cursor.getString(UserRoleDBAdapter.KEY_USERROLE_USERROLE_CREATEDDTTM));
			userRoleBean.setCreatedBY(cursor.getInt(UserRoleDBAdapter.KEY_USERROLE_CREATEDBY));
			userRoleBean.setModifiedBY(cursor.getInt(UserRoleDBAdapter.KEY_USERROLE_MODIFIEDBY));
			userRoleBean.setModifiedDTTM(cursor.getString(UserRoleDBAdapter.KEY_USERROLE_USERROLE_MODIFIEDDTTM));
			userRoleBean.setIsActive(cursor.getInt(UserRoleDBAdapter.KEY_USERROLE_ISACTIVE));
			userRoleBean.setCompanyMasterId(cursor.getInt(UserRoleDBAdapter.KEY_USERROLE_COMPANYMASTERID));

		} catch (Exception e) {
			logger.error(e);
		}
		return userRoleBean;
	}
	public ArrayList<UserRoleActionForm> fetchAllActiveuserRoll(){
		userRoleDBAdapter.open();
		ResultSet cursor=userRoleDBAdapter.getAllActiveUserRoll();
		ArrayList<UserRoleActionForm> userrollBeanList = new ArrayList<UserRoleActionForm>();
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				while(cursor.next()){
					userrollBeanList.add(fetchDataFromResultSet(cursor));
				}
				cursor.close();
			}
			catch (Exception e) {
				//System.out.println(e);
				logger.error(e);
			}
			
		}
		userRoleDBAdapter.close();
		return userrollBeanList; 
	}

	private UserRoleActionForm getCompanyFromResultSet(ResultSet userResultSet) throws SQLException{
		UserRoleActionForm userrollbean=new UserRoleActionForm();
		userrollbean.setCompanyMasterId(userResultSet.getInt(UserRoleDBAdapter.KEY_USERROLE_COMPANYMASTERID));
		return userrollbean;
	
	}
	
	public ArrayList<UserRoleActionForm> fetchAllDistinctCompany(){
		userRoleDBAdapter.open();
		ResultSet cursor=userRoleDBAdapter.getAlldistinctCompany();
		ArrayList<UserRoleActionForm> disticcompany = new ArrayList<UserRoleActionForm>();
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				while(cursor.next()){
					disticcompany.add(getCompanyFromResultSet(cursor));
					System.out.println("parth");
				}
				cursor.close();
			}
			catch (Exception e) {
				//System.out.println(e);
				logger.error(e);
			}
			
		}
		userRoleDBAdapter.close();
		return disticcompany; 
	}
	
	// 19-2-2016 - @DISILVA
	
	public UserRoleActionForm getUserRoleByRoleId(int roleid){
		userRoleDBAdapter.open();
		ResultSet rs = userRoleDBAdapter.getUserRoleByRoleId(roleid);
		UserRoleActionForm roleBean = null;
		try{
			while(rs.next())
				roleBean = fetchDataFromResultSet(rs);
		}catch(SQLException e){
			System.out.println(e);			
		}
		userRoleDBAdapter.close();
		return roleBean;
		
	}
	
	public ArrayList<UserRoleActionForm> getActiveRolesForSpecificCompany(int companyid) throws SQLException{
		userRoleDBAdapter.open();
		ArrayList<UserRoleActionForm> list = new ArrayList<UserRoleActionForm>();
		if(userRoleDBAdapter.getActiveRolesForSpecificCompany(companyid).next()){
			ResultSet rs = userRoleDBAdapter.getActiveRolesForSpecificCompany(companyid);
			while(rs.next()){
				list.add(fetchDataFromResultSet(rs));
			}
		}
		userRoleDBAdapter.close();
		return list;
	}
	
}
