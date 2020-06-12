package hd.biz;

import javax.swing.table.DefaultTableModel;

import hd.dao.SearchDAO;

import java.sql.Connection;
import static common.JDBCTemplate.*;

public class SearchBIZ {

	public static void userSelectAll(DefaultTableModel dt) {
		Connection conn = getConnection();

		new SearchDAO(conn).getUserSelectAll(dt);
		Close(conn);

	}

	public void userSearchAll(DefaultTableModel dt, String word) {
		Connection conn = getConnection();

		new SearchDAO(conn).getUserSearchAll(dt, word);
		Close(conn);

	}

	public void userSearch(DefaultTableModel dt, String type, String word) {
		Connection conn = getConnection();

		new SearchDAO(conn).getUserSearch(dt, type, word);
		Close(conn);
	}

}

