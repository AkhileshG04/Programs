package Basics;

public class Student {
	
	int id;
	String name;

	void display() {System.out.println(id+" "+name);}
	
	public static void main(String[] args) {
		
		Student s1=new Student();
		Student s2=new Student();
		
		s1.display();
		s2.display();
		
	}

}
