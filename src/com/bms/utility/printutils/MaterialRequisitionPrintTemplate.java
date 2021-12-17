package com.bms.utility.printutils;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.bms.constants.Constants;

public class MaterialRequisitionPrintTemplate extends PrintTemplate{

	public MaterialRequisitionPrintTemplate() {
		 this.profileNo=1;
		 printerCommands=new PrinterCommands();
	         printData="";
	}
	
	public MaterialRequisitionPrintTemplate(int profileNo){
		this.profileNo=profileNo;
		 printerCommands=new PrinterCommands();
		  printData="";
	}
	
	public String getPrintHeader(JSONObject item, String PrinterType)throws JSONException
	{
	
		switch (profileNo) {
	    	case 1://starting print profile 1
	 		if(PrinterType.equalsIgnoreCase(Constants.PRINTER_LASER))
	 		       {
	 		
	 		       }
	        else
	 		{
	 			
	 		
	 		}

			 break;
	 		
	 		///finishing print profile 1
			 
	    	case 2:
	    	// starting  Material Requisition Note
	    	if(PrinterType.equalsIgnoreCase(Constants.PRINTER_LASER))
		       {
	    		printData="";
	 			printData=printData+ printerCommands.getHtmlTag('s');
	 		
	    	    printData=printData+printerCommands.getStyleSheet("Material Requisition");
	    	    printData=printData+printerCommands.getBodyTag('s')+printerCommands.getTableTag('s');
	    		
	    		printData=printData+"<tr class='BoldStyle header' align='center'><td style='border: 1pt solid black;' colspan='5' ><img  align='left' src='../../assets/img/NessLogo.png'> <span style='color: red' ><font size='5px'>NESSTECH INSTRUMENTS. PVT. LTD.</span></td><td colspan='2' style='border: 1pt solid black;'> <span>MRIN No. </span>&nbsp;&nbsp;&nbsp;";
	    		if(item.get("MRINNo")!=null)
	    		printData=printData+item.get("MRINNo")+"</td></tr>";
	    		printData=printData+"<tr class='BoldStyle header' align='center'><td colspan='7' style='border: 1pt  solid black;font-weight: bold;'>M A T E R I A L &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   R E Q U I S I T I O N &nbsp;&nbsp & &nbsp;&nbsp; I S S U E &nbsp;&nbsp&nbsp;&nbsp N O T E </td></tr>";
	    	    printData=printData+"<tr><td style='border: 1pt solid black;' colspan='4'><span><font size='3px'>DEPARTMENT :</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
	    		printData=printData+item.get("ToDepartMent")+"</td><td colspan='3' style='border: 1pt solid black;'> <span>DATE :</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
	    		printData=printData+item.get("MaterialReqDate")+"</td></tr> ";
	    		
	    		printData=printData+"<tr class='BoldStyle'><td colspan='1' style='border: 1pt  solid black; font-weight: bold;'>SR No.</td><td colspan='2' style='border: 1pt solid black; font-weight: bold;'>Item Code</td><td colspan='2' style='border: 1pt solid black; font-weight: bold;'>Item Description</td><td colspan='2' style='border: 1pt solid black; font-weight: bold;'>Required Quantity</td></tr>";
		       }
   		else{
   			
   				printData="";  
   				if(item.get("siteAddress")!=null)
			      printData=printData+item.get("siteAddress").toString()+ printerCommands.getNewLine(); // outlet address
   				if(item.get("siteEmail")!=null)
		          printData=printData+"email: " + item.get("siteEmail")+ printerCommands.getNewLine(); // outlet email
   				if(item.get("sitePhone")!=null)
		          printData=printData+"Phone: " + item.get("sitePhone")+ printerCommands.getNewLine(); // outlet phone
   				if(item.get("TinNo")!=null)
		          printData=printData+"TIN: " + item.get("TinNo")+ printerCommands.getNewLine(); // outlet TIN
   				
		          printData=printData+"----------------------------------------"+printerCommands.getNewLine(); // seperator
		          printData=printData+"Purchase Order"+printerCommands.getNewLine()+printerCommands.getNewLine(); // Transfer Out String
		     
			
		          printData=printData+"Purchase Order Number: " +item.getDouble("PONumber") + printerCommands.getNewLine(); // TO number
		          printData=printData+"Date: "+ item.get("PODate") + printerCommands.getNewLine(); // TO Date
		          printData=printData+"PO No.: "+ item.get("PONumber") +printerCommands.getNewLine(); // PO number
		          printData=printData+"PO Date: "+ item.get("PODate") + printerCommands.getNewLine(); // Po Date
		          printData=printData+"PO Type: "+ printerCommands.getNewLine();  
		          printData=printData+"Refrence NO: "+ printerCommands.getNewLine();  
		          printData=printData+"Refrence Date: "+ printerCommands.getNewLine(); 
		          printData=printData+"Due Date: "+ printerCommands.getNewLine(); 
		          printData=printData+"Supplier: "+ item.get("supplierName") +printerCommands.getNewLine()+printerCommands.getNewLine(); // Supplier Name

		         
		          printData=printData+"----------------------------------------"+ printerCommands.getNewLine(); // seperator
		          printData=printData+"Code/           Qty/       Tax     Line"+ printerCommands.getNewLine(); // Header 1
		          printData=printData+"Description     Rate       Disc.   Total"+ printerCommands.getNewLine(); // Header 2
		          printData=printData+"----------------------------------------"+ printerCommands.getNewLine(); // seperator

   		}
	    		
	    		break;
	    

		default:
			break;
			
		}  
		  
		 return printData;
	
	  }
	
	
	
	
	public String getPrintBody(JSONArray itemArray, String PrinterType)throws JSONException
	{
	  printData="";
		 switch (profileNo) {
	    	case 1://starting print profile 1
	 	
				
			 break;
	    	case 2:
	    		if(PrinterType.equalsIgnoreCase(Constants.PRINTER_LASER))
	 		       {
	    			
	    			  for (int i = 1; i<itemArray.length();  i++)
	 		                  {
	 		                       JSONObject item = itemArray.getJSONObject(i);
	 			                   printData= printData+printerCommands.getTableRowTag('s')+printerCommands.getTableRowTag('e');
	 		                       printData= printData+printerCommands.getTableRowTag('s')+printerCommands.getTableColumnTag('s',1)+i+printerCommands.getTableColumnTag('e') +printerCommands.getTableColumnTag('s',2)+item.getString("itemName").toString()+printerCommands.getTableColumnTag('e')+printerCommands.getTableColumnTag('s',2)+item.get("itemName").toString() +printerCommands.getTableColumnTag('e')+printerCommands.getTableColumnTag('s',2)+item.get("orderQuantity").toString() + "</td></tr>";
	 			                } 
	 			             
	 			   
	 		       }else
	 		       {
	 		    	  for (int i = 1, size = itemArray.length(); i < size; i++)
	                  {
	                     JSONObject item = itemArray.getJSONObject(i);

	 			       
	                     printData=printData+item.get("itemSKU").toString() + "   " +  item.get("poQuantity").toString() + "   0.00    "+ item.get("lineTotal").toString() + printerCommands.getNewLine(); // SKU       qty    tax     line total
	                     printData=printData+item.get("itemName").toString() + "   " + item.get("itemRate").toString() + "     (-)        "+ printerCommands.getNewLine(); // Header 1
	                     printData=printData+"----------------------------------------"+ printerCommands.getNewLine(); // seperator

				          }
	 		       }
	    		
	    		break;
	 		///finishing print profile 2

		default:
			break;
			
		}  
	 return printData;
	
	  }
	
	
	@SuppressWarnings("unused")
	public String getPrintFooter(JSONObject item, String PrinterType)throws JSONException
	{
		printData="";
	 
		 switch (profileNo) {
	    	case 1://starting print profile 1
	 			
			 break;
	 		
	 		///finishing print profile 1
			 
	    	case 2: //starting Material Requisition Note print profile 2
	    		if(PrinterType.equalsIgnoreCase(Constants.PRINTER_LASER))
		       {
		    		printData=printData+"<tr class='BoldStyle' align='right'><td colspan='6' style='border: 1pt solid black;'>Total(Rs)</td><td colspan='1' style='border: 1pt solid black;'>"+item.getDouble("totalAmount")+"</td></tr>";  /**/
		    		/*printData=printData+"<tr class='BoldStyle'><td colspan='3 style='border: 1pt solid black;' '>Payment Terms :</td><td style='border: 1pt solid black;' colspan='3'>TAX 5% VAT</td><td colspan='1' style='border: 1pt solid black;'></td></tr>";*/
		    		//printData=printData+"<tr><td align='center' colspan='7' style='border: 1pt solid black;'>1. The above order is on Door Delivery basis and inclusive of all incidental expenses, taxes & charges if any, unless otherwise stated.<br>2. Material Receipt shall be subject to the final approval of the Purchase Department, please send your invoice together with the consignment and attach copy of this purchase order, without which it will not be processed for payment. <br>3. Validity of the purchase order is one week from the purchase order date, unless otherwise stated </td></tr>";					
		    		printData=printData+"<tr><td align='left' colspan='4' style='border: 1pt solid black;'>Thank you very much for your order.!!<br><br>Best Regards,<br>Nesstech Instruments Pvt.Ltd<br><br><br><br><span style='text-decoration: underline;'>PREPARED BY</span><br><br>MR.</td><td align='right' colspan='3' style='border: 1pt solid black;'><br><br><br><br><br><br><br><span style='text-decoration: underline;'>APPROVED BY</span><br><br>GENERAL MANAGER</td></tr>";
		    	    printData=printData+printerCommands.getTableTag('e')+printerCommands.getBodyTag('e')+printerCommands.getHtmlTag('e');
		       }
	    	    else{
	    	    	int totalItemNo = item.getInt("totalItemNo");
		 			if(totalItemNo != 0 ){
		 			 
					 
		 				printData= printData+" packages Charges: 0.00                      SUB TOTAL: "+ item.get("subTotal") + printerCommands.getNewLine(); // subtotal
		 				printData= printData+"  Delivery Charges: 0.00                    Adjustment: "+   printerCommands.getNewLine(); 
		 				printData= printData+" Purchase Tax:   0.00                   Discount : "+ item.get("discount") +printerCommands.getNewLine(); // discount
		 				printData= printData+" servece Tax: 0.00                        --------------"+ printerCommands.getNewLine(); // seperator
		 				printData= printData+"                 NET PAYABLE:    "+ item.get("netTotal")+printerCommands.getNewLine()+printerCommands.getNewLine()+printerCommands.getNewLine(); // net payable
		 				printData= printData+"Total Items : "+ item.get("totalItemNo") +printerCommands.getNewLine(); // total items count
		 				printData= printData+"Quantity    : "+  item.get("quantity") +printerCommands.getNewLine(); // total quantity 
							
					}

	    	    }
	    		
	    		break; //finishing print profile 2

		default:
			break;
			
		}  
		 return printData;
	
	  }
	
}
