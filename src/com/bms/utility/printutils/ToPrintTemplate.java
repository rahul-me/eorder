package com.bms.utility.printutils;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.bms.constants.Constants;

public class ToPrintTemplate extends PrintTemplate{
	public ToPrintTemplate() {
		 this.profileNo=1;
		 printerCommands=new PrinterCommands();
	         printData="";
	
	}
	
	public ToPrintTemplate(int profileNo){
		this.profileNo=profileNo;
		 printerCommands=new PrinterCommands();
		  printData="";
	}
	
	public String getPrintHeader(JSONObject item, String PrinterType)throws JSONException
	{
	 printData="";
		 switch (profileNo) {
	    	case 1://starting print profile 1
	 		if(PrinterType.equalsIgnoreCase(Constants.PRINTER_LASER))
	 		       {
	 				printData="";
	 				printData=printData+ printerCommands.getHtmlTag('s');
	 				
	 				printData=printData+printerCommands.getStyleSheet("to");
	 				printData=printData+printerCommands.getBodyTag('s')+printerCommands.getTableTag('s');
	 				
	 				printData=printData+"<tr class='BoldStyle header' align='center'><td colspan='7' style='border: 1pt  solid black;font-weight: bold;'>T R A N S F E R          O U T </td></tr>";
	 				//printData=printData+"<tr class='BoldStyle header' align='center'><td style='border: 1pt solid black;' colspan='7' ><font size='5px'>"+item.get("siteAddress")+"<br> <span align='left'>"+item.get("sitePhone")+" <br> "+item.get("TinNo")+"</span></td></tr>";
	 				printData=printData+"<tr><td colspan='4' style='border: 1pt solid black;'>supplier :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
	 				if(item.get("supplierName")!=null)
	 					printData=printData+item.get("supplierName")+"<br>P.O NO :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ";
	 				if(item.get("poNumber")!=null)
	 					printData=printData+item.get("poNumber")+"<br> P.O Date :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp";
	 				if(item.get("poDate")!=null)
	 					printData=printData+item.get("poDate")+"<br> Contact No :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+item.get("supplierContactNo")+" </td > <td colspan='3' style='border: 1pt  solid black;'>Site Name :&nbsp;&nbsp;&nbsp;&nbsp;";
	 				if(item.get("siteName")!=null)
	 				printData=printData+item.get("siteName")+"<br> T.O NO:&nbsp;&nbsp;&nbsp;&nbsp;";
	 				if(item.get("TONumber")!=null)
	 				printData=printData+item.get("TONumber")+"<br>Transfer Date :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
	 				if(item.get("TODate")!=null)
	 				printData=printData+item.get("TODate")+"<br>Phone No :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
	 				if(item.get("sitePhone")!=null)
	 				printData=printData+item.get("sitePhone")+"<br>Add :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
	 				printData=printData+item.get("siteAddress")+" </td></tr>";
	 				printData=printData+"<tr class='BoldStyle'><td colspan='2' style='border: 1pt  solid black; font-weight: bold;'>Item Code</td><td colspan='3' style='border: 1pt solid black; font-weight: bold;'>Item Name</td><td colspan='2' style='border: 1pt solid black; font-weight: bold;'>Quantity</td></tr>";
	 		
	 		       }
	              
	 		 else
	 			
	 		 {
	 			
	 			     //printData=printData+(sitename + "\n"); // creating outlet name
	 			    //printData=printData+(sitename + "\n"); // creating outlet name
	 			     printData=printData+item.get("siteAddress")+ "\n"; // outlet address
	 			     printData=printData+"email: " + item.get("siteEmail")+ "\n"; // outlet email
	 			     printData=printData+"Phone: " + item.get("sitePhone")+ "\n"; // outlet phone
	 			     printData=printData+"TIN: " + item.get("TinNo")+ "\n"; // outlet TIN
	 			     printData=printData+"----------------------------------------"+ "\n"; // seperator
	 			     printData=printData+"TRANSFER OUT"+ "\n\n"; // Transfer Out String   printData=printData+"Transfer Out Number: "+ item.get("TONumber") + "\n"; // TO number
	 			     printData=printData+"Date: "+ item.get("TODate") + "\n"; // TO Date
	 			     printData=printData+"PO No.: "+ item.get("poNumber") +"\n"; // PO number
	 			     printData=printData+"PO Date: "+ item.get("poDate") + "\n"; // Po Date
			         printData=printData+"Supplier: "+ item.get("supplierName") +"\n\n"; // Supplier Name
	 			     printData=printData+"----------------------------------------"+ "\n"; // seperator
	 			     printData=printData+"Code/           Qty/       Tax     Line"+ "\n"; // Header 1
	 			     printData=printData+"Description     Rate       Disc.   Total"+ "\n"; // Header 2
	 			     printData=printData+"----------------------------------------"+ "\n"; // seperator

	 		 }

			 break;
	 		
	 		///finishing print profile 1

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
	 		if(PrinterType.equalsIgnoreCase(Constants.PRINTER_LASER))
	 		       {
	 			             for (int i = 1; i<itemArray.length();  i++)
	 		                  {
	 			            	 JSONObject item = itemArray.getJSONObject(i);
	 			            		//printData=printData+"<tr><td colspan=2 style='border-style:groov; border-left-style:none; border-bottom-style:none;'>"+item.get("itemSKU")+"</td><td colspan=2 style='border-style:groov; border-left-style:none; border-bottom-style:none;' >"+item.get("toQuantity")+"</td></tr>";
	 							     printData= printData+printerCommands.getTableRowTag('s')+printerCommands.getTableRowTag('e');
	 							     if(item.getString("itemSKU")!=null)
	 		                         printData= printData+printerCommands.getTableRowTag('s')+printerCommands.getTableColumnTag('s',2)+item.getString("itemSKU").toString()+printerCommands.getTableColumnTag('e') +printerCommands.getTableColumnTag('s',3)+item.getString("itemName").toString()+printerCommands.getTableColumnTag('e')+printerCommands.getTableColumnTag('s',2)+item.get("toQuantity").toString()+ printerCommands.getTableColumnTag('e') +printerCommands.getTableRowTag('e');
	 						
	 		                  } 
	 			 
	 		       }
	    		
	 		         
	 		          
	 		 else{
	 			  for (int i = 1, size = itemArray.length(); i < size-1; i++)
                 {
	                     JSONObject item = itemArray.getJSONObject(i);
	                     printData+=item.get("itemSKU")+ "   " +  item.get("toQuantity")+ "   0.00    "+ item.get("lineTotal") + printerCommands.getNewLine(); // SKU       qty    tax     line total
	  					 printData+=item.get("itemName") + "   " + item.get("itemRate") + "     (-)        "+ printerCommands.getNewLine(); // Header 1
	  					 printData+="----------------------------------------"+ printerCommands.getNewLine(); // seperator

	                  
				         
	                   }
	 			  
				
                 }
				

	    		
	    		
			 break;
	 		
	 		///finishing print profile 1

		default:
			break;
			
		}  
		  
		
		  
		  
	  
		 return printData;
	
	  }
	
	
	public String getPrintFooter(JSONObject item, String PrinterType)throws JSONException
	{
	 printData="";
		 switch (profileNo) {
	    	case 1://starting print profile 1
	 		if(PrinterType.equalsIgnoreCase(Constants.PRINTER_LASER))
	 		       {
	 						 printData=printData+"<tr class='BoldStyle' align='right'><td colspan='6' style='border: 1pt solid black;'>Total Item </td><td colspan='1' style='border: 1pt solid black;'>"+item.getInt("totalItemNo")+"</td></tr>";  /**/
	 		              /*   String username =null;
	 			              if(username == null)   // this item stands for the username
	 		             	     {
	 			 	
	 				
	 			            	 printData= printData+"<tr><td></td></tr><tr><td></td></tr><tr><td><hr/></td><td><hr/></td><td><hr/></td></tr><tr><td>Authorized by</td><td></td><td>Date</td></tr>";
	 				      
	 			            	printData= printData+"<tr><td>Please notify us immediately if you are unable to ship as specified</td></tr>";
	 			   
	 			                  }
	 			   */           
	 			          printData=printData+printerCommands.getTableTag('e')+printerCommands.getBodyTag('e')+printerCommands.getHtmlTag('e');   
	 			 
	 		       }
	    	          
	 		 else
	 			  {
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

				
				  // this item stands for the username
				/*{
					
					 document.jZebra.append("----------------------------------------"+ "\n"); // seperator
					 document.jZebra.append("                 Date:                  "+ "\n"); // date
					 document.jZebra.append("Authorized by: "+ "\n\n"); // signature
					 document.jZebra.append("Please notify us immediately if you are "+ "\n"); // footer1
					 document.jZebra.append("unable to ship as specified             "+ "\n"); // footer2
					 document.jZebra.append("----------------------------------------"+ "\n"); // seperator
					 document.jZebra.append("updated by: "+ username +"\n\n\n\n"); // user name
					
					 
					
				}*/
			
	 		
	 			 
	 			 
	 			 
	 			 
	 			        }
	    		
			 break;
	 		
	 		///finishing print profile 1

		default:
			break;
			
		}  
		  
		
		  
		  
	  
		 return printData;
	
	  }
	
	
	
}
