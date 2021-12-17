package com.bms.retail;

import com.bms.constants.Constants;
import com.bms.db.ContentValues;
import com.bms.db.RestoserverDBAdapter;

import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RetailDBAdapter extends RestoserverDBAdapter {
	
	public final static String RETAIL_TABLE_NAME = "retail";
	
	public static final String RETAIL_COLUMN_RETAILMASTERID = "retailmasterid";
	public static final String RETAIL_COLUMN_RETAILID = "retailid";
	public static final String RETAIL_COLUMN_ITEMID = "itemid";
	public static final String RETAIL_COLUMN_COMPANYMASTERID = "companymasterid";
	public static final String RETAIL_COLUMN_ORDERQUANTITY = "orderedquantity";
	public static final String RETAIL_COLUMN_DELIVEREDQUANTITY = "deliveredquantity";
	public static final String RETAIL_COLUMN_SALEQUANTITY = "salequantity";
	public final static String RETAIL_COLUMN_RETURNQUANTITY = "returnquantity";
				
	public RetailDBAdapter(){
		super();
	}
	
	public int insertRetail(RetailActionForm retailBean){
		ContentValues cv = new ContentValues();
		cv.put(RETAIL_COLUMN_RETAILID, retailBean.getRetailid());
		cv.put(RETAIL_COLUMN_ITEMID, retailBean.getItemid());
		cv.put(RETAIL_COLUMN_COMPANYMASTERID, retailBean.getCompanymasterid());
		cv.put(RETAIL_COLUMN_ORDERQUANTITY, retailBean.getOrderquantity());
		cv.put(RETAIL_COLUMN_DELIVEREDQUANTITY, retailBean.getDeliveredquantity());
		cv.put(RETAIL_COLUMN_SALEQUANTITY, retailBean.getSalequantity());
		cv.put(RETAIL_COLUMN_RETURNQUANTITY, retailBean.getReturnquantity());
		return (int)insert(RETAIL_TABLE_NAME, null, cv);
	}
	
	public int updateRetail(RetailActionForm retailBean){
		ContentValues cv = new ContentValues();
		cv.put(RETAIL_COLUMN_RETAILID, retailBean.getRetailid());
		cv.put(RETAIL_COLUMN_ITEMID, retailBean.getItemid());
		cv.put(RETAIL_COLUMN_COMPANYMASTERID, retailBean.getCompanymasterid());
		cv.put(RETAIL_COLUMN_ORDERQUANTITY, retailBean.getOrderquantity());
		cv.put(RETAIL_COLUMN_DELIVEREDQUANTITY, retailBean.getDeliveredquantity());
		cv.put(RETAIL_COLUMN_SALEQUANTITY, retailBean.getSalequantity());
		cv.put(RETAIL_COLUMN_RETURNQUANTITY, retailBean.getReturnquantity());
		return (int)update(RETAIL_TABLE_NAME, cv, RETAIL_COLUMN_RETAILMASTERID+"="+retailBean.getRetailmasterid(), null);
	}
	
	public ResultSet getAllRetailDetails(){
		return query(RETAIL_TABLE_NAME, null, null, null, null, null, null);
	}
	
	public ResultSet checkAvailableItemForRetailer(int retailid, int itemid){
		String sql = "SELECT * FROM "+Constants.DBNAME+"."+RETAIL_TABLE_NAME+" where "+RETAIL_COLUMN_RETAILID+"=? AND "+RETAIL_COLUMN_ITEMID+"=?";
		try{
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, retailid);
		pstmt.setInt(2, itemid);
		return pstmt.executeQuery();
		}catch(SQLException sqle){
			System.out.println(sqle);
		}
		return null;
	}
	
	public int updateOrderQuantityForRetailerItem(int retailid, int itemid, float orderquantity){
		String sql = "update "+Constants.DBNAME+"."+RETAIL_TABLE_NAME+" set "+RETAIL_COLUMN_ORDERQUANTITY+"="+RETAIL_COLUMN_ORDERQUANTITY+"+? where "+RETAIL_COLUMN_RETAILID+"=? AND "+RETAIL_COLUMN_ITEMID+"=?";
		try{
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setFloat(1, orderquantity);
		pstmt.setInt(2, retailid);
		pstmt.setInt(3, itemid);
		return pstmt.executeUpdate();
		}catch(SQLException sqle){
			System.out.println(sqle);
		}
		return -1;
	}
	
	public ResultSet getRetailDetailsByRetailerAndItem(int retailid, int itemid){
		String sql = "select * from "+Constants.DBNAME+"."+RETAIL_TABLE_NAME+" where "+RETAIL_COLUMN_RETAILID+"=? and "+RETAIL_COLUMN_ITEMID+"=?";
		try{
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, retailid);
			pstmt.setInt(2, itemid);
			return pstmt.executeQuery();
		}catch(SQLException sqle){
			System.out.println(sqle);
		}
		return null;
	}
	
	public ResultSet getItemsOfRetailer(int retailid){
		//String sql = "select * from "+RETAIL_TABLE_NAME+","+MDM_ITEM_TABLE_NAME+" where "+RETAIL_TABLE_NAME+"."+RETAIL_COLUMN_ITEMID+"="+MDM_ITEM_TABLE_NAME+"."+COLUMN_ITEM_MASTER_ID+" AND "+RETAIL_COLUMN_RETAILID+"=?";
		try{
		CallableStatement cs = connection.prepareCall("call getItemsOfRetailer(?)");
		cs.setInt(1, retailid);
		boolean result = cs.execute();
		if(result == true){
			return cs.getResultSet();
		}else{
			return null;
		}
		}catch(SQLException sqle){
			System.out.println(sqle);
		}
		return null;
	}

}
