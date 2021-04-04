package appium_Project;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Project1 {

	AppiumDriver<MobileElement> driver = null;

	@BeforeClass
	public void begining() throws InterruptedException, IOException {

		DesiredCapabilities pixelCapability = new DesiredCapabilities();
		pixelCapability.setCapability("deviceId", "emulator-5554");
		pixelCapability.setCapability("deviceName", "Pixel4Emulator");
		pixelCapability.setCapability("platformName", "Android");
		pixelCapability.setCapability("appPackage", "com.google.android.apps.tasks");
		pixelCapability.setCapability("appActivity", ".ui.TaskListsActivity");
		pixelCapability.setCapability("noReset", true);

		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), pixelCapability);
	}

	@Test
	public void Add_Tasks() {
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//driver.findElementById("welcome_get_started").click();
		
		driver.findElementById("tasks_fab").click();
		driver.findElementById("add_task_title").sendKeys("Complete Activity with Google Tasks");
		driver.findElementById("add_task_done").click();
		String task1 = driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"Complete Activity with Google Tasks\"]/android.view.ViewGroup/android.widget.TextView").getText();
		
		driver.findElementById("tasks_fab").click();
		driver.findElementById("add_task_title").sendKeys("Complete Activity with Google Keep");
		driver.findElementById("add_task_done").click();
		String task2 = driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"Complete Activity with Google Keep\"]/android.view.ViewGroup/android.widget.TextView").getText();
		
		driver.findElementById("tasks_fab").click();
		driver.findElementById("add_task_title").sendKeys("Complete the second Activity Google Keep");
		driver.findElementById("add_task_done").click();
		String task3 = driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"Complete the second Activity Google Keep\"]/android.view.ViewGroup/android.widget.TextView").getText();
		
		Assert.assertEquals(task1, "Complete Activity with Google Tasks");
		Assert.assertEquals(task2, "Complete Activity with Google Keep");
		Assert.assertEquals(task3, "Complete the second Activity Google Keep");
		
	}
	
	@AfterClass
	public void closing() {
		driver.quit();
	}
}
