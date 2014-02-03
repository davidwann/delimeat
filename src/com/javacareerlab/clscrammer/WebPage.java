package com.javacareerlab.clscrammer;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import java.text.SimpleDateFormat;
import java.text.ParseException;

// import java.util.logging.FileHandler;
// import java.util.logging.Level;
// import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import java.net.URL;
import java.net.MalformedURLException;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class WebPage {

	   private String url;
	   private String html;
	   private String pageType;
	   
	   private Date adDate;
	   private List<String> emailAddresses;
	   private List<String> subLinks;
		
		// private Logger log;

	   /* - - - - - - - - - - - - - - - - - - - - - - - - - - - */

	   public WebPage() {

	      this.url = "http://www.foo.com";
	      this.html = "<html><head><title>Initial HTML</title></head><body><h2>Initial HTML</h2></body></html>";
	      this.pageType = "";

	      this.adDate = new Date();
	      this.emailAddresses = new ArrayList<String>();
	      this.subLinks = new ArrayList<String>();
	      
	      // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
			
	      // this.log = Logger.getLogger(this.getClass().getName());
			
//	      try {
//	    	  this.log.addHandler(new FileHandler("WebPage_class_log.xml"));
//	      } catch (SecurityException e) {
//	    	  // TODO Auto-generated catch block
//	    	  e.printStackTrace();
//	      } catch (IOException e) {
//	    	  // TODO Auto-generated catch block
//	    	  e.printStackTrace();
//	      }

	      // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
			
	   }

	   /* - - - - - - - - - - - - - - - - - - - - - - - - - - - */

	   public void setUrl(String url) {

	      this.url = url;
		  
	      this.setPageType();
	      this.setHtml();
	      
	      this.emailAddresses.clear();
	      this.subLinks.clear();
	      
	      // this.log.log(Level.INFO, "WebPage : pageType: " + this.pageType);

	      if (this.pageType.equalsIgnoreCase("A")) {
	    	  this.setEmailAddresses();
	    	  this.setAdDate();
	      }
	      else
	    	  this.setSubLinks();
	   }

	   /* - - - - - - - - - - - - - - - - - - - - - - - - - - - */

	   public String getUrl() {
	      return this.url;
	   }

	   /* - - - - - - - - - - - - - - - - - - - - - - - - - - - */
	
	   private void setPageType() {
		   
		   if (this.url.matches(".+\\d{10}\\.html$")) 
			   this.pageType = "A";
		   else
			   this.pageType = "L";
	   }
	   
	   /* - - - - - - - - - - - - - - - - - - - - - - - - - - - */
	   
	   public String getPageType() {

		   return this.pageType;
	   }
	   
	   /* - - - - - - - - - - - - - - - - - - - - - - - - - - - */

	   private void setHtml() {

	      try {
	         URL url = new URL(this.url);
	         BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
	         StringBuilder sb = new StringBuilder();
	         String s;
	         
	         while ((s = br.readLine()) != null) {
	        	 sb.append(s);
	         }

	         this.html = sb.toString();
	      }
	      catch (MalformedURLException e) {
	         this.html = "MalformedURLException was thrown.";
	      }
	      catch (IOException e) {
	    	  // do something?
	      }

	      // System.out.println("Doing an HTTP Request!");
	   }

	   /* - - - - - - - - - - - - - - - - - - - - - - - - - - - */

	   public String getHtml() {

	      return this.html;

	   }

	   /* - - - - - - - - - - - - - - - - - - - - - - - - - - - */

	      //this.emailAddresses = new ArrayList<String>();
	      //this.subLinks = new ArrayList<String>();

	   /* - - - - - - - - - - - - - - - - - - - - - - - - - - - */

	   private void setEmailAddresses() {

		   // - - - - - - - - - - - - - - - - - - - - - - - 
		   // use regular expressions to parse the html
		   // - - - - - - - - - - - - - - - - - - - - - - - 
		   Pattern p = Pattern.compile("\\b[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b", Pattern.CASE_INSENSITIVE);
		   Matcher m = p.matcher(this.html);

		   while (m.find())
			   this.emailAddresses.add(m.group());
	   }

	   /* - - - - - - - - - - - - - - - - - - - - - - - - - - - */
	   
	   public List<String> getEmailAddresses() {
		   
		   return this.emailAddresses;
	   }
	   
	   /* - - - - - - - - - - - - - - - - - - - - - - - - - - - */

	   private void setAdDate() {
		   
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
	   }
 
	   /* - - - - - - - - - - - - - - - - - - - - - - - - - - - */

	   public Date getAdDate() {
		   
		   return this.adDate;
	   }

	   /* - - - - - - - - - - - - - - - - - - - - - - - - - - - */

	   private void setSubLinks() {
		   
		   // - - - - - - - - - - - - - - - - - - - - - - - 
		   // use regular expressions to parse the html
		   // - - - - - - - - - - - - - - - - - - - - - - - 
		   Pattern p = Pattern.compile("<a\\s+href=\"(http://[a-z]+?\\.craigslist\\.org(/[a-z]{3})?/[a-z]{3}/\\d{10}\\.html)\">", Pattern.CASE_INSENSITIVE);

		   Matcher m = p.matcher(this.html);
		   
		   
		   // m.

		   while (m.find()) {

			   // this.log.log(Level.INFO, "WebPage : subLink: " + m.group(1));
			   // this.log.log(Level.INFO, "WebPage : group 2: " + m.group(2));

			   this.subLinks.add(m.group(1));
		   }
		   
	   }

	   /* - - - - - - - - - - - - - - - - - - - - - - - - - - - */

	   public List<String> getSubLinks() {
		   return this.subLinks;
	   }
	   
	   
	   /* - - - - - - - - - - - - - - - - - - - - - - - - - - - */

	   public void displayInfo() {
		   
		   System.out.println("Page Url                  : " + this.url);
		   System.out.println("Page Type                 : " + this.pageType);
		   System.out.println("Number of Sublinks        : " + this.subLinks.size());
		   System.out.println("Number of Email Addresses : " + this.emailAddresses.size());
	   }
	   
	   /* - - - - - - - - - - - - - - - - - - - - - - - - - - - */

}
