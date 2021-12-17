package com.bms.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.bms.mdm.item.ItemActionForm;
import com.bms.mdm.item.ItemDBHelper;
import com.bms.mdm.itemcategories.ItemCategoriesDBHelper;
import com.bms.mdm.itemcategories.ItemCategoryActionForm;

@Path("/dashboardWebService")
public class DashboardService {
	// The @Context annotation allows us to have certain contextual objects
			// injected into this class.
			// UriInfo object allows us to get URI information (no kidding).
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
			

/*@POST
@Path("/getItemCategory")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public JSONObject getitemcategory(String data) throws JSONException{
	System.out.println("In DashBoard Services- get item category List");
							
	JSONObject jsonObject = null;
	JSONObject returnJsonObject= null;
	Map<String, Object> jData = new HashMap<String, Object>();
	//SitesDBHelper sitesDBHelper=new SitesDBHelper();
	ItemCategoriesDBHelper itemCategoriesDBHelper=new ItemCategoriesDBHelper();
	ArrayList<ItemCategoryActionForm> superCategoryArrayList=new ArrayList<ItemCategoryActionForm>();
	ArrayList<ItemCategoryActionForm> subCategoryArrayList=new ArrayList<ItemCategoryActionForm>();
	
	try
	{
		superCategoryArrayList=itemCategoriesDBHelper.getAllSuperCategory();
		for(int x=0;x<superCategoryArrayList.size();x++)
		{
			int id=(superCategoryArrayList.get(x).getItemCategoryMasterId());
			subCategoryArrayList=itemCategoriesDBHelper.getItemCategoryById(id);
			jsonObject = new JSONObject();
				for(int y=0;y<subCategoryArrayList.size();y++)
				{
					JSONObject jsonObject2 = new JSONObject();
					jsonObject2.put("id", subCategoryArrayList.get(y).getItemCategoryId());
					jsonObject2.put("name", subCategoryArrayList.get(y).getItemCategoryName());
					//System.out.println("name"+subCategoryArrayList.get(y).getItemCategoryName());
					jsonObject.append("item"+y, jsonObject2);
				}
				jData.put(superCategoryArrayList.get(x).getItemCategoryName(), jsonObject);
			
		}
		returnJsonObject = new JSONObject();
		returnJsonObject.put("MData", jData);
	}catch (Exception e) {
		System.out.println(e);
	}
	//returnJsonObject = new JSONObject();
	//returnJsonObject.put("aaData", jsonArray);
	return returnJsonObject;
	}
*/
@POST
@Path("/getItemByItemCategory")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public JSONObject getItemByItemcategory(String data) throws JSONException{
	
	JSONObject jsonObject = null;
	JSONObject returnJsonObject= null;
	
	ItemDBHelper itemDBHelper=new ItemDBHelper();
	ArrayList<ItemActionForm> itemActionFormsList=new ArrayList<ItemActionForm>();
	
	try
	{
		//jsonObject = new JSONObject();
		//if(jsonObject !=null)
		//{
			int itemCategoryId = Integer.parseInt(data);
			//System.out.println("item catgort"+itemCategoryId);
			itemActionFormsList=itemDBHelper.getItemByItemCategoryId(itemCategoryId);
			returnJsonObject = new JSONObject();
			for(int i=0;i<itemActionFormsList.size();i++){
					jsonObject = new JSONObject();
					jsonObject.put("id", itemActionFormsList.get(i).getItemMasterId());
					jsonObject.put("itemName", itemActionFormsList.get(i).getName());
					returnJsonObject.put("itemId"+itemActionFormsList.get(i).getItemMasterId(), jsonObject);
			}
		//}
	}
	catch (Exception e) {
		System.out.println(e);
	}
	
	return returnJsonObject;
	}
}
