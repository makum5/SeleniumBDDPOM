package com.crm.qe.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qe.base.BaseClass;

public class ContactsPage extends BaseClass {
	
	/**
	 * Dynamic Xpath
	 */
	String checkbox = "(//td[text()='NAME_RUNTIMEREPLACEMENT']/parent::tr/td/div)[1]";

	
	@FindBy(xpath="//div[text()='Contacts']")
	WebElement contactLabel;
	
	@FindBy(xpath="//button[contains(text(),'New')]")
	WebElement newContactLink;
	
	@FindBy(name="first_name")
	WebElement firstName;
	
	@FindBy(name="last_name")
	WebElement lastName;
	
	@FindBy(name="address")
	WebElement address;
	
	@FindBy(xpath="//input[@name='value' and @placeholder='Number']")
	WebElement number;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	WebElement saveBtn;
	
	public ContactsPage(){
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactLabel(){
		return contactLabel.isDisplayed();
	}
	
	public void selectContactByName(String name){
		driver.findElement(By.xpath(checkbox.replace("NAME_RUNTIMEREPLACEMENT", name))).click();
	}
	
	public void clickOnNewContactLink(){
		newContactLink.click();
	}
	public boolean createNewContact(String fname,String lname,String addrs,String Mobnumber){
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		address.sendKeys(addrs);
		number.sendKeys(Mobnumber);
		saveBtn.click();
		WebElement savedUserName = driver.findElement(By.xpath("//i[@class='large user red icon']/parent::div[text()='"+fname+" "+lname+"']"));
		return savedUserName.isDisplayed();
	}

}
