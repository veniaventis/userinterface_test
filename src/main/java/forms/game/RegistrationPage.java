package forms.game;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class RegistrationPage extends Form {

    private final ILabel timer = AqualityServices.getElementFactory().getLabel(By.xpath("//div[contains(@class,'timer')]"),"Timer");
    public RegistrationPage() {
        super(By.xpath("//div[@class='login-form-with-pw-check']"),"Registration Page ");
    }
    private final FirstForm firstForm = new FirstForm();
    private final SecondForm secondForm = new SecondForm();
    private final ThirdForm thirdForm = new ThirdForm();
    private final HelpForm helpForm = new HelpForm();
    private final CookiesForm cookiesForm = new CookiesForm();


    public FirstForm getFirstCard(){
        return firstForm;
    }

    public SecondForm getSecondCard(){
        return secondForm;
    }

    public ThirdForm getThirdCard(){
        return thirdForm;
    }
    public HelpForm getHelpForm(){
        return helpForm;
    }
    public CookiesForm getCookiesForm(){
        return cookiesForm;
    }

    public String getTimerText(){
        return timer.getText();
    }
}
