package com.bms.mdm.itemcategories;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bms.constants.Constants;
import com.bms.context.ServerAppContext;
import com.bms.neetai.company.CompanyActionForm;
import com.bms.neetai.company.CompanyDBHelper;
import com.bms.neetai.users.UserActionForm;
import com.bms.struts.SCMAction;


public class ItemCategoryViewAction extends SCMAction{

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	
		
		ItemCategoryActionForm itemCategoryActionForm=(ItemCategoryActionForm)form;
		ServerAppContext serverAppContext  = (ServerAppContext)request.getServletContext().getAttribute(Constants.STRUTS_APPLICATION_CONTEXT);
		
		HttpSession session=request.getSession(true);
		UserActionForm actionForm=(UserActionForm)session.getAttribute(Constants.USER_BEAN);
		int userId=actionForm.getUserMasterId();
		int compid=(int)session.getAttribute(Constants.COMPANY_ID);
		try
		{
		if(request.getParameter("itemCategoryId")!=null)
		{
		int catId=Integer.parseInt(request.getParameter("itemCategoryId"));	
		itemCategoryActionForm=serverAppContext.getItemCategoryByItemCategoryMasterId().get(catId);			
		itemCategoryActionForm.setItemCategoryMasterId(catId);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		ArrayList<ItemCategoryActionForm> itemCategoryList=serverAppContext.getItemCategoryByCompanyId().get(compid);
		if(itemCategoryList!=null){
		itemCategoryActionForm.setItemCategoryList(itemCategoryList);
		}
	
		
		
		
		
		if(request.getParameter("update")!=null){
				ActionErrors actionErrors=new ActionErrors();
				actionErrors.add("mehul",new ActionMessage("errors.purchase.update.successful"));
				saveErrors(request, actionErrors);
				//itemCategoryActionForm.setAlertMsg(request.getParameter("update"));
				
		}else if(request.getParameter("insert")!=null){
				ActionErrors actionErrors=new ActionErrors();
				actionErrors.add("mehul",new ActionMessage("errors.purchase.insert.successful"));
				saveErrors(request, actionErrors);
				//itemCategoryActionForm.setAlertMsg(request.getParameter("insert"));
			}else if(request.getParameter("delete")!=null){
				ActionErrors actionErrors=new ActionErrors();
				actionErrors.add("mehul",new ActionMessage("errors.purchase.delete.successful"));
				saveErrors(request, actionErrors);
				//itemCategoryActionForm.setAlertMsg(request.getParameter("delete"));
			}
		
			else if(request.getParameter("error")!=null)
			{
				ActionErrors actionErrors=new ActionErrors();
						actionErrors.add("mehul",new ActionMessage("errors.purchase.insert.error"));
						saveErrors(request, actionErrors);
			}
		BeanUtils.copyProperties(form,itemCategoryActionForm);
		return mapping.findForward("success");
	
}
}