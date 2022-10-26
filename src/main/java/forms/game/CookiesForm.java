package forms.game;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class CookiesForm extends Form {
    protected CookiesForm() {
        super(By.xpath("//div[@class='cookies']"), "Cookies Form");
    }
    private final IButton acceptCookie = AqualityServices.getElementFactory().getButton(By.xpath("//button[contains(@class,'button--transparent')]"),"Accept button");
    public void acceptClick(){
        acceptCookie.click();
    }
    public boolean isCookieClosed(){
        return acceptCookie.state().waitForNotExist();
    }
}
