package TestDefination;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class AlchemyCRM1 {
	 WebDriver driver;
		WebDriverWait wait;
		
		@Given("^User open the CRM site and login$")
		public void CRM1_login() throws Throwable {
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.get("https://alchemy.hguy.co/crm/");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.findElement(By.id("user_name")).sendKeys("admin");
			driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
			driver.findElement(By.id("bigbutton")).click();
			
		}
		@When("^Count the number of Dashlets on the homepage and Print the number and title$")
		public void navigate_Vacancies() throws Throwable{
			Thread.sleep(3000);
			List<WebElement> Dashlets=driver.findElements(By.xpath("//tbody/tr/td[1]/ul/li[contains(@id,'dashlet')]//h3/span[2]"));
			int count=Dashlets.size();
			System.out.println("The number of Dashlets on the homepage is " +count);
			for (WebElement webElement : Dashlets) {
	            String name = webElement.getText();
	            System.out.println("The title of the Dashlet is: " +name);
	        }
			
			
		}
		@And("^Close CRM browser$")
	    public void close_CRM() {
	    	driver.close();
	    	}

}