package projectHRM;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class Activity9 {
	WebDriver driver;
	@BeforeMethod
	  public void beforeMethod() {
		  driver= new FirefoxDriver();
		  driver.get("http://alchemy.hguy.co/orangehrm");
		  }
  @Test
  public void myNinthExample() {
	  WebElement username=driver.findElement(By.xpath("//input[@id='txtUsername']"));
	  username.sendKeys("orange");
	  WebElement password=driver.findElement(By.xpath("//input[@id='txtPassword']"));
      password.sendKeys("orangepassword123");
      WebElement login=driver.findElement(By.xpath("//input[@id='btnLogin']"));
      login.click();
      WebElement det=driver.findElement(By.cssSelector("#menu_pim_viewMyDetails > b:nth-child(1)"));
      det.click();
      WebElement emg=driver.findElement(By.linkText("Emergency Contacts"));
      emg.click();
      int rows=driver.findElements(By.xpath("//html/body/div[1]/div[3]/div/div[3]/div[2]/form/table/thead/tr")).size();
      int columns=driver.findElements(By.xpath("//html/body/div[1]/div[3]/div/div[3]/div[2]/form/table/thead/tr[1]/th")).size();
      int rows1=driver.findElements(By.xpath("//html/body/div[1]/div[3]/div/div[3]/div[2]/form/table/tbody/tr")).size();
      System.out.println("The no of columns:"+columns);
      System.out.println("The no of rows:"+ rows);
      System.out.println("The no of rows:"+ rows1);
      for (int i=1; i<=rows1; i++)
         for( int t=1; t<=columns; t++)
        	 System.out.println(driver.findElement(By.xpath("//html/body/div[1]/div[3]/div/div[3]/div[2]/form/table[@id='emgcontact_list']/tbody/tr[" + i +"]/td[" + t + "]")).getText() + "\t");
     for (int k=1; k<=rows; k++)
     	 System.out.println(driver.findElement(By.xpath("//html/body/div[1]/div[3]/div/div[3]/div[2]/form/table[@id='emgcontact_list']/thead/tr[" + k +"]")).getText() + "\t");
  }
  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}