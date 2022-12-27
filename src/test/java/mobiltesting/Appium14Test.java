package mobiltesting;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;


public class Appium14Test {

    public AndroidDriver driver;

    @Test
    public void test() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "1312d4f50606");
        capabilities.setCapability("platformVersion", "10.0");
        capabilities.setCapability("automationName", "UiAutomator2");
        // capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Administrator\\IdeaProjects\\AppiumCucumberProject\\src\\apps\\Hepsiburada_ Online Shopping_5.5.10_Apkpure (1).apk");
        capabilities.setCapability("appPackage", " com.pozitron.hepsiburada");
        capabilities.setCapability("appActivity", "com.hepsiburada.ui.startup.SplashActivity");


        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElementByXPath("//android.widget.ImageView[@content-desc=\"Kendine bakanlar\"]").click();

        driver.findElementByXPath("//android.widget.ImageView[@content-desc=\"Dudak\"]").click();


    }
}