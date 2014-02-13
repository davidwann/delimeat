
package com.javacareerlab.clscrammer;

// import java.util.List;
// import java.util.ArrayList;
// import java.util.Date;

// import java.text.SimpleDateFormat;
// import java.text.ParseException;

// import java.util.logging.FileHandler;
// import java.util.logging.Level;
// import java.util.logging.Logger;

// import java.util.regex.Pattern;
// import java.util.regex.Matcher;

import java.net.URL;
import java.net.MalformedURLException;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class WebPage {

	protected String url;
	protected String html;
	   
	/* - - - - - - - - - - - - - - - - - - - - - - - - - - - */

	public WebPage() {

		// String url = "http://www.foo.com";
		// String html = "<html><head><title>Initial HTML</title></head><body><h2>Initial HTML</h2></body></html>";
		  
		this("", "");
	}

	public WebPage(String url) {
		
		// String html = "<html><head><title>Initial HTML</title></head><body><h2>Initial HTML</h2></body></html>";
		
		this(url, "");
	}

	public WebPage(String url, String html) {

		this.url = url;
		// this.html = html;
		this.retrieveHtml();
	}

	/* - - - - - - - - - - - - - - - - - - - - - - - - - - - */

	public void setUrl(String url) {

		this.url = url;
		this.retrieveHtml();
	}

	/* - - - - - - - - - - - - - - - - - - - - - - - - - - - */

	public String getUrl() {
		return this.url;
	}
	
	/* - - - - - - - - - - - - - - - - - - - - - - - - - - - */

	private void setHtml(String html) {
		this.html = html;
	}

	/* - - - - - - - - - - - - - - - - - - - - - - - - - - - */

	public String getHtml() {
		return this.html;
	}

	/* - - - - - - - - - - - - - - - - - - - - - - - - - - - */

	private void retrieveHtml() {
	   
		this.html = "";
		
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

	public void displayInfo() {
		   
		System.out.println("Page Url                  : " + this.url);
		// System.out.println("Page Type                 : " + this.pageType);
		// System.out.println("Number of Sublinks        : " + this.subLinks.size());
		// System.out.println("Number of Email Addresses : " + this.emailAddresses.size());
	}
	   
	/* - - - - - - - - - - - - - - - - - - - - - - - - - - - */

}
