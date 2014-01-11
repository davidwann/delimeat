
package com.javacareerlab.clscrammer.db;

// import org.apache.derby.jdbc.ClientDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.Properties;

public class SpamDb {

	private static Connection connection = null;
	
	protected SpamDb() {
		// Exists only to prevent instantiation
	}
	
	/* - - - - - - - - - - */
	
	public static Connection getConnection() {
	
		if (SpamDb.connection == null) {
			// establish connection!
			SpamDb.connect();
		}
	
		return SpamDb.connection;
	}
	
	/* - - - - - - - - - - */

	private static boolean connect() {
	
		// todo: put connection string in config file
		
		String conString;
		
		// ClientDriver derby = new ClientDriver();
		
		Properties connectionProps = new Properties();
		
		// - - - - - - - - - - - - - - - - - - - - - - - -
		
		// conString = "jdbc:derby://localhost:1527/SpamDb;create=true";
		// conString = "jdbc:derby://10.8.3.0:1527/SpamDb;create=true";
		conString = "jdbc:derby://localhost:1527/SpamDb";
		
		connectionProps.put("user", "APP");
		connectionProps.put("password", "");
		
		try {
			
			// Class.forName("org.apache.derby.jdbc.ClientDriver");
			// DriverManager.registerDriver(new ClientDriver());
			
			// SpamDb.connection = DriverManager.getConnection(conString, connectionProps);
			SpamDb.connection = DriverManager.getConnection(conString);
		}
		catch (SQLException e) {
		
			System.out.println("Error occurred when attempting to connect to database");
			System.out.println("Class:  SpamDb");
			System.out.println("Method: connect()");
			System.out.println("Error Message:");
			System.out.println(e.getMessage());
		}
		
		

		return true;


		/*
		
		try {
			
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			
			DriverManager.registerDriver(new ClientDriver());
			
			SpamDb.connection = DriverManager.getConnection(conString, connectionProps);
		}
		catch (SQLException e) {
		
			System.out.println("Error occurred when attempting to connect to database");
			System.out.println("Class:  SpamDb");
			System.out.println("Method: connect()");
			System.out.println("Error Message:");
			System.out.println(e.getMessage());
		}
		catch (ClassNotFoundException e) {
		
			System.out.println("ClassNotFoundException has occurred.");
			System.out.println("Class:  SpamDb");
			System.out.println("Method: connect()");
			System.out.println("Error Message:");
			System.out.println(e.getMessage());
		}
		
		
		==========================================================
		
		
		==========================================================
		
		
		==========================================================
		
		
		try {
			SpamDb.connection = derby.connect(conString, connectionProps);
		}
		catch (SQLException e) {
		
			System.out.println("Error occurred when attempting to connect to database");
			System.out.println("Class:  SpamDb");
			System.out.println("Method: connect()");
			System.out.println("Error Message:");
			System.out.println(e.getMessage());
		}
		
		
		*/
		
	}
	
	/* - - - - - - - - - - */
	
	
	/* - - - - - - - - - - */
	
	
	/* - - - - - - - - - - */
	
}
