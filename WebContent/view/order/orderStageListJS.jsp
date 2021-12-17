 <script type="text/javascript">
           /* $('#example tbody tr').live( 'click', function (event) {
        	   var CompanyId = $(this).find("td:first").html(); 
        	    window.location="../master/companyViewAction.do?CompanyId="+CompanyId;
        	    
        	}); */

        	function back(){
        		 window.location = '../mainscmview/index.jsp';
        	}
        	
        	

			function deleteOrder(OrderStageMasterId){
        		var obj=new Object();
         	  	obj.OrderStageMasterId = OrderStageMasterId;
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
          	//	var OrderStageMasterId=$('#OrderStageMasterId').val();
          	    if(oTable!=null) oTable.fnDestroy();
          	    
           	 $('#example').dataTable({
     		    "sAjaxSource" : "../../rest/masterDataMgmtService/getOrderStageListByFilter",
     	        "bProcessing": true,
     	        "aoColumns":[
 								{"mDataProp":"orderstageid"},
 								{"mDataProp":"name"}, 								
 								{"mDataProp":"createdBy"},
 								{"mDataProp":"CreatedOn"},
 								{"mDataProp":"status"},
 								{"mDataProp":"edit"},
     	                    ],
     				 "aLengthMenu":[[50,100,500, -1],[50,100,500, "All"]],
     					"iDisplayLength": 100,
                 
     	    }); 
        	}
        	
        	
        	 function editorder(OrderStageMasterId){
        		
	 			window.location="../../view/orderstage/OrderStageViewAction.do?OrderStageMasterId="+OrderStageMasterId;
													};	
        	 
        	
          $(document).ready(function() {
        	//  alert("hi");       
        	  getList();
        	
                   	
        	});    
          $("#filterBTN").click(function(event){
            	
          //	$("#example_length").hide();
          } );   
</script> 