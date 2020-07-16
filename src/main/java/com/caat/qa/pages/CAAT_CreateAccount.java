package com.caat.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.caat.qa.base.CAAT_TestBase;
import com.caat.qa.testdata.CAAT_ExpectedData;
import com.caat.qa.testdata.CAAT_TestData;

//import com.caat.qa.pages.CAAT_HomePage;

public class CAAT_CreateAccount extends CAAT_TestBase{

//Page Factory - Object Repository
	CAAT_CreateAccount caat_creatAccount;
	CAAT_TestData caat_TestData;
		
		@FindBy(xpath="//*[@id='header']/div[2]/div/div/nav/div[1]/a")
		WebElement SignIn;
		
		@FindBy(id="email_create")
		WebElement email_Create;
		
		@FindBy(id="email_create")
		WebElement email_Create_Label;
		
		@FindBy(xpath="//*[@id='SubmitCreate']/span")
		WebElement CA_Submit_Btn;
		
		@FindBy(id="id_gender1")
		WebElement Title_Gender;
		
		@FindBy(id="customer_firstname")
		WebElement First_Name;
		
		@FindBy(id="customer_lastname")
		WebElement Last_Name;
		
		@FindBy(id="passwd")
		WebElement Password;
		
		@FindBy(id="firstname")
		WebElement Add_FName;
		
		@FindBy(id="lastname")
		WebElement Add_LName;
		
		@FindBy(id="address1")
		WebElement Address;
		
		@FindBy(id="city")
		WebElement City;
		
		@FindBy(id="id_state")
		WebElement State;
		
		@FindBy(id="postcode")
		WebElement Postal_Code;
		
		@FindBy(id="id_country")
		WebElement Country;
		
		@FindBy(id="phone_mobile")
		WebElement Mobile;
		
		@FindBy(id="alias")
		WebElement Alt_Email;
		
		@FindBy(xpath="//*[@id='submitAccount']/span")
		WebElement Register_Btn;
		
		@FindBy(xpath="//*[@id='header']/div[2]/div/div/nav/div[1]/a/span")
		WebElement Created_User_Name;
		
		@FindBy(xpath="//*[@id='header']/div[2]/div/div/nav/div[2]/a")
		WebElement SignOut_Label;
		
		
		
		
		//Initializing the Page Objects:
			public CAAT_CreateAccount(){
				
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
		
			public void action_SignIn() throws InterruptedException{
				SignIn.click();
				Thread.sleep(5000);
				
				caat_TestData = new CAAT_TestData();
				email_Create.sendKeys(caat_TestData.Email);
				Thread.sleep(5000);
				CA_Submit_Btn.click();
				
				Thread.sleep(1000);
				
				Title_Gender.click();
				First_Name.sendKeys(caat_TestData.First_Name);
				Thread.sleep(3000);
				
				
				Last_Name.sendKeys(caat_TestData.Last_Name);
				Thread.sleep(3000);
				Password.sendKeys(caat_TestData.Password);
				
				Add_FName.sendKeys(caat_TestData.Add_FName);
				Thread.sleep(3000);
				Add_LName.sendKeys(caat_TestData.Add_LName);
				Thread.sleep(3000);
				
				Address.sendKeys(caat_TestData.Address);
				City.sendKeys(caat_TestData.City);
				
				Select selectState = new Select(State);
				selectState.selectByVisibleText(caat_TestData.Select_State);
				
				Postal_Code.sendKeys(caat_TestData.Postal_Code);
								
				Select selectCountry = new Select(Country);
				selectCountry.selectByVisibleText(caat_TestData.Select_Country);
				
				Mobile.sendKeys(caat_TestData.Mobile);
				
				Alt_Email.sendKeys(caat_TestData.Alt_Email);
				
				Register_Btn.click();
				
				}
			
			public String validate_CAAT_MyPage_Title(){
			return driver.getTitle();
			}
			
			public String validate_CAAT_MyPage_URL(){
			return driver.getCurrentUrl();
			}
			
			public String validate_CreatedUserName(){
			String createUserName = Created_User_Name.getText();
			return createUserName;
			}
			
			public String validate_SignOut_Label(){
			String SignOutLabel = SignOut_Label.getText();
			return SignOutLabel;
			}
			
			public void action_SignOut(){
				SignOut_Label.click();
				
				}
			
			
			public String validate_EmailAddress_Label() throws InterruptedException{
				Thread.sleep(5000);
				System.out.println("Create Account Button Text is: "+email_Create_Label.getText());
				return email_Create_Label.getText();
			}
				
			public String validate_Submit_Button() throws InterruptedException{
				Thread.sleep(5000);
				System.out.println("Create Account Button Text is: "+CA_Submit_Btn.getText());
				return CA_Submit_Btn.getText();
			}
	}
