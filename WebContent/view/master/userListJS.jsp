 <script type="text/javascript">
         
        							function back(){
        		 						window.location = '../mainscmview/index.jsp';
        							};
        	
        	
        							function editorder(userid){
	 										window.location="../users/UsersViewAction.do?userMasterId="+userid;
									 };
									 
        	
									 function deleteOrder(userid){
							        		var obj=new Object();
							         	  	obj.userid = userid;
							         	  	var str = JSON.stringify(obj);
							         	  
							         	  	$.ajax({
							         	  	    url: "../../rest/preastaWebService/inActiveRecord"
							         	  	    , type: "POST"
							         	  	    , contentType: 'application/json; charset=utf-8'
							         	  	    , dataType: 'json'
							         	  	    , data: str
							         	  	    , success: function (data) {
							         	  	    	var usrid=null;
							         	  	    	var userRole=null;
							         	  	    	getList(usrid,userRole);
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
							        	
							        	function getList(userId,userRole)
							        	{
							        		var oTable = $('#example').dataTable();
							 	          	if(oTable!=null) oTable.fnDestroy();
							 	          	var uid=userId;
							 	          	var urollid=userRole;
							 	          	
							 	          	//alert("qwwe");
							 	           $('#example').dataTable( {
							 	        	   "sAjaxSource" : "../../rest/masterDataMgmtService/getUsersListByFilter?userId="+uid+"&userRole="+urollid,
							 	        	 "bProcessing": true,
							 	          	 "aoColumns":[
							 	                {"mDataProp":"UserId"},
							 					{"mDataProp":"UserName"},
							 					{"mDataProp":"FirstName"},
							 					{"mDataProp":"PhoneNo"},
							 					{"mDataProp":"UserRole"},							 				 	  
							 					{"mDataProp":"status"},
							 					{"mDataProp":"edit"},
							 					
							 					/* {"mDataProp":"Address"}, */
							 					//{"mDataProp":"UserRole"},
							 				//	{"mDataProp":"CompanyName"},
							 					/* {"mDataProp":"CreatedOn"}, */
							 	                ],
							 	                "aLengthMenu":[[50,100,500, -1],[50,100,500, "All"]],
							 					"iDisplayLength": 100,
							 	        });
							       	 
							        	}
        	
        	
        	
        	
        	
        	
        	

          
    $(document).ready(function() {
    	var mm = $('#alertMsg').val();
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
    	
        $(".selectFilter").show();
      //  $(".date").show();
        $(".userName").show();
        $(".userRole").show();
        $(".company").show();
        
        $("#filter  option[value='supplierId']").remove();
        $("#filter  option[value='date']").remove();
        $("#filter  option[value='itemIds']").remove();
        $("#filter  option[value='itemCategoryId']").remove();
       
    	

    	var userId=$('#userId').val();
    	var userRole=$('#userRoleId').val();
    
    	getList(userId,userRole);
    
     /* $("#createUser").click(function(){
 	  	window.location.href = "../users/UsersViewAction.do?statusUserList=false";
 	  }); */
     
     
    });    
    
    
    
    $("#filterBTN").click(function(event){
    	   
    	var oTable = $('#example').dataTable();
    
    	var userId=$('#userId').val();
    	var userRole=$('#userRoleId').val();   	
    	getList(userId,userRole);
    	  
      
    } );
  
   
    
</script> 