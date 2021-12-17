package com.bms.mdm.report;

import java.util.ArrayList;

import com.bms.mdm.item.ItemActionForm;
import com.bms.mdm.itemcategories.ItemCategoryActionForm;
import com.bms.struts.SCMActionForm;

public class ReportActionForm extends SCMActionForm {
	
	private int itemIds;
	private int itemCategoryId;
	private int siteId;
	public int getItemCategoryId() {
		return itemCategoryId;
	}
	public void setItemCategoryId(int itemCategoryId) {
		this.itemCategoryId = itemCategoryId;
	}
	public int getSiteId() {
		return siteId;
	}
	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}
	public int getItemIds() {
		return itemIds;
	}
	public void setItemIds(int itemIds) {
		this.itemIds = itemIds;
	}
	private ArrayList<ItemActionForm> itemList=null;
	private ArrayList<ItemCategoryActionForm> itemCategoryList=null;
	
	
	public ArrayList<ItemActionForm> getItemList() {
		return itemList;
	}
	public void setItemList(ArrayList<ItemActionForm> itemList) {
		this.itemList = itemList;
	}
	public ArrayList<ItemCategoryActionForm> getItemCategoryList() {
		return itemCategoryList;
	}
	public void setItemCategoryList(
			ArrayList<ItemCategoryActionForm> itemCategoryList) {
		this.itemCategoryList = itemCategoryList;
	}
	

}
