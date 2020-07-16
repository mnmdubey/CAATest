package com.caat.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.caat.qa.base.CAAT_TestBase;
import com.caat.qa.pages.CAAT_Login;
import com.caat.qa.pages.CAAT_OpenApplication;
import com.caat.qa.testdata.CAAT_ExpectedData;
import com.caat.qa.testdata.CAAT_TestData;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class CAAT_Login_Test extends CAAT_TestBase{
	CAAT_OpenApplication openApp;
	CAAT_Login loginPage;
	CAAT_ExpectedData caat_ExpData;
	CAAT_TestData caat_TestData;
	
	ExtentReports report;
	ExtentTest test;
//--------------------------------------------------------------------------------
		@BeforeTest
		public void EnvironmentSetUp(){
			createHTMLReport("LoginAndTransaction_Verification.html", "Login Page - Verification");
			}	
//-------------------------------------------------------------------------------		
		@BeforeMethod
		public void SetUp() throws InterruptedException{
			initialization();
			openApp = new CAAT_OpenApplication();
			loginPage = new CAAT_Login();
			caat_ExpData = new CAAT_ExpectedData();
			caat_TestData = new CAAT_TestData();
		}
	
//=========================================================================
		@Test (priority = 1, enabled = false)
		public void LaunchApplication_Test(){
			System.out.println("Lets Open the CAAT Web Application");
			log_Info("Application has been Launched Successfully");
		}
		
		@Test(priority = 31, enabled = true)
		public void CAAT_LoginAndTransaction_Test() throws InterruptedException{
			loginPage.action_CAAT_Login(caat_TestData.Email, caat_TestData.Password);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			log_Info("User Logged in Successfully");
			takeScreenShot("CAAT_LoginVerification_Test_1.png");
			
			String LoggedIn_UserName = loginPage.validate_LoggedInUserName();
			compare_ExpVsAct_Values(LoggedIn_UserName, caat_ExpData.UserName_Exp);
			//test.log(LogStatus.PASS, "New Account has been Created Successfully");
			
			String MyPage_SignOutLabel = loginPage.validate_MyPageSignOut_Label();
			compare_ExpVsAct_Values(MyPage_SignOutLabel, caat_ExpData.SignOutLabel_Exp);
			
			loginPage.action_Select_WOMAN_Item();
			
			String OrderConf_title = loginPage.validate_OrderConfirmation_Title();
			compare_ExpVsAct_Values(OrderConf_title, caat_ExpData.MyOrderConfirmation_Title);
			//Log the Status
			
		}
		
		@Test (priority = 9999, enabled = false)
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
	}	
}