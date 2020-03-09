package Basics;

import java.util.Scanner;

public class Que3 {

	public static void main(String[] args) {
		
		Scanner s= new Scanner(System.in);
		
		System.out.println("Enter a String : ");
		
		String a=s.nextLine();
		

		int b = a.length();
		int i;
		
		
		for(i=0;i<b;i++)
		{
			if(a.charAt(i)=='a'||a.charAt(i)=='e'||a.charAt(i)=='i'||a.charAt(i)=='o'||a.charAt(i)=='u'||a.charAt(i)=='A'||a.charAt(i)=='E'||a.charAt(i)=='I'||a.charAt(i)=='O'||a.charAt(i)=='U')
				{
										
					a=a.replace(a.charAt(i), '*');
					break;		
				}
			}
		
		System.out.println("The Replaced String is\n"+a);
		s.close();
		}
		
	
	
		
	}


