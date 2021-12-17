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
		         <!-- BEGIN PAGE HEADER-->
		         <div class="row">
		          
		         </div>
		         <!-- END PAGE HEADER-->
      </div>
      <!-- END PAGE -->

	
	</div>
   <!-- END CONTAINER -->
   <jsp:include page="../main/footer.jsp" />
	 <jsp:include page="../main/js_main.jsp" />
</body>
</html>