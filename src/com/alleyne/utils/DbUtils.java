package com.alleyne.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DbUtils {
	private static String DRIVER;
	private static String URL;
	private static String USER;
	private static String PASSWORD;
	
	static{
		loadConfig();
	}
	/**
	 * �������ݿ������ļ�����ȡ����
	 */
	private static void loadConfig() {
		// TODO Auto-generated method stub
		InputStream is = null;
		try{
			Properties properties = new Properties();
			is = DbUtils.class.getResourceAsStream("/jdbc.properties");
			properties.load(is);
			DRIVER = properties.getProperty("jdbc.driver");
			URL = properties.getProperty("jdbc.url");
			USER = properties.getProperty("jdbc.user");
			PASSWORD = properties.getProperty("jdbc.password");
		}catch (IOException e) {
			throw new RuntimeException("��ȡ���ݿ������ļ��쳣��", e);
		}finally{
			try{
				if (is != null) {
					is.close();
				}
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * ��ȡconnection
	 */
	public static Connection getConnection(){
		Connection connection = null;
		try{
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e){
			e.printStackTrace();
		}
		return connection;
	}

	//ִ�в��벢����ID
	public static int insert(String sql,String... args){
		int id = -1;
		Connection connection = getConnection();
		PreparedStatement ps = null;
		try {
			if (sql==null||sql.equals("")) {
				return id;
			}else {
				ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				for (int i = 0; i < args.length; i++) {
					ps.setObject(i+1, args[i]);
				}
				ps.executeUpdate();
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
					id = rs.getInt(1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeDb(ps,connection);
		}
		return id;
	}
	//��ѯ����
	public static String query(String sql,String arg){
		String url = "";
		Connection connection = null;
		PreparedStatement ps =null;
		try{
			if (sql==null||sql.equals("")) {
				return url;
			}else {
			connection = getConnection();
			ps = connection.prepareStatement(sql);
			ps.setObject(1, arg);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				url = rs.getString(1);
			}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeDb(ps,connection);
		}
		return url;
	}
	
	//�ر���Դ
	public static void closeDb(Object... args){
		if (args==null) {
			return;
		}
		try {
			for (int i = 0; i < args.length; i++) {
				if (args[i] instanceof PreparedStatement &&args[i]!=null) {
					((PreparedStatement)args[i]).close();
				}
				if (args[i] instanceof Connection &&args[i]!=null) {
					((Connection)args[i]).close();
				}
				if (args[i] instanceof ResultSet &&args[i]!=null) {
					((ResultSet)args[i]).close();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
