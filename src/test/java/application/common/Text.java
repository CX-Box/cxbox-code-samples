package application.common;

/**
 * Error text. Transferred to the constructor for convenience
 */
public class Text {

    public static String textOnlyLetters(String key) {
        return ("The field '" + key + "' can contain only letters.");
    }

    public static String textOnly(String value) {
        return ("The field can contain only " + value);
    }

    public static String textOnlyWithTitle(String title, String value) {
        return ("The field " + title + " can contain only " + value);
    }

    public static String textOnlyTrue(String field) {
        return ("The field '" + field + "' can contain only 'True");
    }

    public static String textInvalidNumber() {
        return ("The field cannot be less than 100 000.");
    }

    public static String textInvalidMoney(String key) {
        return ("The field '" + key + "' cannot be less than 100 000.00");
    }

    public static String textInvalidPercent(String value) {
        return ("The field cannot be less than " + value);
    }


    public static String textMoreThatCurrentDate(String key) {
        return ("The field '" + key + "' cannot be less than the current date");
    }

    public static String textRadioContains(String value) {
        return ("The field can contain only '" + value + "'");
    }

}
