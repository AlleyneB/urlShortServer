package com.alleyne.dao;

import com.alleyne.utils.DbUtils;

public class UrlDao {
	public int addUrl(String url){
		String sql = "insert into t_url(url) values(?)";
		return DbUtils.insert(sql, url);
	}
	public String getUrl(int id){
		String sql = "select url from t_url where id = ?";
		return DbUtils.query(sql, String.valueOf(id));
	}
}
