package com.bms.msg.messagemaster;

import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.bms.msg.messagemaster.MessageMasterActionForm;
import com.bms.msg.messagemaster.MessageMasterDBAdapter;;




public class MessageMasterDBHelper {
	
	
	
	private static final String TAG = "com.scm.sites.SitesDBHelper";
	private Logger logger = Logger.getLogger(TAG);
	private MessageMasterDBAdapter messagemasterDBAdapter  ;

	public MessageMasterDBHelper() {
		messagemasterDBAdapter = new MessageMasterDBAdapter();
	}

	public ArrayList<MessageMasterActionForm> fetchAllRecords() {
		messagemasterDBAdapter.open();
		ResultSet cursor = 	messagemasterDBAdapter.getAll();
		ArrayList<MessageMasterActionForm> messagemasterBeanList = new ArrayList<MessageMasterActionForm>();
		;
		if (cursor != null) {
			try {
				cursor.beforeFirst();
				while (cursor.next()) {
					messagemasterBeanList.add(fetchDataFromResultSet(cursor));
				}
				cursor.close();
			} catch (Exception e) {
				// System.out.println(e);
				logger.error(e);
			}

		}
		messagemasterDBAdapter.close();
		return messagemasterBeanList;
	}

	

	public int addmessagemaseter(MessageMasterActionForm messagemasterBean) {
		messagemasterDBAdapter.open();
		int status = 	messagemasterDBAdapter.insertMessage(messagemasterBean);
		messagemasterDBAdapter.close();

		return status;
	}


	public int updatemessagemaster(MessageMasterActionForm messagemasterBean) {
		messagemasterDBAdapter.open();
		int result = messagemasterDBAdapter.update(messagemasterBean);
		messagemasterDBAdapter.close();
		return result;
	}

	private MessageMasterActionForm fetchDataFromResultSet(ResultSet cursor) {
		MessageMasterActionForm messagemasterBean = new MessageMasterActionForm();
		try {
			messagemasterBean.setMessageMasterId(cursor.getInt(MessageMasterDBAdapter.KEY_MESSAGEMASTER_MASTERID));
			messagemasterBean.setSenderMasterId(cursor.getInt(MessageMasterDBAdapter.KEY_MESSAGEMASTER_SENDERMASTERID));
			messagemasterBean.setReceiverMasterId(cursor.getInt(MessageMasterDBAdapter.KEY_MESSAGEMASTER_RECEVIVERMASTERID));
			messagemasterBean.setSenderState(cursor.getInt(MessageMasterDBAdapter.KEY_MESSAGEMASTER_SENDERSTATE));
			messagemasterBean.setReceiverState(cursor.getInt(MessageMasterDBAdapter.KEY_MESSAGEMASTER_RECEVIERSTATE));
			messagemasterBean.setSubject(cursor.getString(MessageMasterDBAdapter.KEY_MESSAGEMASTER_SUBJECT));
			messagemasterBean.setCompanyMasterId(cursor.getInt(MessageMasterDBAdapter.KEY_MESSAGEMASTER_COMPANYMASTERID));
		} catch (Exception e) {
			logger.error(e);
		}
		return messagemasterBean;
	}


}
