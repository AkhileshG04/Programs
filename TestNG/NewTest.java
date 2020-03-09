package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NewTest {
  @Test
  public void f() {
  System.out.println("Executing Test 3");
 
  }
  @Test
  public void fa() {
	  System.out.println("Executing Test 2");
  }
	  
  @Test
  public void fab() {

	  System.out.println("Executing Test 1");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("This Block Executed before each Test");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("This Block Executes after each Test");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("This Block Executes Before all Testcases");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("This Block Executes after all Test Cases");
  }

}
