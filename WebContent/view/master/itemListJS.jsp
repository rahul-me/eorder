 <script type="text/javascript">
 
 function updateStock(identifier)
 {	 
	 var updateValue = $("#addStock"+identifier).val();	 
	 var obj = new Object();
	 obj.itemMasterId = identifier;
	 obj.updateValue = updateValue;
	 var str = JSON.stringify(obj);
	 $.ajax({
		 url        : "../../rest/preastaWebService/updateStock",
		 type		: "POST",
		 contentType: "application/json; charset=utf-8",
		 data		: str,
		 success	: function(data)
		 {
			 var v = $("#stock"+identifier).text();
			 var val = (parseFloat(updateValue)+parseFloat(v));
			 $("#stock"+identifier).html(val);
			 $("#addStock"+identifier).val("");
		 }
	 		
	 });
 }
        										function back(){
        												window.location = '../mainscmview/index.jsp';
        																}
 
 
 													function editorder(itemId){
	 													window.location="../item/ItemViewAction.do?itemId="+itemId;
															};	
															
													function deleteOrder(itemId){
										        		var obj=new Object();
										         	  	obj.itemId = itemId;
										         	  	var str = JSON.stringify(obj);										         	  
										         	  	$.ajax({
										         	  	    url: "../../rest/preastaWebService/inActiveRecord"
										         	  	    , type: "POST"
										         	  	    , contentType: 'application/json; charset=utf-8'
										         	  	    , dataType: 'json'
										         	  	    , data: str
										         	  	    , success: function (data) {
										         	  	    	var itemId=null;
										         	  	    	getList(itemId);
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
										        	
										        	function getList(itemId)
										        	{
										        		var oTable = $('#example').dataTable();
										 	          	if(oTable!=null) oTable.fnDestroy();
										 	          	var itemid=itemId;
										 	          	var orderStatus=$('#orderStatus').val();
										 	       
										 	           $('#example').dataTable({
										 	    		    "sAjaxSource" : "../../rest/masterDataMgmtService/getItemListByFilter?itemId="+itemid+"&orderStatus="+orderStatus,
										 	    	        "bProcessing": true,
										 	    	        "aoColumns":[
										 									{"mDataProp":"itemMasterId"},
										 									{"mDataProp":"name"},								
										 									{"mDataProp":"itemPrice","mRender": function ( data, type, full ) {return data.toFixed(2);}},
										 									{"mDataProp":"availableQ"},
										 									{"mDataProp":"addStock"},
										 									{"mDataProp":"createdBy"},
										 									{"mDataProp":"createdDTTM"},
										 									{"mDataProp":"status"},
										 									{"mDataProp":"edit"}
										 									
										 	    	                    ],
										 	    				 "aLengthMenu":[[50,100,500, -1],[50,100,500, "All"]],
										 	    					"iDisplayLength": 100,
										 	                
										 	    	    });
										 	            
										       	 
										        	}
													
 
 
 
 
          
          $(document).ready(function() {
        	
        	  $(".sidebar").removeClass("active");
        		 $("#mdm").addClass("active open");
        		 $("#mdm").append('<span class="selected"></span><span class="arrow open"></span>');
        		        	 
        	 	var a = $('#error').text();
        	 	//alert(a);
        	 	if (a == "") {
        	 	} else {
        	 		
        	 	}

        	    $(".selectFilter").show();
        	    
        	    $("#filter  option[value='supplierId']").remove();
        	    $("#filter  option[value='date']").remove();
        	    
        	    
        		
        	    
        	    
        	 //$(".itemIds").show();
        	 $(".orderStatus").show();
     		
        	    
     		var itemId=$('#itemId').val();     		
      		getList(itemId);  
        	
        	
        	  $("#createItem").click(function(){
            	  	window.location.href = "../item/ItemViewAction.do";
            	  });
        		
        	});
          
          $("#filterBTN").click(function(event){
            	var oTable = $('#example').dataTable();
            	if(oTable!=null) oTable.fnDestroy();
          		var itemId=$('#itemId').val();
          		
          	          	 getList(itemId);
          
          
          } );   
</script> 