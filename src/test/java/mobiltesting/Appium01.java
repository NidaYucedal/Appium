package mobiltesting;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Appium01 {

    public Appium01() throws MalformedURLException {

    }


    @Test
    public void test() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        //capabilities.setCapability("platformName","Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Administrator\\Desktop\\Appium\\Gesture Tool_1.3_Apkpure.apk");
        capabilities.setCapability("appPackage","com.google.android.apps.nexuslauncher");
        capabilities.setCapability("appActivity","com.google.android.apps.nexuslauncher.NexusLauncherActivity");
        //app in izinleri atlayip anasayfada acilmasini istiyorsak
        capabilities.setCapability(MobileCapabilityType.NO_RESET, "true");

        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

       // driver.findElementByXPath("//android.view.View[@content-desc=\"Apps list\"]").click();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        //MobileElement gesture=driver.findElementByAccessibilityId("c89a0852-657b-4a9b-983c-d2b6a7089e5a");
       // gesture.click();

        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

       // MobileElement isdisplayed=driver.findElementById("android:id/title");
       // Assert.assertTrue(isdisplayed.isDisplayed());



        driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Chrome\"]").click();
        MobileElement search=driver.findElementById("com.android.chrome:id/url_bar");
        //com.android.chrome:id/search_box_text
        search.sendKeys("hepsiBurada", Keys.ENTER);

    }
}
