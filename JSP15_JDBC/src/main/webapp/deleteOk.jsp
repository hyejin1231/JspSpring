<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
	int id = Integer.parseInt(request.getParameter("uid"));
%>
<%!

	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	int cnt =0;
	
	String driver = "org.mariadb.jdbc.Driver";
	String url = "jdbc:mariadb://localhost:3306/mydb";
	String uid = "myuser";
	String upw = "1234";

	String sql_delete = "DELETE FROM test_write where wr_uid = ?";
%>
<%
	try{
		Class.forName(driver);
		conn = DriverManager.getConnection(url, uid, upw);
		
		pstmt= conn.prepareStatement(sql_delete);
		pstmt.setInt(1, id);
		
		cnt = pstmt.executeUpdate();
		
		
	}catch(Exception e){
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
















