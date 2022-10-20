package forms.game;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.utilities.JsonSettingsFile;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import utils.RandomUtils;
import utils.UploadUtil;

import java.util.ArrayList;

public class AvatarForm extends Form {

    public AvatarForm() {
        super(By.xpath("//div[contains(@class,'page-indicator') and contains(text(),'2')]"), "Second Card");
    }

    private final ICheckBox uncheckedAll = AqualityServices.getElementFactory().getCheckBox(By.xpath("//input[@id='interest_unselectall']/following-sibling::span"),"Unchecked All Checkbox");
    private final IButton upload = AqualityServices.getElementFactory().getButton(By.xpath("//a[contains(@class,'avatar-and-interests__upload-button')]"),"Upload Button");
    private final IButton next = AqualityServices.getElementFactory().getButton(By.xpath("//button[@name='button' and contains(text(),'Next')]"),"Next Button");
    private final int getInterestNumber = (int) new JsonSettingsFile("testconfig.json").getValue("/interestedNumbers");
    private final int getMaxInterestNumber = (int) new JsonSettingsFile("testconfig.json").getValue("/maxInterestNumber");
    private final String getInterest = new JsonSettingsFile("testconfig.json").getValue("/interestSelectAll").toString();
    public void uncheckedAllClick(){uncheckedAll.click();}

    public void nextClick(){
        next.click();
    }
    public void uploadImage(){
        upload.click();
        UploadUtil.imgUpload();
    }

    public void chooseRandomInterest() {
        ArrayList<Integer> indexes = new ArrayList<>();
        String INTEREST_LOCATOR = "//label[contains(@for, 'interest')]";
        String INTEREST_NAME_LOCATOR = "//span[contains(@class, 'checkbox small')]/following-sibling::span";

        while (indexes.size() < getInterestNumber) {
            int randomIndex = RandomUtils.getRandomInt(1, getMaxInterestNumber);
            String interestName = AqualityServices.getElementFactory().getCheckBox(By.xpath(String.format("(%s)[%d]",INTEREST_NAME_LOCATOR,randomIndex)), "interestName").getText();
            if (!indexes.contains(randomIndex) && !interestName.equals(getInterest)) {
                indexes.add(randomIndex);
                AqualityServices.getElementFactory().getCheckBox(By.xpath(String.format("(%s)[%d]",INTEREST_LOCATOR,randomIndex)), "interest").click();
            }
        }
    }
}
