package projectHRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity1 {
		WebDriver driver;
		@BeforeMethod
		public void beforeMethod() {
			driver = new FirefoxDriver();
			driver.get("http://alchemy.hguy.co/orangehrm");
		}
		@Test
		public void myFirstExample() {
			String title = driver.getTitle();
			System.out.println("Title is:" + title);
			Assert.assertEquals("OrangeHRM", title);
		}
		@AfterMethod
		public void afterMethod() {
			driver.quit();
		}
	
	}


