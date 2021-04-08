package TestDefination;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AlchemyJob1 {
	
    WebDriver driver;
	WebDriverWait wait;
    
	@Given("^User open the browser and Navigate to url​$")
	public void user_is_on_Home_Page() throws Throwable {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://alchemy.hguy.co/jobs/wp-admin/");
	}

	@When("^log in and Locate the left hand menu and click the menu item that says Users$")
		public void user_log_in() throws Throwable {
		driver.findElement(By.id("user_login")).sendKeys("root");
		driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
		driver.findElement(By.id("wp-submit")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.findElement(By.className("menu-icon-users")).click();
	}
	@And("^Locate the Add New button and click it and Fill in the necessary details and  Click the New User button$")
	
	public void user_add_details() throws Throwable {
		
		driver.findElement(By.className("page-title-action")).click();
		driver.findElement(By.id("user_login")).sendKeys("DurgaK");
		driver.findElement(By.id("email")).sendKeys("testingdurga15@gmail.com");
		driver.findElement(By.id("first_name")).sendKeys("Durga");
		driver.findElement(By.id("last_name")).sendKeys("Kundu");

		 JavascriptExecutor js = (JavascriptExecutor) driver;
	      js.executeScript("javascript:window.scrollBy(250,350)");
	      Thread.sleep(10000);
		  WebElement AddNew=driver.findElement(By.id("createusersub"));
		  AddNew.click();

	}

	@Then("^Verify that the user was created$") 	
	public void Validate() throws Throwable 	{
		driver.findElement(By.id("user-search-input")).sendKeys("DurgaK");	
		driver.findElement(By.id("search-submit")).click();
	    String name= driver.findElement(By.xpath("//tbody//tr//td[contains(@class,'column-name')]")).getText();
	    Assert.assertEquals("Durga Kundu", name);
	
	}
	
    @And("^Close the browser$") 
    public void Close() throws Throwable 	{
    	driver.close();
    }
    
    	}	