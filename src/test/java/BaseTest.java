import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import org.testng.annotations.BeforeMethod;


public class BaseTest {

    @BeforeMethod
    public void setUp(){
        Browser browser = AqualityServices.getBrowser();
        browser.maximize();
    }

    public void tearDown(){
        AqualityServices.getBrowser().quit();
    }
}
