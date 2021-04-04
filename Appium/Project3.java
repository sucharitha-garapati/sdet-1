package appium_Project;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Project3 {
	AppiumDriver<MobileElement> driver = null;

	@BeforeClass
	public void begining() throws InterruptedException, IOException {
		DesiredCapabilities pixelCapability = new DesiredCapabilities();
		pixelCapability.setCapability("deviceId", "emulator-5554");
		pixelCapability.setCapability("deviceName", "Pixel4Emulator");
		pixelCapability.setCapability("platformName", "Android");
		pixelCapability.setCapability("appPackage", "com.google.android.keep");
		pixelCapability.setCapability("appActivity", ".activities.BrowseActivity");
		pixelCapability.setCapability("noReset", true);
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), pixelCapability);
	}
	@AfterClass
	public void closing() {
		driver.quit();
	}
	@Test (priority=1)
	public void Add_Texts() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElementById("new_note_button").click();
		driver.findElementById("editable_title").sendKeys("Appium Reminder");
		driver.findElementById("edit_note_text").sendKeys("Reminder for Appium Project");
		driver.findElementById("menu_switch_to_list_view").click();
		driver.findElementByXPath("//android.view.ViewGroup/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.view.ViewGroup[1]").click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]").click();
	}

	@Test (priority=2)
	public void  Assertions () {
		String title = driver.findElementByXPath("//androidx.cardview.widget.CardView[@content-desc=\"Appium Reminder. Reminder for Appium Project. \"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]").getText();
		String content = driver.findElementByXPath("//androidx.cardview.widget.CardView[@content-desc=\"Appium Reminder. Reminder for Appium Project. \"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[2]").getText();
		Assert.assertEquals(title, "Appium Reminder");
		Assert.assertEquals(content, "Reminder for Appium Project");
		Boolean reminder = driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.keep:id/reminder_chip_icon\")")).isDisplayed();
		System.out.println("Is reminder set?: "+reminder);
	}

	
}
