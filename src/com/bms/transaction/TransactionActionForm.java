package com.bms.transaction;

import com.bms.struts.SCMActionForm;

public class TransactionActionForm extends SCMActionForm{

	private int transactionId;
	private String transactionDate;
	private String transactionFlow;
	private float transactionAmount;
	private String createdBy;
	private String createdDate;
	private String modifiedBy;
	private String modifiedDate;
	private int voucherNumber;
	private String voucherDate;
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getTransactionFlow() {
		return transactionFlow;
	}
	public void setTransactionFlow(String transactionFlow) {
		this.transactionFlow = transactionFlow;
	}
	public float getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(float transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public String getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public int getVoucherNumber() {
		return voucherNumber;
	}
	public void setVoucherNumber(int voucherNumber) {
		this.voucherNumber = voucherNumber;
	}
	public String getVoucherDate() {
		return voucherDate;
	}
	public void setVoucherDate(String voucherDate) {
		this.voucherDate = voucherDate;
	}
	
	
	
}
