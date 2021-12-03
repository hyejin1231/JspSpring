<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"  %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<h1>Login Page</h1>
	<h2><c:out value="${error }"/></h2>
	<h2><c:out value="${logout }"/></h2>
	
	<form method="post" action="${pageContext.request.contextPath }/login">
		<input type="text" name="username" value="admin"><br>
		<input type="password" name="password" value="admin"><br>
		<input type="checkbox" name="remember-me">Remember me <br>
		<input type="submit"> <br>
		<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">		
	</form>
</body>
</html>