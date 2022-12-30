package tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ReusableMethods;

public class HepsiBuradaApp extends HepsiBase {

    @Test
    public void test() throws MalformedURLException, InterruptedException {
        AndroidDriver<MobileElement> driver = getAndroidDriver2();
        Thread.sleep(9000);
        MobileElement search = driver.findElementById("com.pozitron.hepsiburada:id/etSearchBox");
        search.click();
        driver.findElementById("com.pozitron.hepsiburada:id/etSearchBox").sendKeys("nutella");


        //[48,199][592,242]
        TouchAction t = new TouchAction(driver);
        // WebElement from = driver.findElementByXPath("//android.widget.Button[@bounds='[48,199][592,242]']");
        //WebElement to = driver.findElementByXPath("//android.widget.Button[@bounds='[0,2232][181,2263]']");
        //t.longPress(longPressOptions().withElement(element(from)).withDuration(ofSeconds(2))).release().perform();

        ////android.widget.TextView[@text='nutella']
        //android.widget.Toast[normalize-space='Please enter your name']
        //driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView[1]").click();


        ReusableMethods.wait(3);
        driver.findElementByXPath("//*[@class='suggestion-telPRb5gY5JtrMjuj62z' and text()='nutella']").click();


        driver.findElementByXPath("(//android.widget.Button[@content-desc=\"Sepete Ekle\"])[1]").click();
        ReusableMethods.wait(5);

        MobileElement toast = driver.findElementByXPath("//android.widget.Toast");
        ReusableMethods.wait(2);
        Assert.assertTrue(toast.isDisplayed());


        driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"Sepetim, 1 yeni bildirim\"]/android.widget.FrameLayout/android.widget.ImageView").click();
        ReusableMethods.wait(2);

        MobileElement basket = driver.findElementById("com.pozitron.hepsiburada:id/cartWebView");
        Assert.assertTrue(basket.isDisplayed());
        ReusableMethods.wait(3);




        //List<MobileElement> els1 = (MobileElement) driver.findElementsByXPath("//android.widget.Button[@content-desc=\"Sepete Ekle\"]");
        driver.findElementByXPath("//android.widget.Button[@text='Alışverişi tamamla']").click();
        ReusableMethods.wait(5);

        MobileElement login = driver.findElementByXPath("//btnLogin[@text='Giriş yap']");
        Assert.assertTrue(login.isDisplayed());


        driver.closeApp();


        /*
         // Find the element to delete
    MobileElement element = driver.findElement(By.xpath("#element-id"));

    // Check if the element is displayed
    if (element.isDisplayed()) {
      // If it is, click the delete button
      driver.findElement(By.xpath("#button")).click();
    }

         */

    }
}
