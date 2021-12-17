package com.bms.sale.salemaster;

import com.bms.db.RestoserverDBAdapter;
import com.bms.constants.Constants;
import com.bms.db.ContentValues;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class SaleMasterDBAdapter extends RestoserverDBAdapter {
	
	public final static String SALEMASTER_TABLE_NAME = "sale_master";
	
	public final static String SALEMASTER_SALEMASTERID = "salemasterid";
	public final static String SALEMASTER_CREATEDDATE = "createdDate";
	public final static String SALEMASTER_COMPANYMASTERID = "companyMasterId";
	public final static String SALEMASTER_RETAILID = "retailid";
	public final static String SALEMASTER_ORDERQUANTITY = "orderquantity";
	public final static String SALEMASTER_DELIVEREDQUANTITY = "deliveredquantity";
	public final static String SALEMASTER_TOTAL = "total";
	public final static String SALEMASTER_CONSUMERNAME = "consumername";
	public final static String SALEMASTER_CONSUMERADDRESS = "consumeraddress";
	
	public SaleMasterDBAdapter(){
		super();
	}
	
	public int insertSaleMasterDetails(SaleMasterActionForm saleMasterBean){
		ContentValues cv = new ContentValues();
		cv.put(SALEMASTER_SALEMASTERID, saleMasterBean.getSalemasterid());
		cv.put(SALEMASTER_CREATEDDATE, saleMasterBean.getCreatedDate());
		cv.put(SALEMASTER_COMPANYMASTERID, saleMasterBean.getCompanyMasterId());
		cv.put(SALEMASTER_RETAILID, saleMasterBean.getRetailid());
		cv.put(SALEMASTER_ORDERQUANTITY, saleMasterBean.getOrderquantity());
		cv.put(SALEMASTER_DELIVEREDQUANTITY, saleMasterBean.getDeliveredquantity());
		cv.put(SALEMASTER_TOTAL, saleMasterBean.getTotal());
		cv.put(SALEMASTER_CONSUMERNAME, saleMasterBean.getConsumername());
		cv.put(SALEMASTER_CONSUMERADDRESS, saleMasterBean.getConsumeraddress());
		return (int)insert(SALEMASTER_TABLE_NAME, null, cv);
	}
	
	public int updateSaleMasterDetails(SaleMasterActionForm saleMasterBean){
		ContentValues cv = new ContentValues();
		cv.put(SALEMASTER_SALEMASTERID, saleMasterBean.getSalemasterid());
		cv.put(SALEMASTER_CREATEDDATE, saleMasterBean.getCreatedDate());
		cv.put(SALEMASTER_COMPANYMASTERID, saleMasterBean.getCompanyMasterId());
		cv.put(SALEMASTER_RETAILID, saleMasterBean.getRetailid());
		cv.put(SALEMASTER_ORDERQUANTITY, saleMasterBean.getOrderquantity());
		cv.put(SALEMASTER_DELIVEREDQUANTITY, saleMasterBean.getDeliveredquantity());
		cv.put(SALEMASTER_TOTAL, saleMasterBean.getTotal());
		cv.put(SALEMASTER_CONSUMERNAME, saleMasterBean.getConsumername());
		cv.put(SALEMASTER_CONSUMERADDRESS, saleMasterBean.getConsumeraddress());
		return update(SALEMASTER_TABLE_NAME, cv, SALEMASTER_SALEMASTERID+"="+saleMasterBean.getSalemasterid(), null);
	}
	
	public ResultSet getAllSaleMasterDetails(){
		return query(SALEMASTER_TABLE_NAME, null, null, null, null, null, null);
	}
	
	public ResultSet getDetailsByRetailId(int retailid){
		String sql = "select * from "+Constants.DBNAME+"."+SALEMASTER_TABLE_NAME+" where "+SALEMASTER_RETAILID+"=?";
		try{
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, retailid);
		return pstmt.executeQuery();
		}catch(SQLException sqle){
			System.out.println(sqle);
		}
		return null;
	}
	
	public ResultSet getDetailsBySaleMasterId(int salemasterid){
		String sql = "select * from "+Constants.DBNAME+"."+SALEMASTER_TABLE_NAME+" where "+SALEMASTER_SALEMASTERID+"=?";
		try{
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, salemasterid);
		return pstmt.executeQuery();
		}catch(SQLException sqle){
			System.out.println(sqle);
		}
		return null;
	}
	
	public ResultSet getDetailsForSpecificPeriod(String fromdate, String todate) throws SQLException{
		String sql = "select * from "+SALEMASTER_TABLE_NAME+" where "+SALEMASTER_CREATEDDATE+" between '"+fromdate+"' and '"+todate+"'";
		Statement stmt = connection.createStatement();
		return stmt.executeQuery(sql);
	}
}
