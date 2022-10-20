
import aquality.selenium.core.utilities.JsonSettingsFile;
import forms.game.RegistrationPage;
import forms.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.RandomUtils;

public class TestUserinterface extends BaseTest{
    private static final String getTimer = new JsonSettingsFile("testconfig.json").getValue("/timerStarts").toString();
    private static final WelcomePage welcomePage = new WelcomePage();
    private static final RegistrationPage registrationPage = new RegistrationPage();
    @Test
    public static void testFillProfileData(){
        Assert.assertTrue(welcomePage.state().isDisplayed(),"Welcome Page doesn't open");

        welcomePage.clickHereLink();
        Assert.assertTrue(registrationPage.state().isDisplayed(), "1 card hasn't been open");

        String email = RandomUtils.getRandomEmailName();
        String password = RandomUtils.getRandomPassword(email);
        String domain = RandomUtils.getRandomEmailDomain();

        registrationPage.getFirstCard().enterPassword(password);
        registrationPage.getFirstCard().enterEmailName(email);
        registrationPage.getFirstCard().enterDomainName(domain);
        registrationPage.getFirstCard().chooseDomainZone();
        registrationPage.getFirstCard().clickTermsCondition();
        registrationPage.getFirstCard().nextClick();
        Assert.assertTrue(registrationPage.getSecondCard().state().isDisplayed(), "Second card has not been loaded");

        registrationPage.getSecondCard().uncheckedAllClick();
        registrationPage.getSecondCard().chooseRandomInterest();
        registrationPage.getSecondCard().uploadImage();
        registrationPage.getSecondCard().nextClick();
        Assert.assertTrue(registrationPage.getThirdCard().state().isDisplayed(), "Third card hasn't been loaded ");
    }

    @Test
    public static void testHideHelpForm(){
        Assert.assertTrue(welcomePage.state().isDisplayed(),"Welcome page hasn't been loaded");

        welcomePage.clickHereLink();
        Assert.assertTrue(registrationPage.state().isDisplayed(), "Registration page hasn't been loaded");
        Assert.assertTrue(registrationPage.getHelpForm().state().isDisplayed(),"Help form hasn't been loaded");

        registrationPage.getHelpForm().clickSendToBottom();
        Assert.assertTrue(registrationPage.getHelpForm().isHidden(),"Help form doesn't hidden ");
    }

    @Test
    public static void testAcceptCookies(){
        Assert.assertTrue(welcomePage.state().isDisplayed(),"Welcome page hasn't been loaded");

        welcomePage.clickHereLink();
        Assert.assertTrue(registrationPage.state().isDisplayed(), "Registration page hasn't been loaded");
        Assert.assertTrue(registrationPage.getCookiesForm().state().waitForNotExist(),"Cookies form hasn't shown");

        registrationPage.getCookiesForm().acceptClick();
        Assert.assertTrue(registrationPage.getCookiesForm().isCookieClosed());
    }

    @Test
    public static void testTimerStarts(){
        Assert.assertTrue(welcomePage.state().isDisplayed(),"Welcome Page hasn't been loaded");

        welcomePage.clickHereLink();
        Assert.assertTrue(registrationPage.state().isDisplayed(),"Registration Page hasn't been loaded");

        Assert.assertEquals(registrationPage.getTimerText(), getTimer,"Timer doesn't start from 00:00" );
    }
}