package com.javacareerlab.clscrammer.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
// import java.util.ListIterator;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.javacareerlab.clscrammer.EmailAccount;
// import com.javacareerlab.clscrammer.Emailer;
// import com.javacareerlab.clscrammer.Harvester;
// import com.javacareerlab.clscrammer.gui.MainFrame.ECListener;
// import com.javacareerlab.clscrammer.gui.MainFrame.HCListener;
import com.javacareerlab.clscrammer.RelayTester;

public class RelayAccountsFrame {
	
	private static JFrame frame;
	
	private static ArrayList<EmailAccount> emailAccounts;
	
	private static JList<String> list;
	
	private static JLabel emailValueLabel;
	private static JLabel usernameValueLabel;
	private static JLabel passwordValueLabel;
	private static JLabel smtpServerValueLabel;
	private static JLabel portValueLabel;
	private static JLabel senderLocalPartValueLabel;
	private static JLabel senderDomainValueLabel;
	
	private static JTextField emailValueTextField;
	private static JTextField usernameValueTextField;
	private static JTextField passwordValueTextField;
	private static JTextField smtpServerValueTextField;
	private static JTextField portValueTextField;
	private static JTextField senderLocalPartValueTextField;
	private static JTextField senderDomainValueTextField;

	private static JTextField recipientValueTextField;
	private static JTextField recipientCCValueTextField;
	private static JTextField subjectValueTextField;
	private static JTextField messageValueTextField;
	
	private static JTextArea responseTextArea;

	// ------------------------------------------------------
	
	public static void createAndShowFrame() {
		
		System.out.println("RelayAccountsFrame is being created and displayed.");
		
		RelayAccountsFrame.frame = new JFrame("Relay Accounts");
		RelayAccountsFrame.initFrame();
		RelayAccountsFrame.frame.setVisible(true);
		
	}
	
	// ------------------------------------------------------
	
	private static void initFrame() {
		
		RelayAccountsFrame.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		RelayAccountsFrame.frame.setSize(960, 880);
		// RelayAccountsFrame.frame.setLocationRelativeTo(null);
		
		Container contentPane = RelayAccountsFrame.frame.getContentPane();
		contentPane.setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();
		
		c.insets = new Insets(8, 8, 8, 8);
		
		// - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
		
		RafActionListener rafal = new RafActionListener();
		RafListSelectionListener raflsl = new RafListSelectionListener();
		
		// - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
		
		DefaultListModel<String> data = RelayAccountsFrame.getListData();
		
// 		DefaultListModel<String> data = new DefaultListModel<String>();
//		
//		data.addElement("david@yahoo.com");
//		data.addElement("fred@msn.com");
//		data.addElement("joe@hotmail.com");
//		data.addElement("jane@samsung.com");
		
		// - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
		// JList
		
		RelayAccountsFrame.list = new JList<String>(data);
		
		RelayAccountsFrame.list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		RelayAccountsFrame.list.setLayoutOrientation(JList.VERTICAL);  // JList.VERTICAL is the default
		RelayAccountsFrame.list.setVisibleRowCount(-1);
		
		RelayAccountsFrame.list.addListSelectionListener(raflsl);
		
		// - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
		// JScrollPane

		JScrollPane scrollPane = new JScrollPane(RelayAccountsFrame.list);
		
		scrollPane.setPreferredSize(new Dimension(240, 400));
		
		c.gridx = 0;
		c.gridy = 0;
		
		c.gridheight = 3;
		
		contentPane.add(scrollPane, c);
		
		c.gridheight = 1;
		
		// - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
		
		c.gridx = 1;  // row 1, column 2
		c.fill = GridBagConstraints.HORIZONTAL;
		contentPane.add(RelayAccountsFrame.createRelayAccountDetailsPanel(), c);
		c.fill = GridBagConstraints.NONE;

		
		// - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
		
		c.gridy = 1;  // row 2, column 2
		contentPane.add(RelayAccountsFrame.createOverridePanel(), c);
		
		// - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
		
		// drop in a button "Send Email"
		
		c.gridy = 2;  // row 3, column 2
		
		JButton sendEmailButton = new JButton("Send Email");
		sendEmailButton.addActionListener(rafal);
		contentPane.add(sendEmailButton, c);
		
		// - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
		// JTextArea inside a JScrollPane
		
		RelayAccountsFrame.responseTextArea = new JTextArea(12, 48);
		RelayAccountsFrame.responseTextArea.setText("Email response message will go here.");
		// RelayAccountsFrame.responseTextArea.setEditable(false);
		RelayAccountsFrame.responseTextArea.setEditable(true);
		
		JScrollPane responseScrollPane = new JScrollPane(RelayAccountsFrame.responseTextArea);
		
		responseScrollPane.setBorder(BorderFactory.createEtchedBorder());
		
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 2;
		
		contentPane.add(responseScrollPane, c);
				
		// - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
		
		
		
		// - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
		
		
		
	}
	
	// ------------------------------------------------------
	
	private static DefaultListModel<String> getListData() {
		
		DefaultListModel<String> data = new DefaultListModel<String>();
		EmailAccount relayAccount;
		
		// - - - - - - - - - - - - - - - - - - - - - - - -
		
		RelayAccountsFrame.loadEmailAccounts();
		
		Iterator<EmailAccount> relayAccounts = RelayAccountsFrame.emailAccounts.iterator();
		
		while (relayAccounts.hasNext()) {
			
			relayAccount = relayAccounts.next();
			data.addElement(relayAccount.getEmailAddress());
		}
		
//		data.addElement("david@yahoo.com");
//		data.addElement("fred@msn.com");
//		data.addElement("joe@hotmail.com");
//		data.addElement("jane@samsung.com");
		
		return data;
	}
	
	// ------------------------------------------------------
	
	
	// ------------------------------------------------------
	
	private static void loadEmailAccounts() {
		
		BufferedReader br;
		String line;
		String[] pieces;

		RelayAccountsFrame.emailAccounts = new ArrayList<EmailAccount>();

		// this.emailAccounts.add(new EmailAccount("", "", "", "", "", ""));
		
		// open text file
		try {
			br = new BufferedReader(new FileReader("EmailAccounts\\email_accounts.txt"));
			// br = new BufferedReader(new FileReader("D:\\JavaCLScrammer\\email_accounts.txt"));
			
			while ((line = br.readLine()) != null) {

				pieces = line.split("\\|");
				
				// if (pieces[0].equalsIgnoreCase("Y"))
				
				RelayAccountsFrame.emailAccounts.add(new EmailAccount(pieces[1], 
                                                                      pieces[2], 
				                                                      pieces[3], 
				                                                      pieces[4], 
				                                                      pieces[5], 
				                                                      pieces[6], 
				                                                      pieces[7]));
			}

			br.close();
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	// ------------------------------------------------------
	
//	private static JPanel createTestingPanel() {
//		
//		JPanel testingPanel = new JPanel(new GridBagLayout());
//		
//		// testingPanel.setBorder(BorderFactory.createLineBorder(Color.black));
//		
//		GridBagConstraints c = new GridBagConstraints();
//		
//		c.insets = new Insets(8, 8, 8, 8);
//		
//		c.gridx = 0;
//		c.gridy = 0;
//		
//		testingPanel.add(RelayAccountsFrame.createRelayAccountDetailsPanel());
//		
//		// - - - - - - - - - - - - - - - - - - - - - - - -
//
//		JPanel outerPanel = new JPanel(new GridBagLayout());
//		
//		outerPanel.setBorder(BorderFactory.createLineBorder(Color.black));
//
//		GridBagConstraints c2 = new GridBagConstraints();
//		c2.anchor = GridBagConstraints.NORTH;
//		
//		outerPanel.add(testingPanel, c2);
//		
//		// - - - - - - - - - - - - - - - - - - - - - - - -
//		
//		// return testingPanel;
//		return outerPanel;
//	}
	
	// ------------------------------------------------------
	
	private static JPanel createOverridePanel() {
		
		
		JPanel overridePanel = new JPanel(new GridBagLayout());
		
		overridePanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		// relayAccountDetailsPanel.setAlignmentX(0);
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.insets = new Insets(2, 8, 2, 8);
		c.fill = GridBagConstraints.HORIZONTAL;
		
		// c.weighty = 0.1;
		
		// - - - - - - - - - - - - - - - - - - - - -
		//     R O W   1 
		// - - - - - - - - - - - - - - - - - - - - -

		JLabel emailLabel = new JLabel("Email Address:");
		emailLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		c.gridx = 0;
		c.gridy = 0;
		
		overridePanel.add(emailLabel, c);
		
		RelayAccountsFrame.emailValueTextField = new JTextField(25);
		
		c.gridx = 1;
		c.gridy = 0;
		
		overridePanel.add(RelayAccountsFrame.emailValueTextField, c);
		
		// - - - - - - - - - - - - - - - - - - - - -
		//     R O W   2 
		// - - - - - - - - - - - - - - - - - - - - -

		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		c.gridx = 0;
		c.gridy = 1;
		
		overridePanel.add(usernameLabel, c);
		
		RelayAccountsFrame.usernameValueTextField = new JTextField(25);
		
		c.gridx = 1;
		c.gridy = 1;
		
		overridePanel.add(RelayAccountsFrame.usernameValueTextField, c);
		
		// - - - - - - - - - - - - - - - - - - - - -
		//     R O W   3 
		// - - - - - - - - - - - - - - - - - - - - -
		
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		c.gridx = 0;
		c.gridy = 2;
		
		overridePanel.add(passwordLabel, c);
		
		RelayAccountsFrame.passwordValueTextField = new JTextField(25);
		
		c.gridx = 1;
		c.gridy = 2;
		
		overridePanel.add(RelayAccountsFrame.passwordValueTextField, c);
		
		// - - - - - - - - - - - - - - - - - - - - -
		//     R O W   4 
		// - - - - - - - - - - - - - - - - - - - - -
		
		JLabel smtpServerLabel = new JLabel("SMTP Server:");
		smtpServerLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		c.gridx = 0;
		c.gridy = 3;
		
		overridePanel.add(smtpServerLabel, c);
		
		RelayAccountsFrame.smtpServerValueTextField = new JTextField(25);
		
		c.gridx = 1;
		c.gridy = 3;
		
		overridePanel.add(RelayAccountsFrame.smtpServerValueTextField, c);
		
		// - - - - - - - - - - - - - - - - - - - - -
		//     R O W   5 
		// - - - - - - - - - - - - - - - - - - - - -
		
		JLabel portLabel = new JLabel("Port:");
		portLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		c.gridx = 0;
		c.gridy = 4;
		
		overridePanel.add(portLabel, c);
		
		RelayAccountsFrame.portValueTextField = new JTextField(25);
		
		c.gridx = 1;
		c.gridy = 4;
		
		overridePanel.add(RelayAccountsFrame.portValueTextField, c);
		
		// - - - - - - - - - - - - - - - - - - - - -
		//     R O W   6 
		// - - - - - - - - - - - - - - - - - - - - -
		
		JLabel senderLocalPartLabel = new JLabel("Sender Local Part:");
		senderLocalPartLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		c.gridx = 0;
		c.gridy = 5;
		
		overridePanel.add(senderLocalPartLabel, c);
		
		RelayAccountsFrame.senderLocalPartValueTextField = new JTextField(25);
		
		c.gridx = 1;
		c.gridy = 5;
		
		overridePanel.add(RelayAccountsFrame.senderLocalPartValueTextField, c);
		
		// - - - - - - - - - - - - - - - - - - - - -
		//     R O W   7 
		// - - - - - - - - - - - - - - - - - - - - -

		JLabel senderDomainLabel = new JLabel("Sender Domain:");
		senderDomainLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		c.gridx = 0;
		c.gridy = 6;
		
		overridePanel.add(senderDomainLabel, c);
		
		RelayAccountsFrame.senderDomainValueTextField = new JTextField(25);
		
		c.gridx = 1;
		c.gridy = 6;
		
		overridePanel.add(RelayAccountsFrame.senderDomainValueTextField, c);
		
		// - - - - - - - - - - - - - - - - - - - - -
		//     R O W   8 
		// - - - - - - - - - - - - - - - - - - - - -

		JLabel recipientLabel = new JLabel("Recipient:");
		recipientLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		c.gridx = 0;
		c.gridy = 7;
		
		overridePanel.add(recipientLabel, c);
		
		RelayAccountsFrame.recipientValueTextField = new JTextField(25);
		
		c.gridx = 1;
		c.gridy = 7;
		
		overridePanel.add(RelayAccountsFrame.recipientValueTextField, c);
		
		// - - - - - - - - - - - - - - - - - - - - -
		//     R O W   9 
		// - - - - - - - - - - - - - - - - - - - - -

		JLabel recipientCCLabel = new JLabel("Recipient CC:");
		recipientCCLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		c.gridx = 0;
		c.gridy = 8;
		
		overridePanel.add(recipientCCLabel, c);
		
		RelayAccountsFrame.recipientCCValueTextField = new JTextField(25);
		
		c.gridx = 1;
		c.gridy = 8;
		
		overridePanel.add(RelayAccountsFrame.recipientCCValueTextField, c);
		
		// - - - - - - - - - - - - - - - - - - - - -
		//     R O W   10 
		// - - - - - - - - - - - - - - - - - - - - -

		JLabel subjectLabel = new JLabel("Subject:");
		subjectLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		c.gridx = 0;
		c.gridy = 9;
		
		overridePanel.add(subjectLabel, c);
		
		RelayAccountsFrame.subjectValueTextField = new JTextField(25);
		
		c.gridx = 1;
		c.gridy = 9;
		
		overridePanel.add(RelayAccountsFrame.subjectValueTextField, c);
		
		// - - - - - - - - - - - - - - - - - - - - -
		//     R O W   11 
		// - - - - - - - - - - - - - - - - - - - - -

		JLabel messageLabel = new JLabel("Message:");
		messageLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		c.gridx = 0;
		c.gridy = 10;
		
		overridePanel.add(messageLabel, c);
		
		RelayAccountsFrame.messageValueTextField = new JTextField(25);
		
		c.gridx = 1;
		c.gridy = 10;
		
		overridePanel.add(RelayAccountsFrame.messageValueTextField, c);
		
		// - - - - - - - - - - - - - - - - - - - - -
		
		// - - - - - - - - - - - - - - - - - - - - -
		
		return overridePanel;
		
	}
	
	// ------------------------------------------------------
	
	private static JPanel createRelayAccountDetailsPanel() {
		
		JPanel relayAccountDetailsPanel = new JPanel(new GridBagLayout());
		
		relayAccountDetailsPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		// relayAccountDetailsPanel.setAlignmentX(0);
		// relayAccountDetailsPanel.setAlignmentY((float) 0.5);
		
		
		
		
		// relayAccountDetailsPanel.setAlignmentX(0);
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.insets = new Insets(2, 8, 2, 8);
		c.fill = GridBagConstraints.HORIZONTAL;
		
		// c.weighty = 0.1;
		
		// - - - - - - - - - - - - - - - - - - - - -
		//     R O W   1 
		// - - - - - - - - - - - - - - - - - - - - -

		// create a label:  Email Address:
		
		JLabel emailLabel = new JLabel("Email Address:");
		emailLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		c.gridx = 0;
		c.gridy = 0;
		
		relayAccountDetailsPanel.add(emailLabel, c);
		
		// - - - - - - - - - - - - - - - - - - - - -
		
		// create a label for value of "email address"
		
		// JLabel emailValueLabel = new JLabel("joe@yahoo.com");
		RelayAccountsFrame.emailValueLabel = new JLabel("");
		RelayAccountsFrame.emailValueLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		c.gridx = 1;
		c.gridy = 0;
		
		relayAccountDetailsPanel.add(RelayAccountsFrame.emailValueLabel, c);
		
		// - - - - - - - - - - - - - - - - - - - - -
		//     R O W   2 
		// - - - - - - - - - - - - - - - - - - - - -

		// create a label:  Username:
		
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		c.gridx = 0;
		c.gridy = 1;
		
		relayAccountDetailsPanel.add(usernameLabel, c);
		
		// - - - - - - - - - - - - - - - - - - - - -
		
		// create a label for value of "username"
		
		// JLabel usernameValueLabel = new JLabel("foouser");
		RelayAccountsFrame.usernameValueLabel = new JLabel("");
		RelayAccountsFrame.usernameValueLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		c.gridx = 1;
		c.gridy = 1;
		
		relayAccountDetailsPanel.add(RelayAccountsFrame.usernameValueLabel, c);
		
		// - - - - - - - - - - - - - - - - - - - - -
		//     R O W   3 
		// - - - - - - - - - - - - - - - - - - - - -

		// create a label:  Password:
		
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		c.gridx = 0;
		c.gridy = 2;
		
		relayAccountDetailsPanel.add(passwordLabel, c);
		
		// - - - - - - - - - - - - - - - - - - - - -
		
		// create a label for value of "password"
		
		RelayAccountsFrame.passwordValueLabel = new JLabel("");
		RelayAccountsFrame.passwordValueLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		c.gridx = 1;
		c.gridy = 2;
		
		relayAccountDetailsPanel.add(RelayAccountsFrame.passwordValueLabel, c);
		
		// - - - - - - - - - - - - - - - - - - - - -
		//     R O W   4 
		// - - - - - - - - - - - - - - - - - - - - -

		// create a label:  SMTP Server:
		
		JLabel smtpServerLabel = new JLabel("SMTP Server:");
		smtpServerLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		c.gridx = 0;
		c.gridy = 3;
		
		relayAccountDetailsPanel.add(smtpServerLabel, c);
		
		// - - - - - - - - - - - - - - - - - - - - -
		
		// create a label for value of "smtp server"
		
		RelayAccountsFrame.smtpServerValueLabel = new JLabel("");
		RelayAccountsFrame.smtpServerValueLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		c.gridx = 1;
		c.gridy = 3;
		
		relayAccountDetailsPanel.add(RelayAccountsFrame.smtpServerValueLabel, c);
		
		// - - - - - - - - - - - - - - - - - - - - -
		//     R O W   5 
		// - - - - - - - - - - - - - - - - - - - - -

		// create a label:  Port:
		
		JLabel portLabel = new JLabel("Port:");
		portLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		c.gridx = 0;
		c.gridy = 4;
		
		relayAccountDetailsPanel.add(portLabel, c);
		
		// - - - - - - - - - - - - - - - - - - - - -
		
		// create a label for value of "port"
		
		RelayAccountsFrame.portValueLabel = new JLabel("");
		RelayAccountsFrame.portValueLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		c.gridx = 1;
		c.gridy = 4;
		
		relayAccountDetailsPanel.add(RelayAccountsFrame.portValueLabel, c);
		
		// - - - - - - - - - - - - - - - - - - - - -
		//     R O W   6 
		// - - - - - - - - - - - - - - - - - - - - -

		// create a label:  Sender Local Part:
		
		JLabel senderLocalPartLabel = new JLabel("Sender Local Part:");
		senderLocalPartLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		c.gridx = 0;
		c.gridy = 5;
		
		relayAccountDetailsPanel.add(senderLocalPartLabel, c);
		
		// - - - - - - - - - - - - - - - - - - - - -
		
		// create a label for value of "sender local part"
		
		RelayAccountsFrame.senderLocalPartValueLabel = new JLabel("");
		RelayAccountsFrame.senderLocalPartValueLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		c.gridx = 1;
		c.gridy = 5;
		
		relayAccountDetailsPanel.add(RelayAccountsFrame.senderLocalPartValueLabel, c);
		
		// - - - - - - - - - - - - - - - - - - - - -
		//     R O W   7 
		// - - - - - - - - - - - - - - - - - - - - -

		// create a label:  Sender Domain:

		JLabel senderDomainLabel = new JLabel("Sender Domain:");
		senderDomainLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		c.gridx = 0;
		c.gridy = 6;
		
		relayAccountDetailsPanel.add(senderDomainLabel, c);
		
		// - - - - - - - - - - - - - - - - - - - - -
		
		// create a label for value of "sender domain"
		
		RelayAccountsFrame.senderDomainValueLabel = new JLabel("");
		RelayAccountsFrame.senderDomainValueLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		c.gridx = 1;
		c.gridy = 6;
		
		relayAccountDetailsPanel.add(RelayAccountsFrame.senderDomainValueLabel, c);
		
		// - - - - - - - - - - - - - - - - - - - - -

		return relayAccountDetailsPanel;
	}
	
	// ------------------------------------------------------
	
	
	// ------------------------------------------------------
	
	
	
	
	
	
	
	
	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	
	/*
	 *   N e s t e d   A c t i o n   L i s t e n e r   
	 *   C l a s s e s 
	 */
	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	
	static class RafActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent ae) {
			// TODO Auto-generated method stub
			
			switch (ae.getActionCommand()) {
			
				case "Send Email":
					
					System.out.println("Email is being sent.");
					
					RelayTester relayTester = new RelayTester(RelayAccountsFrame.emailValueTextField.getText(),
							                                  RelayAccountsFrame.usernameValueTextField.getText(),
							                                  RelayAccountsFrame.passwordValueTextField.getText(),
							                                  RelayAccountsFrame.smtpServerValueTextField.getText(),
					 		                                  RelayAccountsFrame.portValueTextField.getText(),
							                                  RelayAccountsFrame.senderLocalPartValueTextField.getText(),
							                                  RelayAccountsFrame.senderDomainValueTextField.getText(),
							                                  RelayAccountsFrame.recipientValueTextField.getText(),
							                                  RelayAccountsFrame.recipientCCValueTextField.getText(),
							                                  RelayAccountsFrame.subjectValueTextField.getText(),
							                                  RelayAccountsFrame.messageValueTextField.getText());
					
					String response = relayTester.doTest();
					
					RelayAccountsFrame.responseTextArea.setText(response);

					break;
			
				default:
					// do nothing
					break;

			}

		}
		
		// - - - - - - - - - - - - - - - - - - - 
		
		
		// - - - - - - - - - - - - - - - - - - - 
		
		
		// - - - - - - - - - - - - - - - - - - - 
		
		
		// - - - - - - - - - - - - - - - - - - - 
		
	}
	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	
	static class RafListSelectionListener implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent lse) {
			// TODO Auto-generated method stub
			
			if (lse.getValueIsAdjusting() == false) {
				
				if (RelayAccountsFrame.list.getSelectedIndex() == -1) {
					// no item is selected
					
					RelayAccountsFrame.emailValueLabel.setText("");
					RelayAccountsFrame.usernameValueLabel.setText("");
					RelayAccountsFrame.passwordValueLabel.setText("");
					RelayAccountsFrame.smtpServerValueLabel.setText("");
					RelayAccountsFrame.portValueLabel.setText("");
					RelayAccountsFrame.senderLocalPartValueLabel.setText("");
					RelayAccountsFrame.senderDomainValueLabel.setText("");
					
					RelayAccountsFrame.emailValueTextField.setText("");
					RelayAccountsFrame.usernameValueTextField.setText("");
					RelayAccountsFrame.passwordValueTextField.setText("");
					RelayAccountsFrame.smtpServerValueTextField.setText("");
					RelayAccountsFrame.portValueTextField.setText("");
					RelayAccountsFrame.senderLocalPartValueTextField.setText("");
					RelayAccountsFrame.senderDomainValueTextField.setText("");
					
					RelayAccountsFrame.recipientValueTextField.setText("");
					RelayAccountsFrame.recipientCCValueTextField.setText("");
					RelayAccountsFrame.subjectValueTextField.setText("");
					RelayAccountsFrame.messageValueTextField.setText("");
					
				}
				else {
					
					EmailAccount emailAccount = RelayAccountsFrame.emailAccounts.get(RelayAccountsFrame.list.getSelectedIndex());
					
					// System.out.println(emailAccount.getEmailAddress());
					
					RelayAccountsFrame.emailValueLabel.setText(emailAccount.getEmailAddress());
					RelayAccountsFrame.usernameValueLabel.setText(emailAccount.getUsername());
					RelayAccountsFrame.passwordValueLabel.setText(emailAccount.getPassword());
					RelayAccountsFrame.smtpServerValueLabel.setText(emailAccount.getSmtpHost());
					RelayAccountsFrame.portValueLabel.setText(emailAccount.getSmtpPort());
					RelayAccountsFrame.senderLocalPartValueLabel.setText(emailAccount.getNoreplyLocalPart());
					RelayAccountsFrame.senderDomainValueLabel.setText(emailAccount.getNoreplyDomain());
					
					RelayAccountsFrame.emailValueTextField.setText(emailAccount.getEmailAddress());
					RelayAccountsFrame.usernameValueTextField.setText(emailAccount.getUsername());
					RelayAccountsFrame.passwordValueTextField.setText(emailAccount.getPassword());
					RelayAccountsFrame.smtpServerValueTextField.setText(emailAccount.getSmtpHost());
					RelayAccountsFrame.portValueTextField.setText(emailAccount.getSmtpPort());
					RelayAccountsFrame.senderLocalPartValueTextField.setText(emailAccount.getNoreplyLocalPart());
					RelayAccountsFrame.senderDomainValueTextField.setText(emailAccount.getNoreplyDomain());
					
					RelayAccountsFrame.recipientValueTextField.setText("joecopy@crestwoodcomputing.com");
					RelayAccountsFrame.recipientCCValueTextField.setText("davew_2@yahoo.com");
					
					String curDate =  (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new java.util.Date());
					
					RelayAccountsFrame.subjectValueTextField.setText("Test Message - " + curDate);
					RelayAccountsFrame.messageValueTextField.setText("Hello good lookin! - " + curDate);
				}
				
			}
			
		}
		
	}
	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	
}
