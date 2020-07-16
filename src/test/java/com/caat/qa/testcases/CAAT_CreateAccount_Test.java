package com.caat.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.caat.qa.base.CAAT_TestBase;
import com.caat.qa.base.CAAT_TestBase;
import com.caat.qa.pages.CAAT_CreateAccount;
import com.caat.qa.pages.CAAT_Login;
import com.caat.qa.pages.CAAT_Login;
import com.caat.qa.pages.CAAT_OpenApplication;
import com.caat.qa.testdata.CAAT_ExpectedData;
import com.caat.qa.testdata.CAAT_TestData;
import com.caat.qa.testdata.CAAT_ExpectedData;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

	public class CAAT_CreateAccount_Test extends CAAT_TestBase{
		CAAT_OpenApplication openApp;
		CAAT_CreateAccount caat_creatAccount;
		CAAT_ExpectedData caat_ExpData;
		CAAT_TestData caat_TestData;
		
		ExtentReports report;
		ExtentTest test;
	//--------------------------------------------------------------------------------
			@BeforeTest
			public void EnvironmentSetUp(){
				createHTMLReport("CreateAccount_Verification.html", "Create Account - Verification");
				}	
	//-------------------------------------------------------------------------------		
			@BeforeMethod
			public void SetUp() throws InterruptedException{
				initialization();
				openApp = new CAAT_OpenApplication();
				caat_creatAccount = new CAAT_CreateAccount();
				caat_ExpData = new CAAT_ExpectedData();
				caat_TestData = new CAAT_TestData();
			}
		
	//=========================================================================
			@Test (priority = 1, enabled = false)
			public void LaunchApplication_Test(){
			System.out.println("Lets Open the CAAT Application");
			log_Info("Application has been Launched Successfully");
			}

			@Test (priority = 11, enabled = false)
			public void validate_CAAT_MainPage_TitleAndURL_Test(){
			//Title
			String CAAT_MainPage_Title = caat_creatAccount.validate_CAAT_MainPage_Title();
			compare_ExpVsAct_Values(CAAT_MainPage_Title, caat_ExpData.MainPage_Title);
		
			//URL
			String CAAT_MainPage_URL = caat_creatAccount.validate_CAAT_MainPage_URL();
			compare_ExpVsAct_Values(CAAT_MainPage_URL, caat_ExpData.MainPage_URL);
			}

			@Test (priority = 21, enabled = false)
			public void validate_SignIn_Label_Test() throws InterruptedException{
			String CAAT_SignInLabel = caat_creatAccount.validate_SignIn_Label();
			compare_ExpVsAct_Values(CAAT_SignInLabel, caat_ExpData.LP_SignIn_Label);			
			takeScreenShot("validate_IMLWebApp_LoginPage_Label_Test_1.png");
			}
			
			@Test(priority = 31, enabled = true)
			public void CAAT_CreateNewAccount_Test() throws InterruptedException{
			caat_creatAccount.action_SignIn();
			
			String CreatedUserName = caat_creatAccount.validate_CreatedUserName();
			compare_ExpVsAct_Values(CreatedUserName, caat_ExpData.UserName_Exp);
			//test.log(LogStatus.PASS, "New Account has been Created Successfully");
			
			String SignOutLabel = caat_creatAccount.validate_SignOut_Label();
			compare_ExpVsAct_Values(SignOutLabel, caat_ExpData.SignOutLabel_Exp);
			
			caat_creatAccount.action_SignOut();
			//test.log(LogStatus.PASS, "User have been Logged out Successfully");
			}
			
			@Test (priority = 41, enabled = false)
			public void CAAT_RolePage_CloseApp_Test(){
			log_Warning("All Test Completed, Application will be Closed");
			}		
	//========================================================================================
				
			@Test (priority = 999, enabled = false)
			public void ClosingTheApplication_Test(){
				log_Warning("All Test Completed, Application will be Closed");
			}		

	//==================================================================	
		@AfterMethod
		public void ClosetheBroser(){
			//driver.quit();
			System.out.println("Test Case RAN and Browser has been Closed");	
		}
	//------------------------------------------------------------------------	
		@AfterTest
		public void TestCompleted(){
		testCompletedAndCloseReport();
		}	
	}
