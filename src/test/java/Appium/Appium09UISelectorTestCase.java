package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.AssertJUnit.assertEquals;

public class Appium09UISelectorTestCase {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        // capabilities.setCapability("platformName","Android");
        //1.yol manuel olarak yazabılırız(seleniumdan gelir)
        //   capabilities.setCapability(CapabilityType.PLATFORM_NAME,"Android");
        //Hazır seleniumdan gelen methodlar sayesinde yazabiliriz
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        //Buda appiumdan gelen methodlar sayesinde yazabiliriz.
        //Bu uc yolda aynısını yapar
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5556");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        //Yukarıda calısacagımız telefonun ozellıklerını verdık

        capabilities.setCapability(MobileCapabilityType.APP, "C:/Users/USERR/IdeaProjects/AppiumFirst/src/Apps/gestureTool.apk");

        /*cmd'ye sırası ıle  adb shell
        dumpsys window | grep -E "mCurrentFocus" yaz gelen bilgileri asagiya yaz eger bunları yapmadan calısmaz ıse*/


        /*
        bu uc satır sayesınde dırek anasayfaya ilerliyoruz appium02 classindaki izin verme adimlarini atlayarak 39. satırda ekledıgımız ile saglariz
         */
        capabilities.setCapability("appPackage", "com.davemac327.gesture.tool");
        capabilities.setCapability("appActivity", "com.davemac327.gesture.tool.GestureBuilderActivity");
        //Eger aplikasyonu izinler atlayarak ana sayfada acılmasını ıstıyorsanız asagidaki komutu kullanıyoruz
        capabilities.setCapability("noReset", true);

        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        //resourceId ile
        //driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/addButton\")").click();

        //className ile ve index kullanarak
        // driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").index(0)").click();
        Thread.sleep(5000);


        //className ile text kullanarak testButton a click
        // driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").text(\"Test\")").click();


        //className ve startwıth kullanarak testbutton click
        // driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").textStartsWith(\"T\")").click();


        //className ve startwıth kullanarak AddGesture click
        driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").textStartsWith(\"Add\")").click();
        Thread.sleep(5000);


        Thread.sleep(5000);
        String isFalse = driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/done\").enabled(false)").getAttribute("enabled");
        Assert.assertEquals(isFalse, "false");

        driver.findElementByXPath("//android.widget.EditText").sendKeys("text");
        driver.findElementById("com.davemac327.gesture.tool:id/gestures_overlay").click();
        Thread.sleep(5000);
        String isTrue = driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/done\").enabled(true)").getAttribute("enabled");
        Assert.assertEquals(isTrue, "true");

        driver.closeApp();

    }
}
