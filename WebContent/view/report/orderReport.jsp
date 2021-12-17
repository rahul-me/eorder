<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Report</title>
<script type="text/javascript"
	src="../../assets/global/plugins/jquery-2.1.4.min.js"></script>
<!-- <script type="text/javascript" src="../../view/report/js/orderReport.js"></script> -->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sale</title>
<jsp:include page="../main/css_main.jsp" />
<jsp:include page="../main/css_listPage.jsp" />
<jsp:include page="../main/js_main.jsp" />
</head>
<jsp:include page="../main/header.jsp" /><!--In place of <body>  -->

<div class="page-content-wrapper">
	<div class="page-container">
		<div class="page-sidebar navbar-collapse collapse">
			<ul class="page-sidebar-menu visible-sm visible-xs">
				<jsp:include page="../main/menubarforsmallscreen.jsp" />
			</ul>
		</div>
		<div class="page-content">
			<div class="row">
				<div class="col-md-14">
					<div class="portlet box blue-steel">
						<div class="portlet-title">
							<div class="caption">
								<span style="font-weight: bold;"><i
									class="icon-reorder POForm1"></i>Order Report</span>
							</div>
							<div class="tools">
								<a href="javascript:;" class="collapse"></a>
							</div>
						</div>
						<div class="portlet-body form">
							<%-- <html:form styleId="Order Report Form" styleClass="form-horizontal"> --%>
							<div class="form-body">
								<div class="row" style="margin-top: 21px;">
									<div class="col-md-4">
										<div class="form-group">
											<label class="control-label col-md-3">Select Month</label>
											<div class="col-md-7">
												<select name="month" class="form-control select2me"
													style="width: 100%" id="month">
													<option value=""></option>
													<option value="01">January</option>
													<option value="02">February</option>
													<option value="03">March</option>
													<option value="04">April</option>
													<option value="05">May</option>
													<option value="06">June</option>
													<option value="07">July</option>
													<option value="08">August</option>
													<option value="09">September</option>
													<option value="10">October</option>
													<option value="10">November</option>
													<option value="10">December</option>
												</select>
											</div>
										</div>
									</div>
									<div class="col-md-3">
										<div class="form-group">
											<label class="control-label col-md-3">Year</label>
											<div class="col-md-7">
												<input type="text" name="txtyear" id="txtyear"
													class="form-control" />
											</div>
										</div>
									</div>
									<div class="col-md-3">
										<div class="form-group">
											<div class="col-md-7">
												<button type="button" class="btn green-meadow selectFilter"
													id="btnSubmit">
													<span style="font-weight: bold; color: black;">Submit</span>
												</button>
											</div>
										</div>
									</div>
								</div>
								<div class="row" style="margin-top: 21px;">
									<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
										<div class="dashboard-stat blue-madison">
											<div class="visual">
												<i class="fa fa-comments"></i>
											</div>
											<div class="details">
												<div class="number" id="totalorder">0</div>
												<div class="desc">Total Orders</div>
											</div>
											<!-- <a class="more" href="#">
						View more <i class="m-icon-swapright m-icon-white"></i>
						</a> -->
										</div>
									</div>
									<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
										<div class="dashboard-stat red-intense">
											<div class="visual">
												<i class="fa fa-bar-chart-o"></i>
											</div>
											<div class="details">
												<div class="number" id="totaliteminorder">0</div>
												<div class="desc">Items in Order</div>
											</div>
											<!-- <a class="more" href="#">
						View more <i class="m-icon-swapright m-icon-white"></i>
						</a> -->
										</div>
									</div>
									<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
										<div class="dashboard-stat green-haze">
											<div class="visual">
												<i class="fa fa-shopping-cart"></i>
											</div>
											<div class="details">
												<div class="number" id="orderquantity">0</div>
												<div class="desc">Total Quantity</div>
											</div>
											<!-- <a class="more" href="#">
						View more <i class="m-icon-swapright m-icon-white"></i>
						</a> -->
										</div>
									</div>
									<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
										<div class="dashboard-stat purple-plum">
											<div class="visual">
												<i class="fa fa-globe"></i>
											</div>
											<div class="details">
												<div class="number" id="totalamount">0</div>
												<div class="desc">Total Amount</div>
											</div>
											<!-- <a class="more" href="#">
						View more <i class="m-icon-swapright m-icon-white"></i>
						</a> -->
										</div>
									</div>
								</div>
							</div>
							<div class="portlet">
								<div class="portlet-title">
									<div class="caption">
										<span style="font-weight: bold;"><i class="icon-edit"></i>Detailed
											Report</span>
									</div>
									<div class="tools">
										<a href="javascript:;" class="collapse"></a>
									</div>
								</div>
								<div class="portlet-body">
									<div class="table-responsive tableCont">

										<table
											class="table table-striped table-bordered table-hover table-full-width"
											id=example>
											<thead>
												<tr>
													<th>Serial Number</th>
													<th>Product Name</th>
													<th>Order Number</th>
													<th>Order Date</th>
													<th>Order Quantity</th>
													<th>Delivered Quantity</th>
													<th>Order Status</th>
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
												</tr>
											</tfoot>
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
											<div class="col-md-6"></div>
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<label class="control-label col-md-6"></label>
											<div class="col-md-4"></div>
										</div>
									</div>
									<!--/span-->
								</div>
								<!--/row-->

							</div>


							<div class="form-actions submitEntry confirm disp">
								<div class="col-md-offset-5 col-md-4">
									<!-- <button type="button" id="createOrsubmit" title="Create StockTake And Go To List Page" class="btn green">Save</button> -->
									<button type="button" class="btn yellow" id="btnsubmit"
										title="Create New Order">
										<span style="font-weight: bold; color: black;">Submit</span>
									</button>
									<!-- <button type="button" class="btn green dropdown-toggle" data-target="#stack1" data-toggle="modal">Add <i class="icon-plus"></i></button> -->
									<button type="button" class="btn dark" id="btncancel">
										<span style="font-weight: bold; color: black;">Cancel</span>
									</button>
								</div>
							</div>
							<%-- </html:form>	 --%>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="../main/footer.jsp" />
<jsp:include page="../main/js_listPage.jsp" />
<jsp:include page="../report/orderReportJS.jsp" />

</body>
</html>