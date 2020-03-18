package com.bmw.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.bmw.base.BMW_Test_Base;
import com.bmw.pages.BMW_First_Page;
import com.bmw.pages.BMW_Second_Page;
import com.bmw.pages.ExcelWrite;

public class BMW_Test extends BMW_Test_Base {
	
  @Test
  public void a() throws Exception {
	  BMW_Second_Page s= new BMW_Second_Page(driver);
      s.Second(0);
  }
  @Test
  public void b() throws Exception {
	  BMW_Second_Page s= new BMW_Second_Page(driver);
	  s.Second(1);
	 
  }
  @Test
  public void c() throws Exception {
	  BMW_Second_Page s= new BMW_Second_Page(driver);
	  s.Second(2);
	 
  }
  @Test
  public void d() throws Exception {
	  BMW_Second_Page s= new BMW_Second_Page(driver);
	  s.Second(3);
	 
  }
 @BeforeClass
 public void BeforeClass()
 {
	 BMW_First_Page f = new BMW_First_Page(driver);
	  f.First();
//	  ExcelWrite.setExcel("BMW_OutPut");
 }
@AfterClass
public void afterClass()
{
//	ExcelWrite.setFile("C:\\latest\\latest\\Automation\\BMW_OutPut.xlsx");
	ExcelWrite.Write();
}
}

