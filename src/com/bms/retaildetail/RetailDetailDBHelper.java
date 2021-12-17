package com.bms.retaildetail;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RetailDetailDBHelper {
	private RetailDetailDBAdapter retailDetailAdapter;
	
	public RetailDetailDBHelper(){
		retailDetailAdapter = new RetailDetailDBAdapter();
	}
	
	public long insertRetailDetail(RetailDetailActionForm retailDetailBean){
		retailDetailAdapter.open();
		long res = retailDetailAdapter.insertRetailDetail(retailDetailBean);
		retailDetailAdapter.close();
		return res;
	}
	
	public long updateRetailDetail(RetailDetailActionForm retailDetailBean){
		retailDetailAdapter.open();
		long res = retailDetailAdapter.updateRetailDetail(retailDetailBean);
		retailDetailAdapter.close();
		return res;
	}
	
	public RetailDetailActionForm getDataFromRS(ResultSet rs) throws SQLException{
		RetailDetailActionForm retailDetailBean = new RetailDetailActionForm();
		retailDetailBean.setRetailid(rs.getInt(RetailDetailDBAdapter.RETAILDEATIL_RETAILID));
		retailDetailBean.setCstidno(rs.getString(RetailDetailDBAdapter.RETAILDETAIL_CSTIDNO));
		retailDetailBean.setVatidno(rs.getString(RetailDetailDBAdapter.RETAILDETAIL_VATIDNO));
		retailDetailBean.setSuppref(rs.getString(RetailDetailDBAdapter.RETAILDETAIL_SUPPREF));
		return retailDetailBean;
	}
	
	public RetailDetailActionForm getRetailDetailByRetailId(int retailid) throws SQLException{		
		retailDetailAdapter.open();
		ResultSet rs= retailDetailAdapter.getRetailDetailByRetailId(retailid);
		rs.next();
		return getDataFromRS(rs);
	}
	
	public boolean findTableIsEmptyORNot() throws SQLException{
		retailDetailAdapter.open();
		ResultSet rs =retailDetailAdapter.getFullListOfDetails();
		retailDetailAdapter.close();
		if(rs.next()){
			return false;
		}else{
			return true;
		}
	}
	
	public boolean findDataIsAvailableOrNotForRetailid(int retailid) throws SQLException{
		retailDetailAdapter.open();
		ResultSet rs = retailDetailAdapter.getRetailDetailByRetailId(retailid);
		if(rs.next())
			return true;
		else
			return false;
	}
}
