package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class Appium16iOSCalculator extends BaseClassIOS{


    @Test
    public void testName() throws MalformedURLException, InterruptedException {
        IOSDriver<MobileElement> driver=getIOSDriver();
        Thread.sleep(5000);
        driver.findElementByXPath("//XCUIElementTypeButton[name=\"8\"]").click();
        Thread.sleep(2000);
        driver.findElementByXPath("//XCUIElementTypeButton[name=\"5\"]").click();
        Thread.sleep(2000);
        driver.findElementByXPath("//XCUIElementTypeButton[name=\"-\"]").click();
        Thread.sleep(2000);
        driver.findElementByXPath("//XCUIElementTypeButton[name=\"1\"]").click();
        Thread.sleep(2000);
        driver.findElementByXPath("//XCUIElementTypeButton[name=\"2\"]").click();
        Thread.sleep(2000);
        driver.findElementByXPath("//XCUIElementTypeButton[name=\"=\"]").click();

        MobileElement result=driver.findElementByXPath("//XCUIElementTypeProgressIndıcator[@name\"Progres\"]/preceding-sibling::XCUIElemenTypeOther");
        Assert.assertEquals(result.getText(),"73");

    }
}
