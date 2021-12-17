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
	
	  <link href="../../assets/global/plugins/bootstrap-modal/css/bootstrap-modal-bs3patch.css" rel="stylesheet" type="text/css"/>
   	<link href="../../assets/global/plugins/bootstrap-modal/css/bootstrap-modal.css" rel="stylesheet" type="text/css"/>
	
   <link rel="stylesheet" type="text/css" href="../../assets/global/plugins/bootstrap-toastr/toastr.min.css"/>
   	
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
          <!-- BEGIN PAGE FILTER-->
          <jsp:include page="../po/filter.jsp" />
         <html:form styleId="StockTakeFormList" action="/view/order/orderMasterAction">
         <!-- BEGIN PAGE CONTENT-->
         <div class="row">
            <div class="col-md-14">
                <!-- BEGIN EXAMPLE TABLE PORTLET-->
               <div class="portlet box blue-steel">
                  <div class="portlet-title">
                     <div class="caption"><span style="font-weight: bold;"><i class="icon-globe"></i>Order List</span></div>
                     <div class="tools">
                                 <a href="javascript:;" class="collapse"></a>
                     </div>
                  </div>
                  <div class="portlet-body">
                     <table class="table table-striped table-bordered table-hover table-full-width" id=example>
                        <thead>
                             <tr id="tr1">
                                <th>Order Number</th>                                 
                                 <th>Order Date</th>
                                 <th>Order Amount</th>
                                 <th>Customer</th>
                                 <th>Order Stage</th>
                                 <th>Order created Time</th>
                                 <th>View Order</th>                                 
                                 <th id="select-all">Edit Order</th>
                                 <th>Push For Export</th>
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
                                    <!--   <th></th> -->
                                      <th></th>
                                  </tr>
						</tfoot>
                     </table>
                  </div>
               </div>
               <!-- END EXAMPLE TABLE PORTLET-->
            </div>
             
              <div class="form-group">
             <div class="row">
                  <div class="col-md-6">
                  <label  class="col-md-2 control-label">Select Printer</label>
                     <div class="radio-list">
                        <label class="radio-inline">
                        <input type="radio" name="printer" value="1" id="laserPrinterId" checked="checked">Laser printer
                        <input type="radio" name="printer" value="2" id="thermalPrinterId">Thermal printer
                        </label>
                        
                     </div>
                     <!-- <div class="radio-list">
                        <label class="radio-inline">
                        
                        </label>
                        
                     </div> -->
                  </div>
             </div>
             </div> 
             <div class="form-actions">
             	<div class="row">
                       <div class="col-md-offset-3 col-md-9">
                       
                       <!--      <input type="hidden" name="stockTakeExport" id="stockTake-status" value="3" /> -->
                           	<button type="button" class="btn yellow" id="printOrder" style="font-weight: bold; color: black;">Print Order</button>
                           	<button type="button" class="btn yellow" id="exportSheet" style="font-weight: bold; color: black;">Export In Sheet</button>
						</div>
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
						                  <li><strong><u>Customer :</u></strong></li> 
						                     <li id="firstname">John Doe</li>
						                     <li id="mobileno">Mr Nilson Otto</li>
						                     <!-- <li id="landmark">FoodMaster Ltd</li>
						                     <li id="village">Madrid</li> -->
						                     <li id="email">Spain</li>
						                  </ul></div>
						               </div>
						                <div class="col-xs-2">
						                  <div class="well">
						                         <ul class="list-unstyled" id="address">
						                  		
						                      
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
						                  <table class="table table-striped table-hover" id="invoiceTable">
						                     <thead>
						                        <tr>
						                           <th>Serial No</th>
						                           <th>Item</th>
						                           <th class="hidden-480">Quantity</th>
						                           <th>Dispatched Quantity</th>
						                           <th class="hidden-480">Unit Cost</th>
						                           <th>Total</th>
						                        </tr>
						                     </thead>
						                     <tbody id="invoiceTbody">
						                     </tbody>
						                  </table>
						               </div>
						            </div>
						            <br />
						             <div class="row">
						               <!-- <div class="col-xs-2 NEWremark">
						                  <div class="well">
						                  	 <ul class="list-unstyled amounts">
						                     	<li><strong>Remark: </strong> <strong  id="NEWremark"></strong></li>
						                  	</ul>
						                      <address>
						                        <strong>Remark:</strong><br/><br/>
						                        <strong  id="NEWremark"></strong>
						                        <a href="mailto:#">go for sale</a>
						                     </address> 
						                  </div>
						               </div> -->
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
   								   </div>  -->
 					</html:form>
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
    <jsp:include page="../main/js_listPage.jsp"/>
   <jsp:include page="../order/orderListJS.jsp" />

   <script src="../../assets/global/plugins/bootstrap-modal/js/bootstrap-modalmanager.js" type="text/javascript" ></script>
<script src="../../assets/global/plugins/bootstrap-modal/js/bootstrap-modal.js" type="text/javascript" ></script>
<script src="../../assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="../../assets/global/plugins/bootstrap-toastr/toastr.min.js"></script>
<script src="../../assets/global/plugins/bootbox/bootbox.min.js"></script>
<script type="text/javascript">
jQuery(document).ready(function() {
	   UIToastr.init();
	});
</script>	

</body>
<!-- END BODY -->
</html>