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
        super(By.xpath("//div[contains(@class,'avatar-and-interests__avatar-box')]"), "Second Card");
    }
    private final ICheckBox uncheckedAll = AqualityServices.getElementFactory().getCheckBox(By.xpath("//input[@id='interest_unselectall']/following-sibling::span"), "Unchecked All Checkbox");
    private final IButton upload = AqualityServices.getElementFactory().getButton(By.xpath("//a[contains(@class,'avatar-and-interests__upload-button')]"), "Upload Button");
    private final IButton next = AqualityServices.getElementFactory().getButton(By.xpath("//button[contains(@class,'button--stroked')]"), "Next Button");
    private final int interestNumber = (int) new JsonSettingsFile("TestData.json").getValue("/interestedNumbers");
    private final int maxInterestNumber = (int) new JsonSettingsFile("TestData.json").getValue("/maxInterestNumber");
    private final String interest = new JsonSettingsFile("TestData.json").getValue("/interestSelectAll").toString();
    private static final String INTEREST_LOCATOR = "//label[contains(@for, 'interest')]";
    private static final String INTEREST_NAME_LOCATOR = "//span[contains(@class, 'checkbox small')]/following-sibling::span";

    public void uncheckedAllClick() {
        uncheckedAll.click();
    }

    public void nextClick() {
        next.click();
    }

    public void uploadImage() {
        upload.click();
        UploadUtil.imgUpload();
    }

    public void chooseRandomInterest() {
        ArrayList<Integer> indexes = new ArrayList<>();
        while (indexes.size() < interestNumber) {
            int randomIndex = RandomUtils.getRandomInt(1, maxInterestNumber);
            String interestName = AqualityServices.getElementFactory().getCheckBox(By.xpath(String.format("(%s)[%d]", INTEREST_NAME_LOCATOR, randomIndex)), "interestName").getText();
            if (!indexes.contains(randomIndex) && !interestName.equals(interest)) {
                indexes.add(randomIndex);
                AqualityServices.getElementFactory().getCheckBox(By.xpath(String.format("(%s)[%d]", INTEREST_LOCATOR, randomIndex)), "interest").click();
            }
        }
    }
}
