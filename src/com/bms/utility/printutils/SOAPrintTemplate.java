package com.bms.utility.printutils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.bms.constants.Constants;
import com.bms.mdm.item.ItemActionForm;
import com.bms.mdm.item.ItemDBAdapter;
import com.bms.mdm.item.ItemDBHelper;
import com.bms.mdm.itemcategories.ItemCategoriesDBHelper;
import com.bms.mdm.itemcategories.ItemCategoryActionForm;


public class SOAPrintTemplate extends PrintTemplate{
		
	
	
	HttpServletRequest request;
	
	public SOAPrintTemplate() {
		 this.profileNo=1;
		 printerCommands=new PrinterCommands();
	         printData="";
	
	       
	     	
	}
	
	public SOAPrintTemplate(int profileNo){
		this.profileNo=profileNo;
		 printerCommands=new PrinterCommands();
		  printData="";
	}
	
	public String getPrintHeader(JSONObject item, String PrinterType)throws JSONException
	{
	
		//HttpSession session=request.getSession(true);
	    //System.out.println("Session"+session.getAttribute(Constants.SESSION_INFO_USERNAME));
		 switch (profileNo) {
	    	case 1://starting print profile 1
	 		if(PrinterType.equalsIgnoreCase(Constants.PRINTER_LASER))
	 		       {
	 			printData="";
	 			printData=printData+ printerCommands.getHtmlTag('s')+printerCommands.getBodyTag('s')+printerCommands.getTableTag('s');
	 			//printData=printData+printerData+
	 			
	 		       }
	    		
	 		         
	 		          
	 		 else
	 			
	 		 {
	 			
	 			      //printData=printData+(sitename + "\n"); // creating outlet name
	 		          printData="";  
	 			      printData=printData+item.get("siteAddress").toString()+ printerCommands.getNewLine(); // outlet address
	 		          printData=printData+"email: " + item.get("siteEmail")+ printerCommands.getNewLine(); // outlet email
	 		          printData=printData+"Phone: " + item.get("sitePhone")+ printerCommands.getNewLine(); // outlet phone
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
	 		
	 		///finishing print profile 1
			 
	    	case 2:
	    	// starting  SOA profile 2
	    	if(PrinterType.equalsIgnoreCase(Constants.PRINTER_LASER))
		       {
	    		printData="";
	 			printData=printData+ printerCommands.getHtmlTag('s');
	 		
	    	    printData=printData+printerCommands.getStyleSheet("SOA");
	    	    printData=printData+printerCommands.getBodyTag('s')+printerCommands.getTableTag('s');
	    		
	    		printData=printData+"<tr class='BoldStyle header' align='center'><td style='border: 1pt solid black;' colspan='7' ><img  align='left' src='../../assets/img/NessLogo.png'> <span style='color: red' ><font size='5px'>NESSTECH INSTRUMENTS. PVT. LTD.</span><br><font size='3px'>Survey No.26/2,'G' Type, Global Industrial Park, Near Nahuli Railway Crossing, Village-Valvada, Vapi-396105 Tal.<br>Umbergaon, Dist.Valsad (Gujarat) Tel:0260-2996920   Email:dkhairnar@ nesstech.co.in</td></tr>";
	    	    printData=printData+"<tr class='BoldStyle header' align='center'><td colspan='7' style='border: 1pt  solid black;font-weight: bold;'>O R D E R &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   A C K N O W L E D G E M E N T</td></tr>";
	    	    printData=printData+"<tr><td style='border: 1pt solid black;' colspan='4'><span><font size='3px'>CUSTOMER DETAILS</span></td><td colspan='3' style='border: 1pt solid black;'> <span>NIP DETAILS </span></td></tr> ";
	    	    printData=printData+"<tr><td colspan='4' style='border: 1pt solid black;'>TO :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
	    		if(item.get("companyName")!=null)
				printData=printData+item.get("companyName")+"<br>ATTN :&nbsp;&nbsp;&nbsp;&nbsp; ";
	    		printData=printData+" "+" <br> P.O NO :&nbsp;&nbsp;&nbsp;&nbsp; ";
	    		if(item.get("PONo")!=null)
				printData=printData+item.get("PONo")+" <br> P.O Receive Date:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
	    		if(item.get("PODate")!=null)
				printData=printData+item.get("PODate")+" <br>Desired Delivery Date:&nbsp;&nbsp;&nbsp;&nbsp";
	    		if(item.get("deliveryDate")!=null)
	    		printData=printData+item.get("deliveryDate")+"  </td ><td colspan='3' style='border: 1pt  solid black;'>O.A NO :&nbsp;&nbsp;&nbsp;&nbsp;";
				printData=printData+item.get("orderAckNO")+"<br>O.A Date:&nbsp;&nbsp;&nbsp;&nbsp;"+item.get("orderAckDate")+"<br>NIP Deleivery Date :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  " +item.get("NIPDeliveryDate")+"<br>Delivery Condition(If any):&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "+item.get("condition")+"</td></tr>";
	    		printData=printData+"<tr class='BoldStyle'><td colspan='1' style='border: 1pt  solid black; font-weight: bold;'>Item Code</td><td colspan='2' style='border: 1pt solid black; font-weight: bold;'>Item Name</td><td colspan='1' style='border: 1pt solid black; font-weight: bold;'>Quantity Ordered</td><td colspan='1' style='border: 1pt solid black; font-weight: bold;'>Unit Price</td><td colspan='1' style='border: 1pt solid black; font-weight: bold;'>Discount (%)</td><td colspan='1' style='border: 1pt solid black; font-weight: bold;'>Amount</td></tr>";
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
	    	 //finsihing profile 2
			 

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
	 		                          printData= printData+printerCommands.getTableRowTag('s')+printerCommands.getTableColumnTag('s')+item.getString("itemSKU").toString()+printerCommands.getTableColumnTag('e') +printerCommands.getTableColumnTag('s')+item.get("poQuantity").toString() +printerCommands.getTableColumnTag('e')+printerCommands.getTableColumnTag('s')+" 0.00" +printerCommands.getTableColumnTag('e') +printerCommands.getTableColumnTag('s')+item.get("lineTotal").toString() + printerCommands.getTableColumnTag('e') +printerCommands.getTableRowTag('e');
	 			     		          printData= printData+printerCommands.getTableRowTag('s')+printerCommands.getTableColumnTag('s')+item.getString("itemName").toString()+printerCommands.getTableColumnTag('e')+printerCommands.getTableColumnTag('s')+item.get("itemRate").toString() + "</td><td style='border-bottom:1pt solid black; display:block;'> (-) </td><td style='border-bottom:1pt solid black; display:block;'></td></tr>";
	 			    		  } 
	 			 
	 		       }
	    		
	 		         
	 		          
	 		 else{
	 			  for (int i = 1, size = itemArray.length(); i < size; i++)
	                  {
	                     JSONObject item = itemArray.getJSONObject(i);

	 			       
	                     printData=printData+item.get("itemSKU") + "   " +  item.get("poQuantity") + "   0.00    "+ item.get("lineTotal") + printerCommands.getNewLine(); // SKU       qty    tax     line total
	                     printData=printData+item.get("itemName") + "   " + item.get("itemRate") + "     (-)        "+ printerCommands.getNewLine(); // Header 1
	                     printData=printData+"----------------------------------------"+ printerCommands.getNewLine(); // seperator

				          }
				
	                  }
				
			 break;
	    	case 2:
	    		
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
	 		if(PrinterType.equalsIgnoreCase(Constants.PRINTER_LASER))
	 		       {

		 			int totalItemNo = item.getInt("totalItemNo");
		 			if(totalItemNo != 0 ){
			 			 
		 				printData= printData+"<tr><td>Total Items : "+ item.getInt("totalItemNo") +"</td><td>		</td><td>Discount : "+ item.getInt("discount") +"</td></tr>";
		 				printData= printData+"<tr><td>Quantity    : "+  item.getInt("quantity") +"</td><td>		</td><td>NET PAYABLE: "+ item.getDouble("netTotal") +"</td></tr>";
					}
	
	                 String username =null;
	              if(username != null)   // this item stands for the username
	         	     {
	 	
			
	            	  printData= printData+"<tr><td></td></tr><tr><td></td></tr><tr><td><hr/></td><td><hr/></td><td><hr/></td></tr><tr><td>Authorized by</td><td></td><td>Date</td></tr>";
			      
	            	  printData= printData+"<tr><td>Please notify us immediately if you are unable to ship as specified</td></tr>";
	   
	                  }
		 			              
			           printData=printerCommands.getTableTag('e')+printerCommands.getBodyTag('e')+printerCommands.getHtmlTag('s'); 
		 			              
	 			 
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
			 
	    	case 2: //starting SOA print profile 2
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
	
	
	
	
	
	
	
	public String getItemdescription(JSONObject item, String PrinterType)throws JSONException
	{
		printData="";
		
		switch (profileNo) {
			
			case 1:
				break;
			case 2:
				break;
		
		}
		return printData;
	}
	
}
