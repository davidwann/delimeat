
package com.javacareerlab.clscrammer.models;

public class City {

	private long id;
	private String city;
	private String citySector;
	private String website;
	private String websiteType;
	private String spam;
	private String region;
	
	private CityDAO cityDao;
	
	/* - - - - - - - - - - - - - - - - - - - - - */
	
	public City() {
	
		this.id = 0;
		this.city = "";
		this.citySector = "";
		this.website = "";
		this.websiteType = "";
		this.spam = "";
		this.region = "";
		
		this.cityDao = new CityDAO();
	}
	
	/* - - - - - - - - - - - - - - - - - - - - - */
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getId() {
		return this.id;
	}
	
	/* - - - - - - - - - - - - - - - - - - - - - */
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getCity() {
		return this.city;
	}
	
	/* - - - - - - - - - - - - - - - - - - - - - */
	
	public void setCitySector(String citySector) {
		this.citySector = citySector;
	}
	
	public String getCitySector() {
		return this.citySector;
	}
	
	/* - - - - - - - - - - - - - - - - - - - - - */
	
	public void setWebsite(String website) {
		this.website = website;
	}
	
	public String getWebsite() {
		return this.website;
	}
	
	/* - - - - - - - - - - - - - - - - - - - - - */
	
	public void setWebsiteType(String websiteType) {
		this.websiteType = websiteType;
	}
	
	public String getWebsiteType() {
		return this.websiteType;
	}
	
	/* - - - - - - - - - - - - - - - - - - - - - */
	
	public void setSpam(String spam) {
		this.spam = spam;
	}	
	
	public String getSpam() {
		return this.spam;
	}
	
	/* - - - - - - - - - - - - - - - - - - - - - */
	
	public void setRegion(String region) {
		this.region = region;
	}
	
	public String getRegion() {
		return this.region;
	}
	
	/* - - - - - - - - - - - - - - - - - - - - - */
	
	public void clear() {
	
		this.id = 0;
		this.city = "";
		this.citySector = "";
		this.website = "";
		this.websiteType = "";
		this.spam = "";
		this.region = "";
	}
	
	/* - - - - - - - - - - - - - - - - - - - - - */
	
	public boolean save() {
		// persist data to the datastore 
		// - most likely a relational database table 
		// - either a record insert or a record update
		
		return this.cityDao.save(this);
	}
	
	/* - - - - - - - - - - - - - - - - - - - - - */
	
	public boolean deleteAll() {
	
		return this.cityDao.deleteAll();
	}

	/* - - - - - - - - - - - - - - - - - - - - - */


	
	
	
	/* - - - - - - - - - - - - - - - - - - - - - */
	
	
	/* - - - - - - - - - - - - - - - - - - - - - */
	
	
	/* - - - - - - - - - - - - - - - - - - - - - */
	
	
	/* - - - - - - - - - - - - - - - - - - - - - */
	
	
	/* - - - - - - - - - - - - - - - - - - - - - */
	
	
	/* - - - - - - - - - - - - - - - - - - - - - */
	
}
