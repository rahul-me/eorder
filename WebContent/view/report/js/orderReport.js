/**
 * 
 */

$(document).ready(function(){
	$('#btnSubmit').on('click', function(){
		var month = $('#month').val();
		var year = $('#year').val();
		getOrderReport(month, year);
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
	    {"mDataProp":"serialno"},
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