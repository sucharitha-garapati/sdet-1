package testNGTests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;

public class Activity2 {

	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/target-practice");
	}

	@Test
	public void title() {
		String t = driver.getTitle();
		System.out.println("page title: "+t);
	}
	
	@Test
	public void black() {
		WebElement blackButton = driver.findElement(By.xpath("//div[2]/div[3]/button[3]"));
		Assert.assertFalse(blackButton.isDisplayed());
	}
	
	@Test(enabled = false)
	public void skip() {
		System.out.println("Skipping");
	}
	
	@Test
	public void skipWithExcep() {
		
		throw new SkipException("Skip and Throwing Error");
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}


}
