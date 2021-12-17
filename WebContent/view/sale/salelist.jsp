<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sale List</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta content="width=device-width, initial-scale=1.0" name="viewport" />
   <meta content="" name="description" />
   <meta content="" name="author" />
   <meta name="MobileOptimized" content="320">
	<jsp:include page="../main/css_main.jsp" />
	<jsp:include page="../main/css_listPage.jsp"/>
 	<jsp:include page="../main/js_main.jsp" />
</head>
<jsp:include page="../main/header.jsp" /><!-- header will have start of body tag -->
	<div class="page-container">
	   		<div class="page-sidebar-wrapper">	
				<div class="page-sidebar navbar-collapse collapse">
					<ul class="page-sidebar-menu" data-slide-speed="200" data-auto-scroll="true">
						 <jsp:include page="../main/menubarforsmallscreen.jsp" /> 
					</ul>
				</div>
   				<div class="page-content-wrapper">					
					<div class="page-content">						                   
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
				         <%-- <html:form styleId="ItemForm" action="/view/item/ItemMasterAction"> --%>
				         <!-- BEGIN PAGE CONTENT-->
				         <div class="row">
				            <div class="col-md-14">
				                <!-- BEGIN EXAMPLE TABLE PORTLET-->
				               <div class="portlet box blue-steel">
				                  <div class="portlet-title">
				                     <div class="caption"><span style="font-weight: bold; "><i class="icon-globe"></i>Sale List</span></div>
				                      <div class="actions">
				                        <div class="btn-group">
				                           <div class="caption"><a href="../../view/sale/saleViewAction.do" class="btn yellow" title="Sell"><span style="font-weight: bold; color: black;"><i class="fa fa-plus"></i> Go To Sale Entry</span></a></div>
				                        </div>
				                     </div>
				                     <!-- <div class="tools">
				                                 <a href="javascript:;" class="collapse"></a>
				                     </div> -->
				                  </div>
				                  
				                  <div class="portlet-body">
				                     <table class="table table-striped table-bordered table-hover table-full-width" id=example>
				                        <thead>
				                             <tr>				                             	
				                                <th>Serial No</th>
				                                <th>Item Name</th>                               
				                                <th>Quantity</th>
				                                <th>Rate</th>
				                                <th>Amount</th>
				                                <th>Date</th>
				                                <th>Consumer Name</th>
				                                <th>Address </th>
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
				 		<%-- </html:form> --%>
					
					</div>
					<!-- END PAGE -->  
				</div>
   				<!-- END CONTENT --> 
   				<jsp:include page="../main/quicksidebar.jsp" /> 
			</div>
		</div>
	<jsp:include page="../main/footer.jsp" />
    <jsp:include page="../sale/salelistJS.jsp"/>
    <jsp:include page="../main/js_listPage.jsp"/>	
</body>
</html>