package ECommerceApp;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class ECommercePositiveLogin02 extends BaseECommerceApp {
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

        MobileElement expectedCountry = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+country+"\"))");
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





        //close app
      //  driver.closeApp();


    }


}
