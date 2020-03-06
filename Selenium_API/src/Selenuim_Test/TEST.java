package Selenuim_Test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TEST {
  @Test(dataProvider = "dp")
  public void f(Integer n, String s) {
	  
	  System.out.println("Integer: "+n+"String: "+s);
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Before Method");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("After Method");
  }


  @DataProvider
  public Object[][] dp() {
	  
    Object[][] data =new Object[2][2];
    data[0][0]="0 0";
    data[0][1]="0 1";
    
    data[1][0]="1 0";
    data[1][1]="1 1";
    
    data[2][0]="2 0";
    data[2][1]="21";
    
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
