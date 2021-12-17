$(document).ready(function(){
	$("#btnId").click(function(){
		get();
		get(1,2,3);
		get("abc","123");
		var var1 = $("#btnId").val();
		console.log(var1, $("#btnId").val());
	});
	
	function get(a)
	{
		console.log(typeof a, arguments.length);
	}
});