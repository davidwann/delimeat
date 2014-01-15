
package com.javacareerlab.clscrammer.models;

// import java.awt.event.ActionListener;
// import java.awt.event.ActionEvent;

// implements ActionListener 

public class Category {

	private long id;
	private String category;
	private String categoryDesc;
	private String parentCategory;
	
	private CategoryDAO categoryDao;
	
	/* - - - - - - - - - - */

	public Category() {
	
		this.id = 0;
		this.category = "";
		this.categoryDesc = "";
		this.parentCategory = "";
		
		this.categoryDao = new CategoryDAO();
	}
	
	/* - - - - - - - - - - */

	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	/* - - - - - - - - - - */
	
	public String getCategory() {
		return this.category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}

	/* - - - - - - - - - - */
	
	public String getCategoryDesc() {
		return this.categoryDesc;
	}
	
	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}

	/* - - - - - - - - - - */
	
	public String getParentCategory() {
		return this.parentCategory;
	}
	
	public void setParentCategory(String parentCategory) {
		this.parentCategory = parentCategory;
	}

	/* - - - - - - - - - - */
	
//	public void actionPerformed(ActionEvent ae) {
//		// Let's rock!
//		System.out.println("Category.actionPerformed method is executing!");
//		System.out.println("ActionEvent.getActionCommand(): " + ae.getActionCommand());
//		System.out.println(" ");
//	}
	
	/* - - - - - - - - - - */

	public void clear() {
	
		this.id = 0;
		this.category = "";
		this.categoryDesc = "";
		this.parentCategory = "";
	}
	
	/* - - - - - - - - - - */
	
	public boolean save() {
		// persist data to the datastore 
		// - most likely a relational database table 
		// - either a record insert or a record update
		
		return this.categoryDao.save(this);
	}
	
	/* - - - - - - - - - - */

	
	/* - - - - - - - - - - */

	
	/* - - - - - - - - - - */

	
	/* - - - - - - - - - - */

	
	







}
