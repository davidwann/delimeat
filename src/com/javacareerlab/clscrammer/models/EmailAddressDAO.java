
package com.javacareerlab.clscrammer.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import com.javacareerlab.clscrammer.db.SpamDb;


public class EmailAddressDAO {

	private Connection connection;

	/* - - - - - - - - - - - - - - - - - - - - - */
	
	public EmailAddressDAO() {
		this.connection = SpamDb.getConnection();
	}

	/* - - - - - - - - - - - - - - - - - - - - - */

	public boolean insert(EmailAddress emailAddress) {
	
		// TODO: insert record into db table
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql;
		int queryResult = 0;
		
		/* - - - - - - - - - - */
		
		System.out.println(" ");
		System.out.println("EmailAddressDAO.insert() is executing...");
		System.out.println(" ");

		sql = "INSERT INTO EmailAddresses " + 
		      "      (email,              " + 
			  "       ad_url,             " + 
			  "       ad_date,            " + 
			  "       contacted,          " + 
			  "       city,               " + 
			  "       city_sector,        " + 
			  "       cl_ad_category,     " + 
			  "       website,            " + 
			  "       website_type,       " + 
			  "       created,            " + 
			  "       modified)           " + 
			  "   VALUES                  " + 
			  "      (?, ?, ?, ?, ?, ?,   " + 
			  "       ?, ?, ?, ?, ?)      ";
		
		try {
			ps = this.connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, emailAddress.getEmail());
			ps.setString(2, emailAddress.getAdUrl());
			ps.setDate(3, emailAddress.getAdDate());
			ps.setBoolean(4, emailAddress.isContacted());
			ps.setString(5, emailAddress.getCity());
			ps.setString(6, emailAddress.getCitySector());
			ps.setString(7, emailAddress.getClAdCategory());
			ps.setString(8, emailAddress.getWebsite());
			ps.setString(9, emailAddress.getWebsiteType());
			ps.setTimestamp(10, emailAddress.getCreated());
			ps.setTimestamp(11, emailAddress.getModified());

			queryResult = ps.executeUpdate();
			
			rs = ps.getGeneratedKeys();
			
			if (rs.next()) {
				emailAddress.setId(rs.getLong(1));
			}
			
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
				
			if (rs != null) {
				try {
					rs.close();
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
	
	/* - - - - - - - - - - - - - - - - - - - - - */
	
	public boolean update() {
	
		// TODO:  update record
	
		return true;
	}
	
	/* - - - - - - - - - - - - - - - - - - - - - */
	
	public boolean delete() {
	
		// TODO:  delete record
	
		return true;
	}
	
	/* - - - - - - - - - - - - - - - - - - - - - */
	

	/* - - - - - - - - - - - - - - - - - - - - - */
	

	/* - - - - - - - - - - - - - - - - - - - - - */
	




/*
CREATE TABLE EmailAddresses
(
   id              BIGINT        NOT NULL  GENERATED ALWAYS AS IDENTITY,
   email           VARCHAR(100)  NOT NULL  DEFAULT '',
   ad_url          VARCHAR(100)  NOT NULL  DEFAULT '',
   ad_date         DATE          NOT NULL  DEFAULT '1900-01-01',
   contacted       BOOLEAN       NOT NULL  DEFAULT FALSE,
   city            VARCHAR(25)   NOT NULL  DEFAULT '',
   city_sector     VARCHAR(10)   NOT NULL  DEFAULT '',
   cl_ad_category  VARCHAR(10)   NOT NULL  DEFAULT '',
   website         VARCHAR(50)   NOT NULL  DEFAULT '',
   website_type    VARCHAR(20)   NOT NULL  DEFAULT '',
   created         TIMESTAMP     NOT NULL  DEFAULT CURRENT_TIMESTAMP,
   modified        TIMESTAMP     NOT NULL  DEFAULT CURRENT_TIMESTAMP,
   PRIMARY KEY (id)
);
*/

}
