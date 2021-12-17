 <script type="text/javascript">
 $('#example tbody tr').live( 'click', function (event) {
	    var purchaseMasterId = $(this).find("td:first").html(); 
	    window.location="../../po/PurchaseOrderMasterViewAction.do?purchaseOrderId="+purchaseMasterId;
	});
 
    $(document).ready(function() {
    	 var fromDate=$('#datepicker2').val();
    	 $("#POStatus").val("1").change();
    	 var POStatus=$('#POStatus').val();
  	 var toDate=$('#datepicker1').val();
  	$('#example').dataTable( {
            "sAjaxSource" : "../../rest/FillRateService/getItemPurchaseListByFilter?&fromDate="+fromDate+"&toDate="+toDate+"&POStatus="+POStatus,
            "bProcessing": true,
            "bFilter": false,
            "aoColumns":[
                         {"mDataProp":"mpo"},
                         {"mDataProp":"purchaseOrderMasterId"},
                         {"mDataProp":"supplierId"},
                         {"mDataProp":"Creator"},
                         {"mDataProp":"PoSite"},
                         {"mDataProp":"Status"},
                       	 {"mDataProp":"TotalquantityCritical","mRender": function ( data, type, full ) {return data.toFixed(2);}},
                         {"mDataProp":"TotalquantityServicedByTOCritical","mRender": function ( data, type, full ) {return data.toFixed(2);}},
                         {"mDataProp":"TotalquantityServicedByGRCritical","mRender": function ( data, type, full ) {return data.toFixed(2);}},
                         {"mDataProp":"Totalquantity","mRender": function ( data, type, full ) {return data.toFixed(2);}},
                         {"mDataProp":"TotalquantityServicedByTO","mRender": function ( data, type, full ) {return data.toFixed(2);}},
                         {"mDataProp":"TotalquantityServicedByGR","mRender": function ( data, type, full ) {return data.toFixed(2);}},
                         {"mDataProp":"export"}
                         ],
                "oLanguage": {
                    "sSearch": "Search all columns:"
                 },
                 "aoColumnDefs" : [ {
                     'bSortable' : false,
                     'aTargets' : [ 5,6 ]
                 } ],
                  
               /*   fnFooterCallback: function (nRow, aaData, iStart, iEnd, aiDisplay) {
              			  var TotalMarks = 0;
                 	    for ( var i=0 ; i<aaData.length ;i++ )
                 	    {
                 	    	TotalMarks+=aaData[i]["TotalBill"];
                 	    } 

                 	    var nCells = nRow.getElementsByTagName('th');
                 	    nCells[5].innerHTML = TotalMarks.toFixed(3);  
                     
                 } */
             
                	
              
                 
        } );
      
  	
    $('#example').on('page', function () {
  	  $("#select-all").prop('checked', false);
  	  $.uniform.update();
    } );
      
      
      $(".selectFilter").show();
      $(".siteId").show();
      $(".supplierId").show();
      $(".POStatusId").show();
      $(".date").show();
      $(".POId").show(); 
      $(".itemIds").show(); 
      $(".itemCategoryId").show();
      

      $("#filter  option[value='siteId']").remove();
      $("#filter  option[value='supplierId']").remove();
      $("#filter  option[value='date']").remove();
    
} );   
    
    
    
    
	 
  
    
    $("#filterBTN").click(function(event){
  	  
  	  var oTable = $('#example').dataTable();
  	  var suppId=$('#supplierId').val();
  	  var siteId=$('#siteId').val();
  	 var POStatus=$('#POStatus').val();
  	 var fromDate=$('#datepicker2').val();
  	 var itemId=$('#itemId').val();
  	var itemCategoryId=$('#itemCategoryId').val();
  	
  	
  //	 alert(fromDate);
  	 var toDate=$('#datepicker1').val();
  	 var POId=$('#PO').val();
  	//alert(POId);
  	//alert(siteId);
  	if(oTable!=null) oTable.fnDestroy();
  	    $('#example').dataTable( {
        "sAjaxSource" : "../../rest/FillRateService/getItemPurchaseListByFilter?suppId="+suppId+"&siteId="+siteId+"&itemId="+itemId+"&itemCategoryId="+itemCategoryId+"&fromDate="+fromDate+"&toDate="+toDate+"&POStatus="+POStatus+"&POId="+POId,
             "bProcessing": true,
             "aoColumns":[
                          {"mDataProp":"mpo"},
                          {"mDataProp":"purchaseOrderMasterId"},
                          {"mDataProp":"supplierId"},
                          {"mDataProp":"Creator"},
                          {"mDataProp":"PoSite"},
                          {"mDataProp":"Status"},
                          {"mDataProp":"TotalquantityCritical","mRender": function ( data, type, full ) {return data.toFixed(2);}},
                          {"mDataProp":"TotalquantityServicedByTOCritical","mRender": function ( data, type, full ) {return data.toFixed(2);}},
                          {"mDataProp":"TotalquantityServicedByGRCritical","mRender": function ( data, type, full ) {return data.toFixed(2);}},
                          {"mDataProp":"Totalquantity","mRender": function ( data, type, full ) {return data.toFixed(2);}},
                          {"mDataProp":"TotalquantityServicedByTO","mRender": function ( data, type, full ) {return data.toFixed(2);}},
                          {"mDataProp":"TotalquantityServicedByGR","mRender": function ( data, type, full ) {return data.toFixed(2);}},
                          {"mDataProp":"export"}
                          ],
            "oLanguage": {
                "sSearch": "Search all columns:"
             },
             "aoColumnDefs" : [ {
                 'bSortable' : false,
                 'aTargets' : [ 5,6 ]
             } ],
            /*  fnFooterCallback: function (nRow, aaData, iStart, iEnd, aiDisplay) {
     			  var TotalMarks = 0;
        	    for ( var i=0 ; i<aaData.length ;i++ )
        	    {
        	    	TotalMarks+=aaData[i]["TotalBill"];
        	    } 

        	    var nCells = nRow.getElementsByTagName('th');
        	    nCells[5].innerHTML = TotalMarks.toFixed(3);  
            
        } */
             
  	   }); 
  	    
  } );
  
</script> 