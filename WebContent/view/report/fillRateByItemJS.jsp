 <script type="text/javascript">
 
 $('#example tbody tr').live( 'click', function (event) {
	    var purchaseMasterId = $(this).find("td:first").html(); 
	    window.location="../../po/PurchaseOrderMasterViewAction.do?purchaseOrderId="+purchaseMasterId;
	});
 
    $(document).ready(function() {
    	 
    
    	 $( "#datepicker2" ).datepicker({
 		} ); 
    	 
    	/*  $('#datepicker2').change(function(){
    		 alert($( "#datepicker2" ).val());
    	 }); */
    	
 //sds
 
    	$('.dateFilter').show();
    	 var fromDate=$('#datepicker2').val();
    	 $("#POStatus").val("1").change();
    	 var POStatus=$('#POStatus').val();
    	 var dateFilter=$("#dateFilter option:selected").val();
  	 var toDate=$('#datepicker1').val();
  	$('#example').dataTable( {
            "sAjaxSource" : "../../rest/FillRateService/getFillRateByItem?&fromDate="+fromDate+"&toDate="+toDate+"&dateFilter="+dateFilter+"&POStatus="+POStatus,
            "bProcessing": true,
            "bFilter": false,
          	       "aoColumns":[
                         {"mDataProp":"item","sWidth": "15%"},
                         {"mDataProp":"POQty","mRender": function ( data, type, full ) {return data.toFixed(2);}},
                       	 {"mDataProp":"ServicedQty","mRender": function ( data, type, full ) {return data.toFixed(2);}},
                         {"mDataProp":"fillRate","mRender": function ( data, type, full ) {return data.toFixed(2);}},
                         {"mDataProp":"Status"},
                         {"mDataProp":"criticalItem"},
                         {"mDataProp":"site","sWidth": "20%"},
                         {"mDataProp":"supplier","sWidth": "20%"},
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
   //   $(".date").show();
	   $(".dateSelectLable").show();
      $(".well").show();
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
  	 var fromDate=a;
  	 
  	
  	 
  	 var itemId=$('#itemId').val();
  	var itemCategoryId=$('#itemCategoryId').val();
  	var dateFilter=$("#dateFilter option:selected").val();
  	
  	
  	//var d = new Date();
   // d.format(yyyy-MM-dd);
	//alert(d);
  	 var toDate=b;
  	 var POId=$('#PO').val();
  	//alert(POId);
  	//alert(siteId);
  	if(oTable!=null) oTable.fnDestroy();
  	    $('#example').dataTable( {
        "sAjaxSource" : "../../rest/FillRateService/getFillRateByItem?suppId="+suppId+"&siteId="+siteId+"&dateFilter="+dateFilter+"&itemId="+itemId+"&itemCategoryId="+itemCategoryId+"&fromDate="+fromDate+"&toDate="+toDate+"&POStatus="+POStatus+"&POId="+POId,
             "bProcessing": true,
             "aoColumns":[
                          {"mDataProp":"item","sWidth": "15%"},
                          {"mDataProp":"POQty","mRender": function ( data, type, full ) {return data.toFixed(2);}},
                          {"mDataProp":"ServicedQty","mRender": function ( data, type, full ) {return data.toFixed(2);}},
                          {"mDataProp":"fillRate","mRender": function ( data, type, full ) {return data.toFixed(2);}},
                          {"mDataProp":"Status"},
                          {"mDataProp":"criticalItem"},
                          {"mDataProp":"site","sWidth": "15%"},
                          {"mDataProp":"supplier","sWidth": "20%"},
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