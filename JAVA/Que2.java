package Basics;

import java.util.Scanner;

public class Que2 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter a String : ");
		
		String a = s.nextLine();
		
		int b = a.length();
		int i,j;
		
		
		for(i=0;i<b;i++)
		{
			for(j=i+1;j<b;j++)
			{
				if(a.charAt(i)==a.charAt(j))
				{
										
					a=a.replace(a.charAt(i), Character.toUpperCase(a.charAt(j)));
							
				}
			}
		}
		
		System.out.println("The String is : "+a);
		
		s.close();

	}

}
