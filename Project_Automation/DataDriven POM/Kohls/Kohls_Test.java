package Kohls;


import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

public class Kohls_Test extends Kohls_Base{
	
  @Test
  public void f() throws InterruptedException {
	  
	  First_Page fp = new First_Page(driver);
	  Second_Page sp = new Second_Page(driver);
	  
	  fp.search("tuxedo");
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  sp.sort();
	  Thread.sleep(2000L);
	  sp.selectItem();
	  sp.chooseSize();
	  sp.addtoCart();

  }
}
