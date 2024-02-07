package testcases;



import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import page_objects.homePage;
import testBase.baseClass;
import utilities.ExcelUtility;
import utilities.wriring_excel;

public class TC_001 extends baseClass{
	
	

    @Test
    public void Verify_account_details() throws InterruptedException {
    	
    	SoftAssert sa= new SoftAssert();
    
    	logger.info("******Verify_account_details********");
    	try {
    	homePage hp=new homePage(driver);
    	
    	logger.info("click");
    	hp.account_validation();
    	Thread.sleep(9000);
    	
    	
    	
    String abc=	hp.username_ConfirmationMsg();
    	
    	System.out.println(abc);
    String name="Tyagi, Vishal (Cognizant)";
    sa.assertEquals(abc,name,"not matched");
    
    	String email=  hp.Email_ConfirmationMsg();
  
    System.out.println(email);
  String str= "2303764@cognizant.com";
  sa.assertEquals(str,email,"not matched");
  int count=hp.news_count();
  System.out.println("total number of news displayed :"+count);
  
  
String abc1[]=hp.news_Title();
wriring_excel.News_title(abc1);
String xyz[]=hp.news_Tooltip();
String pqr[]=hp.news_Title();
for(int i=0;i<count;i++) {
System.out.println(i+1+" "+abc1[i]);


System.out.println(i+1+" "+xyz[i]);
System.out.println(i+1+" "+pqr[i]);

}
    	}
    	catch(Exception e) {
    		logger.error("test failed");
    		sa.fail();
    		
    	}
	sa.assertAll();

    }

}
