package com.crm.qe.pages;

import io.qameta.allure.Step;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qe.base.BaseClass;

public class LoginPage extends BaseClass {

	
	//pageFactory - OR
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[text()='Login']")
	WebElement loginButton;
	
	//initializing the page objects
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	//Actions
	@Step("Getting Login Page title step")
	public String getLoginPageTitle(){
		return driver.getTitle();
	}
	
	@Step("Login with username {0} and password {1} step")
	public HomePage login(String user,String pass){
		username.sendKeys(user);
		password.sendKeys(pass);
		loginButton.click();
		return new HomePage();
	}
}
