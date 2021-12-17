<%@ taglib uri="/WEB-INF/praesta-custom.tld" prefix="praetsa"%>


		<li class="active">
			<!-- <a href=""> -->	
			<a href="../../view/main/index1.jsp">			
			Home
			</a>			
		</li>
		
		<praetsa:roleCheck componentName="showHideOrder_AccessControl" rolePermitted="admin"> 
			<li>
				<a data-toggle="dropdown" class="dropdown-toggle" href="">Order
				<i class="icon-angle-down"></i>
				</a>
				<ul class="dropdown-menu">
				<praetsa:roleCheck componentName="order_AccessControl" rolePermitted="admin">
					<li><a href="../../view/order/orderMasterViewAction.do">Order</a></li>
				</praetsa:roleCheck>
				
				<praetsa:roleCheck componentName="orderList_AccessControl" rolePermitted="admin">
					<li><a href="../../view/po/filterViewAction.do?orderList=true">Order List</a></li>
				</praetsa:roleCheck>
							
				</ul>
			</li>
	 	 </praetsa:roleCheck>
		
		  <praetsa:roleCheck componentName="orderManagment_AccessControl" rolePermitted="admin"> 
			 <li>
				<a href="../../view/po/filterViewAction.do?orderManagementList=true">Order Management</a>
			</li> 
		 </praetsa:roleCheck> 
		 
		 <praetsa:roleCheck componentName="showHideSetting_AccessControl" rolePermitted="admin">
		 <li>
           <a data-toggle="dropdown" class="dropdown-toggle" href="">Settings
			<i class="icon-angle-down"></i>
			</a>	
			<ul class="dropdown-menu">
				<praetsa:roleCheck componentName="accessControl" rolePermitted="admin">
						<li><a tabindex="-1" href="../../view/settings/AccessControlView.do">Access Control</a></li>
				</praetsa:roleCheck>						
				<praetsa:roleCheck componentName="itemPrice_AccessControl" rolePermitted="admin">
						<li><a tabindex="-1" href="../../view/itemcustomermapping/ItemCustomerMapViewAction.do">Item-Price Settings</a></li>
				</praetsa:roleCheck>
				<praetsa:roleCheck componentName="settingConfigure_AccessControl" rolePermitted="admin">
						<li><a tabindex="-1" href="../../view/settings/settingConfig.jsp">Settings Configuration</a></li>
				</praetsa:roleCheck>
			</ul>				
		</li>
		</praetsa:roleCheck>
		
		
		 
		 <praetsa:roleCheck componentName="showHideMasterData_AccessControl" rolePermitted="admin">
	<li><a data-toggle="dropdown" class="dropdown-toggle" href="">Master
			Data <i class="icon-angle-down"></i>
	</a>
		<ul class="dropdown-menu">
			<%-- Here Modification is done for create package --%>
			<%-- END OF Here Modification is done for create package --%>
			<praetsa:roleCheck componentName="showHideItem_AccessControl"
				rolePermitted="admin">
				<li class="dropdown-submenu"><a tabindex="-1"
					href="javascript:;"> Item </a>
					<ul class="dropdown-menu">
						<praetsa:roleCheck componentName="item_AccessControl"
							rolePermitted="admin">
							<li><a tabindex="-1"
								href="../../view/item/ItemViewAction.do">Create New Item</a></li>
						</praetsa:roleCheck>
						<praetsa:roleCheck componentName="itemList_AccessControl"
							rolePermitted="admin">
							<li><a tabindex="-1"
								href="../../view/po/filterViewAction.do?ItemListForward=true">Item
									List</a></li>
						</praetsa:roleCheck>
					</ul></li>
			</praetsa:roleCheck>
			<%--  <praetsa:roleCheck componentName="showHideItemCategory_AccessControl" rolePermitted="admin">
						<li class="dropdown-submenu">
							<a tabindex="-1" href="javascript:;">
							Item Category
							</a>
							<ul class="dropdown-menu">
							<praetsa:roleCheck componentName="itemCategory_AccessControl" rolePermitted="admin">
								<li><a tabindex="-1" href="../../view/itemcategories/ItemCategoryViewAction.do">Create Item Category</a></li>
								</praetsa:roleCheck>
								<praetsa:roleCheck componentName="itemCategoryList_AccessControl" rolePermitted="admin">
								<li><a tabindex="-1" href="../../view/po/filterViewAction.do?itemCategoryList=true">Item Category List</a></li>
								</praetsa:roleCheck>
							</ul>
						</li>
						</praetsa:roleCheck> --%>
			<%-- <praetsa:roleCheck componentName="showHideCustomer_AccessControl" rolePermitted="admin">
						<li class="dropdown-submenu">
							<a tabindex="-1" href="javascript:;">
							Customer
							</a>
							<ul class="dropdown-menu">
							<praetsa:roleCheck componentName="customer_AccessControl" rolePermitted="admin">
								<li><a tabindex="-1" href="../../view/users/UsersViewAction.do?hello=0">Create New Customer</a></li>
								</praetsa:roleCheck>
								<praetsa:roleCheck componentName="customerList_AccessControl" rolePermitted="admin">
								<li><a tabindex="-1" href="../../view/po/filterViewAction.do?listCustomer=true">Customer List</a></li>
								</praetsa:roleCheck>
							</ul>
						</li>
						</praetsa:roleCheck> --%>
			<praetsa:roleCheck componentName="showHideUser_AccessControl"
				rolePermitted="admin">
				<li class="dropdown-submenu"><a tabindex="-1"
					href="javascript:;"> User </a>
					<ul class="dropdown-menu">
						<praetsa:roleCheck componentName="user_AccessControl"
							rolePermitted="admin">
							<li><a tabindex="-1"
								href="../../view/users/UsersViewAction.do?hello1=0">Create
									New User</a></li>
						</praetsa:roleCheck>
						<praetsa:roleCheck componentName="userList_AccessControl"
							rolePermitted="admin">
							<li><a tabindex="-1"
								href="../../view/po/filterViewAction.do?listUsers=true">User
									List</a></li>
						</praetsa:roleCheck>
					</ul></li>
			</praetsa:roleCheck>
			<praetsa:roleCheck componentName="showHideUserRole_AccessControl"
				rolePermitted="admin">
				<li class="dropdown-submenu"><a tabindex="-1"
					href="javascript:;"> User Role </a>
					<ul class="dropdown-menu">
						<praetsa:roleCheck componentName="userRole_AccessControl"
							rolePermitted="admin">
							<li><a tabindex="-1"
								href="../../view/users/UsersRoleViewAction.do">Create User
									Role</a></li>
						</praetsa:roleCheck>
						<praetsa:roleCheck componentName="userRoleList_AccessControl"
							rolePermitted="admin">
							<li><a tabindex="-1"
								href="../../view/po/filterViewAction.do?listUserRole=true">User
									Role List</a></li>
						</praetsa:roleCheck>
					</ul></li>
			</praetsa:roleCheck>
			<praetsa:roleCheck componentName="showHideCompany_AccessControl"
				rolePermitted="admin">
				<li class="dropdown-submenu"><a tabindex="-1"
					href="javascript:;"> Company </a>
					<ul class="dropdown-menu">
						<praetsa:roleCheck componentName="company_AccessControl"
							rolePermitted="admin">
							<li><a tabindex="-1"
								href="../../view/master/companyViewAction.do">Create Company</a></li>
						</praetsa:roleCheck>
						<praetsa:roleCheck componentName="companyList_AccessControl"
							rolePermitted="admin">
							<li><a tabindex="-1"
								href="../../view/po/filterViewAction.do?companyList=true">Company
									List</a></li>
						</praetsa:roleCheck>
					</ul></li>
			</praetsa:roleCheck>
			<%-- <praetsa:roleCheck componentName="showHidePackage_AccessControl" rolePermitted="admin">
							<li class="dropdown-submenu">
								<a tabindex="-1" href="javascript:;">
								Package
								</a>
								<ul class="dropdown-menu">
								<praetsa:roleCheck componentName="package_AccessControl" rolePermitted="admin">
									<li><a tabindex="-1" href="../../view/master/CreatePackagesAction.do">Package Entry</a></li>
									</praetsa:roleCheck>
								<praetsa:roleCheck componentName="packageList_AccessControl" rolePermitted="admin">
									<li><a tabindex="-1" href="../../view/master/ListPackagesAction.do">Package List</a></li>
									</praetsa:roleCheck>												
								</ul>
							</li>
						</praetsa:roleCheck> --%>
			<%-- <li class="dropdown-submenu">
							<a tabindex="-1" href="javascript:;">
							Company
							</a>
							<ul class="dropdown-menu">
							<praetsa:roleCheck componentName="showHideMasterData_AccessControl" rolePermitted="admin">
								<li><a tabindex="-1" href="../../view/master/companyViewAction.do">Create Company</a></li>
								</praetsa:roleCheck>
								<praetsa:roleCheck componentName="showHideMasterData_AccessControl" rolePermitted="admin">
								<li><a tabindex="-1" href="../../view/po/filterViewAction.do?companyList=true">Company List</a></li>
								</praetsa:roleCheck>
							</ul>
						</li> --%>
			<praetsa:roleCheck componentName="showHideOrderStage_AccessControl"
				rolePermitted="admin">
				<li class="dropdown-submenu"><a tabindex="-1"
					href="javascript:;"> Order Stage </a>
					<ul class="dropdown-menu">
						<praetsa:roleCheck componentName="orderStage_AccessControl"
							rolePermitted="admin">
							<li><a tabindex="-1"
								href="../../view/orderstage/OrderStageViewAction.do">Create
									Order Stage</a></li>
						</praetsa:roleCheck>
						<praetsa:roleCheck componentName="orderStageList_AccessControl"
							rolePermitted="admin">
							<li><a tabindex="-1"
								href="../../view/po/filterViewAction.do?OrderStageList=true">OrderStage
									List</a></li>
						</praetsa:roleCheck>
					</ul></li>
			</praetsa:roleCheck>

			<praetsa:roleCheck componentName="showHideMeasurement_AccessControl"
				rolePermitted="admin">
				<li class="dropdown-submenu"><a tabindex="-1"
					href="javascript:;"> Measurement </a>
					<ul class="dropdown-menu">
						<praetsa:roleCheck componentName="measurement_AccessControl"
							rolePermitted="admin">
							<li><a tabindex="-1"
								href="../../view/measurement/MeasurementViewAction.do">Create
									Measurement</a></li>
						</praetsa:roleCheck>
						<praetsa:roleCheck componentName="measurementList_AccessControl"
							rolePermitted="admin">
							<li><a tabindex="-1"
								href="../../view/po/filterViewAction.do?listMeasurement=true">Measurement
									List</a></li>
						</praetsa:roleCheck>
					</ul></li>
			</praetsa:roleCheck>
			
		</ul>
		</li>		
</praetsa:roleCheck>
<praetsa:roleCheck componentName="sale_AccessControl" rolePermitted="admin">
<li><a data-toggle="dropdown" class="dropdown-toggle" href="">Sale
		<i class="icon-angle-down"></i>
	</a>
	<ul class="dropdown-menu">		
			<li><a href="../../view/sale/saleViewAction.do">Sale Entry</a></li>		
			<li><a href="../../view/sale/salelistView.do">Sale List</a></li>
	</ul></li>
	</praetsa:roleCheck>
<praetsa:roleCheck componentName="sale_AccessControl" rolePermitted="admin">	
<li><a data-toggle="dropdown" class="dropdown-toggle" href="">Item
		<i class="icon-angle-down"></i>
	</a>
	<ul class="dropdown-menu">		
			<li><a href="">Item List</a></li>		
	</ul></li>
	<!-- ../../view/sale/saleItemList.do -->	
</praetsa:roleCheck>

	
	
<praetsa:roleCheck componentName="companydetailac" rolePermitted="admin">	
<li><a data-toggle="dropdown" class="dropdown-toggle" href="">Company <i class="icon-angle-down"></i></a>
	<ul class="dropdown-menu">									
		<li class="dropdown-submenu"><a tabindex="-1" href="javascript:;"> Details </a>
			<ul class="dropdown-menu">						
				<li><a tabindex="-1" href="../../view/company/companyDetailsViewAction.do">Fill Details</a></li>												
				<!-- <li><a tabindex="-1" href="">Show Details</a></li> -->						
			</ul>
		</li>								
	</ul>
</li>		
</praetsa:roleCheck>

<praetsa:roleCheck componentName="accountaccess" rolePermitted="admin"> 
	<li>
		<a data-toggle="dropdown" class="dropdown-toggle" href="">Account
			<i class="icon-angle-down"></i>
		</a>
		<ul class="dropdown-menu">			
			<li><a href="../../view/retail/accountViewAction.do">TIN Numbers</a></li>						
		</ul>
	</li>
</praetsa:roleCheck>
<praetsa:roleCheck componentName="shorderReportContol" rolePermitted="admin"> 
	<li>
		<a data-toggle="dropdown" class="dropdown-toggle" href="">Report
			<i class="icon-angle-down"></i>
		</a>
		<praetsa:roleCheck componentName="orderReportContol" rolePermitted="admin">
		<ul class="dropdown-menu">			
			<li><a href="../../view/report/orderReportView.do">Order Report</a></li>						
		</ul>
		</praetsa:roleCheck>
	</li>
</praetsa:roleCheck>