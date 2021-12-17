package com.bms.neetai.company;

import java.util.ArrayList;



import com.bms.struts.SCMActionForm;

public class CompanyActionForm extends SCMActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5889755456086124117L;
	private int companyMasterId;
	private String  name;
	private String address;
	private String contactPersonNumber;
	private String  phoneNumber1;
	private String phoneNumber;
	private String contactEmail;
	private int createdBy;
	private int modifiedBy;
	private String  createdDTTM;
	private String  modifiedDTTM;
	private String  logo;
	private int isActive;	
    private ArrayList<CompanyActionForm> companyList=null;
	
	public int getCompanyMasterId() {
		return companyMasterId;
	}
	public void setCompanyMasterId(int companyMasterId) {
		this.companyMasterId = companyMasterId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContactPersonNumber() {
		return contactPersonNumber;
	}
	public void setContactPersonNumber(String contactPersonNumber) {
		this.contactPersonNumber = contactPersonNumber;
	}
	public String getPhoneNumber1() {
		return phoneNumber1;
	}
	public void setPhoneNumber1(String phoneNumber1) {
		this.phoneNumber1 = phoneNumber1;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
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
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}    
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public ArrayList<CompanyActionForm> getCompanyList() {
		return companyList;
	}
	public void setCompanyList(ArrayList<CompanyActionForm> companyList) {
		this.companyList = companyList;
	}
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	
	// variable for additional company details
	
	private String cstidno;
	private String vatidno;
	private float saletax;
	private String submit;
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	public String getCstidno() {
		return cstidno;
	}
	public void setCstidno(String cstidno) {
		this.cstidno = cstidno;
	}
	public String getVatidno() {
		return vatidno;
	}
	public void setVatidno(String vatidno) {
		this.vatidno = vatidno;
	}
	public float getSaletax() {
		return saletax;
	}
	public void setSaletax(float saletax) {
		this.saletax = saletax;
	}
}

