package com.alleyne.utils;

public class DbUtilsTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String sql = "insert t_url(url) values(?) ";
		//String sql = "select url from t_url where id = ?";
		//System.out.println(DbUtils.insert(sql, "13331"));
		System.out.println(DbUtils.insert(sql, "www.jd.com"));
	}

}
