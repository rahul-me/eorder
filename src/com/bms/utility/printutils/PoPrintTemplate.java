package com.bms.utility.printutils;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.bms.constants.Constants;
public class PoPrintTemplate extends PrintTemplate{
	public PoPrintTemplate() {
		 this.profileNo=1;
		 printerCommands=new PrinterCommands();
	         printData="";
	
	}
	
	public PoPrintTemplate(int profileNo){
		this.profileNo=profileNo;
		 printerCommands=new PrinterCommands();
		  printData="";
	}
	
	public String getPrintHeaderforPO(JSONObject item, String PrinterType,String statusPrinter)throws JSONException
	{
	 
		 switch (profileNo) {
	    	case 1://starting print profile 1
	 		if(PrinterType.equalsIgnoreCase(Constants.PRINTER_LASER))
	 		       {
	 			printData="";
	 			printData=printData+ printerCommands.getHtmlTag('s')+printerCommands.getBodyTag('s')+printerCommands.getTableTag('s');
	 			printData=printData+ printerCommands.getTableRowTag('s')+printerCommands.getTableColumnTag('s')+ printerCommands.getTableColumnTag('e')+printerCommands.getTableRowTag('e');
	 			printData=printData+ printerCommands.getTableRowTag('s')+printerCommands.getTableColumnTag('s')+item.getString("siteAddress")+ printerCommands.getTableColumnTag('e')+printerCommands.getTableRowTag('e');
	 			printData=printData+ printerCommands.getTableRowTag('s')+printerCommands.getTableColumnTag('s')+"email:"+ item.getString("siteEmail")+printerCommands.getTableColumnTag('e')+printerCommands.getTableRowTag('e');
	 			printData=printData+ printerCommands.getTableRowTag('s')+printerCommands.getTableColumnTag('s')+"Phone:"+ item.getString("sitePhone")+printerCommands.getTableColumnTag('e')+printerCommands.getTableRowTag('e');
	 			printData=printData+ printerCommands.getTableRowTag('s')+printerCommands.getTableColumnTag('s')+"TIN:"+ item.getString("TinNo")+printerCommands.getTableColumnTag('e')+printerCommands.getTableRowTag('e');
	 			
	 			printData=printData+"<tr><td style='border-bottom:1pt solid black; display:block;'><h5>Purchase OUT</h5></td></tr>";
	 			printData=printData+printerCommands.getTableRowTag('s')+printerCommands.getTableColumnTag('s')+"Purchase Order Number: "+item.getInt("PONumber")+printerCommands.getTableColumnTag('e')+printerCommands.getTableRowTag('e');
	 			printData=printData+"<tr><td>Date: "+ item.getString("PODate") + printerCommands.getTableColumnTag('e')+printerCommands.getTableRowTag('e');
	 			printData=printData+"<tr><td>PO Type: "+printerCommands.getTableColumnTag('e')+printerCommands.getTableRowTag('e');
	 			printData=printData+"<tr><td>Refrence No : "+ printerCommands.getTableColumnTag('e')+printerCommands.getTableRowTag('e');
	 			printData=printData+"<tr><td>Reference Date : "+ printerCommands.getTableColumnTag('e')+printerCommands.getTableRowTag('e');
	 			printData=printData+"<tr><td>Due Date: "+  printerCommands.getTableColumnTag('e')+printerCommands.getTableRowTag('e');
	 				
	 			printData=printData+"<tr><td style='border-bottom:1pt solid black; display:block;'>Supplier: "+ item.getString("supplierName") +"</td></tr>";
	 				
	 			printData=printData+"<tr><td>Code/ </td><td>Qty/ </td><td>Tax/</td><td>Line/</td></tr>";
	 			printData= printData+"<tr><td style='border-bottom:1pt solid black; display:block;'>Description </td><td  style='border-bottom:1pt solid black; display:block;'>Rate</td><td  style='border-bottom:1pt solid black; display:block;'>Disc.</td><td  style='border-bottom:1pt solid black; display:block;'>Total</td></tr>";
	 			     
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
	    	// starting  po profile 2
   		if(PrinterType.equalsIgnoreCase(Constants.PRINTER_LASER))
		       {
	    		printData="";
	 			printData=printData+ printerCommands.getHtmlTag('s');
	 		
	    	    printData=printData+printerCommands.getStyleSheet("po");
	    	    printData=printData+printerCommands.getBodyTag('s')+printerCommands.getTableTag('s');
	    		
	    	
	    		printData=printData+"<tr><td style='border: 1pt solid black;' colspan='4'><img  align='left' src='../../assets/img/NessLogo.png'><span><font size='3px'></span></td><td colspan='3' style='border: 1pt solid black;'> <span>Supplier's Copy </span></td></tr> ";
	    	    
	    		if(statusPrinter.equalsIgnoreCase(Constants.PRINT_STATUS_PURCHASE_ORDER))
	    		printData=printData+"<tr class='BoldStyle header' align='center'><td colspan='7' style='border: 1pt  solid black;font-weight: bold;'>PURCHASE ORDER</td></tr>";
	    		else
	    		printData=printData+"<tr class='BoldStyle header' align='center'><td colspan='7' style='border: 1pt  solid black;font-weight: bold;'>REQUISITION ORDER</td></tr>";
	    		
	    		printData=printData+"<tr><td colspan='4' style='border: 1pt solid black;'>supplier :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
	    		if(item.get("supplierName")!=null)
				printData=printData+item.get("supplierName")+"<br>Address :&nbsp;&nbsp;&nbsp;&nbsp; ";
	    		if(item.get("supplierAddress")!=null)
				printData=printData+item.get("supplierAddress")+" <br> Tel:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
	    		if(item.get("phone")!=null)
				printData=printData+item.get("phone")+" <br>E-mail:&nbsp;&nbsp;&nbsp;&nbsp;</td ><td colspan='3' style='border: 1pt  solid black;'>P.O NO :&nbsp;&nbsp;&nbsp;&nbsp;";
				printData=printData+item.get("PONumber")+"<br>P.R NO:&nbsp;&nbsp;&nbsp;&nbsp;"+item.get("PODate")+"<br>Date :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  " +item.get("PODate")+"<br>Payment Terms: &nbsp;&nbsp;&nbsp;&nbsp;<br>Deleviery Date: &nbsp;&nbsp;&nbsp;&nbsp; </td></tr>";
	    		printData=printData+"<tr class='BoldStyle'><td colspan='1' style='border: 1pt  solid black; font-weight: bold;'>Item Code</td><td colspan='3' style='border: 1pt solid black; font-weight: bold;'>Item Name</td><td colspan='1' style='border: 1pt solid black; font-weight: bold;'>Quantity Ordered</td><td colspan='1' style='border: 1pt solid black; font-weight: bold;'>Unit Price</td><td colspan='1' style='border: 1pt solid black; font-weight: bold;'>Total Price</td></tr>";
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
	    		if(PrinterType.equalsIgnoreCase(Constants.PRINTER_LASER))
	 		       {
	 			             for (int i = 1; i<itemArray.length();  i++)
	 		                  {
	 		                     JSONObject item = itemArray.getJSONObject(i);

	 			
	 			                     printData= printData+printerCommands.getTableRowTag('s')+printerCommands.getTableRowTag('e');
	 		                         printData= printData+printerCommands.getTableRowTag('s')+printerCommands.getTableColumnTag('s',1)+item.getString("itemSKU").toString()+printerCommands.getTableColumnTag('e') +printerCommands.getTableColumnTag('s',3)+item.getString("itemName").toString()+printerCommands.getTableColumnTag('e')+printerCommands.getTableColumnTag('s',1)+item.get("poQuantity").toString() +printerCommands.getTableColumnTag('e')+printerCommands.getTableColumnTag('s',1)+item.get("itemRate").toString() + "</td>"+printerCommands.getTableColumnTag('s',1)+item.get("lineTotal").toString() + printerCommands.getTableColumnTag('e') +printerCommands.getTableRowTag('e');
	 			     			           
	 			                   
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
			 
	    	case 2: //starting po print profile 2
	    		if(PrinterType.equalsIgnoreCase(Constants.PRINTER_LASER))
		       {
		    		printData=printData+"<tr class='BoldStyle'><td colspan='3' style='border: 1pt solid black;'>Remarks :</td><td colspan='3' style='border: 1pt solid black;'>GROSS ORDER VALUE(Rs)</td><td colspan='1' style='border: 1pt solid black;'>"+item.getDouble("netTotal")+"</td></tr>";
		    		printData=printData+"<tr class='BoldStyle'><td colspan='3 style='border: 1pt solid black;' '>Payment Terms :</td><td style='border: 1pt solid black;' colspan='3'>TAX 5% VAT</td><td colspan='1' style='border: 1pt solid black;'></td></tr>";
		    		printData=printData+"<tr><td align='center' colspan='7' style='border: 1pt solid black;'>1. The above order is on Door Delivery basis and inclusive of all incidental expenses, taxes & charges if any, unless otherwise stated.<br>2. Material Receipt shall be subject to the final approval of the Purchase Department, please send your invoice together with the consignment and attach copy of this purchase order, without which it will not be processed for payment. <br>3. Validity of the purchase order is one week from the purchase order date, unless otherwise stated </td></tr>";					
		
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
