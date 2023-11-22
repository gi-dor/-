package Java.exception.exception1;

public class NumberUtils {


    public static int toInt(String str, int defaultValue) {

        if (str == null) {
            return defaultValue;
        }

        if (str.isBlank()) {
            return defaultValue;
        }

        try {
            return Integer.parseInt(str);

        } catch (NumberFormatException ex) {
            return defaultValue;
        }
    }
}
