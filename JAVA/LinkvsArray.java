package Basics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkvsArray {

	public static void main(String[] args) {


		List<String> al = new ArrayList<String>();
		al.add("Ravi");
		al.add("Vijay");
		al.add("Ravi");
		al.add("Ajay");
		
		List<String> al1 = new LinkedList<String>();
		al1.add("James");
		al1.add("Serena");
		al1.add("Swati");
		al1.add("Junaid");
		
		System.out.println("Array List : "+al);
		System.out.println("Linked List : "+al1);
		

	}

}
