package Appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium14browserStackCalculator {
    @Test
    public void testName() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", "yeliz_qwXbeQ");
        caps.setCapability("browserstack.key", "LsDW39mYPcyvKy7R5qu4");

        // Set URL of the application under test
        caps.setCapability("app", "bs://eaefcb6b381719dc3fab033dfd9120e4fe655c75");

        // Specify device and os_version for testing
        caps.setCapability("device", "Google Pixel 3");
        caps.setCapability("os_version", "9.0");

        // Set other BrowserStack capabilities
        caps.setCapability("project", "Kendi aplikasyonumuz");
        caps.setCapability("build", "yeni");
        caps.setCapability("name", "hesap makinasi");


        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
                new URL("http://hub.browserstack.com/wd/hub"), caps);

        // Write your test case statements here

        // Invoke driver.quit() after the test is done to indicate that the test is completed.
        driver.quit();
    }
}
