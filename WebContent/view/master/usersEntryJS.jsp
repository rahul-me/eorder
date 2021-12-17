<script>

var flaguname = false;

$(document).ready(function(){

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
	
	
	
 	 $("#select1").bind("click",function(){
				 
	    	var companyId=$("#select1").val();
	    	//alert(companyId);
	    	if(companyId!="")
	    	{ 		
	  
	    	var obj=new Object();
     	  	obj.companyId = companyId;
     	  	var str = JSON.stringify(obj);
			     	  
     	  	$.ajax({
     	  	    url: "../../rest/preastaWebService/getUserRollByCompanyId"
     	  	     		, type: "POST"
	         	  	    , contentType: 'application/json; charset=utf-8'
	         	  	    , dataType: 'json'
	         	  	    , data: str
	         	  	    , success: function (data) {
     	  	    	
     	  	    	str = JSON.stringify(data);
     	  	    	$("#select2").empty();
					$("#select2").append('<option value=""></option>');					     	  	
					
					if(data!="")
						{
							//alert('if');
							$.each(data,function(i, data) {
								var userrolename=data["userrole"];
								var userroleid = data["userrollid"];
								$("#select2").append('<option value="2">ADMIN</option>');							
								$("#select2").append('<option value="' + userroleid + '">' + userrolename + '</option>');
							});
						}else{
							
							$("#select2").append('<option value="2">admin</option>');
							//alert('else');
						}
					
					     	  	    	
     	  	    }
     	  	}); 
	    	}
		 
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
			required:true,
			minlength:6,
			maxlength:12
			},
			password:{
		  	required: true,
		  	minlength:6,
		  	maxlength:12
		  	},
		  	c_password:{
		  		required: true,
		  		equalTo: "#Password"
		  	},
		   	phoneNumber:{
		  	required: true
		  	},
		  	address:{
		  	required: true
		  	},
		  	userRole:{
			required: true
			},
			userRolesMasterId:{
			required: true
			},
			companyMasterId:{
				required:true
			}
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

$("#sub").on("click", function(){
	if(flaguname == true)
		{
		alert('Username is already exist');
		return false;
		}
});

$("#UserName").on("keyup", function(){
	
	var userName=$(this).val();
	var obj = new Object();
	obj.userName = userName;
	var str=JSON.stringify(obj);
	
	$.ajax({
		 url:"../../rest/preastaWebService/checkForUniqueUserName",
		 type:"POST",
		 contentType: 'application/json; charset=utf-8',
		 dataType: 'json',
		 data: str, 
		 success: function (data){
			 
			 var resultString=data["result"];
			 //alert(resultString);
			 if(resultString=="contains")
				 {				 
				 alert('user name already exists');
				 flaguname = true;
				 }
			 else
				 {
				 	flaguname =false;
				 }
			 
		 }
	 });
	
});


</script>