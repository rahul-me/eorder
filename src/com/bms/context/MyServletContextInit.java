package com.bms.context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.print.attribute.standard.Severity;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;

import org.quartz.impl.StdSchedulerFactory;

import com.bms.constants.Constants;
import com.bms.mdm.authorizationmatrix.AuthorisedMatrixActionForm;
import com.bms.mdm.authorizationmatrix.AuthorisedMatrixDBHelper;
import com.bms.neetai.company.CompanyActionForm;
import com.bms.neetai.company.CompanyDBHelper;
import com.bms.neetai.userroles.UserRoleActionForm;
import com.bms.neetai.userroles.UserRoleDBHelper;
import com.bms.neetai.users.UserActionForm;
import com.bms.neetai.users.UserDBHelper;
import com.bms.mdm.item.ItemActionForm;
import com.bms.mdm.item.ItemDBHelper;
import com.bms.mdm.itemcategories.ItemCategoriesDBHelper;
import com.bms.mdm.itemcategories.ItemCategoryActionForm;
import com.bms.mdm.measurement.MeasurementActionForm;
import com.bms.mdm.measurement.MeasurementDBHelper;
import com.bms.mdm.orderstage.OrderStageActionForm;
import com.bms.mdm.orderstage.OrderStageDBHelper;
import com.bms.neetai.company.CompanyActionForm;
import com.bms.neetai.company.CompanyDBHelper;
import com.bms.neetai.userroles.UserRoleActionForm;
import com.bms.neetai.userroles.UserRoleDBHelper;
import com.bms.neetai.users.UserActionForm;
import com.bms.neetai.users.UserDBHelper;



public class MyServletContextInit implements ServletContextListener{

	
	private ServerAppContext serverAppContext;
	private StdSchedulerFactory factory = null;
	
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
		
		serverAppContext = new ServerAppContext();		
		arg0.getServletContext().setAttribute(Constants.STRUTS_APPLICATION_CONTEXT, serverAppContext);
		
		
			
		CompanyDBHelper companyDBHelper=new CompanyDBHelper();
		ArrayList<CompanyActionForm>companyFormList=companyDBHelper.getAllCompany();
		serverAppContext.setCompanyList(companyFormList);
		
		ArrayList<CompanyActionForm>companyActiveFormList=companyDBHelper.fetchAllActiveCompanyRecords();
		serverAppContext.setCompanyListByActiveCompany(companyActiveFormList);
		
		HashMap<Integer, CompanyActionForm>companybyid=new HashMap<Integer,CompanyActionForm>();
		Iterator<CompanyActionForm>iterator3=companyFormList.iterator();
		while(iterator3.hasNext())
		{
			CompanyActionForm companyActionForm=iterator3.next();
			companybyid.put(companyActionForm.getCompanyMasterId(),companyActionForm);
			
		}
		((ServerAppContext)arg0.getServletContext().getAttribute(Constants.STRUTS_APPLICATION_CONTEXT)).setCompanyByCompanyMasterId(companybyid);
		
		
		ItemDBHelper itemDBHelper=new ItemDBHelper();
		ArrayList<ItemActionForm>itemFormList=itemDBHelper.fetchAllRecords();	
		serverAppContext.setItemList(itemFormList);
		
		ArrayList<ItemActionForm>itemActiveFormList=itemDBHelper.fetchAllActiveItemRecords();
		serverAppContext.setItemListByActiveItem(itemActiveFormList);		
		
		HashMap<Integer, ItemActionForm> itembyitemMasterId=new HashMap<Integer,ItemActionForm>();
		Iterator<ItemActionForm> iterator34=itemFormList.iterator();		
		while(iterator34.hasNext())
		{
			ItemActionForm itemActionForm=iterator34.next();			
			itembyitemMasterId.put(itemActionForm.getItemMasterId(), itemActionForm);
		}
		((ServerAppContext)arg0.getServletContext().getAttribute(Constants.STRUTS_APPLICATION_CONTEXT)).setItemByItemMasterId(itembyitemMasterId);
		
		HashMap<Integer, ArrayList<ItemActionForm>>itemByCompanyId=new HashMap<Integer,ArrayList<ItemActionForm>>();
		ArrayList<ItemActionForm>disticcompanyList=itemDBHelper.getAlldistinctCompany();
		if(disticcompanyList!=null)
		for(int i=0;i<disticcompanyList.size();i++){
		ArrayList<ItemActionForm>itemByCompanyList=itemDBHelper.getItemByCompanyId(disticcompanyList.get(i).getCompanyMasterId());		
		if(itemByCompanyList!=null){			
			int id=itemByCompanyList.get(0).getCompanyMasterId();
			itemByCompanyId.put(id, itemByCompanyList);			
					  			
			}
		
		}
		((ServerAppContext)arg0.getServletContext().getAttribute(Constants.STRUTS_APPLICATION_CONTEXT)).setItemByCompanyId(itemByCompanyId);
		
		
		
		ItemCategoriesDBHelper itemCategoriesDBHelper=new ItemCategoriesDBHelper();
		ArrayList<ItemCategoryActionForm>itemCategoryFormList=itemCategoriesDBHelper.fetchAllRecords();
		serverAppContext.setItemCategoryList(itemCategoryFormList);
		ArrayList<ItemCategoryActionForm>itemcategoryActiveFormList=itemCategoriesDBHelper.fetchAllActiveItemCategoriesRecords();
		serverAppContext.setItemCategoryListByActiveitemCategory(itemcategoryActiveFormList);
		HashMap<Integer, ItemCategoryActionForm>itemcategoriesbyid=new HashMap<Integer,ItemCategoryActionForm>();
		Iterator<ItemCategoryActionForm>iterator2=itemCategoryFormList.iterator();
		while(iterator2.hasNext())
		{
				ItemCategoryActionForm itemCategoryActionForm=iterator2.next();
				itemcategoriesbyid.put(itemCategoryActionForm.getItemCategoryMasterId(), itemCategoryActionForm);
			
		}		
		((ServerAppContext)arg0.getServletContext().getAttribute(Constants.STRUTS_APPLICATION_CONTEXT)).setItemCategoryByItemCategoryMasterId(itemcategoriesbyid);
		
		HashMap<Integer, ArrayList<ItemCategoryActionForm>>itemcategoryByCompanyId=new HashMap<Integer,ArrayList<ItemCategoryActionForm>>();
		ArrayList<ItemCategoryActionForm>disticcompanyList1=itemCategoriesDBHelper.getAlldistinctCompany();
		if(disticcompanyList1!=null)
		for(int i=0;i<disticcompanyList1.size();i++){
		ArrayList<ItemCategoryActionForm>itemCategoryByCompanyList=itemCategoriesDBHelper.getItemCategoryByCompanyId(disticcompanyList1.get(i).getCompanyMasterId());
		if(itemCategoryByCompanyList!=null){			
			int id=itemCategoryByCompanyList.get(0).getCompanyMasterId();
			itemcategoryByCompanyId.put(id,itemCategoryByCompanyList);			
					  			
			}
		}
		((ServerAppContext)arg0.getServletContext().getAttribute(Constants.STRUTS_APPLICATION_CONTEXT)).setItemCategoryByCompanyId(itemcategoryByCompanyId);
		
		
		OrderStageDBHelper orderStageDBHelper=new OrderStageDBHelper();
		ArrayList<OrderStageActionForm>orderStageFormList=orderStageDBHelper.fetchAllRecords();
		serverAppContext.setOrderStageList(orderStageFormList);
		
		ArrayList<OrderStageActionForm>orderStageActiveFormList=orderStageDBHelper.fetchAllActiveOrderStage();
		serverAppContext.setOrderStageListByActiveOrderStage(orderStageActiveFormList);
		
		HashMap<Integer, OrderStageActionForm>orderStagebyid=new HashMap<Integer,OrderStageActionForm>();
		Iterator<OrderStageActionForm>iterator4=orderStageActiveFormList.iterator();
		while(iterator4.hasNext())
		{
			OrderStageActionForm orderStageActionForm=iterator4.next();
			orderStagebyid.put(orderStageActionForm.getOrderStageMasterId(),orderStageActionForm);
			
		}
		((ServerAppContext)arg0.getServletContext().getAttribute(Constants.STRUTS_APPLICATION_CONTEXT)).setOrderStageByOrderStageMasterId(orderStagebyid);
		
		
		HashMap<Integer, ArrayList<OrderStageActionForm>>orderStageByCompanyId=new HashMap<Integer,ArrayList<OrderStageActionForm>>();
		ArrayList<OrderStageActionForm>disticcompanyList2=orderStageDBHelper.fetchAllDistinctCompany();
		if(disticcompanyList2!=null)
		for(int i=0;i<disticcompanyList2.size();i++){
		ArrayList<OrderStageActionForm>orderStageByCompanyList=orderStageDBHelper.getOrderStageByCompanyId(disticcompanyList2.get(i).getCompanyMasterId());
		if(orderStageByCompanyList!=null){			
			int id=orderStageByCompanyList.get(0).getCompanyMasterId();
			orderStageByCompanyId.put(id,orderStageByCompanyList);			
					  			
			}
		}
		((ServerAppContext)arg0.getServletContext().getAttribute(Constants.STRUTS_APPLICATION_CONTEXT)).setOrderStageByCompanyMasterId(orderStageByCompanyId);
		
		
		MeasurementDBHelper measurementDBHelper=new MeasurementDBHelper();
		ArrayList<MeasurementActionForm>measurementFormList=measurementDBHelper.fetchAllRecords();
		serverAppContext.setMeasurementList(measurementFormList);
		
		ArrayList<MeasurementActionForm>measurementActiveFormList=measurementDBHelper.fetchAllActiveMeasurementRecords();
		serverAppContext.setMeasurementListByActiveMeasurement(measurementActiveFormList);
		
		HashMap<Integer, MeasurementActionForm>measurementbyid=new HashMap<Integer,MeasurementActionForm>();
		Iterator<MeasurementActionForm>iterator5=measurementFormList.iterator();
		while(iterator5.hasNext())
		{
			MeasurementActionForm measurementActionForm=iterator5.next();
			measurementbyid.put(measurementActionForm.getMeasurementMasterId(),measurementActionForm);
			
		}
		((ServerAppContext)arg0.getServletContext().getAttribute(Constants.STRUTS_APPLICATION_CONTEXT)).setMeasurementByMeasurementMasterId(measurementbyid);
		
		HashMap<Integer, ArrayList<MeasurementActionForm>>measurementByCompanyId=new HashMap<Integer,ArrayList<MeasurementActionForm>>();
		ArrayList<MeasurementActionForm>disticcompanyList3=measurementDBHelper.fetchAllDistinctCompany();
		if(disticcompanyList3!=null)
		for(int i=0;i<disticcompanyList3.size();i++){
		ArrayList<MeasurementActionForm>measurementByCompanyList=measurementDBHelper.getMeasurementByCompanyId(disticcompanyList3.get(i).getCompanyMasterId());
		if(measurementByCompanyList!=null){			
			int id=measurementByCompanyList.get(0).getCompanyMasterId();
			measurementByCompanyId.put(id,measurementByCompanyList);			
					  			
			}
		}
		((ServerAppContext)arg0.getServletContext().getAttribute(Constants.STRUTS_APPLICATION_CONTEXT)).setMeasurementByCompanyMasterId(measurementByCompanyId);
		
		
		UserDBHelper userDBHelper=new UserDBHelper();
		ArrayList<UserActionForm>userFormList=userDBHelper.getAllUsers();
		serverAppContext.setUserList(userFormList);
		
		ArrayList<UserActionForm>userActiveFormList=userDBHelper.fetchAllActiveUser();
		serverAppContext.setUserListByActiveUser(userActiveFormList);
		
		HashMap<Integer, UserActionForm>userbyid=new HashMap<Integer,UserActionForm>();
		Iterator<UserActionForm>iterator6=userActiveFormList.iterator();
		while(iterator6.hasNext())
		{
			UserActionForm userActionForm=iterator6.next();
			userbyid.put(userActionForm.getUserMasterId(),userActionForm);
			
		}
		((ServerAppContext)arg0.getServletContext().getAttribute(Constants.STRUTS_APPLICATION_CONTEXT)).setUserByUserMasterId(userbyid);
		
		HashMap<Integer, ArrayList<UserActionForm>>UserByCompanyId=new HashMap<Integer,ArrayList<UserActionForm>>();
		ArrayList<UserActionForm>userFormdisticComapnyList=userDBHelper.fetchAllDistinctCompany();
		if(userFormdisticComapnyList!=null)
		for(int i=0;i<userFormdisticComapnyList.size();i++){
		ArrayList<UserActionForm>userByCompanyList=userDBHelper.userByCompanyId(userFormdisticComapnyList.get(i).getCompanyMasterId());		
		if(userByCompanyList!=null){			
			int id=userByCompanyList.get(0).getCompanyMasterId();
			UserByCompanyId.put(id, userByCompanyList);			
					  			
			}
		}
		
		((ServerAppContext)arg0.getServletContext().getAttribute(Constants.STRUTS_APPLICATION_CONTEXT)).setUserByCompanyId(UserByCompanyId);
		
				
		UserRoleDBHelper userRoleDBHelper=new UserRoleDBHelper();
		ArrayList<UserRoleActionForm>userRollList=userRoleDBHelper.fetchAllRecords();
		serverAppContext.setUserRollList(userRollList);
		
		ArrayList<UserRoleActionForm>userRollActiveList=userRoleDBHelper.fetchAllActiveuserRoll();
		serverAppContext.setUserRollListByActiveUserRole(userRollActiveList);
				
		HashMap<Integer, UserRoleActionForm>userRollbyid=new HashMap<Integer,UserRoleActionForm>();
		Iterator<UserRoleActionForm>iterator7=userRollList.iterator();
		while(iterator7.hasNext())
		{
			UserRoleActionForm userRollActionForm=iterator7.next();
			userRollbyid.put(userRollActionForm.getUserRolesMasterId(),userRollActionForm);
			
		}
		HashMap<Integer, ArrayList<UserRoleActionForm>>userRoleByCompanyId=new HashMap<Integer,ArrayList<UserRoleActionForm>>();
		ArrayList<UserRoleActionForm>UserrollByDisaticCompany=userRoleDBHelper.fetchAllDistinctCompany();
		if(UserrollByDisaticCompany!=null)
		for(int i=0;i<UserrollByDisaticCompany.size();i++){
		ArrayList<UserRoleActionForm>userRoleByCompanyList=userRoleDBHelper.getUserRollByCompanyId(UserrollByDisaticCompany.get(i).getCompanyMasterId());
		if(userRoleByCompanyList!=null){			
			int id=userRoleByCompanyList.get(0).getCompanyMasterId();
			userRoleByCompanyId.put(id, userRoleByCompanyList);			
					  			
			}
		}
		((ServerAppContext)arg0.getServletContext().getAttribute(Constants.STRUTS_APPLICATION_CONTEXT)).setUserRollByCompanyMasterId(userRoleByCompanyId);
		
		
		HashMap<Integer, UserRoleActionForm> userRoleMap=new HashMap<Integer,UserRoleActionForm>();
		Iterator<UserRoleActionForm> iterator8=userRollList.iterator();
		while(iterator8.hasNext())
		{
			UserRoleActionForm userRoleActionForm=iterator8.next();
			userRoleMap.put(userRoleActionForm.getUserRolesMasterId(),userRoleActionForm);
			
		}
		
		((ServerAppContext)arg0.getServletContext().getAttribute(Constants.STRUTS_APPLICATION_CONTEXT)).setUserRollByUserRollMasterId(userRoleMap);
		
		AuthorisedMatrixDBHelper authorisedMatrixDBHelper=new AuthorisedMatrixDBHelper();
		ArrayList<AuthorisedMatrixActionForm>authorisedMatrixRoleModuleList=authorisedMatrixDBHelper.fetchAllRecords();
		
		HashMap<Integer, String> authHashMap=new HashMap<Integer, String>();
		if(authorisedMatrixRoleModuleList!=null)
		{
			String moduleKey=null;
			Iterator authIterator=authorisedMatrixRoleModuleList.iterator();
			while(authIterator.hasNext())
			{
				
				
				AuthorisedMatrixActionForm authorisedMatrixActionForm=(AuthorisedMatrixActionForm)authIterator.next();
				if(authorisedMatrixActionForm!=null && authorisedMatrixActionForm.getAuthMatrixId()>0 && authorisedMatrixActionForm.getMappingStatus()==1)
				{
					if(authHashMap.containsKey(authorisedMatrixActionForm.getRoleId()))
					{
						moduleKey=authHashMap.get(authorisedMatrixActionForm.getRoleId());
						authHashMap.put(authorisedMatrixActionForm.getRoleId(),moduleKey.concat(authorisedMatrixActionForm.getModulekey()));
					}
					else
					{
						authHashMap.put(authorisedMatrixActionForm.getRoleId(),authorisedMatrixActionForm.getModulekey());
					}
				}
			}
			((ServerAppContext)arg0.getServletContext().getAttribute(Constants.STRUTS_APPLICATION_CONTEXT)).setAccessRoles(authHashMap);
		}
			
	}
}
