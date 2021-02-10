package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/simple-form");
		String pagetitle = driver.getTitle();
		System.out.println("page title is:" + pagetitle);
		driver.findElement(By.id("firstName")).sendKeys("sucharitha");
		driver.findElement(By.id("lastName")).sendKeys("Garapati");
		driver.findElement(By.id("email")).sendKeys("garapatisuchi1111@gmail.com");
		driver.findElement(By.id("number")).sendKeys("9010321425");
		driver.findElement(By.cssSelector(".ui.green.button")).click();
		//System.out.println("text is:" + button.getText());
		Thread.sleep(1000);
		driver.close();
	}

}
