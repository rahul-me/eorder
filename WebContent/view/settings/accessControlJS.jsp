<script type="text/javascript">
	

	// on DOM ready
	$(document).ready(function (){
		
		$("#select2").bind("change",function(event){
			userRoleId = $('#select2').val();
			
				if(userRoleId>0)
					setAccessRoles(userRoleId);
				else
				{
					$("input[type=checkbox]").each(function ()
						{
						 	$(this).prop('checked',false);
						 	 $.uniform.update();
				    	});
				}
			
			
			
			
			$("[name=select-all]").click(function(event){
				var myID=$(this).attr('id');
				if ($("#"+myID).is(':checked'))
				{
					$("input[type=checkbox]",$("#"+myID+"Table")).prop('checked', true);
					
				}
				else 
				{
					$("input[type=checkbox]",$("#"+myID+"Table")).prop('checked', false);
					
				}
				$.uniform.update();
			   });
			
		}); 
		
		
		$("#cancel").click(function(event){
			   window.location.href = "../settings/accessContol.jsp"; 
			  });
		
		
		$("#select2").select2({
			placeholder : "Select Role"
		});
		
	  	$("#select2").change();
	  
		   
	});
	
	function setAccessRoles(userRoleId)
	{
		var obj=new Object();
    	obj.roleId = userRoleId;
    	var str = JSON.stringify(obj);
    	
		$.ajax({
			    url: "../../rest/masterDataMgmtService/getAccessContols"
			    , type: "POST"
			    , contentType: 'application/json; charset=utf-8'
			    , dataType: 'json'
			    , async:false
			    , data: str
			    , success: function (data) {
			    	//alert("hi");
			    	$("input[type=checkbox]").each(function () {
 					 	$(this).prop('checked',false);
 					 	 $.uniform.update();
 			    	});
               // alert(str);
            		var results = JSON.stringify(data); //$.parseJSON(data);
			    	$.each(data, function(i,options){
			    			var role=options["moduleName"];
			    			$("#"+role).prop("checked",true);
						 	$.uniform.update();
			    			//$("#"+role).click();
					}); 
			    }
			});
	}
	</script>