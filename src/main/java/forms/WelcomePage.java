package forms;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class WelcomePage extends Form {

    public WelcomePage() {
        super(By.xpath("//button[contains(@class,'start__button')]"), "Welcome Page");
    }
}
