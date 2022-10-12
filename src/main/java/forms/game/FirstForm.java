package forms.game;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.utilities.JsonSettingsFile;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class FirstForm extends Form {
    public FirstForm() {
        super(By.xpath("//div[contains(@class,'page-indicator') and contains(text(),'1')]"), "First Card");
    }

    private final String getDomainZone = new JsonSettingsFile("testconfig.json").getValue("/domainZone").toString();
    private final ITextBox passwordField = AqualityServices.getElementFactory().getTextBox(By.xpath("//input[contains(@placeholder,'Password')]"), "Password Field");
    private final ITextBox emailField = AqualityServices.getElementFactory().getTextBox(By.xpath("//input[contains(@placeholder,'email')]"), "Email Field");
    private final ITextBox domainField = AqualityServices.getElementFactory().getTextBox(By.xpath("//input[contains(@placeholder,'Domain')]"), "Domain Field");
    private final ICheckBox termsCondition = AqualityServices.getElementFactory().getCheckBox(By.xpath("//span[@class='checkbox']"), "Terms & Conditions checkbox");
    private final IButton domainZoneDropDown = AqualityServices.getElementFactory().getButton(By.xpath("//div[contains(@class,'dropdown__field')]"), "Domain Zone dropdown menu");
    private final IButton domainZone = AqualityServices.getElementFactory().getButton(By.xpath("//div[contains(text(),'"+ getDomainZone +"')]"), "Domain Zone");
    private final IButton next = AqualityServices.getElementFactory().getButton(By.xpath("//a[contains(@class,'button--secondary') and text()='Next']"),"Next Button");


    public void enterPassword(String password) {
        this.passwordField.clearAndType(password);
    }

    public void enterEmailName(String email){
        this.emailField.clearAndType(email);
    }

    public void enterDomainName(String domainName){
        this.domainField.clearAndType(domainName);
    }

    public void chooseDomainZone(){
        this.domainZoneDropDown.click();
        this.domainZone.click();
    }

    public void clickTermsCondition(){
        this.termsCondition.click();
    }

    public void nextClick(){
        this.next.click();
    }




}