package com.bms.mdm.filter;

import java.util.ArrayList;

import com.bms.mdm.item.ItemActionForm;
import com.bms.mdm.itemcategories.ItemCategoryActionForm;
import com.bms.mdm.orderstage.OrderStageActionForm;
import com.bms.neetai.userroles.UserRoleActionForm;
import com.bms.neetai.users.UserActionForm;
import com.bms.order.ordermaster.OrderMasterActionForm;
import com.bms.struts.SCMActionForm;

public class FilterActionForm extends SCMActionForm{
	
	
	private int[] itemIds;
	private int[] siteid;
	private int[] supplierId;
	private int filterSelect;
	private int[] areaMasterId;
	private int stockStatus;
	private int[] itemActive;
	private int[] itemType;
	private int[] supplierStatus;
	private int[] supplierType;
	private int[] companyId;
	private int[] userId;
	private int[] userRole;
	private int[] active;
	private int critical;
	private String alertMsg;
	private int[] customerId;
	private int[] orderMasterId;
	private int dateVal;
	private int[] POStatusId;
	private int[] POId;
	private String fromDate;
	private String toDate;
	private String villageName;
	private int orderStageId;
	private int orderStatus;
	private ArrayList<OrderStageActionForm> orderStageList;
	private ArrayList<ItemActionForm> itemList=null;


	private ArrayList<UserActionForm> userList=null;
	private ArrayList<OrderMasterActionForm> orderMasterList=null;
    private ArrayList<ItemCategoryActionForm>categoryList=null;
    
    private String fromPackageDate;
    private String toPackageDate;
    
    private ArrayList<UserRoleActionForm> userRoleList=null;
    
    
    
    
    
    
	
	public ArrayList<UserRoleActionForm> getUserRoleList() {
		return userRoleList;
	}
	public void setUserRoleList(ArrayList<UserRoleActionForm> userRoleList) {
		this.userRoleList = userRoleList;
	}
	public void setFromPackageDate(String fromPackageDate){
		this.fromPackageDate=fromPackageDate;
	}
	public String getFromPackageDate(){
		return fromPackageDate;
	}
	public String getToPackageDate() {
		return toPackageDate;
	}
	public void setToPackageDate(String toPackageDate) {
		this.toPackageDate = toPackageDate;
	}
	public int getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}
	public int getOrderStageId() {
		return orderStageId;
	}
	public void setOrderStageId(int orderStageId) {
		this.orderStageId = orderStageId;
	}
	public ArrayList<OrderStageActionForm> getOrderStageList() {
		return orderStageList;
	}
	public void setOrderStageList(ArrayList<OrderStageActionForm> orderStageList) {
		this.orderStageList = orderStageList;
	}
	public int[] getAreaMasterId() {
		return areaMasterId;
	}
	public ArrayList<OrderMasterActionForm> getOrderMasterList() {
		return orderMasterList;
	}
	public void setOrderMasterList(ArrayList<OrderMasterActionForm> orderMasterList) {
		this.orderMasterList = orderMasterList;
	}
	public String getVillageName() {
		return villageName;
	}
	public void setVillageName(String villageName) {
		this.villageName = villageName;
	}
	public void setAreaMasterId(int[] areaMasterId) {
		this.areaMasterId = areaMasterId;
	}
	public int[] getPOStatusId() {
		return POStatusId;
	}
	public void setPOStatusId(int[] pOStatusId) {
		POStatusId = pOStatusId;
	}
	public int[] getPOId() {
		return POId;
	}
	public void setPOId(int[] pOId) {
		POId = pOId;
	}
	public int[] getOrderMasterId() {
		return orderMasterId;
	}
	public void setOrderMasterId(int[] orderMasterId) {
		this.orderMasterId = orderMasterId;
	}
	public String getAlertMsg() {
		return alertMsg;
	}
	public void setAlertMsg(String alertMsg) {
		this.alertMsg = alertMsg;
	}
	public int[] getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int[] supplierId) {
		this.supplierId = supplierId;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public int[] getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int[] customerId) {
		this.customerId = customerId;
	}
	public int[] getActive() {
		return active;
	}
	public void setActive(int[] active) {
		this.active = active;
	}
	
	public int getCritical() {
		return critical;
	}
	public void setCritical(int critical) {
		this.critical = critical;
	}
	
	public int getDateVal() {
		return dateVal;
	}
	public void setDateVal(int dateVal) {
		this.dateVal = dateVal;
	}
	
	public int getStockStatus() {
		return stockStatus;
	}
	public void setStockStatus(int stockStatus) {
		this.stockStatus = stockStatus;
	}
	public ArrayList<UserActionForm> getUserList() {
		return userList;
	}
	public void setUserList(ArrayList<UserActionForm> userList) {
		this.userList = userList;
	}
	
	
	public int getFilterSelect() {
		return filterSelect;
	}
	public void setFilterSelect(int filterSelect) {
		this.filterSelect = filterSelect;
	}
	
	public int[] getItemIds() {
		return itemIds;
	}
	public void setItemIds(int[] itemIds) {
		this.itemIds = itemIds;
	}
	
	public int[] getItemActive() {
		return itemActive;
	}
	public void setItemActive(int[] itemActive) {
		this.itemActive = itemActive;
	}
	public int[] getItemType() {
		return itemType;
	}
	public void setItemType(int[] itemType) {
		this.itemType = itemType;
	}
	public int[] getSupplierStatus() {
		return supplierStatus;
	}
	public void setSupplierStatus(int[] supplierStatus) {
		this.supplierStatus = supplierStatus;
	}
	public int[] getSupplierType() {
		return supplierType;
	}
	public void setSupplierType(int[] supplierType) {
		this.supplierType = supplierType;
	}
	public int[] getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int[] companyId) {
		this.companyId = companyId;
	}
	public int[] getUserId() {
		return userId;
	}
	public void setUserId(int[] userId) {
		this.userId = userId;
	}
	public int[] getUserRole() {
		return userRole;
	}
	public void setUserRole(int[] userRole) {
		this.userRole = userRole;
	}
	
	public int[] getSiteid() {
		return siteid;
	}
	public void setSiteid(int[] siteid) {
		this.siteid = siteid;
	}
	
	public ArrayList<ItemActionForm> getItemList() {
		return itemList;
	}
	public void setItemList(ArrayList<ItemActionForm> itemList) {
		this.itemList = itemList;
	}
	public ArrayList<ItemCategoryActionForm> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(ArrayList<ItemCategoryActionForm> categoryList) {
		this.categoryList = categoryList;
	}
	
	
}
