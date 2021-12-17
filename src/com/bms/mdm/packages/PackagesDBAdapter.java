package com.bms.mdm.packages;

import java.sql.ResultSet;



import com.bms.db.ContentValues;
import com.bms.db.RestoserverDBAdapter;

public class PackagesDBAdapter extends RestoserverDBAdapter {
	
	public static final String MDM_PACKAGE_TABLE_NAME="mdm_package";
	
	public static final String COLUMN_PACKAGE_MASTER_ID="packageMasterId";
	public static final String COLUMN_PACKAGE_NAME="name";
	public static final String COLUMN_PACKAGE_DESCRIPTION="description";
	public static final String COLUMN_PACKAGE_DURATION="duration";
	public static final String COLUMN_PACKAGE_CHARGE="charge";
	public static final String COLUMN_PACKAGE_IS_ACTIVE="isActive";
	public static final String COLUMN_PACKAGE_CREATED_DATE="createdDate";
	public static final String COLUMN_PACKAGE_CREATED_DTTM="createdDTTM";
	public static final String COLUMN_PACKAGE_CREATED_BY="createdBy";
	public static final String COLUMN_PACKAGE_MODIFYDATE="modifyDate";
	public static final String COLUMN_PACKAGE_MODDIFY_DTTM="modifyDTTM";
	
	public PackagesDBAdapter()
	{
		super();
	}
	
	public int insertPkg(PackagesActionForm packagesActionForm)
	{
		ContentValues cValues=new ContentValues();
		
		cValues.put(COLUMN_PACKAGE_MASTER_ID,packagesActionForm.getPackageMasterId());
		cValues.put(COLUMN_PACKAGE_NAME, packagesActionForm.getPackageName());
		cValues.put(COLUMN_PACKAGE_DESCRIPTION, packagesActionForm.getPackageDescription());
		cValues.put(COLUMN_PACKAGE_DURATION, packagesActionForm.getPackageDuration());
		cValues.put(COLUMN_PACKAGE_CHARGE, packagesActionForm.getPackageCharge());
		cValues.put(COLUMN_PACKAGE_IS_ACTIVE, packagesActionForm.getPackageStatus());
		cValues.put(COLUMN_PACKAGE_CREATED_DATE, packagesActionForm.getCreatedDate());
		cValues.put(COLUMN_PACKAGE_CREATED_DTTM, packagesActionForm.getCreatedDTTM());
		cValues.put(COLUMN_PACKAGE_CREATED_BY, packagesActionForm.getCreatedBy());
		cValues.put(COLUMN_PACKAGE_MODIFYDATE, packagesActionForm.getModifyDate());
		cValues.put(COLUMN_PACKAGE_MODDIFY_DTTM, packagesActionForm.getModifyDTTM());
		
		return (int)insert(MDM_PACKAGE_TABLE_NAME, null, cValues);
	}
	
	public ResultSet getAll()
	{
		return query(MDM_PACKAGE_TABLE_NAME, null, null, null, null, null, null);		
	}
	
	public ResultSet getAllPkgByPkgId(int pkgId)
	{
		return query(MDM_PACKAGE_TABLE_NAME, null, COLUMN_PACKAGE_MASTER_ID+ "=" +pkgId, null, null, null, null);		
	}
	
	public ResultSet getByPkgId(int pkgId)
	{
		return query(MDM_PACKAGE_TABLE_NAME, null, COLUMN_PACKAGE_MASTER_ID+ "=" + pkgId, null, null, null, null);
	}
	public ResultSet getAllByFilter(String Filter) {
		return query(MDM_PACKAGE_TABLE_NAME, null, Filter, null, null, null,null);
	}
	public boolean deactiavtePkg(long pkgId) {

		return delete(MDM_PACKAGE_TABLE_NAME, COLUMN_PACKAGE_MASTER_ID+ "=" + pkgId, null) > 0;
	}
	public int update(PackagesActionForm packagesActionForm)
	{
		int result = 0;
		ContentValues cv=new ContentValues();
		
		cv.put(COLUMN_PACKAGE_MASTER_ID,packagesActionForm.getPackageMasterId());
		cv.put(COLUMN_PACKAGE_NAME, packagesActionForm.getPackageName());
		cv.put(COLUMN_PACKAGE_DESCRIPTION, packagesActionForm.getPackageDescription());
		cv.put(COLUMN_PACKAGE_DURATION, packagesActionForm.getPackageDuration());
		cv.put(COLUMN_PACKAGE_CHARGE, packagesActionForm.getPackageCharge());
		cv.put(COLUMN_PACKAGE_IS_ACTIVE, packagesActionForm.getPackageStatus());
		cv.put(COLUMN_PACKAGE_CREATED_DATE, packagesActionForm.getCreatedDate());
		cv.put(COLUMN_PACKAGE_CREATED_DTTM, packagesActionForm.getCreatedDTTM());
		cv.put(COLUMN_PACKAGE_CREATED_BY, packagesActionForm.getCreatedBy());
		cv.put(COLUMN_PACKAGE_MODIFYDATE, packagesActionForm.getModifyDate());
		cv.put(COLUMN_PACKAGE_MODDIFY_DTTM, packagesActionForm.getModifyDTTM());
		
		result = update(MDM_PACKAGE_TABLE_NAME, cv, COLUMN_PACKAGE_MASTER_ID + "=" + packagesActionForm.getPackageMasterId(), null);
		return result;
	}
	

	
	public ResultSet getAllActivePkg()
	{
		return query(MDM_PACKAGE_TABLE_NAME, null, COLUMN_PACKAGE_IS_ACTIVE+"= 1", null, null, null, null);		
	}

	public ResultSet getAllSortedItemsByName()
	{
		return query(MDM_PACKAGE_TABLE_NAME, null, null, null, null, null,COLUMN_PACKAGE_NAME);		
	}
	
	public ResultSet getPkgByPkgId(int pkgId)
	{
		return query(MDM_PACKAGE_TABLE_NAME, null, COLUMN_PACKAGE_MASTER_ID+ "=" + pkgId, null, null, null, null);
	}

}
