package com.javacareerlab.clscrammer.gui;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class EmailAccountsFrame {
	
	public static void createAndShowFrame() {
		
		System.out.println("EmailAccountsFrame is being created and displayed.");
		
		JFrame frame = new JFrame("Email Accounts");
		EmailAccountsFrame.initFrame(frame);
		frame.setVisible(true);
		
	}
	
	private static void initFrame(JFrame frame) {
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(600, 400);
		frame.setLocationRelativeTo(null);
		
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();

		//create button

		JButton b = new JButton("Click Me");
		
		// set attributes of c

		c.gridx = 0;
		c.gridy = 0;

		// pane.add(button, c);
		contentPane.add(b, c);

	}
	
}
