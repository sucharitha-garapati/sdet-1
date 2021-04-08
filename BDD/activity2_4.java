package TestDefination;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class activity2_4 {	
    WebDriver driver;	
    WebDriverWait wait;
    
    @Given("^User on Login page$")
	
    public void loginPage() {

    	driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);
        driver.get("https://www.training-support.net/selenium/login-form");
    }
	
    @When("^User enters username and password$")
	
    public void enter_Credentials() {
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");

        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
    @When("^User enters \"(.*)\" and \"(.*)\"$")
	
    public void user_enters_and(String username, String password) throws Throwable {
	
        //Enter username from Feature file
	
        driver.findElement(By.id("username")).sendKeys(username);
	
        //Enter password from Feature file
	
        driver.findElement(By.id("password")).sendKeys(password);
	
        //Click Login
	
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
 
    @Then("^Read the page title and message$")
	
    public void readTitle_Heading() {
	
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("action-confirmation")));
    
        //Read the page title and heading
        String pageTitle = driver.getTitle();
        String confirmMessage = driver.findElement(By.id("action-confirmation")).getText();
     
        //Print the page title and heading
	
        System.out.println("Page title is: " + pageTitle);
	
        System.out.println("Login message is: " + confirmMessage);
        //Assertion
	
        Assert.assertEquals(confirmMessage, "Welcome Back, admin");
    }
   
    @And("^Close the Browser$")
	
    public void closeBrowser() {
	
        //Close browser
	
        driver.close();
	
    }

}