package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium01 {
    @Test
    public void test() throws MalformedURLException {
        DesiredCapabilities capabilities=new DesiredCapabilities();
       // capabilities.setCapability("platformName","Android");
        //1.yol manuel olarak yazabılırız(seleniumdan gelir)
     //   capabilities.setCapability(CapabilityType.PLATFORM_NAME,"Android");
        //Hazır seleniumdan gelen methodlar sayesinde yazabiliriz
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        //Buda appiumdan gelen methodlar sayesinde yazabiliriz.
        //Bu uc yolda aynısını yapar
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5556");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        //Yukarıda calısacagımız telefonun ozellıklerını verdık

        capabilities.setCapability(MobileCapabilityType.APP,"C:/Users/USERR/IdeaProjects/AppiumFirst/src/Apps/gestureTool.apk");
        /*cmd'ye sırası ıle  adb shell
        dumpsys window | grep -E "mCurrentFocus" yaz gelen bilgileri asagiya yaz eger bunları yapmadan calısmaz ıse*/
        capabilities.setCapability("appPackage","com.davemac327.gesture.tool");
        capabilities.setCapability("appActivity","com.davemac327.gesture.tool.GestureBuilderActivity");

        AndroidDriver<MobileElement> driver =new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        //Benim cihazımın ozellıklerını verdım ve andorıd drıver vasıtası ile ulasıyorum ve capatilities leri bu url ile gonder



    }
}
