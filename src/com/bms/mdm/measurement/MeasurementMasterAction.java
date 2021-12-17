package com.bms.mdm.measurement;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bms.constants.Constants;
import com.bms.context.ServerAppContext;
import com.bms.mdm.item.ItemActionForm;
import com.bms.mdm.item.ItemDBHelper;
import com.bms.neetai.users.UserActionForm;
import com.bms.struts.SCMAction;


public class MeasurementMasterAction extends SCMAction{
	
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
         	

		  MeasurementActionForm measurementActionForm=(MeasurementActionForm)form;		  
		  MeasurementDBHelper measurementDBHelper=new  MeasurementDBHelper(); 
		  ServerAppContext serverAppContext  = (ServerAppContext)request.getServletContext().getAttribute(Constants.STRUTS_APPLICATION_CONTEXT);
		  	HttpSession httpSession=request.getSession(true);
			UserActionForm userActionForm=(UserActionForm)httpSession.getAttribute(Constants.USER_BEAN);
			measurementActionForm.setCreatedBy(userActionForm.getUserMasterId());
			int compid=(int)httpSession.getAttribute(Constants.COMPANY_ID);
			SimpleDateFormat simpleDateFormat=new SimpleDateFormat(Constants.DATE_FORMAT);
			measurementActionForm.setCreatedDTTM(simpleDateFormat.format(new Date()));
		  
		 
		  if(measurementActionForm.getMeasurementMasterId()>0)
		  {
			    System.out.println("Is Active Value "+measurementActionForm.getIsActive());
			  	System.out.println(Integer.parseInt(request.getParameter("isActive")));
			  	measurementActionForm.setIsActive(measurementActionForm.getIsActive());
			  	measurementActionForm.setCompanyMasterId(compid);
			  	measurementDBHelper.updateMeasurementEntry(measurementActionForm);
			  
			  	ArrayList<MeasurementActionForm>measurementFormList=measurementDBHelper.fetchAllRecords();
				serverAppContext.setMeasurementList(measurementFormList);
				
				ArrayList<MeasurementActionForm>measurementActiveFormList=measurementDBHelper.fetchAllActiveMeasurementRecords();
				serverAppContext.setMeasurementListByActiveMeasurement(measurementActiveFormList);
				
				HashMap<Integer, MeasurementActionForm>measurementbyid=new HashMap<Integer,MeasurementActionForm>();
				measurementbyid=serverAppContext.getMeasurementByMeasurementMasterId();
				measurementbyid.put(measurementActionForm.getMeasurementMasterId(),measurementActionForm);
				serverAppContext.setMeasurementByMeasurementMasterId(measurementbyid);
				
				ArrayList<MeasurementActionForm>measurementByCompanyList=measurementDBHelper.getMeasurementByCompanyId(compid);
				HashMap<Integer,ArrayList<MeasurementActionForm>>measurementByCompanyId=new HashMap<Integer,ArrayList<MeasurementActionForm>>();
				measurementByCompanyId=serverAppContext.getMeasurementByCompanyMasterId();
				measurementByCompanyId.put(compid, measurementByCompanyList);
				serverAppContext.setMeasurementByCompanyMasterId(measurementByCompanyId);
				
				
				
				
				return mapping.findForward(Constants.STRUTS_MAPPING_SUCCESS);
		  }
		  else
		  {
			  System.out.println("Is Active Value "+measurementActionForm.getIsActive());			  
			  measurementActionForm.setIsActive(measurementActionForm.getIsActive());
			  measurementActionForm.setCompanyMasterId(compid);
			  int status=measurementDBHelper.addMeasurementEntryId(measurementActionForm);
			  	if(status>0){
				
			  	ArrayList<MeasurementActionForm>measurementFormList=serverAppContext.getMeasurementList();
			  	measurementFormList.add(measurementActionForm);
				serverAppContext.setMeasurementList(measurementFormList);
				
				ArrayList<MeasurementActionForm>measurementActiveFormList=serverAppContext.getMeasurementListByActiveMeasurement();
				measurementActiveFormList.add(measurementActionForm);
				serverAppContext.setMeasurementListByActiveMeasurement(measurementActiveFormList);
				
				measurementActionForm.setMeasurementMasterId(status);
				HashMap<Integer, MeasurementActionForm>measurementbyid=new HashMap<Integer,MeasurementActionForm>();
				measurementbyid=serverAppContext.getMeasurementByMeasurementMasterId();
				measurementbyid.put(status,measurementActionForm);
				serverAppContext.setMeasurementByMeasurementMasterId(measurementbyid);
				
				HashMap<Integer, ArrayList<MeasurementActionForm>>measurementByCompanyId=new HashMap<Integer,ArrayList<MeasurementActionForm>>();	
				
				ArrayList<MeasurementActionForm> measurementByDistinctCompany=measurementDBHelper.fetchAllDistinctCompany();
				if(measurementByDistinctCompany!=null){
					for(int i=0;i<measurementByDistinctCompany.size();i++)
					{
						ArrayList<MeasurementActionForm> measurementListByCompany=measurementDBHelper.getMeasurementByCompanyId(measurementByDistinctCompany.get(i).getCompanyMasterId());
						if(measurementListByCompany!=null)
						{
							int id=measurementListByCompany.get(0).getCompanyMasterId();
							measurementByCompanyId.put(id, measurementListByCompany);
						}
					}
				}
				serverAppContext.setMeasurementByCompanyMasterId(measurementByCompanyId);
				
				
				
				/*measurementByCompanyId=serverAppContext.getMeasurementByCompanyMasterId();
				ArrayList<MeasurementActionForm> measurementByCompanyList=new ArrayList<>();
				if(measurementByCompanyId.size()>1){
					measurementByCompanyList=measurementByCompanyId.get(compid);
				}
				measurementByCompanyList.add(measurementActionForm);
				measurementByCompanyId.put(compid, measurementByCompanyList);
				serverAppContext.setMeasurementByCompanyMasterId(measurementByCompanyId);*/
				
				
				
				
			}
			  return mapping.findForward(Constants.STRUTS_MAPPING_SUCCESS);
		  }
		  		  
			
			}

}
