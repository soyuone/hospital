<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Hospital</title>
	
	<link href="../assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link href="../assets/plugins/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
	<link href="../assets/plugins/bootstrap/css/templatemo_style.css" rel="stylesheet" type="text/css">
	<link href="../assets/plugins/icheck/skins/all.css" rel="stylesheet" type="text/css">
	<link href="../assets/plugins/bootstrap-datepicker/css/bootstrap-datepicker.css" rel="stylesheet" type="text/css">	
	<style type="text/css">
		.templatemo-bg-gray {
			background-color: rgb(70, 90, 40);
			background-image: url(../assets/plugins/bootstrap/images/background_login.jpg);
			background-repeat: no-repeat;
			background-position: center center;
			background-attachment: fixed;
			background-size: cover;
		}
		h1{
		margin:auto auto auto;
		}
	</style>
	</head>
	
	<body class="templatemo-bg-gray">
		<div class="container">
			<div class="col-md-12">			
				<form class="form-horizontal templatemo-create-account templatemo-container" style="margin-top: 35px;" role="form" action="#" method="post">
					<div class="form-inner">
				        <div class="form-group">
				          <div class="col-md-12">		          	
				            <h1 >注册账号</h1>	            		            		            
				          </div>              
				        </div>
						<div class="form-group">
				          <div class="col-md-6">		          	
				            <label for="user_name" class="control-label">用户名</label>
				            <input type="text" class="form-control" id="user_name" placeholder="请输入用户名">		            		            		            
				          </div>  
				          <div class="col-md-6">		          	
				            <label for="real_name" class="control-label">姓名</label>
				            <input type="text" class="form-control" id="real_name" placeholder="请输入姓名">		            		            		            
				          </div>             
				        </div>
				        <div class="form-group">
				          <div class="col-md-12">		          	
				            <label for="email" class="control-label">Email</label>
				            <input type="email" class="form-control" id="email" style="width:48%" placeholder="请输入Email">		            		            		            
				          </div>              
				        </div>			
				        <div class="form-group">
				          <div class="col-md-6">		          	
				            <label for="birthday" class="control-label">出生日期</label>
				            <input type="text" class="form-control" id="birthday" placeholder="请选择出生日期" data-date-format="yyyy-mm-dd">		            		            		            
				          </div>
				          <div class="col-md-6 templatemo-radio-group">
				          	<label class="radio-inline">
			          			<input type="radio" name="sex" class="i-grey" id="optionsRadios" value="男" checked> 男
			          		</label>
			          		<label class="radio-inline">
			          			<input type="radio" name="sex" class="i-grey" id="optionsRadios" value="女"> 女
			          		</label>
				          </div>             
				        </div>
				        <div class="form-group">
				          <div class="col-md-6">
				            <label for="password" class="control-label">密码</label>
				            <input type="password" class="form-control" id="password" placeholder="请输入密码">
				          </div>
				          <div class="col-md-6">
				            <label for="password_confirm" class="control-label">密码确认</label>
				            <input type="password" class="form-control" id="password_confirm" placeholder="请再次输入密码">
				          </div>
				        </div>
				        <div class="form-group">
				          <div class="col-md-12">
				            <label><input type="checkbox" id="privacy" value="privacy" class="i-grey"> 我同意 <a href="javascript:;" data-toggle="modal" data-target="#templatemo_modal">隐私政策</a> 和服务协议.</label>
				          </div>
				        </div>
				        <div class="form-group">
				          <div class="col-md-12">
				            <input type="button" value="确认注册" class="btn btn-info" onclick="register()">
				            <a href="register.jsp" class="pull-right">重置</a>
				          </div>
				        </div>	
					</div>				    	
			      </form>		      
			</div>
		</div>
		
		<!-- Modal框 -->
		<div class="modal fade" id="templatemo_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
		        <h4 class="modal-title" id="myModalLabel">隐私政策</h4>
		      </div>
		      <div class="modal-body">
		      	<p>您成为本网站用户前务必仔细阅读本隐私条款并同意本隐私条款。作为本网站服务的正常操作程序的一部分，本网站收集、使用并（在一些情况下）向第三方披露有关您的资料。本隐私条款作为本网站服务协议的附件，在您注册成为本网站用户后立即生效，并对您及本网站产生约束力。</p>
		      	<p>如果您利用本网站的服务向没有在本网站内注册的电子邮件地址发出电子邮件,本网站除了利用该电子邮件地址发出您的电子邮件之外将不作任何其他用途。本网站不会出租或出售这些电子邮件地址。本网站不会永久储存电子邮件信息或电子邮件地址。</p>
		      	<p>本网站可能不时按照您的意见和本网站的需要修改本隐私条款，以准确地反映本网站的资料收集及披露惯例。本条款的所有修改，在本网站公布有关修改内容后自动生效或在该等条款指定的日期生效。</p>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		      </div>
		    </div>
		  </div>
		</div>
		<script src="../assets/plugins/jquery/jquery-3.1.1.js"></script>
		<script src="../assets/plugins/bootstrap/js/bootstrap.js"></script>
		<script src="../assets/plugins/icheck/icheck.js"></script>
		<script src="../assets/plugins/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
		<script src="../assets/plugins/bootstrap-datepicker/locales/bootstrap-datepicker.zh-CN.min.js"></script>
		<script type="text/javascript">
		$(function(){
			$('#user_name').val("");
			$('#real_name').val("");
			$('#email').val("");
			$('#birthday').val("");
			$('#password').val("");
			$('#password_confirm').val("");
			
			// 初始化
			$('input.i-grey').iCheck({
				radioClass : 'iradio_minimal-grey',
				checkboxClass: 'icheckbox_minimal-grey'
			});
			
			$('#birthday').datepicker({
				language: 'zh-CN',
				autoclose: true
			});
		});
		
		function register(){
			//获取值
			var user_name = $('#user_name').val();
			var real_name = $('#real_name').val();
			var email = $('#email').val();
			var birthday = $('#birthday').val();
			var sex = $('input[name="sex"]').filter(':checked').val();
			var password = $('#password').val();
			var password_confirm = $('#password_confirm').val();
			var privacy = $('#privacy').is(':checked');
			
			//空值校验
/* 			if( !user_name ){
				alert("用户名不能为空，请输入");
				return false;
			}
			if( !real_name ){
				alert("姓名不能为空，请输入");
				return false;
			} */
			if( !email ){
				alert("邮件不能为空，请输入");
				return false;
			}
/* 			if( !birthday ){
				alert("出生日期不能为空，请输入");
				return false;
			} */
			if( !password ){
				alert("密码不能为空，请输入");
				return false;
			}
			if( !password_confirm ){
				alert("密码确认不能为空，请输入");
				return false;
			}
			if(password != password_confirm){
				alert("两次所输密码不同，请检查");
				return false;
			}
			if( privacy == false ){
				alert("请同意隐私政策和服务协议");
				return false;
			}
			
			$.ajax({
				url:"../api/user/register",
				async: false,
				method: "POST",
				dataType: "json",
				data: {
					username: user_name,
					realname: real_name,
					email: email,
					birthday: birthday,
					sex: sex,
					password: password
				},
				success:function(data){
					alert(data.msg);
					if(data.code == '200'){
						location.href = "../login.jsp";
					}
				}
			});
		}
		</script>
	</body>
</html>