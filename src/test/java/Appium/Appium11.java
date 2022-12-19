package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium11 {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");


        capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\USERR\\IdeaProjects\\AppiumFirst\\src\\Apps\\ApiDemos.apk");
        capabilities.setCapability("noReset", true);


        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        //Api Demos a tkla

//preference a tikla
        driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
        Thread.sleep(1000);

//preference dependencies e tikla
        driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();

//wifi checkbox u tikla

        if (driver.findElementByXPath("//android.widget.TextView[@text='WiFi settings']").isEnabled()) {
            driver.findElementByXPath("//android.widget.TextView[@text='WiFi settings']").click();
        } else {
            driver.findElementByXPath("//android.widget.CheckBox").click();
            Thread.sleep(2000);
            //wi-fi settings e tikla
            driver.findElementByXPath("//android.widget.TextView[@text='WiFi settings']").click();
        }

// send keys
        driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"android:id/edit\")").sendKeys("text");

//ok a tikla
        driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"android:id/button1\")").click();

        // driver.closeApp();

    }
}
