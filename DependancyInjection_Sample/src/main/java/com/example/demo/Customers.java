package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Customers {
private int cust_ID;
private String cust_name;
private String course_name;

@Autowired //it is used for Customer class to get to know about the exsistence of Technologies class and make sure that the dependancies are satisfied.
private  Technologies techdetails; // Here customer class is using the object of technologies class

public Technologies getTechdetails() {
	return techdetails;
}
public void setTechdetails(Technologies techdetails) {
	this.techdetails = techdetails;
}
public int getCust_ID() {
	return cust_ID;
}
public void setCust_ID(int cust_ID) {
	this.cust_ID = cust_ID;
}
public String getCust_name() {
	return cust_name;
}
public void setCust_name(String cust_name) {
	this.cust_name = cust_name;
}
public String getCourse_name() {
	return course_name;
}
public void setCourse_name(String course_name) {
	this.course_name = course_name;
}
public void display()
{
	System.out.println("Customers Object returned Successfully");
	techdetails .tech(); // here one class is dependant on another but it does not know the existence of other class hence we need to use "AutoWire" annotation
}

}
