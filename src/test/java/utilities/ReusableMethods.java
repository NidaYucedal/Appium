package utilities;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;


public class ReusableMethods {


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

    public static void scrollDownToBeVisible(MobileElement element) {

    }

    public static void scrollUpToBeVisible(MobileElement element) {

    }

    public static void swipeFromElementToElement(MobileElement el1, MobileElement el2) {

    }
//attribute check


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