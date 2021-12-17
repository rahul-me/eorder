package com.bms.sale.saledetail;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

public class SaleDetailDBHelper {
	SaleDetailDBAdapter saleDetailDBAdapter;
	public SaleDetailDBHelper(){
		saleDetailDBAdapter = new SaleDetailDBAdapter();
	}
	
	public int insertDetails(SaleDetailActionForm saleDetailBean){
		saleDetailDBAdapter.open();
		int result = saleDetailDBAdapter.insertDetails(saleDetailBean);
		saleDetailDBAdapter.close();
		return result;
	}
	
	public int updateDetails(SaleDetailActionForm saleDetailBean){
		saleDetailDBAdapter.open();
		int result = saleDetailDBAdapter.updateDetails(saleDetailBean);
		saleDetailDBAdapter.close();
		return result;
	}
	
	SaleDetailActionForm fetchDetailsFromResultSet(ResultSet rs){
		SaleDetailActionForm saleDetailBean = null;
		try{
			saleDetailBean = new SaleDetailActionForm();
			saleDetailBean.setSaledetailid(rs.getInt(SaleDetailDBAdapter.SALEDETAIL_SALEDETAILID));
			saleDetailBean.setItemid(rs.getInt(SaleDetailDBAdapter.SALEDETAIL_ITEMID));
			saleDetailBean.setQuantity(rs.getFloat(SaleDetailDBAdapter.SALEDETAIL_QUANTITY));
			saleDetailBean.setRate(rs.getFloat(SaleDetailDBAdapter.SALEDETAIL_RATE));
			saleDetailBean.setAmount(rs.getFloat(SaleDetailDBAdapter.SALEDETAIL_AMOUNT));
			saleDetailBean.setSalemasterid(rs.getInt(SaleDetailDBAdapter.SALEDETAIL_SALEMASTERID));
		}catch(SQLException sqle){
			System.out.println(sqle);
		}
		return saleDetailBean;
	}
	
	public ArrayList<SaleDetailActionForm> getAllDetails(){
		ArrayList<SaleDetailActionForm> list = null;
		ResultSet rs = saleDetailDBAdapter.getAllDetails();
		if(rs!=null){
			try{
				list = new ArrayList<SaleDetailActionForm>();
				while(rs.next()){
					try{
					list.add(fetchDetailsFromResultSet(rs));
					}catch(Exception e){
						System.out.println(e);
					}
				}
			}catch(SQLException sqle){
				System.out.println(sqle);
			}
		}
		return list;
	}
	
	public ArrayList<SaleDetailActionForm> getDetailsBySaleMasterId(int salemasterid) throws SQLException{
		saleDetailDBAdapter.open();
		ArrayList<SaleDetailActionForm> list = new ArrayList<SaleDetailActionForm>();
		ResultSet rs = saleDetailDBAdapter.getDetailsBySaleMasterId(salemasterid);
		while(rs.next()){
			list.add(fetchDetailsFromResultSet(rs));
		}
		saleDetailDBAdapter.close();
		return list;
	}
	
	public SaleDetailActionForm getDetailsByDetailId(int saledetailid) throws SQLException{
		saleDetailDBAdapter.open();
		SaleDetailActionForm saleDetailBean = new SaleDetailActionForm();		
		ResultSet rs = saleDetailDBAdapter.getDetailsByDetailId(saledetailid);
		while(rs.next()){
			saleDetailBean = fetchDetailsFromResultSet(rs);
		}
		saleDetailDBAdapter.close();
		return saleDetailBean;
	}
}
