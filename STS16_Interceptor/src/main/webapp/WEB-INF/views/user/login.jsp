<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h2 class="text-center">로그인</h2>
		<hr>
		<form class="text-center" action="loginOk" method="post">
			<div class="form-group">
				<label>id : </label>
				<input name="id" required="required"/> 
			</div>
			
			<div class="form-group">
				<label>pw: </label>
				<input name="pw" required="required"/>
			</div>
			
			<div class="btn-group">
				<input type="submit" value="login">
			</div>
		</form>
	</div>
</body>
</html>