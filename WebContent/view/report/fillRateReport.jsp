<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title> Neetai Tech.</title>


   <jsp:include page="../main/css_main.jsp"/>
   
   <!-- BEGIN PAGE LEVEL STYLES for datatable -->
	<link rel="stylesheet" href="../../assets/plugins/data-tables/DT_bootstrap.css" />
   <link rel="stylesheet" type="text/css" href="../../assets/plugins/select2/select2_metro.css" />
   
   
    <jsp:include page="../main/js_main.jsp"/>
    
     <!-- BEGIN PAGE LEVEL PLUGINS  for data table-->
   <script type="text/javascript" src="../../assets/plugins/data-tables/jquery.dataTables.js"></script>
   <script type="text/javascript" src="../../assets/plugins/data-tables/DT_bootstrap.js"></script>
   <script type="text/javascript" src="../../assets/plugins/select2/select2.min.js"></script>
  
    
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
        <form id="POListForm" class="form-horizontal" action="">
         <!-- BEGIN PAGE CONTENT-->
         <div class="row">
            <div class="col-md-14">
                <!-- BEGIN EXAMPLE TABLE PORTLET-->
               <div class="portlet box yellow">
                  <div class="portlet-title">
                     <div class="caption"><i class="icon-globe"></i>Fill Rate Report</div>
                  </div>
                  <div class="portlet-body">
                     <table class="table table-striped table-bordered table-hover table-full-width" id=example>
                        <thead>
                             <tr id="tr1">
                                 <th rowspan="2">SL No</th>
                                  <th id="th1" rowspan="2">PO No</th>
                                  <th rowspan="2">Supplier Name</th>
                                  <th rowspan="2">Created Date</th>
                                  <th style="width: 20%" rowspan="2">Site Created</th>
                                  <th rowspan="2">Status</th>
                                  <th colspan="3">CRITICAL</th>
                                  <th colspan="3">NON-CRITICAL</th>
                                  <th rowspan="2">Select All<input type="checkbox" id="select-all"></th>
                              </tr>
                               <tr>
	                               <th>No of Item</th>
	                               <th>Line Fill Rate(%)</th>
	                               <th>Quantity Fill Rate</th>
	                               <th>No of Item</th>
	                               <th>Line Fill Rate(%)</th>
	                               <th>Quantity Fill Rate</th>
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
								   <th style="text-align: center;">Total</th>
								   <th style="text-align: center;"></th>
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
         </div>
 		</form>
         <!-- END PAGE CONTENT-->
      </div>
      <!-- END PAGE -->
	</div>
	<div id="error" style="display: none"><html:errors/></div>
   <!-- END CONTAINER -->
    <jsp:include page="../main/footer.jsp" />
      <jsp:include page="../report/fillRateReportJS.jsp" />
</body>
</html>