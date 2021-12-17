package com.bms.utility.printutils;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.bms.constants.Constants;
public class GrPrintTemplate  extends PrintTemplate{
	public GrPrintTemplate() {
		 this.profileNo=1;
		 printerCommands=new PrinterCommands();
	         printData="";
	
	}
	
	public GrPrintTemplate(int profileNo){
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
			 			printData="";
			 			//printData=printData+"<tr><td>site:"+sitename+"</td></tr>";
			 			printData=printData+"<tr><td>"+item.get("siteAddress")+"</td></tr>";
			 			printData=printData+"<tr><td>email:"+ item.get("siteEmail")+"</td></tr>";
			 			printData=printData+"<tr><td>Phone:"+ item.get("sitePhone")+"</td></tr>";
			 			printData=printData+"<tr><td style='border-bottom:1pt solid black; display:block;'>TIN:"+ item.get("TinNo")+"</td></tr>";
						
			 			printData=printData+"<tr><td style='border-bottom:1pt solid black; display:block;'><h5>Receive Goods</h5></td></tr>";
			 			printData=printData+"<tr><td>Receive Goods Number: "+item.get("GRNumber")+"</td></tr>";
			 			printData=printData+"<tr><td>Date: "+ item.get("GRDate") + "</td></tr>";
			 			printData=printData+"<tr><td>PO No.: "+ item.get("poNumber") +"</td></tr>";
						printData=printData+"<tr><td>PO Date: "+ item.get("poDate") + "</td></tr>";
						printData=printData+"<tr><td style='border-bottom:1pt solid black; display:block;'>Supplier: "+ item.get("supplierName") +"</td></tr>";
						
						printData=printData+"<tr><td>Code/ </td><td>Qty/ </td><td>Item/</td><td>Line/</td></tr>";
						printData=printData+"<tr><td style='border-bottom:1pt solid black; display:block;'>Description </td><td  style='border-bottom:1pt solid black; display:block;'>Rate</td><td  style='border-bottom:1pt solid black; display:block;'>Vat(%).</td><td  style='border-bottom:1pt solid black; display:block;'>Total</td></tr>";
				
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
	    	// starting  GR profile 2
   		if(PrinterType.equalsIgnoreCase(Constants.PRINTER_LASER))
		       {
		
	    		printData="";
	 			printData=printData+ printerCommands.getHtmlTag('s');
	 		
	    	    printData=printData+printerCommands.getStyleSheet("Gr");
	    	    printData=printData+printerCommands.getBodyTag('s')+printerCommands.getTableTag('s');
	    		
	    	
	    		printData=printData+"<tr class='BoldStyle header' align='center'><td colspan='7' style='border: 1pt solid black;'>G O O D S  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;     R E C E I V E    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    N O T E </td></tr>";
	    		printData=printData+"<tr><td style='border: 1pt solid black;' colspan='3'><span><font size='3px'>SUPPLIER DETAILS</span></td><td colspan='4' style='border: 1pt solid black;'> <span>SITE:&nbsp;&nbsp;   "+item.get("siteName")+"</span></td></tr> ";
	    		printData=printData+"<tr><td colspan='3' style='border: 1pt solid black;'>supplier :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
	    		if(item.get("supplierName")!=null)
                printData=printData+item.get("supplierName")+"<br>Address :&nbsp;&nbsp;&nbsp;&nbsp;";
	    		if(item.get("supplierAdd")!=null)
	    		printData=printData+item.get("supplierAdd")+" <br> Tel:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
	    		if(item.get("supplierPhoneNO")!=null)
	    		printData=printData+item.get("supplierPhoneNO")+" <br>E-mail:&nbsp;&nbsp;&nbsp;&nbsp;</td > <td colspan='4' style='border: 1pt solid black;' >P.O NO :&nbsp;&nbsp;"+item.get("poNumber")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; G.R NO :&nbsp;&nbsp"+item.get("GRNumber")+"<br>P.O Date :&nbsp;&nbsp;" +item.get("poDate")+":&nbsp;&nbsp; G.R Date: &nbsp;&nbsp;"+item.get("GRDate")+"<br>Bill No :&nbsp;&nbsp;&nbsp;"+item.getDouble("billNumber")+"<br>Add :&nbsp;&nbsp;&nbsp;"+item.get("siteAddress")+"<br>Phone No :&nbsp;&nbsp;"+item.get("sitePhone")+"</td></tr>";
	    		printData=printData+"<tr class='BoldStyle'><td colspan='2' style='border: 1pt solid black;'>Item Name</td><td colspan='1' style='border: 1pt solid black;'>Quantity</td><td colspan='1' style='border: 1pt solid black;'>Price</td><td colspan='1' style='border: 1pt solid black;'>VAT(%)</td><td colspan='2' style='border: 1pt solid black;'>Total Price</td></tr>";
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
	 			  for (int i = 0, size = itemArray.length(); i < size; i++)
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

	 			
	 			                     printData=printData+ printerCommands.getTableRowTag('s')+printerCommands.getTableRowTag('e');  
	 		                         printData= printData+printerCommands.getTableRowTag('s')+printerCommands.getTableColumnTag('s',2)+item.get("itemName").toString()+printerCommands.getTableColumnTag('e')+printerCommands.getTableColumnTag('s',1)+item.get("grQuantity").toString() + printerCommands.getTableColumnTag('e')+printerCommands.getTableColumnTag('s',1)+item.get("itemRate").toString() + "</td>"+printerCommands.getTableColumnTag('s',1)+item.getString("itemVat").toString()+printerCommands.getTableColumnTag('e') + printerCommands.getTableColumnTag('s',2)+item.get("lineTotal").toString() + printerCommands.getTableColumnTag('e') +printerCommands.getTableRowTag('e');
	 			     			           
	 			                   
	 		                  } 
	 			 
	 		       }else
	 		       {
	 		    	  for (int i = 0, size = itemArray.length(); i < size; i++)
	                  {
	                     JSONObject item = itemArray.getJSONObject(i);

	 			       
	                     printData=printData+item.get("itemSKU") + "   " +  item.get("poQuantity") + "   0.00    "+ item.get("lineTotal") + printerCommands.getNewLine(); // SKU       qty    tax     line total
	                     printData=printData+item.get("itemName") + "   " + item.get("itemRate") + "     (-)        "+ printerCommands.getNewLine(); // Header 1
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
			 
	    	case 2: //starting GR print profile 2
   			if(PrinterType.equalsIgnoreCase(Constants.PRINTER_LASER))
		       	{
	
   				    printData=printData+ printerCommands.getTableRowTag('s')+printerCommands.getTableRowTag('e'); 
   				    printData=printData+ printerCommands.getTableRowTag('s')+printerCommands.getTableRowTag('e'); 
   				    printData=printData+ printerCommands.getTableRowTag('s')+printerCommands.getTableRowTag('e'); 
				    printData=printData+ printerCommands.getTableRowTag('s')+printerCommands.getTableRowTag('e'); 
				    printData=printData+ printerCommands.getTableRowTag('s')+printerCommands.getTableRowTag('e'); 
   				    printData=printData+ printerCommands.getTableRowTag('s')+printerCommands.getTableRowTag('e'); 
   				    printData=printData+ printerCommands.getTableRowTag('s')+printerCommands.getTableRowTag('e'); 
   				    printData=printData+ printerCommands.getTableRowTag('s')+printerCommands.getTableRowTag('e'); 
		    		printData=printData+"<tr class='BoldStyle'><td colspan='5' align='right'>Sub Total(Rs):- </td><td colspan='2'>"+item.getDouble("subTotal")+"</td></tr>";  //<td colspan='4' style='border: 1pt solid black;'>Remarks :"+item.get("remark")+"</td>
		    		printData=printData+"<tr class='BoldStyle'><td colspan='1'>VAT : <br> TIN : </td><td colsapn='1'>"+item.get("VATNo")+"<br>"+item.get("TinNo")+"</td><td colspan='4' align='right'>Dis. <br> Tax(%) </td><td colspan='2' >"+item.getDouble("discount")+"<br>"+item.getDouble("tax1")+"</td></tr>";
		    		printData=printData+"<tr class='BoldStyle'><td colspan='5' align='right'>Net Amount(Rs):-  </td><td colspan='2'>"+item.getDouble("finalAmount")+"</td></tr>";		    							
	
		    		printData=printData+"<tr class='BoldStyle'><td colspan='5' align='right'>Total Amount(Rs):-  </td><td colspan='2'>"+item.getDouble("finalAmount")+"</td></tr>";
		    	    printData=printData+printerCommands.getTableTag('e')+printerCommands.getBodyTag('e')+printerCommands.getHtmlTag('e');
		       	} else
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
				}
	    		
	    		break; //finishing print profile 2

		default:
			break;
			
		}  
		  
		
		  
		  
	  
		 return printData;
	
	  }
}
