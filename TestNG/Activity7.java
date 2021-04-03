package testNGTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity7 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void beforeClass() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);
        
        //Open browser
        driver.get("https://www.training-support.net/selenium/login-form");
    }
    
    @DataProvider(name = "Authentication")
    public static Object[][] credentials() {
        return new Object[][] { { "admin", "password" } ,{ "admin", "password" }};
    }
    
    @Test (dataProvider = "Authentication")
    public void loginTestCase(String user123, String pwd123) {
        //Find user123 and pwd123 fields
        WebElement usernameField = driver.findElement(By.id("user123"));
        WebElement passwordField = driver.findElement(By.id("pwd123"));
        
        usernameField.clear();
        passwordField.clear();
        //Enter values
        usernameField.sendKeys(user123);
        passwordField.sendKeys(pwd123);
        
        //Click Log in
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        
        //Assert Message
        String login = driver.findElement(By.id("action-confirmation")).getText();
        Assert.assertEquals(login, "Welcome Back, admin");
    }

    @AfterTest
    public void afterClass() {
        //Close browser
        driver.close();
    }

}
