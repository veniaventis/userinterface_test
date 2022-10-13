package forms.game;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class RegistrationPage extends Form {


    public RegistrationPage() {
        super(By.xpath("//div[@class='login-form-with-pw-check']"),"Registration Page ");
    }
    private final FirstForm firstForm = new FirstForm();
    private final SecondForm secondForm = new SecondForm();
    private final ThirdForm thirdForm = new ThirdForm();
    private final HelpForm helpForm = new HelpForm();


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
}
