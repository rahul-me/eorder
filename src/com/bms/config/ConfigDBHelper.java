package com.bms.config;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bms.constants.Constants;



public class ConfigDBHelper {
	

	ConfigActionForm configBean;
	private ConfigDBAdapter configDBAdapter;

	public ConfigDBHelper() {
		configDBAdapter= new ConfigDBAdapter();
	}
	
	public ConfigActionForm getConfigByPropertyTypeFetchedFromCompanyId(ArrayList<ConfigActionForm> configBean, String criteria)
	{
		
		try
		{
			this.configBean=new ConfigActionForm();
			for(int i=0;i<configBean.size();i++)
			{
				if(configBean.get(i).getPropertyType().equals(criteria))
				{
					this.configBean.setCompanyId(configBean.get(i).getCompanyId());
					this.configBean.setProperty(configBean.get(i).getProperty());
					this.configBean.setPropertyType(configBean.get(i).getPropertyType());
					this.configBean.setValue(configBean.get(i).getValue());
				}
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception :"+e);
		}
		return this.configBean;
	}
	
	public ArrayList<ConfigActionForm> getAllRecordsByCompanyId(int compid)
	{
		configDBAdapter.open();
		ResultSet rs=configDBAdapter.fetchConfigByCompanyId(compid);
		ArrayList<ConfigActionForm> configList=new ArrayList<ConfigActionForm>();
		try
		{
			while(rs.next())
			{
				configList.add(fetchDataFromResultSet(rs));
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		configDBAdapter.close();
		return configList;
	}

	public ArrayList<ConfigActionForm> getAllRecords()
	{
		configDBAdapter.open();
		ResultSet rs=null;
		rs=configDBAdapter.fetchAllConfig();
		ArrayList<ConfigActionForm> configList= new ArrayList<ConfigActionForm>();
		try
		{
			while(rs.next())
			{
				configList.add(fetchDataFromResultSet(rs));
			}
		}
		catch(Exception e)
		{
			System.out.println("Error:"+e);
		}
		configDBAdapter.close();
		
		return configList;
	}
	
	public boolean insertMailConfiguration(ConfigActionForm configbean){
		configDBAdapter.open();
		boolean result=configDBAdapter.insertMailConfiguration(configbean);
		configDBAdapter.close();

		if(result)
			return true;
		else 
			return false;

	}
	public boolean insertSection(ConfigActionForm configbean){
		configDBAdapter.open();
		int result=configDBAdapter.createConfig(configbean);
		configDBAdapter.close();

		if(result>0)
			return true;
		else 
			return false;

	}

	public String getMailId(String property){
		ResultSet configResultSet;
		String emailIds="";
		configDBAdapter.open();
		configResultSet=configDBAdapter.fetchConfigByProperty(property);
		if(configResultSet != null)
		{
			try {
				configResultSet.beforeFirst();
				if(configResultSet.next())
					emailIds=configResultSet.getString(ConfigDBAdapter.KEY_VALUE);
				configResultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		configDBAdapter.close();
		return emailIds;
	}

	public boolean deleteAllMailReports(String property){
		configDBAdapter.open();
		boolean result=configDBAdapter.deleteAllMailReports(property);
		configDBAdapter.close();
		return result;
	}

	public boolean deleteConfigReport(String property){
		configDBAdapter.open();
		boolean result=configDBAdapter.deleteConfig(property);
		configDBAdapter.close();
		return result;
	}


	public boolean updateConfiguration(ConfigActionForm configBean){
		configDBAdapter.open();
		boolean result=configDBAdapter.updateConfig(configBean);
		configDBAdapter.close();
		if(result)
			return true;
		else 
			return false;
	}


	public String populate(ConfigActionForm configBean){
		ResultSet configResultSet;
		String emailIds = null;
		configDBAdapter.open();
		configResultSet = configDBAdapter.populate(configBean);
		if(configResultSet != null)
		{
			try {
				configResultSet.beforeFirst();
				if(configResultSet.next())
					emailIds=configResultSet.getString(ConfigDBAdapter.KEY_VALUE);
				configResultSet.close();
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		configDBAdapter.close();
		return emailIds;


	}

	public ArrayList<ConfigActionForm> getConfigByPropertyType(String type){

		ResultSet configResultSet;
		//ConfigBean configBean=new ConfigBean();
		ArrayList<ConfigActionForm> configBean = null;
		configDBAdapter.open();
		configResultSet=configDBAdapter.fetchConfigByPropertyType(type);
		if(configResultSet!=null){

			try {
				 configBean=new ArrayList<ConfigActionForm>();
				configResultSet.beforeFirst();
				while(configResultSet.next())
					configBean.add(fetchDataFromResultSet(configResultSet));
				configResultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		configDBAdapter.close();
		return configBean;
	}
	public ConfigActionForm fetchConfigByCompanyId(int compid)
	{
		ResultSet rs=null;
		configDBAdapter.open();
		rs=configDBAdapter.fetchConfigByCompanyId(compid);
		ConfigActionForm configActionForm=new ConfigActionForm();
		configActionForm=fetchDataFromResultSet(rs);
		System.out.println("hello");
		return configActionForm;
	}
	public ConfigActionForm fetchConfigByPropertyType(String type){

		ResultSet configResultSet;
		ConfigActionForm configBean=new ConfigActionForm();
		configDBAdapter.open();
		configResultSet=configDBAdapter.fetchConfigByPropertyType(type);
		if(configResultSet!=null){

			try {
				configResultSet.beforeFirst();
				if(configResultSet.next())
					configBean=fetchDataFromResultSet(configResultSet);
				configResultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		configDBAdapter.close();
		return configBean;
	}

	public ConfigActionForm getLastValueByPropertyType(String type){

		ResultSet configResultSet;
		ConfigActionForm configBean=new ConfigActionForm();
		configDBAdapter.open();
		configResultSet=configDBAdapter.fetchConfigByPropertyType(type);
		if(configResultSet!=null){

			try {
				configResultSet.beforeFirst();
				int max=0;
				ConfigActionForm maxConfigBean=new ConfigActionForm();
				while(configResultSet.next()){
					configBean=fetchDataFromResultSet(configResultSet);
					if(max<Integer.parseInt(configBean.getValue())){
						max=Integer.parseInt(configBean.getValue());
						maxConfigBean=configBean;
					}
				}
				configDBAdapter.close();
				configResultSet.close();
				return maxConfigBean;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		configDBAdapter.close();
		return configBean;
	}


	public String fetchConfigByProperty(String type){

		ResultSet configResultSet;
		//ConfigActionForm configBean=new ConfigActionForm();
		String  configvalue=null;
		configDBAdapter.open();
		configResultSet=configDBAdapter.fetchConfigByProperty(type);
		if(configResultSet!=null){

			try {
				configResultSet.beforeFirst();
				if(configResultSet.next())
					configvalue=configResultSet.getString(ConfigDBAdapter.KEY_VALUE);
					//configBean=fetchDataFromResultSet(configResultSet);
				configResultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		configDBAdapter.close();
		return configvalue;
	}

	public int updateIsActive(String TableName,int isActive,String MasterIdName, int masterId,int userId,String ModifiedDTTM){
		configDBAdapter.open();
		int result=configDBAdapter.updateIsActive(TableName,isActive,MasterIdName,masterId,userId,ModifiedDTTM);
		configDBAdapter.close();
			return result;
	}	
	
	
	
	public ConfigActionForm fetchDataFromResultSet(ResultSet resultSet){

		ConfigActionForm configBean=new ConfigActionForm();
		try {
			configBean.setProperty(resultSet.getString(ConfigDBAdapter.KEY_PROPERTY));
			configBean.setPropertyType(resultSet.getString(ConfigDBAdapter.KEY_PROPERTY_TYPE));
			configBean.setValue(resultSet.getString(ConfigDBAdapter.KEY_VALUE));
			configBean.setCompanyId(resultSet.getInt(ConfigDBAdapter.KEY_COMPANY_ID));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return configBean;
	}
	

	
	
	
	public boolean updateTrainingFile(String trainingModeProp,int modeValue,String modeFile){
		configDBAdapter.open();
		boolean result=configDBAdapter.updateTrainingFile(trainingModeProp,modeValue,modeFile);
		configDBAdapter.close();
		if(result)
			return true;
		else 
			return false;
	}


	public ConfigActionForm fetchTrainingByProperty(String property){

		ResultSet configResultSet;
		ConfigActionForm configBean=new ConfigActionForm();
		configDBAdapter.open();
		configResultSet=configDBAdapter.fetchTrainingByProperty(property);
		if(configResultSet!=null){

			try {
				configResultSet.beforeFirst();
				if(configResultSet.next())
					configBean=fetchDataFromResultSet(configResultSet);
				configResultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		configDBAdapter.close();
		return configBean;
	}
public boolean updateBackupConfiguration(String prop,int value,String fileName){
		configDBAdapter.open();
		boolean result=configDBAdapter.insertBackupConfiguration(prop,value,fileName);
		configDBAdapter.close();
		if(result)
			return true;
		else 
			return false;
	}
	String ac;
	public String fetchBachupConfiguration(String value)
	{
		ResultSet resultSet;		
		configDBAdapter.open();
		
		resultSet=configDBAdapter.fetchBachupConfiguration(value);
		if(resultSet!=null)
		{
			try 
			{
				while (resultSet.next()) 
				{
				
					 ac=resultSet.getString("propertytype");
					 System.out.println("go");
					 System.out.println("inside helper"+ac);
					
				
				}
				
			} catch (Exception e) {
				// TODO: handle exception
		}
			
			
			
			
		}	
		configDBAdapter.close();
		return ac;
	}
	
	public ConfigActionForm getDetailsSpecificForCompanyAndProperty(int companyid, String property) throws SQLException{
		configDBAdapter.open();
		ConfigActionForm configBean = null;
		if(configDBAdapter.getDetailsSpecificForCompanyAndProperty(companyid, property).next()){
			configBean= new ConfigActionForm();
			ResultSet rs = configDBAdapter.getDetailsSpecificForCompanyAndProperty(companyid, property);
			rs.next();
			configBean = fetchDataFromResultSet(rs);			
		}
		configDBAdapter.close();
		return configBean;
	}

}
