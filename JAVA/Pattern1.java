package Basics;

import java.util.Scanner;

public class Pattern1 {

	public static void main(String[] args) {
		
        Scanner Obj = new Scanner(System.in); 
		
		System.out.print("Enter A number : ");
		
		int i,j,k,n,a;
		
		n= Obj.nextInt();
		a=(n-1);

		 for(i=1;i<=n;i++)
		 {
			for(j=0;j<a;j++)
			{ System.out.print(" ");}
			for(k=1;k<=i;k++)
				{System.out.print(" * ");}
			System.out.println("");
			a--;
		 }
		 Obj.close();
			
 }

}
