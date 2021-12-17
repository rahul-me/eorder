package com.bms.msg.messagemaster;

import com.bms.struts.SCMActionForm;


public class MessageMasterActionForm extends SCMActionForm  {

	
	private int messageMasterId;                              
    private int senderMasterId;
	private int receiverMasterId;
	private int senderState;
	private int receiverState;
	private String subject;
	private int companyMasterId;
	public int getMessageMasterId() {
		return messageMasterId;
	}
	public void setMessageMasterId(int messageMasterId) {
		this.messageMasterId = messageMasterId;
	}
	public int getSenderMasterId() {
		return senderMasterId;
	}
	public void setSenderMasterId(int senderMasterId) {
		this.senderMasterId = senderMasterId;
	}
	public int getReceiverMasterId() {
		return receiverMasterId;
	}
	public void setReceiverMasterId(int receiverMasterId) {
		this.receiverMasterId = receiverMasterId;
	}
	public int getSenderState() {
		return senderState;
	}
	public void setSenderState(int senderState) {
		this.senderState = senderState;
	}
	public int getReceiverState() {
		return receiverState;
	}
	public void setReceiverState(int receiverState) {
		this.receiverState = receiverState;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getCompanyMasterId() {
		return companyMasterId;
	}
	public void setCompanyMasterId(int companyMasterId) {
		this.companyMasterId = companyMasterId;
	}
		
}




