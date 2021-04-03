package testNGTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity6 {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/login-form");
	}

	@Test
	@Parameters({"user123", "pwd123"})
	public void login(String user123, String pwd123) {
		driver.findElement(By.id("username")).sendKeys(user123);
		driver.findElement(By.id("password")).sendKeys(pwd123);
		driver.findElement(By.cssSelector("button[type='submit']")).click();
	}
	
	@AfterClass
	public void afterClass() {
		driver.close();
	}
}


