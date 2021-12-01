<%@page import="com.lec.beans.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.text.SimpleDateFormat" %>
<%@ page import = "java.util.Date" %>    
<%@ page import = "java.sql.*" %> 
<jsp:useBean id="dao" class="com.lec.beans.BoardDAO"/>

<%
	int id = Integer.parseInt(request.getParameter("uid"));

%>    
<%
	BoardDTO[] arr= dao.readById(id);
%>

<%
	if(arr == null || arr.length == 0) {
%>
		<script>
			alert("해당 정보가 삭제되거나 없습니다.");
			history.back();
		</script>
<% 	
			return;
	}

%>
<%
	String name = arr[0].getName();
	String subject = arr[0].getSubject();
	String content = arr[0].getContent();
	String regdate = arr[0].getRegdate();
	int viewcnt =  arr[0].getViewcnt();
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View <%= subject %></title>
</head>
<script>
function chkDelete(id) {
	// 삭제 여부 확인 
	var r = confirm("삭제하시겠습니까?");
	
	if(r) {
		location.href = 'deleteOk.jsp?uid='+ id;
	} 
	
}
</script>
<body>

<h2>view <%= subject %></h2>
<br>
id : <%= id %> <br>
작성자 : <%= name %><br>
제목 : <%= subject %> <br>
등록일 : <%= regdate%> <br>
조회수 : <%= viewcnt %> <br>
내용 : <br>
<hr>
<div>
	<%= content %>
</div>
<hr>
<br>
<button onclick ="location.href='update.jsp?uid=<%=id %>'">수정하기</button>
<button onclick="location.href='list.jsp'">목록보기</button>
<button onclick="chkDelete(<%= id %>)"> 삭제하기 </button>
<button onclick="location.href ='write.jsp'">신규등록</button>
</body>
</html>




























