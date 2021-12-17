package com.bms.audit;

import java.sql.ResultSet;

import org.apache.log4j.Logger;

import com.bms.audit.AuditActionForm;
import com.bms.db.ContentValues;
import com.bms.db.RestoserverDBAdapter;


/**
 * AuditDBAdapter manages the Audit table in the database. Responsible for 
 * all CRUD operations on the Audit table.
 * @author Jemis Dhameliya
 *
 */


public class AuditDBAdapter extends RestoserverDBAdapter{

	private final String TAG = "com.scm.audit.AuditDBAdapter";
	
	private final Logger log = Logger.getLogger(TAG);
	
	public static final String AUDIT_TABLE_NAME="mdm_audit";
	
	public static final String COLUMN_AUDIT_AUDIT_ID="auditId";
	public static final String COLUMN_AUDIT_AUDIT_NAME="auditName";
	public static final String COLUMN_AUDIT_AUDIT_DESCRIPTION="auditDescription";
	public static final String COLUMN_AUDIT_AUDIT_DTTM="auditDTTM";
	public static final String COLUMN_AUDIT_AUDIT_BRANCH_CODE="auditBranchCode";
	public static final String COLUMN_AUDIT_AUDIT_KEY="auditKey";
	public static final String COLUMN_AUDIT_AUDIT_USER_ID="auditUserId";
	public static final String COLUMN_AUDIT_AUDIT_COMPANY_ID="companyId";
	public static final String COLUMN_AUDIT_AUDIT_TYPE="auditType";

	 public AuditDBAdapter() {
		 super();
	}
	
	 
	 /**
		 * Insert Audit will insert data in to Audit table 
         *
		 * @param auditBean 
		 * @return cVAlue object if succes 
		 */
        
		public int insertAudit(AuditActionForm auditBean)
		
		{	
			ContentValues cValues = new ContentValues();
			cValues.put(COLUMN_AUDIT_AUDIT_ID, auditBean.getAuditId());
			cValues.put(COLUMN_AUDIT_AUDIT_NAME, auditBean.getAuditName());
			cValues.put(COLUMN_AUDIT_AUDIT_DESCRIPTION, auditBean.getAuditDescription());
			cValues.put(COLUMN_AUDIT_AUDIT_DTTM, auditBean.getAuditDate());
			cValues.put(COLUMN_AUDIT_AUDIT_BRANCH_CODE, auditBean.getAuditBranchCode());
			cValues.put(COLUMN_AUDIT_AUDIT_KEY, auditBean.getAuditKey());
			cValues.put(COLUMN_AUDIT_AUDIT_USER_ID, auditBean.getAuditUserId());
			cValues.put(COLUMN_AUDIT_AUDIT_COMPANY_ID, auditBean.getCompanyId());
			cValues.put(COLUMN_AUDIT_AUDIT_TYPE, auditBean.getAuditType());
			
			return (int)insert(AUDIT_TABLE_NAME, null, cValues);
		}
	 
		/**
		 * get All Method will return all record of Audit table
		 * 
		 * 
		 */
		
		public ResultSet getAll()
		{
			return query(AUDIT_TABLE_NAME, new String[] {COLUMN_AUDIT_AUDIT_ID, COLUMN_AUDIT_AUDIT_NAME, COLUMN_AUDIT_AUDIT_DESCRIPTION, COLUMN_AUDIT_AUDIT_DTTM, COLUMN_AUDIT_AUDIT_BRANCH_CODE, COLUMN_AUDIT_AUDIT_KEY, COLUMN_AUDIT_AUDIT_USER_ID,COLUMN_AUDIT_AUDIT_COMPANY_ID,COLUMN_AUDIT_AUDIT_TYPE}, null, null, null, null, null);		
		}
		
		
		/**
		 * getByAuditId  will return single record of Audit table
		 * 
		 * @param auditId
		 * @return resultset
		 * 
		 */
		
		public ResultSet getByAuditId(int auditId)
		{
			return query(AUDIT_TABLE_NAME, new String[] {COLUMN_AUDIT_AUDIT_ID, COLUMN_AUDIT_AUDIT_NAME, COLUMN_AUDIT_AUDIT_DESCRIPTION, COLUMN_AUDIT_AUDIT_DTTM, COLUMN_AUDIT_AUDIT_BRANCH_CODE, COLUMN_AUDIT_AUDIT_KEY, COLUMN_AUDIT_AUDIT_USER_ID,COLUMN_AUDIT_AUDIT_COMPANY_ID,COLUMN_AUDIT_AUDIT_TYPE}, COLUMN_AUDIT_AUDIT_ID+ "=" + auditId, null, null, null, null);
		}
	
		
		
		/**
		 * getByAuditUserId  will return single record of Audit table
		 * 
		 * @param auditUserId
		 * @return resultset
		 * 
		 */
		
		public ResultSet getByAuditUserId(int auditUserId)
		{
			return query(AUDIT_TABLE_NAME, new String[] {COLUMN_AUDIT_AUDIT_ID, COLUMN_AUDIT_AUDIT_NAME, COLUMN_AUDIT_AUDIT_DESCRIPTION, COLUMN_AUDIT_AUDIT_DTTM, COLUMN_AUDIT_AUDIT_BRANCH_CODE, COLUMN_AUDIT_AUDIT_KEY, COLUMN_AUDIT_AUDIT_USER_ID,COLUMN_AUDIT_AUDIT_COMPANY_ID,COLUMN_AUDIT_AUDIT_TYPE}, COLUMN_AUDIT_AUDIT_USER_ID+ "=" + auditUserId, null, null, null, null);
		}
		
		
		/**
		 * DeactivateAudit  will unset particular of Audit table
		 * 
		 * @param auditId
		 * @return true/false
		 * 
		 */
			
	
		public boolean deactiavteAudit(long auditId) {

			return delete(AUDIT_TABLE_NAME, COLUMN_AUDIT_AUDIT_ID+ "=" + auditId, null) > 0;
		}

		
		/**
		 *update will update Audit of Audit table
		 * 
		 * @param auditBean
		 * @return resultset
		 * 
		 */
			
		
		public int update(AuditActionForm auditBean){

			int result = 0;
			ContentValues cv=new ContentValues();
			cv.put(COLUMN_AUDIT_AUDIT_NAME, auditBean.getAuditName());
			cv.put(COLUMN_AUDIT_AUDIT_COMPANY_ID, auditBean.getCompanyId());
			cv.put(COLUMN_AUDIT_AUDIT_DESCRIPTION, auditBean.getAuditDescription());
			cv.put(COLUMN_AUDIT_AUDIT_BRANCH_CODE , auditBean.getAuditBranchCode());
			cv.put(COLUMN_AUDIT_AUDIT_DTTM , auditBean.getAuditDate());
			cv.put(COLUMN_AUDIT_AUDIT_KEY, auditBean.getAuditKey());
			cv.put(COLUMN_AUDIT_AUDIT_USER_ID, auditBean.getAuditUserId());
			cv.put(COLUMN_AUDIT_AUDIT_TYPE, auditBean.getAuditType());
			
			
			result = update(AUDIT_TABLE_NAME, cv, COLUMN_AUDIT_AUDIT_ID + "='" + auditBean.getAuditId() +"'", null);
			return result;
		}
		
	
}
