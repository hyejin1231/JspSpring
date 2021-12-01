<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
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
%>
<%
	try {
		Class.forName(driver);
		out.println("드라이버 성공");
		conn = DriverManager.getConnection(url, uid, upw);
		out.println("conn 성공 " + "<br>");
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try {
			if( rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
%> 