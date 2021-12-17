package com.bms.sale;

import org.apache.commons.beanutils.BeanUtils;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionForm;

import com.bms.constants.Constants;
import com.bms.retail.RetailDBHelper;
import com.bms.sale.saledetail.SaleDetailActionForm;
import com.bms.neetai.userroles.UserRoleDBHelper;
import com.bms.neetai.users.UserDBHelper;
import com.bms.neetai.users.UserActionForm;

import java.lang.reflect.InvocationTargetException;
import java.lang.IllegalAccessException;

import java.text.SimpleDateFormat;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SaleViewAction extends Action {
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		HttpSession httpSession = request.getSession(true);
		int userid = (int)httpSession.getAttribute(Constants.SESSION_INFO_USER_ID);
		boolean updateflag = false;
		
		String update = request.getParameter("update");
		if(update!=null){
			if(update.equals("yes")){
				int saleMasterId = Integer.parseInt(request.getParameter("saleid"));
				httpSession.setAttribute("update", "yes");
				httpSession.setAttribute("saleid", saleMasterId);
				updateflag = true;
			}
		}
		
		
		UserRoleDBHelper roleHelper = new UserRoleDBHelper();
		UserDBHelper userHelper = new UserDBHelper();
		SaleDetailActionForm saleDetailBean = new SaleDetailActionForm();
		RetailDBHelper retailHelper = new RetailDBHelper();
		
		SimpleDateFormat formator1 = new SimpleDateFormat(Constants.DATE_FORMAT_DATE);
		saleDetailBean.setCreatedDate(formator1.format(new Date()));
		
		UserActionForm userBean = userHelper.getSingleUserByUserId(userid);
		roleHelper.getUserRoleByRoleId(userBean.getUserRolesMasterId());
		
		saleDetailBean.setRetailer(userBean.getFirstName()+" "+userBean.getLastName());
		if(updateflag){
			saleDetailBean.setUpdate(true);
			saleDetailBean.setSaleMasterIdForUpdate(Integer.parseInt(request.getParameter("saleid")));
		}else{
			saleDetailBean.setUpdate(false);
		}
		
		try{
		saleDetailBean.setRetailItems(retailHelper.getListOfItemsForRetailer(userid));
		}catch(Exception e){
			System.out.println("setRetailItems"+e);
		}
		
		try{
		BeanUtils.copyProperties(form, saleDetailBean);
		}catch(InvocationTargetException ite){
			System.out.println(ite);
		}
		catch(IllegalAccessException iae){
			System.out.println(iae);
		}
		 
		return mapping.findForward("success");
	}

}
