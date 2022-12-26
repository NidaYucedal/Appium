package mobiltesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.URL;
import java.net.MalformedURLException;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Appium13BrowserCalculator {


    @Test
    public void browser() throws MalformedURLException, InterruptedException {


        DesiredCapabilities caps = new DesiredCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", "nidayucedal_nKI8Zh");
        caps.setCapability("browserstack.key", "2UNicaiBy5tjTytLhmy8");

        // Set URL of the application under test
        caps.setCapability("app", "bs://0f41354519b69d6c14003f5e30a6ae8968aa003d");

        // Specify device and os_version for testing
        caps.setCapability("device", "Google Pixel 3");
        caps.setCapability("os_version", "9.0");

        // Set other BrowserStack capabilities
        caps.setCapability("project", "First Java Project");
        caps.setCapability("build", "browserstack-build-1");
        caps.setCapability("name", "first_test");


        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
                new URL("http://hub.browserstack.com/wd/hub"), caps);

        // Write your test case statements here

        driver.findElementById("com.google.android.calculator:id/digit_5").click();
        Thread.sleep(5000);

        driver.findElementByAccessibilityId("plus").click();
        driver.findElementById("com.google.android.calculator:id/digit_5").click();
        Thread.sleep(3000);

        driver.findElementByAccessibilityId("equals").click();

        Thread.sleep(5000);
        Assert.assertEquals(driver.findElementById("com.google.android.calculator:id/result_preview").getText(),"10");




        // Invoke driver.quit() after the test is done to indicate that the test is completed.
        driver.quit();

    }


}
