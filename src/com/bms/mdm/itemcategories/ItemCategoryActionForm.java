package com.bms.mdm.itemcategories;

import java.util.ArrayList;


import com.bms.neetai.company.CompanyActionForm;
import com.bms.struts.SCMActionForm;

public class ItemCategoryActionForm extends SCMActionForm{

	private int itemCategoryMasterId;
	private String name;
	private String description;
	private int superCategoryId;
	private int createdBy;
	private String createdDTTM;
	private int modifiedBy;
	private String modifiedDTTM;
	private int companyMasterId;
	private int isActive;
	
	private ArrayList<ItemCategoryActionForm> itemCategoryList=null;
	private ArrayList<CompanyActionForm> companyList=null;
	
	public ArrayList<ItemCategoryActionForm> getItemCategoryList() {
		return itemCategoryList;
	}
	public void setItemCategoryList(
			ArrayList<ItemCategoryActionForm> itemCategoryList) {
		this.itemCategoryList = itemCategoryList;
	}
	public ArrayList<CompanyActionForm> getCompanyList() {
		return companyList;
	}
	public void setCompanyList(ArrayList<CompanyActionForm> companyList) {
		this.companyList = companyList;
	}
	public int getItemCategoryMasterId() {
		return itemCategoryMasterId;
	}
	public void setItemCategoryMasterId(int itemCategoryMasterId) {
		this.itemCategoryMasterId = itemCategoryMasterId;
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
	public int getSuperCategoryId() {
		return superCategoryId;
	}
	public void setSuperCategoryId(int superCategoryId) {
		this.superCategoryId = superCategoryId;
	}
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	public String getCreatedDTTM() {
		return createdDTTM;
	}
	public void setCreatedDTTM(String createdDTTM) {
		this.createdDTTM = createdDTTM;
	}
	public int getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public String getModifiedDTTM() {
		return modifiedDTTM;
	}
	public void setModifiedDTTM(String modifiedDTTM) {
		this.modifiedDTTM = modifiedDTTM;
	}
	public int getCompanyMasterId() {
		return companyMasterId;
	}
	public void setCompanyMasterId(int companyMasterId) {
		this.companyMasterId = companyMasterId;
	}
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	
	
	
	
}
