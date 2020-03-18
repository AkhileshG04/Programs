package com.php.test;

import org.testng.annotations.Test;
import com.php.base.php_Test_Base;
import com.php.pages.php_First_Page;
import com.php.pages.php_Second_Page;


public class php_Test extends php_Test_Base {
	
  @Test
  public void php_TestCase() throws InterruptedException 
 {
	  php_First_Page fs = new php_First_Page(driver);
	  fs.selectCurrenct();
	  fs.selectFrom();
	  fs.selectTo();
	  fs.datePick();
	  
	  php_Second_Page ss = new php_Second_Page(driver);
	  ss.ratesSelect();
	  
 }
}