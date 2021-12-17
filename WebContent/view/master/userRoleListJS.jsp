  <script type="text/javascript">
        /*   $('#example tbody tr').live( 'click', function (event) {
        	    var userRoleId= $(this).find("td:first").html(); 
        	    window.location="../users/UsersRoleViewAction.do?userRoleId="+userRoleId;
        	});
 */			
			 
 
 
        							function back(){
        		 						window.location = '../mainscmview/index.jsp';
        	      									}
 
 									function editorder(UserRolesMasterId){
 										  window.location="../users/UsersRoleViewAction.do?UserRolesMasterId="+UserRolesMasterId;
									};
 
									function deleteOrder(UserRolesMasterId){
						        		var obj=new Object();
						         	  	obj.UserRolesMasterId = UserRolesMasterId;
						         	  	var str = JSON.stringify(obj);						         	  	
						         	  	$.ajax({
						         	  	    url: "../../rest/preastaWebService/inActiveRecord"
						         	  	    , type: "POST"
						         	  	    , contentType: 'application/json; charset=utf-8'
						         	  	    , dataType: 'json'
						         	  	    , data: str
						         	  	    , success: function (data) {
						         	  	    	getList();
						         	  	    	str = JSON.stringify(data);
						    					//alert(data["mobileExist"]);
						    					if(data["status"]==true)
						    					{
						    						Command: toastr['error']("Record Deleted Successfully!!!!")
						    						toastr.options = {
						    		        				"closeButton": true,
						    		        				  "debug": false,
						    		        				  "positionClass": "toast-bottom-full-width",
						    		        				  "onclick": null,
						    		        				  "showDuration": "1000",
						    		        				  "hideDuration": "1000",
						    		        				  "timeOut": "5000",
						    		        				  "extendedTimeOut": "1000",
						    		        				  "showEasing": "swing",
						    		        				  "hideEasing": "linear",
						    		        				  "showMethod": "fadeIn",
						    		        				  "hideMethod": "fadeOut"
						    		        			}
						    					}
						         	  	    	
						         	  	    	
						         	  	    }
						         	  	});
						        	};	
						        	
						        	function getList()
						        	{
						        		var oTable = $('#example').dataTable();
						 	          	if(oTable!=null) oTable.fnDestroy();
						 	          	//alert("qwwe");
						 	           $('#example').dataTable({
						        		    "sAjaxSource" : "../../rest/masterDataMgmtService/getUserRoleListByFilter",
						        	        "bProcessing": true,
						        	      	 "aoColumns":[
						       	      	            {"mDataProp":"id"},
						                        	{"mDataProp":"userRolename"},                 	
						                        	{"mDataProp":"CreatedBy"},
						                        	{"mDataProp":"status"},
						                        	{"mDataProp":"edit"},
						                        	 ],
						        				 "aLengthMenu":[[50,100,500, -1],[50,100,500, "All"]],
						        					"iDisplayLength": 100,
						                    
						        	    });
						        	}
 
 
 
          
          $(document).ready(function() {
        	  	var mm=$('#alertMsg').val();
        		var a = $('#error').text();
        		//alert(a);
        		if (a == "") {
        		} else {

        			Command: toastr['success'](""+mm+" "+a+"")
        			toastr.options = {
        				"closeButton": true,
        				  "debug": false,
        				  "positionClass": "toast-bottom-full-width",
        				  "onclick": null,
        				  "showDuration": "1000",
        				  "hideDuration": "1000",
        				  "timeOut": "5000",
        				  "extendedTimeOut": "1000",
        				  "showEasing": "swing",
        				  "hideEasing": "linear",
        				  "showMethod": "fadeIn",
        				  "hideMethod": "fadeOut"
        			}

        		}

        	 	getList();
        		
        	
        
        	$(".selectFilter").show();
      	 
      	    
      	    
      	    $("#filter  option[value='supplierId']").remove();
      	    $("#filter  option[value='date']").remove();
      	    $("#filter  option[value='itemIds']").remove();
      	    $("#filter  option[value='itemCategoryId']").remove();
      	
      	    $("#createItemCat").click(function(){
      	  	window.location.href = "../users/UsersRoleViewAction.do?createItemCategoryStatus=false";
      	  });
      	    
        	});
          
          
          $("#filterBTN").click(function(event){
          	/* var oTable = $('#example').dataTable();
         	var itemCategoryId=$('#itemCategoryId').val();
         	var companyId=$('#companyId').val();
         	// var fromDate=$('#datepicker2').val();
          	// var toDate=$('#datepicker1').val();
          	 
          	if(oTable!=null) oTable.fnDestroy();
          	 $('#example').dataTable( {
                   "sAjaxSource" : "../../rest/masterDataMgmtService/getUserRoleListByFilter?itemCategoryId="+itemCategoryId+"&companyId="+companyId,
                   "bProcessing": true,
                 	 "aoColumns":[
                 	         {"mDataProp":"id"},
                             {"mDataProp":"userRoleName"},
                             {"mDataProp":"userRoleDesc"},
                             {"mDataProp":"CreatedBy"},
                       ],
                       "aLengthMenu":[[50,100,500, -1],[50,100,500, "All"]],
       				"iDisplayLength": 100,
                       "oLanguage": {
                           "sSearch": "Search all columns:"
                        },
               } ); */
         // 	$("#example_length").hide();
          });  
</script> 