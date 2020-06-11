package hd.dao;

import static common.JDBCTemplate.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

public class SearchDAO implements HeartDartSQL{
	private Connection conn;

	public SearchDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	
	// 전체유저검색
	public void getUserSelectAll(DefaultTableModel t_model) {
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			pstm = conn.prepareStatement(company_selectall);
			rs = pstm.executeQuery();

			// DefaultTableModel에 있는 기존 데이터 지우기
			for (int i = 0; i < t_model.getRowCount();) {
				t_model.removeRow(0);
			}

			while (rs.next()) {
				Object data[] = { rs.getString(1), rs.getString(2), rs.getString(3)};
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
			pstm = conn.prepareStatement(company_select);
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
