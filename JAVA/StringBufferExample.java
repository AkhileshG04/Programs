package Basics;

public class StringBufferExample {

	public static void main(String[] args) {
		
		StringBuffer sb = new StringBuffer("Hello");
		//StringBuilder sb = new StringBuilder("Hello");
		sb.append("Java"); //now original string is changed
        System.out.println(sb);
        
        sb.insert(1,"Java");
        System.out.println(sb);
        
       StringBuffer sb1 = new StringBuffer("Hello");
       sb1.replace(1, 2, "Java");
       System.out.println(sb1);
       
       StringBuffer sb2 = new StringBuffer("Hello");
       sb2.delete(1,3);
       System.out.println(sb2);//prints Hlo
	}

}
