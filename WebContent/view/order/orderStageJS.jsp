
<script>

$(document).ready(function(){
	
	var form1 = $('#orderstageEntryForm');
    var error1 = $('.alert-danger', form1);
    var success1 = $('.alert-success', form1);

    form1.validate({
        errorElement: 'span', //default input error message container
        errorClass: 'help-block help-block-error', // default input error message class
        focusInvalid: false, // do not focus the last invalid input
        ignore: "",  // validate all fields including form hidden input
       
        rules: {
            
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
        }
        */
    });
	 
});
</script>