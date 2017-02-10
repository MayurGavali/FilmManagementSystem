package com.flp.fms.domain;

public class Actor {

	   //Private Fields
		private int actor_Id;
		private String firstName;
		private String lastName;

//No Argument Constructor		
public Actor(){}


// Argument Constructor
public Actor(int actor_Id,String firstName,String lastName){
	super();
		this.actor_Id =actor_Id;
		this.firstName =firstName;
		this.lastName =lastName;
}

//Getters And Setters
public int getActor_Id() {
	return actor_Id;
}

public void setActor_Id(int actor_Id) {
	this.actor_Id = actor_Id;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

@Override
public String toString() {
	return "Actor [actor_Id=" + actor_Id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
}



}
	
	
	
	

