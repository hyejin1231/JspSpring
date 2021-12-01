<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>buyPage</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h2 class="text-center">카드 결제</h2>
		<form action="buyTicket.do" class="form-horizontal">
			<div class="form-group">
				<label>고객 아이디</label>
				<input type="text" class="form-control" name="user_id">
			</div>
			
			<div class="form-group">
				<label>티켓 구매수</label>
				<input type="text" class="form-control" name="ticket_count"> 
			</div>
			
			<input type="submit" value="구매"> 
		</form>
	</div>
</body>
</html>