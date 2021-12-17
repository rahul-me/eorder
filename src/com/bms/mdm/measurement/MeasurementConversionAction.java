package com.bms.mdm.measurement;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionRedirect;

import com.bms.constants.Constants;
import com.bms.neetai.users.UserActionForm;
import com.bms.struts.SCMAction;

public class MeasurementConversionAction extends SCMAction {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession httpSession=request.getSession(true);
		UserActionForm userActionForm=(UserActionForm)httpSession.getAttribute(Constants.USER_BEAN);
		
		MeasurementConversionBean measurementActionForm=(MeasurementConversionBean)form;
		MeasurementConversionDBHelper measurementConversionDBHelper=new MeasurementConversionDBHelper();
		
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		measurementActionForm.setCreatedBy(userActionForm.getUserName());
		measurementActionForm.setCreatedDTTM(simpleDateFormat.format(new Date()));
		
		measurementConversionDBHelper.addItemCategory(measurementActionForm);

		int temp=0;
		temp=measurementActionForm.getFirstMeasurementId();
		measurementActionForm.setFirstMeasurementId(measurementActionForm.getSecondMeasurementId());
		measurementActionForm.setSecondMeasurementId(temp);
		measurementActionForm.setConversionValue(1/measurementActionForm.getConversionValue());
		measurementConversionDBHelper.addItemCategory(measurementActionForm);
		// TODO Auto-generated method stub
		 ActionRedirect redirect = new ActionRedirect(mapping.findForward(Constants.STRUTS_MAPPING_SUCCESS));
		  redirect.addParameter("insert","Conversion");
		  return redirect;
	}

}
