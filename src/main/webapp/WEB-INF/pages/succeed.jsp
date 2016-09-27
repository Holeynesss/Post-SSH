<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<div id="content">
		<div id="infowrap">
			<div id="box">
				<h3>操作成功!</h3>


				<input type="text" value="1" id="time" class="fr">

			</div>
		</div>
	</div>
</body>

<script language="javascript">
	var t = 1;
	var time = document.getElementById("time");
	function fun() {
		t--;
		time.value = t;
		if (t <= 0) {
			location.href = "${path}/${succeedAction}";
			clearInterval(inter);
		}
	}
	var inter = setInterval("fun()", 1000);
</script>
</html>