package com.bms.msg.messagedetails;

import java.sql.ResultSet;

import org.apache.log4j.Logger;

import com.bms.db.ContentValues;
import com.bms.db.RestoserverDBAdapter;
import com.bms.neetai.userroles.UserRoleActionForm;
import com.bms.msg.messagedetails.MessageDetailsActionForm;


public class MessageDetailsDBAdapter extends RestoserverDBAdapter {

	
	private final String TAG = "com.scm.supplyarea.MessageDetailsDBAdapter";

	private final Logger log = Logger.getLogger(TAG);
	public static final String KEY_MESSAGEDETAILSROLE_TABLE_NAME = "msg_messagedetails";

	public static final String KEY_MESSAGEDETAILS_MASTERID = "messageDetailsMasterId";
	public static final String KEY_MESSAGEDETAILS_DESCRIPTION = "description";
	public static final String KEY_MESSAGEDETAILS_ATTACHMENT = "attachment";
	public static final String  KEY_MESSAGEDETAILS_FILETYPE = "fileType";
	public static final String KEY_MESSAGEDETAILS_FILESIZE = "fileSize";
	public static final String  KEY_MESSAGEDETAILS_MESSAGEMASTERID = "messageMasterId";

	public MessageDetailsDBAdapter() {
		super();
	}

	/**
	 * insertUserRole will insert data in to UserRole table
	 * 
	 * 
	 * 
	 * @param messagedetailsRoleBean
	 * @return cVAlue object if succes
	 */

	public int insertUserRole(MessageDetailsActionForm messagedetailsRoleBean)

	{
		ContentValues cValues = new ContentValues();
		cValues.put(KEY_MESSAGEDETAILS_MASTERID, messagedetailsRoleBean.getMessageDetailsMasterId());
		cValues.put(KEY_MESSAGEDETAILS_DESCRIPTION, messagedetailsRoleBean.getDescription());
		cValues.put(KEY_MESSAGEDETAILS_ATTACHMENT, messagedetailsRoleBean.getAttachment());
		cValues.put(KEY_MESSAGEDETAILS_FILESIZE, messagedetailsRoleBean.getFileSize());
		cValues.put(KEY_MESSAGEDETAILS_FILETYPE, messagedetailsRoleBean.getFileType());
		cValues.put(KEY_MESSAGEDETAILS_MESSAGEMASTERID, messagedetailsRoleBean.getMessageMasterId());

		
		return (int) insert(KEY_MESSAGEDETAILSROLE_TABLE_NAME, null, cValues);

	}

	/**
	 * get all will return all record of UserRole table
	 * 
	 * 
	 * 
	 * 
	 */

	public ResultSet getAll() {
		return query(KEY_MESSAGEDETAILSROLE_TABLE_NAME,null,null, null,null, null, null);
	}

	/**
	 * getByUserRoleId will return single record of UserRole table
	 * 
	 * @param UserRoleid
	 * @return resultset
	 * 
	 */

	public ResultSet getByMessagedetailsId(int UserRoleId) {
		return query(KEY_MESSAGEDETAILSROLE_TABLE_NAME,null,
				KEY_MESSAGEDETAILS_MASTERID + "=" + UserRoleId, null, null, null, null);
	}

	/**
	 * deactivateUserRole will unset particular UserRole of UserRole table
	 * 
	 * @param UserRoleid
	 * @return true/false
	 * 
	 */

	public boolean deactiavtemessagedetails(long UserRoleId) {

		return delete(KEY_MESSAGEDETAILSROLE_TABLE_NAME, KEY_MESSAGEDETAILS_MASTERID + "=" + UserRoleId,
				null) > 0;
	}

	/**
	 * update will update UserRole of UserRole table
	 * 
	 * @param messagedetailsRoleBean
	 * @return resultset
	 * 
	 */

	public int update(MessageDetailsActionForm messagedetailsRoleBean) {

		int result = 0;
		ContentValues cValues = new ContentValues();
		cValues.put(KEY_MESSAGEDETAILS_MESSAGEMASTERID, messagedetailsRoleBean.getMessageDetailsMasterId());
		cValues.put(KEY_MESSAGEDETAILS_DESCRIPTION, messagedetailsRoleBean.getDescription());
		cValues.put(KEY_MESSAGEDETAILS_ATTACHMENT, messagedetailsRoleBean.getAttachment());
		cValues.put(KEY_MESSAGEDETAILS_FILESIZE, messagedetailsRoleBean.getFileSize());
		cValues.put(KEY_MESSAGEDETAILS_FILETYPE, messagedetailsRoleBean.getFileType());
		cValues.put(KEY_MESSAGEDETAILS_MASTERID, messagedetailsRoleBean.getMessageMasterId());
		
		result = update(KEY_MESSAGEDETAILSROLE_TABLE_NAME, cValues, KEY_MESSAGEDETAILS_MASTERID + "='"
				+ messagedetailsRoleBean.getMessageDetailsMasterId() + "'", null);
		return result;
	}

}
