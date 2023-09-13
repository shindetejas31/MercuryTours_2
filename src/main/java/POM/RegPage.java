package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegPage {
	
WebDriver driver;
	
	public RegPage(WebDriver driver) {
		 		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	//web elements
		@FindBy(xpath="//input[@name='firstName']")
		private WebElement FirstName;
		
		@FindBy(xpath="//input[@name='lastName']")
		private WebElement LastName;
		
		@FindBy(xpath="//input[@name='phone']")
		private WebElement Phone;
		
		@FindBy(xpath="//input[@id='userName']")
		private WebElement Email;
		
		@FindBy(xpath="//input[@name='address1']")
		private WebElement Address;
		
		@FindBy(xpath="//input[@name='city']")
		private WebElement City;
		
		@FindBy(xpath="//input[@name='state']")
		private WebElement State;
		
		@FindBy(xpath="//input[@name='postalCode']")
		private WebElement Postalcode;
				
		@FindBy(xpath="//select[@name='country']")
		   WebElement Country;
        
		@FindBy(xpath="//input[@id='email']")
		private WebElement Username;
		
		@FindBy(xpath="//input[@name='password']")
		private WebElement Password;
		
		@FindBy(xpath="//input[@name='confirmPassword']")
		private WebElement CPassword;
		
		@FindBy(xpath="//input[@name='submit']")
		private WebElement Submit;
		
		@FindBy(xpath="//font[contains(text(),'Thank you for registering.')]")
		private WebElement AccSuccessful;
		
		@FindBy(xpath="//span[@id='repeatedPassword.errors']")
		private WebElement AccWarning;
		
		public void EnterFname(String FirstnameText)
		{
			FirstName.sendKeys(FirstnameText);
		}
		
		public void EnterLname(String LastnameText)
		{
			LastName.sendKeys(LastnameText);
		}
		
		public void EnterPhone(String TelephoneText)
		{
			Phone.sendKeys(TelephoneText);
		}
		
		public void EnterEmail(String EmailText)
		{
			Email.sendKeys(EmailText);
		}
		
		public void EnterAddress(String AddressText)
		{
			Address.sendKeys(AddressText);
		}
		
		public void EnterCity(String CityText)
		{
			City.sendKeys(CityText);
		}
		
		public void EnterState(String StateText)
		{
			State.sendKeys(StateText);
		}
		
		public void EnterPostalCode(String PostalCodeText)
		{
			Postalcode.sendKeys(PostalCodeText);
		}
		
		public void select_list(String INDIA)
		{
		     Select statusDropdown=new Select(Country);
		     statusDropdown.selectByVisibleText(INDIA);
		}
		
		public void EnterUsername(String UsernameText)
		{
			Username.sendKeys(UsernameText);
		}
		
		public void EnterPW(String PWText)
		{
			Password.sendKeys(PWText);
		}
		
		public void EnterCPW(String CPWText)
		{
			CPassword.sendKeys(CPWText);
		}
		
		public void ClickOnSubmit()
		{
			Submit.click();
		}
		
		public String AccConfirmText()
		{
			return AccSuccessful.getText();
		}
		
		
		public String AccWarningMSG()
		{
			return AccWarning.getText();
		}
	
}
