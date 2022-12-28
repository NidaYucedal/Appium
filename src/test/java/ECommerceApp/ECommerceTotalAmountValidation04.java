package ECommerceApp;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class ECommerceTotalAmountValidation04 extends BaseECommerceApp {


    @Test
    public void positiveTest() throws MalformedURLException, InterruptedException {
        AndroidDriver<MobileElement> driver = getAndroidDriver();
        Thread.sleep(7000);

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

        Thread.sleep(2000);
        Assert.assertTrue(driver.findElementById("com.androidsample.generalstore:id/toolbar_title").isDisplayed());


        MobileElement addButton1 = driver.findElementByXPath("(//android.widget.TextView[@text='ADD TO CART'])[1]");
        MobileElement addButton2 = driver.findElementByXPath("(//android.widget.TextView[@text='ADD TO CART'])[2]");
        addButton1.click();
        Thread.sleep(3000);
        addButton2.click();
        //sepete tikla
        driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
        Thread.sleep(5000);
        //sepette ol
        Assert.assertTrue(driver.findElementById("com.androidsample.generalstore:id/toolbar_title").isDisplayed());

        //ilk urunun adi Air Jordan 4 Retro
        Assert.assertEquals(driver.findElementByXPath("//android.widget.TextView[@text='Air Jordan 4 Retro']").getText(), "Air Jordan 4 Retro");

        //ikinci urun adi = Air Jordan 1 Mid SE
        Assert.assertEquals(driver.findElementByXPath("//android.widget.TextView[@text='Air Jordan 1 Mid SE']").getText(), "Air Jordan 1 Mid SE");

        //sepeeteki iki urunun toplami ile genel toplami karsilastirma
        MobileElement firstProductPrice = driver.findElementByXPath("(//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productPrice'])[1]");
        MobileElement secondProductPrice = driver.findElementByXPath("(//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productPrice'])[2]");

        String ilkFiyatRakam = firstProductPrice.getText().substring(1);
        String ikinicFiyatRakam = secondProductPrice.getText().substring(1);
        System.out.println("ilk fiyat string = " + ilkFiyatRakam);
        System.out.println("ikinci fiyat string = " + ikinicFiyatRakam);
        double fiyatDouble = Double.parseDouble(ilkFiyatRakam);
        double ikinciDouble = Double.parseDouble(ikinicFiyatRakam);
        System.out.println("ilk fiyat double = " + fiyatDouble);
        System.out.println("ikinci fiyat double= " + ikinciDouble);

        double total = fiyatDouble + ikinciDouble;
        System.out.println("total double " + total);

        MobileElement totalActual = driver.findElementById("com.androidsample.generalstore:id/totalAmountLbl");
        String totalActualRakam = totalActual.getText().substring(1);

        double totalActualDouble = Double.parseDouble(totalActualRakam);

        System.out.println("actual total double " + totalActualDouble);

        Assert.assertEquals(totalActualDouble, total);


        Thread.sleep(10000);
        //close app
        driver.closeApp();

    }
}