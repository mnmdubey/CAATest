package com.caat.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.caat.qa.base.CAAT_TestBase;

public class CAAT_OpenApplication extends CAAT_TestBase {
	
//  Page Factory - Object Repository
//	@FindBy(xpath="/html/body/div[1]/header/div/nav/div[2]/div/div[2]/ul/a")
//	WebElement Login_Link;
	
	//Initializing the Page Objects:
		public CAAT_OpenApplication(){
			PageFactory.initElements(driver, this);
		}

		//Actions:
		public String validate_CAAT_MainPage_Title(){
		return driver.getTitle();
		}
		
		//Actions:
		public String validate_CAAT_MainPage_URL(){
		return driver.getCurrentUrl();
		}
}

