package mobiltesting;

import appium.BaseClass;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;


import java.net.MalformedURLException;

public class Appium15Scrolling extends BaseClass {

    @Test
    public void test() throws MalformedURLException, InterruptedException {
        AndroidDriver driver = getAndroidDriver();

        System.out.println("App intstalled...");
        //api demos butonuna tikla
        driver.findElementByXPath("//android.widget.TextView[@text='API Demos']").click();
        Thread.sleep(3000);
        //preference butonuna tikladik
        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        //preference dependencies butonuna bastik
        Thread.sleep(5000);

        //uiScrollable
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Switches\"))");

        driver.findElementByAndroidUIAutomator("UiSelector().className(\"android.widget.TextView\").text(\"Switches\")").click();

        //Appium'da driver.manage().window().getSize()yöntem,
        // Appium sunucusunun etkileşimde bulunduğu cihaz
        // veya öykünücüdeki geçerli pencerenin boyutunu (genişlik ve yükseklik)
        // almak için kullanılır. Döndürülen nesne,
        // org.openqa.selenium.Dimensioniki alan içeren widthve heighttam sayı olan türdedir.

        // Dimension dimension = driver.manage().window().getSize();
        // int start_x = (int) (dimension.width * 0.5); //baslangıc noktalarını belirttik
        // int start_y = (int) (dimension.height * 0 //parmagi koydugumuz yer
        // int end_x = (int) (dimension.width * 0.5);
        // int end_y = (int) (dimension.height * 0
        // TouchAction touchAction = new TouchAction(driver);
        // for (int i = 0; i < 3; i++) {
        //     Thread.sleep(3000);
        //     touchAction.press(PointOption.point(start_x,start_y))
        //             .moveTo(PointOption.point(end_x,end_y)).release().perform();
        // }

        //dokunma eylemleri gerçekleştirmek için kullanılır. io.appium.java_clientPaketin bir parçasıdır
        //Sağladığınız kod, TouchActionsınıfı kullanarak dokunma eylemlerini
        // birbirine zincirliyor ve ardından bunları gerçekleştiriyor.
        // Yöntem press(), ekranda x ve y koordinatlarıyla temsil edilen
        // belirli bir noktada bir basma hareketini simüle etmek için
        // kullanılır. Yöntem moveTo(), ekrandaki bir hareket hareketini
        // ekranda x ve y koordinatlarıyla temsil edilen başka bir
        // noktaya simüle etmek için kullanılır. Yöntem release(),
        // bir basın hareketinin serbest bırakılmasını simüle etmek
        // için kullanılır. Son olarak, perform()yöntem birlikte
        // zincirlenmiş tüm dokunma eylemlerini yürütmek için kullanılır.

        //Bu durumda dokunma eylemi, noktada (start_x, start_y)
        // bir basma hareketi ve hareketi noktaya (end_x, end_y)
        // taşıma ve ardından bırakmadır.
    }
}