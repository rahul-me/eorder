package com.bms.audit;

import com.bms.struts.SCMActionForm;

public class AuditActionForm extends SCMActionForm{

	private int auditId;
	private String auditName;
	private String auditDescription;
	private String auditDate;
	private String auditBranchCode;
	private int auditKey;
	private int auditUserId;
	private int companyId;
	private String auditType;
	
	
	public String getAuditType() {
		return auditType;
	}
	public void setAuditType(String auditType) {
		this.auditType = auditType;
	}
	public int getAuditId() {
		return auditId;
	}
	public void setAuditId(int auditId) {
		this.auditId = auditId;
	}
	public String getAuditName() {
		return auditName;
	}
	public void setAuditName(String auditName) {
		this.auditName = auditName;
	}
	public String getAuditDescription() {
		return auditDescription;
	}
	public void setAuditDescription(String auditDescription) {
		this.auditDescription = auditDescription;
	}
	public String getAuditDate() {
		return auditDate;
	}
	public void setAuditDate(String auditDate) {
		this.auditDate = auditDate;
	}
	public String getAuditBranchCode() {
		return auditBranchCode;
	}
	public void setAuditBranchCode(String auditBranchCode) {
		this.auditBranchCode = auditBranchCode;
	}
	public int getAuditKey() {
		return auditKey;
	}
	public void setAuditKey(int auditKey) {
		this.auditKey = auditKey;
	}
	public int getAuditUserId() {
		return auditUserId;
	}
	public void setAuditUserId(int auditUserId) {
		this.auditUserId = auditUserId;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	
	
}
