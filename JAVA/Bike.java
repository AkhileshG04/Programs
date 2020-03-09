package Basics;

public class Bike {
	
	int id;
	String name;
	
	Bike(int i,String n)
	{
		id=i; 
		name=n;
	}
	
	void display()
	{
		System.out.println(id+" "+name);
	}

	public static void main(String[] args) {
		
		Bike b =new Bike(111,"Karan");
		Bike d =new Bike(222,"Aryan");
		
		b.display();
		d.display();
		
		
		
	}

}
