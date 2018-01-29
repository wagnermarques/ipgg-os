package com.ipgg.ipgg_os.persistence;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtil {

	private static String dbSgbd = "mysql";
	private static String dnServerHost = "localhost";
	private static String dbPort = "3306";
	private static String classNameForSgbdDriver = "com.mysql.cj.jdbc.Driver";
	// private static String classNameForSgbdDriver = "com.mysql.jdbc.Driver";
	private static String dbName = "**NAME**";
	private static String dbUser = "**USER**";
	private static String dbPassword = "**PASSWORD**";

	private static String jdbcStrConnection;
	private static Connection conn;

	static public Connection getConnection() {
		if (JDBCUtil.conn != null) {
			return JDBCUtil.conn;
		} else {
			try {
				Class.forName(classNameForSgbdDriver);
				JDBCUtil.jdbcStrConnection = "jdbc:" + dbSgbd + "//" + dnServerHost + ":" + dbPort + "/"
						+ dbName;
				JDBCUtil.conn = DriverManager.getConnection(jdbcStrConnection, dbUser, dbPassword);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return JDBCUtil.conn;
	}

}