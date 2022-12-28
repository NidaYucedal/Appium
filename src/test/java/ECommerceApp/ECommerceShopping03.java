package ECommerceApp;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.sound.midi.Track;
import java.net.MalformedURLException;

public class ECommerceShopping03 extends BaseECommerceApp {


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
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Belgium\"))");
        MobileElement expectedCountry = driver.findElementByXPath("//android.widget.TextView[@text='Belgium']");
        expectedCountry.click();
        Thread.sleep(5000);
        //istedigimiz ulkeyi dogru olarak sectik mi?
        MobileElement selectedCountry = driver.findElementByXPath("//android.widget.TextView[@text='Belgium']");
        System.out.println(selectedCountry.getText());
        Assert.assertEquals(selectedCountry.getText(), "Belgium");
        Thread.sleep(3000);

        nameBox.sendKeys("Nida");
        //female secilsin
        maleRadioButton.click();
        //shop butonuna tiklayalim
        letsShopButton.click();
        //basrili girildi
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElementById("com.androidsample.generalstore:id/toolbar_title").isDisplayed());

        //ik urun secilsin
        //driver.findElementByXPath("(//android.widget.TextView[@text='ADD TO CART'])[1]").click();
        //Thread.sleep(2000);
        ////ikinci urun sec
        //driver.findElementByXPath("(//android.widget.TextView[@text='ADD TO CART'])[1]").click();

        MobileElement addButton1 = driver.findElementByXPath("(//android.widget.TextView[@text='ADD TO CART'])[1]");
        MobileElement addButton2 = driver.findElementByXPath("(//android.widget.TextView[@text='ADD TO CART'])[2]");
        addButton1.click();
        Thread.sleep(3000);
        addButton2.click();

        driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
        Thread.sleep(5000);
        //sepette ol
        Assert.assertTrue(driver.findElementById("com.androidsample.generalstore:id/toolbar_title").isDisplayed());

        //ilk urunun adi Air Jordan 4 Retro
        Assert.assertEquals(driver.findElementByXPath("//android.widget.TextView[@text='Air Jordan 4 Retro']").getText(), "Air Jordan 4 Retro");

        //ikinci urun adi = Air Jordan 1 Mid SE
        Assert.assertEquals(driver.findElementByXPath("//android.widget.TextView[@text='Air Jordan 1 Mid SE']").getText(), "Air Jordan 1 Mid SE");

        Thread.sleep(10000);
        //close app
        driver.closeApp();

    }
}