package Basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader1Buff {

	public static void main(String[] args) throws IOException {
				
		try
		{
			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("Enter Intger :");
		int n = Integer.parseInt(br.readLine());
		System.out.println("Integer :"+n);
		
		System.out.print("Enter Float :");
		float f = Float.parseFloat(br.readLine());
		System.out.println("Float :"+f);
			
		System.out.print("Enter String :");  
		String c = br.readLine();
		System.out.println("String :"+c);
		}
		catch(IOException e)
		{
			System.err.println("IO Exception");
		}
		catch(NumberFormatException e1)
		{
		System.err.println("Conversion Error");
		}
		
		finally
		{
			System.out.println("Done");
		}


	}

}
