package com.bms.mdm.reports;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporterParameter;
import net.sf.jasperreports.view.JasperViewer;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bms.struts.SCMAction;

public class PDFReportDownloadAction extends SCMAction {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		JasperPrint jasperPrint=null;
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
		
		ReportInputBean reportBean = (ReportInputBean)form;
		
		String dateName = reportBean.getFromDate();
		System.out.println("Mehul "+reportBean.getFromDate());
		System.out.println(reportBean.getToDate());
		ResourceBundle messages = ResourceBundle.getBundle("applicationResource");
		
		String restaurant_name = "DamaDum";
	
		
		String reportType= (String)request.getParameter("reportType");
		
		   String reportFileName="Balance_Stock_Quantity.jasper";
		   String reportPath= getServlet().getServletContext().getRealPath("")+ "\\jasperreport\\"+reportFileName;
		   String targetFileName="Balance_Stock_Quantity_" + dateName +".pdf";
		   Map < String, Object> parameterMap = new HashMap<String, Object>();
		 try {
			 
			   parameterMap = new HashMap<String, Object>();
			   parameterMap.put("fromDate", reportBean.getFromDate());
			   parameterMap.put("toDate", reportBean.getToDate());
			   parameterMap.put("hotelName", restaurant_name);
			   parameterMap.put("itemCategoryId", "12");
			   parameterMap.put("itemId", "4");
			   parameterMap.put("siteId", "1");
			   
			   
	/*	if(Constants.REPORT_SALES_REPORT.equalsIgnoreCase(reportType))
		{
			   reportFileName=Constants.REPORT_SALES_REPORT;
			   reportPath= getServlet().getServletContext().getRealPath("")+ "\\jasperreport\\"+reportFileName;
			   targetFileName="Total_Sales_report_" + dateName +".pdf";
			   parameterMap = new HashMap<String, Object>();
			   
			   parameterMap.put("foodCategory", ServerUtils.getConfigurationByProperty(Constants.CATEGORY_TYPE_FOR_REPORT_FOOD).getValue());
			   parameterMap.put("liquorFoodCategory", ServerUtils.getConfigurationByProperty(Constants.CATEGORY_TYPE_FOR_REPORT_LIQUOR).getValue());
			   parameterMap.put("wineFoodCategory", ServerUtils.getConfigurationByProperty(Constants.CATEGORY_TYPE_FOR_REPORT_WINE).getValue());
			   parameterMap.put("coldDrinkFoodCategory", ServerUtils.getConfigurationByProperty(Constants.CATEGORY_TYPE_FOR_REPORT_COLD_DRINK).getValue());

			   parameterMap.put("fromDate", reportBean.getFromDate());
			   parameterMap.put("toDate", reportBean.getToDate());
			   parameterMap.put("hotelName", restaurant_name);
			
			
		}
		else if(Constants.REPORT_ITEM_WISE.equalsIgnoreCase(reportType))
		{
			
			   reportFileName=Constants.REPORT_ITEM_WISE;
			   reportPath= getServlet().getServletContext().getRealPath("")+ "\\jasperreport\\"+reportFileName;
			   targetFileName="Item_Wise_Report_" + dateName +".pdf";
			   parameterMap = new HashMap<String, Object>();
			   parameterMap.put("fromDate", reportBean.getFromDate());
			   parameterMap.put("toDate", reportBean.getToDate());
			   parameterMap.put("hotelName", restaurant_name);
				
			
		}
		else if(Constants.REPORT_DETAILED_BILL_WISE.equalsIgnoreCase(reportType))
		{
			
			   reportFileName=Constants.REPORT_DETAILED_BILL_WISE;
			   reportPath= getServlet().getServletContext().getRealPath("")+ "\\jasperreport\\"+reportFileName;
			   targetFileName="Detail_Bill_Wise_Report_" + dateName +".pdf";
//			   targetFileName=targetFileName.replace(".jrxml", ".pdf");
			   parameterMap = new HashMap<String, Object>();
			   parameterMap.put("foodCategory", ServerUtils.getConfigurationByProperty(Constants.CATEGORY_TYPE_FOR_REPORT_FOOD).getValue());

			   parameterMap.put("fromDate", reportBean.getFromDate());
			   parameterMap.put("toDate", reportBean.getToDate());
			   parameterMap.put("hotelName", restaurant_name);
				
			
		}

		*/
		
		   
		
		   jasperPrint = JasperFillManager.fillReport(reportPath,parameterMap,com.bms.db.DBConnectionPool.getInstance().getConnection());
		   ServletOutputStream outputstream = response.getOutputStream();
		   final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		    JasperExportManager.exportReportToPdfStream(jasperPrint, byteArrayOutputStream);
		             response.setContentType("application/pdf");
		             outputstream.write(byteArrayOutputStream.toByteArray());
		             response.setHeader("Cache-Control", "max-age=0");
		             response.setHeader("Content-Disposition", "attachment; filename=" + targetFileName);
		             // clear the output stream.
		             outputstream.flush();
		             outputstream.close();
	
		  } catch (final Exception e) {
		   e.printStackTrace();
		  }
		
		
		// TODO Auto-generated method stub
		return mapping.findForward("success");
	}
	
	private void generateHtmlOutput(
			JasperPrint jasperPrint,
			HttpServletRequest req,
			HttpServletResponse resp)
			throws IOException, JRException {

		
		
		Map imagesMap = new HashMap();
		req.getSession().setAttribute("IMAGES_MAP", imagesMap);
		JRHtmlExporter exporter = new JRHtmlExporter();

		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		exporter.setParameter(
			JRExporterParameter.OUTPUT_WRITER,
			resp.getWriter());

		exporter.setParameter(JRHtmlExporterParameter.IMAGES_MAP, imagesMap);
		exporter.setParameter(
			JRHtmlExporterParameter.IMAGES_URI,
			"image?image=");
			exporter.exportReport();
		}

}

/*
//String reportFileName="bill_report.jrxml";
String reportFileName="bill_report.jasper";
String reportPath= getServlet().getServletContext().getRealPath("")+ "\\jasperreport\\"+reportFileName;
String targetFileName=reportFileName.replace(".jrxml", ".pdf");
//final JasperReport jasperReport = JasperCompileManager.compileReport(reportPath);   
Map < String, Object> parameterMap = new HashMap<String, Object>();
parameterMap.put("hello", "hello");
jasperPrint = JasperFillManager.fillReport(reportPath,parameterMap,DBConnectionPool.getInstance().getConnection());
//ServletOutputStream outputstream = response.getOutputStream();
//final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//Jasper

JasperViewer.viewReport(jasperPrint);
//generateHtmlOutput(jasperPrint, request, response);
		    JasperExportManager.exportReportToPdfStream(jasperPrint, byteArrayOutputStream);
          response.setContentType("application/pdf");
          outputstream.write(byteArrayOutputStream.toByteArray());
          response.setHeader("Cache-Control", "max-age=0");
          response.setHeader("Content-Disposition", "attachment; filename=" + targetFileName);
          // clear the output stream.
          outputstream.flush();
          outputstream.close();
		    
*/