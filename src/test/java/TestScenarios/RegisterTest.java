package TestScenarios;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import POM.HomePage;
import POM.RegPage;
import Resources.BaseObjects_Class;
import Utilities.Utilities;
import TestScenarios.RegisterTest;

public class RegisterTest extends BaseObjects_Class {

	public WebDriver driver;
	
	Logger log;

	RegPage regpage;
	
	HomePage homePage;
	
 public RegisterTest() 
 { 
	 super(); 
 }
 
 @BeforeMethod
	
	public void setup() throws IOException {
	 
	 	
		driver = InitializeBrowserANDopenAppURL();
		homePage = new HomePage(driver);
	 	regpage = new RegPage(driver);
		homePage.ClickOnRegister();
		}
 
       @AfterMethod public void teardown() 
       { 
    	   driver.quit(); 
    	   
       }
    
 			@Test(priority = 1)
	
			 public void RegWithAllData()  {
 				
 				
 		    log = LogManager.getLogger(RegisterTest.class.getName());

 			
			
			 regpage.EnterFname(prop2.getProperty("FirstName"));
			 regpage.EnterLname(prop2.getProperty("LastName"));
			 regpage.EnterPhone(prop2.getProperty("Phone"));
			 regpage.EnterEmail(Utilities.generateEmail());
			 regpage.EnterAddress(prop2.getProperty("Address"));
			 regpage.EnterCity(prop2.getProperty("City"));
			 regpage.EnterState(prop2.getProperty("State"));
			 regpage.EnterPostalCode(prop2.getProperty("Postalcode"));
			 regpage.select_list("INDIA");
			 regpage.EnterUsername(Utilities.generateEmail());
			 regpage.EnterPW(prop2.getProperty("Password"));
			 regpage.EnterCPW(prop2.getProperty("CPassword"));
			 regpage.ClickOnSubmit();
			 String name = regpage.AccConfirmText();
			 System.out.println(name);
			 
			 Assert.assertTrue(regpage.AccConfirmText().contains(name));
			 
			 
			 
}}
