package com.Estuate.DbConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	private static String url = "jdbc:mysql://localhost:3306/estuate" ;
	private static String username = "root";
	private static String password = "dili4400";
	private static Connection con;

	public static Connection connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url, username, password);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	return con;
	}

}
