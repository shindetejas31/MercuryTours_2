package Listners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Resources.BaseObjects_Class;
import Utilities.ExtentReport;

public class Listners extends BaseObjects_Class implements ITestListener  {
	
	WebDriver driver = null;
	ExtentReports extentReport = ExtentReport.getExtentReport();
	
	ExtentTest extenTest;
	ExtentTest extenTest2;
	
	//to run parallel test without false status
	ThreadLocal<ExtentTest> extentTestThread = new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
		
		String testName2 =  result.getName();
		 extenTest = extentReport.createTest(testName2+" Execution started");
		 extentTestThread.set(extenTest);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		String testName2 =  result.getName();
		//without thread
		//extenTest.log(Status.PASS, testName2+" Test Passed");
		
		//with thread
		extentTestThread.get().log(Status.PASS, testName2+" Test Passed");
	
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		String testName = result.getName();

		
		//extenTest.fail(result.getThrowable());
		extentTestThread.get().fail(result.getThrowable());
		
		try {
			 driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			String ScreenShotFilePath = TakeScreenShots( testName, driver);
			extentTestThread.get().addScreenCaptureFromPath(ScreenShotFilePath, testName);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	
		//code to take screenshots and can be implemented in any listener 
	
		String testName = result.getName();
		
		extentTestThread.get().skip(result.getThrowable());
		try {
			 driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			String ScreenShotFilePath = TakeScreenShots( testName, driver);
			extentTestThread.get().addScreenCaptureFromPath(ScreenShotFilePath, testName);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		extentReport.flush();
		
	}
	

}
