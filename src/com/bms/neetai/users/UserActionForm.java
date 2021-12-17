package com.bms.neetai.users;

import java.util.ArrayList;

import org.omg.CORBA.PRIVATE_MEMBER;

import com.bms.neetai.company.CompanyActionForm;
import com.bms.neetai.userroles.UserRoleActionForm;
import com.bms.struts.SCMActionForm;

public class UserActionForm extends SCMActionForm{
																				
	private int userMasterId;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String phoneNumber1;
	private String address;
	private String userRoleName;
	private String createdDTTM;
	private String modifiedDTTM;
	private int createdBy;
	private int modifiedBy;
	private String email;
	private String phoneNumber2;
	private int isActive;
	private int userRolesMasterId;
	private int companyMasterId;
	private int customerMasterId;
	private String city;
	private String state;
	private String country;
	private int pincode;
	private String userCode;
	
	private ArrayList<UserActionForm> userList=null;
	private ArrayList<UserRoleActionForm> roleList=null;
	
	
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
	public ArrayList<CompanyActionForm> getCompanyList() {
		return companyList;
	}
	public void setCompanyList(ArrayList<CompanyActionForm> companyList) {
		this.companyList = companyList;
	}
	private ArrayList<CompanyActionForm> companyList=null;
	
	public int getUserMasterId() {
		return userMasterId;
	}
	public void setUserMasterId(int userMasterId) {
		this.userMasterId = userMasterId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNumber1() {
		return phoneNumber1;
	}
	public void setPhoneNumber1(String phoneNumber1) {
		this.phoneNumber1 = phoneNumber1;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getUserRoleName() {
		return userRoleName;
	}
	public void setUserRoleName(String userRoleName) {
		this.userRoleName = userRoleName;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhoneNumber2() {
		return phoneNumber2;
	}
	public void setPhoneNumber2(String phoneNumber2) {
		this.phoneNumber2 = phoneNumber2;
	}
	
	public int getUserRolesMasterId() {
		return userRolesMasterId;
	}
	public void setUserRolesMasterId(int userRolesMasterId) {
		this.userRolesMasterId = userRolesMasterId;
	}
	public int getCompanyMasterId() {
		return companyMasterId;
	}
	public void setCompanyMasterId(int companyMasterId) {
		this.companyMasterId = companyMasterId;
	}
		
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	public int getCustomerMasterId() {
		return customerMasterId;
	}
	public void setCustomerMasterId(int customerMasterId) {
		this.customerMasterId = customerMasterId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	

		
}

