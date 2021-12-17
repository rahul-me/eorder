package com.bms.context;

import java.util.ArrayList;
import java.util.HashMap;

import com.bms.mdm.item.ItemActionForm;
import com.bms.mdm.itemcategories.ItemCategoryActionForm;
import com.bms.mdm.measurement.MeasurementActionForm;
import com.bms.mdm.orderstage.OrderStageActionForm;
import com.bms.neetai.company.CompanyActionForm;
import com.bms.neetai.userroles.UserRoleActionForm;
import com.bms.neetai.users.UserActionForm;




/**
 * 
 * This class is being used as the application context class.
 * 
 * this class object is picked at the application at various places and modified. 
 * 
 * @author parth gandhi
 */


public class ServerAppContext {

	private final String TAG = "com.bms.context.ServerAppContext" ;
	
	private ArrayList<ItemActionForm> itemList=new ArrayList<ItemActionForm>();
	private ArrayList<ItemActionForm> itemListByActiveItem=new ArrayList<ItemActionForm>();
	private HashMap<Integer,ItemActionForm> itemByItemMasterId=new HashMap<Integer,ItemActionForm>();
	//private ArrayList<ItemActionForm> itemByCompanyList=new ArrayList<ItemActionForm>();
	private HashMap<Integer,ArrayList<ItemActionForm>> itemByCompanyId=new HashMap<Integer,ArrayList<ItemActionForm>>();
	
	private ArrayList<ItemCategoryActionForm>itemCategoryList=new ArrayList<ItemCategoryActionForm>();
	private ArrayList<ItemCategoryActionForm>itemCategoryListByActiveitemCategory=new ArrayList<ItemCategoryActionForm>();
	private HashMap<Integer, ItemCategoryActionForm>itemCategoryByItemCategoryMasterId=new HashMap<Integer,ItemCategoryActionForm>();
	private ArrayList<ItemCategoryActionForm>itemCategoryByCompanyList=new ArrayList<ItemCategoryActionForm>();
	private HashMap<Integer,ArrayList<ItemCategoryActionForm>>itemCategoryByCompanyId=new HashMap<Integer,ArrayList<ItemCategoryActionForm>>();
	
	private ArrayList<CompanyActionForm>companyList=new ArrayList<CompanyActionForm>();
	private ArrayList<CompanyActionForm>companyListByActiveCompany=new ArrayList<CompanyActionForm>();
	private HashMap<Integer, CompanyActionForm>companyByCompanyMasterId=new HashMap<Integer,CompanyActionForm>();
	
	private ArrayList<OrderStageActionForm>orderStageList=new ArrayList<OrderStageActionForm>();
	private ArrayList<OrderStageActionForm>orderStageListByActiveOrderStage=new ArrayList<OrderStageActionForm>();
	private HashMap<Integer, OrderStageActionForm>orderStageByOrderStageMasterId=new HashMap<Integer,OrderStageActionForm>();
	private ArrayList<OrderStageActionForm>orderStageByCompanyList=new ArrayList<OrderStageActionForm>();
	private HashMap<Integer, ArrayList<OrderStageActionForm>>orderStageByCompanyMasterId=new HashMap<Integer,ArrayList<OrderStageActionForm>>();
	
	private ArrayList<MeasurementActionForm>measurementList=new ArrayList<MeasurementActionForm>();
	private ArrayList<MeasurementActionForm>measurementListByActiveMeasurement=new ArrayList<MeasurementActionForm>();
	private HashMap<Integer, MeasurementActionForm>measurementByMeasurementMasterId=new HashMap<Integer, MeasurementActionForm>();
	private ArrayList<MeasurementActionForm>measurementByCompanyList=new ArrayList<MeasurementActionForm>();
	private HashMap<Integer,ArrayList<MeasurementActionForm>>measurementByCompanyMasterId=new HashMap<Integer,ArrayList<MeasurementActionForm>>();
	
	private ArrayList<UserActionForm>userList=new ArrayList<UserActionForm>();
	private ArrayList<UserActionForm>userListByActiveUser=new ArrayList<UserActionForm>();	
	private HashMap<Integer,UserActionForm>userByUserMasterId=new HashMap<Integer,UserActionForm>();
	private ArrayList<UserActionForm>userByCompanyList=new ArrayList<UserActionForm>();
	private HashMap<Integer,ArrayList<UserActionForm>>userByCompanyId=new HashMap<Integer,ArrayList<UserActionForm>>();
	//private ArrayList<UserActionForm>userByCompanyIdandRollId=new ArrayList<UserActionForm>();
	
	private ArrayList<UserRoleActionForm>userRollList=new ArrayList<UserRoleActionForm>();
	private ArrayList<UserRoleActionForm>userRollListByActiveUserRole=new ArrayList<UserRoleActionForm>();
	private HashMap<Integer, UserRoleActionForm>userRollByUserRollMasterId=new HashMap<Integer,UserRoleActionForm>();
	private ArrayList<UserRoleActionForm>userRollByCompanyList=new ArrayList<UserRoleActionForm>();
	private HashMap<Integer,ArrayList<UserRoleActionForm>>userRollByCompanyMasterId=new HashMap<Integer,ArrayList<UserRoleActionForm>>();
	
	private HashMap<Integer,String> accessRoles;
	
	public ArrayList<ItemActionForm> getItemList() {
		return itemList;
	}



	public void setItemList(ArrayList<ItemActionForm> itemList) {
		this.itemList = itemList;
	}



	public ArrayList<ItemActionForm> getItemListByActiveItem() {
		return itemListByActiveItem;
	}



	public void setItemListByActiveItem(
			ArrayList<ItemActionForm> itemListByActiveItem) {
		this.itemListByActiveItem = itemListByActiveItem;
	}



	public HashMap<Integer, ItemActionForm> getItemByItemMasterId() {
		return itemByItemMasterId;
	}



	public void setItemByItemMasterId(
			HashMap<Integer, ItemActionForm> itemByItemMasterId) {
		this.itemByItemMasterId = itemByItemMasterId;
	}



	public ArrayList<ItemCategoryActionForm> getItemCategoryList() {
		return itemCategoryList;
	}



	public void setItemCategoryList(
			ArrayList<ItemCategoryActionForm> itemCategoryList) {
		this.itemCategoryList = itemCategoryList;
	}



	public ArrayList<ItemCategoryActionForm> getItemCategoryListByActiveitemCategory() {
		return itemCategoryListByActiveitemCategory;
	}



	public void setItemCategoryListByActiveitemCategory(
			ArrayList<ItemCategoryActionForm> itemCategoryListByActiveitemCategory) {
		this.itemCategoryListByActiveitemCategory = itemCategoryListByActiveitemCategory;
	}



	public HashMap<Integer, ItemCategoryActionForm> getItemCategoryByItemCategoryMasterId() {
		return itemCategoryByItemCategoryMasterId;
	}



	public void setItemCategoryByItemCategoryMasterId(
			HashMap<Integer, ItemCategoryActionForm> itemCategoryByItemCategoryMasterId) {
		this.itemCategoryByItemCategoryMasterId = itemCategoryByItemCategoryMasterId;
	}



	public ArrayList<CompanyActionForm> getCompanyList() {
		return companyList;
	}



	public void setCompanyList(ArrayList<CompanyActionForm> companyList) {
		this.companyList = companyList;
	}



	public ArrayList<CompanyActionForm> getCompanyListByActiveCompany() {
		return companyListByActiveCompany;
	}



	public void setCompanyListByActiveCompany(
			ArrayList<CompanyActionForm> companyListByActiveCompany) {
		this.companyListByActiveCompany = companyListByActiveCompany;
	}



	public HashMap<Integer, CompanyActionForm> getCompanyByCompanyMasterId() {
		return companyByCompanyMasterId;
	}



	public void setCompanyByCompanyMasterId(
			HashMap<Integer, CompanyActionForm> companyByCompanyMasterId) {
		this.companyByCompanyMasterId = companyByCompanyMasterId;
	}



	public ArrayList<OrderStageActionForm> getOrderStageList() {
		return orderStageList;
	}



	public void setOrderStageList(ArrayList<OrderStageActionForm> orderStageList) {
		this.orderStageList = orderStageList;
	}



	public ArrayList<OrderStageActionForm> getOrderStageListByActiveOrderStage() {
		return orderStageListByActiveOrderStage;
	}



	public void setOrderStageListByActiveOrderStage(
			ArrayList<OrderStageActionForm> orderStageListByActiveOrderStage) {
		this.orderStageListByActiveOrderStage = orderStageListByActiveOrderStage;
	}



	public HashMap<Integer, OrderStageActionForm> getOrderStageByOrderStageMasterId() {
		return orderStageByOrderStageMasterId;
	}



	public void setOrderStageByOrderStageMasterId(
			HashMap<Integer, OrderStageActionForm> orderStageByOrderStageMasterId) {
		this.orderStageByOrderStageMasterId = orderStageByOrderStageMasterId;
	}



	public ArrayList<MeasurementActionForm> getMeasurementList() {
		return measurementList;
	}



	public void setMeasurementList(ArrayList<MeasurementActionForm> measurementList) {
		this.measurementList = measurementList;
	}



	public ArrayList<MeasurementActionForm> getMeasurementListByActiveMeasurement() {
		return measurementListByActiveMeasurement;
	}



	public void setMeasurementListByActiveMeasurement(
			ArrayList<MeasurementActionForm> measurementListByActiveMeasurement) {
		this.measurementListByActiveMeasurement = measurementListByActiveMeasurement;
	}



	public HashMap<Integer, MeasurementActionForm> getMeasurementByMeasurementMasterId() {
		return measurementByMeasurementMasterId;
	}



	public void setMeasurementByMeasurementMasterId(
			HashMap<Integer, MeasurementActionForm> measurementByMeasurementMasterId) {
		this.measurementByMeasurementMasterId = measurementByMeasurementMasterId;
	}



	public ArrayList<UserActionForm> getUserList() {
		return userList;
	}



	public void setUserList(ArrayList<UserActionForm> userList) {
		this.userList = userList;
	}



	public ArrayList<UserActionForm> getUserListByActiveUser() {
		return userListByActiveUser;
	}



	public void setUserListByActiveUser(
			ArrayList<UserActionForm> userListByActiveUser) {
		this.userListByActiveUser = userListByActiveUser;
	}



	public HashMap<Integer, UserActionForm> getUserByUserMasterId() {
		return userByUserMasterId;
	}



	public void setUserByUserMasterId(
			HashMap<Integer, UserActionForm> userByUserMasterId) {
		this.userByUserMasterId = userByUserMasterId;
	}



	public ArrayList<UserRoleActionForm> getUserRollList() {
		return userRollList;
	}



	public void setUserRollList(ArrayList<UserRoleActionForm> userRollList) {
		this.userRollList = userRollList;
	}



	public ArrayList<UserRoleActionForm> getUserRollListByActiveUserRole() {
		return userRollListByActiveUserRole;
	}



	public void setUserRollListByActiveUserRole(
			ArrayList<UserRoleActionForm> userRollListByActiveUserRole) {
		this.userRollListByActiveUserRole = userRollListByActiveUserRole;
	}



	public HashMap<Integer, UserRoleActionForm> getUserRollByUserRollMasterId() {
		return userRollByUserRollMasterId;
	}



	public void setUserRollByUserRollMasterId(
			HashMap<Integer, UserRoleActionForm> userRollByUserRollMasterId) {
		this.userRollByUserRollMasterId = userRollByUserRollMasterId;
	}

	public ArrayList<UserRoleActionForm> getUserRollByCompanyList() {
		return userRollByCompanyList;
	}



	public void setUserRollByCompanyList(
			ArrayList<UserRoleActionForm> userRollByCompanyList) {
		this.userRollByCompanyList = userRollByCompanyList;
	}


	public String getTAG() {
		return TAG;
	}



	public HashMap<Integer, String> getAccessRoles() {
		return accessRoles;
	}
	
	
	
	public void setAccessRoles(HashMap<Integer, String> accessRoles) {
		this.accessRoles = accessRoles;
	}



	public HashMap<Integer, ArrayList<UserRoleActionForm>> getUserRollByCompanyMasterId() {
		return userRollByCompanyMasterId;
	}



	public void setUserRollByCompanyMasterId(
			HashMap<Integer, ArrayList<UserRoleActionForm>> userRollByCompanyMasterId) {
		this.userRollByCompanyMasterId = userRollByCompanyMasterId;
	}



	/*public ArrayList<ItemActionForm> getItemByCompanyList() {
		return itemByCompanyList;
	}



	public void setItemByCompanyList(ArrayList<ItemActionForm> itemByCompanyList) {
		this.itemByCompanyList = itemByCompanyList;
	}*/



	public HashMap<Integer, ArrayList<ItemActionForm>> getItemByCompanyId() {
		return itemByCompanyId;
	}



	public void setItemByCompanyId(
			HashMap<Integer, ArrayList<ItemActionForm>> itemByCompanyId) {
		this.itemByCompanyId = itemByCompanyId;
	}



	public ArrayList<UserActionForm> getUserByCompanyList() {
		return userByCompanyList;
	}



	public void setUserByCompanyList(ArrayList<UserActionForm> userByCompanyList) {
		this.userByCompanyList = userByCompanyList;
	}



	public HashMap<Integer, ArrayList<UserActionForm>> getUserByCompanyId() {
		return userByCompanyId;
	}



	public void setUserByCompanyId(
			HashMap<Integer, ArrayList<UserActionForm>> userByCompanyId) {
		this.userByCompanyId = userByCompanyId;
	}



	public ArrayList<ItemCategoryActionForm> getItemCategoryByCompanyList() {
		return itemCategoryByCompanyList;
	}



	public void setItemCategoryByCompanyList(
			ArrayList<ItemCategoryActionForm> itemCategoryByCompanyList) {
		this.itemCategoryByCompanyList = itemCategoryByCompanyList;
	}



	public HashMap<Integer, ArrayList<ItemCategoryActionForm>> getItemCategoryByCompanyId() {
		return itemCategoryByCompanyId;
	}



	public void setItemCategoryByCompanyId(
			HashMap<Integer, ArrayList<ItemCategoryActionForm>> itemCategoryByCompanyId) {
		this.itemCategoryByCompanyId = itemCategoryByCompanyId;
	}



	public ArrayList<OrderStageActionForm> getOrderStageByCompanyList() {
		return orderStageByCompanyList;
	}



	public void setOrderStageByCompanyList(
			ArrayList<OrderStageActionForm> orderStageByCompanyList) {
		this.orderStageByCompanyList = orderStageByCompanyList;
	}



	public HashMap<Integer, ArrayList<OrderStageActionForm>> getOrderStageByCompanyMasterId() {
		return orderStageByCompanyMasterId;
	}



	public void setOrderStageByCompanyMasterId(
			HashMap<Integer, ArrayList<OrderStageActionForm>> orderStageByCompanyMasterId) {
		this.orderStageByCompanyMasterId = orderStageByCompanyMasterId;
	}



	public ArrayList<MeasurementActionForm> getMeasurementByCompanyList() {
		return measurementByCompanyList;
	}



	public void setMeasurementByCompanyList(
			ArrayList<MeasurementActionForm> measurementByCompanyList) {
		this.measurementByCompanyList = measurementByCompanyList;
	}



	public HashMap<Integer, ArrayList<MeasurementActionForm>> getMeasurementByCompanyMasterId() {
		return measurementByCompanyMasterId;
	}



	public void setMeasurementByCompanyMasterId(
			HashMap<Integer, ArrayList<MeasurementActionForm>> measurementByCompanyMasterId) {
		this.measurementByCompanyMasterId = measurementByCompanyMasterId;
	}
	


}