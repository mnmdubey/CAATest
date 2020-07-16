package com.caat.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
//import com.lki.qa.util.WebEventListener;
import com.relevantcodes.extentreports.LogStatus;

public class CAAT_TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static ExtentReports report;
	public static ExtentTest test;
	
	
	public CAAT_TestBase(){
		try {
			prop = new Properties();
			FileInputStream fip = new FileInputStream(".\\src\\main\\java\\com\\caat\\qa\\config\\config.properties");
			prop.load(fip);
		}
	catch (FileNotFoundException e)
		{
		e.printStackTrace();
		}
	catch (IOException e)
		{
		e.printStackTrace();
		}
		}

//	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"); 
//	Calendar cal = Calendar.getInstance();  
//	String DateTime = dateFormat.format(cal.getTime());
	
public static void initialization() throws InterruptedException{
	String browserName = prop.getProperty("browserName");
	
	if(browserName.contains("chrome")) // browserName == chrome, fireFox
		{
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver_v83.0.exe");
		driver = new ChromeDriver();
		}
	else if (browserName.equals("fireFox")) // browserName == chrome, fireFox
		{
		System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		}

	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	Thread.sleep(3000);
	driver.get(prop.getProperty("AppURL"));
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

public void createHTMLReport(String VerifPageName, String TestPageName){
	report = new ExtentReports(System.getProperty("user.dir")+"\\test-output\\HTMLReport\\"+VerifPageName);
	test = report.startTest("IML: Test Report || "+TestPageName);
}

//Common Method to call in Other Classes
	public void log_Info(String Log_Info){
		test.log(LogStatus.INFO, Log_Info);
		}
	
//Common Method to call in Other Classes
	public void log_Warning(String Log_WarningMessage){
			test.log(LogStatus.WARNING, Log_WarningMessage);
			}
	
//Common Method to call in Other Classes
	public void compare_ExpVsAct_Values_NP(String aStr, String eStr, ExtentTest test, ExtentReports report){
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy__HH-mm-ss-SSS"); 
		//DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Calendar cal = Calendar.getInstance();  
		String DateTime = dateFormat.format(cal.getTime());
		
		System.out.println("DateTime: "+DateTime);
		takeScreenShot("LetTakePrintAndSave.png");
		System.out.println("Took the Print and Saved");
		
		if(eStr.equals(aStr))
		{
			System.out.println("Test Passed :: Expected and Actual Matched || Expected: "+eStr + " | Actual: "+aStr);
			test.log(LogStatus.PASS, "Test Passed :: Expected and Actual Matched || Expected: "+eStr + " | Actual: "+aStr);
			
			takeScreenShot("ScreenShot_"+DateTime+".png");
		}
		else
		{
			System.out.println("Test Failed :: Expected and Actual DID NOT Matched || Expected: "+eStr + " | Actual: "+aStr);
			test.log(LogStatus.FAIL, "Test Failed :: Expected and Actual DID NOT Matched || Expected: "+eStr + " | Actual: "+aStr);
			takeScreenShot("ScreenShot_"+DateTime+".png");
		}	
	}
	
	
	//Common Method to call in Other Classes
		public void compare_ExpVsAct_Values(String aStr, String eStr){
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy__HH-mm-ss-SSS"); 
			//DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			Calendar cal = Calendar.getInstance();  
			String DateTime = dateFormat.format(cal.getTime());
			
			System.out.println("DateTime: "+DateTime);
			takeScreenShot("LetTakePrintAndSave.png");
			System.out.println("Took the Print and Saved");
			
			if(eStr.equals(aStr))
			{
				System.out.println("Test Passed :: Expected and Actual Matched || Expected: "+eStr + " | Actual: "+aStr);
				test.log(LogStatus.PASS, "Test Passed :: Expected and Actual Matched || Expected: "+eStr + " | Actual: "+aStr);
				
//				takeScreenShot("ScreenShot_"+DateTime+".png");
			}
			else
			{
				System.out.println("Test Failed :: Expected and Actual DID NOT Matched || Expected: "+eStr + " | Actual: "+aStr);
				test.log(LogStatus.FAIL, "Test Failed :: Expected and Actual DID NOT Matched || Expected: "+eStr + " | Actual: "+aStr);
				takeScreenShot("ScreenShot_"+DateTime+".png");
			}	
		}
//Common Method to call in Other Classes
	public void compare_ExpVsAct_BooleanDecision(boolean eBooleanValue, boolean aBooleanValue){
		if(eBooleanValue==aBooleanValue)
		{
			System.out.println("Test Passed :: Expected and Actual Matched || Expected: "+eBooleanValue + " | Actual: "+aBooleanValue);
			test.log(LogStatus.PASS, "Test Passed :: Expected and Actual Matched || Expected: "+eBooleanValue + " | Actual: "+aBooleanValue);
		}
		else
		{
			System.out.println("Test Failed :: Expected and Actual DID NOT Matched || Expected: "+eBooleanValue + " | Actual: "+aBooleanValue);
			test.log(LogStatus.FAIL, "Test Failed :: Expected and Actual DID NOT Matched || Expected: "+eBooleanValue + " | Actual: "+aBooleanValue);
		}	
	}
	
//--------------------------------------------------------------------------------------------------------
	public void takeScreenShot(String fileName){
		//Lets take the screenShots
		//String directory = lki_ConfigFile.screenShotPath;
		String directory = ".\\test-output\\ScreenShot\\";
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
//		File sourceFile = ((TakesScreenshot)driver)
		try {
			FileUtils.copyFile(sourceFile, new File(directory+File.separator+fileName));
			} 
		catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("INFO: Took the screenshot and saved at Specified location");
	}
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
public void testCompletedAndCloseReport(){
//	report.endTest(test); 
	report.endTest(test); 
	report.flush();
	}
}