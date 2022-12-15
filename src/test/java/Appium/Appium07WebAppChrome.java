package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Appium07WebAppChrome {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();


        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");

        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");


         //capabilities.setCapability("chromeDriverExecutable","chromepath'i buraya yapistir");
        // --> chrome driver eski ise bunu  kullanacaz bunun ıcın kendı bılgısayarımıza aıt versiyona uygun chrome surumu ındırıp ıntellije eklenecek
        //src icine directory ac ıcıne ındırdıgını yukle ve uzantısını yukarıya yaz
        //https://chromedriver.storage.googleapis.com/index.html



        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"chrome");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,"60000");//eger bekleme gerekırse bunu ekle acılmazsa bu sanıye kadar bekler

        Thread.sleep(5000);

        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://www.amazon.com");


        //Burada aplikasyonun hangi tur oldugunu ogrenebilmek icin getContextHandles() kullaniyoruz

      System.out.println(driver.getContext() + "<====app acildigindaki tur ");

      Set<String> butunTurler = driver.getContextHandles();

        for (String tur : butunTurler) {
            System.out.println(tur);
            if (tur.contains("WEBVIEW_chrome")) {
                driver.context(tur);
            }
        }
        System.out.println(driver.getContext() + "<========app sonraki durumu");


        MobileElement logo=driver.findElementByXPath("//a[@id='nav-logo-sprites']");
        Assert.assertTrue(logo.isEnabled());
        System.out.println("");

        MobileElement signIn=driver.findElementByXPath("//a[@class='nav-a nav-show-sign-in']");
        signIn.click();

        MobileElement welcome=driver.findElementByXPath("//h2");
        assert welcome.isDisplayed();
        System.out.println("Sign in sayfasindayiz");


        Thread.sleep(20000);




        driver.closeApp();

}}


