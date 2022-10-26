package utils;

import aquality.selenium.core.logging.Logger;
import aquality.selenium.core.utilities.JsonSettingsFile;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class UploadUtil {
    private static final String AVATAR_PATH = new JsonSettingsFile("TestData.json").getValue("/imagePath").toString();
    private static final StringSelection STRING_SELECTION = new StringSelection(System.getProperty("user.dir") + AVATAR_PATH);

    private static void copyPathToWindowsPopupMenu() throws AWTException {
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(STRING_SELECTION, null);

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

    public static void imgUpload() {
        try {
            copyPathToWindowsPopupMenu();
        } catch (AWTException e) {
            Logger.getInstance().debug("Image doesn't upload");
        }
    }
}
