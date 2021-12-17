package com.bms.config;

import org.apache.struts.action.ActionForm;

public class ConfigActionForm extends ActionForm {
	
	private String property;
	private String value;
	private String propertyType;
	private int GRnClosePO;
	private int companyId;
	
	
	
	
	
	
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public int getGRnClosePO() {
		return GRnClosePO;
	}
	public void setGRnClosePO(int gRnClosePO) {
		GRnClosePO = gRnClosePO;
	}
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getPropertyType() {
		return propertyType;
	}
	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}
	

}
