package com.bms.mdm.measurement;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;


public class MeasurementConversionDBHelper {

	private static final String TAG= "com.scm.mdm.MeasurementDBHelper";
	private Logger logger = Logger.getLogger(TAG);
	private MeasurementConversionDBAdapter measurementConversionDBAdapter;
	public MeasurementConversionDBHelper() {
		measurementConversionDBAdapter=new MeasurementConversionDBAdapter();
	}
	
	
	public ArrayList<MeasurementConversionBean> fetchAllRecords(){
		measurementConversionDBAdapter.open();
		ResultSet cursor=measurementConversionDBAdapter.getAll();
		ArrayList<MeasurementConversionBean> meConversionBeanList = new ArrayList<MeasurementConversionBean>();;
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				while(cursor.next()){
					meConversionBeanList.add(fetchDataFromResultSet(cursor));
				}
				cursor.close();
			}
			catch (Exception e) {
				//System.out.println(e);
				logger.error(e);
			}
			
		}
		measurementConversionDBAdapter.close();
		return meConversionBeanList; 
	}
	
	
	
	public MeasurementConversionBean getMeasurementConversionById(int mesconid){
		measurementConversionDBAdapter.open();
		ResultSet cursor=measurementConversionDBAdapter.getByMeasurementConversionId(mesconid);
		MeasurementConversionBean measurementConversionBean = null;
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				if(cursor.next()){
					measurementConversionBean = fetchDataFromResultSet(cursor);
				}
				cursor.close();
			}
			catch (Exception e) {
				logger.error(e);
			}
		}
		measurementConversionDBAdapter.close();
		return measurementConversionBean;
	}
	
	
	
	public int addItemCategory(MeasurementConversionBean measurementConversionBean)
	{   
		measurementConversionDBAdapter.open();
		int status = measurementConversionDBAdapter.insertMeasurementConversion(measurementConversionBean);
		measurementConversionDBAdapter.close();
		
		return status;
	}
	
	
	public boolean deleteItemCategoryById(int itemCateId)
	{
         measurementConversionDBAdapter.open();
		boolean status = measurementConversionDBAdapter.deactiavteMeasurementConversion(itemCateId);
		measurementConversionDBAdapter.close();
		return status;
	}
	
	
	
	
	public int updateMeasurementConversion(MeasurementConversionBean measurementConversionBean){
		measurementConversionDBAdapter.open();
		int result = measurementConversionDBAdapter.update(measurementConversionBean);
		measurementConversionDBAdapter.close();
		return result;
	}
	
	
	private MeasurementConversionBean fetchDataFromResultSet(ResultSet cursor){ 
		MeasurementConversionBean measurementConversionBean=new MeasurementConversionBean();
		try
		{
			measurementConversionBean.setId(cursor.getInt(MeasurementConversionDBAdapter.COLUMN_MEASUREMENTCONVERSION_ID));
			measurementConversionBean.setFirstMeasurementId(cursor.getInt(MeasurementConversionDBAdapter.COLUMN_FIRST_MEASUREMENT_ID));
			measurementConversionBean.setSecondMeasurementId(cursor.getInt(MeasurementConversionDBAdapter.COLUMN_SECOND_MEASUREMENT_ID));
			
			measurementConversionBean.setConversionValue(cursor.getInt(MeasurementConversionDBAdapter.COLUMN_MEASUREMENTCONVERSION_CONVERSION_VALUE));
			measurementConversionBean.setCreatedBy(cursor.getString(MeasurementConversionDBAdapter.COLUMN_MEASUREMENTCONVERSION_CREATED_BY));
			measurementConversionBean.setCreatedDTTM(cursor.getString(MeasurementConversionDBAdapter.COLUMN_MEASUREMENTCONVERSION_CREATED_DTTM));
			measurementConversionBean.setModifiedBy(cursor.getString(MeasurementConversionDBAdapter.COLUMN_MEASUREMENTCONVERSION_MODIFIED_BY));
			measurementConversionBean.setModifiedDTTM(cursor.getString(MeasurementConversionDBAdapter.COLUMN_MEASUREMENTCONVERSION_MODIFIED_DTTM));
						
		}
		catch(Exception e)
		{
			logger.error(e);
		}
		return measurementConversionBean;
	}
	
	
	public ArrayList<MeasurementConversionBean> fetchAllRecordsByFilter(HashMap<String , String > filterMap) {
		Set<String> keySet = filterMap.keySet();
		Iterator<String > keySetIterator= keySet.iterator();
		String whereClause="";
		while(keySetIterator.hasNext())
		{
			String tempKey = keySetIterator.next();
			if(!tempKey.equalsIgnoreCase("createdDate")){
					whereClause += " " + tempKey + " in("+  filterMap.get(tempKey)   + ") "; 
					System.out.println("mm1" +filterMap.get(tempKey));
					if (keySetIterator.hasNext()) {
						whereClause += " AND ";
					}
				}
			else
			{
				whereClause += " STR_TO_DATE(" + tempKey + ",'%d/%m/%Y') between "+  filterMap.get(tempKey)   + " ";
			}
		}
		System.out.println("Query "+whereClause);
		measurementConversionDBAdapter.open();
		ResultSet cursor = measurementConversionDBAdapter.getAllByFilter(whereClause);
		ArrayList<MeasurementConversionBean> measurementConversionBeansList = new ArrayList<MeasurementConversionBean>();
		if (cursor != null) {
			try {
				cursor.beforeFirst();
				while (cursor.next()) {
					measurementConversionBeansList.add(fetchDataFromResultSet(cursor));
				}
				cursor.close();
			} catch (Exception e) {
				logger.error(e);
			}
		}
		measurementConversionDBAdapter.close();
		return measurementConversionBeansList;
	}

}
