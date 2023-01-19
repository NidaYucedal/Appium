package mobiltesting;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class WebAppChrome {


    @Test
    public void test() throws MalformedURLException, InterruptedException {


        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "626c3e64");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "6000");

        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
        //chrome eski ise bunun ile execute yapalim
        capabilities.setCapability("chromeDriverExecutable", "C:\\Users\\Administrator\\IdeaProjects\\AppiumPractise\\src\\driver\\chromedriver.exe");

        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        //chrome güncelleme için
        //https://chromedriver.storage.googleapis.com/index.html

        driver.get("https://www.amazon.com");

        System.out.println("driver.getContext() = " + driver.getContext());

        MobileElement logo = driver.findElementByCssSelector(".nav-left");
        Assert.assertTrue(logo.isDisplayed());
        Thread.sleep(3000);

        MobileElement sign = driver.findElementByCssSelector("#nav-logobar-greeting");
        sign.click();
        Thread.sleep(3000);

        MobileElement welocome = driver.findElementByTagName("h2");
        Assert.assertTrue(welocome.isDisplayed());

        System.out.println("welcome sayfasi = " + driver.getContext());


    }
}
