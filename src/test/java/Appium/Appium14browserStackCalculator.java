package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class Appium14browserStackCalculator {
    @Test
    public void testName() throws MalformedURLException, InterruptedException {

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


     /*boylede alınabılır ıd ıle
      driver.findElementById("com.google.android.calculator:id/digit_5").click();*/
        driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'5')]").click();
        Thread.sleep(3000);

        MobileElement plus=driver.findElementByAccessibilityId("plus");
        plus.click();
        Thread.sleep(3000);

        driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'5')]").click();
        Thread.sleep(3000);

        MobileElement equals= driver.findElementByAccessibilityId("equals");
        equals.click();
        Thread.sleep(3000);

        MobileElement actualResult=driver.findElementById("com.google.android.calculator:id/result_final");

       assertEquals("10",actualResult.getText());




        driver.quit();
    }
}
