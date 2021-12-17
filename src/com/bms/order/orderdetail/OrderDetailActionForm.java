package com.bms.order.orderdetail;


public class OrderDetailActionForm {
	
	private int orderDetailId;
	private int itemMasterId;
	private String description;
	private float quantity;
	private float rate;
	private float amount;
	private int orderMasterId;
	private float dispatchedQuantity;
	
		
	public float getDispatchedQuantity() {
		return dispatchedQuantity;
	}
	public void setDispatchedQuantity(float dispatchedQuantity) {
		this.dispatchedQuantity = dispatchedQuantity;
	}
	public int getOrderDetailId() {
		return orderDetailId;
	}
	public void setOrderDetailId(int orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
	public int getItemMasterId() {
		return itemMasterId;
	}
	public void setItemMasterId(int itemMasterId) {
		this.itemMasterId = itemMasterId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public int getOrderMasterId() {
		return orderMasterId;
	}
	public void setOrderMasterId(int orderMasterId) {
		this.orderMasterId = orderMasterId;
	}
	
}
