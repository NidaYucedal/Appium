package mobiltesting;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Appium06Amazon {

    @Test
    public void test() throws MalformedURLException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        //capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Administrator\\IdeaProjects\\Appium\\src\\apps\\Hepsiburada_ Online Shopping_5.5.10_Apkpure.apk");
        capabilities.setCapability("appPackage", "com.google.android.apps.nexuslauncher");
        capabilities.setCapability("appActivity", "com.google.android.apps.nexuslauncher.NexusLauncherActivity");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, "true");

        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        //driver.get("https://www.amazon.com");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement search=driver.findElementByAccessibilityId("Search");
        search.click();
        MobileElement amazon=driver.findElementById("com.google.android.googlequicksearchbox:id/search_box");
        amazon.sendKeys("amazon", Keys.ENTER);

        //asagidaki kod tel kilitli ise acmamizi sagliyor
        // if(driver.isDeviceLocked()){
        //     driver.unlockDevice();
        // }


        System.out.println(driver.getContext() + "<===app acildiginda");
        //burda aplikasyonu hangi turleri oldugunu gormek icin getContextHandles() kullaniyoruz
        Set<String> butunTurler = driver.getContextHandles();
        for(String tur: butunTurler){
            System.out.println(tur);
            if (tur.contains("WEBVIEW_chrome")){
                driver.context(tur);
            }

        }

        System.out.println(driver.getContext() + "<===app degistiginde");
        Thread.sleep(5000);
        MobileElement homeScreenLogo=driver.findElementByAccessibilityId("Amazon");
        Assert.assertTrue(homeScreenLogo.isDisplayed());

        //System.out.println(driver.getCurrentUrl());
        Thread.sleep(3000);
        MobileElement signInButton=driver.findElementByAccessibilityId("Sign in ›");
        signInButton.click();

       //  MobileElement welcomeText=driver.findElementByXPath("//android.widget.TextView[@text='Welcome']");
       //  Assert.assertEquals(welcomeText.getText(),"Welcome");

        Thread.sleep(3);
        //close session
        driver.closeApp();

        //driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.Button\").textStartsWith(\"add\")").click();




    }
}
