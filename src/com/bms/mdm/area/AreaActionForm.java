package com.bms.mdm.area;

import com.bms.struts.SCMActionForm;

public class AreaActionForm extends SCMActionForm {

	private int areaMasterId;
	private String areaName;
	private int createdBY;
	private String createdDTTM;
	private int modifiedBY;
	private String modifiedDTTM;
	
	public int getAreaMasterId() {
		return areaMasterId;
	}
	public void setAreaMasterId(int areaMasterId) {
		this.areaMasterId = areaMasterId;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public int getCreatedBY() {
		return createdBY;
	}
	public void setCreatedBY(int createdBY) {
		this.createdBY = createdBY;
	}
	public String getCreatedDTTM() {
		return createdDTTM;
	}
	public void setCreatedDTTM(String createdDTTM) {
		this.createdDTTM = createdDTTM;
	}
	public int getModifiedBY() {
		return modifiedBY;
	}
	public void setModifiedBY(int modifiedBY) {
		this.modifiedBY = modifiedBY;
	}
	public String getModifiedDTTM() {
		return modifiedDTTM;
	}
	public void setModifiedDTTM(String modifiedDTTM) {
		this.modifiedDTTM = modifiedDTTM;
	}
	
	
}
