<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script>
function chkWrite() {
	frm = document.forms["form1"];
	
	var subject = frm["subject"].value.trim();
	

	
	if(subject == "") {
		alert("제목은 반드시 입력해야 합니다.");
		frm["subject"].focus();
		return false;
	}
	
	return true;
}
</script>
</head>
<body>
	<div class="container">
		<div>
			<form name="form1" onsubmit="return chkWrite()" action="updateOk.do" method="post">
				<input type="hidden" name="wr_uid" value="${board.wr_uid }">
				<input type="hidden" name ="name" value="${board.name }">
				<input type="hidden" name="viewcnt" value="${board.viewcnt }"> 
				<h2><input type="text" name="subject" value="${board.subject }"></h2>
				<table class="table table-bordered table table-hover">
					<tr>
						<td>번호</td>
						<td>${board.wr_uid }</td>
					</tr>
					
					<tr>
						<td>작성자</td>
						<td>${board.name }</td>
					</tr>
					
					<tr>
						<td>작성일</td>
						<td>${board.regdate }</td>
					</tr>
					
					<tr>
						<td>조회수</td>
						<td>${board.viewcnt }</td>
					</tr>
					
					<tr>
						<td colspan="2"><b>내용</b></td>
					</tr>	
					
					<tr>
						<td colspan="2">
							<textarea rows="10" cols="150" name="content">
								${board.content }
							</textarea>
						</td>
					</tr>
					
					<tr>
						<td colspan="2">
							<input type="submit" value="수정하기">
							
						</td>
					</tr>
				</table>
				
			
			</form>
		
		<button onclick="history.back()">이전으로</button>
		<button onclick="location.href='list.do'">목록으로</button>
		</div>
	</div>

</body>
</html>