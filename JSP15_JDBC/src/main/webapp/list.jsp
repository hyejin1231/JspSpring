<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
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
	
	String sql_select = "SELECT * FROM test_write ORDER BY wr_uid DESC";
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
	try {
		Class.forName(driver);

		conn = DriverManager.getConnection(url, uid, upw);
		
		pstmt = conn.prepareStatement(sql_select);
		rs = pstmt.executeQuery();
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

		while(rs.next()) {
			int uid = rs.getInt("wr_uid");
			String subject =rs.getString("wr_subject");
			String name = rs.getString("wr_name");
			int viewcnt = rs.getInt("wr_viewcnt");
			Date d = rs.getDate("wr_regdate");
			Time t = rs.getTime("wr_regdate");
			String regdate = new SimpleDateFormat("yyyy-MM-dd").format(d) + " " + new SimpleDateFormat("hh:mm:ss").format(t);
			
			out.println("<tr>");
			out.println("<td>" + uid + "</td>");
			out.println("<td><a href = 'view.jsp?uid=" +uid+ "'>"+ subject +"</a></td>");
			out.println("<td>" + name + "</td>");
			out.println("<td>" + viewcnt + "</td>");
			out.println("<td>" + regdate + "</td>");
			out.println("</tr>");
		}


%>			
			
		
		</table>
		
		
		<br>
		<button onclick="location.href ='write.jsp'">신규 등록</button>
		
		
<% 		
	} catch(Exception e) {
		e.printStackTrace();
	} finally{
		try{
			if( rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
%>
</body>
</html>






























