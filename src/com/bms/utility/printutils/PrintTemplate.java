package com.bms.utility.printutils;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
public class PrintTemplate {
protected PrinterCommands printerCommands;
	
	protected String printData;
	protected int profileNo;
	
	PrintTemplate()
	{
	 this.profileNo=1;
	 printerCommands=new PrinterCommands();
         printData="";
	   }
	PrintTemplate(int profileNo ){
		
		this.profileNo=profileNo;
		 printerCommands=new PrinterCommands();
		  printData="";
	}
	
	
	public String getPrintHeader(JSONObject item, String PrinterType)throws JSONException
	{
	 
		 	  
	  
		 return printData;
	
	  }
	
	
	
	
	public String getPrintBody(JSONArray itemArray, String PrinterType)throws JSONException
	{
	 
		 return printData;
	
	  }
	
	
	public String getPrintFooter(JSONObject item, String PrinterType)throws JSONException
	{
		 return printData;
	}
	
	
	public String getPrintHeaderforPO(JSONObject item, String PrinterType,String statusPrinter)throws JSONException
	{
	  return printData;
	}
	
	
	
	
	/*public String getPrintHeaderforSales(SaleMasterActionForm saleMasterActionForm,ArrayList<SaleDetailActionForm>saleDetailList,String PrinterType,String statusPrinter)throws JSONException
	{
	  return printData;
	}
	*/
	
	public String getItemdescription(JSONObject item, String PrinterType)throws JSONException
	{
		 return printData;
	}
	
	
	
	/*
	 * 
	 * Below Function is For Delivery Challan Header Format
	 */
	public String getDeliveryChallanPrintHeader(JSONObject item, String PrinterType)throws JSONException
	{
	 	 return printData;
	}


	
	public String getDeliveryChallanPrintBody(JSONArray itemArray, String PrinterType)throws JSONException
	{
	 
		 return printData;
	
	}
	
	
	public String getDeliveryChallanPrintFooter(JSONObject item, String PrinterType)throws JSONException
	{
	 
		 return printData;
	
	  }
	
}
