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
	<h1>UPDATE PAGE</h1>
	<div id="notePad">
		<form
			action="${path}/msgPost/user/updatePost?postId=${currentPost.postId}"
			method="post">
			标题:<input type="text" name="postTitle" style="width: 500px"
				value="${currentPost.postTitle}"><br /> <br /> <br />
			<jsp:include page="notePad.jsp">
				<jsp:param value="postContent" name="content" />
				<jsp:param value="${currentPost.postContent}"
					name="currentPostContent" />
			</jsp:include>
			<br /> <input type="submit" value="SUBMIT">
		</form>
	</div>
</body>
</html>