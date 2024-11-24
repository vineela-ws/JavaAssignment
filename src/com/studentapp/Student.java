package com.studentapp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {
	
	private String name;  //null
	private int age;      //0
	private String studentId; //null
	private List<String> courses; //null
	
	public Student(String name, int age, String studentId) {
		super();
		if(validateAge(age) && validateName(name) && validateStudentId(studentId)) {
		this.name = name;
		this.age = age;
		this.studentId = studentId;
		courses = new ArrayList<String>();	
		}
	}
	
	private boolean validateStudentId(String studentId) {
		String studentIdRegex ="S-\\d+$";
		Pattern idPattern = Pattern.compile(studentIdRegex);
		Matcher idMatcher = idPattern.matcher(studentId);
		if(idMatcher.matches()){
			return true;
		} else {
			System.err.println("Invalid Student Id !!! Please enter proper format only");
			return false;	
		}
	}

	public void enrollCourse(String course) {
		//Contains() to check certain object is part of ArrayList
		if(validateCourseName(course)) {
		if(!courses.contains(course) ) {
			courses.add(course);
			System.out.println("Student is enrolled to "+course+" successfully");			
		}else {
			System.err.println("Student is already enrolled to the course"+course);	
		}
	  }
	}
	
	public void printStudentInfo() {
		System.out.println("************* Student Information *****************");	
		System.out.println("Student Name :" +name);
		System.out.println("Student Age :" +age);
		System.out.println("Student Id :" +studentId);
		System.out.println("Enrolled for :" +courses);		
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", studentId=" + studentId + ", courses=" + courses + "]";
	}
	
	//Validate Methods
	public boolean validateAge(int age) {
		if(age>=19&&age<=35) {
			return true;	
		}
		else {
			System.err.println("Invalid age !!! Student age needs be between 19 and 35");
		return false;
		}	
	}
		
	public boolean validateName(String name) {
		String nameRegex = "^[a-zA-Z\\s]+$";
		Pattern namePattern = Pattern.compile(nameRegex);
		Matcher nameMatcher = namePattern.matcher(name);
		if(nameMatcher.matches()){
			return true;
		}else {
			System.out.println("Invalid Name !!! Please enter alphabets only");
			return false;	
		}
	}
		
	public boolean validateCourseName(String course) {
		if(course.equalsIgnoreCase("java") || course.equalsIgnoreCase("DSA") ||  course.equalsIgnoreCase("Devops") ) {
			return true;
		}
		System.err.println("Invalid Course name !!! Please Select courses from the list!![Java,DSA,Devops]");
		return false;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getStudentId() {
		return studentId;
	}

	public List<String> getCourses() {
		return courses;
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
