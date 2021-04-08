package TestDefination;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class AlchemyHRM1 {

    WebDriver driver;
	WebDriverWait wait;
	
	@Given("^User open the OrangeHRM and login$")
	public void OrangeHRM_login() throws Throwable {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("txtUsername")).sendKeys("orange");
		driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
		driver.findElement(By.id("btnLogin")).click();
		
	}

	@When("^user navigate to the Recruitment page and Click on the Vacancies menu item$")
	public void navigate_Vacancies() throws Throwable{
		driver.findElement(By.linkText("Recruitment")).click();
		driver.findElement(By.id("menu_recruitment_viewJobVacancy")).click();	
	}
	@And("^Click on the Add and Fill the necessary details in Add Job Vacancy form and Click Save$")
	public void Add_form_details()throws Throwable{
		driver.findElement(By.id("btnAdd")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Select JobTitle=new Select(driver.findElement(By.id("addJobVacancy_jobTitle")));
		JobTitle.selectByVisibleText("Automation Test Engineer");
		driver.findElement(By.id("addJobVacancy_name")).sendKeys("QA Job6");
		driver.findElement(By.id("addJobVacancy_hiringManager")).sendKeys("Test mia");
		driver.findElement(By.id("btnSave")).click();
	}
  
	@Then("^Verify that the vacancy was created$")
	public void verify_new_vacancy()throws Throwable{
		
	driver.findElement(By.id("menu_recruitment_viewJobVacancy")).click();	
	
	
    Thread.sleep(5000);
	Select NewJob=new Select(driver.findElement(By.id("vacancySearch_jobVacancy")));
	NewJob.selectByVisibleText("QA Job6");
	driver.findElement(By.id("btnSrch")).click();	
    String jobN= driver.findElement(By.xpath("//tbody/tr/td[2]/a")).getText();
    Assert.assertEquals(jobN, "QA Job6");
	}
	
    @And("^Close test browser$")
    public void close() {
    	driver.close();
    }
}