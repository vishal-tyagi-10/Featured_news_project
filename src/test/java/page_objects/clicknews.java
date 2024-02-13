package page_objects;

import java.io.IOException;
import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import utilities.Reuse;




public class clicknews extends basePage {
	
	// WebDriver driver;
	 public clicknews(WebDriver driver)
		{
			super(driver);
		}
	
	@FindBy(xpath="//*[@style=\"-webkit-line-clamp: 3;\"]")
	 //@FindBy(xpath="//*[@role='listitem']/div/div/div/div/div/a")
    List<WebElement> click_news;

	@FindBy(xpath="//*[@role='menuitem'][@name='be.cognizant']")
	WebElement homepage;
	
	@FindBy(xpath="//*[@role='listitem']/div/div/div/div/div/a")
	List<WebElement> news;
	

	@FindBy(xpath="//*[@id='fa45f946-463e-428f-a84b-0bbbde09c3ba']//p[1]")
	WebElement content;
	
	
	public String[] clicking_news() throws InterruptedException, IOException {
		
		
		Reuse r= new Reuse(driver);
		String[] arr3= new String[click_news.size()]; 
		
		for(int i=0;i<click_news.size();i++) {
			
		r.ExplicitwaitList(driver,click_news);
		 int z=i+1;
		
			System.out.println("================= " + z+" "+"news"+" ====================");
			//Thread.sleep(8000);
			
			
			
			System.out.println(z+" "+click_news.get(i).getText());
			//arr3[i]=click_news.get(i).getText();
			   click_news.get(i).click();
			   arr3[i]=click_news.get(i).getText();
	         r.Explicitwait(driver, homepage);
	         Thread.sleep(7000);
	         r.ScreenShot(driver);
		
			  // Thread.sleep(8000);
		
			homepage.click();
			System.out.println("============Homepage=========================");
			 
		//	r.ExplicitwaitList();
		//r.Implicitwait(driver);
		
		Thread.sleep(4000);
		
       
		
		System.out.println(driver.getTitle());
		System.out.println();
	
		}
		return arr3;
	
	}
}
