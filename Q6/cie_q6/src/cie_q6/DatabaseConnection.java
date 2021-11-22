package cie_q6;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	public static Connection initializeDB(String dbName) throws ClassNotFoundException {
		String dbDriver = "com.mysql.jdbc.Driver";
		String dbURL = "jdbc:mysql://localhost:3306/";
		String dbUser = "root";
		String dbPass = "";
		
		Class.forName(dbDriver);
		
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(dbURL + dbName, dbUser, dbPass);
			System.out.println("DB connected successfully...");
		} catch(Exception e) {
			System.out.println("Couldn't connect to database...");
			System.out.println(e);
		}
		
		return con;
	}
}