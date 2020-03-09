package Basics;

public class Testmethodofstringclass {

	public static void main(String[] args) {
		String s="Sachin";
		System.out.println(s.toUpperCase());//SACHIN
		System.out.println(s.toLowerCase());//sachin
		System.out.println(s);//Sachin(no change in original)
		System.out.println(s.trim());//Sachin
		System.out.println(s.length());//6
		
		String s1="Java is a programming lanquage. Java is a platform. Java is an Island";
		String replaceString=s1.replace("Java","Kava");//replace all occurences of "Java" to "Kava"
		System.out.println(replaceString);
	}

}
