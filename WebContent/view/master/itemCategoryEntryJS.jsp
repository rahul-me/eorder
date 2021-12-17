<script>
$(document).ready(function(){
	
	$("#listCategory").click(function() {
		window.location.href = "../po/filterViewAction.do?itemCategory=true";
	});
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

	
	$("#createOrSubmit").click(function(){
		$("#CatEntryForm").submit();
		});

	var autoComplete=document.getElementById('CatEntryForm'); 
	autoComplete.setAttribute("autocomplete", "off");
	var options = [];
	options.length=0;
	$('#select1 option').each(function() {
		options.push(this.textContent.toUpperCase().replace(/[^\w]/g,''));
	});
	
	//alert(options[2].text.toUpperCase().replace(/[^\w]/g,''));
	//alert(options[6].text);
	/*   var form1 = $('#CatEntryForm');
         var error1 = $('.alert-danger', form1);
         var success1 = $('.alert-success', form1);
         form1.validate({
             errorElement: 'span', //default input error message container
             errorClass: 'help-block', // default input error message class
             focusInvalid: false, // do not focus the last invalid input
             ignore: "",
             rules: {
            	 name:{
					required:true
					},
				siteId:{
				  	required: true
				  	},
				companyId:{
				   	required: true
				   	},
             },

             invalidHandler: function (event, validator) { //display error alert on form submit              
                 success1.hide();
                 error1.show();
                 App.scrollTo(error1, -200);
             },

             highlight: function (element) { // hightlight error inputs
                 $(element).closest('.form-group').addClass('has-error'); // set error class to the control group
             },

             unhighlight: function (element) { // revert the change done by hightlight
                 $(element).closest('.form-group').removeClass('has-error'); // set error class to the control group
             },

             success: function (label) {
                 label.closest('.form-group').removeClass('has-error'); // set success class to the control group
             },
             
         });  */
        
         var form1 = $('#CatEntryForm');
         var error1 = $('.alert-danger', form1);
         var success1 = $('.alert-success', form1);

         form1.validate({
             errorElement: 'span', //default input error message container
             errorClass: 'help-block help-block-error', // default input error message class
             focusInvalid: false, // do not focus the last invalid input
             ignore: "",  // validate all fields including form hidden input
            
             rules: {
             	name: {
                     minlength: 2,
                     required: true
                 },
                 companyId: {
                     required: true,
                 },
                
             },
             messages: {
                 select_multi: {
                     maxlength: jQuery.validator.format("Max {0} items allowed for selection"),
                     minlength: jQuery.validator.format("At least {0} items must be selected")
                 }
             },

             invalidHandler: function (event, validator) { //display error alert on form submit              
                 success1.hide();
                 error1.show();
                 Metronic.scrollTo(error1, -200);
             },

             highlight: function (element) { // hightlight error inputs
                 $(element)
                     .closest('.form-group').addClass('has-error'); // set error class to the control group
             },

             unhighlight: function (element) { // revert the change done by hightlight
                 $(element)
                     .closest('.form-group').removeClass('has-error'); // set error class to the control group
             },

             success1: function (label) {
                 label
                     .closest('.form-group').removeClass('has-error'); // set success class to the control group
             },

             /* submitHandler: function (form) {
                 success1.show();
                 error1.hide();
             } */
         });
	
		  $("#CategoryName").focusout('input',function(){
		 	  var pathname=document.location.search.split("=",2);
		 	 if($("#CategoryName").val()=="")
			 {
			 
			 }
		  //alert(pathname[1]);
		  else if(!pathname[1])
				{
		   		var filter = $(this).val().replace(/[^\w]/g,'').toUpperCase(); // get the value of the input, which we filter on;
			    //alert(filter);
			    var haveDuplicate = $.inArray(filter,options) != -1;
			    //alert(haveDuplicate);
			    if(haveDuplicate==true)
			    	{
			    	alert("Please Enter Unique Category Name");
			    	$(this).focus();
			    	}
			    /* else
			    	{
			    	var sku=document.getElementById("SKU");
			    	sku.value=filter;
			    	} */
			   /*  var sku=document.getElementById("dummySKU");
		     	sku.value=filter; */
		     	
				}
			/* else
				{
				var filter = $(this).val().replace(/[^\w\s]/g,'').toUpperCase(); // get the value of the input, which we filter on;
				var sku=document.getElementById("dummySKU");
		     	sku.value=filter;
		     	$(this).focus();
				} */
			  });
		  
			 /*  $("#CategoryName").keyup('input',function(){
				  var filter = $(this).val().replace(/ /g,'').toUpperCase(); // get the value of the input, which we filter on;
				  var sku=document.getElementById("dummySKU");
			     	sku.value=filter;
			     	
			   }); */
			  
			   $("#cancel").click(function(event){
				   window.location.href = "../po/filterViewAction.do?itemCategory=true"; 
				  });
			  
			 /*   $("#select2").select2({
					placeholder : "Select Site"
				});
			   $("#select1").select2({
					placeholder : "Select Category"
				});
			   $("#select3").select2({
					placeholder : "Select Company"
				});
			  $("#select1").change();
			  $("#select2").change();
			  $("#select3").change(); */
			  
});


</script>