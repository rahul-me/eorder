<script type="text/javascript">

	$(document).ready(function(){		
			getPkgList();
			
			
	})
	
	function getPkgList()
	{		
		$('#dtable').dataTable({
			"sAjaxSource" : "../../rest/masterDataMgmtService/getAllPkg", 
			"bProcessing": true, 
			"aoColumns":[{"mDataProp":"pkgid"},
			             {"mDataProp":"pkgname"},
			             {"mDataProp":"pkgdesc"},
			             {"mDataProp":"pkgcreatedby"},
			             {"mDataProp":"pkgactivestatus"},
			             {"mDataProp":"pkgcharge"},
			             {"mDataProp":"editoption"}],
			"aLengthMenu":[[50,100,500,-1],[50,100,500,"All"]],
			"iDispalyLength":100,
		});
	}
	
	function deletePkg(id)
	{
		var v=id;	
		window.location="../../view/master/ViewPackagesAction.do?pkgIdfordelete="+v;
		
	}
	
	function editpkg(id)
	{
		var v=id;		
		window.location="../../view/master/ViewPackagesAction.do?pkgIdforedit="+v;
	}
	
</script>