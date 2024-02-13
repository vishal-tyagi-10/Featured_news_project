package testcases;



import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BaseClass.Driver;
import page_objects.homePage;
import utilities.Reuse;


public class TC_001_VerifyUserDetail extends Driver{
	

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
	logger.error("test failed");
	sa.fail();
	
}
    	sa.assertAll();


}
    	}
    




