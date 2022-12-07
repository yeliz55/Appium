package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium02 {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities=new DesiredCapabilities();
       // capabilities.setCapability("platformName","Android");
        //1.yol manuel olarak yazabılırız(seleniumdan gelir)
     //   capabilities.setCapability(CapabilityType.PLATFORM_NAME,"Android");
        //Hazır seleniumdan gelen methodlar sayesinde yazabiliriz
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        //Buda appiumdan gelen methodlar sayesinde yazabiliriz.
        //Bu uc yolda aynısını yapar
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        //Yukarıda calısacagımız telefonun ozellıklerını verdık

        capabilities.setCapability(MobileCapabilityType.APP,"C:/Users/USERR/IdeaProjects/AppiumFirst/src/Apps/gestureTool.apk");
        /*cmd'ye sırası ıle  adb shell
        dumpsys window | grep -E "mCurrentFocus" yaz gelen bilgileri asagiya yaz eger bunları yapmadan calısmaz ıse*/
        capabilities.setCapability("appPackage","com.davemac327.gesture.tool");
        capabilities.setCapability("appActivity","com.davemac327.gesture.tool.GestureBuilderActivity");

        //Eger aplikasyonu izinler atlayarak ana sayfada acılmasını ıstıyorsanız asagidaki komutu kullanıyoruz
        capabilities.setCapability("noReset",true);

        AndroidDriver<MobileElement> driver =new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        //Benim cihazımın ozellıklerını verdım ve andorıd drıver vasıtası ile ulasıyorum ve capatilities leri bu url ile gonder


/*
        //add button
       // driver.findElementById("com.davemac327.gesture.tool:id/addButton").click();

        System.out.println("app yuklendi");
        Thread.sleep(7000);
        driver.findElementById("com.android.permissioncontroller:id/continue_button").click();


        Thread.sleep(7000);
        MobileElement okButton=driver.findElementByXPath("//android.widget.Button[@text='OK']");
        okButton.click();
        System.out.println("Izinler onaylandi");



        MobileElement homeScreenTitle=driver.findElementById("android:id/title");
        Assert.assertTrue(homeScreenTitle.isDisplayed());
        System.out.println("Ana sayfa acildi");
*/


    }
}
