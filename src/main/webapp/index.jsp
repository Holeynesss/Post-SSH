<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<html>
<body>
	<h2>Hello World!</h2>
	<a href="${path}/msgPost/findAll?pn=0&ps=5">Show All Post</a>
	<form action="${path}/msgPost/findByKeyWord" method="post">
		<input type="text" name="keyWord" id="keyWord" /> <select
			id="searchWay" name="searchWay">
			<option value="1">By Key Words</option>
			<option value="2">By Title</option>
		</select> <input type="submit" name="submit" value="SEARCH">
	</form>
</body>
</html>
