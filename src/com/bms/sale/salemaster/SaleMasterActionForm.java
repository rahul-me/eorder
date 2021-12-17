package com.bms.sale.salemaster;

public class SaleMasterActionForm {
		
	private int salemasterid;
	private String createdDate;
	private int companyMasterId;
	private int retailid;
	private float orderquantity;
	private float deliveredquantity;
	private String consumername;
	private String consumeraddress;
	private float total;	
	public String getConsumeraddress() {
		return consumeraddress;
	}
	public void setConsumeraddress(String consumeraddress) {
		this.consumeraddress = consumeraddress;
	}
	public String getConsumername() {
		return consumername;
	}
	public void setConsumername(String consumername) {
		this.consumername = consumername;
	}	
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public int getSalemasterid() {
		return salemasterid;
	}
	public void setSalemasterid(int salemasterid) {
		this.salemasterid = salemasterid;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public int getCompanyMasterId() {
		return companyMasterId;
	}
	public void setCompanyMasterId(int companyMasterId) {
		this.companyMasterId = companyMasterId;
	}
	public int getRetailid() {
		return retailid;
	}
	public void setRetailid(int retailid) {
		this.retailid = retailid;
	}
	public float getOrderquantity() {
		return orderquantity;
	}
	public void setOrderquantity(float orderquantity) {
		this.orderquantity = orderquantity;
	}
	public float getDeliveredquantity() {
		return deliveredquantity;
	}
	public void setDeliveredquantity(float deliveredquantity) {
		this.deliveredquantity = deliveredquantity;
	}
	

}
