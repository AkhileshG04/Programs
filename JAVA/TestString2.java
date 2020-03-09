package Basics;

public class TestString2 {

	public static void main(String[] args) {
		String s1="Sachin";
		String s2="SACHIN";
		
		System.out.println(s1.equals(s2));//false
		System.out.println(s1.equalsIgnoreCase(s2));//true
		
		String s3=new String("Sachin");
		System.out.println(s1==s2);//true (because both refer to same instance)
		System.out.println(s1==s3);//flase(because s3 refers to instance created in nonpool)
		
		System.out.println(s1.compareTo(s2));//0
		System.out.println(s1.compareTo(s3));//1(because s1>s3)
		System.out.println(s3.compareTo(s1));//-1(because s3<s1)
		
		String s="String" + "Tendulkar";
		System.out.println(s);//Sachin Tendulkar
		
		String s4=50+30+"Sachin"+40+40;
		System.out.println(s4);//80sachin
				
	}

}
