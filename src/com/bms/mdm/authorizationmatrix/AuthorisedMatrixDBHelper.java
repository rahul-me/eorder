package com.bms.mdm.authorizationmatrix;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;



/**
 * AuthorisedMatrixDBHelper manages the AuthorisedMatrixDBAdapter Responsible for 
 * all business operations on the UserAuthorizationMatrix table.
 * @author Jemis Dhameliya
 *
 */

public class AuthorisedMatrixDBHelper {

	
	private static final String TAG= "com.scm.authorizationmatrix.AuthorisedMatrixDBHelper";
	private Logger logger = Logger.getLogger(TAG);
	private AuthorisedMatrixDBAdapter authorisedMatDBAdapter;
	public AuthorisedMatrixDBHelper() {
		authorisedMatDBAdapter=new AuthorisedMatrixDBAdapter();
	}
	
	//
	
	public ArrayList<AuthorisedMatrixActionForm> fetchAllRecords(){
		authorisedMatDBAdapter.open();
		ResultSet cursor=authorisedMatDBAdapter.getAll();
		ArrayList<AuthorisedMatrixActionForm> authorisationMatBeanList = new ArrayList<AuthorisedMatrixActionForm>();;
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				while(cursor.next()){
					authorisationMatBeanList.add(fetchDataFromResultSet(cursor));
				}
				cursor.close();
			}
			catch (Exception e) {
				logger.error(e);
			}
			
		}
		authorisedMatDBAdapter.close();
		return authorisationMatBeanList; 
	}
	
	

	public ArrayList<AuthorisedMatrixActionForm> fetchAllRecordsByRoleId(int roleId){
		authorisedMatDBAdapter.open();
		ResultSet cursor=authorisedMatDBAdapter.getAllByRoleId(roleId);
		ArrayList<AuthorisedMatrixActionForm> authorisationMatBeanList = new ArrayList<AuthorisedMatrixActionForm>();;
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				while(cursor.next()){
					authorisationMatBeanList.add(fetchDataFromResultSet(cursor));
				}
				cursor.close();
			}
			catch (Exception e) {
				logger.error(e);
			}
			
		}
		authorisedMatDBAdapter.close();
		return authorisationMatBeanList; 
	}
	
	

	public AuthorisedMatrixActionForm getAuthorisedMatrixById(int authorisedMatrixId){
		authorisedMatDBAdapter.open();
		ResultSet cursor=authorisedMatDBAdapter.getByauthorizationMatrixId(authorisedMatrixId);
		AuthorisedMatrixActionForm authorisationMatBean = null;
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				if(cursor.next()){
					authorisationMatBean = fetchDataFromResultSet(cursor);
				}
				cursor.close();
			}
			catch (Exception e) {
				logger.error(e);
			}
		}
		authorisedMatDBAdapter.close();
		return authorisationMatBean;
	}
	
	
	
	public void addAuthorisationMatrixList(AuthorisedMatrixActionForm authorisationMatBean, List < String> controlList)
	{   
		authorisedMatDBAdapter.open();
		Iterator< String> controlIterator = controlList.iterator(); 
		while(controlIterator.hasNext())
		{
		  String moduleKey = controlIterator.next();
		  authorisationMatBean.setModulekey(moduleKey);
		  authorisedMatDBAdapter.insertAuthorisedMatrix(authorisationMatBean);
		  
		}
		authorisedMatDBAdapter.close();
		
		
	}
	
	
	public int addAuthorisationMatrix(AuthorisedMatrixActionForm authorisationMatBean)
	{   
		authorisedMatDBAdapter.open();
		int status = authorisedMatDBAdapter.insertAuthorisedMatrix(authorisationMatBean);
		authorisedMatDBAdapter.close();
		
		return status;
	}
	
	
	public boolean deleteAuthorisationMatrixById(int authorisedMatrixId)
	{
         authorisedMatDBAdapter.open();
		boolean status = authorisedMatDBAdapter.deactiavteAuthorisationMatrix(authorisedMatrixId);
		authorisedMatDBAdapter.close();
		return status;
	}
	

	public boolean deleteAuthorisationMatrixByRoleID(int roleId,int companyId,int authMatrixOf)
	{
         authorisedMatDBAdapter.open();
		boolean status = authorisedMatDBAdapter.deactiavteAuthorisationMatrixByRoleId(roleId,companyId,authMatrixOf);
		authorisedMatDBAdapter.close();
		return status;
	}
	

	
	
	
	public int updateAuthorisationMatrix(AuthorisedMatrixActionForm authorisationMatBean){
		authorisedMatDBAdapter.open();
		int result = authorisedMatDBAdapter.update(authorisationMatBean);
		authorisedMatDBAdapter.close();
		return result;
	}
	
	
	private AuthorisedMatrixActionForm fetchDataFromResultSet(ResultSet cursor){ 
		AuthorisedMatrixActionForm authorisationMatBean=new AuthorisedMatrixActionForm();
		try
		{
			authorisationMatBean.setAuthMatrixId(cursor.getInt(AuthorisedMatrixDBAdapter.COLUMN_USER_AUTHORIZATION_MATRIX_ID));
			authorisationMatBean.setRoleId(cursor.getInt(AuthorisedMatrixDBAdapter.COLUMN_USER_AUTHORIZATION_MATRIX_AUTH_ROLE_ID));
			authorisationMatBean.setModulekey(cursor.getString(AuthorisedMatrixDBAdapter.COLUMN_USER_AUTHORIZATION_MATRIX_AUTH_MODULE_KEY));
			authorisationMatBean.setCompanyId(cursor.getInt(AuthorisedMatrixDBAdapter.COLUMN_USER_AUTHORIZATION_MATRIX_COMPANY_ID));			
			authorisationMatBean.setMappingStatus(cursor.getInt(AuthorisedMatrixDBAdapter.COLUMN_USER_AUTHORIZATION_MATRIX_MAPPING_STATUS));
			authorisationMatBean.setCreatedBY(cursor.getInt(AuthorisedMatrixDBAdapter.COLUMN_USER_AUTHORIZATION_MATRIX_CREATEDBY));
			authorisationMatBean.setCreatedDTTM(cursor.getString(AuthorisedMatrixDBAdapter.COLUMN_USER_AUTHORIZATION_MATRIX_CREATEDDTTM));
			authorisationMatBean.setAuthMatrixOf(cursor.getInt(AuthorisedMatrixDBAdapter.COLUMN_USER_AUTHORIZATION_MATRIX_OF));
		}
		catch(Exception e)
		{
			logger.error(e);
		}
		return authorisationMatBean;
	}
	

	
}
