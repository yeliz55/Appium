package ECommerceApp.ParalelExecution.Android;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class ParallelAndroidTest01 extends ParalelAndroidBase {

    @Test
    public void test01() throws MalformedURLException, InterruptedException {
        AndroidDriver<MobileElement> driver = androidDriver("10000","11","Emulator","emulator-5554","8100");

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


    }

    @Test
    public void test02() throws MalformedURLException, InterruptedException {
        AndroidDriver<MobileElement> driver = androidDriver("10001","11","sdk_gphone_x86","emulator-5556","8100");

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

    }

}
