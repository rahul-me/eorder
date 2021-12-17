<script>
$(document).ready(function(){

	$("#clientState").change(function(){
    	var clientState=$("#clientState").val();
    	//alert(clientState);
    	$("#clientcity").empty();
    	$.ajax({ 
			url : "../../rest/preastaWebService/getAllCityByStateId?clientState="+clientState,
			type : "GET",
			contentType : 'application/json; charset=utf-8',
			dataType : 'json',
			success : function(data) {
			if(data!='')
	 	    	{	
				var selectCity=$("#clientcity");
					$.each(data.aaData,function(i,obj)
				           {
							var masterId= obj["cityMasterId"];
							var cityName=obj["cityName"];
				                var div_data="<option value="+masterId+">"+cityName+"</option>";
				               // alert(masterId);
				               	 $(div_data).appendTo(selectCity); 
				           });  
				}	
			}
      });
	
	var mm=$('#alertMsg').val();
	var a = $('#error').text();

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
		$("#createOrSubmitUserId").val(1);
		$("#UserEntryForm").submit();
		});
	
 	
	var autoComplete=document.getElementById('UserEntryForm'); 
	autoComplete.setAttribute("autocomplete", "off");
	
	var options = [];
	options.length=0;
	$('#select5 option').each(function() {
		options.push(this.textContent.toUpperCase().replace(/[^\w]/g,''));
	});
	
	var form1 = $('#UserEntryForm');
    var error1 = $('.alert-danger', form1);
    var success1 = $('.alert-success', form1);

    form1.validate({
        errorElement: 'span', //default input error message container
        errorClass: 'help-block help-block-error', // default input error message class
        focusInvalid: false, // do not focus the last invalid input
        ignore: "",  // validate all fields including form hidden input
       
        rules: {
			firstName:{
			required:true
			},
			lastName:{
			required:true
			},
			userName:{
			required:true
				},
		   	phoneNumber:{
		  	required: true
		  	},
		  	address:{
		  	required: true
		  	},
		  	
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
/* 
        submitHandler: function (form) {
            success1.show();
            error1.hide();
        } */
    });
	
	
	$.validator.addMethod("custom_number", function(value, element) {
	    return this.optional(element) || value === "NA" ||
	        value.match(/^[0-9,\+-]+$/);
	}, "Please enter a valid number");
	
	
		    $("#cancel").click(function(event){
		    	 window.location.href = "../po/filterViewAction.do?listUsers=true"; 
				  });
		    
		    $("#UserName").focusout('input',function(){
			 	  var pathname=document.location.search.split("=",2);
			 	 if($("#UserName").val()=="")
				 {
				 
				 }
			  //alert(pathname[1]);
			  else if(!pathname[1])
					{
			   		var filter = $(this).val().replace(/[^\w]/g,'').toUpperCase(); // get the value of the input, which we filter on;
				    var haveDuplicate = $.inArray(filter,options) != -1;
				    if(haveDuplicate==true)
				    	{
				    	alert("UserName already exists");
				    	$(this).focus();
				    	}
				 	}
				  });
		    
		    
			 // $("#select1").change();
			  //$("#select2").change();
			 
});


</script>