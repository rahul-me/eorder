<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title> Neetai Tech</title>
 <jsp:include page="../main/css_main.jsp" />
 <jsp:include page="../main/css_entryPage.jsp" />
 <jsp:include page="../main/js_main.jsp" />
</head>
	<jsp:include page="../main/header.jsp" />
   <!-- BEGIN CONTAINER -->
   <div class="page-container">
   		<!-- BEGIN EMPTY PAGE SIDEBAR -->
		<div class="page-sidebar navbar-collapse collapse">
			<ul class="page-sidebar-menu visible-sm visible-xs">
				 <jsp:include page="../main/menubarforsmallscreen.jsp" /> 
			</ul>
		</div>
		<!-- END EMPTY PAGE SIDEBAR -->
		<!-- BEGIN CONTENT -->
   <div class="page-content-wrapper">
	     <!-- BEGIN PAGE -->
      <div class="page-content">
         <!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->               
         <div class="modal fade" id="portlet-config" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
               <div class="modal-content">
                  <div class="modal-header">
                     <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                     <h4 class="modal-title">Modal title</h4>
                  </div>
                  <div class="modal-body">
                     Widget settings form goes here
                  </div>
                  <div class="modal-footer">
                     <button type="button" class="btn blue">Save changes</button>
                     <button type="button" class="btn default" data-dismiss="modal">Close</button>
                  </div>
               </div>
               <!-- /.modal-content -->
            </div>
            <!-- /.modal-dialog -->
         </div>
         <!-- /.modal -->
         <!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->
         <!-- BEGIN PAGE HEADER-->
         <div class="row">
            <div class="col-md-12">
               <!-- BEGIN PAGE TITLE & BREADCRUMB-->
              <h3 class="page-title">
                <span style="font-weight: bold; color: black;">Access Control</span> <small>User Role Wise Access</small>
               </h3>
              
               <ul class="page-breadcrumb breadcrumb">
                  
               </ul>
               <!-- END PAGE TITLE & BREADCRUMB-->
            </div>
         </div>
         <!-- END PAGE HEADER-->
         
         <!-- BEGIN PAGE CONTENT-->
                           <html:form action="/view/settings/AccessControl" styleId="AccessControlForm" >
	      					<%--  <html:hidden property="userRolesMasterId" styleId="userId1"/> --%>                 
                       	 	<div class="row">
		                       	<div class="col-md-5 ">
			                       	<div class="form-body">
				                           <div class="form-group">
				                           <label class="col-md-4 control-label"><span style="font-weight: bold;">Select User Role</span></label>
				                              <div class="col-md-5">
			                                     <html:select property="userRolesMasterId" styleClass="form-control input-medium select2me" style="width:100%" styleId="select2">
															<html:option value=""></html:option>
															 <logic:notEmpty name="accessControlBean" property="roleList">
																<html:optionsCollection name="accessControlBean" property="roleList" label="name" value="userRolesMasterId" />
															</logic:notEmpty>
												 </html:select>
				                              </div>
				                              </div>
				                           </div>
				            	</div>
		            		</div>  
				            	 
				            <div class="row" style="margin-top: 3%">
           						 <div class="col-md-6">  
           						  <div class="portlet box blue-steel">
							                  <div class="portlet-title">
							                     <div class="caption"><span style="font-weight: bold;"><i class="icon-reorder"></i>Order List Controls</span></div>
							                     <div class="tools">
							                        <a href="javascript:;" class="collapse"></a>
							                     </div>
							                  </div>
							                  <div class="portlet-body">
							                     	<table class="responsive table table-bordered" id="orderListOptionsTable" style="font-size: medium;; width: 100%;">
				                                        <thead>
				                                          <tr>
				                                            <th align="center">Option</th><th align="center">Enabled</th>
				                                          </tr>
				                                        </thead>
				                                         <tbody>
				                                          <tr>
				                                                <td align="center"><div class="span12 controls">Order <div class="clear"></div></div></td>
													    	 	<td align="center"><input type="checkbox"  id="order_AccessControl" name="orderAccessControl" value="order_AccessControl"/></td>
													      </tr>
													    </tbody>
				                                        <tbody>
				                                          <tr>
				                                                <td align="center"><div class="span12 controls">Order List<div class="clear"></div></div></td>
													    	 	<td align="center"><input type="checkbox"  id="orderList_AccessControl" name="orderListAccessControl" value="orderList_AccessControl"/></td>
													      </tr>
													    </tbody>
													     <tbody>
				                                          <tr>
				                                                <td align="center"><div class="span12 controls">Show/Hide Order <div class="clear"></div></div></td>
													    	 	<td align="center"><input type="checkbox"  id="showHideOrder_AccessControl" name="showHideOrderAccessControl" value="showHideOrder_AccessControl"/></td>
													      </tr>
													    </tbody>
				                                    </table>
							                  </div>
								       </div>           						 	 
								       <!-- <div class="portlet box blue-steel">
							                  <div class="portlet-title">
							                     <div class="caption"><span style="font-weight: bold;"><i class="icon-reorder"></i>Reports</span></div>
							                     <div class="tools">
							                        <a href="javascript:;" class="collapse"></a>
							                     </div>
							                  </div>
							                  <div class="portlet-body">
							                     	<table class="responsive table table-bordered" id="orderManagmentListOptionsTable" style="font-size: medium;; width: 100%;">
				                                        <thead>
				                                          <tr>
				                                            <th align="center">Option</th><th align="center">Enabled</th>
				                                          </tr>
				                                        </thead>
				                                        <tbody>
				                                          <tr>
				                                                <td align="center"><div class="span12 controls">Show/Hide Reports<div class="clear"></div></div></td>
													    	 	<td align="center"><input type="checkbox"  id="report_AccessControl" name="reportAccessControl" value="report_AccessControl"/></td>
													      </tr>
													    </tbody>
				                                    </table>
							                  </div>
								       </div>  -->
								       
								       <!-- Addition of Sale Module  -->
								       <div class="portlet box blue-steel">
							                  <div class="portlet-title">
							                     <div class="caption"><span style="font-weight: bold;"><i class="icon-reorder"></i>Sale</span></div>
							                     <div class="tools">
							                        <a href="javascript:;" class="collapse"></a>
							                     </div>
							                  </div>
							                  <div class="portlet-body">
							                     	<table class="responsive table table-bordered" id="orderManagmentListOptionsTable" style="font-size: medium;; width: 100%;">
				                                        <thead>
				                                          <tr>
				                                            <th align="center">Option</th><th align="center">Enabled</th>
				                                          </tr>
				                                        </thead>
				                                        <tbody>
				                                          <tr>
				                                                <td align="center"><div class="span12 controls">Sale<div class="clear"></div></div></td>
													    	 	<td align="center"><input type="checkbox"  id="sale_AccessControl" name="saleAccessControl" value="sale_AccessControl"/></td>
													      </tr>
													    </tbody>
				                                    </table>
							                  </div>
								       </div>
														       
								       <!-- Close Sale Module -->
								       <!-- Addition of company details Module  -->
								       <div class="portlet box blue-steel">
							                  <div class="portlet-title">
							                     <div class="caption"><span style="font-weight: bold;"><i class="icon-reorder"></i>Company Details Entry</span></div>
							                     <div class="tools">
							                        <a href="javascript:;" class="collapse"></a>
							                     </div>
							                  </div>
							                  <div class="portlet-body">
							                     	<table class="responsive table table-bordered" id="orderManagmentListOptionsTable" style="font-size: medium;; width: 100%;">
				                                        <thead>
				                                          <tr>
				                                            <th align="center">Option</th><th align="center">Enabled</th>
				                                          </tr>
				                                        </thead>
				                                        <tbody>
				                                          <tr>
				                                                <td align="center"><div class="span12 controls">Entry<div class="clear"></div></div></td>
													    	 	<td align="center"><input type="checkbox"  id="companydetailac" name="companydetailac" value="companydetailac"/></td>
													      </tr>
													    </tbody>
				                                    </table>
							                  </div>
								       </div>
														       
								       <!-- Close company Module -->
								       
								       <!-- Addition of company details Module  -->
								       <div class="portlet box blue-steel">
							                  <div class="portlet-title">
							                     <div class="caption"><span style="font-weight: bold;"><i class="icon-reorder"></i>Account detail for retailers</span></div>
							                     <div class="tools">
							                        <a href="javascript:;" class="collapse"></a>
							                     </div>
							                  </div>
							                  <div class="portlet-body">
							                     	<table class="responsive table table-bordered" id="orderManagmentListOptionsTable" style="font-size: medium;; width: 100%;">
				                                        <thead>
				                                          <tr>
				                                            <th align="center">Option</th><th align="center">Enabled</th>
				                                          </tr>
				                                        </thead>
				                                        <tbody>
				                                          <tr>
				                                                <td align="center"><div class="span12 controls">Account<div class="clear"></div></div></td>
													    	 	<td align="center"><input type="checkbox"  id="accountaccess" name="accountaccess" value="accountaccess"/></td>
													      </tr>
													    </tbody>
				                                    </table>
							                  </div>
								       </div>
														       
								       <!-- Close company Module -->
								       
								       
								       	 	   
								       	
								        </div>
								       <div class="col-md-6">         						 	 
								        <div class="portlet box blue-steel">
							                  <div class="portlet-title">
							                     <div class="caption"><span style="font-weight: bold;"><i class="icon-reorder"></i>Order Management Controls</span></div>
							                     <div class="tools">
							                        <a href="javascript:;" class="collapse"></a>
							                     </div>
							                  </div>
							                  <div class="portlet-body">
							                     	<table class="responsive table table-bordered" id="orderManagmentListOptionsTable" style="font-size: medium;; width: 100%;">
				                                        <thead>
				                                          <tr>
				                                            <th align="center">Option</th><th align="center">Enabled</th>
				                                          </tr>
				                                        </thead>
				                                        <tbody>
				                                          <tr>
				                                                <td align="center"><div class="span12 controls">Show/Hide Order Management<div class="clear"></div></div></td>
				                                                <td align="center"><input type="checkbox"  id="orderManagment_AccessControl" name="orderManagmentAccessControl" value="orderManagment_AccessControl"/></td>
													      </tr>
													    </tbody>
				                                    </table>
							                  </div>
								       </div> 	 	 
								      
							          	
								           <div class="portlet box blue-steel">
							                  <div class="portlet-title">
							                     <div class="caption"><span style="font-weight: bold;"><i class="icon-reorder"></i>Settings Controls</span></div>
							                     <div class="tools">
							                        <a href="javascript:;" class="collapse"></a>
							                     </div>
							                  </div>
							                  <div class="portlet-body">
							                     	<table class="responsive table table-bordered" id="settingsOptionsTable" style="font-size: medium;; width: 100%;">
				                                        <thead>
				                                          <tr>
				                                            <th align="center">Option</th><th align="center">Enabled</th>
				                                          </tr>
				                                        </thead>
				                                        <tbody>
				                                          <tr>
				                                                <td align="center"><div class="span12 controls">AccessControl <div class="clear"></div></div></td>
				                                                <td align="center"><input type="checkbox"  id="accessControl" name="accessControl" value="accessControl"/></td>
													      </tr>
													    </tbody>
													     <tbody>
				                                          <tr>
				                                                <td align="center"><div class="span12 controls">ItemPrice Setting <div class="clear"></div></div></td>
				                                                <td align="center"><input type="checkbox"  id="itemPrice_AccessControl" name="itemPriceAccessControl" value="itemPrice_AccessControl"/></td>
													      </tr>
													    </tbody>
													     <tbody>
				                                          <tr>
				                                                <td align="center"><div class="span12 controls">Setting Configuration<div class="clear"></div></div></td>
				                                                <td align="center"><input type="checkbox"  id="settingConfigure_AccessControl" name="settingConfigureAccessControl" value="settingConfigure_AccessControl"/></td>
													      </tr>
													    </tbody>
													     <tbody>
				                                          <tr>
				                                                <td align="center"><div class="span12 controls">Show/Hide Settings <div class="clear"></div></div></td>
				                                                <td align="center"><input type="checkbox"  id="showHideSetting_AccessControl" name="showHideSettingAccessControl" value="showHideSetting_AccessControl"/></td>
													      </tr>
													    </tbody>
				                                    </table>
							                  </div>
								       </div> 
								       <div class="portlet box blue-steel">
							                  <div class="portlet-title">
							                     <div class="caption"><span style="font-weight: bold;"><i class="icon-reorder"></i>Report</span></div>
							                     <div class="tools">
							                        <a href="javascript:;" class="collapse"></a>
							                     </div>
							                  </div>
							                  <div class="portlet-body">
							                     	<table class="responsive table table-bordered" id="rreport" style="font-size: medium;; width: 100%;">
				                                        <thead>
				                                          <tr>
				                                            <th align="center">Option</th><th align="center">Enabled</th>
				                                          </tr>
				                                        </thead>
				                                         <tbody>
				                                          <tr>
				                                                <td align="center"><div class="span12 controls">Order Report <div class="clear"></div></div></td>
													    	 	<td align="center"><input type="checkbox"  id="orderReportContol" name="orderReportContol" value="orderReportContol"/></td>
													      </tr>
													    </tbody>				                                        
													     <tbody>
				                                          <tr>
				                                                <td align="center"><div class="span12 controls">Show/Hide Order <div class="clear"></div></div></td>
													    	 	<td align="center"><input type="checkbox"  id="shorderReportContol" name="shorderReportContol" value="shorderReportContol"/></td>
													      </tr>
													    </tbody>
				                                    </table>
							                  </div>
								       </div>    
								       <div class="portlet box blue-steel">
							                  <div class="portlet-title">
							                     <div class="caption"><span style="font-weight: bold;"><i class="icon-reorder"></i>Features</span></div>
							                     <div class="tools">
							                        <a href="javascript:;" class="collapse"></a>
							                     </div>
							                  </div>
							                  <div class="portlet-body">
							                     	<table class="responsive table table-bordered" id="features" style="font-size: medium;; width: 100%;">
				                                        <thead>
				                                          <tr>
				                                            <th align="center">Option</th><th align="center">Enabled</th>
				                                          </tr>
				                                        </thead>
				                                         <tbody>
				                                          <tr>
				                                                <td align="center"><div class="span12 controls">Editable Unit Cost value <div class="clear"></div></div></td>
													    	 	<td align="center"><input type="checkbox"  id="editableUnitCost" name="editableUnitCost" value="editableUnitCost"/></td>
													      </tr>
													    </tbody>				                                        													     
				                                    </table>
							                  </div>
								       </div>
           						 
           						</div>
           					
           					</div>		
           					
           					<div class="row" style="margin-top: 3%">
           						 <div class="col-md-12"> 
           						 	
							             <div class="portlet box blue-steel">
								                  <div class="portlet-title">
								                     <div class="caption"><span style="font-weight: bold;"><i class="icon-reorder"></i>Master Data Controls</span></div>
								                     <div class="tools">
								                        <a href="javascript:;" class="collapse"></a>
								                        <!-- <a href="#portlet-config" data-toggle="modal" class="config"></a> -->
								                     </div>
								                  </div>
								                  <div class="portlet-body">
								                  		<table class="responsive table table-bordered" id="masterOptionsTable" style="font-size: medium;; width: 100%;">
					                                        <thead>
					                                          <tr>
					                                            <th align="center">Option</th><th align="center">Enabled</th><th align="center">Option</th><th align="center">Enabled</th><th align="center">Option</th><th align="center">Enabled</th>
					                                          </tr>
					                                        </thead>
					                                        <tbody>
														    	 	<tr>	
														     		
															     		<td align="center"><div class="grid9">Item<div class="clear"></div></div></td>
															    	 	<td align="center"><input type="checkbox" id="item_AccessControl" name="itemAccessControl" value="item_AccessControl"/></td>
															    	 		
															    	 	<td align="center"><div class="grid9">Item List<div class="clear"></div></div></td>
															    	 	<td align="center"><input type="checkbox" id="itemList_AccessControl" name="itemListAccessControl" value="itemList_AccessControl"/></td>
															    	 	
															    	 	<td align="center"><div class="span12 controls">Show/Hide Item <div class="clear"></div></div></td>
														    	 		<td align="center"><input type="checkbox"  id="showHideItem_AccessControl" name="showHideItemAccessControl" value="showHideItem_AccessControl"/></td>
																 	
														    	 	</tr>
														    	 	
					                                        
														     		<tr>	
														     		
															     		<td align="center"><div class="grid9">Item Category<div class="clear"></div></div></td>
															    	 	<td align="center"><input type="checkbox" id="itemCategory_AccessControl" name="itemCategoryAccessControl" value="itemCategory_AccessControl"/></td>
															    	 	
															    	 	<td align="center"><div class="grid9">Item Category List<div class="clear"></div></div></td>
															    	 	<td align="center"><input type="checkbox" id="itemCategoryList_AccessControl" name="itemCategoryListAccessControl" value="itemCategoryList_AccessControl"/></td>
															    	 	
															    	 	<td align="center"><div class="span12 controls">Show/Hide Category <div class="clear"></div></div></td>
														    	 		<td align="center"><input type="checkbox"  id="showHideItemCategory_AccessControl" name="showHideItemCategoryAccessControl" value="showHideItemCategory_AccessControl"/></td>
																 	
														    	 	</tr>
														    	 	
														    	 	<tr>	
														     		
															     		<td align="center"><div class="grid9">Customer<div class="clear"></div></div></td>
														    	 		<td align="center"><input type="checkbox" id="customer_AccessControl" name="customerAccessControl" value="customer_AccessControl"/></td>
														    	 
															    	 	<td align="center"><div class="grid9">Customer List<div class="clear"></div></div></td>
														    	 		<td align="center"><input type="checkbox" id="customerList_AccessControl" name="customerListAccessControl" value="customerList_AccessControl"/></td>
														    	 	
															    	 	<td align="center"><div class="span12 controls">Show/Hide Customer <div class="clear"></div></div></td>
														    	 		<td align="center"><input type="checkbox"  id="showHideCustomer_AccessControl" name="showHideCustomerAccessControl" value="showHideCustomer_AccessControl"/></td>
																 	
														    	 	</tr>
														    	 	
														    	 	<tr>	
														     		
															     		<td align="center"><div class="grid9">User<div class="clear"></div></div></td>
														    	 		<td align="center"><input type="checkbox" id="user_AccessControl" name="userAccessControl" value="user_AccessControl"/></td>
														    	 
															    	 	<td align="center"><div class="grid9">User List<div class="clear"></div></div></td>
														    	 		<td align="center"><input type="checkbox" id="userList_AccessControl" name="userListAccessControl" value="userList_AccessControl"/></td>
														    	 	
															    	 	<td align="center"><div class="span12 controls">Show/Hide User <div class="clear"></div></div></td>
														    	 		<td align="center"><input type="checkbox"  id="showHideUser_AccessControl" name="showHideUserAccessControl" value="showHideUser_AccessControl"/></td>
																 	
														    	 	</tr>
														    	 	
														    	 	<tr>	
														     		
															     		<td align="center"><div class="grid9">UserRole<div class="clear"></div></div></td>
														    	 		<td align="center"><input type="checkbox" id="userRole_AccessControl" name="userRoleAccessControl" value="userRole_AccessControl"/></td>
																		
															    	 	<td align="center"><div class="grid9">UserRole List<div class="clear"></div></div></td>
														    	 		<td align="center"><input type="checkbox" id="userRoleList_AccessControl" name="userRoleListAccessControl" value="userRoleList_AccessControl"/></td>
																	
															    	 	<td align="center"><div class="span12 controls">Show/Hide UserRole<div class="clear"></div></div></td>
														    	 		<td align="center"><input type="checkbox"  id="showHideUserRole_AccessControl" name="showHideUserRoleAccessControl" value="showHideUserRole_AccessControl"/></td>
																 	
														    	 	</tr>
														    	 	
														    	 	<tr>	
														     		
															     		<td align="center"><div class="grid9">OrderStage<div class="clear"></div></div></td>
														    	 		<td align="center"><input type="checkbox" id="orderStage_AccessControl" name="orderStageAccessControl" value="orderStage_AccessControl"/></td>
															    	 	
															    	 	<td align="center"><div class="grid9">OrderStage List<div class="clear"></div></div></td>
														    	 		<td align="center"><input type="checkbox" id="orderStageList_AccessControl" name="orderStageListAccessControl" value="orderStageList_AccessControl"/></td>
															    	 		
															    	 	<td align="center"><div class="span12 controls">Show/Hide OrderStage<div class="clear"></div></div></td>
														    	 		<td align="center"><input type="checkbox"  id="showHideOrderStage_AccessControl" name="showHideOrderStageAccessControl" value="showHideOrderStage_AccessControl"/></td>
																 	
														    	 	</tr>
														    	 	
														    	 	<tr>	
														     		
															     		<td align="center"><div class="grid9">Measurement<div class="clear"></div></div></td>
														    		 	<td align="center"><input type="checkbox" id="measurement_AccessControl" name="measurementAccessControl" value="measurement_AccessControl"/></td>
															    	 		
															    	 	<td align="center"><div class="grid9">Measurement List<div class="clear"></div></div></td>
														    	 		<td align="center"><input type="checkbox" id="measurementList_AccessControl" name="measurementListAccessControl" value="measurementList_AccessControl"/></td>
															    	 	
															    	 	<td align="center"><div class="span12 controls">Show/Hide Measurement <div class="clear"></div></div></td>
														    	 		<td align="center"><input type="checkbox"  id="showHideMeasurement_AccessControl" name="showHideMeasurementAccessControl" value="showHideMeasurement_AccessControl"/></td>
																 	
														    	 	</tr>
														    	 	
														    	 	<tr>	
														     		
															     		<td align="center"><div class="grid9">Company<div class="clear"></div></div></td>
															    	 	<td align="center"><input type="checkbox" id="company_AccessControl" name="companyAccessControl" value="company_AccessControl"/></td>
															    	 		
															    	 	<td align="center"><div class="grid9">Company List<div class="clear"></div></div></td>
															    	 	<td align="center"><input type="checkbox" id="companyList_AccessControl" name="companyListAccessControl" value="companyList_AccessControl"/></td>
															    	 	
															    	 	<td align="center"><div class="span12 controls">Show/Hide Company <div class="clear"></div></div></td>
														    	 		<td align="center"><input type="checkbox"  id="showHideCompany_AccessControl" name="showHideCompanyAccessControl" value="showHideCompany_AccessControl"/></td>
																 	
														    	 	</tr>
														    	 	<tr>	
														     		
															     		<td align="center"><div class="grid9">Package<div class="clear"></div></div></td>
															    	 	<td align="center"><input type="checkbox" id="package_AccessControl" name="packageAccessControl" value="package_AccessControl"/></td>
															    	 	
															    	 	<td align="center"><div class="grid9">Package List<div class="clear"></div></div></td>
															    	 	<td align="center"><input type="checkbox" id="packageList_AccessControl" name="packageListAccessControl" value="packageList_AccessControl"/></td>
															    	 	
															    	 	<td align="center"><div class="span12 controls">Show/Hide Package <div class="clear"></div></div></td>
														    	 		<td align="center"><input type="checkbox"  id="showHidePackage_AccessControl" name="showHidePackageAccessControl" value="showHidePackage_AccessControl"/></td>
																 	
														    	 	</tr>
														    	 	
														    	 	<tr>	
														     		
															    	 	<td align="center"><div class="span12 controls">Show/Hide Master Data<div class="clear"></div></div></td>
														    	 		<td align="center"><input type="checkbox"  id="showHideMasterData_AccessControl" name="showHideMasterDataAccessControl" value="showHideMasterData_AccessControl"/></td>
																 	
														    	 	</tr>
														    </tbody>
					                                    </table>
								                     
								                  </div>
								               </div>
           						 
           						 </div>
           					</div>
           					
				              <div class="row">
				                 <div class="form-actions">
		                                      <div class="col-md-offset-4 col-md-4">
	                                         	<button type="submit" class="btn yellow" id="sub" style="font-weight: bold; color: black;">Submit</button>
                                       					<button type="button" class="btn dark" style="font-weight: bold; color: black;">Cancel</button>
	                                         </div>
	                                </div>
							 </div>	
							 
							
						</html:form>
				
					
			
           
         
         <!-- END PAGE CONTENT -->
      </div>
      <!-- END PAGE -->
      </div>
	</div>
   <!-- END CONTAINER -->
   <jsp:include page="../main/footer.jsp" />
   <jsp:include page="../settings/accessControlJS.jsp" />
   <jsp:include page="../main/js_entryPage.jsp" />
    
     </body>
     
</html>