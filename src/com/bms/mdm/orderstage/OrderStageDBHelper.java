package com.bms.mdm.orderstage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;


import org.apache.log4j.Logger;

import com.bms.constants.Constants;
import com.bms.mdm.orderstage.OrderStageActionForm;
import com.bms.mdm.orderstage.OrderStageDBAdapter;



public class OrderStageDBHelper {
	
	
	
	
	private static final String TAG= "com.bms.mdm.orderstage.OrderStageDBHelper";
	private Logger logger = Logger.getLogger(TAG);
	
	private OrderStageDBAdapter orderstageDBAdapter;
	
	public OrderStageDBHelper() {
		orderstageDBAdapter=new OrderStageDBAdapter();
	}
	
	public ArrayList<OrderStageActionForm> fetchAllRecords(){
		orderstageDBAdapter.open();
		ResultSet cursor=orderstageDBAdapter.getAll();
		ArrayList<OrderStageActionForm> orderstageActionFormsList = new ArrayList<OrderStageActionForm>();;
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				while(cursor.next()){
					orderstageActionFormsList.add(fetchDataFromResultSet(cursor));
				}
				cursor.close();
			}
			catch (Exception e) {
				//System.out.println(e);
				logger.error(e);
			}
			
		}
		orderstageDBAdapter.close();
		return orderstageActionFormsList; 
	}
	
	public OrderStageActionForm getOrderStageById(int orderstageId){
		orderstageDBAdapter.open();
		ResultSet cursor=orderstageDBAdapter.getByOrderStageMasterId(orderstageId);
		OrderStageActionForm orderstageActionForm = null;
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				if(cursor.next()){
					orderstageActionForm = fetchDataFromResultSet(cursor);
				}
				cursor.close();
			}
			catch (Exception e) {
				logger.error(e);
			}
		}
		orderstageDBAdapter.close();
		return orderstageActionForm;
	}
	
	public boolean deleteOrderStageEntry(int orderstagemasterId)
	{
		orderstageDBAdapter.open();
		boolean status = orderstageDBAdapter.deactiavteOrderStageEntry(orderstagemasterId);
		orderstageDBAdapter.close();
		return status;
	}
	
	
	
	
	public int updateOrderStageEntry(OrderStageActionForm orderstageActionForm){
		orderstageDBAdapter.open();
		int result = orderstageDBAdapter.update(orderstageActionForm);
		orderstageDBAdapter.close();
		return result;
	}
	
	public int insertOrderStageEntry(OrderStageActionForm orderstageActionForm){
		orderstageDBAdapter.open();
		int result = orderstageDBAdapter.insertOrderStage(orderstageActionForm);
		orderstageDBAdapter.close();
		return result;
	}
	
	
	
	private OrderStageActionForm fetchDataFromResultSet(ResultSet cursor){ 
		
		OrderStageActionForm orderstageActionForm=new OrderStageActionForm();
		try
		{
			
			orderstageActionForm.setOrderStageMasterId(cursor.getInt(OrderStageDBAdapter.COLUMN_ORDER_STAGE_MASTER_ID));
			orderstageActionForm.setName(cursor.getString(OrderStageDBAdapter.COLUMN_ORDER_STAGE_NAME));
			orderstageActionForm.setDescription(cursor.getString(OrderStageDBAdapter.COLUMN_ORDER_STAGE_DESCRIPTION));
			orderstageActionForm.setCreatedBy(cursor.getInt(OrderStageDBAdapter.COLUMN_ORDER_STAGE_CREATED_BY));
			orderstageActionForm.setModifiedBy(cursor.getInt(OrderStageDBAdapter.COLUMN_ORDER_STAGE_MODIFIED_BY));
			orderstageActionForm.setCreatedDTTM(cursor.getString(OrderStageDBAdapter.COLUMN_ORDER_STAGE_CREATED_DTTM));
			orderstageActionForm.setModifiedDTTM(cursor.getString(OrderStageDBAdapter.COLUMN_ORDER_STAGE_MODIFIED_DTTM));
			orderstageActionForm.setIsActive(cursor.getInt(OrderStageDBAdapter.COLUMN_ORDER_STAGE_IS_ACTIVE));
			orderstageActionForm.setCompanyMasterId(cursor.getInt(OrderStageDBAdapter.COLUMN_ORDER_STAGE_COMPANY_MASTER_ID));
		
		}
		catch(Exception e)
		{
			logger.error(e);
		}
		return orderstageActionForm;
	}
	private OrderStageActionForm getCompanyFromResultSet(ResultSet userResultSet) throws SQLException{
		OrderStageActionForm orderstageActionForm=new OrderStageActionForm();
		orderstageActionForm.setCompanyMasterId(userResultSet.getInt(OrderStageDBAdapter.COLUMN_ORDER_STAGE_COMPANY_MASTER_ID));
		return orderstageActionForm;
	}
	public ArrayList<OrderStageActionForm> fetchAllActiveOrderStage(){
		orderstageDBAdapter.open();
		ResultSet cursor=orderstageDBAdapter.getAllActiveOrderStage();
		ArrayList<OrderStageActionForm> orderStagebeanList = new ArrayList<OrderStageActionForm>();
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				while(cursor.next()){
					orderStagebeanList.add(fetchDataFromResultSet(cursor));
				}
				cursor.close();
			}
			catch (Exception e) {
				//System.out.println(e);
				logger.error(e);
			}
			
		}
		orderstageDBAdapter.close();
		return orderStagebeanList; 
	}
	public ArrayList<OrderStageActionForm>getOrderStageByCompanyId(int companyid){
		orderstageDBAdapter.open();
		ResultSet cursor=orderstageDBAdapter.getorderStageByCompanyId(companyid);
		ArrayList<OrderStageActionForm>orderstageBean=new ArrayList<OrderStageActionForm>();
		if(cursor!=null){
			try{
				cursor.beforeFirst();
				while(cursor.next()){
					orderstageBean.add(fetchDataFromResultSet(cursor));
				}
				cursor.close();
			}
			catch(Exception e){
				logger.error(e);
			}
				}
		orderstageDBAdapter.close();
		return orderstageBean;
			}
		
	public ArrayList<OrderStageActionForm> fetchAllDistinctCompany(){
		orderstageDBAdapter.open();
		ResultSet cursor=orderstageDBAdapter.getAlldistinctCompany();
		ArrayList<OrderStageActionForm>distinctCompanyList = new ArrayList<OrderStageActionForm>();
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				while(cursor.next()){
					distinctCompanyList.add(getCompanyFromResultSet(cursor));
				}
				cursor.close();
			}
			catch (Exception e) {
				//System.out.println(e);
				logger.error(e);
			}
			
		}
		orderstageDBAdapter.close();
		return distinctCompanyList; 
	}
	
	public ArrayList<OrderStageActionForm> getActiveStagesForSpecificCompany(int companyid) throws SQLException{
		orderstageDBAdapter.open();
		ArrayList<OrderStageActionForm> list = new ArrayList<OrderStageActionForm>();
		if(orderstageDBAdapter.getActiveStagesForSpecificCompany(companyid).next()){
			ResultSet rs = orderstageDBAdapter.getActiveStagesForSpecificCompany(companyid);
			while(rs.next()){
				list.add(fetchDataFromResultSet(rs));
			}
		}
		orderstageDBAdapter.close();
		return list;
		
	}
	

}
