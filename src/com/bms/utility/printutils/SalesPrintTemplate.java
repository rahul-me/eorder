package com.bms.utility.printutils;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.bms.constants.Constants;
import com.bms.neetai.company.CompanyActionForm;
import com.bms.neetai.company.CompanyDBHelper;
import com.lowagie.text.pdf.hyphenation.TernaryTree.Iterator;

public class SalesPrintTemplate extends PrintTemplate{
	public SalesPrintTemplate() {
		 this.profileNo=1;
		 printerCommands=new PrinterCommands();
	         printData="";
	}
	public SalesPrintTemplate(int profileNo){
		this.profileNo=profileNo;
		 printerCommands=new PrinterCommands();
		  printData="";
	}
	
	
	CompanyDBHelper companyDBHelper=new CompanyDBHelper();
	CompanyActionForm companyActionForm=companyDBHelper.getSingleUserByUserId(1);
	public String getPrintHeader(JSONObject item, String PrinterType)throws JSONException
	{
		switch (profileNo) {
	    	case 1://starting print format for Rental Base Client.
	    		
	 		if(PrinterType.equalsIgnoreCase(Constants.PRINTER_LASER))
	 		       {
	 			printData="";
	 			printData=printData+ printerCommands.getHtmlTag('s');
	 			//printData=printData+printerCommands.getStyleSheet("ORDER");
	 		    printData=printData+printerCommands.getBodyTag('s')+printerCommands.getTableTag('s');
	    		
	    	   
			    printData=printData+"<tr class='BoldStyle header' align='center'><td colspan='7' style='border: 1pt  solid black;font-weight: bold;'>";
			    printData=printData+item.get("companyName"); 
			   	printData=printData+"</td></tr>";
	    	    printData=printData+"<tr><td style='border: 1pt solid black;' colspan='4'><span><font size='3px'>CUSTOMER DETAILS</span></td><td style='border: 1pt solid black;' colspan='3'><span><font size='3px'>ORDER DETAILS</span></td></tr>";
	    	    printData=printData+"<tr><td colspan='4' style='border: 1pt solid black;'>Customer Name :&nbsp;&nbsp;&nbsp;&nbsp;";
	    		if(item.get("custName")!=null)
	    		{
				printData=printData+item.get("custName");
				}
	    		printData=printData+"<br>Address :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ";
	    		printData=printData+item.get("custAddress")+"<br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
	    		/*printData=printData+item.get("village")+" , ";
	    		printData=printData+item.get("taluka")+" ,  ";*/
	    		printData=printData+item.get("custCity")+" <br>Contact NO :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
	    		if(item.get("custContact")!=null)
				printData=printData+item.get("custContact")+"</td > <td colspan='3' style='border: 1pt  solid black;'><br><br>Order NO :&nbsp;&nbsp;&nbsp;&nbsp;";
				printData=printData+item.get("orderNo")+"<br>Order Date:&nbsp;&nbsp;&nbsp;&nbsp;"+item.get("orderDate")+"</td></tr>";
	    		printData=printData+"<tr class='BoldStyle'><td colspan='3' style='border: 1pt  solid black; font-weight: bold;'>Item Name</td><td colspan='2' style='border: 1pt solid black; font-weight: bold;'>Qty</td><td colspan='1' style='border: 1pt solid black; font-weight: bold;'>Rate</td><td colspan='1' style='border: 1pt solid black; font-weight: bold;'>Amount</td></tr>";     
	 		       }
	    	          
	 		 else
	 		 {
	 			
	 			 // This Code has been written for Thermal Priting
	 			 
	 			 
	 			printData="";
	 			printData=printData+ printerCommands.getHtmlTag('s');
	 			printData=printData+printerCommands.getBodyTag('s')+printerCommands.getTableTag('s');
	    		
	    	    printData=printData+"<tr><td colspan='7' style='font-weight: bold;margin-left:10px;' align='center'>";
			    printData=printData+item.get("companyName"); 
			   	printData=printData+"</td></tr>";
			    printData=printData+"<tr><td colspan='7' style='font-weight: bold;margin-left:10px;' align='center'>";
			    printData=printData+item.get("companyAddress"); 
			   	printData=printData+"</td></tr>";
	    	   
			   	 
			    printData=printData+"";
	    		if(item.get("lblOrderDetails")!=null)
	    		{
	    			printData=printData+"<tr><td colspan='7' align='center'><br><br>----------------------------------------------------------------------------------------------------------------------------<br>"+item.get("lblOrderDetails")+"<br>----------------------------------------------------------------------------------------------------------------------------</td></tr>";
				
				}
	    	    printData=printData+"<tr><td colspan='3.5' align='left'>Name &nbsp;&nbsp;&nbsp;:";
	    		if(item.get("custName")!=null)
	    		{
				printData=printData+item.get("custName")+"</td>";
				}
	    		printData=printData+"<td colspan='3.5' align='right'> Order NO :";
	    		if(item.get("orderNo")!=null)
	    		{
	    		printData=printData+item.get("orderNo")+"</td></tr>";
	    		}
	    		
	    		
	    		printData=printData+"<tr><td colspan='3.5' align='left'>Contact :";
	    		if(item.get("custContact")!=null)
	    		{
	    		printData=printData+item.get("custContact")+"</td>";
	    		}
				printData=printData+"<td colspan='3.5' align='right'>Order Date :";
	    		if(item.get("orderDate")!=null)
	    		{
	    		printData=printData+item.get("orderDate")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td></tr>";
	    		}
	    		
	    		
	 			 
	 		
                     //JSONObject item = itemArray.getJSONObject(i);
	 			
	 		 }

			 break;
	 		
	 		///finishing print profile 1
			 
	    	case 2:
	    	// Here We Have to Set Another Client Print Format.
	    	if(PrinterType.equalsIgnoreCase(Constants.PRINTER_LASER))
		       {
	    		
		       }
   		else{
   			
   		}
	    		
	    		break;
	   
		default:
			break;
			
		}  
		  
		 return printData;
	
	  }
	
	public String getDeliveryChallanPrintHeader(JSONObject item, String PrinterType)throws JSONException
	{
		switch (profileNo) {
	    	case 1://starting print format for Rental Base Client.
	    		
	 		if(PrinterType.equalsIgnoreCase(Constants.PRINTER_LASER))
	 		       {
	 			printData="";
	 			printData=printData+ printerCommands.getHtmlTag('s');
	 		    printData=printData+printerCommands.getStyleSheet("Sale Rental");
	    	    printData=printData+printerCommands.getBodyTag('s')+printerCommands.getTableTag('s');
	    	   
				printData=printData+"<tr class='BoldStyle header' align='center'><td style='border: 1pt solid black;' colspan='7' ><img  align='left' src='../../"+companyActionForm.getLogo()+"'><font size='5px'>"+item.get("companyName")+"</span><br><font size='3px'>"+item.get("companyAddress")+"<br><font size='3px'>Contact NO: 9904132608"+"</td></tr>";
	    	    printData=printData+"<tr class='BoldStyle header' align='center'><td colspan='7' style='border: 1pt  solid black;font-weight: bold;'>D E L I V E R Y &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; C H A L L A N</td></tr>";
	    	    printData=printData+"<tr><td style='border: 1pt solid black;' colspan='4'><span><font size='3px'>CUSTOMER DETAILS</span></td><td style='border: 1pt solid black;' colspan='3'><span><font size='3px'>DELIVERY DETAILS</span></td></tr>";
	    	    printData=printData+"<tr><td colspan='4' style='border: 1pt solid black;'>Customer Name :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
	    		if(item.get("customerName")!=null)
				printData=printData+item.get("customerName")+"<br>Address :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ";
	    		printData=printData+item.get("customerAdd")+" <br>Contact NO :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
	    		if(item.get("customerContact")!=null)
				printData=printData+item.get("customerContact")+" <br> Delivery Date:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
	    		if(item.get("deliveryDate")!=null)
				printData=printData+item.get("deliveryDate")+"</td > <td colspan='3' style='border: 1pt  solid black;'><br><br>Challan NO :&nbsp;&nbsp;&nbsp;&nbsp;";
				printData=printData+item.get("saleNumber")+"<br> Date & Time: &nbsp;&nbsp;<br>";
				printData=printData+item.get("deliveryDateTime")+"</td></tr>";
	    		printData=printData+"<tr class='BoldStyle'><td colspan='4' style='border: 1pt  solid black; font-weight: bold;'>Item Name</td><td colspan='3' style='border: 1pt solid black; font-weight: bold;'>Qty</td></tr>";
	 			     
	 		       }
	    	          
	 		 else
	 		 {
	 			
	 		 }

			 break;
	 		
	 		///finishing print profile 1
			 
	    	case 2:
	    	// Here We Have to Set Another Client Print Format.
	    	if(PrinterType.equalsIgnoreCase(Constants.PRINTER_LASER))
		       {
	    		
		       }
   		else{
   			
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
	    	case 1://starting print format for Rental Base Client.
	 		if(PrinterType.equalsIgnoreCase(Constants.PRINTER_LASER))
	 		       {
	 						
	 			             for (int i = 1; i<itemArray.length();  ++i)
	 		                  {
	 		                     JSONObject item = itemArray.getJSONObject(i);
	 		                     printData= printData+printerCommands.getTableRowTag('s')+printerCommands.getTableRowTag('e');
		 		                    if(item.getString("itemName")!=null && item.get("itemQty")!=null && item.get("itemRate")!=null && item.get("itemAmt")!=null)
		 		                    {
		 		                    printData= printData+printerCommands.getTableRowTag('s')+printerCommands.getTableColumnTag('s',3)+item.getString("itemName").toString()+printerCommands.getTableColumnTag('e')+printerCommands.getTableColumnTag('s',2)+item.get("itemQty").toString()+printerCommands.getTableColumnTag('e')+printerCommands.getTableColumnTag('s',1)+item.get("itemRate").toString() + "</td>"+printerCommands.getTableColumnTag('s',1)+item.get("itemAmt").toString() + printerCommands.getTableColumnTag('e') +printerCommands.getTableRowTag('e');
		 		                    }
	 		                 } 
	 		       }
	 		else{
	 			  
	 			//printData=printData+"Deepam: ";
	 			printData=printData+"<tr><td colspan='7' align='center'><br>---------------------------------------------------------------------------------------------------------------------------</td></tr>";
	 			for (int i = 1; i<itemArray.length();  ++i)
	                  {
	                     JSONObject item = itemArray.getJSONObject(i);
	            
	            printData=printData+"<tr align='center'><td colspan='1.75' style='font-weight:bold;'>Item Name :";
	 			printData=printData+item.get("itemName")+"</td>";
	 			
	 			printData=printData+"<td colspan='1.75' style='font-weight:bold;'>Quentity :";
	 			printData=printData+item.get("itemQty")+"</td>";
	 			
	 			printData=printData+"<td colspan='1.75' style='font-weight:bold;'>Rate :";
	 			printData=printData+item.get("itemRate")+"</td>";
	 			
	 			printData=printData+"<td colspan='1.75' style='font-weight:bold;'><br>Amount :";
	 			printData=printData+item.get("itemAmt")+"<br></td></tr>";
	 			
	 			}
	 			printData=printData+"<tr><td colspan='7' align='center'>---------------------------------------------------------------------------------------------------------------------------</td></tr>";	
	             }
				
			 break;
	    	case 2:
	    		// Here We Have to Set Another Client Print Format.
	    		break;
	 		///finishing print profile 2

		default:
			break;
			
		}  
		  
		
		 return printData;
	
	  }
	
	public String getDeliveryChallanPrintBody(JSONArray itemArray, String PrinterType)throws JSONException
	{
	  printData="";
		 switch (profileNo) {
	    	case 1://starting print format for Rental Base Client.
	 		if(PrinterType.equalsIgnoreCase(Constants.PRINTER_LASER))
	 		       {
	 						
	 			             for (int i = 0; i<itemArray.length();  ++i)
	 		                  {
	 			            	 JSONObject item = itemArray.getJSONObject(i);
	 		                     printData= printData+printerCommands.getTableRowTag('s')+printerCommands.getTableRowTag('e');
	 		                     printData= printData+printerCommands.getTableRowTag('s')+printerCommands.getTableColumnTag('s',4)+item.getString("saleItemName").toString()+printerCommands.getTableColumnTag('e') +printerCommands.getTableColumnTag('s',3)+item.get("saleQuantity").toString()+printerCommands.getTableColumnTag('e') +printerCommands.getTableRowTag('e');
	 		                  }
	 		       }
	    	 else{
	 			  
				
	             }
				
			break;
	    	case 2:
	    		// Here We Have to Set Another Client Print Format.
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
	 			printData=printData+"<tr class='BoldStyle' align='right'><td colspan='6' style='border: 1pt solid black;'>Total(Rs)</td><td colspan='1' style='border: 1pt solid black;'>"+item.getDouble("totalBill")+"</td></tr>";  
 			 	printData=printData+"<tr><td align='left' colspan='4' style='border: 1pt solid black;'><br><br><span align='right' style='text-decoration: underline;'>Receiver's sign</span><br><br><br><br></td><td colspan='3' style='border: 1pt solid black;margin-left:100px;'><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style='text-decoration: underline;'>Delivery Person's Sign</span><br><br><br><br></td></tr>";
 				printData=printData+printerCommands.getTableTag('e')+printerCommands.getBodyTag('e')+printerCommands.getHtmlTag('e');
		 	}
	    	else
	 		{  
	    		
	    		
	    		
	    		printData=printData+"<tr><td colspan='7' style='font-weight:bold;' align='right'>TOTAL BILL :";
	 			printData=printData+item.get("totalBill")+"&nbsp;&nbsp;&nbsp;&nbsp;</td></tr>";
	 			
	 			printData=printData+"<tr><td colspan='3.5' style='font-weight:bold;' align='left'><br><br>Receiver's  Signature</td>";
	 			printData=printData+"<td colspan='3.5' style='font-weight:bold;' align='right'><br><br>Delivery Person's  Signature</td></tr>";
	 			
	    		//printData=printData+"Total Amount: " +  item.get("totalBill");
		 		//printData=printData+printerCommands.getNewLine(); 
	    		
		 		
		 		//int totalItemNo = item.getInt("totalItemNo");
	 			/*if(totalItemNo != 0 ){
	 			 
				 	printData= printData+" packages Charges: 0.00                      SUB TOTAL: "+ item.get("subTotal") + printerCommands.getNewLine(); // subtotal
	 				printData= printData+"  Delivery Charges: 0.00                    Adjustment: "+   printerCommands.getNewLine(); 
	 				printData= printData+" Purchase Tax:   0.00                   Discount : "+ item.get("discount") +printerCommands.getNewLine(); // discount
	 				printData= printData+" servece Tax: 0.00                        --------------"+ printerCommands.getNewLine(); // seperator
	 				printData= printData+"                 NET PAYABLE:    "+ item.get("netTotal")+printerCommands.getNewLine()+printerCommands.getNewLine()+printerCommands.getNewLine(); // net payable
	 				printData= printData+"Total Items : "+ item.get("totalItemNo") +printerCommands.getNewLine(); // total items count
	 				printData= printData+"Quantity    : "+  item.get("quantity") +printerCommands.getNewLine(); // total quantity 
						
				}*/

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
			 
	    	case 2:// Here We Have to Set Another Client Print Format.
	    	
	    		
	    		break; //finishing print profile 2

		default:
			break;
			
		}  
		 return printData;
	
	  }
	
	
	public String getDeliveryChallanPrintFooter(JSONObject item, String PrinterType)throws JSONException
	{
		printData="";
	 
		 switch (profileNo) {
	    	case 1://starting print profile 1
	    		
	 		if(PrinterType.equalsIgnoreCase(Constants.PRINTER_LASER))
	 		{
	 			      
	 			    printData=printData+"<tr><td align='left' colspan='4' style='border: 1pt solid black;'><img  align='left' height='75' width='500' src='../../assets/img/varunCondition1.jpg'><br><br><br><br><br><br>Best Regards,<br>"+item.get("companyName")+"<br><br><span style='text-decoration: underline;'>APPROVED BY</span><br>"+item.get("createdUserName")+"</td><td align='right' colspan='3' style='border: 1pt solid black;'><br><br><br><br><br><br><br><span style='text-decoration: underline;'>TAKEN BY</span><br><br>"+item.get("customerName")+"</td></tr>";
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
			 
	    	case 2:// Here We Have to Set Another Client Print Format.
	    	
	    		
	    		break; //finishing print profile 2

		default:
			break;
			
		}  
		 return printData;
	
	  }
	
	
}
