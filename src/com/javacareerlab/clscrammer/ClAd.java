
package com.javacareerlab.clscrammer;


import java.util.List;
import java.util.ArrayList;



import java.util.Date;



import java.text.SimpleDateFormat;
import java.text.ParseException;



import java.util.regex.Pattern;
import java.util.regex.Matcher;




public class ClAd extends WebPage {

	private Date adDate;
	private List<String> emailAddresses;

	/* - - - - - - - - - - - - - - - - - - - - - - - - - - - */
	   
	public ClAd() {
	
		this("");
	}
	
	public ClAd(String url) {
	
		super(url);
	
		this.adDate = new Date();
		this.emailAddresses = new ArrayList<String>();
		
		this.retrieveAdDate();
		this.retrieveEmailAddresses();
	}
	
	/* - - - - - - - - - - - - - - - - - - - - - - - - - - - */

	private void setEmailAddresses(List<String> emailAddresses) {
		this.emailAddresses = emailAddresses;
	}

	/* - - - - - - - - - - - - - - - - - - - - - - - - - - - */
	   
	public List<String> getEmailAddresses() {
		return this.emailAddresses;
	}
	   
	/* - - - - - - - - - - - - - - - - - - - - - - - - - - - */
	
	private void retrieveEmailAddresses() {
	
		this.emailAddresses.clear();
		
		// - - - - - - - - - - - - - - - - - - - - - - - 
		// use regular expressions to parse the html
		// - - - - - - - - - - - - - - - - - - - - - - - 
	      
		Pattern p = Pattern.compile("\\b[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(this.html);

		while (m.find())
			this.emailAddresses.add(m.group());
	}

	/* - - - - - - - - - - - - - - - - - - - - - - - - - - - */

	// overridden from base class
	public void setUrl(String url) {
	
		super.setUrl(url);
		this.retrieveEmailAddresses();
		this.retrieveAdDate();
	}

	/* - - - - - - - - - - - - - - - - - - - - - - - - - - - */

	private void setAdDate(Date adDate) {
		this.adDate = adDate;
	}
 
	/* - - - - - - - - - - - - - - - - - - - - - - - - - - - */

	public Date getAdDate() {
		return this.adDate;
	}
 
	/* - - - - - - - - - - - - - - - - - - - - - - - - - - - */
	
	public void retrieveAdDate() {
	
		// Date: 2012-06-18
		   
		// - - - - - - - - - - - - - - - - - - - - - - - 
		// use regular expressions to parse the html
		// - - - - - - - - - - - - - - - - - - - - - - - 
		Pattern p = Pattern.compile("Date:\\s*(\\d{4}-\\d{2}-\\d{2})", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(this.html);

		if (m.find()) {
			   
			// System.out.println(m.group());
			// System.out.println(m.group(1));
			   
			try {
				this.adDate = (new SimpleDateFormat("y-M-d")).parse(m.group(1));
			}
			catch (ParseException ex) {
				   
				this.adDate = new Date();
				   
				// System.out.println(ex.getMessage());
				// System.out.println("Problem parsing date!");
			}
		}
		else {
			this.adDate = new Date();
		}
		
	}

	/* - - - - - - - - - - - - - - - - - - - - - - - - - - - */

 
	/* - - - - - - - - - - - - - - - - - - - - - - - - - - - */


}
