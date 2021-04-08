package TestDefination;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AlchemyCRM3 {

	WebDriver driver;
	WebDriverWait wait;
	
	@Given("^User open the CRM3 site and login$")
	public void CRM3_login() throws Throwable {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://alchemy.hguy.co/crm/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
		driver.findElement(By.id("bigbutton")).click();
		
	}
	
	@When("^user navigate Activities -> Meetings -> Schedule a Meeting$")
	public void navigate_Meeting() throws Throwable{
		Thread.sleep(2000);
		driver.findElement(By.id("grouptab_3")).click();
		driver.findElement(By.id("moduleTab_9_Meetings")).click();	
		driver.findElement(By.className("actionmenulink")).click();	
	}
    //And Enter the details of the meeting
    @And("^Enter the details of the meeting$")
	public void Meeting_fill() throws Throwable{
		Thread.sleep(2000);
		driver.findElement(By.id("name")).sendKeys("Daily Standup CRM3");
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("javascript:window.scrollBy(250,1050)");
		
    }
 
    @And("^Search FName and LName and add them$")
    public void methodName(DataTable FullName) throws Throwable {
        // Use this to convert the DataTable to convert it to a List of lists
        List<List<String>> names = FullName.asLists(null);
        // Print it out to see what the list looks like
        System.out.println(names);
        for (int i = 0; i < names.size(); i++ ) {
            for (int j = 0; j < 2; j++) {
               //System.out.println(names.get(i).get(j));
               
               driver.findElement(By.id("search_first_name")).clear();
               driver.findElement(By.id("search_last_name")).clear();
            	driver.findElement(By.id("search_first_name")).sendKeys(names.get(i).get(j));
            	driver.findElement(By.id("search_last_name")).sendKeys(names.get(i).get(++j));
            	driver.findElement(By.id("invitees_search")).click();
        		Thread.sleep(2000);
            	driver.findElement(By.id("invitees_add_1")).click();
        		
            }
           }
        
    }
       //Then Save and Navigate to View Meetings page and confirm creation of the meeting

    @Then("^Save and Navigate to View Meetings page and confirm creation of the meeting$") 	
	public void Validate_meeting() throws Throwable 	{
		
    	driver.findElement(By.id("SAVE_HEADER")).click();
    	Thread.sleep(2000);
		driver.findElement(By.partialLinkText("View Meetings")).click();
		Thread.sleep(2000);
        
		String meetingName= driver.findElement(By.xpath("//tbody/tr[1]/td[4]/b/a")).getText();
        Assert.assertEquals(meetingName,"Daily Standup CRM3");
	   
  }
    @And("^Close CRM3 browser$")
    public void close_CRM3() {
    	driver.close();
    }    	
}