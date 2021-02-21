package projectHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity3 {
	WebDriver driver;
	WebDriverWait wait;
	@BeforeMethod
	public void beforeMethod() {
		driver = new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/orangehrm");
	}
	@Test
	public void myThirdExample() {
		WebElement username = driver.findElement(By.id("txtUsername"));
		WebElement password = driver.findElement(By.id("txtPassword"));
		username.sendKeys("orange");
		password.sendKeys("orangepassword123");
		//wait.until(ExpectedConditions.visibilityOf(button));
		WebElement button = driver.findElement(By.id("btnLogin"));
		//wait.until(ExpectedConditions.visibilityOf(button));
		button.click();
		String newTitle = driver.getTitle();
		System.out.println("new title:" +newTitle);
		//wait.until(ExpectedConditions.visibilityOf(button));
	}
	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

}
