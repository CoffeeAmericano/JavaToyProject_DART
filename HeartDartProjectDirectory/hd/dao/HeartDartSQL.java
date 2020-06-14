package hd.dao;

import java.util.Scanner;

public interface HeartDartSQL {

	String company_selectall = "SELECT * FROM COMPANY_LIST ORDER BY COM_NAME";

	String company_searchAll = "SELECT * FROM COMPANY_LIST " + "WHERE COM_NAME LIKE '%' || ? || '%' "
			+ "OR INDUSTRY_NAME LIKE '%' || ? || '%' " + "OR COM_CODE LIKE '%' || ? || '%' " + "ORDER BY COM_NAME";

	public default String company_search(String condition) {
		String sql = "SELECT * FROM COMPANY_LIST " + "WHERE " + condition + " LIKE '%' || ? || '%'";
		return sql;
	}

	public default String info_select(String period) {
		Scanner sc = new Scanner(period).useDelimiter("_");
		String period_last = Integer.toString((Integer.parseInt(sc.next()) - 1)) + "_" + sc.next();

		String sql = "SELECT COM_CODE, BS_" + period_last + ", IS_" + period_last + ", CF_" + period_last + ", BS_"
				+ period + ", IS_" + period + ", CF_" + period + " FROM DARTTABLE "
				+ "WHERE COM_CODE LIKE '%' || ? || '%'";
		sc.close();
		return sql;
	}

};
