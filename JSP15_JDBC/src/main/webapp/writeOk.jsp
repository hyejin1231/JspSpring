<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ page import="java.sql.*" %>
<%
	request.setCharacterEncoding("utf-8");

	String name = request.getParameter("name");
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	
	if(name == null || subject == null || name.trim().equals("") || subject.trim().equals("")) {
%>
	<script>
		alert("작성자 이름과 글 제목은 필수 입니다!");
		history.back();
	</script>
<%		
	return;
	
	}
%>

<%

	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	int cnt =0;
	
	String driver = "org.mariadb.jdbc.Driver";
	String url = "jdbc:mariadb://localhost:3306/mydb";
	String uid = "myuser";
	String upw = "1234";
	
	
	String sql_insert = "INSERT INTO test_write (wr_subject, wr_content, wr_name) values(?,?,?)";
	
%>
<%
	try{
		Class.forName(driver);
		out.println("드라이버 성공");
		conn = DriverManager.getConnection(url, uid, upw);
		out.println("conn 성공 " + "<br>");
		
		pstmt = conn.prepareStatement(sql_insert);
		pstmt.setString(1, subject);
		pstmt.setString(2, content);
		pstmt.setString(3, name);
		
		cnt = pstmt.executeUpdate();
	}catch(Exception e) {
		e.printStackTrace();
	}finally{
		try{
			if( rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
%>

<%
	if(cnt == 0) {
%>
	<script>
		alert("등록 실패!!");
		history.back();
	</script>
		
<% 		
	}else {
%>
	<script>
		alert("등록 성공, 리스트를 출력합니다.");
		location.href="list.jsp";
	</script>
		
<% 		
	}

%>
















