package com.bms.mdm.item;

import java.util.ArrayList;

import com.bms.mdm.itemcategories.ItemCategoryActionForm;
import com.bms.mdm.measurement.MeasurementActionForm;
import com.bms.neetai.company.CompanyActionForm;
import com.bms.neetai.users.UserActionForm;
import com.bms.struts.SCMActionForm;

public class ItemActionForm extends SCMActionForm{

	private int itemMasterId;
	private String name;
	private String SKU;
	private float life;
	private int state;
	private int isCritical;
	private float minOrderQuantity;
	private float itemPrice;
	private String returnAllowed;
	private String description;
	private int isActive;
	private int createdBy;
	private String createdDTTM;
	private String modifiedBy;
	private String modifiedDTTM;
	private String photo;
	private String itemType;
	private String brand;
	private String modelNo;
	private float tax1;
	private float tax2;
	private float tax3;
	private String itemCategoryMasterId;
	private int measurementMasterId;
	private int companyMasterId;
	private int userMasterId;
	private float stockQuantity;
	
	private ArrayList<ItemCategoryActionForm> itemCategoryList=null;
	private ArrayList<MeasurementActionForm> measurementList=null;
	private ArrayList<CompanyActionForm> companyList=null;
	private ArrayList<ItemActionForm> itemList=null;
	private ArrayList<UserActionForm> userList=null;
		
	
	public float getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(float stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	public ArrayList<ItemCategoryActionForm> getItemCategoryList() {
		return itemCategoryList;
	}
	public void setItemCategoryList(
			ArrayList<ItemCategoryActionForm> itemCategoryList) {
		this.itemCategoryList = itemCategoryList;
	}
	public ArrayList<MeasurementActionForm> getMeasurementList() {
		return measurementList;
	}
	public void setMeasurementList(ArrayList<MeasurementActionForm> measurementList) {
		this.measurementList = measurementList;
	}
	public ArrayList<CompanyActionForm> getCompanyList() {
		return companyList;
	}
	public void setCompanyList(ArrayList<CompanyActionForm> companyList) {
		this.companyList = companyList;
	}
	public ArrayList<ItemActionForm> getItemList() {
		return itemList;
	}
	public void setItemList(ArrayList<ItemActionForm> itemList) {
		this.itemList = itemList;
	}
	
	public ArrayList<UserActionForm> getUserList() {
		return userList;
	}
	public void setUserList(ArrayList<UserActionForm> userList) {
		this.userList = userList;
	}
	public int getItemMasterId() {
		return itemMasterId;
	}
	public void setItemMasterId(int itemMasterId) {
		this.itemMasterId = itemMasterId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSKU() {
		return SKU;
	}
	public void setSKU(String sKU) {
		SKU = sKU;
	}
	public float getLife() {
		return life;
	}
	public void setLife(float life) {
		this.life = life;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getIsCritical() {
		return isCritical;
	}
	public void setIsCritical(int isCritical) {
		this.isCritical = isCritical;
	}
	public float getMinOrderQuantity() {
		return minOrderQuantity;
	}
	public void setMinOrderQuantity(float minOrderQuantity) {
		this.minOrderQuantity = minOrderQuantity;
	}
	public float getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(float itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getReturnAllowed() {
		return returnAllowed;
	}
	public void setReturnAllowed(String returnAllowed) {
		this.returnAllowed = returnAllowed;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
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
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public String getModifiedDTTM() {
		return modifiedDTTM;
	}
	public void setModifiedDTTM(String modifiedDTTM) {
		this.modifiedDTTM = modifiedDTTM;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModelNo() {
		return modelNo;
	}
	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}
	public float getTax1() {
		return tax1;
	}
	public void setTax1(float tax1) {
		this.tax1 = tax1;
	}
	public float getTax2() {
		return tax2;
	}
	public void setTax2(float tax2) {
		this.tax2 = tax2;
	}
	public float getTax3() {
		return tax3;
	}
	public void setTax3(float tax3) {
		this.tax3 = tax3;
	}
	public String getItemCategoryMasterId() {
		return itemCategoryMasterId;
	}
	public void setItemCategoryMasterId(String itemCategoryMasterId) {
		this.itemCategoryMasterId = itemCategoryMasterId;
	}
	public int getMeasurementMasterId() {
		return measurementMasterId;
	}
	public void setMeasurementMasterId(int measurementMasterId) {
		this.measurementMasterId = measurementMasterId;
	}
	public int getCompanyMasterId() {
		return companyMasterId;
	}
	public void setCompanyMasterId(int companyMasterId) {
		this.companyMasterId = companyMasterId;
	}
	public int getUserMasterId() {
		return userMasterId;
	}
	public void setUserMasterId(int userMasterId) {
		this.userMasterId = userMasterId;
	}
	
	
	
}
