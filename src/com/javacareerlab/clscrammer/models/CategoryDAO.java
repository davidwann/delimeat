
package com.javacareerlab.clscrammer.models;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.Connection;

import com.javacareerlab.clscrammer.db.SpamDb;

public class CategoryDAO implements ActionListener {

	// private FooClass connection;
	
	private Connection connection;
	
	/* - - - - - - - - - - */
	
	public CategoryDAO() {
	
		this.connection = SpamDb.getConnection();
	}
	
	/* - - - - - - - - - - */
	
	public void actionPerformed(ActionEvent ae) {
	
		// Let's rock!
		System.out.println("CategoryDAO.actionPerformed method is executing!");
	
	
	}
	
	/* - - - - - - - - - - */
	
	
	/* - - - - - - - - - - */
	
	
	/* - - - - - - - - - - */
	
	
	/* - - - - - - - - - - */
	

}


