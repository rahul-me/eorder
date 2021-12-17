package com.bms.msg.messagedetails;

import com.bms.struts.SCMActionForm;

public class MessageDetailsActionForm extends SCMActionForm {

    private int messageDetailsMasterId;
    private String description;
	private String attachment;
	private String fileType;
	private String fileSize;
	private int messageMasterId;
	
	public int getMessageDetailsMasterId() {
		return messageDetailsMasterId;
	}
	public void setMessageDetailsMasterId(int messageDetailsMasterId) {
		this.messageDetailsMasterId = messageDetailsMasterId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAttachment() {
		return attachment;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getFileSize() {
		return fileSize;
	}
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	public int getMessageMasterId() {
		return messageMasterId;
	}
	public void setMessageMasterId(int messageMasterId) {
		this.messageMasterId = messageMasterId;
	}
	

}
