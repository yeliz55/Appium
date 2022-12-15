package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import java.util.concurrent.TimeUnit;

public class Appium06NativeChrome {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();


        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");

        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");


        capabilities.setCapability("appPackage", "com.android.chrome");
        capabilities.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        capabilities.setCapability("noReset", true);

        Thread.sleep(5000);

        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://www.amazon.com");





        if (driver.isDeviceLocked()) {
            driver.unlockDevice();
        }


        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

        MobileElement homeScreenLogo = driver.findElementByAccessibilityId("Amazon");
        Assert.assertTrue(homeScreenLogo.isDisplayed());
        System.out.println("Anasayfada");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //  System.out.println(driver.getCurrentUrl() + "<======== url");

       /* MobileElement signInButton = driver.findElementByXPath("//android.view.View[@content-desc=\"Giriş Yap ›\"]/android.widget.TextView");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        signInButton.click();*/

        MobileElement signInButton = driver.findElementByXPath("//android.view.View[@content-desc=\"Sign in ›\"]/android.widget.TextView");
        signInButton.click();
        Thread.sleep(3000);


        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        MobileElement welcome = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View[1]/android.view.View[4]/android.view.View[1]");
        Assert.assertTrue(welcome.isDisplayed());
        System.out.println("welcome sayfasında");

     /*   MobileElement createAccount=driver.findElementByXPath("//android.widget.TextView[@text='Create account. New to Amazon?']");
        Assert.assertTrue(createAccount.isDisplayed());*/

        driver.closeApp();
    }

}


