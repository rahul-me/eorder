<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%> 
<%@ taglib uri="/WEB-INF/praesta-custom.tld" prefix="praetsa"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" class="no-js">
<head>
   <meta charset="utf-8" />
   <title>Neetai Tech</title>
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta content="width=device-width, initial-scale=1.0" name="viewport" />
   <meta content="" name="description"/>
   <meta content="" name="author"/>
   <meta name="MobileOptimized" content="320">
	<jsp:include page="../main/css_main.jsp"/>
   <jsp:include page="../main/css_listPage.jsp"/>
  <link href="../../assets/global/plugins/bootstrap-modal/css/bootstrap-modal-bs3patch.css" rel="stylesheet" type="text/css"/>
   	<link href="../../assets/global/plugins/bootstrap-modal/css/bootstrap-modal.css" rel="stylesheet" type="text/css"/>
	
   <link rel="stylesheet" type="text/css" href="../../assets/global/plugins/bootstrap-toastr/toastr.min.css"/>
   <jsp:include page="../main/js_main.jsp"/>
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
					        <!--  <div class="modal fade" id="portlet-config" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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
					               /.modal-content
					            </div>
					            /.modal-dialog
					         </div> -->
					         <!-- /.modal -->
					         <!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->
					          <!-- BEGIN PAGE FILTER-->
					         <jsp:include page="../po/filter.jsp" />
					         <html:form styleId="StockTakeFormList" action="/view/order/orderMasterAction">
					         <!-- BEGIN PAGE CONTENT-->
					         <div class="row">
					            <div class="col-md-14">
					                <!-- BEGIN EXAMPLE TABLE PORTLET-->
					               <div class="portlet box blue-steel">
					                  <div class="portlet-title">
					                     <div class="caption"><i class="icon-globe"></i>Order Management</div>
					                     
					                     
					                  </div>
					                  <div class="portlet-body">
					                     <table class="table table-striped table-bordered table-hover table-full-width" id=example>
					                        <thead>
					                             <tr id="tr1">
					                                <th>Order Number</th>
					                                 <th>Order Date</th>
					                                 <th>Order Status</th>
					                                 <th>Quantity to dispatch</th>
					                                 <th>Dispatched Quantity</th>
					                                 <th>Delivery Status</th>
					                                 <th>Created By</th>
					                                 <th>Last Status</th>
					                                 <th>Updated By</th>
					                                 <th>Updated Time</th>
					                                 <th>View Order</th>					                                 
					                             </tr>
					                          </thead>
					                          <tbody>
					                          </tbody>
					                                <tfoot>
													 <tr>
					                                      <th></th>
					                                      <th></th>
					                                      <th></th>
					                                      <th></th>
					                                      <th></th>
					                                      <th></th>
					                                      <th></th>
					                                      <th></th>
					                                      <th></th>
					                                      <th></th>
					                                      <th></th>
					                                  </tr>
											</tfoot>
					                     </table>
					                  </div>
					               </div>
					               <!-- END EXAMPLE TABLE PORTLET-->
					            </div>
					              <div class="form-actions">
					                       <div class="col-md-offset-5 col-md-6">
					                       <praetsa:roleCheck componentName="editableUnitCost" rolePermitted="admin">
					                           	<button type="button" class="btn yellow" id="editOrder" style="font-weight: bold; color: black;">Edit Order</button>
					                           	<button type="button" class="btn dark" id="cancel-btn" style="font-weight: bold; color: black;">Cancel</button>
					                       </praetsa:roleCheck>  
											</div>
								 </div> 
					           
					         </div>
					         	
					         				<div id="stack1" class="modal container fade" tabindex="-1">
							                       <div class="modal-header">
							                         <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
							                         <h4 class="modal-title">Order Details</h4>
							                       </div>
							                      
							                      	  <!-- BEGIN PAGE CONTENT-->
											         <div class="invoice">
											            <div class="row">
											           	 <div>
											            	</div>
											               <div class="col-xs-4">
											                  <div class="well">
											                  <ul class="list-unstyled">
											                  <li><strong><u>Customer Detail :</u></strong></li> 
											                    <!--  <li id="firstname">John Doe</li>
											                     <li id="mobileno">Mr Nilson Otto</li>
											                     <li id="landmark">FoodMaster Ltd</li>
											                     <li id="village">Madrid</li>
											                     <li id="email">Spain</li> -->
											                  </ul>
											                  <table>
											                  <tr><td>Name        :</td><td id="firstname"></td></tr>
											                  <tr><td>Mobile No   :</td><td id="mobileno"></td></tr>
											                  <tr><td>email       :</td><td id="email"></td></tr>
											                  </table>
											                  </div>
											               </div>
											                <div class="col-xs-2">
											                  <div class="well">
											                         <ul class="list-unstyled" id="address">
											                  		
											                      
											                        </ul>
											                    
											                  </div>
											               </div>
											               <div class="col-xs-2">
											                  <div class="well">
											                         <ul class="list-unstyled" id="ordernumber">
											                  		
											                      
											                        </ul>
											                    
											                  </div>
											               </div>
											               <div class="col-xs-3">
											                  <div class="well">
											                         <ul class="list-unstyled">
											                         <li><strong><u>Enter Logistic Registration Number</u></strong></li>
											                         <li><label>  </label></li>
																		<li><input id="lrno" name="lrno" type="text" class="form-control"></input></li>											                  													                    
											                        </ul>
											                    
											                  </div>
											               </div>
											               <!-- <div class="col-xs-4">
											                  <h4>About:</h4>
											                  <ul class="list-unstyled">
											                     <li>Drem psum dolor sit amet</li>
											                     <li>Laoreet dolore magna</li>
											                     <li>Consectetuer adipiscing elit</li>
											                     <li>Magna aliquam tincidunt erat volutpat</li>
											                     <li>Olor sit amet adipiscing eli</li>
											                     <li>Laoreet dolore magna</li>
											                  </ul>
											               </div> -->
											              
											            </div>
											            <div class="row">
								<div class="col-xs-12">
									<table class="table table-striped table-hover"
										id="invoiceTable">
										<thead>
											<tr>
												<th>Serial No</th>
												<th>Order Id</th>
												<th>Item</th>
												<th class="hidden-480">Order Quantity</th>
												<th>Available Stock</th>
												<th>Delivered Quantity</th>
												<th>Dispatch Here</th>
												<th class="hidden-480">Unit Cost</th>
												<th>Total</th>
											</tr>
										</thead>
										<tbody id="invoiceTbody">
										</tbody>
									</table>									
									<!-- <table>
											                  <tr><td>Take Action</td><td><label> </label></td><td><div><button type="button" class="btn blue">Save</button></div></td></tr>
											                  </table> -->
									

									<div class="col-md-offset-3 col-md-9">
											<button type="submit" class="btn blue" id="btnInvoiceSave">Save</button>
											<button type="submit" class="btn blue" id="btnForDownload">PDF</button>											
										</div>

								</div>
							</div>
											            <br />
											             <div class="row">
											               <div class="col-xs-2 NEWremark">
											                  <div class="well">
											                  	<!--  <ul class="list-unstyled amounts">
											                     	<li><strong>Remark: </strong> <strong  id="NEWremark"></strong></li>
											                  	</ul> -->
											                      <address>
											                        <strong>Remark:</strong><br/><br/>
											                        <strong  id="NEWremark"></strong>
											                       <!--  <a href="mailto:#">go for sale</a> -->
											                     </address> 
											                  </div>
											               </div>
											               <div class="col-xs-8 invoice-block NEWtotal-amt">
											                  <ul class="list-unstyled amounts">
											                     <li><strong>Grand Total: </strong><strong  id="NEWtotal-amt"></strong></li>
											                  </ul>
											                  <br />
											               </div>
											            </div>
											         </div>
							                      	
							                       <div class="modal-footer">
							                        <button type="button" class="btn blue" id="createOrder">Create Order</button>
							                         <button type="button" data-dismiss="modal" class="btn btn-default">Back</button>
							                       </div>
							                     
					                     	</div>
					                     	
					                     
					        					 <!-- Conformation Box -->
					   							<!--  <div id="stack1" class="modal fade" tabindex="-1" data-width="800">
					      								<div class="modal-dialog">
					         								<div class="modal-content">
					            								<div class="modal-header">
					               									<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
					               										<h4 class="modal-title" >Customer Entry Form</h4>
					            								</div>
					            								<div class="modal-body">
					               									<div class="row">
					                  									<div class="col-md-12">
					                     									<h4>Customer Name</h4>
					                     										<p><input type="text" class="col-md-12 form-control"></p>
					                  									</div>
					                  									
					                  								<div class="form-body">
					                  									<div class="portlet-body tableCpyCont">
					                  									
					                  									</div>
								                                    </div>
					                  							</div>
					            								</div>
					            								<div class="modal-footer">
					               									<button type="button" data-dismiss="modal" class="btn">Close</button>
					               									<button type="button" class="btn green" id="submitCustomer">Save</button>
					            								</div>
					         								</div>
					      								 </div>
					   								   </div> -->
					 		</html:form>
					 						 <!-- <div class="modal fade" id="basic11" tabindex="-1" role="basic" aria-hidden="true"> -->
							                        <div class="modal-dialog modal fade" id="basic11">
							                           <div class="modal-content">
							                              <div class="modal-header">
							                               <input type="text" id="rowOrderId" name="roworderno" value="" class="form-control input-large" style="display: none;">
							                               <input type="text" id="rowStatusId" name="rowStatusno" value="" class="form-control input-large" style="display: none;">
							                                 <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
							                                 <h4 class="modal-title">Remark</h4>
							                              </div>
							                              <div class="modal-body">
							                              <input type="text" id="remark" name="remark" class="form-control input-large">
							                              </div>
							                              <div class="modal-footer">
							                                 <button type="button" class="btn default" data-dismiss="modal">Close</button>
							                                 <button type="button" id="saveRemark" class="btn yellow">Save changes</button>
							                              </div>
							                           </div>
							                           <!-- /.modal-content -->
							                        </div>
							                        <!-- /.modal-dialog -->
					                   		  <!-- </div> -->
         <!-- END PAGE CONTENT-->
					
					</div>
					<!-- END PAGE -->  
				</div>
   				<!-- END CONTENT --> 
   				<jsp:include page="../main/quicksidebar.jsp" /> 
			</div>
		</div>
   		<!-- END CONTAINER -->
    <jsp:include page="../main/footer.jsp" />
   <jsp:include page="../main/js_entryPage.jsp" />
    <jsp:include page="../main/js_listPage.jsp"/>
      <jsp:include page="../order/orderManagementListJS.jsp" />
      
       <script src="../../assets/global/plugins/bootstrap-modal/js/bootstrap-modalmanager.js" type="text/javascript" ></script>
<script src="../../assets/global/plugins/bootstrap-modal/js/bootstrap-modal.js" type="text/javascript" ></script>
<script src="../../assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="../../assets/global/plugins/bootstrap-toastr/toastr.min.js"></script>
<script src="../../assets/global/plugins/bootstrap-touchspin/bootstrap.touchspin.js" type="text/javascript"></script>
<script type="text/javascript">
jQuery(document).ready(function() {
	   UIToastr.init();
	});
</script>	

</body>
<!-- END BODY -->
</html>