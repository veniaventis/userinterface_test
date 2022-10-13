package forms.game;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class HelpForm extends Form {

    protected HelpForm() {
        super(By.xpath("//div[@class='help-form']"), "Help form");
    }
    private final IButton sendToBottom = AqualityServices.getElementFactory().getButton(By.xpath("//button[contains(@class,'help-form__send-to-bottom')]"),"Send to bottom button");
    private final ILabel helpContainer  = AqualityServices.getElementFactory().getLabel(By.xpath("//div[contains(@class,'help-form ')]"),"Help Container ");
    public void clickSendToBottom(){
        sendToBottom.click();
    }

    public boolean isHidden(){
        return AqualityServices.getConditionalWait().waitFor(() ->helpContainer.getAttribute("class").equals("help-form is-hidden"));
    }

}
