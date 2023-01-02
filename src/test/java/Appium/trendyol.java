package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.TapOptions;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class trendyol {

    @Test
    public void test() throws InterruptedException, MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();


        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");

        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\USERR\\IdeaProjects\\AppiumFirst\\src\\Apps\\Trendyol.apk");

        capabilities.setCapability("noReset", true);

        Thread.sleep(5000);

        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        Assert.assertTrue(driver.findElementByXPath("//android.widget.TextView[@text='Trendyol Go']").isDisplayed());
        System.out.println("trenyol uygulamasindayiz");

        MobileElement textBox1 = driver.findElementByClassName("android.widget.EditText");
        textBox1.click();
        Thread.sleep(3000);
        MobileElement textBox2 = driver.findElementById("trendyol.com:id/edittext_search_view");
        textBox2.sendKeys("kalem");
        Thread.sleep(3000);



    }
}
