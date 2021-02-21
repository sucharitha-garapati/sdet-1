package projectHRM;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Activity4 {
	WebDriver driver;
	 @BeforeMethod
	  public void beforeMethod() {
		  driver=new FirefoxDriver();
		  driver.get("http://alchemy.hguy.co/orangehrm");
	  }
	
	  @Test
	  public void myFourthExample() {
		  WebElement username=driver.findElement(By.xpath("//input[@id='txtUsername']"));
		  username.sendKeys("orange");
		  WebElement s=driver.findElement(By.xpath("//input[@id='txtPassword']"));
	      s.sendKeys("orangepassword123");
	      WebElement login=driver.findElement(By.xpath("//input[@id='btnLogin']"));
	      login.click();
	      String title = driver.getTitle();
	      System.out.println("The title is:"+title);
	      Assert.assertEquals("OrangeHRM",title);
	      WebElement pim=driver.findElement(By.cssSelector("#menu_pim_viewPimModule > b:nth-child(1)"));
	      pim.click();
	      WebElement add=driver.findElement(By.id("btnAdd"));
	      add.click();
	      WebElement first=driver.findElement(By.id("firstName"));
	      first.sendKeys("Garapati");
	      WebElement last=driver.findElement(By.id("lastName"));
	      last.sendKeys("Suchi");
	      WebElement save= driver.findElement(By.id("btnSave"));
	      save.click();
	      WebElement pim1=driver.findElement(By.id("menu_pim_viewEmployeeList"));
	      pim1.click();
	      WebElement search=driver.findElement(By.id("empsearch_employee_name_empName"));
	      search.sendKeys("Garapati Suchi");
	      WebElement botton=driver.findElement(By.id("searchBtn"));
	      botton.click();
	      WebElement check= driver.findElement(By.id("ohrmList_chkSelectRecord_2316"));
	      if(check.isEnabled()) {
	    	  System.out.println("Employee Added is:"+check.isEnabled());
	    	  }
	      else {
	    		  System.out.println("Employee not Added:"+check.isEnabled());
	      }
	  }
	    	  
	  @AfterMethod
	  public void afterMethod() {
		  driver.close();
	  }

	}
