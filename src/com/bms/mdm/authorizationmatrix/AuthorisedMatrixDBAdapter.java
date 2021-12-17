package com.bms.mdm.authorizationmatrix;

import java.sql.ResultSet;

import org.apache.log4j.Logger;

import com.bms.db.ContentValues;
import com.bms.db.RestoserverDBAdapter;





/**
 * AuthorisedMatrixDBAdapter manages the UserAuthorizationMatrix table in the database. Responsible for 
 * all CRUD operations on the UserAuthorizationMatrix table.
 * @author Jemis Dhameliya
 *
 */

public class AuthorisedMatrixDBAdapter extends RestoserverDBAdapter{

private final String TAG = "com.scm.authorizationmatrix.AuthorisedMatrixDBAdapter";
	
	private final Logger log = Logger.getLogger(TAG);
	
	public static final String USER_AUTHORIZATION_MATRIX="mdm_userauthorizationmatrix";

	public static final String COLUMN_USER_AUTHORIZATION_MATRIX_ID="authMatrixId";
	public static final String COLUMN_USER_AUTHORIZATION_MATRIX_AUTH_ROLE_ID="RoleId";
	public static final String COLUMN_USER_AUTHORIZATION_MATRIX_AUTH_MODULE_KEY="modulekey";
	public static final String COLUMN_USER_AUTHORIZATION_MATRIX_COMPANY_ID="companyId";
	public static final String COLUMN_USER_AUTHORIZATION_MATRIX_MAPPING_STATUS = "mappingStatus";
	public static final String COLUMN_USER_AUTHORIZATION_MATRIX_CREATEDBY= "createdBY";
	public static final String COLUMN_USER_AUTHORIZATION_MATRIX_CREATEDDTTM= "createdDTTM";
	public static final String COLUMN_USER_AUTHORIZATION_MATRIX_OF= "authMatrix_of";
	 public AuthorisedMatrixDBAdapter() {
		 super();
	}

	 
	 /**
		 * Insert AuthorisedMatrix will insert data in to UserAuthorizationMatrix table 
         *
		 * @param authorizationMatBean 
		 * @return cVAlue object if succes 
		 */
         
		public int insertAuthorisedMatrix(AuthorisedMatrixActionForm authorizationMatBean)
		
		{	
			ContentValues cValues = new ContentValues();
			cValues.put(COLUMN_USER_AUTHORIZATION_MATRIX_AUTH_ROLE_ID, authorizationMatBean.getRoleId());
			cValues.put(COLUMN_USER_AUTHORIZATION_MATRIX_AUTH_MODULE_KEY, authorizationMatBean.getModulekey());
			cValues.put(COLUMN_USER_AUTHORIZATION_MATRIX_COMPANY_ID, authorizationMatBean.getCompanyId());
			cValues.put(COLUMN_USER_AUTHORIZATION_MATRIX_MAPPING_STATUS, authorizationMatBean.getMappingStatus());
			cValues.put(COLUMN_USER_AUTHORIZATION_MATRIX_CREATEDBY, authorizationMatBean.getCreatedBY());
			cValues.put(COLUMN_USER_AUTHORIZATION_MATRIX_CREATEDDTTM, authorizationMatBean.getCreatedDTTM());
			
			cValues.put(COLUMN_USER_AUTHORIZATION_MATRIX_OF, authorizationMatBean.getAuthMatrixOf());
			return (int)insert(USER_AUTHORIZATION_MATRIX, null, cValues);
			
		}
	 
		/**
		 * get All Method will return all record of UserAuthorizationMatrix table
		 * 
		 * 
		 */
		
		public ResultSet getAll()
		{
			return query(USER_AUTHORIZATION_MATRIX, new String[] {COLUMN_USER_AUTHORIZATION_MATRIX_ID, 
					COLUMN_USER_AUTHORIZATION_MATRIX_AUTH_ROLE_ID, COLUMN_USER_AUTHORIZATION_MATRIX_AUTH_MODULE_KEY,
					COLUMN_USER_AUTHORIZATION_MATRIX_COMPANY_ID,COLUMN_USER_AUTHORIZATION_MATRIX_MAPPING_STATUS , COLUMN_USER_AUTHORIZATION_MATRIX_CREATEDBY,
					COLUMN_USER_AUTHORIZATION_MATRIX_CREATEDDTTM,
					COLUMN_USER_AUTHORIZATION_MATRIX_OF}, null, null, null, null, null);		
	
		}


		/**
		 * get All Method will return all record of UserAuthorizationMatrix table by Role ID
		 * 
		 * 
		 */
		
		public ResultSet getAllByRoleId(int roleId)
		{
			return query(USER_AUTHORIZATION_MATRIX, new String[] {COLUMN_USER_AUTHORIZATION_MATRIX_ID, 
					COLUMN_USER_AUTHORIZATION_MATRIX_AUTH_ROLE_ID, COLUMN_USER_AUTHORIZATION_MATRIX_AUTH_MODULE_KEY,
					COLUMN_USER_AUTHORIZATION_MATRIX_COMPANY_ID,COLUMN_USER_AUTHORIZATION_MATRIX_MAPPING_STATUS , COLUMN_USER_AUTHORIZATION_MATRIX_CREATEDBY,
					COLUMN_USER_AUTHORIZATION_MATRIX_CREATEDDTTM,COLUMN_USER_AUTHORIZATION_MATRIX_OF}, COLUMN_USER_AUTHORIZATION_MATRIX_AUTH_ROLE_ID  + " = " + roleId, null, null, null, null);		
	
		}


		/**
		 * getByAuthorizationMatrixId  will return single record of UserAuthorizationMatrix table
		 * 
		 * @param authorizationMatrixId
		 * @return resultset
		 * 
		 */
		
		public ResultSet getByauthorizationMatrixId(int authorizationMatrixId)
		{
			return query(USER_AUTHORIZATION_MATRIX, new String[] {COLUMN_USER_AUTHORIZATION_MATRIX_ID, 
					COLUMN_USER_AUTHORIZATION_MATRIX_AUTH_ROLE_ID, COLUMN_USER_AUTHORIZATION_MATRIX_AUTH_MODULE_KEY,
					COLUMN_USER_AUTHORIZATION_MATRIX_COMPANY_ID,COLUMN_USER_AUTHORIZATION_MATRIX_MAPPING_STATUS , COLUMN_USER_AUTHORIZATION_MATRIX_CREATEDBY,
					COLUMN_USER_AUTHORIZATION_MATRIX_CREATEDDTTM,COLUMN_USER_AUTHORIZATION_MATRIX_OF}, COLUMN_USER_AUTHORIZATION_MATRIX_ID+ "=" + authorizationMatrixId, null, null, null, null);
		}
		
	
		/**
		 * DeactivateUserAuthorizationMatrix  will unset particular UserAuthorizationMatrix of UserAuthorizationMatrix table
		 * 
		 * @param authorizationMatrixId
		 * @return true/false
		 * 
		 */
			
	
		public boolean deactiavteAuthorisationMatrix(long authorizationMatrixId) {

			return delete(USER_AUTHORIZATION_MATRIX, COLUMN_USER_AUTHORIZATION_MATRIX_ID+ "=" + authorizationMatrixId, null) > 0;
		}



		/**
		 * 
		 * @param roleId
		 * @return
		 */
		public boolean deactiavteAuthorisationMatrixByRoleId(int roleId,int companyId,int authMatrixOf) {

			return delete(USER_AUTHORIZATION_MATRIX, COLUMN_USER_AUTHORIZATION_MATRIX_AUTH_ROLE_ID+ "=" + roleId+" and "+COLUMN_USER_AUTHORIZATION_MATRIX_COMPANY_ID+ "="+companyId+" and "+COLUMN_USER_AUTHORIZATION_MATRIX_OF+ "="+authMatrixOf, null) > 0;
		}


		/**
		 *update will update UserAuthorizationMatrix of UserAuthorizationMatrix table
		 * 
		 * @param authorizationMatBean
		 * @return resultset
		 * 
		 */
			
		
		public int update(AuthorisedMatrixActionForm authorizationMatBean ){

			int result = 0;
			ContentValues cv=new ContentValues();
			cv.put(COLUMN_USER_AUTHORIZATION_MATRIX_AUTH_MODULE_KEY, authorizationMatBean.getModulekey());
			cv.put(COLUMN_USER_AUTHORIZATION_MATRIX_COMPANY_ID, authorizationMatBean.getCompanyId());
			
			result = update(USER_AUTHORIZATION_MATRIX, cv, COLUMN_USER_AUTHORIZATION_MATRIX_ID + "='" + authorizationMatBean.getAuthMatrixId() +"'", null);
			return result;
		}
		
	

}
