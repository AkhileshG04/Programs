import org.testng.annotations.DataProvider;

import com.hotels.datasources.Read_Excel;

-----------------------------------------LAUNCH CHROME----------------------------------------------------------------------------------
		
	  WebDriver driver;
      System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("https://www.seleniumhq.org");
	  driver.manage().window().maximize();
		  
------------------------------------------LAUNCH IE--------------------------------------------------------------------------------
	  
		WebDriver driver;
	   System.setProperty("webdriver.ie.driver", "C:\\Selenium\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");
	   driver = new InternetExplorerDriver();
	   driver.get("https://in.hotels.com/");
	   driver.manage().window().maximize();
		  
		  
-------------------------------------------------SCREENSHOT----------------------------------------------------------------------------------
	   
		TakesScreenshot scrn = ((TakesScreenshot)driver);
	    File src = scrn.getScreenshotAs(OutputType.FILE);
	    String i="imgFail";
	    File dest = new File("C:\\latest\\latest\\Screenshots\\"+i+System.currentTimeMillis()+".png");
	    FileUtils.copyFile(src, dest);
		driver.close();
		
-----------------------------------------------MONTH SELECT----------------------------------------------------------------------------------
		
		 d=driver.findElement(By.xpath("//*[@class=\"widget-datepicker-hd\"]//*[@class=\"widget-datepicker-label\"]"));
		 while(!d.getText().contains("September 2020"))
		 {
			 p = (List<WebElement>) driver.findElements(By.xpath("//*[@class=\"widget-datepicker-hd\"]/button[2]"));
			 ((List<WebElement>) p).get(1).click();
		 }
		 
		 //Day Select
		 
		 List<WebElement> date =  driver.findElements(By.xpath("/html/body/div[6]/div[2]/div[1]/div[2]/table/tbody/tr/td/a"));
		  
		  count = date.size();
		 
		  for(i=0;i<count;i++)
		  {
			  text=date.get(i).getText();
		 
		  if(text.equalsIgnoreCase("10"))
		  {
			  date.get(i).click();
			  break;
		  }
		  }	  
			
		  //Scroll Up/Down
		  
		  JavascriptExecutor js = (JavascriptExecutor) driver;
	      js.executeScript("window.scrollBy(0,-600)", "");
	      
-----------------------------------------------------DataProvider-----------------------------------------------------------------------------
	      
	      Object[][] data = new Object[3][5];

		  String s;
					  
		  int i=0,j=0,n;
		  
		  File file=new File("C:\\latest\\latest\\Automation\\HotelsData.xlsx");
			FileInputStream fis=new FileInputStream(file);

			@SuppressWarnings("resource")
			XSSFWorkbook workbook=new XSSFWorkbook(fis);
			XSSFSheet sheet=workbook.getSheet("HotelDetails");
			Iterator <Row> itr=sheet.iterator();
		
		 
			while(itr.hasNext()){
				j=0;
				Row row=itr.next();
				Iterator<Cell> cellIterator=row.cellIterator();
				
				while(cellIterator.hasNext()) {
					
					Cell cell=cellIterator.next();
					
						s=cell.getStringCellValue();
						data[i][j]=s;
						
				  j++;
				}				
				i++;
			}
			
		 return data; 
-----------------------------------------------SWITCH WINDOWS-------------------------------------------------------------------------------------
		 
		 ArrayList<String> availableWindows = new ArrayList<String>(driver.getWindowHandles());
		  driver.switchTo().window(availableWindows.get(1));  
		 
-----------------------------------------------ASSERT----------------------------------------------------------------------------------------------
		 
		  Assert.assertTrue(linksCount>150);
		  
---------------------------------------------EXPLICIT WAIT------------------------------------------------------------------------------------------
		  
		  WebDriverWait wai8= new WebDriverWait(driver,30);
		  wai8.until(ExpectedConditions.elementToBeClickable(By.xpath("x-path")));
		  Wai8.until(ExpectedConditions.textToBePresentInElementValue(locator, text))

		  
--------------------------------------------READ EXCEL CLASS-------------------------------------------------------------------------------------
		  
		  public class ReadExcelData
		  {
		   private static XSSFSheet ExcelWSheet;
		   private static XSSFWorkbook ExcelWBook;
		   private static XSSFCell Cell; 
		    
		   //This method is to set the File path and to open the Excel file
		   //Pass Excel Path and SheetName as Arguments to this method
		   public static void setExcelFile(String Path,String SheetName) throws Exception 
		   {
		   FileInputStream ExcelFile = new FileInputStream(Path);
		   ExcelWBook = new XSSFWorkbook(ExcelFile);
		   ExcelWSheet = ExcelWBook.getSheet(SheetName);
		   }
		    
		   //This method is to read the test data from the Excel cell
		   //In this we are passing parameters/arguments as Row Num and Col Num
		   public static String getCellData(int RowNum, int ColNum) throws Exception
		   {
		   Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
		   String CellData = Cell.getStringCellValue();
		   return CellData;
		   }
		  }
	  
-----------------------------------------------------WRITE EXCEL---------------------------------------------------------------------------------------
		
		  public class ExcelWrite {
				public static Object[][] data = new Object[5][2];
				
				public static void ObjData(int RowC,int ColC,String s)
				{
					data[RowC][ColC]=s;
				}
				
				public static void Write() {
			       data[0][0]="OUTPUT POWER";
			       data[0][1]="Result";
					XSSFWorkbook workbook = new XSSFWorkbook();
					XSSFSheet sheet = workbook.createSheet("BMW_OUTPUT");
					
					int rowCount=0;
					for(Object[] abc : data)
					{
						Row row = sheet.createRow(rowCount++);
					int colCount=0;
					for(Object fie : abc)
					{
						Cell cell = row.createCell(colCount++);
					if(fie instanceof String)
					{
						cell.setCellValue((String) fie);
					}
					else if (fie instanceof Integer)
					{
						cell.setCellValue((Integer) fie);
					}
					else if(fie instanceof Float)
					{
						cell.setCellValue((Float) fie);
					}
				}

			}
					try
					{
						File file = new File("C:\\latest\\latest\\Automation\\BMW_Output.xlsx");
						FileOutputStream fis = new FileOutputStream(file);
						workbook.write(fis);
						workbook.close();
						System.out.println("File has been written successfully");
								}
					catch(Exception e)
					{
					e.printStackTrace();	
					}
					}

			}    
		  
------------------------------------------------------BROWSER COMPLIANCE------------------------------------------------------------------------------
		  
		  System.out.println("Enter Your Browser Choice");
          System.out.println("1.Google Chrome");
          System.out.println("2.Internet Explorer");
          @SuppressWarnings("resource")
          Scanner sc = new Scanner(System.in);
          int choice=sc.nextInt();
       
          //Choice of Browser
          
          switch(choice)
          {
          case 1:
               {
            	   //Launch the Chrome Browser
            	   
                    System.setProperty("webdriver.chrome.driver","C:\\New folder\\chromedriver_win32\\chromedriver.exe\\");
                    driver=new ChromeDriver();
               }
               break;
               
          case 2:
               {
            	   //Launch the IE Browser
            	   
            	   System.setProperty("webdriver.ie.driver",".//IEDriverServer.exe");
            	   driver=new InternetExplorerDriver();
               }
               break;
          
               default:
               {
            	   //Launch the Chrome Browser as default when user chooses choices other than Chrome and IE Browser
            	   
                    System.setProperty("webdriver.chrome.driver",".//chromedriver.exe");
                    driver=new ChromeDriver();
               }
          }
@@DataProvider{----------------------------------------------DATA PROVIDER WITH READ EXCEL------------------------------------------------------------


				
					public Object[][] dp() throws Exception {
	
					int i,j;
					Object[][] data= new Object[12][5];
	    
					Read_Excel.setExcelFile("C:\\latest\\latest\\Automation\\HotelsData.xlsx", "HotelDetails");
	    
					for(i=0;i<12;i++)
					{
						j=0;
						for(j=0;j<5;j++)
						{
							data[i][j]=Read_Excel.getCellData(i, j);
						}
							}

						return data;
						}
						}
