package studentdatabaseapp;

import java.util.Scanner;

public class Student {
	private String firstname;
	private String lastname;
	private String gradelevel;
	private String studentid;
	private int defaultstudentidlength = 7;
	private String courses = " ";
	private int tuition = 0;
	private static int costofcourse = 600;
	private static int id;
	private String password;
	private int defaultpasswordlength = 10;
	private String email;
	private String collegesuffix = "ucsc.com";
	
	//Constructor: prompt user to enter student's name and year
	public Student() {
		Scanner in = new Scanner(System.in);
		System.out.print("\nEnter student first name: ");
		this.firstname = in.nextLine();
		
		System.out.print("Enter student last name: ");
		this.lastname = in.nextLine();
		
		System.out.print("1. Freshman\n2. Sophmore\n3. Junior\n4. Senior\nEnter student grade level: ");
		this.gradelevel = in.nextLine();
		
		//System.out.println(firstname + " " + lastname + " " + gradelevel + " " + studentid);
		
		//Call a method that returns a random student id
		this.studentid = setstudentid(defaultstudentidlength);
		
		//Call a method that returns a random password
		this.password = setpassword(defaultpasswordlength);
		//System.out.println("Your password is: " + this.password);
		
		this.email = firstname.toLowerCase() + lastname.toLowerCase() + "@" + collegesuffix;
	}
	
	//Generate an ID
	private String setstudentid(int length) {
		String studentidset = "1234567890";
		char[] studentid = new char[length];
		for (int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * studentidset.length());
			studentid[i] = studentidset.charAt(rand);
		}
		return new String(studentid);
	}
	
	//Generate a random password
	private String setpassword(int length) {
		String passwordset = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$";
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * passwordset.length());
			password[i] = passwordset.charAt(rand);
		}
		return new String(password);
	}
	
	//Enroll in courses
	public void enroll() {
		//Get inside a loop, user hits 0
		do {
			System.out.print("Enter course to enroll (Q to quit): ");
			Scanner in = new Scanner(System.in);
			String course = in.nextLine();
			if (!course.equals("Q")) {
				courses = courses + "\n " + course;
				tuition = tuition + costofcourse;
			} else {
				break;
			}
		} while (1 != 0);
		
		//System.out.println("Enrolled in: " + courses);
		//System.out.println("Tuition Balance: $" + tuition);
	}
	
	//View balance
	public void viewbalance() {
		System.out.println("Your balance is: $" + tuition);
	}
	
	//Pay tuition
	public void paytuition() {
		viewbalance();
		System.out.print("Enter your payment: $");
		Scanner in = new Scanner(System.in);
		int payment = in.nextInt();
		tuition = tuition - payment; 
		System.out.println("Thank You for your payment of $" + payment);
		viewbalance();
	}
	
	//Show status
	public String showinformation() {
		return "\nName: " + firstname + " " + lastname + 
				"\nGrade Level: " + gradelevel + 
				"\nStudent ID: " + studentid +
				"\nUniversity Email: " + email +
				"\nDefault Password: " + password +
				"\nCourses Enrolled: " + courses + 
				"\nBalance: $" + tuition; 
	}
}
