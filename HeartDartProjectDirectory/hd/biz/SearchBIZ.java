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

}
