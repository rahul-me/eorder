package com.bms.order.ordermaster;

import java.util.ArrayList;

import com.bms.mdm.item.ItemActionForm;
import com.bms.neetai.userroles.UserRoleActionForm;
import com.bms.neetai.users.UserActionForm;
import com.bms.struts.SCMActionForm;

public class OrderMasterActionForm extends SCMActionForm{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int	orderId;
	private int orderMasterId;
	private int customerMasterId;
	private String orderNumber;
	public int state;
	public float total;
	public String remark;
	public String createdDate;
	public String createdDTTM;
	public int createdBy;
	public int modifiedBy;
	public int isClose;
	public int closeBy;
	public String modifiedDTTM;
	public String closedDTTM;
	public int isActive;
	public int companyMasterId;
	public int userMasterId;
	public int itemMasterId;
	public int itemPrice;
	public int numList[];
	public String description;
	public float orderQuantity;
	public float dispatchedQuantity;
	
	
	public float getOrderQuantity() {
		return orderQuantity;
	}
	public void setOrderQuantity(float orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
	public float getDispatchedQuantity() {
		return dispatchedQuantity;
	}
	public void setDispatchedQuantity(float dispatchedQuantity) {
		this.dispatchedQuantity = dispatchedQuantity;
	}
	public int[] getNumList() {
		return numList;
	}
	public void setNumList(int[] numList) {
		this.numList = numList;
	}
	
	private ArrayList<UserRoleActionForm> roleList=null;
	
	private ArrayList<OrderMasterActionForm>orderMasterList=null;
	
	private ArrayList<ItemActionForm> itemList=null;
	
	private ArrayList<UserActionForm> userList=null;
	
	
	public int getCustomerMasterId() {
		return customerMasterId;
	}
	public void setCustomerMasterId(int customerMasterId) {
		this.customerMasterId = customerMasterId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ArrayList<OrderMasterActionForm> getOrderMasterList() {
		return orderMasterList;
	}
	public void setOrderMasterList(ArrayList<OrderMasterActionForm> orderMasterList) {
		this.orderMasterList = orderMasterList;
	}
	public ArrayList<UserActionForm> getUserList() {
		return userList;
	}
	public void setUserList(ArrayList<UserActionForm> userList) {
		this.userList = userList;
	}
	public ArrayList<UserRoleActionForm> getRoleList() {
		return roleList;
	}
	public void setRoleList(ArrayList<UserRoleActionForm> roleList) {
		this.roleList = roleList;
	}
	public ArrayList<ItemActionForm> getItemList() {
		return itemList;
	}
	public void setItemList(ArrayList<ItemActionForm> itemList) {
		this.itemList = itemList;
	}
	public int getItemMasterId() {
		return itemMasterId;
	}
	public void setItemMasterId(int itemMasterId) {
		this.itemMasterId = itemMasterId;
	}
	
	public int getUserMasterId() {
		return userMasterId;
	}
	public void setUserMasterId(int userMasterId) {
		this.userMasterId = userMasterId;
	}
	public int getOrderMasterId() {
		return orderMasterId;
	}
	public void setOrderMasterId(int orderMasterId) {
		this.orderMasterId = orderMasterId;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	public int getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public int getIsClose() {
		return isClose;
	}
	public void setIsClose(int isClose) {
		this.isClose = isClose;
	}
	public int getCloseBy() {
		return closeBy;
	}
	public void setCloseBy(int closeBy) {
		this.closeBy = closeBy;
	}
	public String getModifiedDTTM() {
		return modifiedDTTM;
	}
	public void setModifiedDTTM(String modifiedDTTM) {
		this.modifiedDTTM = modifiedDTTM;
	}
	public String getClosedDTTM() {
		return closedDTTM;
	}
	public void setClosedDTTM(String closedDTTM) {
		this.closedDTTM = closedDTTM;
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
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
}
