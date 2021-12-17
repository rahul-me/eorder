package com.bms.retaildetail;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bms.constants.Constants;
import com.bms.db.ContentValues;
import com.bms.db.RestoserverDBAdapter;

public class RetailDetailDBAdapter extends RestoserverDBAdapter {
	
	public static final String RETAILDETAIL_TABLENAME = "retail_detail";
	
	public static final String RETAILDEATIL_RETAILID = "retailid";
	public static final String RETAILDETAIL_CSTIDNO = "cstidno";
	public static final String RETAILDETAIL_VATIDNO = "vatidno";
	public static final String RETAILDETAIL_SUPPREF = "suppref";
	
	public RetailDetailDBAdapter(){
		super();
	}
	
	public long insertRetailDetail(RetailDetailActionForm retailDetailBean){
		ContentValues cv = new ContentValues();		
		cv.put(RETAILDEATIL_RETAILID, retailDetailBean.getRetailid());
		cv.put(RETAILDETAIL_CSTIDNO, retailDetailBean.getCstidno());
		cv.put(RETAILDETAIL_VATIDNO, retailDetailBean.getVatidno());
		cv.put(RETAILDETAIL_SUPPREF, retailDetailBean.getSuppref());
		return insert(RETAILDETAIL_TABLENAME, null, cv);
	}
	
	public long updateRetailDetail(RetailDetailActionForm retailDetailBean){
		ContentValues cv = new ContentValues();
		cv.put(RETAILDEATIL_RETAILID, retailDetailBean.getRetailid());
		cv.put(RETAILDETAIL_CSTIDNO, retailDetailBean.getCstidno());
		cv.put(RETAILDETAIL_VATIDNO, retailDetailBean.getVatidno());
		cv.put(RETAILDETAIL_SUPPREF, retailDetailBean.getSuppref());
		return update(RETAILDETAIL_TABLENAME, cv, RETAILDEATIL_RETAILID+"="+retailDetailBean.getRetailid(), null);
	}
	
	public ResultSet getFullListOfDetails() throws SQLException{
		String sql = "select * from "+Constants.DBNAME+"."+RETAILDETAIL_TABLENAME;
		Statement stmt = connection.createStatement();
		return stmt.executeQuery(sql);
	}
	
	public ResultSet getRetailDetailByRetailId(int retailid) throws SQLException{
		String sql = "select * from "+Constants.DBNAME+"."+RETAILDETAIL_TABLENAME+" where "+RETAILDEATIL_RETAILID+"="+retailid;
		Statement stmt = connection.createStatement();
		return stmt.executeQuery(sql);
	}
}
