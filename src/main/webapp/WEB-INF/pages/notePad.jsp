<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>发帖</title>
<script type="text/javascript"
	src="${path}/ckeditor/ckeditor.js" charset="utf-8"></script>
</head>
<body>
	<div>
		<%-- 		<form action="${param.notePadAction}" method="post">
			标题：${notePadAction} <input type="text" name="postTitle"
				style="width: 500px" value=""><br /> <br /> <br /> --%>
		<textarea cols="80" id="editor" name="${param.content}" rows="10">
		${param.currentPostContent}
     </textarea>
		<br />
		<script type="text/javascript">
			CKEDITOR.editorConfig = function(config) {
				width = 700;
			}
			CKEDITOR.replace('editor', {
				language : 'zh-cn'
			});
		</script>
		<!-- 			<br /> 关键字<input type="text" name="keyWords"> <input
				type="submit" value="发帖"><input type="reset" value="清空">
		</form> -->
	</div>
</body>
</html>