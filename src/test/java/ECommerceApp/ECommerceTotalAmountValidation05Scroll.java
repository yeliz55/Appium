package ECommerceApp;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.List;

public class ECommerceTotalAmountValidation05Scroll extends BaseECommerceApp {
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
        Thread.sleep(8000);
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
        //1.yol
        //first product selected
        //driver.findElementByXPath("(//android.widget.TextView[@text='ADD TO CART'])[1]").click();

        //second product selected
        // driver.findElementByXPath("(//android.widget.TextView[@text='ADD TO CART'])[1]").click();
        /*
        ılk urune tıklamadan ekranda ıkı urun oldugu ıcın ındex olarak locate de 1 ve 2 dememiz gerekiyor du addtocart kısmına
        fakat ılk urunde addtocart kısmına tıklayınca yani ılk urunu secınce addtocart addedtocart ta donusuyor ve ıkıncı urunun locate tek indexse donusuyor
        Bu yuzden ıkıncıyı sectırırken ılk aldıgımız locate gore [2] yazarsak ve tıklamaya calısırsak hata alırız ılk urun secılınce ıkıncı urun bır konumuna gecıyor ve locatedekı ındex[1] olur

        yada bu sorunu cozebılmek mobılelement veraeblesıne atama yapmamız gerekır
        3.yol list e atayarak da yapabiliriz
         */
        //2.yol
        //  MobileElement addButton1= driver.findElementByXPath("(//android.widget.TextView[@text='ADD TO CART'])[1]");
        // MobileElement addButton2= driver.findElementByXPath("(//android.widget.TextView[@text='ADD TO CART'])[2]");
        // addButton1.click();
        //  Thread.sleep(2000);
        // addButton2.click();

        //3.yol
        List<MobileElement> addTOCarts=driver.findElementsByXPath("//android.widget.TextView[@text='ADD TO CART']");
        addTOCarts.get(0).click();
        Thread.sleep(2000);
        addTOCarts.get(1).click();

        //add Basket
        driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();

        //sepetteyiz
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElementById("com.androidsample.generalstore:id/toolbar_title").isDisplayed());

        //sepetteki urunleri dogruluyoruz
        Assert.assertEquals(driver.findElementByXPath("//android.widget.TextView[@text='Air Jordan 4 Retro']").getText(),"Air Jordan 4 Retro");
        Assert.assertEquals(driver.findElementByXPath("//android.widget.TextView[@text='Air Jordan 1 Mid SE']").getText(),"Air Jordan 1 Mid SE");

        //Fiyat
        List<MobileElement> prices=driver.findElementsByXPath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productPrice']");

        Double amount=0.0;
        for (int i = 0; i <prices.size() ; i++) {
            amount+=Double.parseDouble(prices.get(i).getText().substring(1));
        }
        Double totalPrice=Double.parseDouble(driver.findElementById("com.androidsample.generalstore:id/totalAmountLbl").getText().substring(1));
        Assert.assertEquals(amount, totalPrice);

        //close app
        // driver.closeApp();




    }
}