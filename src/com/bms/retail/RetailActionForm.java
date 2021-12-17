package com.bms.retail;

public class RetailActionForm {
	
	private int retailmasterid;
	private int retailid;
	private int itemid;
	private int companymasterid;
	private float orderquantity;
	private float deliveredquantity;
	private float salequantity;
	private float returnquantity;
	public float getDeliveredquantity() {
		return deliveredquantity;
	}
	public void setDeliveredquantity(float deliveredquantity) {
		this.deliveredquantity = deliveredquantity;
	}
	public int getRetailmasterid() {
		return retailmasterid;
	}
	public void setRetailmasterid(int retailmasterid) {
		this.retailmasterid = retailmasterid;
	}
	public int getRetailid() {
		return retailid;
	}
	public void setRetailid(int retailid) {
		this.retailid = retailid;
	}
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public int getCompanymasterid() {
		return companymasterid;
	}
	public void setCompanymasterid(int companymasterid) {
		this.companymasterid = companymasterid;
	}
	public float getOrderquantity() {
		return orderquantity;
	}
	public void setOrderquantity(float orderquantity) {
		this.orderquantity = orderquantity;
	}	
	public float getSalequantity() {
		return salequantity;
	}
	public void setSalequantity(float salequantity) {
		this.salequantity = salequantity;
	}
	public float getReturnquantity() {
		return returnquantity;
	}
	public void setReturnquantity(float returnquantity) {
		this.returnquantity = returnquantity;
	}
	
	
	// Variables to combine retailer items (retailer - mdm_item)
	
	private int itemMasterId;
	private String name;
	private float itemPrice;
	private int measurementMasterId;
	public int getItemMasterId() {
		return itemMasterId;
	}
	public void setItemMasterId(int itemMasterId) {
		this.itemMasterId = itemMasterId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(float itemPrice) {
		this.itemPrice = itemPrice;
	}
	public int getMeasurementMasterId() {
		return measurementMasterId;
	}
	public void setMeasurementMasterId(int measurementMasterId) {
		this.measurementMasterId = measurementMasterId;
	}

}
