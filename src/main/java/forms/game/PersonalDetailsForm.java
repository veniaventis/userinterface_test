package forms.game;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class PersonalDetailsForm extends Form {

    public PersonalDetailsForm() {
        super(By.xpath("//div[@class='personal-details']"), "Third Card Card");
    }
}