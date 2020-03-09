package Basics;

class Anmal{
	void eat() {System.out.println("eating...");}
}
class dogs extends Anmal{
	void bark() {System.out.println("barking...");}
}
class babydog extends dogs{
	void weep() {System.out.println("weeping...");}
}
class Function1
{
public static void main(String[] args)
{
	babydog z= new babydog();
	z.weep();
	z.bark();
	z.eat();
}
}
