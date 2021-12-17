 <script type="text/javascript">
 
function checkValue(orderQuantity, dispatchQuantity, index, unitCostEditable)
{
	
	var desiredDispatchQuantity=$("#dispatchQuantityid"+index).val();
	//alert(desiredDispatchQuantity);
	
	if(parseFloat(desiredDispatchQuantity) > (parseFloat(orderQuantity)-parseFloat(dispatchQuantity)))
		{
		alert("Your entered quantity is greater than remaining quantity");
		$("#dispatchQuantityid"+index).val("");
		return false;
		}
	
	var reg = new RegExp('^[0-9]+(\.[0-9]{1,2})?|[0-9]+(\.)$');
	var res=reg.test(desiredDispatchQuantity);
	//alert('----'+reg.test(desiredDispatchQuantity));
	if(res==false)
		{
		if($("#dispatchQuantityid"+index).val()=="")
			{
				
			}
		else
			{
			alert('Enter only number value');
			$("#dispatchQuantityid"+index).val("");
			}
		
		}
	
	if(unitCostEditable == 1){
		var editableRate = $('#editableRate'+index).val();
		var resEditableRate = reg.test(editableRate);
		if(resEditableRate == true && res == true){
			var totamount = parseFloat(editableRate) * parseFloat(desiredDispatchQuantity); 
		   	$('#editedAmount'+index).val(totamount);	   
		}else{
		    $('#editedAmount'+index).val(0.00);
		}
	}
}
	
	$('#btnForDownload').on('click', function(){
		$.ajax({
			 url:"../../rest/preastaWebService/getFileForMe",
			 type:"GET",
			 contentType: 'application/json; charset=utf-8',			 			 
			 success: function (data){
				 var mdata = data;
			 }
		 });
	});
	
 $("#btnInvoiceSave").on("click",function(){
	 
	 var orderDetailIds=[];
	 var dispatchQuantityValues=[];
	 var editableRates=[];
	 $("input[name='dispatchQuantity']").each(function(){
		 dispatchQuantityValues.push($(this).val());
	 });
	 $("input[name='editableRate']").each(function(){
		 editableRates.push($(this).val());
	 });
	 $("label[name='lebelOrderId']").each(function(){
		orderDetailIds.push($(this).attr("id"));
	 });
	 var lrno = $('#lrno').val();
	 //alert('ids-'+orderDetailIds+' : Quantities-'+dispatchQuantityValues);
	 
	 var obj = new Object();
	 obj.orderDetailIds=orderDetailIds;
	 obj.dispatchQuantityValues=dispatchQuantityValues;
	 obj.editableRates = editableRates;
	 obj.lrno = lrno;
	 var str=JSON.stringify(obj);
	 
	 $.ajax({
		 url:"../../rest/preastaWebService/makeUpdateDispatchValues",
		 type:"POST",
		 contentType: 'application/json; charset=utf-8',
		 dataType: 'json',
		 data: str, 
		 success: function (data){
			 
			 var resultString=data["result"];
			 //alert(resultString);
			 if(resultString=="done")
				 {
				 window.location="../../order/companyInvoice/invoicePdf.do?invoicePdf=true&data="+str;
				 //window.location="../../view/po/filterViewAction.do?orderManagementList=true";
				 }
			 else
				 {
				 
				 }
			 
			 window.location="../../view/po/filterViewAction.do?orderManagementList=true";
			 
		 }
	 });	
 });


 
 
 	/* function editorder(orderNumber,customerMasId){
 		$("#customerMasterId").val(customerMasId).change();
 		$('input[name=active][value=1]').prop('checked',true);
 		$("#orderNumber").val(orderNumber).change();
 		$(".disp1").show();
 		$("#stateId").focus();
 		
 		//active
 		
 	}; */
 	
 	
 	function getorder(orderNumber,customerMasId){
 		
 		 $('#invoiceTbody').children().remove();
  		var obj=new Object();
  	  	obj.orderNumber = orderNumber;
  	  	var str = JSON.stringify(obj);
  	  	var ordernumber;
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
  	  	   		/* alert(str); */
  	  	    	var j = 1;	
  	     			$.each(data, function(i,item){
  	     				/* alert(i);
  	     				alert(item); */
  	     				var unitCostEditable = item['unitCostEditable'];
  	     				var availableStock = item["availableStock"].toFixed(2);
  	     				var itemId = item["itemMasterId"];
  	     				var itemName= item["itemName"];
  	     				var measurementId = item["itemMeasurementId"];
  	     				var measurementName = item["itemMeasurementName"];
  	     				var quantity = item["quantity"].toFixed(2);
  	     				var rate = item["rate"].toFixed(2);
  	     				var amount = item["amount"].toFixed(2);
  	     				var dispatchedquantity=item["dispatchedQuantity"].toFixed(2);
  	     				var dispatchere=item["dispatchere"];
  	     				ordernumber=item["orderNumber"];
  	     				var orderId=item["orderId"];
  	     				var editFlag;
  	     				if(unitCostEditable == 'yes'){
  	     					editFlag = 1;
  	     				}else{
  	     					editFlag = 0;
  	     				} 
  	     				
  	     				$("#Itemsverified").append();
  	     				/* $("#invoiceTbody").append('<tr><td>'+j+'</td><td>'+itemName+'</td><td>'+quantity+'</td><td>'+dispatchedquantity+'</td><td><input type="text" name="dispatchere"/></td><td>'+rate+'</td><td>'+amount+'</td></tr>'); */
  	     				//$("#invoiceTbody").append('<tr><td>'+j+'</td><td>'+orderId+'</td><td>'+itemName+'</td><td>'+quantity+'</td><td>'+dispatchedquantity+'</td><td><div class="input-inline input-medium"><div class="input-group bootstrap-touchspin"><span class="input-group-addon bootstrap-touchspin-prefix">Q</span><input name="dispatchQuantity" type="text" class="form-control" style="display: block;"><span class="input-group-addon bootstrap-touchspin-postfix" style="display: none;"></span></div></div></td><td>'+rate+'</td><td>'+amount+'</td></tr>');
  	     				if(unitCostEditable == 'yes'){
  	     					$("#invoiceTbody").append('<tr><td>'+j+'</td><td><label id="'+orderId+'" name="lebelOrderId">'+orderId+'</label></td><td>'+itemName+'</td><td>'+quantity+'</td><td>'+availableStock+'</td><td>'+dispatchedquantity+'</td><td><div class="input-inline input-medium"><div class="input-group bootstrap-touchspin"><span class="input-group-addon bootstrap-touchspin-prefix">Q</span><input id="dispatchQuantityid'+j+'" name="dispatchQuantity" type="text" onkeyup="checkValue('+quantity+','+dispatchedquantity+','+j+','+editFlag+')" class="form-control" style="display: block;"><span class="input-group-addon bootstrap-touchspin-postfix" style="display: none;"></span></div></div></td><td><input id="editableRate'+j+'" name="editableRate" value="'+rate+'" type="text" onkeyup="calculateTotal('+quantity+','+j+')" class="form-control" style="display: block;"></td><td><input id="editedAmount'+j+'" readonly="" name="editedAmount" value="'+amount+'" type="text" class="form-control" style="display: block;"></td></tr>');	
  	     				}else{
  	     					$("#invoiceTbody").append('<tr><td>'+j+'</td><td><label id="'+orderId+'" name="lebelOrderId">'+orderId+'</label></td><td>'+itemName+'</td><td>'+quantity+'</td><td>'+availableStock+'</td><td>'+dispatchedquantity+'</td><td><div class="input-inline input-medium"><div class="input-group bootstrap-touchspin"><span class="input-group-addon bootstrap-touchspin-prefix">Q</span><input id="dispatchQuantityid'+j+'" name="dispatchQuantity" type="text" onkeyup="checkValue('+quantity+','+dispatchedquantity+','+j+','+editFlag+')" class="form-control" style="display: block;"><span class="input-group-addon bootstrap-touchspin-postfix" style="display: none;"></span></div></div></td><td>'+rate+'</td><td>'+amount+'</td></tr>');		
  	     				}
  	     				
  	     				
  	     				
  	     				j++;
  	    			});
  	  	    }
  	  	});
  	  	
  	  	
  		
  		/* $("#NEWtotal-amt").text($("#total-amt").val());
  		$("#NEWremark").text($("#remark").val()); */
  		
 			 
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
 		  			var ordernumber=data["ordernumber"];

 		  			$("#firstname").text(firstName);
 		  			$("#mobileno").text(contactNumber);
 		  			$("#landmark").text(landmark);
 		  			$("#village").text(village);
 		  			$("#email").text(email);
 		  			/* $("#NEWcontactNumber1").val(contactNumber);
 		  			$("#NEWaddress1").val(address);
 		  			$("#NEWFirstName").val(firstName);
 		  			 */
 		  			var res = address.split(",");
 		  			 var lp=Math.round((res.length)/2);
 		  			 var newct=0;
 		  			 
 		  			 $('#ordernumber').children().remove();
 		  			 $("#ordernumber").append('<li><strong><u>Order Number:</u></strong></liadress>');
 		  			 $("#ordernumber").append('<li><label id="labelOrderNumber">'+ordernumber+'</label>')
 		  			 
 		  			 $('#address').children().remove();
 		  			 $("#address").append('<li><strong><u>Address :</u></strong></li>');
 		  			 for(var i=0;i<lp;i++){
							
 		  				$("#address").append('<li>'+res[newct]+'</li>'/* ,'+res[++newct]+'</li>' */);
 		  				++newct;
 		  			 }
 		  			 /* $("#address").append('<li>Pin '+pin+'</li>'); */
 		  	    }
 			});
 			
 			$('.NEWtotal-amt').hide();
 			$('.NEWremark').hide();
 			$('#createOrder').hide();
  			$('#stack1').modal('show');
 	}
 	
 	stuff = {}; // Object

 	
 	
 	function changeState(orderNo,value)
 	{
 		
 		stuff[orderNo] = value;
 		/* var obj=new Object();
 		obj.OrderNo=orderNo;
 		obj.value=value;
 		var str = JSON.stringify(obj);
 		alert(str);
 		$.ajax({
 	  	    url: "../../rest/preastaWebService/updateOrderStatus"
 	  	    , type: "POST"
 	  	    , contentType: 'application/json; charset=utf-8'
 	 	  	, dataType: 'json'
 	 	  	, data: str
 	  	    , success: function (data) {
 	  	    	var str = JSON.stringify(data);
 	  	    	alert(str);
 	  	    }
 	  	}); */
 		
 		//refreshTable();
		} 
 		 /* if(value==5||value==6){
 			
             $('#rowOrderId').val(orderNo);
             $('#rowStatusId').val(value);
 			$('#basic11').modal('show');
 		} *//* else{		
 	} */
 	function editOrder()
 	{
 		
 		var str = JSON.stringify(stuff);
 		//alert(str);
 		$
		.ajax({
			url: "../../rest/preastaWebService/updateOrderStatus",
			type : "POST",
			contentType : 'application/json; charset=utf-8',
			dataType : 'json',
			data : str,
			async : false,
			success : function(data) {
				var result=data["result"];
				//alert('hello '+result);
				
				if(result=="done" || result=="validaction")
					{
				Command: toastr['success']("Order List Successfully Updated")
					toastr.options = {
						"closeButton": true,
						  "debug": false,
						  "positionClass": "toast-bottom-full-width",
						  "onclick": null,
						  "showDuration": "1000",
						  "hideDuration": "1000",
						  "timeOut": "15000",
						  "extendedTimeOut": "1000",
						  "showEasing": "swing",
						  "hideEasing": "linear",
						  "showMethod": "fadeIn",
						  "hideMethod": "fadeOut"
						  }
			              window.location="../../view/po/filterViewAction.do?orderManagementList=true";
					}
				if(result=="invalidaction")
					{
					//alert("In order to make your order status delivered, you must have your delivery status 100 percentage");
					Command: toastr['success']("Your action can't be updated because in order to make your order status delivered, you must have your delivery status 100 percentage");
					toastr.options = {
						"closeButton": true,
						  "debug": false,						  
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
 	
    $(document).ready(function() {
    	
    	
    	
    	$("#editOrder").on("click", function(e) {
    		var r = confirm("Are U Sure!");
    		var txt;
    		if (r == true) {
    			editOrder();
    		} else {
    			txt = "You pressed Cancel!";
    		}
    		
    		
    	});
    	
    	
    	/* $("#filterDisp").removeClass("collapse");
        $("#filterDisp").addClass("expand");
        $("#filterBody").removeAttr("style","display: block;");
        $("#filterBody").css("display","none"); */
        $("#basic11").on("show", function() {    // wire up the OK button to dismiss the modal when shown
                $("#saveRemark").on("click", function(e) {
                    var remark=$("#remark").val();   // just as an example...
                    var orderNo=$('#rowOrderId').val();
                    var value=$('#rowStatusId').val();
                    $.ajax({
        	 	  	    url: "../../rest/preastaWebService/updateOrderStatus?orderMasterId="+orderNo+"&state="+value+"&remark="+remark
        	 	  	    , type: "POST"
        	 	  	    , contentType: 'application/json; charset=utf-8'
        	 	  	    , dataType: 'json'
        	 	  	    , success: function (data) {
        	 	  	    }
        	 	  	});
                    $("#basic11").modal('hide');     // dismiss the dialog
                });
            });
        
    	
     	$(".sidebar").removeClass("active");
		 $("#ordermanage").addClass("active open");
		 $("#ordermanage").append('<span class="selected"></span><span class="arrow open"></span>'); 
	
    	
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
   	 
	    $("#export").click(function(){
      		 if($("#example input[type='checkbox']").is(":checked")==true)
      			{
  			 		//alert('ClickStockTake Export');
      			 $("#StockTakeFormList").submit();
  			 	}else
  			 		{
  			 		
  			 		Command: toastr['error']("Please Mark Stock Take to Export")
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
  			 	return false;
  			 		} 
  			 		
      		
	    });
    	
    	
    	 var fromDate=$('#datepicker2').val();
    	  	 var toDate=$('#datepicker1').val();
    	  	var orderMasterId=$('#orderMasterId').val();
    	  	//alert('g');
    	    $('#example').dataTable( {
    		    "sAjaxSource" : "../../rest/preastaWebService/getOrderListByFilter?orderMasterId="+orderMasterId+"&fromDate="+fromDate+"&toDate="+toDate,
    	        "bProcessing": true,
    	        "aoColumns":[
								{"mDataProp":"orderType"},
								{"mDataProp":"CreatedDate"},
								{"mDataProp":"status"},
								{"mDataProp":"quantityToDispatch"},
								{"mDataProp":"dispatchedQuantity"},
								{"mDataProp":"deliveryStatus"},								
								{"mDataProp":"createdBy"},
								{"mDataProp":"LastStatus"},
								{"mDataProp":"UpdatedBy"},
								{"mDataProp":"UpdatedDTTM"},
								 {"mDataProp":"view"},
								 
								 
    	                    ],
    				 "aLengthMenu":[[50,100,500, -1],[50,100,500, "All"]],
    					"iDisplayLength": 100,
    					/* "fnInitComplete": function () {
    						alert('fd');
    					     $('#stateId1').removeAttr('disabled');    
    					} */
                
    	    } );
    	  	
  
    	    
   	 $(".AddFilter").hide();
     $(".selectFilter").show();
     $(".orderMasterId").show();
     $(".date").show();
     $(".orderStageId").show();
     
  //   $(".stockType").show();

     $("#filter  option[value='siteId']").remove();
     $("#filter  option[value='supplierId']").remove();
     $("#filter  option[value='date']").remove();
     
     
     
    } );  
    
    $("#isDisable1").click(function(event){
    	 if ($('#isDisable1').is(':checked')) {
    		 $('.statusVal').removeAttr('disabled');
	    } 
	   else 
	   {
		   $('.statusVal').attr("disabled","true");
	    }
	  
	});
    
    $("#filterBTN").click(function(event){
  	  
    	refreshTable();
    	
  } );
    
    function refreshTable(){
    	
    	var orderStageId= $('#orderStageId').val();    	
    	 var oTable = $('#example').dataTable();
    	  	var orderMasterId=$('#orderMasterId').val();
    	  	 var fromDate=$('#datepicker2').val();
    	  	// alert(fromDate);
    	  	 var toDate=$('#datepicker1').val();
    	  //alert(stockType);
    	  	// alert(toDate);
    	  	//alert(siteId);
    	  	if(oTable!=null) oTable.fnDestroy();
    	  	$('#example').dataTable( {
    		    "sAjaxSource" : "../../rest/preastaWebService/getOrderListByFilter?orderMasterId="+orderMasterId+"&fromDate="+fromDate+"&toDate="+toDate+"&orderStageId="+orderStageId,
    	        "bProcessing": true,
    	        "aoColumns":[
								{"mDataProp":"orderType"},
								{"mDataProp":"CreatedDate"},
								{"mDataProp":"status"},
								{"mDataProp":"quantityToDispatch"},
								{"mDataProp":"dispatchedQuantity"},
								{"mDataProp":"deliveryStatus"},								
								{"mDataProp":"createdBy"},
								{"mDataProp":"LastStatus"},
								{"mDataProp":"UpdatedBy"},
								{"mDataProp":"UpdatedDTTM"},
 								{"mDataProp":"view"},
    	                    ],
    				 "aLengthMenu":[[50,100,500, -1],[50,100,500, "All"]],
    					"iDisplayLength": 100,
    					"fnInitComplete": function () {
    						if ($('#isDisable1').is(':checked')) {
    			       		 	$('.statusVal').removeAttr('disabled');
    			   	    	} 
    			   	   		else 
    			   	   		{
    			   		   		$('.statusVal').attr("disabled","true");
    			   	    	}    
    					}
    	        
    	    } );
    	  
    }
    
   function calculateTotal(quantity, index){
	   var editableRate = $('#editableRate'+index).val();	   	   
	   var dispatchQuantity = $('#dispatchQuantityid'+index).val();
	   
	   var reg = new RegExp('^[0-9]+(\.[0-9]{1,2})?|[0-9]+(\.)$');
	   var resEditableRate = reg.test(editableRate);
	   var resDispatchQuantity = reg.test(dispatchQuantity);
	   
	   if(resEditableRate == true && resDispatchQuantity== true){
		   var totamount = parseFloat(editableRate) * parseFloat(dispatchQuantity); 
		   $('#editedAmount'+index).val(totamount);
	   }else{
		   $('#editedAmount'+index).val(0.00);
	   }
   }
</script> 