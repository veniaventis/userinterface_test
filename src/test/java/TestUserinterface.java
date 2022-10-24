
import aquality.selenium.core.utilities.JsonSettingsFile;
import forms.game.RegistrationPage;
import forms.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.RandomUtils;

public class TestUserinterface extends BaseTest{
    private static final String TIMER = new JsonSettingsFile("TestData.json").getValue("/timerStarts").toString();
    private static final WelcomePage WELCOME_PAGE = new WelcomePage();
    private static final RegistrationPage REGISTRATION_PAGE = new RegistrationPage();
    @Test
    public static void testFillProfileData(){
        Assert.assertTrue(WELCOME_PAGE.state().isDisplayed(),"Welcome Page doesn't open");

        WELCOME_PAGE.clickHereLink();
        Assert.assertTrue(REGISTRATION_PAGE.state().isDisplayed(), "1 card hasn't been open");

        REGISTRATION_PAGE.getFirstCard().enterPasswordAndEmail();
        REGISTRATION_PAGE.getFirstCard().enterDomainName();
        REGISTRATION_PAGE.getFirstCard().chooseDomainZone();
        REGISTRATION_PAGE.getFirstCard().clickTermsCondition();
        REGISTRATION_PAGE.getFirstCard().nextClick();
        Assert.assertTrue(REGISTRATION_PAGE.getSecondCard().state().isDisplayed(), "Second card has not been loaded");

        REGISTRATION_PAGE.getSecondCard().uncheckedAllClick();
        REGISTRATION_PAGE.getSecondCard().chooseRandomInterest();
        REGISTRATION_PAGE.getSecondCard().uploadImage();
        REGISTRATION_PAGE.getSecondCard().nextClick();
        Assert.assertTrue(REGISTRATION_PAGE.getThirdCard().state().isDisplayed(), "Third card hasn't been loaded ");
    }

    @Test
    public static void testHideHelpForm(){
        Assert.assertTrue(WELCOME_PAGE.state().isDisplayed(),"Welcome page hasn't been loaded");

        WELCOME_PAGE.clickHereLink();
        Assert.assertTrue(REGISTRATION_PAGE.state().isDisplayed(), "Registration page hasn't been loaded");
        Assert.assertTrue(REGISTRATION_PAGE.getHelpForm().state().isDisplayed(),"Help form hasn't been loaded");

        REGISTRATION_PAGE.getHelpForm().clickSendToBottom();
        Assert.assertTrue(REGISTRATION_PAGE.getHelpForm().isHidden(),"Help form doesn't hidden ");
    }

    @Test
    public static void testAcceptCookies(){
        Assert.assertTrue(WELCOME_PAGE.state().isDisplayed(),"Welcome page hasn't been loaded");

        WELCOME_PAGE.clickHereLink();
        Assert.assertTrue(REGISTRATION_PAGE.state().isDisplayed(), "Registration page hasn't been loaded");
        Assert.assertTrue(REGISTRATION_PAGE.getCookiesForm().state().waitForNotExist(),"Cookies form hasn't shown");

        REGISTRATION_PAGE.getCookiesForm().acceptClick();
        Assert.assertTrue(REGISTRATION_PAGE.getCookiesForm().isCookieClosed());
    }

    @Test
    public static void testTimerStarts(){
        Assert.assertTrue(WELCOME_PAGE.state().isDisplayed(),"Welcome Page hasn't been loaded");

        WELCOME_PAGE.clickHereLink();
        Assert.assertTrue(REGISTRATION_PAGE.state().isDisplayed(),"Registration Page hasn't been loaded");

        Assert.assertEquals(REGISTRATION_PAGE.getTimerText(), TIMER,"Timer doesn't start from 00:00" );
    }
}