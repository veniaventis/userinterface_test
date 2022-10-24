package forms.game;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.utilities.JsonSettingsFile;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import utils.RandomUtils;

public class RegistrationForm extends Form {
    public RegistrationForm() {
        super(By.xpath("//div[@class='login-form']"), "First Card");
    }

    private final String DOMAIN_ZONE_FROM_DATA = new JsonSettingsFile("TestData.json").getValue("/domainZone").toString();
    private final ITextBox PASSWORD_FIELD = AqualityServices.getElementFactory().getTextBox(By.xpath("//input[contains(@placeholder,'Password')]"), "Password Field");
    private final ITextBox EMAIL_FIELD = AqualityServices.getElementFactory().getTextBox(By.xpath("//input[contains(@placeholder,'email')]"), "Email Field");
    private final ITextBox DOMAIN_FIELD = AqualityServices.getElementFactory().getTextBox(By.xpath("//input[contains(@placeholder,'Domain')]"), "Domain Field");
    private final ICheckBox TERMS_CONDITION = AqualityServices.getElementFactory().getCheckBox(By.xpath("//span[@class='checkbox']"), "Terms & Conditions checkbox");
    private final IButton DOMAIN_ZONE_DROPDOWN = AqualityServices.getElementFactory().getButton(By.xpath("//div[contains(@class,'dropdown__field')]"), "Domain Zone dropdown menu");
    private final IButton DOMAIN_ZONE = AqualityServices.getElementFactory().getButton(By.xpath(String.format("//div[contains(text(),'%s')]", DOMAIN_ZONE_FROM_DATA)), "Domain Zone");
    private final IButton NEXT = AqualityServices.getElementFactory().getButton(By.xpath("//a[@class='button--secondary']"),"Next Button");


    public void enterPasswordAndEmail() {
        String email = RandomUtils.getRandomEmailName();
        PASSWORD_FIELD.clearAndType(RandomUtils.getRandomPassword(email));
        EMAIL_FIELD.clearAndType(email);
    }
    public void enterDomainName(){
        DOMAIN_FIELD.clearAndType(RandomUtils.getRandomEmailDomain());
    }
    public void chooseDomainZone(){
        DOMAIN_ZONE_DROPDOWN.click();
        DOMAIN_ZONE.click();
    }
    public void clickTermsCondition(){
        TERMS_CONDITION.click();}
    public void nextClick(){
        NEXT.click();}
}