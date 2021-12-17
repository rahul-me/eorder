package com.bms.neetai.company;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;

import com.bms.neetai.users.UserActionForm;



/**
 * 
 * @author Mehul Markana
 *Helper class for different operations on the user is created
 *
 */

public class CompanyDBHelper {
	
	private final String TAG = "com.bms.neetai.company.CompanyDBHelper";
	private CompanyDBAdapter companyDBAdapter ;
	private final Logger logger = Logger.getLogger(TAG);
	
	public CompanyDBHelper() {
		companyDBAdapter = new CompanyDBAdapter();
	}

	public int addCompany(CompanyActionForm companybean)
	{	
		int result = 0;
		
		try {
			companyDBAdapter.open();
			result=companyDBAdapter.insert(companybean);
			companyDBAdapter.close();
		} catch (Exception e) {
			//System.out.println(e);
			logger.error(e);
		}
		return result;
	}
	
	public Boolean updateCompany(CompanyActionForm companybean)
	{	
		Boolean result;
		companyDBAdapter.open();
		result = companyDBAdapter.updateCompanyData(companybean);
		companyDBAdapter.close();
		return result;
	}
	
	public Boolean deleteCompanyById(int userId){
		Boolean result;
		companyDBAdapter.open();
		result=companyDBAdapter.deleteUser(userId);
		companyDBAdapter.close();
		return result;
	}
	/**
	 * 
	 * Convert the data in ResultSet into array list
	 * @return
	 */
	public ArrayList <CompanyActionForm> getAllCompany()
	{   
		companyDBAdapter.open();
		ResultSet companyResultSet = companyDBAdapter.getAll();
		ArrayList <CompanyActionForm> companybeanlist = new ArrayList <CompanyActionForm> ();
		if(companyResultSet != null ) {
			try 
			{
				companyResultSet.beforeFirst();
				while (companyResultSet.next()){
					companybeanlist.add(fetchDataResultSet(companyResultSet));	
				}
				companyResultSet.close();
			} catch (Exception e) {
				//System.out.println(e);
				logger.error(e);
			}
			
		}
//		companyResultSet.close();
		companyDBAdapter.close();
		return companybeanlist;
	}

	public CompanyActionForm getSingleUserByUserId(int id){
		companyDBAdapter.open();
		ResultSet companyResultSet = companyDBAdapter.getCompanyDataByCompanyId(id);
		CompanyActionForm userBean=new CompanyActionForm();
		if(companyResultSet != null ) {
		try {
			companyResultSet.beforeFirst();
			while(companyResultSet.next())
				userBean=fetchDataResultSet(companyResultSet);
			companyResultSet.close();
		}catch (Exception e) {
			//System.out.println(e);
			logger.error(e);
		}
		
		}
		companyDBAdapter.close();
		return userBean;
	}

	private CompanyActionForm fetchDataResultSet(ResultSet companyResultSet) throws SQLException{
		CompanyActionForm companybean = new CompanyActionForm();
		
		companybean.setCompanyMasterId(companyResultSet.getInt(CompanyDBAdapter.KEY_COMPANYMASTERID));
		companybean.setName(companyResultSet.getString(CompanyDBAdapter.KEY_NAME));
		companybean.setAddress(companyResultSet.getString(CompanyDBAdapter.KEY_ADDRESS));
		companybean.setContactEmail(companyResultSet.getString(CompanyDBAdapter.KEY_CONTACTEMAIL));
		companybean.setContactPersonNumber(companyResultSet.getString(CompanyDBAdapter.KEY_CONTACTPERSONNUMBER));
		companybean.setPhoneNumber1(companyResultSet.getString(CompanyDBAdapter.KEY_PHONENUMBER1));
		companybean.setPhoneNumber(companyResultSet.getString(CompanyDBAdapter.KEY_PHONENUMBER2));
		companybean.setCreatedBy(companyResultSet.getInt(CompanyDBAdapter.KEY_CREATEDBY));
		companybean.setCreatedDTTM(companyResultSet.getString(CompanyDBAdapter.KEY_CREATEDDTTM));
		companybean.setModifiedBy(companyResultSet.getInt(CompanyDBAdapter.KEY_MODIFIEDBY));
		companybean.setModifiedDTTM(companyResultSet.getString(CompanyDBAdapter.KEY_MODIFIEDDTTM));
		companybean.setLogo(companyResultSet.getString(CompanyDBAdapter.KEY_GETLOGO));
		companybean.setIsActive(companyResultSet.getInt(CompanyDBAdapter.KEY_ISACTIVE));
		companybean.setCstidno(companyResultSet.getString(CompanyDBAdapter.KEY_CSTIDNO));
		companybean.setVatidno(companyResultSet.getString(CompanyDBAdapter.KEY_VATIDNO));
		companybean.setSaletax(companyResultSet.getFloat(CompanyDBAdapter.KEY_SALETAX));
		//userbean.setSiteId(companyResultSet.getInt(UserDBAdapter.KEY_SITE_ID));
		return companybean;
	}
	public String getCompanyByRole(String role){
		companyDBAdapter.open();
		String sendString="";
		ResultSet userCursor =companyDBAdapter.getByRole(role);
		CompanyActionForm companyBean=new CompanyActionForm();
		StringBuffer buf=new StringBuffer();
		try{
		if(userCursor != null ) {
		userCursor.beforeFirst();
		while (userCursor.next()){
			companyBean=fetchDataResultSet(userCursor);
			//sendString += companyBean.getUid()+","+companyBean.getFirstName()+","+companyBean.getLastName()+"|";
			buf.append(companyBean.getCompanyMasterId()).append(",").append(companyBean.getName()).append(",");
		}
		sendString=buf.toString();
		}
		userCursor.close();
		}catch (Exception e) {
			//System.out.println(e);
			logger.error(e);
		}
			
		companyDBAdapter.close();
		return sendString;
	}
	

	
	public CompanyActionForm getCompanybyCompanyMasterId(int companyMasterId){
		companyDBAdapter.open();
		ResultSet userCursor =companyDBAdapter.getCompanybyCompanyMasterId(companyMasterId);
		CompanyActionForm companyBean=new CompanyActionForm();
	
		if(userCursor != null ) 
		{
			try{
		userCursor.beforeFirst();
		while (userCursor.next()){
			companyBean=fetchDataResultSet(userCursor);
			/*userCursor.close();*/
			}
			}catch(Exception e){
				logger.error(e);
			}
		}
		
		
			
		companyDBAdapter.close();
		return companyBean;
	}
	
	public ArrayList<CompanyActionForm> fetchAllActiveCompanyRecords(){
		companyDBAdapter.open();
		ResultSet cursor=companyDBAdapter.getAllActiveCompany();
		ArrayList<CompanyActionForm> companyBeanList = new ArrayList<CompanyActionForm>();
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				while(cursor.next()){
					companyBeanList.add(fetchDataResultSet(cursor));
				}
				cursor.close();
			}
			catch (Exception e) {
				//System.out.println(e);
				logger.error(e);
			}
			
		}
		companyDBAdapter.close();
		return companyBeanList; 
	}
	
	
		
		
	
			}

