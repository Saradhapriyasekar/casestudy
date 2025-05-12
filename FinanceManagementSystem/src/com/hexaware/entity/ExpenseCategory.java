package com.hexaware.entity;

public class ExpenseCategory {
	private int categoryId;
	private String categoryName;
	
// Default constructor – needed for object creation without initial values
	public ExpenseCategory() {}

// parameterized constructor
	public ExpenseCategory(int categoryId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}

	
// getter and setter
	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	
	

}
