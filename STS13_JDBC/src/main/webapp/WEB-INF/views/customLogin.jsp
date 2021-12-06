<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"  %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>Login Page</h1>
		<h2><c:out value="${error }"/></h2>
		<h2><c:out value="${logout }"/></h2>
		
		<form method="post" action="${pageContext.request.contextPath }/login" class="form-horizontal" >
			<div class="form-group">
				<label>id : </label>
				<input class="form-control" type="text" value="admin" name="username">
			</div>
			
			<div class="form-group">
				<label>pw :</label>
				<input type="password" name="password" value="admin" class="form-control">
			</div>
			
			<input type="checkbox" name="remember-me">Remember Me
			<input type="submit" value="login">
			<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
		</form>
	</div>
</body>
</html>