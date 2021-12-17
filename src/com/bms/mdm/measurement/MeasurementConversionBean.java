package com.bms.mdm.measurement;

import com.bms.struts.SCMActionForm;

public class MeasurementConversionBean extends SCMActionForm {
	
	private int id;
	private int firstMeasurementId;
	private int secondMeasurementId;
	private double conversionValue;
	private String	createdBy;
	private String	createdDTTM;
	private String	modifiedBy;
	private String	modifiedDTTM;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFirstMeasurementId() {
		return firstMeasurementId;
	}
	public void setFirstMeasurementId(int firstMeasurementId) {
		this.firstMeasurementId = firstMeasurementId;
	}
	public int getSecondMeasurementId() {
		return secondMeasurementId;
	}
	public void setSecondMeasurementId(int secondMeasurementId) {
		this.secondMeasurementId = secondMeasurementId;
	}
	public double getConversionValue() {
		return conversionValue;
	}
	public void setConversionValue(double conversionValue) {
		this.conversionValue = conversionValue;
	}
	
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
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

}
