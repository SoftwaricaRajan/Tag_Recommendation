package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DB {

	/**
	 * Databasename: entagrec
	 * user: root (change it in constructor below
	 * psw: root(change is in constructor below)
	 */
	public Connection getDBConnection() throws ClassNotFoundException, SQLException {

		// 1. Register Driver
		Class.forName("com.mysql.jdbc.Driver");

		// 2. Create Connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/entagrec?useSSL=false", "root",
				"");
		
		return conn;

	}

}
