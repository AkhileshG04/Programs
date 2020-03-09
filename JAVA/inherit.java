package Basics;

public class inherit {

	void eat() {System.out.println("eating...");}
	
}
	
	class dog extends inherit{
		void bark() {System.out.println("barking...");}
	}
	class testinheritance{
	public static void main(String[] args) {
		
		dog d =new dog();
		d.bark();
		d.eat();

	}

}
