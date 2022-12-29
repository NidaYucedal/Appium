package tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import utilities.ReusableMethods;

public class HepsiBuradaApp extends HepsiBase {

    @Test
    public void test() throws MalformedURLException, InterruptedException {
        AndroidDriver<MobileElement> driver = getAndroidDriver();
        Thread.sleep(9000);
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ReusableMethods.wait(5);
        MobileElement search=driver.findElementById("com.pozitron.hepsiburada:id/etSearchBox");
        ReusableMethods.waitToBeClickable(search,5);
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


        ReusableMethods.wait(5);
        driver.findElementByXPath("//*[@class='suggestion-telPRb5gY5JtrMjuj62z' and text()='nutella']").click();
        ReusableMethods.wait(2);

        // driver.findElementByXPath("//android.widget.ImageView[@content-desc=\"Dudak\"]");
        ReusableMethods.wait(5);

    }
}
