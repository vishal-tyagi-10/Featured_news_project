package testcases;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BaseClass.Driver;
import page_objects.clicknews;
import page_objects.homePage;
import utilities.Reuse;


public class TC_Combined extends Driver {
	 @Test(priority=0)
	    public void Verify_account_details() throws InterruptedException {
	    	
	    	

		 Reuse r= new Reuse(driver);
	    	SoftAssert sa= new SoftAssert();
	    
	    	logger.info("******Verify_account_details********");
	    	try {
	    	homePage hp=new homePage(driver);
	    	
	    	logger.info("click");
	    	hp.account_validation();
	    	
	    	
	    	
	 
	    String abc=	hp.username_ConfirmationMsg();
	    System.out.println("===============username================");
	    	System.out.println(abc);
	    String name="Tyagi, Vishal (Cognizant)";
	   sa.assertEquals(abc,name,"not matched");
	   
	   r.ScreenShot(driver,"profile.png");
	    
	    	String email=  hp.Email_ConfirmationMsg();
	    	
	    	System.out.println("===============Email ID================");
	  
	    System.out.println(email);
	  String str= "2303764@cognizant.com";
	  sa.assertEquals(str,email,"not matched");
	  
	  

	    	}
	catch(Exception e) {
		//logger.error("test failed");
		sa.fail();
		
	}
	    	sa.assertAll();


	}
	 
	 @Test(priority=1)
		public void news_details() throws IOException {
			
		 homePage hp= new homePage(driver);
			
			Reuse reuse= new Reuse(driver);
			
			
		
		 int count=hp.news_count();
		

		 System.out.println();
		  System.out.println("total number of news displayed :"+count);
		  
		//printing number of news  in excel 
			reuse.totalnews(count);
		
		  
		String abc1[]=hp.news_Title();
		System.out.println();

		for(int i=0;i<count;i++) {
		System.out.println(i+1+" "+abc1[i]);
		}
		
		//printing news title in excel sheet
		reuse.News_title(abc1);
		reuse.ScreenShot(driver,"News.png");
		System.out.println();
		System.out.println();
		
		  	}
	 
	 @Test(priority=2)
		public void clicking_news() throws InterruptedException, IOException  {
		
				clicknews n=new clicknews(driver);
				homePage hp= new homePage(driver);
				SoftAssert sa= new SoftAssert();
				
			    
			      String tooltip[]=hp.news_Tooltip();
			      
			      String newsheading[]=n.clicking_news();
			  	//String pqr[]=hp.news_Title();
			      
			      for(int i=0;i< hp.news_count();i++) {
				      System.out.println("Tool Tip : "+tooltip[i]);
				      String abc=tooltip[i];
				      System.out.println("news heading : "+newsheading[i]);
				      String xyz=newsheading[i];

			    	  sa.assertEquals(abc,xyz,"not matching");
			      }
		}
	 @Test(priority=3)
		public void apps_tools() throws  IOException{
			
			
			homePage hm=new homePage(driver);
			hm.allAppsTools();
			
	 }
	 

}
