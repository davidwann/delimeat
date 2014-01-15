
package com.javacareerlab.clscrammer.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.javacareerlab.clscrammer.db.SpamDb;

public class CategoryDAO {

	// private FooClass connection;
	
	private Connection connection;
	
	/* - - - - - - - - - - */
	
	public CategoryDAO() {
	
		this.connection = SpamDb.getConnection();
	}
	
	/* - - - - - - - - - - */
	
	public boolean save(Category category) {
	
		if (category.getId() == 0) {
			return this.insert(category);
		}
		else {
			return this.update(category);
		}
	}
	
	/* - - - - - - - - - - */
	
	/*

	CREATE TABLE Categories
	(
		id               BIGINT       NOT NULL  GENERATED ALWAYS AS IDENTITY,  
		category         VARCHAR(10)  NOT NULL  DEFAULT '',
		category_desc    VARCHAR(50)  NOT NULL  DEFAULT '',
		parent_category  VARCHAR(50)  NOT NULL  DEFAULT '',
		PRIMARY KEY (id)
	);
	
	*/
	
	private boolean insert(Category category) {
		
		String sql;
		PreparedStatement ps = null;
		int queryResult = 0;
		
		/* - - - - - - - - - - */
		
		System.out.println(" ");
		System.out.println("CategoryDAO.insert() is executing...");
		System.out.println(" ");

		sql = "INSERT INTO Categories  " + 
		      "      (category,        " + 
			  "       category_desc,   " + 
			  "       parent_category) " + 
			  "   VALUES               " + 
			  "      (?, ?, ?)         ";
		
		try {
			ps = this.connection.prepareStatement(sql);
		
			ps.setString(1, category.getCategory());
			ps.setString(2, category.getCategoryDesc());
			ps.setString(3, category.getParentCategory());
		
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
	
	private boolean update(Category category) {
	
		return true;
	}
	
	/* - - - - - - - - - - */
	
	
	/* - - - - - - - - - - */
	
	
	/* - - - - - - - - - - */
	
	
	/* - - - - - - - - - - */
	
}
