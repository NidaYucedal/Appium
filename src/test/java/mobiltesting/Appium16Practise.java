package mobiltesting;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Appium16Practise {

    @Test
    public void test() throws MalformedURLException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "1312d4f50606");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        //capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Administrator\\IdeaProjects\\AppiumPractise\\src\\apps\\apiDemos.apk");
        capabilities.setCapability("appPackage", "com.touchboarder.android.api.demos");
        capabilities.setCapability("appActivity", "com.touchboarder.androidapidemos.MainActivity");
        capabilities.setCapability("noReset", "true");


        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);


        //"API Demos" butununa tikladi
        //"API Demos" ekrani dogrula
        //"Views" butununa tikladi
        //"Views" ekrani dogrula
        //"Date Widgets" butununa tikla
        //"Views/Date Widgets" ekrani dogrula
        //"2. Inline" butununa tikla
        //9 a tiklasin
        //15 ten 45 e yesil topu kaydir


        //API Demos" butununa tikla
        MobileElement apiDemos = driver.findElementByXPath("//android.widget.TextView[@text='API Demos']");
        apiDemos.click();
        MobileElement apiDemosTitle = driver.findElementByAndroidUIAutomator("UiSelector().text(\"API Demos\")");
        Assert.assertEquals(apiDemosTitle.getText(), "API Demos");
        Thread.sleep(1000);

        //Views" butununa tikladi
        MobileElement views = driver.findElementByXPath("//android.widget.TextView[@text='Views']");
        views.click();
        MobileElement viewsTitle = driver.findElementByAndroidUIAutomator("UiSelector().text(\"Views\")");
        Assert.assertEquals(viewsTitle.getText(), "Views");
        Thread.sleep(1000);

        //"Date Widgets" butununa tikla
        MobileElement datesWidgets = driver.findElementByAndroidUIAutomator("UiSelector().text(\"Date Widgets\")");
        datesWidgets.click();

        //"Views/Date Widgets" ekrani dogrula
        MobileElement datesWidgetsTitle = driver.findElementByAndroidUIAutomator("UiSelector().text(\"Views/Date Widgets\")");
        Assert.assertEquals(datesWidgetsTitle.getText(), "Views/Date Widgets");

        //"2. Inline" butununa tikla
        MobileElement inlineTwo = driver.findElementByAndroidUIAutomator("UiSelector().text(\"2. Inline\")");
        inlineTwo.click();

        //9 a tiklasin
        MobileElement nine = driver.findElementByAccessibilityId("9");
        nine.click();
        Thread.sleep(2000);

        //15 ten 45 e yesil topu kaydir
        MobileElement fifteen = driver.findElementByAccessibilityId("15");
        MobileElement fourtyFive = driver.findElementByAccessibilityId("45");
        TouchAction touchAction = new TouchAction<>(driver);
        touchAction.press(ElementOption.element(fifteen))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
                .moveTo(ElementOption.element(fourtyFive)).release().perform();


    }
}
