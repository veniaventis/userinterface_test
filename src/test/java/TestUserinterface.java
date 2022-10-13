import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.utilities.JsonSettingsFile;
import forms.game.RegistrationPage;
import forms.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Randomizer;

public class TestUserinterface extends BaseTest{

    private static final String getUrl = new JsonSettingsFile("settings.json").getValue("/url").toString();
    private static WelcomePage welcomePage;

    @Test
    public static void testCase1FillProfileData(){
         welcomePage = new WelcomePage();
         RegistrationPage registrationPage = new RegistrationPage();


        AqualityServices.getBrowser().goTo(getUrl);
        Assert.assertTrue(welcomePage.isDisplayed(),"Welcome Page doesn't open");

        welcomePage.clickHereLink();
        Assert.assertTrue(registrationPage.isDisplayed(), "1 card hasn't been open");

        String email = Randomizer.getRandomEmailName();
        String password = Randomizer.getRandomPassword(email);
        String domain = Randomizer.getRandomEmailDomain();

        registrationPage.getFirstCard().enterPassword(password);
        registrationPage.getFirstCard().enterEmailName(email);
        registrationPage.getFirstCard().enterDomainName(domain);
        registrationPage.getFirstCard().chooseDomainZone();
        registrationPage.getFirstCard().clickTermsCondition();
        registrationPage.getFirstCard().nextClick();
        Assert.assertTrue(registrationPage.getSecondCard().isDisplayed(), "Second card has not been loaded");

        registrationPage.getSecondCard().uncheckedAllClick();
        registrationPage.getSecondCard().chooseRandomInterest();
        registrationPage.getSecondCard().uploadImage();
        registrationPage.getSecondCard().nextClick();
        Assert.assertTrue(registrationPage.getThirdCard().isDisplayed(), "Third card hasn't been loaded ");
    }

    @Test
    public static void testCase2HideHelpForm(){
        welcomePage = new WelcomePage();
        RegistrationPage registrationPage = new RegistrationPage();

        AqualityServices.getBrowser().goTo(getUrl);
        Assert.assertTrue(welcomePage.isDisplayed(),"Welcome page hasn't been loaded");

        welcomePage.clickHereLink();
        Assert.assertTrue(registrationPage.isDisplayed(), "Registration page hasn't been loaded");

        registrationPage.getHelpForm().clickSendToBottom();
        Assert.assertTrue(registrationPage.getHelpForm().isHidden(),"Help form doesn't hiden ");





    }
}