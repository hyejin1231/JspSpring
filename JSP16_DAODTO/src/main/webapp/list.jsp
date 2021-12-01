<%@page import="com.lec.beans.BoardDTO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.sql.*" %>
<jsp:useBean id="dao" class="com.lec.beans.BoardDAO"/>
<%
	BoardDTO arr[] = dao.select();
%>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Page</title>
<style>
	table {width : 100%; }
	table, th, td {
		border : 1px solid black;
		border-collapse: collapse;
	} 
</style>
</head>
<body>
<%
	if(arr == null || arr.length == 0) {
		out.println("멤버가 없습니다.<br>");
	}else {
%>
	<hr> 
		<h2>리스트</h2>
		<table>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>등록일</th>
			</tr>
<%

		for(int i = 0; i< arr.length; i++) {
			out.println("<tr>");
			out.println("<td>" + arr[i].getUid() + "</td>");
			out.println("<td><a href='view.jsp?uid=" +arr[i].getUid()+"'>"+arr[i].getSubject() + "</a></td>" );
			out.println("<td>" + arr[i].getName() + "</td>");
			out.println("<td>" + arr[i].getViewcnt() + "</td>");
			out.println("<td>" + arr[i].getRegdate() + "</td>");
			out.println("</tr>");
		}

%>	
</table>		
<%
	}
	
%>
<br>
<button onclick="location.href='write.jsp'">신규등록</button>

</body>
</html>






























