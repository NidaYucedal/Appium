package mobiltesting;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Appium01 {

    TouchAction touchAction;
    private static Logger logger = LogManager.getLogger(Appium01.class.getName());

    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        //"autoGrantPermissions": Test edilecek cihazda uygulamanın izinlerinin otomatik olarak onaylanması isteniyorsa true olarak set edilir.
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "626c3e64");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        //capabilities.setCapability(MobileCapabilityType.APP,"");
        capabilities.setCapability("appPackage", "com.google.android.apps.maps");
        capabilities.setCapability("appActivity", "com.google.android.maps.MapsActivity");
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("disableAndroidWatchers", true);

        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        touchAction = new TouchAction(driver);


        //touchAction.tap(PointOption.point(920, 429)).perform();

         MobileElement shopping = driver.findElementByXPath("//android.widget.Button[@content-desc=\"Benzin için arama yapın\"]");

         touchAction.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(shopping)))
          .moveTo(ElementOption.element(driver.findElementByXPath("//android.widget.Button[@content-desc=\"Restoranlar için arama yapın\"]"))).release().perform();

        //  int startX = shopping.getLocation().getX();
        //  int startY = shopping.getLocation().getY();

        //  MobileElement otel = driver.findElementByXPath("//android.widget.Button[@content-desc=\"Oteller için arama yapın\"]");
        //  int endX = otel.getLocation().getX();
        //  int endY = otel.getLocation().getY();


        //        getDriver().findElement(MobileBy.AndroidUIAutomator(""new UiScrollable(new UiSelector().scrollable(true).instance(0)).setAsHorizontalList().scrollIntoView(new UiSelector().text(\""+textToSearch+"\"))")).click();
        //  touchAction.press(PointOption.point(startX, startY))
        //          .waitAction()
        //          .moveTo(PointOption.point(endX, endY))
        //          .release()
        //          .perform();


        logger.info("ekranda yana kaydırma yapildi");

        // MobileElement search = driver.findElementByXPath("//android.widget.TextView[@text='Burada arayın']");
        // search.click();
        // Thread.sleep(3000);
        // search.sendKeys("Istanbul \n");
        // ReusableMethods.wait(3);
        // MobileElement istanbul = driver.findElementByXPath("//android.widget.TextView[@text='İstanbul Havalimanı (IST)']");
        // istanbul.click();

        logger.info("istanbul havalimanı araması yapildi");

        ReusableMethods.wait(3);
        // MobileElement istanbulisVisible = driver.findElementByXPath("//android.widget.TextView[@text='İstanbul Havalimanı']");
        // Assert.assertEquals(istanbulisVisible.getText(), "İstanbul Havalimanı");


        logger.info("istanbul havalimanı araması yapildigi dogrulandi");


        //   Dimension dimension= driver.manage().window().getSize();
//
        //   int start_x= (int) (dimension.width*0.5);
        //   int start_y= (int) (dimension.height*0.8);
//
        //   int end_x= (int) (dimension.width*0.5);
        //   int end_y= (int) (dimension.height*0.2);
//
        //   TouchAction touchAction=new TouchAction<>(driver);
        //   touchAction.press(PointOption.point(start_x,start_y))
        //           .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
        //           .moveTo(PointOption.point(end_x,end_y)).perform();

        //
        // Location location = new Location(28.6520,77.2315, 830);
        // driver.setLocation(location);
        // Thread.sleep(10000);

        //zoom
       int startX1 = 720;
       int startY1 = 1953;

       int startX2 = 250;
       int startY2 = 505;

       touchAction.press(PointOption.point(startX1, startY1))
               .waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))
               .moveTo(PointOption.point(startX2, startY2))
               .waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))
               .release()
               .perform();


    }
}
