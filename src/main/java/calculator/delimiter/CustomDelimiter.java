package calculator.delimiter;

import java.util.regex.Pattern;

public final class CustomDelimiter {
    private static final String PREFIX = "//";
    private static final char REAL_NL = '\n';

    private CustomDelimiter() {}

    public static final class Resolution {
        public final String splitRegex;
        public final String body;
        public Resolution(String splitRegex, String body) {
            this.splitRegex = splitRegex;
            this.body = body;
        }
    }

    public static boolean isCustom(String input) {
        return input != null && input.startsWith(PREFIX);
    }

    public static Resolution resolve(String input) {
        int nl = input.indexOf(REAL_NL);
        if (nl < 0) {
            throw new IllegalArgumentException();
        }

        String delimiterPart = input.substring(PREFIX.length(), nl);

        if (delimiterPart.length() != 1) throw new IllegalArgumentException();

        char custom = delimiterPart.charAt(0);
        if (Character.isISOControl(custom)) throw new IllegalArgumentException();

        String body = input.substring(nl + 1);
        if (body.isEmpty()) throw new IllegalArgumentException();

        String combined = "(?:" + Delimiter.getBasicDelimiterRegex() + "|" +
                Pattern.quote(String.valueOf(custom)) + ")";
        return new Resolution(combined, body);
    }
}