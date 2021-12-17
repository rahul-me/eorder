package com.bms.mdm.supercategory;

import com.bms.struts.SCMActionForm;

public class SuperCategoryActionForm extends SCMActionForm{
	private int superCategoryId;
	private int productMasterId;
	private String superCategoryCode;
	private String supercategoryDesc;
	public int getSuperCategoryId() {
		return superCategoryId;
	}
	public void setSuperCategoryId(int superCategoryId) {
		this.superCategoryId = superCategoryId;
	}
	public int getProductMasterId() {
		return productMasterId;
	}
	public void setProductMasterId(int productMasterId) {
		this.productMasterId = productMasterId;
	}
	public String getSuperCategoryCode() {
		return superCategoryCode;
	}
	public void setSuperCategoryCode(String superCategoryCode) {
		this.superCategoryCode = superCategoryCode;
	}
	public String getSupercategoryDesc() {
		return supercategoryDesc;
	}
	public void setSupercategoryDesc(String supercategoryDesc) {
		this.supercategoryDesc = supercategoryDesc;
	}
	
	
}
