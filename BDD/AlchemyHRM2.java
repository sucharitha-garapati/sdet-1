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

public class AlchemyHRM2 {
	WebDriver driver;
	WebDriverWait wait;
	
	@Given("^User open OrangeHRM and login for HRM2$")
	public void OrangeHRM2_login() throws Throwable {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("txtUsername")).sendKeys("orange");
		driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
		driver.findElement(By.id("btnLogin")).click();
		
	}

	@When("^user navigate to the Recruitment page and Click on Add$")
	public void navigate_Vacancies() throws Throwable{
		Thread.sleep(3000);
		driver.findElement(By.linkText("Recruitment")).click();
		driver.findElement(By.id("btnAdd")).click();	
	}
	@And("^fill in the details of the candidate and Upload a resume and save$")
	public void Add_form_details()throws Throwable{
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("addCandidate_firstName")).sendKeys("Durga");
		driver.findElement(By.id("addCandidate_lastName")).sendKeys("Kundu");
		driver.findElement(By.id("addCandidate_email")).sendKeys("testdurga@gmail.com");
		Select JobV=new Select(driver.findElement(By.id("addCandidate_vacancy")));
		JobV.selectByVisibleText("Automation Test Engineer");
		driver.findElement(By.id("addCandidate_resume")).sendKeys("C:\\Users\\DurgaKundu\\eclipse-workspace\\Cucumber_Project\\Test resume.docx");
		
		
		
		driver.findElement(By.id("btnSave")).click();
	}
	@Then("^Navigate back to the Recruitments page to confirm candidate entry$")
	public void verify_new_candidate()throws Throwable{
		
	driver.findElement(By.id("menu_recruitment_viewRecruitmentModule")).click();	
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	Select Job=new Select(driver.findElement(By.id("candidateSearch_jobTitle")));
	Job.selectByVisibleText("Automation Test Engineer");
	driver.findElement(By.id("candidateSearch_candidateName")).sendKeys("Durga Kundu");
	driver.findElement(By.id("btnSrch")).click();	
    String CandidateN= driver.findElement(By.xpath("//tbody/tr[1]/td[3]/a")).getText();
    Assert.assertEquals(CandidateN, "Durga Kundu");
	}
	
	
	@And("^Close test browser HRM2$")
    public void close() {
    	driver.close();
    }
	
}