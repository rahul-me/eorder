package com.bms.neetai.userroles;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bms.constants.Constants;
import com.bms.context.ServerAppContext;
import com.bms.neetai.company.CompanyActionForm;
import com.bms.neetai.users.UserActionForm;
import com.bms.struts.SCMAction;



public class UserRoleMasterAction extends SCMAction {
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
			ServerAppContext serverAppContext  = (ServerAppContext)request.getServletContext().getAttribute(Constants.STRUTS_APPLICATION_CONTEXT);
			UserRoleActionForm userRoleActionForm=(UserRoleActionForm)form;
			UserRoleDBHelper userRoleDBHelper=new UserRoleDBHelper();
		 
		
			HttpSession httpSession=request.getSession(true);
			UserActionForm userActionForm=(UserActionForm)httpSession.getAttribute(Constants.USER_BEAN);
	
			System.out.println("Calling");
			userRoleActionForm.setCreatedBY(userActionForm.getUserMasterId());
			int compid=(int)httpSession.getAttribute(Constants.COMPANY_ID);
			
			SimpleDateFormat simpleDateFormat=new SimpleDateFormat(Constants.DATE_FORMAT);
			userRoleActionForm.setCreatedDTTM(simpleDateFormat.format(new Date()));
			
		        	
		  int userroleid=Integer.parseInt(request.getParameter("userRolesMasterId"));
		  if(userroleid>0)
		  {
			    userActionForm.setCompanyMasterId(compid);
			    userRoleActionForm.setCompanyMasterId(userActionForm.getCompanyMasterId());
			  	userRoleDBHelper.updateUserRole(userRoleActionForm);
			  	userRoleActionForm.setCompanyMasterId(compid);
			  	
			  	
				userActionForm.setCompanyMasterId(compid);
				
				
			 	
			 	ArrayList<UserRoleActionForm>userRollList=userRoleDBHelper.fetchAllRecords();
				serverAppContext.setUserRollList(userRollList);
				
				ArrayList<UserRoleActionForm>userRollActiveList=userRoleDBHelper.fetchAllActiveuserRoll();
				serverAppContext.setUserRollListByActiveUserRole(userRollActiveList);
						
				HashMap<Integer, UserRoleActionForm>userRollbyid=new HashMap<Integer,UserRoleActionForm>();
				userRollbyid=serverAppContext.getUserRollByUserRollMasterId();
				serverAppContext.setUserRollByUserRollMasterId(userRollbyid);
				
				ArrayList<UserRoleActionForm>userRollByCompanyList=userRoleDBHelper.getUserRollByCompanyId(compid);
				HashMap<Integer,ArrayList<UserRoleActionForm>>userRollByCompanyId=new HashMap<Integer,ArrayList<UserRoleActionForm>>();
				userRollByCompanyId=serverAppContext.getUserRollByCompanyMasterId();
				userRollByCompanyId.put(compid, userRollByCompanyList);
				serverAppContext.setUserRollByCompanyMasterId(userRollByCompanyId);
				
				
				return mapping.findForward(Constants.STRUTS_MAPPING_SUCCESS);
		  }
		  else
		  {
			 
			  userRoleActionForm.setCompanyMasterId(userActionForm.getCompanyMasterId());
			  userActionForm.setCompanyMasterId(compid);
			  int status=userRoleDBHelper.addUser(userRoleActionForm);
			  System.out.println("Status is"+status);
			//  userRoleDBHelper.updateUserRole(userRoleActionForm);
			  if(status>0){
				  	
				  	ArrayList<UserRoleActionForm>userRollList=serverAppContext.getUserRollList();
				  	userRollList.add(userRoleActionForm);
					serverAppContext.setUserRollList(userRollList);
					
					ArrayList<UserRoleActionForm>userRollActiveList=serverAppContext.getUserRollListByActiveUserRole();
					userRollActiveList.add(userRoleActionForm);
					serverAppContext.setUserRollListByActiveUserRole(userRollActiveList);
					
					userRoleActionForm.setUserRolesMasterId(status);		
					HashMap<Integer, UserRoleActionForm>userRollbyid=new HashMap<Integer,UserRoleActionForm>();
					userRollbyid=serverAppContext.getUserRollByUserRollMasterId();
					userRollbyid.put(status, userRoleActionForm);
					serverAppContext.setUserRollByUserRollMasterId(userRollbyid);
					
					
					
					HashMap<Integer, ArrayList<UserRoleActionForm>>userRoleByCompanyId=new HashMap<Integer,ArrayList<UserRoleActionForm>>();
					ArrayList<UserRoleActionForm> UserrollByDisaticCompany = userRoleDBHelper.fetchAllDistinctCompany();
					if(UserrollByDisaticCompany!=null)
					for(int i=0;i<UserrollByDisaticCompany.size();i++)
					{
						ArrayList<UserRoleActionForm>userRoleByCompanyList=userRoleDBHelper.getUserRollByCompanyId(UserrollByDisaticCompany.get(i).getCompanyMasterId());
						if(userRoleByCompanyList!=null)
						{			
						int id=userRoleByCompanyList.get(0).getCompanyMasterId();
						userRoleByCompanyId.put(id, userRoleByCompanyList);											  			
						}
					}
					serverAppContext.setUserRollByCompanyMasterId(userRoleByCompanyId);
					
				/*	ArrayList<UserRoleActionForm>userRollByCompanyList=new ArrayList<>();
					
					System.out.println("roll by company size"+userRollByCompanyId.size());
					
					if(userRollByCompanyId.size()>1){
						userRollByCompanyList=userRollByCompanyId.get(compid);
					}
					
					System.out.println("id "+userRoleActionForm.getCompanyMasterId());
				//	System.out.println("size "+userRollByCompanyList.size());
					
					userRollByCompanyList.add(userRoleActionForm);
					userRollByCompanyId.put(compid, userRollByCompanyList);
					serverAppContext.setUserRollByCompanyMasterId(userRollByCompanyId);
				*/	
					
			  }
					return mapping.findForward(Constants.STRUTS_MAPPING_SUCCESS);
		  }
		
		
		  
			
		
	}
  
}
