<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="../../assets/global/plugins/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="../../view/sale/js/sale.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sale</title>
<jsp:include page="../main/css_main.jsp" />
<jsp:include page="../main/css_entryPage.jsp" />
<jsp:include page="../main/js_main.jsp" />

</head>

<jsp:include page="../main/header.jsp" />

<body>

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
										class="icon-reorder POForm1"></i>Sale Form</span>
								</div>
								<div class="tools">
									<a href="javascript:;" class="collapse"></a>									
								</div>
							</div>
							<div class="portlet-body form">
								<!-- BEGIN FORM-->

								<html:form styleId="SaleForm" styleClass="form-horizontal"
									action="/view/sale/saleMasterAction">
									<html:hidden property="update" styleId="update"/>
									<html:hidden property="saleMasterIdForUpdate" styleId="saleMasterIdForUpdate"/>
									<div class="form-body">
										<div class="row">
											<div class="col-md-4">
												<div class="form-group">
													<label class="control-label col-md-5">Seller</label>
													<div class="col-md-7">
														<html:text property="retailer" styleId="retailer"
															styleClass="form-control" readonly="true"></html:text>
													</div>
												</div>
											</div>											
											<div class="col-md-7">
												<div class="form-group">
													<label class="control-label col-md-5">Date</label>
													<div class="col-md-4">
														<html:text property="createdDate" styleId="createdDate"
															styleClass="form-control" readonly="true"></html:text>
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-4">
												<div class="form-group">
													<label class="control-label col-md-5">Customer Name</label>
													<div class="col-md-7">
														<html:text property="consumername" styleId="consumername"
															styleClass="form-control"></html:text>
													</div>
												</div>
											</div>											
											<div class="col-md-7">
												<div class="form-group">
													<label class="control-label col-md-5">Address</label>
													<div class="col-md-4">
														<html:textarea property="consumeraddress" styleId="consumeraddress"
															styleClass="form-control"></html:textarea>
													</div>
												</div>
											</div>
										</div>
									</div>

									<!-- BEGIN EXAMPLE TABLE PORTLET-->
									<div class="portlet">
										<div class="portlet-title">
											<div class="caption">
												<span style="font-weight: bold;"><i class="icon-edit"></i>Pick Your Products</span>
											</div>
											<div class="tools">
												<a href="javascript:;" class="collapse"></a>												
											</div>
										</div>
										<div class="portlet-body">
											<div class="table-responsive tableCont">

												<table
													class="responsive table table-bordered table-striped table-hover disp"
													id="itable">
													<thead>
														<tr>
															<th>Product Name</th>															
															<th>Available Quantity</th>
															<th>Quantity</th>
															<th>Rate</th>
															<th>Amount</th>
															<th style="width: 4%">Add/Remove</th>
															<!-- <th class="isDisa">Void</th> -->
														</tr>
													</thead>
													<tbody id="tbody">
														<tr id="1">
															<td style="width: 25%;">
															<input type="hidden" name="saleDetailIdU" id="saleDetailIdU1"/>
																<div class="span12 controls">																
																	<html:select property="itemid" styleId="itemid1"
																		styleClass="form-control select2me" onchange="getDetails(this)">
																		<html:option value=""></html:option>
																		<logic:notEmpty name="SaleDetailActionBean"
																			property="retailItems">
																			<html:optionsCollection name="SaleDetailActionBean"
																				property="retailItems" label="name"
																				value="itemMasterId" />
																		</logic:notEmpty>
																	</html:select>
																</div>
															</td>															
															<td>
																<input class="form-control text aqty" id="availablequantity1" name="availablequantity" type="text" style="text-align: right;" readonly="readonly" />
																</td>
															<td><input class="form-control text qty " id="quantity1" name="quantity" type="text" style="text-align: right;" onkeyup="oninputquantity(this)"/>
																<span class="label label-sm label-default"></span>
																<input class="form-control text" type="hidden" readonly="readonly" name="measurement" style="text-align: center;" /> 
																<input type="hidden" name="measurementid" />
																</td>
															<td><input class="form-control text rate" id="rate1" name="rate" type="text" style="text-align: right;" onkeyup="oninputrate(this)" />
																</td>
															<td><input class="form-control text" id="amount1" name="amount" type="text" readonly="readonly" style="text-align: right;" value="0" />
																</td>
															<td><a class="btn btn-sm green " onclick="insertRow(this)"><i class="fa fa-plus"></i></a> 
																<a href="#" class="btn btn-sm red " id="cancel-button" onclick="deleteRow(this)"><i class="fa fa-minus"></i></a>
															</td>															
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
													<div class="col-md-6">
														<%-- <html:textarea property="remark" styleClass="form-control"
															styleId="remark"></html:textarea> --%>
													</div>
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label class="control-label col-md-6">Total Amount</label>
													<div class="col-md-4">
														<html:text styleClass="form-control" readonly="true"
															styleId="total" style="text-align: right;"
															property="total" />
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
											<button type="button" class="btn yellow" id="btnsubmit" title="Create New Order">
												<span style="font-weight: bold; color: black;">Submit</span>
											</button>
											<!-- <button type="button" class="btn green dropdown-toggle" data-target="#stack1" data-toggle="modal">Add <i class="icon-plus"></i></button> -->
											<button type="button" class="btn dark" id="btncancel">
												<span style="font-weight: bold; color: black;">Cancel</span>
											</button>
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

<jsp:include page="../main/footer.jsp" />
<jsp:include page="../main/js_entryPage.jsp" />

</body>
</html>