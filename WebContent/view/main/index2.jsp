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
	<jsp:include page="../main/css_entryPage.jsp" />
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
							<h3 class="page-title">
							Dashboard <small>reports & statistics</small>
							</h3>
							<div class="page-bar">
								<ul class="page-breadcrumb">
									<li>
										<i class="fa fa-home"></i>
										<a href="">Home</a>
										<i class="fa fa-angle-right"></i>
									</li>
									<li>
										<a href="#">Dashboard</a>
									</li>
								</ul>
								<!-- <div class="page-toolbar">
									<div id="dashboard-report-range" class="pull-right tooltips btn btn-fit-height grey-salt" data-placement="top" data-original-title="Change dashboard date range">
										<i class="icon-calendar"></i>&nbsp;
										<span class="thin uppercase visible-lg-inline-block">&nbsp;</span>&nbsp;
										<i class="fa fa-angle-down"></i>
									</div>
								</div> -->
							</div>
							<!-- END PAGE HEADER-->
							<!-- BEGIN DASHBOARD STATS -->
							<div class="row">
								<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
									<div class="dashboard-stat blue-madison">
										<div class="visual">
											<i class="fa fa-comments"></i>
										</div>
										<div class="details">
											<div class="number">
												 <label style="font-size: 34px" id="totalOrder"></label>
											</div>
											<div class="desc">
												 Total Order
											</div>
										</div>
										<a class="more" href="#">
										View more <i class="m-icon-swapright m-icon-white"></i>
										</a>
									</div>
								</div>
								<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
									<div class="dashboard-stat red-intense">
										<div class="visual">
											<i class="fa fa-bar-chart-o"></i>
										</div>
										<div class="details">
											<div class="number">
												 <label style="font-size: 34px" id="totalAmount"></label>
											</div>
											<div class="desc">
												 Total Amount
											</div>
										</div>
										<a class="more" href="#">
										View more <i class="m-icon-swapright m-icon-white"></i>
										</a>
									</div>
								</div>
								
								<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
									<div class="dashboard-stat purple-plum">
										<div class="visual">
											<i class="fa fa-globe"></i>
										</div>
										<div class="details">
											<div class="number">
												 <label style="font-size: 34px" id="totalItem"></label>
											</div>
											<div class="desc">
												 Total Item Quantity
											</div>
										</div>
										<a class="more" href="#">
										View more <i class="m-icon-swapright m-icon-white"></i>
										</a>
									</div>
								</div>
								<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
									<div class="dashboard-stat green-haze">
										<div class="visual">
											<i class="fa fa-shopping-cart"></i>
										</div>
										<div class="details">
											<div class="number">
												 <label style="font-size: 34px" id="status"> Good</label>
											</div>
											<div class="desc">
												 Server Status
											</div>
										</div>
										<a class="more" href="#">
										View more <i class="m-icon-swapright m-icon-white"></i>
										</a>
									</div>
								</div>
							</div>
							<!-- END DASHBOARD STATS -->
						
							<div class="clearfix">
							</div>
					
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
   <jsp:include page="../main/dashboardJS.jsp" />
   

    <%--  <jsp:include page="../main/billingJS.jsp" />  --%>

</body>
<!-- END BODY -->
</html>