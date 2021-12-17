package com.bms.mdm.packages;

import org.apache.struts.action.ActionForm;

public class PackagesActionForm extends ActionForm{

	/**
	 * 
	 * 
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int packageMasterId;
	private String packageName;
	private String packageDescription;
	private int packageCharge;	
	private int packageDuration;
	private int isActive;
	private String createdDate;
	private String createdDTTM;
	private int createdBy;
	private String modifyDate;
	private String modifyDTTM;
	private int packageStatus;
	
	
	public int getPackageMasterId() {
		return packageMasterId;
	}
	public void setPackageMasterId(int packageMasterId) {
		this.packageMasterId = packageMasterId;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public String getPackageDescription() {
		return packageDescription;
	}
	public void setPackageDescription(String packageDescription) {
		this.packageDescription = packageDescription;
	}
	public int getPackageCharge() {
		return packageCharge;
	}
	public void setPackageCharge(int packageCharge) {
		this.packageCharge = packageCharge;
	}
	public int getPackageDuration() {
		return packageDuration;
	}
	public void setPackageDuration(int packageDuration) {
		this.packageDuration = packageDuration;
	}
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getCreatedDTTM() {
		return createdDTTM;
	}
	public void setCreatedDTTM(String createdDTTM) {
		this.createdDTTM = createdDTTM;
	}
	
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getModifyDTTM() {
		return modifyDTTM;
	}
	public void setModifyDTTM(String modifyDTTM) {
		this.modifyDTTM = modifyDTTM;
	}
	public int getPackageStatus() {
		return packageStatus;
	}
	public void setPackageStatus(int packageStatus) {
		this.packageStatus = packageStatus;
	}
	
	
	
	}
