package com.lec.beans;

import java.sql.Statement;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lec.jsp.D;

public class BoardDAO {

	Connection conn;
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs;
	
	
	public BoardDAO() {
		try {
			Class.forName(D.DRIVER);
			conn = DriverManager.getConnection(D.URL, D.USERID, D.USERPW);
			System.out.println("WriteDAO 생성, 데이터베이스 연결!!");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void close() throws SQLException {
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(stmt != null) stmt.close();
		if(conn != null) conn.close();
	}
	
	
	// 새글 작성 
	public int insert(BoardDTO dto) throws SQLException{
		String subject = dto.getSubject();
		String name = dto.getName();
		String content = dto.getContent();
		
		int cnt = this.insert(subject, content, name);
		return cnt;
	}
	
	public int insert(String subject, String content, String name) throws SQLException {
		int cnt = 0;
		try {
			pstmt = conn.prepareStatement(D.SQL_INSERT);
			pstmt.setString(1, subject);
			pstmt.setString(2, content);
			pstmt.setString(3, name);
			cnt = pstmt.executeUpdate();
			
		}finally {
			close();
		}
		
		return cnt;
	}
	
	// resultset를 dto 배열로 반환 
	public BoardDTO[] createArray(ResultSet rs) throws SQLException {
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		
		while (rs.next()) {
			int id = rs.getInt("wr_uid");
			String subject = rs.getString("wr_subject");
			String content = rs.getString("wr_content");
			if(content == null) content ="";
			String name = rs.getString("wr_name");
			int viewcnt = rs.getInt("wr_viewcnt");
			
			Date d = rs.getDate("wr_regdate");
			Time t = rs.getTime("wr_regdate");
			String regdate = "";
			if(d != null) {
				regdate = new SimpleDateFormat("yyyy-MM-dd").format(d) + new SimpleDateFormat("hh:mm:ss").format(t);
			}
			
			BoardDTO dto = new BoardDTO(id, subject, content, name, viewcnt);
			dto.setRegdate(regdate);
			list.add(dto);
			
		}
		
		int size = list.size();
		if(size == 0) return null;
		
		
		BoardDTO arr[] = new BoardDTO[size];
		list.toArray(arr);
		return arr;
		
	}
	
	
	// list 조회 
	public BoardDTO[] select() throws SQLException {
		BoardDTO arr[] = null;
		
		try {
			pstmt = conn.prepareStatement(D.SQL_SELECT);
			rs = pstmt.executeQuery();
			arr = createArray(rs);
		}finally {
			close();
		}
		
		return arr;
	}
	
	public BoardDTO [] selectByUid(int id) throws SQLException {
		BoardDTO [] arr = null;
		
		try {
			pstmt = conn.prepareStatement(D.SQL_SELECT_BY_UID);
			pstmt.setInt(1, id);
			rs= pstmt.executeQuery();
			arr= createArray(rs);
		}finally {
			close();
		}
		return arr;
	}
	
	public BoardDTO[] readById(int id) throws SQLException {
		int cnt = 0;
		BoardDTO arr[] = null;
		
		try {
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(D.SQL_INC_VIEWCNT);
			pstmt.setInt(1, id);
			cnt = pstmt.executeUpdate();
			pstmt.close();
			
			pstmt = conn.prepareStatement(D.SQL_SELECT_BY_UID);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			arr = createArray(rs);
			conn.commit();
			
		}catch (Exception e) {
			conn.rollback();
			throw e;
		}finally {
			close();
		}
		
		return arr;
	}
	
	public int update(int id, String subject, String content) throws SQLException {
		int cnt = 0;
		try {
			pstmt = conn.prepareStatement(D.SQL_UPDATE);
			pstmt.setString(1, subject);
			pstmt.setString(2, content);
			pstmt.setInt(3, id);
			cnt = pstmt.executeUpdate();
		}finally {
			close();
		}
		
		return cnt;
	}
	
	public int deleteById(int id) throws SQLException {
		int cnt = 0;
		
		try {
			pstmt= conn.prepareStatement(D.SQL_DELETE);
			pstmt.setInt(1, id);
			
			cnt = pstmt.executeUpdate();
		}finally {
			close();
		}
		
		return cnt;
	}
	
}


































