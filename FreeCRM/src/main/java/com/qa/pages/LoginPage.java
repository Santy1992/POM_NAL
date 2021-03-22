package com.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

import okio.Timeout;

public class LoginPage extends TestBase{
	//PageFactory OR:
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[contains(text(),'Login')]")
	WebElement btnLogin;
	
	@FindBy(xpath="//div[contains(text(),'Classic FreeCRM or CRMPro User? Login to ')]")
	WebElement txtLoginToClassicCRM;
	
	//Initializing Page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateClassicCRMText() {
		return txtLoginToClassicCRM.isDisplayed();
	}
	
	public HomePage login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		btnLogin.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new HomePage();
	}
}
