package common;

import java.sql.*;

/////////  Connection & Close & Commit & rollback
	// JDBCTemplate 에는 위의 네가지 메소드만 만든다.

public class JDBCTemplate {
	// 연결상태로 리턴해주겠다.
	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} // 설치된 오라클 드라이버를 참조시킨다.

		// 1. url
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		// 2. id
		String id = "big5";
		// 3. pwd
		String pwd = "admin1234";

		Connection con = null;
		try {
			con = DriverManager.getConnection(url, id, pwd);
			con.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		} // 접속하고 연결했다.
		try {
			if (!con.isClosed()) {
				// System.out.println("연결 성공 ~~");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return con;
	}
	
	// 연결한 상태를 close()하겠다.
	public static void Close(Connection con) {
		try {
			if(!con.isClosed() && con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void Close(Statement stmt) {
		try {
			if(stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void Close(ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void Commit(Connection con) {
		try {
			if(con!= null && !con.isClosed()) {
				con.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void Rollback(Connection con) {
		try {
			if(con!= null && !con.isClosed()) {
				con.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
