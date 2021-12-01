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
	BoardDTO [] arr = dao.selectByUid(id);

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
	int viewcnt = arr[0].getViewcnt();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update <%= subject %></title>
</head>
<script>
frm = document.forms["frm"];

//var name = frm["name"].value.trim();
var subject = frm["subject"].value.trim();

//if( name == ""){
//	alert("작성자 란은 반드시 입력해야 합니다.");
//	frm["name"].focus();
//	return false; // submit 안됨 
//}

if(subject == "") {
	alert("제목은 반드시 작성해야 합니다.");
	frm["subject"].focus();
	return false;
}

return true;
</script>
<body>
	<h2>Update <%= subject %></h2>
	<form action="updateOk.jsp" method="post" name ="frm" onsubmit ="return chkSubmit()">
		<input type ="hidden" name = "uid" value ="<%= id %>"/> <br>
		작성자 : <%= name %> <br>
		제목 : <input type ="text" name ="subject" value="<%=subject %>"/> <br>
		내용 : <textarea name ="content"> <%= content %></textarea>
		<br><br>
		<input type="submit" value ="수정"/>
	</form>
	
	<button onclick="history.back()">이전으로</button>
	<button onclick="location.href = 'lsit.jsp'">목록으로</button>
</body>
</html>

































