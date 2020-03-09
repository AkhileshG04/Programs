package Selenuim;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TEST {
  @Test(dataProvider = "dp")
  public void f(Integer n, Integer s) {
	  
	  System.out.println("Integer 1: "+n+"\tInteger 2: "+s);
	  System.out.println(" ");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Before Method");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("After Method");
  }


  @SuppressWarnings("null")
@DataProvider
  public Object[][] dp() {
	  
    Object[][] data =new Object[2][2];

    
	Integer[][] arr=new Integer[5][5];
    
    
    for(int i=0;i<2;i++)
    {
    	for(int j=0;j<2;j++)
    	{
    		data[i][j]=i;
    	}
    }
    

    
    
   return data;
  
  }
  @BeforeTest
  public void beforeTest() {
	  System.out.println("Before Test");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("After Test");
  }

}
