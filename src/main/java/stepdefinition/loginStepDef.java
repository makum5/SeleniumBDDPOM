package stepdefinition;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.qe.base.BaseClass;
import com.crm.qe.pages.HomePage;
import com.crm.qe.pages.LoginPage;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class loginStepDef extends BaseClass {

	/**
	 * Without POM **********************************
	 */
	//WebDriver driver;
	
//	@Before
//	public void setup(){
//		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/driver/chromedriver.exe");
//	     driver =  new ChromeDriver();
//	     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//	     driver.manage().window().maximize();
//	}
//	@After
//	public void tearDown(){
//		driver.quit();
//	}
	
	//@Before(), @After() ----> Global Hooks
	// @Before("@tagname") @After("@tagname") ----> local to @tagname
	// Ordering of hooks @Before(order=0) @After(order=0)
/**
 * ****************************************************
 */
	
/**
 * With POM********************************	
 */
	
	LoginPage loginpage;
	HomePage homePage;
	@Given("^user is already on login page$")
	public void user_is_already_on_login_page() {
     BaseClass.initialization();
	}

	@When("^title of login page is CRM$")
	public void title_of_login_page_is_CRM() {
		loginpage = new LoginPage();
		String title = loginpage.getLoginPageTitle();
		Assert.assertEquals("CRM", title);
	}

	@Then("^user enters \"(.*)\" and \"(.*)\"$")
	public void user_enters_username_and_password(String username,String password) {
//		driver.findElement(By.name("email")).sendKeys(username);
//		driver.findElement(By.name("password")).sendKeys(password);
		
		homePage = loginpage.login(username, password);

	}

	@Then("^user clicks on login button$")
	public void user_clicks_on_login_button() {
		//driver.findElement(By.xpath("//div[text()='Login']")).click();

	}

	@Then("^user redirected to home page$")
	public void user_redirected_to_home_page() {
		System.out.println("Home Page Title: "+ homePage.getHomePageTitle());
		Assert.assertEquals("CRM", homePage.getHomePageTitle());

	}
	@Then("^close the browser$")
	public void close_the_browser() {
	    driver.quit();
	}
//	@Then("^user enters username and password$")
//	public void user_enters_username_and_password(DataTable credentials) {
//	List<List<String>> data = credentials.raw();
//	driver.findElement(By.name("email")).sendKeys(data.get(0).get(0));
//	driver.findElement(By.name("password")).sendKeys(data.get(0).get(1));
//	}
	
	@Then("^user enters username and password$")
	public void user_enters_username_and_password(DataTable credentials) {
	for(Map<String,String> data : credentials.asMaps(String.class, String.class)){
		driver.findElement(By.name("email")).sendKeys(data.get("username"));
		driver.findElement(By.name("password")).sendKeys(data.get("password"));
	}	
	}
}
