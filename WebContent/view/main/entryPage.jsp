<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title> Neetai Tech.</title>
 <jsp:include page="../main/css_main.jsp" />
 
</head>
   <jsp:include page="../main/header.jsp" />
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
         <!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->               
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
         <!-- BEGIN STYLE CUSTOMIZER -->
         <div class="theme-panel hidden-xs hidden-sm">
            <div class="toggler"></div>
            <div class="toggler-close"></div>
            <div class="theme-options">
               <div class="theme-option theme-colors clearfix">
                  <span>THEME COLOR</span>
                  <ul>
                     <li class="color-black current color-default" data-style="default"></li>
                     <li class="color-blue" data-style="blue"></li>
                     <li class="color-brown" data-style="brown"></li>
                     <li class="color-purple" data-style="purple"></li>
                     <li class="color-grey" data-style="grey"></li>
                     <li class="color-white color-light" data-style="light"></li>
                  </ul>
               </div>
               <div class="theme-option">
                  <span>Layout</span>
                  <select class="layout-option form-control input-small">
                     <option value="fluid" selected="selected">Fluid</option>
                     <option value="boxed">Boxed</option>
                  </select>
               </div>
               <div class="theme-option">
                  <span>Header</span>
                  <select class="header-option form-control input-small">
                     <option value="fixed" selected="selected">Fixed</option>
                     <option value="default">Default</option>
                  </select>
               </div>
               <div class="theme-option">
                  <span>Sidebar</span>
                  <select class="sidebar-option form-control input-small">
                     <option value="fixed">Fixed</option>
                     <option value="default" selected="selected">Default</option>
                  </select>
               </div>
               <div class="theme-option">
                  <span>Footer</span>
                  <select class="footer-option form-control input-small">
                     <option value="fixed">Fixed</option>
                     <option value="default" selected="selected">Default</option>
                  </select>
               </div>
            </div>
         </div>
         <!-- END BEGIN STYLE CUSTOMIZER -->            
         <!-- BEGIN PAGE HEADER-->
         <div class="row">
            <div class="col-md-12">
               <!-- BEGIN PAGE TITLE & BREADCRUMB-->
               <h3 class="page-title">
                  Editable Tables <small>editable table samples</small>
               </h3>
               <ul class="page-breadcrumb breadcrumb">
                  <li class="btn-group">
                     <button type="button" class="btn blue dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-delay="1000" data-close-others="true">
                     <span>Actions</span> <i class="icon-angle-down"></i>
                     </button>
                     <ul class="dropdown-menu pull-right" role="menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li class="divider"></li>
                        <li><a href="#">Separated link</a></li>
                     </ul>
                  </li>
                  <li>
                     <i class="icon-home"></i>
                     <a href="../../view/main/index.jsp">Home</a> 
                     <i class="icon-angle-right"></i>
                  </li>
                  <li>
                     <a href="#">Data Tables</a>
                     <i class="icon-angle-right"></i>
                  </li>
                  <li><a href="#">Editable Tables</a></li>
               </ul>
               <!-- END PAGE TITLE & BREADCRUMB-->
            </div>
         </div>
         <!-- END PAGE HEADER-->
         <!-- BEGIN PAGE CONTENT-->
         <div class="row">
            <div class="col-md-12">
            
            	  <div class="tab-pane " id="tab_2">
                        <div class="portlet box blue">
                           <div class="portlet-title">
                              <div class="caption"><i class="icon-reorder"></i>Form Sample</div>
                              <div class="tools">
                                 <a href="javascript:;" class="collapse"></a>
                                 <a href="#portlet-config" data-toggle="modal" class="config"></a>
                                 <a href="javascript:;" class="reload"></a>
                                 <a href="javascript:;" class="remove"></a>
                              </div>
                           </div>
                           <div class="portlet-body form">
                              <!-- BEGIN FORM-->
                              <form action="#" class="form-horizontal" id="entryPageId">
                                 <div class="form-body">
                                    <h3 class="form-section">Person Info</h3>
                                    <div class="row">
                                       <div class="col-md-6">
                                          <div class="form-group">
                                             <label class="control-label col-md-3">First Name</label>
                                             <div class="col-md-9">
                                                <input type="text" name="name" class="form-control" placeholder="Patel">
                                                <span class="help-block">Enter first name</span>
                                             </div>
                                          </div>
                                       </div>
                                       <!--/span-->
                                       <div class="col-md-6">
                                          <div class="form-group">
                                             <label class="control-label col-md-3">Last Name</label>
                                             <div class="col-md-9">
                                                <input type="text" name="lastName" class="form-control" placeholder="Mehul">
                                                <span class="help-block">This is Last name.</span>
                                             </div>
                                          </div>
                                       </div>
                                       <!--/span-->
                                    </div>
                                    <!--/row-->
                                    <div class="row">
                                       <div class="col-md-6">
                                          <div class="form-group">
                                             <label class="control-label col-md-3">Gender</label>
                                             <div class="col-md-9">
                                                <select class="form-control" name="gender">
                                                   <option value="">Male</option>
                                                   <option value="1">Female</option>
                                                </select>
                                                <span class="help-block">Select your gender.</span>
                                             </div>
                                          </div>
                                       </div>
                                       <!--/span-->
                                       <div class="col-md-6">
                                          <div class="form-group">
                                             <label class="control-label col-md-3">Date of Birth</label>
                                             <div class="col-md-9">
                                                <input type="text" class="form-control" name="DOB" placeholder="dd/mm/yyyy">
                                             </div>
                                          </div>
                                       </div>
                                       <!--/span-->
                                    </div>
                                    <!--/row-->        
                                    <div class="row">
                                       <div class="col-md-6">
                                          <div class="form-group">
                                             <label class="control-label col-md-3">Category</label>
                                             <div class="col-md-9">
                                                <select class="select2_category form-control"  data-placeholder="Choose a Category" tabindex="1">
                                                   <option value="Category 1">Category 1</option>
                                                   <option value="Category 2">Category 2</option>
                                                   <option value="Category 3">Category 5</option>
                                                   <option value="Category 4">Category 4</option>
                                                </select>
                                             </div>
                                          </div>
                                       </div>
                                      
                                    </div>
                                    <!--/row-->                   
                                 </div>
                                 
                                   <!-- BEGIN EXAMPLE TABLE PORTLET-->
                                   <div class="portlet">
                                   		 <div class="portlet-title">
						                     <div class="caption"><i class="icon-edit"></i>Details</div>
						                     <div class="tools">
						                        <a href="javascript:;" class="collapse"></a>
						                        <a href="#portlet-config" data-toggle="modal" class="config"></a>
						                        <a href="javascript:;" class="reload"></a>
						                        <a href="javascript:;" class="remove"></a>
						                     </div>
						                  </div>
						           	 <div class="portlet-body">
               							<div class="table-responsive">
					                 
					                     <table class="table table-striped table-hover table-bordered" id="sample_editable_1">
					                        <thead>
					                           <tr>
					                              <th>Username</th>
					                              <th>Full Name</th>
					                              <th><i class="icon-bookmark"></i> Points</th>
					                              <th>Notes</th>
					                              <th>Data</th>
					                              <th style="width: 4%">Add/Remove</th>
					                           </tr>
					                        </thead>
					                        <tbody>
					                           <tr >
					                              <td>alex</td>
					                              <td>Alex Nilson</td>
					                              <td>1234</td>
					                              <td class="center">power user</td>
					                              <td>123</td>
					                              <td><a class="btn btn-sm green"><i class="icon-plus"></i></a>
					                              <a href="#" class="btn btn-sm red"><i class="icon-minus"></i></a>
					                              </td>
					                           </tr>
					                          
					                        </tbody>
					                     </table>
					              		</div>
					             	 </div>
					              </div>
					               <!-- END EXAMPLE TABLE PORTLET-->
                                 
                                 
                                 
                                 <div class="form-actions fluid">
                                    <div class="row">
                                       <div class="col-md-6">
                                          <div class="col-md-offset-3 col-md-9">
                                             <button type="submit" class="btn blue">Submit</button>
                                             <button type="button" class="btn default">Cancel</button>                              
                                          </div>
                                       </div>
                                       <div class="col-md-6">
                                       </div>
                                    </div>
                                 </div>
                              </form>
                              <!-- END FORM-->                
                           </div>
                        </div>
                     </div>
            
            
            
             
            </div>
         </div>
         <!-- END PAGE CONTENT -->
      </div>
      <!-- END PAGE -->

	
	</div>
   <!-- END CONTAINER -->
    <jsp:include page="../main/js_main.jsp" />
  
 <script>
      jQuery(document).ready(function() {       
       
        	 var form1 = $('#entryPageId');
             var error1 = $('.alert-danger', form1);
             var success1 = $('.alert-success', form1);

        	 
             form1.validate({
        	 
        	 errorElement: 'span', //default input error message container
             errorClass: 'help-block', // default input error message class
             focusInvalid: false, // do not focus the last invalid input
             ignore: "",
        	
        	 rules: {
                 name: {
                     minlength: 2,
                     required: true
                 },
                 lastName: {
                     required: true,
                 },
                 category: {
                     required: true
                 },
                 gender: {
                     required: true
                 },
                 DOB: {
                     required: true,
                     date: true,
                 },
          
               
             },

             messages: { // custom messages for radio buttons and checkboxes
            	
            	 gender: {
                     required: "Please select a gender"
                 },
             },
        		
             invalidHandler: function (event, validator) { //display error alert on form submit              
                 success1.hide();
                 error1.show();
                 App.scrollTo(error1, -200);
             },

             highlight: function (element) { // hightlight error inputs
                 $(element)
                     .closest('.form-group').addClass('has-error'); // set error class to the control group
             },

             unhighlight: function (element) { // revert the change done by hightlight
                 $(element)
                     .closest('.form-group').removeClass('has-error'); // set error class to the control group
             },

             success: function (label) {
                 label
                     .closest('.form-group').removeClass('has-error'); // set success class to the control group
             },

             submitHandler: function (form) {
                 success1.show();
                 error1.hide();
             }
         });
         
      });
   </script> 
  <jsp:include page="../main/footer.jsp" />
</body>
</html>