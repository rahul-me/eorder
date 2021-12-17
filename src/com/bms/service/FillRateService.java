package com.bms.service;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.bms.constants.Constants;
import com.bms.context.ServerAppContext;
import com.bms.mdm.authorizationmatrix.AuthorisedMatrixActionForm;
import com.bms.mdm.authorizationmatrix.AuthorisedMatrixDBHelper;
import com.bms.neetai.users.UserActionForm;

@Path("/FillRateService")
public class FillRateService {
	
	@Context
	UriInfo uriInfo;

	// Another "injected" object. This allows us to use the information that's
	// part of any incoming request.
	// We could, for example, get header information, or the requestor's address.
	@Context
	//Request request;
	//Response response;
	HttpServletRequest request;
	HttpServletResponse response;
	
	
	@POST
	@Path("/getAccessControlValue")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JSONArray getAccessControlValue(String data) throws JSONException{
	
		
		HttpSession session=request.getSession(true);
		UserActionForm userActionForm=new UserActionForm();
		userActionForm=(UserActionForm) session.getAttribute(Constants.USER_BEAN);
		
		int loginRole = userActionForm.getUserRolesMasterId();
		System.out.println("user role "+loginRole);
		AuthorisedMatrixDBHelper authorisedMatrixDBHelper = new AuthorisedMatrixDBHelper();
		
		ArrayList <AuthorisedMatrixActionForm> authList= authorisedMatrixDBHelper.fetchAllRecordsByRoleId(loginRole);
				
		JSONArray jsonArray = null;
		JSONObject jsonObject= null;
		try {
			jsonArray = new JSONArray();	
			String m=request.getParameter("plCatId");
			System.out.println("id" +m);
			if(authList != null)
			{

				System.out.println("array size"+authList.size());
				for(int i= 0; i<authList.size(); i++)
				{
					jsonObject = new JSONObject();
					jsonObject.put("Key", authList.get(i).getModulekey());
					System.out.println("key val "+authList.get(i).getModulekey());
					//jsonObject.put("Val", authList.get(i).getRoleId());
								
					jsonArray.put(jsonObject);
				}
			}
			else
			{
				jsonArray = new JSONArray();
			}

		
			}
		catch (Exception e) {
			System.out.println(e);
		}
	
		return jsonArray;
	}

}
