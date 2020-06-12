package hd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import hd.vo.InfoVO;

import static common.JDBCTemplate.*;

public class InfoDAO implements HeartDartSQL {
	private Connection conn;

	public InfoDAO(Connection conn) {
		this.conn = conn;
	}

	public InfoVO getInfoSelect(String clickCode, String period) {
		PreparedStatement pstm = null;
		ResultSet rs = null;
		InfoVO infoVO = null;
		try {
			String sql = "SELECT COM_CODE, BS_" + period +", IS_" + period + 
						", CF_" + period +" FROM DARTTABLE "
						+ "WHERE COM_CODE LIKE '%' || ? || '%'";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, clickCode);
			rs = pstm.executeQuery();
			while (rs.next()) {
				infoVO = new InfoVO(rs.getString(1), rs.getString(2), 
						rs.getString(3), rs.getString(4));
			}
		} catch (Exception e) {
			System.out.println(e + "=> getInfoSelect fail");
		} finally {
			Close(rs);
			Close(pstm);
		}
		return infoVO;
	}

}
