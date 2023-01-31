package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class IQ {
    @Test
    public void iq() throws InterruptedException, MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();


        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");

        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        Thread.sleep(5000);
        capabilities.setCapability(MobileCapabilityType.APP,"C:/Users/USERR/IdeaProjects/AppiumFirst/src/Apps/Calculator.apk");
        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        //Telefonu yan acmasını saglamak icin
        capabilities.setCapability("deviceOrientation","landscape");

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

        num2.click();
        num3.click();
        plus.click();
        num9.click();
        num5.click();
        equals.click();

        MobileElement result=driver.findElementById("com.google.android.calculator:id/result_final");
        String resultString=result.getText();


        MobileElement sugare= driver.findElementById("com.google.android.calculator:id/op_sqrt");
        sugare.click();

        for (int i = 0; i <resultString.length() ; i++) {

            switch (resultString.charAt(i)){
                case '1': num1.click();break;
                case '2': num1.click();break;
                case '3': num1.click();break;
                case '4': num1.click();break;
                case '5': num1.click();break;
                case '6': num1.click();break;
                case '7': num1.click();break;
                case '8': num1.click();break;
                case '9': num1.click();break;
                case '0': num1.click();break;
                default:
                    System.out.println("no digit value");
            }
        }
        equals.click();
        Thread.sleep(3000);
        multiply.click();
        minus.click();
        num1.click();
        equals.click();
        MobileElement result2 = driver.findElementById("com.google.android.calculator:id/result_final");
        String carpimSonrasiSonuc = result2.getText();
        String ex = "-10.862782780491200215723891499337473741120";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(carpimSonrasiSonuc,ex);


        //        String rounding=format("%.4f", carpimSonrasiSonuc);

        String rounding = carpimSonrasiSonuc.substring(1);
        String numericSonuc = rounding;
        double doubleSonuc = Double.parseDouble(numericSonuc);
        System.out.println(doubleSonuc +"=======");
        doubleSonuc =  Math.round(doubleSonuc*10000.0)/10000.0 *(-1);
        System.out.println(doubleSonuc);
        double exrounding = -10.8628;
        softAssert.assertEquals(doubleSonuc,exrounding);
        softAssert.assertAll("Actual and expected sonuc ayni degil");
        


    }
}
