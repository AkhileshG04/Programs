package Basics;


class Base
{
	public void printMessage()
	{
		System.out.println("Hi!");
	}
}

class inher extends Base
{
	
	public void printMessage()
	{
		super.printMessage();
		System.out.println("Welcome");
	}
	
}
 

public class Que4 {
	
	
	public static void main(String[] args) {
		
		
		inher i = new inher();
	
		i.printMessage();
		

		 

	}

}
