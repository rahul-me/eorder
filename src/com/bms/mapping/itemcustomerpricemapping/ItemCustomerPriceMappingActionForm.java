package com.bms.mapping.itemcustomerpricemapping;

import java.util.ArrayList;

import com.bms.mdm.item.ItemActionForm;
import com.bms.neetai.users.UserActionForm;
import com.bms.struts.SCMActionForm;

public class ItemCustomerPriceMappingActionForm extends SCMActionForm{
	
	private int id;
	private int itemId;
	private int companyId;
	private int customerId;
	private float itemPrice;
	private int itemStatus;
	private int createdBy;
	private int modifiedBy;
	private String createdDTTM;
	private String modifiedDTTM;
	private int userMasterId;
	private int itemMasterId;
	
	private ArrayList<ItemActionForm> itemList=null;
	private ArrayList<UserActionForm> userList=null;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public float getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(float itemPrice) {
		this.itemPrice = itemPrice;
	}
	public int getItemStatus() {
		return itemStatus;
	}
	public void setItemStatus(int itemStatus) {
		this.itemStatus = itemStatus;
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
	public int getUserMasterId() {
		return userMasterId;
	}
	public void setUserMasterId(int userMasterId) {
		this.userMasterId = userMasterId;
	}
	public int getItemMasterId() {
		return itemMasterId;
	}
	public void setItemMasterId(int itemMasterId) {
		this.itemMasterId = itemMasterId;
	}
	
	
	
}
