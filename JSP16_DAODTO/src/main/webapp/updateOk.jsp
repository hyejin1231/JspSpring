<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<jsp:useBean id="dao" class="com.lec.beans.BoardDAO"/>
<%
	request.setCharacterEncoding("utf-8");
	int id = Integer.parseInt(request.getParameter("uid"));
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
%>

<%
	int cnt = dao.update(id, subject, content);
%>
<%
	if(cnt == 0) {
%>
	<script>
		alert("수정 실패");
		history.back();
	</script>
<% 		
	}else {
%>
	<script>
		alert("수정 성공");
		location.href ="view.jsp?uid=<%=id%>";
	</script>	
<% 		
	}
%>





















