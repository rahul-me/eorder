package com.bms.msg.messagedetails;

import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.bms.msg.messagedetails.MessageDetailsActionForm;
import com.bms.msg.messagedetails.MessageDetailsDBAdapter;;



/**
 * MessageDetailsDBHelper manages the usreroletable in the database. Responsible for all
 * bussiness operations on the userrole table.
 * 
 * @author Santosh Dubey
 * 
 */

public class MessageDetailsDBHelper {

	private static final String TAG = "com.scm.sites.SitesDBHelper";
	private Logger logger = Logger.getLogger(TAG);
	private MessageDetailsDBAdapter messagedetailsDBAdapter  ;

	public MessageDetailsDBHelper() {
		messagedetailsDBAdapter = new MessageDetailsDBAdapter();
	}

	public ArrayList<MessageDetailsActionForm> fetchAllRecords() {
		messagedetailsDBAdapter.open();
		ResultSet cursor = 	messagedetailsDBAdapter.getAll();
		ArrayList<MessageDetailsActionForm> messagedetailsBeanList = new ArrayList<MessageDetailsActionForm>();
		;
		if (cursor != null) {
			try {
				cursor.beforeFirst();
				while (cursor.next()) {
					messagedetailsBeanList.add(fetchDataFromResultSet(cursor));
				}
				cursor.close();
			} catch (Exception e) {
				// System.out.println(e);
				logger.error(e);
			}

		}
		messagedetailsDBAdapter.close();
		return messagedetailsBeanList;
	}

	public MessageDetailsActionForm getUserByUserId(int UserRoleId) {
		messagedetailsDBAdapter.open();
		ResultSet cursor = 	messagedetailsDBAdapter.getByMessagedetailsId(UserRoleId);
		MessageDetailsActionForm messagedetailsBean = null;
		if (cursor != null) {
			try {
				cursor.beforeFirst();
				if (cursor.next()) {
					messagedetailsBean = fetchDataFromResultSet(cursor);
				}
				cursor.close();
			} catch (Exception e) {
				logger.error(e);
			}
		}
		messagedetailsDBAdapter.close();
		return messagedetailsBean;
	}

	public int addmessagedetails(MessageDetailsActionForm messagedetailsBean) {
		messagedetailsDBAdapter.open();
		int status = 	messagedetailsDBAdapter.insertUserRole(messagedetailsBean);
		messagedetailsDBAdapter.close();

		return status;
	}


	public int updatemessagedetails(MessageDetailsActionForm messagedetailsBean) {
		messagedetailsDBAdapter.open();
		int result = messagedetailsDBAdapter.update(messagedetailsBean);
		messagedetailsDBAdapter.close();
		return result;
	}

	private MessageDetailsActionForm fetchDataFromResultSet(ResultSet cursor) {
		MessageDetailsActionForm messagedetailsBean = new MessageDetailsActionForm();
		try {
			messagedetailsBean.setMessageDetailsMasterId(cursor.getInt(MessageDetailsDBAdapter.KEY_MESSAGEDETAILS_MASTERID));
			messagedetailsBean.setAttachment(cursor.getString(MessageDetailsDBAdapter.KEY_MESSAGEDETAILS_ATTACHMENT));
			messagedetailsBean.setDescription(cursor.getString(MessageDetailsDBAdapter.KEY_MESSAGEDETAILS_DESCRIPTION));
			messagedetailsBean.setFileSize(cursor.getString(MessageDetailsDBAdapter.KEY_MESSAGEDETAILS_FILESIZE));
			messagedetailsBean.setFileType(cursor.getString(MessageDetailsDBAdapter.KEY_MESSAGEDETAILS_FILETYPE));
			messagedetailsBean.setMessageMasterId(cursor.getInt(MessageDetailsDBAdapter.KEY_MESSAGEDETAILS_MESSAGEMASTERID));
		} catch (Exception e) {
			logger.error(e);
		}
		return messagedetailsBean;
	}

}
