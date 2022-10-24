package forms.game;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class PersonalDetailsForm extends Form {

    public PersonalDetailsForm() {
        super(By.xpath("//div[contains(@class,'page-indicator') and contains(text(),'3')]"), "Third Card Card");
    }
}