package com.caat.qa.testcases;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.caat.qa.base.CAAT_TestBase;
import com.caat.qa.pages.CAAT_Login;
import com.caat.qa.testdata.CAAT_ExpectedData;
import com.caat.qa.pages.CAAT_OpenApplication;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class CAAT_OpenApplication_Test extends CAAT_TestBase{
	CAAT_OpenApplication openApp;
	CAAT_ExpectedData caat_ExpData;

//--------------------------------------------------------------------------------
	@BeforeTest
	public void EnvironmentSetUp(){
		createHTMLReport("OpenApplication_Verification.html", "Open Application Page - Verification");
		}	
//-------------------------------------------------------------------------------
	
	@BeforeMethod
	public void SetUp() throws InterruptedException{
		initialization();
		openApp = new CAAT_OpenApplication();
		caat_ExpData = new CAAT_ExpectedData();
//		openApp_Test = new OpenApplication_Test();
		
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy__HH-mm-ss-SSS"); 
		Calendar cal = Calendar.getInstance();  
	//	public String DateTime = dateFormat.format(cal.getTime());
	}
//========================================================================================	
	@Test (priority = 10, enabled = true)
	public void LaunchApplication_Test(){
		System.out.println("Lets Open the Cross Asyst Web Application");
		log_Info("Application has been Launched Successfully");
		takeScreenShot("LaunchApplication_Test_1.png");
	}
	
	@Test (priority = 11, enabled = true)
	public void validate_CAAT_MainPage_TitleAndURL_Test(){
		//Title
		String CAAT_MainPage_Title = openApp.validate_CAAT_MainPage_Title();
		System.out.println("CAAT_MainPage_Title:"+CAAT_MainPage_Title);
		compare_ExpVsAct_Values(CAAT_MainPage_Title, caat_ExpData.MainPage_Title);
	
		//URL
		String CAAT_MainPage_URL = openApp.validate_CAAT_MainPage_URL();
		System.out.println("CAAT_MainPage_URL: "+CAAT_MainPage_URL);
		compare_ExpVsAct_Values(CAAT_MainPage_URL, caat_ExpData.MainPage_URL);
		
//		takeScreenShot("ScreenShot_"+DateTime+".png");
	}
	
	@Test (priority = 9999, enabled = true)
	public void CAAT_CloseApp_Test(){
		log_Warning("All Test Completed, Application will be Closed");
	}		
//========================================================================================
	@AfterMethod
	public void ClosetheBroser(){
		driver.quit();
		System.out.println("Test Case RAN and Browser has been Closed");	
	}
	
//------------------------------------------------------------------------	
	@AfterTest
	public void TestCompleted(){
	testCompletedAndCloseReport();
//		report.endTest(test);  
//		report.flush();
	}
}

