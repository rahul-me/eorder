package com.bms.msg.messagemaster;

import java.sql.ResultSet;

import org.apache.log4j.Logger;

import com.bms.db.ContentValues;
import com.bms.db.RestoserverDBAdapter;
import com.bms.msg.messagemaster.MessageMasterActionForm;



public class MessageMasterDBAdapter extends RestoserverDBAdapter   {

	
	private final String TAG = "com.scm.supplyarea.MessageMasterDBAdapter";

	private final Logger log = Logger.getLogger(TAG);
	public static final String KEY_MESSAGEMASTER_TABLE_NAME = "msg_messagemaster";

	public static final String KEY_MESSAGEMASTER_MASTERID = "messageMasterId";
	public static final String KEY_MESSAGEMASTER_SENDERMASTERID = "senderMasterId";
	public static final String KEY_MESSAGEMASTER_RECEVIVERMASTERID = "receiverMasterId";
	public static final String  KEY_MESSAGEMASTER_SENDERSTATE = "senderState";
	public static final String KEY_MESSAGEMASTER_RECEVIERSTATE = "receiverState";
	public static final String  KEY_MESSAGEMASTER_SUBJECT = "subject";
	public static final String  KEY_MESSAGEMASTER_COMPANYMASTERID = "companyMasterId";
	public MessageMasterDBAdapter() {
		super();
	}

	/**
	 * insertUserRole will insert data in to UserRole table
	 * 
	 * 
	 * 
	 * @param messagemasterRoleBean
	 * @return cVAlue object if succes
	 */

	public int insertMessage(MessageMasterActionForm messagemasterRoleBean)

	{
		ContentValues cValues = new ContentValues();
		cValues.put(KEY_MESSAGEMASTER_MASTERID, messagemasterRoleBean.getMessageMasterId());
		cValues.put(KEY_MESSAGEMASTER_SENDERMASTERID, messagemasterRoleBean.getSenderMasterId());
		cValues.put(KEY_MESSAGEMASTER_RECEVIVERMASTERID, messagemasterRoleBean.getReceiverMasterId());
		cValues.put(KEY_MESSAGEMASTER_SENDERSTATE, messagemasterRoleBean.getSenderState());
		cValues.put(KEY_MESSAGEMASTER_RECEVIERSTATE, messagemasterRoleBean.getReceiverState());
		cValues.put(KEY_MESSAGEMASTER_SUBJECT, messagemasterRoleBean.getSubject());
		cValues.put(KEY_MESSAGEMASTER_COMPANYMASTERID,messagemasterRoleBean.getCompanyMasterId());

		
		return (int) insert(KEY_MESSAGEMASTER_TABLE_NAME, null, cValues);

	}

	/**
	 * get all will return all record of UserRole table
	 * 
	 * 
	 * 
	 * 
	 */

	public ResultSet getAll() {
		return query(KEY_MESSAGEMASTER_TABLE_NAME,null,null, null,null, null, null);
	}

	/**
	 * getByUserRoleId will return single record of UserRole table
	 * 
	 * @param UserRoleid
	 * @return resultset
	 * 
	 */

	public ResultSet getByMessagemasterId(int UserRoleId) {
		return query(KEY_MESSAGEMASTER_TABLE_NAME,null,
				KEY_MESSAGEMASTER_MASTERID + "=" + UserRoleId, null, null, null, null);
	}

	/**
	 * deactivateUserRole will unset particular UserRole of UserRole table
	 * 
	 * @param UserRoleid
	 * @return true/false
	 * 
	 */

	public boolean deactiavtemessagedetails(long UserRoleId) {

		return delete(KEY_MESSAGEMASTER_TABLE_NAME, KEY_MESSAGEMASTER_MASTERID + "=" + UserRoleId,
				null) > 0;
	}

	/**
	 * update will update UserRole of UserRole table
	 * 
	 * @param messagemasterRoleBean
	 * @return resultset
	 * 
	 */

	public int update(MessageMasterActionForm messagemasterRoleBean) {

		int result = 0;
		ContentValues cValues = new ContentValues();
		cValues.put(KEY_MESSAGEMASTER_MASTERID, messagemasterRoleBean.getMessageMasterId());
		cValues.put(KEY_MESSAGEMASTER_SENDERMASTERID, messagemasterRoleBean.getSenderMasterId());
		cValues.put(KEY_MESSAGEMASTER_RECEVIVERMASTERID, messagemasterRoleBean.getReceiverMasterId());
		cValues.put(KEY_MESSAGEMASTER_SENDERSTATE, messagemasterRoleBean.getSenderState());
		cValues.put(KEY_MESSAGEMASTER_RECEVIERSTATE, messagemasterRoleBean.getReceiverState());
		cValues.put(KEY_MESSAGEMASTER_SUBJECT, messagemasterRoleBean.getSubject());
		cValues.put(KEY_MESSAGEMASTER_COMPANYMASTERID, messagemasterRoleBean.getCompanyMasterId());
		
		result = update(KEY_MESSAGEMASTER_TABLE_NAME, cValues, KEY_MESSAGEMASTER_MASTERID + "='"
				+ messagemasterRoleBean.getMessageMasterId() + "'", null);
		return result;
	}

	
}



