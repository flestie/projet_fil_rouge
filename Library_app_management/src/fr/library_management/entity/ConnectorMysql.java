package fr.library_management.entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorMysql {

	private Connection cn = null;
	private final String url = "jdbc:mysql://localhost:3306/library";
	private final String username = "root";
	private final String password = "root";
	
	
	public ConnectorMysql() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public Connection getCn() {
		return this.cn;
	}
}
