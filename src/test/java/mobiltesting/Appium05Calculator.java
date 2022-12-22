package mobiltesting;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Appium05Calculator {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
       // capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Administrator\\IdeaProjects\\Appium\\src\\apps\\Calculator_8.3 (477856174)_Apkpure.apk");


        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(734, 1006)).
                waitAction(new WaitOptions().withDuration(Duration.ofMillis(600))).
                moveTo(PointOption.point(734, 1006)).release().perform();

        driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Calculator\"]").click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        MobileElement num1 = driver.findElementById("com.google.android.calculator:id/digit_1");
        MobileElement num2 = driver.findElementById("com.google.android.calculator:id/digit_2");
        MobileElement num3 = driver.findElementById("com.google.android.calculator:id/digit_3");
        MobileElement num4 = driver.findElementById("com.google.android.calculator:id/digit_4");
        MobileElement num5 = driver.findElementById("com.google.android.calculator:id/digit_5");
        MobileElement num6 = driver.findElementById("com.google.android.calculator:id/digit_6");
        MobileElement num7 = driver.findElementById("com.google.android.calculator:id/digit_7");
        MobileElement num8 = driver.findElementById("com.google.android.calculator:id/digit_8");
        MobileElement num9 = driver.findElementById("com.google.android.calculator:id/digit_9");
        MobileElement num0 = driver.findElementById("com.google.android.calculator:id/digit_0");

        MobileElement plus = driver.findElementByAccessibilityId("plus");
        MobileElement multiply = driver.findElementByAccessibilityId("multiply");
        MobileElement divide = driver.findElementByAccessibilityId("divide");
        MobileElement minus = driver.findElementByAccessibilityId("minus");

        MobileElement equal = driver.findElementByAccessibilityId("equals");


        num1.click();
        num2.click();
        plus.click();
        num4.click();
        num5.click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        MobileElement preResult = driver.findElementById("com.google.android.calculator:id/result_preview");
        System.out.println("Pre result "+ preResult.getText());
        String preResultText = preResult.getText();

        equal.click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        MobileElement result = driver.findElementById("com.google.android.calculator:id/result_final");
        System.out.println("final result " + result.getText());

        Assert.assertEquals(result.getText(),preResultText);

    }
}