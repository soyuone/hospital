<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Hospital</title>
	</head>

	<body>
		<h1 style="text-align: center">个人中心页面</h1>
		<div style="text-align: center">
			<p style="font-size: 15px">欢迎您，</p>
			
			<%
			String emailCookie = null;
			String passwordCookie = null;
			
			Cookie[] cookies = request.getCookies(); 
			
			if(null != cookies){
				
				for(Cookie cookie: cookies){
					if("HOSPITAL_COOKIE_EMAIL".equals(cookie.getName())){
						emailCookie = cookie.getValue();
					}
					if("HOSPITAL_COOKIE_PASSWORD".equals(cookie.getName())){
						passwordCookie = cookie.getValue();
					}
				}
				
				if(null != emailCookie && null != passwordCookie){
					%>
					<h4 style="text-align: center; font-weight: 700;margin: 20px 0;" id="email"><%=emailCookie%></h4>
					<h4 style="text-align: center; font-weight: 700;margin: 20px 0;" id="password"><%=passwordCookie%></h4>
					<%
				}
			}
			%>
		</div>
	</body>
</html>