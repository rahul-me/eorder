package com.bms.mdm.packages;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;





public class PackagesDBHelper {
	
	
	
	PackagesDBAdapter pkgDBAdapter;
	
	public PackagesDBHelper() {
		System.out.println("Im in db helper");
		pkgDBAdapter=new PackagesDBAdapter();			
	}
	
	// Implementation of all methods that will help us to manipulate data requested from database.
	// Here We are creating abstraction for database manipulation. 
	
	public ArrayList<PackagesActionForm> fetchAllRecords() throws SQLException
	{
		pkgDBAdapter.open();
		ResultSet rs=pkgDBAdapter.getAll();
		
		ArrayList<PackagesActionForm> pkgFormBeanList=new ArrayList<PackagesActionForm>();
		
		if(rs!=null)
		{
			rs.beforeFirst();
			while(rs.next())
			{
				pkgFormBeanList.add(fetchDataFromResultSet(rs));
			}
		}
		pkgDBAdapter.close();
		
		
		return pkgFormBeanList;
	}
	
	public PackagesActionForm fetchDataFromResultSet(ResultSet rs)
	{
		PackagesActionForm pkgFormBean = new PackagesActionForm();
		try
		{
			pkgFormBean.setPackageMasterId(rs.getInt(PackagesDBAdapter.COLUMN_PACKAGE_MASTER_ID));
			pkgFormBean.setPackageName(rs.getString(PackagesDBAdapter.COLUMN_PACKAGE_NAME));
			pkgFormBean.setPackageDescription(rs.getString(PackagesDBAdapter.COLUMN_PACKAGE_DESCRIPTION));
			pkgFormBean.setPackageDuration(rs.getInt(PackagesDBAdapter.COLUMN_PACKAGE_DURATION));
			pkgFormBean.setPackageCharge(rs.getInt(PackagesDBAdapter.COLUMN_PACKAGE_CHARGE));
			pkgFormBean.setPackageStatus(rs.getInt(PackagesDBAdapter.COLUMN_PACKAGE_IS_ACTIVE));
			pkgFormBean.setCreatedDate(rs.getString(PackagesDBAdapter.COLUMN_PACKAGE_CREATED_DATE));
			pkgFormBean.setCreatedDTTM(rs.getString(PackagesDBAdapter.COLUMN_PACKAGE_CREATED_DTTM));
			pkgFormBean.setCreatedBy(rs.getInt(PackagesDBAdapter.COLUMN_PACKAGE_CREATED_BY));
			pkgFormBean.setModifyDate(rs.getString(PackagesDBAdapter.COLUMN_PACKAGE_MODIFYDATE));
			pkgFormBean.setModifyDTTM(rs.getString(PackagesDBAdapter.COLUMN_PACKAGE_MODDIFY_DTTM));
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return pkgFormBean;
	}
	
	public PackagesActionForm getPkgById(int pkgId) throws SQLException
	{
		pkgDBAdapter.open();
		ResultSet rs= pkgDBAdapter.getPkgByPkgId(pkgId);
		PackagesActionForm pkgBean=null;
		
		if(rs!=null)
		{
			rs.beforeFirst();
			if(rs.next())
			{
				pkgBean = fetchDataFromResultSet(rs);
			}
		}
		pkgDBAdapter.close();
		return pkgBean;
	}
	
	public int addPkg(PackagesActionForm pkgBean)
	{
		pkgDBAdapter.open();
		int op=pkgDBAdapter.insertPkg(pkgBean);
		pkgDBAdapter.close();
		return op;
	}
	
	public boolean deletePkgById(int pkgId)
	{
		pkgDBAdapter.open();
		boolean val=pkgDBAdapter.deactiavtePkg(pkgId);
		pkgDBAdapter.close();
		return val;
	}
	
	public int updatePkgProperty(PackagesActionForm pkgBean)
	{
		pkgDBAdapter.open();
		int op=pkgDBAdapter.update(pkgBean);
		pkgDBAdapter.close();
		return op;
	}
	
	public ArrayList<PackagesActionForm> getAllActivePkg() throws SQLException
	{
		pkgDBAdapter.open();
		ResultSet rs=pkgDBAdapter.getAllActivePkg();
		
		ArrayList<PackagesActionForm> pkgActiveBean=new ArrayList<PackagesActionForm>();
		
		if(rs!=null)
		{
			rs.beforeFirst();
			while(rs.next())
			{
				pkgActiveBean.add(fetchDataFromResultSet(rs));
			}
		}
		pkgDBAdapter.close();
		return pkgActiveBean;
	}
	
	  
}
