	package com.bms.constants;

public class Constants {
	
		public static final String DBNAME = "orderingdb";
		
		
		//constants for order management setting configuration property name and type
		
		public static final String SETTING_CONFIG_ITEMUNITCOST_EDITABILITY = "unitCostEditable";
		public static final String SETTING_CONFIG_ITEMUNITCOST_EDITABILITY_VALUE_ON = "1";
		public static final String SETTING_CONFIG_ITEMUNITCOST_EDITABILITY_VALUE_OFF = "0";
		
		
		// constants for admin role
		
		public static final int ROLE_ADMIN = 2;
		
		//Constants for mapping of active and inactive
		
		public static final int ACTIVE = 1;
		public static final int NOT_ACTIVE = 0;
		
		//constant for button type
		public static final String BTN_SUBMIT = "SUBMIT";
		public static final String BTN_UPDATE = "UPDATE";
		
		//constant string for retailer mapping
		public static final String ROLE_NAME_FOR_RETAILER = "RETAILER";		
		
		//constants for user roles 
		   public static final byte ESC = 27;
		    public static final byte FS = 28;
		    public static final byte GS = 29;
		    public static final byte DLE = 16;
		    public static final byte EOT = 4;
		    public static final byte ENQ = 5;
		    public static final byte SP = 32;
		    public static final byte HT = 9;
		    public static final byte LF = 10;
		    public static final byte CR = 13;
		    public static final byte FF = 12;
		
		//Constants For Printer Type
		public static final String PRINTER_THERMAL_ZPL  = "PRINTER_THERMAL_ZPL";
		public static final String PRINTER_THERMAL_EPL  = "PRINTER_THERMAL_EPL";
		public static final String PRINTER_DOTMATRIX    = "PRINTER_DOTMATRIX";
		public static final String PRINTER_LASER    = "1";
		public static final String PRINTER_DEFAULT = "DEFAULT";
		
		//Constants for Requisition Order Print or Purchase Order Print
		public static final String PRINT_STATUS_REQUISITION = "requestionPrint";
		public static final String PRINT_STATUS_PURCHASE_ORDER = "purchaseOrderPrint";
		
		//constants for user roles 
		public static final int USER_ROLE_ADMIN = 1;
		
		//constants for user status
		public static final int USER_STATUS_IN_ACTIVE = 0;
		public static final int USER_STATUS_ACTIVE = 1;
		public static final int USER_STATUS_DISABLED = 2;
		public static final int USER_STATUS_LOCKED = 3;
		public static final int USERROLL_MASTERID=2;
		
		//constants for applicant status
		public static final String APPLICANT_STATUS="applicantStatus";
		public static final int APPLICANT_STATUS_INQUIRY = 1;
		public static final int APPLICANT_STATUS_CONFORMED = 2;
		public static final int APPLICANT_STATUS_REJECTED = 3;
		
		//Date format
		public static final String DATE_FORMAT="yyyy-MM-dd HH:mm:ss";
		public static final String DATE_FORMAT_DATE = "yyyy-MM-dd";
		public static final String DATE_FORMAT_DATETIME = "yyyy-MM-dd HH:mm:ss";
		public static final String DATE_DD_MM_YYYY = "dd-MM-yyyy";
		
		//constants for struts mapping
		public static final String STRUTS_MAPPING_SUCCESS = "success";
		public static final String STRUTS_MAPPING_SUCCESS2 = "success2";
		public static final String STRUTS_MAPPING_ERROR = "error";
		public static String STRUTS_APPLICATION_CONTEXT = "STRUTS_APPLICATION_CONTEXT";
		
		public static final String STRUTS_MAPPING_ADMIN = "admin";
		public static final String STRUTS_MAPPING_STAFF = "staff";
		public static final String STRUTS_MAPPING_ADD_SUCCESS = "addsuccess";
		public static final String STRUTS_MAPPING_ADD_ERROR = "adderror";
		public static final String STRUTS_MAPPING_EDIT_SUCCESS = "editsuccess";
		public static final String STRUTS_MAPPING_EDIT_ERROR = "editerror";
		public static final String STRUTS_MAPPING_SMS_IND_SUCEESSS = "indsuccess";
		public static final String STRUTS_MAPPING_SMS_GROUP_SUCEESSS = "groupsuccess";
		public static final String STRUTS_MAPPING_SMS_IND_ERROR = "inderror";
		public static final String STRUTS_MAPPING_SMS_GROUP_ERROR= "grouperror";
		
		//constants for student
		public static final String MAPPING_TYPE="mapping";
	    public static final int SAVE_WITHOUT_PREVIOUS_DETAIL=2;
	    public static final int SAVE_WITH_PREVIOUS_DETAIL=1;
				
		//constants for address type
		public static final int ADDRESS_TYPE_LOCAL=1;
		public static final int ADDRESS_TYPE_PERMENENT=2;
		
		//constants for action type
		public static final String ACTION_TYPE="action";
		public static final int ACTION_TYPE_INSERT=1;
		public static final int ACTION_TYPE_UPDATE=2;
		public static final int ACTION_TYPE_PRINT=3;
		public static final int ACTION_TYPE_VALIDATE=4;
		public static final int ACTION_TYPE_DELETE=5;
		
			
		//audit keys
		public static final String AUDIT_PO="PO";
		public static final String AUDIT_PO_CREATION="PO_CREATE";
		public static final String AUDIT_PO_DELETION="PO_DELETE";
		public static final String AUDIT_PO_EDIT="PO_EDIT";
		public static final String AUDIT_PO_EDIT_CLOSED="PO_EDIT_CLOSED";

	
		
		//constants for session
		public static final String USER_ID="USER_ID";
		public static final String COMPANY_ID="COMPANY_ID";
		public static final String COMPANY_LOGO="COMPANY_LOGO";
		public static final String USER_ROLE="USER_ROLE";
		public static final String USER_SITE_MAPPING="USER_SITE_MAPPING";
		public static final String IS_LOGGED_IN="IS_LOGGED_IN";
		public static final String USER_BEAN="USER_BEAN";
		public static final String USER_SITE_ID="USER_SITE";
		public static final String SITE_LIST="SITE_LIST";
		public static final String CREATE_GR_PO_STATUS="CREATE_GR_PO_STATUS";
		
		//constants for Item Status
		
		public static final int ITEM_STATUS_ACTIVE=1;    //Show All Active Item
		public static final int ITEM_STATUS_IN_ACTIVE=0; //Show All InActive Item
		
		public static int getItemStatusActive() {
			return ITEM_STATUS_ACTIVE;
		}
		public static int getItemStatusInActive() {
			return ITEM_STATUS_IN_ACTIVE;
		}
		
		
		//constants for stock status
		
		public static final int ST_STATUS_DEFAULT=0;
		public static final int ST_STATUS_GOOD_STOCK=1;
		public static final int ST_STATUS_BLOCKED=2;
		public static final int ST_STATUS_INTRANSITE=3;
		public static final int ST_STATUS_WASTED=4;
		public static final int ST_STATUS_EXPIRED=5;
		public static final int ST_STATUS_DAMAGED=6;
		public static final int ST_STATUS_UNACCOUNTED=7;
		public static final int ST_STATUS_MANUFACTURE=8;
		public static final int ST_STATUS_SALE=9;
		public static final int ST_STATUS_PLANNING_STOCK=10;
		public static final int ST_STATUS_MATERIAL_RELEASE=11;
		public static final int BMS_ORDER_MODULE=1;
		
		
		public int getST_STATUS_DEFAULT() {
			return (ST_STATUS_DEFAULT);
		}
		public int getST_STATUS_GOOD_STOCK() {
			return (ST_STATUS_GOOD_STOCK);
		}
		public int getST_STATUS_BLOCKED() {
			return (ST_STATUS_BLOCKED);
		}
		public int getST_STATUS_INTRANSITE() {
			return (ST_STATUS_INTRANSITE);
		}
		public int getST_STATUS_WASTED() {
			return (ST_STATUS_WASTED);
		}
		public int getST_STATUS_EXPIRED() {
			return (ST_STATUS_EXPIRED);
		}
		public int getST_STATUS_DAMAGED() {
			return (ST_STATUS_DAMAGED);
		}
		public int getST_STATUS_UNACCOUNTED() {
			return (ST_STATUS_UNACCOUNTED);
		}
		public int getST_STATUS_MANUFACTURE() {
			return (ST_STATUS_MANUFACTURE);
		}
		
		//constants for BinStockQuantity
		public static final int ST_QUANTITY_MORE=1;
		public static final int ST_QUANTITY_LESS=2;
		public static final int ST_QUANTITY_ALL=3;
		
		public int getST_QUANTITY_MORE() {
			return (ST_QUANTITY_MORE);
		}
		public int getST_QUANTITY_LESS() {
			return (ST_QUANTITY_LESS);
		}
		public int getST_QUANTITY_ALL() {
			return (ST_QUANTITY_ALL);
		}
		
		
	

	    //Constants for Stock Take Status
		public static final int STOCK_TAKE_DAILY=1;
		public static final int STOCK_TAKE_WEEKLY=2;
		public static final int STOCK_TAKE_MONTHLY=3;
		public static final int STOCK_TAKE_DISABLED=4;
	
		
		//constants for stock summary actionId
		public static final int ACTION_GR=1;
		public static final int ACTION_TO=2;
		public static final int ACTION_STOCK_ADJUSTMENT=3;
		public static final int ACTION_BATCH_JOB=4;
		public static final int ACTION_MANUFACTURE=5;
		public static final int ACTION_PO=6;
		public static final int ACTION_PLANNING_DEPT=7;
		public static final int ACTION_STORE_DEPT=8;
		public static final int ACTION_SALE=9;
		
		//constants for stock operation
		public static final int OPERATION_ADD=1;
		public static final int OPERATION_MINUS=2;
		
		
		//constants for site type
		public static final int ITEM_SUPPLIER_MAPPING_SITE_TYPE_SITE= 1;
		public static final int ITEM_SUPPLIER_MAPPING_SITE_TYPE_SITEAREA= 2;
		public static final int ITEM_SUPPLIER_MAPPING_SITE_TYPE_GENERIC_SITE= 3;

		//constants for type of supplier
		public static final int ITEM_SUPPLIER_MAPPING_SUPPLIER_INTERNAL= 1;
		
		
	//added for user roles
		//user info session strings.
		public static String  SESSION_INFO_USER_ROLE = "SESSION_INFO_USER_ROLE";
		public static String  SESSION_INFO_USERNAME= "SESSION_INFO_USERNAME";
		public static String  SESSION_INFO_USERLASTNAME= "SESSION_INFO_USERLASTNAME";
		public static String  SESSION_INFO_USER_ID = "userId";
		public static String  SESSION_INFO_USER_COMPANY_ID = "SESSION_INFO_COMPANY_ID";
		//access control mapping states
		public static int  ACCESS_CONTROL_MAPPING_ACTIVE= 1;
		public static int  ACCESS_CONTROL_MAPPING_INACTIVE= 2;
		public static int  ACCESS_CONTROL_AUTH_MATRIX_OF= 1;   //For SCM Project set 1
		//order synchronization timing
		//PROPERTIES FOR batch job SCM configuration
				
		public static String PROPERTY_TYPE_LAST_ORDER_SINK_TIME = "LastOrderSinkTime";
		public static String  ORDER_SINK_TIME_10_MIN="0 */10 * * * ?";
		public static String lAST_SYNC_TIME_DEFAULT="1970-1-1 00:00:00";
		
		public static String PROPERTY_TYPE_BATCH_JOB_START_STOP = "BatchJobStartStop";
		public static String PROPERTY_TYPE_BATCH_JOB_START_STOP_VALUE = "0";
		
		//Property For Default Site 
		public static String SCM_CONFIGURATION_DEFAULT_SITE="Default Site";
		
		//Property For Receive Goods Site
		public static String SCM_CONFIGURATION_RECIVE_GOODS_FROM_SITE="ReceiveGoodsPOMapping";

		//Property of Purchase Order View According to Mfg Company 
		public static String SCM_CONFIGURATION_PO_VIEW_ACCORDING_TO_MFG="POViewFromMfgCompny";
		
		//Property For Supplier Site Mapping is Enable or Not.. 
		public static String SCM_CONFIGURATION_SUPPLIER_SITE_MAPPING="SUPPLIER SITE MAPPING";	
		
		//Property For When GR Create that time Option for User Close PO or Not.
		public static String SCM_CONFIGURATION_CREATE_GR_PO_STATUS="Create GR and PO Status";
		public static String SCM_CONFIGURATION_CREATE_GR_CLOSE_PO="Create GR and Close PO";
		public static String SCM_CONFIGURATION_CREATE_GR_OPEN_PO="Create GR and Open PO";
		
		public static String COMPANY_NAME = "NEETAI TECH";

		//User Role For Admin
		public static int SCM_USER_ROLE_ADMIN=1;
		
		//Buyer Type.
		public static int  BUYER_CUSTOMER = 1;
		public static int  BUYER_VEPARI= 2;
		
		
		//Submit Button,Create&Submit Button Status.
		public static int  BMS_SUBMIT_BUTTON = 1;
		public static int  BMS_CREATE_SUBMIT_BUTTON = 0;
		
		//constants for po status
		
		public static final int PO_STATUS_SAVE=1;//Work as Draft not submit on other site
		public static final int PO_STATUS_SUBMIT=2;//submit on other site
		public static final int PO_STATUS_SERVICED=3;//generated TO or GR on that PO
		public static final int PO_STATUS_CANCEL=4;
		public static final int PO_STATUS_CLOSED=5;//if All item serverd then po close bt the time of gr
		public static final int PO_STATUS_DISABLED=6;
		
		//constants for GR status
		public static final int GR_STATUS_OPEN=1;
		public static final int GR_STATUS_SERVICED=2;
		public static final int GR_STATUS_CLOSED=3;
		public static final int GR_STATUS_DIABLED=4;
		
		//constant for date manipulation 
		public static final int DATE_ADD=1;
		public static final int DATE_SUB=2;
		
		//constant for mail system
		public static String DEFAULT_MAIL="DefaultMail";
		public static String DEFAULT_PASSWORD="DefaultPassword";
		public static String DEFAULT_COMPANY_HOST="DefaultHost";
		public static String DEFAULT_COMPANY_PORT="DefaultCompanyPort";
		public static String DEFAULT_COMPANY_TRUST="DefaultCompanyTrust";
		
		// constants for order status
		
		public static String STATUS_DELIVERED="delivered";
}
