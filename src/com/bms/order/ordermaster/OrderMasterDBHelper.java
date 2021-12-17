package com.bms.order.ordermaster;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;

public class OrderMasterDBHelper {

	private static final String TAG= "com.bms.order.ordermaster.OrderMasterDBHelper";
	private Logger logger = Logger.getLogger(TAG);
	private OrderMasterDBAdapter orderMasterDBAdapter;
	public OrderMasterDBHelper() {
		orderMasterDBAdapter=new OrderMasterDBAdapter();
	}
	
	
	public ArrayList<OrderMasterActionForm> fetchAll(){
		orderMasterDBAdapter.open();
		ResultSet cursor=orderMasterDBAdapter.getAll();
		ArrayList<OrderMasterActionForm> orderMasterDBAdapterBeanList = new ArrayList<OrderMasterActionForm>();;
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				while(cursor.next()){
					orderMasterDBAdapterBeanList.add(fetchDataFromResultSet(cursor));
				}
				cursor.close();
			}
			catch (Exception e) {
				//System.out.println(e);
				logger.error(e);
			}
			
		}
		orderMasterDBAdapter.close();
		return orderMasterDBAdapterBeanList; 
	}
	
	public ArrayList<OrderMasterActionForm> fetchAllOrderMasterByFilter(HashMap<String, String > filterorder){
		
		
		Set<String> keySet = filterorder.keySet();
		Iterator<String > keySetIterator= keySet.iterator();
		
		String whereClause="";
		while(keySetIterator.hasNext())
		{
			//String current = iterator.next();
			String tempKey = keySetIterator.next();
		
			if(!tempKey.equalsIgnoreCase("createdDate")){
					whereClause += " " + tempKey + " in("+  filterorder.get(tempKey)   + ") "; 
					System.out.println("mm1" +filterorder.get(tempKey));
				
					if (keySetIterator.hasNext()) {
						whereClause += " AND ";
					}
				}
			else
			{
				
				whereClause +=filterorder.get(tempKey); 
				if (keySetIterator.hasNext()) {
					whereClause += " AND ";
				}
			}
				
			
		}
		//this is added for disable record not display on list
		//whereClause=whereClause+" And " + orderMasterDBAdapter.KEY_STOCK_TAKE_STATUS + " not in(" + Constants.STOCK_TAKE_DISABLED + ")";
				
		System.out.println("Query "+whereClause);
		
		orderMasterDBAdapter.open();
		ResultSet cursor=orderMasterDBAdapter.getAllByFilter(whereClause);
		ArrayList<OrderMasterActionForm> orderMasterDBAdapterBeanList = new ArrayList<OrderMasterActionForm>();
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				while(cursor.next()){
					orderMasterDBAdapterBeanList.add(fetchDataFromResultSet(cursor));
				}
				cursor.close();
			}
			catch (Exception e) {
				//System.out.println(e);
				logger.error(e);
			}
			
		}
		orderMasterDBAdapter.close();
		return orderMasterDBAdapterBeanList; 
	}
	
	
	public OrderMasterActionForm getOrderByMasterId(int orderMasterDBAdapterId){
		orderMasterDBAdapter.open();
		ResultSet cursor=orderMasterDBAdapter.getByOrderMasterId(orderMasterDBAdapterId);
		OrderMasterActionForm orderMasterDBAdapterBean = null;
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				if(cursor.next()){
					orderMasterDBAdapterBean = fetchDataFromResultSet(cursor);
				}
				cursor.close();
			}
			catch (Exception e) {
				logger.error(e);
			}
		}
		orderMasterDBAdapter.close();
		return orderMasterDBAdapterBean;
	}
	
	public ArrayList<OrderMasterActionForm> getOrderByCompanyId(int compid){
		orderMasterDBAdapter.open();
		ResultSet cursor=orderMasterDBAdapter.getOrderByCompanyMasterId(compid);
		ArrayList<OrderMasterActionForm> orderMasterDBAdapterBeanList = new ArrayList<OrderMasterActionForm>();;
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				while(cursor.next()){
					orderMasterDBAdapterBeanList.add(fetchDataFromResultSet(cursor));
				}
				cursor.close();
			}
			catch (Exception e) {
				//System.out.println(e);
				logger.error(e);
			}
			
		}
		orderMasterDBAdapter.close();
		return orderMasterDBAdapterBeanList; 
	}
	
	public ArrayList<OrderMasterActionForm> getOrderByState(int stateid){
		orderMasterDBAdapter.open();
		ResultSet cursor=orderMasterDBAdapter.getOrderByState(stateid);
		ArrayList<OrderMasterActionForm> orderMasterDBAdapterBeanList = new ArrayList<OrderMasterActionForm>();;
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				while(cursor.next()){
					orderMasterDBAdapterBeanList.add(fetchDataFromResultSet(cursor));
				}
				cursor.close();
			}
			catch (Exception e) {
				//System.out.println(e);
				logger.error(e);
			}
			
		}
		orderMasterDBAdapter.close();
		return orderMasterDBAdapterBeanList; 
	}
	
	public ArrayList<OrderMasterActionForm> getByUserMasterIdAndOrderDate(String date){
		orderMasterDBAdapter.open();
		ResultSet cursor=orderMasterDBAdapter.getByUserMasterIdAndOrderDate(date);
		ArrayList<OrderMasterActionForm> orderMasterDBAdapterBeanList = new ArrayList<OrderMasterActionForm>();;
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				while(cursor.next()){
					orderMasterDBAdapterBeanList.add(fetchDataFromResultSet(cursor));
				}
				cursor.close();
			}
			catch (Exception e) {
				//System.out.println(e);
				logger.error(e);
			}
			
		}
		orderMasterDBAdapter.close();
		return orderMasterDBAdapterBeanList; 
	}
	
	
	
	
	public OrderMasterActionForm getOrderByOrderNumber(long orderNumber){
		orderMasterDBAdapter.open();
		ResultSet cursor=orderMasterDBAdapter.getByOrderNumber(orderNumber);
		OrderMasterActionForm orderMasterDBAdapterBean = null;
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				if(cursor.next()){
					orderMasterDBAdapterBean = fetchDataFromResultSet(cursor);
				}
				cursor.close();
			}
			catch (Exception e) {
				logger.error(e);
			}
		}
		orderMasterDBAdapter.close();
		return orderMasterDBAdapterBean;
	}
	
	/*public OrderMasterActionForm getLastOrderByCustomerMasterId(int customerMasterId){
		orderMasterDBAdapter.open();
		ResultSet cursor=orderMasterDBAdapter.getByLastOrderByCustomerMasterId(customerMasterId);
		OrderMasterActionForm orderMasterDBAdapterBean = null;
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				if(cursor.next()){
					orderMasterDBAdapterBean = fetchDataFromResultSet(cursor);
				}
				cursor.close();
			}
			catch (Exception e) {
				logger.error(e);
			}
		}
		orderMasterDBAdapter.close();
		return orderMasterDBAdapterBean;
	}*/
	
	
	public int addOrderMaster(OrderMasterActionForm orderMasterDBAdapterBean)
	{   
		orderMasterDBAdapter.open();
		int status = orderMasterDBAdapter.insertOrder(orderMasterDBAdapterBean);
		orderMasterDBAdapter.close();
		
		return status;
	}
	
	
	public boolean deleteOrderMasterById(int orderMasterDBAdapterId)
	{
		orderMasterDBAdapter.open();
		boolean status = orderMasterDBAdapter.deactiavteOrderMaster(orderMasterDBAdapterId);
		orderMasterDBAdapter.close();
		return status;
	}
	
	
	
	
	public int updateOrderMaster(OrderMasterActionForm orderMasterDBAdapterBean){
		orderMasterDBAdapter.open();
		int result = orderMasterDBAdapter.update(orderMasterDBAdapterBean);
		orderMasterDBAdapter.close();
		return result;
	}
	public int updateOrder(OrderMasterActionForm orderMasterDBAdapterBean){
		orderMasterDBAdapter.open();
		int result = orderMasterDBAdapter.update(orderMasterDBAdapterBean);
		orderMasterDBAdapter.close();
		return result;
	}
	
	public int updateOrderStatus(OrderMasterActionForm orderMasterDBAdapterBean){
		orderMasterDBAdapter.open();
		int result = orderMasterDBAdapter.updateOrderStatus(orderMasterDBAdapterBean);
		orderMasterDBAdapter.close();
		return result;
	}
	

	private OrderMasterActionForm fetchDataFromResultSet(ResultSet cursor){ 
		OrderMasterActionForm orderMasterDBAdapterBean=new OrderMasterActionForm();
	
		try
		{
			orderMasterDBAdapterBean.setOrderMasterId(cursor.getInt(OrderMasterDBAdapter.KEY_ORDER_MASTER_MASTER_ID));
			orderMasterDBAdapterBean.setOrderNumber(cursor.getString(OrderMasterDBAdapter.KEY_ORDER_MASTER_ORDER_NUMBER));
			orderMasterDBAdapterBean.setState(cursor.getInt(OrderMasterDBAdapter.KEY_ORDER_MASTER_STATE));
			orderMasterDBAdapterBean.setTotal(cursor.getFloat(OrderMasterDBAdapter.KEY_ORDER_MASTER_TOTAL));
			orderMasterDBAdapterBean.setRemark(cursor.getString(OrderMasterDBAdapter.KEY_ORDER_MASTER_REMARK));
			orderMasterDBAdapterBean.setCreatedDate(cursor.getString(OrderMasterDBAdapter.KEY_ORDER_MASTER_CREATED_DATE));
			orderMasterDBAdapterBean.setCreatedDTTM(cursor.getString(OrderMasterDBAdapter.KEY_ORDER_MASTER_CREATED_DTTM));
			orderMasterDBAdapterBean.setCreatedBy(cursor.getInt(OrderMasterDBAdapter.KEY_ORDER_MASTER_CREATED_BY));
			orderMasterDBAdapterBean.setModifiedBy(cursor.getInt(OrderMasterDBAdapter.KEY_ORDER_MASTER_MODIFIED_BY));
			orderMasterDBAdapterBean.setIsClose(cursor.getInt(OrderMasterDBAdapter.KEY_ORDER_MASTER_IS_CLOSE));
			orderMasterDBAdapterBean.setCloseBy(cursor.getInt(OrderMasterDBAdapter.KEY_ORDER_MASTER_CLOSE_BY));
			orderMasterDBAdapterBean.setModifiedDTTM(cursor.getString(OrderMasterDBAdapter.KEY_ORDER_MASTER_MODIFIED_DTTM));
			orderMasterDBAdapterBean.setClosedDTTM(cursor.getString(OrderMasterDBAdapter.KEY_ORDER_MASTER_CLOSED_DTTM));
			orderMasterDBAdapterBean.setIsActive(cursor.getInt(OrderMasterDBAdapter.KEY_ORDER_MASTER_IS_ACTIVE));
			orderMasterDBAdapterBean.setUserMasterId(cursor.getInt(OrderMasterDBAdapter.KEY_ORDER_MASTER_USERMASTERID));
			orderMasterDBAdapterBean.setCompanyMasterId(cursor.getInt(OrderMasterDBAdapter.KEY_ORDER_MASTER_COMPANY_MASTER_ID));
			orderMasterDBAdapterBean.setOrderQuantity(cursor.getInt(OrderMasterDBAdapter.KEY_ORDER_MASTER_ORDER_QUANTITY));
			orderMasterDBAdapterBean.setDispatchedQuantity(cursor.getFloat(OrderMasterDBAdapter.KEY_ORDER_MASTER_DISPATCHEDQUANTITY));
		}
		catch(Exception e)
		{
			logger.error(e);
		}
		return orderMasterDBAdapterBean;
	}
	
	public int fetchOrder(String date,int compId,int userRoleId,int userId) throws SQLException
	{
		orderMasterDBAdapter.open();
		int valInt = 0;
		try
		{
			ResultSet cursor = orderMasterDBAdapter.getTodayOrder(date,compId,userRoleId,userId);
			if(cursor!= null)
			{	cursor.beforeFirst();
				while(cursor.next())
				{
					valInt = cursor.getInt(1);
				}
			}
			orderMasterDBAdapter.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return valInt;
	}
	
	public int fetchTotalAmount(String date,int compId,int userRoleId,int userId) throws SQLException
	{
		orderMasterDBAdapter.open();
		int valInt = 0;
		try
		{
			ResultSet cursor = orderMasterDBAdapter.getTotalAmount(date,compId,userRoleId,userId);
			if(cursor!= null)
			{	cursor.beforeFirst();
				while(cursor.next())
				{
					valInt = cursor.getInt(1);
				}
			}
			orderMasterDBAdapter.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return valInt;
	}
	
	public int fetchTotalItem(String date,int compId,int userRoleId,int userId) throws SQLException
	{
		orderMasterDBAdapter.open();
		int valInt = 0;
		try
		{
			ResultSet cursor = orderMasterDBAdapter.getTotalItem(date,compId,userRoleId,userId);
			if(cursor!= null)
			{	cursor.beforeFirst();
				while(cursor.next())
				{
					valInt = cursor.getInt(1);
				}
			}
			orderMasterDBAdapter.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return valInt;
	}
	
	public ArrayList<OrderMasterActionForm> getOrderMasterDataForGivenMonthAndYear(String month, String year, int companyid, int userid, boolean adminflag) throws SQLException{
		orderMasterDBAdapter.open();
		ArrayList<OrderMasterActionForm> list = new ArrayList<OrderMasterActionForm>();
		if(adminflag==true){
			if(orderMasterDBAdapter.getOrderMasterDataForGivenMonthAndYear(month, year, companyid).next()){
				ResultSet rs = orderMasterDBAdapter.getOrderMasterDataForGivenMonthAndYear(month, year, companyid);
				while(rs.next()){
					list.add(fetchDataFromResultSet(rs));
				}
			}
		}else{
			if(orderMasterDBAdapter.getOrderMasterDataForGivenMonthAndYear(month, year, companyid, userid).next()){
				ResultSet rs = orderMasterDBAdapter.getOrderMasterDataForGivenMonthAndYear(month, year, companyid, userid);
				while(rs.next()){
					list.add(fetchDataFromResultSet(rs));
				}
			}
		}
		
		orderMasterDBAdapter.close();
		return list;
	}
	
	public ArrayList<OrderMasterActionForm> getTotalOrderForSpecificPeriod(String fromdate, String todate, int companyid, int userid, boolean adminflag) throws SQLException{
		orderMasterDBAdapter.open();
		ArrayList<OrderMasterActionForm> list = new ArrayList<OrderMasterActionForm>();
		ResultSet rs = null;
		if(adminflag){
			rs = orderMasterDBAdapter.getTotalOrderForSpecificPeriod(fromdate, todate, companyid);
		}else{
			rs = orderMasterDBAdapter.getTotalOrderForSpecificPeriod(fromdate, todate, companyid, userid);
		}		
		while(rs.next()){
			list.add(fetchDataFromResultSet(rs));
		}
		orderMasterDBAdapter.close();
		return list;
	}
	
	public int getTotalItemsInOrderOfSpecificPeriod(String fromdate, String todate) throws SQLException{
		orderMasterDBAdapter.open();
		ResultSet rs = orderMasterDBAdapter.getTotalItemsInOrderOfSpecificPeriod(fromdate, todate);
		rs.next();
		int itemount = rs.getInt(1);
		orderMasterDBAdapter.close();
		return itemount;
		
	}

}
