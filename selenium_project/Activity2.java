package projectHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity2 {
	WebDriver driver;
	@BeforeMethod
	public void beforeMethod() {
		driver = new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/orangehrm");
	}
	@Test
	public void mySecondexample() {
		WebElement URL = driver.findElement(By.id("divLogo/src"));
		System.out.println("URL is:" + URL);
		
	}
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
