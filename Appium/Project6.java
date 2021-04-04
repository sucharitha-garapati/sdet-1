package appium_Project;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;
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

public class Project6 {

	WebDriverWait wait;
	AppiumDriver<MobileElement> driver = null;

	@BeforeTest
	public void mytaskspopups() throws InterruptedException, IOException {
		DesiredCapabilities pixelCapability = new DesiredCapabilities();
		pixelCapability.setCapability("deviceId", "emulator-5554");
		pixelCapability.setCapability("deviceName", "Pixel4Emulator");
		pixelCapability.setCapability("platformName", "Android");
		pixelCapability.setCapability("appPackage", "com.android.chrome");
		pixelCapability.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		pixelCapability.setCapability("noReset", true);
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), pixelCapability);
		driver.get("https://www.training-support.net/selenium");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollIntoView(textContains(\"Popups\"))")).click();
	}
	@AfterTest
	public void closing() {
		driver.quit();
	}
	@Test (priority=1)
	public void myTasksValid () throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.webkit.WebView/android.view.View/android.view.View[3]/android.widget.Button").click();
		driver.findElementByXPath("//android.view.View[2]/android.view.View/android.view.View[2]/android.view.View/android.widget.EditText[1]").sendKeys("admin");
        driver.findElementByXPath("//android.view.View[2]/android.view.View/android.view.View[2]/android.view.View/android.widget.EditText[2]").sendKeys("password");
		driver.findElementByXPath("//android.view.View[2]/android.view.View/android.view.View[2]/android.view.View/android.widget.Button").click();
		String validConf = driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"action-confirmation\")")).getText();
		System.out.println("Login Message for valid creds: "+validConf);
		Assert.assertEquals(validConf, "Welcome Back, admin");
	}

	@Test (priority=2)
	public void myTasksInvalid () throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.webkit.WebView/android.view.View/android.view.View[4]/android.widget.Button[contains(@text, 'Sign In')]").click();
		driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"username\")")).sendKeys(Keys.chord(Keys.COMMAND, "a"), "admin$" );
		driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"password\")")).sendKeys(Keys.chord(Keys.COMMAND, "a"), "password$");
		driver.findElementByXPath("//android.view.View[2]/android.view.View/android.view.View[2]/android.view.View/android.widget.Button").click();
		String invalidConf = driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"action-confirmation\")")).getText();
		System.out.println("Login Message for valid creds: "+invalidConf);
		Assert.assertEquals(invalidConf, "Invalid Credentials");
	}

	
}