import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.utilities.JsonSettingsFile;
import forms.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestUserinterface extends BaseTest{

    private static final String getUrl = new JsonSettingsFile("settings.json").getValue("/url").toString();

    @Test
    public static void testCase1FillProfileData(){
       WelcomePage welcomePage = new WelcomePage();

        AqualityServices.getBrowser().goTo(getUrl);
        Assert.assertTrue(welcomePage.isDisplayed(),"Welcome Page doesn't open");

        welcomePage.clickHereLink();

    }
}