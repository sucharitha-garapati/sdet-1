package TestDefination;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class AlchemyJob3 {
	

    WebDriver driver;
	WebDriverWait wait;

	@Given("^open browser and got to ​Alchemy Jobs site​ and navigate to Post a Job page​$")
	public void Home_Page() throws Throwable {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://alchemy.hguy.co/jobs/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("menu-item-26")).click();
	}

	@When("^User enters \"(.*)\" and \"(.*)\" and \"(.*)\" and \"(.*)\" and click Preview and submit$")
	
	public void user_input(String Email, String JobTitle, String Desc, String Comp)throws Throwable {
		
		driver.findElement(By.id("create_account_email")).sendKeys(Email);
		driver.findElement(By.id("job_title")).sendKeys(JobTitle);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("javascript:window.scrollBy(250,450)");
	    
	    //Thread.sleep(10000);
	    driver.switchTo().frame("job_description_ifr");
		driver.findElement(By.id("tinymce")).sendKeys(Desc);
		driver.switchTo().parentFrame(); 
		driver.findElement(By.id("application")).sendKeys(Email);
		driver.findElement(By.id("company_name")).sendKeys(Comp);
	    js.executeScript("javascript:window.scrollBy(250,4000)");

	    driver.findElement(By.xpath("//input[contains(@name, 'submit_job')]")).click();
	    
	    driver.findElement(By.id("job_preview_submit_button")).click();
		}
 
	@Then ("^Go to the Jobs page and Confirm job listing is shown on page \"(.*)\"$")
	public void validation(String JobTitle)throws Throwable{
		driver.findElement(By.xpath("//header/div/div/div/div/div[3]/div/nav/div/ul/li[1]/a")).click();
		driver.findElement(By.id("search_keywords")).sendKeys(JobTitle);
		driver.findElement(By.className("search_submit")).click();
		String jobName=driver.findElement(By.xpath("//article/div/div/ul/li/a/div[1]/h3")).getText();
		Assert.assertEquals(jobName, JobTitle);
	}

}