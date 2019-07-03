package com.crm.qe.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.crm.qe.dataprovider.ReadTestDataFromExcel;
import com.crm.qe.pages.HomePage;
import com.crm.qe.pages.LoginPage;
import com.crm.qe.utils.TestUtils;
import com.crm.qe.utils.WebEventListener;

public class BaseClass {
	public static WebDriver driver;
	public static Properties properties;
	public static HomePage homePage;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public Logger logger;
	
	public BaseClass(){
		
		try{
			properties = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/crm/qe/config/config.properties");
			properties.load(ip);			
		}catch(FileNotFoundException e){
		  e.printStackTrace();	
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}

	public static void initialization(){
		String browserName = properties.getProperty("browser");
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/driver/chromedriver.exe");
			driver = new ChromeDriver();
		}
//		e_driver = new EventFiringWebDriver(driver);
//		eventListener = new WebEventListener();
//		e_driver.register(eventListener);
//		driver = e_driver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(properties.getProperty("url"));
	}
	
}
