 <script type="text/javascript">

$(document).ready(function(){
	
	$('.filter').hide();
	
	$('#reportSubId').change(function(){
		
		if($('#reportSubId option:selected').val()!=''){
			$('.filter').show();
		}else{	$('.filter').hide();}
		
	});
	
$('#reportId').change(function(){
		
		$('#reportSubId option').remove();
		
		var ReportSelval=$('#reportId option:selected').val();
	
		if(ReportSelval=='SCM_GR'){
			$('#reportSubId').append($('<option></option>').val('').html(''));
		 	$('#reportSubId').append($('<option></option>').val('SCM_GR_Detail_Report').html('GR Detail Report')); 
			$('#reportSubId').append($('<option></option>').val('SCM_GR_list_Report').html('GR List Report'));
			$('#reportSubId').append($('<option></option>').val('SCM_GR_list_Sitewise').html('GR List Sitewise'));
			$('.label-success').text('Select Here Good Receipt Related Report');
		}
		else if(ReportSelval=='SCM_PO'){
			$('#reportSubId').append($('<option></option>').val('').html(''));
			$('#reportSubId').append($('<option></option>').val('SCM_PO_Detail_Report').html('PO Detail Report'));
			$('#reportSubId').append($('<option></option>').val('SCM_PO_list_Report').html('PO List Report'));
			$('#reportSubId').append($('<option></option>').val('SCM_PO_List_Sitewise').html('PO List Sitewise'));
			$('#reportSubId').append($('<option></option>').val('SCM_POwise_Item_Summary_Report').html('PO Item Summary Report'));
			$('.label-success').text('Select Here Purchase Order Related Report');
		}
		else if(ReportSelval=='SCM_TO'){
		//	document.write('mmsdfs');
			$('#reportSubId').append($('<option></option>').val('').html(''));
			$('#reportSubId').append($('<option></option>').val('SCM_TO_Detail_Report').html('TO Detail Report'));
			$('#reportSubId').append($('<option></option>').val('SCM_TO_list_Report').html('TO List Report'));
			$('#reportSubId').append($('<option></option>').val('SCM_TO_List_Sitewise').html('TO List Sitewise'));
			$('#reportSubId').append($('<option></option>').val('SCM_TOwise_Item_Summary_Report').html('TO Item Summary Report'));
			$('.label-success').text('Select Here Transfer Order Related Report');
			//$('#reportSubId').change();
			}
		else if(ReportSelval=='SCM_ITEMS'){
			$('#reportSubId').append($('<option></option>').val('').html(''));
			$('#reportSubId').append($('<option></option>').val('SCM_Item_master').html('Item Master Report'));
			$('#reportSubId').append($('<option></option>').val('SCM_Item_Summary_Report').html('Summary Report'));
			/* $('#reportSubId').append($('<option></option>').val('SCM_Item_Status_Report').html('Item Status Report'));
			$('#reportSubId').append($('<option></option>').val('SCM_Item_Status_Sitewise').html('Item Status Sitewise'));
			$('#reportSubId').append($('<option></option>').val('SCM_Item_Stock_Detail').html('Item Stock Detail '));
			$('#reportSubId').append($('<option></option>').val('SCM_Item_value_of_stock').html('Item Value of stock Report ')); */
			$('.label-success').text('Select Here Item Related Report');
			
			
		}
		else if(ReportSelval=='SCM_INDIVIDUAL_LIST_REPORT'){
			$('#reportSubId').append($('<option></option>').val('').html(''));
			$('#reportSubId').append($('<option></option>').val('SCM_Individual_View_Report').html('Individual View Report'));
			$('.label-success').text('Select Here Individual List Related Report');
			
		}
		else if(ReportSelval=='SCM_PNL'){
			$('#reportSubId').append($('<option></option>').val('').html(''));
			 $('#reportSubId').append($('<option></option>').val('SCM_Goods_Consumption_Report_Categorywise').html('Categorywise Report')); 
			$('#reportSubId').append($('<option></option>').val('SCM_Goods_Consumption_Report_Itemwise').html('Itemwise Report'));
			 $('#reportSubId').append($('<option></option>').val('SCM_Goods_Consumption_Report_Subcategorywise').html('Subcategorywise Report')); 
			$('.label-success').text('Select Here PNL Report');
			
		}
		else if(ReportSelval=='SCM_FILLRATE'){
			$('#reportSubId').append($('<option></option>').val('').html(''));
			$('#reportSubId').append($('<option></option>').val('SCM_Itemwise_Fill_Rate_Report').html('ItemWise Report'));
			$('#reportSubId').append($('<option></option>').val('SCM_POwise_Fill_Rate_Report').html('POWise Report'));
			$('.label-success').text('Select Here FillRate Report');
			
		}
		else if(ReportSelval=='SCM_STOCK'){
			$('#reportSubId').append($('<option></option>').val('').html(''));
			$('#reportSubId').append($('<option></option>').val('SCM_Stocktake_Detail_Report').html('Stocktake Detail Report'));
			$('.label-success').text('Select Here FillRate Report');
			
		}
		
		
	});
	
	/* var reportName=location.search.split("=");
	var reportNameVal=reportName[1].split("&");
	var jasperFolderName=reportNameVal[0];
	var jasperReportName=reportNameVal[1]; */
	
	
	//$('#rName').text(reportNameVal[1]);
	
	 $(".selectFilter").show();
     $(".siteId").show();
     $(".supplierId").show();
     $(".itemIds").show();
     $(".itemCategoryId").show();
     $(".POStatusId").show();
     $(".TOStatusId").show();
     $(".GRByStatusId").show();
     $(".stockStatus").show();
     $(".date").show();
     $(".critical").show();
     $(".activeItemState").show();
     $(".stockType").show();
     $(".plCategory").show();
     //$(".userN").show();
     
     
      $("#plCategoryId").change(function(){
    	 
    	 if($("#plCategoryId").val()!=null){
    		
    		 var plCatId= $('#plCategoryId').val();
    			//alert(plCatId);
    			$.ajax({
    						url : "../rest/FillRateService/getPLSuperTypeByCategoryId?plCatId="+plCatId,
    						type : "POST",
    						contentType : 'application/json; charset=utf-8',
    						dataType : 'json',
    					//	async : false,
    						success : function(data) {
    						//	data = $.parseJSON(data);
    						 $(".plSuperType").show();
    						 $('#plSuperTypeId option').remove();
    							$.each(data, function(i,item){
    									  var Id = item["plCategoryId"];
    									  var Name = item["plCategoryName"];
    									  $('#plSuperTypeId').append($('<option></option>').val(Id).html(Name));
    									 
    							});
    							
    						}
    			});
    					
    		 }else{
    			 
				 $('#plSuperTypeId option').remove();
				 $(".plSuperType").hide();
    		 }
    	 });
     


    $("#filter  option[value='siteId']").remove();
    $("#filter  option[value='supplierId']").remove();
    $("#filter  option[value='date']").remove();
    $("#filter  option[value='itemIds']").remove();
    $("#filter  option[value='itemCategoryId']").remove();
    
    
    $("#report-frame").hide();
    
     $("#filterBTN").click(function(event){
    	 
    	 var jasperFolderName=$('#reportId option:selected').val();
    		var jasperReportName=$('#reportSubId option:selected').val();
    		
  	  
    		//  var oTable = $('#example').dataTable();
  	  var suppId=$('#supplierId').val();
  	 // alert(suppId);
  	  var siteId=$('#siteId').val();
  	 var POStatus=$('#POStatus').val();
  	 var fromDate=$('#datepicker2').val();
  //	 alert(fromDate);
  	 var toDate=$('#datepicker1').val();
  	 var PO_Number=$('#PO').val();
  	 var itemId=$('#itemId').val();
 	  var itemCategoryId=$('#itemCategoryId').val();
 	 var userId=$('#userId').val();
 	var TO_Number=0;
 	var GR_Number=0;
 	var isActive=$('#isActive').val();
 	var isCritical=$('#isCritical').val();
 	var stockType=$('#stock-Type').val();
 	var plCategoryId=$('#plSuperTypeId').val();
 	var plSuperTypeId=$('#plCategoryId').val();
 	
 	if(plCategoryId==null || plCategoryId=="" || plCategoryId=='null'){
 		plCategoryId=0;
	  }
 	if(plSuperTypeId==null || plSuperTypeId=="" || plSuperTypeId=='null'){
 		plSuperTypeId=0;
	  }
 	if(stockType==null || stockType=="" || stockType=='null'){
 		stockType=0;
	  }
 	//alert(isCritical);
 	  if(suppId==null || suppId=="" || suppId=='null'){
 		  suppId=0;
 	  }
 	 if(siteId==null || siteId=="" || siteId=="null"){
 		siteId=0;
	  }
 	if(POStatus==null || POStatus=="" || POStatus=="null"){
 		POStatus=0;
	  }
 	if(itemId==null || itemId=="" || itemId=="null"){
 		itemId=0;
	  }
 	if(itemCategoryId==null || itemCategoryId=="" || itemCategoryId=="null"){
 		itemCategoryId=0;
	  }
 
 	if(userId==null || userId=="" || userId=="null"){
 		userId=0;
	  }

 	if(PO_Number==null || PO_Number=="" || PO_Number=="null"){
 		PO_Number=0;
	  }
 	if(TO_Number==null || TO_Number=="" || TO_Number=="null"){
 		TO_Number=0;
	  }
 	if(GR_Number==null || GR_Number=="" || GR_Number=="null"){
 		GR_Number=0;
	  }
 	if(isActive==null || isActive=="" || isActive=="null"){
 		isActive=-1;
 		//alert(isActive);
	  }
 	if(isCritical==null || isCritical=="" || isCritical=="null"){
 		isCritical=-1;
 		//alert(isCritical);
	  }
 	//alert(plSuperTypeId);
 	//alert(plCategoryId);
 	document.getElementById('js').setAttribute("src", "/jasperserver/flow.html?_flowId=viewReportFlow&standAlone=true&_flowId=viewReportFlow&ParentFolderUri=%2Freports%2FSCM_REPORTS_1%2F"+jasperFolderName+"&reportUnit=%2Freports%2FSCM_REPORTS_1%2F"+jasperFolderName+"%2F"+jasperReportName+"&fromDate="+fromDate+"&toDate="+toDate+"&hotelName="+"DUM-A-DUM"+"&siteId="+siteId+"&stockType="+stockType+"&itemId="+itemId+"&itemCategory="+itemCategoryId+"&userId="+userId+"&supplierId="+suppId+"&status="+POStatus+"&PO_Number="+PO_Number+"&TO_Number="+TO_Number+"&GR_Number="+GR_Number+"&isActive="+isActive+"&isCritical="+isCritical+"&plSuperCategoryId="+plSuperTypeId+"&plSubCategoryId="+plCategoryId+"&j_acegi_security_check?&j_username=jasperadmin&j_password=jasperadmin");
	 $("#report-frame").show();
 	       
  	   }); 
       
 
	
});
</script>