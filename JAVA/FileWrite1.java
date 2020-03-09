package Basics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWrite1 {

	public static void main(String[] args) throws IOException {
		
		FileWriter writer = new  FileWriter("C:\\Users\\837357\\Documents\\Java\\New.txt");
		BufferedWriter buffer = new BufferedWriter(writer);
		buffer.write("Welcome to javaTpoint");
		buffer.close();
		System.out.println("Success");
				
	}

}
