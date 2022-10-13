package utils;

import aquality.selenium.core.utilities.JsonSettingsFile;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class UploadUtil {


    private final String getAvatarPath = new JsonSettingsFile("testconfig.json").getValue("/imagePath").toString();


    private static void copyPathToWindowsPopupMenu(String path) throws AWTException {

        StringSelection stringSelection = new StringSelection(System.getProperty("user.dir") + path);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

        Robot robot = new Robot();
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(100);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
    public void imgUpload() {
        try {
            copyPathToWindowsPopupMenu(this.getAvatarPath);
        } catch (AWTException e) {
            System.out.println("Image doesn't upload");
        }
    }
}
