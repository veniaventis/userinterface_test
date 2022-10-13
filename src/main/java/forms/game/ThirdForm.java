package forms.game;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class ThirdForm extends Form {

    public ThirdForm() {
        super(By.xpath("//div[contains(@class,'page-indicator') and contains(text(),'3')]"), "Third Card Card");
    }
}