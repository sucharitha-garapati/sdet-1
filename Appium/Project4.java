package appium_Project;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Project4 {
	WebDriverWait wait;
	AppiumDriver<MobileElement> driver = null;
	
	@BeforeTest
	public void mylist() throws InterruptedException, IOException {
		DesiredCapabilities pixelCapability = new DesiredCapabilities();
		pixelCapability.setCapability("deviceId", "emulator-5554");
		pixelCapability.setCapability("deviceName", "Pixel4Emulator");
		pixelCapability.setCapability("platformName", "Android");
		pixelCapability.setCapability("appPackage", "com.android.chrome");
		pixelCapability.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		pixelCapability.setCapability("noReset", true);
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), pixelCapability);
	}

	@Test (priority=1)
	public void addTexts () throws InterruptedException {
		driver.get("https://www.training-support.net/selenium");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollIntoView(textContains(\"To-Do List\"))")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		String[] tasks = {"Add tasks to list", "Get number of tasks", "Clear the list"};
		MobileElement inputTask = driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"taskInput\")"));
		MobileElement addTask = driver.findElementByXPath("//android.view.View/android.view.View[3]/android.view.View[1]/android.widget.Button");

		for (int i = 0; i<tasks.length; i++) {
			inputTask.sendKeys(tasks[i]);
			addTask.click();	
		}

		Thread.sleep(500);
	}
	@AfterTest
	public void closing() {
		driver.quit();
	}
	@Test (priority=2)
	public void strikeAndAssert () throws InterruptedException {
		MobileElement t1 = driver.findElementByXPath("//android.view.View/android.view.View[3]/android.view.View[2]/android.view.View[2]");
		MobileElement t2 = driver.findElementByXPath("//android.view.View/android.view.View[3]/android.view.View[2]/android.view.View[3]");
		MobileElement t3 = driver.findElementByXPath("//android.view.View/android.view.View[3]/android.view.View[2]/android.view.View[4]");
		t1.click();
		t2.click();
		t3.click();
		System.out.println("Task 1: "+t1.getText());
		System.out.println("Task 2: "+t2.getText());
		System.out.println("Task 3: "+t3.getText());
		Assert.assertEquals(t1.getText(), "Add tasks");
		Assert.assertEquals(t2.getText(), "Get tasks");
		Assert.assertEquals(t3.getText(), "Clear list");
	}
	
	@Test (priority=3)
	public void clearList () throws InterruptedException {
		driver.findElementByXPath("//android.view.View/android.view.View[3]/android.view.View[3]").click();
	}
	
}
