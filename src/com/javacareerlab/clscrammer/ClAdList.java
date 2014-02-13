
package com.javacareerlab.clscrammer;



import java.util.List;
import java.util.ArrayList;
// import java.util.Date;



import java.util.regex.Pattern;
import java.util.regex.Matcher;



public class ClAdList extends WebPage {

	private List<String> subLinks;
	
	/* - - - - - - - - - - - - - - - - - - - - - - - - - - - */
	   
	public ClAdList() {
	
		this("");
	}
	
	public ClAdList(String url) {
	
		super(url);
		
		this.subLinks = new ArrayList<String>();
		
		this.retrieveSubLinks();
	}
	
	/* - - - - - - - - - - - - - - - - - - - - - - - - - - - */

	private void setSubLinks(List<String> subLinks) {
		this.subLinks = subLinks;
	}

	/* - - - - - - - - - - - - - - - - - - - - - - - - - - - */

	public List<String> getSubLinks() {
		return this.subLinks;
	}

	/* - - - - - - - - - - - - - - - - - - - - - - - - - - - */
	
	public void retrieveSubLinks() {
	
		this.subLinks.clear();
		   
		// - - - - - - - - - - - - - - - - - - - - - - - 
		// use regular expressions to parse the html
		// - - - - - - - - - - - - - - - - - - - - - - - 
		Pattern p = Pattern.compile("<a\\s+href=\"(http://[a-z]+?\\.craigslist\\.org(/[a-z]{3})?/[a-z]{3}/\\d{10}\\.html)\">", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(this.html);
		   
		while (m.find()) {

			// this.log.log(Level.INFO, "WebPage : subLink: " + m.group(1));
			// this.log.log(Level.INFO, "WebPage : group 2: " + m.group(2));

			this.subLinks.add(m.group(1));
		}
	}
	
	/* - - - - - - - - - - - - - - - - - - - - - - - - - - - */

	// overridden from base class
	public void setUrl(String url) {
	
		super.setUrl(url);
		this.retrieveSubLinks();
	}

	/* - - - - - - - - - - - - - - - - - - - - - - - - - - - */



	/* - - - - - - - - - - - - - - - - - - - - - - - - - - - */


	/* - - - - - - - - - - - - - - - - - - - - - - - - - - - */

}
