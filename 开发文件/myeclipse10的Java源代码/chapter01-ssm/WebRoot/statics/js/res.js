$(function(){
	$("[name='userCode']").blur(function(){
		var c=$(this).val();
		$.ajax({
			type:"get",
			url:"resCode?userCode="+c,
			dataType:"JSON",
			success:function(resu){
				$("[id='userCode']").html(resu.name);
			}
			
		});
		
	});
	
});