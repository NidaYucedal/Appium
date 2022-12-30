package utilities;


import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class ReusableMethods {


    //HARD WAIT WITH THREAD.SLEEP
    //waitFor(5);  => waits for 5 second
    public static void waitFor(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //elementlerin textlerine gore tiklar
    public static void tapOnElementWithText(String text) {
        List<MobileElement> mobileElementList = Driver.getAppiumDriver().findElementsByClassName("android.widget.TextView");
        for (MobileElement page : mobileElementList) {
            if (page.getText().equals(text)) {
                page.click();
            } else {
                scrollWithUiScrollable(text);
            }
            break;
        }
    }

    //ikinci alternatif bir method
    public static void clickOnElementWithText(String elementText) throws InterruptedException {
        Thread.sleep(4000);
        List<MobileElement> mobileElementList = Driver.getAppiumDriver().findElementsByXPath("//android.widget.TextView[@text='" + elementText + "']");
        if (mobileElementList.size() > 0) {
            mobileElementList.get(0).click();
        } else scrollWithUiScrollable(elementText);
    }


    //butun elementleri aldim text olarak elementimi tanimladim
    //eger text elementimi iceriyorsa
    //visible olmasini bekle true don
    public static boolean isElementPresent(String text) {
        boolean elementFound = false;
        List<MobileElement> mobileElementList = Driver.getAppiumDriver().findElementsByXPath("//android.widget.TextView[@text='" + text + "']");
        for (MobileElement el : mobileElementList) {
            if (el.getText().equals(text)) {
                waitToBeVisible(el, 10);
                if (el.isDisplayed()) {
                    elementFound = true;
                }
            }
        }
        return elementFound;
    }

    public static void wait(int second) {
        try {
            Thread.sleep(second * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //element gorunene kadar bekler click yapar
    public static void tapOn(MobileElement element) {
        waitToBeClickable(element, 10);
        element.click();
    }

    //sendkeys
    public static void enterText(MobileElement element, String text) {
        waitToBeClickable(element, 10);
        element.sendKeys(text);
    }

    //sendkeys 3 parametreli text dolu ise siliyor sonra send yapıyor
    public static void enterText(MobileElement element, String text, boolean needClear) {
        waitToBeClickable(element, 10);
        if (needClear) {
            element.clear();
        }
        element.sendKeys(text);
    }

    //element gorunuyor mu gorunmuyor mu
    //akıllı waitler 6. saniyede elementi bulursa geciyor 10 saniye beklemiyor
    public static boolean isElementPresent(MobileElement mobileElement) {
        boolean elementFound = false;
        waitToBeVisible(mobileElement, 10);
        if (mobileElement.isDisplayed()) {
            elementFound = true;
        }
        return elementFound;
    }

    //element gorunene kadar bekle
    public static void waitToBeVisible(MobileElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getAppiumDriver(), timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitToBeClickable(MobileElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getAppiumDriver(), timeout);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void scrollWithUiScrollable(String elementText) {
        AndroidDriver<MobileElement> driver = (AndroidDriver) Driver.getAppiumDriver();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + elementText + "\"))");
        tapOn(driver.findElementByXPath("//android.widget.TextView[@text='" + elementText + "']"));
    }


    public static void setNumber(String no) {
        TouchAction touchAction = new TouchAction<>(Driver.getAppiumDriver());
        String[] sayi = no.split("");
        System.out.println(Arrays.toString(sayi));
        for (int i = 0; i < sayi.length; i++) {
            ReusableMethods.waitFor(2);
            switch (sayi[i]) {
                case "0":
                    touchAction.tap(PointOption.point(414, 2138)).perform();
                    break;
                case "1":
                    touchAction.tap(PointOption.point(133, 1797)).perform();
                    break;
                case "2":
                    touchAction.tap(PointOption.point(402, 1797)).perform();
                    break;
                case "3":
                    touchAction.tap(PointOption.point(680, 1797)).perform();
                    break;
                case "4":
                    touchAction.tap(PointOption.point(133, 1916)).perform();
                    break;
                case "5":
                    touchAction.tap(PointOption.point(402, 1916)).perform();
                    break;
                case "6":
                    touchAction.tap(PointOption.point(680, 1916)).perform();
                    break;
                case "7":
                    touchAction.tap(PointOption.point(133, 2064)).perform();
                    break;
                case "8":
                    touchAction.tap(PointOption.point(402, 2064)).perform();
                    break;
                case "9":
                    touchAction.tap(PointOption.point(680, 2064)).perform();
                    break;

            }

        }
    }

    public static void waitToast(MobileElement element, int timeout) {
        // Set the implicit wait timeout to 10 seconds
        WebDriverWait wait = new WebDriverWait(Driver.getAppiumDriver(), timeout);
        wait.until(ExpectedConditions.visibilityOf(element));

        // Wait until the toast message becomes visible
        Driver.getAppiumDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Toast[1]")));
        String toastMessage = Driver.getAppiumDriver().findElement(By.xpath("//android.widget.Toast[1]")).getText();
    }



    //  @Test
    //  public void testScroll()throws Exception
    //  {
    //      for(int i=0;i<4;i++)
    //      {
    //          Thread.sleep(2000);
    //          if (driver.findElement(By.name("end_item")).isDisplayed())
    //          {
    //              driver.findElement(By.name("end_item")).click();
    //              break;
    //          }
    //          else
    //          {
    //              horizontalScroll();
    //          }
//
    //      }
    //  }
    //  public void verticalScroll()
    //  {
    //      size=driver.manage().window().getSize();
    //      int y_start=(int)(size.height*0.60);
    //      int y_end=(int)(size.height*0.30);
    //      int x=size.width/2;
    //      driver.swipe(x,y_start,x,y_end,4000);
    //  }
}