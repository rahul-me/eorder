package com.bms.mdm.settings;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bms.constants.Constants;
import com.bms.context.ServerAppContext;
import com.bms.mdm.authorizationmatrix.AuthorisedMatrixActionForm;
import com.bms.mdm.authorizationmatrix.AuthorisedMatrixDBHelper;
import com.bms.struts.SCMAction;

public class AccessControlAction extends SCMAction {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		HttpSession httpSession=request.getSession(true);
		//UserActionForm userActionForm=(UserActionForm)httpSession.getAttribute(Constants.USER_BEAN);
		int companyId=(int)httpSession.getAttribute(Constants.COMPANY_ID);
		int userId=(int)httpSession.getAttribute(Constants.USER_ID);
		
		System.out.println("Company "+companyId);
		
		
		int roleId = Integer.parseInt((String)request.getParameter("userRolesMasterId"));
		AuthorisedMatrixDBHelper authorisedMatrixDBHelper = new AuthorisedMatrixDBHelper();
		//first we need to delete all the current mappings.
		
		authorisedMatrixDBHelper.deleteAuthorisationMatrixByRoleID(roleId,companyId,Constants.ACCESS_CONTROL_AUTH_MATRIX_OF);
		
		
		
		//init the mapping bean
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat(Constants.DATE_FORMAT);
		String date = simpleDateFormat.format(new Date());
		
		//HttpSession session = request.getSession(false);
		AuthorisedMatrixActionForm authorisedMatrixActionForm = new AuthorisedMatrixActionForm();
		authorisedMatrixActionForm.setCompanyId(companyId);
		authorisedMatrixActionForm.setCreatedDTTM(date);
		authorisedMatrixActionForm.setMappingStatus(1);
		authorisedMatrixActionForm.setCreatedBY(userId);
		authorisedMatrixActionForm.setRoleId(roleId);
		authorisedMatrixActionForm.setAuthMatrixOf(Constants.ACCESS_CONTROL_AUTH_MATRIX_OF);
		
		
		AccessControlBean accessControlBean = (AccessControlBean)form;
		List <String> controlList = new  ArrayList<String>();
		if(accessControlBean.getEditableUnitCost()!=null)
			controlList.add(accessControlBean.getEditableUnitCost());
		if(accessControlBean.getOrderReportContol()!=null)
			controlList.add(accessControlBean.getOrderReportContol());
		if(accessControlBean.getShorderReportContol()!=null)
			controlList.add(accessControlBean.getShorderReportContol());
		if(accessControlBean.getAccountaccess()!= null )
			controlList.add(accessControlBean.getAccountaccess());
		if(accessControlBean.getCompanydetailac()!= null )
			controlList.add(accessControlBean.getCompanydetailac());
		if(accessControlBean.getSaleAccessControl()!= null )
			controlList.add(accessControlBean.getSaleAccessControl());
		
		if(accessControlBean.getOrderAccessControl()!= null )
			controlList.add(accessControlBean.getOrderAccessControl());
			//controlList = (List<String>) Arrays.asList(accessControlBean.getOrderAccessControl());
		//authorisedMatrixDBHelper.addAuthorisationMatrixList(authorisedMatrixActionForm, controlList);
		
		if(accessControlBean.getOrderListAccessControl()!= null )
			controlList.add(accessControlBean.getOrderListAccessControl());
			//controlList = (List<String>) Arrays.asList(accessControlBean.getOrderListAccessControl());
		//authorisedMatrixDBHelper.addAuthorisationMatrixList(authorisedMatrixActionForm, controlList);
		
		if(accessControlBean.getShowHideOrderAccessControl()!= null )
			controlList.add(accessControlBean.getShowHideOrderAccessControl());
			//controlList = (List<String>) Arrays.asList(accessControlBean.getShowHideOrderAccessControl());
		//authorisedMatrixDBHelper.addAuthorisationMatrixList(authorisedMatrixActionForm, controlList);
		
		if(accessControlBean.getReportAccessControl()!= null )
			controlList.add(accessControlBean.getReportAccessControl());
			//controlList = (List<String>) Arrays.asList(accessControlBean.getReportAccessControl());
		//authorisedMatrixDBHelper.addAuthorisationMatrixList(authorisedMatrixActionForm, controlList);
		
		if(accessControlBean.getOrderManagmentAccessControl()!= null )
			controlList.add(accessControlBean.getOrderManagmentAccessControl());
			//controlList = (List<String>) Arrays.asList(accessControlBean.getOrderManagmentAccessControl());
		//authorisedMatrixDBHelper.addAuthorisationMatrixList(authorisedMatrixActionForm, controlList);
		
		if(accessControlBean.getAccessControl()!= null )
			controlList.add(accessControlBean.getAccessControl());
			//controlList = (List<String>) Arrays.asList(accessControlBean.getAccessControl());
		//authorisedMatrixDBHelper.addAuthorisationMatrixList(authorisedMatrixActionForm, controlList);
		
		if(accessControlBean.getItemPriceAccessControl()!= null )
			controlList.add(accessControlBean.getItemPriceAccessControl());
			//controlList = (List<String>) Arrays.asList(accessControlBean.getItemPriceAccessControl());
		//authorisedMatrixDBHelper.addAuthorisationMatrixList(authorisedMatrixActionForm, controlList);
		
		if(accessControlBean.getSettingConfigureAccessControl()!= null )
			controlList.add(accessControlBean.getSettingConfigureAccessControl());
			//controlList = (List<String>) Arrays.asList(accessControlBean.getSettingConfigureAccessControl());
		//authorisedMatrixDBHelper.addAuthorisationMatrixList(authorisedMatrixActionForm, controlList);
		
		if(accessControlBean.getShowHideSettingAccessControl()!= null )
			controlList.add(accessControlBean.getShowHideSettingAccessControl());
			//controlList = (List<String>) Arrays.asList(accessControlBean.getShowHideSettingAccessControl());
		//authorisedMatrixDBHelper.addAuthorisationMatrixList(authorisedMatrixActionForm, controlList);
		
		//master
		
		if(accessControlBean.getPackageAccessControl()!= null )
			controlList.add(accessControlBean.getPackageAccessControl());
			//controlList = (List<String>) Arrays.asList(accessControlBean.getPackageAccessControl());
		//authorisedMatrixDBHelper.addAuthorisationMatrixList(authorisedMatrixActionForm, controlList);
		
		
		if(accessControlBean.getPackageListAccessControl()!= null )
			controlList.add(accessControlBean.getPackageListAccessControl());
			//controlList = (List<String>) Arrays.asList(accessControlBean.getPackageListAccessControl());
		//authorisedMatrixDBHelper.addAuthorisationMatrixList(authorisedMatrixActionForm, controlList);
		
		if(accessControlBean.getShowHidePackageAccessControl()!=null)
			controlList.add(accessControlBean.getShowHidePackageAccessControl());
			//controlList=(List<String>)Arrays.asList(accessControlBean.getShowHidePackageAccessControl());
		//authorisedMatrixDBHelper.addAuthorisationMatrixList(authorisedMatrixActionForm,controlList);
		
		if(accessControlBean.getItemAccessControl()!=null)
			controlList.add(accessControlBean.getItemAccessControl());
			//controlList=(List<String>)Arrays.asList(accessControlBean.getItemAccessControl());
		//authorisedMatrixDBHelper.addAuthorisationMatrixList(authorisedMatrixActionForm, controlList);
		
		if(accessControlBean.getItemListAccessControl()!=null)
			controlList.add(accessControlBean.getItemListAccessControl());
			//controlList=(List<String>)Arrays.asList(accessControlBean.getItemAccessListControl());
		//authorisedMatrixDBHelper.addAuthorisationMatrixList(authorisedMatrixActionForm, controlList);
		
		if(accessControlBean.getShowHideItemAccessControl()!=null)
			controlList.add(accessControlBean.getShowHideItemAccessControl());
			//controlList=(List<String>)Arrays.asList(accessControlBean.getShowHideItemAccessControl());
		//authorisedMatrixDBHelper.addAuthorisationMatrixList(authorisedMatrixActionForm, controlList);
		
		if(accessControlBean.getItemCategoryAccessControl()!=null)
			controlList.add(accessControlBean.getItemCategoryAccessControl());
			//controlList=(List<String>)Arrays.asList(accessControlBean.getItemCategoryAccessControl());
		//authorisedMatrixDBHelper.addAuthorisationMatrixList(authorisedMatrixActionForm, controlList);
		
		if(accessControlBean.getItemCategoryListAccessControl()!=null)
			controlList.add(accessControlBean.getItemCategoryListAccessControl());
			//controlList=(List<String>)Arrays.asList(accessControlBean.getItemCategoryListAccessControl());
		//authorisedMatrixDBHelper.addAuthorisationMatrixList(authorisedMatrixActionForm, controlList);
		
		if(accessControlBean.getShowHideItemCategoryAccessControl()!=null)
			controlList.add(accessControlBean.getShowHideItemCategoryAccessControl());
			//controlList=(List<String>)Arrays.asList(accessControlBean.getShowHideItemCategoryAccessControl());
		//authorisedMatrixDBHelper.addAuthorisationMatrixList(authorisedMatrixActionForm, controlList);
		
		
	 	if(accessControlBean.getCompanyAccessControl()!= null )
	 		controlList.add(accessControlBean.getCompanyAccessControl());
			//controlList = (List<String>) Arrays.asList(accessControlBean.getCompanyAccessControl());
		//authorisedMatrixDBHelper.addAuthorisationMatrixList(authorisedMatrixActionForm, controlList);
		
		
		if(accessControlBean.getCompanyListAccessControl()!= null )
			controlList.add(accessControlBean.getCompanyListAccessControl());
			//controlList = (List<String>) Arrays.asList(accessControlBean.getCompanyListAccessControl());
		//authorisedMatrixDBHelper.addAuthorisationMatrixList(authorisedMatrixActionForm, controlList);
		
		if(accessControlBean.getShowHideCompanyAccessControl()!=null)
			controlList.add(accessControlBean.getShowHideCompanyAccessControl());
			//controlList=(List<String>)Arrays.asList(accessControlBean.getShowHideCompanyAccessControl());
		//authorisedMatrixDBHelper.addAuthorisationMatrixList(authorisedMatrixActionForm,controlList);
		
		if(accessControlBean.getOrderStageAccessControl()!=null)
			controlList.add(accessControlBean.getOrderStageAccessControl());
			//controlList=(List<String>)Arrays.asList(accessControlBean.getOrderStageAccessControl());
		//authorisedMatrixDBHelper.addAuthorisationMatrixList(authorisedMatrixActionForm, controlList);
		
		if(accessControlBean.getOrderStageListAccessControl()!=null)
			controlList.add(accessControlBean.getOrderStageListAccessControl());
			//controlList=(List<String>)Arrays.asList(accessControlBean.getOrderStageListAccessControl());
		//authorisedMatrixDBHelper.addAuthorisationMatrixList(authorisedMatrixActionForm, controlList);
		
		if(accessControlBean.getShowHideOrderStageAccessControl()!=null)
			controlList.add(accessControlBean.getShowHideOrderStageAccessControl());
			//controlList=(List<String>)Arrays.asList(accessControlBean.getShowHideOrderStageAccessControl());
		//authorisedMatrixDBHelper.addAuthorisationMatrixList(authorisedMatrixActionForm, controlList);
		
		if(accessControlBean.getMeasurementAccessControl()!=null)
			controlList.add(accessControlBean.getMeasurementAccessControl());
			//controlList=(List<String>)Arrays.asList(accessControlBean.getMeasurementAccessControl());
		//authorisedMatrixDBHelper.addAuthorisationMatrixList(authorisedMatrixActionForm, controlList);
		
		if(accessControlBean.getMeasurementListAccessControl()!=null)
			controlList.add(accessControlBean.getMeasurementListAccessControl());
			//controlList=(List<String>)Arrays.asList(accessControlBean.getMeasurementListAccessControl());
		//authorisedMatrixDBHelper.addAuthorisationMatrixList(authorisedMatrixActionForm, controlList);
		
		if(accessControlBean.getShowHideMeasurementAccessControl()!=null)
			controlList.add(accessControlBean.getShowHideMeasurementAccessControl());
			//controlList=(List<String>)Arrays.asList(accessControlBean.getShowHideMeasurementAccessControl());
		//authorisedMatrixDBHelper.addAuthorisationMatrixList(authorisedMatrixActionForm, controlList);
		
	 	
	 	if(accessControlBean.getCustomerAccessControl()!= null )
	 		controlList.add(accessControlBean.getCustomerAccessControl());
			//controlList = (List<String>) Arrays.asList(accessControlBean.getCustomerAccessControl());
		//authorisedMatrixDBHelper.addAuthorisationMatrixList(authorisedMatrixActionForm, controlList);
		
		
		if(accessControlBean.getCustomerListAccessControl()!= null )
			controlList.add(accessControlBean.getCustomerListAccessControl());
			//controlList = (List<String>) Arrays.asList(accessControlBean.getCustomerListAccessControl());
		//authorisedMatrixDBHelper.addAuthorisationMatrixList(authorisedMatrixActionForm, controlList);
		
		if(accessControlBean.getShowHideCustomerAccessControl()!=null)
			controlList.add(accessControlBean.getShowHideCustomerAccessControl());
			//controlList=(List<String>)Arrays.asList(accessControlBean.getShowHideCustomerAccessControl());
		//authorisedMatrixDBHelper.addAuthorisationMatrixList(authorisedMatrixActionForm,controlList);
		
		if(accessControlBean.getUserAccessControl()!=null)
			controlList.add(accessControlBean.getUserAccessControl());
			//controlList=(List<String>)Arrays.asList(accessControlBean.getUserAccessControl());
		//authorisedMatrixDBHelper.addAuthorisationMatrixList(authorisedMatrixActionForm, controlList);
		
		if(accessControlBean.getUserListAccessControl()!=null)
			controlList.add(accessControlBean.getUserListAccessControl());
			//controlList=(List<String>)Arrays.asList(accessControlBean.getUserListAccessControl());
		//authorisedMatrixDBHelper.addAuthorisationMatrixList(authorisedMatrixActionForm, controlList);
		
		if(accessControlBean.getShowHideUserAccessControl()!=null)
			controlList.add(accessControlBean.getShowHideUserAccessControl());
			//controlList=(List<String>)Arrays.asList(accessControlBean.getShowHideUserAccessControl());
		//authorisedMatrixDBHelper.addAuthorisationMatrixList(authorisedMatrixActionForm, controlList);
		
		if(accessControlBean.getUserRoleAccessControl()!=null)
			controlList.add(accessControlBean.getUserRoleAccessControl());
			//controlList=(List<String>)Arrays.asList(accessControlBean.getUserRoleAccessControl());
		//authorisedMatrixDBHelper.addAuthorisationMatrixList(authorisedMatrixActionForm, controlList);
		
		if(accessControlBean.getUserRoleListAccessControl()!=null)
			controlList.add(accessControlBean.getUserRoleListAccessControl());
			//controlList=(List<String>)Arrays.asList(accessControlBean.getUserRoleListAccessControl());
		//authorisedMatrixDBHelper.addAuthorisationMatrixList(authorisedMatrixActionForm, controlList);
		
		if(accessControlBean.getShowHideUserRoleAccessControl()!=null)
			controlList.add(accessControlBean.getShowHideUserRoleAccessControl());
			//controlList=(List<String>)Arrays.asList(accessControlBean.getShowHideUserRoleAccessControl());
		//authorisedMatrixDBHelper.addAuthorisationMatrixList(authorisedMatrixActionForm, controlList);
		
		if(accessControlBean.getShowHideMasterDataAccessControl()!=null)
			controlList.add(accessControlBean.getShowHideMasterDataAccessControl());
			//controlList=(List<String>)Arrays.asList(accessControlBean.getShowHideMasterDataAccessControl());
		
		System.out.println("size "+controlList.size());
		
		authorisedMatrixDBHelper.addAuthorisationMatrixList(authorisedMatrixActionForm, controlList);
		
		//now add the new mappings.
		
		
		ArrayList <AuthorisedMatrixActionForm> authList= authorisedMatrixDBHelper.fetchAllRecords();
        Iterator <AuthorisedMatrixActionForm> authListIterator = authList.iterator();
        HashMap<Integer, String> accessRoles = new HashMap<Integer, String>();
        while(authListIterator.hasNext())
        {
        	AuthorisedMatrixActionForm tempAuthBean = authListIterator.next(); 
        	if(accessRoles.get(tempAuthBean.getRoleId()) == null )
        	{
        		accessRoles.put(tempAuthBean.getRoleId(), tempAuthBean.getModulekey());
        	}
        	accessRoles.put(tempAuthBean.getRoleId(), accessRoles.get(tempAuthBean.getRoleId()) + "," +tempAuthBean.getModulekey());
        }
        ((ServerAppContext)request.getServletContext().getAttribute(Constants.STRUTS_APPLICATION_CONTEXT)).setAccessRoles(accessRoles);

		return mapping.findForward(Constants.STRUTS_MAPPING_SUCCESS);
	}
	
	
}
