package common;

import java.sql.*;

/////////  Connection & Close & Commit & rollback
	// JDBCTemplate ���� ���� �װ��� �޼ҵ常 �����.

public class JDBCTemplate {
	// ������·� �������ְڴ�.
	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} // ��ġ�� ����Ŭ ����̹��� ������Ų��.

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
		} // �����ϰ� �����ߴ�.
		try {
			if (!con.isClosed()) {
				// System.out.println("���� ���� ~~");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return con;
	}
	
	// ������ ���¸� close()�ϰڴ�.
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
