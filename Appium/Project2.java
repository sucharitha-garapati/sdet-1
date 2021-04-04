package appium_Project;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Project2 {

	AppiumDriver<MobileElement> driver = null;
    WebDriverWait wait; 

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel 4 API 28");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.keep");
        caps.setCapability("appActivity", ".activities.BrowseActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver, 100);
    }
    @AfterClass
    public void afterClass() {
        driver.quit();
}
    
    @Test
    public void addText() throws Throwable {
    	Thread.sleep(10000);
    	driver.findElementById("new_note_button").click();
    	Thread.sleep(5000);
    	wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("editable_title")));
    	
    	//adding title
    	driver.findElementById("editable_title").sendKeys("First Task");
    	//adding note description
    	Thread.sleep(5000);
    	driver.findElementById("edit_note_text").sendKeys("Task added into Google Keep app");
    	driver.findElementByClassName("android.widget.ImageButton").click();
    	Thread.sleep(5000);
    	
    	//assertion for added task
    	String note = driver.findElementById("index_note_title").getText();
    	String comp = "First Task";
    	Assert.assertEquals(note, comp);
    	
   	    }
}