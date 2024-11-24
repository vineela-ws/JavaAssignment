package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
	private static List<Student>studentList;

	public static void main(String[] args) {
		System.out.println("************************ Student Managment System ****************************");	
		System.out.println("************************ Welcome ****************************");
		
		studentList = new ArrayList<Student>();
		Student s1;
		s1= new Student("Kajal Beaty",22,"S-21");
		s1.enrollCourse("Java");
		s1.enrollCourse("DSA");
		s1.enrollCourse("C#");
		//Class will loaded in the memory
		//Instance variable will be created
		//Constructor will be called 
		//Super() class can be used to call parent class constructor
		//If we have any Instance variables make sure Validation should happen
		System.out.println(s1);
		//s1.printStudentInfo();
		Student s2;
		s2= new Student("Beaty",25,"S-11");
		s2.enrollCourse("Java");
		s2.enrollCourse("DSA");
		System.out.println(s2);
		Student s3;
		s3= new Student("Bittu",21,"S-10");
		s3.enrollCourse("Java");
		s3.enrollCourse("DSA");
		System.out.println(s3);
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		
		Student result =findStudentById("S-11");
		System.out.println("result" +result);
		sortByName();
	}
		
	private static void sortByName() {
		Comparator<Student>studentNameComparator = (o1,o2) -> o1.getName().compareTo(o2.getName());
		Collections.sort(studentList,studentNameComparator);
		System.out.println(studentList);
	}

	public static Student findStudentById(String studentid) {
		Student result = null;
		try {
		result= studentList.
		stream().filter(x-> x.getStudentId().equalsIgnoreCase(studentid)).findFirst()
	    .orElseThrow(()	->new RuntimeException("No data found !!!"));
		}
		catch(RuntimeException e) {
			System.err.println("Student with ID "+studentid+ "not found!!");
		}
		return result;
	}

}
