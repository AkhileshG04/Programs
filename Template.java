import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public static void main(String[] args) {
		System.out.println("Template");
		
		
//-----------------------------------------Launch Chrome Browser----------------------------------------------------------------
		
	  WebDriver driver;
      System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("https://www.seleniumhq.org");
	  driver.manage().window().maximize();
		  
//------------------------------------------Launch IE Browser--------------------------------------------------------------------
	  
		WebDriver driver;
	   System.setProperty("webdriver.ie.driver", "C:\\Selenium\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");
	   driver = new InternetExplorerDriver();
	   driver.get("https://in.hotels.com/");
	   driver.manage().window().maximize();
		  
		  
//-----------------------------------------------Screenshot----------------------------------------------------------------------
	   
		TakesScreenshot scrn = ((TakesScreenshot)driver);
	    File src = scrn.getScreenshotAs(OutputType.FILE);
	    String i="imgFail";
	    File dest = new File("C:\\latest\\latest\\Screenshots\\"+i+System.currentTimeMillis()+".png");
	    FileUtils.copyFile(src, dest);
		driver.close();
		
//-----------------------------------------------Month Select------------------------------------------------------------------------
		
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
	      
//-----------------------------------------------------DataProvider---------------------------------------------------------------------
	      
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
		 
//------------------------------------------Assert---------------------------------------------------------------------------
		 
		  Assert.assertTrue(linksCount>150);
		  
//-----------------------------------------Explicit Wait----------------------------------------------------------------------
		  
		  WebDriverWait wai8= new WebDriverWait(driver,30);
		  wai8.until(ExpectedConditions.elementToBeClickable(By.xpath("x-path")));
		  
//-----------------------------------------READ EXCEL CLASS-------------------------------------------------------------------
		  
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
	  
//------------------------------------------Write Excel---------------------------------------------------------------------------
		
		  public class ExcelWrite {
				public static Object[][] data = new Object[5][2];
				 //Function to write data into data object
				public static void ObjData(int RowC,int ColC,String s)
				{
					data[RowC][ColC]=s;
				}
				
				public static void Write() {
			       data[0][0]="OUTPUT POWER";//FIrst Row Of Excel Sheet
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
		  

