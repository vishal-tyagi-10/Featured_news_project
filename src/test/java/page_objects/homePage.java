package page_objects;


	import java.io.IOException;
    import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	
	import org.openqa.selenium.support.FindBy;

    import utilities.Reuse;





	public class homePage  extends basePage {
		
		public homePage(WebDriver driver)
		{
			super(driver);
		}
		
		
		Reuse a=new Reuse(driver);


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
		
		@FindBy(xpath="//div[@id='89c5ffca-2ffb-4052-a723-e99c8c9a14ef']//div[@id='QuicklinksItemTitle']")
		List<WebElement> All_apps;
		

		@FindBy(xpath="//strong[text()='Around Cognizant']")
		WebElement txtScrollTill;

		@FindBy(xpath="//div[@id='89c5ffca-2ffb-4052-a723-e99c8c9a14ef']//div[@id='QuicklinksItemTitle']")
		List<WebElement> listAllAppsTools;
		
		
		
		public void account_validation() throws InterruptedException{
			a.Explicitwait(driver, profile);
			//Thread.sleep(20000);
			profile.click();
		

			
		}
		
		
		public String username_ConfirmationMsg() {
			try {
				a.Explicitwait(driver,username);
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
		
		
		
		
//		public void scrollIntoView() throws InterruptedException {
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			Thread.sleep(4000);
//		//	a.Explicitwait(driver,txtScrollTill);
//		    js.executeScript("arguments[0].scrollIntoView(true);",txtScrollTill);
//		 
//		}
//			
			
		
		public int news_count() {
			

				a.ExplicitwaitList(driver,news);

				return (news.size());
			}
		
		
		public String[] news_Title() {
				String[] arr = new String[news.size()];
				a.ExplicitwaitList(driver,news);
				for(int i=0;i<news.size();i++) {
					arr[i]=news.get(i).getText();
				}
				return arr;
			}

			
			
		public String[] news_Tooltip() throws IOException {
			a.ExplicitwaitList(driver,news);
			//a.ScreenShot("Tooltip1.png");
			
				String[] arr2 = new String[news.size()];
				for(int i=0;i<news.size();i++) {
					arr2[i]=news.get(i).getAttribute("title");
				}
				return arr2;
			}
			


	public void allAppsTools() throws IOException
	{
		String apps[]=new String[10];
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView(true);",txtScrollTill);
		 a.ScreenShot(driver,"ToolsAnd Apps.png");
		
	   a.ExplicitwaitList(driver,listAllAppsTools);
		System.out.println("Total Apps and Tools: "+ listAllAppsTools.size());
		

		for(int i=0;i<listAllAppsTools.size();i++)
		{
			WebElement apptool= listAllAppsTools.get(i);
			System.out.println(apptool.getText());
			apps[i]=apptool.getText();
		}
		a.Apps_tools(apps);
	}


	}



