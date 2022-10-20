package forms;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class WelcomePage extends Form {
    public WelcomePage() {
        super(By.xpath("//button[contains(@class,'start__button')]"), "Welcome Page");
    }

    private final ILink hereLink =AqualityServices.getElementFactory().getLink(By.xpath("//a[contains(@class,'start__link')]"), "Link here");
    public void clickHereLink(){
        hereLink.clickAndWait();
    }
}

