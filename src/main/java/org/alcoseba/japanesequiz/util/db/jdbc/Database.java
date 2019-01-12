package org.alcoseba.japanesequiz.util.db.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database {
	public Database() {
		try {
			String url = "jdbc:postgresql://localhost/postgres";
			Properties props = new Properties();
			props.setProperty("user","postgres");
			props.setProperty("password","root");
			Connection conn = DriverManager.getConnection(url, props);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
