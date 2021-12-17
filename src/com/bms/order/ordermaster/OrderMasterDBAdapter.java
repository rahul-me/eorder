package com.bms.order.ordermaster;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.bms.db.ContentValues;
import com.bms.db.RestoserverDBAdapter;
import com.bms.neetai.users.UserActionForm;
import com.mysql.jdbc.PreparedStatement;


/**
 * StockTakeDBAdapter manages the stocktakein the database. Responsible for 
 * all CRUD operations on the stocktakesummarytable.
 * @author Santosh Dubey
 *
 */


public class OrderMasterDBAdapter extends RestoserverDBAdapter {

	//private final String TAG = "com.bms.stock.ordermaster.orderMasterDBAdapter";
	
	private final String TAG = "com.bms.order.ordermaster.OrderMasterDBAdapter";
	private final Logger log = Logger.getLogger(TAG);
	
	public static final String KEY_ORDER_MASTER_TABLE_NAME="order_ordermaster";

	public static final String KEY_ORDER_MASTER_MASTER_ID="orderMasterId";
	public static final String KEY_ORDER_MASTER_ORDER_NUMBER="orderNumber";
	public static final String KEY_ORDER_MASTER_STATE="state";
	public static final String KEY_ORDER_MASTER_TOTAL="total";
	public static final String KEY_ORDER_MASTER_REMARK="remark";
	public static final String KEY_ORDER_MASTER_CREATED_DATE="createdDate";
	public static final String KEY_ORDER_MASTER_CREATED_DTTM="createdDTTM";
	public static final String KEY_ORDER_MASTER_CREATED_BY="createdBy";
	public static final String KEY_ORDER_MASTER_MODIFIED_BY="modifiedBy";
	public static final String KEY_ORDER_MASTER_IS_CLOSE="isClose";
	public static final String KEY_ORDER_MASTER_CLOSE_BY="closeBy";
	public static final String KEY_ORDER_MASTER_MODIFIED_DTTM="modifiedDTTM";
	public static final String KEY_ORDER_MASTER_CLOSED_DTTM="closedDTTM";
	public static final String KEY_ORDER_MASTER_IS_ACTIVE="isActive";
	public static final String KEY_ORDER_MASTER_USERMASTERID="userMasterId";
	public static final String KEY_ORDER_MASTER_COMPANY_MASTER_ID="companyMasterId";
	public static final String KEY_ORDER_MASTER_ORDER_QUANTITY="orderQuantity";
	public static final String KEY_ORDER_MASTER_DISPATCHEDQUANTITY="dispatchedQuantity";
	
	 public OrderMasterDBAdapter() {
		 super();
	}
	 

		/**
		 *insertStockSummay will insert data in to stocksummary table 
		 * 
		 * 
		 * 
		 * @param  OrderMasterActionForm 
		 * @return cVAlue object if success 
		 */

		public int insertOrder(OrderMasterActionForm  orderMasterActionForm)
		
		{	
			ContentValues cValues = new ContentValues();
			//cValues.put(KEY_ORDER_MASTER_ORDER_MASTER_ID,  orderMasterActionForm.getOrderMasterId());
						
			cValues.put(KEY_ORDER_MASTER_ORDER_NUMBER, orderMasterActionForm.getOrderNumber());
			cValues.put(KEY_ORDER_MASTER_STATE, orderMasterActionForm.getState());
			cValues.put(KEY_ORDER_MASTER_TOTAL, orderMasterActionForm.getTotal());
			cValues.put(KEY_ORDER_MASTER_REMARK, orderMasterActionForm.getRemark());
			cValues.put(KEY_ORDER_MASTER_CREATED_DATE, orderMasterActionForm.getCreatedDate());
			cValues.put(KEY_ORDER_MASTER_CREATED_DTTM, orderMasterActionForm.getCreatedDTTM());
			cValues.put(KEY_ORDER_MASTER_CREATED_BY, orderMasterActionForm.getCreatedBy());
			cValues.put(KEY_ORDER_MASTER_MODIFIED_BY, orderMasterActionForm.getModifiedBy());
			cValues.put(KEY_ORDER_MASTER_IS_CLOSE, orderMasterActionForm.getIsClose());
			cValues.put(KEY_ORDER_MASTER_CLOSE_BY, orderMasterActionForm.getCloseBy());
			cValues.put(KEY_ORDER_MASTER_MODIFIED_DTTM, orderMasterActionForm.getModifiedDTTM());
			cValues.put(KEY_ORDER_MASTER_CLOSED_DTTM, orderMasterActionForm.getClosedDTTM());
			cValues.put(KEY_ORDER_MASTER_IS_ACTIVE, orderMasterActionForm.getIsActive());
			cValues.put(KEY_ORDER_MASTER_COMPANY_MASTER_ID, orderMasterActionForm.getCompanyMasterId());
			cValues.put(KEY_ORDER_MASTER_USERMASTERID, orderMasterActionForm.getUserMasterId());
			cValues.put(KEY_ORDER_MASTER_ORDER_QUANTITY, orderMasterActionForm.getOrderQuantity());
			cValues.put(KEY_ORDER_MASTER_DISPATCHEDQUANTITY, orderMasterActionForm.getDispatchedQuantity());
			
			return (int)insert(KEY_ORDER_MASTER_TABLE_NAME, null, cValues);
			
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
			return query(KEY_ORDER_MASTER_TABLE_NAME, null, null, null, null, null, null);		
		}
		
		public ResultSet getAllByFilter(String Filter)
		{
			return query(KEY_ORDER_MASTER_TABLE_NAME, null, Filter, null, null, null, null);		
		}
		
		
		/**
		 *getByStockTakeId  will return single record of stocksummary table
		 * 
		 * @param stockSummaryId
		 * @return resultset
		 * 
		 */
		
		public ResultSet getByUserMasterIdAndOrderDate(String date)
		{
			char quotes ='"';
			String value =""+quotes+date+""+quotes+"";
			return query(KEY_ORDER_MASTER_TABLE_NAME, null, KEY_ORDER_MASTER_CREATED_DATE+ "=" +value,null,null, null,null );
		}	
		
		public ResultSet getByOrderMasterId(int stocktaleMasterId)
		{
			return query(KEY_ORDER_MASTER_TABLE_NAME, null, KEY_ORDER_MASTER_MASTER_ID+ "=" + stocktaleMasterId, null, null, null, null);
		}
		
		public ResultSet getOrderByCompanyMasterId(int compnayMasterId)
		{
			return query(KEY_ORDER_MASTER_TABLE_NAME, null, KEY_ORDER_MASTER_COMPANY_MASTER_ID+ "=" + compnayMasterId, null, null, null, null);
		}
		
		 
		public ResultSet getByOrderNumber(long orderNumber)
		{
			return query(KEY_ORDER_MASTER_TABLE_NAME, null, KEY_ORDER_MASTER_ORDER_NUMBER+ "=" + orderNumber, null, null, null, null);
		}
		
	/*	public ResultSet getByLastOrderByCustomerMasterId(int customerMasterId)
		{
			return query(KEY_ORDER_ORDER_MASTER_TABLE, null, KEY_ORDER_MASTER_CUSOMERMASTERID+ "=" + customerMasterId + " order by " + KEY_ORDER_MASTER_CREATEDDTTM + " desc limit 1", null, null, null, null);
		}*/
		/**
		 *deactivateStockSummay  will unset particular StockTake of stocksummary table
		 * 
		 * @param stockSummayId
		 * @return true/false
		 * 
		 */
			
		public ResultSet getOrderByState(int state)
		{
			return query(KEY_ORDER_MASTER_TABLE_NAME, null, KEY_ORDER_MASTER_STATE+ "=" + state, null, null, null, null);
		}
		

		public boolean deactiavteOrderMaster(long stocktaleMasterId) {

			return delete(KEY_ORDER_MASTER_TABLE_NAME, KEY_ORDER_MASTER_MASTER_ID+ "=" + stocktaleMasterId, null) > 0;
		}

		
		/**
		 *update will update stockSummary of stocksummary table
		 * 
		 * @param  OrderMasterActionForm
		 * @return resultset
		 * 
		 */
			
		
		public int update(OrderMasterActionForm orderMasterActionForm ){

			int result = 0;
			ContentValues	cValues=new ContentValues();
			cValues.put(KEY_ORDER_MASTER_ORDER_NUMBER, orderMasterActionForm.getOrderNumber());
			cValues.put(KEY_ORDER_MASTER_STATE, orderMasterActionForm.getState());
			cValues.put(KEY_ORDER_MASTER_TOTAL, orderMasterActionForm.getTotal());
			cValues.put(KEY_ORDER_MASTER_REMARK, orderMasterActionForm.getRemark());
			cValues.put(KEY_ORDER_MASTER_CREATED_DATE, orderMasterActionForm.getCreatedDate());
			cValues.put(KEY_ORDER_MASTER_CREATED_DTTM, orderMasterActionForm.getCreatedDTTM());
			cValues.put(KEY_ORDER_MASTER_CREATED_BY, orderMasterActionForm.getCreatedBy());
			cValues.put(KEY_ORDER_MASTER_MODIFIED_BY, orderMasterActionForm.getModifiedBy());
			cValues.put(KEY_ORDER_MASTER_IS_CLOSE, orderMasterActionForm.getIsClose());
			cValues.put(KEY_ORDER_MASTER_CLOSE_BY, orderMasterActionForm.getCloseBy());
			cValues.put(KEY_ORDER_MASTER_MODIFIED_DTTM, orderMasterActionForm.getModifiedDTTM());
			cValues.put(KEY_ORDER_MASTER_CLOSED_DTTM, orderMasterActionForm.getClosedDTTM());
			cValues.put(KEY_ORDER_MASTER_IS_ACTIVE, orderMasterActionForm.getIsActive());
			cValues.put(KEY_ORDER_MASTER_COMPANY_MASTER_ID, orderMasterActionForm.getCompanyMasterId());
			cValues.put(KEY_ORDER_MASTER_USERMASTERID, orderMasterActionForm.getUserMasterId());
			cValues.put(KEY_ORDER_MASTER_ORDER_QUANTITY, orderMasterActionForm.getOrderQuantity());
			cValues.put(KEY_ORDER_MASTER_DISPATCHEDQUANTITY, orderMasterActionForm.getDispatchedQuantity());
			result = update(KEY_ORDER_MASTER_TABLE_NAME, cValues, KEY_ORDER_MASTER_MASTER_ID + "='" + orderMasterActionForm.getOrderMasterId()+"'", null);
			return result;
		}
		
		public int updateOrderStatus(OrderMasterActionForm orderMasterActionForm ){

			int result = 0;
			ContentValues	cValues=new ContentValues();
			cValues.put(KEY_ORDER_MASTER_STATE, orderMasterActionForm.getState());
			cValues.put(KEY_ORDER_MASTER_MODIFIED_BY, orderMasterActionForm.getModifiedBy());
			cValues.put(KEY_ORDER_MASTER_MODIFIED_DTTM, orderMasterActionForm.getModifiedDTTM());
			result = update(KEY_ORDER_MASTER_TABLE_NAME, cValues, KEY_ORDER_MASTER_MASTER_ID + "='" + orderMasterActionForm.getOrderMasterId()+"'", null);
			return result;
		}
		
		public ResultSet getTodayOrder(String todayDate,int compId,int userRoleId,int userId) throws SQLException
		{
			//Statement stm = null;
			PreparedStatement ps1 = null ;
			ResultSet resultSet1 =null;
			Date date = null;
			String query1 =null;
			
			try 
			{
				DateFormat formateter = new SimpleDateFormat("yyyy-mm-dd");
				date = (Date) formateter.parse(todayDate);
				System.out.println(formateter.format(date));
				
				String userMasId="";
				
				if(userRoleId!=2){
					userMasId=" and userMasterId= "+userId;
				}
				
				
				query1 ="SELECT " +
						"count(order_ordermaster.orderMasterId) AS orderMasterId " +
						"FROM " +
						"orderingdb.order_ordermaster order_ordermaster " +
						"WHERE " +
						"createdDate='"+formateter.format(date)+"' and companyMasterId=" +compId+userMasId;
				System.out.println("Build Query is"+query1);
				
				ps1 = (PreparedStatement) connection.prepareStatement(query1);
			//	ps1.setDate(1,(java.sql.Date) date);
				resultSet1 = ps1.executeQuery(query1);
				return resultSet1;
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			//DBConnectionPool.getInstance().free(connection);
			return resultSet1;	
		}
		
		
		public ResultSet getTotalAmount(String todayDate,int compId,int userRoleId,int userId) throws SQLException
		{
			//Statement stm = null;
			PreparedStatement ps1 = null ;
			ResultSet resultSet1 =null;
			Date date = null;
			String query1 =null;
			
			try 
			{
				DateFormat formateter = new SimpleDateFormat("yyyy-mm-dd");
				date = (Date) formateter.parse(todayDate);
				
				System.out.println(formateter.format(date));
				String userMasId="";
				
				if(userRoleId!=2){
					userMasId=" and userMasterId= "+userId;
				}
				
				query1 =" SELECT" +
						" sum(order_ordermaster.total) AS totalAmt" +
						" FROM" +
						" orderingdb.order_ordermaster order_ordermaster " +
						" WHERE" +
						" createdDate = '"+formateter.format(date)+"' and companyMasterId=" +compId+userMasId;
				
				System.out.println("Build Query is"+query1);
				
				ps1 = (PreparedStatement) connection.prepareStatement(query1);
			//	ps1.setDate(1,(java.sql.Date) date);
				resultSet1 = ps1.executeQuery(query1);
				return resultSet1;
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			//DBConnectionPool.getInstance().free(connection);
			return resultSet1;	
		}
		
		public ResultSet getTotalItem(String todayDate,int compId,int userRoleId,int userId) throws SQLException
		{
			//Statement stm = null;
			PreparedStatement ps1 = null ;
			ResultSet resultSet1 =null;
			Date date = null;
			String query1 =null;
			
			try 
			{
				DateFormat formateter = new SimpleDateFormat("yyyy-mm-dd");
				date = (Date) formateter.parse(todayDate);
				
				System.out.println(formateter.format(date));
				String userMasId="";
				
				if(userRoleId!=2){
					userMasId=" and userMasterId= "+userId;
				}
				
				query1 ="SELECT " +
						"sum( order_orderdetail.quantity ) AS quantity " +
						"FROM " +
						"orderingdb.order_orderdetail order_orderdetail " +
						"INNER JOIN orderingdb.order_ordermaster order_ordermaster " +
						"ON order_orderdetail.orderMasterId = order_ordermaster.orderMasterId " +
						"WHERE " +
						"createdDate = '"+formateter.format(date)+"' and companyMasterId=" +compId+userMasId;
				
				System.out.println("Build Query is"+query1);
				
				ps1 = (PreparedStatement) connection.prepareStatement(query1);
			//	ps1.setDate(1,(java.sql.Date) date);
				resultSet1 = ps1.executeQuery(query1);
				return resultSet1;
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			//DBConnectionPool.getInstance().free(connection);
			return resultSet1;	
		}
		
		public ResultSet getOrderMasterDataForGivenMonthAndYear(String month, String year, int companyid) throws SQLException{
			String sql = "select * from "+KEY_ORDER_MASTER_TABLE_NAME+" where "+KEY_ORDER_MASTER_COMPANY_MASTER_ID+"="+companyid+" and "+KEY_ORDER_MASTER_CREATED_DATE+" between '"+year+"-"+month+"-01' and '"+year+"-"+month+"-31' group by "+KEY_ORDER_MASTER_TABLE_NAME+"."+KEY_ORDER_MASTER_MASTER_ID+" DESC";
			Statement stmt = connection.createStatement();
			return stmt.executeQuery(sql);
		}
		
		public ResultSet getOrderMasterDataForGivenMonthAndYear(String month, String year, int companyid, int userid) throws SQLException{
			String sql = "select * from "+KEY_ORDER_MASTER_TABLE_NAME+" where "+KEY_ORDER_MASTER_COMPANY_MASTER_ID+"="+companyid+" and "+KEY_ORDER_MASTER_USERMASTERID+"="+userid+" and "+KEY_ORDER_MASTER_CREATED_DATE+" between '"+year+"-"+month+"-01' and '"+year+"-"+month+"-31' group by "+KEY_ORDER_MASTER_TABLE_NAME+"."+KEY_ORDER_MASTER_MASTER_ID+" DESC";
			Statement stmt = connection.createStatement();
			return stmt.executeQuery(sql);
		}
		
		public ResultSet getTotalOrderForSpecificPeriod(String fromdate, String todate, int companyid) throws SQLException{
			String sql = "select * from "+KEY_ORDER_MASTER_TABLE_NAME+" where "+KEY_ORDER_MASTER_COMPANY_MASTER_ID+"="+companyid+" and "+KEY_ORDER_MASTER_CREATED_DATE+" between '"+fromdate+"' and '"+todate+"'";
			Statement stmt = connection.createStatement();
			return stmt.executeQuery(sql);
		}
		public ResultSet getTotalOrderForSpecificPeriod(String fromdate, String todate, int companyid, int userid) throws SQLException{
			String sql = "select * from "+KEY_ORDER_MASTER_TABLE_NAME+" where "+KEY_ORDER_MASTER_USERMASTERID+"="+userid+" and "+KEY_ORDER_MASTER_COMPANY_MASTER_ID+"="+companyid+" and "+KEY_ORDER_MASTER_CREATED_DATE+" between '"+fromdate+"' and '"+todate+"'";
			Statement stmt = connection.createStatement();
			return stmt.executeQuery(sql);
		}
		
		public ResultSet getTotalItemsInOrderOfSpecificPeriod(String fromdate, String todate) throws SQLException{
			String sql = "select count(distinct order_orderdetail.itemMasterId) from order_orderdetail,order_ordermaster where order_orderdetail.orderMasterId=order_ordermaster.orderMasterId and order_ordermaster.createdDate between '"+fromdate+"' and '"+todate+"'";
			Statement stmt = connection.createStatement();
			return stmt.executeQuery(sql);
		}
	 
}