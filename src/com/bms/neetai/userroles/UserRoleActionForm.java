package com.bms.neetai.userroles;

import java.util.ArrayList;

import com.bms.neetai.company.CompanyActionForm;
import com.bms.struts.SCMActionForm;

public class UserRoleActionForm extends SCMActionForm {

	private int userRolesMasterId;
	private String name;                    
	private String description;
	private String createdDTTM;
	private int createdBY;
	private int modifiedBY;
	private String modifiedDTTM;
	private int isActive;
	private int companyMasterId;
	
	private ArrayList<CompanyActionForm> companyList=null;
	
	public ArrayList<CompanyActionForm> getCompanyList() {
		return companyList;
	}
	public void setCompanyList(ArrayList<CompanyActionForm> companyList) {
		this.companyList = companyList;
	}
	public int getUserRolesMasterId() {
		return userRolesMasterId;
	}
	public void setUserRolesMasterId(int userRolesMasterId) {
		this.userRolesMasterId = userRolesMasterId;
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
	public String getCreatedDTTM() {
		return createdDTTM;
	}
	public void setCreatedDTTM(String createdDTTM) {
		this.createdDTTM = createdDTTM;
	}
	public int getCreatedBY() {
		return createdBY;
	}
	public void setCreatedBY(int createdBY) {
		this.createdBY = createdBY;
	}
	public int getModifiedBY() {
		return modifiedBY;
	}
	public void setModifiedBY(int modifiedBY) {
		this.modifiedBY = modifiedBY;
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

