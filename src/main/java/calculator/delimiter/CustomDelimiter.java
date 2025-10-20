package calculator.delimiter;

import java.util.regex.Pattern;

public final class CustomDelimiter {
    private static final String PREFIX = "//";
    private static final char REAL_NL = '\n';

    private CustomDelimiter() {}

    public static final class Resolution {
        public final String delimiterPart;
        public final String body;

        public Resolution(String delimiterPart, String body) {
            this.delimiterPart = delimiterPart;
            this.body = body;
        }

        /** 정규식 결합용 메서드 */
        public String combinedRegex() {
            return "(?:" + Delimiter.getBasicDelimiterRegex() + "|" + Pattern.quote(delimiterPart) + ")";
        }
    }

    public static boolean isCustom(String input) {
        return input != null && input.startsWith(PREFIX);
    }

    public static Resolution parse(String input) {
        int nl = input.indexOf(REAL_NL);
        if (nl < 0) {
            return new Resolution("", input); // 개행 없으면 일단 전체를 body로 반환
        }

        String delimiterPart = input.substring(PREFIX.length(), nl);
        String body = input.substring(nl + 1);
        return new Resolution(delimiterPart, body);
    }
}