package mobiltesting;


import appium.BaseClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


public class Appium10ApiDemos  {


    @Test
    public void test() throws MalformedURLException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "1312d4f50606");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Administrator\\IdeaProjects\\AppiumPractise\\src\\apps\\apiDemos.apk");
        capabilities.setCapability("noReset", "true");


        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        System.out.println("App installed");


        //api demos butonuna tikla
        MobileElement apiDemos = driver.findElementByXPath("//android.widget.TextView[@text='API Demos']");
        apiDemos.click();
        Thread.sleep(300);

        //preference butonuna tikla
        MobileElement preferenceButton = driver.findElementByXPath("//android.widget.TextView[@text='Preference']");
        preferenceButton.click();

        //preference dependencies butonuna tikla
        MobileElement preferenceDependencies = driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']");
        preferenceDependencies.click();

        //click to check box
        MobileElement checkBoxButton = driver.findElementById("android:id/checkbox");
        checkBoxButton.click();

        //WiFi settings click
        MobileElement wifiSettingsButton = driver.findElementByXPath("//android.widget.TextView[@text='WiFi settings']");
        wifiSettingsButton.click();

        Thread.sleep(5000);
        //Wifi settings yazisinin gorunurlugunu dogrula
        MobileElement wifiSettingIsDisplayed = driver.findElementByXPath("android:id/alertTitle");
        Assert.assertTrue(wifiSettingIsDisplayed.isDisplayed());
        Thread.sleep(300);

        //Wifi settings text box a metin gonder
        MobileElement wifiSettingsTextbox = driver.findElementById("android:id/edit");
        wifiSettingsTextbox.sendKeys("first");

        Thread.sleep(3000);
        //ok butonuna bas
        MobileElement okButton = driver.findElementById("android:id/button1");
        okButton.click();

        System.out.println("Mission Completed");
        //close the session
        driver.closeApp();












    }
}
