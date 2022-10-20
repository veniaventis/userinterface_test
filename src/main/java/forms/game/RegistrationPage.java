package forms.game;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class RegistrationPage extends Form {
    public RegistrationPage() {
        super(By.xpath("//div[@class='login-form-with-pw-check']"),"Registration Page ");
    }
    private final ILabel timer = AqualityServices.getElementFactory().getLabel(By.xpath("//div[contains(@class,'timer')]"),"Timer");

    public RegistrationForm getFirstCard(){
        return new RegistrationForm();
    }
    public AvatarForm getSecondCard(){return new AvatarForm();}
    public ThirdForm getThirdCard(){
        return new ThirdForm();
    }
    public HelpForm getHelpForm(){
        return new HelpForm();
    }
    public CookiesForm getCookiesForm(){
        return new CookiesForm();
    }
    public String getTimerText(){
        return timer.getText();
    }
}
