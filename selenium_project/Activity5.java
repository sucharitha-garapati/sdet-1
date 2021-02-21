package projectHRM;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class Activity5 {
	WebDriver driver;
	@BeforeMethod
	  public void beforeMethod() {
		 driver=new FirefoxDriver();
		 driver.get("http://alchemy.hguy.co/orangehrm");
	}
  @Test
  public void myFifthExample() {
	  WebElement username=driver.findElement(By.xpath("//input[@id='txtUsername']"));
	  username.sendKeys("orange");
	  WebElement password=driver.findElement(By.xpath("//input[@id='txtPassword']"));
      password.sendKeys("orangepassword123");
      WebElement login=driver.findElement(By.xpath("//input[@id='btnLogin']"));
      login.click();
	  WebElement pim=driver.findElement(By.cssSelector("#menu_pim_viewMyDetails > b:nth-child(1)"));
      pim.click();
      WebElement save= driver.findElement(By.id("btnSave"));
      save.click();
      WebElement first=driver.findElement(By.id("personal_txtEmpFirstName"));
      first.clear();
      first.sendKeys("Garapati");
      WebElement middle=driver.findElement(By.id("personal_txtEmpMiddleName"));
      middle.clear();
      WebElement last=driver.findElement(By.id("personal_txtEmpLastName"));
      last.clear();
      last.sendKeys("Suchi");
      WebElement dob=driver.findElement(By.id("personal_DOB"));
      dob.clear();
      dob.sendKeys("1997-11-09");
      WebElement gender= driver.findElement(By.id("personal_optGender_2"));
      gender.click();
      Select select = new Select(driver.findElement(By.id("personal_cmbNation")));
      select.selectByValue("82");
      save.click();
      WebElement text= driver.findElement(By.id("welcome"));
      text.click();
      WebElement log= driver.findElement(By.linkText("Logout"));
      log.click();
}

  @AfterMethod
  public void afterMethod() {
  driver.close();
  }
  

}
