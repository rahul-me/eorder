package com.bms.mdm.area;

import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.bms.mdm.area.AreaActionForm;
import com.bms.mdm.area.AreaDBAdapter;



/**
 * UserRoleDBHelper manages the usreroletable in the database. Responsible for all
 * bussiness operations on the userrole table.
 * 
 * @author Markana Mehul
 * 
 */

public class AreaDBHelper {

	private static final String TAG = "com.bms.mdm.area.AreaDBHelper";
	private Logger logger = Logger.getLogger(TAG);
	private AreaDBAdapter areaDBAdapter  ;

	public AreaDBHelper() {
		areaDBAdapter = new AreaDBAdapter();
	}

	public ArrayList<AreaActionForm> fetchAllRecords() {
		areaDBAdapter.open();
		ResultSet cursor = areaDBAdapter.getAll();
		ArrayList<AreaActionForm> userRoleBeanList = new ArrayList<AreaActionForm>();
		;
		if (cursor != null) {
			try {
				cursor.beforeFirst();
				while (cursor.next()) {
					userRoleBeanList.add(fetchDataFromResultSet(cursor));
				}
				cursor.close();
			} catch (Exception e) {
				// System.out.println(e);
				logger.error(e);
			}

		}
		areaDBAdapter.close();
		return userRoleBeanList;
	}

	public AreaActionForm getAreaByAreaId(int AreaId) {
		areaDBAdapter.open();
		ResultSet cursor = areaDBAdapter.getByAreaMasterId(AreaId);
		AreaActionForm userRoleBean = null;
		if (cursor != null) {
			try {
				cursor.beforeFirst();
				if (cursor.next()) {
					userRoleBean = fetchDataFromResultSet(cursor);
				}
				cursor.close();
			} catch (Exception e) {
				logger.error(e);
			}
		}
		areaDBAdapter.close();
		return userRoleBean;
	}

	public int addArea(AreaActionForm actionForm) {
		areaDBAdapter.open();
		int status = areaDBAdapter.insertArea(actionForm);
		areaDBAdapter.close();

		return status;
	}

	public boolean deleteArea(int userRoleId) {
		areaDBAdapter.open();
		boolean status = areaDBAdapter.deactiavteArea(userRoleId);
		areaDBAdapter.close();
		return status;
	}

	public int updateArea(AreaActionForm actionForm) {
		areaDBAdapter.open();
		int result = areaDBAdapter.updateArea(actionForm);
		areaDBAdapter.close();
		return result;
	}

	private AreaActionForm fetchDataFromResultSet(ResultSet cursor) {
		AreaActionForm areaActionForm = new AreaActionForm();
		try {
			areaActionForm.setAreaMasterId(cursor.getInt(AreaDBAdapter.KEY_AREA_AREAMASTERID));
			areaActionForm.setAreaName(cursor.getString(AreaDBAdapter.KEY_AREA_AREANAME));
			areaActionForm.setCreatedBY(cursor.getInt(AreaDBAdapter.KEY_AREA_CREATEDBY));
			areaActionForm.setModifiedBY(cursor.getInt(AreaDBAdapter.KEY_AREA_MODIFIEDBY));
			areaActionForm.setCreatedDTTM(cursor.getString(AreaDBAdapter.KEY_AREA_CREATEDDTTM));
			areaActionForm.setModifiedDTTM(cursor.getString(AreaDBAdapter.KEY_AREA_MODIFIEDDTTM));
			
		} catch (Exception e) {
			logger.error(e);
		}
		return areaActionForm;
	}

}
