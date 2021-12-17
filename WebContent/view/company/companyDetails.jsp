<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="../../assets/global/plugins/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="../../view/company/js/companyDetails.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Company Details</title>
<jsp:include page="../main/css_main.jsp"/>
<jsp:include page="../main/css_entryPage.jsp"/>
<jsp:include page="../main/js_main.jsp"/>
</head>
<!-- <body> -->
<jsp:include page="../main/header.jsp" /> <!-- In place of body -->
	<div class="page-container">
		<div class="page-sidebar-wrapper">			
			<div class="page-sidebar navbar-collapse collapse">
				<ul class="page-sidebar-menu">
					<jsp:include page="../main/menubarforsmallscreen.jsp" /> 
				</ul>
			</div>							
   			<div class="page-content-wrapper">			
				<div class="page-content">				
					<div class="modal fade" id="portlet-config" tabindex="1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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
				        </div>				            
				    </div>				         				
				    <div class="row">
				    	<div class="col-md-12">
				         	<div class="portlet box blue-steel">
				                <div class="portlet-title">
				                    <div class="caption"><span style="font-weight: bold;"><i class="icon-reorder"></i>Company Details</span></div>
				                    <div class="tools">                               
				                    </div>
				                </div>				                  				                        				                      
				                <div class="portlet-body form">
				                	<html:form styleClass="form-horizontal seperator" action="view/company/companyDetailAction" styleId="CompanyDetailForm">				                    	    	
							        	<div class="form-body">							                        
							            	<div class="form-group">
							                	<label class="col-md-4 control-label">Central State Tax Identification Number</label>
							                    <div class="col-md-3">
				                                	<html:text styleClass="form-control" styleId="cstidno"  property="cstidno"/>
							                    </div>
							                </div>
							                <div class="form-group">
							                	<label class="col-md-4 control-label">Value Added Tax Identification Number</label>
							                    <div class="col-md-3">
				                                	<html:text styleClass="form-control" styleId="vatidno"  property="vatidno"/>
							                    </div>
							                </div>
							                <div class="form-group">
							                	<label class="col-md-4 control-label">Sale Tax</label>
							                    <div class="col-md-3">
				                                	<html:text styleClass="form-control" styleId="saletax"  property="saletax"/>
							                    </div>
							                </div>
							            </div>							                        
							            <div class="form-actions">
					                    	<div class="col-md-offset-4 col-md-4">
					                          	<html:submit styleId="btnSubmit" property="submit" value="Submit"></html:submit>					                          						                          
					                        </div>
										</div>
									</html:form>
				                 </div>
				            </div>
				        </div>		
					</div>						  				
				</div>					  
			</div>   				 
   			<jsp:include page="../main/quicksidebar.jsp" /> 
		</div>
	</div>
<jsp:include page="../main/footer.jsp" />
<jsp:include page="../main/js_entryPage.jsp" />	
</body>
</html>