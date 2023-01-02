package ECommerceApp;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class ECommerceShoopping03 extends BaseECommerceApp {
    //1- Fill the form details and verify Toast error messages displayed appropriately for wrong inputs
    //1- hatali data ile form doldurdugunuzda hata mesajini dogrulayin

    //2-Shop the items in the app by scrolling to specific Product and add to cart
    //3-Validate if the items selected in the page 2 are matching with the items displayed in check out page
    //4- Validate the total Amount displayed in the checkout page matches with sum of product amounts selected for shopping
    //5-Validate Mobile gestures working for link (long press) and navigate to WebView 
    // 6-Verify if user can do operations on Web view and navigate back to native app if needed.
    //(go to google and search “appium” then navigate to NATIVE APP and verify it)

    @Test
    public void negativeTest() throws MalformedURLException, InterruptedException {
        //1- Fill the form details and verify Toast error messages displayed appropriately for wrong inputs
        //1- hatali data ile form doldurdugunuzda hata mesajini dogrulayin

        AndroidDriver<MobileElement> driver = getAndroidDriver();
        Thread.sleep(8000);

        MobileElement homeScreenTitle = driver.findElementById("com.androidsample.generalstore:id/toolbar_title");

        MobileElement countrySpinner = driver.findElementById("spinnerCountry");


        MobileElement nameBox = driver.findElementById("com.androidsample.generalstore:id/nameField");

        MobileElement maleRadioButton = driver.findElementById("com.androidsample.generalstore:id/radioMale");

        MobileElement femaleRadioButton = driver.findElementById("com.androidsample.generalstore:id/radioFemale");

        MobileElement letsShopButton = driver.findElementById("com.androidsample.generalstore:id/btnLetsShop");


        Assert.assertTrue(homeScreenTitle.isDisplayed());
        System.out.println("Ana sayfadayiz");

        countrySpinner.click();
        System.out.println("ulke butonuna bastik");
        String country = "Belgium";

        MobileElement expectedCountry = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + country + "\"))");
        expectedCountry.click();
        System.out.println("ulkeyi sectik");

        Thread.sleep(5000);
        MobileElement selectedCountry = driver.findElementByXPath("//android.widget.TextView[@text='" + country + "']");
        System.out.println(selectedCountry.getText());
        Assert.assertEquals(selectedCountry.getText(), country);
        System.out.println("secilen ulke Belgium mi kontrol ettik");


        nameBox.sendKeys("Ali");
        System.out.println("pozitif case icin name text yolladik");

        if (!maleRadioButton.isSelected()) {
            maleRadioButton.click();
        }
        System.out.println("male button sectik");

        letsShopButton.click();
        System.out.println("shop butonuna tıkladik");

        Thread.sleep(3000);

        Assert.assertTrue(driver.findElementById("com.androidsample.generalstore:id/toolbar_title").isDisplayed());

        //ilk urun secilsin
        driver.findElementByXPath("(//android.widget.TextView[@text='ADD TO CART'])[1]").click();
        Thread.sleep(3000);


        /*
        ılk urune tıklamadan ekranda ıkı urun oldugu ıcın ındex olarak locate de 1 ve 2 dememiz gerekiyor du addtocart kısmına
        fakat ılk urunde addtocart kısmına tıklayınca yani ılk urunu secınce addtocart addedtocart ta donusuyor ve ıkıncı urunun locate tek indexse donusuyor
        Bu yuzden ıkıncıyı sectırırken ılk aldıgımız locate gore [2] yazarsak ve tıklamaya calısırsak hata alırız ılk urun secılınce ıkıncı urun bır konumuna gecıyor ve locatedekı ındex[1] olur

        yada bu sorunu cozebılmek mobılelement veraeblesıne atama yapmamız gerekır(Yada lıste atamak lazım)
        */
        /*
        //2.yol
         MobileElement addButton1=driver.findElementByXPath("(//android.widget.TextView[@text='ADD TO CART'])[1]");
        MobileElement addButton2=driver.findElementByXPath("(//android.widget.TextView[@text='ADD TO CART'])[2]");
         */


        //ikinci urun icin sec
        driver.findElementByXPath("(//android.widget.TextView[@text='ADD TO CART'])[1]").click();

        //3.yol
        /*
        List<MobileElement> addTOCarts=driver.findElementsByXPath("//android.widget.TextView[@text='ADD TO CART']");
        addTOCarts.get(0).click();
        Thread.sleep(2000);
         addTOCarts.get(1).click();
         */


        //Sepete tıklar
        driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
        System.out.println("sepete tikladik");


        //sepette oldugumuzu kontrol edelım
        Assert.assertTrue(driver.findElementById("com.androidsample.generalstore:id/toolbar_title").isDisplayed());
        System.out.println("Sepetteyiz");

        //Sepette iki urun oldugunu kontrol ettik
        Assert.assertEquals(driver.findElementByXPath("//android.widget.TextView[@text='Air Jordan 4 Retro']").getText(),"Air Jordan 4 Retro");
        Assert.assertEquals(driver.findElementByXPath("//android.widget.TextView[@text='Air Jordan 1 Mid SE']").getText(),"Air Jordan 1 Mid SE");
        System.out.println("iki elementte sepette");


        //close app
        driver.closeApp();


    }


}
