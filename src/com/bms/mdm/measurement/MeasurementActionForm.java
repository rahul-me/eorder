package com.bms.mdm.measurement;

import java.util.ArrayList;

import com.bms.struts.SCMActionForm;

public class MeasurementActionForm extends SCMActionForm  {
	
	
	private int measurementMasterId;
	private String unit;
	private String name;
	private String symbol;
	private int createdBy;
	private String createdDTTM;
	private int modifiedBy;
	private String modifiedDTTM;
	private int isActive;
	private int companyMasterId;
	
	private ArrayList<MeasurementActionForm> measurementList=null;
	
	public ArrayList<MeasurementActionForm> getMeasurementList() {
		return measurementList;
	}
	public void setMeasurementList(ArrayList<MeasurementActionForm> measurementList) {
		this.measurementList = measurementList;
	}
	public int getMeasurementMasterId() {
		return measurementMasterId;
	}
	public void setMeasurementMasterId(int measurementMasterId) {
		this.measurementMasterId = measurementMasterId;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
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
	public int getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public String getModifiedDTTM() {
		return modifiedDTTM;
	}
	public void setModifiedDTTM(String modifiedDTTM) {
		this.modifiedDTTM = modifiedDTTM;
	}
	
	public int getCompanyMasterId() {
		return companyMasterId;
	}
	public void setCompanyMasterId(int companyMasterId) {
		this.companyMasterId = companyMasterId;
	}
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	
	

	

}
