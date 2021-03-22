package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.ContactsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	TestUtil testutil;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testutil = new TestUtil();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String title = homepage.validateHomePageTitle();
		Assert.assertEquals(title, "Cogmento CRM","Home Page title not matched");
	}
	
	@Test(priority = 2)
	public void verifyUserTitleTest() {
		//testutil.switchToFrame();// To Switch to frame if present
		String userNm = homepage.validateUserName();
		Assert.assertEquals(userNm, "Santosh Kumar","User name didnot match");
	}
	
	@Test(priority = 3)
	public void verifyContactsLinkTest() {
		//testutil.switchToFrame();// To Switch to frame if present
		contactspage = homepage.clickOnContacts();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
