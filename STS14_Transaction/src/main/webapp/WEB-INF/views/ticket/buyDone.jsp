<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>buyDone</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h2 class="text-center">결제 완료</h2>
		<table class="table text-center table table-hover">
			<tr>
				<td>고객 아이디 :</td>
				<td>${ticket.user_id }</td>
			</tr>
			
			<tr>
				<td>티켓 구매수 :</td>
				<td>${ticket.ticket_count }</td>
			</tr>
			
			<tr>
				<td colspan="2" class="text-center">
					<button class="btn btn_primary" onclick="location.href='buyPage.do'"> 돌아가기 </button>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>