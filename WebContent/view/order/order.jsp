<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title> Neetai Tech.</title>
	<jsp:include page="../main/css_main.jsp" />
	<jsp:include page="../main/css_entryPage.jsp" />
 	<jsp:include page="../main/js_main.jsp" />
 
</head>
   <jsp:include page="../main/header.jsp" />
   <!-- BEGIN CONTENT -->
   <div class="page-content-wrapper">
   <!-- BEGIN CONTAINER -->
   <div class="page-container">
	   <!-- BEGIN EMPTY PAGE SIDEBAR -->
		<div class="page-sidebar navbar-collapse collapse">
			<ul class="page-sidebar-menu visible-sm visible-xs">
				 <jsp:include page="../main/menubarforsmallscreen.jsp" /> 
			</ul>
		</div>
		<!-- END EMPTY PAGE SIDEBAR -->
		
	  <!-- BEGIN PAGE -->
      <div class="page-content">
		         <!-- BEGIN PAGE HEADER-->
		         <div class="row">
		          	   <div class="col-md-14">
			                        <div class="portlet box blue-steel">
			                           <div class="portlet-title">
			                              <div class="caption"><span style="font-weight: bold;"><i class="icon-reorder POForm1"></i>Order Entry Form</span></div>
			                              <div class="tools">
			                                 <a href="javascript:;" class="collapse"></a>
			                        <!--          <a href="#portlet-config" data-toggle="modal" class="config"></a>
			                                 <a href="javascript:;" class="reload"></a>
			                                 <a href="javascript:;" class="remove"></a>
			                         -->     </div>
			                           </div>
			                           <div class="portlet-body form">
			                              <!-- BEGIN FORM-->
			                              
			                              <html:form styleId="stockTakeForm" styleClass="form-horizontal" action="/view/order/orderMasterAction">
			                        		
											 <html:hidden property="itemPrice" styleId="itemPrice"/> 
			                                 <html:hidden property="state" styleId="state"/>
			                                 <html:hidden property="orderMasterId" styleId="orderMasterId"/>
			                                 <html:hidden property="customerMasterId" styleId="customerMasterId"/>
			                                 <html:hidden property="createdBy" styleId="createdById"/>
			                              
										     <div class="form-body">
			                                    <div class="row">
			                                 	   <div class="col-md-4">
			                                    	   <div class="form-group">
			                                             <label class="control-label col-md-5">Select Customer</label>
			                                               <div class="col-md-7">
				                                             	<html:select property="userMasterId" styleClass="form-control select2me" style="width:100%" styleId="userMasterId">
																	<html:option value=""></html:option>																	
																	 <logic:notEmpty name="orderMasterActionForm" property="userList"> 
																		<html:optionsCollection name="orderMasterActionForm" property="userList" label="firstName" value="userMasterId" />
																	 </logic:notEmpty> 
																</html:select>
				                                            </div>
			                                             </div> 
			                                         </div>
			                                       
			                                       <!--/span-->
			                                       <div class="col-md-5">
															<div class="form-group">
																<label class="control-label col-md-5">Order Date</label>
																<div class="col-md-4">
																		 <html:text property="createdDate" styleId="dateId" styleClass="form-control" readonly="true"></html:text>
																</div>
															</div>
													</div>
														
														<!-- <div class="col-md-2 upload">
															<div class="form-group">
																<label class="control-label col-md-4" for="exampleInputFile1">Order Import</label>
																	<div class="col-md-3">
																		 <input type="file" id="file" name="fileInput" onchange="upload()" value=" ">
																	</div>
															</div>
														</div> -->
			                                       <!--/span-->
			                                    </div>
			                                    
			                                    <!--/row-->
			                                    <div class="row">
			                                    	<!--  <div class="col-md-4 disp">
					                                     <div class="form-group">
					                                       <label class="control-label col-md-5">Order State:<span class="required">*</span></label>
					                                       <div class="col-md-7">
					                                           <div class="radio-list"> 
					                                           		<label class="radio-inline">
					                                           			 <input type="radio" name="active" value="0"/>NEW
					                                             	</label>  
					                                         	 	<label class="radio-inline">
					                                         	 		 <input type="radio" name="active" value="1"/>EXISTING
					                                            	</label>
					                                           </div> 
					                                       </div>
					                                    </div>
					                                   </div> -->
			                                    	<div class="col-md-4 disp1">
				                                        <div class="form-group">
				                                             <label class="control-label col-md-5 POForm1">Order Number</label>
				                                              <div class="col-md-7">
				                                             	<html:select property="orderNumber" styleClass="form-control select2me" style="width:100%;" styleId="orderNumber">
														<html:option value=""></html:option>
														 <logic:notEmpty name="orderMasterActionForm" property="orderMasterList"> 
														<html:optionsCollection name="orderMasterActionForm" property="orderMasterList" label="orderNumber" value="orderNumber" />
														 </logic:notEmpty> 
													</html:select>
				                                             </div> 
				                                          </div>
				                                      </div>
				                                      <%-- <div class="col-md-4">
				                                        <div class="form-group">
				                                             <label class="control-label col-md-5">Order Status</label>
				                                              <div class="col-md-6">
				                                             	<html:select property="state" styleClass="form-control input-xmedium select2me" style="width:100%;" styleId="stateId">
																	<html:option value=""></html:option>
																	<html:option value="1">Submitted</html:option>
																	<html:option value="2">Processed</html:option>
																	<html:option value="3">Dispatched</html:option>
																	<html:option value="4">Delivered</html:option>
																	<html:option value="5">Delayed</html:option>
																	<html:option value="5">Cancelled</html:option>
																</html:select>
				                                             </div> 
				                                          </div>
				                                      </div> --%>
													</div>
			                                    
			                                    <!--/row-->        
			                                   
			                                 </div>
			                                 
			                                  	<!-- BEGIN EXAMPLE TABLE PORTLET-->
			                                   <div class="portlet">
			                                   		 <div class="portlet-title">
									                     <div class="caption"><span style="font-weight: bold;"><i class="icon-edit"></i>Pick Your Products</span></div>
									                     <div class="tools">
									                        <a href="javascript:;" class="collapse"></a>
									                        <!-- <a href="#portlet-config" data-toggle="modal" class="config"></a>
									                        <a href="javascript:;" class="reload"></a>
									                        <a href="javascript:;" class="remove"></a> -->
									                     </div>
									                  </div>
									           	 <div class="portlet-body">
			               							<div class="table-responsive tableCont">
								                 
								                     <table class="responsive table table-bordered table-striped table-hover disp" id="POITable">
								                        <thead>
								                           <tr>
								                           		<th>Product Name</th>
								                           		<th>Description</th>
								                           		<th>Available Quantity</th>
																<th>Quantity</th>
																<th>Rate</th>
																<th>Amount</th>
																<th style="width: 4%" >Add/Remove</th>
																<!-- <th class="isDisa">Void</th> -->
								                           </tr>
								                        </thead>
								                       <tbody id="tbody">
																<tr id="1">
																	<td style="width: 25%;">
																		<div class="span12 controls">
																			<html:select property="itemMasterId" styleId="itemId_1" styleClass="form-control select2me">
																				<html:option value=""></html:option>
																				<logic:notEmpty name="orderMasterActionForm" property="itemList">
																					<html:optionsCollection name="orderMasterActionForm" property="itemList" label="name" value="itemMasterId" />
																				</logic:notEmpty>
																			</html:select>
																		</div> 
																	</td>
																	<td style="width: 20%;">
																		<div class="span12 controls">
																			<input class="form-control text qty " id="description1" name="description" type="text" style="text-align: right;" />
																		</div> 
																	</td>
																	<td ><input class="form-control text aqty " id="availableQ1" name="availableQ" type="text" style="text-align: right;" value="0" readonly="readonly"/></td>
																	<td>
																		<input class="form-control text qty " id="qty1" name="quantity" type="text" style="text-align: right;" />
																		<span class="label label-sm label-default"></span>
																		<input class="form-control text" type="hidden" readonly="readonly" name="measurementName" style="text-align: center;" /> 
																		<input type="hidden" name="measurementIds" />
																	</td>
																	<td ><input class="form-control text rate " id="rate1" name="rate" type="text" style="text-align: right;" value="0" readonly="readonly"/></td>
																	<td ><input class="form-control text " id="itemAmnt1" name="amount" type="text" readonly="readonly" style="text-align: right;" value="0" /></td>
																	<td ><a class="btn btn-sm green " onclick="insRow(this)"><i class="fa fa-plus"></i></a>
								                             		 	<a href="#" class="btn btn-sm red " id="cancel-button" onclick="deleteRow(this)"><i class="fa fa-minus"></i></a>
								                             		</td>
								                             		 <td style="display: none;"><input type="hidden" id="orderDetailId" name="orderDetailId"/></td>
																</tr>
			
														</tbody>
								                     </table>
								              		</div>
								             	 </div>
								              </div>
								               <!-- END EXAMPLE TABLE PORTLET-->
								               
								             <div class="form-body disp">
			                                    <!--/row-->
			                                 	 <div class="row">
			                                 	 	<div class="col-md-4">
			                                          <div class="form-group">
			                                            <label class="control-label col-md-2">Remark</label>
			                                             <div class="col-md-6">
			                                                <html:textarea property="remark" styleClass="form-control" styleId="remark"></html:textarea>
			                                             </div>
			                                          </div>
			                                       </div>
			                                    	<div class="col-md-4">
			                                          <div class="form-group">
			                                             <label class="control-label col-md-6">Total Amount</label>
			                                             <div class="col-md-4">
			                                                <html:text styleClass="form-control" readonly="true" styleId="total-amt" style="text-align: right;" property="total" />
			                                             </div>
			                                          </div>
			                                       </div>
			                                       <!--/span-->
												</div>
			                                    <!--/row-->        
			                                   
			                                 </div>
								               
			                                 
			                                 <div class="form-actions submitEntry confirm disp">
			                                          <div class="col-md-offset-5 col-md-4">
			                                                <!-- <button type="button" id="createOrsubmit" title="Create StockTake And Go To List Page" class="btn green">Save</button> -->
			                                                <button type="button" class="btn yellow" id="addBtn" title="Create New Order"><span style="font-weight: bold; color:black;" >Create Order</span></button>
			                                                <!-- <button type="button" class="btn green dropdown-toggle" data-target="#stack1" data-toggle="modal">Add <i class="icon-plus"></i></button> -->
															<button type="button" class="btn dark" id="cancel"><span style="font-weight: bold; color:black;">Cancel</span></button>                             
			                                          </div>
											</div>
											
											
										  </html:form>
			                              <!-- END FORM-->                
			                           </div>
			                        </div>
			            </div>
		          
		         </div>
		         <%-- <jsp:include page="../main/quicksidebar.jsp" />  --%>
		         <!-- END PAGE HEADER-->
      </div>
      <!-- END PAGE -->
	</div>
	
	</div>
   <!-- END CONTAINER -->
   <jsp:include page="../main/footer.jsp" />
   <jsp:include page="../order/orderJS.jsp" />
   <jsp:include page="../main/js_entryPage.jsp" />
   
</body>
</html>