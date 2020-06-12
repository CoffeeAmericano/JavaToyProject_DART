package hd.dao;

import static common.JDBCTemplate.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

public class SearchDAO implements HeartDartSQL {
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
				Object data[] = {rs.getString(2), rs.getString(3), rs.getString(1)};
				t_model.addRow(data); // DefaultTableModel에 레코드 추가
			}

		} catch (SQLException e) {
			System.out.println(e + "=> userSelectAll fail");
		} finally {
			Close(pstm);
			Close(rs);
		}
	}// userSelectAll()

	// 모든 조건 검색
	public void getUserSearchAll(DefaultTableModel dt, String word) {
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			pstm = conn.prepareStatement(company_searchAll);
			pstm.setString(1, word.trim());
			pstm.setString(2, word.trim());
			pstm.setString(3, word.trim());
			rs = pstm.executeQuery();

			// DefaultTableModel에 있는 기존 데이터 지우기
			for (int i = 0; i < dt.getRowCount();) {
				dt.removeRow(0);
			}
			while (rs.next()) {
				Object data[] = {rs.getString(2), rs.getString(3), rs.getString(1)};
				dt.addRow(data);
			}

		} catch (SQLException e) {
			System.out.println(e + "=> getUserSearchAll fail");
		} finally {
			Close(rs);
			Close(pstm);
		}
		
	}
	
	// 한 조건 검색
	public void getUserSearch(DefaultTableModel dt, String fieldName, String word) {
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			switch(fieldName) {
			case "com_name" : 
				pstm = conn.prepareStatement(company_searchName);
				break;
			case "com_code" :
				pstm = conn.prepareStatement(company_searchCode);
				break;
			case "industry_name" :
				pstm = conn.prepareStatement(company_searchIndustry);
				break;
				
			}
			pstm.setString(1, word.trim());
			rs = pstm.executeQuery();

			// DefaultTableModel에 있는 기존 데이터 지우기
			for (int i = 0; i < dt.getRowCount();) {
				dt.removeRow(0);
			}
			while (rs.next()) {
				Object data[] = {rs.getString(2), rs.getString(3), rs.getString(1)};
				dt.addRow(data);
			}

		} catch (SQLException e) {
			System.out.println(e + "=> getUserSearch fail");
		} finally {
			Close(rs);
			Close(pstm);
		}

	}// getUserSearch()

	
}
