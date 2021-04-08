package TestDefination;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AlchemyCRM4 {
	WebDriver driver;
	WebDriverWait wait;
	
	@Given("^User open the CRM4 site and login$")
	public void CRM4_login() throws Throwable {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://alchemy.hguy.co/crm/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
		driver.findElement(By.id("bigbutton")).click();
		
	}
	
	@When("^user navigate All -> Products-> Create Product$")
	public void navigate_Meeting() throws Throwable{
		Thread.sleep(2000);
		driver.findElement(By.id("grouptab_5")).click();
		driver.findElement(By.partialLinkText("Products")).click();
		driver.findElement(By.partialLinkText("Create Product")).click();	
	}
//     And Enter the details "<PName>" and "<Price>" and "<Desc>" and save
  
	 @And("^Enter the details \"(.*)\" and \"(.*)\" and \"(.*)\" and save$") 	
		public void Validate_Pnew(String PName,String Price, String Desc) throws Throwable 	{
			Thread.sleep(2000);
			
			driver.findElement(By.id("name")).sendKeys(PName);
			driver.findElement(By.id("price")).sendKeys(Price);
			driver.findElement(By.id("description")).sendKeys(Desc);
			JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("javascript:window.scrollBy(250,1050)");
		    driver.findElement(By.id("SAVE")).click();
	       Thread.sleep(2000);

	  }
	 //Then Navigate to  “View Products” page to see all products listed 
	 @Then("^Navigate to View Products page to see all products \"(.*)\" listed$") 	
		public void Validate_Prod(String PName) throws Throwable 	{
			
			driver.findElement(By.partialLinkText("View Products")).click();
			Thread.sleep(2000);
	        String ProductN= driver.findElement(By.xpath("//tbody/tr[1]/td[3]/b/a")).getText();
	        Assert.assertEquals(ProductN, PName);
	 }
	 @And("^Close CRM4 browser$")
	    public void close_CRM4() {
	    	driver.close();
	    }    	 
}