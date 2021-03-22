package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class ContactsPage extends TestBase{
	//PageFactory OR:
		@FindBy(xpath="//div[contains(text(),'Contacts')]")
		WebElement txtContactsLabel;
		
		@FindBy(xpath="//button[contains(text(),'New')]")
		WebElement btnContactsNew;
		
		@FindBy(name="first_name")
		WebElement txtFirstName;
		
		@FindBy(name="last_name")
		WebElement txtLastName;
		
		@FindBy(xpath="//div[@name='company']/input")
		WebElement txtCompanyContacts;
		
		@FindBy(name="status")
		WebElement drpdownStatus;
		
		@FindBy(xpath="//button[contains(text(),'Save')]")
		WebElement btnContactsSave;
		
		@FindBy(xpath="//button[contains(text(),'Cancel')]")
		WebElement btnContactsCancel;
		
		//Initializing Page objects
		public ContactsPage() {
			PageFactory.initElements(driver, this);
		}
		
		public boolean validateContactsLabel() {
			return txtContactsLabel.isDisplayed();
		}
		
		public void selectContact(String contactName) {
			List<WebElement> lstContactName = driver.findElements(By.xpath("//table[@class='ui celled sortable striped table custom-grid']/tbody/tr/td[2]/a"));
			for(int i=0; i<=lstContactName.size()-1; i++) {
				String txtContactName = lstContactName.get(i).getText();
				if(txtContactName.equalsIgnoreCase(contactName)) {
					WebElement chkContact = driver.findElement(By.xpath("//table[@class='ui celled sortable striped table custom-grid']/tbody/tr["+i+"]/td[1]/div/input"));
					chkContact.click();
				}
			}
		}
		
		public void createContact(String firstName, String lastName, String companyName, String StatusVal) {
			txtFirstName.sendKeys(firstName);
			txtLastName.sendKeys(lastName);
			txtCompanyContacts.sendKeys(companyName);
			drpdownStatus.click();
			List<WebElement> lstStatusVal = driver.findElements(By.xpath("//div[@class='visible menu transition']/div/span"));
			for(int i=0; i<=lstStatusVal.size()-1; i++) {
				String txtStatusVal = lstStatusVal.get(i).getText();
				if(txtStatusVal.equalsIgnoreCase(StatusVal)) {
					WebElement eleStatus = driver.findElement(By.xpath("//div[@class='visible menu transition']/div["+i+"]/span"));
					eleStatus.click();
				}
			}
			btnContactsSave.click();
		}
}
