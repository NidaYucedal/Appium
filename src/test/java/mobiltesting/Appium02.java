package mobiltesting;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Appium02 {

    @Test
    public void test() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        //capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Administrator\\Desktop\\Appium\\Gesture Tool_1.3_Apkpure.apk");
       capabilities.setCapability("appPackage", "com.amazon.mShop.android.shopping");
       capabilities.setCapability("appActivity", "com.amazon.mShop.navigation.MainActivity");
       // capabilities.setCapability(MobileCapabilityType.NO_RESET, "true");
       capabilities.setCapability("disableAndroidWatchers", true);

        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        //driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Gesture Tool\"]").click();
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

       // MobileElement title=driver.findElementById("android:id/title");
       // Assert.assertTrue(title.isDisplayed());
       // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       // MobileElement test=driver.findElementById("com.davemac327.gesture.tool:id/testButton");
       // Assert.assertTrue(test.isEnabled());




    }
}