package Basics;
	
	public class OverloadingFunction
	{
		int id;
		String name;
		int age;
	
	OverloadingFunction(int i,String n)
	{
		id=i;
		name=n;
	}
	
	OverloadingFunction(int i, String n, int a)
	{
		id=i;
		name=n;
		age =a;
	}

	void display() {System.out.println(id+" "+name+" "+age);}
	
	public static void main(String[] args) {
	
		OverloadingFunction b=new OverloadingFunction(111,"Karan");
		OverloadingFunction o=new OverloadingFunction(222,"Aryan",25);
		o.display();
		b.display();
	}


}