package page_objects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class homePage extends basePage {
	WebDriver driver;
	public homePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//*[@id='O365_MainLink_MePhoto']")
	WebElement profile;
	
	@FindBy(xpath="//div[@id='mectrl_currentAccount_primary']")
	WebElement username;
	
	@FindBy(xpath="//div[@id='mectrl_currentAccount_secondary']")
	WebElement Email;
	
	@FindBy(xpath="//*[@role='listitem']/div/div/div/div/div/a")
	List<WebElement> news;
	
	@FindBy(xpath="//*[@id='title_text']")
	WebElement news_title;

	
	public void account_validation() throws InterruptedException{
		//Thread.sleep(9000);
		profile.click();
		
	}
	

	
	public String username_ConfirmationMsg() {
		try {
			return (username.getText());
		} catch (Exception e) {
			return (e.getMessage());

		}
	}
		public String Email_ConfirmationMsg() {
			try {
				return (Email.getText());
			} catch (Exception e) {
				return (e.getMessage());

			}
		}
		
		public int news_count() {
			
			return (news.size());
			
		
		}
		public String[] news_Title() {
			String[] arr = new String[news.size()];
			for(int i=0;i<news.size();i++) {
				arr[i]=news.get(i).getText();
			}
			return arr;
		}

			
			
		
		
		public String[] news_Tooltip() {
			String[] arr2 = new String[news.size()];
			for(int i=0;i<news.size();i++) {
				arr2[i]=news.get(i).getAttribute("title");
			}
			return arr2;
		}
		public String[] clicking_news() throws InterruptedException {
			String[] arr3 = new String[news.size()];
			for(int i=0;i<news.size();i++) {
				news.get(i).click();
				Thread.sleep(5000);
				arr3[i]=news_title.getText();
				
			}
			return arr3;
			
		}
		
}


