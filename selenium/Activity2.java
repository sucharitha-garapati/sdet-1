package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net");
		String pagetitle = driver.getTitle();
		System.out.println("title is" +pagetitle);
		WebElement locator = driver.findElement(By.id("about-link"));
		System.out.println("webelemnt is" +locator.getText());
		driver.close();
	}

}
