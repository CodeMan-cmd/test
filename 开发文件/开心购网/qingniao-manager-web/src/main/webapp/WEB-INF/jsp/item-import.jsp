<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div>
	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="importItems()">导入商品数据到索引库</a>
</div>
<script type="text/javascript">
	function importItems(){
		$.post("/item/import",null,function(data){
			console.log(data);
			if(data.status == 200){
				$.messager.alert('提示','数据添加成功!');
			}else{
				$.messager.alert('提示','数据添加失败!');
			}
		});
	}
</script>
	