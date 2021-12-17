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
				                              <div class="caption"><span style="font-weight: bold;"><i class="icon-reorder"></i>User Entry Form</span></div>
				                              <div class="tools">
				                             
				                               </div>
				                           </div>
				                  
				                       
				                        
				                          <div class="portlet-body form">
				                          		 <html:form styleClass="form-horizontal seperator" action="/view/users/UsersMasterAction" styleId="UserEntryForm">
							                      <html:hidden property="userMasterId" styleId="userMasterId" />
							                       <html:hidden property="userRoleName" styleId="userRoleName"/>
							                        <html:hidden property="createdBy" styleId="createdBy"/>
							                         <html:hidden property="createdDTTM" styleId="createdDTTM"/>
							                     
							                          <div class="form-body">
							                           
							                           <logic:notEmpty name="UserActionForm" property="companyList">
							                           <div class="form-group">
							                             <label class="col-md-4 control-label">Company:<span class="required">*</span></label>
							                              <div class="col-md-3">
							                              	<html:select property="companyMasterId" styleId="select1" styleClass="form-control select2me" style="width:100%;">
							                              	<html:option value=""></html:option>
																<html:optionsCollection name="UserActionForm" property="companyList" label="name" value="companyMasterId" />
				                                            </html:select>
							                              </div>
							                           </div>   
							                           </logic:notEmpty>
							                        
							                        
							                           <div class="form-group">
							                              <label class="col-md-4 control-label">First Name:<span class="required">*</span></label>
							                              <div class="col-md-3">
				                                       		 <html:text styleClass="form-control" styleId="FirstName"  property="firstName"/>
							                              </div>
							                           </div>
							                           
							                           <div class="form-group">
							                              <label class="col-md-4 control-label">Last Name:<span class="required">*</span></label>
							                              <div class="col-md-3">
				                                       		 <html:text styleClass="form-control" styleId="LastName"  property="lastName"/>
							                              </div>
							                           </div>
							                           
							                           <div class="form-group">
							                              <label class="col-md-4 control-label">UserName:<span class="required">*</span></label>
							                              <div class="col-md-3">
				                                       		 <html:text styleClass="form-control" styleId="UserName"  property="userName"/>
							                              </div>
							                           </div>
							                           <div class="form-group">
							                              <label class="col-md-4 control-label">Password:<span class="required">*</span></label>
							                              <div class="col-md-3">
				                                       		 <html:password styleClass="form-control" styleId="Password"  property="password"/>
							                              </div>
							                           </div>
							                           
							                           <div class="form-group">
							                              <label class="col-md-4 control-label">Confirm Password:<span class="required">*</span></label>
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
							                              <label class="col-md-4 control-label">Address:<span class="required">*</span></label>
							                              <div class="col-md-3">
				                                       		 <html:textarea property="address" styleClass="form-control"></html:textarea>
							                              </div>
							                           </div>	
							                           	                                  
						                                     <div class="form-group">
						                                       <label class="col-md-4 control-label">User Staus:<span class="required">*</span></label>
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
						                                   
						                			      <div class="form-group">
							                             <label class="col-md-4 control-label">User Role:<span class="required">*</span></label>
							                              <div class="col-md-3">
							                              	 <html:select property="userRolesMasterId" styleId="select2" styleClass="form-control select2me" style="width:100%;">
							                              	 	<html:option value=""></html:option>
							                              	 	<logic:notEmpty name="UserActionForm" property="roleList">
															 	<html:optionsCollection name="UserActionForm" property="roleList" label="name" value="userRolesMasterId" />
															 	</logic:notEmpty>
				                                            </html:select>
							                              </div>
							                           </div> 
							                           </div>
							                           
							                           	<div class="form-actions">
					                                          <div class="col-md-offset-4 col-md-4">	                                         
				                                          		<button type="submit" class="btn yellow" id="sub" title="Create  New User" style="font-weight: bold; color: black;">Submit</button>
					                                            <button type="button" class="btn dark" id="cancel" style="font-weight: bold; color: black;">Back</button>
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
   <jsp:include page="../master/usersEntryJS.jsp"/>
   

    <%--  <jsp:include page="../main/billingJS.jsp" />  --%>

</body>
<!-- END BODY -->
</html>