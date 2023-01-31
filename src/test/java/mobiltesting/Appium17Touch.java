package mobiltesting;

import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;


public class Appium17Touch {

    @Test
    public void testName() throws MalformedURLException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "626c3e64");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability("appPackage", "com.touchboarder.android.api.demos");
        capabilities.setCapability("appActivity", "com.touchboarder.androidapidemos.MainActivity");
        capabilities.setCapability("noReset", "true");


        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);


        //'API Demos" butununa tikla
        Thread.sleep(1000);
        MobileElement apiDemosButton = driver.findElementByAndroidUIAutomator("UiSelector().text(\"API Demos\")");
        apiDemosButton.click();
        //"API Demos" sayfasinda olundugunu dogrula
        MobileElement apiDemosTitle = driver.findElementByAndroidUIAutomator("UiSelector().text(\"API Demos\")");
        Assert.assertEquals(apiDemosTitle.getText(), "API Demos");
        //"Views" butununa tikla
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Views\"))").click(); //scroll down to the element and click
        //"Views" sayfasinda olundugunu dogrula
        MobileElement viewsTitle = driver.findElementByAndroidUIAutomator("UiSelector().text(\"Views\")");
        Assert.assertEquals(viewsTitle.getText(), "Views");
        Thread.sleep(3000);
        //kullanici Drag and Drop butonuna tikladi
        MobileElement drag = driver.findElementByXPath("//android.widget.TextView[@text='Drag and Drop']");
        drag.click();
        Thread.sleep(3000);
        //kullanici birinci topu ikici topun ustune brakti
        MobileElement firstDot = driver.findElementById("com.touchboarder.android.api.demos:id/drag_dot_1");
        MobileElement secondDot = driver.findElementById("com.touchboarder.android.api.demos:id/drag_dot_2");
        //MobileElement thirdDot = driver.findElementById("com.touchboarder.android.api.demos:id/drag_dot_3");

        TouchAction touchAction = new TouchAction(driver);

        touchAction.longPress(ElementOption.element(firstDot))
                .moveTo(ElementOption.element(secondDot)).release().perform();

        //kullanici dorduncu topun gorunurlugunu dogrula
        MobileElement hiddenDot = driver.findElementById("com.touchboarder.android.api.demos:id/drag_dot_hidden");
        Assert.assertTrue(hiddenDot.isDisplayed());





















    }
}

