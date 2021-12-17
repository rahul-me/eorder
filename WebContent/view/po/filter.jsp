<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<link rel="stylesheet" type="text/css" href="../../assets/global/plugins/bootstrap-datepicker/css/datepicker.css"/>
<script type="text/javascript" src="../../assets/global/plugins/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>

<style>
.input-group-addon, .input-group-btn {
 width: 0%; 
}
.input-group-addon {
line-height: 0;
}
</style>

 <div class="row">
            <div class="col-md-14">
               <div class="portlet box solid grey-cascade">
                  <div class="portlet-title">
                     <div class="caption"><span style="font-weight: bold;"><i class="icon-reorder"></i>Filter</span></div>
                     <div class="tools">
                        <a href="javascript:;" class="collapse" id="filterDisp"></a>
                        <!-- <a href="#portlet-config" data-toggle="modal" class="config"></a> -->
                     </div>
                  </div>
               <div class="portlet-body" id="filterBody">
                     <div class="scroller" style="height:70px" data-always-visible="1" data-rail-visible="0">
                         <html:form styleId="POForm" styleClass="form-horizontal" action="/view/po/filterViewAction">
                     		 <div class="row">
                     			  <div class="col-md-10">
                     			  
                                      <%--  <div class="col-md-4 siteId">
                                          <div class="form-group">
                                          		<html:select property="siteid" styleClass="input-medium"  styleId="siteId"  multiple="multiple">
					                                <html:option value=""></html:option>
													<html:optionsCollection name="filterActionForm"	property="siteList" label="siteName" value="siteId" />
					                              </html:select>
                                          </div>
                                       </div>
                                       <!--/span-->--%>
                                       
                                       <!--/span-->
                                        <div class="col-md-3 itemIds" style="display: none;">
                                          <div class="form-group">
                                          <div class="col-md-11">
                                          	<html:select property="itemIds" style="width:100%;" styleId="itemId" multiple="multiple">
											<html:option value=""></html:option>
											<logic:notEmpty name="filterActionForm" property="itemList">
											<html:optionsCollection name="filterActionForm"
												property="itemList" label="name" value="itemMasterId" />
												</logic:notEmpty>
										</html:select>
										</div>
                                          </div>
                                       </div>
                                       <!--/span-->
                                      <%--  <div class="col-md-3 customerId" style="display: none;">
                                          <div class="form-group">
                                          <div class="col-md-11">
                                          		<html:select property="customerId"
											 styleId="customerId" style="width:100%;" multiple="multiple">
											<html:option value=""></html:option>
											<html:optionsCollection name="filterActionForm"
												property="customerList" label="firstName"
												value="id" />
										    </html:select>
										    </div>
                                          </div>
                                        </div> --%>
                                        
                                         <div class="col-md-3 orderMasterId" style="display: none;">
                                          <div class="form-group">
                                          <div class="col-md-11">
                                          		<html:select property="orderMasterId"
											 styleId="orderMasterId" style="width:100%;" multiple="multiple">
											<html:option value=""></html:option>
											<logic:notEmpty name="filterActionForm" property="orderMasterList">
											<html:optionsCollection name="filterActionForm"
												property="orderMasterList" label="orderNumber"
												value="orderMasterId" />
											</logic:notEmpty>	
										    </html:select>
										    </div>
                                          </div>
                                        </div>
                                        
                                        <div class="col-md-3 orderStageId" style="display: none;">
                                          <div class="form-group">
                                          <div class="col-md-11">
                                          		<html:select property="orderStageId"
											 styleId="orderStageId" style="width:100%;" multiple="multiple">
											<html:option value=""></html:option>
											<logic:notEmpty name="filterActionForm" property="orderStageList">
											<html:optionsCollection name="filterActionForm"
												property="orderStageList" label="name"
												value="orderStageMasterId" />
											</logic:notEmpty>	
										    </html:select>
										    </div>
                                          </div>
                                        </div>
                                        
                                        <div class="col-md-3 orderStatus" style="display: none;">
                                          <div class="form-group">
                                          <div class="col-md-11">                                          		
											<html:select property="orderStatus" style="width:100%;" styleId="orderStatus"  multiple="multiple">
													<option value=""></option>
													<option value="1">Active</option>
													<option value="0">In Active</option>
												</html:select>																						   
										    </div>
                                          </div>
                                        </div>                                      
                                   		 
                                   		 <div class="col-md-3 datePackage" style="display:none;">
                                   		 	<div class="form-group">
                                   		 		<div >
                                   		 			<div class="input-group input-daterange">
                                   		 				<html:text property="fromPackageDate"></html:text>
                                   		 				<html:text property="toPackageDate"></html:text>
                                   		 			</div>
                                   		 		</div>
                                   		 	</div>
                                   		 </div>
                                       
                                   		<div class="col-md-3 userName" style="display: none;">
                                          <div class="form-group">
                                          <div class="col-md-11">
                                          		<html:select property="userId" style="width:100%;" styleId="userId" multiple="multiple">
													<html:option value=""></html:option>
													<logic:notEmpty name="filterActionForm" property="userList">
													<html:optionsCollection name="filterActionForm" property="userList" label="userName" value="userMasterId" />
													</logic:notEmpty>
												</html:select>
												</div>
                                          </div>
                                       </div>
                                      
                                       <!--/span-->
                                       <div class="col-md-3 userRole" style="display: none;">
                                          <div class="form-group">
                                          <div class="col-md-11">
                                          		<html:select property="userRole" style="width:100%;" styleId="userRoleId"  multiple="multiple">
													<html:option value=""></html:option>
													<logic:notEmpty name="filterActionForm" property="userRoleList">
													<html:optionsCollection name="filterActionForm" property="userRoleList" label="name" value="userRolesMasterId" />
													</logic:notEmpty>
												</html:select>
												</div>
                                          </div>
                                       </div>
                                                                              
                                       <div class="col-md-3 POStatusId" style="display: none;">
                                          <div class="form-group">
                                          <div class="col-md-11">
                                          		<html:select property="POStatusId" style="width:100%;" styleId="POStatus" multiple="multiple">
													<html:option value="1">Save</html:option>
													<html:option value="2">Submit</html:option>
													<html:option value="3">Serviced</html:option>
													<html:option value="4">Cancel</html:option>
													<html:option value="5">Close</html:option>
												</html:select>
												</div>
                                          </div>
                                       </div>
                                       <!--/span-->
                                        <div class="col-md-3 date" style="display: none;">
	                                       <div class="form-group ">
	                                          <div class="input-group input-daterange">
	                                              <html:text property="fromDate" styleClass="form-control" styleId="datepicker2" />
	                                             <span class="input-group-addon">to</span>
	                                             <html:text property="toDate" styleClass="form-control" styleId="datepicker1"/>
	                                          </div>
	                                          <!-- /input-group -->
	                                       </div>
                                   		 </div>
                                       <!--/span-->
                                       <!--/span-->
                                       <%-- <div class="col-md-4 TOSupplierId">
                                          <div class="form-group">
                                          		<html:select property="supplierSiteCode" styleClass="input-medium"
											style="width:100%;" styleId="supplierSiteCode" multiple="multiple">
											<html:option value=""></html:option>
											<html:optionsCollection name="filterActionForm"
												property="TOSupplierList" label="supplierName"
												value="supplierSiteCode" />
										</html:select>
                                          </div>
                                       </div>
                                       <!--/span-->
                                       <div class="col-md-4 TOSiteId">
                                          <div class="form-group">
                                          		<html:select property="TOSiteId" styleClass="input-medium"
											style="width:100%" styleId="TOSiteId" multiple="multiple">
											<html:option value=""></html:option>
											<html:optionsCollection name="filterActionForm"	property="TOSiteList" label="siteName" value="superSiteId" />
										</html:select>
                                          </div>
                                       </div>
                                       <!--/span-->
                                       <div class="col-md-4 POStatusId">
                                          <div class="form-group">
                                          		<html:select property="POStatusId" styleClass="input-medium"
											style="width:100%;" styleId="POStatus" multiple="multiple">
									
											<html:option value="${constants.PO_STATUS_SAVE}">Save</html:option>
											<html:option value="${constants.PO_STATUS_SUBMIT}">Submit</html:option>
											<html:option value="${constants.PO_STATUS_SERVICED}">Serviced</html:option>
											<html:option value="${constants.PO_STATUS_CANCEL}">Cancel</html:option>
											<html:option value="${constants.PO_STATUS_CLOSED}">Close</html:option>
										</html:select>
                                          </div>
                                       </div>
                                       <!--/span-->
                                       <div class="col-md-4 POId">
                                          <div class="form-group">
                                          		<html:select property="POId" styleClass="input-medium"
											style="width:100%;" styleId="PO" multiple="multiple">
											<html:option value=""></html:option>
											<html:optionsCollection name="filterActionForm"
												property="POLoginSiteList" label="purchaseOrderMasterId"
												value="purchaseOrderMasterId" />
										</html:select>
                                          </div>
                                       </div>
                                       <!--/span-->
                                       <div class="col-md-4 TOId">
                                          <div class="form-group">
                                          		<html:select property="TOId" styleClass="input-medium"
											style="width:100%;" styleId="TOId" multiple="multiple">
											<html:option value=""></html:option>
											<html:optionsCollection name="filterActionForm"
												property="TOLoginSiteList" label="transferOrderMasterId"
												value="transferOrderMasterId" />
										</html:select>
                                          </div>
                                       </div>
                                       <!--/span-->
                                       <div class="col-md-4 TOStatusId">
                                          <div class="form-group">
                                          		<html:select property="TOStatusId" styleClass="input-medium"
											style="width:100%;" styleId="TOStatus" multiple="multiple">
											<html:option value="${constants.TO_STATUS_OPEN}">Save</html:option>
											<html:option value="${constants.TO_STATUS_PENDING}">Not Shiped</html:option>
											<html:option value="${constants.TO_STATUS_SHIPPED}">Shipment Notice</html:option>
											<html:option value="${constants.TO_STATUS_CLOSE}">Close</html:option>
										</html:select>
                                          </div>
                                       </div> 
                                       <!--/span-->
                                       <div class="col-md-4 site-Id">
                                          <div class="form-group">
                                          		<html:select property="siteid" styleClass="input-medium"
											style="width:100%" styleId="site-Id" multiple="multiple">
											<html:option value=""></html:option>
											<html:optionsCollection name="filterActionForm"	property="siteList" label="siteName" value="siteId" />
										</html:select>
                                          </div>
                                       </div>
                                       <!--/span-->--%>
                                      
                                       <%--<div class="col-md-4 itemCategoryId">
                                          <div class="form-group">
                                          		<html:select property="itemCategoryId" styleClass="input-medium"
											style="width:100%;" styleId="itemCategoryId" multiple="multiple">
											<html:option value=""></html:option>
											<html:optionsCollection name="filterActionForm"
												property="itemCategoryList" label="itemCategoryName"
												value="itemCategoryId" />
										</html:select>
                                          </div>
                                       </div>
                                       <!--/span-->
                                        <div class="col-md-4 TOByPOId">
                                          <div class="form-group">
                                          		<html:select property="TOByPOId" styleClass="input-medium"
											style="width:100%;" styleId="TOByPOId" multiple="multiple">
											<html:option value=""></html:option>
											<html:optionsCollection name="filterActionForm"
												property="TOList" label="purchaseOrderMasterId"
												value="purchaseOrderMasterId" />
										</html:select>
                                          </div>
                                       </div>
                                       <!--/span-->
                                       <div class="col-md-4 GRByPOId">
                                          <div class="form-group">
                                          		<html:select property="GRByPOId" styleClass="input-medium"
											style="width:100%;" styleId="GRByPO" multiple="multiple">
											<html:option value=""></html:option>
											<html:optionsCollection name="filterActionForm"
												property="GRList" label="poLinkId"
												value="poLinkId" />
										</html:select>
                                          </div>
                                       </div>
                                       <!--/span-->
                                       <div class="col-md-4 GRByTOId">
                                          <div class="form-group">
                                          		<html:select property="GRByTOId" styleClass="input-medium"
											style="width:100%;" styleId="GRByTO" multiple="multiple">
											<html:option value=""></html:option>
											<html:optionsCollection name="filterActionForm"
												property="GRList" label="transferOrderId"
												value="transferOrderId" />
										</html:select>
                                          </div>
                                       </div>
                                       <!--/span-->
                                       <div class="col-md-4 GRByStatusId">
                                          <div class="form-group">
                                          		<html:select property="GRByStatusId" styleClass="input-medium"
											style="width:100%;" styleId="GRByStatus" multiple="multiple">
											
											<html:option value="${constants.GR_STATUS_OPEN}">Open</html:option>
											<html:option value="${constants.GR_STATUS_SERVICED}">Serviced</html:option>
											<html:option value="${constants.GR_STATUS_CLOSED}">Close</html:option>
										</html:select>
                                          </div>
                                       </div>
                                       <!--/span-->
                                       <div class="col-md-4 stockStatus">
                                          <div class="form-group">
                                          		<html:select property="stockStatus" styleClass="input-medium" 
													style="width:100%;" styleId="stock-state">
													<html:option value=""></html:option>
													<html:option value="1">Good</html:option>
													<html:option value="2">Blocked</html:option>
													<html:option value="3">InTransit</html:option>
													<html:option value="4">Wasted</html:option>
													<html:option value="5">Expired</html:option>
													<html:option value="6">Damaged</html:option>
												</html:select>
                                          </div>
                                       </div>
                                       <!--/span-->
                                       <div class="col-md-4 stockQuantity">
                                          <div class="form-group">
                                          		<html:select property="stockStatus" styleClass="input-medium" 
													style="width:100%;" styleId="stock-Quantity">
													<html:option value="1">Bin Qty > 0</html:option>
													<html:option value="2">Bin Qty < 0</html:option>
													<html:option value="3">All Qty</html:option>
												</html:select>
                                          </div>
                                       </div> 
                                       <!--/span-->
                                       <div class="col-md-4 itemState">
                                          <div class="form-group">
                                          		<html:select property="itemActive" styleClass="input-medium" 
													style="width:100%;" styleId="item-State"  multiple="multiple">
													<html:option value="0">Active</html:option>
													<html:option value="1">In Active</html:option>
												</html:select>
                                          </div>
                                       </div>
                                      <!--/span-->
                                       <div class="col-md-4 itemVeg-nonVeg">
                                          <div class="form-group">
                                          		<html:select property="itemType" styleClass="input-medium" 
													style="width:100%;" styleId="item-Type"  multiple="multiple">
													<html:option value="0">Veg</html:option>
													<html:option value="1">Non-Veg</html:option>
												</html:select>
                                          </div>
                                       </div>
                                       <!--/span-->
                                       <div class="col-md-4 supplierStatus">
                                          <div class="form-group">
                                          		<html:select property="supplierStatus" styleClass="input-medium" 
													style="width:100%;" styleId="supplier-Status"  multiple="multiple">
													<html:option value="0">In Active</html:option>
													<html:option value="1">Active</html:option>
												</html:select>
                                          </div>
                                       </div>
                                       <!--/span-->
                                       <div class="col-md-4 supplierType">
                                          <div class="form-group">
                                          		<html:select property="supplierType" styleClass="input-medium" 
													style="width:100%;" styleId="supplier-Type"  multiple="multiple">
													<html:option value="0">External</html:option>
													<html:option value="1">Internal</html:option>
												</html:select>
                                          </div>
                                       </div>
                                       <!--/span--> 
                                       <div class="col-md-4 company">
                                          <div class="form-group">
                                          		<html:select property="companyId" styleId="companyId"
													style="width:100%;" styleClass="input-medium" multiple="multiple">
													<html:option value=""></html:option>
													<html:optionsCollection name="filterActionForm"
														property="companyList" label="companyName" value="companyId" />
												</html:select>
                                          </div>
                                       </div>
                                       <!--/span-->
                                      
                                       <div class="col-md-4 activeItemState">
                                          <div class="form-group">
                                          		<html:select property="active" styleClass="input-medium" 
													style="width:100%;" styleId="isActive"  multiple="multiple">
													<html:option value="1">Active</html:option>
													<html:option value="0">NonActive</html:option>
												</html:select>
                                          </div>
                                       </div>
                                      <%--  <!--/span-->
                                       <div class="col-md-4 critical">
                                          <div class="form-group">
                                          		<html:select property="critical" styleClass="input-medium" 
													style="width:100%;" styleId="isCritical"  multiple="multiple">
													<html:option value="1">Critical</html:option>
													<html:option value="0">NonCritical</html:option>
												</html:select>
                                          </div>
                                       </div>
                                       <!--/span-->
                                       <div class="col-md-4 stockType">
                                          <div class="form-group">
                                          		<html:select property="stockType" styleClass="input-medium" 
													style="width:100%;" styleId="stock-Type"  multiple="multiple">
													<html:option value="1">Daily Stock</html:option>
													<html:option value="2">Weekly Stock</html:option>
													<html:option value="3">Monthly Stock</html:option>
												</html:select>
                                          </div>
                                       </div>
                                       <!--/span-->
                                       <div class="col-md-4 recipeName">
                                          <div class="form-group">
                                          		<html:select property="recipeId" styleId="recipeId"
													style="width:100%;" styleClass="input-medium" multiple="multiple">
													<html:option value=""></html:option>
													<html:optionsCollection name="filterActionForm"
														property="recipeList" label="recipeName" value="recipeMasterId" />
												</html:select>
                                          </div>
                                       </div>
                                       <!--/span-->
                                       <div class="col-md-4 manufacturedItem">
                                          		<html:select property="manufacturedMasterId" styleId="manufacturedMasterId"
													style="width:100%;" styleClass="input-medium" multiple="multiple">
													<html:option value=""></html:option>
													<html:optionsCollection name="filterActionForm"
														property="manufacturedItemList" label="manufacturedItem" value="manufactureId" />
												</html:select>
                                       </div>
                                       <!--/span-->
                                       
                                       <div class="col-md-4 processName">
                                          		<html:select property="processMasterId" styleId="processId"
													style="width:100%;" styleClass="input-medium" multiple="multiple">
													<html:option value=""></html:option>
													<html:optionsCollection name="filterActionForm"
														property="processList" label="processName" value="processId" />
												</html:select>
                                       </div> 
                                       <div class="col-md-4 fromDeptId">
                                          <div class="form-group">
                                          		<html:select property="siteid" styleClass="input-medium"  styleId="fromDeptId"  multiple="multiple">
					                                <html:option value=""></html:option>
													<html:optionsCollection name="filterActionForm"	property="siteList" label="siteName" value="siteId" />
					                              </html:select>
                                          </div>
                                       </div>
                                       
                                        <div class="col-md-4 toDeptId">
                                          <div class="form-group">
                                          		<html:select property="supplierId" styleClass="input-medium"
											style="width:100%;" styleId="toDeptId" multiple="multiple">
											<html:option value=""></html:option>
											<html:optionsCollection name="filterActionForm"
												property="internalSupplierList" label="supplierName"
												value="supplierId" />
										    </html:select>
                                          </div>
                                        </div>--%>
                                        
                                        <%-- <div class="col-md-4 orderAckByStatusId">
                                          <div class="form-group"> 
                                          		<html:select property="orderAckByStatusId" styleClass="input-medium"
													style="width:100%;" styleId="orderAckByStatusId" multiple="multiple">
													<html:option value="1">Open</html:option>
													<html:option value="2">Planning Dept</html:option>
													<html:option value="3">Store Dept</html:option>
												</html:select>
                                          </div>
                                        </div>
                                        <div class="col-md-4 jobOrderMasterId">
                                          <div class="form-group">
                                          		<html:select property="jobOrderMasterId" styleClass="input-medium"
														style="width:100%;" styleId="jobOrderMasterId" multiple="multiple">
													<html:option value=""></html:option>
													<html:optionsCollection name="filterActionForm"
														property="jwoList" label="jwo_Id"
														value="jobOrderMasterId" />
												</html:select>
                                          </div>
                                       	</div>
                                       	<div class="col-md-4 orderAckMasterId">
                                          <div class="form-group">
                                          		<html:select property="orderAckMasterId" styleClass="input-medium"
														style="width:100%;" styleId="orderAckMasterId" multiple="multiple">
													<html:option value=""></html:option>
													<html:optionsCollection name="filterActionForm"
														property="jwoList" label="oa_oaId"
														value="oa_oaId" />
												</html:select>
                                          </div>
                                       	</div>
                                       <div class="col-md-4 saleOrderMasterId">
                                          <div class="form-group">
                                          		<html:select property="saleOrderId" styleClass="input-medium"
														style="width:100%;" styleId="saleOrderMasterId" multiple="multiple">
													<html:option value=""></html:option>
													<html:optionsCollection name="filterActionForm"
														property="saleOrderList" label="saleMasterId"
														value="saleMasterId" />
												</html:select>
                                          </div>
                                       	</div>  --%>
	                                    
                                        <%-- <div class="col-md-4 date">
                                        	 <div class="col-md-5">
                                        		  <div class="form-group">
                                         		  <html:text property="fromDate" styleClass="input-small" styleId="datepicker2" />
                                          		   <span class="help-block">From Date</span></div>
                                          	 </div> 
                                         
											<div class="col-md-3">
                                        		  <div class="form-group">
													<html:text property="toDate" styleClass="input-small" styleId="datepicker1"/>
													 <span class="help-block">To Date</span></div>
											 </div>
										</div> --%>
										
                                       </div>
                                       
                                       <div class="col-md-2">
                                         
									
                                            <button type="button" class="btn green-meadow selectFilter" style="display: none;" id="filterBTN"><span style="font-weight: bold; color: black;">Filter</span></button>
                                       </div>
                              </div>
                           </html:form>
                     
                      </div> 
                  </div>  
               </div>
            </div>
            <!-- END PAGE CONTENT-->
         </div>
     
         <!-- END PAGE Filter--> 
         
         <script type="text/javascript">
 
       
          
 jQuery(document).ready(function() { 
	 /*  $(".selectFilter").hide();
       $(".supplierId").hide();
       $(".itemIds").hide();
       $(".date").hide();
       $(".userName").hide();
       $(".userRole").hide();
      $(".customerId").hide();
       $(".orderMasterId").hide(); */
      	 $('#areaMasterId').select2({placeholder: "Select Area"});
    	 $('#supplierId').select2({placeholder: "Select Supplier"});
		 $('#orderMasterId').select2({placeholder: "Order Number"});
		 $('#itemId').select2({placeholder: "Select Item"});
		 $('#userId').select2({placeholder: "User Name"});
		 $('#userRoleId').select2({placeholder: "User Role"});
		 /* $('#customerId').select2({placeholder: "Select Customer"}); */
		 $('#PO').select2({placeholder: "Select Purchase Order"});
		 $('#POStatus').select2({placeholder: "Select POStatus"});
		 $('#villageName').select2({placeholder: "Select Village"});
		 $('#orderStageId').select2({placeholder: "Order Stage"});
		 $('#orderStatus').select2({placeholder: "Order Status"});
		 
		 
		 
      
		// $('#datepicker1').datepicker({});
		// $('#datepicker2').datepicker({});
		 
	 if(!$("#datepicker1").val()){
		 		var mdate=new Date();
		 		mdate.setDate(mdate.getDate());
			 $('#datepicker1').datepicker('setDate', mdate);
		}else
		{$('#datepicker1').datepicker({});}	
	 	if(!$("#datepicker2").val()){
	 		var mdate=new Date();
	 		mdate.setDate(mdate.getDate());
	 		 $('#datepicker2').datepicker('setDate', mdate);
	 	}else
	 	{$('#datepicker2').datepicker();} 
	 	
	 	 $('#filter').change(function(){
	    	  var cls=($("#filter").val());
	    	  $('.selectFilter').show();
	    	  $('.'+cls).show();
	    	  $('#filter option:selected').remove();
	      });
		 
		 
	    
 });
 </script>
         
