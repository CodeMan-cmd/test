$(function(){
	$("[name='userCode']").blur(function(){
		var c=$(this).val();
		$.ajax({
			type:"post",
			url:"resCode?userCode="+c,
			dataType:"JSON",
			success:function(resu){
				$("#userCode").html(resu.name);
			}
			
		});
		
	});
	
});