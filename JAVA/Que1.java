package Basics;

import java.util.HashMap;
import java.util.Scanner;

public class Que1 {

	public static void main(String[] args) {


		HashMap<String,String> d = new HashMap<String,String>();
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the Number of Employee details to be Entered :");
		
		int n= s.nextInt();
		
		int i;
		String g;
		
		String name,id; 
		
		System.out.println("Enter Details Below :");
		
		for(i=0;i<n;i++)
		{
			System.out.println("Enter Id Of "+(i+1) +":");
			
			id=s.next();
			
			System.out.println("Enter Employee Name :");
			
			name=s.next();
			
			d.put(id, name);
			
		}
		
		
		System.out.println("Enter the ID of Employee : ");
		
		g=s.next();
		
		if(d.containsKey(g))
		{
		
		System.out.println("Employee: " + d.get(g));
		}
		else
		{
			System.out.println("Error Data Not Available");
		}
		
		
			
		
		s.close();
	}

}
