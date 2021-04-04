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

public class Activity2_3 {
    AppiumDriver<MobileElement> driver = null;
    WebDriverWait wait;
    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel 4 API 28");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.android.contacts");
        caps.setCapability("appActivity", ".activities.PeopleActivity");
        caps.setCapability("noReset", true);
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver, 5);
    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
    @Test
    public void myTask1() throws Throwable {
        driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Create new contact']").click();
        Thread.sleep(5000);
        driver.hideKeyboard();
        Thread.sleep(5000);
        MobileElement firstName = driver.findElementByXPath("//android.widget.EditText[@text='First name']");
        MobileElement lastName = driver.findElementByXPath("//android.widget.EditText[@text='Last name']");
        MobileElement phoneNumber = driver.findElementByXPath("//android.widget.EditText[@text='Phone']");
        Thread.sleep(5000);
        // text fields
        firstName.sendKeys("Sowmya");
        lastName.sendKeys("Rathnakar");
        phoneNumber.sendKeys("9991284782");
        driver.findElementById("editor_menu_save_button").click();
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("toolbar_parent")));
        MobileElement Card = driver.findElementById("toolbar_parent");
        Assert.assertTrue(Card.isDisplayed());
        String contactName = driver.findElementById("large_title").getText();
        Assert.assertEquals(contactName, "Sowmya Rathnakar");
    }
}