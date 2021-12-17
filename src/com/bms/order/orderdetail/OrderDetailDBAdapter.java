package com.bms.order.orderdetail;

import java.sql.ResultSet;

import org.apache.log4j.Logger;

import com.bms.db.ContentValues;
import com.bms.db.RestoserverDBAdapter;
import com.bms.order.orderdetail.OrderDetailActionForm;


/**
 * StockTakeDBAdapter manages the stocktakein the database. Responsible for 
 * all CRUD operations on the stocktakesummarytable.
 * @author Deepam Parmar
 *
 */


public class OrderDetailDBAdapter extends RestoserverDBAdapter {
	


	private final String TAG = "com.bms.order.orderdetail.OrderDetailDBAdapter";
	private final Logger log = Logger.getLogger(TAG);
	
	public static final String KEY_ORDER_DETAIL_TABLE_NAME="order_orderdetail";
	
	public static final String KEY_ORDER_DETAIL_ORDER_DETAIL_ID="orderDetailId";
	public static final String KEY_ORDER_DETAIL_ITEM_MASTER_ID="itemMasterId";
	public static final String KEY_ORDER_DETAIL_DESCRIPTION="description";
	public static final String KEY_ORDER_DETAIL_QUANTITY="quantity";
	public static final String KEY_ORDER_DETAIL_RATE="rate";
	public static final String KEY_ORDER_DETAIL_AMOUNT="amount";
	public static final String KEY_ORDER_DETAIL_ORDER_MASTER_ID="orderMasterId";
	public static final String KEY_ORDER_DETAIL_DISPATCHED_QUANTITY="dispatchedQuantity";
	
	
	 public OrderDetailDBAdapter() {
		 super();
	}
	 	/**
		 *insertStockSummay will insert data in to stocksummary table 
		 * 
		 * 
		 * 
		 * @param  OrderDetailActionForm 
		 * @return cVAlue object if success 
		 */
	
		public int insertOrderDetail(OrderDetailActionForm  OrderDetailActionForm)
		
		{	
			ContentValues cValues = new ContentValues();
			//cValues.put(KEY_ORDER_DETAIL_ORDER_DETAIL_ID,  OrderDetailActionForm.getOrderDetailId());
			cValues.put(KEY_ORDER_DETAIL_ITEM_MASTER_ID,  OrderDetailActionForm.getItemMasterId());
			cValues.put(KEY_ORDER_DETAIL_DESCRIPTION,  OrderDetailActionForm.getDescription());
			cValues.put(KEY_ORDER_DETAIL_QUANTITY,  OrderDetailActionForm.getQuantity());
			cValues.put(KEY_ORDER_DETAIL_RATE,  OrderDetailActionForm.getRate());
			cValues.put(KEY_ORDER_DETAIL_AMOUNT,  OrderDetailActionForm.getAmount());
			cValues.put(KEY_ORDER_DETAIL_ORDER_MASTER_ID,  OrderDetailActionForm.getOrderMasterId());
			cValues.put(KEY_ORDER_DETAIL_DISPATCHED_QUANTITY, OrderDetailActionForm.getDispatchedQuantity());
		
			return (int)insert(KEY_ORDER_DETAIL_TABLE_NAME, null, cValues);
			
		}
	 
		/**
		 *get all will return all record of stocksummary table
		 * 
		 * 
		 * 
		 * 
		 */
		
		public ResultSet getAll()
		{
			return query(KEY_ORDER_DETAIL_TABLE_NAME, null, null, null, null, null, null);		
		}
		
		
		/**
		 *getByStockTakeId  will return single record of stocksummary table
		 * 
		 * @param stockSummaryId
		 * @return resultset
		 * 
		 */
		
			
		
		public ResultSet getByOrderDetailId(int stocktaleDetailId)
		{
			return query(KEY_ORDER_DETAIL_TABLE_NAME, null, KEY_ORDER_DETAIL_ORDER_DETAIL_ID+ "=" + stocktaleDetailId, null, null, null, null);
		}
		
	
		
		
		public ResultSet getOrderDetailsByOrderMasterId(int orderMasterId)
		{
			return query(KEY_ORDER_DETAIL_TABLE_NAME, null, KEY_ORDER_DETAIL_ORDER_MASTER_ID+ "=" + orderMasterId, null, null, null, null);
		}
		/**
		 *deactivateStockSummay  will unset particular StockTake of stocksummary table
		 * 
		 * @param stockSummayId
		 * @return true/false
		 * 
		 */
			
		

		public boolean deactiavteOrderDetail(long stockTakeMasterId) {

			return delete(KEY_ORDER_DETAIL_TABLE_NAME, KEY_ORDER_DETAIL_ORDER_DETAIL_ID+ "=" + stockTakeMasterId, null) > 0;
		}

		
		/**
		 *update will update stockSummary of stocksummary table
		 * 
		 * @param  OrderDetailActionForm
		 * @return resultset
		 * 
		 */
			
		
		public int update(OrderDetailActionForm OrderDetailActionForm ){

			int result = 0;
			ContentValues	cValues=new ContentValues();
		//	cValues.put(KEY_ORDER_DETAIL_ORDER_DETAIL_ID,  OrderDetailActionForm.getOrderDetailId());
			cValues.put(KEY_ORDER_DETAIL_ITEM_MASTER_ID,  OrderDetailActionForm.getItemMasterId());
			cValues.put(KEY_ORDER_DETAIL_DESCRIPTION,  OrderDetailActionForm.getDescription());
			cValues.put(KEY_ORDER_DETAIL_QUANTITY,  OrderDetailActionForm.getQuantity());
			cValues.put(KEY_ORDER_DETAIL_RATE,  OrderDetailActionForm.getRate());
			cValues.put(KEY_ORDER_DETAIL_AMOUNT,  OrderDetailActionForm.getAmount());
			cValues.put(KEY_ORDER_DETAIL_ORDER_MASTER_ID,  OrderDetailActionForm.getOrderMasterId());
			cValues.put(KEY_ORDER_DETAIL_DISPATCHED_QUANTITY, OrderDetailActionForm.getDispatchedQuantity());
			
			result = update(KEY_ORDER_DETAIL_TABLE_NAME, cValues, KEY_ORDER_DETAIL_ORDER_DETAIL_ID+ "='" + OrderDetailActionForm.getOrderDetailId()+"'", null);
			return result;
		}
		
	public ResultSet getOrderDetailsByOrderDetailId(int stockTakemasterId)
	{
		return query(KEY_ORDER_DETAIL_TABLE_NAME, null, KEY_ORDER_DETAIL_ORDER_DETAIL_ID+ "=" + stockTakemasterId, null, null, null, null);
	
	}
	
	
}