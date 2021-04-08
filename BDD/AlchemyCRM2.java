package TestDefination;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class AlchemyCRM2 {
	WebDriver driver;
	WebDriverWait wait;
	
	@Given("^User open the CRM2 site and login$")
	public void CRM2_login() throws Throwable {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://alchemy.hguy.co/crm/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
		driver.findElement(By.id("bigbutton")).click();
		
	}
	@When("^user navigate Sales -> Leads -> Create Lead$")
	public void navigate_Vacancies() throws Throwable{
		Thread.sleep(2000);
		driver.findElement(By.id("grouptab_0")).click();
		driver.findElement(By.id("moduleTab_9_Leads")).click();	
		driver.findElement(By.className("actionmenulink")).click();	
	}
	//fill "<FName>" and "<LName>" and save
   @And("fill \"(.*)\" and \"(.*)\" and save$")
	
	public void user_input(String FName, String LName)throws Throwable {
	   Thread.sleep(2000);
		driver.findElement(By.id("first_name")).sendKeys(FName);
		driver.findElement(By.id("last_name")).sendKeys(LName);
		
		driver.findElement(By.id("SAVE")).click();

	} 
   //Navigate to the View Leads page to see "<FName>" result
   @Then("^Navigate to the View Leads page to see \"(.*)\" and \"(.*)\" result$") 	
	public void Validate_new(String FName,String LName) throws Throwable 	{
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//ul/li[3]/a/div[2]")).click();
		driver.findElement(By.partialLinkText("View Leads")).click();
		Thread.sleep(2000);
        String newName= driver.findElement(By.xpath("//tbody/tr[1]/td[3]/b/a")).getText();
        Assert.assertEquals(FName+" "+ LName, newName);
		
       

  }
	@And("^Close CRM2 browser$")
   public void close_CRM2() {
   	driver.close();
   }

}