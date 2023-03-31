package stepDefinition;

import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

public class loginDef {
	
	WebDriver driver;
	
	public String url = "https://global.hitachi-solutions.com/";
	
	HomePage home_obj;

	@Given("I navigate to Hitachi Homepage")
	public void i_navigate_to_login_page() {

	    WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		home_obj = new HomePage(driver);

	}

	@When("I search for {string}")
	public void i_searchforfield(String search) {
		home_obj.clicksearchkeyword(search);
	}

	@Then("I view {string} result page")
	public void i_searchresult(String search) {
		home_obj.validatesearchresults(search);
	}
	
	@After
	public void after_test() {
		driver.quit();
	}
}
