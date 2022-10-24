package forms.game;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class HelpForm extends Form {
    protected HelpForm() {
        super(By.xpath("//div[contains(@class,'help-form')]"), "Help form");
    }

    private final IButton SEND_TO_BOTTOM = AqualityServices.getElementFactory().getButton(By.xpath("//button[contains(@class,'help-form__send-to-bottom')]"),"Send to bottom button");
    private static final ILabel HELP_CONTAINER = AqualityServices.getElementFactory().getLabel(By.xpath( "//div[contains(@class,'help-form')]"),"Help Container ");
    private final boolean CONTAINS_HIDDEN = HELP_CONTAINER.getAttribute("class").contains("hidden");
    public void clickSendToBottom(){
        SEND_TO_BOTTOM.click();
    }

    public boolean isHidden(){
         return AqualityServices.getConditionalWait().waitFor(() -> CONTAINS_HIDDEN);
    }
}
