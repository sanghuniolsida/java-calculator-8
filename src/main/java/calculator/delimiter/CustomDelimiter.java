package calculator.delimiter;

import java.util.regex.Pattern;

public final class CustomDelimiter {
    private static final String PREFIX = "//";

    private CustomDelimiter() {}

    public static final class Resolution {
        public final String delimiterPart;
        public final String body;

        public Resolution(String delimiterPart, String body) {
            this.delimiterPart = delimiterPart;
            this.body = body;
        }

        public String combinedRegex() {
            return "(?:" + Delimiter.getBasicDelimiterRegex() + "|" + Pattern.quote(delimiterPart) + ")";
        }
    }

    public static boolean isCustom(String input) {
        return input != null && input.startsWith(PREFIX);
    }

    public static Resolution parse(String input) {
        int nl = input.indexOf('\n');
        if (nl < 0) throw new IllegalArgumentException();

        String delimPart = input.substring(PREFIX.length(), nl);
        if (delimPart.length() != 1) throw new IllegalArgumentException();
        char custom = delimPart.charAt(0);
        if (Character.isISOControl(custom)) throw new IllegalArgumentException();

        String body = input.substring(nl + 1);
        if (body.isEmpty()) throw new IllegalArgumentException();

        return new Resolution(delimPart, body);
    }
}