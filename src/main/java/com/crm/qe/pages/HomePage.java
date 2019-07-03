package com.crm.qe.pages;

import io.qameta.allure.Step;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qe.base.BaseClass;

public class HomePage extends BaseClass {
	
	@FindBy(xpath="//div[@class='right menu']/span[@class='user-display']")
	@CacheLookup
	WebElement UserNameLabel;
	
	@FindBy(xpath="//span[contains(text(),'Contactsserv')]")
	WebElement contactLink;
	
	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//span[contains(text(),'Tasks')]")
	WebElement taskLink;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	@Step("Getting Home Page Title step")
	public String getHomePageTitle(){
		return driver.getTitle();
	}
	
	@Step("Clicking on Contact link step")
	public ContactsPage clickOnContactsLink(){
		contactLink.click();
		return new ContactsPage();
	}
	public DealsPage clickOnDealsLink(){
		dealsLink.click();
		return new DealsPage();
	}
	public TasksPage clickOnTasksLink(){
		taskLink.click();
		return new TasksPage();
	}
	

}
