package hd.dao;

public interface HeartDartSQL {

	String company_selectall = "SELECT * FROM COMPANY_LIST ORDER BY COMPANYNAME";

	String company_select = "SELECT * FROM COMPANY_LIST WHERE ? LIKE '%?%'" + "ORDER BY COMPANYNAME";
};
