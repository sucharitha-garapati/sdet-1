package TestDefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AlchemyJob2 {
	
    WebDriver driver;
	WebDriverWait wait;

	@Given("^User open browser with ​Alchemy Jobs site​ and navigate to Jobs page​$")
	public void Home_Page() throws Throwable {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://alchemy.hguy.co/jobs/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//header/div/div/div/div/div[3]/div/nav/div/ul/li[1]/a")).click();
	}

	@When("^Find the Keywords search input field and Type in keywords to search for jobs and change the Job type$")
		public void search_key() throws Throwable {
		driver.findElement(By.id("search_keywords")).sendKeys("Test Job");
		driver.findElement(By.className("search_submit")).click();
			
			}
	


	public void uncheckifchecked(String chkboxId){
	if(driver.findElement(By.id(chkboxId)).isSelected()){
	driver.findElement(By.id(chkboxId)).click();
	}
	}
	
	@Then("^Find the filter using XPath and filter job type to show only Full Time jobs$")
	public void Filter_details() {
		
		uncheckifchecked("job_type_freelance");
		uncheckifchecked("job_type_internship");
		uncheckifchecked("job_type_part-time");
		uncheckifchecked("job_type_temporary");
				
	}

	
	
	@And("^Find a job listing using XPath and it to see job details and Find the title of the job listing using XPath and print it to the console$") 	
	public void Job_title() throws Throwable 	{
		//driver.findElement(By.linkText("Test Job8")).click();
		driver.findElement(By.partialLinkText("Test Job8")).click();
		//driver.findElement(By.xpath("//ul/li[1]/a/img[contains(@class,'company_logo')]")).click();	
		String title=driver.findElement(By.xpath("//header/div/h1[contains(@class,'entry-title')]")).getText();
	   System.out.println("Job title is "+ title);
	}
	
	@And("^Find and Click on the Apply for job button$") 	
	public void Apply() throws Throwable 	{
		driver.findElement(By.xpath("//div[3]/input")).click();	
	}
	
    @And("^browser close$") 
    public void Close() throws Throwable 	{
    	driver.close();
    }
    
    	}	