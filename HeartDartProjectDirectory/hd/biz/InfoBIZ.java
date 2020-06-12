package hd.biz;

import hd.dao.InfoDAO;
import hd.vo.InfoVO;

import java.sql.Connection;
import static common.JDBCTemplate.*;

public class InfoBIZ {

	public InfoVO infoSelect(String clickCode, String period) {

		Connection conn = getConnection();
		InfoVO infoVO = new InfoDAO(conn).getInfoSelect(clickCode, period);
		Close(conn);
		return infoVO;
	}

}
