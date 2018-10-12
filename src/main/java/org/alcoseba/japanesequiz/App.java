package org.alcoseba.japanesequiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class App {
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:postgresql://localhost/japanese_dictionary";
		Properties props = new Properties();
		props.setProperty("user","postgres");
		props.setProperty("password","root");
		Connection conn = DriverManager.getConnection(url, props);
	}
}
