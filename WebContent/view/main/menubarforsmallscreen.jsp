	<li class="sidebar-search-wrapper">
					<!-- BEGIN RESPONSIVE QUICK SEARCH FORM -->
					<!-- DOC: Apply "sidebar-search-bordered" class the below search form to have bordered search box -->
					<!-- DOC: Apply "sidebar-search-bordered sidebar-search-solid" class the below search form to have bordered & solid search box -->
					<form class="sidebar-search sidebar-search-bordered" action="extra_search.html" method="POST">
						<a href="javascript:;" class="remove">
						<i class="icon-close"></i>
						</a>
						<div class="input-group">
							<input type="text" class="form-control" placeholder="Search...">
							<span class="input-group-btn">
							<button class="btn submit"><i class="icon-magnifier"></i></button>
							</span>
						</div>
					</form>
					<!-- END RESPONSIVE QUICK SEARCH FORM -->
	</li>
	<li class="active">
		<a href="">
		<!-- <a href="../../view/main/index.jsp"> -->
		Home                        
		</a>
	</li>
	<li>
		<a href="../../view/order/orderMasterViewAction.do">Order</a>
				
	</li>
	<li><a href="../../view/po/filterViewAction.do?orderList=true">Order List</a></li>
	<li>
		<a href="../../view/po/filterViewAction.do?orderManagementList=true">Order Management</a>
	</li>
	<li  class="active">
		<a href="javascript:;">
		Master Data
		<span class="arrow open"></span>   
		<span class="selected"></span>   
		</a>
		<ul class="sub-menu">
			<li>
				<a href="javascript:;">
				Item
				<span class="arrow"></span>
				</a>
				<ul class="sub-menu">
					<li><a href="../../view/item/ItemViewAction.do">Create New Item</a></li>
					<li><a
					href="../../view/po/filterViewAction.do?ItemListForward=true">Item
						List</a></li>
				</ul>
			</li>
			<li>
				<a href="javascript:;">
				Item Category
				<span class="arrow"></span>
				</a>
				<ul class="sub-menu">
					<li><a href="../../view/item/ItemViewAction.do">Create New Item</a></li>
					<li><a href="../../view/po/filterViewAction.do?listItem=true">Item List</a></li>
				</ul>
			</li>
			<li>
				<a href="javascript:;">
				Order Stage
				<span class="arrow"></span>
				</a>
				<ul class="sub-menu">
					<li><a href="../../view/itemcategories/ItemCategoryViewAction.do">Create Order Stage</a></li>
					<li><a href="../../view/po/filterViewAction.do?itemCategory=true">Order Stage List</a></li>
				</ul>
			</li>
			<li>
				<a href="javascript:;">
				Measurement
				<span class="arrow"></span>
				</a>
				<ul class="sub-menu">
					<li><a href="../../view/measurement/MeasurementViewAction.do">Create Measurement</a></li>
					<li><a href="../../view/po/filterViewAction.do?listMeasurement=true">Measurement List</a></li>
				</ul>
			</li>
			<li class="dropdown-submenu">
					<a tabindex="-1" href="javascript:;">
					Customer
					</a>
					<ul class="dropdown-menu">
						<li><a tabindex="-1" href="../../view/users/UsersViewAction.do">Create New Customer</a></li>
						<li><a tabindex="-1" href="../../view/po/filterViewAction.do?listUsers=true">Customer List</a></li>
					</ul>
				</li>
			<li>
				<a href="javascript:;">
				User
				<span class="arrow"></span>
				</a>
				<ul class="sub-menu">
					<li><a href="../../view/users/UsersViewAction.do">Create New User</a></li>
					<li><a href="../../view/po/filterViewAction.do?listUsers=true">User List</a></li>
				</ul>
			</li>
			<li>
				<a href="javascript:;">
				User Role
				<span class="arrow"></span>
				</a>
				<ul class="sub-menu">
					<li><a href="../../view/users/UsersRoleViewAction.do">Create User Role</a></li>
					<li><a href="../../view/po/filterViewAction.do?listUserRole=true">User Role List</a></li>
				</ul>
			</li>
		</ul>
	</li>
	<li>
		<a href="../../view/settings/AccessControlView.do">Settings</a>
	</li>
	<li>
		<a href="">Report</a>
	</li>
	