function toTop() {
	jQuery("#shou").click(function() {
		jQuery.ajax({
			type : "get",
			url : "statics/cc",
			dataType : "JSON",
			// 当 AJAX 请求成功完成时，触发
			success : function(resu) {
				$("[name=dangqianyema]").val(1);
			}
		});
	});
}
toTop();

function toTop1() {
	jQuery("#shang").click(function() {
		jQuery.ajax({
			type : "get",
			url : "statics/cc",
			dataType : "JSON",
			success : function() {
				var s = parseInt($("[name=dangqianyema]").val()) - 1;
				$("[name=dangqianyema]").val(s);
			}
		});

	});
}

toTop1();

function toEnd() {
	jQuery("#xia").click(function() {
		jQuery.ajax({
			type:"get",
			url:"statics/cc",
			dataType:"JSON",
			success:function(){
				var s = parseInt($("[name=dangqianyema]").val()) + 1;
				$("[name=dangqianyema]").val(s);
			}
		});
	});
}
toEnd();
function toEnd1(abc) {
	jQuery("#wei").click(function() {
		jquery.ajax({
			type:"get",
			url:"statics/cc",
			dataType:"JSON",
			success:function(){
				$("[name=dangqianyeshu]").val(abc);
			}
		});
	});
}
toEnd1(abc);