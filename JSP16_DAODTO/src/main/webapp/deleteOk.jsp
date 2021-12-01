<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<jsp:useBean id="dao" class="com.lec.beans.BoardDAO"/>
<%
	int id = Integer.parseInt(request.getParameter("uid"));
%>
<%
	int cnt = dao.deleteById(id);
%>
<%
	if(cnt == 0) {
%>
	<script>
		alert("삭제 실패");
		history.back();
	</script>
		
<% 		
	}else {
%>
	<script>
		alert("삭제 성공");
		location.href="list.jsp";
	</script>

<% 		
	}

%>
















