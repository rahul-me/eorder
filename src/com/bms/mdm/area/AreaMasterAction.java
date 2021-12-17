package com.bms.mdm.area;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionRedirect;

import com.bms.constants.Constants;
import com.bms.neetai.users.UserActionForm;
import com.bms.struts.SCMAction;

public class AreaMasterAction extends SCMAction{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		AreaActionForm areaActionForm=(AreaActionForm)form;
	
		HttpSession session=request.getSession(true);
		UserActionForm userActionForm=new UserActionForm();
		userActionForm=(UserActionForm) session.getAttribute(Constants.USER_BEAN);
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		AreaDBHelper areaDBHelper=new AreaDBHelper();
		
		if(areaActionForm.getAreaMasterId()>0){
			areaActionForm.setModifiedBY(userActionForm.getUserMasterId());
			areaActionForm.setModifiedDTTM(simpleDateFormat.format(new Date()));
			areaDBHelper.updateArea(areaActionForm);
			 ActionRedirect redirect = new ActionRedirect(mapping.findForward(Constants.STRUTS_MAPPING_SUCCESS));
			 redirect.addParameter("userRoll", areaActionForm.getAreaName());
			 return redirect;
		}
		else{
				areaActionForm.setCreatedBY(userActionForm.getUserMasterId());
				areaActionForm.setCreatedDTTM(simpleDateFormat.format(new Date()));
				int status=areaDBHelper.addArea(areaActionForm);
				String name= areaActionForm.getAreaName();
				if(status>0){
					  ActionRedirect redirect = new ActionRedirect(mapping.findForward(Constants.STRUTS_MAPPING_SUCCESS));
					  redirect.addParameter("userRoll", name);
					  return redirect;
					  //return mapping.findForward(Constants.STRUTS_MAPPING_SUCCESS);
					  }
				else{
					ActionRedirect redirect = new ActionRedirect(mapping.findForward(Constants.STRUTS_MAPPING_ERROR));
					redirect.addParameter("error", "Error");
					return redirect;
					//return mapping.findForward(Constants.STRUTS_MAPPING_ADD_ERROR);
				}
		
	}
}
}