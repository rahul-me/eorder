package com.bms.mdm.authorizationmatrix;


import com.bms.struts.SCMAction;

public class AuthorisedMatrixActionForm extends SCMAction{

	
	
	
	private int authMatrixId;
	private int roleId;
	private String modulekey;
	private int companyId;
	private int mappingStatus;
	private String createdDTTM;
	private int createdBY;
	private int authMatrixOf;
	
	
	
	public int getAuthMatrixOf() {
		return authMatrixOf;
	}
	public void setAuthMatrixOf(int authMatrixOf) {
		this.authMatrixOf = authMatrixOf;
	}
	public int getAuthMatrixId() {
		return authMatrixId;
	}
	public void setAuthMatrixId(int authMatrixId) {
		this.authMatrixId = authMatrixId;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getModulekey() {
		return modulekey;
	}
	public void setModulekey(String modulekey) {
		this.modulekey = modulekey;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public int getMappingStatus() {
		return mappingStatus;
	}
	public void setMappingStatus(int mappingStatus) {
		this.mappingStatus = mappingStatus;
	}
	public String getCreatedDTTM() {
		return createdDTTM;
	}
	public void setCreatedDTTM(String createdDTTM) {
		this.createdDTTM = createdDTTM;
	}
	public int getCreatedBY() {
		return createdBY;
	}
	public void setCreatedBY(int createdBY) {
		this.createdBY = createdBY;
	}
	/*@Override
	public void getFromMQMessage(Message message) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Message setInMQMessage(Message message) {
		// TODO Auto-generated method stub
		return null;
	}*/

	
	
	
}
