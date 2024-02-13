package utilities;

import java.io.File;

import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import page_objects.basePage;

public class Reuse extends basePage{
	public WebDriver driver;
	 public Reuse(WebDriver driver)
		{
			super(driver);
		
		}
	 
	ExcelUtility e = new ExcelUtility();
	 String file_path = System.getProperty("user.dir") + ".\\Excel-data\\Excel.xlsx";
	

		public  void ScreenShot(WebDriver driver) throws IOException
		{
		    Date d =new Date();
		    TakesScreenshot ts=(TakesScreenshot)driver;
	        File srcFile=ts.getScreenshotAs(OutputType.FILE);
	        File destFile = new File(System.getProperty("user.dir")+"/Screenshots/"+d.toString().replace(":", "_")+".png");
		    FileUtils.copyFile(srcFile, destFile);
		}
		 
		 public  void ScreenShot(WebDriver driver, String Str) throws IOException  {
				TakesScreenshot ts=(TakesScreenshot)driver;
		        File src=ts.getScreenshotAs(OutputType.FILE);
		        String path="C:\\Users\\2303764\\eclipse-workspace\\new_featured_news\\Screenshots\\"+ Str;
		        File trg=new File(path);
		        FileUtils.copyFile(src, trg);
			}
	
	 
	 public  void Implicitwait(WebDriver driver)
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
	 
	 public  void Explicitwait(WebDriver driver, WebElement ele)
		{
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(60));
			wait.until(ExpectedConditions.visibilityOfAllElements(ele));
		}
		public  void ExplicitwaitList( WebDriver driver, List<WebElement> eleme)
		{
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(40));
			wait.until(ExpectedConditions.visibilityOfAllElements(eleme));
		}

	
	
	


	public void News_title(String[] names) {

		for (int i = 1; i <= 5; i++) {
			try {
				
				
				e.setCellData(file_path, "Sheet1", i, 1, names[i - 1]);
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
		System.out.println("Writing of First Five news in Excel Done");
	}

	public  void totalnews(int count) {
		
		String value = String.valueOf(count);
		try {
			e.setCellData(file_path, "Sheet1", 1, 0, value);
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		System.out.println("Writing of Total number of news in Excel Done");
	}
	
	public void Apps_tools(String[] names) {

		for (int i = 1; i <= 9; i++) {
			try {
				
				
				e.setCellData(file_path, "Sheet1", i, 2, names[i - 1]);
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
		System.out.println("Writing all apps and tools name in Excel Done");
	}
	

		
	
	
	
}