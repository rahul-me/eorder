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
<jsp:include page="../main/css_listPage.jsp" />
<link
	href="../../assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css"
	rel="stylesheet" type="text/css" />
<jsp:include page="../main/js_main.jsp" />
</head>

<!-- END HEAD -->
<jsp:include page="../main/header.jsp" />
<!-- BEGIN CONTAINER -->
<div class="page-container">
	<div class="page-sidebar-wrapper">
		<!-- BEGIN EMPTY PAGE SIDEBAR -->
		<div class="page-sidebar navbar-collapse collapse">
			<ul class="page-sidebar-menu" data-slide-speed="200"
				data-auto-scroll="true">
				<jsp:include page="../main/menubarforsmallscreen.jsp" />
			</ul>
		</div>
		<!-- END EMPTY PAGE SIDEBAR -->
		<!-- BEGIN CONTENT -->
		<div class="page-content-wrapper">
			<!-- BEGIN PAGE -->
			<div class="page-content">

				<div class="row">
					<div class="col-md-14">
						<!-- BEGIN PORTLET-->
						<div class="portlet box blue-steel">
							<div class="portlet-title">
								<div class="caption">
									<span style="font-weight: bold;">Item Settings</span>
								</div>
							</div>
							<div class="portlet-body form">
								<!-- BEGIN FORM-->
								<form name="settingConfigForm" id="settingConfigForm">
									<div class="form-body">
										<div class="form-group">
											<label class="control-label col-md-3">item Price:</label>
											<div class="col-md-9">
												<input type="checkbox" name="active" checked
													class="make-switch" data-size="medium">
											</div>
										</div>
									</div>
									
									<div class="portlet-body">
						
						<h4>Default Email Setting</h4>
							Email
							<div class="form-group">
								<div class="input-icon">
									<i class="fa fa-envelope"></i>
									<input class="form-control" id="emailId" name="email"/>
								</div>
							</div>
							Password
							<div class="form-group">
								<div class="input-icon">
									<i class="fa fa-user"></i>
									<input type="password" class="form-control" id="epasswordId" name="epassword">
								</div>
							</div>
							Company Host
							<div class="form-group">
								<div class="input-icon">
									<i class="fa fa-envelope"></i>
									<input class="form-control" id="companyHost" name="companyHost"/>
								</div>
							</div>
							Company Port
							<div class="form-group">
								<div class="input-icon">
									<i class="fa fa-envelope"></i>
									<input class="form-control" id="companyPort" name="companyPort"/>
								</div>
							</div>
							Company Trust
							<div class="form-group">
								<div class="input-icon">
									<i class="fa fa-envelope"></i>
									<input class="form-control" id="companyTrust" name="companyTrust"/>
								</div>
							</div>
							<button type="button" class="btn btn-default" id="subEmail">Save</button>
						
						<hr>
						<h4>Default Message Setting</h4>
							<div class="form-group">
								<div class="input-icon">
									<i class="fa fa-envelope"></i>
									<input class="form-control" id="smsId" name="sms"/>
								</div>
							</div>
							<div class="form-group">
								<div class="input-icon">
									<i class="fa fa-user"></i>
									<input type="password" class="form-control" id="spasswordId" name="spassword">
								</div>
							</div>
							<button type="button" class="btn btn-default" id="subSMS">Save</button>
						<hr>
						</form>
					</div>

								

								<!-- END FORM-->
							</div>
						</div>

						

						<!-- END PORTLET-->
					</div>
					
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
								<div class="caption">
									<span style="font-weight: bold;"><i
										class="icon-reorder POForm1"></i>Order Management Settings</span>
								</div>
								<div class="tools">
									<a href="javascript:;" class="collapse"></a>									
								</div>
							</div>
							<div class="portlet-body form">
								<!-- BEGIN FORM-->
								<div class="form-body">
										<div class="form-group">
											<label class="control-label col-md-3">Unit Cost Editable</label>
											<div class="col-md-9">
												<input type="checkbox" id="unitCostEditable" name="unitCostEditable" value="0">
											</div>											
										</div>
									</div>
								
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
			<!-- END PAGE -->
		</div>
		<!-- END CONTENT -->
		<jsp:include page="../main/quicksidebar.jsp" />
	</div>
</div>
<!-- END CONTAINER -->
<jsp:include page="../main/footer.jsp" />
<jsp:include page="../main/js_entryPage.jsp" />
<jsp:include page="../main/js_listPage.jsp" />
<jsp:include page="../settings/settingConfigJS.jsp" />
<script
	src="../../assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js"
	type="text/javascript"></script>

<%--  <jsp:include page="../main/billingJS.jsp" />  --%>

</body>
<!-- END BODY -->
</html>