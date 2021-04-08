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



public class AlchemyHRM4 {

    WebDriver driver;
	WebDriverWait wait;
	
	@Given("^User open the OrangeHRM4 and login$")
	public void OrangeHRM4_login() throws Throwable {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("txtUsername")).sendKeys("orange");
		driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
		driver.findElement(By.id("btnLogin")).click();
		
	}

	@When("^user navigate to the Recruitment page and Click on the Vacancies$")
	public void navigate_Vacancies4() throws Throwable{
		Thread.sleep(2000);
		driver.findElement(By.linkText("Recruitment")).click();
		driver.findElement(By.id("menu_recruitment_viewJobVacancy")).click();	
	}
	//Click Add and Fill "<JobTitle>" and "<VName>" and "<Hmanager>" and Click Save
	@And("^Click Add and Fill \"(.*)\" and \"(.*)\" and \"(.*)\" and Click Save$")
	public void Add_form_details(String JobTitle, String VName, String Hmanager)throws Throwable{
		driver.findElement(By.id("btnAdd")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Select Jobtitle=new Select(driver.findElement(By.id("addJobVacancy_jobTitle")));
		Jobtitle.selectByVisibleText(JobTitle);
		driver.findElement(By.id("addJobVacancy_name")).sendKeys(VName);
		driver.findElement(By.id("addJobVacancy_hiringManager")).sendKeys(Hmanager);
		driver.findElement(By.id("btnSave")).click();
	}
  //Verify that the vacancy was created "<VName>"
	@Then("^Verify that the vacancy was created \"(.*)\"$")
	public void verify_new_vacancy(String VName)throws Throwable{
		
	driver.findElement(By.id("menu_recruitment_viewJobVacancy")).click();	
	
	
    Thread.sleep(5000);
	Select NewJob=new Select(driver.findElement(By.id("vacancySearch_jobVacancy")));
	NewJob.selectByVisibleText(VName);
	driver.findElement(By.id("btnSrch")).click();	
    String jobN= driver.findElement(By.xpath("//tbody/tr/td[2]/a")).getText();
    Assert.assertEquals(jobN, VName);
	}
	
    @And("^Close HRM4 browser$")
    public void close4() {
    	driver.close();
    }
}