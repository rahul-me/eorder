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
   <jsp:include page="../main/css_entryPage.jsp" />
       
    <jsp:include page="../main/js_main.jsp"/>
    
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
         
          <div class="row">
            <div class="col-md-14">
                <!-- BEGIN EXAMPLE TABLE PORTLET-->
               <div class="portlet box yellow">
                  <div class="portlet-title">
                  </div>
                  <div class="portlet-body">
                      <div class="row">
                              	<div class="col-md-4">
                                 	   <div class="form-group">
                                          <label class="control-label col-md-5">Report Category</label>
                                            <div class="col-md-6">
                                            	<select name="report" id="reportId"
													style="width:100%;" class="form-control input-medium select2me" placeholder="Select Report Type">
													<option value=""></option>
												 	<option value="SCM_GR">GR</option>
													<option value="SCM_PO">PO</option> 
													<option value="SCM_TO">TO</option>
													<option value="SCM_STOCK">StockTake</option>
													<option value="SCM_ITEMS">Items</option>
													<option value="SCM_INDIVIDUAL_LIST_REPORT">Individual Report</option>
													<option value="SCM_PNL">Goods Consumption Report</option>
												</select>
                                             </div>
                                          </div> 
                                  </div>
                                 <div class="col-md-4">
									<div class="form-group">
										<label class="control-label col-md-6">Select Report</label>
                                           	<div class="col-md-6">
                                           		<select name="reportSub" id="reportSubId" style="width:100%;" class="form-control input-medium select2me" placeholder="Select Report Type">
											 		<option value=""></option>
												</select>
                                             	<span class="label label-sm label-success">Select Report Category</span>
                                            </div>
								</div>
							</div>
                      </div>
                  </div>
               </div>
               <!-- END EXAMPLE TABLE PORTLET-->
            </div>
         </div>
         
          <!-- BEGIN PAGE FILTER-->
          <jsp:include page="../po/filter.jsp" />
         <!-- BEGIN PAGE CONTENT-->
         <div class="row">
            <div class="col-md-14">
                <!-- BEGIN EXAMPLE TABLE PORTLET-->
                     <div class="box gradient" id="report-frame">
									 <div   style="overflow-x:hidden ;  width: 100%;">
									 <iframe  name="report"  style="min-height: 700px " style="position:  absolute; "scrolling="auto" src="" height="100%" width="100%" id="js"></iframe> 
                        			 </div>                             
                                
                                
                      </div>
               <!-- END EXAMPLE TABLE PORTLET-->
            </div>
         </div>
         <!-- END PAGE CONTENT-->
      </div>
      <!-- END PAGE -->
	</div>
	<div id="error" style="display: none"><html:errors/></div>
   <!-- END CONTAINER -->
    <jsp:include page="../main/footer.jsp" />
    <jsp:include page="../main/js_entryPage.jsp" />
      <jsp:include page="../report/reportJS.jsp" />
</body>
</html>