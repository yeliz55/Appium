package ECommerceApp;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class ECommerceTotalAmountValidation06 extends BaseECommerceApp {
     /*
    //1- Fill the form details and verify Toast error messages displayed appropriately for wrong inputs
    //1- hatali data ile form doldurdugunuzda hata mesajini dogrulayin
    //2-Shop the items in the app by scrolling to specific Product and add to cart
    //3-Validate if the items selected in the page 2 are matching with the items displayed in check out page
    //4- Validate the total Amount displayed in the checkout page matches with sum of product amounts selected for shopping
    //5-Validate Mobile gestures working for link (long press) and navigate to WebView
    //6-Verify if user can do operations on Web view and navigate back to native app if needed.
    (go to google and search "appium" then navigate to NATIVE APP and verify it)

     */

    @Test
    public void positiveTest() throws MalformedURLException, InterruptedException {
        AndroidDriver<MobileElement> driver=getAndroidDriver();
        //1- Fill the form details and verify Toast error messages displayed appropriately for wrong inputs
        //1- hatali data ile form doldurdugunuzda hata mesajini dogrulayin
        Thread.sleep(5000);
        MobileElement homeScreenTitle=driver.findElementById("com.androidsample.generalstore:id/toolbar_title");
        MobileElement countrySpinner=driver.findElementById("com.androidsample.generalstore:id/spinnerCountry");


        MobileElement nameBox=driver.findElementById("com.androidsample.generalstore:id/nameField");
        MobileElement maleRadioButton=driver.findElementById("com.androidsample.generalstore:id/radioMale");
        MobileElement feMaleRadioButton=driver.findElementById("com.androidsample.generalstore:id/radioFemale");
        MobileElement letsShopButton=driver.findElementById("com.androidsample.generalstore:id/btnLetsShop");

        //Eger popup test edılmek ıstenıyorsa ve bu search kod ıcınde bulunmuyorsa yani direk locate edilemiyorsa
        //developerlar genelde bunu asagıdaki gibi className= "android.widget.Toast" ile build ederler bizde bu sekilde verify ederiz

        //Ana sayfada miyiz?
        Assert.assertTrue(homeScreenTitle.isDisplayed());

        //clicks country drop down
        countrySpinner.click();

        //country sectik
        String country="Belgium";
        Thread.sleep(2000);
        MobileElement expectedCountry = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+country+"\"))");
        expectedCountry.click();
        //Dogru ulke sectik mi?
        Thread.sleep(2000);
        MobileElement selectedCountry=driver.findElementByXPath("//android.widget.TextView[@text='"+country+"']");
        Assert.assertEquals(selectedCountry.getText(),country);

        // positive test icin name box i doldurduk
        nameBox.sendKeys("Hanife");

        //female secilir
        if(!feMaleRadioButton.isSelected()) {
            feMaleRadioButton.click();
        }

        //clicks shop button
        letsShopButton.click();

        Thread.sleep(2000);

        //Products ekraninda miyiz?

        Assert.assertTrue(driver.findElementById("com.androidsample.generalstore:id/toolbar_title").isDisplayed());
        //First product added in the basket
        MobileElement addButton1 = driver.findElementByXPath("(//android.widget.TextView[@text='ADD TO CART'])[1]");
        addButton1.click();

        //2. urune kadar scroll yap
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan Lift Off\"))");

        MobileElement ikiciUrunAddButton = driver.
                findElementByXPath("((//android.widget.TextView[@text='Jordan Lift Off']//following-sibling::*)[2]//following-sibling::*)[2]");
        ikiciUrunAddButton.click();

        //sepete tikla
        driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
        Thread.sleep(5000);

        //sepette ol
        Assert.assertTrue(driver.findElementById("com.androidsample.generalstore:id/toolbar_title").isDisplayed());



        //sepetteki urunleri dogruluyoruz
        Assert.assertEquals(driver.findElementByXPath("//android.widget.TextView[@text='Air Jordan 4 Retro']").getText(),"Air Jordan 4 Retro");
        Assert.assertEquals(driver.findElementByXPath("//android.widget.TextView[@text='Jordan Lift Off']").getText(),"Jordan Lift Off");

        //urunlerin fiyatlarındaki $ isaretlerini kaldırıp double a cevirip totalAmount a ekledik
        List<MobileElement> prices=driver.findElementsByXPath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productPrice']");

        Double totalAmount=0.0;
        for (int i = 0; i <prices.size() ; i++) {
            totalAmount+=Double.parseDouble(prices.get(i).getText().substring(1));
        }
        Double totalPrice=Double.parseDouble(driver.findElementById("com.androidsample.generalstore:id/totalAmountLbl").
                getText().substring(1));//Sepetin toplam fiyatindaki $ isaretini kaldırıp Double a cevirdik
        Assert.assertEquals(totalAmount, totalPrice);

        MobileElement termButton = driver.findElementById("com.androidsample.generalstore:id/termsButton");
        driver.findElementByXPath("//android.widget.CheckBox").click();

        TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(termButton))
                .withDuration(Duration.ofSeconds(2))).release().perform();

        Assert.assertTrue(driver.findElementById("com.androidsample.generalstore:id/alertTitle").isDisplayed());
        Thread.sleep(2000);
        driver.findElementById("android:id/button1").click();
        Thread.sleep(2000);
        System.out.println(driver.getContext() +"<=======proceed butonuna basmadan onceki context");
        driver.findElementById("com.androidsample.generalstore:id/btnProceed").click();
        Thread.sleep(5000);
        System.out.println(driver.getContext() +"<=======proceed butonuna bastiktan sonraki context - driver hala native de");

        Set<String> butunturler = driver.getContextHandles();
        for (String tur: butunturler) {
            System.out.println(tur);
            if (tur.contains("WEBVIEW")) {
                driver.context(tur);
            }
        }

        Thread.sleep(5000);
        System.out.println(driver.getContext() + " web view gectik");
        Thread.sleep(5000);

/*
Burada WEBVIEW e gecıs yaptıgımız ıcın selenıum kodları gecerlı oluyor locate kısmını da dev tools uzerınden locate edebiliyoruz
 */
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("appium" + Keys.ENTER);

        Thread.sleep(5000);
        System.out.println(driver.getContext() + " web view deyiz");

        Set<String> butunturler1 = driver.getContextHandles();
        for (String tur: butunturler1) {
            System.out.println(tur);
            if (tur.contains("NATIVE")) {
                driver.context(tur);
            }
        }
/*
Burada natıve app (mobıl uygulama)uzerıne gecıs yaptıgımız ıcın gerı gıtmek ıcın navıgate.back methodu kullanılamıyor
onun yerıne asagıdakı medhod kullanılıyor
 */
        driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));//geri gitmek icin kullandik

        System.out.println(driver.getContext() + " native deyiz");



        //close app
        // driver.closeApp();



    }
}

        //Popup tam secilmediginde getAttribute ile name alip mesaj icerigi ile assertEquals ediyoruz
        //Eger popup test edılmek ıstenıyorsa ve bu search kod ıcınde bulunmuyorsa yani direk locate edilemiyorsa
        //developerlar genelde bunu asagıdaki gibi className= "android.widget.Toast" ile build ederler bizde bu sekilde verify ederiz
