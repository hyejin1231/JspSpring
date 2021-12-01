<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.text.SimpleDateFormat" %>
<%@ page import = "java.util.Date" %>        
<%@ page import = "java.sql.*" %>  
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
		
		String sql_select_by_uid = "SELECT * FROM test_write where wr_uid =? ";
		

%>
<%
	String name ="";
	String subject ="";
	String content ="";
	String regdate ="";
	int viewcnt = 0;
%>

<%
	try{
		Class.forName(driver);
		conn = DriverManager.getConnection(url, uid, upw);
		
		pstmt = conn.prepareStatement(sql_select_by_uid);
		pstmt.setInt(1, id);
		rs = pstmt.executeQuery();
		
		if(rs.next()){
			subject = rs.getString("wr_subject");
			content = rs.getString("wr_content");
			if(content == null) content ="";
			
			name = rs.getString("wr_name");
			viewcnt = rs.getInt("wr_viewcnt");
			Date d = rs.getDate("wr_regdate");
			Time t = rs.getTime("wr_regdate");
			regdate = new SimpleDateFormat("yyyy-MM-dd").format(d) + new SimpleDateFormat("hh:mm:ss").format(t);
		}else {
%>
		<script>
			alert("해당 글이 삭제되었거나 없습니다.");
			history.back();
		</script>
<% 			

			return;
		}
		
		
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

































