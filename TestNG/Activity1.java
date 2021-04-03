package testNGTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity1 {
	WebDriver driver;

	@BeforeMethod
	public void beforeClass() {

		driver = new FirefoxDriver();
		driver.get("https://www.training-support.net");
	}

	@Test
	public void TestActivity1() {

		String t = driver.getTitle();
		System.out.println("Title of the page: "+t);
		Assert.assertEquals("Training Support", t);
		driver.findElement(By.xpath("//*[@id=\"about-link\"]")).click();
		String nt = driver.getTitle();
		System.out.println("Title of the new page: "+nt);
		Assert.assertEquals("About the Training Support", t);
	}

	@AfterMethod
	public void afterClass() {
		driver.close();
	}

}