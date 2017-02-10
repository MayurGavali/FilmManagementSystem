package com.flp.fms.domain;

public class Category {

	  //Private Fields
	private int category_Id;
	private String category_name;

//No Argument Constructor	
public Category(){}

//Argument Constructor	
public Category(int category_Id,String category_name){
	super();
		this.category_Id=category_Id;
		this.category_name=category_name;
}

//Getters and Setters
public int getCategory_Id() {
	return category_Id;
}

public void setCategory_Id(int category_Id) {
	this.category_Id = category_Id;
}

public String getcategory_name() {
	return category_name;
}

public void setCategory_name(String category_name) {
	this.category_name = category_name;
}

@Override
public String toString() {
	return "Category [category_Id=" + category_Id + ", categoryName=" + category_name + "]";
}





}
