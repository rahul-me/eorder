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
         
          <!-- BEGIN PAGE FILTER-->
          <jsp:include page="../po/filter.jsp" />
         
         <!-- BEGIN PAGE CONTENT-->
         <div class="row">
            <div class="col-md-14">
               <!-- BEGIN EXAMPLE TABLE PORTLET-->
               <div class="portlet box yellow">
                  <div class="portlet-title">
                     <div class="caption"><i class="icon-globe"></i>Managed Table</div>
                     <div class="tools">
                        <a href="javascript:;" class="collapse"></a>
                        <a href="#portlet-config" data-toggle="modal" class="config"></a>
                        <a href="javascript:;" class="reload"></a>
                        <a href="javascript:;" class="remove"></a>
                     </div>
                  </div>
                  <div class="portlet-body">
                     <div class="table-toolbar">
                        <div class="btn-group pull-right">
                           <button class="btn dropdown-toggle" data-toggle="dropdown">Tools <i class="icon-angle-down"></i>
                           </button>
                           <ul class="dropdown-menu pull-right">
                              <li><a href="#">Print</a></li>
                              <li><a href="#">Save as PDF</a></li>
                              <li><a href="#">Export to Excel</a></li>
                           </ul>
                        </div>
                     </div>
                     <table class="table table-striped table-bordered table-hover" id="sample_1">
                        <thead>
                           <tr>
                              <th class="table-checkbox"><input type="checkbox" class="group-checkable" data-set="#sample_1 .checkboxes" /></th>
                              <th>Username</th>
                              <th >Email</th>
                              <th >Points</th>
                              <th >Joined</th>
                              <th >&nbsp;</th>
                           </tr>
                        </thead>
                        <tbody>
                           <tr class="odd gradeX">
                              <td><input type="checkbox" class="checkboxes" value="1" /></td>
                              <td>shuxer</td>
                              <td ><a href="mailto:shuxer@gmail.com">shuxer@gmail.com</a></td>
                              <td >120</td>
                              <td class="center">12 Jan 2012</td>
                              <td ><span class="label label-sm label-success">Approved</span></td>
                           </tr>
                           <tr class="odd gradeX">
                              <td><input type="checkbox" class="checkboxes" value="1" /></td>
                              <td>looper</td>
                              <td ><a href="mailto:looper90@gmail.com">looper90@gmail.com</a></td>
                              <td >120</td>
                              <td class="center">12.12.2011</td>
                              <td ><span class="label label-sm label-warning">Suspended</span></td>
                           </tr>
                           <tr class="odd gradeX">
                              <td><input type="checkbox" class="checkboxes" value="1" /></td>
                              <td>userwow</td>
                              <td ><a href="mailto:userwow@yahoo.com">userwow@yahoo.com</a></td>
                              <td >20</td>
                              <td class="center">12.12.2012</td>
                              <td ><span class="label label-sm label-success">Approved</span></td>
                           </tr>
                           <tr class="odd gradeX">
                              <td><input type="checkbox" class="checkboxes" value="1" /></td>
                              <td>user1wow</td>
                              <td ><a href="mailto:userwow@gmail.com">userwow@gmail.com</a></td>
                              <td >20</td>
                              <td class="center">12.12.2012</td>
                              <td ><span class="label label-sm label-default">Blocked</span></td>
                           </tr>
                           <tr class="odd gradeX">
                              <td><input type="checkbox" class="checkboxes" value="1" /></td>
                              <td>restest</td>
                              <td ><a href="mailto:userwow@gmail.com">test@gmail.com</a></td>
                              <td >20</td>
                              <td class="center">12.12.2012</td>
                              <td ><span class="label label-sm label-success">Approved</span></td>
                           </tr>
                           <tr class="odd gradeX">
                              <td><input type="checkbox" class="checkboxes" value="1" /></td>
                              <td>foopl</td>
                              <td ><a href="mailto:userwow@gmail.com">good@gmail.com</a></td>
                              <td >20</td>
                              <td class="center">19.11.2010</td>
                              <td ><span class="label label-sm label-success">Approved</span></td>
                           </tr>
                           <tr class="odd gradeX">
                              <td><input type="checkbox" class="checkboxes" value="1" /></td>
                              <td>weep</td>
                              <td ><a href="mailto:userwow@gmail.com">good@gmail.com</a></td>
                              <td >20</td>
                              <td class="center">19.11.2010</td>
                              <td ><span class="label label-sm label-success">Approved</span></td>
                           </tr>
                           <tr class="odd gradeX">
                              <td><input type="checkbox" class="checkboxes" value="1" /></td>
                              <td>coop</td>
                              <td ><a href="mailto:userwow@gmail.com">good@gmail.com</a></td>
                              <td >20</td>
                              <td class="center">19.11.2010</td>
                              <td ><span class="label label-sm label-success">Approved</span></td>
                           </tr>
                           <tr class="odd gradeX">
                              <td><input type="checkbox" class="checkboxes" value="1" /></td>
                              <td>pppol</td>
                              <td ><a href="mailto:userwow@gmail.com">good@gmail.com</a></td>
                              <td >20</td>
                              <td class="center">19.11.2010</td>
                              <td ><span class="label label-sm label-success">Approved</span></td>
                           </tr>
                           <tr class="odd gradeX">
                              <td><input type="checkbox" class="checkboxes" value="1" /></td>
                              <td>test</td>
                              <td ><a href="mailto:userwow@gmail.com">good@gmail.com</a></td>
                              <td >20</td>
                              <td class="center">19.11.2010</td>
                              <td ><span class="label label-sm label-success">Approved</span></td>
                           </tr>
                           <tr class="odd gradeX">
                              <td><input type="checkbox" class="checkboxes" value="1" /></td>
                              <td>userwow</td>
                              <td ><a href="mailto:userwow@gmail.com">userwow@gmail.com</a></td>
                              <td >20</td>
                              <td class="center">12.12.2012</td>
                              <td ><span class="label label-sm label-default">Blocked</span></td>
                           </tr>
                           <tr class="odd gradeX">
                              <td><input type="checkbox" class="checkboxes" value="1" /></td>
                              <td>test</td>
                              <td ><a href="mailto:userwow@gmail.com">test@gmail.com</a></td>
                              <td >20</td>
                              <td class="center">12.12.2012</td>
                              <td ><span class="label label-sm label-success">Approved</span></td>
                           </tr>
                           <tr class="odd gradeX">
                              <td><input type="checkbox" class="checkboxes" value="1" /></td>
                              <td>goop</td>
                              <td ><a href="mailto:userwow@gmail.com">good@gmail.com</a></td>
                              <td >20</td>
                              <td class="center">12.11.2010</td>
                              <td ><span class="label label-sm label-success">Approved</span></td>
                           </tr>
                           <tr class="odd gradeX">
                              <td><input type="checkbox" class="checkboxes" value="1" /></td>
                              <td>weep</td>
                              <td ><a href="mailto:userwow@gmail.com">good@gmail.com</a></td>
                              <td >20</td>
                              <td class="center">15.11.2011</td>
                              <td ><span class="label label-sm label-default">Blocked</span></td>
                           </tr>
                           <tr class="odd gradeX">
                              <td><input type="checkbox" class="checkboxes" value="1" /></td>
                              <td>toopl</td>
                              <td ><a href="mailto:userwow@gmail.com">good@gmail.com</a></td>
                              <td >20</td>
                              <td class="center">16.11.2010</td>
                              <td ><span class="label label-sm label-success">Approved</span></td>
                           </tr>
                           <tr class="odd gradeX">
                              <td><input type="checkbox" class="checkboxes" value="1" /></td>
                              <td>userwow</td>
                              <td ><a href="mailto:userwow@gmail.com">userwow@gmail.com</a></td>
                              <td >20</td>
                              <td class="center">9.12.2012</td>
                              <td ><span class="label label-sm label-default">Blocked</span></td>
                           </tr>
                           <tr class="odd gradeX">
                              <td><input type="checkbox" class="checkboxes" value="1" /></td>
                              <td>tes21t</td>
                              <td ><a href="mailto:userwow@gmail.com">test@gmail.com</a></td>
                              <td >20</td>
                              <td class="center">14.12.2012</td>
                              <td ><span class="label label-sm label-success">Approved</span></td>
                           </tr>
                           <tr class="odd gradeX">
                              <td><input type="checkbox" class="checkboxes" value="1" /></td>
                              <td>fop</td>
                              <td ><a href="mailto:userwow@gmail.com">good@gmail.com</a></td>
                              <td >20</td>
                              <td class="center">13.11.2010</td>
                              <td ><span class="label label-sm label-warning">Suspended</span></td>
                           </tr>
                           <tr class="odd gradeX">
                              <td><input type="checkbox" class="checkboxes" value="1" /></td>
                              <td>kop</td>
                              <td ><a href="mailto:userwow@gmail.com">good@gmail.com</a></td>
                              <td >20</td>
                              <td class="center">17.11.2010</td>
                              <td><span class="label label-sm label-success">Approved</span></td>
                           </tr>
                           <tr class="odd gradeX">
                              <td><input type="checkbox" class="checkboxes" value="1" /></td>
                              <td>vopl</td>
                              <td ><a href="mailto:userwow@gmail.com">good@gmail.com</a></td>
                              <td >20</td>
                              <td class="center">19.11.2010</td>
                              <td><span class="label label-sm label-success">Approved</span></td>
                           </tr>
                           <tr class="odd gradeX">
                              <td><input type="checkbox" class="checkboxes" value="1" /></td>
                              <td>userwow</td>
                              <td ><a href="mailto:userwow@gmail.com">userwow@gmail.com</a></td>
                              <td >20</td>
                              <td class="center">12.12.2012</td>
                              <td><span class="label label-sm label-default">Blocked</span></td>
                           </tr>
                           <tr class="odd gradeX">
                              <td><input type="checkbox" class="checkboxes" value="1" /></td>
                              <td>wap</td>
                              <td ><a href="mailto:userwow@gmail.com">test@gmail.com</a></td>
                              <td >20</td>
                              <td class="center">12.12.2012</td>
                              <td><span class="label label-sm label-success">Approved</span></td>
                           </tr>
                           <tr class="odd gradeX">
                              <td><input type="checkbox" class="checkboxes" value="1" /></td>
                              <td>test</td>
                              <td ><a href="mailto:userwow@gmail.com">good@gmail.com</a></td>
                              <td >20</td>
                              <td class="center">19.12.2010</td>
                              <td><span class="label label-sm label-success">Approved</span></td>
                           </tr>
                           <tr class="odd gradeX">
                              <td><input type="checkbox" class="checkboxes" value="1" /></td>
                              <td>toop</td>
                              <td ><a href="mailto:userwow@gmail.com">good@gmail.com</a></td>
                              <td >20</td>
                              <td class="center">17.12.2010</td>
                              <td><span class="label label-sm label-success">Approved</span></td>
                           </tr>
                           <tr class="odd gradeX">
                              <td><input type="checkbox" class="checkboxes" value="1" /></td>
                              <td>weep</td>
                              <td ><a href="mailto:userwow@gmail.com">good@gmail.com</a></td>
                              <td >20</td>
                              <td class="center">15.11.2011</td>
                              <td><span class="label label-sm label-success">Approved</span></td>
                           </tr>
                        </tbody>
                     </table>
                  </div>
               </div>
               <!-- END EXAMPLE TABLE PORTLET-->
            </div>
         </div>
 
         <!-- END PAGE CONTENT-->
      </div>
      <!-- END PAGE -->

	
	</div>
   <!-- END CONTAINER -->
   <jsp:include page="../main/footer.jsp" />
    <jsp:include page="../main/js_main.jsp" />
   
</body>
</html>