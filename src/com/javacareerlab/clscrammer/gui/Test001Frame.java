
package com.javacareerlab.clscrammer.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import com.javacareerlab.clscrammer.models.CategoryDAO;

public class Test001Frame {

	private static JFrame frame;
	private static CategoryDAO categoryDao;

	public static void createAndShowFrame() {
	
		Test001Frame.categoryDao = new CategoryDAO();
	
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
		connectToDbServerButton = new JButton("Connect to Database Server");
		
		connectToDbServerButton.addActionListener(Test001Frame.categoryDao);
		
		
		
		
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



}
