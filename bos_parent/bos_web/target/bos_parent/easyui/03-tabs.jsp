<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>layout</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>
</head>
<body class="easyui-layout">
	<!-- 使用div元素描述每个区域 -->
	<div title="第五人格管理系统" style="height: 100px" data-options="region:'north'">北部区域</div>
	<div title="系统菜单" style="width: 200px" data-options="region:'west'">
		<div class="easyui-accordion" data-options="fit:true">
			<div title="面板1">
				<a id="but1" class="easyui-linkbutton">添加一个选项卡</a>
				<script type="text/javascript">
					$(function(){
						$("#but1").click(function(){
							//alert(111);
							var e = $("#mytabs").tabs("exists","管理系统");
							if(e){
								var e = $("#mytabs").tabs("select","管理系统");
							}else{
								$("#mytabs").tabs("add",{
									title:'管理系统',
									iconCls:'icon-edit',
									closable:true,
									content:'<iframe frameborder="0" width="100%" height="100%" src="https://www.baidu.com"></iframe>'
								});
							}
						});
					});
				</script>
			</div>
			<div title="面板2">222</div>
			<div title="面板3">333</div>
		</div>
	</div>
	<div data-options="region:'center'">
		<div class="easyui-tabs" data-options="fit:true" id="mytabs">
			<div title="面板1" data-options="iconCls:'icon-cut'">111</div>
			<div title="面板2" data-options="closable:true">222</div>
			<div title="面板3">333</div>
		</div>
	</div>
	<div style="width: 100px" data-options="region:'east'">东部区域</div>
	<div style="height: 50px" data-options="region:'south'">南部区域</div>
</body>
</html>