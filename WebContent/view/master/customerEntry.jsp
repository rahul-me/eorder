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
					
						<div class="row">
				            <div class="col-md-12">
				                        <div class="portlet box blue-steel">
				                           <div class="portlet-title">
				                              <div class="caption"><span style="font-weight: bold;"><i class="icon-reorder"></i>Customer Entry Form</span></div>
				                              <div class="tools">
				                             
				                               </div>
				                           </div>
				                  
				                       
				                        
				                          <div class="portlet-body form">
				                          		 <html:form styleClass="form-horizontal seperator" action="/view/users/UsersMasterAction" styleId="UserEntryForm">
							                      <html:hidden property="customerMasterId" styleId="customerMasterId" />
							                      <html:hidden property="userMasterId" styleId="userMasterId"/>
							                       <html:hidden property="userRoleName" styleId="userRoleName"/>
							                        <html:hidden property="createdBy" styleId="createdBy"/>
							                         <html:hidden property="createdDTTM" styleId="createdDTTM"/>
							                     
							                          <div class="form-body">
							                           
							                          
							                        
							                           <div class="form-group">
							                              <label class="col-md-4 control-label">First Name:</label>
							                              <div class="col-md-3">
				                                       		 <html:text styleClass="form-control" styleId="FirstName"  property="firstName"/>
							                              </div>
							                           </div>
							                           
							                           <div class="form-group">
							                              <label class="col-md-4 control-label">Last Name:</label>
							                              <div class="col-md-3">
				                                       		 <html:text styleClass="form-control" styleId="LastName"  property="lastName"/>
							                              </div>
							                           </div>
							                            <div class="form-group">
							                              <label class="col-md-4 control-label">User Name:</label>
							                              <div class="col-md-3">
				                                       		 <html:text styleClass="form-control" styleId="userName"  property="userName"/>
							                              </div>
							                           </div>
							                          
							                           <div class="form-group">
							                              <label class="col-md-4 control-label">Password:</label>
							                              <div class="col-md-3">
				                                       		 <html:password styleClass="form-control" styleId="Password"  property="password"/>
							                              </div>
							                           </div>
							                           
							                           <div class="form-group">
							                              <label class="col-md-4 control-label">Confirm Password:</label>
							                              <div class="col-md-3">
				                                       		  <input type="password" class="form-control" id="C_Password" name="c_password"/>
							                              </div>
							                           </div>
							                           
							                           <div class="form-group">
							                              <label class="col-md-4 control-label">Email:</label>
							                              <div class="col-md-3">
				                                       		 <html:text styleClass="form-control" styleId="email"  property="email"/>
							                              </div>
							                           </div>
							                           
							                           <div class="form-group">
							                              <label class="col-md-4 control-label">Phone No.:</label>
							                              <div class="col-md-3">
				                                       		 <html:text styleClass="form-control" styleId="PhoneNumber"  property="phoneNumber1"/>
							                              </div>
							                           </div>
							                           
							                           <div class="form-group">
							                              <label class="col-md-4 control-label">Address:</label>
							                              <div class="col-md-3">
				                                       		 <html:textarea property="address" styleClass="form-control"></html:textarea>
							                              </div>
							                           </div>	
							                           	      <div class="form-group">
							                              <label class="col-md-4 control-label">State:</label>
							                              <div class="col-md-3">
				                                       		 <html:text styleClass="form-control" styleId="State"  property="state"/>
							                              </div>
							                           </div>
							                           <div class="form-group">
							                              <label class="col-md-4 control-label">City:</label>
							                              <div class="col-md-3">
				                                       		 <html:text styleClass="form-control" styleId="City"  property="city"/>
							                              </div>
							                           </div>
										                <%-- <div class="col-md-4">
															<div class="form-group">
															<label class="control-label col-md-5">State</label>
															<div class="col-md-6">
												            <html:select property="clientState" styleClass="form-control input-medium select2me" style="width:100%" styleId="clientState">
												            <html:option value=""></html:option> 
															<html:optionsCollection name="clientMasterActionForm" property="stateList" label="states_name" value="states_id" />
															</html:select> 
														</div>					                           
													   </div>
													   </div> --%>
										
													<%-- <div class="col-md-4">
														<div class="form-group">
													    <label class="control-label col-md-6">City</label>
													    <div class="col-md-6">
										                <html:select property="clientCity" styleClass="form-control input-medium select2me" style="width:100%" styleId="clientcity" >
										                <html:option value=""></html:option> 
														</html:select>
														</div>
													    </div>
														</div>                             
						                                   --%>   <div class="form-group">
						                                       <label class="col-md-4 control-label">Customer Staus:<span class="required">*</span></label>
						                                       <div class="col-md-3">
						                                       			<div class="radio-list">
						                                       				<label class="radio-inline">
								                                       	  		<html:radio property="isActive" value="0"/>Active</label>
								                                       		<label class="radio-inline">
						                                              	 		<html:radio property="isActive" value="1"/>In-Active</label>
					                                              		</div>		                                       		
						                                       		<div id="form_gender_error"></div>
						                                       </div>
						                                    </div>
						                                   
						                			      
							                           </div>
							                           
							                           	<div class="form-actions">
					                                          <div class="col-md-offset-4 col-md-4">	                                         
				                                          		<button type="submit" class="btn yellow" id="sub" title="Create New Customer" style="font-weight: bold; color: black;">Submit</button>
					                                            <button type="button" class="btn dark" style="font-weight: bold; color: black;">Cancel</button>
					                                          </div>
														</div>                           
							                           			                        
									</html:form>
				                  			</div>
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
   <jsp:include page="../main/js_entryPage.jsp" />
   <jsp:include page="../master/customerEntryJS.jsp"/>
   

    <%--  <jsp:include page="../main/billingJS.jsp" />  --%>

</body>
<!-- END BODY -->
</html>