package org.alcoseba.japanesequiz.dbo.conn.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.alcoseba.japanesequiz.dbo.conn.IConnection;

public class JDBCConnection implements IConnection {

	private Connection connection;

	private String url = "jdbc:postgresql://localhost/postgres";
	private Properties props = new Properties();

	public JDBCConnection() throws SQLException {
		props.setProperty("user", "postgres");
		props.setProperty("password", "root");
		// this.connection = DriverManager.getConnection(url, props);
	}

	@Override
	public Connection getConnection() {
		Connection connection = null;

		try {
			connection = DriverManager.getConnection(url, props);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}
}
