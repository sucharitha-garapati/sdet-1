package projectHRM;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class Activity8 {
	WebDriver driver;
	@BeforeMethod
	  public void beforeMethod() {
		  driver= new FirefoxDriver();
		  driver.get("http://alchemy.hguy.co/orangehrm");
	  }
  @Test
  public void myEighthExample() throws InterruptedException {
	  	
	  WebElement username=driver.findElement(By.xpath("//input[@id='txtUsername']"));
	  username.sendKeys("orange");
	  WebElement password=driver.findElement(By.xpath("//input[@id='txtPassword']"));
      password.sendKeys("orangepassword123");
      WebElement login=driver.findElement(By.xpath("//input[@id='btnLogin']"));
      login.click();
      WebElement menu=driver.findElement(By.xpath("//a[@id='menu_dashboard_index']/b"));
      menu.click();
      WebElement apply=driver.findElement(By.xpath("//span[text()='Apply Leave']"));
      apply.click();
      Thread.sleep(10000);
      WebElement type=driver.findElement(By.id("applyleave_txtLeaveType"));
      Select leave =new Select(type);
      leave.selectByValue("1");
      WebElement from=driver.findElement(By.xpath("//input[@id='applyleave_txtFromDate']"));
      from.clear();
      from.sendKeys("2021-02-21");
      WebElement to=driver.findElement(By.xpath("//input[@id='applyleave_txtToDate']"));
      from.clear();
      to.sendKeys("2021-02-22");
      WebElement txt=driver.findElement(By.xpath("//textarea[@id='applyleave_txtComment']"));
      txt.sendKeys("Personal reasons");
      WebElement txt1=driver.findElement(By.xpath("//input[@id='applyBtn']"));
      txt1.click();
      WebElement txt2=driver.findElement(By.cssSelector("#menu_leave_viewMyLeaveList"));
      txt2.click();
      WebElement txt3=driver.findElement(By.xpath("//input[@id='calFromDate']"));
      txt3.sendKeys("2021-02-21");
      WebElement txt4=driver.findElement(By.xpath("//input[@id='calToDate']"));
      txt4.sendKeys("2021-02-22");
      WebElement txt5=driver.findElement(By.xpath("//input[@id='btnSearch']"));
      txt5.click();
      
 }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}