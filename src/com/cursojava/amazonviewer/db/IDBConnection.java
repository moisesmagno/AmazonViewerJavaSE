package com.cursojava.amazonviewer.db;

import java.sql.Connection;
import java.sql.DriverManager;
import static com.cursojava.amazonviewer.db.DataBase.*;

public interface IDBConnection {

	default Connection connecToDB() {
		Connection connection = null;
		
		try {			
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL+DB, USER, PASSWORD);
			if (connection != null) {
				System.out.println("Se estableció la conexión :)");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		} finally {
			return connection;
		}
	}
}
