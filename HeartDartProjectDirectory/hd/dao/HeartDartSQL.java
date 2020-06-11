package hd.dao;

public interface HeartDartSQL {

	String company_selectall = "SELECT * FROM COMPANY_LIST ORDER BY COMPANYNAME";

	String company_searchAll = "SELECT * FROM COMPANY_LIST "
	         + "WHERE COM_NAME LIKE '%' || ? || '%' "
	         + "OR INDUSTRY_NAME LIKE '%' || ? || '%' "
	         + "OR COM_CODE LIKE '%' || ? || '%' " 
	         + "ORDER BY COM_NAME";

	String company_searchName = "SELECT * FROM COMPANY_LIST "
			+ "WHERE COM_NAME  LIKE '%' || ? || '%'";
	
	String company_searchCode = "SELECT * FROM COMPANY_LIST "
			+ "WHERE COM_CODE  LIKE '%' || ? || '%'";
	
	String company_searchIndustry = "SELECT * FROM COMPANY_LIST "
			+ "WHERE INDUSTRY_NAME  LIKE '%' || ? || '%'";
};
