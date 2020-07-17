package com.caat.qa.pages;


import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;

import com.caat.qa.base.CAAT_TestBase;
import com.caat.qa.testdata.CAAT_ExpectedData;
import com.caat.qa.testdata.CAAT_TestData;
import com.caat.qa.pages.CAAT_HomePage;
import com.caat.qa.pages.CAAT_HomePage;

//import com.caat.qa.pages.CAAT_HomePage;

public class CAAT_Login extends CAAT_TestBase{

//Page Factory - Object Repository
	CAAT_CreateAccount caat_creatAccount;
	CAAT_TestData caat_TestData;
		
		@FindBy(xpath="//*[@id='header']/div[2]/div/div/nav/div[1]/a")
		WebElement SignIn;
		
		@FindBy(xpath="//*[@id='email']")
		WebElement EmailAddess;
		
		@FindBy(xpath="//*[@id='passwd']")
		WebElement Password;
		

		@FindBy(xpath="//*[@id='SubmitLogin']")
		WebElement Submit_Login_Btn;
		
		@FindBy(xpath="//*[@id='header']/div[2]/div/div/nav/div[1]/a/span")
		WebElement LoggedIn_User_Name;
		
		@FindBy(xpath="//*[@id='header']/div[2]/div/div/nav/div[2]/a")
		WebElement MyPage_SignOut_Label;
		
		
		//Initializing the Page Objects:
			public CAAT_Login(){
				
				PageFactory.initElements(driver, this);
			}

			//Actions:
			public String validate_SignIn_Label() throws InterruptedException{
				System.out.println("SignIn: "+SignIn.getText());
				return SignIn.getText();
			}
				

			public String validate_CAAT_MainPage_Title(){
				return driver.getTitle();
			}
			
				public String validate_CAAT_MainPage_URL(){
				return driver.getCurrentUrl();
			}
				
			public CAAT_HomePage action_CAAT_Login(String userName, String EnterPassword) throws InterruptedException{
				
				SignIn.click();
				Thread.sleep(5000);
				EmailAddess.sendKeys(userName);
				Password.sendKeys(EnterPassword);
				Thread.sleep(2000);
				Submit_Login_Btn.click();
				Thread.sleep(1000);
				return new CAAT_HomePage();		
				}
			
				public String validate_LoggedInUserName(){
				String LoggedInUserName = LoggedIn_User_Name.getText();
				return LoggedInUserName;
				}
				
				public String validate_MyPageSignOut_Label(){
				String MyPage_SignOutLabel = MyPage_SignOut_Label.getText();
				return MyPage_SignOutLabel;
				}
	}
