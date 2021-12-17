 <script type="text/javascript">
 
	var itemIdText=[];

 function changeEvent(data,data1)
 {	 
	 var itemId=$(data).val();
	 //alert(itemId);
	 var obj=new Object();
	 obj.itemId=itemId;
	 var str=JSON.stringify(obj);
	 $.ajax({
		 url:"../../rest/preastaWebService/getItemById",
		 type:"POST",
		 contentType: 'application/json; charset=utf-8',
		 dataType: 'json',
		 data:str,
		 success: function(data)
		 {
			 //alert('process has been completed');
			 var itemPrice=data["itemPrice"];			 
			 var table= document.getElementById('example');
			 var aprice=table.rows[data1].cells[2].getElementsByTagName('input')[0];			 
			 aprice.value=itemPrice;
		 }
	 });
 }
	
 $("#itemMasterId_1").on("change",function(){
	 //alert('you have changed');
	 var itemId=$(this).val();
	 //alert(itemId);
	 var obj=new Object();
	 obj.itemId=itemId;
	 var str=JSON.stringify(obj);
	 $.ajax({
		 url:"../../rest/preastaWebService/getItemById",
		 type:"POST",
		 contentType: 'application/json; charset=utf-8',
		 dataType: 'json',
		 data:str,
		 success: function(data)
		 {
			 //alert('process has been completed');
			 var itemPrice=data["itemPrice"];
			 //alert(itemPrice);
			 $("#itsActualPrice").val(itemPrice);
		 }
	 });
 });
 
 var table= document.getElementById('example');
 tbody = table.getElementsByTagName('tbody')[0];
 clone = tbody.rows[0].cloneNode(true);
 var newClone="";
 
 $(document).ready(function() {
	  
			 /*  $("#createOrSubmit").on("click", function(e) {
			 		var r = confirm("Are U Sure!");
			 		var txt;
			 		if (r == true) {
			 			edititemprice();
			 		} else {
			 			txt = "You pressed Cancel!";
			 		}
		 		}); */
		 	
			
			  $(".sidebar").removeClass("active");
				 $("#mdm").addClass("active open");
				 $("#mdm").append('<span class="selected"></span><span class="arrow open"></span>');
				        	 
			 	var a = $('#error').text();        	 	
			 	if (a == "") {
			 	} else {
			 		
			 	}
		
			    $(".selectFilter").show();
			    
			    $("#filter  option[value='supplierId']").remove();
			    $("#filter  option[value='date']").remove();
			    
			    
			 $(".itemIds").show();
				  
				
				 $("#userMasterId").change(function(){
					
					if(($("#userMasterId").val()!=""))
						getList();
				 });
				
			
			  $("#createItem").click(function(){
		   	  	window.location.href = "../item/ItemViewAction.do";
		   	  });
			  
			  var table=document.getElementById("example");
			  
			  var cellIndexMapping={0:true};
			  var data=[];
			  $("#example").each(function(rowIndex){
				  $(this).find("html").each(function(cellIndex){
					  if(cellIndexMapping[cellIndex])
						  {
						  data.push($(this).styleId.val());
						  }
				  });
			  });
			  
				
			});
 
			function back(){
					window.location = '../mainscmview/index.jsp';
						   }

        	 /* stuff={};
        	 function changeState(itemid,price){									        	 
        	 stuff[itemid]=price;
        	 }
        	 function edititemprice()
        	 {
        		 
        		 var str = JSON.stringify(stuff);
        		// alert(str);
        	 		$
        			.ajax({
        				url: "../../rest/preastaWebService/updateitemPrice",
        				type : "POST",
        				contentType : 'application/json; charset=utf-8',
        				dataType : 'json',
        				data : str,
        				async : false,
        				success : function(data) {
        					Command: toastr['success']("ItemPrice List Successfully Updated")
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
        			});
        	 } */
        	
        	function getList()  {
        		
        		var oTable = $('#example').dataTable();
 	          	if(oTable!=null) oTable.fnDestroy();
 	          
 	          	var userMasterId=$('#userMasterId').val();
        			//var itemCategoryId=$("#sel3").find(':selected').val();
        			
        			
        			$.ajax({
        				url : "../../rest/masterDataMgmtService/getItemCustomerPriceMappingListByFilter?userMasterId="+userMasterId,
        	  	 	 	type : "GET",
        	  	 	  	contentType : 'application/json; charset=utf-8',
        	  	 	  	dataType : 'json',
        	  	 	  	async:false,
        	  	 	 	//data : str,
        	  	 	 	success : function(data) {
        	  	 		var str = JSON.stringify(data);
        	  	 		
        	     			var tableRows = tbody.rows.length; 
        	     			var i;
        	     			 for(i=tableRows;i>=1; i--)
        	     			{
        	     				if( i != 1 )
        	     			    {   
        	     					table.deleteRow(i); 
        	     				}
        	     			} 
        	     			
        					var itemId = table.rows[1].cells[0].getElementsByTagName('select')[0].id;
        	     			itemId.value = '';
        						
        	     			var price = table.rows[1].cells[1].getElementsByTagName('input')[0];
        	     			price.value='';
        	     		
        	     			/*  var itemUnit=table.rows[1].cells[1].getElementsByTagName('span')[0];
        	     			itemUnit.innerHTML=''; 
        					
        	     			var arrayLength = data.length; */
        	     			//updateItemBySupplier();
        	     			var j = 1;	
        	     			
        	     				
        	     			for(var itemSupplierList in data)
        					  {
        						var list=data[itemSupplierList];	
        						var itemId=list["itemId"];
        	     				var price=list["price"];
        	     				
        	     				if(j == 1)
        	     				{
        	     					var selectId = table.rows[j].cells[0].getElementsByTagName('select')[0].id;
        	    					
        	     					$('#'+selectId).removeProp("onchange");
        	     					/* $('#'+selectId).on("change", function(event) { 
        	     					   getCurrentItem(this);
        	     					}); */
        	     				   
        	     					var itemSelects = $('#'+selectId);
        	     					itemSelects.val(itemId).change();
        	     					//alert(itemId);
        	     				
        	     					var p = table.rows[j].cells[1].getElementsByTagName('input')[0];
        	     					p.value =(price.toFixed(2));
        	     					
        	     				 
        	     				}
        	     				else
        	     				{
        	     					
        	     					//alert(clone);
        	     					var new_row = updateRow(clone.cloneNode(true), ++tbody.rows.length, true);
        	     				    tbody.appendChild(new_row);
        	     				    var i=tbody.rows.length;
        	     				     var selectId = new_row.cells[0].getElementsByTagName('select')[0].id;
        	     				    $("#"+selectId).select2();
        	     				    $("#"+selectId).trigger("list:updated");
        	     				   
        	     				    //$('#'+selectId).removeProp("onchange");
        	     		   			var itemSelects = $('#'+selectId);
        	     		   			itemSelects.val(itemId).change();
        	     		   			
        		     		   	  	/* $('#'+selectId).on("change", function(event) { 
        							     getCurrentItem(this);
        							}); */ 
        	     					//itemSelects.trigger('liszt:updated');
        	     					
        	     					var p = new_row.cells[1].getElementsByTagName('input')[0];
        	     					p.value =(price.toFixed(2));
        	     				
        	     				}
        	     				j++;
        	    				}
        	  	   			 },
        	  		 		 error:function(){
        	        			   	alert("Something went wrong in MasterDataMgmt Service");
        					 		}
        	  			});
        	  	
        			}
        	  
        	  
        	  
        	  
        	  function deleteRow(el) {
        		 //  table=document.getElementById("POItable");
        		    var i = el.parentNode.parentNode.rowIndex;
        		    if( i != 1 ) {   
        		    
        		    	table.deleteRow(i);
        		    	/* getAmountOfItems(); */
        			}
        		}
        	  
        	  
        	  function cancelRecepie() {
        		  window.location.href = "../itemsuppliermapping/ItemSupplierViewAction.do";
        			}
        	  
        	  
        	  function insRow() {
        		 
        			var new_row = updateRow(clone.cloneNode(true), ++tbody.rows.length,true);
        					
        					tbody.appendChild(new_row);
        				
        					var selectId = new_row.cells[0].getElementsByTagName('select')[0].id;
        					$("#"+selectId).select2();
        					
        					var price = new_row.cells[1].getElementsByTagName('input')[0].id;
        					
        					var cellIndexMapping={0:true};
        					  var data=[];
        					  
        					  $("#example tbody tr").each(function(rowIndex){
        						  $(this).find("td").each(function(cellIndex){
        							  if(cellIndexMapping[cellIndex])
        								  {
        								  //data.push(((($(this).children()).children()).attr('id')).substring(5));
        								  data.push(((($(this).children()).children()).attr('id')).substring(5));
        								  //alert(data);
        								  itemIdText=data;
        								  //alert('itemidtext '+itemIdText);
        								  }
        						  });
        					  });
        				    
        				 //   var valueId = new_row.cells[2].getElementsByTagName('input')[0].id;
        				    
        				    
        				    
        				  /*   $("#"+qtyId).bind('input',function(){
        						$("#"+amtId).val((parseFloat($("#"+qtyId).val())*parseFloat($("#"+rateId).val())).toFixed(2));
        						getAmountOfItems();
        					});
        				     */
        					/* $("#"+rateId).bind('input',function(){
        						$("#"+amtId).val((parseFloat($("#"+qtyId).val())*parseFloat($("#"+rateId).val())).toFixed(2));
        						getAmountOfItems();
        					}); */

        				}
        	  function updateRow(row, i, reset) {
        			
        			var selectItem = row.cells[0].getElementsByTagName('select')[0];
        			selectItem.setAttribute("name", "itemMasterId");//[" + i + "]");

        			selectItem.setAttribute("class", "form-control  select2me required selectevent");
        			var j;
        			var selectId = 1;
        			
        			for (j = 0; j < i - 1; j++) {
        				
        				if (selectId < parseInt(tbody.rows[j].cells[0].getElementsByTagName('select')[0].id.substring(13)));
        				{
        					
        					selectId = parseInt(tbody.rows[j].cells[0].getElementsByTagName('select')[0].id.substring(13));

        				}
        			}
        			selectId = selectId + 1;
        			selectItem.setAttribute("id", "itemMasterId_" + selectId);
        			selectItem.setAttribute("onChange","changeEvent("+"itemMasterId_"+selectId+","+selectId+")")

        			var priceInput = row.cells[1].getElementsByTagName('input')[0];
        			priceInput.setAttribute("name", "prices");//[" + i + "]");
        			priceInput.setAttribute("id", "price"+selectId);
        			
        			
        			
        			/* var selectMeas = row.cells[1].getElementsByTagName('input')[1];
        			selectMeas.setAttribute("name", "measurementName");//[" + i + "]");
        	 */
        			/* var selectMeasId = row.cells[1].getElementsByTagName('input')[2];
        			selectMeasId.setAttribute("name", "measurementIds");//[" + i + "]");
        	 */
        			//var qtyAmount = row.cells[2].getElementsByTagName('input')[0];
        		//	qtyAmount.setAttribute("name", "value");//[" + i + "]");
        		//	qtyAmount.setAttribute("id", "value"+selectId);
        			/* 
        			var qtyAmount = row.cells[2].getElementsByTagName('input')[0];
        			qtyAmount.setAttribute("name", "amounts");//[" + i + "]");
        			qtyAmount.setAttribute("id", "amt"+selectId); */
        		
        			$(".selectevent").live("click",function(){
        				alert('hello');
        			});
        			
        			return row;
        		}
        	  
        	  $(".selectevent").live("click",function(){
  				alert('hello');
  			});

        	 
        	 /*  function getCurrentItem(el) {
        		 
        		  i = el.parentNode.parentNode.parentNode.rowIndex;
        			
        			if (typeof i == "undefined") {
        				i = 1;
        			}
        			var itemId = table.rows[i].cells[0].getElementsByTagName('select')[0].value;		
        			var obj = new Object();
        			obj.itemId = itemId;		
        			var str = JSON.stringify(obj);		
        			$.ajax({
        				url : "../../rest/preastaWebService/getItemPriceAndMeasurementUnit",
        				type : "POST",
        				contentType : 'application/json; charset=utf-8',
        				dataType : 'json',
        				async:false,
        				data : str,
        				success : function(data) {
        					str = JSON.stringify(data);
        					alert(str);
        				//	var measurementId = data["measurementId"];
        				//	var measurementName = data["measurementName"];				
        					var itemCost=data["itemPrice"].toFixed(2);	
        					
        					
        					//var itemQty = table.rows[i].cells[2].getElementsByTagName('input')[0].value;
        					
        				//	var selectMeas = table.rows[i].cells[2].getElementsByTagName('span')[0];
        					//selectMeas.innerHTML = measurementName;
        					var itemprice = table.rows[i].cells[1].getElementsByTagName('input')[0];
        					itemprice.value=itemCost;	
        					//var itemAmount = table.rows[i].cells[4].getElementsByTagName('input')[0].id;
        					
        					

        			}
        			}); 
        				
        		}*/
													
        
         /*  
          $("#filterBTN").click(function(event){
            	var oTable = $('#example').dataTable();
            	if(oTable!=null) oTable.fnDestroy();
          		var itemId=$('#itemId').val();
          		
          	          	 getList(itemId);
          
          
          } );    */
</script> 