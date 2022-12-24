package pages;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;


public class HepsiBuradaAppScreen {

    public HepsiBuradaAppScreen(){

        PageFactory.initElements(new AppiumFieldDecorator(Driver.getAppiumDriver()),this);
    }




}

/*
protected WebDriverWait wait;
public Decorator(AppiumDriver<MobileElement> driver) {
    this.driver = driver;
    wait = new WebDriverWait(driver, 5);
    JavascriptExecutor executor = (JavascriptExecutor)driver;
    PageFactory.initElements(new AppiumFieldDecorator(driver),this);
}
 */


/*
public class LoginPage extends Decorator {

public LoginPage() {
    super(driver);
}

@BeforeMethod
public void context() {
    driver.context("NATIVE_APP");
}


@AndroidFindBy(xpath = "//android.widget.Button[....']")
private MobileElement element;

public void welcome_header_is_visible() {
    wait.until(ExpectedConditions.visibilityOf(welcomeHeader));
}
 */


/*
 protected boolean switchToWebContext() {
        ArrayList<String> contexts = new ArrayList(driver.getContextHandles());
        for (String context : contexts) {
            System.out.println(context);
            if (context.contains("WEBVIEW")) {
                driver.context(context);
                return true;
            }
        }
        return false;
    }
ve kodla web'de gerekli olan ögeyle daha iyi gecis yapin:

public void Verify_visibility_of_welcome_header () {
    switchToWebContext();
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.visibilityOf(welcomeHeader));
    switchToNativeContext(); // write yourself :-)
}
 */