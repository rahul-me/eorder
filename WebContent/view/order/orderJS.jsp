<script>
	var items = 0;
	var table = document.getElementById('POITable');

	tbody = table.getElementsByTagName('tbody')[0];
	clone = tbody.rows[0].cloneNode(true);
	var itemFlag = new Array();

	$("#userMasterId").on("change",this,function() {

				var myitem = $("#itemId_1").val();				
				var myqty = $("#qty1").val();
				if (myitem != null) {
					if(myitem!=""){
					getCurrentStock(this);
					}
				}
				var rateamt = $('#rate1').val();
				if (rateamt != null) {
					$("#itemAmnt1").val(
							(parseFloat($("#qty1").val()) * parseFloat($(
									"#rate1").val())).toFixed(2));
					var resval = $("#itemAmnt1").val(
							(parseFloat($("#qty1").val()) * parseFloat($(
									"#rate1").val())).toFixed(2));
					if (resval.val() == 'NaN') {
						$("#itemAmnt1").val(0.0);
					}
					getAmountOfItems();
				}

			});
	$("#itemId_1").on("change",this,function() {

				var itemId = $("#itemId_1").val();

				for ( var i in itemFlag) {
					if (itemId == itemFlag[0][0]) {
						itemFlag[0][1] = true;
					}
				}

				var myuser = $("#userMasterId").val();
				if (myuser == "") {
					alert("Select Customer First");
					return;
				}
				getCurrentStock(this);
				var rateamt = $('#rate1').val();
				if (rateamt != null) {
					$("#itemAmnt1").val(
							(parseFloat($("#qty1").val()) * parseFloat($(
									"#rate1").val())).toFixed(2));
					var resval = $("#itemAmnt1").val(
							(parseFloat($("#qty1").val()) * parseFloat($(
									"#rate1").val())).toFixed(2));
					if (resval.val() == 'NaN') {
						$("#itemAmnt1").val(0.0);
					}
					getAmountOfItems();
				}
			});

	//uploding excel
	/* var object={};

	 function upload()
	 {
	
	 $( "#item-list_1").die();

	 var data = new FormData(),
	 file = $("#file")[0].files[0];
	 data.append( "name", file.name );
	 data.append( "size", file.size );
	 data.append( "type", file.type );
	 data.append( "file", file );
	 data.append("filepath","stockTake");
	 $.ajax(
	 { url: "../../rest/preastaWebService/getFileUpload",
	 dataType: "json",
	 type: "POST",
	 data: data,
	 cache: false,
	 contentType: false,
	
	 processData: false,
	 async:true,
	 success: function(data) {
	 var /* str = JSON.stringify(data);
	
	 var tableRows = tbody.rows.length;
	
	 var date=document.getElementsByName("date");
	
	 var trows=1;
	
	 $.each(data, function(i,item){
	
	
	
	 var itemId = item["itemId"];
	 var quantity = item["itemQuantity"].toFixed(4);
	 var itemRate =item["itemPrice"].toFixed(2);
	 var siteid=item["siteId"];
	 var measurementName=item["measurementName"];
	 var measurementId=item["measurementId"];
	
	 var flag=0;	
	
	 if(trows == 1)
	 {
	
	
	
	 var selectId = POITable.rows[trows].cells[0].getElementsByTagName('select')[0].id;
	 $("#"+selectId).select2();
	
	 var itemSelects = $('#'+selectId);
	 itemSelects.val(itemId).change();
	 $("#"+selectId).on("change",this,function(){getCurrentStock(this);});
	
	 var balenceQuantity = POITable.rows[trows].cells[1].getElementsByTagName('input')[0];
	 balenceQuantity.value = quantity;
	
	 var measurement = POITable.rows[trows].cells[1].getElementsByTagName('span')[0];
	 measurement.innerHTML = measurementName;
	
	 var Rate = POITable.rows[trows].cells[2].getElementsByTagName('input')[0];
	 Rate.value = itemRate;
	
	 var Quantity = POITable.rows[trows].cells[1].getElementsByTagName('input')[0].id;
	 var rateId = POITable.rows[tableRows].cells[2].getElementsByTagName('input')[0].id;
	 var amtId = POITable.rows[tableRows].cells[3].getElementsByTagName('input')[0].id;

	 $("#" + amtId).val(
	 (parseFloat($("#"+ Quantity).val()) * parseFloat($("#"+ rateId).val())).toFixed(2));

	
	 trows=trows+1 ;
	 flag=1;
	
	
	
	 }
	 else{
	
	 var new_row = updateRow(clone.cloneNode(true), ++tbody.rows.length, true);
	 tbody.appendChild(new_row);
	 var i=tbody.rows.length;
	 if(flag==1)
	 {
	 i=i-1;
	 flag=0;
	 }
	 var selectId = new_row.cells[0].getElementsByTagName('select')[0].id;
	
	 $("#"+selectId).select2();
	
	
	
	
	 var itemSelects = $('#'+selectId);
	 itemSelects.val(itemId).change();
	
	 $("#"+selectId).on("change",this,function(){getCurrentStock(this);});
	 var balanceQuantity = new_row.cells[1].getElementsByTagName('input')[0];
	 balanceQuantity.value = quantity;
	
	 var measurement =new_row.cells[1].getElementsByTagName('span')[0];
	 measurement.innerHTML = measurementName;
	
	 var Rate = new_row.cells[2].getElementsByTagName('input')[0];
	 Rate.value = itemRate;
	
	
	 var qtyId = new_row.cells[1].getElementsByTagName('input')[0].id;
	 var rateId = new_row.cells[2].getElementsByTagName('input')[0].id;
	 var itemAmountId = new_row.cells[3].getElementsByTagName('input')[0].id;
	
	

	 $("#" + itemAmountId).val(
	 (parseFloat($("#"+ qtyId).val()) * parseFloat($("#"+ rateId).val())).toFixed(2));

	 $("#"+qtyId).bind('input',function(){
	 $("#"+itemAmountId).val((parseFloat($("#"+qtyId).val())*parseFloat($("#"+rateId).val())).toFixed(2));		
	
	
	 });	
	 }
	 });
	
	 },
	 error: function() { alert('error'); }
	 }); */
	//} 
	//finish upload excel

	function changevalue(val) {

		var i = table.rows.length;
		//alert(i);
		if (i > 2) {
			if (confirm("Are you sure?")) {
				//Ok button pressed...
				var disId = $("#" + val.id).closest('tr').attr('id');
				$("#" + disId).css('display', 'none');

				if ($("#" + val.id).val() == 0) {
					$("#" + val.id).val(1);
				} else {
					$("#" + val.id).val(0);
				}
			} else {
				$("#" + val.id).attr("checked", false);
				return false;
			}

			//alert(val.id); 
		} else {
			//$("#"+val.id).parent().hasClass( "checked" );
			alert("Atleast Need One Record !!!!");
			$("#" + val.id).attr("checked", false);
			return false;
		}

	}

	//functions which are bind on page load

	$(document)
			.ready(
					function() {

						getItemStock();

						function getItemStock() {
							$
									.ajax({
										url : "../../rest/preastaWebService/getItemStock",
										type : "POST",
										contentType : "application/json; charset=utf-8",
										success : function(data) {

											var count = 0;
											var storage = data["data"];

											var itemId = data["data"][0].itemId;

											for ( var i in data["data"]) {
												count++;
												var ide = data["data"][i].itemId
												var f = "flag" + ide;
												itemFlag.push([ f, false ]);
											}
											item = count;

										}
									});
						}

						if ($("#userMasterId").val() != "") {
							$("#userMasterId").attr("readonly", true);
						}

						var val1 = $("#orderMasterId").val();

						if (val1 > 0) {
							$(".disp1").show();
							$(".disp12").show();
							getOrderDetailsList($("#orderMasterId").val());
						} else {

							$(".disp1").hide();
						}
						/*  var val=$('#itemPrice').val();	 
						 if(val==0)
							 {
							 $('.disp12').hide();
							 }*/

						var form1 = $('#stockTakeForm');
						var error1 = $('.alert-danger', form1);
						var success1 = $('.alert-success', form1);

						form1
								.validate({
									errorElement : 'span', //default input error message container
									errorClass : 'help-block help-block-error', // default input error message class
									focusInvalid : false, // do not focus the last invalid input
									ignore : "", // validate all fields including form hidden input

									rules : {

										itemMasterId : {
											required : true
										},
										createdDate : {
											required : true
										},
										userMasterId : {
											required : true,
										},
										quantity : {
											required : true,
										},
									},
									messages : {
										select_multi : {
											maxlength : jQuery.validator
													.format("Max {0} items allowed for selection"),
											minlength : jQuery.validator
													.format("At least {0} items must be selected")
										}
									},

									invalidHandler : function(event, validator) { //display error alert on form submit              
										success1.hide();
										error1.show();
										Metronic.scrollTo(error1, -200);
									},

									highlight : function(element) { // hightlight error inputs
										$(element).closest('.form-group')
												.addClass('has-error'); // set error class to the control group
									},

									unhighlight : function(element) { // revert the change done by hightlight
										$(element).closest('.form-group')
												.removeClass('has-error'); // set error class to the control group
									},

									success1 : function(label) {
										label.closest('.form-group')
												.removeClass('has-error'); // set success class to the control group
									},

								/*  submitHandler: function (form) {
								     success1.show();
								     error1.hide();
								 } */
								});

						$("#addBtn").click(function() {
							var result = checkforitemuniqueness();
							if(result == false){
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
								
							}else{
								  $("#stockTakeForm").submit();	
							}
							/*  $('#stack1').modal('hide'); */
							
						});

						$(".sidebar").removeClass("active");
						$("#order").addClass("active open");
						$("#order")
								.append(
										'<span class="selected"></span><span class="arrow open"></span>');

						// $(".disp2").hide();

						/* $("#userMasterId").change(function() {
						  $(".disp").show();
						  
						}); */

						$("#orderNumber").change(function() {
							if ($("#orderNumber").val() != "") {
								getOrderDetailsList($("#orderNumber").val());
							}
						});

						$('#dateId').datepicker('setDate', new Date());
						/* $('#item-list_1').select2({
						placeholder: "Select Item"
						}); */

						/*  var stockTakeMasterId=document.getElementById('stockTakeMasterId').value;
						 if(stockTakeMasterId!=0)
								{
							         // alert("dfsf");
						       			getItemStockTakeList(stockTakeMasterId); 
						       			$(".submitEdit").show();
										$(".confirm").hide();
								}else{
									$(".submitEdit").hide();
									$(".confirm").show();
								} */
						// alert('h');
						/*  $("#listStockTake").click(function() {
							window.location.href = "../po/filterViewAction.do?stockTakeList=true";
						}); */

						/*  $("table").stupidtable(); */
						$("#qty1")
								.bind(
										'input',
										function() {

											$("#itemAmnt1")
													.val(
															(parseFloat($(
																	"#qty1")
																	.val()) * parseFloat($(
																	"#rate1")
																	.val()))
																	.toFixed(2));
											getAmountOfItems();

										});

						$("#tempDownload").click(function() {
							$("#templateExport").submit();
						});

						var autoComplete = document
								.getElementById('stockTakeForm');
						autoComplete.setAttribute("autocomplete", "off");

						var a = $('#error').text();
						//  var siteId=$('#customerMasterId').val();
						var mm = $('#alertMsg').val();
						//alert(a);
						if (a == "") {
						} else {

							Command: toastr['success']("" + mm + " " + a + "")
							toastr.options = {
								"closeButton" : true,
								"debug" : false,
								"positionClass" : "toast-bottom-full-width",
								"onclick" : null,
								"showDuration" : "1000",
								"hideDuration" : "1000",
								"timeOut" : "5000",
								"extendedTimeOut" : "1000",
								"showEasing" : "swing",
								"hideEasing" : "linear",
								"showMethod" : "fadeIn",
								"hideMethod" : "fadeOut"
							}

						}
						//  $("#dateformate").hide();
						//   $("#datepicker").datepicker("option","maxDate",'+0d');
						//    $("#datepicker").val(document.getElementById("datepicker").innerHTML);
						//    alert('working');
						//if(stockTakeMasterId==0){
						//$( "#datepicker" ).datepicker('setDate', '+0d');
						//} 
						//$( "#datepicker" ).bind('change',("#datepicker").datepicker({ dateFormat:'dd/mm/yyyy' }).val());

						/* $("#btnclick").click(function(){
							 
							 if( $("#stockTakeForm").valid()){	
							  var form=document.getElementById("stockTakeForm");

							  form.target='';
							  form.action="../stock/StockTakeMasterAction.do?param='download'";
							  form.submit();
							 }
							
						  }); */

						$("#cancel")
								.click(
										function() {
											window.location.href = "../po/filterViewAction.do?orderList=true";

										});

						$("#sub")
								.click(
										function() {
											//alert("sdfs");
											$("#submitStatusId").val(1); //In Action Check Submit Buttin Click or Not
											if ($("#stockTakeForm").valid()) {

												$("#sub")
														.prop("disabled", true);
												var form = document
														.getElementById("stockTakeForm");

												form.target = '';
												form.action = "../stock/StockTakeMasterAction.do?param='submit'";

												form.submit();
											}

										});

						$("#update")
								.click(
										function() {
											$("#createOrSubmitSTId").val(1);
											if ($("#stockTakeForm").valid()) {
												var form = document
														.getElementById("stockTakeForm");
												form.target = '';
												form.action = "../stock/StockTakeMasterAction.do?param='submit'";

												form.submit();
											}

										});

						$("#rate1")
								.bind(
										'input',
										function() {
											$("#amt1")
													.val(
															(parseFloat($(
																	"#qty1")
																	.val()) * parseFloat($(
																	"#rate1")
																	.val()))
																	.toFixed(2));
											getAmountOfItems();

										});

					});

	function getOrderDetailsList(orderNumber) {

		var obj = new Object();
		obj.orderNumber = orderNumber;
		var str = JSON.stringify(obj);

		$
				.ajax({
					url : "../../rest/preastaWebService/getOrderDetailsByOrderMasterId",
					type : "POST",
					contentType : 'application/json; charset=utf-8',
					dataType : 'json',
					data : str,
					success : function(data) {

						var str = JSON.stringify(data);

						var tableRows = tbody.rows.length;

						var i;
						for (i = tableRows; i >= 1; i--) {
							if (i != 1) {
								table.deleteRow(i);
							}
						}

						var itemId = table.rows[1].cells[0]
								.getElementsByTagName('select')[0];
						itemId.value = '';

						var itemDescription = table.rows[1].cells[1]
								.getElementsByTagName('input')[0];
						itemDescription.value = '';

						var availableQ = table.rows[1].cells[2]
								.getElementsByTagName('input')[0];
						availableQ.value = '';

						var itemQuantity = table.rows[1].cells[3]
								.getElementsByTagName('input')[0];
						itemQuantity.value = '';

						var itemUnit = table.rows[1].cells[3]
								.getElementsByTagName('span')[0];
						itemUnit.innerHTML = '';

						var itemRate = table.rows[1].cells[4]
								.getElementsByTagName('input')[0];
						itemRate.value = '';

						var itemAmount = table.rows[1].cells[5]
								.getElementsByTagName('input')[0];
						itemAmount.value = '';

						//var arrayLength = data.length;
						//alert(arrayLength);
						var j = 1;
						$
								.each(
										data,
										function(i, item) {

											var itemId = item["itemMasterId"];
											var supplierMasterId = item["supplierMasterId"];
											var measurementId = item["itemMeasurementId"];
											var description = item["description"];
											var measurementName = item["itemMeasurementName"];
											var quantity = item["quantity"];
											var rate = item["rate"].toFixed(2);
											var amount = item["amount"]
													.toFixed(2);
											var orderDetailId = item["orderDetailId"];
											var availableQvalue = item["availableStock"];
											//var isDisable=item["isDisable"];

											if (j == 1) {

												var selectId = table.rows[j].cells[0]
														.getElementsByTagName('select')[0].id;
												var itemSelects = $('#'
														+ selectId);
												itemSelects.val(itemId)
														.change();

												$("#" + selectId)
														.on(
																"change",
																this,
																function() {
																	getCurrentStock(this);
																});

												//itemSelects.trigger('liszt:updated');
												var itemDescription = table.rows[j].cells[1]
														.getElementsByTagName('input')[0];
												itemDescription.value = description;

												var availableQ = table.rows[j].cells[2]
														.getElementsByTagName('input')[0];
												availableQ.value = availableQvalue;

												var qty = table.rows[j].cells[3]
														.getElementsByTagName('input')[0];
												qty.value = quantity;

												var itemUnit = table.rows[j].cells[3]
														.getElementsByTagName('span')[0];
												itemUnit.innerHTML = measurementName;

												var itemRate = table.rows[j].cells[4]
														.getElementsByTagName('input')[0];
												itemRate.value = rate;

												var itemAmount = table.rows[j].cells[5]
														.getElementsByTagName('input')[0];
												itemAmount.value = amount;

												var orderDetailIdVal = table.rows[j].cells[7]
														.getElementsByTagName('input')[0];
												orderDetailIdVal.value = orderDetailId;

												var balenceQty = table.rows[j].cells[3]
														.getElementsByTagName('input')[0].id;
												var qtyRate = table.rows[j].cells[4]
														.getElementsByTagName('input')[0].id;
												var itemAmount = table.rows[j].cells[5]
														.getElementsByTagName('input')[0].id;

												$("#" + itemAmount)
														.val(
																(parseFloat($(
																		"#"
																				+ balenceQty)
																		.val()) * parseFloat($(
																		"#"
																				+ qtyRate)
																		.val()))
																		.toFixed(2));

											} else {

												var new_row = updateRow(clone
														.cloneNode(true),
														++tbody.rows.length,
														true);
												tbody.appendChild(new_row);
												var i = tbody.rows.length;
												var selectId = new_row.cells[0]
														.getElementsByTagName('select')[0].id;
												$("#" + selectId).select2();
												// $("#"+selectId).trigger("liszt:updated");

												var itemSelects = $('#'
														+ selectId);
												itemSelects.val(itemId)
														.change();

												$("#" + selectId)
														.on(
																"change",
																this,
																function() {
																	getCurrentStock(this);
																});

												var itemDescription = new_row.cells[1]
														.getElementsByTagName('input')[0];
												itemDescription.value = description;

												var availableQ = table.rows[j].cells[2]
														.getElementsByTagName('input')[0];
												availableQ.value = availableQvalue;

												var qty = new_row.cells[3]
														.getElementsByTagName('input')[0];
												qty.value = quantity;

												var itemUnit = new_row.cells[3]
														.getElementsByTagName('span')[0];
												itemUnit.innerHTML = measurementName;

												var itemRate = new_row.cells[4]
														.getElementsByTagName('input')[0];
												itemRate.value = rate;

												var itemAmount = new_row.cells[5]
														.getElementsByTagName('input')[0];
												itemAmount.value = amount;

												/*  var orderDetailIdVal= new_row.cells[5].getElementsByTagName('input')[0];
												orderDetailIdVal.value = orderDetailId;
												 */

												var qtyId = new_row.cells[3]
														.getElementsByTagName('input')[0].id;
												var rateId = new_row.cells[4]
														.getElementsByTagName('input')[0].id;
												var itemAmountId = new_row.cells[5]
														.getElementsByTagName('input')[0].id;

												$("#" + itemAmountId)
														.val(
																(parseFloat($(
																		"#"
																				+ qtyId)
																		.val()) * parseFloat($(
																		"#"
																				+ rateId)
																		.val()))
																		.toFixed(2));

												$("#" + qtyId)
														.bind(
																'input',
																function() {
																	$(
																			"#"
																					+ itemAmountId)
																			.val(
																					(parseFloat($(
																							"#"
																									+ qtyId)
																							.val()) * parseFloat($(
																							"#"
																									+ rateId)
																							.val()))
																							.toFixed(2));
																	getAmountOfItems();

																});

											}
											j++;
										});
					}
				});
	}

	//finishes document load binding function

	function getAmountOfItems() {
		$("#total-amt").val(0);
		var i = table.rows.length;
		var j;
		for (j = 1; j < i; j++) {
			var totalId = table.rows[j].cells[5].getElementsByTagName('input')[0].id;
			if (!isNaN($("#" + totalId).val()) && $("#" + totalId).val() != '') {
				$("#total-amt").val(
						parseFloat($("#total-amt").val())
								+ parseFloat($("#" + totalId).val()));
			}
		}
	}
	function deleteRow(el) {

		var val = $('#itemPrice').val();
		if (val == 0) {
			$('.disp12').hide();
		}

		var i = el.parentNode.parentNode.rowIndex;

		if (i != 1) {
			table.deleteRow(i);
			getAmountOfItems();
		}
	}
	function insRow() {

		var val = $('#itemPrice').val();
		//alert(val);
		if (val == 0) {
			$('.disp12').hide();
		}
		var new_row = updateRow(clone.cloneNode(true), ++tbody.rows.length,
				true);

		tbody.appendChild(new_row);
		var selectId = new_row.cells[0].getElementsByTagName('select')[0].id;
		object = new_row.cells[0].getElementsByTagName('select')[0];
		$("#" + selectId).select2({
			placeholder : "Select Item",
			allowClear : true
		});

		/* 	tbody.appendChild(new_row);	
			var selectId1 = new_row.cells[1].getElementsByTagName('select')[0].id;
		
			 object=new_row.cells[1].getElementsByTagName('select')[0];				
			$("#" + selectId1).select2({
			    placeholder: "Select Color Code",
			    allowClear: true
			    
			}); */

		var qtyId = new_row.cells[3].getElementsByTagName('input')[0].id;
		var valueId = new_row.cells[4].getElementsByTagName('input')[0].id;
		var itemAmountId = new_row.cells[5].getElementsByTagName('input')[0].id;

		$("#" + selectId)
				.on(
						"change",
						this,
						function() {
							getCurrentStock(this);
							var rateamt = $("#" + valueId).val();
							if (rateamt != null) {
								$("#" + itemAmountId)
										.val(
												(parseFloat($("#" + qtyId)
														.val()) * parseFloat($(
														"#" + valueId).val()))
														.toFixed(2));
								var resval = $("#" + itemAmountId)
										.val(
												(parseFloat($("#" + qtyId)
														.val()) * parseFloat($(
														"#" + valueId).val()))
														.toFixed(2));
								if (resval.val() == 'NaN') {
									$("#" + itemAmountId).val(0.0);
								}
								getAmountOfItems();
							}
						});

		$("#" + qtyId).bind(
				'input',
				function() {
					$("#" + itemAmountId).val(
							(parseFloat($("#" + qtyId).val()) * parseFloat($(
									"#" + valueId).val())).toFixed(2));
					getAmountOfItems();

				});

	}
	function updateRow(row, i, reset) {

		row.setAttribute("id", i + 1);

		var selectItem = row.cells[0].getElementsByTagName('select')[0];
		selectItem.setAttribute("name", "itemMasterId");//[" + i + "]");

		var t = i;
		var j;

		var selectId = 1;

		for (j = 0; j < i - 1; j++) {
			if (selectId < parseInt(tbody.rows[j].cells[0]
					.getElementsByTagName('select')[0].id.substring(7)))
				;
			{
				selectId = parseInt(tbody.rows[j].cells[0]
						.getElementsByTagName('select')[0].id.substring(7));
			}
		}
		selectId = selectId + 1;
		row.setAttribute("id", i + 1);

		selectId = selectId + 1;
		selectItem.setAttribute("id", "itemId_" + selectId);

		var pack = row.cells[1].getElementsByTagName('input')[0];
		pack.setAttribute("name", "description");//[" + i + "]");
		pack.setAttribute("id", "description" + selectId);

		var qtyInput = row.cells[3].getElementsByTagName('input')[0];
		qtyInput.setAttribute("name", "quantity");//[" + i + "]");
		qtyInput.setAttribute("id", "quantity" + selectId);

		var rate = row.cells[4].getElementsByTagName('input')[0];
		rate.setAttribute("name", "rate");//[" + i + "]");
		rate.setAttribute("id", "rate" + selectId);

		var qtyAmount = row.cells[5].getElementsByTagName('input')[0];
		qtyAmount.setAttribute("name", "amount");//[" + i + "]");
		qtyAmount.setAttribute("id", "amount" + selectId);

		return row;

	}
	function getCurrentStock(el) {
		var customerId = $("#userMasterId").val();
		i = el.parentNode.parentNode.parentNode.rowIndex;

		if (typeof i == "undefined") {
			i = 1;
		}
		var itemId = table.rows[i].cells[0].getElementsByTagName('select')[0].value;
		var obj = new Object();
		obj.itemId = itemId;
		obj.customerId = customerId;

		var str = JSON.stringify(obj);
		$
				.ajax({
					url : "../../rest/preastaWebService/getItemPriceAndMeasurementUnit",
					type : "POST",
					contentType : 'application/json; charset=utf-8',
					dataType : 'json',
					async : false,
					data : str,
					success : function(data) {
						str = JSON.stringify(data);
						var measurementId = data["measurementId"];
						var measurementName = data["measurementName"];
						var itemCost = data["itemPrice"].toFixed(2);
						var availableStock = data["availableStock"].toFixed(2);

						var itemQty = table.rows[i].cells[3].getElementsByTagName('input')[0].value;

						var asq = table.rows[i].cells[2].getElementsByTagName('input')[0];
						asq.value = availableStock;

						var selectMeas = table.rows[i].cells[3]
								.getElementsByTagName('span')[0];
						selectMeas.innerHTML = measurementName;
						var itemprice = table.rows[i].cells[4]
								.getElementsByTagName('input')[0];
						itemprice.value = itemCost;
						var itemAmount = table.rows[i].cells[5]
								.getElementsByTagName('input')[0].id;

					}
				});
	}
	//Below Function is for Site To Item Mapping..
	function itemMapping() {
		var siteId = document.getElementById('userMasterId').value;
		var obj = new Object();
		obj.siteId = siteId;
		var str = JSON.stringify(obj);
		//  alert(str);
		$
				.ajax({
					url : "../../rest/preastaWebService/getItemMappingBySiteId",
					type : "POST",
					contentType : 'application/json; charset=utf-8',
					dataType : 'json',
					data : str,
					success : function(data) {

						//first we delete all the rows in the tabol
						var tableRows = tbody.rows.length;
						var i;
						for (i = tableRows; i >= 1; i--) {
							if (i != 1) {
								table.deleteRow(i);
							}
						}

						//now we clear all the items from the item drop down
						$('#tbody tr').each(
								function() {
									var selectItemList = $(this).find(
											'select[name="itemId"]');
									//var measurementId=$(this).find('input[name="measurementIds"]');
									selectItemList.find('option').remove()
											.end();
									//	$(selectItemList).append("<option value=''></option>");	
								});

						if (data != '') {
							var str = JSON.stringify(data);
							//alert(str);
							var arrayLength = data.length;

							$('#tbody tr')
									.each(
											function() {
												var selectItemList = $(this)
														.find(
																'select[name="itemId"]');
												$(selectItemList)
														.append(
																"<option value=''></option>");

												$
														.each(
																data,
																function(i,
																		item) {

																	var itemList = item["itemName"];
																	var itemId = item["itemId"];
																	var measurementId = item["itemMeasurementId"];
																	var measurementName = item["itemMeasurementName"];
																	//var itemPrice = item["itemPrice"];

																	$(
																			selectItemList)
																			.append(
																					"<option value='" +itemId + "'>"+ itemList+ "</option>");
																	var selectMeasId = table.rows[1].cells[1].getElementsByTagName('input')[2];
																	selectMeasId.value = measurementId;

																});
											});

						}

					}
				});

	}
	function back() {
		window.location = '../po/filterViewAction.do?stockTakeList=true';
	}

	function checkforitemuniqueness() {
		var rowcount = tbody.rows.length;
		var itemid = [];
		for (var i = 0; i < rowcount; i++) {
			itemid.push(tbody.rows[i].cells[0].getElementsByTagName('select')[0].value);
		}

		var result = true;

		for (var i = 0; i < itemid.length; i++) {
			for (var j = 0; j < itemid.length; j++) {
				if(i!=j){
				if (itemid[i] == itemid[j]) {
					result = false;
					return false;
				}
				}
			}
		}

		return true;
	}
</script>
