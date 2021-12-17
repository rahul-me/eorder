
package com.bms.neetai.company;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.bms.db.ContentValues;

/**
 * 
 * @author Mehul Markana
 *This class is responsible to create the table for different users.
 * The name of the table is userTable in database Restaurant.
 */

public class CompanyDBAdapter extends com.bms.db.RestoserverDBAdapter{
	private static final String TAG = "com.bms.neetai.company.CompanyDBAdapter";
	private final Logger log = Logger.getLogger(TAG);
	public static final String COMPANY_TABLE_NAME="neetai_company";
	
	public static final String KEY_COMPANYMASTERID="companyMasterId";
	public static final String KEY_NAME="name";
	public static final String KEY_Address="address";
	public static final String KEY_CONTACTPERSONNUMBER="contactPersonNumber";
	public static final String KEY_PHONENUMBER1="phoneNumber1";
	public static final String KEY_PHONENUMBER2="phoneNumber2";
	public static final String KEY_CONTACTEMAIL="contactEmail";
	public static final String KEY_CREATEDBY="createdBy";
	public static final String KEY_MODIFIEDBY="modifiedBy";
	public static final String KEY_CREATEDDTTM="createdDTTM";
	public static final String KEY_MODIFIEDDTTM="modifiedDTTM";
	public static final String KEY_GETLOGO="logo";
	public static final String KEY_ISACTIVE="isActive";
	
	public static final String KEY_CSTIDNO = "cstidno";
	public static final String KEY_VATIDNO = "vatidno";
	public static final String KEY_SALETAX = "saletax";
	
	
	public CompanyDBAdapter() {
		super();
	}


	 public int insert(CompanyActionForm companybean) throws SQLException{
		 ContentValues cv=new ContentValues();
		 int result;
		 cv.put(KEY_COMPANYMASTERID,companybean.getCompanyMasterId());
		 cv.put(KEY_NAME, companybean.getName());
		 cv.put(KEY_Address, companybean.getAddress());
		 cv.put(KEY_CONTACTPERSONNUMBER, companybean.getContactPersonNumber());
		 cv.put(KEY_PHONENUMBER1,companybean.getPhoneNumber1());
		 cv.put(KEY_PHONENUMBER2,companybean.getPhoneNumber());
		 cv.put(KEY_CONTACTEMAIL,companybean.getContactEmail());
		 cv.put(KEY_CREATEDBY,companybean.getCreatedBy());
		 cv.put(KEY_MODIFIEDBY,companybean.getModifiedBy());
		 cv.put(KEY_CREATEDDTTM,companybean.getCreatedDTTM());
		 cv.put(KEY_MODIFIEDDTTM,companybean.getModifiedDTTM());
		 cv.put(KEY_GETLOGO,companybean.getLogo());
		 cv.put(KEY_ISACTIVE, companybean.getIsActive());
		 cv.put(KEY_CSTIDNO, companybean.getCstidno());
		 cv.put(KEY_VATIDNO, companybean.getVatidno());
		 cv.put(KEY_SALETAX, companybean.getSaletax());
		 //cv.put(KEY_SITE_ID,companybean.getSiteId());
		  result= (int) insert(COMPANY_TABLE_NAME, null, cv);
		  return result;
		 	 }

	 public ResultSet getAll(){
		 ResultSet ResultSet = query(COMPANY_TABLE_NAME,null,null, null, null, null, null);
		 return ResultSet;
	 }

	 /**
	  * 
	  * @param userbean
	  * This method is used to get the user data based on its UID
	  * @return
	  */
	 public ResultSet getCompanyDataByCompanyId(int id){
		 ResultSet ResultSet = query(COMPANY_TABLE_NAME,null,KEY_COMPANYMASTERID+ "=" + "'" + id +"'", null, null, null, null);
		 return ResultSet;
	 }

	 public ResultSet getCompanyName(String companyname){
		 ResultSet ResultSet = query(COMPANY_TABLE_NAME,null,KEY_NAME+ "=" + "'" + companyname + "'", null, null, null, null);
		 return ResultSet;
	 }
	
	 public ResultSet getByRole(String role){
		 ResultSet cursor = query(COMPANY_TABLE_NAME,null,KEY_ROLE+ "=" + "'" + role +"'", null, null, null, null);
		 return cursor;
	 }
	 
	 public ResultSet getCompanybyCompanyMasterId(int masterId){
		 ResultSet cursor = query(COMPANY_TABLE_NAME,null,KEY_COMPANYMASTERID+ "=" + "'" + masterId +"'", null, null, null, null);
		 return cursor;
	 }
	 
	/**
		 * getAllByFilter will return records by filter
		 * 
		 * @param filter(createdDate,SiteId list)
		 * 
		 */
		public ResultSet getAllByFilter(String Filter) {
			return query(COMPANY_TABLE_NAME, null, Filter, null, null, null,
					null);
		}
	 /**
	  * 
	  * @param userbean
	  * THe method below is used to update the details of the the user
	  * @return
	  */
	 public boolean updateCompanyData(CompanyActionForm companybean){
		 ContentValues cv = new ContentValues();
		 cv.put(KEY_COMPANYMASTERID,companybean.getCompanyMasterId());
		 cv.put(KEY_NAME, companybean.getName());
		 cv.put(KEY_Address, companybean.getAddress());
		 cv.put(KEY_CONTACTPERSONNUMBER, companybean.getContactPersonNumber());
		 cv.put(KEY_PHONENUMBER1,companybean.getPhoneNumber1());
		 cv.put(KEY_PHONENUMBER2,companybean.getPhoneNumber());
		 cv.put(KEY_CONTACTEMAIL,companybean.getContactEmail());
		 cv.put(KEY_CREATEDBY,companybean.getCreatedBy());
		 cv.put(KEY_MODIFIEDBY,companybean.getModifiedBy());
		 cv.put(KEY_CREATEDDTTM,companybean.getCreatedDTTM());
		 cv.put(KEY_MODIFIEDDTTM,companybean.getModifiedDTTM());
		 cv.put(KEY_GETLOGO,companybean.getLogo());
		 cv.put(KEY_ISACTIVE, companybean.getIsActive());
		 cv.put(KEY_CSTIDNO, companybean.getCstidno());
		 cv.put(KEY_VATIDNO, companybean.getVatidno());
		 cv.put(KEY_SALETAX, companybean.getSaletax());
		//cv.put(KEY_SITE_ID,userbean.getSiteId());
		 return update(COMPANY_TABLE_NAME,cv,KEY_COMPANYMASTERID+ "=" + "'" + companybean.getCompanyMasterId() + "'", null) > 0;
	 }

	 public boolean deleteUser(int userId){
		 return delete(COMPANY_TABLE_NAME, KEY_COMPANYMASTERID + "="  + userId  , null) > 0;
	 }

	 public ResultSet getAllActiveCompany(){

		 return query(COMPANY_TABLE_NAME, null, KEY_ISACTIVE+"= 1", null, null, null,null);		
	 }

}
