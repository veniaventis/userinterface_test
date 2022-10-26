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

    private final String domainZoneFromDate = new JsonSettingsFile("TestData.json").getValue("/domainZone").toString();
    private final ITextBox passwordField = AqualityServices.getElementFactory().getTextBox(By.xpath("//input[contains(@placeholder,'Password')]"), "Password Field");
    private final ITextBox emailField = AqualityServices.getElementFactory().getTextBox(By.xpath("//input[contains(@placeholder,'email')]"), "Email Field");
    private final ITextBox domainField = AqualityServices.getElementFactory().getTextBox(By.xpath("//input[contains(@placeholder,'Domain')]"), "Domain Field");
    private final ICheckBox termsCondition = AqualityServices.getElementFactory().getCheckBox(By.xpath("//span[@class='checkbox']"), "Terms & Conditions checkbox");
    private final IButton domainZoneDropdownMenu = AqualityServices.getElementFactory().getButton(By.xpath("//div[contains(@class,'dropdown__field')]"), "Domain Zone dropdown menu");
    private final IButton domainZone = AqualityServices.getElementFactory().getButton(By.xpath(String.format("//div[contains(text(),'%s')]", domainZoneFromDate)), "Domain Zone");
    private final IButton next = AqualityServices.getElementFactory().getButton(By.xpath("//a[@class='button--secondary']"),"Next Button");


    public void enterPasswordAndEmail() {
        String email = RandomUtils.getRandomEmailName();
        passwordField.clearAndType(RandomUtils.getRandomPassword(email));
        emailField.clearAndType(email);
    }
    public void enterDomainName(){
        domainField.clearAndType(RandomUtils.getRandomEmailDomain());
    }
    public void chooseDomainZone(){
        domainZoneDropdownMenu.click();
        domainZone.click();
    }
    public void clickTermsCondition(){
        termsCondition.click();}
    public void nextClick(){
        next.click();}
}