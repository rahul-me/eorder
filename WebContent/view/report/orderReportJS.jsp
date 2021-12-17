<script type="text/javascript">

$(document).ready(function(){
	$('#btnSubmit').on('click', function(){
		var month = $('#month').val();
		var year = $('#txtyear').val();
		getOrderReport(month, year);
		getOrderDetails();
	});
});

function getOrderReport(month, year){
	var oTable = $('#example').dataTable();
   	if(oTable!=null)oTable.fnDestroy();
   	
   	var obj = new Object();
   	obj.month = month;
   	obj.year = year;
   	var str = JSON.stringify(obj);
   	
$('#example').dataTable({
  "sAjaxSource" : "../../rest/preastaWebService/getOrderReportList?data="+str,
  "bProcessing": true,
  "aoColumns":[
	    {"mDataProp":"serial"},
		{"mDataProp":"item"},
		{"mDataProp":"ordernumber"},
		{"mDataProp":"orderdate"},								 				 	 
		{"mDataProp":"orderedquantity"},
		{"mDataProp":"deliveredquantity"},
		{"mDataProp":"status"},
		],
		"aLengthMenu":[[50,100,500, -1],[50,100,500, "All"]],
		"iDisplayLength": 100,
	});
}

function getOrderDetails(){
	
	var month = $('#month').val();
	var year = $('#txtyear').val();
	
	var obj = new Object();
   	obj.month = month;
   	obj.year = year;
   	var str = JSON.stringify(obj);
	
	$.ajax({
		url:'../../rest/preastaWebService/getOrderDetailsForMonthlyReport',
		type:'POST',
		contentType:'application/json; charset=utf-8',
		data:str,
		success: function(data){
			
			var totalorder = data['totalorder'];
			var totalquantity = data['totalquantity'];
			var totalamount = data['totalamount'];
			var totaliteminorder = data['totaliteminorder'];
			
			$('#totalorder').text(totalorder);
			$('#totaliteminorder').text(totaliteminorder);
			$('#orderquantity').text(totalquantity);
			$('#totalamount').text(totalamount);
					
		}
	});
}

</script>