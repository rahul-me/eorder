/**
 * 
 */

var table = null;
var tbody = null;
var rowcopy = null;

$(document).ready(function(){
	table = document.getElementById('itable');
	tbody = table.getElementsByTagName('tbody')[0];
	rowcopy = tbody.rows[0].cloneNode(true);
	
	
	/* form validation */
	
	var saleform = $('#SaleForm');
    var error1 = $('.alert-danger', saleform);
    var success1 = $('.alert-success', saleform);
    
	saleform.validate({
        errorElement: 'span',
        errorClass: 'help-block help-block-error',
        focusInvalid: false,
        ignore: "",       
        rules: {            
        	consumername:{ required: true}, 
        	createdDate:{ required: true}, 
        	itemid:{required: true},
        	quantity: {required: true, number: true},
        	rate:{number: true}
        },
        messages: {
            select_multi: {
                maxlength: jQuery.validator.format("Max {0} items allowed for selection"),
                minlength: jQuery.validator.format("At least {0} items must be selected")
            },
            rate: {
            	number:'Enter Digits'
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
    });
	
	// Form Submission
	$('#btnsubmit').on('click', function(){
		var result = checkforitemuniqueness();
		if(result == true){
			$('#SaleForm').submit();
		}else{
			Command: toastr['error']("One or more items selected multiple times. Please Make sure your list contains single entry of any item to avoid access amount of order for product")
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
		}		
		
	});
	
	getDataIfItIsAboutToUpdate();
});

function updateRow(row, i, reset){
	row.setAttribute("id",i);
	
	var col_1 = row.cells[0].getElementsByTagName('select')[0];
	col_1.setAttribute('name','itemid');
	col_1.setAttribute('id','itemid'+i);
	
	var col_11 = row.cells[0].getElementsByTagName('input')[0];
	col_11.setAttribute('name','saleDetailIdU');
	col_11.setAttribute('id','saleDetailIdU'+i);
	
	var col_2 = row.cells[1].getElementsByTagName('input')[0];
	col_2.setAttribute('name','availablequantity');
	col_2.setAttribute('id','availablequantity'+i);
	
	var col_3 = row.cells[2].getElementsByTagName('input')[0];
	col_3.setAttribute('name','quantity');
	col_3.setAttribute('id','quantity'+i);
	
	var col_4 = row.cells[3].getElementsByTagName('input')[0];
	col_4.setAttribute('name','rate');
	col_4.setAttribute('id','rate'+i);
	
	var col_5 = row.cells[4].getElementsByTagName('input')[0];
	col_5.setAttribute('name','amount');
	col_5.setAttribute('id','amount'+i);
	
	return row;
	
}

function insertRow(){
	var updatedrow = updateRow(rowcopy.cloneNode(true), ++tbody.rows.length, true);
	tbody.appendChild(updatedrow);
	
	var col_1id = updatedrow.cells[0].getElementsByTagName('select')[0].id;
	object=updatedrow.cells[0].getElementsByTagName('select')[0];				
	$("#"+col_1id).select2({
	    placeholder: "Select",
	    allowClear: true
	});
}

function deleteRow(node){
	var index = node.parentNode.parentNode.rowIndex;
	if(index!=1){
		table.deleteRow(index);
	}
}

function getDetails(element){
	var index = element.parentNode.parentNode.parentNode.id;
	var item = $("#itemid"+index).val();
	var obj = new Object();
	obj.item = item;
	var jdata = JSON.stringify(obj);table
	if(item!=""){
		$.ajax({
			url:'../../rest/preastaWebService/getItemDetails',
			type:'POST',
			contentType:'application/json; charset=utf-8',
			data:jdata,
			success: function(data){
				var availablequantity = data['availablequantity'].toFixed(2);
				var rate = data['rate'].toFixed(2);
				
				$("#availablequantity"+index).val(availablequantity);
				$("#rate"+index).val(rate);
				
				var quantity = $("quantity"+index).val();
				if(quantity!='' && (parseFloat(quantity)>0)){
					var rate = $('#rate'+index).val();
					if(parseFloat(rate)>0){
						var amount = parseFloat(quantity) * parseFloat(rate);
						$('#amount'+index).val(amount.toFixed(2));
						countTotalAmount();
					}
				}
			}
		});
	}
}

function oninputquantity(element){	
	var index = element.parentNode.parentNode.id;
	var item = $("#itemid"+index).val();
	if(item!="" && (parseInt(item))>0){
		var rate = $("#rate"+index).val();
		if(rate!=""){
			var quantity = $("#quantity"+index).val();
			if(quantity!="" && (parseFloat(quantity)>0)){
				var total = parseFloat(rate) * parseFloat(quantity);
				$("#amount"+index).val(total.toFixed(2));
				countTotalAmount();
			}			
		}
	}
}

function oninputrate(element){
	var index = element.parentNode.parentNode.id;
	var item = $("#itemid"+index).val();
	var quantity = $("#quantity"+index).val();
	if(item!="" && (parseInt(item))>0 && quantity!="" && (parseFloat(quantity)>0)){
		var rate = $("#rate"+index).val();
		if(rate!=""){
			var total = parseFloat(rate) * parseFloat(quantity);
			$("#amount"+index).val(total.toFixed(2));
			countTotalAmount();
		}
	}
}

function countTotalAmount(){
	var rowcount = tbody.rows.length;
	var totalamount = 0;
	for(var i = 0 ; i< rowcount ; i++){
		var index = tbody.rows[i].id;
		totalamount += parseFloat($('#amount'+index).val());
		$('#total').val(totalamount.toFixed(2));
	}
}

function checkforitemuniqueness() {
	var rowcount = tbody.rows.length;
	var result = true;
	var itemid = [];
	for (var i = 0; i < rowcount; i++) {
		itemid.push(tbody.rows[i].cells[0].getElementsByTagName('select')[0].value);
	}
	for (var i = 0; i < itemid.length; i++) {
		for (var j = 0; j < itemid.length; j++) {
			if(i!=j){
				if (itemid[i] == itemid[j]){
					result = false;
					return false;
				}
			}
		}
	}

	return true;
}

function getDataIfItIsAboutToUpdate(){	
	if($('#update').val() == 'true'){
		setDataSpecificForSaleId();
	}
}

function setDataSpecificForSaleId(){
	$.ajax({
		url:'../../rest/preastaWebService/getSaleDetailsSpecificForSaleId',
		type:'POST',
		success: function(data){
			
			$('#consumername').val(data[0].consumername);
			$('#consumeraddress').val(data[0].consumeraddress);
			
			for (var i=0 ; i< data.length; i++){
				
				if(i>0){
					var updatedrow = updateRow(rowcopy.cloneNode(true), ++tbody.rows.length, true);
					tbody.appendChild(updatedrow);
					
					var col_1id = updatedrow.cells[0].getElementsByTagName('select')[0].id;
					object=updatedrow.cells[0].getElementsByTagName('select')[0];				
					$("#"+col_1id).select2({
					    placeholder: "Select",
					    allowClear: true
					});
				}
				var indexid = i+1;
				$('#saleDetailIdU'+indexid).val(data[i].saleDetailIdU);
				$('#itemid'+indexid).val(data[i].itemid).change();
				$('#availablequantity'+indexid).val(data[i].availablequantity.toFixed(2));
				$('#quantity'+indexid).val(data[i].quantity.toFixed(2));
				$('#rate'+indexid).val(data[i].rate.toFixed(2));
				$('#amount'+indexid).val(data[i].amount.toFixed(2));
			}
			countTotalAmount();			
		}
	});
	
}