package testcases;

import java.io.IOException;

import org.testng.annotations.Test;
import BaseClass.Driver;
import page_objects.homePage;



public class TC_004_allapps_and_tools extends Driver {
	@Test(priority=1)
	public void apps_tools() throws IOException{
		
		
		homePage hm=new homePage(driver);
		hm.allAppsTools();
		
		
	}

		
	}

