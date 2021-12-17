package com.bms.utility.printutils;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class PrintUtility {
	 private String printData;
	  private PrintTemplate printTemplate=null;	
		public PrintUtility(){
		 this.printData="";

		}
		
		
   public String print(PrintUtilityBean printUtilityBean,JSONArray itemArray)throws JSONException
   {
       JSONObject item = itemArray.getJSONObject(0);
       
       if(printUtilityBean.getPrintingModule().equals("ORDER"))
       	  {
			  printTemplate= new SalesPrintTemplate(printUtilityBean.getPrintProfile());    
			  printData=printData+printTemplate.getPrintHeader(item, printUtilityBean.getPrinterType());
	          printData=printData+printTemplate.getPrintBody(itemArray, printUtilityBean.getPrinterType());
	          printData=printData+printTemplate.getPrintFooter(item,printUtilityBean.getPrinterType());
	      }
       
       
			
			       return this.printData;

    }
   
  
   
}
