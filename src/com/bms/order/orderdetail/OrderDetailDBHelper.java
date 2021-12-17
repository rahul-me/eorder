package com.bms.order.orderdetail;

import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.bms.order.orderdetail.OrderDetailActionForm;
import com.bms.order.orderdetail.OrderDetailDBAdapter;

public class OrderDetailDBHelper {

	//private static final String TAG= "com.bms.stock.orderdetail.orderDetailDBHelper";
	private static final String TAG= "com.bms.order.orderdetail.OrderDetailDBHelper";
	private Logger logger = Logger.getLogger(TAG);
	private OrderDetailDBAdapter orderDetailDBAdapter;
	public OrderDetailDBHelper() {
		orderDetailDBAdapter=new OrderDetailDBAdapter();
	}
	
	
	public ArrayList<OrderDetailActionForm> fetchAllorderDetailDBAdapter(){
		orderDetailDBAdapter.open();
		ResultSet cursor=orderDetailDBAdapter.getAll();
		ArrayList<OrderDetailActionForm> orderDetailDBAdapterBeanList = new ArrayList<OrderDetailActionForm>();;
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				while(cursor.next()){
					orderDetailDBAdapterBeanList.add(fetchDataFromResultSet(cursor));
				}
				cursor.close();
			}
			catch (Exception e) {
				//System.out.println(e);
				logger.error(e);
			}
			
		}
		orderDetailDBAdapter.close();
		return orderDetailDBAdapterBeanList; 
	}
	
	public ArrayList<OrderDetailActionForm> fetchAllorderDetailByOrderMasterId(int orderDetailByMasterId){
		orderDetailDBAdapter.open();
		ResultSet cursor=orderDetailDBAdapter.getOrderDetailsByOrderMasterId(orderDetailByMasterId);
		ArrayList<OrderDetailActionForm> orderDetailDBAdapterBeanList = new ArrayList<OrderDetailActionForm>();;
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				while(cursor.next()){
					orderDetailDBAdapterBeanList.add(fetchDataFromResultSet(cursor));
				}
				cursor.close();
			}
			catch (Exception e) {
				//System.out.println(e);
				logger.error(e);
			}
			
		}
		orderDetailDBAdapter.close();
		return orderDetailDBAdapterBeanList; 
	}
	
	public OrderDetailActionForm getOrderByorderDetailDBAdapterId(int orderDetailDBAdapterId){
		orderDetailDBAdapter.open();
		ResultSet cursor=orderDetailDBAdapter.getByOrderDetailId(orderDetailDBAdapterId);
		OrderDetailActionForm orderDetailDBAdapterBean = null;
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				if(cursor.next()){
					orderDetailDBAdapterBean = fetchDataFromResultSet(cursor);
				}
				cursor.close();
			}
			catch (Exception e) {
				logger.error(e);
			}
		}
		orderDetailDBAdapter.close();
		return orderDetailDBAdapterBean;	
	}
	
	
	
	public OrderDetailActionForm getOrderByorderMasterId(int orderMasterId){
		orderDetailDBAdapter.open();
		ResultSet cursor=orderDetailDBAdapter.getOrderDetailsByOrderMasterId(orderMasterId);
		OrderDetailActionForm orderDetailDBAdapterBean = null;
		if(cursor!=null){
			try
			{
				cursor.beforeFirst();
				if(cursor.next()){
					orderDetailDBAdapterBean = fetchDataFromResultSet(cursor);
				}
				cursor.close();
			}
			catch (Exception e) {
				logger.error(e);
			}
		}
		orderDetailDBAdapter.close();
		return orderDetailDBAdapterBean;	
	}
	
	
	public int addorderDetailDBAdapter(OrderDetailActionForm orderDetailDBAdapterBean)
	{   
		orderDetailDBAdapter.open();
		int status = orderDetailDBAdapter.insertOrderDetail(orderDetailDBAdapterBean);
		orderDetailDBAdapter.close();
		
		return status;
	}
	
	
	public boolean deleteorderDetailDBAdapterById(int orderDetailDBAdapterId)
	{
		orderDetailDBAdapter.open();
		boolean status = orderDetailDBAdapter.deactiavteOrderDetail(orderDetailDBAdapterId);
		orderDetailDBAdapter.close();
		return status;
	}
	
	
	
	
	public int updateorderDetailDBAdapter(OrderDetailActionForm orderDetailDBAdapterBean){
		orderDetailDBAdapter.open();
		int result = orderDetailDBAdapter.update(orderDetailDBAdapterBean);
		orderDetailDBAdapter.close();
		return result;
	}
	
	private OrderDetailActionForm fetchDataFromResultSet(ResultSet cursor){ 
		OrderDetailActionForm orderDetailDBAdapterBean=new OrderDetailActionForm();
		try
		{
			orderDetailDBAdapterBean.setOrderDetailId(cursor.getInt(OrderDetailDBAdapter.KEY_ORDER_DETAIL_ORDER_DETAIL_ID));
			orderDetailDBAdapterBean.setDescription(cursor.getString(OrderDetailDBAdapter.KEY_ORDER_DETAIL_DESCRIPTION));
			orderDetailDBAdapterBean.setItemMasterId(cursor.getInt(OrderDetailDBAdapter.KEY_ORDER_DETAIL_ITEM_MASTER_ID));
			orderDetailDBAdapterBean.setQuantity(cursor.getFloat(OrderDetailDBAdapter.KEY_ORDER_DETAIL_QUANTITY));
			orderDetailDBAdapterBean.setRate(cursor.getFloat(OrderDetailDBAdapter.KEY_ORDER_DETAIL_RATE));
			orderDetailDBAdapterBean.setAmount(cursor.getFloat(OrderDetailDBAdapter.KEY_ORDER_DETAIL_AMOUNT));
			orderDetailDBAdapterBean.setOrderMasterId(cursor.getInt(OrderDetailDBAdapter.KEY_ORDER_DETAIL_ORDER_MASTER_ID));			
			orderDetailDBAdapterBean.setDispatchedQuantity(cursor.getFloat(OrderDetailDBAdapter.KEY_ORDER_DETAIL_DISPATCHED_QUANTITY));
		}
		catch(Exception e)
		{
			logger.error(e);
		}
		return orderDetailDBAdapterBean;
	}

public ArrayList<OrderDetailActionForm> getOrderDetailsListByOrderDetailId(int stockTakeMasterId)
{
	OrderDetailActionForm orderDetailDBAdapterBean=new OrderDetailActionForm();
	orderDetailDBAdapter.open();
 ArrayList<OrderDetailActionForm> stockTakeItemList=new ArrayList<OrderDetailActionForm>();
  ResultSet rs=  orderDetailDBAdapter.getOrderDetailsByOrderDetailId(stockTakeMasterId);
  if(rs!=null){
		try
		{
			rs.beforeFirst();
			while(rs.next()){
				orderDetailDBAdapterBean = fetchDataFromResultSet(rs);
				stockTakeItemList.add(orderDetailDBAdapterBean);
			}
			rs.close();
		}
		catch (Exception e) {
			logger.error(e);
		}
	}
    
  orderDetailDBAdapter.close();
 return stockTakeItemList;
}


public ArrayList<OrderDetailActionForm> getOrderDetailsListByOrderMasterId(int orderMasterId)
{
	OrderDetailActionForm orderDetailDBAdapterBean=new OrderDetailActionForm();
	orderDetailDBAdapter.open();
 ArrayList<OrderDetailActionForm> orderTakeItemList=new ArrayList<OrderDetailActionForm>();
  ResultSet rs=  orderDetailDBAdapter.getOrderDetailsByOrderMasterId(orderMasterId);
  if(rs!=null){
		try
		{
			rs.beforeFirst();
			while(rs.next()){
				orderDetailDBAdapterBean = fetchDataFromResultSet(rs);
				orderTakeItemList.add(orderDetailDBAdapterBean);
			}
			rs.close();
		}
		catch (Exception e) {
			logger.error(e);
		}
	}
    
  orderDetailDBAdapter.close();
 return orderTakeItemList;
}


}
