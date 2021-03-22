package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class HomePage extends TestBase {
	@FindBy(xpath = "//div/span[@class='user-display']")
	@CacheLookup
	WebElement txtUserName;

	@FindBy(xpath = "//div[@id='main-nav']/div[3]")
	WebElement btnContacts;
	
	@FindBy(xpath = "//div[@id='main-nav']/div[3]/button")
	WebElement btnContactsNew;

	@FindBy(xpath = " //div/a/span[contains(text(),'Deals')]")
	WebElement btnDeals;

	@FindBy(xpath = " //div/a/span[contains(text(),'Tasks')]")
	WebElement btnTasks;

	// Initializing Page objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String validateUserName() {
		return txtUserName.getText();
	}

	public String validateHomePageTitle() {
		return driver.getTitle();
	}

	public ContactsPage clickOnContacts() {
		btnContacts.click();
		return new ContactsPage();
	}

	public void clickOnNewContactsLink() {
		Actions action = new Actions(driver);
		action.moveToElement(btnContacts).build().perform();
		btnContactsNew.click();
	}

	public DealsPage clickOnDeals() {
		btnDeals.click();
		return new DealsPage();
	}

	public TasksPage clickOnTasks() {
		btnTasks.click();
		return new TasksPage();
	}
}
