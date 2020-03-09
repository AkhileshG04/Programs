package Basics;

public class Testimutablestring {

	public static void main(String[] args) {
		String s="Sachin ";
		s.concat("Tendulkar");//concat()method appends the string at the end
		s=s.concat("Tendulkar");
		System.out.println(s);//Will print Sachin because strings are immutable objects
		
	}
}
