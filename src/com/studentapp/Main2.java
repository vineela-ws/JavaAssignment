package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main2 {
	private static List<Student>studentList;

	public static void main(String[] args) {
		System.out.println("************************ Student Managment System ****************************");	
		System.out.println("************************ Welcome ****************************");
		
		studentList = new ArrayList<Student>();
		// Read Input from the Terminal
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Student Name......");
		String name = scanner.next();
		System.out.println("you have entered the name " +name);	
		System.out.println("Enter Student Age ......");
		int age =scanner.nextInt();
		System.out.println("you have entered the name " +age);	
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
