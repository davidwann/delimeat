
package com.javacareerlab.clscrammer.models;

import java.sql.Date;
import java.sql.Timestamp;

// EmailAddress
// EmailAddressDAO

public class EmailAddress {

	private long id;
	private String email;
	private String adUrl;
	private Date adDate;
	private boolean contacted;
	private String city;
	private String citySector;
	private String clAdCategory;
	private String website;
	private String websiteType;
	private Timestamp created;
	private Timestamp modified;

	/* - - - - - - - - - - - - - - - - - - - - - */
	
	public EmailAddress() {
	
		this.id = 0;
		this.email = "";
		this.adUrl = "";
		this.adDate = new Date(0);
		this.contacted = false;
		this.city = "";
		this.citySector = "";
		this.clAdCategory = "";
		this.website = "";
		this.websiteType = "";
		this.created = new Timestamp(0);
		this.modified = new Timestamp(0);
	
	}

	/* - - - - - - - - - - - - - - - - - - - - - */
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getId() {
		return this.id;
	}
	
	/* - - - - - - - - - - - - - - - - - - - - - */
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	/* - - - - - - - - - - - - - - - - - - - - - */
	
	public void setAdUrl(String adUrl) {
		this.adUrl = adUrl;
	}
	
	public String getAdUrl() {
		return this.adUrl;
	}
	
	/* - - - - - - - - - - - - - - - - - - - - - */
	
	public void setAdDate(Date adDate) {
		this.adDate = adDate;
	}
	
	public Date getAdDate() {
		return this.adDate;
	}
	
	/* - - - - - - - - - - - - - - - - - - - - - */
	
	public void setContacted(boolean contacted) {
		this.contacted = contacted;
	}
	
	public boolean isContacted() {
		return this.contacted;
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
	
	public void setClAdCategory(String clAdCategory) {
		this.clAdCategory = clAdCategory;
	}
	
	public String getClAdCategory() {
		return this.clAdCategory;
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
	
	public void setCreated(Timestamp created) {
		this.created = created;
	}
	
	public Timestamp getCreated() {
		return this.created;
	}
	
	/* - - - - - - - - - - - - - - - - - - - - - */
	
	public void setModified(Timestamp modified) {
		this.modified = modified;
	}
	
	public Timestamp getModified() {
		return this.modified;
	}

	/* - - - - - - - - - - - - - - - - - - - - - */
	
	public boolean save() {
	
		// TODO: insert or update database record
	
	
		return true;
	}
	
	/* - - - - - - - - - - - - - - - - - - - - - */
	
	public boolean delete() {
	
		// TODO: delete a database record
	
		return true;
	}
	
	/* - - - - - - - - - - - - - - - - - - - - - */
	
	
	
	

	
	
	/* - - - - - - - - - - - - - - - - - - - - - */
	

	
	
	/* - - - - - - - - - - - - - - - - - - - - - */
	







}
