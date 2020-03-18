package com.kohls.test;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.hols.base.Kohls_Base;
import com.kohls.pages.Kohls_First_Page;
import com.kohls.pages.Kohls_Second_Page;

public class Kohls_Test extends Kohls_Base{
	
  @Test
  public void f() throws InterruptedException {
	  
	  Kohls_First_Page fp = new Kohls_First_Page(driver);
	  Kohls_Second_Page sp = new Kohls_Second_Page(driver);
	  
	  fp.search("tuxedo");
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  sp.sort();
	  Thread.sleep(2000L);
	  sp.selectItem();
	  sp.chooseSize();
	  sp.addtoCart();

  }
}
