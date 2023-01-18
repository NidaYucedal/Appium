package mobiltesting;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

public class Appium07NativeChrome {

    @Test
    public void test() throws MalformedURLException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "626c3e64");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability("appPackage", "com.android.chrome");
        capabilities.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        capabilities.setCapability("noReset", "true");


        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        driver.get("https://www.amazon.com");

        //asagidaki kod tel kilitli ise acmamizi sagliyor
        if (driver.isDeviceLocked()) {
            driver.unlockDevice();
        }


        System.out.println(driver.getContext() + "<===app acildiginda");
        //burda aplikasyonu hangi turleri oldugunu gormek icin getContextHandles() kullaniyoruz
        Set<String> butunTurler = driver.getContextHandles();
        for (String tur : butunTurler) {
            System.out.println(tur);
            if (tur.contains("WEBVIEW_chrome")) {  //eğer web varsa seç ve set et
                driver.context(tur);
            }

            //app native olarak devam ettiği için web app e geçemedik
            //swtich işlemi yapamadık
            //Set<String> contextNames = driver.getContextHandles();
            //driver.context(contextNames.toArray()[1]);
        }

        System.out.println(driver.getContext() + "<=== app degistiginde");
        Thread.sleep(5000);
        MobileElement homeScreenLogo = driver.findElementByAccessibilityId("Amazon");
        Assert.assertTrue(homeScreenLogo.isDisplayed());
        System.out.println("Ana sayfadayiz");
        Thread.sleep(3000);

        ////android.widget.TextView[@text='Sign in ›']
        MobileElement signInButton = driver.findElementByXPath("//android.view.View[@content-desc=\"Sign in ›\"]/android.widget.TextView");
        signInButton.click();


        Thread.sleep(5000);
        MobileElement welcomeText = driver.findElementByXPath("//android.widget.TextView[@text='Welcome']");
        Assert.assertEquals(welcomeText.getText(), "Welcome");


        System.out.println("Test bitti");
        Thread.sleep(3);
        //close session
        driver.closeApp();


    }
}



