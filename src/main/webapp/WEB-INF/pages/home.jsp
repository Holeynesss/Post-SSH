<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h2>HOME PAGE</h2>
	<div>
		<c:forEach var="posts" items="${postList}" step="1">
			<a href="${path}/msgPost/showPost?postId=${posts.postId}">${posts.postTitle}</a>
			<a href="${path}/msgPost/admin/deletePost?postId=${posts.postId}">DELETE</a>
			<br />
		</c:forEach>
	</div>
	<div id="page">
		<c:if test="${currentPage!=0}">
			<a href="${path}/msgPost/findAll?pn=${currentPage-1}&ps=${ps}"><span>上一页</span></a>
		</c:if>
	</div>
	<c:if test="${hasNext!=-1}">
		<a href="${path}/msgPost/findAll?pn=${currentPage+1}&ps=${ps}"><span>下一页</span></a>
	</c:if>
	<div id="notePad">
		<form action="${path}/msgPost/user/insertPost" method="post">
			标题:<input type="text" name="postTitle" style="width: 500px" value=""><br />
			<br /> <br />
			<jsp:include page="notePad.jsp">
				<jsp:param value="postContent" name="content" />
			</jsp:include>
			<br /> 关键字<input type="text" name="keyWords"> <input
				type="submit" value="发帖"> <input type="reset" value="清空">
		</form>
	</div>
</body>
</html>