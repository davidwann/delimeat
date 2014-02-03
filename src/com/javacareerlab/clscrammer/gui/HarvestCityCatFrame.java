
package com.javacareerlab.clscrammer.gui;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class HarvestCityCatFrame {



	private static JFrame frame;
	



	
	// ------------------------------------------------------
	
	public static void createAndShowFrame() {
		
		System.out.println("HarvestCityCatFrame is being created and displayed.");
		
		// JFrame frame = new JFrame("Craigslist Scrammer");
		HarvestCityCatFrame.frame = new JFrame("Craigslist Scrammer");
		HarvestCityCatFrame.initFrame();
		HarvestCityCatFrame.frame.setVisible(true);
		
	}
	
	private static void initFrame() {
		
		HarvestCityCatFrame.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		HarvestCityCatFrame.frame.setSize(600, 400);
		HarvestCityCatFrame.frame.setLocationRelativeTo(null);
		
		Container contentPane = HarvestCityCatFrame.frame.getContentPane();
		contentPane.setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();
		
		c.insets = new Insets(8, 8, 8, 8);
		
		// - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
		
		MainFrameActionListener mfal = new MainFrameActionListener();
		
		// - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
		
		// HarvestCityCatFrame.viewRelayAccountsButton = new JButton("View Relay Accounts");
		
		// HarvestCityCatFrame.viewRelayAccountsButton.addActionListener(mfal);
		
		c.gridx = 0;
		c.gridy = 0;
		
		// contentPane.add(HarvestCityCatFrame.viewRelayAccountsButton, c);
		
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
		
		// HarvestCityCatFrame.startHarvestButton = new JButton("Start Harvesting");
		// HarvestCityCatFrame.startHarvestButton = new JButton("Harvest Test 1");
		
		// HarvestCityCatFrame.startHarvestButton.addActionListener(new HarvestCityCatFrame.StartHarvestButtonActionListener());
		// HarvestCityCatFrame.startHarvestButton.addActionListener(mfal);
		
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
		
		// contentPane.add(HarvestCityCatFrame.startHarvestButton, c);
		
		// - - - - - - - - - - - - - - - - - - - - - -
		
		// HarvestCityCatFrame.stopHarvestButton = new JButton("Stop Harvesting");
		// HarvestCityCatFrame.stopHarvestButton.setEnabled(false);
		// HarvestCityCatFrame.stopHarvestButton.addActionListener(mfal);
		
		c.gridx = 1;
		c.gridy = 1;
		
		// contentPane.add(HarvestCityCatFrame.stopHarvestButton, c);
		
		// - - - - - - - - - - - - - - - - - - - - - -
		
		// HarvestCityCatFrame.startEmailButton = new JButton("Start Sending Emails");
		// HarvestCityCatFrame.startEmailButton.setEnabled(false);   // should be true by default
		// HarvestCityCatFrame.startEmailButton.addActionListener(mfal);
		
		c.gridx = 2;
		c.gridy = 0;
		
		// contentPane.add(HarvestCityCatFrame.startEmailButton, c);
		
		// - - - - - - - - - - - - - - - - - - - - - -
		
		// HarvestCityCatFrame.stopEmailButton = new JButton("Stop Sending Emails");
		// HarvestCityCatFrame.stopEmailButton.setEnabled(false);
		// HarvestCityCatFrame.stopEmailButton.addActionListener(mfal);
		
		c.gridx = 2;
		c.gridy = 1;
		
		// contentPane.add(HarvestCityCatFrame.stopEmailButton, c);
		
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
			
//			switch (ae.getActionCommand()) {
//			
//				case "View Relay Accounts":
//					
//					RelayAccountsFrame.createAndShowFrame();
//				
//					break;
//			
//				case "Start Harvesting":
//					
//					HarvestCityCatFrame.startHarvestButton.setEnabled(false);
//				
//					System.out.println("Button [Start Harvesting] was clicked");
//				
//					HarvestCityCatFrame.harvester = new Harvester();
//					
//					HarvestCityCatFrame.harvester.addHarvestCompletionListener(new HCListener());
//					
//					// create a new thread, pass it the harvester, then start the thread
//					// ( this will cause the harvester to start harvesting )
//					// -----------------------------------------------------------------
//					Thread t1 = new Thread(HarvestCityCatFrame.harvester);
//					t1.start();
//					
//					HarvestCityCatFrame.stopHarvestButton.setEnabled(true);
//					
//					break;
//			
//			
//				case "Stop Harvesting":
//				
//					HarvestCityCatFrame.stopHarvestButton.setEnabled(false);
//					
//					System.out.println("Button [Stop Harvesting] was clicked");
//					
//					HarvestCityCatFrame.harvester.stopHarvesting();
//					
//					HarvestCityCatFrame.startHarvestButton.setEnabled(true);
//					
//					break;
//		
//		
//				case "Harvest Test 1":
//				
//					// System.out.println("Harvest Test 1 is underway.");
//
//					HarvestCityCatFrame.harvester = new Harvester();
//					HarvestCityCatFrame.harvester.logTest();
//					HarvestCityCatFrame.harvester = null;
//
//					break;
//			
//			
//				case "Start Sending Emails":
//					
//					HarvestCityCatFrame.startEmailButton.setEnabled(false);
//					
//					System.out.println("Button [Start Sending Emails] was clicked");
//					
//					HarvestCityCatFrame.emailer = new Emailer();
//					
//					HarvestCityCatFrame.emailer.addEmailCompletionListener(new ECListener());
//					
//					Thread t2 = new Thread(HarvestCityCatFrame.emailer);
//					t2.start();
//					
//					HarvestCityCatFrame.stopEmailButton.setEnabled(true);
//					
//					break;
//					
//				
//				case "Stop Sending Emails":
//					
//					HarvestCityCatFrame.stopEmailButton.setEnabled(false);
//					
//					System.out.println("Button [Stop Sending Emails] was clicked");
//					
//					HarvestCityCatFrame.emailer.stopSending();
//					
//					// HarvestCityCatFrame.startEmailButton.setEnabled(true);
//					
//					
//					// at this point, the user should be given a message 
//					// telling him that the shutdown process has started
//					// and could take up to 24 minutes
//					
//					
//					break;
//				
//				
//				default:
//					// do nothing
//					break;
//
//			}
			
			
			
			
			
		}
	}
	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	
	// Harvest Completion Listener Object
	
//	static class HCListener implements HarvestCompletionListener {
//
//		@Override
//		public void actionPerformed(HarvestCompletionEvent e) {
//			// TODO Auto-generated method stub
//			
//			HarvestCityCatFrame.stopHarvestButton.setEnabled(false);
//			HarvestCityCatFrame.startHarvestButton.setEnabled(true);
//		}
//	}
	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	
	// Email Completion Listener Object
	
//	static class ECListener implements EmailCompletionListener {
//
//		@Override
//		public void actionPerformed(EmailCompletionEvent e) {
//			// TODO Auto-generated method stub
//			
//			// HarvestCityCatFrame.stopEmailButton.setEnabled(false);
//			HarvestCityCatFrame.startEmailButton.setEnabled(true);
//			
//			
//			// at this point, the user should be given a message
//			// telling him that the "stop emailing" process is complete
//			// and that it is now safe to end the program
//			
//			
//		}
//	}
	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	
	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -







}
