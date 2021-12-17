<script type="text/javascript">
 
 $
 
 $("#exportSheet").on("click",function(){
	 
	 var count=0;
	 var orderIdsForDataDisplay=[];
	 var exportflag = false;
	 $("input[name='pushforexport']").each(function()
			 {
		 		if($(this).is(':checked'))
		 			{
		 			exportflag = true;
		 			orderIdsForDataDisplay.push($(this).val());
		 			count++;
		 			}
			 });
	
	 if(exportflag == true){
		 var obj=new Object();
		 obj.orderIdsForDataDisplay=orderIdsForDataDisplay;
		 var str=JSON.stringify(obj);
		 window.location='../../rest/preastaWebService/makeExcelNew?str='+str;
		 /* $.ajax({
			 url: '../../rest/preastaWebService/makeExcelNewS',
			 type: 'POST',
			 data: str,
			 contentType: 'application/json',
			 dataType: 'json',
			 success: function(response){
				 console.log(response);
			 }
		 }); */
		 //window.location="../../view/order/exportOrderList.do?orderIdsForDataDisplay="+orderIdsForDataDisplay+"&str="+str
	 }
	 
 });
 
 var isOrderEdit=0;
 function deleteOrder(ordermasId){
	 
	 if(confirm("Are You Sure") == true)
		 {
		 		 
		var obj=new Object();
	  	obj.ordermasId = ordermasId;
	  	var str = JSON.stringify(obj);
	  	//alert(str);
	  	$.ajax({
	  	    url: "../../rest/preastaWebService/inActiveRecord"
	  	    , type: "POST"
	  	    , contentType: 'application/json; charset=utf-8'
	  	    , dataType: 'json'
	  	    , data: str
	  	    , success: function (data) {
	  	    	/* bootbox.confirm("Are you sure?", function(ordermasId) {
	  			  Example.show("Confirm result: "+ordermasId);
	  			}); */
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
 		}
	 else
		 {
		 alert("You have pressed cancel");
		 }
	};
 	 
 	function editorder(ordermasid){
		
		window.location="../../view/order/orderMasterViewAction.do?orderMasterId="+ordermasid
 	 };	
 	
    $(document).ready(function() {
    	
    	
    	/* $("#filterDisp").removeClass("collapse");
        $("#filterDisp").addClass("expand");
        $("#filterBody").removeAttr("style","display: block;");
        $("#filterBody").css("display","none"); */
        
    	
    	$(".sidebar").removeClass("active");
		 $("#order").addClass("active open");
		 $("#order").append('<span class="selected"></span><span class="arrow open"></span>');
	
    	
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

    	$("#createStockTake").click(function(){
    	  	window.location.href = "../stock/StockTakeMasterViewAction.do";
    	  });
    	
    	$("#select-all").click(function(){
   		   if ($('#select-all').is(':checked')) {
				   
			    	 $("#example input[type='checkbox']").prop('checked', true);
			    } 
			   else 
			   {
				   $("#example input[type='checkbox']").prop('checked', false);
			    }
			  
		   });
   	 
    	  $("#filterBTN").click(function(event){
    	 		getList(); 	  
    	 	});
    	  
	    $("#printOrder").click(function(){
			
	    	var checkedprinter=document.getElementsByName("printer");
       		var table = document.getElementById("example");
     		var tableRows = table.rows.length;
     		
     		
     		 $('#example tbody tr').each(function(){
         		//we simply have to copy the balance qty
         		//alert('mm');
         		if($(this).find('input[type="checkbox"]').is(":checked")==true)
         		{
   				 var orderNumber=$(this).find("td").html();
   					//alert("Order Number is  "+orderNumber);
   				  for(var i=0; i<checkedprinter.length;i++){
   				 if(checkedprinter[i].checked){
       				 getOrderingPrintServices(orderNumber,checkedprinter[i].value);       			
       				 }
         		} 
   			}
         	}); 
      		
	    });
    	
    	getList();
    	
   	 $(".AddFilter").hide();
     $(".selectFilter").show();
     $(".area").show();
     $(".orderMasterId").show();
     $(".date").show();
     
     $(".orderStageId").show();
  //   $(".stockType").show();

     $("#filter  option[value='siteId']").remove();
     $("#filter  option[value='supplierId']").remove();
     $("#filter  option[value='date']").remove();
     
    });
     
    function getList(){
    	
    	var orderStageId= $('#orderStageId').val();
  	  var oTable = $('#example').dataTable();
  	  	var orderMasterId=$('#orderMasterId').val();
  	  	 var fromDate=$('#datepicker2').val();
  	  	// alert(fromDate);
  	  	var areaMasterId=$('#areaMasterId').val();
  	  	 var toDate=$('#datepicker1').val();
  	  //alert(stockType);
  	  	// alert(toDate);
  	  	if(oTable!=null) oTable.fnDestroy();
  	  	$('#example').dataTable( {
  		    "sAjaxSource" : "../../rest/preastaWebService/getOrderListByFilter?orderMasterId="+orderMasterId+"&fromDate="+fromDate+"&toDate="+toDate+"&orderStageId="+orderStageId,
  	        "bProcessing": true,
  	        "aoColumns":[
  							{"mDataProp":"orderType"},
  							{"mDataProp":"CreatedDate"},
  							{"mDataProp":"orderAmount"},
  	                 	    {"mDataProp":"customerName"},                 	                    		
  	                 		{"mDataProp":"orderStage"}, 
  	                 		{"mDataProp":"createdDTTM"}, 
  	                 		{"mDataProp":"view"},
  	                 		{"mDataProp":"edit"},
  	                 		{"mDataProp":"pushforexport"}
  	                 		
  	                    ],
  				 "aLengthMenu":[[50,100,500, -1],[50,100,500, "All"]],
  					"iDisplayLength": 100,
  	        
  	    } );
  }
 
  
 function getorder(orderNumber,customerMasId){
 		
 		 $('#invoiceTbody').children().remove();
 		
 		var obj=new Object();
 	  	obj.orderNumber = orderNumber;
 	  	var str = JSON.stringify(obj);
 	  	//alert(str);
 	  	//alert(outletId);
 	  	$.ajax({
 	  	    url: "../../rest/preastaWebService/getOrderDetailsByOrderMasterId"
 	  	    , type: "POST"
 	  	    , contentType: 'application/json; charset=utf-8'
 	  	    , dataType: 'json'
 	  	    , data: str
 	  	    , success: function (data) {
 	  	    	
 	  	    	var str = JSON.stringify(data);
 	  	   		//alert(str);
 	  	    	var j = 1;	
 	     			$.each(data, function(i,item){
 	     				
 	     				var itemId = item["itemMasterId"];
 	     				var itemName = item["itemName"]
 	     				var measurementId = item["itemMeasurementId"];
 	     				var measurementName = item["itemMeasurementName"];
 	     				var quantity = item["quantity"];
 	     				var rate = item["rate"].toFixed(2);
 	     				var amount = item["amount"].toFixed(2);
 	     				var dispatchedQuantity = item["dispatchedQuantity"]
 	     				$("#Itemsverified").append();
 	     				$("#invoiceTbody").append('<tr><td>'+j+'</td><td>'+itemName+'</td><td>'+quantity+'</td><td>'+dispatchedQuantity+'</td><td>'+rate+'</td><td>'+amount+'</td></tr>');
 	     				j++;
 	    			});
 	  	    }
 	  	}); 
  		
 			//var customerMasId=$("#customerMasterId").val();
 		 	var obj=new Object();
 		  	obj.customerMasId = customerMasId;
 		  	var str = JSON.stringify(obj);
 		  	
 			$.ajax({
 		  	    url: "../../rest/preastaWebService/getCustomerDetails?customerId="+customerMasId+"&orderNumber="+orderNumber,
 		  	    type: "POST"
 		  	    , contentType: 'application/json; charset=utf-8'
 		  	    , dataType: 'json'
 		  	    , data: str
 		  	    , success: function (data) {
 		  	    	
 		  			var contactNumber = data["contactNumber"];
 		  			var address = data["address"];
 		  			var firstName = data["firstName"];
 		  			var village = data["village"];
 		  			var landmark = data["landmark"];
 		  			var taluka = data["taluka"];
 		  			var distric = data["distric"];
 		  			var email = data["email"];
 		  			var pin = data["pin"];					
 		  			$("#firstname").text(firstName);
 		  			$("#mobileno").text(contactNumber);
 		  			$("#landmark").text(landmark);
 		  			$("#village").text(village);
 		  			$("#email").text(email);
 		  			
 		  			var res = address.split(",");
 		  			 var lp=Math.round((res.length)/2);
 		  			 var newct=0;
 		  			$('#address').children().remove();
 		  			  $("#address").append('<li><strong><u>Address :</u></strong></li>');/*
 		  			 for(var i=0;i<lp;i++){
							
 		  				$("#address").append('<li>'+res[newct]+','+res[++newct]+'</li>');
 		  				++newct;
 		  			 }
 		  			 $("#address").append('<li>Pin '+pin+'</li>'); */
 		  			$('#address').append('<li>'+address+'</li>'); 
 		  	    }
 			});
 			
 			$('.NEWtotal-amt').hide();
 			$('.NEWremark').hide();
 			$('#createOrder').hide(); 
  			$('#stack1').modal('show');
 	};
 	 
    function getOrderingPrintServices(data,printerType) {
  		var obj = new Object();
  		
  		obj.orderNumber = data;
  		obj.printerType=printerType;
  		var statusPrint='purchaseOrderPrint';
		obj.statusPrint=statusPrint;  
  		//alert(printerType);
  		var str = JSON.stringify(obj);
  		//var str=$.toJSON(obj);
  		//alert(str);
  		//(str);
  		$.ajax({
  			url : "../../rest/SmartPrintServices/orderingPrintservice", 
  			type : "POST",
  			contentType : 'application/json; charset=utf-8',
  			dataType : 'json',
  			data : str,
  			success : function(data) {
  		
  			//alert('working');	
  		    var printData=data["printData"];
  		    //alert(printData);
    		/* document.jZebra.append(printData);
   	   			document.jZebra.findPrinter();
   	   			document.jZebra.appendHTML(printData); */
   	   		var popup = window.open('','' ,"menubar=0,location=0,height=500,width=800");
   	   		if(printerType==1) {
   			//	alert('inside Printer Type');
		
			  popup.document.write(printData);
			  popup.print(); 
			
   			}
   			else{
   			  popup.document.write(printData);
			  popup.print(); 	
   	      }
  		    
   		/* 	document.jZebra.append(printData);
   			document.jZebra.findPrinter();
   			document.jZebra.appendHTML(printData);  */
   			
  			}	
  			
  		});

    }
    
    
    function confirm_box(obj)
	    {
	    //alert("test");	
    	// destroy all default event 
	    	
	    	$.fn.dialog2.helpers.confirm("Do You Want to Delete Stock Take ?  Continue For Yes..!!",
	      			 { 
	          		confirm: function() {
	          			//if true redirect to link
	          			window.location.href = obj.href; 
	          			}, 
	          		decline: function() {
	          			//if false then do nothing
	          			return false; }
	          		
	            });
	    	
	    	event.preventDefault();
	    }
</script> 