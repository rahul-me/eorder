package com.bms.sale;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bms.constants.Constants;
import com.bms.mdm.item.ItemDBHelper;
import com.bms.sale.saledetail.SaleDetailActionForm;
import com.bms.sale.saledetail.SaleDetailDBHelper;
import com.bms.sale.salemaster.SaleMasterActionForm;
import com.bms.sale.salemaster.SaleMasterDBHelper;
import com.bms.utility.number.EnglishNumberToWords;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.bms.neetai.company.CompanyDBHelper;
import com.bms.neetai.users.UserDBHelper;
import com.bms.order.orderdetail.OrderDetailActionForm;
import com.bms.retail.RetailActionForm;
import com.bms.retail.RetailDBHelper;

public class SaleMasterAction extends Action {
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws SQLException{
		
		SaleDetailActionForm saleDetailBean = (SaleDetailActionForm)form;
		HttpSession httpSession = request.getSession(true);
		int userid = (int)httpSession.getAttribute(Constants.SESSION_INFO_USER_ID);
		
		RetailDBHelper retailHelper = new RetailDBHelper();
		SaleDetailDBHelper saleDetailHelper = new SaleDetailDBHelper();
		SaleMasterActionForm saleMasterBean = new SaleMasterActionForm();
		SaleMasterDBHelper saleMasterHelper = new SaleMasterDBHelper();
		UserDBHelper userHelper = new UserDBHelper();
		int companyMasterId = userHelper.getSingleUserByUserId(userid).getCompanyMasterId();
		
		String itemid[] = request.getParameterValues("itemid");
		String quantity[] = request.getParameterValues("quantity");
		String rate[] = request.getParameterValues("rate");
		String saleDetailIdU[] = request.getParameterValues("saleDetailIdU");
		
		Float totalquantity = 0f;
		Float totalamount = 0f;
		for(int i = 0 ; i < quantity.length; i++){
			totalquantity += Float.parseFloat(quantity[i]);
			totalamount += (Float.parseFloat(quantity[i]) * Float.parseFloat(rate[i]));
		}
		
		if (!saleDetailBean.isUpdate()) {

			// Make a master bean
			saleMasterBean.setCreatedDate(saleDetailBean.getCreatedDate());
			saleMasterBean.setCompanyMasterId(companyMasterId);
			saleMasterBean.setRetailid(userid);
			saleMasterBean.setOrderquantity(totalquantity);
			saleMasterBean.setTotal(totalamount);
			saleMasterBean.setConsumername(saleDetailBean.getConsumername());
			saleMasterBean.setConsumeraddress(saleDetailBean.getConsumeraddress());
			int salemasterid = saleMasterHelper.insertDetails(saleMasterBean);

			// make a detail bean
			for (int i = 0; i < itemid.length; i++) {
				// make a detail bean
				saleDetailBean.setItemid(Integer.parseInt(itemid[i]));
				saleDetailBean.setQuantity(Float.parseFloat(quantity[i]));
				saleDetailBean.setRate(Float.parseFloat(rate[i]));
				saleDetailBean.setAmount((Float.parseFloat(quantity[i]) * Float.parseFloat(rate[i])));
				saleDetailBean.setSalemasterid(salemasterid);
				saleDetailHelper.insertDetails(saleDetailBean);

				RetailActionForm retailBean = retailHelper.getRetailDetailsByRetailerAndItem(userid,
						Integer.parseInt(itemid[i]));
				retailBean.setSalequantity((retailBean.getSalequantity() + Float.parseFloat(quantity[i])));
				retailHelper.updateRetailDetails(retailBean);
			}
		}
		
		if(saleDetailBean.isUpdate()){
			int saleMasterId = saleDetailBean.getSaleMasterIdForUpdate();
			SaleMasterActionForm saleMasterBeanForUpdate = saleMasterHelper.getDetailsBySaleMasterId(saleMasterId);
			saleMasterBeanForUpdate.setOrderquantity(totalquantity);
			saleMasterBeanForUpdate.setTotal(totalamount);
			saleMasterBeanForUpdate.setConsumername(saleDetailBean.getConsumername());
			saleMasterBeanForUpdate.setConsumeraddress(saleDetailBean.getConsumeraddress());
			saleMasterHelper.updateDetails(saleMasterBeanForUpdate);
			
			ArrayList<SaleDetailActionForm> saleDetailList = saleDetailHelper.getDetailsBySaleMasterId(saleMasterId);
			for(int i=0 ; i<itemid.length; i++){
				int itemidu = Integer.parseInt(itemid[i]);
				int saleDetailUdU = Integer.parseInt(saleDetailIdU[i]);
				if(i<saleDetailList.size()){
				SaleDetailActionForm saleDetailBeanForUpdate  = saleDetailHelper.getDetailsByDetailId(saleDetailUdU);
				saleDetailBeanForUpdate.setItemid(Integer.parseInt(itemid[i]));
				saleDetailBeanForUpdate.setQuantity(Float.parseFloat(quantity[i]));
				saleDetailBeanForUpdate.setAmount((Float.parseFloat(quantity[i]) * Float.parseFloat(rate[i])));
				saleDetailHelper.updateDetails(saleDetailBeanForUpdate);
				}
			}
		}
		
		
		
		//
		//
		//
		//
		//code that will generate the retail invoice
		
		PdfPTable table = null;
		
			try{
			table=new PdfPTable(5);
			table.setWidthPercentage(100);
			table.setSpacingBefore(10f);
			table.setSpacingAfter(10f);
			
			String partialpath=request.getServletContext().getRealPath("");			
			String fullpath=partialpath+"assets\\global\\resources\\EncodeSans-Bold.ttf";
			
			BaseFont baseFont = BaseFont.createFont(fullpath,BaseFont.CP1257, BaseFont.EMBEDDED);
		
			Font font1=new Font(Font.FontFamily.TIMES_ROMAN,10,Font.BOLD);
			Font font2=new Font(Font.FontFamily.TIMES_ROMAN,10,Font.NORMAL);
			Font font3 = new Font(Font.FontFamily.TIMES_ROMAN,16,Font.BOLD);
			Font font4 = new Font(baseFont,14);
			
			
			
			float borderwidth = 1f;
			
			String consumeradd = saleDetailBean.getConsumeraddress();
			String cosumername = saleDetailBean.getConsumername();
			
			Paragraph paraForConsumerAddress = new Paragraph();
			paraForConsumerAddress.add(new Paragraph("To,", font1));
			paraForConsumerAddress.add(Chunk.NEWLINE);
			paraForConsumerAddress.add(new Paragraph(cosumername, font1));
			paraForConsumerAddress.add(Chunk.NEWLINE);
			paraForConsumerAddress.add(Chunk.NEWLINE);
			paraForConsumerAddress.add(new Paragraph("Address", font1));
			paraForConsumerAddress.add(Chunk.NEWLINE);
			paraForConsumerAddress.add(new Paragraph(consumeradd, font2));
			paraForConsumerAddress.add(Chunk.NEWLINE);
											
			PdfPCell cell = new PdfPCell(paraForConsumerAddress);
			cell.setColspan(3);
			cell.setBorderWidth(borderwidth);
			table.addCell(cell);
			
			SimpleDateFormat formator1 = new SimpleDateFormat(Constants.DATE_FORMAT_DATE);
			String tdate = formator1.format(new Date());
			
			Paragraph paraForIvoiceDetail = new Paragraph();
			paraForIvoiceDetail.add(new Paragraph("Retailer INVOICE", font1));
			paraForIvoiceDetail.add(Chunk.NEWLINE);
			paraForIvoiceDetail.add(Chunk.NEWLINE);
			paraForIvoiceDetail.add(new Paragraph("Invoice No: ", font1));
			paraForIvoiceDetail.add(Chunk.NEWLINE);
			paraForIvoiceDetail.add(new Paragraph("Invoice Date: "+tdate, font1));
			paraForIvoiceDetail.add(Chunk.NEWLINE);
						
			cell = new PdfPCell(paraForIvoiceDetail);
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
			float totalamountp = 0f;
			float totalQuantity = 0f;
			int serialcounter = 0; 
			for(int i=0 ; i<itemid.length; i++){
				
				float quantityp = Float.parseFloat(quantity[i]);
				float ratep = Float.parseFloat(rate[i]);				
											
					totalQuantity+= Float.parseFloat(quantity[i]);
					serialcounter+=1;
										
					String product = itemHelper.getItemById(Integer.parseInt(itemid[i])).getName();					
					float amount = quantityp * ratep;
					totalamountp+=amount;
					
					
					cell = new PdfPCell(new Paragraph(Integer.toString(serialcounter), font2));
					cell.setBorderWidth(borderwidth);
					table.addCell(cell);
					
					cell = new PdfPCell(new Paragraph(product, font2));
					cell.setBorderWidth(borderwidth);
					table.addCell(cell);
					
					cell = new PdfPCell(new Paragraph(quantity[i], font2));
					cell.setBorderWidth(borderwidth);
					table.addCell(cell);
					
					cell = new PdfPCell(new Paragraph(rate[i], font2));
					cell.setBorderWidth(borderwidth);
					table.addCell(cell);
					
					cell = new PdfPCell(new Paragraph(Float.toString(amount), font2));
					cell.setBorderWidth(borderwidth);
					table.addCell(cell);
				
			}
			
			
			
			
			float saletaxamount = 0f;
			
			
			float gtotal = saletaxamount + totalamountp;
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
			
			cell = new PdfPCell(new Paragraph(Float.toString(totalamountp), font2));
			cell.setBorderWidth(borderwidth);
			table.addCell(cell);
			
			
			
			cell = new PdfPCell(new Paragraph("Sale tax (0.0%)", font1));
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
			paraTC.add(new Paragraph("Subject to VADODARA Juridiction ", font1));
			paraTC.add(Chunk.NEWLINE);
			paraTC.add(Chunk.NEWLINE);
			
			cell = new PdfPCell(paraTC);
			cell.setColspan(3);
			cell.setBorderWidth(borderwidth);
			table.addCell(cell);
			
			
			String authorityperson = userHelper.getSingleUserByUserId(userid).getFirstName()+" "+userHelper.getSingleUserByUserId(userid).getFirstName();
			Paragraph paraSign = new Paragraph();
			paraSign.add(new Paragraph("From,", font1));
			paraSign.add(Chunk.NEWLINE);
			paraSign.add(new Paragraph(authorityperson, font1));
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
						
		
		
		//End of code that will generate the retail invoice
		//
		//
		//
		//
		
		return null;
	}

}
