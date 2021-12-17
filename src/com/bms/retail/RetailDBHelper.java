package com.bms.retail;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.HashMap;

import com.bms.mdm.item.ItemDBAdapter;



public class RetailDBHelper {
	
	private RetailDBAdapter retailDBAdapter;
	
	public RetailDBHelper(){
		retailDBAdapter =  new RetailDBAdapter();
	}
	
	public RetailActionForm fetchDataFromResultSet(ResultSet rs){
		RetailActionForm retailBean = new RetailActionForm();
		try{
		retailBean.setRetailmasterid(rs.getInt(RetailDBAdapter.RETAIL_COLUMN_RETAILMASTERID));
		retailBean.setRetailid(rs.getInt(RetailDBAdapter.RETAIL_COLUMN_RETAILID));
		retailBean.setItemid(rs.getInt(RetailDBAdapter.RETAIL_COLUMN_ITEMID));
		retailBean.setCompanymasterid(rs.getInt(RetailDBAdapter.RETAIL_COLUMN_COMPANYMASTERID));
		retailBean.setOrderquantity(rs.getFloat(RetailDBAdapter.RETAIL_COLUMN_ORDERQUANTITY));
		retailBean.setDeliveredquantity(rs.getFloat(RetailDBAdapter.RETAIL_COLUMN_DELIVEREDQUANTITY));
		retailBean.setSalequantity(rs.getFloat(RetailDBAdapter.RETAIL_COLUMN_SALEQUANTITY));
		retailBean.setReturnquantity(rs.getFloat(RetailDBAdapter.RETAIL_COLUMN_RETURNQUANTITY));
		}catch(Exception e){
			System.out.println(e);
		}
		return retailBean;
	}
	
	public int insertRetailDetails(RetailActionForm retailBean){
		retailDBAdapter.open();
		int result = retailDBAdapter.insertRetail(retailBean);
		retailDBAdapter.close();
		return result;
	}
	
	public int updateRetailDetails(RetailActionForm retailBean){
		retailDBAdapter.open();
		int result = retailDBAdapter.updateRetail(retailBean);
		retailDBAdapter.close();
		return result;
	}
	
	public ArrayList<RetailActionForm> getAllRetailDetails(){
		retailDBAdapter.open();
		ResultSet rs = retailDBAdapter.getAllRetailDetails();
		retailDBAdapter.close();
		ArrayList<RetailActionForm> list = null;
		if(rs!=null){
			list = new ArrayList<RetailActionForm>();
			try{
				while(rs.next()){
					list.add(fetchDataFromResultSet(rs));
				}
			}catch(SQLException sqle){
				System.out.println(sqle);				
			}
		}			
		
		return list;
	}
	
	public int checkAvailableItemForRetailer(int retailid, int itemid){
		retailDBAdapter.open();
		ResultSet rs = null;
		try{
			rs = retailDBAdapter.checkAvailableItemForRetailer(retailid, itemid);
			retailDBAdapter.close();
			if(rs!=null){
			rs.next();
			return rs.getInt(1);}
			else{return -1;}
		}catch(SQLException sqle){
			System.out.println(sqle);
		}
		return -1;
	}
	
	public int updateOrderQuantityForRetailerItem(int retailid, int itemid, float orderquantity){
		retailDBAdapter.open();
		int result = retailDBAdapter.updateOrderQuantityForRetailerItem(retailid, itemid, orderquantity);
		retailDBAdapter.close();
		return result;
	}
	
	public RetailActionForm getRetailDetailsByRetailerAndItem(int retailid, int itemid){
		retailDBAdapter.open();
		ResultSet rs = null;
		RetailActionForm retailBean = null;
		try{
			rs = retailDBAdapter.getRetailDetailsByRetailerAndItem(retailid, itemid);
			retailDBAdapter.close();
			rs.next();			
			retailBean =fetchDataFromResultSet(rs);
		}catch(SQLException sqle){
			System.out.println(sqle);
		}
		return retailBean;
	}
	
	public RetailActionForm fetchDataFromResultSetHavingRetailerItems(ResultSet rs){
		RetailActionForm retailBean = new RetailActionForm();
		try{
			retailBean.setRetailmasterid(rs.getInt(RetailDBAdapter.RETAIL_COLUMN_RETAILMASTERID));
			retailBean.setRetailid(rs.getInt(RetailDBAdapter.RETAIL_COLUMN_RETAILID));
			retailBean.setItemid(rs.getInt(RetailDBAdapter.RETAIL_COLUMN_ITEMID));
			retailBean.setCompanymasterid(rs.getInt(RetailDBAdapter.RETAIL_COLUMN_COMPANYMASTERID));
			retailBean.setOrderquantity(rs.getFloat(RetailDBAdapter.RETAIL_COLUMN_ORDERQUANTITY));
			retailBean.setDeliveredquantity(rs.getFloat(RetailDBAdapter.RETAIL_COLUMN_DELIVEREDQUANTITY));
			retailBean.setSalequantity(rs.getFloat(RetailDBAdapter.RETAIL_COLUMN_SALEQUANTITY));
			retailBean.setReturnquantity(rs.getFloat(RetailDBAdapter.RETAIL_COLUMN_RETURNQUANTITY));
			retailBean.setItemMasterId(rs.getInt(ItemDBAdapter.COLUMN_ITEM_MASTER_ID));
			retailBean.setName(rs.getString(ItemDBAdapter.COLUMN_ITEM_NAME));
			retailBean.setItemPrice(rs.getFloat(ItemDBAdapter.COLUMN_ITEM_PRICE));
			retailBean.setMeasurementMasterId(rs.getInt(ItemDBAdapter.COLUMN_ITEM_MEASUREMENT_MASTER_ID));
			}catch(Exception e){
				System.out.println(e);
			}
		return retailBean;
	}
	
	public ArrayList<RetailActionForm> getListOfItemsForRetailer(int retailid){
		retailDBAdapter.open();
		ResultSet rs = retailDBAdapter.getItemsOfRetailer(retailid);
		ArrayList<RetailActionForm> list = null;
		if(rs!=null){
			list = new ArrayList<RetailActionForm>();
			try{
				while(rs.next()){
					try{
						list.add(fetchDataFromResultSetHavingRetailerItems(rs));
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
	
	public HashMap<Integer, RetailActionForm> getHashMapOfItemsForRetailer(int retailid){
		HashMap<Integer, RetailActionForm> hashmap = null;
		retailDBAdapter.open();
		ResultSet rs = retailDBAdapter.getItemsOfRetailer(retailid);
		if(rs!=null){
			hashmap = new HashMap<Integer, RetailActionForm>();
			try{
				while(rs.next()){
					RetailActionForm retailBean = fetchDataFromResultSetHavingRetailerItems(rs);
					hashmap.put(retailBean.getItemid(), retailBean);
				}
			}catch(SQLException sqle){
				System.out.println(sqle);
			}
		}
		return hashmap;
	}
}
