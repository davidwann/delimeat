
package com.javacareerlab.clscrammer.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

// import com.javacareerlab.clscrammer.models.CategoryDAO;
import com.javacareerlab.clscrammer.models.Category;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Test001Frame {

	private static JFrame frame;
	
	// private static CategoryDAO categoryDao;
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
		
		// add controls to frame
		
		// Container contentPane;
		// contentPane = Test001Frame.frame.getContentPane();
		
		// add a button
		
		// set frame size
		
		/* - - - - - - - - - - - - - - - - - - - - - */
		/*    Create a GridBagConstraints object     */
		/* - - - - - - - - - - - - - - - - - - - - - */
		
		GridBagConstraints c;
		c = new GridBagConstraints();
		
		/* - - - - - - - - - - - - */
		/*     Create a Button     */
		/* - - - - - - - - - - - - */
		
		JButton connectToDbServerButton;
		// connectToDbServerButton = new JButton("Create Database");
		
		// connectToDbServerButton = new JButton("Connect to Database Server");
		// connectToDbServerButton.setActionCommand("Connect_to_DB_Server");
		
		connectToDbServerButton = new JButton("Insert Record Into Table [Categories]");
		connectToDbServerButton.setActionCommand("INSERT_INTO_CATEGORIES");
		
		// connectToDbServerButton.addActionListener(Test001Frame.categoryDao);
		// connectToDbServerButton.addActionListener(Test001Frame.category);
		
		connectToDbServerButton.addActionListener(new Test001Frame.FrameEventHandler());
		
		
		
		
		
		
		// c.ipady = 400;
		// c.ipadx = 600;
		
		c.insets = new Insets(32, 56, 32, 56);
		
		
		
		
		
		/* - - - - - - - - - - - - - - - - - - */
		/*    Add Button to the main panel     */
		/* - - - - - - - - - - - - - - - - - - */
		
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
			
			switch (ae.getActionCommand()) {
			
				case "INSERT_INTO_CATEGORIES":
					this.insertRecord();
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

	
		/* - - - - - - - - - - */

	
		/* - - - - - - - - - - */

	
		/* - - - - - - - - - - */

	
		/* - - - - - - - - - - */

	
		/* - - - - - - - - - - */

	
		/* - - - - - - - - - - */

	
		/* - - - - - - - - - - */


	
	
	}   // end of nested static class definition :: FrameEventHandler
	
	/* - - - - - - - - - - */
	
}
