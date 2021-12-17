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
                     <option value="fixed" selected="selected">Fixed</option>
                     <option value="default">Default</option>
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
                  Dashboard <small>Billing And More</small>
               </h3>
              
               <!-- END PAGE TITLE & BREADCRUMB-->
            </div>
         </div>
         <!-- END PAGE HEADER-->
 
   
       
         <div class="clearfix"></div>
         <div class="row ">
            <div class="col-md-3 col-sm-3">
               <div class="portlet box grey">
                  <div class="portlet-title">
                     <div class="caption"> Category </div>
                      <!-- BEGIN RESPONSIVE QUICK SEARCH FORM -->
		               <form class="sidebar-search" action="extra_search.html" method="POST">
		                  <div class="form-container">
		                     <div class="input-box">
		                        <a href="javascript:;" class="remove"></a>
		                        <input type="text" placeholder="Search..."/>
		                        <input type="button" class="select" value=" "/>
		                     </div>
		                  </div>
		               </form>
		               <!-- END RESPONSIVE QUICK SEARCH FORM -->
                  </div>
                  <div class="portlet-body">
                     <div class="panel-group accordion scrollable" id="accordion2" >
                     
                        <div class="panel panel-default" id="panel">
                           <div class="panel-heading">
                              <h4 class="panel-title">
                                 <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapse_2_1" id="link">Food</a>
                              </h4>
                           </div>
                           <div id="collapse_2_1" class="panel-collapse collapse">
                              <div class="panel-body">
                                 <table id="tableId">
                                 <tr>
                                 	<td align="center" valign="top"><a href="images/big.png" title="" class="lightbox"><img src="../../assets/img/avatar1.jpg" alt="" /></a><div class="dname"><a href="#">Coffee</a></div></td>
                                 	<td align="center" valign="top"><a href="images/big.png" title="" class="lightbox"><img src="../../assets/img/avatar2.jpg" alt="" /></a><div class="dname"><a href="#">Blue Coffee</a></div></td>
                                 	<td align="center" valign="top"><a href="images/big.png" title="" class="lightbox"><img src="../../assets/img/avatar3.jpg" alt="" /></a><div class="dname"><a href="#">Italian Coffee</a></div></td>
                                 	<td align="center" valign="top"><a href="images/big.png" title="" class="lightbox"><img src="../../assets/img/avatar1.jpg" alt="" /></a><div class="dname"><a href="#">hot Coffee</a></div></td>
                                 </tr>
                                 <tr>
                                 	<td align="center" valign="top"><a href="images/big.png" title="" class="lightbox"><img src="../../assets/img/avatar1.jpg" alt="" /></a><div class="dname"><a href="#">Coffee</a></div></td>
                                 	<td align="center" valign="top"><a href="images/big.png" title="" class="lightbox"><img src="../../assets/img/avatar2.jpg" alt="" /></a><div class="dname"><a href="#">Blue Coffee</a></div></td>
                                 	<td align="center" valign="top"><a href="images/big.png" title="" class="lightbox"><img src="../../assets/img/avatar3.jpg" alt="" /></a><div class="dname"><a href="#">Italian Coffee Italian Coffee Italian Coffee</a></div></td>
                                 	<td align="center" valign="top"><a href="images/big.png" title="" class="lightbox"><img src="../../assets/img/avatar1.jpg" alt="" /></a><div class="dname"><a href="#">hot Coffee</a></div></td>
                                 </tr>
                                 </table>
                              </div>
                           </div>
                        </div>
                   
                     </div>
                  </div>
               </div>
            </div>
            <div class="col-md-6 col-sm-6">
               <div class="portlet box green tasks-widget">
                   <div class="portlet-title">
                     <div class="caption"><i class="icon-bell"></i>Select Item </div>
                      <!-- BEGIN RESPONSIVE QUICK SEARCH FORM -->
		               <form class="sidebar-search" action="extra_search.html" method="POST">
		                  <div class="form-container">
		                     <div class="input-box">
		                        <a href="javascript:;" class="remove"></a>
		                        <input type="text" placeholder="Search..."/>
		                        <input type="button" class="select" value=" "/>
		                     </div>
		                  </div>
		               </form>
		               <!-- END RESPONSIVE QUICK SEARCH FORM -->
                  </div>
                  <div class="portlet-body">
                     <div class="task-content">
                        <div class="scroller" style="height: 600px;" data-always-visible="1" data-rail-visible1="1">
                           <!-- START TASK LIST -->
                        	<table id="itemTableId">
                                 <tr>
                                 	<td align="center" valign="top"><a href="images/big.png" title="" class="lightbox"><img src="../../assets/img/foodimage.jpg" alt="" /></a><div class="dname"><a href="#">Coffee</a></div></td>
                                 	<td align="center" valign="top"><a href="images/big.png" title="" class="lightbox"><img src="../../assets/img/foodimage.jpg" alt="" /></a><div class="dname"><a href="#">Blue Coffee</a></div></td>
                                 	<td align="center" valign="top"><a href="images/big.png" title="" class="lightbox"><img src="../../assets/img/foodimage.jpg" alt="" /></a><div class="dname"><a href="#">Italian Coffee</a></div></td>
                                 	<td align="center" valign="top"><a href="images/big.png" title="" class="lightbox"><img src="../../assets/img/foodimage.jpg" alt="" /></a><div class="dname"><a href="#">Borke Coffee</a></div></td>
                                 </tr>
                                 <tr>
                                 	<td align="center" valign="top"><a href="images/big.png" title="" class="lightbox"><img src="../../assets/img/foodimage.jpg" alt="" /></a><div class="dname"><a href="#">Cold Coffee</a></div></td>
                                 </tr>
                            </table>
                           <!-- END START TASK LIST -->
                        </div>
                     </div>
                     <div class="task-footer">
                        <span class="pull-right">
                        <a href="#">See All Tasks <i class="m-icon-swapright m-icon-gray"></i></a> &nbsp;
                        </span>
                     </div>
                  </div>
               </div>
            </div>
                 <div class="col-md-3 col-sm-3">
               <div class="portlet box blue">
                  <div class="portlet-title">
                     <div class="caption"><i class="icon-bell"></i>Billing</div>
                  </div>
                  <div class="portlet-body">
                     <div class="scroller" style="height: 400px;" data-always-visible="1" data-rail-visible="0">
                        <ul class="feeds" id="billing">
                         <!--   <li id="order">
                              <div class="col1" id="orderId">
                                 <div class="cont">
                                    <div class="cont-col1">
                                       <div class="label label-sm label-default">                        
                                          <i class="icon-signout"></i>
                                       </div>
                                    </div>
                                    <div class="cont-col2">
                                       <div class="desc" id="0">
                                          Coffe
                                       </div>
                                    </div>
                                 </div>
                              </div>
                              <div class="col2" id="orderQty">
                                 <div class="date">
                                    <div class="badge badge-sm badge-info" id="qty">2</div>
                                    <div class="label label-sm label-danger">                        
                                          <i class="icon-remove"></i>
                                    </div>
                                 </div>
                              </div>
                           </li>
                            <li>
                              <div class="col1">
                                 <div class="cont">
                                    <div class="cont-col1">
                                       <div class="label label-sm label-default">                        
                                          <i class="icon-signout"></i>
                                       </div>
                                    </div>
                                    <div class="cont-col2">
                                       <div class="desc">
                                          Hot Coffe
                                       </div>
                                    </div>
                                 </div>
                              </div>
                              <div class="col2">
                                 <div class="date">
                                    <div class="badge badge-sm badge-info">1</div>
                                    <div class="label label-sm label-danger">                        
                                          <i class="icon-remove"></i>
                                    </div>
                                 </div>
                              </div>
                           </li> -->
                        </ul>
                     </div>
                     <div class="well">
	                     <button type="button" id="print" class="btn green">Print Bill</button>
	                     <button type="button" class="btn dark" id="cancel">Cancel Bill</button>
                     </div>
                     <div class="scroller-footer">
                        <div class="pull-right">
                           <a href="#">See All Records <i class="m-icon-swapright m-icon-gray"></i></a> &nbsp;
                        </div>
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </div>
      <!-- END PAGE -->
  