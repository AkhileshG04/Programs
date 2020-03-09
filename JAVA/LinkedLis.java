package Basics;


import java.util.Iterator;
import java.util.LinkedList;

public class LinkedLis {

	public static void main(String[] args) {

     LinkedList<String> list = new LinkedList<String>();
		
		list.add("Ravi");
		list.add("Vijay");
		list.add("Ravi");
		list.add("Ajay");
		
		Iterator<String> itr =list.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}

	}

}
