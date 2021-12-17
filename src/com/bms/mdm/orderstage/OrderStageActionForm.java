package com.bms.mdm.orderstage;

import com.bms.struts.SCMActionForm;

public class OrderStageActionForm extends SCMActionForm{
	
	public int orderStageMasterId;
	public String name;
	public String description;
	public int createdBy;
	public int modifiedBy;
	public String createdDTTM;
	public String modifiedDTTM;
	public int isActive;
	public int companyMasterId;
	
	public int getOrderStageMasterId() {
		return orderStageMasterId;
	}
	public void setOrderStageMasterId(int orderStageMasterId) {
		this.orderStageMasterId = orderStageMasterId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	public int getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public String getCreatedDTTM() {
		return createdDTTM;
	}
	public void setCreatedDTTM(String createdDTTM) {
		this.createdDTTM = createdDTTM;
	}
	public String getModifiedDTTM() {
		return modifiedDTTM;
	}
	public void setModifiedDTTM(String modifiedDTTM) {
		this.modifiedDTTM = modifiedDTTM;
	}
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	public int getCompanyMasterId() {
		return companyMasterId;
	}
	public void setCompanyMasterId(int companyMasterId) {
		this.companyMasterId = companyMasterId;
	}
	
	
	
	
	
}
