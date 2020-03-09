package Basics;

import java.util.Scanner;

public class Pattern {

	public static void main(String[] args) {
		
		Scanner Obj = new Scanner(System.in); 
		
		System.out.print("Enter A number : ");
		
		int i,j,n;
		
		n= Obj.nextInt();
		
		for(i=1;i<=n;i++)
		{
			for(j=1;j<=i;j++)
			{
				 System.out.print(" * ");
					
				 
			}
			System.out.println("");
		}
			
		for(i=1;i<=n;i++)
		{
			for(j=(n-1);j>=i;j--)
			{
				 System.out.print(" * " );
			}
			System.out.println("");
			
			Obj.close();
		}
			
			
					
			
			
			
			
		}
		
		}
		


