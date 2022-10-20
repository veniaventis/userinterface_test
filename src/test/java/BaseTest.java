import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import aquality.selenium.core.utilities.JsonSettingsFile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {

    @BeforeMethod
    public void setUp(){
        String getUrl = new JsonSettingsFile("settings.json").getValue("/url").toString();
        Browser browser = AqualityServices.getBrowser();
        browser.maximize();
        browser.goTo(getUrl);
    }
    @AfterMethod
    public void tearDown(){
        AqualityServices.getBrowser().quit();
    }
}
