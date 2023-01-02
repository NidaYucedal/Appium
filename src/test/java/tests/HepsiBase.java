package tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class HepsiBase {

    @Test
    public static AndroidDriver getAndroidDriver2() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("platformVersion", "10.0");
        capabilities.setCapability("automationName", "UiAutomator2");
        //capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Administrator\\IdeaProjects\\AppiumCucumberProject\\src\\apps\\Hepsiburada_ Online Shopping_5.5.10_Apkpure (1).apk");
        capabilities.setCapability("appPackage", " com.pozitron.hepsiburada");
        capabilities.setCapability("appActivity", "com.hepsiburada.ui.startup.SplashActivity");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability("autoAcceptAlert",true);
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,"60000");


        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        return driver;








    }
}


//  String toastMessage = driver.findElement(By.xpath("//android.widget.Toast[1]")).getText();
//  assertEquals(toastMessage, "Expected toast message");
//WebElement element = driver.findElement(By.xpath("//div[@class='my-class']/button[1]"));