package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;

public HomePage(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	//to register
	@FindBy(linkText = "REGISTER" )
	WebElement Register;
	
	public void ClickOnRegister()
	{
		Register.click();
	}
	
	//to login
	
	@FindBy(xpath = "//input[@name='userName']" )
	WebElement Username;
	
	@FindBy(xpath = "//input[@name='password']" )
	WebElement Password;
	
	@FindBy(xpath = "//input[@name='submit']" )
	WebElement Submit;
	
	@FindBy(xpath="//h3[normalize-space()='Login Successfully']")
	private WebElement LoginSuccessful;
	
	@FindBy(xpath="//span[normalize-space()='Enter your userName and password correct']")
	private WebElement InvalidCreds;
	
	public void EnterUsername(String UsernameText)
	{
		Username.sendKeys(UsernameText);
	}
	
	public void EnterPW(String PWText)
	{
		Password.sendKeys(PWText);
	}
	
	public void ClickOnSubmit()
	{
		Submit.click();
	}
	
	public String LoginConfirmText()
	{
		return LoginSuccessful.getText();
	}
	
	public String LoginFailedText()
	{
		return InvalidCreds.getText();
	}
}

