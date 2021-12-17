package com.bms.audit;

import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.bms.audit.AuditActionForm;
import com.bms.audit.AuditDBAdapter;
import com.bms.constants.Constants;


/**
 * AuditDBHelper manages the AuditEntryDBAdapter Responsible for 
 * all business operations on the Audit table.
 * @author Jemis Dhameliya
 *
 */

public class AuditDBHelper {
	
	private static final String TAG= "com.scm.audit.AuditDBHelper";
	private Logger logger = Logger.getLogger(TAG);
	private AuditDBAdapter auditDBAdapter;
	public AuditDBHelper() {
		auditDBAdapter=new AuditDBAdapter();
	}
	
	
	
	public ArrayList<AuditActionForm> fetchAllRecords(){
		auditDBAdapter.open();
		ResultSet cursor=auditDBAdapter.getAll();
		ArrayList<AuditActionForm> auditBeanList = new ArrayList<AuditActionForm>();;
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				while(cursor.next()){
					auditBeanList.add(fetchDataFromResultSet(cursor));
				}
				cursor.close();
			}
			catch (Exception e) {
				//System.out.println(e);
				logger.error(e);
			}
			
		}
		auditDBAdapter.close();
		return auditBeanList; 
	}
	
	
	public AuditActionForm getAuditById(int auditId){
		auditDBAdapter.open();
		ResultSet cursor=auditDBAdapter.getByAuditId(auditId);
		AuditActionForm auditBean = null;
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				if(cursor.next()){
					auditBean = fetchDataFromResultSet(cursor);
				}
				cursor.close();
			}
			catch (Exception e) {
				logger.error(e);
			}
		}
		auditDBAdapter.close();
		return auditBean;
	}
	
	
	public AuditActionForm getAuditByAuditUserId(int auditUserId){
		auditDBAdapter.open();
		ResultSet cursor=auditDBAdapter.getByAuditUserId(auditUserId);
		AuditActionForm auditBean = null;
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				if(cursor.next()){
					auditBean = fetchDataFromResultSet(cursor);
				}
				cursor.close();
			}
			catch (Exception e) {
				logger.error(e);
			}
		}
		auditDBAdapter.close();
		return auditBean;
	}
	
	
	
	public int addAudit(AuditActionForm auditBean)
	{   
		auditDBAdapter.open();
		int status = auditDBAdapter.insertAudit(auditBean);
		auditDBAdapter.close();
		
		return status;
	}

	
	/**
	 * 
	 * @param auditName  The heading to be assigned to the audit
	 * @param auditDescription  The description to be added for the audit entry
	 * @param auditDTTM     The date of creation of audit. If left null, default system date is taken
	 * @param auditBranchCode   The KEY summarizing the type of audit. Refer to {@link Constants} for key details 
	 * @param auditKey      The primary key of the relevant table
	 * @param auditUserId    The user who has created the entry . cannot be null*
	 * @param auditCompanyId  The company id for which it was created. Ideally will be picked up from the user itself
	 * @param auditType       The Type summarizing the Exception of audit.
	 * @return
	 */
	public int addAudit(String auditName,String auditDescription, String auditDTTM, String auditBranchCode, String auditKey, String auditUserId,String auditCompanyId,String auditType)
	{   
		return -1;
	}

	
	public boolean deleteAuditById(int auditId)
	{
         auditDBAdapter.open();
		 boolean status = auditDBAdapter.deactiavteAudit(auditId);
		 auditDBAdapter.close();
		return status;
	}
	
	
	
	
	public int updateAudit(AuditActionForm auditBean){
		auditDBAdapter.open();
		int result = auditDBAdapter.update(auditBean);
		auditDBAdapter.close();
		return result;
	}
	
	
	private AuditActionForm fetchDataFromResultSet(ResultSet cursor){ 
		AuditActionForm auditBean=new AuditActionForm();
		try
		{
			auditBean.setAuditId(cursor.getInt(AuditDBAdapter.COLUMN_AUDIT_AUDIT_ID));
			auditBean.setAuditName(cursor.getString(AuditDBAdapter.COLUMN_AUDIT_AUDIT_NAME));
			auditBean.setAuditDescription(cursor.getString(AuditDBAdapter.COLUMN_AUDIT_AUDIT_DESCRIPTION));
			auditBean.setAuditDate(cursor.getString(AuditDBAdapter.COLUMN_AUDIT_AUDIT_DTTM));
			auditBean.setAuditBranchCode(cursor.getString(AuditDBAdapter.COLUMN_AUDIT_AUDIT_BRANCH_CODE));
			auditBean.setAuditKey(cursor.getInt(AuditDBAdapter.COLUMN_AUDIT_AUDIT_KEY));
			auditBean.setAuditUserId(cursor.getInt(AuditDBAdapter.COLUMN_AUDIT_AUDIT_USER_ID));
			auditBean.setCompanyId(cursor.getInt(AuditDBAdapter.COLUMN_AUDIT_AUDIT_COMPANY_ID));
			auditBean.setAuditType(cursor.getString(AuditDBAdapter.COLUMN_AUDIT_AUDIT_TYPE));
			
		}
		catch(Exception e)
		{
			logger.error(e);
		}
		return auditBean;
	}
	

}
