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
	
	String sql_select_by_id = "SELECT * FROM test_write where wr_uid =? ";
	
	String sql_inc_viewcnt = "UPDATE test_write SET wr_viewcnt = wr_viewcnt+1 where wr_uid = ?";

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
		
		conn.setAutoCommit(false);
		
		pstmt = conn.prepareStatement(sql_inc_viewcnt);
		pstmt.setInt(1, id);
		cnt = pstmt.executeUpdate();
		
		pstmt.close();
		
		pstmt = conn.prepareStatement(sql_select_by_id);
		pstmt.setInt(1, id);
		rs = pstmt.executeQuery();
		
		if(rs.next()){
			subject = rs.getString("wr_subject");
			content = rs.getString("wr_content");
			if(content == null) content = "";
			
			name = rs.getString("wr_name");
			viewcnt = rs.getInt("wr_viewcnt");
			Date d = rs.getDate("wr_regdate");
			Time t = rs.getTime("wr_regdate");
			regdate = new SimpleDateFormat("yyyy-MM-dd").format(d) + new SimpleDateFormat("hh:mm:ss").format(t);
		}else {
%>
		<script>
			alert("해당 글이 삭제되거나 없습니다.");
			history.back();
		</script>
<% 			

			return;
		}
		
		conn.commit();
		
		
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			if(rs != null) rs.close();
			if(conn != null) conn.close();
			if(pstmt != null) pstmt.close();
			if(stmt != null) stmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View <%= subject %></title>
</head>
<script>
function chkDelete(id) {
	// 삭제 여부 확인 
	var r = confirm("삭제하시겠습니까?");
	
	if(r) {
		location.href = 'deleteOk.jsp?uid='+ id;
	} 
	
}
</script>
<body>

<h2>view <%= subject %></h2>
<br>
id : <%= id %> <br>
작성자 : <%= name %><br>
제목 : <%= subject %> <br>
등록일 : <%= regdate%> <br>
조회수 : <%= viewcnt %> <br>
내용 : <br>
<hr>
<div>
	<%= content %>
</div>
<hr>
<br>
<button onclick ="location.href='update.jsp?uid=<%=id %>'">수정하기</button>
<button onclick="location.href='list.jsp'">목록보기</button>
<button onclick="chkDelete(<%= id %>)"> 삭제하기 </button>
<button onclick="location.href ='write.jsp'">신규등록</button>
</body>
</html>




























