<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logout</title>
</head>
<body>
	<h1>Logout Page</h1>
	<form action="${pageContext.request.contextPath }/customLogout" method="post">
		<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
		<button> 로그 아웃</button>
	</form>
</body>
</html>