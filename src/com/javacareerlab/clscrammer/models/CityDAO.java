
package com.javacareerlab.clscrammer.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.javacareerlab.clscrammer.db.SpamDb;

public class CityDAO {

	private Connection connection;
	
	/* - - - - - - - - - - */
	
	public CityDAO() {
	
		this.connection = SpamDb.getConnection();
	}
	
	/* - - - - - - - - - - */
	
	public boolean save(City city) {
	
		if (city.getId() == 0) {
			return this.insert(city);
		}
		else {
			return this.update(city);
		}
	}
	
	/* - - - - - - - - - - */
	
	/*

	CREATE TABLE Cities
	(
		id            BIGINT        NOT NULL  GENERATED ALWAYS AS IDENTITY,
		city          VARCHAR(25)   NOT NULL  DEFAULT '',
		city_sector   VARCHAR(10)   NOT NULL  DEFAULT '',
		website       VARCHAR(50)   NOT NULL  DEFAULT '',
		website_type  VARCHAR(20)   NOT NULL  DEFAULT '',
		spam          VARCHAR(3)    NOT NULL  DEFAULT '',
		region        VARCHAR(100)  NOT NULL  DEFAULT '',
		PRIMARY KEY (id)
	);
	
	*/
	
	private boolean insert(City city) {
		
		String sql;
		PreparedStatement ps = null;
		int queryResult = 0;
		
		/* - - - - - - - - - - */
		
		System.out.println(" ");
		System.out.println("CityDAO.insert() is executing...");
		System.out.println(" ");

		sql = "INSERT INTO Cities       " + 
		      "      (city,             " + 
			  "       city_sector,      " + 
			  "       website,          " + 
			  "       website_type,     " + 
			  "       spam,             " + 
			  "       region)           " + 
			  "   VALUES                " + 
			  "      (?, ?, ?, ?, ?, ?) ";
		
		try {
			ps = this.connection.prepareStatement(sql);
		
			ps.setString(1, city.getCity());
			ps.setString(2, city.getCitySector());
			ps.setString(3, city.getWebsite());
			ps.setString(4, city.getWebsiteType());
			ps.setString(5, city.getSpam());
			ps.setString(6, city.getRegion());
		
			queryResult = ps.executeUpdate();
		}
		catch (SQLException e) {
		
			System.out.println(" ");
			System.out.println("SQLException was thrown");
			System.out.println(" ");
			System.out.println("Error Message:");
			System.out.println(e.getMessage());
			System.out.println(" ");
		}
		finally {
			if (ps != null) {
				try {
					ps.close();
				}
				catch (SQLException e) {
					// Really?  
					// Oh well, we tried.
				}
			}
		}
		
		System.out.println(" ");
		// System.out.println("CategoryDAO.insert() is executing...");
		System.out.println("PreparedStatement.executeUpdate() returned: " + Integer.toString(queryResult));
		System.out.println(" ");
		
		return true;
	}
	
	/* - - - - - - - - - - */
	
	private boolean update(City city) {
	
		return true;
	}
	
	/* - - - - - - - - - - */
	
	public boolean deleteAll() {
		
		String sql;
		PreparedStatement ps = null;
		int queryResult = 0;
		
		/* - - - - - - - - - - */
		
		System.out.println(" ");
		System.out.println("CityDAO.deleteAll() is executing...");
		System.out.println(" ");

		sql = "TRUNCATE TABLE Cities";

		try {
			ps = this.connection.prepareStatement(sql);
			queryResult = ps.executeUpdate();
		}
		catch (SQLException e) {
		
			System.out.println(" ");
			System.out.println("SQLException was thrown");
			System.out.println(" ");
			System.out.println("Error Message:");
			System.out.println(e.getMessage());
			System.out.println(" ");
		}
		finally {
			if (ps != null) {
				try {
					ps.close();
				}
				catch (SQLException e) {
					// Relax!  Take it easy!
				}
			}
		}
		
		System.out.println(" ");
		System.out.println("PreparedStatement.executeUpdate() returned: " + Integer.toString(queryResult));
		System.out.println(" ");
		
		return true;
	}
	
	/* - - - - - - - - - - */
	
	
	/* - - - - - - - - - - */
	
	
	/* - - - - - - - - - - */
	







}
