package com.ajax.test.common;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBCon {
	private static String URL;
	private static String ID;
	private static String PWD;
	private static String DRIVER_NAME;
	
	static {
		InputStream is = DBCon.class.getResourceAsStream("/config/dbcon.properties");
		Properties prop = new Properties();
		try {
			prop.load(is);
			URL = prop.getProperty("url");
			ID = prop.getProperty("id");
			PWD = prop.getProperty("pwd");
			DRIVER_NAME = prop.getProperty("driver");
			Class.forName(DRIVER_NAME);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Connection getCon() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL,ID,PWD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
		
	}
	public static void main(String[]args) {
		getCon();//실행했을때 아무것도 안떠야 됨
		
	}

}
