package projectHRM;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Activity6 {
	WebDriver driver;
	@BeforeMethod
	  public void beforeMethod() {
		  driver= new FirefoxDriver();
		  driver.get("http://alchemy.hguy.co/orangehrm");
	  }
  @Test
  public void mySixthExample() {
	  WebElement username=driver.findElement(By.xpath("//input[@id='txtUsername']"));
	  username.sendKeys("orange");
	  WebElement password=driver.findElement(By.xpath("//input[@id='txtPassword']"));
      password.sendKeys("orangepassword123");
      WebElement login=driver.findElement(By.xpath("//input[@id='btnLogin']"));
      login.click();
      WebElement dirct=driver.findElement(By.cssSelector("#menu_directory_viewDirectory > b:nth-child(1)"));
      if (dirct.isDisplayed()){
      System.out.println("Element is visible");}
      
      else {
    	  System.out.println("Element is not visible");
      }
      dirct.click();
      WebElement tit=driver.findElement(By.xpath("//html/body/div[1]/div[3]/div[1]/div[1]/h1"));
      String text=tit.getText();
      System.out.println("The title is:"+text);
      Assert.assertEquals(text,"Search Directory");
      WebElement wel= driver.findElement(By.id("welcome"));
      wel.click();
      WebElement log= driver.findElement(By.linkText("Logout"));
      log.click();
}

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
