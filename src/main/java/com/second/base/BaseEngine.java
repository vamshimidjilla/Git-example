package com.second.base;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import com.second.utilities.ScreenShot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;




import com.second.utilities.DriverPathVariables;

public class BaseEngine {
	private static WebDriver  webDriver;
	private static String userDir;
	@Parameters("browser")
	@BeforeSuite
	public void openBrowser(@Optional("chrome")String browser) {
		userDir=System.getProperty("user.dir");
		if (browser.equalsIgnoreCase(DriverPathVariables.ieParameter)) {
			System.setProperty(DriverPathVariables.ieKey, userDir+DriverPathVariables.ieDriverPath);
			webDriver = new InternetExplorerDriver();
			initActivities();
		}
		else if (browser.equalsIgnoreCase(DriverPathVariables.chromeParameter)) {
			System.setProperty(DriverPathVariables.chromeKey,DriverPathVariables.chromeDriverPath);
			webDriver = new ChromeDriver();
			initActivities();
		}
        else if (browser.equalsIgnoreCase(DriverPathVariables.firefoxParameter)) {
        	System.setProperty(DriverPathVariables.firefoxKey, userDir+DriverPathVariables.firefoxDriverPath);
			webDriver = new FirefoxDriver();
			initActivities();
		}
	}
	@AfterSuite
	public void closeBrowser() {
		//clean up activities
		if (webDriver!=null) 
			webDriver.close();
		else
			System.out.println("WEBDRIVER is pointing to NULL....CHECK ONCE");
	}
	
	private void initActivities()
	{
		webDriver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
		webDriver.manage().window().maximize();
		webDriver.manage().deleteAllCookies();

	}
	
	@BeforeMethod
	public void beforeTCExecution(Method method) {
		String tcName = method.getName();
		System.out.println("Currently executing tcname is: " + tcName);
	}
	
	@AfterMethod
	public void afterTCExecution(ITestResult result) throws IOException {
		String tcName = result.getName();
		System.out.println("TC is executed: " + tcName);
		System.out.println("Analysing Execution status FAIL|PASS|SKIP");
		
		if (result.getStatus()==ITestResult.SUCCESS) {
			System.out.println("TC is passed so not taking screenshot");
		}
		else if (result.getStatus()==ITestResult.FAILURE) {
			System.out.println("TC IS FAILED SO TAKING SCREENSHOT : " +tcName);
			ScreenShot.screenshot(tcName);
		}
		else if (result.getStatus()==ITestResult.SKIP) {
			ScreenShot.screenshot(tcName);	
			System.out.println("TC IS SKIPPED SO TAKING SCREENSHOT : " +tcName);
		}
		
	}
	
	public static String getUserDir()
	{
		return userDir;
	}
	
	//It is a getter method to access webdriver
		public static WebDriver getWebDriver()
		{
			return webDriver;
		}
}
	
	
	