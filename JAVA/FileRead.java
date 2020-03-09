package Basics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileRead {

	public static void main(String[] args) throws IOException {
		
		FileReader fr=new FileReader("C:\\Users\\837357\\Documents\\New.txt");
		BufferedReader br=new BufferedReader(fr);
					
					String st;
				    int i;
					
					while((st=br.readLine())!=null)
						//while((i=br.read())!=-1)
					{
						System.out.println(st);
					//	System.out.println((char)i);
					}
			br.close();
			fr.close();
				}

			
}

