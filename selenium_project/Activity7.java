package projectHRM;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class Activity7 {
	WebDriver driver;
	@BeforeMethod
	  public void beforeMethod() {
		  driver= new FirefoxDriver();
		  driver.get("http://alchemy.hguy.co/orangehrm");
	  }
  @Test
  public void mySeventhExample() {
	  WebElement username=driver.findElement(By.xpath("//input[@id='txtUsername']"));
	  username.sendKeys("orange");
	  WebElement password=driver.findElement(By.xpath("//input[@id='txtPassword']"));
      password.sendKeys("orangepassword123");
      WebElement login=driver.findElement(By.xpath("//input[@id='btnLogin']"));
      login.click();
      WebElement det=driver.findElement(By.cssSelector("#menu_pim_viewMyDetails > b:nth-child(1)"));
      det.click();
      WebElement qual=driver.findElement(By.linkText("Qualifications"));
      qual.click();
      WebElement exp=driver.findElement(By.xpath("//input[@id='addWorkExperience']"));
      exp.click();
      WebElement emp=driver.findElement(By.xpath("//input[@id='experience_employer']"));
      emp.sendKeys("IBM");
      WebElement job=driver.findElement(By.xpath("//input[@id='experience_jobtitle']"));
      job.sendKeys("Associate System Engineer");
      WebElement date=driver.findElement(By.xpath("//input[@id='experience_from_date']"));
      date.clear();
      date.sendKeys("2019-08-29");
      WebElement date1=driver.findElement(By.xpath("//input[@id='experience_to_date']"));
      date1.clear();
      date1.sendKeys("2021-02-21");
      WebElement area=driver.findElement(By.xpath("//textarea[@id='experience_comments']"));
      area.sendKeys("Selenium is good");
      WebElement wrk=driver.findElement(By.xpath("//input[@id='btnWorkExpSave']"));
      wrk.click();
      }
 
  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
