package com.bms.mdm.area;

import java.sql.ResultSet;

import org.apache.log4j.Logger;

import com.bms.db.ContentValues;
import com.bms.db.RestoserverDBAdapter;


/**
 * UserRoleDBAdapter manages the usreroletable in the database. Responsible for all
 * CRUD operations on the userrole table.
 * 
 * @author Mehul Markana
 * 
 */

public class AreaDBAdapter extends RestoserverDBAdapter {
	private final String TAG = "com.bms.mdm.area.AreaDBAdapter";

	private final Logger log = Logger.getLogger(TAG);
	public static final String KEY_AREA_TABLE_NAME = "mdm_area";

	public static final String KEY_AREA_AREAMASTERID = "areaMasterId";
	public static final String KEY_AREA_AREANAME = "areaName";
	public static final String KEY_AREA_CREATEDDTTM = "createdDTTM";
	public static final String KEY_AREA_CREATEDBY = "createdBY";
	public static final String KEY_AREA_MODIFIEDDTTM = "modifiedDTTM";
	public static final String KEY_AREA_MODIFIEDBY = "modifiedBY";


	
	public AreaDBAdapter() {
		super();
	}

	/**
	 * insertUserRole will insert data in to UserRole table
	 * 
	 * 
	 * 
	 * @param userRoleBean
	 * @return cVAlue object if succes
	 */

	public int insertArea(AreaActionForm areaActionForm)

	{
		ContentValues cValues = new ContentValues();
		cValues.put(KEY_AREA_AREAMASTERID, areaActionForm.getAreaMasterId());
		cValues.put(KEY_AREA_AREANAME, areaActionForm.getAreaName());
		cValues.put(KEY_AREA_CREATEDDTTM, areaActionForm.getCreatedDTTM());
		cValues.put(KEY_AREA_MODIFIEDBY, areaActionForm.getModifiedBY());
		cValues.put(KEY_AREA_MODIFIEDDTTM, areaActionForm.getModifiedDTTM());
		cValues.put(KEY_AREA_CREATEDBY, areaActionForm.getCreatedBY());

		
		return (int) insert(KEY_AREA_TABLE_NAME, null, cValues);

	}

	/**
	 * get all will return all record of UserRole table
	 * 
	 * 
	 * 
	 * 
	 */

	public ResultSet getAll() {
		return query(KEY_AREA_TABLE_NAME,null,null, null,null, null, null);
	}

	/**
	 * getByUserRoleId will return single record of UserRole table
	 * 
	 * @param UserRoleid
	 * @return resultset
	 * 
	 */

	public ResultSet getByAreaMasterId(int UserRoleId) {
		return query(KEY_AREA_TABLE_NAME,null,
				KEY_AREA_AREAMASTERID + "=" + UserRoleId, null, null, null, null);
	}

	/**
	 * deactivateUserRole will unset particular UserRole of UserRole table
	 * 
	 * @param UserRoleid
	 * @return true/false
	 * 
	 */

	public boolean deactiavteArea(long UserRoleId) {

		return delete(KEY_AREA_TABLE_NAME, KEY_AREA_AREAMASTERID + "=" + UserRoleId,
				null) > 0;
	}

	/**
	 * update will update UserRole of UserRole table
	 * 
	 * @param userRoleBean
	 * @return resultset
	 * 
	 */
	public int update(AreaActionForm areaActionForm) {

		int result = 0;
		ContentValues cValues = new ContentValues();
		cValues.put(KEY_AREA_AREANAME, areaActionForm.getAreaName());
		cValues.put(KEY_AREA_CREATEDDTTM, areaActionForm.getCreatedDTTM());
		cValues.put(KEY_AREA_MODIFIEDBY, areaActionForm.getModifiedBY());
		cValues.put(KEY_AREA_MODIFIEDDTTM, areaActionForm.getModifiedDTTM());
		cValues.put(KEY_AREA_CREATEDBY, areaActionForm.getCreatedBY());

		
		result = update(KEY_AREA_TABLE_NAME, cValues, KEY_AREA_AREAMASTERID + "='"
				+ areaActionForm.getAreaMasterId() + "'", null);
		return result;
	}

	public int updateArea(AreaActionForm areaActionForm) {

		int result = 0;
		ContentValues cValues = new ContentValues();
		cValues.put(KEY_AREA_AREANAME, areaActionForm.getAreaName());
		cValues.put(KEY_AREA_MODIFIEDBY, areaActionForm.getModifiedBY());
		cValues.put(KEY_AREA_MODIFIEDDTTM, areaActionForm.getModifiedDTTM());

		
		result = update(KEY_AREA_TABLE_NAME, cValues, KEY_AREA_AREAMASTERID + "='"
				+ areaActionForm.getAreaMasterId() + "'", null);
		return result;
	}
	
	/**
	 * get allRecordsWithoutAdmin  will return records of UserRole table
	 * 
	 * 
	 */

}