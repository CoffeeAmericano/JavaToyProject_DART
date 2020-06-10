import java.sql.*;
import javax.swing.table.DefaultTableModel;
import static Page_1.JDBCTemplate.*;

public class DefaultDAO implements HeartDartSQL{
	
	private Connection conn;

	public DefaultDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	
	// 전체유저검색
	public void getUserSelectAll(DefaultTableModel t_model) {
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			pstm = conn.prepareStatement(company_all);
			rs = pstm.executeQuery();

			// DefaultTableModel에 있는 기존 데이터 지우기
			for (int i = 0; i < t_model.getRowCount();) {
				t_model.removeRow(0);
			}

			while (rs.next()) {
				Object data[] = { rs.getString(1), rs.getInt(2), rs.getString(3)};
				t_model.addRow(data); //DefaultTableModel에 레코드 추가
			}

		} catch (SQLException e) {
			System.out.println(e + "=> userSelectAll fail");
		} finally {
			Close(pstm);
			Close(rs);
		}
	}//userSelectAll()
	
	// 유저서치기능
	public void getUserSearch(DefaultTableModel dt, String fieldName, String word) {
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			pstm = conn.prepareStatement(company_search);
			pstm.setString(1, fieldName.trim());
			pstm.setString(2, word.trim());
			rs = pstm.executeQuery();

			// DefaultTableModel에 있는 기존 데이터 지우기
			for (int i = 0; i < dt.getRowCount();) {
				dt.removeRow(0);
			}
			while (rs.next()) {
				Object data[] = { rs.getString(1), rs.getInt(2), rs.getString(3) };
				dt.addRow(data);
			}

		} catch (SQLException e) {
			System.out.println(e + "=> getUserSearch fail");
		} finally {
			Close(rs);
			Close(pstm);
		}

	}//getUserSearch()
	
	
}
