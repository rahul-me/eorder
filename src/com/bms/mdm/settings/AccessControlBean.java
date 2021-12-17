package com.bms.mdm.settings;

import java.util.ArrayList;

import com.bms.neetai.userroles.UserRoleActionForm;
import com.bms.struts.SCMActionForm;

public class AccessControlBean extends SCMActionForm{

	private int userId;	
	private int userRolesMasterId;		
	
	private String orderAccessControl;
	private String orderListAccessControl;
	private String showHideOrderAccessControl;
	
	private String reportAccessControl;
	
	private String orderManagmentAccessControl;
	
	private String accessControl;
	private String itemPriceAccessControl;
	private String settingConfigureAccessControl;
	private String showHideSettingAccessControl;
	
	
	private String packageAccessControl;
	private String packageListAccessControl;
	private String showHidePackageAccessControl;
	
	private String itemAccessControl;
	private String itemListAccessControl;
	private String showHideItemAccessControl;
		
	private String itemCategoryAccessControl;
	private String itemCategoryListAccessControl;
	private String showHideItemCategoryAccessControl;
		
	private String companyAccessControl;
	private String companyListAccessControl;
 	private String showHideCompanyAccessControl;
 	
 	private String orderStageAccessControl;
 	private String orderStageListAccessControl;
 	private String showHideOrderStageAccessControl;
 	
 	private String measurementAccessControl;
 	private String measurementListAccessControl;
 	private String showHideMeasurementAccessControl;
 	
 	private String customerAccessControl;
 	private String customerListAccessControl;
 	private String showHideCustomerAccessControl;
 	
 	private String userAccessControl;
 	private String userListAccessControl;
 	private String showHideUserAccessControl;
 	
 	private String userRoleAccessControl;
 	private String userRoleListAccessControl;
 	private String showHideUserRoleAccessControl;
 	
 	private String showHideMasterDataAccessControl;
 	
 	private String saleAccessControl;
 	private String companydetailac;
 	private String accountaccess;
 	private String shorderReportContol;
 	private String orderReportContol;
 	private String editableUnitCost;
	public String getEditableUnitCost() {
		return editableUnitCost;
	}

	public void setEditableUnitCost(String editableUnitCost) {
		this.editableUnitCost = editableUnitCost;
	}

	public String getShorderReportContol() {
		return shorderReportContol;
	}

	public void setShorderReportContol(String shorderReportContol) {
		this.shorderReportContol = shorderReportContol;
	}

	public String getOrderReportContol() {
		return orderReportContol;
	}

	public void setOrderReportContol(String orderReportContol) {
		this.orderReportContol = orderReportContol;
	}

	public String getAccountaccess() {
		return accountaccess;
	}

	public void setAccountaccess(String accountaccess) {
		this.accountaccess = accountaccess;
	}

	public String getCompanydetailac() {
		return companydetailac;
	}

	public void setCompanydetailac(String companydetailac) {
		this.companydetailac = companydetailac;
	}

	private ArrayList<UserRoleActionForm> roleList=null;
	
	public String getSaleAccessControl() {
		return saleAccessControl;
	}

	public void setSaleAccessControl(String saleAccessControl) {
		this.saleAccessControl = saleAccessControl;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUserRolesMasterId() {
		return userRolesMasterId;
	}

	public void setUserRolesMasterId(int userRolesMasterId) {
		this.userRolesMasterId = userRolesMasterId;
	}

	public String getOrderAccessControl() {
		return orderAccessControl;
	}

	public void setOrderAccessControl(String orderAccessControl) {
		this.orderAccessControl = orderAccessControl;
	}

	public String getOrderListAccessControl() {
		return orderListAccessControl;
	}

	public void setOrderListAccessControl(String orderListAccessControl) {
		this.orderListAccessControl = orderListAccessControl;
	}

	public String getShowHideOrderAccessControl() {
		return showHideOrderAccessControl;
	}

	public void setShowHideOrderAccessControl(String showHideOrderAccessControl) {
		this.showHideOrderAccessControl = showHideOrderAccessControl;
	}

	public String getReportAccessControl() {
		return reportAccessControl;
	}

	public void setReportAccessControl(String reportAccessControl) {
		this.reportAccessControl = reportAccessControl;
	}

	public String getOrderManagmentAccessControl() {
		return orderManagmentAccessControl;
	}

	public void setOrderManagmentAccessControl(String orderManagmentAccessControl) {
		this.orderManagmentAccessControl = orderManagmentAccessControl;
	}

	public String getAccessControl() {
		return accessControl;
	}

	public void setAccessControl(String accessControl) {
		this.accessControl = accessControl;
	}

	public String getItemPriceAccessControl() {
		return itemPriceAccessControl;
	}

	public void setItemPriceAccessControl(String itemPriceAccessControl) {
		this.itemPriceAccessControl = itemPriceAccessControl;
	}

	public String getSettingConfigureAccessControl() {
		return settingConfigureAccessControl;
	}

	public void setSettingConfigureAccessControl(String settingConfigureAccessControl) {
		this.settingConfigureAccessControl = settingConfigureAccessControl;
	}

	public String getShowHideSettingAccessControl() {
		return showHideSettingAccessControl;
	}

	public void setShowHideSettingAccessControl(String showHideSettingAccessControl) {
		this.showHideSettingAccessControl = showHideSettingAccessControl;
	}

	public String getPackageAccessControl() {
		return packageAccessControl;
	}

	public void setPackageAccessControl(String packageAccessControl) {
		this.packageAccessControl = packageAccessControl;
	}

	public String getPackageListAccessControl() {
		return packageListAccessControl;
	}

	public void setPackageListAccessControl(String packageListAccessControl) {
		this.packageListAccessControl = packageListAccessControl;
	}

	public String getShowHidePackageAccessControl() {
		return showHidePackageAccessControl;
	}

	public void setShowHidePackageAccessControl(String showHidePackageAccessControl) {
		this.showHidePackageAccessControl = showHidePackageAccessControl;
	}

	public String getItemAccessControl() {
		return itemAccessControl;
	}

	public void setItemAccessControl(String itemAccessControl) {
		this.itemAccessControl = itemAccessControl;
	}

	public String getItemListAccessControl() {
		return itemListAccessControl;
	}

	public void setItemListAccessControl(String itemListAccessControl) {
		this.itemListAccessControl = itemListAccessControl;
	}

	public String getShowHideItemAccessControl() {
		return showHideItemAccessControl;
	}

	public void setShowHideItemAccessControl(String showHideItemAccessControl) {
		this.showHideItemAccessControl = showHideItemAccessControl;
	}

	public String getItemCategoryAccessControl() {
		return itemCategoryAccessControl;
	}

	public void setItemCategoryAccessControl(String itemCategoryAccessControl) {
		this.itemCategoryAccessControl = itemCategoryAccessControl;
	}

	public String getItemCategoryListAccessControl() {
		return itemCategoryListAccessControl;
	}

	public void setItemCategoryListAccessControl(String itemCategoryListAccessControl) {
		this.itemCategoryListAccessControl = itemCategoryListAccessControl;
	}

	public String getShowHideItemCategoryAccessControl() {
		return showHideItemCategoryAccessControl;
	}

	public void setShowHideItemCategoryAccessControl(String showHideItemCategoryAccessControl) {
		this.showHideItemCategoryAccessControl = showHideItemCategoryAccessControl;
	}

	public String getCompanyAccessControl() {
		return companyAccessControl;
	}

	public void setCompanyAccessControl(String companyAccessControl) {
		this.companyAccessControl = companyAccessControl;
	}

	public String getCompanyListAccessControl() {
		return companyListAccessControl;
	}

	public void setCompanyListAccessControl(String companyListAccessControl) {
		this.companyListAccessControl = companyListAccessControl;
	}

	public String getShowHideCompanyAccessControl() {
		return showHideCompanyAccessControl;
	}

	public void setShowHideCompanyAccessControl(String showHideCompanyAccessControl) {
		this.showHideCompanyAccessControl = showHideCompanyAccessControl;
	}

	public String getOrderStageAccessControl() {
		return orderStageAccessControl;
	}

	public void setOrderStageAccessControl(String orderStageAccessControl) {
		this.orderStageAccessControl = orderStageAccessControl;
	}

	public String getOrderStageListAccessControl() {
		return orderStageListAccessControl;
	}

	public void setOrderStageListAccessControl(String orderStageListAccessControl) {
		this.orderStageListAccessControl = orderStageListAccessControl;
	}

	public String getShowHideOrderStageAccessControl() {
		return showHideOrderStageAccessControl;
	}

	public void setShowHideOrderStageAccessControl(String showHideOrderStageAccessControl) {
		this.showHideOrderStageAccessControl = showHideOrderStageAccessControl;
	}

	public String getMeasurementAccessControl() {
		return measurementAccessControl;
	}

	public void setMeasurementAccessControl(String measurementAccessControl) {
		this.measurementAccessControl = measurementAccessControl;
	}

	public String getMeasurementListAccessControl() {
		return measurementListAccessControl;
	}

	public void setMeasurementListAccessControl(String measurementListAccessControl) {
		this.measurementListAccessControl = measurementListAccessControl;
	}

	public String getShowHideMeasurementAccessControl() {
		return showHideMeasurementAccessControl;
	}

	public void setShowHideMeasurementAccessControl(String showHideMeasurementAccessControl) {
		this.showHideMeasurementAccessControl = showHideMeasurementAccessControl;
	}

	public String getCustomerAccessControl() {
		return customerAccessControl;
	}

	public void setCustomerAccessControl(String customerAccessControl) {
		this.customerAccessControl = customerAccessControl;
	}

	public String getCustomerListAccessControl() {
		return customerListAccessControl;
	}

	public void setCustomerListAccessControl(String customerListAccessControl) {
		this.customerListAccessControl = customerListAccessControl;
	}

	public String getShowHideCustomerAccessControl() {
		return showHideCustomerAccessControl;
	}

	public void setShowHideCustomerAccessControl(String showHideCustomerAccessControl) {
		this.showHideCustomerAccessControl = showHideCustomerAccessControl;
	}

	public String getUserAccessControl() {
		return userAccessControl;
	}

	public void setUserAccessControl(String userAccessControl) {
		this.userAccessControl = userAccessControl;
	}

	public String getUserListAccessControl() {
		return userListAccessControl;
	}

	public void setUserListAccessControl(String userListAccessControl) {
		this.userListAccessControl = userListAccessControl;
	}

	public String getShowHideUserAccessControl() {
		return showHideUserAccessControl;
	}

	public void setShowHideUserAccessControl(String showHideUserAccessControl) {
		this.showHideUserAccessControl = showHideUserAccessControl;
	}

	public String getUserRoleAccessControl() {
		return userRoleAccessControl;
	}

	public void setUserRoleAccessControl(String userRoleAccessControl) {
		this.userRoleAccessControl = userRoleAccessControl;
	}

	public String getUserRoleListAccessControl() {
		return userRoleListAccessControl;
	}

	public void setUserRoleListAccessControl(String userRoleListAccessControl) {
		this.userRoleListAccessControl = userRoleListAccessControl;
	}

	public String getShowHideUserRoleAccessControl() {
		return showHideUserRoleAccessControl;
	}

	public void setShowHideUserRoleAccessControl(String showHideUserRoleAccessControl) {
		this.showHideUserRoleAccessControl = showHideUserRoleAccessControl;
	}

	public String getShowHideMasterDataAccessControl() {
		return showHideMasterDataAccessControl;
	}

	public void setShowHideMasterDataAccessControl(String showHideMasterDataAccessControl) {
		this.showHideMasterDataAccessControl = showHideMasterDataAccessControl;
	}

	public ArrayList<UserRoleActionForm> getRoleList() {
		return roleList;
	}

	public void setRoleList(ArrayList<UserRoleActionForm> roleList) {
		this.roleList = roleList;
	}


	
}
