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
import java.util.Set;

public class ECommerceTotalAmountValidation06 extends BaseECommerceApp {


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
        addButton1.click();



        //2. urune kadar scroll yap
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan Lift Off\"))");

        MobileElement ikiciUrunAddButton = driver.findElementByXPath("((//android.widget.TextView[@text='Jordan Lift Off']//following-sibling::*)[2]//following-sibling::*)[2]");
        ikiciUrunAddButton.click();

        driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
        Thread.sleep(5000);
        //sepette ol
        Assert.assertTrue(driver.findElementById("com.androidsample.generalstore:id/toolbar_title").isDisplayed());

        //ilk urunun adi Air Jordan 4 Retro
        Assert.assertEquals(driver.findElementByXPath("//android.widget.TextView[@text='Air Jordan 4 Retro']").getText(), "Air Jordan 4 Retro");

        //ikinci urun adi = Air Jordan 1 Mid SE
        //eger scroll yapmayacaksak alttaki urunu acip digerini yoruma lain
        Assert.assertEquals(driver.findElementByXPath("//android.widget.TextView[@text='Jordan Lift Off']").getText(), "Jordan Lift Off");
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

        MobileElement termButton = driver.findElementById("com.androidsample.generalstore:id/termsButton");
        driver.findElementByXPath("//android.widget.CheckBox").click();

        TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(termButton))
                .withDuration(Duration.ofSeconds(2))).release().perform();

        Assert.assertTrue(driver.findElementById("com.androidsample.generalstore:id/alertTitle").isDisplayed());
        Thread.sleep(2000);
        driver.findElementById("android:id/button1").click();
        Thread.sleep(2000);
        System.out.println(driver.getContext() + "<=======proceed butonuna basmadan onceki context");
        driver.findElementById("com.androidsample.generalstore:id/btnProceed").click();
        Thread.sleep(5000);
        System.out.println(driver.getContext() + "<=======proceed butonuna bastiktan sonraki context - driver hala native de");

        Set<String> butunturler = driver.getContextHandles();
        for (String tur : butunturler) {
            System.out.println(tur);
            if (tur.contains("WEBVIEW")) {
                driver.context("WEBVIEW_chrome");
            }
        }

        Thread.sleep(5000);
        System.out.println(driver.getContext() + " web view gectik");
        Thread.sleep(5000);



        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("appium" + Keys.ENTER);

        Thread.sleep(5000);
        System.out.println(driver.getContext() + " web view deyiz");

        Set<String> butunturler1 = driver.getContextHandles();
        for (String tur : butunturler1) {
            System.out.println(tur);
            if (tur.contains("NATIVE")) {
                driver.context(tur);
            }
        }

        driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));

        System.out.println(driver.getContext() + " native deyiz");
        Thread.sleep(10000);
        //close app
        driver.closeApp();







    }
}