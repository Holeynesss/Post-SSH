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
	<h1>PostDetail</h1>
	<h1>${currentPost.postTitle}</h1>
	<a
		href="${path}/msgPost/user/transferUpdatePage?postId=${currentPost.postId}">EDIT</a>
	${currentPost.postContent}
	<c:forEach var="reply" items="${replies}" step="1">
		<c:if test="${reply.repliesStatus==1}">
			<h2>${reply.repliesContent}</h2>
			<a
				href="${path}/replies/admin/blockReply?repliesId=${reply.repliesId}">BLOCK</a>
		</c:if>
		<c:if test="${reply.repliesStatus==-1}">
			<h4 style="color: red">该回复已被屏蔽！</h4>
		</c:if>
	</c:forEach>
	<div id="notePad">
		<form action="${path}/replies/insertPost?postId=${currentPost.postId}"
			method="post">
			<br /> <br />
			<jsp:include page="notePad.jsp">
				<jsp:param value="repliesContent" name="content" />
			</jsp:include>
			<input type="submit" value="回复"> <input type="reset"
				value="清空">
		</form>
	</div>
</body>
</html>