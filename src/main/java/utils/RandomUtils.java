package utils;

import aquality.selenium.core.utilities.JsonSettingsFile;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public final class RandomUtils {

    private RandomUtils() {}
    private static final int LENGTH = (int) new JsonSettingsFile("testconfig.json").getValue("/emailLength");
    private static final Random random = new Random();
    private static final StringBuilder stringBuilder = new StringBuilder();
    public static String getRandomEmailName() {
        for (int i = 0; i < LENGTH; i++) {
            char tmp = (char) ('a' + random.nextInt('z' - 'a'));
            stringBuilder.append(tmp);
        }
        return stringBuilder.toString();
    }

    public static String getRandomEmailDomain() {
        int getDomainLength = (int) new JsonSettingsFile("testconfig.json").getValue("/domainLength");
        return RandomStringUtils.randomAlphanumeric(getDomainLength);
    }

    public static String getRandomPassword(String email) {

        stringBuilder.append((int) (Math.random() * LENGTH));
        stringBuilder.append((char) ('а' + random.nextInt('я' - 'а')));
        stringBuilder.append(email.charAt((int) (Math.random() * email.length())));

        for (int i = 0; i < LENGTH; i++) {
            char tmp = (char) ('a' + random.nextInt('z' - 'a'));
            if (i == 0) {
                stringBuilder.append(String.valueOf(tmp).toUpperCase());
            } else {
                stringBuilder.append(tmp);
            }
        }
        return stringBuilder.toString();
    }

    public static int getRandomInt(int from, int toIncl) {
        return (int) ((Math.random() * (toIncl - from + 1)) + from);
    }
}
