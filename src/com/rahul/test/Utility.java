package com.rahul.test;

import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class Utility extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) {
		ResourceBundle resource = ResourceBundle.getBundle("applicationResource");
		return mapping.findForward("success");
	}
	
	
}
