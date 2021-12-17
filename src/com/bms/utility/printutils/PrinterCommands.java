package com.bms.utility.printutils;
import com.bms.constants.*;
import java.util.HashMap;

import javax.servlet.ServletContext;

import org.codehaus.jettison.json.JSONObject;

public class PrinterCommands {
	private String printerType = null;
	//private ServletContext mContext = null;
		// com.java.restoserver.printer.commands.ESCPOS.ESC;

		//byte ESC = 27;
		final static  char ESC = Constants.ESC;

		/*
		 * PRINTER_THERMAL_ZPL = "Thermal Printer Epson"; public static final String
		 * PRINTER_THERMAL_EPL = "Thermal Printer TVS"; public static final String
		 * PRINTER_DOTMATRIX = "Dot Matrix";
		 */
		public PrinterCommands(String printerType) {

			this.printerType = printerType;
			//this.mContext = mContext;

		}
		
		
		public PrinterCommands() {

			
		}
		
		
		public String getHtmlTag(char flag)
		{
			if(flag=='s')//flag means start tag or end tag
				return"<html>";
			else
				return "</html>";
		}
		
		public String getTableTag(char flag)
		{
			if(flag=='s')//flag means start tag or end tag
				return"<table width='100%'>";
			else
				return "</table>";
		}
		
		public String getStyleSheet(String styleSheet)
		{
			return "<link href='../plugins/misc/fullcalendar/printing.css' rel='stylesheet' media='print'  type='text/css'  />" ;
					
			
		}
		
		
		
		public String getTableRowTag(char flag)
		{
			if(flag=='s')//flag means start tag or end tag
				return"<tr>";
			else
				return "</tr>";
		}
		
		
		public String getTableColumnTag(char flag ,int colspan)
		{
			if(flag=='s')//flag means start tag or end tag
				return"<td colspan="+colspan+" style='border: 1pt solid black;'>";
			else
				return "</td>";
			
		}
		
		public String getTableColumnTag(char flag)
		{
			if(flag=='s')//flag means start tag or end tag
				return"<td style='border: 1pt solid black;'>";
			else
				return "</td>";
		}
		
		
		public String getBodyTag(char flag)
		{
			if(flag=='s')//flag means start tag or end tag
				return"<body>";
			else
				return "</body>";
		}
		
		
		
	    
		    
		  
		  
		

		public String doCenterAlign() {
			if (Constants.PRINTER_THERMAL_ZPL.equalsIgnoreCase(printerType)) {
				return  ESC+"|cA";
			} else if (Constants.PRINTER_THERMAL_EPL.equalsIgnoreCase(printerType)) {
				return ESC+"|cA";

			} else if (Constants.PRINTER_DOTMATRIX.equalsIgnoreCase(printerType)) {
				/*return ESC+"H"+ESC+"T";*/
				return new String();
			}
			else if(Constants.PRINTER_DEFAULT.equalsIgnoreCase(printerType)){
				return " ";
			}

			else {
				return ESC+"|cA";
			}
		}

		public String doFontBig3() {
			if (Constants.PRINTER_THERMAL_ZPL.equalsIgnoreCase(printerType)) {
				return  ESC+"|2C";
			} else if (Constants.PRINTER_THERMAL_EPL.equalsIgnoreCase(printerType)) {
				return  ESC+"|2C";
				}
			else if(Constants.PRINTER_DEFAULT.equalsIgnoreCase(printerType)){
					return " ";
				
			} else if (Constants.PRINTER_DOTMATRIX.equalsIgnoreCase(printerType)) {
				final byte DOUBLEHEIGHT = 1;
				return  ESC+"E"+ DOUBLEHEIGHT;
				//return  ESC+"|2C";
			}

			else {
				return ESC+"|2C";
			}
		}

		public String doFontBig2() {
			if (Constants.PRINTER_THERMAL_ZPL.equalsIgnoreCase(printerType)) {
				return ESC+"|bD";
			} else if (Constants.PRINTER_THERMAL_EPL.equalsIgnoreCase(printerType)) {
				return ESC+"|bD";

			} else if (Constants.PRINTER_DOTMATRIX.equalsIgnoreCase(printerType)) {
				return ESC+"F";
			}
			else if(Constants.PRINTER_DEFAULT.equalsIgnoreCase(printerType)){
				return " ";
			}
			else {
				return ESC+"|bD";
			}

		}

		public String doFontBig4() {
			/*if (Constants.PRINTER_THERMAL_ZPL.equalsIgnoreCase(printerType)) {
				return "!" + (byte)16;
				
			}*/
			
//			final static  char ESC = com.java.restoserver.printer.commands.ESCPOS.ESC;
			final byte DOUBLEHEIGHT = 1;
			//		return "ES";
//			return "!" + Byte.parseByte("16");
			return  ESC+"E" + DOUBLEHEIGHT;
		}

		public String getNewLine() {
			if (Constants.PRINTER_THERMAL_ZPL.equalsIgnoreCase(printerType)) {
				return "\n";
			} else if (Constants.PRINTER_THERMAL_EPL.equalsIgnoreCase(printerType)) {
				return "\n";

			} else if (Constants.PRINTER_DOTMATRIX.equalsIgnoreCase(printerType)) {
				return "\n";
			}
			 else if (Constants.PRINTER_DEFAULT.equalsIgnoreCase(printerType)) {
					return "<br>";
				}
			else {
				return "\n";
			}
		}

		public String getSpace() {
			if (Constants.PRINTER_THERMAL_ZPL.equalsIgnoreCase(printerType)) {
				return " ";
			} else if (Constants.PRINTER_THERMAL_EPL.equalsIgnoreCase(printerType)) {
				return "";

			} else if (Constants.PRINTER_DOTMATRIX.equalsIgnoreCase(printerType)) {
				return "";
			}

			else {
				return "";
			}
		}

		public String getTwoSpaces() {
			if (Constants.PRINTER_THERMAL_ZPL.equalsIgnoreCase(printerType)) {
				return "  ";
			} else if (Constants.PRINTER_THERMAL_EPL.equalsIgnoreCase(printerType)) {
				return "";

			} else if (Constants.PRINTER_DOTMATRIX.equalsIgnoreCase(printerType)) {
				return "";
			}

			else {
				return "";
			}
		}
		public String getThreeSpaces() {
			if (Constants.PRINTER_THERMAL_ZPL.equalsIgnoreCase(printerType)) {
				return "   ";
			} else if (Constants.PRINTER_THERMAL_EPL.equalsIgnoreCase(printerType)) {
				return "";

			} else if (Constants.PRINTER_DOTMATRIX.equalsIgnoreCase(printerType)) {
				return "";
			}

			else {
				return "";
			}
		}
		

		public int getOneCharLength() {
			if (Constants.PRINTER_THERMAL_ZPL.equalsIgnoreCase(printerType)) {
				return 1;
			} else if (Constants.PRINTER_THERMAL_EPL.equalsIgnoreCase(printerType)) {
				return 0;

			} else if (Constants.PRINTER_DOTMATRIX.equalsIgnoreCase(printerType)) {
				return 0;
			}

			else {
				return 0;
			}
		}

		public int getTwoCharLength() {
			if (Constants.PRINTER_THERMAL_ZPL.equalsIgnoreCase(printerType)) {
				return 2;
			} else if (Constants.PRINTER_THERMAL_EPL.equalsIgnoreCase(printerType)) {
				return 0;

			} else if (Constants.PRINTER_DOTMATRIX.equalsIgnoreCase(printerType)) {
				return 0;
			}

			else {
				return 0;
			}
		}
		public int getThreeCharLength() {
			if (Constants.PRINTER_THERMAL_ZPL.equalsIgnoreCase(printerType)) {
				return 3;
			} else if (Constants.PRINTER_THERMAL_EPL.equalsIgnoreCase(printerType)) {
				return 0;

			} else if (Constants.PRINTER_DOTMATRIX.equalsIgnoreCase(printerType)) {
				return 0;
			}

			else {
				return 0;
			}
		}

		public int getFirstColumnSpacing()
		{
			if (Constants.PRINTER_THERMAL_ZPL.equalsIgnoreCase(printerType)) {
				return 32;
			} else if (Constants.PRINTER_THERMAL_EPL.equalsIgnoreCase(printerType)) {
				return 25;

			} else if (Constants.PRINTER_DOTMATRIX.equalsIgnoreCase(printerType)) {
				return 25;
			}

			else {
				return 32;
			}
			
			
		}
		public int getSecondColumnSpacing()
		{
			if (Constants.PRINTER_THERMAL_ZPL.equalsIgnoreCase(printerType)) {
				return 8;
			} else if (Constants.PRINTER_THERMAL_EPL.equalsIgnoreCase(printerType)) {
				return 7;

			} else if (Constants.PRINTER_DOTMATRIX.equalsIgnoreCase(printerType)) {
				return 7;
			}

			else {
				return 8;
			}
			
			
		}
		
		
		public int getDishLengthForKot()
		{
			
			if (Constants.PRINTER_THERMAL_ZPL.equalsIgnoreCase(printerType)) {
				return 28;
			} else if (Constants.PRINTER_THERMAL_EPL.equalsIgnoreCase(printerType)) {
				return 28;

			} else if (Constants.PRINTER_DOTMATRIX.equalsIgnoreCase(printerType)) {
				return 28;
			}

			else {
				return 28;
			}
			
		}
		public int getDishLengthForBill()
		{
			
			if (Constants.PRINTER_THERMAL_ZPL.equalsIgnoreCase(printerType)) {
				return 14;
			} else if (Constants.PRINTER_THERMAL_EPL.equalsIgnoreCase(printerType)) {
				return 14;

			} else if (Constants.PRINTER_DOTMATRIX.equalsIgnoreCase(printerType)) {
				return 14;
			}

			else {
				return 14;
			}
			
		}
		
		public String getDashedLines() {
			if (Constants.PRINTER_THERMAL_ZPL.equalsIgnoreCase(printerType)) {
				return "----------";
			} else if (Constants.PRINTER_THERMAL_EPL.equalsIgnoreCase(printerType)) {
				return "";

			} else if (Constants.PRINTER_DOTMATRIX.equalsIgnoreCase(printerType)) {
				return "";
			}

			else {
				return "";
			}
		}
}
