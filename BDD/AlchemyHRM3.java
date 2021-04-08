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

public class AlchemyHRM3 {
	WebDriver driver;
	WebDriverWait wait;
	
	@Given("^User open OrangeHRM and login for HRM3$")
	public void OrangeHRM3_login() throws Throwable {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("txtUsername")).sendKeys("orange");
		driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
		driver.findElement(By.id("btnLogin")).click();
		
	}
	@When("^user navigate to PIM option and Click Add$")
	public void navigate_PIM() throws Throwable{
		Thread.sleep(3000);
		driver.findElement(By.linkText("PIM")).click();
		driver.findElement(By.id("btnAdd")).click();	
	}
	
	
	@And("fill \"(.*)\" and \"(.*)\" and check Create Login Details checkbox and fill \"(.*)\" and save$")
	
	public void user_input(String Fname, String Lname, String UserName)throws Throwable {
		
		driver.findElement(By.id("firstName")).sendKeys(Fname);
		driver.findElement(By.id("lastName")).sendKeys(Lname);
		if(driver.findElement(By.id("chkLogin")).isSelected())
		{
			//driver.findElement(By.id("chkLogin")).click();
		}
		else {driver.findElement(By.id("chkLogin")).click();}
		driver.findElement(By.id("user_name")).sendKeys(UserName);
		driver.findElement(By.id("btnSave")).click();

	}
	@Then("^Verify that the employees have been created with \"(.*)\"$") 	
	public void Validate(String Fname) throws Throwable 	{
		Thread.sleep(2000);
		driver.findElement(By.linkText("PIM")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys(Fname);	
		driver.findElement(By.id("searchBtn")).click();
	    String name= driver.findElement(By.xpath("//tbody/tr[1]/td[3]/a")).getText();
	    Assert.assertEquals(Fname, name);
	}
	@And("^Close test browser HRM3$")
    public void close() {
    	driver.close();
    }
}