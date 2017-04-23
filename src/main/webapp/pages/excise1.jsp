<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>excise1</title>
	<style type="text/css">
		body{
			margin: 0;
			padding: 0;
		}
		.main{
			width: 800px;
			height: 600px;
			background-color: #ccc;
			margin: 0 auto;
		}
		.left{
			height: 600px;
			width: 200px;
			background: yellow;
			float: left;
		}
		.right{
			height: 600px;
			width: 600px;
			background: #369;
			float: right;
		}
		.sub_l{
			height: 600px;
			width:400px;
			background: green;
			float: left;
		}
		.sub_r{
			height: 600px;
			width:200px;
			background: #09F;
			float: right;
		}
		.top{
			height: 100px;
			background: blue;
		}
		.head{
			height: 100px;
			width: 800px;
			background: #f60;
			margin: 0 auto;
		}
		.foot{
			width: 800px;
			height: 100px;
			background-color: #900;
			margin: 0 auto;
		}
	</style>
</head>
<body>
	<div class="top">
		<div class="head"></div>
	</div>
	<div class="main">
		<div class="left"></div>
		<div class="right">
			<div class="sub_l"></div>
			<div class="sub_r"></div>
		</div>
	</div>
	<div class="foot"></div>
</body>
</html>