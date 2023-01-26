package mobiltesting;

import io.appium.java_client.MobileElement;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import io.appium.java_client.TouchAction;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Appium14Test {

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

        //capabilities.setCapability("appPackage", "com.amazon.mShop.android.shopping");
        //capabilities.setCapability("appActivity", "com.amazon.mShop.navigation.MainActivity");
        capabilities.setCapability("disableAndroidWatchers", true);
        //com.dolap.android/com.dolap.android.home.v1.ui.activity.MainActivity

        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        //API Demos app'ini android cihazda baslat ve API DEMOS simgesine tiklayarak animasyonu ekranda 5 sn boyunca goster
//'API Demos" butununa tikla
//"API Demos" sayfasinda olundugunu dogrula
//"Views" butununa tikla (scroll islemi UiSelector()'de UiScrollable() ile yapilabilir)
//"Views" sayfasinda olundugunu dogrula
//"Expandable Lists" butununa tikla
//"Views/Expandable Lists" ekranini dogrula
//"1. Custom Adapter" butununa tikla
//"People Names" butununa tikla
//"Chuck" butununa uzun bas
//"Sample menu" ekranini dogrula
        //API Demos" butununa tikla
        MobileElement api=driver.findElementByXPath("//android.widget.ImageView");
        api.click();
        Thread.sleep(5000);
        MobileElement area=driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View");
        area.click();
        Thread.sleep(200);


        MobileElement apiDemos = driver.findElementByXPath("//android.widget.TextView[@text='API Demos']");
        apiDemos.click();
        Thread.sleep(200);

        //Views" butununa tikladi
        MobileElement views = driver.findElementByXPath("//android.widget.TextView[@text='Views']");
        views.click();
        Thread.sleep(200);

        //Expandable Lists" butununa tikla
        MobileElement lists = driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']");
        lists.click();
        Thread.sleep(200);

        //"Views/Expandable Lists" ekrani dogrula
        MobileElement verfiy = driver.findElementByXPath("//android.widget.TextView[@text='Views/Expandable Lists']");
        Assert.assertTrue(verfiy.isDisplayed());
        Thread.sleep(200);

        //1. Custom Adapter" butununa tikla
        MobileElement adapter = driver.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']");
        adapter.click();
        Thread.sleep(200);

        //People Names" butununa tikla
        MobileElement peopleNames = driver.findElementByXPath("//android.widget.TextView[@text='People Names']");
        peopleNames.click();
        Thread.sleep(200);

        //Chuck" butununa uzun bas
        MobileElement chuck = driver.findElementByXPath("//android.widget.TextView[@text='Chuck']");
        Actions actions = new Actions(driver);
        actions.moveToElement(chuck).clickAndHold().pause(Duration.ofSeconds(4)).release().build().perform();

        // TouchAction touchAction = new TouchAction(driver);
        // touchAction.longPress(LongPressOptions.longPressOptions()
        //                 .withElement(ElementOption.element(driver.findElementByXPath("//android.widget.TextView[@text='Chuck']"))))
        //         .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3))).release().perform();


        Thread.sleep(300);

        //"Sample menu" ekrani dogrula
        MobileElement sampleMenu = driver.findElementByXPath("//android.widget.TextView[@text='Sample menu']");
        Assert.assertTrue(sampleMenu.isDisplayed());
        Thread.sleep(200);

        //API Demos app'ini android cihazda baslat ve API DEMOS simgesine tiklayarak animasyonu ekranda 5 sn boyunca goster
        MobileElement mainPageAPIDemos = driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.ImageView\").index(0)");
        mainPageAPIDemos.click();
        Thread.sleep(1000);
        MobileElement animationPage = driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.view.View\")");
        animationPage.click();
        //'API Demos" butununa tikla
        Thread.sleep(1000);
        MobileElement apiDemosButton = driver.findElementByAndroidUIAutomator("UiSelector().text(\"API Demos\")");
        apiDemosButton.click();
        //"API Demos" sayfasinda olundugunu dogrula
        MobileElement apiDemosTitle= driver.findElementByAndroidUIAutomator("UiSelector().text(\"API Demos\")");
        Assert.assertEquals(apiDemosTitle.getText(), "API Demos");
        //"Views" butununa tikla
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Views\"))").click(); //scroll down to the element and click
        //"Views" sayfasinda olundugunu dogrula
        MobileElement viewsTitle= driver.findElementByAndroidUIAutomator("UiSelector().text(\"Views\")");
        Assert.assertEquals(viewsTitle.getText(), "Views");
        //"Expandable Lists" butununa tikla
        MobileElement expandableListsButton= driver.findElementByAndroidUIAutomator("UiSelector().textContains(\"pandable\")");
        expandableListsButton.click();
        //"Views/Expandable Lists" ekranini dogrula
        MobileElement viewsExpandableListsTitle= driver.findElementByAndroidUIAutomator("UiSelector().textContains(\"Views/Expandable\")");
        Assert.assertEquals(viewsExpandableListsTitle.getText(), "Views/Expandable Lists");
        //"1. Custom Adapter" butununa tikla
        MobileElement customAdaptor = driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.TextView\").index(0)");
        customAdaptor.click();
        //"People Names" butununa tikla
        MobileElement peopleNamesButton = driver.findElementByAndroidUIAutomator("UiSelector().text(\"People Names\")");
        peopleNamesButton.click();
        //"Chuck" butununa uzun bas
        MobileElement chuckButton = driver.findElementByAndroidUIAutomator("UiSelector().text(\"Chuck\")");
        actions.clickAndHold(chuckButton).perform();
        //"Sample menu" ekranini dogrula
        Thread.sleep(1000);
        MobileElement sampleMenuTitle = driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"android:id/alertTitle\")");
        Assert.assertEquals(sampleMenuTitle.getText(), "Sample menu");

        Thread.sleep(5000);
        driver.closeApp();


    }
}