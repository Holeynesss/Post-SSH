<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录界面</title>
</head>
<body>
	<h4>请登录</h4>
	<form action="/j_spring_security_check" method="post">
		<div>
			<ul>
				<li><label for="username">用户名：</label> <input type="text"
					id="username" /></li>
				<li><label for="password">密码：</label><input type="password"
					id="password" /></li>
					<!-- 后台自动验证权限？ -->
				<!-- <li><label for="general">普通会员：</label><input type="radio"
					value="general" name="authority" checked="checked"> <label
					for="admin">管理员：</label><input type="radio" value="admin"
					name="authority" /></li> -->
				<li><input type="checkbox" id="_spring_security_remember_me"
					name="_spring_security_remember_me"> <label
					for="_spring_security_remember_me">Remember me?</label></li>
				<li><input type="submit" value="提交" id="submit" /> <input
					type="reset" value="重置" id="reset" /></li>

			</ul>
		</div>
	</form>
</body>
</html>