package com.lec.jsp;

public class D {
	public static final String DRIVER = "org.mariadb.jdbc.Driver";
	public static final String URL = "jdbc:mariadb://localhost:3306/mydb";
	public static final String USERID = "myuser";
	public static final String USERPW = "1234";
	
	public static final String SQL_INSERT = "INSERT INTO test_write (wr_subject, wr_content, wr_name) values(?,?,?)";
	
	public static final String SQL_SELECT = "SELECT * FROM test_write ORDER BY wr_uid DESC";
	
	public static final String SQL_SELECT_BY_UID ="SELECT * FROM test_write where wr_uid =?";
	
	public static final String SQL_INC_VIEWCNT = "UPDATE test_write SET wr_viewcnt = wr_viewcnt+1 where wr_uid = ?";
	
	public static final String SQL_DELETE = "DELETE FROM test_write where wr_uid = ?";
	
	public static final String SQL_UPDATE = "UPDATE test_write SET wr_subject =? , wr_content =? WHERE wr_uid =?";
}
