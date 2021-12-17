  <script type="text/javascript">
         /*  $('#example tbody tr').live( 'click', function (event) {
        	    var measurementId = $(this).find("td:first").html(); 
        	    window.location="../measurement/MeasurementViewAction.do?measurementId="+measurementId;
        	});
         */
        	function back(){
        		 window.location = '../mainscmview/index.jsp';
        	}
          

			function deleteOrder(measurementId){
				
     		var obj=new Object();
      	  	obj.measurementId = measurementId;
      	  	var str = JSON.stringify(obj);
      	  	//alert(str);
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
 
     									function editorder(measurementId){
     										window.location="../measurement/MeasurementViewAction.do?measurementId="+measurementId;
								  								};	
 
 
								  function getList()
						        	{
						        		var oTable = $('#example').dataTable();
						 	         	if(oTable!=null) oTable.fnDestroy();
						 	          	//alert("qwwe");
						 	         	$('#example').dataTable({
						        		    "sAjaxSource" : "../../rest/masterDataMgmtService/getMeasurementListByFilter?itemCategoryId",
						        	        "bProcessing": true,
						        	      	 "aoColumns":[
						       	      	            {"mDataProp":"id"},
						                        	{"mDataProp":"unit"},
						                        	{"mDataProp":"name"},
						                        	{"mDataProp":"symbol"},
						                        	{"mDataProp":"CreatedDate"},
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
        		var itemCategoryId=$('#itemCategoryId').val();
             	var companyId=$('#companyId').val();
        	  
        	//  $("#example_length").hide();
        	// $.uniform.update();
        	$(".selectFilter").show();
      	  //  $(".date").show();
      	   // $(".itemCategoryId").show();
      	   // $(".company").show();
      	    
      	    
      	    $("#filter  option[value='supplierId']").remove();
      	    $("#filter  option[value='date']").remove();
      	    $("#filter  option[value='itemIds']").remove();
      	    $("#filter  option[value='itemCategoryId']").remove();
      	
      	    $("#createItemCat").click(function(){
      	  	window.location.href = "../measurement/MeasurementViewAction.do?createItemCategoryStatus=false";
      	  });
      	    
        	} );    
          $("#filterBTN").click(function(event){
         	var oTable = $('#example').dataTable();
         	var itemCategoryId=$('#itemCategoryId').val();
         	var companyId=$('#companyId').val();
         	// var fromDate=$('#datepicker2').val();
          	// var toDate=$('#datepicker1').val();
          	 
          	if(oTable!=null) oTable.fnDestroy();
          	 $('#example').dataTable({
                   "sAjaxSource" : "../../rest/masterDataMgmtService/getMeasurementListByFilter?itemCategoryId="+itemCategoryId+"&companyId="+companyId,
                   "bProcessing": true,
                 	 "aoColumns":[
                 	    {"mDataProp":"id"},
                 		{"mDataProp":"unit"},
                 		{"mDataProp":"name"},
                 		{"mDataProp":"symbol"},
                 		{"mDataProp":"CreatedDate"},
                       ],
                       "aLengthMenu":[[50,100,500, -1],[50,100,500, "All"]],
       				"iDisplayLength": 100,
                       "oLanguage": {
                           "sSearch": "Search all columns:"
                        },
               });
         // 	$("#example_length").hide();
          } );   
</script> 