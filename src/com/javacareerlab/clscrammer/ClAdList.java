
package com.javacareerlab.clscrammer;

public class ClAdList extends WebPage {

	private List<String> subLinks;
	
	
	public ClAdList() {
	
		// super();
		
		
		this.subLinks = new ArrayList<String>();

	
		      // this.subLinks.clear();

	
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
	   
	   

	





}
