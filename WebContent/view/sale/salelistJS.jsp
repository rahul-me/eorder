<script type="text/javascript">

$(document).ready(function(){
	getSaleList();
});

function getSaleList(){
		
	$('#example').dataTable({
		    "sAjaxSource" : "../../rest/preastaWebService/getSaleDetails",
	        "bProcessing": true,
	        "aoColumns":[
							/* {"mDataProp":"detailid"}, */
							{"mDataProp":"serial"},
							{"mDataProp":"item"},								
							{"mDataProp":"quantity"},
							{"mDataProp":"rate"},
							{"mDataProp":"amount"},
							{"mDataProp":"saledate"},
							{"mDataProp":"consumername"},
							{"mDataProp":"consumeraddress"},
							{"mDataProp":"edit"},
							
	                    ],
				 "aLengthMenu":[[50,100,500, -1],[50,100,500, "All"]],
					"iDisplayLength": 100,
         
	    });
}

function editSale(saleid){
	window.location='../../view/sale/saleViewAction.do?saleid='+saleid+'&update=yes';
}
</script>