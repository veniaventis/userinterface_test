package forms.game;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.utilities.JsonSettingsFile;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import utils.Randomizer;

import java.util.ArrayList;

public class SecondForm extends Form {

    public SecondForm() {
        super(By.xpath("//div[contains(@class,'page-indicator') and contains(text(),'2')]"), "Second Card");
    }

    private final ICheckBox uncheckedAll = AqualityServices.getElementFactory().getCheckBox(By.xpath("//input[@id='interest_unselectall']/following-sibling::span"),"Unchecked All Checkbox");
    private final IButton upload = AqualityServices.getElementFactory().getButton(By.xpath("//a[contains(@class,'avatar-and-interests__upload-button')]"),"Upload Button");
    private final IButton next = AqualityServices.getElementFactory().getButton(By.xpath("//button[@name='button' and contains(text(),'Next')]"),"Next Button");
    private final String interestsLoc = "//label[contains(@for, 'interest')]";
    private final String interestsNamesLoc = "//span[contains(@class, 'checkbox small')]/following-sibling::span";
    private final String getAvatarPath = new JsonSettingsFile("testconfig.json").getValue("/imagePath").toString();
    private final String getAvatarName = new JsonSettingsFile("testconfig.json").getValue("/imageName").toString();

    private final int getInterestNumber = (int) new JsonSettingsFile("testconfig.json").getValue("/interestedNumbers");

    public void uncheckedAllClick(){
        this.uncheckedAll.click();
    }

    public void nextClick(){
        this.next.click();
    }
    public void uploadImage(){
        this.upload.sendKeys(getAvatarPath + getAvatarName);

    }

    public void chooseRandomInterest() {
        ArrayList<Integer> indexes = new ArrayList<>();
        while (indexes.size() < getInterestNumber) {
            int randomIndex = Randomizer.getRandomInt(1, 20);
            String interestName = AqualityServices.getElementFactory().getCheckBox(By.xpath("(" + interestsNamesLoc + ")[" + randomIndex + "]"), "interestName").getText();
            if (!indexes.contains(randomIndex) && !interestName.equals("Select all")) {
                indexes.add(randomIndex);
                AqualityServices.getElementFactory().getCheckBox(By.xpath("(" + interestsLoc + ")[" + randomIndex + "]"), "interest").click();
            }
        }
    }

}
