package com.lowes.empapp.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.cj.jdbc.MysqlDataSource;

public class JdbcConnection {

	Connection conn = null;
	Statement stmt = null;

	public Connection getConnection() {
		try {
			// STEP 2: Create Datasource instance
			MysqlDataSource dataSource = new MysqlDataSource();

			// Loading configuration from properties file
			Properties prop = new Properties();
			prop.load(new FileInputStream("jdbc.properties"));

			String dbServerName = prop.getProperty("dbServerName");
			String username = prop.getProperty("username");
			String password = prop.getProperty("password");

			dataSource.setDatabaseName("jdbctraining");
			dataSource.setServerName(dbServerName);
			dataSource.setUser(username);
			dataSource.setPassword(password);

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = dataSource.getConnection();
			conn.setAutoCommit(false); // enable transaction

			System.out.println("Connection estabilished: " + conn);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;

	}

}
