package com.bms.utility.printutils;

import com.bms.struts.SCMActionForm;

public class PrintUtilityBean extends SCMActionForm{
	private PrintUtilityBean (){
		super();
		printerName="LaserPrinter";
		PrinterType="PRINTER_THERMAL_EPL";
		
	}
	
	private static PrintUtilityBean printUtilityBean =null;
	
	private String printerName;
	private String PrinterType;
	private String statusPrinter;
	
	
	
	
	
	public static PrintUtilityBean getPrintUtilityBean() {
		return printUtilityBean;
	}
	public static void setPrintUtilityBean(PrintUtilityBean printUtilityBean) {
		PrintUtilityBean.printUtilityBean = printUtilityBean;
	}
	public String getStatusPrinter() {
		return statusPrinter;
	}
	public void setStatusPrinter(String statusPrinter) {
		this.statusPrinter = statusPrinter;
	}
	public String getPrinterName() {
		return printerName;
	}
	public void setPrinterName(String printerName) {
		this.printerName = printerName;
	}
	public String getPrinterType() {
		return PrinterType;
	}
	public void setPrinterType(String printerType) {
		PrinterType = printerType;
	}
	private int printProfile;
	private String printingModule;

	
	public int getPrintProfile() {
		return printProfile;
	}
	public void setPrintProfile(int printProfile) {
		this.printProfile = printProfile;
	}
	public String getPrintingModule() {
		return printingModule;
	}
	public void setPrintingModule(String printingModule) {
		this.printingModule = printingModule;
	}
	
	
	
	public static PrintUtilityBean getPrintUtilityBeanInstance()
	{
	   
		if (printUtilityBean==null){
		
           printUtilityBean=new PrintUtilityBean();		
		}
		
		return printUtilityBean;
	
	  }
	
}
