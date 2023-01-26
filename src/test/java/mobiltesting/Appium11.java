package mobiltesting;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


public class Appium11 {

    @Test
    public void test() throws MalformedURLException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "626c3e64");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability("appPackage", "com.touchboarder.android.api.demos");
        capabilities.setCapability("appActivity", "com.touchboarder.androidapidemos.MainActivity");
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


        String isChecked = driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"android:id/checkbox\").checkable(true)").getAttribute("checked");
        System.out.println(isChecked + "---->");
        if (isChecked.equals("false")) {
            driver.findElementById("android:id/checkbox").click();

            /*
            MobileElement wiFiSetting = driver.findElementByXPath("//android.widget.TextView[@text='WiFi settings']");
MobileElement wiFiCheckBox = driver.findElementById("android:id/checkbox");

if(!wiFiSetting.isEnabled()) {
    wiFiCheckBox.click();
}
             */
        }

        //click to check box
        MobileElement checkBoxButton = driver.findElementById("android:id/checkbox");
        checkBoxButton.click();

        //WiFi settings click
        MobileElement wifiSettingsButton = driver.findElementByXPath("//android.widget.TextView[@text='WiFi settings']");
        wifiSettingsButton.click();

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


        //API Demos" butununa tikla
        //Views" butununa tikladi
        //Expandable Lists" butununa tikla
        //"Views/Expandable Lists" ekrani dogrula
        //1. Custom Adapter" butununa tikla
        //People Names" butununa tikla
        //Chuck" butununa uzun bas
        //"Sample menu" ekrani dogrula

    }
}