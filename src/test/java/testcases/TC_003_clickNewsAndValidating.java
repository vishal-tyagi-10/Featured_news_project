package testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BaseClass.Driver;
import page_objects.clicknews;
import page_objects.homePage;



public class TC_003_clickNewsAndValidating extends Driver {
	
	
	@Test
	public void clicking_news() throws InterruptedException  {
		try {
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
	    	  System.out.println();
	    	  System.out.println();
	      }
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
