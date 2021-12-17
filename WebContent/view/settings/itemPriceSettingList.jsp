<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" class="no-js">
<head>
   <meta charset="utf-8" />
   <title>Neetai Tech</title>
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta content="width=device-width, initial-scale=1.0" name="viewport" />
   <meta content="" name="description" />
   <meta content="" name="author" />
   <meta name="MobileOptimized" content="320">
	<jsp:include page="../main/css_main.jsp" />
	<jsp:include page="../main/css_listPage.jsp"/>
 	<jsp:include page="../main/js_main.jsp" />
</head>

<!-- END HEAD -->
<jsp:include page="../main/header.jsp" />
   		<!-- BEGIN CONTAINER -->
	   <div class="page-container">
	   		<div class="page-sidebar-wrapper">
				<!-- BEGIN EMPTY PAGE SIDEBAR -->
				<div class="page-sidebar navbar-collapse collapse">
					<ul class="page-sidebar-menu" data-slide-speed="200" data-auto-scroll="true">
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
				                <span style="font-weight: bold; color: black;">Item Price Setting</span> <small>Customer Wise Price</small>
				               </h3>
				              
				               <ul class="page-breadcrumb breadcrumb">
				                  
				               </ul>
				               <!-- END PAGE TITLE & BREADCRUMB-->
				            </div>
				         </div>
				         <!-- END PAGE HEADER-->
				          
				         <!-- BEGIN PAGE FILTER-->
				         <html:form styleId="ItemForm" action="/view/itemcustomermapping/ItemCustomerMapMasterAction">
				         <!-- BEGIN PAGE CONTENT-->
				         <div class="row">
		                       	<div class="col-md-6 ">
			                       	<div class="form-body">
				                           <div class="form-group">
				                           <label class="col-md-4 control-label"><span style="font-weight: bold;">Select User</span></label>
				                              <div class="col-md-5">
			                                     <html:select property="userMasterId" styleClass="form-control select2me" style="width:100%" styleId="userMasterId">
															<html:option value=""></html:option>
															 <logic:notEmpty name="ItemCustomerPriceMappingActionForm" property="userList">
																<html:optionsCollection name="ItemCustomerPriceMappingActionForm" property="userList" label="userName" value="userMasterId" />
															</logic:notEmpty>
												 </html:select>
				                              </div>
				                              </div>
				                           </div>
				            	</div>
		            		</div>  
		            		
				         <div class="row" style="margin-top: 3%">
				            <div class="col-md-14">
				                <!-- BEGIN EXAMPLE TABLE PORTLET-->
				               <div class="portlet box blue-steel">
				                  <div class="portlet-title">
				                     <div class="caption"><span style="font-weight: bold;"><i class="icon-globe"></i> Item-Price List</span></div>
				                      <div class="actions">
				                        
				                     </div>
				                     <!-- <div class="tools">
				                                 <a href="javascript:;" class="collapse"></a>
				                     </div> -->
				                  </div>
				                  <div class="portlet-body">
				                      <table class="responsive table table-bordered disp" id="example">
					                        <thead>
					                           <tr>
					                             	 <th id="th1" style="width:3%;">Item</th>
				                               		 <th>Price</th>  
				                               		 <th>Item's Actual Price</th>                             
				                                	 <th>More</th>
					                           </tr>
					                        </thead>
					                       	<tbody id="tbody"> 
													<tr id="1">
														<td style="width: 40%" id="hello">
															<div class="span12 controls" id="hello2">
																<html:select property="itemMasterId" styleId="itemMasterId_1" styleClass="form-control select2me selectevent">
																	<html:option value=""></html:option>
																	<logic:notEmpty name="ItemCustomerPriceMappingActionForm" property="itemList">
																		<html:optionsCollection name="ItemCustomerPriceMappingActionForm" property="itemList" label="name" value="itemMasterId" />
																	</logic:notEmpty>
																</html:select>
															</div>
														</td>
														<td><input class="form-control" id="price1" name="prices"  type="text"/>
                                    					<span></span>
                                    					</td>
                                    					<td><input class="form-control" id="itsActualPrice" type="text"/>
                                    					<span></span>
                                    					</td>
														<td><a class="btn btn-sm green" onclick="insRow()"><i class="fa fa-plus"></i></a>
					                             		  <!-- <a href="#" class="btn btn-sm red" id="cancel-button" onclick="deleteRow(this)"><i class="icon-minus"></i></a> --> 
					                             		 </td>
													</tr>
												</tbody>
					                     </table>
				                  </div>
				               </div>
				               <!-- END EXAMPLE TABLE PORTLET-->
				            </div>
				            <div class="form-actions">
					                                          <div class="col-md-offset-4 col-md-4">
					                                          		<button type="submit" class="btn yellow" title="Update Item Price" id="createOrSubmit" style="font-weight: bold; color: black;">Edit Item-Price</button>                               	
						                                            <button type="button" class="btn dark" style="font-weight: bold;">Cancel</button>
					                                          </div>
													</div>
				         </div>
				 		</html:form>
					
					</div>
					<!-- END PAGE -->  
				</div>
   				<!-- END CONTENT --> 
   				<jsp:include page="../main/quicksidebar.jsp" /> 
			</div>
		</div>
   		<!-- END CONTAINER -->
   <jsp:include page="../main/footer.jsp" />
    <jsp:include page="../settings/itemPriceSettingListJS.jsp"/>
   <jsp:include page="../main/js_listPage.jsp"/>
   

    <%--  <jsp:include page="../main/billingJS.jsp" />  --%>

</body>
<!-- END BODY -->
</html>