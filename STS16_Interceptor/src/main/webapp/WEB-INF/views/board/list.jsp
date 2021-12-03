<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h2 class="text-center">Board 게시판</h2>
		<table class="table table-bordered table table-hover">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>조회수</th>
					<th>등록일</th>
				</tr>
			</thead>
			
			<tbody>
				<c:choose>
					<c:when test="${empty list || fn.length(list) == 0 }">
						<script>
							alert("작성된 글이 없습니다.");
						</script>
					</c:when>
					<c:otherwise>
						<c:forEach var="board" items="${list }">
							<tr>
								<td>${board.wr_uid }</td>
								<td><a href="view.do?wr_uid=${board.wr_uid }">${board.subject}</a></td>
								<td>${board.name }</td>
								<td>${board.viewcnt }</td>
								<td>${board.regdate }</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
				
		
				
				<tr>
					<td colspan="5" class="text-center"><button onclick="location.href='write.do'">신규등록</button></td>
				</tr>
			</tbody>
		</table>
	</div>

</body>
</html>