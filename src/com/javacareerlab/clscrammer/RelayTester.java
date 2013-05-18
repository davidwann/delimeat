package com.javacareerlab.clscrammer;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class RelayTester {
	
	private String email;
	private String username;
	private String password;
	private String smtpServer;
	private String port;
	private String senderLocalPart;
	private String senderDomain;

	private String recipient;
	private String recipientCC;
	private String subject;
	private String message;
	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	
	public RelayTester(String email,
			           String username,
			           String password,
			           String smtpServer,
			           String port,
			           String senderLocalPart,
			           String senderDomain,
			           String recipient,
			           String recipientCC,
			           String subject,
			           String message) {
		
		// constructor
		
		this.email = email;
		this.username = username;
		this.password = password;
		this.smtpServer = smtpServer;
		this.port = port;
		this.senderLocalPart = senderLocalPart;
		this.senderDomain = senderDomain;
		this.recipient = recipient;
		this.recipientCC = recipientCC;
		this.subject = subject;
		this.message = message;
	}
	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	
	public String doTest() {
		
		String retval = "Successful test!";
		
		Authenticator auth = new MyAuthenticator(this.username, this.password);
		
		Properties props = new Properties();

		props.put("mail.smtp.host", this.smtpServer);
		props.put("mail.smtp.port", this.port);
		props.put("mail.smtp.auth", "true");

		// Session session = Session.getDefaultInstance(props, auth);
		Session session = Session.getInstance(props, auth);
				
		MimeMessage message = new MimeMessage(session);

		try {
			Address sender = new InternetAddress(this.senderLocalPart + "@" + this.senderDomain, 
			                                     "Art Vandalay");
			
			// Address recipTO = new InternetAddress("david@crestwoodcomputing.com");
			Address recipTO = new InternetAddress(this.recipient);
			
			Address recipCC = new InternetAddress(this.recipientCC);
			// Address recipBCC = new InternetAddress("joecopy@crestwoodcomputing.com");
			
			message.setSubject(this.subject);
			message.setText(this.message);

			message.setFrom(sender);
			message.addRecipient(Message.RecipientType.TO, recipTO);
			
			message.addRecipient(Message.RecipientType.CC, recipCC);
			// message.addRecipient(Message.RecipientType.BCC, recipBCC);
			
			message.saveChanges();
			
			Transport.send(message);
			
		}	
		catch (MessagingException e) {
			// TODO Auto-generated catch block

			retval = e.getMessage();
		} 
		catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block

			retval = e.getMessage();
		}
		
		return retval;
	}
	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	
	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	
}
