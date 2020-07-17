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
import com.caat.qa.pages.CAAT_ProfileAndTrans;
import com.caat.qa.testdata.CAAT_ExpectedData;
import com.caat.qa.testdata.CAAT_TestData;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class CAAT_ProfileAndTrans_Test extends CAAT_TestBase{
	CAAT_OpenApplication openApp;
	CAAT_Login loginPage;
	CAAT_ProfileAndTrans caat_TransHistory;
	CAAT_ExpectedData caat_ExpData;
	CAAT_TestData caat_TestData;
	
	ExtentReports report;
	ExtentTest test;
//--------------------------------------------------------------------------------
		@BeforeTest
		public void EnvironmentSetUp(){
			createHTMLReport("ProfileAndTransaction_Verification.html", "Transaction Page - Verification");
			}	
//-------------------------------------------------------------------------------		
		@BeforeMethod
		public void SetUp() throws InterruptedException{
			initialization();
			openApp = new CAAT_OpenApplication();
			loginPage = new CAAT_Login();
			caat_TransHistory = new CAAT_ProfileAndTrans();
			caat_ExpData = new CAAT_ExpectedData();
			caat_TestData = new CAAT_TestData();
			loginPage.action_CAAT_Login(caat_TestData.Email, caat_TestData.Password);
		}
	
//=========================================================================
		@Test (priority = 1, enabled = true)
		public void LaunchApplication_Test(){
			System.out.println("Lets Open the CAAT Web Application");
			log_Info("Application has been Launched Successfully");
		}
		
		@Test(priority = 11, enabled = true)
		public void CAAT_LoginAndTransactionAmountVerification_Test() throws InterruptedException{
			String LoggedIn_UserName = loginPage.validate_LoggedInUserName();
			compare_ExpVsAct_Values(LoggedIn_UserName, caat_ExpData.UserName_Exp);
			//test.log(LogStatus.PASS, "New Account has been Created Successfully");
			
			String MyPage_SignOutLabel = loginPage.validate_MyPageSignOut_Label();
			compare_ExpVsAct_Values(MyPage_SignOutLabel, caat_ExpData.SignOutLabel_Exp);
			
			double Trans_Amount = caat_TransHistory.validate_TransactionAmount();
			double ItemPrice = caat_TestData.ItemPrice;
			double Order_Qnty = caat_TestData.Order_Qnty;
			
			double TotalAmount = ItemPrice*Order_Qnty;
			
			compare_ExpVsAct_TransAmount(Trans_Amount, TotalAmount);
				
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
	}	
}