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

public class Appium05 {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();


        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");

        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        Thread.sleep(5000);
        capabilities.setCapability(MobileCapabilityType.APP,"C:/Users/USERR/IdeaProjects/AppiumFirst/src/Apps/Calculator.apk");
        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
      /*  Thread.sleep(9000);
        MobileElement num1=driver.findElementById("com.google.android.calculator:id/digit_1");
        MobileElement num2=driver.findElementById("com.google.android.calculator:id/digit_2");
        MobileElement num3=driver.findElementById("com.google.android.calculator:id/digit_3");
        MobileElement num4=driver.findElementById("com.google.android.calculator:id/digit_4");
        MobileElement num5=driver.findElementById("com.google.android.calculator:id/digit_5");
        MobileElement num6=driver.findElementById("com.google.android.calculator:id/digit_6");
        MobileElement num7=driver.findElementById("com.google.android.calculator:id/digit_7");
        MobileElement num8=driver.findElementById("com.google.android.calculator:id/digit_8");
        MobileElement num9=driver.findElementById("com.google.android.calculator:id/digit_9");
        MobileElement num0=driver.findElementById("com.google.android.calculator:id/digit_0");

        MobileElement plus=driver.findElementByXPath("//android.widget.Button[@text='+']");
        num1.click();*/

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //rakamlarin elementlerini locate ettik:
        MobileElement num1 = driver.findElementById("com.google.android.calculator:id/digit_1");
        MobileElement num2 = driver.findElementById("com.google.android.calculator:id/digit_2");
        MobileElement num3 = driver.findElementById("com.google.android.calculator:id/digit_3");
        MobileElement num4 = driver.findElementById("com.google.android.calculator:id/digit_4");
        MobileElement num5 = driver.findElementById("com.google.android.calculator:id/digit_5");
        MobileElement num6 = driver.findElementById("com.google.android.calculator:id/digit_6");
        MobileElement num7 = driver.findElementById("com.google.android.calculator:id/digit_7");
        MobileElement num8 = driver.findElementById("com.google.android.calculator:id/digit_8");
        MobileElement num9 = driver.findElementById("com.google.android.calculator:id/digit_9");
        MobileElement num0 = driver.findElementById("com.google.android.calculator:id/digit_0");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //islem sembollerini locate ettik
        MobileElement plus = driver.findElementByAccessibilityId("plus");
        MobileElement minus = driver.findElementByAccessibilityId("minus");
        MobileElement multiply = driver.findElementByAccessibilityId("multiply");
        MobileElement divide = driver.findElementByAccessibilityId("divide");
        MobileElement equals = driver.findElementByAccessibilityId("equals");
        //64+71=135
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        num6.click();
        num4.click();
        plus.click();
        num7.click();
        num1.click();
        MobileElement preResult = driver.findElementById("com.google.android.calculator:id/result_preview");
        System.out.println("preResult = " + preResult);
        String preResultText = preResult.getText();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        equals.click();
        MobileElement result = driver.findElementById("com.google.android.calculator:id/result_final");
        String acualResult = result.getText();
        Assert.assertEquals(preResultText,acualResult);
        System.out.println("final result = " + result);
        //session kapat
        driver.closeApp();
    }

    }


