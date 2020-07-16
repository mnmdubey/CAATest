package com.caat.qa.pages;


import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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
		
		@FindBy(xpath="//*[@id='block_top_menu']/ul/li[1]/a")
		WebElement MyPage_WOMAN_Section;
		
		
		@FindBy(xpath="//*[@id='center_column']/ul/li[3]/div/div[1]/div/a[1]/img")
		WebElement MyPage_WOMAN_Item;
		
		@FindBy(xpath="//*[@id='add_to_cart']/button/span")
		WebElement MyPage_WOMAN_Add;
		
//		@FindBy(xpath="//*[@id='quantity_wanted_p']/a[2]/span")
//		WebElement Select_Quantity;
//		
//		@FindBy(xpath="//*[@id='our_price_display']")
//		WebElement Item_Price;
//		
//		@FindBy(xpath="//*[@id='add_to_cart']/button")
//					   
//		WebElement AddToCart;
	
		@FindBy(xpath="//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span")
		WebElement PrcdToCheckOut;
		
		@FindBy(xpath="//*[@id='center_column']/p[2]/a[1]/span")
		WebElement Summary_PrcdToCheckOut;
		
		@FindBy(xpath="//*[@id='center_column']/form/p/button/span")
		WebElement Address_PrcdToCheckOut;
		
		@FindBy(xpath="//*[@id='cgv']")
		WebElement TermsAndService_CheckBox;
		
		@FindBy(xpath="//*[@id='form']/p/button/span")
		WebElement Shipping_PrcdToCheckOut;
		
		@FindBy(xpath="//*[@id=HOOK_PAYMENT']/div[1]/div/p/a")
		WebElement Payment_Wire;
		
		@FindBy(xpath="//*[@id='cart_navigation']/button/span")
		WebElement IConfirmMyOrder_Btn;
		
	
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
				
			public void action_Select_WOMAN_Item() throws InterruptedException{
				MyPage_WOMAN_Section.click();
				Thread.sleep(6000);
				
				driver.findElement(By.xpath("//*[@id='center_column']/ul/li[3]/div/div[1]/div/a[1]/img")).click();
//				MyPage_Woman_PrintedDress.click();
//				Thread.sleep(15000);
				
				driver.findElement(By.xpath("//*[@id='bigpic']")).click();
//				MyPage_WOMAN_Item.click();
				Thread.sleep(15000);
				
				
//				Select_Quantity.click();
//				
//				String ItemPrice = Item_Price.getText();
//				ItemPrice = ItemPrice.replace("$", "");
				
//				AddToCart.click();
//				Thread.sleep(5000);
				
				MyPage_WOMAN_Add.click();
				Thread.sleep(5000);
				
				PrcdToCheckOut.click();
				Thread.sleep(5000);
				
				Summary_PrcdToCheckOut.click();
				Thread.sleep(5000);
				
				Address_PrcdToCheckOut.click();
				Thread.sleep(5000);
				
				TermsAndService_CheckBox.click();
				Thread.sleep(10000);
				
				Shipping_PrcdToCheckOut.click();
				Thread.sleep(5000);
				
				IConfirmMyOrder_Btn.click();
				Thread.sleep(5000);
				
				}
			
			public String validate_OrderConfirmation_Title(){
				return driver.getTitle();
			}
			
	}
