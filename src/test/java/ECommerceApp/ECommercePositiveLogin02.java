package ECommerceApp;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class ECommercePositiveLogin02 extends BaseECommerceApp {


    @Test
    public void positiveTest() throws MalformedURLException, InterruptedException {
        AndroidDriver<MobileElement> driver = getAndroidDriver();
        Thread.sleep(7000);
        //1- Fill the form details and verify Toast error messages displayed appropriately for wrong inputs
        //1- hatali data ile form doldurdugunuzda hata mesajini dogrulayin

        MobileElement homeScreenTitle = driver.findElementById("toolbar_title");
        MobileElement countrySpinner = driver.findElementById("spinnerCountry");


        MobileElement nameBox = driver.findElementById("com.androidsample.generalstore:id/nameField");
        MobileElement maleRadioButton = driver.findElementById("com.androidsample.generalstore:id/radioMale");
        MobileElement femaleRadioButton = driver.findElementById("com.androidsample.generalstore:id/radioFemale");
        MobileElement letsShopButton = driver.findElementById("com.androidsample.generalstore:id/btnLetsShop");



        //ulkeyi secmek icin ulke butununa bastik
        countrySpinner.click();
        //ulkeyi sececegiz
        Thread.sleep(4000);
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Turkey\"))");
        MobileElement expectedCountry = driver.findElementByXPath("//android.widget.TextView[@text='Turkey']");
        expectedCountry.click();
        Thread.sleep(5000);
        //istedigimiz ulkeyi dogru olarak sectik mi?
        MobileElement selectedCountry = driver.findElementByXPath("//android.widget.TextView[@text='Turkey']");
        System.out.println(selectedCountry.getText());
        Assert.assertEquals(selectedCountry.getText(), "Turkey");
        Thread.sleep(3000);
        //negative case icin name bos olmali
        // Assert.assertTrue(nameBox.getText().isEmpty());
        nameBox.sendKeys("Nida");
        //female secilsin
        maleRadioButton.click();
        //shop butonuna tiklayalim
        letsShopButton.click();
        //hata mesajini onayla
        Thread.sleep(2000);


        //close app
        driver.closeApp();

    }
}