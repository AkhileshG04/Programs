package Basics;

import java.util.Scanner;

public class Input {

	public static void main(String[] args) {

		Scanner Obj = new Scanner(System.in); 
	    System.out.println("Enter username");

	    String userName = Obj.nextLine(); 
	    System.out.println("Username is: " + userName);
	    Obj.close();
	}

}
