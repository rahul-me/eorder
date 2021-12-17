package com.bms.sale.salemaster;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

public class SaleMasterDBHelper {
	
	SaleMasterDBAdapter saleMasterDBAdapter;
	
	public SaleMasterDBHelper(){
		saleMasterDBAdapter = new SaleMasterDBAdapter();
	}
	
	public int insertDetails(SaleMasterActionForm saleMasterBean){
		saleMasterDBAdapter.open();
		int result = saleMasterDBAdapter.insertSaleMasterDetails(saleMasterBean);
		saleMasterDBAdapter.close();
		return result;
	}
	
	public int updateDetails(SaleMasterActionForm saleMasterBean){
		saleMasterDBAdapter.open();
		int result = saleMasterDBAdapter.updateSaleMasterDetails(saleMasterBean);
		saleMasterDBAdapter.close();
		return result;
	}
	
	SaleMasterActionForm fetchDataFromResultSet(ResultSet rs){
		SaleMasterActionForm saleMasterBean = null;
		try{
			saleMasterBean = new SaleMasterActionForm();
		saleMasterBean.setSalemasterid(rs.getInt(SaleMasterDBAdapter.SALEMASTER_SALEMASTERID));
		saleMasterBean.setCreatedDate(rs.getString(SaleMasterDBAdapter.SALEMASTER_CREATEDDATE));
		saleMasterBean.setCompanyMasterId(rs.getInt(SaleMasterDBAdapter.SALEMASTER_COMPANYMASTERID));
		saleMasterBean.setRetailid(rs.getInt(SaleMasterDBAdapter.SALEMASTER_RETAILID));
		saleMasterBean.setOrderquantity(rs.getFloat(SaleMasterDBAdapter.SALEMASTER_ORDERQUANTITY));
		saleMasterBean.setDeliveredquantity(rs.getFloat(SaleMasterDBAdapter.SALEMASTER_DELIVEREDQUANTITY));
		saleMasterBean.setTotal(rs.getFloat(SaleMasterDBAdapter.SALEMASTER_TOTAL));
		saleMasterBean.setConsumername(rs.getString(SaleMasterDBAdapter.SALEMASTER_CONSUMERNAME));
		saleMasterBean.setConsumeraddress(rs.getString(SaleMasterDBAdapter.SALEMASTER_CONSUMERADDRESS));
		}catch(SQLException sqle){
			System.out.println(sqle);
		}
		return saleMasterBean;
	}
	
	public ArrayList<SaleMasterActionForm> getAllDetails(){
		saleMasterDBAdapter.open();
		ResultSet rs = saleMasterDBAdapter.getAllSaleMasterDetails();
		ArrayList<SaleMasterActionForm> list = null;
		saleMasterDBAdapter.close();
		if(rs!=null){
			list = new ArrayList<SaleMasterActionForm>();
			try{
				while(rs.next()){
					try{
					list.add(fetchDataFromResultSet(rs));
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
	
	public SaleMasterActionForm getDetailsBySaleMasterId(int salemasterid){
		SaleMasterActionForm saleMasterBean = new SaleMasterActionForm();
		saleMasterDBAdapter.open();
		ResultSet rs = saleMasterDBAdapter.getDetailsBySaleMasterId(salemasterid);
		saleMasterDBAdapter.close();
		if(rs!=null){
			try{
				
			while(rs.next()){
				try{
				saleMasterBean = fetchDataFromResultSet(rs);
				}catch(Exception e){
					System.out.println(e);
				}
			}
			}catch(SQLException sqle){
				System.out.println(sqle);
			}
		}
		return saleMasterBean;
	}
	
	public ArrayList<SaleMasterActionForm> getDetailsForSpecificPeriod(String fromdate, String todate) throws SQLException{
		saleMasterDBAdapter.open();
		ArrayList<SaleMasterActionForm> list = new ArrayList<SaleMasterActionForm>();
		if(saleMasterDBAdapter.getDetailsForSpecificPeriod(fromdate, todate).next()){
			ResultSet rs = saleMasterDBAdapter.getDetailsForSpecificPeriod(fromdate, todate);
			while(rs.next()){
				list.add(fetchDataFromResultSet(rs));
			}
		}
		saleMasterDBAdapter.close();
		return list;
	}

}
