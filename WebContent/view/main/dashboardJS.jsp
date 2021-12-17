<script>

$(document).ready(function() {
	//alert("welcome to homr page");
	getTotalOrder();
	});

function getTotalOrder()
{
	var obj=new Object();
	var date = new Date();
	
	var yyyy = date.getFullYear();
	var mm = date.getMonth();
	var dd = date.getDate();
	
	var today = yyyy+"-"+(++mm)+"-"+dd;
	//alert(today);
  	obj.tDate = today;
  	var str = JSON.stringify(obj);
  	
	$.ajax({
  	    url: "../../rest/preastaWebService/getTodayOrder",
  	    type: "POST",
  	    contentType: 'application/json; charset=utf-8',
  	    dataType: 'json',
  	    data: str,
  	    success: function (data) {
  	     	
	    		var totalOrder = data["TodayOrder"];
	    		var totalAmt = data["totalAmount"];
	    		var totalItem = data["totalItem"];
	    		
			 	$("#totalOrder").text(totalOrder);
			 	$("#totalAmount").text(totalAmt);
			 	$("#totalItem").text(totalItem);
  	    }
	});
}


</script>