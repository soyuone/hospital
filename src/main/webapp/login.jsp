<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Hospital</title>
		
		<link href="assets/plugins/bootstrap/css/font-awesome.min.css" rel="stylesheet" type="text/css">
		<link href="assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
		<link href="assets/plugins/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
		<link href="assets/plugins/bootstrap/css/bootstrap-social.css" rel="stylesheet" type="text/css">	
		<link href="assets/plugins/bootstrap/css/templatemo_style.css" rel="stylesheet" type="text/css">	
	</head>
	
	<body class="templatemo-bg-image-1">
		<div class="container">
			<div class="col-md-12">			
				<form class="form-horizontal templatemo-login-form-2" role="form" action="#" method="post">
					<div class="row">
						<div class="col-md-12">
							<h1>Hospital</h1>
						</div>
					</div>
					<div class="row">
						<div class="templatemo-one-signin col-md-6">
					        <div class="form-group">
					          <div class="col-md-12">		          	
					            <label for="email" class="control-label">邮箱</label>
					            <div class="templatemo-input-icon-container">
					            	<i class="fa fa-user"></i>
					            	<input type="text" class="form-control" id="email" placeholder="请输入用户名">
					            </div>		            		            		            
					          </div>              
					        </div>
					        <div class="form-group">
					          <div class="col-md-12">
					            <label for="password" class="control-label">密 码</label>
					            <div class="templatemo-input-icon-container">
					            	<i class="fa fa-lock"></i>
					            	<input type="password" class="form-control" id="password" placeholder="请输入密码">
					            </div>
					          </div>
					        </div>
					        <div class="form-group">
					          <div class="col-md-12">
					            <div class="checkbox">
					                <label>
					                  <input type="checkbox"> 记住我
					                </label>
					            </div>
					          </div>
					        </div>
					        <div class="form-group">
					          <div class="col-md-12">
					            <input type="button" value="登   录" class="btn btn-warning" onclick="login()">
					          </div>
					        </div>
					        <div class="form-group">
					          	<div class="col-md-6">
					        		<a href="forgot-password.html" class="text-center">忘记密码?</a>
					       	 	</div>
					          	<div class="col-md-6">
					        		<a href="pages/register.jsp" class="text-center">没有账号？</a>
					       	 	</div>
					    	</div>
						</div>
						<div class="templatemo-other-signin col-md-6">
							<label class="margin-bottom-15">
								用如下账号登录
							</label>
							<a class="btn btn-block btn-social btn-microsoft margin-bottom-15">
							    <i class="fa fa-windows"></i> Microsoft
							</a>
							<a class="btn btn-block btn-social btn-github margin-bottom-15">
							    <i class="fa fa-github"></i> Github
							</a>
							<a class="btn btn-block btn-social btn-google-plus margin-bottom-15">
							    <i class="fa fa-google"></i> Google
							</a>
							<a class="btn btn-block btn-social btn-facebook margin-bottom-15">
							    <i class="fa fa-weibo"></i> Weibo
							</a>
						</div>   
					</div>				 	
			      </form>		      		      
			</div>
		</div>
		<script src="assets/plugins/jquery/jquery-3.1.1.min.js"></script>
		<script src="assets/plugins/bootstrap/js/bootstrap.js"></script>
		<script src="assets/plugins/jalerts/js/jquery.alerts.js"></script>
		<script type="text/javascript">
		$(function(){
			$('#email').val("");
			$('#password').val("");
		});
		
		function login(){
			var email = $('#email').val();
			var password = $('#password').val();
			//空值校验
			if( !email ){
				alert("邮箱不能为空，请输入");
				return false;
			}
			if( !password ){
				alert("密码不能为空，请输入");
				return false;
			}
			
			$.ajax({
				url: "api/user/login",
				async: false,
				method: "POST",
				dataType: "json",
				data: {
					email: email,
					password: password
				},
				success:function(data){
					alert(data.msg);
					if(data.code == '200'){
						location.href = "usercenter.jsp";
					}
				}
			});
		}
		</script>
	</body>
</html>