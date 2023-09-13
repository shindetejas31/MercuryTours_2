package TestScenarios;

import java.io.IOException;


import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import POM.HomePage;

import Resources.BaseObjects_Class;

public class LoginTest extends BaseObjects_Class {

public WebDriver driver;
	
	Logger log;

	HomePage homePage;
	
 public LoginTest() 
 { 
	 super(); 
 }
 
 @BeforeMethod
	
	public void setup() throws IOException {
		
		driver = InitializeBrowserANDopenAppURL();
		
		log = LogManager.getLogger(LoginTest.class);
		   
		homePage = new HomePage(driver);
		
		log.debug("Browser and URL got launched");
		
		}
 
       @AfterMethod public void teardown() 
       { 
    	   driver.quit(); 
   		log.debug("Browser got closed");

    	   
       }
	
       @Test(dataProvider = "GetLoginData")
   	
		 public void Login (String Email, String Password, String Expected_Result) throws IOException, InterruptedException {
    	   
    	 
		
		homePage.EnterUsername(Email);
		log.debug("Email got entered");

		homePage.EnterPW(Password);
		log.debug("PW got Entered");

		homePage.ClickOnSubmit();
		log.debug("Clicked on submit button");

		
		String ActualResult;
		
		
		try {		
				homePage.LoginConfirmText();	
		ActualResult = "Login Successfully";
		log.debug("User logged in");

		}catch(Exception e) {			
		ActualResult = "Enter your userName and password correct";
		log.debug("User didn't logged in");
		}		
		Assert.assertEquals(ActualResult, Expected_Result );
		log.info("Login test got passed");

       }	      
       @DataProvider
       
       public Object[][] GetLoginData() {
    	   
    	   Object[][] data = {{"rbajega","Testing@123","Login Successfully"}, {"rbajega","xassfafsyz","abc Enter your userName and password correct"}};
    	   
    	   return data;
       }
}










