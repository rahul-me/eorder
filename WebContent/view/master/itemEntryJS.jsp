
<script>



function createtextbox(data)
{
	
	if (data.value==1){
		 var obj= document.createElement("input");
		// $(document.getElementById("ItemEntryForm")).append(obj);
		 $("#item-Vat").show();
		 $(document.getElementById("Vat")).append(obj);
	 }
	
	
}

$("#ItemName").focusout('input',function(){
	 var pathname=document.location.search.split("=",2);
	 if($("#ItemName").val()=="")
		 {
		 
		 }
	  //alert(pathname[1]);
	  else if(!pathname[1])
		{
		var filter = $(this).val().replace(/[^\w]/g,'').toUpperCase(); // get the value of the input, which we filter on;
	    //alert(filter);
	    //var list=document.getElementById("select1");
	    var haveDuplicate = $.inArray(filter,options) != -1;
	    //alert(haveDuplicate);
	    if(haveDuplicate==true)
	    	{
	    	alert("Please Enter Unique Item Name");
	    	$(this).focus();
	    	}
	     else
	    	{
	    	 	var SKU=document.getElementById("dummySKU");
		    	SKU.value=filter;
		    	$("#sku").val(filter);
		    	
		    	 var filter1 = $("#dummySKU").val().replace(/[^\w]/g,'').toUpperCase();
					// alert(filter);
					 var haveDuplicateVal = $.inArray(filter1,optionsSKU) != -1;
					   // alert(haveDuplicateVal);
					    if(haveDuplicateVal==true)
					    	{
					    	alert("All Ready Have this SKU Please Enter Unique SKU Name");
					    	$("#dummySKU").focus();
					    	}
	    	} 
	    }
	 else
		{
		 var filter = $(this).val().replace(/[^\w]/g,'').toUpperCase(); // get the value of the input, which we filter on;
		  var SKU=document.getElementById("dummySKU");
	    	SKU.value=filter;
	    	$("#sku").val(filter);
	    	//alert(filter);
	    } 
	 
	
		
	   });

$("#dummySKU").focusout('input',function(){
	 
	 var filter1 = $(this).val().replace(/[^\w]/g,'').toUpperCase();
	// alert(filter);
	 var haveDuplicateVal = $.inArray(filter1,optionsSKU) != -1;
	   // alert(haveDuplicateVal);
	    if(haveDuplicateVal==true)
	    	{
	    	alert("All Ready Have this SKU Please Enter Unique SKU Name");
	    	$(this).focus();
	    	}
	
	   });


$("#ItemName").keyup('input',function(){
	
	 var SKU=document.getElementById("dummySKU");
	 SKU.value=$("#sku").val();
 	//$("#sku").val(SKU.value);
 	//alert(SKU.value);
	
 		var options = [];
		options.length=0;
		$('#select5 option').each(function() {
			options.push(this.textContent.toUpperCase().replace(/[^\w]/g,''));
			
		});
		
		var optionsSKU = [];
		optionsSKU.length=0;
		$('#SKUName option').each(function() {
			optionsSKU.push(this.textContent.toUpperCase().replace(/[^\w]/g,''));
		});
	
	
	  var filter = $(this).val().replace(/[^\w]/g,'').toUpperCase(); // get the value of the input, which we filter on;
	  var SKU=document.getElementById("dummySKU");
   	SKU.value=filter;
   	$("#sku").val(filter);
   	//alert(filter);
 });


/* function leaveAStepCallback(obj, context){
    alert("Leaving step " + context.fromStep + " to go to step " + context.toStep);
    return validateSteps(context.fromStep); // return false to stay on step and true to continue navigation 
} */

$(document).ready(function(){
	
	
	
	var form1=$("#ItemEntryForm");
	var error1 = $('.alert-danger', form1);
    var success1 = $('.alert-success', form1);
    
    form1.validate({
        errorElement: 'span', //default input error message container
        errorClass: 'help-block help-block-error', // default input error message class
        focusInvalid: false, // do not focus the last invalid input
        ignore: "",  // validate all fields including form hidden input
       
        
	    rules : {name : {required : true}, measurementMasterId : {required : true}, itemPrice : {required : true}, stockQuantity : {required : true, number:true}},
									messages : {
										select_multi : {
											maxlength : jQuery.validator
													.format("Max {0} items allowed for selection"),
											minlength : jQuery.validator
													.format("At least {0} items must be selected")
										}
									},

									invalidHandler : function(event, validator) { //display error alert on form submit              
										success1.hide();
										error1.show();
										Metronic.scrollTo(error1, -200);
									},

									highlight : function(element) { // hightlight error inputs
										$(element).closest('.form-group')
												.addClass('has-error'); // set error class to the control group
									},

									unhighlight : function(element) { // revert the change done by hightlight
										$(element).closest('.form-group')
												.removeClass('has-error'); // set error class to the control group
									},

									success1 : function(label) {
										label.closest('.form-group')
												.removeClass('has-error'); // set success class to the control group
									},

								});

						$(".sidebar").removeClass("active");
						$("#mdm").addClass("active open");
						$("#mdm")
								.append(
										'<span class="selected"></span><span class="arrow open"></span>');

						var mm = $('#alertMsg').val();
						var a = $('#error').text();
						//alert(a);
						if (a == "") {
						} else {

							Command: toastr['success']("" + mm + " " + a + "")
							toastr.options = {
								"closeButton" : true,
								"debug" : false,
								"positionClass" : "toast-bottom-full-width",
								"onclick" : null,
								"showDuration" : "1000",
								"hideDuration" : "1000",
								"timeOut" : "5000",
								"extendedTimeOut" : "1000",
								"showEasing" : "swing",
								"hideEasing" : "linear",
								"showMethod" : "fadeIn",
								"hideMethod" : "fadeOut"
							}

						}

						$("#itemList")
								.click(
										function() {
											window.location.href = "../po/filterViewAction.do?listItem=true";
										});

						/*  $("#wizard").smartWizard('goBackward', 'Hello, World!');
						return false; 
						
						 $('.button-next').bind("click",function(){
							
							var m=$("#ItemEntryForm").validate().form();
							//alert(m);
							if(!m)
							{
								//alert('You Missed Below Data..! Please Go Privios To Page Add Reqired Data');
								$('#wizard').smartWizard({selected: 0});
							}
							
						});  */

						$("#item-Vat").hide();
						$(".mappingItem").hide();
						//	$('#itemMapId').prop('checked',false);

						$('#itemMapId').bind("change", function() {
							if ($('#itemMapId').attr('checked')) {
								$('.mappingItem').show();
							} else {
								$('.mappingItem').hide();
							}
						});
						var autoComplete = document
								.getElementById('ItemEntryForm');
						autoComplete.setAttribute("autocomplete", "off");

						var itemname = $("#ItemName").val();

						if (itemname != "") {

							var SKU = document.getElementById("dummySKU");
							SKU.value = $("#sku").val();
							//$("#sku").val(SKU.value);
							//alert(SKU.value);

							var options = [];
							options.length = 0;
							$('#select5 option').each(
									function() {
										options.push(this.textContent
												.toUpperCase().replace(
														/[^\w]/g, ''));

									});

							var optionsSKU = [];
							optionsSKU.length = 0;
							$('#SKUName option').each(
									function() {
										optionsSKU.push(this.textContent
												.toUpperCase().replace(
														/[^\w]/g, ''));
									});

							var filter = $("#ItemName").val().replace(/[^\w]/g,
									'').toUpperCase(); // get the value of the input, which we filter on;
							var SKU = document.getElementById("dummySKU");
							SKU.value = filter;
							$("#sku").val(filter);
							//alert(filter);

						} else {
						}

						/* $("#ItemEntryForm").validate({
									ignore : null,
									ignore : 'input[type="hidden"]',
									
									
									errorElement : "label",
									errorPlacement : function(error, element) {
										error.insertBefore(element);
										
									}
							  });
						
						$.validator.addMethod("custom_number", function(value, element) {
						    return this.optional(element) || value === "NA" ||
						        value.match(/^[0-9,\+-]+$/);
						}, "Please enter a valid number"); */

						/*  $("#select2").select2({
								placeholder : "Select Category"
							});
						 $("#itemType").select2({
								placeholder : "Item Type"
							}); 
						
						  $("#select1").select2({
								placeholder : "Select Unit"
							});
						 	$("#select1").change();
						  	$("#select2").change();
						  	$("#select3").change();
						  	$("#select4").change(); */

					});
</script>