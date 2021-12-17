package com.bms.retaildetail;

import org.apache.struts.action.ActionForm;

public class RetailDetailActionForm extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4687713598380429318L;
	
	private int retailid;
	private String cstidno;
	private String vatidno;
	private String suppref;
	public int getRetailid() {
		return retailid;
	}
	public void setRetailid(int retailid) {
		this.retailid = retailid;
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
	public String getSuppref() {
		return suppref;
	}
	public void setSuppref(String suppref) {
		this.suppref = suppref;
	}
		
}
