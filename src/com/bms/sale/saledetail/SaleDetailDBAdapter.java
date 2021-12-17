package com.bms.sale.saledetail;

import com.bms.db.RestoserverDBAdapter;
import com.bms.constants.Constants;
import com.bms.db.ContentValues;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SaleDetailDBAdapter extends RestoserverDBAdapter{
	public static final String SALEDETAIL_TABLE_NAME = "sale_detail";
	
	public static final String SALEDETAIL_SALEDETAILID = "saledetailid";
	public static final String SALEDETAIL_ITEMID = "itemid";
	public static final String SALEDETAIL_QUANTITY = "quantity";
	public static final String SALEDETAIL_RATE = "rate";
	public static final String SALEDETAIL_AMOUNT = "amount";
	public static final String SALEDETAIL_SALEMASTERID = "salemasterid";
	
	SaleDetailDBAdapter(){
		super();
	}
	
	public int insertDetails(SaleDetailActionForm saleDetailBean){
		ContentValues cv = new ContentValues();
		cv.put(SALEDETAIL_SALEDETAILID, saleDetailBean.getSaledetailid());
		cv.put(SALEDETAIL_ITEMID, saleDetailBean.getItemid());
		cv.put(SALEDETAIL_QUANTITY, saleDetailBean.getQuantity());
		cv.put(SALEDETAIL_RATE, saleDetailBean.getRate());
		cv.put(SALEDETAIL_AMOUNT, saleDetailBean.getAmount());
		cv.put(SALEDETAIL_SALEMASTERID, saleDetailBean.getSalemasterid());
		return (int)insert(SALEDETAIL_TABLE_NAME, null, cv);
	}
	
	public int updateDetails(SaleDetailActionForm saleDetailBean){
		ContentValues cv = new ContentValues();
		cv.put(SALEDETAIL_SALEDETAILID, saleDetailBean.getSaledetailid());
		cv.put(SALEDETAIL_ITEMID, saleDetailBean.getItemid());
		cv.put(SALEDETAIL_QUANTITY, saleDetailBean.getQuantity());
		cv.put(SALEDETAIL_RATE, saleDetailBean.getRate());
		cv.put(SALEDETAIL_AMOUNT, saleDetailBean.getAmount());
		cv.put(SALEDETAIL_SALEMASTERID, saleDetailBean.getSalemasterid());
		return update(SALEDETAIL_TABLE_NAME, cv, SALEDETAIL_SALEDETAILID+"="+saleDetailBean.getSaledetailid(), null);
	}
	
	public ResultSet getAllDetails(){
		return query(SALEDETAIL_TABLE_NAME, null, null, null, null, null, null);
	}
	
	public ResultSet getDetailsByDetailId(int saledetailid){
		String sql = "select * from "+Constants.DBNAME+"."+SALEDETAIL_TABLE_NAME+" where "+SALEDETAIL_SALEDETAILID+"=?";
		try{
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, saledetailid);
		return pstmt.executeQuery();
		}catch(SQLException sqle){
			System.out.println(sqle);
		}
		return null;
	}
	
	public ResultSet getDetailsBySaleMasterId(int salemasterid){
		String sql = "select * from "+Constants.DBNAME+"."+SALEDETAIL_TABLE_NAME+" where "+SALEDETAIL_SALEMASTERID+"=?";
		try{
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, salemasterid);
		return pstmt.executeQuery();
		}catch(SQLException sqle){
			System.out.println(sqle);
		}
		return null;
	}
		
	
}
