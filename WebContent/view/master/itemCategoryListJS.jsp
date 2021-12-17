		  <script type="text/javascript">
									        	function back(){
									        		 window.location = '../mainscmview/index.jsp';
									        	}
									 
									 			function getList(){
									 					//alert("jjjj");
									 					var oTable = $('#example').dataTable();
									 					var orderStatus=$('#orderStatus').val();
									 	          	    if(oTable!=null) oTable.fnDestroy();
									 					 
									             		
									        	  		$('#example').dataTable({
									        		    "sAjaxSource" : "../../rest/masterDataMgmtService/getItemCategoryListByFilter?orderStatus="+orderStatus,
									        	        "bProcessing": true,
									        	      	 "aoColumns":[
									        	             {"mDataProp":"CategoryId"},
									        				{"mDataProp":"CategoryName"},
									        				{"mDataProp":"SuperCategoryName"},
									        				{"mDataProp":"CreatedOn"},
									        				{"mDataProp":"status"},
									        				{"mDataProp":"edit"}, 
									        				],
									        				 "aLengthMenu":[[50,100,500, -1],[50,100,500, "All"]],
									        					"iDisplayLength": 100,
									                    
									        	    } );

         	 										function editorder(ItemCategoryMasterId){
 	 												window.location="../../view/itemcategories/ItemCategoryViewAction.do?itemCategoryId="+ItemCategoryMasterId;
 													};	
 													
 													
 													
 													
 													
 													
 													function deleteOrder(ItemCategoryMasterId){
 													//	alert("hiii");
 										        		var obj=new Object();
 										         	  	obj.ItemCategoryMasterId = ItemCategoryMasterId;
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
 										        	
        	
        	/* $(".selectFilter").show();      	 
      	    $(".itemCategoryId").show();
      	    $(".company").show();
      	    
      	    
      	    $("#filter  option[value='supplierId']").remove();
      	    $("#filter  option[value='date']").remove();
      	    $("#filter  option[value='itemIds']").remove();
      	    $("#filter  option[value='itemCategoryId']").remove();
      	 */
      	   /*  $("#createItemCat").click(function(){
      	  	window.location.href = "../itemcategories/ItemCategoryViewAction.do?createItemCategoryStatus=false";
      	  });
      	 */
  }; 
	
	
          
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
      	  
      	    $(".itemCategoryId").show();
      	    $(".company").show();
      	    $(".orderStatus").show();
      	    
      	    
      	    $("#filter  option[value='supplierId']").remove();
      	    $("#filter  option[value='date']").remove();
      	    $("#filter  option[value='itemIds']").remove();
      	    $("#filter  option[value='itemCategoryId']").remove();
      	
      	    $("#createItemCat").click(function(){
      	  	window.location.href = "../itemcategories/ItemCategoryViewAction.do?createItemCategoryStatus=false";
      	  });
      	    
        	});    
          $("#filterBTN").click(function(event){
         	getList();
          });  
          
</script> 