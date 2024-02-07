package testBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class baseClass {
	public WebDriver driver;
	public Logger logger;
	public Properties p;
	
	@BeforeClass
	@Parameters({"os","browser"})
	public void setup(String os,String br) throws InterruptedException, IOException {
		//loading data from config properties
		FileInputStream file= new FileInputStream(".//src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		
		//loading log4j2
	logger=	LogManager.getLogger(this.getClass());
		
		switch(br.toLowerCase()) {
		case "chrome":driver = new ChromeDriver(); break;
		case "edge": driver=new EdgeDriver();
		break;
		}
		
		
	//	WebDriverManager.chromedriver().setup();
		// driver = new ChromeDriver();	
		 driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	    driver.get(p.getProperty("appUrl"));
	    Thread.sleep(20000);
		
	
	}
	public  void Scroll()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,150)", "");
	}
    @AfterClass
    public void tearDown() {
    	driver.quit();
	
}

}
