package com.bms.sale.saledetail;

import org.apache.struts.action.ActionForm;

import com.bms.retail.RetailActionForm;

import java.util.ArrayList;


public class SaleDetailActionForm extends ActionForm{
	
		
	/**
	 * Form Bean to hold data for sale detail
	 */
	private static final long serialVersionUID = 6389846511515422611L;
	// Variables for sale_detail table
	private int saledetailid;
	private int itemid;
	private float quantity;
	private float rate;
	private float amount;
	private int salemasterid;	
	public int getSaledetailid(){
		return saledetailid;
	}
	public void setSaledetailid(int saledetailid) {
		this.saledetailid = saledetailid;
	}
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public float getQuantity() {
		return quantity;
	}
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public int getSalemasterid() {
		return salemasterid;
	}
	public void setSalemasterid(int salemasterid) {
		this.salemasterid = salemasterid;
	}
	
	// Variables for storage of fetched data
	// and will be fed into the form element
	private String retailer;
	private ArrayList<RetailActionForm> retailItems;
	public ArrayList<RetailActionForm> getRetailItems() {
		return retailItems;
	}
	public void setRetailItems(ArrayList<RetailActionForm> retailItems) {
		this.retailItems = retailItems;
	}
	public String getRetailer() {
		return retailer;
	}
	public void setRetailer(String retailer) {
		this.retailer = retailer;
	}	

	// Variables for fetching data for sale_master table
	private int retailid;	
	private String createdDate;	
	private float total;
	private String consumername;
	private String consumeraddress;	
	public String getConsumername() {
		return consumername;
	}
	public void setConsumername(String consumername) {
		this.consumername = consumername;
	}
	public String getConsumeraddress() {
		return consumeraddress;
	}
	public void setConsumeraddress(String consumeraddress) {
		this.consumeraddress = consumeraddress;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}	
	public int getRetailid() {
		return retailid;
	}
	public void setRetailid(int retailid) {
		this.retailid = retailid;
	}
	
	// variables to retain update result and update operation
	private int saleMasterIdForUpdate;
	private boolean update;	
	public int getSaleMasterIdForUpdate() {
		return saleMasterIdForUpdate;
	}
	public void setSaleMasterIdForUpdate(int saleMasterIdForUpdate) {
		this.saleMasterIdForUpdate = saleMasterIdForUpdate;
	}
	public boolean isUpdate() {
		return update;
	}
	public void setUpdate(boolean update) {
		this.update = update;
	}
}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             