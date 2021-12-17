<script>

$(document).ready(function() {
	//alert("welcome to homr page");
	
	var data ="mm";
	 $.ajax({
		url : "../../rest/dashboardWebService/getItemCategory",
		type : "POST",
		contentType : 'application/json; charset=utf-8',
		dataType : 'json',
		data : data,
		async : false,
		success : function(data) {
			var str = JSON.stringify(data);
			//  alert(str);
			var vm=1;
			$.each( data, function( key, value ) {
				  //alert( key + ": " + value );
				  $.each( value, function( key, value ) {
				//	var str = JSON.stringify(value);
					//  alert(str);
					 // alert( key + ": " + value );
					  $( "#panel" ).clone().attr('id','panel'+vm).appendTo( "#accordion2");
					  $('#panel'+vm).find( "a" ).attr('href','#collapse_2_1'+vm).attr('id','link'+vm);
					  $('#link'+vm).text(key);
					  $('#panel'+vm).children().next().attr('id','collapse_2_1'+vm);
					  $('#panel'+vm).find( "table" ).attr('id','tableId'+vm);
					  $('#tableId'+vm).empty();
					  
					  //file sub category in category
					   var countVal=0;
					  $.each( value, function( key, value ) {
						 // var str = JSON.stringify(value);
						 // alert( str ); 
						  $.each( value, function( key, value ) {
							if(countVal % 4==0 || countVal==0){
								$('#tableId'+vm).append('<tr></tr>');
							}
							$('#tableId'+vm+':last').find('tbody').find('tr:last').append('<td align="center" valign="top"><a href="#" onClick="loadItem(this.id);" title="" class="lightbox" id='+value["id"]+'><img src="../../assets/img/avatar1.jpg" alt="" /></a><div class="dname"><a href="#">'+value["name"]+'</a></div></td>');
							/* if(countVal % 4==0){
								 $('#tableId'+vm).append('</tr>');
							} */
							countVal+=1;
						  // 
						  });
					  });
					  vm+=1;
					});
				});
			}
		});
});

function loadItem(id){
	

	var data =id;
	 $.ajax({
		url : "../../rest/dashboardWebService/getItemByItemCategory",
		type : "POST",
		contentType : 'application/json; charset=utf-8',
		dataType : 'json',
		data : data,
		async : false,
		success : function(data) {
			//var str = JSON.stringify(data);
			var countVal=0;
			$('#itemTableId').empty();
			 $.each( data, function( key, value ) {
				 var str = JSON.stringify(value);
				 //alert(str);
				 if(countVal % 4==0 || countVal==0){
				 $('#itemTableId').append('<tr></tr>');}
				 $('#itemTableId').find('tbody').find('tr:last').append('<td align="center" valign="top"><a href="#" onClick="addBill(this.id,this.name);" title="" class="lightbox" id='+value["id"]+' name='+value["itemName"]+'><img src="../../assets/img/foodimage.jpg" alt="" /></a><div class="dname"><a href="#">'+value["itemName"]+'</a></div></td>');
					// alert(str)
				 //alert(value["itemName"]);
				 countVal+=1;
			 });
			
		}
	});
}

function addBill(id,name){
	$('#billing').append('<li id="order"><div class="col1" id="orderId"><div class="cont"><div class="cont-col1"><div class="label label-sm label-default"><i class="icon-signout"></i></div></div><div class="cont-col2"><div class="desc" id="'+id+'" >'+name+'</div></div></div></div><div class="col2" id="orderQty"><div class="date"><div class="badge badge-sm badge-info" id="qty">1</div><div class="label label-sm label-danger"><i class="icon-remove"></i></div></div></div></li>');
	//alert(id);
	//alert(name);
}

</script>