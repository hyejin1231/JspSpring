<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${user.userid }사용자 상세 정보</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h2 class="text-center">사용자 상세 정보</h2>
		<table class ="table table-bordered table table-hover">
			<tr><td>아이디 : </td><td>${user.userid }</td></tr>
			<tr><td>이름 :</td><td>${user.name }</td></tr>
			<tr><td>성별 :</td><td>${user.gender }</td></tr>
			<tr><td>거주지 : </td><td>${user.city }</td></tr>
			
		</table>
	</div>

</body>
</html>