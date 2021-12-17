package com.bms.mdm.measurement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

public class MeasurementDBHelper {
	
	private static final String TAG= "com.bms.mdm.measurement.MeasurementDBHelper";
	private Logger logger = Logger.getLogger(TAG);
	
	private MeasurementDBAdapter measurementDBAdapter;
	public MeasurementDBHelper() {
		measurementDBAdapter=new MeasurementDBAdapter();
	}
	
	public ArrayList<MeasurementActionForm> fetchAllRecords(){
		measurementDBAdapter.open();
		ResultSet cursor=measurementDBAdapter.getAll();
		ArrayList<MeasurementActionForm> measurementActionFormsList = new ArrayList<MeasurementActionForm>();;
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				while(cursor.next()){
					measurementActionFormsList.add(fetchDataFromResultSet(cursor));
				}
				cursor.close();
			}
			catch (Exception e) {
				//System.out.println(e);
				logger.error(e);
			}
			
		}
		measurementDBAdapter.close();
		return measurementActionFormsList; 
	}
	
	public MeasurementActionForm getMeasurementById(int measurementEntryId){
		measurementDBAdapter.open();
		ResultSet cursor=measurementDBAdapter.getByMeasurementId(measurementEntryId);
		MeasurementActionForm measurementActionForm = null;
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				if(cursor.next()){
					measurementActionForm = fetchDataFromResultSet(cursor);
				}
				cursor.close();
			}
			catch (Exception e) {
				logger.error(e);
			}
		}
		measurementDBAdapter.close();
		return measurementActionForm;
	}
	
	
	
	public int addMeasurementEntryId(MeasurementActionForm measurementActionForm)
	{   
		measurementDBAdapter.open();
		int status = measurementDBAdapter.insertMeasurement(measurementActionForm);
		measurementDBAdapter.close();
		
		return status;
	}
	
	
	public boolean deleteMeasurementById(int measurementEntryId)
	{
		measurementDBAdapter.open();
		boolean status = measurementDBAdapter.deactiavteMeasurementEntry(measurementEntryId);
		measurementDBAdapter.close();
		return status;
	}
	
	
	
	
	public int updateMeasurementEntry(MeasurementActionForm measurementActionForm){
		measurementDBAdapter.open();
		int result = measurementDBAdapter.update(measurementActionForm);
		measurementDBAdapter.close();
		return result;
	}
	
	
	
	
	private MeasurementActionForm fetchDataFromResultSet(ResultSet cursor){ 
		
		MeasurementActionForm measurementActionForm=new MeasurementActionForm();
		try
		{
		
			measurementActionForm.setMeasurementMasterId(cursor.getInt(MeasurementDBAdapter.COLUMN_MEASUREMENT_MASTER_ID));
			measurementActionForm.setUnit(cursor.getString(MeasurementDBAdapter.COLUMN_MEASUREMENT_UNIT));
			measurementActionForm.setName(cursor.getString(MeasurementDBAdapter.COLUMN_MEASUREMENT_NAME));
			measurementActionForm.setSymbol(cursor.getString(MeasurementDBAdapter.COLUMN_MEASUREMENT_SYMBOL));
			measurementActionForm.setCreatedBy(cursor.getInt(MeasurementDBAdapter.COLUMN_MEASUREMENT_CREATED_BY));
			measurementActionForm.setCreatedDTTM(cursor.getString(MeasurementDBAdapter.COLUMN_MEASUREMENT_CREATED_DTTM));
			measurementActionForm.setModifiedBy(cursor.getInt(MeasurementDBAdapter.COLUMN_MEASUREMENT_MODIFIED_BY));
			measurementActionForm.setModifiedDTTM(cursor.getString(MeasurementDBAdapter.COLUMN_MEASUREMENT_MODIFIED_DTTM));
			measurementActionForm.setIsActive(cursor.getInt(MeasurementDBAdapter.COLUMN_MEASUREMENT_MODIFIED_IS_ACTIVE));
			measurementActionForm.setCompanyMasterId(cursor.getInt(MeasurementDBAdapter.COLUMN_MEASUREMENT_COMPANY_MASTER_ID));
			
		}
		catch(Exception e)
		{
			logger.error(e);
		}
		return measurementActionForm;
	}
	private MeasurementActionForm getCompanyFromResultSet(ResultSet userResultSet) throws SQLException{
		MeasurementActionForm measurementActionForm=new MeasurementActionForm();
		measurementActionForm.setCompanyMasterId(userResultSet.getInt(MeasurementDBAdapter.COLUMN_MEASUREMENT_COMPANY_MASTER_ID));
		return measurementActionForm;
	}
		
		public ArrayList<MeasurementActionForm>getMeasurementByCompanyId(int companyid){
			measurementDBAdapter.open();
			ResultSet cursor=measurementDBAdapter.getmeasurementByCompanyId(companyid);
			ArrayList<MeasurementActionForm>measurementBean=new ArrayList<MeasurementActionForm>();
			if(cursor!=null){
				try{
					cursor.beforeFirst();
					while(cursor.next()){
						measurementBean.add(fetchDataFromResultSet(cursor));
					}
					cursor.close();
				}
				catch(Exception e){
					logger.error(e);
				}
					}
			measurementDBAdapter.close();
			return measurementBean;
				}
			
		public ArrayList<MeasurementActionForm> fetchAllDistinctCompany(){
			measurementDBAdapter.open();
			ResultSet cursor=measurementDBAdapter.getAlldistinctCompany();
			ArrayList<MeasurementActionForm> MeasurementbycompanyFormList = new ArrayList<MeasurementActionForm>();;
			if(cursor!=null){
				try
				{
					cursor.beforeFirst();
					while(cursor.next()){
						MeasurementbycompanyFormList.add(getCompanyFromResultSet(cursor));
					}
					cursor.close();
				}
				catch (Exception e) {
					//System.out.println(e);
					logger.error(e);
				}
				
			}
			measurementDBAdapter.close();
			return MeasurementbycompanyFormList; 
		}
	
	public ArrayList<MeasurementActionForm> fetchAllActiveMeasurementRecords(){
		measurementDBAdapter.open();
		ResultSet cursor=measurementDBAdapter.getAllActiveMeasurement();
		ArrayList<MeasurementActionForm> measurementBeanList = new ArrayList<MeasurementActionForm>();
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				while(cursor.next()){
					measurementBeanList.add(fetchDataFromResultSet(cursor));
				}
				cursor.close();
			}
			catch (Exception e) {
				//System.out.println(e);
				logger.error(e);
			}
			
		}
		measurementDBAdapter.close();
		return measurementBeanList; 
	}
	
	public boolean findTrueIfTableHasDataForSpecificCompanyOWFalse(int companyid) throws SQLException{
		measurementDBAdapter.open();
		ResultSet rs = measurementDBAdapter.findTrueIfTableHasDataForSpecificCompanyOWFalse(companyid);
		if(rs.next()){
			return true;
		}else{
			return false;
		}		
	}
	
	public boolean findTrueIfTableContainsMinOneRow() throws SQLException{
		measurementDBAdapter.open();
		ResultSet rs =measurementDBAdapter.getAll();
		if(rs.next()){
			return true;
		}else{
			return false;
		}
	}
	
	public ArrayList<MeasurementActionForm> getActiveMeasuresSpecificForCompany(int companyid) throws SQLException{
		measurementDBAdapter.open();
		ArrayList<MeasurementActionForm> list = new ArrayList<MeasurementActionForm>();
		if(measurementDBAdapter.getActiveMeasuresSpecificForCompany(companyid).next()){
			ResultSet rs = measurementDBAdapter.getActiveMeasuresSpecificForCompany(companyid);
			while(rs.next()){
				list.add(fetchDataFromResultSet(rs));
			}
		}
		measurementDBAdapter.close();
		return list;
	}
	
	
	

}
