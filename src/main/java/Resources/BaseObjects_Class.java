package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import Utilities.Utilities;
import io.github.bonigarcia.wdm.WebDriverManager;



public class BaseObjects_Class {
	
	WebDriver driver = null;
	
	public Properties prop;
	public Properties prop2;
	
	
	
	public WebDriver InitializeBrowserANDopenAppURL() throws IOException 
	{
		
		
		prop = new Properties();
		prop2 = new Properties();
		
		String propPath = System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\data.properties";
		String propPath2 = System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\RegisterData.properties";
		
		FileInputStream fis = new FileInputStream(propPath);
		FileInputStream fis2 = new FileInputStream(propPath2);
		
		prop.load(fis);
		prop2.load(fis2);
		
		String browsername = prop.getProperty("browser");
		
		if(browsername.equalsIgnoreCase("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
		}
		else if (browsername.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
		}
		else if (browsername.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			 driver = new EdgeDriver();;
		}
		
		else if (browsername.equalsIgnoreCase	("safari"))
		{
			WebDriverManager.safaridriver().setup();
			 driver = new SafariDriver();
		}
		
		// selenium 4 timeout method
		/*
		 * driver.manage().window().maximize();
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.
		 * IMPLICIT_WAIT_TIME));
		 * driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.
		 * PAGE_LOAD_TIME)); driver.get(prop.getProperty("url"));
		 */
		
		//selenium 3 timeout method
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Utilities.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Utilities.PAGE_LOAD_TIME, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
		return driver;
	
	}
	
	public String TakeScreenShots(String testName,WebDriver driver) throws IOException {
		
		File SourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFilePath = System.getProperty("user.dir")+"\\screenshots\\"+testName+".png";
		FileUtils.copyFile(SourceFile,new File(destinationFilePath));
		
		return destinationFilePath;
		
	}
}






