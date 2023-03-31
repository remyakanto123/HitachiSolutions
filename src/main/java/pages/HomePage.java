package pages;

import net.jodah.failsafe.internal.util.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HomePage {

	private WebDriver driver;

	@FindBy(id = "open-global-search")
	private WebElement searchbutton;

	@FindBy(id = "site-search-keyword")
	private WebElement searchfield;

	@FindBy(xpath = "//span[@class='breadcrumb_last']")
	private WebElement searchresults;


	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clicksearchkeyword(String search){
		WebDriverWait wait=new WebDriverWait(driver,20);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("open-global-search")));
		searchbutton.click();
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("site-search-keyword")));
		element.sendKeys(search);
		element.sendKeys(Keys.ENTER);
		WebElement searchelement =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='"+search+"']")));
		searchelement.click();
	}

	public void validatesearchresults(String search){
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='breadcrumb_last']")));
		Assert.isTrue(searchresults.getText().equals(search),"Page is not displayed with expected search results");
	}
}
