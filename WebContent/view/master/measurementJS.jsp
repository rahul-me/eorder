<script>



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
	
	$("#measurementId2").select2({
		placeholder : "Select"
	});
	$("#measurementId1").select2({
		placeholder : "Select"
	});
	
	var form1 = $('#measurementEntryForm');
    var error1 = $('.alert-danger', form1);
    var success1 = $('.alert-success', form1);

    form1.validate({
        errorElement: 'span', //default input error message container
        errorClass: 'help-block help-block-error', // default input error message class
        focusInvalid: false, // do not focus the last invalid input
        ignore: "",  // validate all fields including form hidden input
       
        rules: {
       	 unit:{
				required:true
				},
				name:{
			  	required: true
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

      /*   submitHandler: function (form) {
            success1.show();
            error1.hide();
        } */
    });
	
    var form2 = $('#measurementForm');
    var error2 = $('.alert-danger', form2);
    var success2 = $('.alert-success', form2);

    form2.validate({
        errorElement: 'span', //default input error message container
        errorClass: 'help-block help-block-error', // default input error message class
        focusInvalid: false, // do not focus the last invalid input
        ignore: "",  // validate all fields including form hidden input
       
        rules: {
       	 firstMeasurementId:{
				required:true
				},
				secondMeasurementId:{
			  	required: true
			  	},
			  	measurementValue:{
			  	required: true,
			  	number : true
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

        success: function (label) {
            label
                .closest('.form-group').removeClass('has-error'); // set success class to the control group
        },

        submitHandler: function (form) {
            success2.show();
            error2.hide();
        },
    });
	 
});

</script>