package com.bms.mdm.reports;

import java.util.ArrayList;
import java.util.HashMap;

import com.bms.struts.SCMActionForm;

public class ReportInputBean extends SCMActionForm {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 738202372937124128L;
	
	private String fromDate;
	private String toDate;
	private boolean isPresent;
	
	private ArrayList <String >  xValues;
	private HashMap<Integer,ArrayList <String >>  yValues;
	private ArrayList<Integer> dishId;
	private ArrayList<Integer> itemId;
	
	public boolean getisPresent() {
		return isPresent;
	}

	public boolean isPresent() {
		return isPresent;
	}
	public void setPresent(boolean isPresent) {
		this.isPresent = isPresent;
	}
	public ArrayList<String> getxValues() {
		return xValues;
	}
	public void setxValues(ArrayList<String> xValues) {
		this.xValues = xValues;
	}
	public HashMap<Integer, ArrayList<String>> getyValues() {
		return yValues;
	}
	public void setyValues(HashMap<Integer, ArrayList<String>> yValues) {
		this.yValues = yValues;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public ArrayList<Integer> getItemId() {
		return itemId;
	}

	public void setItemId(ArrayList<Integer> itemId) {
		this.itemId = itemId;
	}

	public ArrayList<Integer> getDishId() {
		return dishId;
	}

	public void setDishId(ArrayList<Integer> dishId) {
		this.dishId = dishId;
	}

}
