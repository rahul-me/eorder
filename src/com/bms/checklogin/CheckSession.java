package com.bms.checklogin;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class CheckSession extends Action {
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	{
		HttpSession httpSession = request.getSession();
		Enumeration<String>  sessionNames = httpSession.getAttributeNames();
		while(sessionNames.hasMoreElements())
		{
			String sname = sessionNames.nextElement();
		}
		return mapping.findForward("available");
	}

}
