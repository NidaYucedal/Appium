package ECommerceApp;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.net.MalformedURLException;

import static org.testng.AssertJUnit.assertEquals;

public class ECommerceNegativeLogin01 extends BaseECommerceApp {

    /*

    //1- Fill the form details and verify Toast error messages displayed appropriately for wrong inputs
    //1- hatali data ile form doldurdugunuzda hata mesajini dogrulayin
    //2-Shop the items in the app by scrolling to specific Product and add to cart
    //3-Validate if the items selected in the page 2 are matching with the items displayed in check out page
    //4- Validate the total Amount displayed in the checkout page matches with sum of product amounts selected for shopping
    //5-Validate Mobile gestures working for link (long press) and navigate to WebView 
    //6-Verify if user can do operations on Web view and navigate back to native app if needed.
    (go to google and search “appium” then navigate to NATIVE APP and verify it)
     */


    @Test
    public void negativeTest() throws MalformedURLException, InterruptedException {
        AndroidDriver<MobileElement> driver = getAndroidDriver();
        Thread.sleep(7000);
        //1- Fill the form details and verify Toast error messages displayed appropriately for wrong inputs
        //1- hatali data ile form doldurdugunuzda hata mesajini dogrulayin

        Thread.sleep(5000);
        MobileElement countrySpinner = driver.findElementById("spinnerCountry");


        MobileElement nameBox = driver.findElementById("com.androidsample.generalstore:id/nameField");
        MobileElement femaleRadioButton = driver.findElementById("com.androidsample.generalstore:id/radioFemale");
        MobileElement letsShopButton = driver.findElementById("com.androidsample.generalstore:id/btnLetsShop");


        //ulkeyi secmek icin ulke butununa bastik
        //countrySpinner.click();
        //ulkeyi sececegiz
        Thread.sleep(4000);
       // MobileElement expectedCountry = driver.findElementByXPath("//android.widget.TextView[@text='Angola']");
       // expectedCountry.click();
        //Thread.sleep(5000);
        //istedigimiz ulkeyi dogru olarak sectik mi?
       // MobileElement selectedCountry = driver.findElementByXPath("//android.widget.TextView[@text='Angola']");
       // System.out.println(selectedCountry.getText());
       // Assert.assertEquals(selectedCountry.getText(), "Angola");
        //Thread.sleep(3000);
        //negative case icin name bos olmali
        //Assert.assertTrue(nameBox.getText().isEmpty());
        nameBox.clear();
        //female secilsin
        femaleRadioButton.click();
        //shop butonuna tiklayalim
        letsShopButton.click();
        ReusableMethods.wait(5);
        //hata mesajini onayla


        Thread.sleep(2000);
        MobileElement errorPopUpText = driver.findElementByXPath("//android.widget.Toast");
        String errorText = errorPopUpText.getText();
        Assert.assertEquals(errorText, "Please enter your name");


        String toastMessage = driver.findElement(By.xpath("//android.widget.Toast[1]")).getText();
        assertEquals(toastMessage, "Please enter your name");

      //  boolean found = false;
      //  for (int i = 0; i < 8; i++) {
      //      if (Driver.getAppiumDriver().getPageSource().contains("class=\"android.widget.Toast\" text=\"" + errorPopUpText + "\"")) {
      //          found = true;
      //          break;
      //      }
      //      Thread.sleep(300);
      //  }
      //  Assert.assertTrue(found, "toast message " + errorPopUpText + " is present");

        //waitForToast.until(ExpectedConditions.presenceOfElementLoacted(By.xpath("/hierarchy/android.widget.Toast")));
        //
        //String toastMessage = driver.findElement((By.xpath("/hierarchy/android.widget.Toast")).getText();
        //
        //System.out.println(toastMessage);
        //MobileElement errorPopUpText = driver.findElementByXPath("//android.widget.Toast[normalize-space()='Please enter your name']");
        //android.widget.Toast[normalize-space='Please enter your name']
        ////android.widget.Toast[@text='Please enter your name']
        //ReusableMethods.waitToBeVisible(errorPopUpText,5);
        //String errorText = errorPopUpText.getText();
        //Assert.assertEquals(errorText, "Please enter your name");

        //close app
        //driver.closeApp();


        //WebDriverWait waitForToast = new WebDriverWait(driver.25);
        //
        //waitForToast.until(ExpectedConditions.presenceOfElementLoacted(By.xpath("/hierarchy/android.widget.Toast")));
        //
        //String toastMessage = driver.findElement((By.xpath("/hierarchy/android.widget.Toast")).getText();
        //
        //System.out.println(toastMessage);


        /*
        public void verifyToastMessageUsingPageSource(String toastmsg) throws InterruptedException {
    boolean found = false;
    for(int i =0 ; i <8; i++){
      if(getDriver().getPageSource().contains("class=\"android.widget.Toast\" text=\""+toastmsg+"\"")){
        found = true;
        break;
      }
      Thread.sleep(300);
    }
    Assert.assertTrue(found,"toast message "+toastmsg+" is present");
  }


  WebElement toastView = androidDriver.findElement(By.xpath("/hierarchy/android.widget.Toast[1]"));
 String text = toastView.getAttribute("name");
         */
    }
}