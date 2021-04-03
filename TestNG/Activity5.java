package testNGTests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity5 {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/target-practice");
	}

	@Test (groups = {"HeaderTests"})
	public void headertestcase1() {
		String h3 = driver.findElement(By.id("third-header")).getText();
		Assert.assertEquals("Third header", h3);
	}
	
	@Test (groups = {"HeaderTests"})
	public void headertestcase2() {
		WebElement h5 = driver.findElement(By.cssSelector("h5.ui"));
		Assert.assertEquals(h5.getCssValue("color"), "rgb(33, 186, 69)");		
	}
	
	@Test (groups = {"ButtonTests"})
	public void buttontestcase1() {
		String b1 = driver.findElement(By.xpath("//div[2]/div[1]/button[4]")).getText();
		Assert.assertEquals("Olive", b1);		
	}
	
	@Test (groups = {"ButtonTests"})
	public void buttontestcase2() {
		WebElement b2 = driver.findElement(By.xpath("//div/div[2]/div[3]/button[1]"));
		Assert.assertEquals(b2.getCssValue("color"), "rgb(255, 255, 255)");
	}
	
	@AfterClass
	public void afterClass() {
		driver.close();
	}
}