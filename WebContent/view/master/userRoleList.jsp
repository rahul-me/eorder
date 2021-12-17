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
				         
				          <!-- BEGIN PAGE FILTER-->
				          <%-- <jsp:include page="../po/filter.jsp" /> --%>
				         <html:form styleId="ItemCategoryForm" action="/view/itemcategories/ItemCategoryMasterAction">
				         <!-- BEGIN PAGE CONTENT-->
				         <div class="row">
				            <div class="col-md-14">
				                <!-- BEGIN EXAMPLE TABLE PORTLET-->
				               <div class="portlet box blue-steel">
				                  <div class="portlet-title">
				                     <div class="caption"><span style="font-weight: bold;"><i class="icon-globe"></i>UserRole List</span></div>
				                      <div class="actions">
				                        <div class="btn-group">
				                           <div class="caption"><a href="../../view/users/UsersRoleViewAction.do" class="btn yellow" title="Create New UserRole"><span style="font-weight: bold; color: black;"><i class="fa fa-plus"></i> Create UserRole</span></a></div>
				                        </div>
				                     </div>
				                  </div>
				                  <div class="portlet-body">
				                     <table class="table table-striped table-bordered table-hover table-full-width" id=example>
				                        <thead>
				                             <tr>
				                                <th id="th1">No</th>
				                                <th>UserRole Name</th>                               
				                                <th>Created By</th>
				                                <th>Status</th>
				                                <th>Edit</th>
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
												 </tr>
										</tfoot>
				                     </table>
				                  </div>
				               </div>
				               <!-- END EXAMPLE TABLE PORTLET-->
				            </div>
				         </div>
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
   <jsp:include page="../master/userRoleListJS.jsp" />
   

    <%--  <jsp:include page="../main/billingJS.jsp" />  --%>

</body>
<!-- END BODY -->
</html>