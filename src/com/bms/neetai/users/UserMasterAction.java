package com.bms.neetai.users;

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
import com.bms.neetai.userroles.UserRoleActionForm;
import com.bms.neetai.userroles.UserRoleDBHelper;
import com.bms.struts.SCMAction;

public class UserMasterAction extends SCMAction{

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		
		UserActionForm userActionForm= (UserActionForm)form; 
		ServerAppContext serverAppContext  = (ServerAppContext)request.getServletContext().getAttribute(Constants.STRUTS_APPLICATION_CONTEXT); 
		HttpSession httpSession=request.getSession(true);
		UserActionForm userActionFormSessiosn=(UserActionForm)httpSession.getAttribute(Constants.USER_BEAN);
		//userActionForm.setCreatedBy(userActionForm.getUserMasterId());
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat(Constants.DATE_FORMAT);
		int compid=(int)httpSession.getAttribute(Constants.COMPANY_ID);
		
		 UserRoleDBHelper userRoleDBHelper = new UserRoleDBHelper();
		 UserDBHelper userDBHelper=new  UserDBHelper(); 		
		 int userid=userActionForm.getUserMasterId();
		 int custid=userActionForm.getCustomerMasterId();
		 //UserRoleActionForm userRoleActionForm=serverAppContext.getUserRollByUserRollMasterId().get(userActionForm.getUserRolesMasterId());
		 UserRoleActionForm userRoleActionForm = userRoleDBHelper.getUserRoleByRoleId(userActionForm.getUserRolesMasterId());
      	
      	if(userid>0 || custid>0 )
      	{   		
      		if(request.getParameter("companyMasterId")==null)
      		{
      			userActionForm.setCompanyMasterId(compid);
      		}
      		if(userRoleActionForm!=null){
          		userActionForm.setUserRoleName(userRoleActionForm.getName());}
      		userActionForm.setModifiedBy(userActionFormSessiosn.getUserMasterId());
      		userActionForm.setModifiedDTTM(simpleDateFormat.format(new Date()));
      		
      		if(request.getParameter("customerMasterId")!=null){
      			userActionForm.setUserRolesMasterId(Constants.USERROLL_MASTERID);
      			userActionForm.setUserRoleName("customer");
      		}
      		else if(request.getParameter("userMasterId")!=null){      			
      		}
      		if(userActionForm.getIsActive()==Constants.USER_STATUS_IN_ACTIVE)
      			userActionForm.setIsActive(Constants.USER_STATUS_ACTIVE);
      		else
      			userActionForm.setIsActive(Constants.USER_STATUS_IN_ACTIVE);
      			
      		userDBHelper.updateUser(userActionForm);
      		ArrayList<UserActionForm>userFormList=userDBHelper.getAllUsers();
    		serverAppContext.setUserList(userFormList);
    		
    		ArrayList<UserActionForm>userActiveFormList=userDBHelper.fetchAllActiveUser();
    		serverAppContext.setUserListByActiveUser(userActiveFormList);
    		
    		HashMap<Integer, UserActionForm>userbyid=new HashMap<Integer,UserActionForm>();    		
    		userbyid=serverAppContext.getUserByUserMasterId();
    		userbyid.put(userActionForm.getUserMasterId(),userActionForm);
    		serverAppContext.setUserByUserMasterId(userbyid);
    		
    		ArrayList<UserActionForm>userByCompanyList=userDBHelper.userByCompanyId(compid);
			HashMap<Integer,ArrayList<UserActionForm>>userByCompanyId=new HashMap<Integer,ArrayList<UserActionForm>>();
			userByCompanyId=serverAppContext.getUserByCompanyId();
			userByCompanyId.put(compid, userByCompanyList);
			serverAppContext.setUserByCompanyId(userByCompanyId);
    		
			if(request.getParameter("customerMasterId")!=null){
				return mapping.findForward("success1");
			}
    		
    		return mapping.findForward(Constants.STRUTS_MAPPING_SUCCESS);
      	}
      	else
      	{
      		
      		if(userRoleActionForm!=null){
      		userActionForm.setUserRoleName(userRoleActionForm.getName());}
      		if(request.getParameter("companyMasterId")==null)
      		{
      			userActionForm.setCompanyMasterId(compid);
      		}
      		if(request.getParameter("customerMasterId")!=null){
      			userActionForm.setUserRolesMasterId(Constants.USERROLL_MASTERID);
      			userActionForm.setUserRoleName("customer");
      		}
      		else if(request.getParameter("userMasterId")!=null)
      		userActionForm.setCreatedBy(userActionFormSessiosn.getUserMasterId());
      		userActionForm.setCreatedDTTM(simpleDateFormat.format(new Date()));
   		 
      		if(userActionForm.getIsActive()==Constants.USER_STATUS_IN_ACTIVE)
      			userActionForm.setIsActive(Constants.USER_STATUS_ACTIVE);
      		else
      			userActionForm.setIsActive(Constants.USER_STATUS_IN_ACTIVE);
      			
      		int status=userDBHelper.addUser(userActionForm);
      		if(status>0){
      		      		
	      		ArrayList<UserActionForm>userFormList=serverAppContext.getUserList();
	      		userFormList.add(userActionForm);
	    		serverAppContext.setUserList(userFormList);
	    		
	    		ArrayList<UserActionForm>userActiveFormList=serverAppContext.getUserListByActiveUser();
	    		userActiveFormList.add(userActionForm);
	    		serverAppContext.setUserListByActiveUser(userActiveFormList);
	    		
	    		userActionForm.setUserMasterId(status);
	    		
	    		HashMap<Integer, UserActionForm>userbyid=new HashMap<Integer,UserActionForm>();
	    		userbyid=serverAppContext.getUserByUserMasterId();
	    		userbyid.put(status,userActionForm);
	    		serverAppContext.setUserByUserMasterId(userbyid);
	    		
	    		HashMap<Integer, ArrayList<UserActionForm>>userByCompanyId=new HashMap<Integer,ArrayList<UserActionForm>>();
	    		ArrayList<UserActionForm> userByCompany=userDBHelper.fetchAllDistinctCompany();
	    		if(userByCompany!=null)
	    		{
	    			for(int i=0;i<userByCompany.size();i++)
	    			{
	    				ArrayList<UserActionForm> userByComapnyMasterId=userDBHelper.userByCompanyId(userByCompany.get(i).getCompanyMasterId());
	    				if(userByComapnyMasterId!=null)
	    				{
	    					int id=userByComapnyMasterId.get(0).getCompanyMasterId();
	    					userByCompanyId.put(id, userByComapnyMasterId);
	    				}
	    			}
	    		}
	    		serverAppContext.setUserByCompanyId(userByCompanyId);
	    		
	    		
	    		
	    		/*userByCompanyId=serverAppContext.getUserByCompanyId();
	    		ArrayList<UserActionForm>userByCompanyList=userByCompanyId.get(compid);
	    		userByCompanyId.put(compid, userByCompanyList);
	    		serverAppContext.setUserByCompanyId(userByCompanyId);*/
	    		
	    		if(request.getParameter("customerMasterId")!=null){
	    			return mapping.findForward("success1");
	    		}
	    		
	    		
      		}
      		
      		
      		return mapping.findForward(Constants.STRUTS_MAPPING_SUCCESS);
      		
      	}
					 
}
	
}