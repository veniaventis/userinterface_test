package forms.game;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class FirstForm extends Form {
    protected FirstForm() {
        super(By.xpath("//div[contains(@class,'page-indicator') and contains(text(),'1')]"), "First Card");
    }

    private final ITextBox passwordField = AqualityServices.getElementFactory().getTextBox(By.xpath("//input[contains(@placeholder,'Password')]"),"Password Field");
    private final ITextBox emailField = AqualityServices.getElementFactory().getTextBox(By.xpath("//input[contains(@placeholder,'email')]"),"Email Field");
    private final ITextBox domainField = AqualityServices.getElementFactory().getTextBox(By.xpath("//input[contains(@placeholder,'Domain')]"),"Domain Field");
    private final ICheckBox termsCondition = AqualityServices.getElementFactory().getCheckBox(By.xpath("//span[@class='checkbox']"), "Terms & Conditions checkbox");

}
