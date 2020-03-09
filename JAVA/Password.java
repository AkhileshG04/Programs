package Basics;



import java.util.Scanner;

public class Password {
	
	public static void main(String[] args) {

        Scanner Obj = new Scanner(System.in); 
        
        System.out.println("Enter a Password \n(Should contain atleast 1numeral , 1 Special Symbol(*,@,#) , and be only 6-20 character) \n");
        
        String p=Obj.nextLine();
        
        int l ,flag=0 ;
        l=p.length();
        
        if(l>=6&&l<20)
        	{
        
        if(p.matches(".*[0-9]+.*")==true&&p.matches(".*[$#@]+.*")== true)
        	flag=1;
        
        	}
 
       if(flag==1)
    	   System.out.println("Password Valid");
       else
    	   System.out.println("Password Invalid");
       
        Obj.close();
 
	}

}

