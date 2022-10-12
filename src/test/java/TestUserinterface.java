import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.utilities.JsonSettingsFile;
import forms.WelcomePage;
import forms.game.FirstForm;
import forms.game.SecondForm;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Randomizer;

public class TestUserinterface extends BaseTest{

    private static final String getUrl = new JsonSettingsFile("settings.json").getValue("/url").toString();

    @Test
    public static void testCase1FillProfileData() throws InterruptedException {
        WelcomePage welcomePage = new WelcomePage();
        FirstForm firstForm = new FirstForm();
        SecondForm secondForm = new SecondForm();

        AqualityServices.getBrowser().goTo(getUrl);
        Assert.assertTrue(welcomePage.isDisplayed(),"Welcome Page doesn't open");

        welcomePage.clickHereLink();
        Assert.assertTrue(firstForm.isDisplayed(), "1 card hasn't been open");

        String email = Randomizer.getRandomEmailName();
        String password = Randomizer.getRandomPassword(email);
        String domain = Randomizer.getRandomEmailDomain();

        firstForm.enterPassword(password);
        firstForm.enterEmailName(email);
        firstForm.enterDomainName(domain);
        firstForm.chooseDomainZone();
        firstForm.clickTermsCondition();
        firstForm.nextClick();

        secondForm.uncheckedAllClick();
        secondForm.chooseRandomInterest();
        secondForm.uploadImage();
        secondForm.nextClick();


        Thread.sleep(2000);

    }
}