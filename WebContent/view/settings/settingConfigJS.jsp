<script>
$(document).ready(function(){	
$.ajax({
	url : "../../rest/ConfigurationService/getitemPrice",
	type : "POST",
	contentType : 'application/json; charset=utf-8',
	dataType : 'json',
	async : false,
	success : function(data) {
		var value = data["value"];
		var editableCost = data['editableCost']; 
	//	alert(value);
		if(value==1){
							
				$("input:radio[name='active']").attr('checked', true);
				
		}
			else
			{
				$("input:radio[name='active']").attr('checked', false);
				
		    }
		
		
		if(editableCost == 'yes'){		
			$('#unitCostEditable').attr('checked',true);
			$('#unitCostEditable').parent().addClass("checked");
			$('#unitCostEditable').val(1);
		}else {
			$('#unitCostEditable').val(0);			
	    }
		
		
	}
});



});

$("input[name='unitCostEditable']").on('change',function() {
	var status = $('#unitCostEditable').val();
	
	if(status == 1){
		$('#unitCostEditable').val(0);
	
	}else{
		$('#unitCostEditable').val(1);
	
	}
	
	takeActionForUnitCostEditability();
});

$("input[name='active']" ).change(function() {

	
	
	var obj=new Object();
	obj.itemPriceStatus = val;
	var str = JSON.stringify(obj);
	//alert(str);
	 $.ajax({
		url : "../../rest/ConfigurationService/setitemPrice",
		type : "POST",
		contentType : 'application/json; charset=utf-8',
		dataType : 'json',
		
		data : str,
		async : false,
		success : function(data) {
					var message = data["message"];
				
					 if(message)
						{
						Command: toastr['success']("Configuration Successfully Updated")
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
						}else{
							Command: toastr['error']("Something terrible happened.")
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
				 
	
	});
	
	$("#subEmail").on("click",function(){
		var email=$("#emailId").val();
		var epass=$("#epasswordId").val();
		var echost=$("#companyHost").val();
		var ecport=$("#companyPort").val();
		var ectrust=$("#companyTrust").val();
		
		alert(email+":"+epass);
		
		$.ajax({
			url:"../../rest/ConfigurationService/setDefaultMailConfiguration?email="+email+"&epass="+epass+"&echost="+echost+"&ecport="+ecport+"&ectrust="+ectrust,
			type : "GET",
			contentType : 'application/json; charset=utf-8',
			dataType : 'json',
			success : function(data){
				
				
			}
			});
		
		
		
		
		
	});
	
function takeActionForUnitCostEditability(){
	var checkboxstatus = $('#unitCostEditable').val();
	var obj = new Object();
	obj.checkboxstatus = checkboxstatus;
	var str = JSON.stringify(obj);
	$.ajax({
		url : "../../rest/ConfigurationService/setUnitCostEditability",
		type : "POST",
		contentType : 'application/json; charset=utf-8',
		dataType : 'json',		
		data : str,
		async : false,
		success : function(data) {
			if(data['result']== 'Done'){
				Command: toastr['success']("Configuration Successfully Updated")
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
</script>