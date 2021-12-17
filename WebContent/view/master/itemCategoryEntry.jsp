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
				         <div class="row">
				            <div class="col-md-12">
				             
				            </div>
				         </div>
				         <!-- END PAGE HEADER-->
				         <!-- BEGIN PAGE CONTENT-->
				         <div class="row">
				            <div class="col-md-12">
				                        <div class="portlet box blue-steel">
				                           <div class="portlet-title">
				                              <div class="caption"><span style="font-weight: bold;"><i class="icon-reorder"></i>Item Category Entry Form</span></div>
				                              <div class="tools">
				                                <!--  <a href="javascript:;" class="collapse"></a> -->
				                                <!--  <a href="#portlet-config" data-toggle="modal" class="config"></a>
				                                 <a href="javascript:;" class="reload"></a>
				                                 <a href="javascript:;" class="remove"></a> -->
				                              </div>
				                           </div>
				                  
				                       
				                        
				                          <div class="portlet-body form">
				                          		<html:form styleClass="form-horizontal seperator" action="/view/itemcategories/ItemCategoryMasterAction" styleId="CatEntryForm">
				                          		<html:hidden styleClass="form-control input-sm"  styleId="CategoryId"  property="itemCategoryMasterId"/>
				                    	    <%-- 	<html:hidden property="itemCategoryMasterId" styleId="itemCategoryMasterId" value="0"/> --%>
				                    	    	<html:hidden property="createdDTTM" styleId="createdDTTMId"/>
							                        <div class="form-body">
							                           <div class="form-group">
							                              <label class="col-md-4 control-label">Item Category Name:</label>
							                              <div class="col-md-3">
				                                       		 <html:text styleClass="form-control" styleId="CategoryName"  property="name"/>
							                              </div>
							                           </div>
							                          
							                           <div class="form-group">
							                             <label class="col-md-4 control-label">Sub-Category of:</label>
							                              <div class="col-md-3">
							                              	<html:select property="superCategoryId" styleId="select1" styleClass="form-control select2me" style="width:100%;">
				                                                   <html:option value=""></html:option>
				                                                   <logic:notEmpty name="ItemCategoryActionForm" property="itemCategoryList">
																	<html:optionsCollection name="ItemCategoryActionForm" property="itemCategoryList" label="name" value="superCategoryId"/>
																	</logic:notEmpty>
				                                             </html:select>
				                                             
							                              </div>
							                           </div>
							                           <div class="form-group">
							                               <label class="col-md-4 control-label">Description:</label>
							                              <div class="col-md-3">
							                             	 <html:textarea styleClass="form-control" property="description"></html:textarea>
							                              </div>
							                           </div>
							                          
							                        </div>
							                        <div class="form-group">
														<div class="col-md-9">
															 
															 <html:hidden styleId="CreatedDate"  property="createdDTTM"/>
															 <html:hidden styleId="CreatedBy"  property="createdBy"/>
														</div>
													</div>
							                        
							                        <div class="form-actions">
					                                          <div class="col-md-offset-4 col-md-4">
					                                          		<button type="submit" class="btn yellow" title="Create New ItemCategory and go to List Page" id="createOrSubmit" style="font-weight: bold; color: black;">Submit</button>	                                          		
						                                            <button type="button" class="btn dark" style="font-weight: bold; color: black;">Cancel</button>
					                                          </div>
													</div>
													
													
									</html:form>
				                  			</div>
				                  	</div>
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
   <jsp:include page="../master/itemCategoryEntryJS.jsp"/>
   <jsp:include page="../main/js_entryPage.jsp" />
   

    <%--  <jsp:include page="../main/billingJS.jsp" />  --%>

</body>
<!-- END BODY -->
</html>