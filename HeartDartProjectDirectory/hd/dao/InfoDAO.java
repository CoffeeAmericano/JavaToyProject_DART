package hd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import hd.view.ErrorFrame;
import hd.vo.InfoVO;

import static common.JDBCTemplate.*;

public class InfoDAO implements HeartDartSQL {
	private Connection conn;

	public InfoDAO(Connection conn) {
		this.conn = conn;
	}

	public InfoVO getInfoSelect(String clickCode, String period) throws Exception{
		PreparedStatement pstm = null;
		ResultSet rs = null;
		InfoVO infoVO = null;
		try {
			pstm = conn.prepareStatement(info_select(period));
			pstm.setString(1, clickCode);
			rs = pstm.executeQuery();
			while (rs.next()) {
				infoVO = new InfoVO(rs.getString(1), rs.getString(2), 
						rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8));
			}			
		} finally {
			Close(rs);
			Close(pstm);
		}
		return infoVO;
	}

}
