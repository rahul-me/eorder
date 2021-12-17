/**
 * 
 */

$(document).ready(function(){
	$('#CompanyDetailForm').submit(function(){		
		var resultcst = varifyNumber($('#cstidno').val(), 'CST');
		var resultvat = varifyNumber($('#vatidno').val(), 'VAT');		
		if(resultcst== true && resultvat == true){
			var companyDetailForm = $('#CompanyDetailForm');
			companyDetailForm.action='view/company/companyDetailAction.do?submit=Submit';
		}else{
			return false; 
		}
	});
});

function varifyNumber(num, name){
	
	if(num.trim()!=""){
		var regid = num.substring(0,2);
		if(!(parseInt(regid)<=35 && parseInt(regid)>=1)){
			Command: toastr['error']("Enter Valid "+name+" Identification Number")
			toastr.options = {
				"closeButton": true,
				"debug": false,
				"positionClass": "toast-bottom-full-width",
				"onclick": null,
				"showDuration": "5000",
				"hideDuration": "1000",
				"timeOut": "5000",
				"extendedTimeOut": "1000",
				"showEasing": "swing",
				"hideEasing": "linear",
				"showMethod": "fadeIn",
				"hideMethod": "fadeOut"
			}
				return false;
		}else if(num.length!=11){			
			Command: toastr['error']("Enter Valid "+name+" Identification Numbers")
			toastr.options = {
				"closeButton": true,
				"debug": false,
				"positionClass": "toast-bottom-full-width",
				"onclick": null,
				"showDuration": "5000",
				"hideDuration": "1000",
				"timeOut": "5000",
				"extendedTimeOut": "1000",
				"showEasing": "swing",
				"hideEasing": "linear",
				"showMethod": "fadeIn",
				"hideMethod": "fadeOut"
			}
			return false;
		}else{					
			return true;
		}
	}else{
		return true;
	}

}
