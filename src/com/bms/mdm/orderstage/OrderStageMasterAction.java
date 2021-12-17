package com.bms.mdm.orderstage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bms.constants.Constants;
import com.bms.context.ServerAppContext;
import com.bms.mdm.item.ItemActionForm;
import com.bms.neetai.users.UserActionForm;
import com.bms.struts.SCMAction;

public class OrderStageMasterAction extends SCMAction {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		OrderStageActionForm orderStageActionForm=(OrderStageActionForm)form;		
		OrderStageDBHelper orderStageDBHelper=new OrderStageDBHelper();
		ServerAppContext serverAppContext  = (ServerAppContext)request.getServletContext().getAttribute(Constants.STRUTS_APPLICATION_CONTEXT);
		
		HttpSession httpSession=request.getSession(true);
		UserActionForm userActionForm=(UserActionForm)httpSession.getAttribute(Constants.USER_BEAN);
		orderStageActionForm.setCreatedBy(userActionForm.getUserMasterId());
		int compid=(int)httpSession.getAttribute(Constants.COMPANY_ID);
		
		
		
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat(Constants.DATE_FORMAT);
		orderStageActionForm.setCreatedDTTM(simpleDateFormat.format(new Date()));
		 try{   
		        int OrderStageMasterId=Integer.parseInt(request.getParameter("orderStageMasterId"));
		        
		        
		        if(OrderStageMasterId>0)
		        {
		        	orderStageActionForm.setCompanyMasterId(compid);
		        	orderStageDBHelper.updateOrderStageEntry(orderStageActionForm);
		        	
		        	
		        	ArrayList<OrderStageActionForm> orderstageList=orderStageDBHelper.fetchAllRecords();
		        	serverAppContext.setOrderStageList(orderstageList);
		        	
		        	ArrayList<OrderStageActionForm>orderstageActiveList=orderStageDBHelper.fetchAllActiveOrderStage();
		        	serverAppContext.setOrderStageListByActiveOrderStage(orderstageActiveList);
		        	
		        	HashMap<Integer, OrderStageActionForm>orderStagebyid=new HashMap<Integer,OrderStageActionForm>();
		        	orderStagebyid=serverAppContext.getOrderStageByOrderStageMasterId();
		        	orderStagebyid.put(orderStageActionForm.getCompanyMasterId(),orderStageActionForm);
		        	serverAppContext.setOrderStageByOrderStageMasterId(orderStagebyid);
		        	
		        	ArrayList<OrderStageActionForm>orderStageByCompanyList=orderStageDBHelper.getOrderStageByCompanyId(compid);
					HashMap<Integer,ArrayList<OrderStageActionForm>>orderStageByCompanyId=new HashMap<Integer,ArrayList<OrderStageActionForm>>();
					orderStageByCompanyId=serverAppContext.getOrderStageByCompanyMasterId();
					orderStageByCompanyId.put(compid, orderStageByCompanyList);
					serverAppContext.setOrderStageByCompanyMasterId(orderStageByCompanyId);
		        	return mapping.findForward("success");
		        }
		        else
		        {
		        	orderStageActionForm.setCompanyMasterId(compid);
		        	int status=orderStageDBHelper.insertOrderStageEntry(orderStageActionForm);
		        	if(status>0){
		        	
		        	
		        	ArrayList<OrderStageActionForm> orderstageList=serverAppContext.getOrderStageList();
		        	orderstageList.add(orderStageActionForm);
		        	serverAppContext.setOrderStageList(orderstageList);
		        	
		        	ArrayList<OrderStageActionForm>orderstageActiveList=serverAppContext.getOrderStageListByActiveOrderStage();
		        	orderstageActiveList.add(orderStageActionForm);
		        	serverAppContext.setOrderStageListByActiveOrderStage(orderstageActiveList);
		        	
		        	orderStageActionForm.setOrderStageMasterId(status);
		        	HashMap<Integer, OrderStageActionForm>orderStagebyid=new HashMap<Integer,OrderStageActionForm>();
		        	orderStagebyid=serverAppContext.getOrderStageByOrderStageMasterId();
		        	orderStagebyid.put(status,orderStageActionForm);
		        	serverAppContext.setOrderStageByOrderStageMasterId(orderStagebyid);
		        	
		        	HashMap<Integer,ArrayList<OrderStageActionForm>>orderStageByCompanyId=new HashMap<Integer,ArrayList<OrderStageActionForm>>();
		        	
		        	ArrayList<OrderStageActionForm> orderStageByCompanyIdList=orderStageDBHelper.getOrderStageByCompanyId(orderStageActionForm.getCompanyMasterId());
		 
		        	if(orderStageByCompanyIdList!=null)
		        	{
		        		orderStageByCompanyId.put(orderStageByCompanyIdList.get(1).getCompanyMasterId(), orderStageByCompanyIdList);
		        	}
		        	serverAppContext.setOrderStageByCompanyMasterId(orderStageByCompanyId);
		        	
		        	/*orderStageByCompanyId=serverAppContext.getOrderStageByCompanyMasterId();
		        	ArrayList<OrderStageActionForm>orderStageByCompanyList=orderStageByCompanyId.get(compid);
		        	orderStageByCompanyList.add(orderStageActionForm);
		        	orderStageByCompanyId.put(compid, orderStageByCompanyList);
		        	serverAppContext.setOrderStageByCompanyMasterId(orderStageByCompanyId);*/
		        	
		    		return mapping.findForward("success");
		        	}
		        	
		        	
		        }
		     }
		     catch(Exception e)
				{
					e.printStackTrace();
				}
				
		 		return mapping.findForward("success");
			
				}
}
	

