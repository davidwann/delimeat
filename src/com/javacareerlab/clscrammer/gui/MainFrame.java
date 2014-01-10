package com.javacareerlab.clscrammer.gui;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// import javax.swing.AbstractAction;
// import javax.swing.BorderFactory;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.javacareerlab.clscrammer.Emailer;
import com.javacareerlab.clscrammer.Harvester;
import com.javacareerlab.clscrammer.actions.LoadEmailAccountsFrameAction;
import com.javacareerlab.clscrammer.events.EmailCompletionEvent;
import com.javacareerlab.clscrammer.events.HarvestCompletionEvent;
import com.javacareerlab.clscrammer.listeners.EmailCompletionListener;
import com.javacareerlab.clscrammer.listeners.HarvestCompletionListener;

public class MainFrame {
	
	private static JFrame frame;
	
	private static JButton startHarvestButton;
	private static JButton stopHarvestButton;
	
	private static JButton startEmailButton;
	private static JButton stopEmailButton;
	
	private static JButton viewRelayAccountsButton;
	
	private static Harvester harvester;
	private static Emailer emailer;
	
	// ------------------------------------------------------
	
	public static void createAndShowFrame() {
		
		System.out.println("MainFrame is being created and displayed.");
		
		// JFrame frame = new JFrame("Craigslist Scrammer");
		MainFrame.frame = new JFrame("Craigslist Scrammer");
		MainFrame.initFrame();
		MainFrame.frame.setVisible(true);
		
	}
	
	private static void initFrame() {
		
		MainFrame.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainFrame.frame.setSize(600, 400);
		MainFrame.frame.setLocationRelativeTo(null);
		
		Container contentPane = MainFrame.frame.getContentPane();
		contentPane.setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();
		
		c.insets = new Insets(8, 8, 8, 8);
		
		// - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
		
		MainFrameActionListener mfal = new MainFrameActionListener();
		
		// - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
		
		MainFrame.viewRelayAccountsButton = new JButton("View Relay Accounts");
		
		MainFrame.viewRelayAccountsButton.addActionListener(mfal);
		
		c.gridx = 0;
		c.gridy = 0;
		
		contentPane.add(MainFrame.viewRelayAccountsButton, c);
		
		// - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
		
//		//create button
//
//		// JButton b = new JButton("View Email Accounts");
//		JButton b = new JButton();
//		
//		// b.setBorder(BorderFactory.createEmptyBorder(32, 32, 32, 32));
//		
//		// b.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(32, 32, 32, 32), BorderFactory.createEmptyBorder(32, 32, 32, 32)));
//		
//		b.setAction(new LoadEmailAccountsFrameAction());
//		b.setText("View Relay Accounts");
//		
//		// set attributes of c
//
//		c.gridx = 0;
//		c.gridy = 0;
//		// c.ipady = 25;
//		// c.ipadx = 25;
//
//		// pane.add(button, c);
//		contentPane.add(b, c);
		
		// - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
		
		MainFrame.startHarvestButton = new JButton("Start Harvesting");
		// MainFrame.startHarvestButton = new JButton("Harvest Test 1");
		
		// MainFrame.startHarvestButton.addActionListener(new MainFrame.StartHarvestButtonActionListener());
		MainFrame.startHarvestButton.addActionListener(mfal);
		
		// b2.seten
		
//		b2.setAction(new AbstractAction() {
//			
//			/**
//			 * 
//			 */
//			private static final long serialVersionUID = 1L;
//
//			@Override
//			public void actionPerformed(ActionEvent ae) {
//				
//				// do work
//				System.out.println("Button [Start Harvesting] was clicked");
//				
//				// create an object
//				Harvester harvester = new Harvester();
//				
//				// create a new thread, pass it the harvester, then start the thread
//				// ( this will cause the harvester to start harvesting )
//				// -----------------------------------------------------------------
//				Thread t = new Thread(harvester);
//				t.start();
//				
//			}
//		});
//		
//		b2.setText("Start Harvesting");
		
		// b2.setBorder(BorderFactory.createEmptyBorder(32, 32, 32, 32));
		
		c.gridx = 1;
		c.gridy = 0;
		
		contentPane.add(MainFrame.startHarvestButton, c);
		
		// - - - - - - - - - - - - - - - - - - - - - -
		
		MainFrame.stopHarvestButton = new JButton("Stop Harvesting");
		MainFrame.stopHarvestButton.setEnabled(false);
		MainFrame.stopHarvestButton.addActionListener(mfal);
		
		c.gridx = 1;
		c.gridy = 1;
		
		contentPane.add(MainFrame.stopHarvestButton, c);
		
		// - - - - - - - - - - - - - - - - - - - - - -
		
		MainFrame.startEmailButton = new JButton("Start Sending Emails");
		// MainFrame.startEmailButton.setEnabled(false);   // should be true by default
		MainFrame.startEmailButton.addActionListener(mfal);
		
		c.gridx = 2;
		c.gridy = 0;
		
		contentPane.add(MainFrame.startEmailButton, c);
		
		// - - - - - - - - - - - - - - - - - - - - - -
		
		MainFrame.stopEmailButton = new JButton("Stop Sending Emails");
		MainFrame.stopEmailButton.setEnabled(false);
		MainFrame.stopEmailButton.addActionListener(mfal);
		
		c.gridx = 2;
		c.gridy = 1;
		
		contentPane.add(MainFrame.stopEmailButton, c);
		
		// - - - - - - - - - - - - - - - - - - - - - -
		
	}
	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	
	/*
	 *   N e s t e d   A c t i o n   L i s t e n e r   
	 *   C l a s s e s 
	 */
	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	
	static class MainFrameActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent ae) {
			// TODO Auto-generated method stub
			
			switch (ae.getActionCommand()) {
			
				case "View Relay Accounts":
					
					RelayAccountsFrame.createAndShowFrame();
				
					break;
			
				case "Start Harvesting":
					
					MainFrame.startHarvestButton.setEnabled(false);
				
					System.out.println("Button [Start Harvesting] was clicked");
				
					MainFrame.harvester = new Harvester();
					
					MainFrame.harvester.addHarvestCompletionListener(new HCListener());
					
					// create a new thread, pass it the harvester, then start the thread
					// ( this will cause the harvester to start harvesting )
					// -----------------------------------------------------------------
					Thread t1 = new Thread(MainFrame.harvester);
					t1.start();
					
					MainFrame.stopHarvestButton.setEnabled(true);
					
					break;
			
			
				case "Stop Harvesting":
				
					MainFrame.stopHarvestButton.setEnabled(false);
					
					System.out.println("Button [Stop Harvesting] was clicked");
					
					MainFrame.harvester.stopHarvesting();
					
					MainFrame.startHarvestButton.setEnabled(true);
					
					break;
		
		
				case "Harvest Test 1":
				
					// System.out.println("Harvest Test 1 is underway.");

					MainFrame.harvester = new Harvester();
					MainFrame.harvester.logTest();
					MainFrame.harvester = null;

					break;
			
			
				case "Start Sending Emails":
					
					MainFrame.startEmailButton.setEnabled(false);
					
					System.out.println("Button [Start Sending Emails] was clicked");
					
					MainFrame.emailer = new Emailer();
					
					MainFrame.emailer.addEmailCompletionListener(new ECListener());
					
					Thread t2 = new Thread(MainFrame.emailer);
					t2.start();
					
					MainFrame.stopEmailButton.setEnabled(true);
					
					break;
					
				
				case "Stop Sending Emails":
					
					MainFrame.stopEmailButton.setEnabled(false);
					
					System.out.println("Button [Stop Sending Emails] was clicked");
					
					MainFrame.emailer.stopSending();
					
					// MainFrame.startEmailButton.setEnabled(true);
					
					
					// at this point, the user should be given a message 
					// telling him that the shutdown process has started
					// and could take up to 24 minutes
					
					
					break;
				
				
				default:
					// do nothing
					break;

			}
		}
	}
	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	
	// Harvest Completion Listener Object
	
	static class HCListener implements HarvestCompletionListener {

		@Override
		public void actionPerformed(HarvestCompletionEvent e) {
			// TODO Auto-generated method stub
			
			MainFrame.stopHarvestButton.setEnabled(false);
			MainFrame.startHarvestButton.setEnabled(true);
		}
	}
	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	
	// Email Completion Listener Object
	
	static class ECListener implements EmailCompletionListener {

		@Override
		public void actionPerformed(EmailCompletionEvent e) {
			// TODO Auto-generated method stub
			
			// MainFrame.stopEmailButton.setEnabled(false);
			MainFrame.startEmailButton.setEnabled(true);
			
			
			// at this point, the user should be given a message
			// telling him that the "stop emailing" process is complete
			// and that it is now safe to end the program
			
			
		}
	}
	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	
	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	
}
