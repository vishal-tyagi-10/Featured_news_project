package testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import BaseClass.Driver;
import page_objects.homePage;
import utilities.Reuse;


public class TC_002_newsAndCount extends Driver{
	@Test
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
	}


