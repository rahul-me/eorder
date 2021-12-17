package com.bms.pdf;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.bms.constants.Constants;
import com.bms.mdm.item.ItemDBHelper;
import com.bms.neetai.company.CompanyDBHelper;
import com.bms.neetai.userroles.UserRoleDBHelper;
import com.bms.neetai.users.UserDBHelper;
import com.bms.order.orderdetail.OrderDetailActionForm;
import com.bms.order.orderdetail.OrderDetailDBHelper;
import com.bms.order.ordermaster.OrderMasterDBHelper;
import com.bms.retaildetail.RetailDetailDBHelper;
import com.bms.utility.number.EnglishNumberToWords;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


public class GetCompanyInvoice extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		String data = request.getParameter("data");
		JSONObject jsonObject = null;
		JSONArray jsonArrayOrderDetailIds =null, jsonArrayDispachValues=null, jsonArrayEditableRates=null;
		String orderDetailId = null; 
		try{
		jsonObject = new JSONObject(data);
		jsonArrayOrderDetailIds = jsonObject.getJSONArray("orderDetailIds");
		jsonArrayDispachValues = jsonObject.getJSONArray("dispatchQuantityValues");
		jsonArrayEditableRates = jsonObject.getJSONArray("editableRates");		
		orderDetailId = jsonArrayOrderDetailIds.getString(0);
		}catch(JSONException je){
			System.out.println(je);
		}
		
		OrderDetailDBHelper orderDetailHelper = new OrderDetailDBHelper();
		OrderMasterDBHelper orderMasterHelper = new OrderMasterDBHelper();
		UserRoleDBHelper userRoleHelper = new UserRoleDBHelper();
		UserDBHelper userHelper = new UserDBHelper();
		RetailDetailDBHelper retailDetailHelper = new RetailDetailDBHelper();
		int orderMasterId = orderDetailHelper.getOrderByorderDetailDBAdapterId(Integer.parseInt(orderDetailId)).getOrderMasterId();
		String name = userRoleHelper.getUserRoleByRoleId(userHelper.getSingleUserByUserId(orderMasterHelper.getOrderByMasterId(orderMasterId).getUserMasterId()).getUserRolesMasterId()).getName();
		int userid = orderMasterHelper.getOrderByMasterId(orderMasterId).getUserMasterId();
		String address = "";
		String unameInPlaceOfCompany = userHelper.getSingleUserByUserId(userid).getFirstName()+" "+userHelper.getSingleUserByUserId(userid).getLastName();
		String phonenumber = "Not Available";
		String cstidno ="Not Available", vatidno="Not Available", suppref="Not Available";
		if(userHelper.getSingleUserByUserId(userid).getPhoneNumber1()!=null && userHelper.getSingleUserByUserId(userid).getPhoneNumber1()!="")
		{
			phonenumber = userHelper.getSingleUserByUserId(userid).getPhoneNumber1();
		}
		if(name.equalsIgnoreCase(Constants.ROLE_NAME_FOR_RETAILER)){
			address = userHelper.getSingleUserByUserId(userid).getAddress();
			try{
			if(retailDetailHelper.findDataIsAvailableOrNotForRetailid(userid)){
				cstidno = retailDetailHelper.getRetailDetailByRetailId(userid).getCstidno();
				vatidno = retailDetailHelper.getRetailDetailByRetailId(userid).getVatidno();
				suppref = retailDetailHelper.getRetailDetailByRetailId(userid).getSuppref();
			}
			}catch(Exception e){
				System.out.println("Exception in retailer check"+e);
			}
		}
		
		SimpleDateFormat formator1 = new SimpleDateFormat(Constants.DATE_FORMAT_DATE);
		SimpleDateFormat formator2 = new SimpleDateFormat(Constants.DATE_DD_MM_YYYY);
		String tdate = formator1.format(new Date());
		String tdate_in_dmy = formator2.format(new Date());
		
		PdfPTable table = null;
		if(jsonObject!=null && jsonArrayDispachValues!=null && jsonArrayOrderDetailIds!=null){
			try{
			table=new PdfPTable(5);
			table.setWidthPercentage(100);
			table.setSpacingBefore(10f);
			table.setSpacingAfter(10f);
		
			Font font1=new Font(Font.FontFamily.TIMES_ROMAN,10,Font.BOLD);
			Font font2=new Font(Font.FontFamily.TIMES_ROMAN,10,Font.NORMAL);
			Font font3 = new Font(Font.FontFamily.TIMES_ROMAN,16,Font.BOLD);
			
			float borderwidth = 1f;
			
			Paragraph paraForRetailerAddress = new Paragraph();
			paraForRetailerAddress.add(new Paragraph("To,", font1));
			paraForRetailerAddress.add(Chunk.NEWLINE);
			paraForRetailerAddress.add(new Paragraph(unameInPlaceOfCompany, font1));
			paraForRetailerAddress.add(Chunk.NEWLINE);
			paraForRetailerAddress.add(Chunk.NEWLINE);
			paraForRetailerAddress.add(new Paragraph(address, font2));
			paraForRetailerAddress.add(Chunk.NEWLINE);
			paraForRetailerAddress.add(new Paragraph("Contact Number: "+phonenumber, font2));
			paraForRetailerAddress.add(Chunk.NEWLINE);
			paraForRetailerAddress.add(Chunk.NEWLINE);
			paraForRetailerAddress.add(new Paragraph("CST TIN NO: "+cstidno, font1));
			paraForRetailerAddress.add(Chunk.NEWLINE);
			paraForRetailerAddress.add(new Paragraph("VAT TIN NO: "+vatidno, font1));
			
			
			PdfPCell cell = new PdfPCell(paraForRetailerAddress);
			cell.setColspan(3);
			cell.setBorderWidth(borderwidth);
			table.addCell(cell);
			
			Paragraph paraForIvoiceDetail = new Paragraph();
			paraForIvoiceDetail.add(new Paragraph("TAX INVOICE", font1));
			paraForIvoiceDetail.add(Chunk.NEWLINE);
			paraForIvoiceDetail.add(Chunk.NEWLINE);
			paraForIvoiceDetail.add(new Paragraph("Invoice No: ", font1));
			paraForIvoiceDetail.add(Chunk.NEWLINE);
			paraForIvoiceDetail.add(new Paragraph("Invoice Date: "+tdate, font1));
			paraForIvoiceDetail.add(Chunk.NEWLINE);
			paraForIvoiceDetail.add(new Paragraph("Supp Ref: "+suppref, font1));
			paraForIvoiceDetail.add(Chunk.NEWLINE);
			paraForIvoiceDetail.add(new Paragraph("Sale Date: "+tdate_in_dmy, font1));
			
			cell = new PdfPCell(paraForIvoiceDetail);
			cell.setColspan(2);
			cell.setBorderWidth(borderwidth);
			table.addCell(cell);
			
			String lrno = jsonObject.getString("lrno");
			
			Paragraph paragraphforNos = new Paragraph();
			paragraphforNos.add(new Paragraph("PO NO: ", font1));
			paragraphforNos.add(Chunk.NEWLINE);
			paragraphforNos.add(new Paragraph("LR NO: "+lrno, font1));
			
			cell = new PdfPCell(paragraphforNos);
			cell.setColspan(3);
			cell.setBorderWidth(borderwidth);
			table.addCell(cell);
			
			Paragraph paragraphforDates = new Paragraph();
			paragraphforDates.add(new Paragraph("PO Date:"+tdate, font1));
			paragraphforDates.add(Chunk.NEWLINE);
			paragraphforDates.add(new Paragraph("TO Date:"+tdate, font1));
			
			cell = new PdfPCell(paragraphforDates);
			cell.setColspan(2);
			cell.setBorderWidth(borderwidth);
			table.addCell(cell);
			
			cell = new PdfPCell(new Paragraph("Sr No", font1));
			cell.setBorderWidth(1);
			table.addCell(cell);
			
			cell = new PdfPCell(new Paragraph("Product", font1));
			cell.setBorderWidth(1);
			table.addCell(cell);
			
			cell = new PdfPCell(new Paragraph("Quantity", font1));
			cell.setBorderWidth(1);
			table.addCell(cell);
			
			cell = new PdfPCell(new Paragraph("Rate", font1));
			cell.setBorderWidth(1);
			table.addCell(cell);
			
			cell = new PdfPCell(new Paragraph("Amount", font1));
			cell.setBorderWidth(borderwidth);
			table.addCell(cell);
			
			// code to display items purchased
			
			
			ItemDBHelper itemHelper = new ItemDBHelper();
			float totalamount = 0f;
			float totalQuantity = 0f;
			int serialcounter = 0; 
			for(int i=0 ; i<jsonArrayOrderDetailIds.length(); i++){
				String detailId = jsonArrayOrderDetailIds.getString(i);
				String dispatchValue = jsonArrayDispachValues.getString(i);
				String editedRate = jsonArrayEditableRates.getString(i);
				System.out.println(detailId+" "+dispatchValue);
				
				if(!dispatchValue.equalsIgnoreCase("")){
					totalQuantity+=Float.parseFloat(dispatchValue);
					serialcounter+=1;
					
					OrderDetailActionForm orderDetailBean = orderDetailHelper.getOrderByorderDetailDBAdapterId(Integer.parseInt(detailId));
					String product = itemHelper.getItemById(orderDetailBean.getItemMasterId()).getName();
					String rate = editedRate;
					Float amount = Float.parseFloat(dispatchValue) * Float.parseFloat(editedRate);
					totalamount+=amount;
					
					
					cell = new PdfPCell(new Paragraph(Integer.toString(serialcounter), font2));
					cell.setBorderWidth(borderwidth);
					table.addCell(cell);
					
					cell = new PdfPCell(new Paragraph(product, font2));
					cell.setBorderWidth(borderwidth);
					table.addCell(cell);
					
					cell = new PdfPCell(new Paragraph(dispatchValue, font2));
					cell.setBorderWidth(borderwidth);
					table.addCell(cell);
					
					cell = new PdfPCell(new Paragraph(rate, font2));
					cell.setBorderWidth(borderwidth);
					table.addCell(cell);
					
					cell = new PdfPCell(new Paragraph(Float.toString(amount), font2));
					cell.setBorderWidth(borderwidth);
					table.addCell(cell);
				}
			}
			
			
			HttpSession httpSession = request.getSession();
			int companyid = (int)httpSession.getAttribute(Constants.COMPANY_ID);			
			CompanyDBHelper companyHelper = new CompanyDBHelper();
			float saletax = companyHelper.getCompanybyCompanyMasterId(companyid).getSaletax();
			float saletaxamount = 0f;
			if(saletax>0){
				saletaxamount = (totalamount * saletax)/100;
			}
			
			float gtotal = saletaxamount + totalamount;
			long ntocov = (long)gtotal;
			String numberinwords = EnglishNumberToWords.convert(ntocov);
			
			cell = new PdfPCell(new Paragraph("Total", font2));
			cell.setColspan(2);
			cell.setBorderWidth(borderwidth);
			table.addCell(cell);
			
			cell = new PdfPCell(new Paragraph(Float.toString(totalQuantity), font2));
			cell.setBorderWidth(borderwidth);
			table.addCell(cell);
			
			cell = new PdfPCell(new Paragraph(""));
			cell.setBorderWidth(borderwidth);
			table.addCell(cell);
			
			cell = new PdfPCell(new Paragraph(Float.toString(totalamount), font2));
			cell.setBorderWidth(borderwidth);
			table.addCell(cell);
			
			
			
			cell = new PdfPCell(new Paragraph("Sale tax ("+saletax+"%)", font1));
			cell.setColspan(4);
			cell.setBorderWidth(borderwidth);
			table.addCell(cell);
			
			cell = new PdfPCell(new Paragraph(Float.toString(saletaxamount), font1));
			cell.setBorderWidth(borderwidth);
			table.addCell(cell);
			
			
			
			cell = new PdfPCell(new Paragraph(numberinwords, font1));
			cell.setColspan(3);
			cell.setBorderWidth(borderwidth);
			table.addCell(cell);
			
			cell = new PdfPCell(new Paragraph("Grand Total", font1));
			cell.setBorderWidth(borderwidth);
			table.addCell(cell);
			
			cell = new PdfPCell(new Paragraph(Float.toString(gtotal), font1));
			cell.setBorderWidth(borderwidth);
			table.addCell(cell);
			
			Paragraph paraTC = new Paragraph();
			paraTC.add(new Paragraph("Terms & Conditions:", font1));
			paraTC.add(Chunk.NEWLINE);
			paraTC.add(new Paragraph("1) Goods Once Sold Can not be taken back or exchange.", font2));
			paraTC.add(Chunk.NEWLINE);
			paraTC.add(new Paragraph("2) Payment Should be made by demand draft or rtgs only.", font2));
			paraTC.add(Chunk.NEWLINE);
			paraTC.add(new Paragraph("3) Check Quantity and Quality before Use.", font2));
			paraTC.add(Chunk.NEWLINE);
			paraTC.add(new Paragraph("4) We are not responsible for any loss, Shortage or brackage in transit.", font2));
			paraTC.add(Chunk.NEWLINE);
			paraTC.add(new Paragraph("Subject to VADODARA Juridiction ", font2));
			paraTC.add(Chunk.NEWLINE);
			paraTC.add(Chunk.NEWLINE);
			
			cell = new PdfPCell(paraTC);
			cell.setColspan(3);
			cell.setBorderWidth(borderwidth);
			table.addCell(cell);
			
			
			String companyName = companyHelper.getCompanybyCompanyMasterId(companyid).getName();
			Paragraph paraSign = new Paragraph();
			paraSign.add(new Paragraph("From,", font1));
			paraSign.add(Chunk.NEWLINE);
			paraSign.add(new Paragraph(companyName, font1));
			paraSign.add(Chunk.NEWLINE);
			paraSign.add(Chunk.NEWLINE);
			paraSign.add(Chunk.NEWLINE);
			paraSign.add(new Paragraph("Authority Signatory", font2));
			
			cell = new PdfPCell(paraSign);
			cell.setColspan(2);
			cell.setBorderWidth(borderwidth);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell);
			}catch(Exception e){
				System.out.println("Exception in table generation"+e);
			}
			
			try{
			Document document=new Document();
			
			ByteArrayOutputStream outStream=new ByteArrayOutputStream();			
			PdfWriter.getInstance(document, outStream);
			document.open();
			document.add(table);
			document.close();
			response.setContentType("application/pdf");
			response.setHeader("Content-disposition", "attachment; filename=CompanyInvoice.pdf");
			response.setContentLength(outStream.size());
			
			ServletOutputStream servletOutStream=response.getOutputStream();						
			
			byte var[] = outStream.toByteArray();
			InputStream in = new ByteArrayInputStream(var);
			while(in.read(var) != -1){
	        	servletOutStream.write(var);
	        }
			
			
			//outStream.writeTo(servletOutStream);
			in.close();
			/*servletOutStream.flush();
			servletOutStream.close();*/
			/*response.getOutputStream().flush();
			response.getOutputStream().close();*/
			}catch(Exception e){
				System.out.println(e);
			}
						
		}
		return null;
	}
}
