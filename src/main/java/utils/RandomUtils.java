package utils;

import aquality.selenium.core.utilities.JsonSettingsFile;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public final class RandomUtils {

    private RandomUtils() {
    }

    private static final int LENGTH = (int) new JsonSettingsFile("TestData.json").getValue("/emailLength");
    private static final Random RANDOM = new Random();
    private static final StringBuilder STRING_BUILDER = new StringBuilder();
    private static final char TMP = (char) ('a' + RANDOM.nextInt('z' - 'a'));

    public static String getRandomEmailName() {
        STRING_BUILDER.append(String.valueOf(TMP).repeat(Math.max(0, LENGTH)));
        return STRING_BUILDER.toString();
    }

    public static String getRandomEmailDomain() {
        int domainLength = (int) new JsonSettingsFile("TestData.json").getValue("/domainLength");
        return RandomStringUtils.randomAlphanumeric(domainLength);
    }

    public static String getRandomPassword(String email) {
        STRING_BUILDER.append((int) (Math.random() * LENGTH));
        STRING_BUILDER.append((char) ('а' + RANDOM.nextInt('я' - 'а')));
        STRING_BUILDER.append(email.charAt((int) (Math.random() * email.length())));
        for (int i = 0; i < LENGTH; i++) {
            if (i == 0) {
                STRING_BUILDER.append(String.valueOf(TMP).toUpperCase());
            } else {
                STRING_BUILDER.append(TMP);
            }
        }
        return STRING_BUILDER.toString();
    }

    public static int getRandomInt(int from, int toIncl) {
        return (int) ((Math.random() * (toIncl - from + 1)) + from);
    }
}
