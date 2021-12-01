<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ page import="java.sql.*" %>
 <jsp:useBean id="dao" class="com.lec.beans.BoardDAO"/>
 <jsp:useBean id="dto" class="com.lec.beans.BoardDTO"/>
<%
	request.setCharacterEncoding("utf-8");

%>

<jsp:setProperty property="*" name = "dto"/>

<%
	int cnt = dao.insert(dto);
	
%>

<%
	if(cnt == 0) {
%>
		<script>
			alert("등록 실패!!");
			history.back();
		</script>
<% 		
	} else {
%>
		<script>
			alert("등록 성공!!");
			location.href ="list.jsp";
		</script>
<% 		
	}
%>
















