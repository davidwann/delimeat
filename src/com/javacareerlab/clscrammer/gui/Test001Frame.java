
package com.javacareerlab.clscrammer.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

// import com.javacareerlab.clscrammer.models.CategoryDAO;
import com.javacareerlab.clscrammer.models.Category;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Test001Frame {

	private static JFrame frame;
	
	private static Category category;
	
	/* - - - - - - - - - - */

	public static void createAndShowFrame() {
	
		// Test001Frame.categoryDao = new CategoryDAO();
		Test001Frame.category = new Category();
	
		Test001Frame.initFrame();
		
		// show the JFrame
		// Test001Frame.frame.show();
	
	}
	
	/* - - - - - - - - - - */
	
	private static void initFrame() {
	
		// create new JFrame
		
		Test001Frame.frame = new JFrame("Create Database");
		Test001Frame.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// JFrame frame;
		// frame = new JFrame("Create Database");
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/* - - - - - - - - - - - - - - - - - - - - - - - - - - - */
		/*    Create a JPanel object to hold all the controls    */
		/* - - - - - - - - - - - - - - - - - - - - - - - - - - - */
		
		JPanel contentPane = new JPanel(new GridBagLayout());
		
		// now add controls to panel
		
		/* - - - - - - - - - - - - - - - - - - - - - */
		/*    Create a GridBagConstraints object     */
		/* - - - - - - - - - - - - - - - - - - - - - */
		
		GridBagConstraints c;
		c = new GridBagConstraints();
		
		/* - - - - - - - - - - - - */
		/*     Create a Label      */
		/* - - - - - - - - - - - - */
		
		JLabel categoriesLabel = new JLabel("Categories Table");
		
		c.gridx = 0;
		c.gridy = 0;
				
		c.insets = new Insets(32, 56, 8, 56);
		
		contentPane.add(categoriesLabel, c);
		
		
		/* - - - - - - - - - - - - - - - - - - - - - */
		/*     Create 1 (?) Action Listener for      */
		/*     all the controls on this frame        */
		/* - - - - - - - - - - - - - - - - - - - - - */
		
		Test001Frame.FrameEventHandler myActionListener = new Test001Frame.FrameEventHandler();
		
		
		/* - - - - - - - - - - - - - - - - - - - - - - - */
		/*     Create a Button - Truncate Table          */
		/* - - - - - - - - - - - - - - - - - - - - - - - */

		JButton truncateCategoriesTableButton;     // connectToDbServerButton;
		
		truncateCategoriesTableButton = new JButton("Truncate Table [Categories]");
		truncateCategoriesTableButton.setActionCommand("TRUNCATE_TABLE_CATEGORIES");
		
		// connectToDbServerButton.addActionListener(new Test001Frame.FrameEventHandler());
		truncateCategoriesTableButton.addActionListener(myActionListener);
		
		c.gridx = 0;
		c.gridy = 1;
		
		// c.ipady = 400;
		// c.ipadx = 600;
		
		c.insets = new Insets(8, 56, 8, 56);
		
		contentPane.add(truncateCategoriesTableButton, c);
		
		
		/* - - - - - - - - - - - - - - - - - - - - - - - */
		/*     Create a Button - Fill Table              */
		/* - - - - - - - - - - - - - - - - - - - - - - - */
		
		JButton connectToDbServerButton;
		
		connectToDbServerButton = new JButton("Insert Records into Table [Categories]");
		connectToDbServerButton.setActionCommand("INSERT_INTO_CATEGORIES");
		
		// connectToDbServerButton.addActionListener(new Test001Frame.FrameEventHandler());
		connectToDbServerButton.addActionListener(myActionListener);
		
		c.gridx = 0;
		c.gridy = 2;
		
		// c.ipady = 400;
		// c.ipadx = 600;
		
		c.insets = new Insets(8, 56, 8, 56);
		
		contentPane.add(connectToDbServerButton, c);
		
		
		/* - - - - - - - - - - - - - - - - - - */
		/*                                     */
		/* - - - - - - - - - - - - - - - - - - */
		
		Test001Frame.frame.setContentPane(contentPane);
		Test001Frame.frame.pack();
		Test001Frame.frame.setVisible(true);
		
		// frame.setContentPane(contentPane);
		// frame.pack();
		// frame.setVisible(true);

		return;
	}
	
	/* - - - - - - - - - - */
	
	private static class FrameEventHandler implements ActionListener {
	
		private Category category;
	
		/* - - - - - - - - - - */
		// default constructor
		/* - - - - - - - - - - */
		public FrameEventHandler() {
			this.category = new Category();
		}
	
		/* - - - - - - - - - - */
	
		public void actionPerformed(ActionEvent ae) {
		
			// Let's rock!
			
			System.out.println("Test001Frame.FrameEventHandler.actionPerformed method is executing!");
			System.out.println("ActionEvent.getActionCommand(): " + ae.getActionCommand());
			System.out.println(" ");
			
			// do more stuff!
			
			// FILL_FROM_TEXT_FILE ?
			
			switch (ae.getActionCommand()) {
			
				case "INSERT_INTO_CATEGORIES":
					this.insertRecord();
					break;
			
				case "TRUNCATE_TABLE_CATEGORIES":
					this.truncateTable();
					break;

				default:
					// do nothing
					break;
			}
			
			
			
			
		}
	
		/* - - - - - - - - - - */
		
		private void insertRecord() {
		
			System.out.println(" ");
			System.out.println("Method Test001Frame.FrameEventHandler.insertRecord() is executing!");
			System.out.println(" ");
			
			// reo|Real Estate by Owner|Housing
			// apa|Apts/Housing For Rent|Housing
			// roo|Rooms & Shares|Housing
			// sub|Sublets & Temporary|Housing
			// sha|Room/Share Wanted|Housing

			this.category.setId(0);
			
			// this.category.setCategory("reo");
			// this.category.setCategoryDesc("Real Estate by Owner");
			// this.category.setParentCategory("Housing");
			// this.category.save();
			
			this.category.setCategory("apa");
			this.category.setCategoryDesc("Apts/Housing For Rent");
			this.category.setParentCategory("Housing");
			this.category.save();
			
			this.category.setCategory("roo");
			this.category.setCategoryDesc("Rooms & Shares");
			this.category.setParentCategory("Housing");
			this.category.save();
			
			this.category.setCategory("sub");
			this.category.setCategoryDesc("Sublets & Temporary");
			this.category.setParentCategory("Housing");
			this.category.save();
			
			this.category.setCategory("sha");
			this.category.setCategoryDesc("Room/Share Wanted");
			this.category.setParentCategory("Housing");
			this.category.save();
			
			return;
		}

		/* - - - - - - - - - - */

		private void truncateTable() {

			System.out.println(" ");
			System.out.println("Method Test001Frame.FrameEventHandler.truncateTable() is executing!");
			System.out.println(" ");

			this.category.deleteAll();

			return;
		}

		/* - - - - - - - - - - */
		
		// INSERT MULTIPLE RECORDS INTO CATEGORIES TABLE
		// WITH DATA FROM TEXT FILE
		
		// populateCategoriesTableFromTextFile()
		
		private void  populateCategoriesTableFromTextFile() {
			
			// Loop thru the records in the text file!
			
			
			
			return;
		}
		
		/* - - - - - - - - - - */

	
		/* - - - - - - - - - - */

	
		/* - - - - - - - - - - */

	
		/* - - - - - - - - - - */

	
		/* - - - - - - - - - - */

	
		/* - - - - - - - - - - */


	
	
	}   // end of nested static class definition :: FrameEventHandler
	
	/* - - - - - - - - - - */
	
}
