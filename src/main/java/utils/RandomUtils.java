package utils;

import aquality.selenium.core.utilities.JsonSettingsFile;
import java.util.Random;

public final class RandomUtils {

    private RandomUtils() {}

    public static String getRandomEmailName() {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        int emailLength = (int) new JsonSettingsFile("testconfig.json").getValue("/emailLength");
        for (int i = 0; i < emailLength; i++) {
            char tmp = (char) ('a' + random.nextInt('z' - 'a'));
            stringBuilder.append(tmp);
        }
        return stringBuilder.toString();
    }

    public static String getRandomEmailDomain() {
        String[] domains = new String[] {"gmail", "yahoo", "yandex", "mail"};
        return domains[(int) (Math.random() * domains.length)];
    }

    public static String getRandomPassword(String email) {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        int passwordLength = (int) new JsonSettingsFile("testconfig.json").getValue("/emailLength");

        stringBuilder.append((int) (Math.random() * passwordLength));
        stringBuilder.append((char) ('а' + random.nextInt('я' - 'а')));
        stringBuilder.append(email.charAt((int) (Math.random() * email.length())));

        for (int i = 0; i < passwordLength; i++) {
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
