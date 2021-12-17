package com.bms.mail;


import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeBodyPart;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.internet.MimeMultipart;

import com.bms.config.ConfigActionForm;
import com.bms.config.ConfigDBHelper;
import com.bms.constants.Constants;
import com.bms.mdm.item.ItemActionForm;
import com.bms.mdm.item.ItemDBHelper;

import com.bms.mdm.orderstage.OrderStageActionForm;
import com.bms.mdm.orderstage.OrderStageDBHelper;
import com.bms.neetai.users.UserActionForm;
import com.bms.neetai.users.UserDBHelper;
import com.bms.order.orderdetail.OrderDetailActionForm;
import com.bms.order.orderdetail.OrderDetailDBHelper;
import com.bms.order.ordermaster.OrderMasterActionForm;
import com.bms.order.ordermaster.OrderMasterDBHelper;

public class MailSMS{
			
	/////Configuration////////// 
	ConfigDBHelper configDBHelper = new ConfigDBHelper();
	ArrayList<ConfigActionForm> configListByCompanyId=new ArrayList<ConfigActionForm>();
	
	//////Order Master /////
	OrderMasterActionForm orderMasterActionForm = new OrderMasterActionForm();
	OrderMasterDBHelper orderMasterDBHelper = new OrderMasterDBHelper();
		
	//////Order stage history /////,
	OrderStageActionForm orderStageActionForm = new OrderStageActionForm();
	OrderStageDBHelper orderStageDBHelper = new OrderStageDBHelper();
	
	//////order Detail/////
	ArrayList<OrderDetailActionForm> orderDetailActionForm = new ArrayList<OrderDetailActionForm>();
	OrderDetailDBHelper orderDetailDBHelper = new OrderDetailDBHelper();
	
	// user mail detection
	UserActionForm userActionForm=new UserActionForm();
	UserDBHelper userDBHelper=new UserDBHelper();
	String userMailId;
	
	//Item Detail
	ItemActionForm itemActionForm=new ItemActionForm();
	ItemDBHelper itemDBHelper=new ItemDBHelper();
	
	
		
	public void sendMail(int eorderMasterIdForMail/* , int orderStageId*/)
	{
		try 
		{
			////////Mail User Name Password/////////
			
			//final String configHostName = configDBHelper.getMailId("DefaultHostName");
			//final String configPort = configDBHelper.getMailId("DefaultPort");
			
			
			
			orderDetailActionForm=orderDetailDBHelper.getOrderDetailsListByOrderMasterId(eorderMasterIdForMail);
			orderMasterActionForm=orderMasterDBHelper.getOrderByMasterId(eorderMasterIdForMail);
			
			userActionForm=userDBHelper.getSingleUserByUserId(orderMasterActionForm.getUserMasterId());
			userMailId=userActionForm.getEmail();
			
			int companyId=orderMasterActionForm.getCompanyMasterId();    
			
			String hostMail=null,hostPassword=null,companyHost=null,companyPort=null,companyTrust=null;
			configListByCompanyId=configDBHelper.getAllRecordsByCompanyId(companyId);
			
			for(int i=0;i<configListByCompanyId.size();i++)
			{
				if(configListByCompanyId.get(i).getPropertyType().equals(Constants.DEFAULT_MAIL))
				{
					hostMail=configListByCompanyId.get(i).getValue();
				}
				if(configListByCompanyId.get(i).getPropertyType().equals(Constants.DEFAULT_PASSWORD))
				{
					hostPassword=configListByCompanyId.get(i).getValue();
				}
				if(configListByCompanyId.get(i).getPropertyType().equals(Constants.DEFAULT_COMPANY_HOST))
				{
					companyHost=configListByCompanyId.get(i).getValue();
				}
				if(configListByCompanyId.get(i).getPropertyType().equals(Constants.DEFAULT_COMPANY_PORT))
				{
					companyPort=configListByCompanyId.get(i).getValue();
				}
				if(configListByCompanyId.get(i).getPropertyType().equals(Constants.DEFAULT_COMPANY_TRUST))
				{
					companyTrust=configListByCompanyId.get(i).getValue();
				}
			}
			
			System.out.println(hostMail+" : "+hostPassword);
			
			final String myHostMail=hostMail;
			final String myHostPassword=hostPassword;
			final String myCompanyHost=companyHost;
			final String myCompanyPort=companyPort;
			final String myCompanyTrust=companyTrust;
			
			String eOrderNumber=orderMasterActionForm.getOrderNumber();
			
			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			//props.put("mail.smtp.host", "mail.neetai.com");
			props.put("mail.smtp.host", myCompanyHost);
			//props.put("mail.smtp.port", "587");
			props.put("mail.smtp.port", myCompanyPort);
			//props.put("mail.smtp.ssl.trust", "mail.neetai.com");
			props.put("mail.smtp.ssl.trust", myCompanyTrust);

		
			Session session2 = Session.getInstance(props,new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() 
				{
					return new PasswordAuthentication(myHostMail, myHostPassword);
				}
			});
			
			
			//code for sending mail
			
					
				
					Message message = new MimeMessage(session2);
					message.setFrom(new InternetAddress(hostMail));
					message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(userMailId));
					//message.setSubject("Your Order With Houzstuff.com, Order No : ["+OrdAssNo+"] has been "+ orderStageActionForm.getName());
					message.setSubject("Ordernumber : "+eOrderNumber+". By E_Ordering");
					MimeMultipart multipart = new MimeMultipart("related");
					BodyPart messageBodyPart = new MimeBodyPart();
					String mailString2=null;
					String mailString = null;
					String mailString3=null;
		        	       
					mailString = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">" +
						"<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns=\"http://www.w3.org/1999/xhtml\" style=\"font-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; margin: 0; padding: 0;\">" +
						"<head>" +
						"	<meta name=\"viewport\" content=\"width=device-width\" />" +
						"	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />" +
						"	<title>HouzStuff</title>" +
						"</head>" +
						"<body bgcolor=\"#FFFFFF\" style=\"font-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; -webkit-font-smoothing: antialiased; -webkit-text-size-adjust: none; width: 100% !important; height: 100%; margin: 0; padding: 0;\">" +
						"<!-- HEADER -->" +
						"	<table bgcolor=\"#005387\" style=\"font-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; width: 100%; margin: 0; padding: 0;\">" +
						"		<tr style=\"font-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; margin: 0; padding: 0;\">" +
						"			<td style=\"font-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; display: block !important; max-width: 600px !important; clear: both !important; margin: 0 auto; padding: 0;\">" +
						"				<div style=\"font-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; max-width: 600px; display: block; margin: 0 auto; padding: 15px;\">" +
						"					<table bgcolor=\"#005387\" style=\"font-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; width: 100%; margin: 0; padding: 0;\">" +
						"						<tr style=\"font-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; margin: 0; padding: 0;\">" +
						"							<td style=\"font-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; margin: 0; padding: 0;\">" +
						"								<img id=\"logo\" src=\"cid:image\" style=\"font-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; max-width: 100%; margin: 0; padding: 0;\" />" +
						"							</td>" +
						"							<td align=\"right\"><h4 style=\"margin:0!important;\">	NEETAI TECH</h4></td>"+		
						"						</tr>" +
						"					</table>" +
						"				</div>" +
						"			</td>" +
						"			<td style=\"font-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; margin: 0; padding: 0;\">" +
						"			</td>" +
						"		</tr>" +
						"	</table>" +
						"<!-- /HEADER -->" +
						"<!-- BODY -->" +
						"<table style=\"font-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; width: 100%; margin: 0; padding: 0;\">" +
						"	<tr style=\"font-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; margin: 0; padding: 0;\">" +
						"		<td bgcolor=\"#FFFFFF\" style=\"font-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; display: block !important; max-width: 600px !important; clear: both !important; margin: 0 auto; padding: 0;\">&#13;" +
						"			<div style=\"font-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; max-width: 600px; display: block; margin: 0 auto; padding: 15px;\">&#13;" +
						"			<table style=\"font-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; width: 100%; margin: 0; padding: 0;\">" +
						"				<tr style=\"font-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; margin: 0; padding: 0;\">" +
						"					<td style=\"font-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; margin: 0; padding: 0;\">&#13;" +
						"					<h3 style=\"font-family: 'HelveticaNeue-Light', 'Helvetica Neue Light', 'Helvetica Neue', Helvetica, Arial, 'Lucida Grande', sans-serif; line-height: 1.1; color: #000; font-weight: 500; font-size: 27px; margin: 0 0 15px; padding: 0;\">Hello Dear " +
						"						"+"</h3>" +
						"						<p style=\"font-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; font-weight: normal; font-size: 17px; line-height: 1.6; margin: 0 0 10px; padding: 0;\">";
					
					String msgToAppend="";
					String itemName="";
					String itemQuantity="";
					String rate="";
					String amount="";
					for(int i=0;i<orderDetailActionForm.size();i++)
					{
						itemActionForm=itemDBHelper.getItemById(orderDetailActionForm.get(i).getItemMasterId());
						itemName=itemActionForm.getName();
						
						itemQuantity=""+orderDetailActionForm.get(i).getQuantity();
						rate=""+orderDetailActionForm.get(i).getRate();
						amount=""+orderDetailActionForm.get(i).getAmount();
						msgToAppend=msgToAppend+"<table>"+
								    			"<tr><td>Item:</td><td>"+itemName+"</td></tr>"+
								    			"<tr><td>Quantity:</td><td>"+itemQuantity+"</td></tr>"+
								    			"<tr><td>Rate:</td><td>"+rate+"</td></tr>"+
								    			"<tr><td>Amount:</td><td>"+amount+"</td></tr>"+
								    			"<tr><td></td><td></td></tr>"+
								    			"</table>";
						
					}
					
						
			mailString2="						Your order Order Number:"+" | Date:"+"  item(s) is/are <b>\""+ "\" Successfully. </b>"+		
						"						</p>" +
						"						<!-- A Real Hero (and a real human being) -->" +
						"							<p style=\"font-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; font-weight: normal; font-size: 14px; line-height: 1.6; margin: 0 0 10px; padding: 0;\">" +
						"							<!--	<img src=\"http://placehold.it/600x300\" style=\"font-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; max-width: 100%; margin: 0; padding: 0;\" /> -->" +
						"							</p>" +
						"						<!-- /hero -->" +
						"						<!-- Callout Panel -->&#13;" +
						"							<p style=\"font-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; font-weight: normal; font-size: 14px; line-height: 1.6; background-color: #ECF8FF; margin: 0 0 15px; padding: 15px;\">" +
						"								Any Questions? <br> Regarding any issue on your transaction or palced order.." + 
						"								<a href=\"http://www.neetai.com/contact.php\" style=\"font-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; color: #2BA6CB; font-weight: bold; margin: 0; padding: 0;\">Please Click Here! »</a>" +
						"							</p>" +
						"						<!-- /Callout Panel -->" +
						"						<a href=\"http://www.neetai.com\" style=\"font-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; color: #FFF; text-decoration: none; font-weight: bold; text-align: center; cursor: pointer; display: block !important; background-image: none !important; background-color: #666; margin: 0 0 10px; padding: 10px 16px;\">Click Me!</a>" +
						"						</br>" +
						"						<!-- social & contact -->" +
						"						<table width=\"100%\" style=\"font-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; width: 100%; background-color: #ebebeb; margin: 0; padding: 0;\" bgcolor=\"#ebebeb\">" +
						"							<tr style=\"font-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; margin: 0; padding: 0;\">" +
						"								<td style=\"font-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; margin: 0; padding: 0;\">" +
						"									<!--- column 1 -->" +
						"									<table align=\"left\" style=\"font-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; width: 280px; float: left; min-width: 279px; margin: 0; padding: 0;\">" +
						"										<tr style=\"font-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; margin: 0; padding: 0;\">" +
						"											<td style=\"font-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; margin: 0; padding: 15px;\">" +
						"												<h5 style=\"font-family: 'HelveticaNeue-Light', 'Helvetica Neue Light', 'Helvetica Neue', Helvetica, Arial, 'Lucida Grande', sans-serif; line-height: 1.1; color: #000; font-weight: 900; font-size: 17px; margin: 0 0 15px; padding: 0;\">Connect with Us:</h5>&#13;" +
						"												<p style=\"font-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; font-weight: normal; font-size: 14px; line-height: 1.6; margin: 0 0 10px; padding: 0;\">" +
						"													<a href=\"#\" style=\"font-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; color: #FFF; font-size: 12px; text-decoration: none; font-weight: bold; display: block; text-align: center; background-color: #3B5998 !important; margin: 0 0 10px; padding: 3px 7px;\">Facebook</a> " +
						"													<a href=\"#\" style=\"font-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; color: #FFF; font-size: 12px; text-decoration: none; font-weight: bold; display: block; text-align: center; background-color: #1daced !important; margin: 0 0 10px; padding: 3px 7px;\">Twitter</a> " +
						"													<a href=\"#\" style=\"font-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; color: #FFF; font-size: 12px; text-decoration: none; font-weight: bold; display: block; text-align: center; background-color: #DB4A39 !important; margin: 0 0 10px; padding: 3px 7px;\">Google+</a>" +
						"												</p>" +
						"											</td>&#13;" +
						"										</tr>" +
						"									</table>" +
						"									<!-- /column 1 -->" +
						"									<!--- column 2 -->" +
						"									<table align=\"left\" style=\"font-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; width: 280px; float: left; min-width: 279px; margin: 0; padding: 0;\">" +
						"										<tr style=\"font-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; margin: 0; padding: 0;\">" +
						"											<td style=\"font-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; margin: 0; padding: 15px;\">" +
						"												<h5 style=\"font-family: 'HelveticaNeue-Light', 'Helvetica Neue Light', 'Helvetica Neue', Helvetica, Arial, 'Lucida Grande', sans-serif; line-height: 1.1; color: #000; font-weight: 900; font-size: 17px; margin: 0 0 15px; padding: 0;\">Contact Info:</h5>" +
						"												<p style=\"font-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; font-weight: normal; font-size: 14px; line-height: 1.6; margin: 0 0 10px; padding: 0;\">Phone: <strong style=\"font-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; margin: 0; padding: 0;\">+91.000.000.000.0</strong><br/>" +
						"												Email: <strong style=\"font-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; margin: 0; padding: 0;\">" +
						"												<a href=\"info@neetai.com\" style=\"font-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; color: #2BA6CB; margin: 0; padding: 0;\">info@neetai.com </a></strong></p>&#13;" +
						"											</td>" +
						"										</tr>" +
						"									</table>" +
						"									<!-- /column 2 -->" +
						"									<span style=\"font-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; display: block; clear: both; margin: 0; padding: 0;\"></span" +
						"								</td>" +
						"							</tr>" +
						"						</table>" +
						"						<!-- /social & contact -->" +
						"					</td>&#13;" +
						"				</tr>" +
						"			</table>" +
						"			</div>" +
						"		</td>" +
						"		<td style=\"font-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; margin: 0; padding: 0;\">" +
						"		</td>" +
						"	</tr>" +
						"</table>" +
						"<!-- /BODY -->" +
						"</body>" +
						"</html>";
			
					
					mailString3=mailString+msgToAppend+mailString2;
			
					// Loading the image
			        DataSource ds=new FileDataSource("assets/frontend/layout/img/logos/logo-shop-red.png");
			        messageBodyPart.setDataHandler(new DataHandler(ds));
		
			        //Setting the header
			        messageBodyPart.addHeader("Content-ID","<image>");
		
					messageBodyPart.setContent(mailString3,"text/html; charset=utf-8");
				
					multipart.addBodyPart(messageBodyPart);
					message.setContent(multipart);
					Transport.send(message);
	 
					//System.out.println("-------------------------->"+configUsername);
					//System.out.println("-------------------------->"+recipientMailId);
					System.out.println("Done");
				
			
					//END code for sending mail
					
			} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	/*public void sendSMS(int orderMasterId, int orderStageId)
	{
		try 
		{
			String SMSStr = null;
			
			orderMasterActionForm = orderMasterDBHelper.getOrderByMasterId(orderMasterId);
			final String configUsername = configDBHelper.getMailId("DefaultSMSUser");
			final String configPassword = configDBHelper.getMailId("DefaultSMSPassword");
			orderStageActionForm = orderStageDBHelper.getOrderStageById(orderStageId);
			SMSStr = "Dear, CUS OrNO:"+orderMasterActionForm.getOrderNumber()+" items "+orderStageActionForm.getName()+" Successfully.";
			
			URL url = new URL("http://49.50.78.10/vendorsms/pushsms.aspx?user="+configUsername+"&password="+configPassword+"&msisdn="+orderMasterActionForm.getMobileNumber()+"&sid=WEBSMS&msg="+SMSStr+"&fl=0");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection(); 

			connection.setDoOutput(false); 
			connection.setDoInput(true); 
	          
			String res=connection.getResponseMessage(); 
			System.out.println("Response Code  ->"+res); 
	          
			int code = connection.getResponseCode () ; 
	        
			if ( code == HttpURLConnection.HTTP_OK ) 
			{    
				System.out.println("Send Sucessfully");
				connection.disconnect() ; 
	          }
	       }
	       catch(IOException e) 
	       {
	          System.out.println("unable to create new url"+e.getMessage());

	       }

	}*/
	


	
}

