<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>          
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Write</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script type="text/javascript">

	function chkWrite() {
		frm = document.forms["form1"];
		
		var name = frm["name"].value.trim();
		var subject = frm["subject"].value.trim();
		
		if(name == "") {
			alert("작성자는 반드시 입력해야 합니다!");
			frm["frm"].focus();
			return false;
		}
		
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
		<h2>글 작성</h2>
		<div>
			<form name="form1" action="${pageContext.request.contextPath }/board/writeOk.do" method="post" onsubmit="return chkWrite()">
				<table class="table table-bordered table table-hover">
					<tr>
						<td>작성자</td>
						<td>
							<input type="text" name="name"> 
						</td>
					</tr>
					
					<tr>
						<td>제목</td>
						<td>
							<input type="text" name="subject">
						</td>
					</tr>
					
					<tr>
						<td colspan="2">내용</td>
					</tr>
					
					<tr>
						<td colspan="2">
							<textarea cols="150" rows="10" name="content"></textarea>
						</td>
					</tr>
					
					<tr>
						<td colspan="2">
							<input type="submit" value ="등록">
							
						</td>
					</tr>
				</table>
			
			</form>
		
		<button onclick="location.href='list.do'">목록으로</button>
		</div>
	
	</div>

</body>
</html>