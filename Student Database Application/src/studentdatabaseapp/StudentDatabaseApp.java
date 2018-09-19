package studentdatabaseapp;

import java.util.Scanner;

public class StudentDatabaseApp {

	public static void main(String[] args) {
		//Student student1 = new Student();
		//student1.enroll();
		//student1.paytuition();
		//System.out.println(student1.showinformation());
		
		//Ask how many new students we want to add
		System.out.print("Enter number of new students to enroll: ");
		Scanner in = new Scanner(System.in);
		int numofstudents = in.nextInt();
		Student[] students = new Student[numofstudents];
		
		
		//Create n number of new students
		boolean payagain = false;
		for (int n = 0; n < numofstudents; n++) {
			students[n] = new Student();
			students[n].enroll();
			do {
				students[n].paytuition();
				System.out.println("Submit another Payment? (Y/N)");
				in = new Scanner(System.in);
				payagain = in.nextLine().equals("Y") ? true : false;
			} while(payagain);
			System.out.println(students[n].showinformation());
		}
		
		System.out.println("\nThanks for visiting. Come Again");
	}

}
