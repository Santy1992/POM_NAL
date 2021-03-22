package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.ContactsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	TestUtil testutil;
	String sheetName = "Contacts";
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeClass
	public void setUp() {
		initialization();
		testutil = new TestUtil();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		//testutil.switchToFrame();
		contactspage = homepage.clickOnContacts();
	}
	
	@Test(priority = 1)
	public void verifyContactsPageLabelTest() {
		boolean flag= contactspage.validateContactsLabel();
		Assert.assertTrue(flag,"Contacts label is missing on the page");
	}
	
	@Test(priority = 2)
	public void selectContactsTest() {
		contactspage.selectContact("Test Automation 2");
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority = 3, dataProvider = "getCRMTestData")
	public void validateCreateNewContactsTest(String firstName, String lastName, String company, String status) {
		homepage.clickOnNewContactsLink();
		//contactspage.createContact("Test", "NewContact1", "A2Z", "New");
		contactspage.createContact(firstName, lastName, company, status);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
