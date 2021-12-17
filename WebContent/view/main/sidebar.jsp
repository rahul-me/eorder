<%@ taglib uri="/WEB-INF/praesta-custom.tld" prefix="praetsa"%>
      <!-- BEGIN SIDEBAR -->
      <div class="page-sidebar navbar-collapse collapse ">
         <!-- BEGIN SIDEBAR MENU -->  
         <ul class="page-sidebar-menu ">
            <li>
               <!-- BEGIN SIDEBAR TOGGLER BUTTON -->
               <div class="sidebar-toggler hidden-phone"></div>
               <!-- BEGIN SIDEBAR TOGGLER BUTTON -->
            </li>
            <li>
               <!-- BEGIN RESPONSIVE QUICK SEARCH FORM -->
               <form class="sidebar-search" action="extra_search.html" method="POST">
                  <div class="form-container">
                     <div class="input-box">
                        <a href="javascript:;" class="remove"></a>
                        <input type="text" placeholder="Search..."/>
                        <input type="button" class="submit" value=" "/>
                     </div>
                  </div>
               </form>
               <!-- END RESPONSIVE QUICK SEARCH FORM -->
            </li>
            <li class="sidebar active" id="home">
               <a href="../../view/main/index.jsp">
               <i class="icon-home"></i> 
               <span class="title">Home</span>
               </a>
            </li>
       
            <praetsa:roleCheck componentName="edit_OrderList" rolePermitted="admin">
            <li class="sidebar" id="order">
               <a href="../../view/po/filterViewAction.do?orderList=true">
               <i class="icon-edit"></i>
               <span class="title">Order List</span>
               </a>
          
            </li>
            </praetsa:roleCheck>
            
             <praetsa:roleCheck componentName="edit_OrderManagement" rolePermitted="admin">
             <li class="sidebar" id="ordermanage">
            	<a href="../../view/po/filterViewAction.do?orderManagementList=true">
               <i class="icon-list"></i> 
               <span class="title ">Order Management</span>
               </a>
             </li>
             </praetsa:roleCheck>
           
            <praetsa:roleCheck componentName="editMasterDataEntry_ViewAll" rolePermitted="admin">
            <li class="sidebar" id="mdm">
               <a href="javascript:;">
               <i class="icon-cloud"></i> 
               <span class="title">Master Data Entry</span>
               <span class="arrow mdm"></span>
               </a>
               <ul class="sub-menu">
                  <praetsa:roleCheck componentName="editMaster_createItemAndSetting" rolePermitted="admin">
                  <li>
                     <a href="javascript:;">
                     <i class="icon-info-sign"></i> 
                     Item Master
                     <span class="arrow"></span>
                     </a>
                     <ul class="sub-menu">
                        <li><a href="../../view/item/ItemViewAction.do"><i class="icon-pencil"></i>Create New Item</a></li>
                        <li><a href="../../view/po/filterViewAction.do?listItem=true"><i class="icon-list"></i>Item List</a></li>
                     </ul>
                  </li>
                  </praetsa:roleCheck>
                   <li>
                     <a href="javascript:;">
                     <i class="icon-globe"></i> 
                     Item Category
                     <span class="arrow"></span>
                     </a>
                     <ul class="sub-menu">
                        <li><a href="../../view/itemcategories/ItemCategoryViewAction.do"><i class="icon-pencil"></i>Create Item Category</a></li>
                        <li><a href="../../view/po/filterViewAction.do?itemCategory=true"><i class="icon-list"></i>Item Category List</a></li>
                     </ul>
                  </li>
                  <li>
                     <a href="javascript:;">
                     <i class="icon-globe"></i> 
                     Order Process Stage
                     <span class="arrow"></span>
                     </a>
                     <ul class="sub-menu">
                        <li><a href="../../view/itemcategories/ItemCategoryViewAction.do"><i class="icon-pencil"></i>Create Order Stage</a></li>
                        <li><a href="../../view/po/filterViewAction.do?itemCategory=true"><i class="icon-list"></i>Order Stage List</a></li>
                     </ul>
                  </li>
                   <li>
                     <a href="javascript:;">
                     <i class="icon-dashboard"></i> 
                     Measurement
                     <span class="arrow"></span>
                     </a>
                     <ul class="sub-menu">
                        <li><a href="../../view/measurement/MeasurementViewAction.do"><i class="icon-pencil"></i>Create Measurement</a></li>
                         <li><a href="../../view/po/filterViewAction.do?listMeasurement=true"><i class="icon-list"></i>Measurement List</a></li>
                     </ul>
                  </li>
		          <li>
                     <a href="javascript:;">
                     <i class="icon-user"></i> 
                     User Master
                     <span class="arrow"></span>
                     </a>
                     <ul class="sub-menu">
                     	<li><a href="../../view/users/UsersViewAction.do"><i class="icon-pencil"></i>Create New User</a></li>
                        <li><a href="../../view/po/filterViewAction.do?listUsers=true"><i class="icon-list"></i>Users List</a></li>
                     </ul>
                  </li>
                  <li>
                     <a href="javascript:;">
                     <i class="icon-user"></i> 
                     User Role Master
                     <span class="arrow"></span>
                     </a>
                     <ul class="sub-menu">
                        <li><a href="../../view/users/UsersRoleViewAction.do"><i class="icon-pencil"></i>Create User Role</a></li>
                        <li><a href="../../view/po/filterViewAction.do?listUserRole=true"><i class="icon-list"></i>User Role List</a></li>
                     </ul>
                  </li>
                </ul>
            </li>
            </praetsa:roleCheck>
            <%-- <praetsa:roleCheck componentName="editSettings_ViewAll" rolePermitted="admin"> --%>
            <li class="">
               <a href="javascript:;">
               <i class="icon-cogs"></i> 
               <span class="title">Settings</span>
               <span class="arrow "></span>
               </a>
               <ul class="sub-menu">
               	 <%-- <praetsa:roleCheck componentName="editSettings_AccessControl" rolePermitted="admin"> --%>
                   <li><a href="../../view/settings/AccessControlView.do"><i class=" icon-key"></i>Access Control</a></li>
               <%--   </praetsa:roleCheck> --%>
              
               </ul>
            </li>
            <%-- </praetsa:roleCheck>  --%>
            <praetsa:roleCheck componentName="Report_ViewAll" rolePermitted="admin">
            <li class="sidebar" id="report">
               <a href="javascript:;">
               <i class="icon-bar-chart"></i> 
               <span class="title">Report</span>
               <span class="report arrow "></span>
               </a>
                <ul class="sub-menu">
               </ul> 
            </li>
           </praetsa:roleCheck>
         </ul>
         <!-- END SIDEBAR MENU -->
      </div>
      <!-- END SIDEBAR -->
  