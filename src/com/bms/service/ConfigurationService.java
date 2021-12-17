
package com.bms.service;



import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.bms.config.ConfigActionForm;
import com.bms.config.ConfigDBHelper;
import com.bms.constants.Constants;


@Path("/ConfigurationService")
public class ConfigurationService {
	
	@Context
	HttpServletRequest request;
	HttpServletResponse response;
	
	@Context
	UriInfo uriInfo;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String respondAsReady() {
		return "Smart web service is ready!";
	}
	
	@GET
	@Path("/setDefaultMailConfiguration")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JSONObject setDefaultMailConfiguration(String data) throws JSONException
	{
		
		HttpSession session=request.getSession(true);
		int compid=(int)session.getAttribute(Constants.COMPANY_ID);
		System.out.println(compid);
		System.out.println("hello");
		System.out.println(request.getContentType());
		
		ConfigDBHelper configDBHelper=new ConfigDBHelper();
		ArrayList<ConfigActionForm> configListByCompanyId=new ArrayList<ConfigActionForm>();
		configListByCompanyId=configDBHelper.getAllRecordsByCompanyId(compid);
		if(configListByCompanyId.size()>0)
		{
			for(int i=0;i<configListByCompanyId.size();i++)
			{
				if(i==0)
				{
					ConfigActionForm updateEmailConfigList=new ConfigActionForm();
					//updateEmailConfigList=configDBHelper.fetchConfigByPropertyType(Constants.DEFAULT_MAIL);
					updateEmailConfigList=configDBHelper.getConfigByPropertyTypeFetchedFromCompanyId(configListByCompanyId, Constants.DEFAULT_MAIL);
					if(updateEmailConfigList!=null)
					updateEmailConfigList.setValue(request.getParameter("email"));
					boolean rese=configDBHelper.updateConfiguration(updateEmailConfigList);
				}
				if(i==1)
				{
					ConfigActionForm updateEPassConfigList=new ConfigActionForm();
					//updateEPassConfigList=configDBHelper.fetchConfigByPropertyType(Constants.DEFAULT_MAIL);
					updateEPassConfigList=configDBHelper.getConfigByPropertyTypeFetchedFromCompanyId(configListByCompanyId, Constants.DEFAULT_PASSWORD);
					if(updateEPassConfigList!=null)
					updateEPassConfigList.setValue(request.getParameter("epass"));
					boolean resp=configDBHelper.updateConfiguration(updateEPassConfigList);
				}
				if(i==2)
				{
					ConfigActionForm updateECHostConfigList=new ConfigActionForm();
					//updateEPassConfigList=configDBHelper.fetchConfigByPropertyType(Constants.DEFAULT_MAIL);
					updateECHostConfigList=configDBHelper.getConfigByPropertyTypeFetchedFromCompanyId(configListByCompanyId, Constants.DEFAULT_COMPANY_HOST);
					if(updateECHostConfigList!=null)
						updateECHostConfigList.setValue(request.getParameter("echost"));
					boolean resp=configDBHelper.updateConfiguration(updateECHostConfigList);
				}
				if(i==3)
				{
					ConfigActionForm updateECPortConfigList=new ConfigActionForm();
					//updateEPassConfigList=configDBHelper.fetchConfigByPropertyType(Constants.DEFAULT_MAIL);
					updateECPortConfigList=configDBHelper.getConfigByPropertyTypeFetchedFromCompanyId(configListByCompanyId, Constants.DEFAULT_COMPANY_PORT);
					if(updateECPortConfigList!=null)
						updateECPortConfigList.setValue(request.getParameter("ecport"));
					boolean resp=configDBHelper.updateConfiguration(updateECPortConfigList);
				}
				if(i==4)
				{
					ConfigActionForm updateECTrustConfigList=new ConfigActionForm();
					//updateEPassConfigList=configDBHelper.fetchConfigByPropertyType(Constants.DEFAULT_MAIL);
					updateECTrustConfigList=configDBHelper.getConfigByPropertyTypeFetchedFromCompanyId(configListByCompanyId, Constants.DEFAULT_COMPANY_TRUST);
					if(updateECTrustConfigList!=null)
						updateECTrustConfigList.setValue(request.getParameter("ectrust"));
					boolean resp=configDBHelper.updateConfiguration(updateECTrustConfigList);
				}
			}
		}
		if(configListByCompanyId.size()<1)
		{
			ConfigActionForm configActionForm=new ConfigActionForm();
			configActionForm.setProperty(Constants.DEFAULT_MAIL);
			configActionForm.setPropertyType(Constants.DEFAULT_MAIL);
			configActionForm.setValue(request.getParameter("email"));
			configActionForm.setCompanyId(compid);
			boolean resultem=configDBHelper.insertSection(configActionForm);
			if(resultem)
			{
				System.out.println("Data has been submit");
			}
			else
			{
				System.out.println("Some error is occured");
			}
			
			ConfigActionForm configActionFormPass=new ConfigActionForm();
			configActionFormPass.setProperty(Constants.DEFAULT_PASSWORD);
			configActionFormPass.setPropertyType(Constants.DEFAULT_PASSWORD);
			configActionFormPass.setCompanyId(compid);
			configActionFormPass.setValue(request.getParameter("epass"));
			boolean resultep=configDBHelper.insertSection(configActionFormPass);
			if(resultep)
			{
				System.out.println("ep Data has been submit");
			}
			else
			{
				System.out.println("ep Some error is occured");
			}
			
			ConfigActionForm configActionFormCHost=new ConfigActionForm();
			configActionFormCHost.setProperty(Constants.DEFAULT_COMPANY_HOST);
			configActionFormCHost.setPropertyType(Constants.DEFAULT_COMPANY_HOST);
			configActionFormCHost.setCompanyId(compid);
			configActionFormCHost.setValue(request.getParameter("echost"));
			boolean resultch=configDBHelper.insertSection(configActionFormCHost);
			if(resultch)
			{
				System.out.println("ep Data has been submit");
			}
			else
			{
				System.out.println("ep Some error is occured");
			}
			
			ConfigActionForm configActionFormCPort=new ConfigActionForm();
			configActionFormCPort.setProperty(Constants.DEFAULT_COMPANY_PORT);
			configActionFormCPort.setPropertyType(Constants.DEFAULT_COMPANY_PORT);
			configActionFormCPort.setCompanyId(compid);
			configActionFormCPort.setValue(request.getParameter("ecport"));
			boolean resultcp=configDBHelper.insertSection(configActionFormCPort);
			if(resultcp)
			{
				System.out.println("ep Data has been submit");
			}
			else
			{
				System.out.println("ep Some error is occured");
			}
			
			ConfigActionForm configActionFormCTrust=new ConfigActionForm();
			configActionFormCTrust.setProperty(Constants.DEFAULT_COMPANY_TRUST);
			configActionFormCTrust.setPropertyType(Constants.DEFAULT_COMPANY_TRUST);
			configActionFormCTrust.setCompanyId(compid);
			configActionFormCTrust.setValue(request.getParameter("ectrust"));
			boolean resultct=configDBHelper.insertSection(configActionFormCTrust);
			if(resultct)
			{
				System.out.println("ep Data has been submit");
			}
			else
			{
				System.out.println("ep Some error is occured");
			}
		}
		
		return null;
	}
	
	
	@POST
	@Path("/setitemPrice")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JSONObject setitemPrice(String data){

		JSONObject jsonObject = null;
		ConfigDBHelper configDBHelper=new ConfigDBHelper();
		ConfigActionForm configActionForm=new ConfigActionForm();

		try
		{
			jsonObject = new JSONObject(data);
			if(jsonObject !=null)
			{
				String itempriceStatus=jsonObject.getString("itemPriceStatus");
				System.out.println("GRnPOstatus:- "+itempriceStatus);
				
					configActionForm.setProperty("itemPriceOn");
					configActionForm.setValue(itempriceStatus);
					configActionForm.setPropertyType("itemPriceOn");
				boolean val=configDBHelper.updateConfiguration(configActionForm);
				jsonObject.put("message", val);
			}
				
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return jsonObject;
	}
	
	@POST
	@Path("/getitemPrice")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JSONObject getGRnPOMapping(){

		JSONObject jsonObject = null;
		ConfigDBHelper configDBHelper=new ConfigDBHelper();
		try
		{
			jsonObject = new JSONObject();
			String val=configDBHelper.fetchConfigByProperty("itemPriceOn");
			jsonObject.put("value", val);
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		try{
		HttpSession httpSession = request.getSession(true);
		int companyid = (int)httpSession.getAttribute(Constants.COMPANY_ID);
		ConfigDBHelper configHelper = new ConfigDBHelper();
		ConfigActionForm configBean = configDBHelper.getDetailsSpecificForCompanyAndProperty(companyid, Constants.SETTING_CONFIG_ITEMUNITCOST_EDITABILITY);
		if(configBean!=null){
			if(configBean.getValue().equals(Constants.SETTING_CONFIG_ITEMUNITCOST_EDITABILITY_VALUE_ON)){
				jsonObject.put("editableCost", "yes");
			}else{
				jsonObject.put("editableCost", "no");
			}
		}
		}catch(Exception e){
			System.out.println(e);			
		}
		return jsonObject;
	}
	
	@POST
	@Path("/setUnitCostEditability")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JSONObject setUnitCostEditability(String data) throws JSONException, SQLException{
		JSONObject jsonObject = new JSONObject(data);
		String unitCostEditabilityStatus = jsonObject.getString("checkboxstatus");
		JSONObject jsonData = new JSONObject();
		HttpSession httpSession = request.getSession(true);
		int companyid = (int)httpSession.getAttribute(Constants.COMPANY_ID);
		
		ConfigDBHelper configHelper = new ConfigDBHelper();
		
		ConfigActionForm configBean = configHelper.getDetailsSpecificForCompanyAndProperty(companyid, Constants.SETTING_CONFIG_ITEMUNITCOST_EDITABILITY);
		if(configBean!=null){
			configBean.setValue(unitCostEditabilityStatus);
			configHelper.updateConfiguration(configBean);
			jsonData.put("result", "Done");
		}else{
			configBean = new ConfigActionForm();
			configBean.setCompanyId(companyid);
			configBean.setProperty(Constants.SETTING_CONFIG_ITEMUNITCOST_EDITABILITY);
			configBean.setPropertyType(Constants.SETTING_CONFIG_ITEMUNITCOST_EDITABILITY);
			configBean.setValue(unitCostEditabilityStatus);
			configHelper.insertSection(configBean);
			jsonData.put("result", "Done");
		}
		return jsonData;
	}
	
}
