package ECommerceApp;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
        nameBox.sendKeys("ylz");

        //female secilir
        if(!feMaleRadioButton.isSelected()) {
            feMaleRadioButton.click();
        }

        //clicks shop button
        letsShopButton.click();

        Thread.sleep(2000);

        //Products ekraninda miyiz?

        Assert.assertTrue(driver.findElementById("com.androidsample.generalstore:id/toolbar_title").isDisplayed());




        //ilk urun sepete eklendi
        MobileElement addButton1= driver.findElementByXPath("(//android.widget.TextView[@text='ADD TO CART'])[1]");
        addButton1.click();
        //ikinci secilmek istenen urun icin scroll yapmamız gerekir
        driver.findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan Lift Off\"))");

        MobileElement ikiciUrunAddButton = driver.findElementByXPath("((//android.widget.TextView[@text='Jordan Lift Off']//following-sibling::*)[2]//following-sibling::*)[2]");
        ikiciUrunAddButton.click();

        //add Basket
        driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();

        //sepetteyiz
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElementById("com.androidsample.generalstore:id/toolbar_title").isDisplayed());

        //sepetteki urunleri dogruluyoruz
        Assert.assertEquals(driver.findElementByXPath("//android.widget.TextView[@text='Air Jordan 4 Retro']").getText(),"Air Jordan 4 Retro");
        Assert.assertEquals(driver.findElementByXPath("//android.widget.TextView[@text='Jordan Lift Off']").getText(),"Jordan Lift Off");

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